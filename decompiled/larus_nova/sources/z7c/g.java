package z7c;

import android.os.Handler;
import android.os.Looper;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f570770a;

    @Override // z7c.e.a
    public final void a() {
        e.a r100 = this.f570770a.f570764e;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        f r101 = this.f570770a;
        if (r101.f570763d == true) goto L26;
        UDDialog r102 = r101.getMDialog();
        if (r102 == null) goto L30;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r104 == null) goto L23;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L12:
        if (Looper.myLooper() == r103.getLooper()) goto L14;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    L30:
        return;
    }

    public g(f r100) {
        this.f570770a = r100;
    }
}
