package com.bytedance.ee.bear.bitable.card.view.page;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoSubscribeConfirmDialog f208572a;

    public c(AutoSubscribeConfirmDialog r100) {
        this.f208572a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AutoSubscribeConfirmDialog.da0(this.f208572a, true);
        BitableAnalytic r101 = this.f208572a.f208459k.bitableAnalytic();
        r101.getClass();
        HashMap r102 = new HashMap();
        r102.put("click", "cancel_subscribe");
        r102.put(PickerReporterConstants.KEY.TARGET, "none");
        r101.t("ccm_bitable_record_unsubscribe_click", r102);
        Dialog r103 = this.f208572a.getDialog();
        if (r103 == null) goto L21;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r103);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r105 == null) goto L18;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r104.getLooper()) goto L9;
        r104.post(DialogLancet.createDismissRunnable(r103));
        return;
    }
}
