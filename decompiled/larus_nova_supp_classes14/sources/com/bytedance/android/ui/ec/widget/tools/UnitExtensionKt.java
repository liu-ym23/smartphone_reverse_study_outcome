package com.bytedance.android.ui.ec.widget.tools;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\u001a\u000e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001\"\"\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\"\u0010\u0006\u001a\u00020\u0007\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\"\u0010\n\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005\"\"\u0010\f\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u0010"}, d2 = {"dp", "", "T", "", "getDp", "(Ljava/lang/Number;)I", "dpFloat", "", "getDpFloat", "(Ljava/lang/Number;)F", "px", "getPx", "sp", "getSp", "dp2px", "dpValue", "ui-ec-widget_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class UnitExtensionKt {
    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_tools_UnitExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final int dp2px(int r1) {
        return (int) ((r1 * INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_tools_UnitExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density) + 0.5f);
    }

    public static final /* synthetic */ <T extends Number> int getDp(T r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$dp");
        return MathKt.roundToInt(TypedValue.applyDimension(1, r2.floatValue(), INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_tools_UnitExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
    }

    public static final /* synthetic */ <T extends Number> float getDpFloat(T r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$dpFloat");
        return TypedValue.applyDimension(1, r2.floatValue(), INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_tools_UnitExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()));
    }

    public static final /* synthetic */ <T extends Number> int getPx(T r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$px");
        return r1.intValue();
    }

    public static final /* synthetic */ <T extends Number> int getSp(T r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$sp");
        return MathKt.roundToInt(TypedValue.applyDimension(2, r2.floatValue(), INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_tools_UnitExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
    }
}
