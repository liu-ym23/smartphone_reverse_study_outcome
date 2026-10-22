package com.ss.android.bytedcert.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes34.dex */
public class SSDialog extends AppCompatDialog {
    protected Activity mContext;

    public static /* synthetic */ void access$000(AppCompatDialog r100) {
        super.show();
    }

    public boolean isViewValid() {
        return !this.mContext.isFinishing();
    }

    @Override // android.app.Dialog
    public void show() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        INVOKESPECIAL_com_ss_android_bytedcert_dialog_SSDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
    }

    public SSDialog(Activity r100) {
        super(r100);
        this.mContext = r100;
    }

    public static void INVOKESPECIAL_com_ss_android_bytedcert_dialog_SSDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AppCompatDialog r100) {
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

    public SSDialog(Activity r100, int r101) {
        super(r100, r101);
        this.mContext = r100;
    }

    public SSDialog(Activity r100, boolean r101, DialogInterface.OnCancelListener r102) {
        super(r100, r101, r102);
        this.mContext = r100;
    }
}
