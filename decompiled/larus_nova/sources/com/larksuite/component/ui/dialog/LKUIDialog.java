package com.larksuite.component.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes24.dex */
public class LKUIDialog extends UDDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f284116c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f284117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f284118b;

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        Activity r100 = this.f284118b;
        if (r100 == null) goto L6;
        r100.finish();
        this.f284118b = null;
        return;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        Activity r101 = this.f284118b;
        if (r101 == null) goto L26;
        r101.finish();
        this.f284118b = null;
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public LKUIDialog(Context r100) {
        super(r100);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        getWindow().setSoftInputMode(19);
        super.onCreate(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r100) {
        setContentView(LayoutInflater.from(getContext()).inflate(r100, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100) {
        this.f284117a = r100;
        super.setContentView(r100);
    }

    public LKUIDialog(Context r100, int r101) {
        super(r100, r101);
    }
}
