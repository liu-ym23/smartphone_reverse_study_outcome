package com.ss.android.cert.manager.ablity;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes34.dex */
public interface ICertDialogDepend {

    public static class AlertDialogParams {
        public Context context;
        public String message;
        public String negativeLabel;
        public DialogInterface.OnClickListener negativeListener;
        public String positiveLabel;
        public DialogInterface.OnClickListener positiveListener;
        public String title;
        public String type;

        public AlertDialogParams() {
        }
    }

    public interface DialogType {
        public static final String FACE_RETAIN = "face_retain";
        public static final String FACE_RETRY = "face_retry";
    }

    boolean showAlertDialog(AlertDialogParams r100);

    ICertLoadingDialog showLoading(Context r100, String r101);
}
