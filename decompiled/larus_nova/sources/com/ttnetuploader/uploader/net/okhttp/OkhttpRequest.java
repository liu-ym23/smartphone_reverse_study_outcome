package com.ttnetuploader.uploader.net.okhttp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.RouteInfo;
import android.util.Patterns;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ttnetuploader.uploader.api.ULLog;
import com.ttnetuploader.uploader.api.ULMultipartPart;
import com.ttnetuploader.uploader.net.INetRequest;
import com.ttnetuploader.uploader.net.INetResponse;
import com.ttnetuploader.uploader.net.NetResponse;
import com.ttnetuploader.uploader.slice_task.SliceConfig;
import com.ttnetuploader.uploader.utils.CommonTools;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.k;

/* JADX INFO: loaded from: classes41.dex */
public class OkhttpRequest implements INetRequest {
    private static final String TAG = "OkhttpRequest";
    private volatile Call mCall;
    OkHttpClient mClient;
    private Context mContext;

    public static class TargetInfo {
        final String host;
        final InetAddress target;

        public TargetInfo(InetAddress r100, String r101) {
            this.target = r100;
            this.host = r101;
        }
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public void suspend() {
        if (this.mCall == null) goto L6;
        this.mCall.cancel();
        return;
    }

    public OkhttpRequest(Context r100) {
        this.mCall = null;
        this.mClient = new OkHttpClient();
        this.mContext = r100;
    }

    private OkHttpClient buildBoundClient(final Network r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return this.mClient.newBuilder().socketFactory(r100.getSocketFactory()).dns(new AnonymousClass3(this, r100)).build();
    L7:
        th = move-exception;
        ULLog.e(TAG, "forceWifi build bound client error", th);
        return null;
    }

    private Network getActiveWifiNetwork(ConnectivityManager r100) {
        Network r101 = r100.getActiveNetwork();     // Catch: Throwable -> L10
        if (r101 == null) goto L15;
        NetworkCapabilities r102 = r100.getNetworkCapabilities(r101);     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        if (r102.hasTransport(1) == true) goto L18;
        return null;
    L18:
        return r101;
    L16:
        return null;
    L15:
        return null;
    L10:
        th = move-exception;
        ULLog.e(TAG, "forceWifi get active wifi network error", th);
        return null;
    }

    private OkHttpClient getWifiBoundClient(String r110) {
        Context r100 = this.mContext;
        if (r100 != null) goto L5;
        return null;
    L5:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 != null) goto L8;
        return null;
    L8:
        TargetInfo r102 = parseTargetInfo(r110);
        Network[] r103 = r101.getAllNetworks();
        logForceWifiStart(r110, r102.target, r103);
        Network r111 = getActiveWifiNetwork(r101);
        if (r103 == null) goto L21;
        int r104 = r103.length;
        int r105 = 0;
        Network r106 = null;
    L11:
        if (r105 >= r104) goto L22;
        Network r107 = r103[r105];
        NetworkCapabilities r108 = r101.getNetworkCapabilities(r107);
        LinkProperties r109 = r101.getLinkProperties(r107);
        logNetworkInfo(r107, r108, r109);
        if (isWifiCandidate(r108, r109) == false) goto L20;
        if (r106 != null) goto L17;
        r106 = r107;
    L17:
        OkHttpClient r112 = selectWifiByRoute(r102.target, r107, r109);
        if (r112 == null) goto L20;
        return r112;
    L20:
        r105 = r105 + 1;
    L22:
        if (r111 == null) goto L27;
        logActiveWifi(r101, r111, r102.host);
        OkHttpClient r113 = buildBoundClient(r111);
        if (r113 == null) goto L27;
        return r113;
    L27:
        if (r106 == null) goto L34;
        logFallbackWifi(r101, r106);     // Catch: Throwable -> L30
        return buildBoundClient(r106);
    L30:
        th = move-exception;
        ULLog.e(TAG, "forceWifi fallback wifi network error", th);
        return null;
    L34:
        if (ULLog.debug() == false) goto L36;
        ULLog.d(TAG, "forceWifi no wifi network found");
    L36:
        return null;
    L21:
        r106 = null;
        goto L22
    }

