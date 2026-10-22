package wi2;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vi2.u0;

/* JADX INFO: loaded from: classes10.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f559774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f559775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f559776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f559777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f559778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f559779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f559780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f559781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f559782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f559783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C8116a f559784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f559785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f559786m;

    /* JADX INFO: renamed from: wi2.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lwi2/a$a;", "", "", "exceptionName", "Ljava/lang/String;", "getExceptionName", "()Ljava/lang/String;", "exceptionMessage", "getExceptionMessage", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C8116a {

        @SerializedName("exception_message")
        private final String exceptionMessage;

        @SerializedName(CrashHianalyticsData.EXCEPTION_NAME)
        private final String exceptionName;

        public C8116a() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C8116a) == false) goto L10;
            C8116a r101 = (C8116a) r100;
            if (Intrinsics.areEqual(this.exceptionName, r101.exceptionName) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.exceptionMessage, r101.exceptionMessage) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.exceptionName;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.exceptionMessage;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ErrorInfo(exceptionName=" + this.exceptionName + ", exceptionMessage=" + this.exceptionMessage + ")";
        }

        public C8116a(String r100, String r101) {
            this.exceptionName = r100;
            this.exceptionMessage = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lwi2/a$b;", "", "", "requestInfo", "Ljava/lang/String;", "getRequestInfo", "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("request_info")
        private final String requestInfo;

        public b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.requestInfo, ((b) r100).requestInfo) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r100 = this.requestInfo;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Extra(requestInfo=" + this.requestInfo + ")";
        }

        public b(String r100) {
            this.requestInfo = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lwi2/a$c;", "", "", "url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", e.f25671s, "getMethod", "", "headers", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("headers")
        private final Map<String, String> headers;

        @SerializedName(e.f25671s)
        private final String method;

        @SerializedName("url")
        private final String url;

        public c() {
            this(null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L12;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.method, r101.method) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.headers, r101.headers) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.url;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.method;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Map<String, String> r107 = this.headers;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Request(url=" + this.url + ", method=" + this.method + ", headers=" + this.headers + ")";
        }

        public final String b() {
            return this.url;
        }

        public static c a(c r100, String r101) {
            return new c(r101, r100.method, r100.headers);
        }

        public c(String r100, String r101, Map<String, String> r102) {
            this.url = r100;
            this.method = r101;
            this.headers = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lwi2/a$d;", "", "", "httpCode", "Ljava/lang/String;", "getHttpCode", "()Ljava/lang/String;", "cronetInternalErrorCode", "getCronetInternalErrorCode", ContainerPosition.BODY, "getBody", "", "headers", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName(ContainerPosition.BODY)
        private final String body;

        @SerializedName("cronet_internal_error_code")
        private final String cronetInternalErrorCode;

        @SerializedName("headers")
        private final Map<String, String> headers;

        @SerializedName("http_code")
        private final String httpCode;

        /* JADX WARN: Multi-variable type inference failed */
        public d() {
            Object[] r100 = 0 == true ? 1 : 0;
            Object[] r101 = 0 == true ? 1 : 0;
            this(null, r100, r101, 15);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L14;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.httpCode, r101.httpCode) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.cronetInternalErrorCode, r101.cronetInternalErrorCode) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.body, r101.body) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.headers, r101.headers) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.httpCode;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.cronetInternalErrorCode;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.body;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Map<String, String> r110 = this.headers;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Response(httpCode=" + this.httpCode + ", cronetInternalErrorCode=" + this.cronetInternalErrorCode + ", body=" + this.body + ", headers=" + this.headers + ")";
        }

        public static d a(d r100, String r101, String r102) {
            return new d(r101, r102, r100.body, r100.headers);
        }

        public /* synthetic */ d(String r100, String r101, Map r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "-1";
        L6:
            if ((r103 & 2) == 0) goto L8;
            String r104 = "0";
        L10:
            if ((r103 & 4) == 0) goto L13;
            r101 = null;
        L13:
            if ((r103 & 8) == 0) goto L15;
            r102 = null;
        L15:
            this(r100, r104, r101, r102);
            return;
        L8:
            r104 = null;
            goto L10
        }

        public d(String r100, String r101, String r102, Map<String, String> r103) {
            this.httpCode = r100;
            this.cronetInternalErrorCode = r101;
            this.body = r102;
            this.headers = r103;
        }
    }

    public a() {
        this.f559775b = -1;
        this.f559776c = -1;
        this.f559778e = "";
        this.f559786m = new HashMap();
        this.f559776c = -1;
    }

    public static String a(BaseHttpRequestInfo r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = new JSONObject();
        r101.put("remote_ip", r100.remoteIp);
        r101.put("appLevelRequestStart", r100.appLevelRequestStart);
        r101.put("beforeAllInterceptors", r100.beforeAllInterceptors);
        r101.put("requestStart", r100.requestStart);
        r101.put("responseBack", r100.responseBack);
        r101.put("completeReadResponse", r100.completeReadResponse);
        r101.put("requestEnd", r100.requestEnd);
        r101.put("recycleCount", r100.recycleCount);
        r101.put("timing_dns", r100.dnsTime);
        r101.put("timing_connect", r100.connectTime);
        r101.put("timing_ssl", r100.sslTime);
        r101.put("timing_send", r100.sendTime);
        r101.put("timing_waiting", r100.ttfbMs);
        r101.put("timing_receive", r100.receiveTime);
        r101.put("timing_total", r100.totalTime);
        r101.put("timing_isSocketReused", r100.isSocketReused);
        r101.put("timing_totalSendBytes", r100.sentByteCount);
        r101.put("timing_totalReceivedBytes", r100.receivedByteCount);
        r101.put("timing_remoteIP", r100.remoteIp);
        r101.put("native_post_task_start", r100.nativePostTaskStartTime);
        r101.put("native_request_start", r100.nativeRequestStartTime);
        r101.put("native_wait_ctx", r100.nativeWaitContext);
        r101.put("content_type", r100.contentType);
        r101.put(SpeechEngineDefines.CAPT_RESPONSE_MODE_STREAMING, r100.downloadFile);
        return r101.toString();
    }

    public a(int r100, String r101, String r102, Map<String, String> r103, SsResponse<String> r110, boolean r111) {
        this.f559775b = -1;
        this.f559776c = -1;
        this.f559778e = "";
        this.f559786m = new HashMap();
        this.f559776c = r100;
        this.f559780g = r101;
        String r104 = null;
        if (r110 == null) goto L19;
        this.f559775b = r110.code();
        int r105 = u0.f555269a;
        Iterator<T> r106 = r110.headers().iterator();
    L6:
        if (r106.hasNext() == false) goto L10;
        T r107 = r106.next();
        if (Intrinsics.areEqual(((Header) r107).getName(), Constants.Keys.KEY_X_TT_LOGID.toLowerCase(Locale.getDefault())) == false) goto L6;
    L11:
        Header r108 = r107;
        if (r108 == null) goto L14;
        String r109 = r108.getValue();
    L15:
        if (r109 == null) goto L18;
        r102 = r109;
    L18:
        this.f559781h = r102;
        goto L19
    L14:
        r109 = null;
        goto L15
    L10:
        r107 = (T) null;
    L19:
        ((HashMap) this.f559786m).putAll(r103);
        int r112 = 2;
        if (this.f559775b != 200) goto L39;
        int r113 = u0.f555269a;
        if (r110 == null) goto L35;
        Iterator<T> r114 = r110.headers().iterator();
    L26:
        if (r114.hasNext() == false) goto L30;
        T r115 = r114.next();
        if (Intrinsics.areEqual(((Header) r115).getName(), "tt_orcas_res".toLowerCase(Locale.getDefault())) == false) goto L26;
    L31:
        Header r116 = r115;
        if (r116 == null) goto L35;
        r104 = r116.getValue();
        goto L35
    L30:
        r115 = (T) null;
    L35:
        if (Intrinsics.areEqual(r104, "1") == false) goto L39;
        if (this.f559774a != null) goto L39;
        this.f559777d = 1;
    L41:
        if (r110 == null) goto L69;
        WeakHashMap<SsResponse<?>, Request> r117 = zj2.b.f572447a;     // Catch: Exception -> L49
        Intrinsics.checkNotNullParameter(r110, "$this$request");     // Catch: Exception -> L49
        Request r118 = zj2.b.f572447a.get(r110);     // Catch: Exception -> L49
        if (r118 == null) goto L51;
        String r119 = r118.getUrl();     // Catch: Exception -> L49
        String r120 = r118.getMethod();     // Catch: Exception -> L49
        List<Header> r121 = r118.getHeaders();     // Catch: Exception -> L49
        HashMap r122 = new HashMap();     // Catch: Exception -> L49
        Iterator<T> r123 = r121.iterator();     // Catch: Exception -> L49
    L46:
        if (r123.hasNext() == false) goto L48;
        Header r124 = (Header) r123.next();     // Catch: Exception -> L49
        r122.put(r124.getName(), r124.getValue());     // Catch: Exception -> L49
        goto L46
    L48:
        this.f559782i = new c(r119, r120, r122);     // Catch: Exception -> L49
        Intrinsics.checkNotNullParameter(r110, "$this$request");     // Catch: Exception -> L49
        zj2.b.f572447a.remove(r110);     // Catch: Exception -> L49
    L51:
        String r125 = String.valueOf(r110.code());     // Catch: Exception -> L49
        String r126 = r110.body();     // Catch: Exception -> L49
        List<Header> r127 = r110.headers();     // Catch: Exception -> L49
        HashMap r128 = new HashMap();     // Catch: Exception -> L49
        Iterator<T> r129 = r127.iterator();     // Catch: Exception -> L49
    L53:
        if (r129.hasNext() == false) goto L55;
        Header r130 = (Header) r129.next();     // Catch: Exception -> L49
        r128.put(r130.getName(), r130.getValue());     // Catch: Exception -> L49
        goto L53
    L55:
        this.f559783j = new d(r125, r126, r128, r112);     // Catch: Exception -> L49
        return;
    L49:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L69:
        return;
    L39:
        if (r111 == false) goto L41;
        this.f559777d = 2;
        goto L41
    }
}
