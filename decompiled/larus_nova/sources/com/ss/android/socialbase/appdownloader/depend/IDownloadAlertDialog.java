package com.ss.android.socialbase.appdownloader.depend;

import android.widget.Button;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadAlertDialog {
    void dismiss();

    Button getButton(int r100);

    boolean isShowing();

    void show();
}
