package com.huawei.hms.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ServiceConnection f277660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Messenger f277661b;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f277662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f277663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ r f277664c;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
            HMSLog.i("RemoteService", "remote service onDisconnected");
            r.a(this.f277664c, null);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            HMSLog.i("RemoteService", "remote service onConnected");
            r.a(this.f277664c, new Messenger(r101));
            Message r102 = Message.obtain();
            r102.setData(this.f277662a);
            r.a(this.f277664c).send(r102);     // Catch: RemoteException -> L5
        L6:
            HMSLog.i("RemoteService", "remote service unbindservice");
            this.f277663b.unbindService(r.b(this.f277664c));
            return;
        L5:
            HMSLog.i("RemoteService", "remote service message send failed");
            goto L6
        }

        public a(r r100, Bundle r101, Context r102) {
            this.f277664c = r100;
            this.f277662a = r101;
            this.f277663b = r102;
        }
    }

    public r() {
        this.f277661b = null;
    }

    public static /* synthetic */ Messenger a(r r100) {
        return r100.f277661b;
    }

    public static /* synthetic */ ServiceConnection b(r r100) {
        return r100.f277660a;
    }

    public static /* synthetic */ Messenger a(r r100, Messenger r101) {
        r100.f277661b = r101;
        return r101;
    }

    public boolean a(Context r100, Bundle r101, Intent r102) {
        Context r103 = r100.getApplicationContext();
        this.f277660a = new a(this, r101, r103);
        HMSLog.i("RemoteService", "remote service bind service start");
        return r103.bindService(r102, this.f277660a, 1);
    }
}
