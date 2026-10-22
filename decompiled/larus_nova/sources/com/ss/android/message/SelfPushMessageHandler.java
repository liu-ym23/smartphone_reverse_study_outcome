package com.ss.android.message;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import rgc.b;
import zfc.a;

/* JADX INFO: loaded from: classes38.dex */
public class SelfPushMessageHandler extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return null;
    }

    public SelfPushMessageHandler() {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        int r103 = super.onStartCommand(r100, r101, r102);
        if (((a.b) b.a(a.b.class)).f() == false) goto L6;
        return 2;
    L6:
        return r103;
    }
}
