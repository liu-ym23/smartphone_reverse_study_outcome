package com.ss.android.download.api.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.ss.android.download.api.config.DownloadUIFactory;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;

/* JADX INFO: loaded from: classes34.dex */
public class DefaultDownloadUIFactory implements DownloadUIFactory {
    public DefaultDownloadUIFactory() {
    }

    @Override // com.ss.android.download.api.config.DownloadUIFactory
    public Notification buildNotification(NotificationCompat.Builder r100) {
        return null;
    }

    private static Dialog showDialog(final DownloadAlertDialogInfo r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        AlertDialog r101 = new AlertDialog.Builder(r100.mContext).setTitle(r100.mTitle).setMessage(r100.mMessage).setPositiveButton(r100.mPositiveBtnText, new AnonymousClass2(r100)).setNegativeButton(r100.mNegativeBtnText, new AnonymousClass1(r100)).show();
        r101.setCanceledOnTouchOutside(r100.mCancelableOnTouchOutside);
        r101.setOnCancelListener(new AnonymousClass3(r100));
        Drawable r102 = r100.mIcon;
        if (r102 == null) goto L8;
        r101.setIcon(r102);
    L8:
        return r101;
    }

    @Override // com.ss.android.download.api.config.DownloadUIFactory
    public Dialog showAlertDialog(DownloadAlertDialogInfo r100) {
        return showDialog(r100);
    }

    @Override // com.ss.android.download.api.config.DownloadUIFactory
    public void showToastWithDuration(int r100, Context r101, DownloadModel r102, String r103, Drawable r104, int r105) {
        Toast.makeText(r101, r103, 0).show();
    }
}
