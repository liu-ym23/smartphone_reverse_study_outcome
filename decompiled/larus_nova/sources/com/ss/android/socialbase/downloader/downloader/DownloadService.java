package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadService extends Service {
    private static final String TAG = null;
    protected IDownloadServiceHandler downloadServiceHandler;

    static {
        TAG = "DownloadService";
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
        IDownloadServiceHandler r100 = DownloadComponentManager.getDownloadServiceHandler();
        this.downloadServiceHandler = r100;
        r100.setDownloadService(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, LiveCommonConstants.REASON_ON_DEDTROY, "Run");
    L5:
        IDownloadServiceHandler r100 = this.downloadServiceHandler;
        if (r100 == null) goto L8;
        r100.onDestroy();
        this.downloadServiceHandler = null;
    L8:
        super.onDestroy();
    }

    public DownloadService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        if (Logger.debug() == false) goto L9;
        String r101 = TAG;
        StringBuilder r102 = new StringBuilder("DownloadServiceHandler != null:");
        if (this.downloadServiceHandler == null) goto L7;
        boolean r103 = true;
    L8:
        r102.append(r103);
        Logger.globalDebug(r101, "onBind", r102.toString());
        goto L9
    L7:
        r103 = false;
    L9:
        IDownloadServiceHandler r104 = this.downloadServiceHandler;
        if (r104 != null) goto L12;
        return null;
    L12:
        return r104.onBind(r100);
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent r100, final int r101, final int r102) {
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "onStartCommand", "Run");
    L16:
        IDownloadServiceHandler r103 = this.downloadServiceHandler;     // Catch: Throwable -> L9
        if (r103 == null) goto L11;
        r103.onStartCommandOnMainThread();     // Catch: Throwable -> L9
    L11:
        ExecutorService r104 = DownloadComponentManager.getCPUThreadExecutor();
        if (r104 == null) goto L18;
        r104.execute(new AnonymousClass1(this, r100, r101, r102));
        return 2;
    L18:
        return 2;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }
}
