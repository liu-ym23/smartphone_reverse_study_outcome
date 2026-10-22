package com.obric.oui.dropdown;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "V", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ODropdownRatio$popMenu$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.obric.oui.popover.a $popover;

    public ODropdownRatio$popMenu$1(com.obric.oui.popover.a r100) {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        INVOKEVIRTUAL_com_obric_oui_dropdown_ODropdownRatio$popMenu$1_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(null);
    }

    public static void INVOKEVIRTUAL_com_obric_oui_dropdown_ODropdownRatio$popMenu$1_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(com.obric.oui.popover.a r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        throw null;
    }
}
