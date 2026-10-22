package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CardListViewWrapper$interactBackOnce$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BackInteractDialog $dialog;

    public CardListViewWrapper$interactBackOnce$1$1(BackInteractDialog r100) {
        this.$dialog = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        INVOKEVIRTUAL_com_suite_lark_platform_component_widget_biz_dinghelper_helper_view_CardListViewWrapper$interactBackOnce$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.$dialog);
    }

    public static void INVOKEVIRTUAL_com_suite_lark_platform_component_widget_biz_dinghelper_helper_view_CardListViewWrapper$interactBackOnce$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(BackInteractDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }
}
