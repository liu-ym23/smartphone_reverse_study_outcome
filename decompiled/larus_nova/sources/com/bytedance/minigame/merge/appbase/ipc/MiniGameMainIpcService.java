package com.bytedance.minigame.merge.appbase.ipc;

import a27.a;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdp.bdpbase.ipc.d;
import com.bytedance.bdp.bdpbase.ipc.r;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public class MiniGameMainIpcService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f265552a;

    @Override // android.app.Service
    public final void onDestroy() {
        this.f265552a = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f265552a = d.a.a();
    }

    public MiniGameMainIpcService() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        a r101 = a.C0005a.f1420a;
        d r102 = this.f265552a;
        monitor-enter(r101);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (((ConcurrentHashMap) r101.f1419a).isEmpty() == true) goto L15;
        if (r102 == null) goto L15;
        Iterator r103 = ((ConcurrentHashMap) r101.f1419a).values().iterator();     // Catch: Throwable -> L18
    L10:
        if (r103.hasNext() == false) goto L13;
        r102.registerObject((r) r103.next());     // Catch: Throwable -> L18
        goto L10
    L13:
        monitor-exit(r101);
    L17:
        return this.f265552a;
    L15:
        monitor-exit(r101);
        goto L17
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent r100) {
        return super.onUnbind(r100);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        super.onStartCommand(r100, r101, r102);
        return 2;
    }
}
