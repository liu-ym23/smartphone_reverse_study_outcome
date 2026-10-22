package com.ss.android.socialbase.appdownloader.impls;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.socialbase.appdownloader.depend.AbsDownloadAlertDialogBuilder;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder;

/* JADX INFO: loaded from: classes38.dex */
public class DefaultAlertDialogBuilder extends AbsDownloadAlertDialogBuilder {
    private AlertDialog.Builder builder;

    public static class DownloadAlertDialog implements IDownloadAlertDialog {
        private AlertDialog alertDialog;

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public void dismiss() {
            AlertDialog r100 = this.alertDialog;
            if (r100 == null) goto L6;
            INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_impls_DefaultAlertDialogBuilder$DownloadAlertDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r100);
            return;
        }

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public boolean isShowing() {
            AlertDialog r100 = this.alertDialog;
            if (r100 != null) goto L5;
            return false;
        L5:
            return r100.isShowing();
        }

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public void show() {
            AlertDialog r100 = this.alertDialog;
            if (r100 == null) goto L6;
            INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_impls_DefaultAlertDialogBuilder$DownloadAlertDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r100);
            return;
        }

        public DownloadAlertDialog(AlertDialog.Builder r100) {
            if (r100 == null) goto L6;
            this.alertDialog = r100.show();
            return;
        }

        public static void INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_impls_DefaultAlertDialogBuilder$DownloadAlertDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AlertDialog r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L13:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L10;
            d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }

        public static void INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_impls_DefaultAlertDialogBuilder$DownloadAlertDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r100) {
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r100);
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L7:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
        }

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public Button getButton(int r100) {
            AlertDialog r101 = this.alertDialog;
            if (r101 != null) goto L5;
            return null;
        L5:
            return r101.getButton(r100);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialog show() {
        return new DownloadAlertDialog(this.builder);
    }

    public DefaultAlertDialogBuilder(Context r100) {
        this.builder = new AlertDialog.Builder(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setMessage(String r100) {
        AlertDialog.Builder r101 = this.builder;
        if (r101 == null) goto L5;
        r101.setMessage(r100);
    L5:
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener r100) {
        AlertDialog.Builder r101 = this.builder;
        if (r101 == null) goto L5;
        r101.setOnCancelListener(r100);
    L5:
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setTitle(int r100) {
        AlertDialog.Builder r101 = this.builder;
        if (r101 == null) goto L5;
        r101.setTitle(r100);
    L5:
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setNegativeButton(int r100, DialogInterface.OnClickListener r101) {
        AlertDialog.Builder r102 = this.builder;
        if (r102 == null) goto L5;
        r102.setNegativeButton(r100, r101);
    L5:
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setPositiveButton(int r100, DialogInterface.OnClickListener r101) {
        AlertDialog.Builder r102 = this.builder;
        if (r102 == null) goto L5;
        r102.setPositiveButton(r100, r101);
    L5:
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setNegativeButton(CharSequence r100, DialogInterface.OnClickListener r101) {
        AlertDialog.Builder r102 = this.builder;
        if (r102 == null) goto L5;
        r102.setNegativeButton(r100, r101);
    L5:
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setPositiveButton(CharSequence r100, DialogInterface.OnClickListener r101) {
        AlertDialog.Builder r102 = this.builder;
        if (r102 == null) goto L5;
        r102.setPositiveButton(r100, r101);
    L5:
        return this;
    }
}
