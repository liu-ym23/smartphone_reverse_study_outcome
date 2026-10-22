package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b0<T> implements Observer {
    public final /* synthetic */ LiveFlashNewFragment a;

    public b0(LiveFlashNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        xi2.o r5 = (xi2.o) r4;
        Context r0 = this.a.getContext();
        if (r0 == null) goto L14;
        if (r5 == null) goto L6;
        ECV2PopupInfo r1 = r5.getPopupInfo();
    L7:
        if (r1 == null) goto L9;
        LiveFlashNewFragment r2 = this.a;
        int r3 = com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut.b.a;
        r2.t = com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut.b.a(r0, r5.getPopupInfo());
        goto L14
    L9:
        if (r5 == null) goto L12;
        String r6 = ((com.bytedance.android.ec.model.g) r5).statusMessage;
        if (r6 == null) goto L12;
    L13:
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r0, r6);
    L12:
        r6 = th.a.g(r0, 2131896598);
        goto L13
    L6:
        r1 = null;
    L14:
        Dialog r7 = this.a.p;
        if (r7 == null) goto L33;
        Handler r8 = DialogLancet.resolveDialogHandler(r7);
        if (r8 != null) goto L19;
    L21:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L24 Exception -> L26
    L30:
        DialogLancet.afterDialogDismiss(r7);
        goto L33
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L24
        Throwable r9 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L24
        if (r9 == null) goto L30;
        com.bytedance.crash.d.d(r9, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L19:
        if (Looper.myLooper() == r8.getLooper()) goto L21;
        r8.post(DialogLancet.createDismissRunnable(r7));
    L33:
        LiveFlashNewFragment r10 = this.a;
        int r11 = com.bytedance.android.livesdk.livecommerce.utils.t.a;
        r10.qa0(true, com.bytedance.android.livesdk.livecommerce.utils.t.a(r10.getContext(), 2131896551));
    }
}
