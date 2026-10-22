package com.ss.android.downloadlib.downloader;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder;

/* JADX INFO: loaded from: classes34.dex */
public class NewDownloadDepend extends AbsAppDownloadDepend {
    private static String TAG;

    public static class DownloadAlertDialog implements IDownloadAlertDialog {
        private Dialog dialog;

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public Button getButton(int r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public void dismiss() {
            Dialog r100 = this.dialog;
            if (r100 == null) goto L6;
            INVOKEVIRTUAL_com_ss_android_downloadlib_downloader_NewDownloadDepend$DownloadAlertDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r100);
            return;
        }

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public boolean isShowing() {
            Dialog r100 = this.dialog;
            if (r100 != null) goto L5;
            return false;
        L5:
            return r100.isShowing();
        }

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public void show() {
            Dialog r100 = this.dialog;
            if (r100 == null) goto L6;
            INVOKEVIRTUAL_com_ss_android_downloadlib_downloader_NewDownloadDepend$DownloadAlertDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r100);
            return;
        }

        public DownloadAlertDialog(Dialog r100) {
            if (r100 == null) goto L6;
            this.dialog = r100;
            show();
            return;
        }

        public static void INVOKEVIRTUAL_com_ss_android_downloadlib_downloader_NewDownloadDepend$DownloadAlertDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
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

        public static void INVOKEVIRTUAL_com_ss_android_downloadlib_downloader_NewDownloadDepend$DownloadAlertDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r100) {
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
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend, com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public boolean getAllowBootReceiver() {
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend, com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public boolean getAllowNetwork(Context r100) {
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend
    public boolean needClearWhenTaskReset() {
        return false;
    }

    static {
        TAG = "NewDownloadDepend";
    }

    public NewDownloadDepend() {
    }

    public static /* synthetic */ String access$300() {
        return TAG;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend, com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public IDownloadAlertDialogBuilder getThemedAlertDlgBuilder(final Context r100) {
        return new AnonymousClass1(this, r100);
    }
}
