package com.bytedance.ee.bear.appsetting.downgrade;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: classes15.dex */
public final class DowngradeSettingUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f206254a = null;

    static {
        f206254a = LazyKt.lazy(DowngradeSettingUtil$downgradeSettingConfig$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "downgradeKey");
        Boolean r101 = (Boolean) ((DowngradeSettingMap) f206254a.getValue()).get(r100);
        if (r101 == null) goto L5;
        boolean r102 = r101.booleanValue();
    L6:
        a.h("DowngradeSettingUtil", r100 + ": isDowngrade:" + r102);
        return r102;
    L5:
        r102 = false;
        goto L6
    }
}
