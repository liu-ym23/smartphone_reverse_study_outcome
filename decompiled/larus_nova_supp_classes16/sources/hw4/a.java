package hw4;

import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class a implements com.bytedance.ee.bear.content.common.morepanel.a.InterfaceC0035a {
    public final /* synthetic */ ActionSheetDialogFragment a;

    public /* synthetic */ a(ActionSheetDialogFragment r1) {
        this.a = r1;
    }

    public final void a() {
        ActionSheetDialogFragment r0 = this.a;
        int r1 = ActionSheetDialogFragment.j;
        if (com.bytedance.ee.util.ui.b.a(r0.getActivity()) == false) goto L13;
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L14;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }
}
