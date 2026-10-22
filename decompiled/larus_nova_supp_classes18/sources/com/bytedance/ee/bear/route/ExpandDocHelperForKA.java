package com.bytedance.ee.bear.route;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ExpandDocHelperForKA {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ExpandDocHelperForKA$downgradeExpandDoc$2.INSTANCE);
    }

    public static boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }
}
