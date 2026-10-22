package wi2;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.google.gson.annotations.SerializedName;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> {
    public T a;
    public final int b;
    public final int c;
    public int d;
    public String e;
    public long f;
    public final String g;
    public final String h;
    public c i;
    public d j;
    public C0184a k;
    public b l;
    public final Map<String, String> m;

    /* JADX INFO: renamed from: wi2.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lwi2/a$a;", "", "", "exceptionName", "Ljava/lang/String;", "getExceptionName", "()Ljava/lang/String;", "exceptionMessage", "getExceptionMessage", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0184a {

        @SerializedName("exception_message")
        private final String exceptionMessage;

        @SerializedName("exception_name")
        private final String exceptionName;

        public C0184a() {
            this(null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0184a) == false) goto L10;
            C0184a r4 = (C0184a) r3;
            if (Intrinsics.areEqual(this.exceptionName, r4.exceptionName) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.exceptionMessage, r4.exceptionMessage) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.exceptionName;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.exceptionMessage;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ErrorInfo(exceptionName=" + this.exceptionName + ", exceptionMessage=" + this.exceptionMessage + ")";
        }

        public C0184a(String r1, String r2) {
            this.exceptionName = r1;
            this.exceptionMessage = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lwi2/a$b;", "", "", "requestInfo", "Ljava/lang/String;", "getRequestInfo", "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("request_info")
        private final String requestInfo;

        public b() {
            this(null);
        }

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.requestInfo, ((b) r2).requestInfo) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r0 = this.requestInfo;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Extra(requestInfo=" + this.requestInfo + ")";
        }

        public b(String r1) {
            this.requestInfo = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lwi2/a$c;", "", "", "url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "method", "getMethod", "", "headers", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("headers")
        private final Map<String, String> headers;

        @SerializedName("method")
        private final String method;

        @SerializedName("url")
        private final String url;

        public c() {
            this(null, null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L12;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.url, r4.url) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.method, r4.method) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.headers, r4.headers) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.url;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.method;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Map<String, String> r7 = this.headers;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Request(url=" + this.url + ", method=" + this.method + ", headers=" + this.headers + ")";
        }

        public final String b() {
            return this.url;
        }

        public static c a(c r2, String r3) {
            return new c(r3, r2.method, r2.headers);
        }

        public c(String r1, String r2, Map<String, String> r3) {
            this.url = r1;
            this.method = r2;
            this.headers = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lwi2/a$d;", "", "", "httpCode", "Ljava/lang/String;", "getHttpCode", "()Ljava/lang/String;", "cronetInternalErrorCode", "getCronetInternalErrorCode", "body", "getBody", "", "headers", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("body")
        private final String body;

        @SerializedName("cronet_internal_error_code")
        private final String cronetInternalErrorCode;

        @SerializedName("headers")
        private final Map<String, String> headers;

        @SerializedName("http_code")
        private final String httpCode;

        /* JADX WARN: Multi-variable type inference failed */
        public d() {
            Object[] r0 = 0 == true ? 1 : 0;
            Object[] r1 = 0 == true ? 1 : 0;
            this(null, r0, r1, 15);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L14;
            d r4 = (d) r3;
            if (Intrinsics.areEqual(this.httpCode, r4.httpCode) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.cronetInternalErrorCode, r4.cronetInternalErrorCode) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.body, r4.body) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.headers, r4.headers) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r0 = this.httpCode;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.cronetInternalErrorCode;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.body;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Map<String, String> r10 = this.headers;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Response(httpCode=" + this.httpCode + ", cronetInternalErrorCode=" + this.cronetInternalErrorCode + ", body=" + this.body + ", headers=" + this.headers + ")";
        }

        public static d a(d r2, String r3, String r4) {
            return new d(r3, r4, r2.body, r2.headers);
        }

        public /* synthetic */ d(String r4, String r5, Map r6, int r7) {
            if ((r7 & 1) == 0) goto L6;
            r4 = "-1";
        L6:
            if ((r7 & 2) == 0) goto L8;
            String r0 = BDLocationException.ERROR_TIMEOUT;
        L10:
            if ((r7 & 4) == 0) goto L13;
            r5 = null;
        L13:
            if ((r7 & 8) == 0) goto L15;
            r6 = null;
        L15:
            this(r4, r0, r5, r6);
            return;
        L8:
            r0 = null;
            goto L10
        }

        public d(String r1, String r2, String r3, Map<String, String> r4) {
            this.httpCode = r1;
            this.cronetInternalErrorCode = r2;
            this.body = r3;
            this.headers = r4;
        }
    }

    public a() {
        this.b = -1;
        this.c = -1;
        this.e = "";
        this.m = new HashMap();
        this.c = -1;
    }

    public static String a(BaseHttpRequestInfo r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("remote_ip", r4.remoteIp);
        r0.put("appLevelRequestStart", r4.appLevelRequestStart);
        r0.put("beforeAllInterceptors", r4.beforeAllInterceptors);
        r0.put("requestStart", r4.requestStart);
        r0.put("responseBack", r4.responseBack);
        r0.put("completeReadResponse", r4.completeReadResponse);
        r0.put("requestEnd", r4.requestEnd);
        r0.put("recycleCount", r4.recycleCount);
        r0.put("timing_dns", r4.dnsTime);
        r0.put("timing_connect", r4.connectTime);
        r0.put("timing_ssl", r4.sslTime);
        r0.put("timing_send", r4.sendTime);
        r0.put("timing_waiting", r4.ttfbMs);
        r0.put("timing_receive", r4.receiveTime);
        r0.put("timing_total", r4.totalTime);
        r0.put("timing_isSocketReused", r4.isSocketReused);
        r0.put("timing_totalSendBytes", r4.sentByteCount);
        r0.put("timing_totalReceivedBytes", r4.receivedByteCount);
        r0.put("timing_remoteIP", r4.remoteIp);
        r0.put("native_post_task_start", r4.nativePostTaskStartTime);
        r0.put("native_request_start", r4.nativeRequestStartTime);
        r0.put("native_wait_ctx", r4.nativeWaitContext);
        r0.put("content_type", r4.contentType);
        r0.put("streaming", r4.downloadFile);
        return r0.toString();
    }

    public a(int r6, String r7, String r8, Map<String, String> r9, SsResponse<String> r10, boolean r11) {
        this.b = -1;
        this.c = -1;
        this.e = "";
        this.m = new HashMap();
        this.c = r6;
        this.g = r7;
        String r12 = null;
        if (r10 == null) goto L19;
        this.b = r10.code();
        int r13 = u0.a;
        Iterator<T> r14 = r10.headers().iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        T r1 = r14.next();
        if (Intrinsics.areEqual(((Header) r1).getName(), "X-Tt-Logid".toLowerCase(Locale.getDefault())) == false) goto L6;
    L11:
        Header r2 = (Header) r1;
        if (r2 == null) goto L14;
        String r15 = r2.getValue();
    L15:
        if (r15 == null) goto L18;
        r8 = r15;
    L18:
        this.h = r8;
        goto L19
    L14:
        r15 = null;
        goto L15
    L10:
        r1 = null;
    L19:
        ((HashMap) this.m).putAll(r9);
        int r16 = 2;
        if (this.b != 200) goto L39;
        int r17 = u0.a;
        if (r10 == null) goto L35;
        Iterator<T> r18 = r10.headers().iterator();
    L26:
        if (r18.hasNext() == false) goto L30;
        T r19 = r18.next();
        if (Intrinsics.areEqual(((Header) r19).getName(), "tt_orcas_res".toLowerCase(Locale.getDefault())) == false) goto L26;
    L31:
        Header r20 = (Header) r19;
        if (r20 == null) goto L35;
        r12 = r20.getValue();
        goto L35
    L30:
        r19 = null;
    L35:
        if (Intrinsics.areEqual(r12, "1") == false) goto L39;
        if (this.a != null) goto L39;
        this.d = 1;
    L41:
        if (r10 == null) goto L69;
        WeakHashMap<SsResponse<?>, Request> r21 = zj2.b.a;     // Catch: Exception -> L49
        Intrinsics.checkNotNullParameter(r10, "$this$request");     // Catch: Exception -> L49
        Request r22 = zj2.b.a.get(r10);     // Catch: Exception -> L49
        if (r22 == null) goto L51;
        String r23 = r22.getUrl();     // Catch: Exception -> L49
        String r24 = r22.getMethod();     // Catch: Exception -> L49
        List r25 = r22.getHeaders();     // Catch: Exception -> L49
        HashMap r110 = new HashMap();     // Catch: Exception -> L49
        Iterator<T> r26 = r25.iterator();     // Catch: Exception -> L49
    L46:
        if (r26.hasNext() == false) goto L48;
        Header r3 = (Header) r26.next();     // Catch: Exception -> L49
        r110.put(r3.getName(), r3.getValue());     // Catch: Exception -> L49
        goto L46
    L48:
        this.i = new c(r23, r24, r110);     // Catch: Exception -> L49
        Intrinsics.checkNotNullParameter(r10, "$this$request");     // Catch: Exception -> L49
        zj2.b.a.remove(r10);     // Catch: Exception -> L49
    L51:
        String r27 = String.valueOf(r10.code());     // Catch: Exception -> L49
        String r28 = (String) r10.body();     // Catch: Exception -> L49
        List r29 = r10.headers();     // Catch: Exception -> L49
        HashMap r111 = new HashMap();     // Catch: Exception -> L49
        Iterator<T> r30 = r29.iterator();     // Catch: Exception -> L49
    L53:
        if (r30.hasNext() == false) goto L55;
        Header r112 = (Header) r30.next();     // Catch: Exception -> L49
        r111.put(r112.getName(), r112.getValue());     // Catch: Exception -> L49
        goto L53
    L55:
        this.j = new d(r27, r28, r111, r16);     // Catch: Exception -> L49
        return;
    L49:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L69:
        return;
    L39:
        if (r11 == false) goto L41;
        this.d = 2;
        goto L41
    }
}
