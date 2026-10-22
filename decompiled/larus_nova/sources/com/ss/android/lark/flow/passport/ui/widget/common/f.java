package com.ss.android.lark.flow.passport.ui.widget.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.officesdk.utils.RomUtils;
import com.ss.android.lark.utils.Contexts;
import uzb.l;

/* JADX INFO: loaded from: classes36.dex */
public final class f extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f423842a;

    public final boolean a() {
        Context r100 = getContext();
        if ((r100 instanceof Activity) == false) goto L6;
        Activity r101 = Contexts.requireActivity(r100);
    L12:
        if (r101 != null) goto L15;
        return false;
    L15:
        if (r101.isFinishing() == false) goto L17;
        return false;
    L17:
        if (r101.isDestroyed() == true) goto L21;
        return true;
    L21:
        return false;
    L6:
        if ((r100 instanceof ContextWrapper) == false) goto L10;
        Context r102 = ((ContextWrapper) r100).getBaseContext();
        if ((r102 instanceof Activity) == false) goto L10;
        r101 = Contexts.requireActivity(r102);
    L10:
        r101 = null;
        goto L12
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (a() == false) goto L21;
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r101 == null) goto L18;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r100.getLooper()) goto L9;
        r100.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (a() == true) goto L5;
        return;
    L5:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(this);
    L10:
        if (this.f423842a == false) goto L24;
        Context r100 = getContext();
        Window r101 = getWindow();
        int r102 = l.b(r100, R.color.transparent);
        if (h18.f.a(r100) == false) goto L17;
        if (RomUtils.g(false, r100, r101) == false) goto L25;
        r101.addFlags(Integer.MIN_VALUE);
        r101.clearFlags(67108864);
        r101.setStatusBarColor(r102);
        return;
    L25:
        return;
    L17:
        if (RomUtils.g(true, r100, r101) == false) goto L27;
        r101.addFlags(Integer.MIN_VALUE);
        r101.clearFlags(67108864);
        r101.setStatusBarColor(r102);
        return;
    L27:
        return;
    L24:
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L8:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L10
    }

    public f(Context r100, boolean r101) {
        super(r100, R.style.DialogStyle);
        this.f423842a = false;
        this.f423842a = r101;
        setContentView(R.layout.signin_sdk_dialog_loading);
        setCanceledOnTouchOutside(false);
        getWindow().setGravity(17);
    }
}
