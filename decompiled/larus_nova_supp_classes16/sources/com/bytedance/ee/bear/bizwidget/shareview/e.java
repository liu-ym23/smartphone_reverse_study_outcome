package com.bytedance.ee.bear.bizwidget.shareview;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class e implements View.OnClickListener {
    public final /* synthetic */ h.a a;
    public final /* synthetic */ h.c b;

    public /* synthetic */ e(h.a r1, h.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        h.a r5 = this.a;
        h.c r0 = this.b;
        r5.getClass();
        r0.a();
        Dialog r1 = r5.a.b;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isShowing() == false) goto L27;
        Dialog r6 = r5.a.b;
        Handler r2 = DialogLancet.resolveDialogHandler(r6);
        if (r2 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r3 == null) goto L20;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L9:
        if (Looper.myLooper() == r2.getLooper()) goto L11;
        r2.post(DialogLancet.createDismissRunnable(r6));
        return;
    }
}
