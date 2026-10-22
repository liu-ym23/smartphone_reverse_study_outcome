package com.bytedance.bdp.bdpbase.ipc.extention;

import aa4.a;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdp.bdpbase.ipc.d;
import g94.b;

/* JADX INFO: loaded from: classes11.dex */
public class MainDefaultIpcService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f201166a;

    @Override // android.app.Service
    public final void onDestroy() {
        this.f201166a = null;
        b.d("MainDefaultIpcService", new Object[]{"#onDestroy (unRegisterToBinder)"});
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        b.d("MainDefaultIpcService", new Object[]{"#onCreate"});
        this.f201166a = a.C0037a.f2343a.f2342b;
    }

    public MainDefaultIpcService() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        b.d("MainDefaultIpcService", new Object[]{"#onBind (registerToBinder)"});
        return this.f201166a;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent r100) {
        b.d("MainDefaultIpcService", new Object[]{"#onUnbind intent=" + r100});
        return super.onUnbind(r100);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        super.onStartCommand(r100, r101, r102);
        b.d("MainDefaultIpcService", new Object[]{"#onStartCommand intent=" + r100 + " flags=" + r101 + " startId=" + r102});
        return 2;
    }
}
