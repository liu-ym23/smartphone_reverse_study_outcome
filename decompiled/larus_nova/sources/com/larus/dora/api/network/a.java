package com.larus.dora.api.network;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.larus.dora.api.IDoraService;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import g49.d;
import java.io.Closeable;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import lm9.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f331768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f331769b = null;

    /* JADX INFO: renamed from: com.larus.dora.api.network.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes27.dex */
    public static abstract class AbstractC4204a {

        /* JADX INFO: renamed from: com.larus.dora.api.network.a$a$a, reason: collision with other inner class name */
        public static final class C4205a extends AbstractC4204a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f331770a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4205a) == true) goto L9;
                return false;
            L9:
                if (this.f331770a == ((C4205a) r100).f331770a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f331770a;
            }

            public final String toString() {
                return "HttpFailed(statusCode=" + this.f331770a + ')';
            }

            public C4205a(int r100) {
                this.f331770a = r100;
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.api.network.a$a$b */
        public static final class b extends AbstractC4204a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f331771a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Integer f331772b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Integer f331773c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f331771a, r101.f331771a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f331772b, r101.f331772b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f331773c, r101.f331773c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f331771a.hashCode() * 31;
                Integer r101 = this.f331772b;
                int r102 = 0;
                if (r101 != null) goto L5;
                int r103 = 0;
            L6:
                int r104 = (r100 + r103) * 31;
                Integer r105 = this.f331773c;
                if (r105 == null) goto L11;
                r102 = r105.hashCode();
            L11:
                return r104 + r102;
            L5:
                r103 = r101.hashCode();
                goto L6
            }

            public final String toString() {
                return "RequestFailed(cause=" + this.f331771a + ", statusCode=" + this.f331772b + ", internalErrorCode=" + this.f331773c + ')';
            }

            public b(Throwable r100, Integer r101, Integer r102) {
                Intrinsics.checkNotNullParameter(r100, "cause");
                this.f331771a = r100;
                this.f331772b = r101;
                this.f331773c = r102;
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.api.network.a$a$c */
        public static final class c extends AbstractC4204a implements Closeable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f331774a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f331775b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final InputStream f331776c;

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                this.f331776c.close();
            }

            public c(int r100, long r101, InputStream r102) {
                Intrinsics.checkNotNullParameter(r102, "inputStream");
                this.f331774a = r100;
                this.f331775b = r101;
                this.f331776c = r102;
            }
        }

        public AbstractC4204a() {
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f331777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f331778b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f331777a, r101.f331777a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f331778b, r101.f331778b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f331777a.hashCode() * 31) + this.f331778b.hashCode();
        }

        public final String toString() {
            return "SessionCookie(name=" + this.f331777a + ", value=" + this.f331778b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "value");
            this.f331777a = r100;
            this.f331778b = r101;
        }
    }

    public a() {
    }

    static {
        f331768a = new a();
        f331769b = CollectionsKt.listOf(new String[]{InteractConst.INTENT_SESSION_ID, "sessionid_ss", "sid_tt"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static AbstractC4204a a(a r210, String r211) {
        Map r100 = MapsKt.emptyMap();
        r210.getClass();
        Intrinsics.checkNotNullParameter(r211, "url");
        Intrinsics.checkNotNullParameter(r100, "headerMap");
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 == null) goto L9;
        Map<String, String> r102 = r101.w0(new JSONObject());
        if (r102 == null) goto L9;
        Map r103 = MapsKt.toMutableMap(r102);
        if (r103 == null) goto L9;
    L10:
        Map r104 = r103;
        if (r104.containsKey("x-ttnet-req-biz-id") == true) goto L13;
        r104.put("x-ttnet-req-biz-id", ServiceType.DORA);
    L13:
        r104.put("Passport-Auth", AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        CookieHandler r105 = CookieHandler.getDefault();
        boolean r106 = false;
        int r107 = 1;
        Integer r108 = null;
        if (r105 == null) goto L70;
        LinkedHashMap r109 = new LinkedHashMap();
        Iterator r110 = SequencesKt.sequenceOf(new String[]{r211, "https://api-normal.doubao.com/"}).iterator();
    L18:
        if (r110.hasNext() == false) goto L61;
        String r111 = (String) r110.next();
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L22
        Object r113 = Result.m9449constructorimpl(r105.get(URI.create(r111), MapsKt.emptyMap()));     // Catch: Throwable -> L22
    L25:
        if (Result.m9455isFailureimpl(r113) == false) goto L27;
        r113 = null;
    L27:
        Map r114 = (Map) r113;
        if (r114 == null) goto L18;
        Iterator r115 = r114.entrySet().iterator();
    L32:
        if (r115.hasNext() == false) goto L18;
        Map.Entry r116 = (Map.Entry) r115.next();
        String r117 = (String) r116.getKey();
        List r118 = (List) r116.getValue();
        if (StringsKt.equals(r117, "Cookie", r107) == true) goto L38;
        if (StringsKt.equals(r117, CronetHttpURLConnection.SS_COOKIE, r107) == false) goto L32;
    L38:
        if (r118 != null) goto L40;
        r118 = CollectionsKt.emptyList();
    L40:
        Iterator r119 = r118.iterator();
    L42:
        if (r119.hasNext() == false) goto L32;
        String r120 = (String) r119.next();
        Intrinsics.checkNotNull(r120);
        char[] r121 = new char[r107];
        r121[0] = ';';
        Iterator r122 = StringsKt.split$default(r120, r121, false, 0, 6, null).iterator();
    L45:
        if (r122.hasNext() == false) goto L42;
        String r123 = (String) r122.next();
        int r124 = StringsKt.indexOf$default(r123, com.alipay.sdk.m.n.a.f25612h, 0, false, 6, null);
        if (r124 <= 0) goto L45;
        String r125 = StringsKt.trim(r123.substring(0, r124)).toString().toLowerCase(Locale.ROOT);
        String r126 = StringsKt.trim(r123.substring(r124 + 1)).toString();
        if (r125.length() <= 0) goto L52;
        boolean r127 = true;
    L53:
        if (r127 == true) goto L55;
    L60:
        r107 = 1;
        goto L45
    L55:
        if (r126.length() <= 0) goto L57;
        boolean r128 = true;
    L58:
        if (r128 == false) goto L60;
        r109.putIfAbsent(r125, r126);
        goto L60
    L57:
        r128 = false;
        goto L58
    L52:
        r127 = false;
    L22:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L61:
        Iterator<T> r130 = f331769b.iterator();
    L63:
        if (r130.hasNext() == false) goto L70;
        String r131 = (String) r130.next();
        String r132 = (String) r109.get(r131);
        if (r132 == null) goto L67;
        b r133 = new b(r131, r132);
    L68:
        if (r133 == null) goto L63;
    L71:
        if (r133 == null) goto L73;
        r104.put("Cookie", "sessionid=" + r133.f331778b);
    L73:
        StringBuilder r134 = new StringBuilder("download auth prepared: host=");
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L76
        Object r136 = Result.m9449constructorimpl(URI.create(r211).getHost());     // Catch: Throwable -> L76
    L79:
        if (Result.m9455isFailureimpl(r136) == false) goto L81;
        r136 = null;
    L81:
        r134.append((String) r136);
        r134.append(", hasSessionCookie=");
        if (r133 == null) goto L84;
        boolean r137 = true;
    L85:
        r134.append(r137);
        r134.append(", source=");
        if (r133 == null) goto L88;
        String r138 = r133.f331777a;
    L89:
        r134.append(r138);
        d.d("DoraResourceInstall", r134.toString());
        r104.putAll(r100);
        ArrayList r139 = new ArrayList(r104.size());
        Iterator r140 = r104.entrySet().iterator();
    L91:
        if (r140.hasNext() == false) goto L136;
        Map.Entry r141 = (Map.Entry) r140.next();
        r139.add(new Header((String) r141.getKey(), (String) r141.getValue()));
        goto L91
    L136:
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L118
        SsResponse<TypedInput> r143 = c.b(r211, false, 268435456, r139);     // Catch: Throwable -> L118
        if (r143 == null) goto L163;
        int r144 = r143.code();     // Catch: Throwable -> L118
        TypedInput r145 = r143.body();     // Catch: Throwable -> L118
        if (200 <= r144) goto L99;
    L101:
        if (r106 == false) goto L106;
        if (r145 == null) goto L106;
        Object r146 = Result.m9449constructorimpl(new AbstractC4204a.c(r144, r145.length(), r145.in()));     // Catch: Throwable -> L118
    L120:
        Throwable r147 = Result.m9452exceptionOrNullimpl(r146);
        if (r147 == null) goto L135;
        if ((r147 instanceof CronetIOException) == false) goto L126;
        CronetIOException r148 = (CronetIOException) r147;
    L128:
        if (r148 == null) goto L130;
        Integer r149 = Integer.valueOf(r148.getStatusCode());
    L131:
        if (r148 == null) goto L133;
        r108 = Integer.valueOf(r148.getCronetInternalErrorCode());
    L133:
        r146 = new AbstractC4204a.b(r147, r149, r108);
        goto L135
    L130:
        r149 = null;
        goto L131
    L126:
        r148 = null;
    L135:
        return (AbstractC4204a) r146;
    L106:
        if (r145 != null) goto L141;
    L112:
        Unit r150 = null;
    L113:
        Result.m9449constructorimpl(r150);     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        Result.Companion r151 = Result.Companion;     // Catch: Throwable -> L118
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L118
    L164:
        return new AbstractC4204a.C4205a(r144);
    L141:
        InputStream r152 = r145.in();     // Catch: Throwable -> L110
        if (r152 == null) goto L112;
        r152.close();     // Catch: Throwable -> L110
        r150 = Unit.INSTANCE;     // Catch: Throwable -> L110
        goto L113
    L99:
        if (r144 >= 300) goto L101;
        r106 = true;
        goto L101
    L163:
        return new AbstractC4204a.b(new IllegalStateException("stream response is null"), null, null);
    L118:
        th = move-exception;
        Result.Companion r153 = Result.Companion;
        r146 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L120
    L88:
        r138 = null;
        goto L89
    L84:
        r137 = false;
    L76:
        th = move-exception;
        Result.Companion r154 = Result.Companion;
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L79
    L67:
        r133 = null;
    L70:
        r133 = null;
    L9:
        r103 = new LinkedHashMap();
        goto L10
    }

    public static Object b(a r100, Class r110, String r111, Map r112, ContinuationImpl r113) {
        r100.getClass();
        return HttpExtKt.g(ServiceType.DORA, r110, r111, r112, null, false, null, null, r113);
    }

    public static Object c(a r110, Class r111, String r112, JSONObject r113, Map r114, Continuation r115, int r116) {
        if ((r116 & 8) == 0) goto L5;
        String r100 = "application/json";
    L6:
        String r101 = r100;
        if ((r116 & 16) == 0) goto L9;
        Map r102 = MapsKt.emptyMap();
    L10:
        r110.getClass();
        IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r103 == null) goto L16;
        Map<String, String> r104 = r103.w0(r113);
        if (r104 == null) goto L16;
        Map r105 = MapsKt.toMutableMap(r104);
        if (r105 == null) goto L16;
    L17:
        Map r106 = r105;
        r106.putAll(r102);
        return HttpExtKt.k(ServiceType.DORA, r111, r112, r113, r101, r106, false, null, null, null, r115, 512);
    L16:
        r105 = new LinkedHashMap();
        goto L17
    L9:
        r102 = r114;
        goto L10
    L5:
        r100 = null;
        goto L6
    }
}
