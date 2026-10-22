package com.bytedance.ee.docsdk.impl.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/UIUtils;", "", "()V", "sScreenHeight", "", "sScreenWidth", "dp2px", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dpValue", "", "getColor", "resId", "getResources", "Landroid/content/res/Resources;", "getScreenHeight", "getScreenWidth", "px2dp", "pxValue", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UIUtils {
    public static final UIUtils INSTANCE = null;
    private static int sScreenHeight;
    private static int sScreenWidth;

    static {
        INSTANCE = new UIUtils();
    }

    private UIUtils() {
    }

    public final int getScreenWidth() {
        return INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).widthPixels;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final Resources getResources(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return r100.getResources();
    }

    public final int getScreenHeight(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (sScreenHeight > 0) goto L6;
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics r102 = new DisplayMetrics();
        ((WindowManager) r101).getDefaultDisplay().getMetrics(r102);
        sScreenHeight = r102.heightPixels;
    L6:
        return sScreenHeight;
    }

    public final int getScreenWidth(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (sScreenWidth > 0) goto L6;
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics r102 = new DisplayMetrics();
        ((WindowManager) r101).getDefaultDisplay().getMetrics(r102);
        sScreenWidth = r102.widthPixels;
    L6:
        return sScreenWidth;
    }

    public final int dp2px(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (int) ((r101 * INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public final int getColor(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return getResources(r100).getColor(r101);
    }

    public final int px2dp(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (int) ((r101 / INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }
}
