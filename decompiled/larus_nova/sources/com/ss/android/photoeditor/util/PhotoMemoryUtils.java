package com.ss.android.photoeditor.util;

import android.os.Build;
import android.os.Debug;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class PhotoMemoryUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f449541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f449542b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f449543c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f449544d = null;

    static {
        f449541a = LazyKt.lazy(PhotoMemoryUtils$systemScore$2.INSTANCE);
        f449542b = LazyKt.lazy(PhotoMemoryUtils$appScore$2.INSTANCE);
        f449543c = LazyKt.lazy(PhotoMemoryUtils$isLowLevelDevice$2.INSTANCE);
        f449544d = LazyKt.lazy(PhotoMemoryUtils$needLimitUseMemory$2.INSTANCE);
    }

    @JvmStatic
    public static final int a() {
        int r100 = DevicePerfManager.b.f432386a.f432372e.f20363a;
        Log.i("PhotoMemoryUtils", "getTotalScore, downgradeLevel:" + r100);
        int r101 = 1;
        if (r100 <= 1) goto L7;
        return 5;
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        long r102 = (Runtime.getRuntime().freeMemory() * ((long) 100)) / RangesKt.coerceAtLeast(Runtime.getRuntime().totalMemory(), 1);
    L10:
        int r103 = (int) r102;
        if (r103 < 30) goto L14;
        r101 = 0;
    L17:
        Log.i("PhotoMemoryUtils", "getFreeMemoryScore, freeRate:" + r103 + ", score:" + r101);
        Lazy r104 = f449541a;
        int r105 = ((Number) r104.getValue()).intValue();
        Lazy r106 = f449542b;
        int r107 = (r105 + ((Number) r106.getValue()).intValue()) + r101;
        Log.i("PhotoMemoryUtils", "getTotalScore, totalScore:" + r107 + " = systemScore:" + ((Number) r104.getValue()).intValue() + " + appScore:" + ((Number) r106.getValue()).intValue() + " + memoryScore:" + r101);
        return r107;
    L14:
        if (r103 >= 15) goto L17;
        r101 = 2;
        goto L17
    L9:
        r102 = (Debug.getNativeHeapFreeSize() * ((long) 100)) / RangesKt.coerceAtLeast(Debug.getNativeHeapSize(), 1);
        goto L10
    }
}
