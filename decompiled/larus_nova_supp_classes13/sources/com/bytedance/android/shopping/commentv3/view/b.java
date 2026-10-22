package com.bytedance.android.shopping.commentv3.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ CommonAlertDialog a;

    public b(CommonAlertDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        SlcCommonAction r0 = this.a.k.get("cancel_action");
        if (r0 == null) goto L10;
        fc3.a r2 = this.a.i;
        if (r2 == null) goto L7;
        r2.a(new fc3.c(r0, r7, null, 12));
    L7:
        Function2<View, String, Unit> r1 = this.a.o;
        if (r1 == null) goto L10;
        Unit r8 = (Unit) r1.invoke(r7, "cancel_action");
    L10:
        AppCompatDialog r9 = this.a;
        Handler r3 = DialogLancet.resolveDialogHandler(r9);
        if (r3 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r9);
        r9.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r9);
        return;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r4 == null) goto L24;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r9);
        throw th;
    L13:
        if (Looper.myLooper() == r3.getLooper()) goto L15;
        r3.post(DialogLancet.createDismissRunnable(r9));
    }
}
