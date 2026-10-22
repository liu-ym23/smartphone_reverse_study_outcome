package com.bytedance.android.shopping.commentv3.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ SheetPanelDialog.SheetCellViewHolder a;
    public final /* synthetic */ Map b;

    public d(SheetPanelDialog.SheetCellViewHolder r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Map r0 = this.b;
        if (r0 == null) goto L9;
        Map<String, Object> r1 = nc3.a.g(r0);
        SlcCommonAction.Companion.getClass();
        SlcCommonAction r2 = SlcCommonAction.a.b(r1);
        if (r2 == null) goto L9;
        fc3.a r3 = this.a.b.d;
        if (r3 == null) goto L9;
        r3.a(new fc3.c(r2, r6, null, 12));
    L9:
        AppCompatDialog r7 = this.a.b;
        r7.c = SheetPanelDialog.CloseReason.CLICK_ACTION;
        Handler r4 = DialogLancet.resolveDialogHandler(r7);
        if (r4 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r7);
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r5 == null) goto L23;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L12:
        if (Looper.myLooper() == r4.getLooper()) goto L14;
        r4.post(DialogLancet.createDismissRunnable(r7));
    }
}
