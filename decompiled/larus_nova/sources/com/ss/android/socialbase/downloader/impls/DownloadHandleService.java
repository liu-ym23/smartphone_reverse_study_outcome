package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.logger.Logger;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadHandleService extends Service {
    private static final String TAG = "DownloadHandleService";

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    public DownloadHandleService() {
    }

    private void handleIntent(Intent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getAction();
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        int r102 = r100.getIntExtra("extra_download_id", 0);
        if (r102 != 0) goto L11;
        return;
    L11:
        if (r101.equals(DownloadConstants.ACTION_RETRY) == false) goto L16;
        if (Logger.debug() == false) goto L22;
        Logger.taskError(TAG, r102, "handleIntent", "Retry delay disable");
        return;
    L22:
        return;
    L16:
        if (r101.equals(DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY) == false) goto L19;
        DownloadProcessDispatcher.getInstance().recordTaskProcessIndependent(r102);
        return;
    L19:
        if (r101.equals(DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY) == false) goto L25;
        DownloadComponentManager.setDownloadInMultiProcess();
        return;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        super.onStartCommand(r100, r101, r102);
        handleIntent(r100);
        return 2;
    }
}
