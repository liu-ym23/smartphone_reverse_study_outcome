package rg5;

import android.app.Dialog;
import android.content.DialogInterface;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements DialogInterface.OnDismissListener {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.d a;

    public f(com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.d r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        Dialog r3 = this.a.c;
        if (r3 != null) goto L5;
        return;
    L5:
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
    }
}
