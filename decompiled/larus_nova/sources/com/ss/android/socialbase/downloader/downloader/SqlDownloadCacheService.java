package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;

/* JADX INFO: loaded from: classes5.dex */
public class SqlDownloadCacheService extends Service {
    private static final String TAG = null;

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        return 2;
    }

    static {
        TAG = "SqlDownloadCacheService";
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(getApplicationContext());
    }

    public SqlDownloadCacheService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        IDownloadCache r101 = DownloadComponentManager.getDownloadCache();
        if ((r101 instanceof DefaultDownloadCache) == false) goto L6;
        ISqlDownloadCache r102 = ((DefaultDownloadCache) r101).getSqlDownloadCache();
    L10:
        if ((r102 instanceof IBinder) == false) goto L14;
        return (IBinder) r102;
    L14:
        return new Binder();
    L6:
        if ((r101 instanceof ISqlDownloadCache) == false) goto L8;
        r102 = (ISqlDownloadCache) r101;
        goto L10
    L8:
        r102 = null;
        goto L10
    }

    public static void startServiceAndBind(Context r100, ServiceConnection r101) {
        if (r100 == null) goto L13;
        Intent r102 = new Intent(r100, SqlDownloadCacheService.class);     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r100.bindService(r102, r101, 1);     // Catch: Throwable -> L8
    L6:
        r100.startService(r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Logger.globalError(TAG, "startServiceAndBind", "Exception:" + th.toString());
        return;
    }
}
