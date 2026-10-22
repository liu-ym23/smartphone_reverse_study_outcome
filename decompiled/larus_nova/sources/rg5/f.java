package rg5;

import android.app.Dialog;
import android.content.DialogInterface;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.d f537703a;

    public f(com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.d r100) {
        this.f537703a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Dialog r101 = this.f537703a.f233275c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r101);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
    }
}
