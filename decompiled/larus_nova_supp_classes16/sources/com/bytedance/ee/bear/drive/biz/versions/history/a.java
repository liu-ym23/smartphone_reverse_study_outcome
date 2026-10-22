package com.bytedance.ee.bear.drive.biz.versions.history;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import b95.l;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements l.a {
    public final /* synthetic */ DriveHistoryModePlugin a;

    @Override // b95.l.a
    public final void cancel() {
        Dialog r0 = DriveHistoryModePlugin.access$getMVersionChangeDialog$p(this.a);
        if (r0 == null) goto L5;
        a(r0);
    L5:
        this.a.getHost().c.enterHistoryMode();
    }

    @Override // b95.l.a
    public final void confirm() {
        Dialog r0 = DriveHistoryModePlugin.access$getMVersionChangeDialog$p(this.a);
        if (r0 == null) goto L5;
        a(r0);
    L5:
        int r1 = d75.a.a;
        d75.a.a(this.a.getHost(), (DriveMGPermissionVM) DriveHistoryModePlugin.access$viewModel(this.a, DriveMGPermissionVM.class), "user_confirm");
    }

    public a(DriveHistoryModePlugin r1) {
        this.a = r1;
    }

    public static void a(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }
}
