package com.larksuite.framework.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes24.dex */
public class BaseDialog extends AppCompatDialog {
    private final String TAG;
    a mDismissListenner;

    public interface a {
    }

    public static /* synthetic */ void access$000(AppCompatDialog r100) {
        super.show();
    }

    public static /* synthetic */ void access$001(AppCompatDialog r100) {
        super.dismiss();
    }

    public void setDismissListenner(a r100) {
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (checkContext(getContext()) == false) goto L6;
        INVOKESPECIAL_com_larksuite_framework_ui_BaseDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        return;
    }

    @Override // android.app.Dialog
    public void show() {
        if (checkContext(getContext()) == false) goto L6;
        INVOKESPECIAL_com_larksuite_framework_ui_BaseDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        return;
    }

    public BaseDialog(Context r100) {
        super(r100);
        this.TAG = "BaseDialog";
    }

    public static void INVOKESPECIAL_com_larksuite_framework_ui_BaseDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AppCompatDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        access$001(r100);     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKESPECIAL_com_larksuite_framework_ui_BaseDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AppCompatDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        access$000(r100);
        DialogLancet.afterDialogShow(r100);
    }

    private boolean checkContext(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        if ((r100 instanceof Activity) == true) goto L9;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L6
    L9:
        Activity r101 = (Activity) r100;
    L12:
        if (r101 != null) goto L15;
        return false;
    L15:
        if (c.a(r101) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        r101 = null;
        goto L12
    }

    public BaseDialog(Context r100, int r101) {
        super(r100, r101);
        this.TAG = "BaseDialog";
    }

    public BaseDialog(Context r100, boolean r101, DialogInterface.OnCancelListener r102) {
        super(r100, r101, r102);
        this.TAG = "BaseDialog";
    }
}