    public static Headers mapToHeaders(Map<String, String> r100) {
        Headers.Builder r101 = new Headers.Builder();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, String> r103 = r102.next();
        if (r103.getKey() == null) goto L4;
        if (r103.getValue() == null) goto L4;
        r101.add(r103.getKey(), r103.getValue());
        goto L4
    L11:
        return r101.build();
    }

    private TargetInfo parseTargetInfo(String r100) {
        InetAddress r101 = null;
        String r102 = URI.create(r100).getHost();     // Catch: Throwable -> L21
        if (r102 == null) goto L25;
    L19:
        th = th;
    L23:
        ULLog.e(TAG, "forceWifi parse url error", th);
        goto L25
    L6:
        if (r102.isEmpty() == true) goto L25;
        if (r102.startsWith("[") == true) goto L10;
    L14:
        String r103 = r102;
    L16:
        if (Patterns.IP_ADDRESS.matcher(r103).matches() == false) goto L25;
        r101 = InetAddress.getByName(r103);     // Catch: Throwable -> L19
        r102 = r103;
        goto L25
    L10:
        if (r102.endsWith("]") == false) goto L14;
        if (r102.length() <= 2) goto L14;
        r103 = r102.substring(1, r102.length() - 1);     // Catch: Throwable -> L19
    L25:
        return new TargetInfo(r101, r102);
    L21:
        th = th;
        r102 = null;
        goto L23
    }

    public static Map<String, String> parserHeaders(Headers r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap r101 = new HashMap();
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L15;
        if (r100.name(r102) == null) goto L14;
        if (r100.value(r102) == null) goto L14;
        r101.put(r100.name(r102), r100.value(r102));
    L14:
        r102 = r102 + 1;
        goto L7
    L15:
        return r101;
    }

    private boolean isWifiCandidate(NetworkCapabilities r100, LinkProperties r101) {
        if (r100 != null) goto L4;
    L11:
        return false;
    L4:
        if (r100.hasTransport(1) == false) goto L11;
        if (r101 == null) goto L11;
        if (r101.getLinkAddresses() == null) goto L11;
        if (r101.getLinkAddresses().isEmpty() == true) goto L11;
        return true;
    }

    private void logFallbackWifi(ConnectivityManager r100, Network r101) {
        if (ULLog.debug() == true) goto L5;
        return;
    L5:
        LinkProperties r102 = r100.getLinkProperties(r101);
        StringBuilder r103 = new StringBuilder("forceWifi fallback wifi network=");
        r103.append(r101);
        r103.append(", iface=");
        Object r104 = "null";
        if (r102 == null) goto L8;
        String r105 = r102.getInterfaceName();
    L9:
        r103.append(r105);
        r103.append(", addrs=");
        if (r102 == null) goto L12;
        r104 = r102.getLinkAddresses();
    L12:
        r103.append(r104);
        ULLog.d(TAG, r103.toString());
        return;
    L8:
        r105 = "null";
        goto L9
    }

    private void logActiveWifi(ConnectivityManager r100, Network r101, String r102) {
        if (ULLog.debug() == true) goto L5;
        return;
    L5:
        LinkProperties r103 = r100.getLinkProperties(r101);
        StringBuilder r104 = new StringBuilder("forceWifi active wifi network=");
        r104.append(r101);
        r104.append(", iface=");
        Object r105 = "null";
        if (r103 == null) goto L8;
        String r106 = r103.getInterfaceName();
    L9:
        r104.append(r106);
        r104.append(", addrs=");
        if (r103 == null) goto L12;
        r105 = r103.getLinkAddresses();
    L12:
        r104.append(r105);
        r104.append(", host=");
        r104.append(r102);
        ULLog.d(TAG, r104.toString());
        return;
    L8:
        r106 = "null";
        goto L9
    }

