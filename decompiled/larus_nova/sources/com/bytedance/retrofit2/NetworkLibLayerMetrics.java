package com.bytedance.retrofit2;

import android.text.TextUtils;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkLibLayerMetrics {
    public static int BIZ_SPAN_MASK = 64;
    public static int EVENT_TIMESTAMP_MASK = 32;
    public static int IMPORTANT_INNER_SPAN_MASK = 128;
    public static int MISC_MASK = 256;
    private static volatile int reportDetail = -1;
    public BizSpan bizSpan;
    public EventTimestamp eventTs;
    public ImportantInnerSpan innerSpan;
    public ImportantKernelSpan kernelSpan;
    public Misc misc;
    public String networkKernelRawRequestLog;

    public static class BizSpan {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public long accountRetryDuration;
        public long bdTuringDuration;
        private long bizCallbackStart;
        public long bodyEncrypt;
        public long inputStreamProcessDuration;
        public long onTryInit;
        public long readResponseBodyInterval;
        public long requestAuditDuration;
        public long rotationRetryAccumulatedDuration;
        public long tryInitCookieManager;
        public long waitReadResponseBody;

        public BizSpan deepCopy() {
            BizSpan r100 = new BizSpan();
            r100.bizCallbackStart = this.bizCallbackStart;
            r100.bodyEncrypt = this.bodyEncrypt;
            r100.onTryInit = this.onTryInit;
            r100.tryInitCookieManager = this.tryInitCookieManager;
            r100.bdTuringDuration = this.bdTuringDuration;
            r100.accountRetryDuration = this.accountRetryDuration;
            r100.rotationRetryAccumulatedDuration = this.rotationRetryAccumulatedDuration;
            r100.requestAuditDuration = this.requestAuditDuration;
            r100.waitReadResponseBody = this.waitReadResponseBody;
            r100.readResponseBodyInterval = this.readResponseBodyInterval;
            r100.inputStreamProcessDuration = this.inputStreamProcessDuration;
            return r100;
        }

        public BizSpan() {
            this.bizCallbackStart = -1;
            this.bodyEncrypt = -1;
            this.onTryInit = -1;
            this.tryInitCookieManager = -1;
            this.bdTuringDuration = -1;
            this.accountRetryDuration = -1;
            this.rotationRetryAccumulatedDuration = -1;
            this.requestAuditDuration = -1;
            this.waitReadResponseBody = -1;
            this.readResponseBodyInterval = -1;
            this.inputStreamProcessDuration = -1;
        }

        public long computeDurationNs() {
            long r100 = System.nanoTime() - this.bizCallbackStart;
            this.bizCallbackStart = -1;
            return r100;
        }

        public void recordCallbackStart() {
            this.bizCallbackStart = System.nanoTime();
        }

        public JSONObject toJson() throws JSONException {
            if ((NetworkLibLayerMetrics.access$000() & NetworkLibLayerMetrics.BIZ_SPAN_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r100 = new JSONObject();
            r100.put("bdy_encrypt", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.bodyEncrypt)));
            r100.put("on_try_init", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.onTryInit)));
            r100.put("init_cookie", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.tryInitCookieManager)));
            r100.put("bd_turing", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.bdTuringDuration)));
            r100.put("acnt_rty", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.accountRetryDuration)));
            r100.put("rot_rty", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.rotationRetryAccumulatedDuration)));
            r100.put("wait_rd_rsp_bdy", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.waitReadResponseBody)));
            r100.put("rd_rsp_bdy_intvl", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.readResponseBodyInterval)));
            r100.put("input_stream_prc", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.inputStreamProcessDuration)));
            long r101 = this.requestAuditDuration;
            if (r101 <= 0) goto L9;
            r100.put("req_audit", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(r101)));
        L9:
            return r100;
        }

        static {
        }
    }

    public static class EventTimestamp {
        public long executeConnectionEnd;
        public long executeConnectionStart;
        public long firstReadResponseBodyStart;
        public long latestReadResponseBodyEnd;
        public long prepareConnectionEnd;
        public long prepareConnectionStart;
        public long processResponseBodyEnd;
        public long processResponseBodyStart;

        public EventTimestamp deepCopy() {
            EventTimestamp r100 = new EventTimestamp();
            r100.prepareConnectionStart = this.prepareConnectionStart;
            r100.prepareConnectionEnd = this.prepareConnectionEnd;
            r100.executeConnectionStart = this.executeConnectionStart;
            r100.executeConnectionEnd = this.executeConnectionEnd;
            r100.processResponseBodyStart = this.processResponseBodyStart;
            r100.processResponseBodyEnd = this.processResponseBodyEnd;
            r100.firstReadResponseBodyStart = this.firstReadResponseBodyStart;
            r100.latestReadResponseBodyEnd = this.latestReadResponseBodyEnd;
            return r100;
        }

        public EventTimestamp() {
            this.prepareConnectionStart = -1;
            this.prepareConnectionEnd = -1;
            this.executeConnectionStart = -1;
            this.executeConnectionEnd = -1;
            this.processResponseBodyStart = -1;
            this.processResponseBodyEnd = -1;
            this.firstReadResponseBodyStart = -1;
            this.latestReadResponseBodyEnd = -1;
        }

        public JSONObject toJson() throws JSONException {
            if ((NetworkLibLayerMetrics.access$000() & NetworkLibLayerMetrics.EVENT_TIMESTAMP_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r100 = new JSONObject();
            r100.put("prp_conn_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.prepareConnectionStart)));
            r100.put("prp_conn_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.prepareConnectionEnd)));
            r100.put("exe_conn_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.executeConnectionStart)));
            r100.put("exe_conn_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.executeConnectionEnd)));
            r100.put("prc_rsp_bdy_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.processResponseBodyStart)));
            r100.put("prc_rsp_bdy_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.processResponseBodyEnd)));
            r100.put("frs_rd_rsp_bdy_s", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.firstReadResponseBodyStart)));
            r100.put("lst_rd_rsp_bdy_e", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.latestReadResponseBodyEnd)));
            return r100;
        }
    }

    public static class ImportantInnerSpan {
        public long configureConnection;
        public long constructConfigureAndRetryConnection;
        public long constructConnection;
        public long executeConnection;
        private Deque<Long> innerSpanStart;
        public long postProcessBody;
        public long processResponseBody;
        public long queryFilter;
        public long readResponseBody;
        public long reflection;

        public long computeDurationNs() {
            Long r100 = this.innerSpanStart.pop();     // Catch: Exception -> L4
            return System.nanoTime() - r100.longValue();
        L4:
            e = move-exception;
            e.printStackTrace();
            return -1;
        }

        public ImportantInnerSpan deepCopy() {
            ImportantInnerSpan r100 = new ImportantInnerSpan();
            r100.queryFilter = this.queryFilter;
            r100.constructConnection = this.constructConnection;
            r100.configureConnection = this.configureConnection;
            r100.executeConnection = this.executeConnection;
            r100.constructConfigureAndRetryConnection = this.constructConfigureAndRetryConnection;
            r100.processResponseBody = this.processResponseBody;
            r100.postProcessBody = this.postProcessBody;
            r100.readResponseBody = this.readResponseBody;
            r100.reflection = this.reflection;
            if (this.innerSpanStart.isEmpty() == true) goto L8;
            r100.innerSpanStart = new ArrayDeque();
            Iterator<Long> r101 = this.innerSpanStart.iterator();
        L6:
            if (r101.hasNext() == false) goto L8;
            Long r102 = r101.next();
            r100.innerSpanStart.push(r102);
        L8:
            return r100;
        }

        public void recordInnerSpanStart() {
            this.innerSpanStart.push(Long.valueOf(System.nanoTime()));
        }

        public ImportantInnerSpan() {
            this.innerSpanStart = new ArrayDeque();
            this.queryFilter = -1;
            this.constructConnection = -1;
            this.configureConnection = -1;
            this.reflection = -1;
            this.executeConnection = -1;
            this.constructConfigureAndRetryConnection = -1;
            this.processResponseBody = -1;
            this.postProcessBody = -1;
            this.readResponseBody = -1;
        }

        public JSONObject toJson() throws JSONException {
            if ((NetworkLibLayerMetrics.access$000() & NetworkLibLayerMetrics.IMPORTANT_INNER_SPAN_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r100 = new JSONObject();
            r100.put("qry_flt", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.queryFilter)));
            r100.put("last_cons_conn", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.constructConnection)));
            r100.put("last_conf_conn", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.configureConnection)));
            r100.put("last_exe_conn", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.executeConnection)));
            r100.put("cons_conf_n_rty_conn", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.constructConfigureAndRetryConnection)));
            r100.put("prc_rsp_bdy", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.processResponseBody)));
            r100.put("post_prc_rsp_bdy", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.postProcessBody)));
            r100.put("total_rd_rsp_bdy", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.readResponseBody)));
            r100.put("reflect", String.valueOf(TTMetricsUtil.nanoSecondsToMicroSeconds(this.reflection)));
            return r100;
        }
    }

    public static class ImportantKernelSpan {
        public long dns;
        public long push;
        public long receiveBody;
        public long send;
        public long tcpConnect;
        public long tls;
        public long total;
        public long ttfb;
        public long upperAddCookieDurationUs;
        public long upperSaveCookieDurationUs;

        public ImportantKernelSpan deepCopy() {
            ImportantKernelSpan r100 = new ImportantKernelSpan();
            r100.dns = this.dns;
            r100.tcpConnect = this.tcpConnect;
            r100.tls = this.tls;
            r100.send = this.send;
            r100.push = this.push;
            r100.ttfb = this.ttfb;
            r100.receiveBody = this.receiveBody;
            r100.total = this.total;
            r100.upperAddCookieDurationUs = this.upperAddCookieDurationUs;
            r100.upperSaveCookieDurationUs = this.upperSaveCookieDurationUs;
            return r100;
        }

        public ImportantKernelSpan() {
            this.dns = -1;
            this.tcpConnect = -1;
            this.tls = -1;
            this.send = -1;
            this.push = -1;
            this.ttfb = -1;
            this.receiveBody = -1;
            this.total = -1;
            this.upperAddCookieDurationUs = -1;
            this.upperSaveCookieDurationUs = -1;
        }

        public JSONObject toJson() throws JSONException {
            if ((NetworkLibLayerMetrics.access$000() & NetworkLibLayerMetrics.IMPORTANT_INNER_SPAN_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r100 = new JSONObject();
            r100.put("add_cookie", String.valueOf(this.upperAddCookieDurationUs));
            r100.put("save_cookie", String.valueOf(this.upperSaveCookieDurationUs));
            return r100;
        }
    }

    public static class Misc {
        public boolean isConcurrentRequest;
        public boolean readResponseBodyInternal;
        public JSONObject requestAuditLog;
        public String requestCookieRelMetric;
        public int requestCookieSourceType;
        public Object requestExtraInfo;
        public long responseBodyReadTimes;
        public JSONObject rotationHostRetryInfo;

        public Misc deepCopy() {
            Misc r100 = new Misc();
            r100.isConcurrentRequest = this.isConcurrentRequest;
            r100.requestCookieSourceType = this.requestCookieSourceType;
            r100.requestCookieRelMetric = this.requestCookieRelMetric;
            r100.responseBodyReadTimes = this.responseBodyReadTimes;
            r100.readResponseBodyInternal = this.readResponseBodyInternal;
            r100.requestExtraInfo = this.requestExtraInfo;
            if (this.rotationHostRetryInfo == null) goto L7;
            r100.rotationHostRetryInfo = new JSONObject(this.rotationHostRetryInfo.toString());     // Catch: JSONException -> L10
        L7:
            if (this.requestAuditLog == null) goto L9;
            r100.requestAuditLog = new JSONObject(this.requestAuditLog.toString());     // Catch: JSONException -> L10
        L9:
            return r100;
        }

        public Misc() {
            this.isConcurrentRequest = false;
            this.requestCookieSourceType = -1;
            this.requestCookieRelMetric = null;
            this.rotationHostRetryInfo = null;
            this.responseBodyReadTimes = -1;
            this.readResponseBodyInternal = false;
            this.requestExtraInfo = null;
            this.requestAuditLog = null;
        }

        public JSONObject toJson() throws JSONException {
            if ((NetworkLibLayerMetrics.access$000() & NetworkLibLayerMetrics.MISC_MASK) != 0) goto L6;
            return null;
        L6:
            JSONObject r100 = new JSONObject();
            JSONObject r101 = this.requestAuditLog;
            if (r101 == null) goto L10;
            r100.put("req_audit", r101);
        L10:
            if (TextUtils.isEmpty(this.requestCookieRelMetric) == false) goto L14;
        L12:
            return r100;
        L14:
            r100.put("cookie_rel", new JSONObject(this.requestCookieRelMetric));     // Catch: Throwable -> L13
            goto L12
        }
    }

    public NetworkLibLayerMetrics deepCopy() {
        NetworkLibLayerMetrics r100 = new NetworkLibLayerMetrics();
        r100.eventTs = this.eventTs.deepCopy();
        r100.bizSpan = this.bizSpan.deepCopy();
        r100.innerSpan = this.innerSpan.deepCopy();
        r100.kernelSpan = this.kernelSpan.deepCopy();
        r100.misc = this.misc.deepCopy();
        r100.networkKernelRawRequestLog = this.networkKernelRawRequestLog;
        return r100;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("event_ts", this.eventTs.toJson());
        r100.put("biz_span", this.bizSpan.toJson());
        r100.put("inner_span", this.innerSpan.toJson());
        r100.put("misc", this.misc.toJson());
        return r100;
    }

    public NetworkLibLayerMetrics() {
        this.eventTs = new EventTimestamp();
        this.bizSpan = new BizSpan();
        this.innerSpan = new ImportantInnerSpan();
        this.kernelSpan = new ImportantKernelSpan();
        this.misc = new Misc();
        this.networkKernelRawRequestLog = "";
    }

    public static /* synthetic */ int access$000() {
        return reportDetail;
    }

    public static void setReportDetail(int r100) {
        reportDetail = r100;
    }
}
