package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e0<T> implements Observer {
    public final /* synthetic */ LiveFlashNewFragment a;

    public e0(LiveFlashNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        String[] r8 = (String[]) r7;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.length < 3) goto L22;
        String r1 = r8[0];
        String r2 = r8[1];
        String r9 = r8[2];
        LiveFlashNewFragment r3 = this.a;
        Context r4 = r3.getContext();
        int r5 = LiveFlashNewFragment.w;
        if (r4 != null) goto L10;
        Dialog r10 = null;
    L16:
        r3.s = r10;
        return;
    L10:
        Dialog r6 = new ECAlertDialog(r4);
        r6.setTitle(r1);
        r6.setCancelable(false);
        r6.setCanceledOnTouchOutside(false);
        r6.setMessage(r2);
        r6.setPositiveButton(r9, v.a);
        r6.hideNegativeButton();
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r6);
    L15:
        r10 = r6;
        goto L16
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L14:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        goto L15
    }
}
