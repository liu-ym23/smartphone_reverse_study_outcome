package com.bytedance.dux.panel.header;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.dux.titlebar.DuxTextTitleBar;
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
final class BasicPanelTextTitleBarHeader$1 extends Lambda implements Function1<DuxTitleBar, Unit> {
    public static final BasicPanelTextTitleBarHeader$1 INSTANCE = null;

    static {
        INSTANCE = new BasicPanelTextTitleBarHeader$1();
    }

    public BasicPanelTextTitleBarHeader$1() {
        super(1);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelTextTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DuxTitleBar r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$initHeader");
        if ((r100 instanceof DuxTextTitleBar) == false) goto L5;
        DuxTextTitleBar r101 = (DuxTextTitleBar) r100;
    L6:
        if (r101 == null) goto L35;
        TextView r102 = r101.getStartText();
        if (r102 == null) goto L14;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L13;
        r103.height = -2;
        r102.setLayoutParams(r103);
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        TextView r104 = r101.getEndText();
        if (r104 == null) goto L21;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L20;
        r105.height = -2;
        r104.setLayoutParams(r105);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L21:
        ImageView r106 = r101.getBackBtn();
        if (r106 == null) goto L28;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L27;
        r107.height = r107.width;
        r106.setLayoutParams(r107);
        goto L28
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L28:
        ImageView r108 = r101.getBackBtn();
        if (r108 == null) goto L31;
        float r109 = 10;
        r108.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r109, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelTextTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r109, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelTextTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r109, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelTextTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r109, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelTextTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
    L31:
        TextView r110 = r101.getTitleView();
        if (r110 == null) goto L36;
        float r111 = 10;
        r110.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, r111, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelTextTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r111, INVOKEVIRTUAL_com_bytedance_dux_panel_header_BasicPanelTextTitleBarHeader$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        return;
    L36:
        return;
    L35:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DuxTitleBar r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
