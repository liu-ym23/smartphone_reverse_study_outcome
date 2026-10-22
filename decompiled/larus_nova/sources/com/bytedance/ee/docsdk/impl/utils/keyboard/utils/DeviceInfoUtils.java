package com.bytedance.ee.docsdk.impl.utils.keyboard.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.MagicWindowUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000e\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/utils/DeviceInfoUtils;", "", "()V", "TAG", "", "navigationHeight", "", "getNavigationBarHeight", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getVariableRealScreenHeight", "isHuaweiDevice", "", "isOverVersionR", "isSamsung", "isXiaoMiInVersionR", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DeviceInfoUtils {
    public static final DeviceInfoUtils INSTANCE = null;
    private static final String TAG = "DeviceInfoUtils";
    private static int navigationHeight;

    private DeviceInfoUtils() {
    }

    @JvmStatic
    public static final boolean isHuaweiDevice() {
        String r100 = Build.BRAND;     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r100) == false) goto L7;
    L8:
        String r101 = Build.MANUFACTURER;     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r101) == true) goto L18;
        if (StringsKt.startsWith$default(r101.toLowerCase(Locale.getDefault()), RomUtils.BRAND_HUAWEI, false, 2, null) == false) goto L19;
    L12:
        return true;
    L19:
        return false;
    L18:
        return false;
    L7:
        if (StringsKt.startsWith$default(r100.toLowerCase(Locale.getDefault()), RomUtils.BRAND_HUAWEI, false, 2, null) == true) goto L12;
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
        String r100 = Build.MANUFACTURER;
        if (r100 == null) goto L33;
        int r101 = r100.length() - 1;
        int r102 = 0;
        boolean r103 = false;
    L6:
        if (r102 > r101) goto L22;
        if (r103 == true) goto L9;
        int r104 = r102;
    L11:
        if (Intrinsics.compare(r100.charAt(r104), 32) > 0) goto L13;
        boolean r105 = true;
    L14:
        if (r103 == false) goto L15;
        if (r105 == false) goto L22;
        r101 = r101 - 1;
        goto L6
    L15:
        if (r105 == false) goto L16;
        r102 = r102 + 1;
        goto L6
    L16:
        r103 = true;
        goto L6
    L13:
        r105 = false;
        goto L14
    L9:
        r104 = r101;
    L22:
        return Intrinsics.areEqual(SmEditTextLeakOpt.SAMSUNG, r100.subSequence(r102, r101 + 1).toString());
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
    public static final int getNavigationBarHeight(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = navigationHeight;
        if (r101 != (-1)) goto L12;
        Resources r102 = r100.getResources();
        if (r102.getIdentifier("config_showNavigationBar", "bool", "android") == 0) goto L10;
        int r103 = r102.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r103 <= 0) goto L10;
        int r104 = r102.getDimensionPixelSize(r103);
        navigationHeight = r104;
        return r104;
    L10:
        return 0;
    L12:
        return r101;
    }

    @JvmStatic
    public static final int getVariableRealScreenHeight(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.WindowManager");
        Display r102 = ((WindowManager) r101).getDefaultDisplay();
        DisplayMetrics r103 = new DisplayMetrics();
        r102.getRealMetrics(r103);
        return r103.heightPixels;
    }
}
