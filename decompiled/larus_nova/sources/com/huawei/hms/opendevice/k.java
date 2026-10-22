package com.huawei.hms.opendevice;

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
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ServiceConnection f277539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Messenger f277540b;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f277541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f277542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f277543c;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
            HMSLog.i("RemoteService", "remote service onDisconnected");
            k.a(this.f277543c, null);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            HMSLog.i("RemoteService", "remote service onConnected");
            k.a(this.f277543c, new Messenger(r101));
            Message r102 = Message.obtain();
            r102.setData(this.f277541a);
            k.a(this.f277543c).send(r102);     // Catch: RemoteException -> L5
        L6:
            HMSLog.i("RemoteService", "remote service unbindservice");
            this.f277542b.unbindService(k.b(this.f277543c));
            return;
        L5:
            HMSLog.i("RemoteService", "remote service message send failed");
            goto L6
        }

        public a(k r100, Bundle r101, Context r102) {
            this.f277543c = r100;
            this.f277541a = r101;
            this.f277542b = r102;
        }
    }

    public k() {
        this.f277540b = null;
    }

    public static /* synthetic */ Messenger a(k r100) {
        return r100.f277540b;
    }

    public static /* synthetic */ ServiceConnection b(k r100) {
        return r100.f277539a;
    }

    public static /* synthetic */ Messenger a(k r100, Messenger r101) {
        r100.f277540b = r101;
        return r101;
    }

    public boolean a(Context r100, Bundle r101, Intent r102) {
        Context r103 = r100.getApplicationContext();
        this.f277539a = new a(this, r101, r103);
        HMSLog.i("RemoteService", "remote service bind service start");
        return r103.bindService(r102, this.f277539a, 1);
    }
}