    private void logForceWifiStart(String r100, InetAddress r101, Network[] r102) {
        if (ULLog.debug() == false) goto L14;
        StringBuilder r103 = new StringBuilder("forceWifi url=");
        r103.append(r100);
        r103.append(", target=");
        if (r101 == null) goto L7;
        String r104 = r101.getHostAddress();
    L8:
        r103.append(r104);
        r103.append(", networks=");
        if (r102 == null) goto L11;
        int r105 = r102.length;
    L12:
        r103.append(r105);
        ULLog.d(TAG, r103.toString());
        return;
    L11:
        r105 = 0;
        goto L12
    L7:
        r104 = "null";
        goto L8
    }

    private void logNetworkInfo(Network r100, NetworkCapabilities r101, LinkProperties r102) {
        if (ULLog.debug() == true) goto L5;
        return;
    L5:
        String r103 = "null";
        if (r102 != null) goto L26;
        String r104 = "null";
    L11:
        if (r101 == null) goto L13;
        String r105 = r101.toString();     // Catch: Throwable -> L8
    L14:
        if (r102 == null) goto L16;
        String r106 = r102.getLinkAddresses().toString();     // Catch: Throwable -> L8
    L17:
        if (r102 == null) goto L19;
        String r107 = r102.getRoutes().toString();     // Catch: Throwable -> L8
    L20:
        if (r102 == null) goto L22;
        r103 = r102.getDnsServers().toString();     // Catch: Throwable -> L8
    L22:
        ULLog.d(TAG, "network=" + r100 + ", iface=" + r104 + ", caps=" + r105 + ", addrs=" + r106 + ", routes=" + r107 + ", dns=" + r103);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        ULLog.e(TAG, "forceWifi log network info error", th);
        return;
    L19:
        r107 = "null";
        goto L20
    L16:
        r106 = "null";
        goto L17
    L13:
        r105 = "null";
        goto L14
    L26:
        r104 = r102.getInterfaceName();     // Catch: Throwable -> L8
        goto L11
    }

