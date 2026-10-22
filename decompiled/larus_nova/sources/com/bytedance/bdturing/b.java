package com.bytedance.bdturing;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f201740a;

    public b(c r100) {
        this.f201740a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = r100.getId();
        if (r101 != R.id.btn_feedback_close) goto L6;
        c r102 = this.f201740a;
        r102.f201759s = EventReport.CloseType.CLOSE_FB_CLOSE;
    L8:
        c r103 = this.f201740a;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r103);
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r105 == null) goto L22;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L11:
        if (Looper.myLooper() == r104.getLooper()) goto L13;
        r104.post(DialogLancet.createDismissRunnable(r103));
        return;
    L6:
        if (r101 != R.id.btn_feedback) goto L8;
        c r106 = this.f201740a;
        r106.f201759s = EventReport.CloseType.CLOSE_FB_FEEDBACK;
        goto L8
    }
}
