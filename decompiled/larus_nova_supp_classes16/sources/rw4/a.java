package rw4;

import android.net.Uri;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a {
    void onDismiss();

    void onDownloading(int r1);

    void onExportStart();

    void onFail(int r1, Throwable r2);

    void onPolling(int r1);

    void onStartDownload();

    void onStartPolling();

    void onSuccess(Uri r1);
}
