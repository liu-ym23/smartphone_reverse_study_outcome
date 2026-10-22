package jm9;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static final c a = null;
    public static final Lazy b = null;
    public static final AtomicBoolean c = null;
    public static final Lazy d = null;

    public c() {
    }

    static {
        a = new c();
        b = LazyKt.lazy(new a());
        c = new AtomicBoolean(false);
        d = LazyKt.lazy(new b());
    }

    public static boolean b() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    public final void a() {
        AtomicBoolean r0 = c;
        if (r0.get() == false) goto L6;
        FLogger.a.d("AppInfoProvider", "init ignored: already initialized.");
        return;
    L6:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (r0.get() == false) goto L13;
        FLogger.a.d("AppInfoProvider", "init ignored (double-check).");     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L13:
        r0.set(true);     // Catch: Throwable -> L16
        FLogger.a.i("AppInfoProvider", "AppInfoProvider initialized.");     // Catch: Throwable -> L16
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
    }
}
