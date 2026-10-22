package vx9;

import androidx.collection.LruCache;
import com.larus.trace.tracespan.span.SpanWrapImpl;
import com.larus.utils.logger.FLogger;
import io.opentelemetry.context.g;
import io.opentelemetry.sdk.trace.m;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import jtc.i;
import jtc.j;
import jtc.k;
import jtc.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f557496a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f557497b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile o f557498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static yx9.a f557499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static yx9.d f557500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f557501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f557502g;

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f557503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f557504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f557505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public wx9.a f557506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f557507e;

        public final com.larus.trace.tracespan.span.b a() {
            b r100 = b.f557496a;
            String r101 = this.f557503a;
            String r102 = this.f557504b;
            if (r102 != null) goto L5;
            r102 = r101;
        L5:
            String r103 = this.f557505c;
            if (r103 != null) goto L8;
            r103 = r101;
        L8:
            long r104 = this.f557507e;
            wx9.a r105 = this.f557506d;
            r100.getClass();
            if (b.f557502g == false) goto L63;
            wx9.a r106 = null;
            if (b.f557498c == null) goto L14;
            o r107 = b.f557498c;
        L25:
            if (r107 == null) goto L53;
            j r108 = r107.a(r101);
            if (r108 == null) goto L53;
            r108.b(r105);
            i r109 = r108.a();
            r109.c(b.f557501f + r103);
            LruCache<String, String> r110 = e.f557510b;
            k r111 = r109.b();
            if (r111 == null) goto L32;
            String r112 = ((io.opentelemetry.api.internal.b) r111).f492665c;
        L33:
            if (r112 != null) goto L35;
            r112 = "";
        L35:
            r110.put(r112, r102);
            Intrinsics.checkNotNull(r109);
            SpanWrapImpl r113 = new SpanWrapImpl(r109, r104);
            Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L38
            io.opentelemetry.context.f r115 = f.f557512a;     // Catch: Throwable -> L38
            Object r116 = Result.m9449constructorimpl(r105.a(r113));     // Catch: Throwable -> L38
        L41:
            if (Result.m9455isFailureimpl(r116) == false) goto L44;
            r116 = null;
        L44:
            if ((r116 instanceof wx9.a) == false) goto L46;
            r106 = (wx9.a) r116;
        L46:
            if (r106 == null) goto L64;
            r105.c().h(r113);
            b.f557496a.getClass();
            zx9.a r117 = b.b();
            if (r117 == null) goto L64;
            r117.a(r113.getTraceId(), r113.a(), r106);
        L64:
            return r113;
        L38:
            th = move-exception;
            Result.Companion r118 = Result.Companion;
            r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L41
        L32:
            r112 = null;
        L53:
            return new com.larus.trace.tracespan.span.a();
        L14:
            Object r119 = b.f557497b;
            monitor-enter(r119);
        L54:
            th = move-exception;
            throw th;
        L17:
            if (b.f557498c == null) goto L57;
            r107 = b.f557498c;     // Catch: Throwable -> L54
            monitor-exit(r119);
            goto L25
        L57:
            Logger r120 = m.f492783c;     // Catch: Throwable -> L20
            io.opentelemetry.sdk.trace.o r121 = new io.opentelemetry.sdk.trace.o();     // Catch: Throwable -> L20
            ((ArrayList) r121.f492787a).add(new otc.d(new e()));     // Catch: Throwable -> L20
            r121.f492789c = new vx9.a();     // Catch: Throwable -> L20
            final io.opentelemetry.sdk.internal.d<io.opentelemetry.sdk.trace.k> r122 = new m(r121.f492788b, r121.f492789c, r121.f492790d, r121.f492791e, r121.f492792f, r121.f492787a).f492785b;     // Catch: Throwable -> L20
            final String r123 = "flow_android";
            final itc.b r124 = itc.b.f495767d;     // Catch: Throwable -> L20
            r122.getClass();     // Catch: Throwable -> L20
            b.f557498c = (o) ((Map) ((ConcurrentHashMap) r122.f492711b).computeIfAbsent("flow_android", new io.opentelemetry.sdk.internal.b())).computeIfAbsent("1.0.0", new io.opentelemetry.sdk.internal.c(r122, r123, r124));     // Catch: Throwable -> L20
            r107 = b.f557498c;     // Catch: Throwable -> L20
        L21:
            monitor-exit(r119);
        L20:
            r107 = null;
            goto L21
        L63:
            return new com.larus.trace.tracespan.span.a();
        }

        public a() {
            this.f557503a = "";
            wx9.b r100 = wx9.b.f561852c;
            this.f557506d = wx9.b.f561852c;
        }
    }

    public b() {
    }

    public static zx9.a b() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        io.opentelemetry.context.c r102 = g.f492702b;     // Catch: Throwable -> L9
        if ((r102 instanceof zx9.a) == false) goto L6;
        zx9.a r103 = (zx9.a) r102;     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        FLogger.f375446a.e("OpenTelemetryTraceService", "failed to get ITraceContextStorage, " + r105);
    L15:
        if (Result.m9455isFailureimpl(r104) == true) goto L19;
        r100 = r104;
    L19:
        return (zx9.a) r100;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    static {
        f557496a = new b();
        f557497b = new Object();
        yx9.a.f569434a.getClass();
        f557499d = yx9.a.C8400a.f569436b;
        yx9.d.f569439a.getClass();
        f557500e = yx9.d.a.f569441b;
        f557501f = "";
    }

    public static com.larus.trace.tracespan.span.b a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "tag");
        if (f557502g == true) goto L5;
        return null;
    L5:
        zx9.a r102 = b();
        if (r102 == null) goto L11;
        wx9.a r103 = r102.c(r100, r101);
        if (r103 != null) goto L10;
        return null;
    L10:
        return r103.c();
    L11:
        return null;
    }
}
