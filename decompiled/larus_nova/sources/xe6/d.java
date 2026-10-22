package xe6;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ze6.e;

/* JADX INFO: loaded from: classes20.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f563365a;

    static {
    }

    @JvmStatic
    public static final synchronized void a(ye6.b r100) {
        monitor-enter(d.class);
        Intrinsics.checkNotNullParameter(r100, "config");     // Catch: Throwable -> L58
        ze6.b.b("TraceSdk.initialize");     // Catch: Throwable -> L58
        boolean r101 = false;
        if (f563365a == false) goto L26;
        ze6.a r102 = ze6.a.f571534a;     // Catch: Throwable -> L58
        if (ze6.a.a(r100.f567398a) == false) goto L22;
        AtomicReference<c> r103 = ze6.c.f571545a;     // Catch: Throwable -> L58
        c r104 = r100.f567399b;     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r104, ShortVideoSegments.KEY_PROP_PROVIDER);     // Catch: Throwable -> L58
        if (ze6.c.f571545a.get() != r104) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L22;
        b r106 = r100.f567401d;     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r106, "logger");     // Catch: Throwable -> L58
        if (ze6.b.f571544a.get() != r106) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L22;
        AtomicReference<a> r108 = e.f571546a;     // Catch: Throwable -> L58
        a r109 = r100.f567400c;     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r109, "reporter");     // Catch: Throwable -> L58
        if (e.f571546a.get() != r109) goto L21;
        r101 = true;
    L21:
        if (r101 == false) goto L22;
    L23:
        ze6.b.c("TraceSdk.initialize Trace SDK is already initialized");     // Catch: Throwable -> L58
        monitor-exit(d.class);
        return;
    L16:
        r107 = false;
        goto L17
    L11:
        r105 = false;
    L22:
        ze6.b.c("TraceSdk.initialize Trace SDK is already initialized; ignoring different dependencies");     // Catch: Throwable -> L58
        goto L23
    L26:
        b r110 = r100.f567401d;     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r110, "logger");     // Catch: Throwable -> L58
        AtomicReference<b> r111 = ze6.b.f571544a;     // Catch: Throwable -> L58
    L28:
        if (r111.compareAndSet(null, r110) == true) goto L29;
        if (r111.get() == null) goto L28;
        boolean r112 = false;
    L33:
        if (r112 == false) goto L35;
        ze6.b.b("TraceLog.setLogger Host logger configured");     // Catch: Throwable -> L58
    L36:
        AtomicReference<c> r113 = ze6.c.f571545a;     // Catch: Throwable -> L58
        c r114 = r100.f567399b;     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r114, ShortVideoSegments.KEY_PROP_PROVIDER);     // Catch: Throwable -> L58
        ze6.b.b("TraceNetTypeProvider.setProvider");     // Catch: Throwable -> L58
        AtomicReference<c> r115 = ze6.c.f571545a;     // Catch: Throwable -> L58
    L38:
        if (r115.compareAndSet(null, r114) == true) goto L39;
        if (r115.get() == null) goto L38;
        boolean r116 = false;
    L43:
        if (r116 == false) goto L45;
        ze6.b.b("TraceNetTypeProvider.setProvider Host network type provider configured");     // Catch: Throwable -> L58
    L46:
        ze6.a.f571534a.b(r100.f567398a);     // Catch: Throwable -> L58
        AtomicReference<a> r117 = e.f571546a;     // Catch: Throwable -> L58
        a r118 = r100.f567400c;     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r118, "reporter");     // Catch: Throwable -> L58
        ze6.b.b("TraceReporter.setEventReporter");     // Catch: Throwable -> L58
        AtomicReference<a> r119 = e.f571546a;     // Catch: Throwable -> L58
    L48:
        if (r119.compareAndSet(null, r118) == true) goto L49;
        if (r119.get() == null) goto L48;
    L52:
        if (r101 == false) goto L54;
        ze6.b.b("TraceReporter.setEventReporter Host event reporter configured");     // Catch: Throwable -> L58
    L55:
        f563365a = true;     // Catch: Throwable -> L58
        ze6.b.b("TraceSdk.initialize Trace SDK initialized");     // Catch: Throwable -> L58
        monitor-exit(d.class);
        return;
    L54:
        ze6.b.c("TraceReporter.setEventReporter Host event reporter already configured; ignoring replacement");     // Catch: Throwable -> L58
        goto L55
    L49:
        r101 = true;
        goto L52
    L45:
        ze6.b.c("TraceNetTypeProvider.setProvider Host network type provider already configured; ignoring replacement");     // Catch: Throwable -> L58
        goto L46
    L39:
        r116 = true;
        goto L43
    L35:
        ze6.b.c("TraceLog.setLogger Host logger already configured; ignoring replacement");     // Catch: Throwable -> L58
        goto L36
    L29:
        r112 = true;
    L58:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void b(af6.a r100, af6.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        ze6.b.b("TraceSdk.report");
        if (f563365a == true) goto L6;
        ze6.b.c("TraceSdk.report Trace SDK is not initialized; dropping trace event");
        return;
    L6:
        AtomicReference<a> r102 = e.f571546a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        ze6.b.b("TraceReporter.report");
        a r103 = e.f571546a.get();
        if (r103 != null) goto L27;
        ze6.b.c("TraceReporter.report Host event reporter is not configured; dropping trace event");
        return;
    L27:
        JSONObject r104 = e.a(e.b(r100, r101, e.d(r101.f3180d)));     // Catch: Throwable -> L18
        if (StringsKt.isBlank(r100.f3173a) == false) goto L25;
        ze6.b.c("TraceReporter.report traceName is blank; dropping trace event");
        return;
    L25:
        r103.report(r100.f3173a, r104);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        e.c("reporter", r100.f3174b, r101.f3177a, th);
        return;
    L18:
        th = move-exception;
        e.c("serialization", r100.f3174b, r101.f3177a, th);
        return;
    L20:
        th = move-exception;
        e.c("processing", r100.f3174b, r101.f3177a, th);
    }
}
