package com.bytedance.dux.panel.header;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.dux.titlebar.DuxNormalTitleBar;
import com.bytedance.dux.titlebar.DuxTitleBar;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/dux/titlebar/DuxTitleBar;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class BasicPanelNormalTitleBarHeader$1 extends Lambda implements Function1<DuxTitleBar, Unit> {
    public static final BasicPanelNormalTitleBarHeader$1 INSTANCE = null;

    static {
        INSTANCE = new BasicPanelNormalTitleBarHeader$1();
    }

    public BasicPanelNormalTitleBarHeader$1() {
        super(1);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelNormalTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DuxTitleBar r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$initHeader");
        if ((r110 instanceof DuxNormalTitleBar) == false) goto L5;
        DuxNormalTitleBar r111 = (DuxNormalTitleBar) r110;
    L6:
        if (r111 == null) goto L38;
        TextView r100 = r111.getStartText();
        if (r100 == null) goto L14;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L13;
        r101.height = -2;
        r100.setLayoutParams(r101);
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        ImageView r102 = r111.getStartBtn();
        if (r102 == null) goto L21;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L20;
        r103.height = r103.width;
        r102.setLayoutParams(r103);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L21:
        ImageView r104 = r111.getStartBtn();
        if (r104 == null) goto L24;
        float r105 = 10;
        r104.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r105, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelNormalTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r105, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelNormalTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r105, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelNormalTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r105, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelNormalTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
    L24:
        TextView r106 = r111.getTitleView();
        if (r106 == null) goto L27;
        float r107 = 10;
        r106.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, r107, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelNormalTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r107, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelNormalTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
    L27:
        ImageView r108 = r111.getEndBtn();
        if (r108 == null) goto L34;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L33;
        r109.height = r109.width;
        r108.setLayoutParams(r109);
        goto L34
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L34:
        ImageView r112 = r111.getEndBtn();
        if (r112 == null) goto L39;
        float r113 = 10;
        r112.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r113, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelNormalTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r113, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelNormalTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r113, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelNormalTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r113, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelNormalTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        return;
    L39:
        return;
    L38:
        return;
    L5:
        r111 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DuxTitleBar r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
