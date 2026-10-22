package com.lynx.devtool.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public class ToastHelper {

    public static class Alert implements Runnable {
        private Context mContext;
        private String mMessage;
        private String mTitle;

        private Alert() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com_lynx_devtool_helper_ToastHelper$Alert_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_lynx_devtool_helper_ToastHelper$Alert__run$___twin___() {
            Context r100 = this.mContext;
            if (r100 == null) goto L6;
            ToastHelper.showAlertSync(this.mTitle, this.mMessage, r100);
            return;
        }

        public /* synthetic */ Alert(AnonymousClass1 r100) {
            this();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_lynx_devtool_helper_ToastHelper$Alert_com_larus_apm_impl_protector_RunnableLancet_run(Alert r100) {
            r100.com_lynx_devtool_helper_ToastHelper$Alert__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void setData(String r100, String r101, Context r102) {
            this.mTitle = r100;
            this.mMessage = r101;
            this.mContext = r102;
        }
    }

    public ToastHelper() {
    }

    public static void INVOKEVIRTUAL_com_lynx_devtool_helper_ToastHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r100) {
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

    public static void showAlert(String r100, String r101, Context r102) {
        Handler r103 = new Handler(Looper.getMainLooper());
        Alert r104 = new Alert(null);
        r104.setData(r100, r101, r102);
        r103.post(r104);
    }

    public static void showAlertSync(String r100, String r101, Context r102) {
        AlertDialog.Builder r103 = new AlertDialog.Builder(r102);     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        AlertDialog r104 = r103.setTitle(r100).setMessage(r101).setNegativeButton("OK", new AnonymousClass1()).create();     // Catch: Throwable -> L9
    L7:
        INVOKEVIRTUAL_com_lynx_devtool_helper_ToastHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r104);     // Catch: Throwable -> L9
        return;
    L6:
        r104 = r103.setTitle(r100).setNegativeButton("OK", new AnonymousClass2()).create();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
    }
}
