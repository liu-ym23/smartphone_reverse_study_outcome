package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\u0012\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleon/util/MagicWindowUtil;", "", "()V", "BRAND_HONOR", "", "BRAND_HUAWEI", "BRAND_XIAOMI", "TAG", "TAG_MAGIC_WINDOW", "getRealWindowWidth", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Integer;", "isHuawei", "", "isMagicWindow", "isPad", "isXiaomi", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MagicWindowUtil {
    private static final String BRAND_HONOR = "honor";
    private static final String BRAND_HUAWEI = "huawei";
    private static final String BRAND_XIAOMI = "xiaomi";
    public static final MagicWindowUtil INSTANCE = null;
    public static final String TAG = "Magic_Window";
    private static final String TAG_MAGIC_WINDOW = "magic-windows";

    static {
        INSTANCE = new MagicWindowUtil();
    }

    private MagicWindowUtil() {
    }

    @JvmStatic
    public static final boolean isHuawei() {
        String r100 = Build.BRAND;
        if (StringsKt.contains$default(r100.toLowerCase(), "huawei", false, 2, null) == false) goto L5;
    L6:
        return true;
    L5:
        if (StringsKt.contains$default(r100.toLowerCase(), "honor", false, 2, null) == true) goto L6;
        return false;
    }

    @JvmStatic
    public static final boolean isXiaomi() {
        return StringsKt.contains$default(Build.BRAND.toLowerCase(), "xiaomi", false, 2, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_MagicWindowUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @JvmStatic
    public static final Integer getRealWindowWidth(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r101 = r100.getResources();
        if (r101 == null) goto L7;
        DisplayMetrics r102 = INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_MagicWindowUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101);
        if (r102 == null) goto L7;
        int r103 = r102.widthPixels;
    L9:
        return Integer.valueOf(r103);
    L7:
        r103 = 0;
        goto L9
    }

    @JvmStatic
    public static final boolean isMagicWindow(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return StringsKt.contains$default(r100.getResources().getConfiguration().toString(), TAG_MAGIC_WINDOW, false, 2, null);
    }

    @JvmStatic
    public static final boolean isPad(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100.getResources().getConfiguration().screenLayout & 15) < 3) goto L5;
        return true;
    L5:
        return false;
    }
}
