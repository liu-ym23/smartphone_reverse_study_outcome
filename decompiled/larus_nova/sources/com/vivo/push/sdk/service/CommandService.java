package com.vivo.push.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.vivo.push.sdk.a;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
public class CommandService extends Service {
    @Override // android.app.Service
    public void onCreate() {
        t.c("CommandService", getClass().getSimpleName() + " -- oncreate " + getPackageName());
        super.onCreate();
        a.a().a(ContextDelegate.getContext(getApplicationContext()));
    }

    public CommandService() {
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean a(String r100) {
        return "com.vivo.pushservice.action.RECEIVE".equals(r100);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        t.c("CommandService", "onBind initSuc: ");
        return null;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r100) {
        return super.onUnbind(r100);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        t.c("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName());
        if (r100 != null) goto L7;
        stopSelf();
        return 2;
    L7:
        if (a(r100.getAction()) == true) goto L16;
        t.a("CommandService", getPackageName() + " receive invalid action " + r100.getAction());
        stopSelf();
        return 2;
    L16:
        a.a().a(getClass().getName());     // Catch: Exception -> L12
        a.a().a(r100);     // Catch: Exception -> L12
    L14:
        stopSelf();
        return 2;
    L12:
        e = move-exception;
        t.a("CommandService", "onStartCommand -- error", e);
        goto L14
    }
}
