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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class LiveBottomSheetDialog extends AppCompatDialog {
    public boolean a;
    public boolean b;
    public boolean c;
    public final Context d;

    /* JADX WARN: Multi-variable type inference failed */
    public final void cancel() {
        if (this.a == true) goto L5;
        return;
    L5:
        if (isShowing() == true) goto L7;
        return;
    L7:
        if (this.c == true) goto L10;
        TypedArray r0 = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        this.b = r0.getBoolean(0, true);
        r0.recycle();
        this.c = true;
    L10:
        if (this.b == false) goto L15;
        super/*android.app.Dialog*/.cancel();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        Context r0 = this.d;
        if ((r0 instanceof Activity) == false) goto L8;
        if (((Activity) r0).isFinishing() == false) goto L8;
        return;
    L8:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
    }

    public void dismiss() {
        I0(this);
    }

    public final void onBackPressed() {
        cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
    }

    public LiveBottomSheetDialog(Context r2) {
        super(r2, 2131954116);
        this.a = true;
        this.b = true;
        this.d = r2;
        supportRequestWindowFeature(1);
    }

    public static void I0(AppCompatDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        AoLogger.b("LiveBottomSheetDialog", new Object[]{"#onCreate"});
        if (Build.VERSION.SDK_INT < 28) goto L6;
        WindowManager.LayoutParams r4 = getWindow().getAttributes();
        r4.layoutInDisplayCutoutMode = 2;
        getWindow().setAttributes(r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCancelable(boolean r2) {
        super/*android.app.Dialog*/.setCancelable(r2);
        if (this.a == r2) goto L6;
        this.a = r2;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCanceledOnTouchOutside(boolean r3) {
        super/*android.app.Dialog*/.setCanceledOnTouchOutside(r3);
        if (r3 == true) goto L5;
    L7:
        this.b = r3;
        this.c = true;
        return;
    L5:
        if (this.a == true) goto L7;
        this.a = true;
        goto L7
    }
}
