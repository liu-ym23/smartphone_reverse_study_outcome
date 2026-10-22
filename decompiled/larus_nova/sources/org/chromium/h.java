package org.chromium;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetRequestExtraInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class h extends RequestFinishedInfo.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseHttpRequestInfo f525644a;

    public static long a(long r100, long r101) {
        if (r101 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r100 == (-1)) goto L11;
        if (r101 > r100) goto L11;
        return r100 - r101;
    }

    static {
    }

    public h(BaseHttpRequestInfo r100) {
        super(new g());
        this.f525644a = r100;
    }

    public static long b(Date r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getTime();
    }

    public static long c(Long r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.longValue();
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
    public final void onRequestFinished(RequestFinishedInfo r110) {
        if (this.f525644a == null) goto L37;
        if (r110 == null) goto L38;
        RequestFinishedInfo.Metrics r111 = r110.getMetrics();
        if (r111 != null) goto L9;
        return;
    L9:
        this.f525644a.nativeRequestStartTime = b(r111.getRequestStart());
        this.f525644a.metrics.setKernelDns(a(b(r111.getDnsEnd()), b(r111.getDnsStart())));
        this.f525644a.metrics.setKernelTCPConnect(a(b(r111.getConnectEnd()), b(r111.getConnectStart())));
        this.f525644a.metrics.setKernelTls(a(b(r111.getSslEnd()), b(r111.getSslStart())));
        this.f525644a.metrics.setKernelSend(a(b(r111.getSendingEnd()), b(r111.getSendingStart())));
        this.f525644a.metrics.setKernelPush(a(b(r111.getPushEnd()), b(r111.getPushStart())));
        this.f525644a.metrics.setKernelTTFB(c(r111.getTtfbMs()));
        this.f525644a.metrics.setKernelReceiveBody(a(b(r111.getRequestEnd()), b(r111.getResponseStart())));
        this.f525644a.metrics.setKernelTotal(c(r111.getTotalTimeMs()));
        this.f525644a.metrics.setUpperAddCookieDurationUs(c(r111.getAddCookieCostUs()));
        this.f525644a.metrics.setUpperSaveCookieDurationUs(c(r111.getSaveCookieCostUs()));
        RetrofitMetrics r100 = this.f525644a.metrics;
        Integer r101 = r111.getRequestCookieSource();
        if (r101 != null) goto L12;
        int r102 = -1;
    L13:
        r100.setRequestCookieSourceType(r102);
        this.f525644a.metrics.setCronetReadResponseBodyMetrics(r111.getResponseBodyReadTimes(), r111.getFirstReadResponseBodyStart(), r111.getLastReadResponseBodyEnd(), r111.getReadResponseBodyDuration(), r111.getBizReadResponseBodyInterval());
        this.f525644a.metrics.setNetworkKernelRawRequestLog(r111.getRequestLog());
        CronetRequestExtraInfo r103 = new CronetRequestExtraInfo();
        r103.urlDispatchDropReason = r111.getURLDispatchDropReason();
        this.f525644a.metrics.setRequestExtraInfo(r103);
        this.f525644a.remoteIp = r111.getPeerAddr() + ":" + r111.getPeerPort();
        this.f525644a.isSocketReused = r111.getSocketReused();
        this.f525644a.sentByteCount = c(r111.getSentByteCount());
        this.f525644a.receivedByteCount = c(r111.getReceivedByteCount());
        this.f525644a.retryAttempts = c(r111.getRetryAttempts());
        this.f525644a.requestHeaders = r111.getRequestHeaders();
        this.f525644a.responseHeaders = r111.getResponseHeaders();
        this.f525644a.hasSampled = r111.getPreSamplingReportable();
        this.f525644a.bypassApiReport = r111.getBypassApiReport();
        this.f525644a.metrics.setRequestCookieRelMetric(r111.getCookieRelMetric());
        if (TextUtils.isEmpty(this.f525644a.requestLog) == false) goto L35;
        JSONObject r112 = this.f525644a.extraInfo;
        if (r112 == null) goto L35;
        if (SsCronetHttpClient.getCronetTncInfoGet() == null) goto L21;
        JSONObject r104 = SsCronetHttpClient.getCronetTncInfoGet().getABTest();
    L22:
        if (r104 == null) goto L35;
        r112.put(BaseHttpRequestInfo.KEY_ABTEST, r104);     // Catch: JSONException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L21:
        r104 = null;
    L35:
        BaseHttpRequestInfo r113 = this.f525644a;     // Catch: Throwable -> L29
        r113.metrics.extra.put(RetrofitMetrics.ExtraKeys.SENT_BYTE_COUNT, Long.valueOf(r113.sentByteCount));     // Catch: Throwable -> L29
        BaseHttpRequestInfo r114 = this.f525644a;     // Catch: Throwable -> L29
        r114.metrics.extra.put(RetrofitMetrics.ExtraKeys.RECEIVED_BYTE_COUNT, Long.valueOf(r114.receivedByteCount));     // Catch: Throwable -> L29
        BaseHttpRequestInfo r115 = this.f525644a;     // Catch: Throwable -> L29
        r115.extraInfo.put("retrofit", r115.metrics.getRetrofitLog());     // Catch: Throwable -> L29
    L31:
        this.f525644a.metrics.markNetworkKernelLogCollected();
        return;
    L29:
        th = move-exception;
        th.printStackTrace();
        goto L31
    L12:
        r102 = r101.intValue();
        goto L13
    L38:
        return;
    }
}
