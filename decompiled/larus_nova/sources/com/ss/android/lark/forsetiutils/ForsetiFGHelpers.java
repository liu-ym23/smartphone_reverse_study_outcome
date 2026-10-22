package com.ss.android.lark.forsetiutils;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ForsetiFGHelpers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f424763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f424764b = null;

    static {
        f424763a = LazyKt.lazy(ForsetiFGHelpers$enableForseti$2.INSTANCE);
        f424764b = LazyKt.lazy(ForsetiFGHelpers$enableResponsiveCompoentInner$2.INSTANCE);
    }

    public static boolean d() {
        if (((Boolean) f424764b.getValue()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (e() == false) goto L7;
        return true;
    }

    public static boolean e() {
        return ((Boolean) f424763a.getValue()).booleanValue();
    }

    public static boolean a(BizType r100) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        if (e() == true) goto L5;
    L7:
        return false;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti." + r100.getKey()) == true) goto L7;
        return true;
    }

    public static boolean b(BizType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        Intrinsics.checkNotNullParameter(r101, "pageName");
        if (a(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti." + r100.getKey() + '.' + r101) == true) goto L7;
        return true;
    }

    public static boolean c(BizType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        Intrinsics.checkNotNullParameter(r101, "featureId");
        if (a(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti." + r100.getKey() + '.' + r101) == true) goto L7;
        return true;
    }
}