    private OkHttpClient selectWifiByRoute(InetAddress r100, Network r101, LinkProperties r102) {
        if (r100 == null) goto L24;
        if (r102 == null) goto L24;
        Iterator<RouteInfo> r103 = r102.getRoutes().iterator();
    L8:
        if (r103.hasNext() == false) goto L24;
        RouteInfo r104 = r103.next();
        if (r104 == null) goto L8;
    L22:
        th = move-exception;
        ULLog.e(TAG, "forceWifi select wifi network error", th);
        goto L8
    L12:
        if (r104.matches(r100) == false) goto L8;
        if (r104.getDestination() == null) goto L8;
        if (r104.getDestination().getPrefixLength() <= 0) goto L8;
        if (ULLog.debug() == false) goto L20;
        ULLog.d(TAG, "forceWifi select wifi network=" + r101 + ", iface=" + r102.getInterfaceName() + ", addrs=" + r102.getLinkAddresses() + ", route=" + r104);     // Catch: Throwable -> L22
    L20:
        return buildBoundClient(r101);
    L24:
        return null;
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public INetResponse httpGetRequest(String r100, SliceConfig r101, Map<String, String> r102, int r110) throws Exception {
        return getNetResponse(r101, 1, r100, null, r102);
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public INetResponse httpPostDataRequest(String r100, final SliceConfig r101, Map<String, String> r102, final InputStream r110) throws Exception {
        return getNetResponse(r101, 2, r100, new AnonymousClass1(this, r101, r110), r102);
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public INetResponse httpPostMultipartRequest(String r110, SliceConfig r111, Map<String, String> r112, Map<String, ULMultipartPart> r113) throws Exception {
        k.a r100 = new k.a();
        r100.e(k.f523924f);
        if (r113 == null) goto L30;
        Iterator<Map.Entry<String, ULMultipartPart>> r114 = r113.entrySet().iterator();
    L6:
        if (r114.hasNext() == false) goto L30;
        Map.Entry<String, ULMultipartPart> r101 = r114.next();
        if (r101.getKey() == null) goto L6;
        if (r101.getValue() == null) goto L6;
        ULMultipartPart r102 = r101.getValue();
        if (r102.stringContent != null) goto L13;
        if (r102.filePath == null) goto L6;
        String r103 = r102.contentType;
        if (r103 != null) goto L24;
        r103 = "application/octet-stream";
    L24:
        MediaType r104 = MediaType.parse(r103);
        if (r102.filePath.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == false) goto L27;
        PolarisFileWrapper r105 = new PolarisFileWrapper(URI.create(r102.filePath));
    L28:
        r100.b(r101.getKey(), r102.fileName, RequestBody.create(r104, r105));
        goto L6
    L27:
        r105 = new PolarisFileWrapper(r102.filePath);
        goto L28
    L13:
        String r106 = r102.contentType;
        if (r106 != null) goto L17;
        r106 = "text/plain";
    L17:
        r100.c(k.b.a(Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + r101.getKey() + "\""}), RequestBody.create(MediaType.parse(r106), r102.stringContent)));
    L30:
        return getNetResponse(r111, 2, r110, r100.d(), r112);
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public INetResponse httpPutDataRequest(String r100, final SliceConfig r101, Map<String, String> r102, final InputStream r110) throws Exception {
        return getNetResponse(r101, 3, r100, new AnonymousClass2(this, r101, r110), r102);
    }

    public INetResponse getNetResponse(SliceConfig r100, int r110, String r111, RequestBody r112, Map<String, String> r113) throws Exception {
        OkHttpClient r101 = this.mClient;     // Catch: Throwable -> L36
        if (r100 != null) goto L6;
    L12:
        Request.Builder r114 = new Request.Builder().url(r111).headers(mapToHeaders(r113));     // Catch: Throwable -> L36
        if (r110 != 1) goto L15;
        r114.get();     // Catch: Throwable -> L36
    L22:
        this.mCall = r101.newCall(r114.build());     // Catch: Throwable -> L36
        Response r115 = this.mCall.execute();     // Catch: Throwable -> L36
    L34:
        th = th;
    L38:
        if (r115 == null) goto L40;
        r115.close();
    L40:
        this.mCall = null;
        throw th;
    L24:
        if (r115.isSuccessful() == false) goto L33;
        if (r115.body() != null) goto L28;
        String r116 = null;
    L29:
        NetResponse r117 = new NetResponse(r115.code(), r100, parserHeaders(r115.headers()), CommonTools.getJsonFromString(r116), "");     // Catch: Throwable -> L34
        r115.close();
        this.mCall = null;
        return r117;
    L28:
        r116 = r115.body().string();     // Catch: Throwable -> L34
        goto L29
    L33:
        throw new IOException("Unexpected response: " + r115);     // Catch: Throwable -> L34
    L15:
        if (r110 != 2) goto L17;
        r114.post(r112);     // Catch: Throwable -> L36
        goto L22
    L17:
        if (r110 != 3) goto L22;
        r114.put(r112);     // Catch: Throwable -> L36
        goto L22
    L6:
        if (r100.getParam() == null) goto L12;
        if (r100.getParam().isForceWifi() == false) goto L12;
        OkHttpClient r102 = getWifiBoundClient(r111);     // Catch: Throwable -> L36
        if (r102 == null) goto L12;
        r101 = r102;
    L36:
        th = th;
        r115 = null;
        goto L38
    }

    @Override // com.ttnetuploader.uploader.net.INetRequest
    public INetResponse httpPostRequest(String r100, SliceConfig r101, Map<String, String> r102, String r110, int r111) throws Exception {
        return getNetResponse(r101, 2, r100, RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r110), r102);
    }
}
