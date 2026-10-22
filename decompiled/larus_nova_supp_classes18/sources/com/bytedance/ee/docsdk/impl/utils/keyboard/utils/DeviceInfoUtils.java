package com.bytedance.ee.docsdk.impl.utils.keyboard.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.MagicWindowUtil;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000e\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/utils/DeviceInfoUtils;", "", "()V", "TAG", "", "navigationHeight", "", "getNavigationBarHeight", "context", "Landroid/content/Context;", "getVariableRealScreenHeight", "isHuaweiDevice", "", "isOverVersionR", "isSamsung", "isXiaoMiInVersionR", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DeviceInfoUtils {
    public static final DeviceInfoUtils INSTANCE = null;
    private static final String TAG = "DeviceInfoUtils";
    private static int navigationHeight;

    private DeviceInfoUtils() {
    }

    @JvmStatic
    public static final boolean isHuaweiDevice() {
        String r1 = Build.BRAND;     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r1) == false) goto L7;
    L8:
        String r2 = Build.MANUFACTURER;     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r2) == true) goto L18;
        if (StringsKt.startsWith$default(r2.toLowerCase(Locale.getDefault()), "huawei", false, 2, null) == false) goto L19;
    L12:
        return true;
    L19:
        return false;
    L18:
        return false;
    L7:
        if (StringsKt.startsWith$default(r1.toLowerCase(Locale.getDefault()), "huawei", false, 2, null) == true) goto L12;
    L13:
        e = move-exception;
        Log.e(TAG, "isHuaweiDevice: " + e.getMessage());
        return false;
    }

    static {
        INSTANCE = new DeviceInfoUtils();
        navigationHeight = -1;
    }

    @JvmStatic
    public static final boolean isOverVersionR() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean isSamsung() {
        String r0 = Build.MANUFACTURER;
        if (r0 == null) goto L33;
        int r2 = r0.length() - 1;
        int r4 = 0;
        boolean r5 = false;
    L6:
        if (r4 > r2) goto L22;
        if (r5 == true) goto L9;
        int r6 = r4;
    L11:
        if (Intrinsics.compare(r0.charAt(r6), 32) > 0) goto L13;
        boolean r7 = true;
    L14:
        if (r5 == false) goto L15;
        if (r7 == false) goto L22;
        r2 = r2 - 1;
        goto L6
    L15:
        if (r7 == false) goto L16;
        r4 = r4 + 1;
        goto L6
    L16:
        r5 = true;
        goto L6
    L13:
        r7 = false;
        goto L14
    L9:
        r6 = r2;
    L22:
        return Intrinsics.areEqual("samsung", r0.subSequence(r4, r2 + 1).toString());
    L33:
        return false;
    }

    @JvmStatic
    public static final boolean isXiaoMiInVersionR() {
        if (isOverVersionR() == true) goto L5;
    L7:
        return false;
    L5:
        if (MagicWindowUtil.isXiaomi() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final int getNavigationBarHeight(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r0 = navigationHeight;
        if (r0 != (-1)) goto L12;
        Resources r4 = r3.getResources();
        if (r4.getIdentifier("config_showNavigationBar", "bool", "android") == 0) goto L10;
        int r1 = r4.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r1 <= 0) goto L10;
        int r5 = r4.getDimensionPixelSize(r1);
        navigationHeight = r5;
        return r5;
    L10:
        return 0;
    L12:
        return r0;
    }

    @JvmStatic
    public static final int getVariableRealScreenHeight(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Object r2 = r1.getSystemService("window");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.WindowManager");
        Display r3 = ((WindowManager) r2).getDefaultDisplay();
        DisplayMetrics r0 = new DisplayMetrics();
        r3.getRealMetrics(r0);
        return r0.heightPixels;
    }
}
