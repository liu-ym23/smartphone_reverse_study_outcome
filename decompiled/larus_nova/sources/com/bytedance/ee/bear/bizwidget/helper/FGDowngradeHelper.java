package com.bytedance.ee.bear.bizwidget.helper;

import com.bytedance.ee.bear.appsetting.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public final class FGDowngradeHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f216485a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f216486b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f216487c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f216488d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f216489e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f216490f = null;

    public FGDowngradeHelper() {
    }

    static {
        f216485a = LazyKt.lazy(FGDowngradeHelper$downgradeCompactModePopover$2.INSTANCE);
        f216486b = LazyKt.lazy(FGDowngradeHelper$downgradeTitleGravity$2.INSTANCE);
        f216487c = LazyKt.lazy(FGDowngradeHelper$downgradeDocLeakMemory$2.INSTANCE);
        f216488d = LazyKt.lazy(FGDowngradeHelper$downgradeSetDataJsbCheck$2.INSTANCE);
        f216489e = LazyKt.lazy(FGDowngradeHelper$downgradeToolBarObserveForever$2.INSTANCE);
        f216490f = LazyKt.lazy(FGDowngradeHelper$downgradeFileBlockLeak$2.INSTANCE);
    }

    public static boolean b() {
        return ((Boolean) f216487c.getValue()).booleanValue();
    }

    public static boolean c() {
        return ((Boolean) f216488d.getValue()).booleanValue();
    }

    public static final boolean a(String r100) {
        boolean r101 = c.a.f206237a.g(r100);
        a.h("FGDowngradeHelper", r100 + ": enabled:" + r101);
        return r101;
    }
}
