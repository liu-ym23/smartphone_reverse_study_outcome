package com.bytedance.helios.common.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f245392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f245393b = null;

    public c() {
    }

    static {
        f245393b = new c();
    }

    @JvmStatic
    public static final Handler a() {
        monitor-enter(c.class);
        f245393b.getClass();     // Catch: Throwable -> L12
        if (f245392a != null) goto L7;
        f245392a = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L12
    L7:
        Handler r100 = f245392a;     // Catch: Throwable -> L12
        if (r100 != null) goto L10;
        Intrinsics.throwNpe();     // Catch: Throwable -> L12
    L10:
        monitor-exit(c.class);
        return r100;
    L12:
        th = move-exception;
        throw th;
    }
}
