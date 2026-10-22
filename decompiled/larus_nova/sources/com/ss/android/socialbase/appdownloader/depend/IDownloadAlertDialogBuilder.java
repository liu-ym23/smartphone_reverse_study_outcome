package com.ss.android.socialbase.appdownloader.depend;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadAlertDialogBuilder {
    IDownloadAlertDialogBuilder setCanceledOnTouchOutside(boolean r100);

    IDownloadAlertDialogBuilder setIcon(int r100);

    IDownloadAlertDialogBuilder setIcon(Drawable r100);

    IDownloadAlertDialogBuilder setMessage(String r100);

    IDownloadAlertDialogBuilder setNegativeButton(int r100, DialogInterface.OnClickListener r101);

    IDownloadAlertDialogBuilder setNegativeButton(CharSequence r100, DialogInterface.OnClickListener r101);

    IDownloadAlertDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener r100);

    IDownloadAlertDialogBuilder setPositiveButton(int r100, DialogInterface.OnClickListener r101);

    IDownloadAlertDialogBuilder setPositiveButton(CharSequence r100, DialogInterface.OnClickListener r101);

    IDownloadAlertDialogBuilder setTitle(int r100);

    IDownloadAlertDialog show();
}
