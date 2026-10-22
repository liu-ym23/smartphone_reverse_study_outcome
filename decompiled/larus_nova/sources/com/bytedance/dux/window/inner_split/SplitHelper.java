package com.bytedance.dux.window.inner_split;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.dux.window.model.AdaptedWindowSize;
import hm4.a;
import im4.b;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class SplitHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f205938a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f205939b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f205940c = null;

    static {
        f205938a = LazyKt.lazy(SplitHelper$currentWindowSizeMap$2.INSTANCE);
        f205939b = LazyKt.lazy(SplitHelper$baseGridColumnWidthMap$2.INSTANCE);
        f205940c = LazyKt.lazy(SplitHelper$currentPageSizeMap$2.INSTANCE);
        MathKt.roundToInt(TypedValue.applyDimension(1, 0.0f, a.a(Resources.getSystem())));
        MathKt.roundToInt(TypedValue.applyDimension(1, 0.0f, a.a(Resources.getSystem())));
    }

    public static a b(Context r100) {
        if (r100 != null) goto L5;
        jm4.a.f499636a.getClass();
        int r101 = b.f490535a;
        return AdaptedWindowSize.f205952e;
    L5:
        Object r102 = ((ConcurrentHashMap) f205940c.getValue()).get(Integer.valueOf(d(r100)));
        if (r102 != null) goto L9;
        jm4.a.f499636a.getClass();
        int r103 = b.f490535a;
        r102 = AdaptedWindowSize.f205952e;
    L9:
        return (a) r102;
    }

    public static hm4.b c(Context r100) {
        if (r100 != null) goto L5;
        jm4.a.f499636a.getClass();
        int r101 = b.f490535a;
        AdaptedWindowSize r102 = AdaptedWindowSize.f205949b;
        return AdaptedWindowSize.f205950c;
    L5:
        Object r103 = ((ConcurrentHashMap) f205938a.getValue()).get(Integer.valueOf(d(r100)));
        if (r103 != null) goto L9;
        jm4.a.f499636a.getClass();
        int r104 = b.f490535a;
        AdaptedWindowSize r105 = AdaptedWindowSize.f205949b;
        r103 = AdaptedWindowSize.f205950c;
    L9:
        return (hm4.b) r103;
    }

    public static int d(Context r100) {
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r101 = (Activity) r100;
    L6:
        if (r101 != null) goto L10;
        return -1;
    L10:
        return r101.getTaskId();
    L5:
        r101 = null;
        goto L6
    }

    public static void a(Context r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "enableOps");
        if (d(r100) != (-1)) goto L6;
    L6:
        r101.invoke();
    }
}
