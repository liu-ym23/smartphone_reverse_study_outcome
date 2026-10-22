package hw4;

import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class a implements com.bytedance.ee.bear.content.common.morepanel.a.InterfaceC3091a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActionSheetDialogFragment f487412a;

    public /* synthetic */ a(ActionSheetDialogFragment r100) {
        this.f487412a = r100;
    }

    public final void a() {
        ActionSheetDialogFragment r100 = this.f487412a;
        int r101 = ActionSheetDialogFragment.f216770j;
        if (com.bytedance.ee.util.ui.b.a(r100.getActivity()) == false) goto L13;
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L14;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }
}
