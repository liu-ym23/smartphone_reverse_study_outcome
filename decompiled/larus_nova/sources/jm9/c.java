package jm9;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f499700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f499701b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f499702c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f499703d = null;

    public c() {
    }

    static {
        f499700a = new c();
        f499701b = LazyKt.lazy(new a());
        f499702c = new AtomicBoolean(false);
        f499703d = LazyKt.lazy(new b());
    }

    public static boolean b() {
        return ((Boolean) f499703d.getValue()).booleanValue();
    }

    public final void a() {
        AtomicBoolean r100 = f499702c;
        if (r100.get() == false) goto L6;
        FLogger.f375446a.d("AppInfoProvider", "init ignored: already initialized.");
        return;
    L6:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (r100.get() == false) goto L13;
        FLogger.f375446a.d("AppInfoProvider", "init ignored (double-check).");     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L13:
        r100.set(true);     // Catch: Throwable -> L16
        FLogger.f375446a.i("AppInfoProvider", "AppInfoProvider initialized.");     // Catch: Throwable -> L16
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
    }
}
