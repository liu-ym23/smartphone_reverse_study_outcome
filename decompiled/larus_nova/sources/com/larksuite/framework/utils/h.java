package com.larksuite.framework.utils;

import android.os.Build;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.ss.android.lark.log.Log;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f285996a = 0;

    static {
    }

    public static boolean a(String r100, String r101) {
        if (r100 == null) goto L10;
        String r102 = r100.toLowerCase(Locale.ROOT);
        if (r102 != null) goto L7;
        return false;
    L7:
        if (StringsKt.contains$default(r102, r101, false, 2, null) != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @JvmStatic
    public static final boolean b(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (r101 == false) goto L5;
    L36:
        boolean r103 = false;
    L37:
        if (r103 == false) goto L40;
        Log.e("ExplicitGcGuard", "skip explicit gc for OPPO-family Android 15, reason=".concat(r100));
        return false;
    L40:
        System.gc();
        if (r102 == false) goto L43;
        System.runFinalization();
    L43:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 35) goto L8;
    L32:
        boolean r104 = false;
    L34:
        if (r104 == false) goto L36;
        r103 = true;
        goto L37
    L8:
        if (RomUtils.f285921d[0].equals(RomUtils.e().f285940a) == false) goto L10;
    L33:
        r104 = true;
        goto L34
    L10:
        if (RomUtils.f285925h[0].equals(RomUtils.e().f285940a) == true) goto L33;
        String r105 = Build.BRAND;
        if (a(r105, "realme") == false) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == true) goto L33;
        if (a(r105, AppConstants.CHANNEL_OPPO) == false) goto L22;
    L29:
        boolean r107 = true;
    L30:
        if (r107 == false) goto L32;
    L22:
        if (a(r105, "oneplus") == true) goto L29;
        String r108 = Build.MANUFACTURER;
        if (a(r108, AppConstants.CHANNEL_OPPO) == true) goto L29;
        if (a(r108, "oneplus") == true) goto L29;
        r107 = false;
        goto L30
    L14:
        if (a(Build.MANUFACTURER, "realme") == true) goto L17;
        r106 = false;
        goto L18
    }
}
