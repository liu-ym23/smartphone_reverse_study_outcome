package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0<T> implements Observer {
    public final /* synthetic */ LiveFlashNewFragment a;

    public a0(LiveFlashNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Void r5 = (Void) r4;
        Context r6 = this.a.getContext();
        Context r0 = this.a.getContext();
        if (r0 == null) goto L5;
        String r1 = th.a.g(r0, 2131896599);
    L6:
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r6, r1);
        LiveFlashNewFragment r7 = this.a;
        r7.n = false;
        Dialog r8 = r7.p;
        if (r8 == null) goto L36;
        Handler r2 = DialogLancet.resolveDialogHandler(r8);
        if (r2 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r8);
        r8.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r8);
        goto L36
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r8);
        throw th;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r3 == null) goto L22;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        goto L22
    L11:
        if (Looper.myLooper() == r2.getLooper()) goto L13;
        r2.post(DialogLancet.createDismissRunnable(r8));
    L36:
        this.a.dismiss();     // Catch: Exception -> L28
        return;
    L28:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L38;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L38:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
