package com.bytedance.ee.bear.bizwidget.helper;

import com.bytedance.ee.bear.appsetting.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class FGDowngradeHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    public FGDowngradeHelper() {
    }

    static {
        a = LazyKt.lazy(FGDowngradeHelper$downgradeCompactModePopover$2.INSTANCE);
        b = LazyKt.lazy(FGDowngradeHelper$downgradeTitleGravity$2.INSTANCE);
        c = LazyKt.lazy(FGDowngradeHelper$downgradeDocLeakMemory$2.INSTANCE);
        d = LazyKt.lazy(FGDowngradeHelper$downgradeSetDataJsbCheck$2.INSTANCE);
        e = LazyKt.lazy(FGDowngradeHelper$downgradeToolBarObserveForever$2.INSTANCE);
        f = LazyKt.lazy(FGDowngradeHelper$downgradeFileBlockLeak$2.INSTANCE);
    }

    public static boolean b() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public static boolean c() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    public static final boolean a(String r2) {
        boolean r0 = c.a.a.g(r2);
        a.h("FGDowngradeHelper", r2 + ": enabled:" + r0);
        return r0;
    }
}
