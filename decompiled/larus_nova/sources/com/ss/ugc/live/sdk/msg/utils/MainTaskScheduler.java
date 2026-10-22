package com.ss.ugc.live.sdk.msg.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class MainTaskScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f458448a = null;

    static {
        f458448a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MainTaskScheduler$sHandler$2.INSTANCE);
    }

    @JvmStatic
    public static final void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        ((Handler) f458448a.getValue()).post(r100);
    }
}
