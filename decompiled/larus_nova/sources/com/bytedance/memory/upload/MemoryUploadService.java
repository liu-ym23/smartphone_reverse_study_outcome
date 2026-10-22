package com.bytedance.memory.upload;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;

/* JADX INFO: loaded from: classes21.dex */
public class MemoryUploadService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f265503a = 0;

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Thread.sleep(2000);     // Catch: InterruptedException -> L6
    L4:
        super.onDestroy();
        System.exit(0);
        Process.killProcess(Process.myPid());
    }

    public void stopService() {
        stopSelf();
    }

    public MemoryUploadService() {
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        if (r100 != null) goto L6;
        stopSelf(r102);
        return 2;
    L6:
        stopSelf(r102);
        return 2;
    }
}
