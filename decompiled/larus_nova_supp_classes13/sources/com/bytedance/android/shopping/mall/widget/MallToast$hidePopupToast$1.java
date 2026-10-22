package com.bytedance.android.shopping.mall.widget;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class MallToast$hidePopupToast$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b this$0;

    public MallToast$hidePopupToast$1(b r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1511invoke() {
        if (this.this$0.isShowing() == false) goto L8;
        b r0 = this.this$0;
        if (r0.b == false) goto L9;
        INVOKEVIRTUAL_com_bytedance_android_shopping_mall_widget_MallToast$hidePopupToast$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r0);
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1511invoke();
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_shopping_mall_widget_MallToast$hidePopupToast$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(b r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }
}
