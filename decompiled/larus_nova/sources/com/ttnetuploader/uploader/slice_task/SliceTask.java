package com.ttnetuploader.uploader.slice_task;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.api.ULLog;
import com.ttnetuploader.uploader.api.ULMultipartPart;
import com.ttnetuploader.uploader.api.a;
import com.ttnetuploader.uploader.net.INetRequest;
import com.ttnetuploader.uploader.net.INetResponse;
import com.ttnetuploader.uploader.net.RequestFactory;
import com.ttnetuploader.uploader.request_protocol.UploaderRequest;
import com.ttnetuploader.uploader.response_protocol.ServerResponseBase;
import com.ttnetuploader.uploader.utils.CommonTools;
import com.ttnetuploader.uploader.utils.UploadFileUtils;
import com.ttnetuploader.uploader.utils.UploaderFileStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class SliceTask {
    private static final String TAG = "SliceTask";
    private Context mContext;
    private volatile INetRequest mDataRequest;
    private volatile long mLastTime;
    private volatile long mLastUploadedLen;
    private Parameters mParam;
    private volatile INetRequest mQueryRequest;
    private SliceConfig mSliceConfig;
    private ISliceOnProgress mSliceOnProgress;
    private long mSliceTaskId;
    private final List<File> mTempFiles;

    public void suspend() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mQueryRequest == null) goto L7;
        this.mQueryRequest.suspend();     // Catch: Throwable -> L11
    L7:
        if (this.mDataRequest == null) goto L9;
        this.mDataRequest.suspend();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    private Map<String, ULMultipartPart> normalizeMultipartBody() throws Exception {
        HashMap r100 = new HashMap();
        Map<String, ULMultipartPart> r101 = this.mParam.getMultipartBody();
        if (r101 != null) goto L5;
    L51:
        return r100;
    L5:
        if (r101.isEmpty() == true) goto L51;
        ContentResolver r102 = this.mContext.getContentResolver();
        if (this.mContext.getExternalCacheDir() == null) goto L10;
        File r103 = this.mContext.getExternalCacheDir();
    L11:
        Iterator<Map.Entry<String, ULMultipartPart>> r104 = r101.entrySet().iterator();
    L13:
        if (r104.hasNext() == false) goto L51;
        Map.Entry<String, ULMultipartPart> r105 = r104.next();
        String r106 = r105.getKey();
        ULMultipartPart r107 = r105.getValue();
        String r108 = r107.stringContent;
        if (r108 != null) goto L16;
        String r109 = r107.filePath;
        if (r109 == null) goto L13;
        String r110 = r107.fileName;
        if (r110 != null) goto L24;
        r110 = String.valueOf(System.currentTimeMillis());
    L24:
        if (r109.startsWith("content://") == true) goto L25;
        if (r109.startsWith("file:") == true) goto L49;
        r100.put(r106, new ULMultipartPart(r107.contentType, r109, r110));
        goto L13
    L49:
        r100.put(r106, new ULMultipartPart(r107.contentType, new PolarisFileWrapper(UriProtector.parse(r109).getPath()).getAbsolutePath(), r110));
        goto L13
    L25:
        Uri r111 = UriProtector.parse(r109);
        PolarisFileWrapper r112 = new PolarisFileWrapper(r103, r110);
        InputStream r113 = null;
        InputStream r114 = ContentResolverWrapper.openInputStream(r102, r111);     // Catch: Throwable -> L40
        PolarisFileOutputStreamWrapper r115 = new PolarisFileOutputStreamWrapper(r112);     // Catch: Throwable -> L37
        byte[] r116 = new byte[8192];     // Catch: Throwable -> L35
    L30:
        int r117 = r114.read(r116);     // Catch: Throwable -> L35
        if (r117 == (-1)) goto L33;
        r115.write(r116, 0, r117);     // Catch: Throwable -> L35
        goto L30
    L33:
        r115.flush();     // Catch: Throwable -> L35
        r114.close();
        r115.close();
        r100.put(r106, new ULMultipartPart(r107.contentType, r112.getAbsolutePath(), r110));
        this.mTempFiles.add(r112);
    L35:
        th = th;
    L39:
        r113 = r114;
    L42:
        if (r113 == null) goto L44;
        r113.close();
    L44:
        if (r115 == null) goto L46;
        r115.close();
    L46:
        throw th;
    L37:
        th = th;
        r115 = null;
    L40:
        th = th;
        r115 = null;
        goto L42
    L16:
        r100.put(r106, new ULMultipartPart(r107.contentType, r108));
        goto L13
    L10:
        r103 = this.mContext.getCacheDir();
        goto L11
    }

    public ServerResponseBase startNormal() throws Exception {
        this.mDataRequest = RequestFactory.getRequest(this.mParam.getNetLibType(), this.mContext);
        if (this.mParam.getMultipartBody() == null) goto L19;
        if (this.mParam.getMultipartBody().isEmpty() == true) goto L19;
        Map<String, ULMultipartPart> r100 = normalizeMultipartBody();
        Iterator<Map.Entry<String, ULMultipartPart>> r101 = r100.entrySet().iterator();
        long r102 = 0;
    L8:
        if (r101.hasNext() == false) goto L15;
        ULMultipartPart r103 = r101.next().getValue();
        if (r103.filePath == null) goto L8;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103.filePath);
        if (r104.exists() == false) goto L8;
        r102 = r102 + r104.length();
        goto L8
    L15:
        if (r102 <= 0) goto L17;
        this.mParam.setFileLength(r102);
    L17:
        INetResponse r105 = this.mDataRequest.httpPostMultipartRequest(this.mParam.getUrl(), this.mSliceConfig, this.mParam.getUserHeaders(), r100);
    L63:
        ServerResponseBase r106 = ServerResponseBase.getServerResponse(this.mParam, r105);     // Catch: Throwable -> L39
        Iterator<File> r107 = this.mTempFiles.iterator();
    L29:
        if (r107.hasNext() == false) goto L37;
        File r108 = r107.next();
        if (r108 == null) goto L29;
        if (r108.exists() == false) goto L29;
        r108.delete();     // Catch: Exception -> L36
        goto L29
    L37:
        this.mTempFiles.clear();
        return r106;
    L39:
        th = move-exception;
        Iterator<File> r109 = this.mTempFiles.iterator();
    L42:
        if (r109.hasNext() == false) goto L50;
        File r110 = r109.next();
        if (r110 == null) goto L42;
        if (r110.exists() == false) goto L42;
        r110.delete();     // Catch: Exception -> L49
        goto L42
    L50:
        this.mTempFiles.clear();
        throw th;
    L19:
        if (this.mParam.getFilePath() == null) goto L60;
        if (this.mParam.getFilePath().isEmpty() == true) goto L60;
        this.mParam.setFileLength(UploadFileUtils.getFileLength(this.mParam.getFilePath(), this.mContext));
        UploaderFileStream r111 = new UploaderFileStream(this.mParam.getFilePath(), 0, this.mParam.getFileLength() - 1, new AnonymousClass1(this), this.mParam, this.mContext);     // Catch: Throwable -> L54
        r105 = this.mDataRequest.httpPostDataRequest(this.mParam.getUrl(), this.mSliceConfig, this.mParam.getUserHeaders(), r111);     // Catch: Throwable -> L52
        r111.close();
    L52:
        Throwable th10 = th;
    L56:
        if (r111 == null) goto L58;
        r111.close();
    L58:
        throw th10;
    L54:
        th = move-exception;
        r111 = null;
        th10 = th;
    L60:
        throw new Exception("normal filePath is empty");
    }

    public long getSliceTaskId() {
        return this.mSliceTaskId;
    }

    public static /* synthetic */ Parameters access$000(SliceTask r100) {
        return r100.mParam;
    }

    public static /* synthetic */ long access$100(SliceTask r100) {
        return r100.mLastTime;
    }

    public static /* synthetic */ long access$200(SliceTask r100) {
        return r100.mLastUploadedLen;
    }

    public void start(boolean r100) throws Exception {
        if (r100 == false) goto L10;
        monitor-enter(this);
        this.mDataRequest = RequestFactory.getRequest(this.mParam.getNetLibType(), this.mContext);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        ServerResponseBase r101 = postData(this.mSliceConfig, this.mDataRequest, this.mSliceOnProgress, this.mContext);
    L14:
        r101.getIsSuccess();
        r101.getIsSingleSliceSucceed();
        if (r101.getIsSuccess() == false) goto L17;
        return;
    L17:
        if (r101.getIsSingleSliceSucceed() == false) goto L20;
        return;
    L20:
        throw new Exception("sliceError:" + r101.getErrorLog());
    L7:
        th = move-exception;
        throw th;
    L10:
        monitor-enter(this);
        this.mQueryRequest = RequestFactory.getRequest(this.mParam.getNetLibType(), this.mContext);     // Catch: Throwable -> L22
        this.mDataRequest = RequestFactory.getRequest(this.mParam.getNetLibType(), this.mContext);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        r101 = queryThenPostData(this.mSliceConfig, this.mQueryRequest, this.mDataRequest, this.mSliceOnProgress, this.mContext);
    L22:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ long access$102(SliceTask r100, long r101) {
        r100.mLastTime = r101;
        return r101;
    }

    public static /* synthetic */ long access$202(SliceTask r100, long r101) {
        r100.mLastUploadedLen = r101;
        return r101;
    }

    private static long getUpdateEnd(Range r100, Parameters r101) {
        if ((r100.end - r100.start) >= (r101.getSliceLen() + 1048576)) goto L7;
        return r100.end;
    L7:
        return (r100.start + r101.getSliceLen()) - 1;
    }

    private static ServerResponseBase getServerInfo(INetRequest r100, Parameters r101, Context r102) throws Exception {
        SliceConfig r103 = new SliceConfig(r101, new Range(0, r101.getFileLength() - 1), 1);
        return ServerResponseBase.getServerResponse(r101, r100.httpGetRequest(UploaderRequest.getQueryUrl(r101.getProtocol(), r103), r103, UploaderRequest.getQueryHeaders(r103.getParam().getProtocol(), r103, r102), 0));
    }

    public SliceTask(Parameters r100, Context r101, Range r102, ISliceOnProgress r103) {
        this.mParam = null;
        this.mSliceConfig = null;
        this.mContext = null;
        this.mDataRequest = null;
        this.mQueryRequest = null;
        this.mSliceOnProgress = null;
        this.mSliceTaskId = -1;
        this.mLastUploadedLen = 0;
        this.mLastTime = 0;
        this.mTempFiles = new ArrayList();
        this.mParam = r100;
        this.mContext = r101;
        this.mSliceOnProgress = r103;
        this.mSliceConfig = new SliceConfig(r100, r102, 2);
        this.mSliceTaskId = r102.start;
    }

    private static ServerResponseBase postData(SliceConfig r110, INetRequest r111, ISliceOnProgress r112, Context r113) throws Exception {
        UploaderFileStream r100 = null;
        INetResponse r101 = null;
        r100 = null;
        Thread.sleep(200);     // Catch: Throwable -> L17 Exception -> L19
        UploaderFileStream r102 = new UploaderFileStream(r110.getParam().getFilePath(), r110.getStart(), r110.getEnd(), r112, r110.getParam(), r113);     // Catch: Throwable -> L17 Exception -> L19
    L15:
        e = e;
        r100 = r102;
    L21:
        if (ULLog.debug() == false) goto L23;
        ULLog.taskDebug(TAG, ((Long) CommonTools.getNonnullValue(r110.getParam(), new a(), 0L)).longValue(), "postData", "error: " + e);     // Catch: Throwable -> L17
    L23:
        throw e;     // Catch: Throwable -> L17
    L13:
        th = th;
        r100 = r102;
    L24:
        if (r100 == null) goto L26;
        r100.close();
    L26:
        throw th;
    L5:
        if (r110.getParam().getProtocol() != 1) goto L8;
        r101 = r111.httpPostDataRequest(UploaderRequest.getPostDataUrl(r110.getParam().getProtocol(), r110), r110, UploaderRequest.getPostDataHeaders(r110.getParam().getProtocol(), r110), r102);     // Catch: Throwable -> L13 Exception -> L15
    L10:
        ServerResponseBase r103 = ServerResponseBase.getServerResponse(r110.getParam(), r101);     // Catch: Throwable -> L13 Exception -> L15
        r102.close();
        return r103;
    L8:
        if (r110.getParam().getProtocol() != 2) goto L10;
        r101 = r111.httpPutDataRequest(UploaderRequest.getPostDataUrl(r110.getParam().getProtocol(), r110), r110, UploaderRequest.getPostDataHeaders(r110.getParam().getProtocol(), r110), r102);     // Catch: Throwable -> L13 Exception -> L15
    L19:
        e = e;
    L17:
        th = th;
        goto L24
    }

    private static ServerResponseBase queryThenPostData(SliceConfig r100, INetRequest r101, INetRequest r102, ISliceOnProgress r103, Context r104) throws Exception {
        ServerResponseBase r105 = getServerInfo(r101, r100.getParam(), r104);
        if (r105.getIsUploaded() == false) goto L6;
        return r105;
    L6:
        if (r105.getIsSuccess() == false) goto L17;
        if (r105.getRemainDisk() > 0) goto L10;
    L14:
        Range r106 = (Range) ListProtector.get(r105.getNeedUploadRangeArray(), 0);
        r100.updateRange(r106.start, getUpdateEnd(r106, r100.getParam()));
        return postData(r100, r102, r103, r104);
    L10:
        if ((r105.getUnuploadedLen() + 524288000) <= r105.getRemainDisk()) goto L14;
        throw new Exception("server disk not enough，res.getRemainDisk()=" + r105.getRemainDisk() + ",res.getUnuploadedLen()=" + r105.getUnuploadedLen());
    L17:
        throw new Exception("error:" + r105.getErrorLog());
    }
}
