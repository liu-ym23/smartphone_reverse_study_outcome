package com.bytedance.dux.toast;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class DuxToastSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f205814a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f205815b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<Integer> f205816c = null;

    static {
        Resources r100 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 84, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
        Resources r101 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 74, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
        f205814a = 32;
        f205815b = LazyKt.lazy(DuxToastSpec$sDuxComponponentService$2.INSTANCE);
        f205816c = LazyKt.lazy(DuxToastSpec$sCornalRadius$1.INSTANCE);
    }
}
