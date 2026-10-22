package com.bytedance.android.shopping.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LargeFontModeUtil {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(LargeFontModeUtil$enlargeScale$2.INSTANCE);
        b = LazyKt.lazy(LargeFontModeUtil$expSwitch$2.INSTANCE);
    }

    public static float a() {
        if (((Number) b.getValue()).intValue() == 1) goto L7;
        return 1.0f;
    L7:
        return ((Number) a.getValue()).floatValue();
    }
}
