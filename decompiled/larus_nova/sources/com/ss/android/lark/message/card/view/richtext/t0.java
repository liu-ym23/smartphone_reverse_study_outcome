package com.ss.android.lark.message.card.view.richtext;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.ui.navigation.LKUISearchView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes36.dex */
public final class t0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LKUISearchView f432088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LKUIDialog f432089b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LKUISearchView r101 = this.f432088a;
        r101.getClass();
        LKUISearchView.b(r101);
        LKUIDialog r102 = this.f432089b;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r104 == null) goto L16;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L5:
        if (Looper.myLooper() == r103.getLooper()) goto L7;
        r103.post(DialogLancet.createDismissRunnable(r102));
    }

    public t0(LKUISearchView r100, LKUIDialog r101) {
        this.f432088a = r100;
        this.f432089b = r101;
    }
}
