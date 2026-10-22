package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;

/* JADX INFO: loaded from: classes38.dex */
public interface IAppDownloadDepend {
    boolean getAllowBootReceiver();

    boolean getAllowNetwork(Context r100);

    IDownloadAlertDialogBuilder getThemedAlertDlgBuilder(Context r100);
}
