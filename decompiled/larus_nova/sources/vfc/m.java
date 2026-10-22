package vfc;

import android.os.Handler;
import android.os.Looper;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f554653a;

    public final void a() {
        o r100 = this.f554653a;
        r100.f554659d = false;
        r100.f554660e.removeCallbacksAndMessages(null);
        if (o.a(r100.f554656a) == false) goto L30;
        LKUIDialog r101 = r100.f554657b;
        if (r101 == null) goto L31;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r103 == null) goto L22;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L11:
        if (Looper.myLooper() == r102.getLooper()) goto L13;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    L31:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m(o r100) {
        this.f554653a = r100;
    }
}
