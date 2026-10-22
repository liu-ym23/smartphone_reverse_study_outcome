package com.ss.android.download.api.config;

import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.app.NotificationCompat;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadUIFactory {
    Notification buildNotification(NotificationCompat.Builder r100);

    Dialog showAlertDialog(DownloadAlertDialogInfo r100);

    void showToastWithDuration(int r100, Context r101, DownloadModel r102, String r103, Drawable r104, int r105);
}
