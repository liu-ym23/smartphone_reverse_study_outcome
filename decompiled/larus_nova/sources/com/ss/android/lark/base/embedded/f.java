package com.ss.android.lark.base.embedded;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.huawei.hms.android.SystemUtils;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final boolean a() {
        if (StringsKt.equals(SystemUtils.PRODUCT_HUAWEI, Build.MANUFACTURER, true) == false) goto L14;
        Context r100 = b.f409746a;
        if (r100 == null) goto L11;
        PackageManager r101 = r100.getPackageManager();
        if (r101 == null) goto L11;
        if (r101.hasSystemFeature("com.huawei.hardware.sensor.posture") != true) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return true;
    L11:
        r102 = false;
    L14:
        return false;
    }
}
