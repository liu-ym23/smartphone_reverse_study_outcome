package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes14.dex */
public class LiveBottomSheetDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f196880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f196881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f196882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f196883d;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.f196880a == true) goto L5;
        return;
    L5:
        if (isShowing() == true) goto L7;
        return;
    L7:
        if (this.f196882c == true) goto L10;
        TypedArray r100 = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        this.f196881b = r100.getBoolean(0, true);
        r100.recycle();
        this.f196882c = true;
    L10:
        if (this.f196881b == false) goto L15;
        super.cancel();
        return;
    }

    @Override // android.app.Dialog
    public void show() {
        Context r100 = this.f196883d;
        if ((r100 instanceof Activity) == false) goto L8;
        if (((Activity) r100).isFinishing() == false) goto L8;
        return;
    L8:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        I0(this);
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        cancel();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public LiveBottomSheetDialog(Context r100) {
        super(r100, com.larus.nova.R.style.aos_common_bottom_dialog_normal);
        this.f196880a = true;
        this.f196881b = true;
        this.f196883d = r100;
        supportRequestWindowFeature(1);
    }

    public static void I0(AppCompatDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        AoLogger.b("LiveBottomSheetDialog", new Object[]{"#onCreate"});
        if (Build.VERSION.SDK_INT < 28) goto L6;
        WindowManager.LayoutParams r101 = getWindow().getAttributes();
        r101.layoutInDisplayCutoutMode = 2;
        getWindow().setAttributes(r101);
        return;
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r100) {
        super.setCancelable(r100);
        if (this.f196880a == r100) goto L6;
        this.f196880a = r100;
        return;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        if (r100 == true) goto L5;
    L7:
        this.f196881b = r100;
        this.f196882c = true;
        return;
    L5:
        if (this.f196880a == true) goto L7;
        this.f196880a = true;
        goto L7
    }
}
