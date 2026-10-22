package com.larus.common_ui.dialog;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes27.dex */
public final class e0 {
    public static void a(l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static final void b(l0 r100, Activity r101) {
        if (r101 != null) goto L16;
    L6:
        boolean r102 = false;
    L7:
        if (r102 == false) goto L18;
        if (r100 != null) goto L10;
        return;
    L10:
        if (r100.isShowing() == false) goto L20;
        a(r100);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        FLogger.f375446a.e("safeDismissDialog", "commonLoadDialog dismiss crash because: " + e.getMessage(), e);
        return;
    L20:
        return;
    L18:
        return;
    L16:
        if (r101.isFinishing() == true) goto L6;
        r102 = true;
        goto L7
    }
}
