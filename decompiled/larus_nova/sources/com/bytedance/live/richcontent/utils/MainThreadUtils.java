package com.bytedance.live.richcontent.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class MainThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f255802a = null;

    static {
        f255802a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MainThreadUtils$sHandler$2.INSTANCE);
    }

    @JvmStatic
    public static final void a(Runnable r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        ((Handler) f255802a.getValue()).post(r100);
    }
}
