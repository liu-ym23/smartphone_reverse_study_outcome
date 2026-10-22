package com.bytedance.retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class RetrofitMetrics {
    private static volatile Handler HANDLER = null;
    private static HandlerThread HANDLER_THREAD = null;
    public static final int REPORT_ALL_DETAILS = -1;
    private static volatile AsyncLogReporter logReporter;
    public static AppLaunchTimeStampProvider sAppStartTimeProvider;
    private static volatile boolean sReportNewMetrics;
    private static IRequestLogReporterBridge sRequestLogReporterBridge;
    private static volatile boolean sSyncReport;
    public long addClientKeyDuration;
    public long addCommonParamDuration;
    public long appCreateRetrofitStart;
    public long appCreateRetrofitStartUpTime;
    public long appLevelRequestStart;
    public long asyncDelayCount;
    public long beforeAllInterceptors;
    public Map<String, Object> bizExtraInfo;
    public int blockingQueueSize;
    public long bodyEncryptDuration;
    public long callExecuteStartTime;
    public long callServerInterceptorTime;
    public long checkReqTicketDuration;
    public long commandListenerDuration;
    public JSONObject concurrentRequest;
    public long createSsHttpCallTime;
    public long delayStartTimeStamp;
    public int delayState;
    public String delayStateName;
    public boolean delayedWithState;
    public JSONArray dispatchQueryActionInfo;
    public long encryptRequestDuration;
    public long enqueueCallbackEndTime;
    public long enqueueCallbackStartTime;
    public long enqueueTime;
    public long executeCallEndTime;
    public long executeCallStartTime;
    public long executeEndTime;
    public long executeTime;
    public Map<String, Long> extra;
    public String fallbackMessage;
    public int fallbackReason;
    public long filterDupQueryDuration;
    public long filterUrlDuration;
    public long genReqTicketDuration;
    private boolean hasNetworkKernelLog;
    private boolean hasRetrofitLog;
    public List<InterceptorInfo> interceptorRequestInfos;
    public List<InterceptorInfo> interceptorResponseInfos;
    public transient Throwable interceptorResponseThrowable;
    public boolean isConcurrent;
    public boolean isResponseStreaming;
    public NetworkLibLayerMetrics networklib;
    public long openConnectionDuration;
    public int postBodyBufferSize;
    public long postCdnCacheVerifyDuration;
    public long preCdnCacheVerifyDuration;
    public long prepareRequestDuration;
    public int priorityLevel;
    public long queryFilterDuration;
    public long randomSendTime;
    private boolean readingResponseBody;
    public JSONObject requestCompressInfo;
    public String requestCompressType;
    public int requestCookieSourceType;
    private EncryptType requestEncryptType;
    public String requestFallbackMessage;
    public int requestFallbackReason;
    public transient WeakReference<LegacyLogRecorder> requestInfo;
    public Map<String, Long> requestInterceptDuration;
    public int requestPriorityLevel;
    public long requestVerifyDuration;
    public long responseChainTime;
    public String responseCompressType;
    public boolean responseConvertSuccess;
    public Map<String, Long> responseInterceptDuration;
    public int responseReadType;
    public RetrofitLayerMetrics retrofit;
    public long retrofitLogReportTime;
    public long retrofitMethodInvokeTime;
    public JSONObject rotationHostRetryInfo;
    public long setThrottleNetSpeedDuration;
    public long stateDelayTime;
    public int streamParserCopyCount;
    public long syncDelayCount;
    public long toRequestEndTime;
    public long toRequestStartTime;
    public long toResponseEndTime;
    public long toResponseStartTime;
    public String traceCode;
    public String transactionId;
    public long tryNecessaryInitDuration;
    public String ttnetVersion;
    public long updateClientKeyDuration;
    public long upperAddCookieDurationUs;
    public long upperSaveCookieDurationUs;
    public URL url;

    public static final enum EncryptType extends Enum<EncryptType> {
        private static final /* synthetic */ EncryptType[] $VALUES = null;
        public static final EncryptType ENCRYPT_BODY = null;
        public static final EncryptType ENCRYPT_BOTH_QUERY_AND_BODY = null;
        public static final EncryptType ENCRYPT_NONE = null;
        public static final EncryptType ENCRYPT_QUERY = null;
        final int type;

        static {
            EncryptType r100 = new EncryptType("ENCRYPT_NONE", 0, 0);
            ENCRYPT_NONE = r100;
            EncryptType r101 = new EncryptType("ENCRYPT_QUERY", 1, 1);
            ENCRYPT_QUERY = r101;
            EncryptType r102 = new EncryptType("ENCRYPT_BODY", 2, 2);
            ENCRYPT_BODY = r102;
            EncryptType r103 = new EncryptType("ENCRYPT_BOTH_QUERY_AND_BODY", 3, 3);
            ENCRYPT_BOTH_QUERY_AND_BODY = r103;
            $VALUES = new EncryptType[]{r100, r101, r102, r103};
        }

        public static EncryptType[] values() {
            return (EncryptType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.type;
        }

        public static EncryptType valueOf(String r100) {
            return (EncryptType) a.a(EncryptType.class, r100);
        }

        private EncryptType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public interface ExtraKeys {
        public static final String RECEIVED_BYTE_COUNT = "receivedByteCount";
        public static final String SENT_BYTE_COUNT = "sentByteCount";
        public static final String STREAM_READ_BYTE_COUNT = "streamReadByteCount";
        public static final String STREAM_READ_TIME = "streamReadTime";
    }

    public interface IRequestLogReporterBridge {
        boolean isAllErrorReport();

        void monitorApiError(String r100, Object r101, Throwable r102);

        void monitorApiOk(String r100, Object r101);
    }

    public class InterceptorInfo {
        public long end;
        public String exception_name;
        public String name;
        public long start;
        final /* synthetic */ RetrofitMetrics this$0;

        public InterceptorInfo(RetrofitMetrics r100, String r101, long r102) {
            this.this$0 = r100;
            this.exception_name = null;
            this.name = r101;
            this.start = r102;
            this.end = r102;
        }
    }

    public void markNetworkKernelLogCollected() {
        this.hasNetworkKernelLog = true;
        maybeReportRequestLog();
    }

    public void markRetrofitLayerLogCollected() {
        this.hasRetrofitLog = true;
        maybeReportRequestLog();
    }

    public void readResponseBodyEnd() {
        this.readingResponseBody = false;
        this.networklib.eventTs.latestReadResponseBodyEnd = System.nanoTime();
        NetworkLibLayerMetrics r100 = this.networklib;
        if (r100.misc.readResponseBodyInternal == false) goto L5;
        return;
    L5:
        NetworkLibLayerMetrics.ImportantInnerSpan r101 = r100.innerSpan;
        if (r101.readResponseBody != (-1)) goto L8;
        r101.readResponseBody = 0;
    L8:
        r101.readResponseBody += r101.computeDurationNs();
        if (isRetrofitRequestEnd() == false) goto L12;
        maybeReportRequestLog();
        return;
    }

    public void readResponseBodyStart() {
        this.readingResponseBody = true;
        NetworkLibLayerMetrics r100 = this.networklib;
        NetworkLibLayerMetrics.Misc r101 = r100.misc;
        if (r101.responseBodyReadTimes != (-1)) goto L5;
        r101.responseBodyReadTimes = 0;
    L5:
        r101.responseBodyReadTimes++;
        NetworkLibLayerMetrics.EventTimestamp r102 = r100.eventTs;
        if (r102.firstReadResponseBodyStart != (-1)) goto L8;
        r102.firstReadResponseBodyStart = System.nanoTime();
    L8:
        NetworkLibLayerMetrics r103 = this.networklib;
        if (r103.misc.readResponseBodyInternal == false) goto L11;
        return;
    L11:
        NetworkLibLayerMetrics.BizSpan r104 = r103.bizSpan;
        if (r104.waitReadResponseBody != (-1)) goto L19;
        long r105 = this.retrofit.eventTs.bizReceiveResponseHeader;
        if (r105 == (-1)) goto L19;
        long r106 = r103.eventTs.firstReadResponseBodyStart;
        if (r106 <= r105) goto L19;
        r104.waitReadResponseBody = r106 - r105;
    L19:
        if (r103.eventTs.latestReadResponseBodyEnd != (-1)) goto L21;
    L24:
        this.networklib.innerSpan.recordInnerSpanStart();
        return;
    L21:
        if (r104.readResponseBodyInterval != (-1)) goto L23;
        r104.readResponseBodyInterval = 0;
    L23:
        r104.readResponseBodyInterval += System.nanoTime() - this.networklib.eventTs.latestReadResponseBodyEnd;
        goto L24
    }

    private JSONObject getBaseTimingInfo() {
        JSONObject r100 = new JSONObject();
        r100.put("fallback", this.fallbackReason);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.fallbackMessage) == true) goto L6;
        r100.put("fallbackMessage", this.fallbackMessage);     // Catch: JSONException -> L23
    L6:
        r100.put("reqFallback", this.requestFallbackReason);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.requestFallbackMessage) == true) goto L9;
        r100.put("reqFallbackMsg", this.requestFallbackMessage);     // Catch: JSONException -> L23
    L9:
        r100.put("createRetrofitTime", this.appCreateRetrofitStart);     // Catch: JSONException -> L23
        r100.put("appRequestStartTime", this.appLevelRequestStart);     // Catch: JSONException -> L23
        r100.put("beforeAllInterceptTime", this.beforeAllInterceptors);     // Catch: JSONException -> L23
        r100.put("callServerInterceptTime", this.callServerInterceptorTime);     // Catch: JSONException -> L23
        r100.put("callExecuteStartTime", this.callExecuteStartTime);     // Catch: JSONException -> L23
        r100.put("reportTime", this.retrofitLogReportTime);     // Catch: JSONException -> L23
        EncryptType r101 = this.requestEncryptType;     // Catch: JSONException -> L23
        if (r101 == EncryptType.ENCRYPT_NONE) goto L13;
        r100.put(LBSLightLocationTraceLogger.ENCRYPT, r101.getValue());     // Catch: JSONException -> L23
    L13:
        if (TextUtils.isEmpty(this.transactionId) == true) goto L15;
        r100.put("transactionId", this.transactionId);     // Catch: JSONException -> L23
    L15:
        long r102 = this.upperAddCookieDurationUs;     // Catch: JSONException -> L23
        if (r102 < 0) goto L18;
        r100.put("upper_add_cookie_us", r102);     // Catch: JSONException -> L23
    L18:
        long r103 = this.upperSaveCookieDurationUs;     // Catch: JSONException -> L23
        if (r103 < 0) goto L21;
        r100.put("upper_save_cookie_us", r103);     // Catch: JSONException -> L23
    L21:
        r100.put("request_cookie_source", this.requestCookieSourceType);     // Catch: JSONException -> L23
    L25:
        boolean r104 = validateAndSetTimingValue(r100, "loadServiceMethod", this.retrofitMethodInvokeTime, this.createSsHttpCallTime, true);
        long r105 = this.enqueueTime;
        if (r105 <= 0) goto L28;
        boolean r106 = validateAndSetTimingValue(r100, "enqueueWait", r105, this.responseChainTime, r104);
    L29:
        boolean r107 = r106;
        RetrofitLayerMetrics.EventTimestamp r108 = this.retrofit.eventTs;
        validateAndSetTimingValue(r100, "biz_start_after_cronet_start", r108.cronetInitStart / 1000, r108.ssHttpCallApiStart / 1000, true);
        RetrofitLayerMetrics.EventTimestamp r109 = this.retrofit.eventTs;
        validateAndSetTimingValue(r100, "biz_start_before_cronet_end", r109.ssHttpCallApiEnd / 1000, r109.cronetInitEnd / 1000, true);
        boolean r110 = validateAndSetTimingValue(r100, "executeCall", this.executeCallStartTime, this.executeCallEndTime, r107);
        boolean r111 = validateAndSetTimingValue(r100, "requestParse", this.toRequestStartTime, this.toRequestEndTime, r110);
        validateAndSetTimingValue(r100, "responseParse", this.toResponseStartTime, this.toResponseEndTime, r111);
        return r100;
    L28:
        r106 = validateAndSetTimingValue(r100, "executeWait", this.executeTime, this.responseChainTime, r104);
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    private Map<String, Object> getBizExtraInfoSnapshot() {
        Map<String, Object> r100 = this.bizExtraInfo;
        if (r100 != null) goto L5;
    L22:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L22;
        int r101 = 0;
    L9:
        if (r101 >= 3) goto L22;
        monitor-enter(r100);     // Catch: ConcurrentModificationException -> L17
        HashMap r102 = new HashMap(r100);     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
    L13:
        return r102;
    L14:
        th = move-exception;
        throw th;     // Catch: ConcurrentModificationException -> L17
    L17:
        e = move-exception;
        if (r101 != 2) goto L21;
        Logger.w("RetrofitMetrics", "Failed to snapshot bizExtraInfo.", e);
    L21:
        r101 = r101 + 1;
        goto L9
    }

    private JSONObject getCallbackTimingInfo() {
        JSONObject r100 = new JSONObject();
        r100.put("filterUrl", this.filterUrlDuration);     // Catch: JSONException -> L8
        r100.put("addCommonParam", this.addCommonParamDuration);     // Catch: JSONException -> L8
        r100.put("requestVerify", this.requestVerifyDuration);     // Catch: JSONException -> L8
        r100.put("encryptRequest", this.encryptRequestDuration);     // Catch: JSONException -> L8
        r100.put("genReqTicket", this.genReqTicketDuration);     // Catch: JSONException -> L8
        r100.put("checkReqTicket", this.checkReqTicketDuration);     // Catch: JSONException -> L8
        r100.put("preCdnVerify", this.preCdnCacheVerifyDuration);     // Catch: JSONException -> L8
        r100.put("postCdnVerify", this.postCdnCacheVerifyDuration);     // Catch: JSONException -> L8
        r100.put("addClientKey", this.addClientKeyDuration);     // Catch: JSONException -> L8
        r100.put("updateClientKey", this.updateClientKeyDuration);     // Catch: JSONException -> L8
        r100.put("commandListener", this.commandListenerDuration);     // Catch: JSONException -> L8
        r100.put("filterDupQuery", this.filterDupQueryDuration);     // Catch: JSONException -> L8
        r100.put("queryFilter", this.queryFilterDuration);     // Catch: JSONException -> L8
        long r101 = this.bodyEncryptDuration;     // Catch: JSONException -> L8
        if (r101 < 0) goto L6;
        r100.put("bodyEncrypt", r101);     // Catch: JSONException -> L8
    L6:
        r100.put("setSpeed", this.setThrottleNetSpeedDuration);     // Catch: JSONException -> L8
        r100.put("tryInit", this.tryNecessaryInitDuration);     // Catch: JSONException -> L8
        r100.put("openConn", this.openConnectionDuration);     // Catch: JSONException -> L8
        r100.put("prepareReq", this.prepareRequestDuration);     // Catch: JSONException -> L8
    L10:
        return r100;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private JSONObject getInterceptorTimingInfo() {
        JSONObject r100 = new JSONObject();
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        return r100;
    L4:
        if (this.requestInterceptDuration.isEmpty() == true) goto L11;
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L18
        Iterator<Map.Entry<String, Long>> r102 = this.requestInterceptDuration.entrySet().iterator();     // Catch: JSONException -> L18
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, Long> r103 = r102.next();     // Catch: JSONException -> L18
        r101.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L18
        goto L7
    L9:
        r100.put("request", r101);     // Catch: JSONException -> L18
    L11:
        if (this.responseInterceptDuration.isEmpty() == true) goto L20;
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L18
        Iterator<Map.Entry<String, Long>> r105 = this.responseInterceptDuration.entrySet().iterator();     // Catch: JSONException -> L18
    L14:
        if (r105.hasNext() == false) goto L16;
        Map.Entry<String, Long> r106 = r105.next();     // Catch: JSONException -> L18
        r104.put(r106.getKey(), r106.getValue());     // Catch: JSONException -> L18
        goto L14
    L16:
        r100.put("response", r104);     // Catch: JSONException -> L18
        goto L20
    }

    private JSONObject getModelInfoWhenFallback() {
        JSONObject r100 = new JSONObject();
        r100.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, Build.MODEL);     // Catch: JSONException -> L10
        String r101 = "";
        String[] r102 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L10
        if (r102 != null) goto L6;
    L8:
        r100.put("abis", r101);     // Catch: JSONException -> L10
    L12:
        return r100;
    L6:
        if (r102.length <= 0) goto L8;
        r101 = Arrays.asList(r102).toString();     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private boolean isRetrofitRequestEnd() {
        if (this.retrofit.eventTs.requestEnd == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void maybeReportRequestLog() {
        if (this.hasRetrofitLog == true) goto L5;
        return;
    L5:
        if (this.hasNetworkKernelLog == false) goto L48;
        requestEnd();
        if (this.readingResponseBody == false) goto L10;
        return;
    L10:
        setRequestEndAppResumeState(AppActivityResumeSuspendRecorder.GetAppActivityResumeState());
        if (sRequestLogReporterBridge == null) goto L44;
        WeakReference<LegacyLogRecorder> r100 = this.requestInfo;
        if (r100 != null) goto L15;
        return;
    L15:
        if (r100.get() == null) goto L49;
        final LegacyLogRecorder r101 = this.requestInfo.get();
        WeakReference<Throwable> r102 = this.retrofit.misc.requestException;
        if (r102 == null) goto L20;
        final Throwable r103 = r102.get();
    L22:
        if (sSyncReport == false) goto L25;
        doReportRequestLog(r101, r103);
        return;
    L25:
        if (logReporter == null) goto L28;
        logReporter.postDelayed(new AnonymousClass1(this, r101, r103), 100);
        return;
    L28:
        if (HANDLER == null) goto L30;
    L39:
        HANDLER.postDelayed(new AnonymousClass2(this, r101, r103), 100);
        return;
    L30:
        monitor-enter(RetrofitMetrics.class);
    L36:
        th = move-exception;
        throw th;
    L32:
        if (HANDLER != null) goto L34;
        PthreadHandlerThreadV2 r104 = new PthreadHandlerThreadV2("TTNet-Log-Report");     // Catch: Throwable -> L36
        HANDLER_THREAD = r104;     // Catch: Throwable -> L36
        ThreadMethodProxy.start(r104);     // Catch: Throwable -> L36
        HANDLER = new Handler(HANDLER_THREAD.getLooper());     // Catch: Throwable -> L36
    L34:
        monitor-exit(RetrofitMetrics.class);     // Catch: Throwable -> L36
        goto L39
    L20:
        r103 = null;
        goto L22
    L49:
        return;
    L44:
        return;
    }

    public void ResetNetworkLibMetrics() {
        this.networklib = new NetworkLibLayerMetrics();
    }

    public void accountRetryEnd() {
        NetworkLibLayerMetrics.BizSpan r100 = this.networklib.bizSpan;
        r100.accountRetryDuration = r100.computeDurationNs();
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setAccountRetryCallbackDuration(TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.bizSpan.accountRetryDuration));
        return;
    }

    public void accountRetryStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void addClientKeyEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r100 = this.retrofit.innerSpan;
        r100.addClientKey = r100.computeDurationNs();
        this.addClientKeyDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.innerSpan.addClientKey);
    }

    public void addClientKeyStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
    }

    public void addCommonParamEnd() {
        RetrofitLayerMetrics.BizSpan r100 = this.retrofit.bizSpan;
        r100.addCommonParam = r100.computeDurationNs();
        this.addCommonParamDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.addCommonParam);
    }

    public void addCommonParamStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void bdTuringEnd() {
        NetworkLibLayerMetrics.BizSpan r100 = this.networklib.bizSpan;
        r100.bdTuringDuration = r100.computeDurationNs();
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setBdTuringCallbackDuration(TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.bizSpan.bdTuringDuration));
        return;
    }

    public void bdTuringStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void bizInvokeRetrofitRequestInterfaceEnd() {
        RetrofitLayerMetrics.EventTimestamp r100 = this.retrofit.eventTs;
        r100.bizInvokeRetrofitRequestInterfaceEnd = System.nanoTime();
    }

    public void bizReceiveResponseHeader() {
        RetrofitLayerMetrics.EventTimestamp r100 = this.retrofit.eventTs;
        r100.bizReceiveResponseHeaderTime = System.currentTimeMillis();
        RetrofitLayerMetrics.EventTimestamp r101 = this.retrofit.eventTs;
        r101.bizReceiveResponseHeader = System.nanoTime();
    }

    public void bodyEncryptEnd() {
        NetworkLibLayerMetrics.BizSpan r100 = this.networklib.bizSpan;
        r100.bodyEncrypt = r100.computeDurationNs();
        this.bodyEncryptDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.bizSpan.bodyEncrypt);
    }

    public void bodyEncryptStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void callServerInterceptorStart() {
        this.retrofit.misc.callServerExecutedTimes++;
        this.callServerInterceptorTime = SystemClock.uptimeMillis();
    }

    public void checkReqTicketEnd() {
        RetrofitLayerMetrics.BizSpan r100 = this.retrofit.bizSpan;
        r100.checkReqTicket = r100.computeDurationNs();
        this.checkReqTicketDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.checkReqTicket);
    }

    public void checkReqTicketStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public RetrofitMetrics cloneMetrics() {
        RetrofitMetrics r100 = new RetrofitMetrics();
        r100.appCreateRetrofitStartUpTime = this.appCreateRetrofitStartUpTime;
        r100.appCreateRetrofitStart = this.appLevelRequestStart;
        r100.retrofitMethodInvokeTime = this.retrofitMethodInvokeTime;
        r100.createSsHttpCallTime = this.createSsHttpCallTime;
        r100.isResponseStreaming = this.isResponseStreaming;
        RetrofitLayerMetrics r101 = r100.retrofit;
        RetrofitLayerMetrics.EventTimestamp r102 = r101.eventTs;
        RetrofitLayerMetrics r103 = this.retrofit;
        RetrofitLayerMetrics.EventTimestamp r104 = r103.eventTs;
        r102.bizInvokeRetrofitRequestInterfaceStartTime = r104.bizInvokeRetrofitRequestInterfaceStartTime;
        r102.bizInvokeRetrofitRequestInterfaceStart = r104.bizInvokeRetrofitRequestInterfaceStart;
        r102.bizInvokeRetrofitRequestInterfaceEnd = r104.bizInvokeRetrofitRequestInterfaceEnd;
        RetrofitLayerMetrics.ImportantInnerSpan r105 = r101.innerSpan;
        RetrofitLayerMetrics.ImportantInnerSpan r106 = r103.innerSpan;
        r105.createRequestFactory = r106.createRequestFactory;
        r105.createHttpServiceMethod = r106.createHttpServiceMethod;
        return r100;
    }

    public void commandListenerEnd() {
        RetrofitLayerMetrics.BizSpan r100 = this.retrofit.bizSpan;
        r100.commandListener = r100.computeDurationNs();
        this.commandListenerDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.commandListener);
    }

    public void commandListenerStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void createHttpServiceMethodEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r100 = this.retrofit.innerSpan;
        r100.createHttpServiceMethod = r100.computeDurationNs();
    }

    public void createHttpServiceMethodStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
        this.createSsHttpCallTime = SystemClock.uptimeMillis();
    }

    public void createRequestFactoryEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r100 = this.retrofit.innerSpan;
        r100.createRequestFactory = r100.computeDurationNs();
    }

    public void createRequestFactoryStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
        this.retrofitMethodInvokeTime = SystemClock.uptimeMillis();
    }

    public RetrofitMetrics deepCopy() {
        RetrofitMetrics r100 = new RetrofitMetrics();
        copyTo(r100);
        return r100;
    }

    public void encryptRequestEnd() {
        RetrofitLayerMetrics.BizSpan r100 = this.retrofit.bizSpan;
        r100.encryptRequest = r100.computeDurationNs();
        this.encryptRequestDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.encryptRequest);
    }

    public void encryptRequestStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void enqueueCallbackEnd() {
        RetrofitLayerMetrics.BizSpan r100 = this.retrofit.bizSpan;
        r100.enqueueCallback = r100.computeDurationNs();
        this.enqueueCallbackEndTime = SystemClock.uptimeMillis();
    }

    public void enqueueCallbackStart() {
        this.retrofit.bizSpan.recordCallbackStart();
        this.enqueueCallbackStartTime = SystemClock.uptimeMillis();
    }

    public void executeSsCallEnd() {
        RetrofitLayerMetrics.EventTimestamp r100 = this.retrofit.eventTs;
        r100.executeSsCallEnd = System.nanoTime();
        this.executeCallEndTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.executeSsCallEnd);
    }

    public void executeSsCallStart() {
        RetrofitLayerMetrics.EventTimestamp r100 = this.retrofit.eventTs;
        r100.executeSsCallStart = System.nanoTime();
        this.executeCallStartTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.executeSsCallStart);
        this.callExecuteStartTime = ConvertToWallClockTimeMs(this.retrofit.eventTs.executeSsCallStart);
    }

    public void filterDupQueryEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r100 = this.retrofit.innerSpan;
        r100.filterDupQuery = r100.computeDurationNs();
        this.filterDupQueryDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.innerSpan.filterDupQuery);
    }

    public void filterDupQueryStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
    }

    public void filterUrlEnd() {
        RetrofitLayerMetrics.BizSpan r100 = this.retrofit.bizSpan;
        r100.filterUrl = r100.computeDurationNs();
        this.filterUrlDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.filterUrl);
    }

    public void filterUrlStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void genReqTicketEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r100 = this.retrofit.innerSpan;
        r100.genReqTicket = r100.computeDurationNs();
        this.genReqTicketDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.innerSpan.genReqTicket);
    }

    public void genReqTicketStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
    }

    public JSONObject getRealChainInterceptorTimingInfo() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        Iterator<InterceptorInfo> r103 = this.interceptorRequestInfos.iterator();     // Catch: JSONException -> L13
    L5:
        if (r103.hasNext() == false) goto L7;
        InterceptorInfo r104 = r103.next();     // Catch: JSONException -> L13
        r100.put(r104.name, r104.end - r104.start);     // Catch: JSONException -> L13
        goto L5
    L7:
        Iterator<InterceptorInfo> r105 = this.interceptorResponseInfos.iterator();     // Catch: JSONException -> L13
    L9:
        if (r105.hasNext() == false) goto L11;
        InterceptorInfo r106 = r105.next();     // Catch: JSONException -> L13
        r101.put(r106.name, r106.end - r106.start);     // Catch: JSONException -> L13
        goto L9
    L11:
        r102.put("interceptorRequestInfo", r100);     // Catch: JSONException -> L13
        r102.put("interceptorResponseInfo", r101);     // Catch: JSONException -> L13
    L15:
        return r102;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public String getRetrofitLog() {
        JSONObject r100 = new JSONObject();
    L39:
        e = move-exception;
        e.printStackTrace();
    L42:
        return r100.toString();
    L4:
        if (this.fallbackReason == (-1)) goto L6;
        r100.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, getModelInfoWhenFallback());     // Catch: JSONException -> L39
    L6:
        JSONObject r101 = this.concurrentRequest;     // Catch: JSONException -> L39
        if (r101 == null) goto L9;
        r100.put("concurrentRequest", r101);     // Catch: JSONException -> L39
    L9:
        r100.put("concurrent", this.isConcurrent);     // Catch: JSONException -> L39
        r100.put("base", getBaseTimingInfo());     // Catch: JSONException -> L39
        r100.put("callback", getCallbackTimingInfo());     // Catch: JSONException -> L39
        r100.put("interceptor", getInterceptorTimingInfo());     // Catch: JSONException -> L39
        r100.put("ttnetVersion", this.ttnetVersion);     // Catch: JSONException -> L39
        JSONArray r102 = this.dispatchQueryActionInfo;     // Catch: JSONException -> L39
        if (r102 != null) goto L12;
    L14:
        JSONObject r103 = this.requestCompressInfo;     // Catch: JSONException -> L39
        if (r103 == null) goto L17;
        r100.put(VideoTools.ERROR_TYPE_COMPRESS, r103);     // Catch: JSONException -> L39
    L17:
        int r104 = this.postBodyBufferSize;     // Catch: JSONException -> L39
        if (r104 <= 0) goto L20;
        r100.put("postBufferSize", r104);     // Catch: JSONException -> L39
    L20:
        int r105 = this.blockingQueueSize;     // Catch: JSONException -> L39
        if (r105 <= 0) goto L23;
        r100.put("blockingQueueSize", r105);     // Catch: JSONException -> L39
    L23:
        long r106 = this.networklib.misc.responseBodyReadTimes;     // Catch: JSONException -> L39
        if (r106 <= 0) goto L26;
        r100.put("apiStreamReadCount", r106);     // Catch: JSONException -> L39
    L26:
        r100.put("stateDelayed", this.delayedWithState);     // Catch: JSONException -> L39
        r100.put("stateDelayTime", this.stateDelayTime);     // Catch: JSONException -> L39
        r100.put("syncCount", this.syncDelayCount);     // Catch: JSONException -> L39
        r100.put("asyncCount", this.asyncDelayCount);     // Catch: JSONException -> L39
        r100.put("delayState", this.delayState);     // Catch: JSONException -> L39
        r100.put("random", this.randomSendTime);     // Catch: JSONException -> L39
        if (TextUtils.isEmpty(this.delayStateName) == true) goto L30;
        r100.put("stateName", this.delayStateName);     // Catch: JSONException -> L39
    L30:
        if (this.addClientKeyDuration < 0) goto L32;
        r100.put("cli_key", true);     // Catch: JSONException -> L39
    L32:
        int r107 = this.streamParserCopyCount;     // Catch: JSONException -> L39
        if (r107 < 0) goto L35;
        r100.put("cp_cnt", r107);     // Catch: JSONException -> L39
    L35:
        int r108 = this.responseReadType;     // Catch: JSONException -> L39
        if (r108 < 0) goto L42;
        r100.put("read_type", r108);     // Catch: JSONException -> L39
        goto L42
    L12:
        if (r102.length() <= 0) goto L14;
        r100.put("actionInfo", this.dispatchQueryActionInfo);     // Catch: JSONException -> L39
        goto L14
    }

    public void inputStreamProcessEnd() {
        NetworkLibLayerMetrics.BizSpan r100 = this.networklib.bizSpan;
        r100.inputStreamProcessDuration = r100.computeDurationNs();
    }

    public void inputStreamProcessStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void logReport() {
        RetrofitLayerMetrics.EventTimestamp r100 = this.retrofit.eventTs;
        r100.logReport = System.nanoTime();
        this.retrofitLogReportTime = ConvertToWallClockTimeMs(this.retrofit.eventTs.logReport);
    }

    public void markReadResponseBodyInternal() {
        this.networklib.misc.readResponseBodyInternal = true;
    }

    public void monitorApiHttpAfterFilterEnd() {
        RetrofitLayerMetrics.BizSpan r100 = this.retrofit.bizSpan;
        r100.monitorApiHttpAfterFilter = r100.computeDurationNs();
    }

    public void monitorApiHttpAfterFilterStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void monitorApiHttpBeforeFilterEnd() {
        RetrofitLayerMetrics.BizSpan r100 = this.retrofit.bizSpan;
        r100.monitorApiHttpBeforeFilter = r100.computeDurationNs();
    }

    public void monitorApiHttpBeforeFilterStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void onTryInitEnd() {
        NetworkLibLayerMetrics.BizSpan r100 = this.networklib.bizSpan;
        r100.onTryInit = r100.computeDurationNs();
        if (this.tryNecessaryInitDuration != (-1)) goto L5;
        this.tryNecessaryInitDuration = 0;
    L5:
        this.tryNecessaryInitDuration += TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.bizSpan.onTryInit);
    }

    public void onTryInitStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void postCdnCacheVerifyEnd() {
        RetrofitLayerMetrics.BizSpan r100 = this.retrofit.bizSpan;
        r100.postCdnCacheVerify = r100.computeDurationNs();
        this.postCdnCacheVerifyDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.postCdnCacheVerify);
    }

    public void postCdnCacheVerifyStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void postProcessBodyEnd() {
        NetworkLibLayerMetrics.ImportantInnerSpan r100 = this.networklib.innerSpan;
        r100.postProcessBody = r100.computeDurationNs();
    }

    public void postProcessBodyStart() {
        this.networklib.innerSpan.recordInnerSpanStart();
    }

    public void preCdnCacheVerifyEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r100 = this.retrofit.innerSpan;
        r100.preCdnCacheVerify = r100.computeDurationNs();
        this.preCdnCacheVerifyDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.innerSpan.preCdnCacheVerify);
    }

    public void preCdnCacheVerifyStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
    }

    public void prepareConnectionEnd() {
        NetworkLibLayerMetrics.EventTimestamp r100 = this.networklib.eventTs;
        r100.prepareConnectionEnd = System.nanoTime();
    }

    public void prepareConnectionStart() {
        NetworkLibLayerMetrics.EventTimestamp r100 = this.networklib.eventTs;
        r100.prepareConnectionStart = System.nanoTime();
    }

    public void processResponseBodyEnd() {
        NetworkLibLayerMetrics.EventTimestamp r100 = this.networklib.eventTs;
        r100.processResponseBodyEnd = System.nanoTime();
        NetworkLibLayerMetrics.ImportantInnerSpan r101 = this.networklib.innerSpan;
        r101.processResponseBody = r101.computeDurationNs();
    }

    public void processResponseBodyStart() {
        NetworkLibLayerMetrics.EventTimestamp r100 = this.networklib.eventTs;
        r100.processResponseBodyStart = System.nanoTime();
        this.networklib.innerSpan.recordInnerSpanStart();
    }

    public void queryFilterEnd() {
        NetworkLibLayerMetrics.ImportantInnerSpan r100 = this.networklib.innerSpan;
        r100.queryFilter = r100.computeDurationNs();
        this.queryFilterDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.innerSpan.queryFilter);
    }

    public void queryFilterStart() {
        this.networklib.innerSpan.recordInnerSpanStart();
    }

    public void recordInterceptorRequestEnd() {
        if (this.interceptorRequestInfos.size() > 0) goto L5;
        return;
    L5:
        List<InterceptorInfo> r100 = this.interceptorRequestInfos;
        ((InterceptorInfo) ListProtector.get(r100, r100.size() - 1)).end = SystemClock.uptimeMillis();
    }

    public void requestAuditEnd() {
        NetworkLibLayerMetrics.BizSpan r100 = this.networklib.bizSpan;
        r100.requestAuditDuration = r100.computeDurationNs();
    }

    public void requestAuditStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void requestEnd() {
        RetrofitLayerMetrics.EventTimestamp r100 = this.retrofit.eventTs;
        r100.requestEnd = System.nanoTime();
        RetrofitLayerMetrics.EventTimestamp r101 = this.retrofit.eventTs;
        r101.requestEndTime = System.currentTimeMillis();
        WeakReference<LegacyLogRecorder> r102 = this.requestInfo;
        if (r102 == null) goto L6;
        r102.get().setRequestEnd(this.retrofit.eventTs.requestEndTime);
        return;
    }

    public void requestVerifyEnd() {
        RetrofitLayerMetrics.BizSpan r100 = this.retrofit.bizSpan;
        r100.requestVerify = r100.computeDurationNs();
        this.requestVerifyDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.bizSpan.requestVerify);
    }

    public void requestVerifyStart() {
        this.retrofit.bizSpan.recordCallbackStart();
    }

    public void rotationRetryEnd() {
        NetworkLibLayerMetrics.BizSpan r100 = this.networklib.bizSpan;
        if (r100.rotationRetryAccumulatedDuration != (-1)) goto L5;
        r100.rotationRetryAccumulatedDuration = 0;
    L5:
        r100.rotationRetryAccumulatedDuration += r100.computeDurationNs();
    }

    public void rotationRetryStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void ssHttpCallApiEnd() {
        RetrofitLayerMetrics.EventTimestamp r100 = this.retrofit.eventTs;
        r100.ssHttpCallApiEnd = System.nanoTime();
        this.executeEndTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.ssHttpCallApiEnd);
    }

    public void toRequestEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r100 = this.retrofit.innerSpan;
        r100.toRequest = r100.computeDurationNs();
        RetrofitLayerMetrics.EventTimestamp r101 = this.retrofit.eventTs;
        r101.toRequestEnd = System.nanoTime();
        this.toRequestEndTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.toRequestEnd);
    }

    public void toRequestStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
        RetrofitLayerMetrics.EventTimestamp r100 = this.retrofit.eventTs;
        r100.toRequestStart = System.nanoTime();
        this.toRequestStartTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.toRequestStart);
    }

    public void toSsResponseEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r100 = this.retrofit.innerSpan;
        r100.toSsResponse = r100.computeDurationNs();
        this.toResponseEndTime = SystemClock.uptimeMillis();
    }

    public void toSsResponseStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
        this.toResponseStartTime = SystemClock.uptimeMillis();
    }

    public void tryInitCookieManagerEnd() {
        NetworkLibLayerMetrics.BizSpan r100 = this.networklib.bizSpan;
        r100.tryInitCookieManager = r100.computeDurationNs();
        if (this.tryNecessaryInitDuration != (-1)) goto L5;
        this.tryNecessaryInitDuration = 0;
    L5:
        this.tryNecessaryInitDuration += TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.bizSpan.tryInitCookieManager);
    }

    public void tryInitCookieManagerStart() {
        this.networklib.bizSpan.recordCallbackStart();
    }

    public void updateClientKeyEnd() {
        RetrofitLayerMetrics.ImportantInnerSpan r100 = this.retrofit.innerSpan;
        r100.updateClientKey = r100.computeDurationNs();
        this.updateClientKeyDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.innerSpan.updateClientKey);
    }

    public void updateClientKeyStart() {
        this.retrofit.innerSpan.recordInnerSpanStart();
    }

    public RetrofitMetrics() {
        this.url = null;
        this.requestInfo = null;
        this.streamParserCopyCount = -1;
        this.responseReadType = -1;
        this.requestEncryptType = EncryptType.ENCRYPT_NONE;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestFallbackReason = -1;
        this.requestFallbackMessage = "";
        this.transactionId = "";
        this.isConcurrent = false;
        this.delayState = -1;
        this.delayStateName = null;
        this.stateDelayTime = -1;
        this.syncDelayCount = -1;
        this.asyncDelayCount = -1;
        this.delayStartTimeStamp = -1;
        this.randomSendTime = -1;
        this.interceptorResponseThrowable = null;
        this.requestInterceptDuration = new ConcurrentHashMap();
        this.responseInterceptDuration = new ConcurrentHashMap();
        this.filterUrlDuration = -1;
        this.addCommonParamDuration = -1;
        this.requestVerifyDuration = -1;
        this.filterDupQueryDuration = -1;
        this.encryptRequestDuration = -1;
        this.genReqTicketDuration = -1;
        this.checkReqTicketDuration = -1;
        this.preCdnCacheVerifyDuration = -1;
        this.addClientKeyDuration = -1;
        this.updateClientKeyDuration = -1;
        this.postCdnCacheVerifyDuration = -1;
        this.commandListenerDuration = -1;
        this.queryFilterDuration = -1;
        this.bodyEncryptDuration = -1;
        this.extra = new HashMap();
        this.ttnetVersion = "";
        this.traceCode = "";
        this.responseConvertSuccess = true;
        this.priorityLevel = -999;
        this.requestPriorityLevel = -1;
        this.responseCompressType = "";
        this.requestCompressType = "";
        this.setThrottleNetSpeedDuration = -1;
        this.tryNecessaryInitDuration = -1;
        this.openConnectionDuration = -1;
        this.prepareRequestDuration = -1;
        this.upperAddCookieDurationUs = -1;
        this.upperSaveCookieDurationUs = -1;
        this.requestCookieSourceType = -1;
        this.bizExtraInfo = Collections.synchronizedMap(new HashMap());
        this.rotationHostRetryInfo = null;
        this.blockingQueueSize = 0;
        this.interceptorRequestInfos = new ArrayList();
        this.interceptorResponseInfos = new ArrayList();
        this.retrofit = new RetrofitLayerMetrics();
        this.networklib = new NetworkLibLayerMetrics();
        this.readingResponseBody = false;
        this.hasNetworkKernelLog = false;
        this.hasRetrofitLog = false;
        new RetrofitMetrics(null);
    }

    public long configureConnectionStart() {
        return System.nanoTime();
    }

    public long constructConnectionStart() {
        return System.nanoTime();
    }

    public long executeConnectionStart() {
        long r100 = System.nanoTime();
        this.networklib.eventTs.executeConnectionStart = r100;
        return r100;
    }

    public void lowestInterceptorRequestEnd() {
        long r100 = System.nanoTime();
        RetrofitLayerMetrics r101 = this.retrofit;
        r101.eventTs.requestInterceptorEnd = r100;
        InterceptorRecorder.LogEntry r102 = r101.interceptorRecorder.peek();
        if (r102 == null) goto L6;
        r102.reqEndNs = r100;
        return;
    }

    public void lowestInterceptorResponseStart() {
        long r100 = System.nanoTime();
        RetrofitLayerMetrics r101 = this.retrofit;
        r101.eventTs.responseInterceptorStart = r100;
        InterceptorRecorder.LogEntry r102 = r101.interceptorRecorder.peek();
        if (r102 == null) goto L6;
        r102.rspStartNs = r100;
        return;
    }

    public void requestRealStart() {
        long r100 = System.nanoTime();
        RetrofitLayerMetrics r101 = this.retrofit;
        RetrofitLayerMetrics.EventTimestamp r102 = r101.eventTs;
        r102.requestRealStart = r100;
        RetrofitLayerMetrics.ImportantInnerSpan r103 = r101.innerSpan;
        long r104 = r102.ssHttpCallApiStart;
        long r105 = r100 - r104;
        r103.reqDelay = r105;
        if (r102.toRequestStart <= r104) goto L8;
        long r106 = r103.toRequest;
        if (r106 == (-1)) goto L9;
        r103.reqDelay = r105 - r106;
        return;
    L9:
        return;
    }

    public static boolean getReportNewMetrics() {
        return sReportNewMetrics;
    }

    public EncryptType getEncryptType() {
        return this.requestEncryptType;
    }

    public RetrofitMetrics(LegacyLogRecorder r100) {
        this.url = null;
        this.requestInfo = null;
        this.streamParserCopyCount = -1;
        this.responseReadType = -1;
        this.requestEncryptType = EncryptType.ENCRYPT_NONE;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestFallbackReason = -1;
        this.requestFallbackMessage = "";
        this.transactionId = "";
        this.isConcurrent = false;
        this.delayState = -1;
        this.delayStateName = null;
        this.stateDelayTime = -1;
        this.syncDelayCount = -1;
        this.asyncDelayCount = -1;
        this.delayStartTimeStamp = -1;
        this.randomSendTime = -1;
        this.interceptorResponseThrowable = null;
        this.requestInterceptDuration = new ConcurrentHashMap();
        this.responseInterceptDuration = new ConcurrentHashMap();
        this.filterUrlDuration = -1;
        this.addCommonParamDuration = -1;
        this.requestVerifyDuration = -1;
        this.filterDupQueryDuration = -1;
        this.encryptRequestDuration = -1;
        this.genReqTicketDuration = -1;
        this.checkReqTicketDuration = -1;
        this.preCdnCacheVerifyDuration = -1;
        this.addClientKeyDuration = -1;
        this.updateClientKeyDuration = -1;
        this.postCdnCacheVerifyDuration = -1;
        this.commandListenerDuration = -1;
        this.queryFilterDuration = -1;
        this.bodyEncryptDuration = -1;
        this.extra = new HashMap();
        this.ttnetVersion = "";
        this.traceCode = "";
        this.responseConvertSuccess = true;
        this.priorityLevel = -999;
        this.requestPriorityLevel = -1;
        this.responseCompressType = "";
        this.requestCompressType = "";
        this.setThrottleNetSpeedDuration = -1;
        this.tryNecessaryInitDuration = -1;
        this.openConnectionDuration = -1;
        this.prepareRequestDuration = -1;
        this.upperAddCookieDurationUs = -1;
        this.upperSaveCookieDurationUs = -1;
        this.requestCookieSourceType = -1;
        this.bizExtraInfo = Collections.synchronizedMap(new HashMap());
        this.rotationHostRetryInfo = null;
        this.blockingQueueSize = 0;
        this.interceptorRequestInfos = new ArrayList();
        this.interceptorResponseInfos = new ArrayList();
        this.retrofit = new RetrofitLayerMetrics();
        this.networklib = new NetworkLibLayerMetrics();
        this.readingResponseBody = false;
        this.hasNetworkKernelLog = false;
        this.hasRetrofitLog = false;
        this.requestInfo = new WeakReference(r100);
    }

    private void appendBizCustomTrack(JSONObject r100) throws JSONException {
        Map<String, Object> r101 = getBizExtraInfoSnapshot();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L28;
        JSONObject r102 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r103 = r101.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L16;
        Map.Entry<String, Object> r104 = r103.next();
        Object r105 = r104.getValue();
        if (TextUtils.isEmpty(r104.getKey()) == true) goto L9;
        if (isSupportedBizCustomTrackValue(r105) == false) goto L9;
        r102.put(r104.getKey(), r105);
        goto L9
    L16:
        if (r102.length() <= 0) goto L27;
        r100.put("biz_custom_track", r102);
        return;
    L27:
        return;
    }

    private void generateTTNetLog(JSONObject r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        r101.put("retrofit", this.retrofit.toJson());
        r101.put("networklib", this.networklib.toJson());
        r100.put(TrafficMetrics.FRPM_TTNET, r101);
    }

    private boolean isSupportedBizCustomTrackValue(Object r100) {
        if ((r100 instanceof String) == false) goto L5;
    L27:
        return true;
    L5:
        if ((r100 instanceof Boolean) == true) goto L27;
        if ((r100 instanceof Double) == false) goto L17;
        double r101 = ((Double) r100).doubleValue();
        if (Double.isNaN(r101) == false) goto L12;
    L14:
        return false;
    L12:
        if (Double.isInfinite(r101) == true) goto L14;
        return true;
    L17:
        if ((r100 instanceof Float) == false) goto L26;
        float r102 = ((Float) r100).floatValue();
        if (Float.isNaN(r102) == false) goto L21;
    L23:
        return false;
    L21:
        if (Float.isInfinite(r102) == true) goto L23;
        return true;
    L26:
        return r100 instanceof Number;
    }

    public static void setLogReporter(AsyncLogReporter r100) {
        logReporter = r100;
    }

    public static void setReportDetail(int r100) {
        RetrofitLayerMetrics.setReportDetail(r100);
        NetworkLibLayerMetrics.setReportDetail(r100);
    }

    public static void setReportNewMetrics(boolean r100) {
        sReportNewMetrics = r100;
    }

    public static void setRequestLogReporterBridge(IRequestLogReporterBridge r100) {
        sRequestLogReporterBridge = r100;
    }

    public static void setSyncReport(boolean r100) {
        sSyncReport = r100;
    }

    public long ConvertToWallClockTimeMs(long r100) {
        RetrofitLayerMetrics.EventTimestamp r101 = this.retrofit.eventTs;
        return TTMetricsUtil.calculateWallClockTimeMs(r101.bizInvokeRetrofitRequestInterfaceStartTime, r101.bizInvokeRetrofitRequestInterfaceStart, r100);
    }

    public void afterInterceptorExecute(Throwable r110) {
        long r100 = System.nanoTime();
        InterceptorRecorder.LogEntry r101 = this.retrofit.interceptorRecorder.pop();
        if (r101 != null) goto L5;
    L24:
        InterceptorRecorder.LogEntry r102 = this.retrofit.interceptorRecorder.peek();
        if (r102 != null) goto L27;
        this.retrofit.eventTs.responseInterceptorEnd = r100;
        return;
    L27:
        if (r110 != null) goto L31;
        r102.rspStartNs = r100;
        return;
    L31:
        return;
    L5:
        if (r101.reqEndNs != (-1)) goto L10;
        r101.reqEndNs = r100;
        if (r110 == null) goto L15;
        r101.exception_name = r110.getClass().getSimpleName();
    L15:
        if (r101.isInternalInterceptor == true) goto L24;
        long r103 = r101.rspStartNs;
        if (r103 == (-1)) goto L24;
        long r104 = r101.rspEndNs;
        if (r104 == (-1)) goto L24;
        RetrofitLayerMetrics.BizSpan r105 = this.retrofit.bizSpan;
        if (r105.bizResponseInterceptor != (-1)) goto L23;
        r105.bizResponseInterceptor = 0;
    L23:
        r105.bizResponseInterceptor += r104 - r103;
        goto L24
    L10:
        if (r101.rspStartNs == (-1)) goto L15;
        r101.rspEndNs = r100;
        if (r110 == null) goto L15;
        r101.exception_name = r110.getClass().getSimpleName();
        goto L15
    }

    public void beforeInterceptorExecute(Interceptor r110) {
        String r100 = r110.getClass().getName();
        if (TextUtils.isEmpty(r100) == true) goto L18;
        long r101 = System.nanoTime();
        InterceptorRecorder.LogEntry r102 = this.retrofit.interceptorRecorder.peek();
        if (r102 != null) goto L7;
        this.retrofit.eventTs.requestInterceptorStart = r101;
        this.responseChainTime = TTMetricsUtil.nanoSecondsToMilliSeconds(r101);
        this.beforeAllInterceptors = ConvertToWallClockTimeMs(r101);
    L16:
        this.retrofit.interceptorRecorder.push(new InterceptorRecorder.LogEntry(r100.substring(r100.lastIndexOf(46) + 1), r110 instanceof TTInternalInterceptor, r101));
        return;
    L7:
        if (r102.reqEndNs != (-1)) goto L10;
        r102.reqEndNs = r101;
    L10:
        if (r102.isInternalInterceptor == true) goto L16;
        RetrofitLayerMetrics.BizSpan r103 = this.retrofit.bizSpan;
        if (r103.bizRequestInterceptor != (-1)) goto L14;
        r103.bizRequestInterceptor = 0;
    L14:
        r103.bizRequestInterceptor += r102.reqEndNs - r102.reqStartNs;
        goto L16
    }

    public void bizInvokeRetrofitRequestInterfaceStart(boolean r100) {
        RetrofitLayerMetrics.EventTimestamp r101 = this.retrofit.eventTs;
        long r102 = System.currentTimeMillis();
        r101.bizInvokeRetrofitRequestInterfaceStartTime = r102;
        this.appCreateRetrofitStart = r102;
        RetrofitLayerMetrics.EventTimestamp r103 = this.retrofit.eventTs;
        r103.bizInvokeRetrofitRequestInterfaceStart = System.nanoTime();
        long r104 = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.bizInvokeRetrofitRequestInterfaceStart);
        this.appCreateRetrofitStartUpTime = r104;
        if (r100 == false) goto L6;
        this.createSsHttpCallTime = r104;
        this.retrofitMethodInvokeTime = r104;
        return;
    }

    public void configureConnectionEnd(long r100) {
        NetworkLibLayerMetrics.ImportantInnerSpan r101 = this.networklib.innerSpan;
        r101.configureConnection = System.nanoTime() - r100;
        this.prepareRequestDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.innerSpan.configureConnection);
    }

    public void constructConnectionEnd(long r100) {
        NetworkLibLayerMetrics.ImportantInnerSpan r101 = this.networklib.innerSpan;
        r101.constructConnection = System.nanoTime() - r100;
        this.openConnectionDuration = TTMetricsUtil.nanoSecondsToMilliSeconds(this.networklib.innerSpan.constructConnection);
    }

    public void copyTo(RetrofitMetrics r100) {
        if (r100 != null) goto L79;
        return;
    L79:
        if (this.url == null) goto L7;
        r100.url = new URL(this.url.toString());     // Catch: Exception -> L71
    L7:
        r100.isResponseStreaming = this.isResponseStreaming;
        r100.streamParserCopyCount = this.streamParserCopyCount;
        r100.responseReadType = this.responseReadType;
        r100.requestEncryptType = this.requestEncryptType;
        r100.fallbackReason = this.fallbackReason;
        r100.fallbackMessage = this.fallbackMessage;
        r100.requestFallbackReason = this.requestFallbackReason;
        r100.requestFallbackMessage = this.requestFallbackMessage;
        JSONObject r101 = null;
        if (this.concurrentRequest == null) goto L11;
        JSONObject r102 = new JSONObject(this.concurrentRequest.toString());     // Catch: JSONException -> L14
    L12:
        r100.concurrentRequest = r102;     // Catch: JSONException -> L14
        goto L15
    L11:
        r102 = null;
    L15:
        r100.transactionId = this.transactionId;
        r100.isConcurrent = this.isConcurrent;
        r100.appCreateRetrofitStart = this.appCreateRetrofitStart;
        r100.appLevelRequestStart = this.appLevelRequestStart;
        r100.beforeAllInterceptors = this.beforeAllInterceptors;
        r100.callServerInterceptorTime = this.callServerInterceptorTime;
        r100.callExecuteStartTime = this.callExecuteStartTime;
        r100.retrofitLogReportTime = this.retrofitLogReportTime;
        r100.retrofitMethodInvokeTime = this.retrofitMethodInvokeTime;
        r100.createSsHttpCallTime = this.createSsHttpCallTime;
        r100.appCreateRetrofitStartUpTime = this.appCreateRetrofitStartUpTime;
        r100.enqueueTime = this.enqueueTime;
        r100.executeTime = this.executeTime;
        r100.delayState = this.delayState;
        r100.delayStateName = this.delayStateName;
        r100.delayedWithState = this.delayedWithState;
        r100.stateDelayTime = this.stateDelayTime;
        r100.syncDelayCount = this.syncDelayCount;
        r100.asyncDelayCount = this.asyncDelayCount;
        r100.delayStartTimeStamp = this.delayStartTimeStamp;
        r100.randomSendTime = this.randomSendTime;
        r100.responseChainTime = this.responseChainTime;
        r100.toRequestStartTime = this.toRequestStartTime;
        r100.toRequestEndTime = this.toRequestEndTime;
        r100.executeCallStartTime = this.executeCallStartTime;
        r100.executeCallEndTime = this.executeCallEndTime;
        r100.toResponseStartTime = this.toResponseStartTime;
        r100.toResponseEndTime = this.toResponseEndTime;
        if (this.interceptorResponseThrowable == null) goto L19;
        Throwable r103 = new Throwable(this.interceptorResponseThrowable.getMessage());
        r103.setStackTrace(this.interceptorResponseThrowable.getStackTrace());
        r100.interceptorResponseThrowable = r103;
    L19:
        if (this.requestInterceptDuration == null) goto L25;
        r100.requestInterceptDuration = new ConcurrentHashMap();
        Iterator<Map.Entry<String, Long>> r104 = this.requestInterceptDuration.entrySet().iterator();
    L22:
        if (r104.hasNext() == false) goto L25;
        Map.Entry<String, Long> r105 = r104.next();
        r100.requestInterceptDuration.put(r105.getKey(), r105.getValue());
    L25:
        if (this.responseInterceptDuration == null) goto L30;
        r100.responseInterceptDuration = new ConcurrentHashMap();
        Iterator<Map.Entry<String, Long>> r106 = this.responseInterceptDuration.entrySet().iterator();
    L28:
        if (r106.hasNext() == false) goto L30;
        Map.Entry<String, Long> r107 = r106.next();
        r100.responseInterceptDuration.put(r107.getKey(), r107.getValue());
    L30:
        r100.filterUrlDuration = this.filterUrlDuration;
        r100.addCommonParamDuration = this.addCommonParamDuration;
        r100.requestVerifyDuration = this.requestVerifyDuration;
        r100.filterDupQueryDuration = this.filterDupQueryDuration;
        r100.encryptRequestDuration = this.encryptRequestDuration;
        r100.genReqTicketDuration = this.genReqTicketDuration;
        r100.checkReqTicketDuration = this.checkReqTicketDuration;
        r100.preCdnCacheVerifyDuration = this.preCdnCacheVerifyDuration;
        r100.addClientKeyDuration = this.addClientKeyDuration;
        r100.updateClientKeyDuration = this.updateClientKeyDuration;
        r100.postCdnCacheVerifyDuration = this.postCdnCacheVerifyDuration;
        r100.commandListenerDuration = this.commandListenerDuration;
        r100.queryFilterDuration = this.queryFilterDuration;
        r100.bodyEncryptDuration = this.bodyEncryptDuration;
        if (this.extra == null) goto L36;
        r100.extra = new ConcurrentHashMap();
        Iterator<Map.Entry<String, Long>> r108 = this.extra.entrySet().iterator();
    L34:
        if (r108.hasNext() == false) goto L36;
        Map.Entry<String, Long> r109 = r108.next();
        r100.extra.put(r109.getKey(), r109.getValue());
    L36:
        r100.ttnetVersion = this.ttnetVersion;
        if (this.dispatchQueryActionInfo == null) goto L40;
        r100.dispatchQueryActionInfo = new JSONArray(this.dispatchQueryActionInfo.toString());     // Catch: JSONException -> L72
    L40:
        r100.traceCode = this.traceCode;
        r100.responseConvertSuccess = this.responseConvertSuccess;
        r100.enqueueCallbackStartTime = this.enqueueCallbackStartTime;
        r100.enqueueCallbackEndTime = this.enqueueCallbackEndTime;
        r100.executeEndTime = this.executeEndTime;
        r100.priorityLevel = this.priorityLevel;
        r100.requestPriorityLevel = this.requestPriorityLevel;
        r100.responseCompressType = this.responseCompressType;
        r100.requestCompressType = this.requestCompressType;
        if (this.requestCompressInfo == null) goto L44;
        JSONObject r110 = new JSONObject(this.requestCompressInfo.toString());     // Catch: JSONException -> L47
    L45:
        r100.requestCompressInfo = r110;     // Catch: JSONException -> L47
        goto L48
    L44:
        r110 = null;
    L48:
        r100.postBodyBufferSize = this.postBodyBufferSize;
        r100.setThrottleNetSpeedDuration = this.setThrottleNetSpeedDuration;
        r100.tryNecessaryInitDuration = this.tryNecessaryInitDuration;
        r100.openConnectionDuration = this.openConnectionDuration;
        r100.prepareRequestDuration = this.prepareRequestDuration;
        r100.upperAddCookieDurationUs = this.upperAddCookieDurationUs;
        r100.upperSaveCookieDurationUs = this.upperSaveCookieDurationUs;
        r100.requestCookieSourceType = this.requestCookieSourceType;
        Map<String, Object> r111 = getBizExtraInfoSnapshot();
        if (r111 == null) goto L81;
        r100.bizExtraInfo.putAll(r111);
    L81:
        if (this.rotationHostRetryInfo == null) goto L54;
        r101 = new JSONObject(this.rotationHostRetryInfo.toString());     // Catch: JSONException -> L56
    L54:
        r100.rotationHostRetryInfo = r101;     // Catch: JSONException -> L56
    L57:
        r100.blockingQueueSize = this.blockingQueueSize;
        List<InterceptorInfo> r112 = this.interceptorRequestInfos;
        if (r112 == null) goto L63;
        Iterator<InterceptorInfo> r113 = r112.iterator();
    L61:
        if (r113.hasNext() == false) goto L63;
        InterceptorInfo r114 = r113.next();
        InterceptorInfo r115 = new InterceptorInfo(this, r114.name, r114.start);
        r115.end = r114.end;
        r115.exception_name = r114.exception_name;
        r100.interceptorRequestInfos.add(r115);
    L63:
        List<InterceptorInfo> r116 = this.interceptorResponseInfos;
        if (r116 == null) goto L69;
        Iterator<InterceptorInfo> r117 = r116.iterator();
    L67:
        if (r117.hasNext() == false) goto L69;
        InterceptorInfo r118 = r117.next();
        InterceptorInfo r119 = new InterceptorInfo(this, r118.name, r118.start);
        r119.end = r118.end;
        r119.exception_name = r118.exception_name;
        r100.interceptorResponseInfos.add(r119);
    L69:
        r100.hasNetworkKernelLog = this.hasNetworkKernelLog;
        r100.hasRetrofitLog = this.hasRetrofitLog;
        r100.requestInfo = this.requestInfo;
        r100.retrofit = this.retrofit.deepCopy();
        r100.networklib = this.networklib.deepCopy();
    }

    public void executeConnectionEnd(long r100) {
        long r101 = System.nanoTime();
        NetworkLibLayerMetrics r102 = this.networklib;
        r102.eventTs.executeConnectionEnd = r101;
        long r103 = r101 - r100;
        r102.innerSpan.executeConnection = r103;
    }

    public void recordInterceptorRequestStart(Interceptor r100) {
        String r101 = r100.getClass().getName();
        if (TextUtils.isEmpty(r101) == true) goto L6;
        String r102 = r101.substring(r101.lastIndexOf(46) + 1);
        this.interceptorRequestInfos.add(new InterceptorInfo(this, r102, SystemClock.uptimeMillis()));
        return;
    }

    public void recordInterceptorResponseEnd(Exception r100) {
        if (this.interceptorResponseInfos.size() > 0) goto L5;
        return;
    L5:
        List<InterceptorInfo> r101 = this.interceptorResponseInfos;
        ((InterceptorInfo) ListProtector.get(r101, r101.size() - 1)).end = SystemClock.uptimeMillis();
        if (r100 == null) goto L9;
        List<InterceptorInfo> r102 = this.interceptorResponseInfos;
        ((InterceptorInfo) ListProtector.get(r102, r102.size() - 1)).exception_name = r100.getClass().getSimpleName();
        return;
    }

    public void recordInterceptorResponseStart(Interceptor r100) {
        String r101 = r100.getClass().getName();
        if (TextUtils.isEmpty(r101) == true) goto L6;
        String r102 = r101.substring(r101.lastIndexOf(46) + 1);
        this.interceptorResponseInfos.add(new InterceptorInfo(this, r102, SystemClock.uptimeMillis()));
        return;
    }

    public void setBlockingQueueSize(int r100) {
        this.retrofit.misc.blockingQueueSize = r100;
        this.blockingQueueSize = r100;
    }

    public void setConstructConfigureAndRetryConnection(long r100) {
        NetworkLibLayerMetrics.ImportantInnerSpan r101 = this.networklib.innerSpan;
        r101.constructConfigureAndRetryConnection = System.nanoTime() - r100;
    }

    public void setEncryptType(EncryptType r100) {
        this.requestEncryptType = r100;
    }

    public void setInterceptorResponseThrowable(Throwable r100) {
        this.retrofit.misc.interceptorResponseThrowable = r100;
        this.interceptorResponseThrowable = r100;
    }

    public void setKernelDns(long r100) {
        this.networklib.kernelSpan.dns = r100;
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setKernelDns(r100);
        return;
    }

    public void setKernelPush(long r100) {
        this.networklib.kernelSpan.push = r100;
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setKernelPush(r100);
        return;
    }

    public void setKernelReceiveBody(long r100) {
        this.networklib.kernelSpan.receiveBody = r100;
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setKernelReceiveBody(r100);
        return;
    }

    public void setKernelSend(long r100) {
        this.networklib.kernelSpan.send = r100;
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setKernelSend(r100);
        return;
    }

    public void setKernelTCPConnect(long r100) {
        this.networklib.kernelSpan.tcpConnect = r100;
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setKernelTCPConnect(r100);
        return;
    }

    public void setKernelTTFB(long r100) {
        this.networklib.kernelSpan.ttfb = r100;
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setKernelTTFB(r100);
        return;
    }

    public void setKernelTls(long r100) {
        this.networklib.kernelSpan.tls = r100;
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setKernelTls(r100);
        return;
    }

    public void setKernelTotal(long r100) {
        this.networklib.kernelSpan.total = r100;
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setKernelTotal(r100);
        return;
    }

    public void setNetworkKernelRawRequestLog(String r100) {
        this.networklib.networkKernelRawRequestLog = r100;
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setNetworkKernelRawRequestLog(r100);
        return;
    }

    public void setPriorityLevel(int r100) {
        if (this.priorityLevel != (-999)) goto L6;
        this.priorityLevel = r100;
        return;
    }

    public void setRequestAuditLog(JSONObject r100) {
        this.networklib.misc.requestAuditLog = r100;
    }

    public void setRequestCookieRelMetric(String r100) {
        this.networklib.misc.requestCookieRelMetric = r100;
    }

    public void setRequestCookieSourceType(int r100) {
        this.networklib.misc.requestCookieSourceType = r100;
        this.requestCookieSourceType = r100;
    }

    public void setRequestEndAppResumeState(long r100) {
        this.retrofit.misc.requestEndAppResumeState = r100;
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L6;
        r101.get().setRequestEndAppResumeState(r100);
        return;
    }

    public void setRequestExtraInfo(Object r100) {
        this.networklib.misc.requestExtraInfo = r100;
    }

    public void setRotationHostRetryInfo(JSONObject r100) {
        this.networklib.misc.rotationHostRetryInfo = r100;
        this.rotationHostRetryInfo = r100;
    }

    public void setUpperAddCookieDurationUs(long r100) {
        this.networklib.kernelSpan.upperAddCookieDurationUs = r100;
        this.upperAddCookieDurationUs = r100;
    }

    public void setUpperSaveCookieDurationUs(long r100) {
        this.networklib.kernelSpan.upperSaveCookieDurationUs = r100;
        this.upperSaveCookieDurationUs = r100;
    }

    public void ssHttpCallApiStart(boolean r110) {
        RetrofitLayerMetrics.EventTimestamp r100 = this.retrofit.eventTs;
        long r101 = System.currentTimeMillis();
        r100.ssHttpCallApiStartTime = r101;
        this.appLevelRequestStart = r101;
        RetrofitLayerMetrics.EventTimestamp r102 = this.retrofit.eventTs;
        r102.ssHttpCallApiStart = System.nanoTime();
        if (r110 == false) goto L5;
        this.enqueueTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.ssHttpCallApiStart);
    L6:
        RetrofitLayerMetrics.Misc r111 = this.retrofit.misc;
        r111.requestStartAppResumeState = AppActivityResumeSuspendRecorder.GetAppActivityResumeState();
        RetrofitLayerMetrics r112 = this.retrofit;
        RetrofitLayerMetrics.BizSpan r103 = r112.bizSpan;
        RetrofitLayerMetrics.EventTimestamp r104 = r112.eventTs;
        long r105 = r104.ssHttpCallApiStart;
        long r106 = r105 - r104.bizInvokeRetrofitRequestInterfaceEnd;
        r103.waitSsHttpCallApiExecute = r106;
        long r107 = r104.toRequestEnd;
        if (r107 != (-1)) goto L9;
        return;
    L9:
        if (r107 >= r105) goto L15;
        long r108 = r112.innerSpan.toRequest;
        if (r108 == (-1)) goto L16;
        r103.waitSsHttpCallApiExecute = r106 - r108;
        return;
    L16:
        return;
    L15:
        return;
    L5:
        this.executeTime = TTMetricsUtil.nanoSecondsToMilliSeconds(this.retrofit.eventTs.ssHttpCallApiStart);
        goto L6
    }

    public void toJson(JSONObject r100) throws JSONException {
        if (r100 != null) goto L4;
        return;
    L4:
        WeakReference<LegacyLogRecorder> r101 = this.requestInfo;
        if (r101 == null) goto L7;
        r101.get().generateOldFormatLog(r100);
    L7:
        appendBizCustomTrack(r100);
        if (sReportNewMetrics == false) goto L11;
        generateTTNetLog(r100);
        return;
    }

    public RetrofitMetrics(long r100, long r110) {
        this.url = null;
        this.requestInfo = null;
        this.streamParserCopyCount = -1;
        this.responseReadType = -1;
        this.requestEncryptType = EncryptType.ENCRYPT_NONE;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.requestFallbackReason = -1;
        this.requestFallbackMessage = "";
        this.transactionId = "";
        this.isConcurrent = false;
        this.delayState = -1;
        this.delayStateName = null;
        this.stateDelayTime = -1;
        this.syncDelayCount = -1;
        this.asyncDelayCount = -1;
        this.delayStartTimeStamp = -1;
        this.randomSendTime = -1;
        this.interceptorResponseThrowable = null;
        this.requestInterceptDuration = new ConcurrentHashMap();
        this.responseInterceptDuration = new ConcurrentHashMap();
        this.filterUrlDuration = -1;
        this.addCommonParamDuration = -1;
        this.requestVerifyDuration = -1;
        this.filterDupQueryDuration = -1;
        this.encryptRequestDuration = -1;
        this.genReqTicketDuration = -1;
        this.checkReqTicketDuration = -1;
        this.preCdnCacheVerifyDuration = -1;
        this.addClientKeyDuration = -1;
        this.updateClientKeyDuration = -1;
        this.postCdnCacheVerifyDuration = -1;
        this.commandListenerDuration = -1;
        this.queryFilterDuration = -1;
        this.bodyEncryptDuration = -1;
        this.extra = new HashMap();
        this.ttnetVersion = "";
        this.traceCode = "";
        this.responseConvertSuccess = true;
        this.priorityLevel = -999;
        this.requestPriorityLevel = -1;
        this.responseCompressType = "";
        this.requestCompressType = "";
        this.setThrottleNetSpeedDuration = -1;
        this.tryNecessaryInitDuration = -1;
        this.openConnectionDuration = -1;
        this.prepareRequestDuration = -1;
        this.upperAddCookieDurationUs = -1;
        this.upperSaveCookieDurationUs = -1;
        this.requestCookieSourceType = -1;
        this.bizExtraInfo = Collections.synchronizedMap(new HashMap());
        this.rotationHostRetryInfo = null;
        this.blockingQueueSize = 0;
        this.interceptorRequestInfos = new ArrayList();
        this.interceptorResponseInfos = new ArrayList();
        this.retrofit = new RetrofitLayerMetrics();
        this.networklib = new NetworkLibLayerMetrics();
        this.readingResponseBody = false;
        this.hasNetworkKernelLog = false;
        this.hasRetrofitLog = false;
        this.appLevelRequestStart = r100;
        this.beforeAllInterceptors = r110;
    }

    private void doReportRequestLog(Object r100, Throwable r101) {
        URL r102 = this.url;
        if (r102 == null) goto L5;
        String r103 = r102.toString();
    L6:
        if (r101 != null) goto L9;
        sRequestLogReporterBridge.monitorApiOk(r103, r100);
        return;
    L9:
        if ((r101 instanceof TTNetExceptionStorage) == false) goto L17;
        TTNetExceptionStorage r104 = (TTNetExceptionStorage) r101;
        if (r104.reportMonitorOk == false) goto L14;
        sRequestLogReporterBridge.monitorApiOk(r103, r100);
    L14:
        if (r104.reportMonitorError == false) goto L24;
        sRequestLogReporterBridge.monitorApiError(r103, r100, r101);
        return;
    L24:
        return;
    L17:
        if (this.retrofit.misc.executeSsCallSuccess == false) goto L20;
        setInterceptorResponseThrowable(r101);
        sRequestLogReporterBridge.monitorApiOk(r103, r100);
        return;
    L20:
        if (sRequestLogReporterBridge.isAllErrorReport() == false) goto L27;
        sRequestLogReporterBridge.monitorApiError(r103, r100, r101);
        return;
    L27:
        return;
    L5:
        r103 = "";
        goto L6
    }

    public static /* synthetic */ void access$000(RetrofitMetrics r100, Object r101, Throwable r102) {
        r100.doReportRequestLog(r101, r102);
    }

    private boolean validateAndSetTimingValue(JSONObject r100, String r101, long r102, long r103, boolean r104) {
        if (r104 == true) goto L5;
    L10:
        r100.put(r101, -1);     // Catch: JSONException -> L12
        return false;
    L5:
        if (r102 > r103) goto L10;
        r100.put(r101, r103 - r102);     // Catch: JSONException -> L12
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void setCronetReadResponseBodyMetrics(long r100, long r101, long r102, long r110, long r111) {
        NetworkLibLayerMetrics r103 = this.networklib;
        NetworkLibLayerMetrics.EventTimestamp r104 = r103.eventTs;
        r104.firstReadResponseBodyStart = r101;
        r104.latestReadResponseBodyEnd = r102;
        NetworkLibLayerMetrics.Misc r105 = r103.misc;
        r105.responseBodyReadTimes = r100;
        if (r105.readResponseBodyInternal == true) goto L13;
        NetworkLibLayerMetrics.BizSpan r106 = r103.bizSpan;
        if (r106.waitReadResponseBody != (-1)) goto L11;
        long r107 = this.retrofit.eventTs.bizReceiveResponseHeader;
        if (r107 == (-1)) goto L11;
        if (r101 <= r107) goto L11;
        r106.waitReadResponseBody = r101 - r107;
    L11:
        r106.readResponseBodyInterval = r111;
        r103.innerSpan.readResponseBody = r110;
        return;
    }
}
