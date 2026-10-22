package org.chromium;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.RetrofitLayerMetrics;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends TTMonitorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f525632a;

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public final boolean handleApiSample(String r100, String r101) {
        return true;
    }

    public static b a() {
        if (f525632a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f525632a != null) goto L9;
        f525632a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f525632a;
    }

    public b() {
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public final void sendAppMonitorEvent(String r100, String r101) {
        c.h().k(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public final void handleApiResult(boolean r110, String r111, String r112, String r113, long r114, long r115, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, boolean r313, long r314, long r315, long r410, String r411, String r412, String r413, int r414, int r415, String r416, String r417) {
        BaseHttpRequestInfo r100 = BaseHttpRequestInfo.createHttpRequestInfo();
        r100.traceCode = r112;
        r100.remoteIp = r113;
        r100.appLevelRequestStart = r114;
        r100.beforeAllInterceptors = r114;
        r100.requestStart = r115;
        RetrofitMetrics r101 = r100.metrics;
        RetrofitLayerMetrics.EventTimestamp r102 = r101.retrofit.eventTs;
        r102.ssHttpCallApiStartTime = r115;
        r100.requestEnd = r212;
        r102.requestEndTime = r212;
        r101.setKernelDns(r213);
        r100.metrics.setKernelTCPConnect(r214);
        r100.metrics.setKernelTls(r310);
        r100.metrics.setKernelSend(r311);
        r100.metrics.setKernelTTFB(r314);
        r100.metrics.setKernelReceiveBody(r312);
        r100.metrics.setKernelTotal(r212 - r115);
        r100.metrics.setNetworkKernelRawRequestLog(r411);
        r100.responseBack = r210;
        r100.completeReadResponse = r211;
        r100.isSocketReused = r313;
        r100.receivedByteCount = r315;
        r100.sentByteCount = r410;
        r100.requestHeaders = r412;
        r100.responseHeaders = r413;
        r100.httpClientType = 0;
        r100.bizExtraLog = r417;
        if (r110 == false) goto L5;
        NetworkParams.monitorApiOk(r111, r100);
        return;
    L5:
        switch(r414) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            default: goto L7;
        };
    L9:
        int r103 = 11;
    L21:
        NetworkExceptionImpl r104 = new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r416, r103, r415);
        int r105 = r104.getErrorCode();
        Throwable r106 = r104;
        switch(r105) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L24;
            default: goto L32;
        };
    L24:
        Throwable r107 = new NoRouteToHostException(r104.getMessage());
    L31:
        r106 = r107;
        goto L32
    L25:
        r107 = new SocketException("reset by peer " + r104.getMessage());
        goto L31
    L26:
        r107 = new ConnectTimeoutException(r104.getMessage());
        goto L31
    L27:
        r107 = new ConnectException(r104.getMessage());
        goto L31
    L28:
        r107 = new SocketTimeoutException(r104.getMessage());
        goto L31
    L29:
        r107 = new ConnectException(r104.getMessage());
        goto L31
    L30:
        r107 = new UnknownHostException(r104.getMessage());
    L32:
        NetworkParams.monitorApiError(r111, r100, r106);
        return;
    L10:
        r103 = 10;
        goto L21
    L11:
        r103 = 9;
        goto L21
    L12:
        r103 = 8;
        goto L21
    L13:
        r103 = 7;
        goto L21
    L14:
        r103 = 6;
        goto L21
    L15:
        r103 = 5;
        goto L21
    L16:
        r103 = 4;
        goto L21
    L17:
        r103 = 3;
        goto L21
    L18:
        r103 = 2;
        goto L21
    L19:
        r103 = 1;
        goto L21
    L7:
        if (d.a().loggerDebug() == false) goto L20;
        d.a().loggerD("monitor", "Unknown error code: " + r414);
    L20:
        r103 = r414;
        goto L21
    }
}
