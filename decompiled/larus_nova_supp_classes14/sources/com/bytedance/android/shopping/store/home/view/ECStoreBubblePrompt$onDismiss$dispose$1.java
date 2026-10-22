package com.bytedance.android.shopping.store.home.view;

import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECStoreBubblePrompt$onDismiss$dispose$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0 $action;
    final /* synthetic */ g this$0;

    public ECStoreBubblePrompt$onDismiss$dispose$1(g r1, Function0 r2) {
        this.$action = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m191invoke() {
        INVOKEVIRTUAL_com_bytedance_android_shopping_store_home_view_ECStoreBubblePrompt$onDismiss$dispose$1_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(null);
        Function0 r0 = this.$action;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m191invoke();
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_shopping_store_home_view_ECStoreBubblePrompt$onDismiss$dispose$1_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(g r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        throw null;
    }
}
