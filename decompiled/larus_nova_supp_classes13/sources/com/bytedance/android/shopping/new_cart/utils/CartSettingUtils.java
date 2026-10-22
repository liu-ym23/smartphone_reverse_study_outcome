package com.bytedance.android.shopping.new_cart.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartSettingUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    public static boolean a() {
        return ((Boolean) f.getValue()).booleanValue();
    }

    public static boolean b() {
        return ((Boolean) e.getValue()).booleanValue();
    }

    static {
        a = LazyKt.lazy(CartSettingUtils$sliceElementReuse$2.INSTANCE);
        b = LazyKt.lazy(CartSettingUtils$textPoolSize$2.INSTANCE);
        c = LazyKt.lazy(CartSettingUtils$imagePoolSize$2.INSTANCE);
        d = LazyKt.lazy(CartSettingUtils$viewPoolSize$2.INSTANCE);
        e = LazyKt.lazy(CartSettingUtils$enableLargeTextMode$2.INSTANCE);
        f = LazyKt.lazy(CartSettingUtils$enableFooterRoundCorner$2.INSTANCE);
    }
}
