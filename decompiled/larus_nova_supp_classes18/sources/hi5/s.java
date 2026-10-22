package hi5;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements y.a {
    public final /* synthetic */ x.a a;
    public final /* synthetic */ Dialog b;

    @Override // hi5.y.a
    public final /* synthetic */ void QF() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        x.a r6 = this.a;
        if (r6 == null) goto L21;
        Dialog r0 = this.b;
        t r7 = (t) r6;
        x.g(r7.a, r7.b);
        com.bytedance.ee.bear.middleground.permission.c.w(r7.c, r7.d, "real_name_link", "admin");
        Handler r8 = DialogLancet.resolveDialogHandler(r0);
        if (r8 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r9 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r9 == null) goto L18;
        com.bytedance.crash.d.d(r9, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L7:
        if (Looper.myLooper() == r8.getLooper()) goto L9;
        r8.post(DialogLancet.createDismissRunnable(r0));
        return;
    }

    public s(t r1, UDDialog r2) {
        this.a = r1;
        this.b = r2;
    }
}
