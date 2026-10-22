package com.bytedance.ee.bear.bizwidget.shareview;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.a f216545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.c f216546b;

    public /* synthetic */ e(h.a r100, h.c r101) {
        this.f216545a = r100;
        this.f216546b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        h.a r101 = this.f216545a;
        h.c r102 = this.f216546b;
        r101.getClass();
        r102.a();
        Dialog r103 = r101.f216558a.f216551b;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.isShowing() == false) goto L27;
        Dialog r104 = r101.f216558a.f216551b;
        Handler r105 = DialogLancet.resolveDialogHandler(r104);
        if (r105 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r104);
        r104.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r104);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r106 == null) goto L20;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r104);
        throw th;
    L9:
        if (Looper.myLooper() == r105.getLooper()) goto L11;
        r105.post(DialogLancet.createDismissRunnable(r104));
        return;
    }
}
