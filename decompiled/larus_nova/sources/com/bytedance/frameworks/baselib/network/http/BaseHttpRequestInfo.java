package com.bytedance.frameworks.baselib.network.http;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.LegacyLogRecorder;
import com.bytedance.retrofit2.RetrofitLayerMetrics;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BaseHttpRequestInfo<T extends BaseRequestContext> implements LegacyLogRecorder {
    public static final int HTTP_CLIENT_TYPE_CRONET = 0;
    public static final int HTTP_CLIENT_TYPE_OK3 = 1;
    public static final String KEY_ABTEST = "ab_test";
    public static final String KEY_COOKIE = "cookie";
    public static final String KEY_EXCEPTION = "ex";
    public static final String KEY_HIT = "hit";
    public static final String KEY_HTTP_CLIENT = "hc";
    public static final String KEY_HTTP_CLIENT_VERSION = "hcv";
    public static final String KEY_RESPONSE_HEADERS = "response-headers";
    public static final String KEY_USER_AGENT = "ua";
    private static volatile b sCreate;
    public boolean accountRetry;
    public long appLevelRequestStart;
    public boolean bdTuringRetry;
    public long beforeAllInterceptors;
    public String bizExtraLog;
    public boolean bypassApiReport;
    public long completeReadResponse;
    public long connectTime;
    public String contentType;
    public int customInputStreamSize;
    public long dnsTime;
    public boolean downloadFile;
    public boolean executeTuringCallback;
    public JSONObject extraInfo;
    public String fallbackMessage;
    public int fallbackReason;
    public boolean fromCache;
    public boolean hasSampled;
    public int httpClientType;
    public boolean isSocketReused;
    public RetrofitMetrics metrics;
    public long nativePostTaskStartTime;
    public long nativeRequestStartTime;
    public long nativeWaitContext;
    public long pushTime;
    public long receiveTime;
    public long receivedByteCount;
    public int recycleCount;
    public String remoteIp;
    public final AtomicBoolean reported;
    public T reqContext;
    public long requestEnd;
    public long requestEndAppResumeState;
    public String requestHeaders;
    public String requestLog;
    public long requestRetryStart;
    public long requestStart;
    public long requestStartAppResumeState;
    public long responseBack;
    public long responseBodyByteCount;
    public String responseHeaders;
    public long retryAttempts;
    public String retryByHeaderFilterKey;
    public long retryForAccountCallbackDuration;
    public com.bytedance.frameworks.baselib.network.http.a rotationHostPathRetryHandler;
    public boolean rotationHostRetry;
    public long sendTime;
    public long sentByteCount;
    public long sslTime;
    public long totalTime;
    public String traceCode;
    public long ttfbMs;
    public long turingCallbackDuration;
    public URL url;
    public boolean useCronetInputStreamWithTTBuffer;
    public boolean useDeprecatedApi;

    public class a implements b {
        public a() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo.b
        public final BaseHttpRequestInfo create() {
            return new BaseHttpRequestInfo();
        }
    }

    public interface b {
        BaseHttpRequestInfo create();
    }

    static {
        sCreate = new a();
    }

    public static BaseHttpRequestInfo createHttpRequestInfo() {
        return sCreate.create();
    }

    public long getRequestDurationMs() {
        return this.metrics.retrofit.getRequestDurationMs();
    }

    public BaseHttpRequestInfo() {
        this.useCronetInputStreamWithTTBuffer = false;
        this.customInputStreamSize = -1;
        this.metrics = new RetrofitMetrics(this);
        this.requestStart = System.currentTimeMillis();
        this.nativePostTaskStartTime = -1;
        this.nativeWaitContext = -1;
        this.requestStartAppResumeState = -1;
        this.requestEndAppResumeState = -1;
        this.recycleCount = -1;
        this.fromCache = false;
        this.httpClientType = -1;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestLog = "";
        this.extraInfo = new JSONObject();
        this.downloadFile = false;
        this.contentType = "";
        this.traceCode = "";
        this.bizExtraLog = "";
        this.executeTuringCallback = false;
        this.bdTuringRetry = false;
        this.turingCallbackDuration = -1;
        this.accountRetry = false;
        this.retryForAccountCallbackDuration = -1;
        this.rotationHostRetry = false;
        this.useDeprecatedApi = false;
        this.reported = new AtomicBoolean(false);
    }

    private void addMoreBizData(JSONObject r110) throws JSONException {
        r110.put("use_deprecated_api", this.useDeprecatedApi);
        T r100 = this.reqContext;
        if (r100 == null) goto L8;
        long r101 = r100.protect_timeout;
        if (r101 <= 0) goto L7;
        r110.put("protect_timeout", r101);
        r110.put("connect_timeout", this.reqContext.socket_connect_timeout);
        r110.put(DownloadSettingKeys.SegmentConfig.READ_TIMEOUT, this.reqContext.socket_read_timeout);
        r110.put("write_timeout", this.reqContext.socket_write_timeout);
        goto L8
    L7:
        r110.put("connect_timeout", r100.timeout_connect);
        r110.put(DownloadSettingKeys.SegmentConfig.READ_TIMEOUT, this.reqContext.timeout_read);
        r110.put("write_timeout", this.reqContext.timeout_write);
    L8:
        RetrofitMetrics r102 = this.metrics;
        if (r102 != null) goto L11;
        return;
    L11:
        r110.put("resp_comp", r102.responseCompressType);
        r110.put("req_comp", this.metrics.requestCompressType);
        Long r103 = this.metrics.responseInterceptDuration.get("CallServerInterceptor");
        if (r103 == null) goto L14;
        long r104 = r103.longValue();
    L15:
        r110.put("parse_time", r104);
        r110.put("priority_level", this.metrics.priorityLevel);
        r110.put("req_priority_level", this.metrics.requestPriorityLevel);
        r110.put(IVideoEventLogger.FEATURE_KEY_THREAD_PRIORITY, ThreadMethodProxy.currentThread().getPriority());
        RetrofitMetrics r105 = this.metrics;
        long r106 = r105.executeTime;
        if (r106 <= 0) goto L28;
        r110.put("biz_before_time", r106 - r105.appCreateRetrofitStartUpTime);
        RetrofitMetrics r107 = this.metrics;
        r110.put("queue_time", r107.responseChainTime - r107.executeTime);
        RetrofitMetrics r108 = this.metrics;
        r110.put("preprocess_time", r108.executeCallStartTime - r108.responseChainTime);
        RetrofitMetrics r109 = this.metrics;
        r110.put("realcall_time", r109.executeCallEndTime - r109.executeCallStartTime);
        r110.put("is_async", 0);
        if (this.downloadFile == false) goto L27;
        RetrofitMetrics r111 = this.metrics;
        if (r111.executeEndTime > 0) goto L22;
        r110.put("postprocess_time", -1);
        r110.put("cb_time", -1);
        r110.put("executeCallEndTime", this.metrics.executeCallEndTime);
        r110.put("executeEndTime", this.metrics.executeEndTime);
    L26:
        RetrofitMetrics r112 = this.metrics;
        r110.put("biz_total_time", r112.executeCallEndTime - r112.appCreateRetrofitStartUpTime);
    L44:
        if (this.metrics.interceptorRequestInfos.size() <= 0) goto L79;
        HashMap r113 = new HashMap();
        int r114 = 0;
    L47:
        if (r114 >= this.metrics.interceptorRequestInfos.size()) goto L53;
        RetrofitMetrics.InterceptorInfo r115 = (RetrofitMetrics.InterceptorInfo) ListProtector.get(this.metrics.interceptorRequestInfos, r114);
        long r116 = r115.end - r115.start;
        Long r117 = (Long) r113.get(r115.name);
        if (r117 != null) goto L51;
        r113.put(r115.name, Long.valueOf(r116));
    L52:
        r114 = r114 + 1;
        goto L47
    L51:
        r113.put(r115.name, Long.valueOf(r117.longValue() + r116));
        goto L52
    L53:
        JSONObject r118 = new JSONObject();
        Iterator r119 = r113.keySet().iterator();
    L55:
        if (r119.hasNext() == false) goto L57;
        String r120 = (String) r119.next();
        r118.put(r120, r113.get(r120));
        goto L55
    L57:
        r110.put("request_interceptors_time", r118);
        HashMap r121 = new HashMap();
        int r122 = 0;
    L59:
        if (r122 >= this.metrics.interceptorResponseInfos.size()) goto L65;
        RetrofitMetrics.InterceptorInfo r123 = (RetrofitMetrics.InterceptorInfo) ListProtector.get(this.metrics.interceptorResponseInfos, r122);
        long r124 = r123.end - r123.start;
        Long r125 = (Long) r121.get(r123.name);
        if (r125 != null) goto L63;
        r121.put(r123.name, Long.valueOf(r124));
    L64:
        r122 = r122 + 1;
        goto L59
    L63:
        r121.put(r123.name, Long.valueOf(r125.longValue() + r124));
        goto L64
    L65:
        JSONObject r126 = new JSONObject();
        Iterator r127 = r121.keySet().iterator();
    L67:
        if (r127.hasNext() == false) goto L69;
        String r128 = (String) r127.next();
        r126.put(r128, r121.get(r128));
        goto L67
    L69:
        r110.put("response_interceptors_time", r126);
        return;
    L79:
        return;
    L22:
        if (r111.interceptorResponseInfos.size() <= 0) goto L24;
        RetrofitMetrics r129 = this.metrics;
        r110.put("postprocess_time", r129.executeEndTime - ((RetrofitMetrics.InterceptorInfo) ListProtector.get(r129.interceptorResponseInfos, 0)).start);
    L24:
        RetrofitMetrics r130 = this.metrics;
        r110.put("cb_time", r130.executeCallEndTime - r130.executeEndTime);
        goto L26
    L27:
        RetrofitMetrics r131 = this.metrics;
        r110.put("postprocess_time", r131.executeEndTime - r131.executeCallEndTime);
        RetrofitMetrics r132 = this.metrics;
        r110.put("biz_total_time", r132.executeEndTime - r132.appCreateRetrofitStartUpTime);
        goto L44
    L28:
        long r133 = r105.enqueueTime;
        if (r133 <= 0) goto L44;
        r110.put("biz_before_time", r133 - r105.appCreateRetrofitStartUpTime);
        RetrofitMetrics r134 = this.metrics;
        r110.put("queue_time", r134.responseChainTime - r134.enqueueTime);
        RetrofitMetrics r135 = this.metrics;
        r110.put("preprocess_time", r135.executeCallStartTime - r135.responseChainTime);
        RetrofitMetrics r136 = this.metrics;
        r110.put("realcall_time", r136.executeCallEndTime - r136.executeCallStartTime);
        r110.put("is_async", 1);
        if (this.downloadFile == false) goto L41;
        RetrofitMetrics r137 = this.metrics;
        if (r137.enqueueCallbackStartTime > 0) goto L35;
        r110.put("postprocess_time", -1);
        r110.put("cb_time", -1);
        r110.put("enqueueCallbackStartTime", this.metrics.enqueueCallbackStartTime);
        r110.put("executeCallEndTime", this.metrics.executeCallEndTime);
    L40:
        RetrofitMetrics r138 = this.metrics;
        r110.put("biz_total_time", r138.executeCallEndTime - r138.appCreateRetrofitStartUpTime);
        goto L44
    L35:
        if (r137.interceptorResponseInfos.size() <= 0) goto L38;
        RetrofitMetrics r139 = this.metrics;
        r110.put("postprocess_time", r139.enqueueCallbackStartTime - ((RetrofitMetrics.InterceptorInfo) ListProtector.get(r139.interceptorResponseInfos, 0)).start);
    L38:
        RetrofitMetrics r140 = this.metrics;
        r110.put("cb_time", r140.executeCallEndTime - r140.enqueueCallbackStartTime);
        goto L40
    L41:
        long r141 = SystemClock.uptimeMillis();
        RetrofitMetrics r142 = this.metrics;
        r110.put("postprocess_time", r142.enqueueCallbackStartTime - r142.executeCallEndTime);
        r110.put("cb_time", r141 - this.metrics.enqueueCallbackStartTime);
        r110.put("biz_total_time", r141 - this.metrics.appCreateRetrofitStartUpTime);
        goto L44
    L14:
        r104 = 0;
        goto L15
    }

    public static JSONObject getABTestInfo(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        String[] r101 = r100.split(",");
        JSONArray r102 = new JSONArray();
        int r103 = r101.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L9;
        r102.put(r101[r104]);
        r104 = r104 + 1;
        goto L7
    L9:
        JSONObject r105 = new JSONObject();
        r105.put(KEY_HIT, r102);     // Catch: JSONException -> L12
    L14:
        return r105;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    private void packageRequestParamters(JSONObject r100) throws JSONException {
        r100.put("requestStart", this.requestStart);
        r100.put("responseBack", this.responseBack);
        r100.put("completeReadResponse", this.completeReadResponse);
        r100.put("appLevelRequestStart", this.appLevelRequestStart);
        r100.put("beforeAllInterceptors", this.beforeAllInterceptors);
        r100.put("requestEnd", this.requestEnd);
        r100.put("recycleCount", this.recycleCount);
        r100.put("timing_dns", this.dnsTime);
        r100.put("timing_connect", this.connectTime);
        r100.put("timing_ssl", this.sslTime);
        r100.put("timing_send", this.sendTime);
        r100.put("timing_waiting", this.ttfbMs);
        r100.put("timing_receive", this.receiveTime);
        r100.put("timing_total", this.totalTime);
        r100.put("timing_isSocketReused", this.isSocketReused);
        r100.put("timing_totalSendBytes", this.sentByteCount);
        r100.put("timing_totalReceivedBytes", this.receivedByteCount);
        r100.put("timing_remoteIP", this.remoteIp);
        r100.put("request_log", this.requestLog);
        JSONObject r101 = this.extraInfo;
        if (r101 == null) goto L5;
        r100.put("req_info", r101);
    L5:
        r100.put("download", this.downloadFile);
        r100.put("addExecutorToAllInterceptors", this.beforeAllInterceptors - this.appLevelRequestStart);
        r100.put("addExecutorTime", this.appLevelRequestStart);
        r100.put("allInterceptorsTime", this.beforeAllInterceptors);
        r100.put("fallback", this.fallbackReason);
        r100.put("requestHeader", this.requestHeaders);
        r100.put("responseHeader", this.responseHeaders);
        if (this.hasSampled == false) goto L9;
        r100.put("hit_rules", 1);
        return;
    }

    public static void setCreate(b r100) {
        if (r100 == null) goto L5;
        sCreate = r100;
        return;
    }

    public void attachMetrics(RetrofitMetrics r100) {
        r100.requestInfo = new WeakReference(this);
        this.metrics = r100;
        RetrofitLayerMetrics.EventTimestamp r101 = r100.retrofit.eventTs;
        long r102 = r101.ssHttpCallApiStartTime;
        this.requestStart = r102;
        this.appLevelRequestStart = r102;
        this.beforeAllInterceptors = r100.ConvertToWallClockTimeMs(r101.requestInterceptorStart);
        this.requestStartAppResumeState = r100.retrofit.misc.requestStartAppResumeState;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void generateOldFormatLog(JSONObject r100) throws JSONException {
        if (r100 != null) goto L4;
        return;
    L4:
        packageRequestParamters(r100);
        addMoreBizData(r100);
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setAccountRetryCallbackDuration(long r100) {
        this.retryForAccountCallbackDuration = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setBdTuringCallbackDuration(long r100) {
        this.turingCallbackDuration = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelDns(long r100) {
        this.dnsTime = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelPush(long r100) {
        this.pushTime = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelReceiveBody(long r100) {
        this.receiveTime = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelSend(long r100) {
        this.sendTime = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTCPConnect(long r100) {
        this.connectTime = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTTFB(long r100) {
        this.ttfbMs = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTls(long r100) {
        this.sslTime = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTotal(long r100) {
        this.totalTime = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setNetworkKernelRawRequestLog(String r100) {
        this.requestLog = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setRequestEnd(long r100) {
        this.requestEnd = r100;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setRequestEndAppResumeState(long r100) {
        this.requestEndAppResumeState = r100;
    }
}
