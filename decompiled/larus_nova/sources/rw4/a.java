package rw4;

import android.net.Uri;

/* JADX INFO: loaded from: classes16.dex */
public interface a {
    void onDismiss();

    void onDownloading(int r100);

    void onExportStart();

    void onFail(int r100, Throwable r101);

    void onPolling(int r100);

    void onStartDownload();

    void onStartPolling();

    void onSuccess(Uri r100);
}
