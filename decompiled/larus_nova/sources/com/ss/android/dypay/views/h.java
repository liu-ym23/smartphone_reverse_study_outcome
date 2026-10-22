package com.ss.android.dypay.views;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.dypay.activity.DyPayH5Activity;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f408524a;

    public h(g r100) {
        this.f408524a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DyPayH5Activity r101 = ((com.ss.android.dypay.activity.e) this.f408524a.f408523d).f408382a;
        int r102 = DyPayH5Activity.f408351v;
        r101.finish();
        DyPayH5Activity.j(r101, "close", null, 6);
        g r103 = this.f408524a;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r103);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r105 == null) goto L16;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r104.getLooper()) goto L7;
        r104.post(DialogLancet.createDismissRunnable(r103));
    }
}
