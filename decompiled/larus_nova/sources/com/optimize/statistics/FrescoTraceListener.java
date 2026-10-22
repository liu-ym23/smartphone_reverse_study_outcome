package com.optimize.statistics;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.exception.IBDException;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.net.FrescoTTNetFetcher;
import com.facebook.net.ImageNetworkCallback;
import com.facebook.net.NetUtils;
import com.facebook.net.ResponseWrap;
import com.facebook.net.RetryInterceptManager;
import com.larus.platform.model.upload.ResourceUploadError;
import com.optimize.statistics.sampling.IFrescoMonitorSamplingDecider;
import com.ss.alog.middleware.ALogService;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class FrescoTraceListener extends BaseRequestListener {
    public static final String ALOGTAG = "Fresco";
    private static final String CLIENT_CRONET = "CronetClient";
    public static final String CLIENT_MDL = "MDLClient";
    private static final String CLIENT_TT_OK3 = "TTOkhttp3Client";
    public static final String IMAGE_MONITOR_DATA = "image_monitor_data";
    private static final String NW_SESSION_TRACE = "Nw-Session-Trace";
    private static final String REMOTEIP = "x-net-info.remoteaddr";
    public static final String TAG = "FrescoTraceListener";
    private static ExecutorService sExecutor;
    private ImageNetworkCallback mImageCallBack;
    private ConcurrentHashMap<String, RequestInfo> mRequestInfoMap;

    /* JADX INFO: loaded from: classes34.dex */
    public class RequestInfo {
        Object callerContext;
        JSONObject extra;
        boolean isFirstIntermediateResult;
        Map<String, Long> producerStartTimeMap;
        boolean reportExceedLimitEnabled;
        boolean reportV2Enabled;
        String requestId;
        long requestStartTime;
        final /* synthetic */ FrescoTraceListener this$0;
        boolean[] traceListenerSampled;

        public RequestInfo(FrescoTraceListener r100) {
            this.this$0 = r100;
            this.producerStartTimeMap = new HashMap();
            this.isFirstIntermediateResult = true;
            this.reportV2Enabled = true;
            this.reportExceedLimitEnabled = true;
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerEvent(String r100, String r101, String r102) {
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithCancellation(String r100, String r101, Map<String, String> r102) {
    }

    static {
        sExecutor = PThreadExecutorsUtils.newFixedThreadPool(1, new AnonymousClass1());
    }

    public FrescoTraceListener() {
        this.mImageCallBack = new AnonymousClass2(this);
        this.mRequestInfoMap = new ConcurrentHashMap();
        FrescoTTNetFetcher.setImageCallBack(this.mImageCallBack);
    }

    private long getTime() {
        return System.currentTimeMillis();
    }

    public ImageNetworkCallback getImageNetworkCallback() {
        return this.mImageCallBack;
    }

    public static /* synthetic */ ConcurrentHashMap access$000(FrescoTraceListener r100) {
        return r100.mRequestInfoMap;
    }

    private long calAppliedImagePxCount(JSONObject r100) {
        String r101 = r100.optString(FrescoMonitorConst.APPLIED_IMAGE_SIZE);
        if (r101 != null) goto L5;
        return 0;
    L5:
        Pair<Integer, Integer> r102 = segmentAndCheckSize(r101);
        if (r102 != null) goto L9;
        return 0;
    L9:
        return ((Integer) r102.first).intValue() * ((Integer) r102.second).intValue();
    }

    private long calIntendedImagePxCount(JSONObject r100) {
        String r101 = r100.optString(FrescoMonitorConst.INTENDED_IMAGE_SIZE);
        if (r101 != null) goto L5;
        return 0;
    L5:
        Pair<Integer, Integer> r102 = segmentAndCheckSize(r101);
        if (r102 != null) goto L9;
        return 0;
    L9:
        return ((Integer) r102.first).intValue() * ((Integer) r102.second).intValue();
    }

    private String calViewImageSize(ImageRequest r100) {
        SizeDeterminer r101 = r100.getSizeDeterminer();
        if (r101 != null) goto L5;
        return "";
    L5:
        Pair<Integer, Integer> r102 = r101.getSize();
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102.first + "*" + r102.second;
    }

    private long calViewNeedImagePxCount(ImageRequest r100) {
        SizeDeterminer r101 = r100.getSizeDeterminer();
        if (r101 != null) goto L5;
        return 0;
    L5:
        Pair<Integer, Integer> r102 = r101.getSize();
        if (r102 != null) goto L9;
        return 0;
    L9:
        return ((Integer) r102.first).intValue() * ((Integer) r102.second).intValue();
    }

    private String encodeUrl(String r100) {
        if (StringUtils.isEmpty(r100) == false) goto L33;
        return r100;
    L33:
        LinkedHashMap r101 = new LinkedHashMap();     // Catch: Throwable -> L30
        Pair<String, String> r102 = UrlUtils.parseUrlWithValueList(r100, r101);     // Catch: Throwable -> L30
        if (r102 != null) goto L8;
        return r100;
    L8:
        UrlBuilder r103 = new UrlBuilder(((String) r102.first) + ((String) r102.second));     // Catch: Throwable -> L30
        if (r101.isEmpty() == true) goto L28;
        Iterator r104 = r101.entrySet().iterator();     // Catch: Throwable -> L30
    L12:
        if (r104.hasNext() == false) goto L28;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L30
        if (r105 == null) goto L12;
        if (r105.getKey() == null) goto L12;
        List r106 = (List) r105.getValue();     // Catch: Throwable -> L30
        if (r106 == null) goto L12;
        if (r106.isEmpty() == true) goto L12;
        Iterator r107 = r106.iterator();     // Catch: Throwable -> L30
    L26:
        if (r107.hasNext() == false) goto L12;
        r103.addParam((String) r105.getKey(), (String) r107.next());     // Catch: Throwable -> L30
    L28:
        return r103.build();
    L30:
        th = move-exception;
        th.printStackTrace();
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int getErrCodeFromThrowable(Throwable r100) {
        if (r100 != 0) goto L5;
        return 200;
    L5:
        if ((r100 instanceof IBDException) == false) goto L9;
        return ((IBDException) r100).getErrorCode();
    L9:
        return NetUtils.checkHttpRequestException(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String getErrMsg(Throwable r100) {
        if ((r100 instanceof IBDException) == false) goto L5;
        String r101 = ((IBDException) r100).getErrorMessage();
    L7:
        if ((r100 instanceof CronetIOException) == true) goto L11;
        if ((r100 instanceof HttpResponseException) == true) goto L11;
        return r101;
    L11:
        return r100.getMessage();
    L5:
        r101 = null;
        goto L7
    }

    private JSONObject getExtra(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject("extra");     // Catch: JSONException -> L7
        if (r101 != null) goto L12;
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L7
        r100.put("extra", r102);     // Catch: JSONException -> L7
        return r102;
    L12:
        return r101;
    L7:
        e = move-exception;
        FLog.e(TAG, "construct extra error", new Object[]{e.getMessage()});
        return null;
    }

    private JSONObject getHeaders(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject("headers");     // Catch: JSONException -> L7
        if (r101 != null) goto L12;
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L7
        r100.put("headers", r102);     // Catch: JSONException -> L7
        return r102;
    L12:
        return r101;
    L7:
        e = move-exception;
        FLog.e(TAG, "construct headers error", new Object[]{e.getMessage()});
        return null;
    }

    public static Map<String, String> handleDemotion(SsResponse<TypedInput> r100) {
        HashMap r101 = new HashMap();
        String r102 = getHeaderForName(r100.headers(), "ImageX-Demotion");
        if (r102 != null) goto L5;
        r102 = "undefined";
    L5:
        String r103 = getHeaderForName(r100.headers(), "ImageX-Fmt");
        if (r103 != null) goto L8;
        String[] r104 = null;
    L9:
        if (r104 != null) goto L11;
    L16:
        String r105 = "undefined";
        String r106 = r105;
    L18:
        if ("undefined".equals(r106) == false) goto L20;
    L25:
        String r107 = "-1";
    L26:
        r101.put("imagex_demotion", r102);
        r101.put("imagex_want_fmt", r106);
        r101.put("imagex_true_fmt", r105);
        r101.put("imagex_consistency", r107);
        return r101;
    L20:
        if ("undefined".equals(r105) == true) goto L25;
        if (r106.equalsIgnoreCase(r105) == false) goto L24;
        r107 = "1";
        goto L26
    L24:
        r107 = "0";
        goto L26
    L11:
        if (r104.length <= 0) goto L16;
        r106 = r104[0];
        if (r104.length <= 1) goto L15;
        r105 = r104[1];
        goto L18
    L15:
        r105 = "undefined";
        goto L18
    L8:
        r104 = r103.split("2");
        goto L9
    }

    private static boolean isCanceledInfo(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r100.contains("Canceled") == false) goto L8;
    L9:
        return true;
    L8:
        if (r100.contains(ResourceUploadError.CANCELED) == true) goto L9;
        return false;
    }

    private Pair<Integer, Integer> segmentAndCheckSize(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        String[] r101 = r100.split("x");
        if (r101.length == 2) goto L13;
        return null;
    L13:
        int r102 = CastIntegerProtector.parseInt(r101[0]);     // Catch: NumberFormatException -> L12
        int r103 = CastIntegerProtector.parseInt(r101[1]);     // Catch: NumberFormatException -> L12
        return new Pair(Integer.valueOf(r102), Integer.valueOf(r103));
    L15:
        return null;
    }

    private JSONObject shallowCopy(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();
        r101.put(r103, r100.opt(r103));     // Catch: JSONException -> L8
        goto L4
    L9:
        return r101;
    }

    private JSONObject uriQueryParamToExtra(JSONObject r100) {
        String r101 = r100.optString("uri", null);     // Catch: JSONException -> L26
        String r102 = r100.optString("biz_tag", null);     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r101) == true) goto L28;
        Uri r103 = UriProtector.parse(r101);     // Catch: JSONException -> L26
        if (r102 != null) goto L20;
        String r104 = UriProtector.getQueryParameter(r103, "biz_tag");     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r104) == false) goto L11;
        r104 = UriProtector.getQueryParameter(r103, "from");     // Catch: JSONException -> L26
    L11:
        if (TextUtils.isEmpty(r104) == false) goto L18;
        String r105 = r103.getPath();     // Catch: JSONException -> L26
        if (r105 == null) goto L15;
        int r106 = r105.lastIndexOf(47);     // Catch: JSONException -> L26
    L16:
        if (r106 <= 0) goto L18;
        r104 = r105.substring(0, r106);     // Catch: JSONException -> L26
        goto L18
    L15:
        r106 = -1;
    L18:
        if (r104 == null) goto L20;
        r100.put("biz_tag", r104);     // Catch: JSONException -> L26
    L20:
        String r107 = UriProtector.getQueryParameter(r103, FrescoMonitorConst.URI_QUERY_PARAM_IMAGEX_FLIGHT_ID);     // Catch: JSONException -> L26
        String r108 = UriProtector.getQueryParameter(r103, FrescoMonitorConst.URI_QUERY_PARAM_IMAGEX_VID);     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r107) == true) goto L23;
    L24:
        JSONObject r109 = getExtra(r100);     // Catch: JSONException -> L26
        r109.put(FrescoMonitorConst.URI_QUERY_PARAM_IMAGEX_FLIGHT_ID, r107);     // Catch: JSONException -> L26
        r109.put(FrescoMonitorConst.URI_QUERY_PARAM_IMAGEX_VID, r108);     // Catch: JSONException -> L26
        goto L28
    L23:
        if (TextUtils.isEmpty(r108) == false) goto L24;
    L28:
        return r100;
    L26:
        e = move-exception;
        FLog.e(TAG, "uriQueryParamToExtra error", new Object[]{e.getMessage()});
        goto L28
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(final String r100) {
        final long r101 = getTime();
        sExecutor.submit(new AnonymousClass5(this, r100, r101));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(String r100) {
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == true) goto L5;
        return true;
    L5:
        RequestInfo r101 = this.mRequestInfoMap.get(r100);
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.reportV2Enabled == false) goto L11;
        return true;
    L11:
        if (r101.reportExceedLimitEnabled == true) goto L16;
        return false;
    L16:
        return true;
    }

    public static /* synthetic */ void access$100(ResponseWrap r100, JSONObject r101) {
        packageResponseHeader(r100, r101);
    }

    private static String formatString(String r100, Object... r101) {
        return String.format(null, r100, r101);
    }

    private long getCurrentTime(Long r100, long r101) {
        if (r100 != null) goto L4;
        return -1;
    L4:
        return r101 - r100.longValue();
    }

    private static String getHeaderForName(List<Header> r100, String r101) {
        String r102 = null;
        if (r100 != null) goto L5;
    L12:
        return r102;
    L5:
        if (r100.size() <= 0) goto L12;
        Iterator<Header> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Header r104 = r103.next();
        if (r101.equalsIgnoreCase(r104.getName()) == false) goto L8;
        r102 = r104.getValue();
        goto L8
    }

    private boolean isNeedReport(ImageRequest r100, JSONObject r101) {
        if (FrescoMonitor.isNeedReportAllSourceUriType() == false) goto L6;
        return true;
    L6:
        if (FrescoMonitor.isReportHitCacheEnabled() == false) goto L13;
        if (r100.getSourceUriType() == 0) goto L14;
        return false;
    L14:
        return true;
    L13:
        return r101.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false);
    }

    private void onRequestCancellationInternal(String r110, long r111) {
        RequestInfo r100 = this.mRequestInfoMap.remove(r110);
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = 1;
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L8;
        ALogService.dSafely(ALOGTAG, formatString("time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", new Object[]{Long.valueOf(r111), r110, Long.valueOf(getCurrentTime(Long.valueOf(r100.requestStartTime), r111))}));
    L8:
        JSONObject r102 = r100.extra;
        r102.put(FrescoMonitorConst.LOAD_STATUS, "cancel");     // Catch: JSONException -> L15
        r102.put("duration", getCurrentTime(Long.valueOf(r100.requestStartTime), r111));     // Catch: JSONException -> L15
        r102.put("timestamp", Long.valueOf(r100.requestStartTime));     // Catch: JSONException -> L15
        if (RetryInterceptManager.inst().isOpen() == true) goto L13;
        r101 = 0;
    L13:
        r102.put(FrescoMonitorConst.RETRY_OPEN, r101);     // Catch: JSONException -> L15
    L17:
        hookMonitor(null, r110, r100.callerContext, r102, false, r102.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false), true);
        uriQueryParamToExtra(r102);
        return;
    L15:
        e = move-exception;
        FLog.e(TAG, e, "", new Object[0]);
        goto L17
    }

    public static void packageRequestParameters(HttpRequestInfo r100, JSONObject r101) {
        if (r100 == null) goto L25;
        if (r101 == null) goto L27;
        JSONObject r102 = new JSONObject();
        r102.put("requestStart", r100.requestStart);     // Catch: JSONException -> L18
        r102.put("responseBack", r100.responseBack);     // Catch: JSONException -> L18
        r102.put("completeReadResponse", r100.completeReadResponse);     // Catch: JSONException -> L18
        r102.put("requestEnd", r100.requestEnd);     // Catch: JSONException -> L18
        r102.put("recycleCount", r100.recycleCount);     // Catch: JSONException -> L18
        if (r100.httpClientType != 0) goto L9;
        r102.put("timing_dns", r100.dnsTime);     // Catch: JSONException -> L18
        r102.put("timing_connect", r100.connectTime);     // Catch: JSONException -> L18
        r102.put("timing_ssl", r100.sslTime);     // Catch: JSONException -> L18
        r102.put("timing_send", r100.sendTime);     // Catch: JSONException -> L18
        r102.put("timing_wait", r100.ttfbMs);     // Catch: JSONException -> L18
        r102.put("timing_receive", r100.receiveTime);     // Catch: JSONException -> L18
        r102.put("timing_total", r100.totalTime);     // Catch: JSONException -> L18
        r102.put("timing_isSocketReused", r100.isSocketReused);     // Catch: JSONException -> L18
        r102.put("timing_totalSendBytes", r100.sentByteCount);     // Catch: JSONException -> L18
        r102.put("timing_totalReceivedBytes", r100.receivedByteCount);     // Catch: JSONException -> L18
        r102.put("timing_remoteIP", r100.remoteIp);     // Catch: JSONException -> L18
        r102.put("request_log", r100.requestLog);     // Catch: JSONException -> L18
    L9:
        JSONObject r103 = r100.extraInfo;     // Catch: JSONException -> L18
        if (r103 == null) goto L12;
        r102.put("req_info", r103);     // Catch: JSONException -> L18
    L12:
        r102.put("download", r100.downloadFile);     // Catch: JSONException -> L18
        r101.put("net_timing_detail", r102);     // Catch: JSONException -> L18
        if (HttpClient.isCronetClientEnable() == false) goto L16;
        r101.put("netClientType", "CronetClient");     // Catch: JSONException -> L18
        return;
    L16:
        r101.put("netClientType", CLIENT_TT_OK3);     // Catch: JSONException -> L18
        return;
    L18:
        e = move-exception;
        if (StatLogUtils.IsDebug() == false) goto L22;
        StatLogUtils.e("packageRequestParameters " + Log.getStackTraceString(e));
    L22:
        e.printStackTrace();
        return;
    L27:
        return;
    }

    private static void packageResponseHeader(ResponseWrap r100, JSONObject r101) {
        SsResponse r102 = r100.ssResponse;     // Catch: Exception -> L29
        String r103 = "";
        if (r102 == null) goto L12;
        Header r104 = r102.raw().getFirstHeader(NW_SESSION_TRACE);     // Catch: Exception -> L29
        Header r105 = r100.ssResponse.raw().getFirstHeader("x-net-info.remoteaddr");     // Catch: Exception -> L29
        if (r104 == null) goto L9;
        String r106 = r100.ssResponse.raw().getFirstHeader(NW_SESSION_TRACE).getValue();     // Catch: Exception -> L29
    L10:
        if (r105 == null) goto L18;
        String r107 = r100.ssResponse.raw().getFirstHeader("x-net-info.remoteaddr").getValue();     // Catch: Exception -> L29
    L21:
        if (r106 != null) goto L24;
        r106 = "";
    L24:
        r101.put("nw-session-trace", r106);     // Catch: Exception -> L29
        if (r107 == null) goto L27;
        r103 = r107;
    L27:
        r101.put("server_ip", r103);     // Catch: Exception -> L29
        return;
    L18:
        r107 = "";
        goto L21
    L9:
        r106 = "";
        goto L10
    L12:
        Response r108 = r100.response;     // Catch: Exception -> L29
        if (r108 == null) goto L15;
        r106 = r108.header(NW_SESSION_TRACE);     // Catch: Exception -> L29
        r107 = r100.response.header("x-snssdk.remoteaddr");     // Catch: Exception -> L29
        goto L21
    L15:
        Map<String, String> r109 = r100.headers;     // Catch: Exception -> L29
        if (r109 == null) goto L19;
        r106 = r109.get(NW_SESSION_TRACE);     // Catch: Exception -> L29
        goto L18
    L19:
        r107 = "";
        r106 = r107;
    L29:
        e = move-exception;
        if (StatLogUtils.IsDebug() == false) goto L33;
        StatLogUtils.e("packageResponseHeader " + Log.getStackTraceString(e));
    L33:
        e.printStackTrace();
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerStart(String r100, String r101) {
        long r102 = getTime();
        RequestInfo r103 = this.mRequestInfoMap.get(r100);
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.reportV2Enabled == false) goto L8;
    L10:
        StringBuilder r104 = new StringBuilder(r100);
        Map<String, Long> r105 = r103.producerStartTimeMap;
        r104.append(r101);
        r105.put(r104.toString(), Long.valueOf(r102));
        JSONObject r106 = r103.extra;
        if (r106 == null) goto L21;
        JSONObject r107 = r106.optJSONObject(IMAGE_MONITOR_DATA);     // Catch: JSONException -> L16
        if (r107 == null) goto L22;
        r107.put(r101, new JSONObject());     // Catch: JSONException -> L16
        return;
    L22:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    L8:
        if (r103.reportExceedLimitEnabled == true) goto L10;
    }

    public static /* synthetic */ void access$400(FrescoTraceListener r100, String r101, long r102) {
        r100.onRequestCancellationInternal(r101, r102);
    }

    private void onRequestSuccessInternal(ImageRequest r310, String r311, long r312) {
        String r110 = r311;
        long r111 = r312;
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("FrescoMonitor#onImageLoaded");
    L5:
        RequestInfo r100 = this.mRequestInfoMap.remove(r110);
        if (r100 != null) goto L12;
        if (FrescoSystrace.isTracing() == false) goto L142;
        FrescoSystrace.endSection();
        return;
    L142:
        return;
    L12:
        if (r100.reportV2Enabled == true) goto L20;
        if (r100.reportExceedLimitEnabled == true) goto L20;
        if (FrescoSystrace.isTracing() == false) goto L143;
        FrescoSystrace.endSection();
        return;
    L143:
        return;
    L20:
        if (r310 != null) goto L22;
    L24:
        String r101 = "";
    L25:
        IFrescoMonitorSamplingDecider r102 = FrescoMonitor.getSamplingDecider();
        if (r102 != null) goto L134;
    L31:
        boolean r103 = true;
    L33:
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L39;
        Object[] r104 = new Object[3];
        if (r103 == false) goto L37;
        String r112 = BaseHttpRequestInfo.KEY_HIT;
    L38:
        r104[0] = r112;
        r104[1] = r101;
        r104[2] = r110;
        ALogService.dSafely(ALOGTAG, formatString("sampling %s onRequestSuccess: {url: %s, requestId: %s}", r104));
        goto L39
    L37:
        r112 = "miss";
    L39:
        if (r103 == false) goto L41;
        JSONObject r105 = r100.extra;
        if (FrescoMonitor.isReportHitCacheEnabled() == true) goto L47;
        boolean r106 = false;
        boolean r113 = r105.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false);
    L53:
        if (r105.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, r106) == true) goto L55;
    L57:
        String r107 = ALOGTAG;
    L140:
        Object r108 = r100.callerContext;     // Catch: JSONException -> L82
        if ((r108 instanceof String) == false) goto L61;
        r105.put(FrescoMonitorConst.SCENE_TAG, r108);     // Catch: JSONException -> L82
    L65:
        SizeDeterminer r109 = r310.getSizeDeterminer();     // Catch: JSONException -> L82
        if (r109 == null) goto L73;
        if (r109.getView() == null) goto L73;
        Context r114 = r109.getView().getContext();     // Catch: JSONException -> L82
        if ((r114 instanceof Activity) == false) goto L73;
        r105.put(FrescoMonitorConst.PAGE_TAG, ((Activity) r114).getClass().getSimpleName());     // Catch: JSONException -> L82
    L73:
        String r210 = r107;
        r105.put("duration", getCurrentTime(Long.valueOf(r100.requestStartTime), r111));     // Catch: JSONException -> L80
        r105.put(FrescoMonitorConst.LOAD_STATUS, "success");     // Catch: JSONException -> L80
        r105.put("timestamp", Long.valueOf(r100.requestStartTime));     // Catch: JSONException -> L80
        r105.put(FrescoMonitorConst.LOG_TYPE, FrescoMonitorConst.MONITOR_IMAGE_V2);     // Catch: JSONException -> L80
        r105.put(FrescoMonitorConst.LOG_VERSION, 1);     // Catch: JSONException -> L80
        r105.put("uri", r310.getSourceUri().toString());     // Catch: JSONException -> L80
        r105.put(FrescoMonitorConst.IMAGE_SDK_VERSION, "1.41.6");     // Catch: JSONException -> L80
        if (RetryInterceptManager.inst().isOpen() == false) goto L77;
        int r115 = 1;
    L78:
        r105.put(FrescoMonitorConst.RETRY_OPEN, r115);     // Catch: JSONException -> L80
        r105.put(FrescoMonitorConst.SOURCE_URI_TYPE, r310.getSourceUriType());     // Catch: JSONException -> L80
        r105.put("network_quality", TTNetInit.getEffectiveConnectionType());     // Catch: JSONException -> L80
    L85:
        String r116 = r210;
        String r117 = FrescoMonitorConst.SCENE_TAG;
        if (hookMonitor(r310, r311, r100.callerContext, r105, true, r113, false) == true) goto L88;
        return;
    L88:
        uriQueryParamToExtra(r105);
        if (r113 == true) goto L136;
        r111 = r111;
        r110 = r110;
        r117 = r117;
        RequestInfo r118 = r100;
    L124:
        char r119 = 1;
    L126:
        if (r105.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false) == false) goto L131;
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L131;
        Object[] r120 = new Object[5];
        r120[0] = Long.valueOf(r312);
        r120[r119] = r310.getSourceUri().toString();
        r120[2] = r110;
        r120[3] = Long.valueOf(getCurrentTime(Long.valueOf(r118.requestStartTime), r111));
        r120[4] = r105.optString(r117);
        ALogService.dSafely(r116, formatString("time %d: onRequestSuccess: {url: %s, requestId: %s, elapsedTime: %d ms, scene_tag: %s}", r120));
    L131:
        if (FrescoSystrace.isTracing() == false) goto L145;
        FrescoSystrace.endSection();
        return;
    L145:
        return;
    L136:
        JSONObject r121 = r105.optJSONObject(IMAGE_MONITOR_DATA);     // Catch: JSONException -> L112
        if (r121 == null) goto L97;
        r121.put("image_status", 0);     // Catch: JSONException -> L112
        if (r121.opt("image_origin") != null) goto L95;
        r121.put("image_origin", 7);     // Catch: JSONException -> L112
    L95:
        r121.put("disk_cache_type", ImageMonitorUtils.mapCacheChoiceToDiskCacheType(r310.getCacheChoice()));     // Catch: JSONException -> L112
        r105.put(FrescoMonitorConst.IMAGE_ORIGIN_SOURCE, r121.opt("image_origin"));     // Catch: JSONException -> L112
    L97:
        r105.put(FrescoMonitorConst.APPLIED_IMAGE_PX_COUNT, calAppliedImagePxCount(r105));     // Catch: JSONException -> L112
        r105.put(FrescoMonitorConst.INTENDED_IMAGE_PX_COUNT, calIntendedImagePxCount(r105));     // Catch: JSONException -> L112
        r105.put(FrescoMonitorConst.VIEW_NEEDED_IMAGE_PX_COUNT, calViewNeedImagePxCount(r310));     // Catch: JSONException -> L112
        r105.put("view_size", calViewImageSize(r310));     // Catch: JSONException -> L112
        if (r121 == null) goto L114;
        JSONObject r122 = r121.optJSONObject(BitmapMemoryCacheProducer.PRODUCER_NAME);     // Catch: JSONException -> L112
        long r123 = 0;
        if (r122 == null) goto L104;
        r123 = 0 + ((long) (JSONObjectProtectorUtils.getInt(r122, "producer_end") - JSONObjectProtectorUtils.getInt(r122, "producer_start")));     // Catch: JSONException -> L112
    L104:
        JSONObject r124 = r121.optJSONObject(EncodedMemoryCacheProducer.PRODUCER_NAME);     // Catch: JSONException -> L112
        if (r124 == null) goto L107;
        r123 = r123 + ((long) (JSONObjectProtectorUtils.getInt(r124, "producer_end") - JSONObjectProtectorUtils.getInt(r124, "producer_start")));     // Catch: JSONException -> L112
    L107:
        JSONObject r125 = r121.optJSONObject(DiskCacheReadProducer.PRODUCER_NAME);     // Catch: JSONException -> L112
        if (r125 == null) goto L110;
        r123 = r123 + ((long) (JSONObjectProtectorUtils.getInt(r125, "producer_end") - JSONObjectProtectorUtils.getInt(r125, r4)));     // Catch: JSONException -> L112
    L110:
        r105.put(FrescoMonitorConst.CACHE_SEEK_DURATION, r123);     // Catch: JSONException -> L112
    L114:
        r118 = r100;
        if (r118.reportExceedLimitEnabled == false) goto L121;
        if (ExceedTheLimitBitmapMonitor.isExceedTheLimitBitmapMonitorEnabled() == false) goto L121;
        ExceedTheLimitBitmapMonitor.checkAndReport(r310, r105.optString("image_type"), r105.optInt(FrescoMonitorConst.IMAGE_COUNT), r105.optString("biz_tag"), r105.optString(r117), r105.optString(FrescoMonitorConst.PAGE_TAG), r105.optString(FrescoMonitorConst.APPLIED_IMAGE_SIZE), r105.optLong("file_size"), r105.optString(FrescoMonitorConst.IMAGE_RAM_SIZE));
    L121:
        if (r118.reportV2Enabled == false) goto L124;
        r119 = 1;
        FrescoMonitor.onImageLoaded(true, r110, r105, r118.traceListenerSampled);
    L112:
        e = move-exception;
        FLog.e(TAG, e, "", new Object[0]);
        goto L114
    L77:
        r115 = 0;
    L80:
        e = e;
    L84:
        FLog.e(TAG, e, "", new Object[0]);
        goto L85
    L61:
        if (r108 == null) goto L65;
        if (TextUtils.isEmpty(r108.toString()) == true) goto L65;
        r105.put(FrescoMonitorConst.SCENE_TAG, r100.callerContext.toString());     // Catch: JSONException -> L82
    L82:
        e = e;
        r210 = r107;
        goto L84
    L55:
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L57;
        String r126 = formatString("time %d: onRequestSuccess: {url: %s, requestId: %s, elapsedTime: %d ms}", new Object[]{Long.valueOf(r312), r310.getSourceUri().toString(), r110, Long.valueOf(getCurrentTime(Long.valueOf(r100.requestStartTime), r111))});
        r107 = ALOGTAG;
        ALogService.dSafely(r107, r126);
        goto L140
    L47:
        if (r310.getSourceUriType() != 0) goto L49;
        boolean r127 = true;
    L50:
        r113 = r127;
        r106 = false;
        goto L53
    L49:
        r127 = false;
        goto L50
    L41:
        if (FrescoSystrace.isTracing() == false) goto L144;
        FrescoSystrace.endSection();
        return;
    L144:
        return;
    L134:
        r103 = r102.shouldSampleRequestSuccess(r310, r110, r100);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        FLog.w(TAG, th, "sampling decider error in onRequestSuccessInternal, fallback to sample", new Object[0]);
        goto L31
    L22:
        if (r310.getSourceUri() == null) goto L24;
        r101 = r310.getSourceUri().toString();
        goto L25
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithSuccess(String r310, String r311, Map<String, String> r312) {
        RequestInfo r100 = this.mRequestInfoMap.get(r310);
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.reportV2Enabled == false) goto L8;
    L10:
        long r101 = getTime();
        Map<String, Long> r110 = r100.producerStartTimeMap;
        if (r110.isEmpty() == false) goto L13;
        return;
    L13:
        Long r102 = r110.remove(r310 + r311);
        JSONObject r111 = r100.extra;
        if (r111 != null) goto L16;
        return;
    L16:
        JSONObject r112 = null;
        r112 = r111.optJSONObject(IMAGE_MONITOR_DATA);     // Catch: JSONException -> L28
        if (r112 == null) goto L27;
        JSONObject r113 = r112.optJSONObject(r311);     // Catch: JSONException -> L28
        if (r113 == null) goto L27;
        Long r313 = r102;
        r113.put("producer_start", r102.longValue() - Long.valueOf(r100.requestStartTime).longValue());     // Catch: JSONException -> L25
        r113.put("producer_end", r101 - r100.requestStartTime);     // Catch: JSONException -> L25
    L31:
        if (r312 != null) goto L33;
        return;
    L33:
        JSONObject r114 = r112;
        if (r100.reportV2Enabled == false) goto L207;
        Object r103 = "1";
        if (NetworkFetchProducer.PRODUCER_NAME.equals(r311) == false) goto L94;
        String r104 = r312.get("content_length");     // Catch: NumberFormatException -> L87 JSONException -> L90
        String r105 = r312.get("image_size");     // Catch: NumberFormatException -> L87 JSONException -> L90
        if (TextUtils.isEmpty(r104) == true) goto L67;
        long r106 = CastLongProtector.parseLong(r104);     // Catch: NumberFormatException -> L87 JSONException -> L90
    L69:
        if (TextUtils.isEmpty(r105) == true) goto L71;
        long r107 = CastLongProtector.parseLong(r105);     // Catch: NumberFormatException -> L87 JSONException -> L90
    L72:
        r111.put("file_size", r107);     // Catch: NumberFormatException -> L87 JSONException -> L90
        r111.put("content_length", r106);     // Catch: NumberFormatException -> L87 JSONException -> L90
        if (r106 == r107) goto L76;
        r103 = "0";
    L76:
        r111.put(FrescoMonitorConst.FILE_CONSISTENT, r103);     // Catch: NumberFormatException -> L87 JSONException -> L90
        r111.put("hit_cdn_cache", r312.get("hit_cdn_cache"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r111.put("x_response_cache", r312.get("x_response_cache"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r111.put("imagex_demotion", r312.get("imagex_demotion"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r111.put("imagex_want_fmt", r312.get("imagex_want_fmt"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r111.put("imagex_true_fmt", r312.get("imagex_true_fmt"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r111.put("imagex_consistency", r312.get("imagex_consistency"));     // Catch: NumberFormatException -> L87 JSONException -> L90
        r111.put("is_prefetch_image", r312.get("is_prefetch_image"));     // Catch: NumberFormatException -> L87 JSONException -> L90
    L203:
        getHeaders(r111).put(FrescoMonitorConst.RESPONSE_HEADER_X_RESPONSE_CACHE, r312.get("x_response_cache"));     // Catch: NumberFormatException -> L83 JSONException -> L85
        if (TextUtils.isEmpty(r312.get(FrescoMonitorConst.RESPONSE_HEADER_X_IMAGEX_EXTRA)) == true) goto L81;
        getHeaders(r111).put(FrescoMonitorConst.RESPONSE_HEADER_X_IMAGEX_EXTRA, r312.get(FrescoMonitorConst.RESPONSE_HEADER_X_IMAGEX_EXTRA));     // Catch: NumberFormatException -> L83 JSONException -> L85
    L81:
        r111.put(FrescoMonitorConst.IMAGEX_CUSTOM_PARAM, r312.get(FrescoMonitorConst.IMAGEX_CUSTOM_PARAM));     // Catch: NumberFormatException -> L83 JSONException -> L85
    L172:
        if (SimplayerImageStrategy.isUploadLog() == false) goto L215;
        String r108 = r312.get("strategy_center");
        if (r108 != null) goto L176;
        return;
    L176:
        if (r108.isEmpty() == true) goto L217;
        r111.put("strategy_center", r108);     // Catch: JSONException -> L179
    L182:
        if (SimplayerImageStrategy.isOpenLog() == true) goto L184;
        return;
    L184:
        return;
    L179:
        e = move-exception;
        e.printStackTrace();
        goto L182
    L217:
        return;
    L215:
        return;
    L83:
        e = e;
    L89:
        e.printStackTrace();
    L85:
        e = e;
    L92:
        e.printStackTrace();
        goto L172
    L71:
        r107 = -1;
        goto L72
    L67:
        r106 = -1;
    L87:
        e = e;
    L90:
        e = e;
        goto L92
    L94:
        if (FrescoTTNetFetcher.BLURHASH_PRODUCER_NAME.equals(r311) == false) goto L100;
        r111.put("blurhash_decode_duration", r312.get("blurhash_decode_duration"));     // Catch: JSONException -> L97
        r111.put(FrescoMonitorConst.BLURHASH_DURATION, r101 - r100.requestStartTime);     // Catch: JSONException -> L97
    L97:
        e = move-exception;
        e.printStackTrace();
        goto L172
    L100:
        if (DiskCacheWriteProducer.PRODUCER_NAME.equals(r311) == false) goto L111;
        r111.put("image_type", (String) r312.get("imageType"));     // Catch: JSONException -> L108
        Object r109 = (String) r312.get("encodedImageSize");     // Catch: JSONException -> L108
        if ("-1x-1".equals(r109) == false) goto L104;
    L105:
        r109 = (String) r312.get(DecodeProducer.EXTRA_BITMAP_SIZE);     // Catch: JSONException -> L108
    L106:
        r111.put(FrescoMonitorConst.APPLIED_IMAGE_SIZE, r109);     // Catch: JSONException -> L108
        goto L172
    L104:
        if ("unknown".equals(r109) == false) goto L106;
    L108:
        e = move-exception;
        e.printStackTrace();
        goto L172
    L111:
        if (DecodeProducer.PRODUCER_NAME.equals(r311) == false) goto L153;
        Object r115 = (String) r312.get(DecodeProducer.REQUESTED_IMAGE_SIZE);     // Catch: NumberFormatException -> L148 JSONException -> L150
        if ("unknown".equals(r115) == false) goto L115;
        r115 = "0x0";
    L115:
        r111.put(FrescoMonitorConst.INTENDED_IMAGE_SIZE, r115);     // Catch: NumberFormatException -> L148 JSONException -> L150
        Object r116 = (String) r312.get("encodedImageSize");     // Catch: NumberFormatException -> L148 JSONException -> L150
        if ("-1x-1".equals(r116) == false) goto L118;
    L119:
        r116 = (String) r312.get(DecodeProducer.EXTRA_BITMAP_SIZE);     // Catch: NumberFormatException -> L148 JSONException -> L150
    L120:
        r111.put("isCrop", r312.get("isCrop"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("regionToDecode", r312.get("regionToDecode"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("sampleSize", r312.get("sampleSize"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put(FrescoMonitorConst.APPLIED_IMAGE_SIZE, r116);     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put(FrescoMonitorConst.DECODE_DURATION, r101 - r313.longValue());     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("image_type", r312.get("imageFormat"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put(FrescoMonitorConst.IMAGE_RAM_SIZE, r312.get(DecodeProducer.EXTRA_BITMAP_RAM_SIZE));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put(FrescoMonitorConst.IMAGE_COUNT, CastIntegerProtector.parseInt(r312.get(DecodeProducer.EXTRA_IMAGE_COUNT)));     // Catch: NumberFormatException -> L148 JSONException -> L150
        Object r117 = (String) r312.get("hdr_type");     // Catch: NumberFormatException -> L148 JSONException -> L150
        if ("-1".equals(r117) == true) goto L123;
        r111.put("hdr_type", r117);     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put(FrescoMonitorConst.USE_TTHEIF_RGBA_102, FrescoCacheMonitorUtil.isUseHeicHdrRgba102());     // Catch: NumberFormatException -> L148 JSONException -> L150
    L123:
        r111.put("extra_bitmap_config", r312.get("extra_bitmap_config"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        if (r114 == null) goto L126;
        r114.put("decode_queue_duration", CastLongProtector.parseLong(r312.get("queueTime")));     // Catch: NumberFormatException -> L148 JSONException -> L150
    L126:
        r111.put(FrescoMonitorConst.IMAGE_QUALITY, r312.get(DecodeProducer.EXTRA_IMAGE_QUALITY));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("heic_sys_first", r312.get("heic_sys_first"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("size_abnormal", r312.get("size_abnormal"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("heic_custom_decoder", r312.get("heic_custom_decoder"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        String r118 = r312.get("heic_decode_error");     // Catch: Exception -> L131
        if (r118 == null) goto L135;
        r111.put("err_code", CastIntegerProtector.parseInt(r118));     // Catch: Exception -> L131
    L135:
        if (r312.get("thumb_decode_duration") == null) goto L138;
        r111.put("thumb_file_size", r312.get("thumb_file_size"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("thumb_decode_duration", r312.get("thumb_decode_duration"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put(FrescoMonitorConst.THUMB_DOWNLOAD_DURATION, System.currentTimeMillis() - r100.requestStartTime);     // Catch: NumberFormatException -> L148 JSONException -> L150
    L138:
        if (r312.get("preview_used") == null) goto L143;
        if ("1".equals(r312.get("preview_used")) == false) goto L143;
        r111.put("preview_used", r312.get("preview_used"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("preview_algo", r312.get("preview_algo"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("preview_duration", r312.get("preview_duration"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("preview_error", r312.get("preview_error"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("preview_hash_decode_duration", r312.get("preview_hash_decode_duration"));     // Catch: NumberFormatException -> L148 JSONException -> L150
    L143:
        if ("1".equalsIgnoreCase(r312.get(FrescoMonitorConst.SR_HEIC_OPT)) == false) goto L172;
        String r119 = r312.get("sr_duration");     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put(FrescoMonitorConst.SR_HEIC_OPT, r312.get(FrescoMonitorConst.SR_HEIC_OPT));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("sr_type", r312.get("sr_type"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("sr_status", r312.get("sr_status"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("sr_duration", r119);     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("sr_width", r312.get("sr_width"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("sr_height", r312.get("sr_height"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("sr_stretch", r312.get("sr_stretch"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("scale_type", r312.get("scale_type"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("enable_all", r312.get("enable_all"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("sr_max_width", r312.get("sr_max_width"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("sr_max_height", r312.get("sr_max_height"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        r111.put("sr_err", r312.get("sr_err"));     // Catch: NumberFormatException -> L148 JSONException -> L150
        if (TextUtils.isEmpty(r119) == true) goto L172;
        r111.put(FrescoMonitorConst.DECODE_DURATION, (r101 - r313.longValue()) - ((long) CastIntegerProtector.parseInt(r119)));     // Catch: NumberFormatException -> L148 JSONException -> L150
    L131:
        e = move-exception;
        e.printStackTrace();     // Catch: NumberFormatException -> L148 JSONException -> L150
        goto L135
    L118:
        if ("unknown".equals(r116) == false) goto L120;
    L148:
        e = move-exception;
        e.printStackTrace();
    L150:
        e = move-exception;
        e.printStackTrace();
        goto L172
    L153:
        if (ThreadHandoffProducer.PRODUCER_NAME.equals(r311) == false) goto L160;
        if (r114 == null) goto L172;
        r114.put("pause_time", r312.get(ThreadHandoffProducer.EXTRA_PENDING_TIME));     // Catch: JSONException -> L157
    L157:
        e = move-exception;
        e.printStackTrace();
        goto L172
    L160:
        if (PostprocessorProducer.NAME.equals(r311) == false) goto L172;
    L165:
        e = move-exception;
        e.printStackTrace();
    L191:
        r111.put("sharp_type", r312.get("sharp_type"));     // Catch: JSONException -> L169
        r111.put("sharp_status", r312.get("sharp_status"));     // Catch: JSONException -> L169
        r111.put("sharp_duration", r312.get("sharp_duration"));     // Catch: JSONException -> L169
        r111.put("sharp_error", r312.get("sharp_error"));     // Catch: JSONException -> L169
        r111.put("sharp_wt", r312.get("sharp_wt"));     // Catch: JSONException -> L169
        r111.put("sharp_thr", r312.get("sharp_thr"));     // Catch: JSONException -> L169
        r111.put("sharp_ovrt", r312.get("sharp_ovrt"));     // Catch: JSONException -> L169
        r111.put("sharp_adaptive", r312.get("sharp_adaptive"));     // Catch: JSONException -> L169
        r111.put("sharp_g0", r312.get("sharp_g0"));     // Catch: JSONException -> L169
        r111.put("sharp_lc_wt_thr", r312.get("sharp_lc_wt_thr"));     // Catch: JSONException -> L169
    L169:
        e = move-exception;
        e.printStackTrace();
        goto L172
    L162:
        if ("1".equalsIgnoreCase(r312.get(FrescoMonitorConst.SR_HEIC_OPT)) == true) goto L191;
        r111.put(FrescoMonitorConst.SR_HEIC_OPT, r312.get(FrescoMonitorConst.SR_HEIC_OPT));     // Catch: JSONException -> L165
        r111.put("sr_type", r312.get("sr_type"));     // Catch: JSONException -> L165
        r111.put("sr_status", r312.get("sr_status"));     // Catch: JSONException -> L165
        r111.put("sr_duration", r312.get("sr_duration"));     // Catch: JSONException -> L165
        r111.put("sr_width", r312.get("sr_width"));     // Catch: JSONException -> L165
        r111.put("sr_height", r312.get("sr_height"));     // Catch: JSONException -> L165
        r111.put("sr_stretch", r312.get("sr_stretch"));     // Catch: JSONException -> L165
        r111.put("scale_type", r312.get("scale_type"));     // Catch: JSONException -> L165
        r111.put("enable_all", r312.get("enable_all"));     // Catch: JSONException -> L165
        r111.put("sr_max_width", r312.get("sr_max_width"));     // Catch: JSONException -> L165
        r111.put("sr_max_height", r312.get("sr_max_height"));     // Catch: JSONException -> L165
        r111.put("sr_err", r312.get("sr_err"));     // Catch: JSONException -> L165
        goto L191
    L207:
    L57:
        e = move-exception;
        e.printStackTrace();
        return;
    L36:
        if (NetworkFetchProducer.PRODUCER_NAME.equals(r311) == false) goto L41;
        String r120 = r312.get("image_size");     // Catch: Throwable -> L57 JSONException -> L59
        if (TextUtils.isEmpty(r120) == true) goto L210;
        r111.put("file_size", CastLongProtector.parseLong(r120));     // Catch: Throwable -> L57 JSONException -> L59
        return;
    L210:
        return;
    L41:
        if (DiskCacheWriteProducer.PRODUCER_NAME.equals(r311) == false) goto L49;
        r111.put("image_type", r312.get("imageType"));     // Catch: Throwable -> L57 JSONException -> L59
        Object r121 = (String) r312.get("encodedImageSize");     // Catch: Throwable -> L57 JSONException -> L59
        if ("-1x-1".equals(r121) == false) goto L45;
    L46:
        r121 = (String) r312.get(DecodeProducer.EXTRA_BITMAP_SIZE);     // Catch: Throwable -> L57 JSONException -> L59
    L47:
        r111.put(FrescoMonitorConst.APPLIED_IMAGE_SIZE, r121);     // Catch: Throwable -> L57 JSONException -> L59
        return;
    L45:
        if ("unknown".equals(r121) == false) goto L47;
    L49:
        if (DecodeProducer.PRODUCER_NAME.equals(r311) == false) goto L213;
        Object r122 = (String) r312.get("encodedImageSize");     // Catch: Throwable -> L57 JSONException -> L59
        if ("-1x-1".equals(r122) == false) goto L53;
    L54:
        r122 = (String) r312.get(DecodeProducer.EXTRA_BITMAP_SIZE);     // Catch: Throwable -> L57 JSONException -> L59
    L55:
        r111.put(FrescoMonitorConst.APPLIED_IMAGE_SIZE, r122);     // Catch: Throwable -> L57 JSONException -> L59
        r111.put("image_type", r312.get("imageFormat"));     // Catch: Throwable -> L57 JSONException -> L59
        r111.put(FrescoMonitorConst.IMAGE_RAM_SIZE, r312.get(DecodeProducer.EXTRA_BITMAP_RAM_SIZE));     // Catch: Throwable -> L57 JSONException -> L59
        r111.put(FrescoMonitorConst.IMAGE_COUNT, CastIntegerProtector.parseInt(r312.get(DecodeProducer.EXTRA_IMAGE_COUNT)));     // Catch: Throwable -> L57 JSONException -> L59
        return;
    L53:
        if ("unknown".equals(r122) == false) goto L55;
    L213:
        return;
    L25:
        e = e;
    L30:
        e.printStackTrace();
    L27:
        r313 = r102;
    L28:
        e = e;
        r313 = r102;
        goto L30
    L8:
        if (r100.reportExceedLimitEnabled == true) goto L10;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener
    public void onRequestIntermediateResult(final ImageRequest r110, final String r111, final boolean r112) {
        final long r100 = getTime();
        sExecutor.submit(new AnonymousClass6(this, r110, r111, r112, r100));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(final ImageRequest r100, final String r101, boolean r110) {
        final long r102 = getTime();
        sExecutor.submit(new AnonymousClass3(this, r100, r101, r102));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onUltimateProducerReached(String r100, String r101, boolean r102) {
        RequestInfo r103 = this.mRequestInfoMap.get(r100);
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.reportV2Enabled == true) goto L8;
        return;
    L8:
        JSONObject r104 = r103.extra;
        if (r104 != null) goto L18;
        return;
    L18:
        JSONObject r105 = r104.optJSONObject(IMAGE_MONITOR_DATA);     // Catch: JSONException -> L15
        if (r105 == null) goto L20;
        r105.put("image_origin", ImageMonitorUtils.mapProducerNameToImageMonitorOrigin(r101));     // Catch: JSONException -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ void access$200(FrescoTraceListener r100, ImageRequest r101, String r102, long r103) {
        r100.onRequestSuccessInternal(r101, r102, r103);
    }

    private void onRequestFailureInternal(ImageRequest r210, String r211, long r212, Throwable r310) {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("FrescoMonitor#onRequestFailure");
    L5:
        RequestInfo r110 = this.mRequestInfoMap.remove(r211);
        if (r110 != null) goto L9;
        return;
    L9:
        if (r110.reportV2Enabled == false) goto L11;
        JSONObject r100 = r110.extra;
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L22;
        if (r310 == null) goto L18;
        String r101 = r310.toString();
    L19:
        String r111 = "";
        String r102 = formatString("time %d: onRequestFailure: {url: %s, requestId: %s, elapsedTime: %d ms, throwable: %s}", new Object[]{Long.valueOf(r212), r210.getSourceUri().toString(), r211, Long.valueOf(getCurrentTime(Long.valueOf(r110.requestStartTime), r212)), r101});
        if (isCanceledInfo(r101) == true) goto L24;
        ALogService.eSafely(ALOGTAG, r102, r310);
    L24:
        if (FrescoMonitor.isReportHitCacheEnabled() == true) goto L26;
        boolean r103 = r100.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false);
    L30:
        boolean r213 = r103;
        if (r310 != null) goto L33;
        int r104 = 200;
    L91:
        Object r105 = r110.callerContext;     // Catch: JSONException -> L54
        if ((r105 instanceof String) == false) goto L37;
        r100.put(FrescoMonitorConst.SCENE_TAG, r105);     // Catch: JSONException -> L54
    L41:
        r100.put(FrescoMonitorConst.LOAD_STATUS, "fail");     // Catch: JSONException -> L54
        r100.put("duration", getCurrentTime(Long.valueOf(r110.requestStartTime), r212));     // Catch: JSONException -> L54
        r100.put("err_code", r104);     // Catch: JSONException -> L54
        String r106 = getErrMsg(r310);     // Catch: JSONException -> L54
        if (TextUtils.isEmpty(r106) == false) goto L44;
        r106 = Log.getStackTraceString(r310);     // Catch: JSONException -> L54
    L44:
        r100.put(FrescoMonitorConst.ERR_DESC, r106);     // Catch: JSONException -> L54
        r100.put("timestamp", Long.valueOf(r110.requestStartTime));     // Catch: JSONException -> L54
        r100.put(FrescoMonitorConst.LOG_TYPE, FrescoMonitorConst.MONITOR_IMAGE_V2);     // Catch: JSONException -> L54
        r100.put(FrescoMonitorConst.LOG_VERSION, 1);     // Catch: JSONException -> L52
        r100.put("uri", r210.getSourceUri().toString());     // Catch: JSONException -> L52
        r100.put(FrescoMonitorConst.IMAGE_SDK_VERSION, "1.41.6");     // Catch: JSONException -> L52
        if (RetryInterceptManager.inst().isOpen() == false) goto L49;
        int r107 = 1;
    L50:
        r100.put(FrescoMonitorConst.RETRY_OPEN, r107);     // Catch: JSONException -> L52
        r100.put(FrescoMonitorConst.SOURCE_URI_TYPE, r210.getSourceUriType());     // Catch: JSONException -> L52
        r100.put("network_quality", TTNetInit.getEffectiveConnectionType());     // Catch: JSONException -> L52
        String r108 = r111;
    L57:
        String r214 = r108;
        int r109 = r104;
        hookMonitor(r210, r211, r110.callerContext, r100, false, r213, false);
        uriQueryParamToExtra(r100);
        if (r213 == false) goto L76;
        int r112 = ImageMonitorUtils.getImageMonitorDataStatus(r310);
        JSONObject r113 = r100.optJSONObject(IMAGE_MONITOR_DATA);     // Catch: JSONException -> L72
        if (r113 == null) goto L71;
        r113.put("image_status", r112);     // Catch: JSONException -> L72
        char r114 = 1;
        if (r109 == 1) goto L66;
        boolean r115 = true;
    L93:
        r113.put("image_load_error_code", ImageMonitorUtils.getImageLoadErrorCode(r310, r115));     // Catch: JSONException -> L69
        r113.put("disk_cache_type", ImageMonitorUtils.mapCacheChoiceToDiskCacheType(r210.getCacheChoice()));     // Catch: JSONException -> L69
    L75:
        char r116 = 0;
        FrescoMonitor.onImageLoaded(false, r211, r100, r110.traceListenerSampled);
    L78:
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L86;
        if (r310 == null) goto L81;
        String r117 = r310.toString();
    L82:
        Object[] r118 = new Object[6];
        r118[r116] = Long.valueOf(r212);
        r118[r114] = r210.getSourceUri().toString();
        r118[2] = r211;
        r118[3] = Long.valueOf(getCurrentTime(Long.valueOf(r110.requestStartTime), r212));
        r118[4] = r117;
        r118[5] = r100.optString(FrescoMonitorConst.SCENE_TAG);
        String r119 = formatString("time %d: onRequestFailure: {url: %s, requestId: %s, elapsedTime: %d ms, throwable: %s, scene_tag: %s}", r118);
        if (isCanceledInfo(r117) == true) goto L86;
        ALogService.eSafely(ALOGTAG, r119, r310);
        goto L86
    L81:
        r117 = r214;
    L86:
        if (FrescoSystrace.isTracing() == false) goto L98;
        FrescoSystrace.endSection();
        return;
    L98:
        return;
    L69:
        e = e;
    L74:
        e.printStackTrace();
        goto L75
    L66:
        r115 = false;
        goto L93
    L71:
        r114 = 1;
    L72:
        e = e;
        r114 = 1;
        goto L74
    L76:
        r116 = 0;
        r114 = 1;
        goto L78
    L49:
        r107 = 0;
    L52:
        e = e;
    L56:
        r108 = r111;
        FLog.e(TAG, e, r108, new Object[0]);
        goto L57
    L37:
        if (r105 == null) goto L41;
        if (TextUtils.isEmpty(r105.toString()) == true) goto L41;
        r100.put(FrescoMonitorConst.SCENE_TAG, r110.callerContext.toString());     // Catch: JSONException -> L54
    L54:
        e = e;
        goto L56
    L33:
        r104 = NetUtils.checkHttpRequestException(r310, null);
        goto L91
    L26:
        if (r210.getSourceUriType() != 0) goto L28;
        r103 = true;
        goto L30
    L28:
        r103 = false;
        goto L30
    L18:
        r101 = "";
        goto L19
    L22:
        r111 = "";
        goto L24
    L11:
        if (FrescoSystrace.isTracing() == false) goto L97;
        FrescoSystrace.endSection();
        return;
    }

    private void onRequestIntermediateResultInternal(ImageRequest r100, String r101, boolean r102, long r103) {
        RequestInfo r104 = this.mRequestInfoMap.get(r101);
        if (r104 != null) goto L6;
        return;
    L6:
        if (r104.reportV2Enabled == true) goto L9;
        return;
    L9:
        if (r104.isFirstIntermediateResult == false) goto L18;
        r104.isFirstIntermediateResult = false;
        JSONObject r105 = r104.extra;
        if (r105 != null) goto L16;
        return;
    L16:
        r105.put(FrescoMonitorConst.FIRST_INTERMEDIATE_RESULT, getCurrentTime(Long.valueOf(r104.requestStartTime), r103));     // Catch: JSONException -> L15
        return;
    L19:
        return;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithFailure(String r110, String r210, Throwable r211, Map<String, String> r212) {
        long r100 = getTime();
        RequestInfo r111 = this.mRequestInfoMap.get(r110);
        if (r111 != null) goto L6;
        return;
    L6:
        if (r111.reportV2Enabled == true) goto L8;
        return;
    L8:
        JSONObject r112 = r111.extra;
        if (r112 != null) goto L12;
        return;
    L12:
        if (r212 != null) goto L14;
        HashMap r113 = new HashMap();
        r113.put("image_size", "-1");
        r113.put("queue_time", "-1");
        r113.put("fetch_time", "-1");
        Map r114 = r113;
    L15:
        JSONObject r101 = r112.optJSONObject(IMAGE_MONITOR_DATA);
        if (NetworkFetchProducer.PRODUCER_NAME.equals(r210) == false) goto L35;
        r112.put("fail_phase", "download");     // Catch: NumberFormatException -> L30 JSONException -> L32
        r112.put("download_duration", -1);     // Catch: NumberFormatException -> L30 JSONException -> L32
        String r102 = (String) r114.get("content_length");     // Catch: NumberFormatException -> L30 JSONException -> L32
        String r103 = (String) r114.get("image_size");     // Catch: NumberFormatException -> L30 JSONException -> L32
        String r104 = (String) r114.get("queue_time");     // Catch: NumberFormatException -> L30 JSONException -> L32
        long r105 = -1;
        if (TextUtils.isEmpty(r102) == true) goto L20;
        long r115 = CastLongProtector.parseLong(r102);     // Catch: NumberFormatException -> L30 JSONException -> L32
    L22:
        if (TextUtils.isEmpty(r103) == true) goto L24;
        long r106 = CastLongProtector.parseLong(r103);     // Catch: NumberFormatException -> L30 JSONException -> L32
    L26:
        if (TextUtils.isEmpty(r104) == true) goto L28;
        r105 = CastLongProtector.parseLong(r104);     // Catch: NumberFormatException -> L30 JSONException -> L32
    L28:
        r112.put("file_size", r106);     // Catch: NumberFormatException -> L30 JSONException -> L32
        r112.put("content_length", r115);     // Catch: NumberFormatException -> L30 JSONException -> L32
        r112.put("queue_duration", r105);     // Catch: NumberFormatException -> L30 JSONException -> L32
    L45:
        StringBuilder r107 = new StringBuilder(r110);
        Map<String, Long> r108 = r111.producerStartTimeMap;
        if (r108.isEmpty() == false) goto L48;
        return;
    L48:
        r107.append(r210);
        Long r109 = r108.remove(r107.toString());
        if (FrescoMonitor.isEnableMonitorLog() == false) goto L55;
        String r116 = r211.toString();
        long r117 = r100;
        String r118 = formatString("time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", new Object[]{Long.valueOf(r100), r110, r210, Long.valueOf(getCurrentTime(r109, r117)), r114, r116});
        if (isCanceledInfo(r116) == false) goto L53;
        ALogService.eSafely(ALOGTAG, r118);
        Throwable r119 = r211;
    L54:
        FLog.e(ALOGTAG, r118, r119);
    L56:
        if (r101 == null) goto L70;
        JSONObject r120 = r101.optJSONObject(r210);     // Catch: JSONException -> L61
        if (r120 == null) goto L71;
        r120.put("producer_start", r109.longValue() - Long.valueOf(r111.requestStartTime).longValue());     // Catch: JSONException -> L61
        r120.put("producer_end", r117 - r111.requestStartTime);     // Catch: JSONException -> L61
        return;
    L71:
        return;
    L61:
        e = move-exception;
        e.printStackTrace();
        return;
    L70:
        return;
    L53:
        r119 = r211;
        ALogService.eSafely(ALOGTAG, r118, r119);
        goto L54
    L55:
        r117 = r100;
        goto L56
    L24:
        r106 = -1;
        goto L26
    L20:
        r115 = -1;
    L30:
        e = move-exception;
        e.printStackTrace();
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L35:
        if (DecodeProducer.PRODUCER_NAME.equals(r210) == false) goto L45;
        r112.put("fail_phase", "decode");     // Catch: NumberFormatException -> L41 JSONException -> L43
        r112.put("download_duration", r114.get("fetch_time"));     // Catch: NumberFormatException -> L41 JSONException -> L43
        if (r101 == null) goto L39;
        r101.put("decode_queue_duration", CastLongProtector.parseLong((String) r114.get("queueTime")));     // Catch: NumberFormatException -> L41 JSONException -> L43
    L39:
        r112.put("heic_sys_first", r114.get("heic_sys_first"));     // Catch: NumberFormatException -> L41 JSONException -> L43
        r112.put("size_abnormal", r114.get("size_abnormal"));     // Catch: NumberFormatException -> L41 JSONException -> L43
        r112.put("heic_custom_decoder", r114.get("heic_custom_decoder"));     // Catch: NumberFormatException -> L41 JSONException -> L43
    L41:
        e = move-exception;
        e.printStackTrace();
    L43:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L14:
        r114 = r212;
        goto L15
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(final ImageRequest r100, final String r110, final Throwable r111, boolean r112) {
        final long r101 = getTime();
        sExecutor.submit(new AnonymousClass4(this, r100, r110, r101, r111));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
        long r104 = getTime();
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("FrescoMonitor#onRequestStart");
    L5:
        RequestInfo r105 = new RequestInfo(this);
        r105.requestId = r102;
        r105.requestStartTime = r104;
        r105.callerContext = r101;
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == false) goto L15;
        boolean r106 = FrescoMonitor.getLogTypeSwitch(FrescoMonitorConst.MONITOR_IMAGE_V2);
        r105.reportExceedLimitEnabled = FrescoMonitor.getLogTypeSwitch(FrescoMonitorConst.MONITOR_IMAGE_Exceed_Limit_V2);
        boolean[] r107 = FrescoMonitor.sampleImageTraceListeners(r100, r101, r102, r106);
        r105.traceListenerSampled = r107;
        if (r106 == true) goto L12;
        if (r107 != null) goto L12;
        boolean r108 = false;
    L13:
        r105.reportV2Enabled = r108;
    L12:
        r108 = true;
    L15:
        if (TextUtils.isEmpty(r102) == true) goto L33;
        JSONObject r109 = new JSONObject();
        if (r105.reportV2Enabled == false) goto L24;
        if (FrescoMonitor.isReportImageMonitorDataEnabled() == false) goto L24;
        r109.put(IMAGE_MONITOR_DATA, new JSONObject());     // Catch: JSONException -> L22
    L24:
        if (r105.reportV2Enabled == false) goto L26;
    L27:
        String r110 = FrescoMonitor.getCurrentScene();
        String r111 = FrescoMonitor.getCurrentActivity();
        if (r110 != null) goto L40;
    L30:
        if (r111 == null) goto L32;
        r109.put(FrescoMonitorConst.PAGE_TAG, r111);     // Catch: JSONException -> L37
    L32:
        r105.extra = r109;
        goto L33
    L40:
        r109.put(FrescoMonitorConst.SCENE_TAG, r110);     // Catch: JSONException -> L37
        goto L30
    L26:
        if (r105.reportExceedLimitEnabled == false) goto L32;
    L33:
        this.mRequestInfoMap.put(r102, r105);
        if (FrescoSystrace.isTracing() == false) goto L42;
        FrescoSystrace.endSection();
        return;
    }

    public static /* synthetic */ void access$300(FrescoTraceListener r100, ImageRequest r101, String r102, long r103, Throwable r104) {
        r100.onRequestFailureInternal(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$500(FrescoTraceListener r100, ImageRequest r101, String r102, boolean r103, long r104) {
        r100.onRequestIntermediateResultInternal(r101, r102, r103, r104);
    }

    private boolean hookMonitor(ImageRequest r110, String r111, Object r112, JSONObject r113, boolean r114, boolean r115, boolean r210) {
        JSONObject r100 = shallowCopy(r113);
        IMonitorHook r101 = FrescoMonitor.getMonitorHook();
        if (r101 != null) goto L64;
    L17:
        boolean r102 = r115;
    L19:
        if (FrescoCacheMonitorUtil.isOptListenerAnr() == false) goto L35;
        Iterator<IMonitorHookV2> r116 = FrescoMonitor.sNewMonitorHookV2s.iterator();
        boolean r117 = r102;
    L22:
        if (r116.hasNext() == false) goto L85;
        Pair<Boolean, Map<String, Object>> r103 = r116.next().onMonitorCompleted(r110, r112, r111, r100, r114, r210);
        if (r103 == null) goto L22;
        if (r117 == true) goto L27;
        r117 = ((Boolean) r103.first).booleanValue();
    L27:
        Map r104 = (Map) r103.second;
        if (r104 == null) goto L22;
        Iterator r105 = r104.keySet().iterator();     // Catch: JSONException -> L34
    L31:
        if (r105.hasNext() == false) goto L22;
        String r106 = (String) r105.next();     // Catch: JSONException -> L34
        r113.put(r106, r104.get(r106));     // Catch: JSONException -> L34
    L85:
        return r117;
    L35:
        List<IMonitorHookV2> r118 = FrescoMonitor.sMonitorHookV2s;
        monitor-enter(r118);
        Iterator<IMonitorHookV2> r119 = r118.iterator();     // Catch: Throwable -> L54
        boolean r120 = r102;
    L39:
        if (r119.hasNext() == false) goto L51;
        Pair<Boolean, Map<String, Object>> r107 = r119.next().onMonitorCompleted(r110, r112, r111, r100, r114, r210);     // Catch: Throwable -> L54
        if (r107 == null) goto L39;
        if (r120 == true) goto L44;
        r120 = ((Boolean) r107.first).booleanValue();     // Catch: Throwable -> L54
    L44:
        Map r108 = (Map) r107.second;     // Catch: Throwable -> L54
        if (r108 == null) goto L39;
        Iterator r109 = r108.keySet().iterator();     // Catch: JSONException -> L57 Throwable -> L54
    L48:
        if (r109.hasNext() == false) goto L39;
        String r121 = (String) r109.next();     // Catch: JSONException -> L57 Throwable -> L54
        r113.put(r121, r108.get(r121));     // Catch: JSONException -> L57 Throwable -> L54
    L51:
        monitor-exit(r118);     // Catch: Throwable -> L54
        return r120;
    L54:
        th = move-exception;
        throw th;
    L64:
        Pair<Boolean, Map<String, Object>> r122 = r101.onMonitorCompleted(r110, r112, r111, r100, r114);     // Catch: Exception -> L7
    L8:
        if (r122 == null) goto L17;
        r102 = ((Boolean) r122.first).booleanValue();
        Map r123 = (Map) r122.second;
        if (r123 == null) goto L19;
        Iterator r124 = r123.keySet().iterator();     // Catch: JSONException -> L16
    L13:
        if (r124.hasNext() == false) goto L19;
        String r125 = (String) r124.next();     // Catch: JSONException -> L16
        r113.put(r125, r123.get(r125));     // Catch: JSONException -> L16
    L7:
        r122 = null;
        goto L8
    }
}
