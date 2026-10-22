package foc;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f478201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f478202b;

    public b(c r100, String r101) {
        this.f478201a = r100;
        this.f478202b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        e r101 = this.f478201a.f478205c;
        if (r101 == null) goto L6;
        r101.a(this.f478202b);
    L6:
        if (this.f478201a.getMAutoDismiss() == false) goto L26;
        UDDialog r102 = this.f478201a.getMDialog();
        if (r102 == null) goto L30;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r104 == null) goto L23;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L12:
        if (Looper.myLooper() == r103.getLooper()) goto L14;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    L30:
        return;
    }
}
