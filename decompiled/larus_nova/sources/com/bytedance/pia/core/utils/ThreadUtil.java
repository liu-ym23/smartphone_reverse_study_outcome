package com.bytedance.pia.core.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class ThreadUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f266378a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f266379b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f266380c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f266381d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f266382e = null;

    static {
        f266378a = LazyKt.lazy(ThreadUtil$mPiaThread$2.INSTANCE);
        f266379b = LazyKt.lazy(ThreadUtil$mPiaBackThread$2.INSTANCE);
        f266380c = LazyKt.lazy(ThreadUtil$piaHandler$2.INSTANCE);
        f266381d = LazyKt.lazy(ThreadUtil$piaBackHandler$2.INSTANCE);
        f266382e = LazyKt.lazy(ThreadUtil$mainHandler$2.INSTANCE);
    }

    public static Handler a() {
        return (Handler) f266380c.getValue();
    }

    @JvmStatic
    public static final void b(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        Lazy r101 = f266382e;
        if (Intrinsics.areEqual(((Handler) r101.getValue()).getLooper(), Looper.myLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        ((Handler) r101.getValue()).post(r100);
    }

    @JvmStatic
    public static final void c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (Intrinsics.areEqual(a().getLooper(), Looper.myLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        a().post(r100);
    }

    @JvmStatic
    public static final void d(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        Lazy r101 = f266381d;
        if (Intrinsics.areEqual(((Handler) r101.getValue()).getLooper(), Looper.myLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        ((Handler) r101.getValue()).post(r100);
    }
}
