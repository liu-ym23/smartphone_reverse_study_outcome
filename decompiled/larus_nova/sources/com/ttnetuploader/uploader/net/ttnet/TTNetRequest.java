package com.ttnetuploader.uploader.net.ttnet;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.http.RequestContext;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.api.ULLog;
import com.ttnetuploader.uploader.api.ULMultipartPart;
import com.ttnetuploader.uploader.net.INetRequest;
import com.ttnetuploader.uploader.net.INetResponse;
import com.ttnetuploader.uploader.net.NetResponse;
import com.ttnetuploader.uploader.slice_task.SliceConfig;
import com.ttnetuploader.uploader.utils.CommonTools;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.k;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class TTNetRequest implements INetRequest {
    private volatile Call<TypedInput> mCall;
    private volatile Call<String> mJsonCall;

    public static class ProgressRequestBody extends RequestBody {
        private static final int BUFF_SIZE_MAX = 8192;
        private static final long PROGRESS_REPORT_INTERVAL = 1000;
        private final File mFile;
        private long mLastProgressTime;
        private long mLastUploadedLen;
        private final MediaType mMediaType;
        private final SliceConfig mSliceConfig;

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.mFile.length();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.mMediaType;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink r210) throws IOException {
            long r110 = contentLength();
            Source r111 = Okio.source(this.mFile);
            Buffer r100 = new Buffer();     // Catch: Throwable -> L20
            long r101 = 0;
        L4:
            long r102 = r111.read(r100, PlaybackStateCompat.ACTION_PLAY_FROM_URI);     // Catch: Throwable -> L20
            if (r102 == (-1)) goto L18;
            r210.write(r100, r102);     // Catch: Throwable -> L20
            long r103 = r101 + r102;     // Catch: Throwable -> L20
            if (this.mSliceConfig.getParam() != null) goto L9;
        L16:
            long r112 = r103;
        L17:
            r101 = r112;
            r110 = r110;
            goto L4
        L9:
            if (this.mSliceConfig.getParam().getCallback() == null) goto L16;
            if ((System.currentTimeMillis() - this.mLastProgressTime) < 1000) goto L13;
        L14:
            this.mLastProgressTime = System.currentTimeMillis();     // Catch: Throwable -> L20
            long r104 = r110;
            r112 = r103;
            this.mSliceConfig.getParam().getCallback().onProgress(this.mSliceConfig.getParam().getUploadId(), r103, r104, r103 - this.mLastUploadedLen);     // Catch: Throwable -> L20
            this.mLastUploadedLen = r112;     // Catch: Throwable -> L20
            goto L17
        L13:
            if (r103 < r110) goto L16;
        L18:
            r111.close();
            return;
        L20:
            th = move-exception;
            r111.close();
            throw th;
        }

        public ProgressRequestBody(MediaType r100, File r101, SliceConfig r102) {
            this.mLastProgressTime = 0;
            this.mMediaType = r100;
            this.mFile = r101;
            this.mSliceConfig = r102;
            this.mLastUploadedLen = 0;
        }
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public void suspend() {
        if (this.mCall == null) goto L6;
        this.mCall.cancel();
    L6:
        if (this.mJsonCall == null) goto L9;
        this.mJsonCall.cancel();
        return;
    }

    public TTNetRequest() {
        this.mCall = null;
        this.mJsonCall = null;
    }

    public static <T> String handleStringResponse(SsResponse<T> r100) throws IOException {
        return CommonTools.getNonnullStringValue(r100.body().toString());
    }

    public static <T> ByteArrayOutputStream handleTypeInputResponse(SsResponse<T> r100) throws IOException {
        InputStream r101 = null;
    L14:
        th = move-exception;
        if (0 == 0) goto L17;
        r101.close();
    L17:
        throw th;
    L4:
        if (r100.isSuccessful() == false) goto L13;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        byte[] r103 = new byte[4096];     // Catch: Throwable -> L14
        InputStream r104 = ((TypedInput) r100.body()).in();     // Catch: Throwable -> L14
    L6:
        int r105 = r104.read(r103, 0, 4096);     // Catch: Throwable -> L14
        if (r105 <= 0) goto L9;
        r102.write(r103, 0, r105);     // Catch: Throwable -> L14
    L9:
        if (r105 > 0) goto L6;
        r104.close();
        return r102;
    L13:
        throw new IOException("Unexpected code " + r100);     // Catch: Throwable -> L14
    }

    public static Map<String, String> listToMap(List<Header> r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<Header> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        Header r103 = r102.next();
        if (r103.getName() == null) goto L7;
        if (r103.getValue() == null) goto L7;
        if (ULLog.debug() == false) goto L15;
        ULLog.globalDebug("TTNetRequest", "listToMap", "[response-header:" + r103.getName() + ContainerUtils.KEY_VALUE_DELIMITER + r103.getValue() + "]");
    L15:
        r101.put(r103.getName(), r103.getValue());
        goto L7
    L16:
        return r101;
    }

    public static List<Header> mapToHeadersList(Map<String, String> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, String> r103 = r102.next();
        if (r103.getKey() == null) goto L4;
        if (r103.getValue() == null) goto L4;
        if (ULLog.debug() == false) goto L12;
        ULLog.globalDebug("TTNetRequest", "mapToHeadersList", "[request-header:" + r103.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + r103.getValue() + "]");
    L12:
        r101.add(new Header(r103.getKey(), r103.getValue()));
        goto L4
    L13:
        return r101;
    }

    private static RequestContext getRequestContext(Parameters r100, int r101) {
        RequestContext r102 = new RequestContext();
        if (r100 != null) goto L5;
        return r102;
    L5:
        r102.byPassProxy = r100.isNoProxy();
        if (r100.getProtocol() != 1) goto L9;
        if (r101 <= 0) goto L9;
        long r103 = r101;
        r102.timeout_connect = r103;
        r102.timeout_read = r103;
        r102.timeout_write = r103;
        r102.protect_timeout = r103;
    L9:
        return r102;
    }

    public static <T> NetResponse sendRequestAndHandleResponse(Call<T> r100, SliceConfig r101, Class<T> r110) throws Exception {
        if (ULLog.debug() == false) goto L27;
        ULLog.globalDebug("TTNetRequest", "sendRequestAndHandleResponse", "enter sendRequestAndHandleResponse,uploadId=" + r101.getParam().getUploadId() + ",url=" + r101.getParam().getUrl() + ",start=" + r101.getStart() + ",end=" + r101.getEnd() + ",sliceType=" + r101.getSliceType());
    L27:
        SsResponse<T> r102 = r100.execute();     // Catch: Throwable -> L15
        if (r110 != TypedInput.class) goto L9;
        String r111 = handleTypeInputResponse(r102).toString();     // Catch: Throwable -> L15
    L13:
        r100.cancel();
        return new NetResponse(r102.code(), r101, listToMap(r102.headers()), CommonTools.getJsonFromString(r111), "");
    L9:
        if (r110 != String.class) goto L12;
        r111 = handleStringResponse(r102);     // Catch: Throwable -> L15
        goto L13
    L12:
        r111 = "";
    L15:
        th = move-exception;
    L21:
        th = move-exception;
        if (r100 == null) goto L24;
        r100.cancel();
    L24:
        throw th;
    L17:
        if (ULLog.debug() == false) goto L20;
        ULLog.globalDebug("TTNetRequest", "sendRequestAndHandleResponse", "exception info=" + th + ",stackTrace=" + Arrays.toString(th.getStackTrace()));     // Catch: Throwable -> L21
    L20:
        throw new Exception(th.toString());     // Catch: Throwable -> L21
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public INetResponse httpGetRequest(String r100, SliceConfig r101, Map<String, String> r102, int r103) throws Exception {
        RequestContext r104 = getRequestContext(r101.getParam(), r103);
        this.mCall = TTNetService.getService(r100).getCall(r100, mapToHeadersList(r102), false, r104);
        return sendRequestAndHandleResponse(this.mCall, r101, TypedInput.class);
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public INetResponse httpPostDataRequest(String r100, final SliceConfig r110, Map<String, String> r111, final InputStream r112) throws Exception {
        RequestContext r101 = getRequestContext(r110.getParam(), 0);
        TypedOutput r102 = new AnonymousClass1(this, r110, r112);
        this.mCall = TTNetService.getService(r100).uploadFile(r100, r102, mapToHeadersList(r111), false, r101);
        return sendRequestAndHandleResponse(this.mCall, r110, TypedInput.class);
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public INetResponse httpPostMultipartRequest(String r110, SliceConfig r111, Map<String, String> r112, Map<String, ULMultipartPart> r113) throws Exception {
        RequestContext r100 = getRequestContext(r111.getParam(), 0);
        k.a r101 = new k.a();
        r101.e(k.f523924f);
        if (r113 == null) goto L35;
        Iterator<Map.Entry<String, ULMultipartPart>> r114 = r113.entrySet().iterator();
    L6:
        if (r114.hasNext() == false) goto L35;
        Map.Entry<String, ULMultipartPart> r102 = r114.next();
        if (r102.getKey() == null) goto L6;
        if (r102.getValue() == null) goto L6;
        ULMultipartPart r103 = r102.getValue();
        if (r103.stringContent != null) goto L13;
        if (r103.filePath == null) goto L6;
        String r104 = r103.contentType;
        if (r104 != null) goto L24;
        r104 = "application/octet-stream";
    L24:
        MediaType r105 = MediaType.parse(r104);
        if (r103.filePath.startsWith("file:") == false) goto L28;
        PolarisFileWrapper r106 = new PolarisFileWrapper(URI.create(r103.filePath));     // Catch: Exception -> L30
    L34:
        r101.b(r102.getKey(), r103.fileName, new ProgressRequestBody(r105, r106, r111));
        goto L6
    L28:
        r106 = new PolarisFileWrapper(r103.filePath);     // Catch: Exception -> L30
    L30:
        Uri r107 = UriProtector.parse(r103.filePath);
        if ("file".equalsIgnoreCase(r107.getScheme()) == false) goto L33;
        r106 = new PolarisFileWrapper(r107.getPath());
        goto L34
    L33:
        r106 = new PolarisFileWrapper(r103.filePath);
        goto L34
    L13:
        String r108 = r103.contentType;
        if (r108 != null) goto L17;
        r108 = "text/plain";
    L17:
        r101.c(k.b.a(Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + r102.getKey() + "\""}), RequestBody.create(MediaType.parse(r108), r103.stringContent)));
    L35:
        this.mJsonCall = TTNetService.getService(r110).uploadMultipart(r110, mapToHeadersList(r112), false, r101.d(), r100);
        return sendRequestAndHandleResponse(this.mJsonCall, r111, String.class);
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public INetResponse httpPutDataRequest(String r100, final SliceConfig r101, Map<String, String> r102, final InputStream r110) throws Exception {
        TypedOutput r103 = new AnonymousClass2(this, r101, r110);
        RequestContext r104 = getRequestContext(r101.getParam(), 0);
        r104.force_use_okhttp = true;
        this.mJsonCall = TTNetService.getService(r100).putCall(r100, mapToHeadersList(r102), false, r103, r104);
        return sendRequestAndHandleResponse(this.mJsonCall, r101, String.class);
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public INetResponse httpPostRequest(String r100, SliceConfig r101, Map<String, String> r110, String r111, int r112) throws Exception {
        RequestContext r102 = getRequestContext(r101.getParam(), r112);
        this.mJsonCall = TTNetService.getService(r100).postJsonCall(r100, mapToHeadersList(r110), false, RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r111), r102);
        SsResponse<String> r103 = this.mJsonCall.execute();
        if (r103.isSuccessful() == false) goto L7;
        return new NetResponse(r103.code(), r101, listToMap(r103.headers()), new JSONObject(r103.body().toString()), "");
    L7:
        throw new IOException("Unexpected code " + r103);
    }
}
