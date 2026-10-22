package com.larus.avlink.e.mock;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f291802a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f291803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static f f291804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f291805d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f291806e = null;

    public e() {
    }

    static {
        f291802a = new e();
        f291805d = new AtomicBoolean(false);
        f291806e = LazyKt.lazy(new d());
    }

    public final void a() {
        if (f291805d.get() == true) goto L6;
        b(this);
        return;
    }

    public static void b(e r100) {
        r100.getClass();
        if (f291805d.getAndSet(true) == true) goto L17;
        f291803b = new g();
        f291804c = new f();
        g r101 = f291803b;
        if ((r101 instanceof g) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L12;
        r101.f291811c.set(10);
        FLogger.f375446a.i("CameraMockRecorder", "📹 Recording mode set: mode=10, dataSetId=" + r101.f291812d.get());
    L12:
        g r102 = f291803b;
        if (r102 == null) goto L15;
        r102.i();
    L15:
        FLogger.f375446a.i("CameraMockManager", "CameraMockManager initialized with mode=10 (recording enabled by default)");
        return;
    }
}
