package ww7;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

/* JADX INFO: loaded from: classes23.dex */
public final class u implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f561713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f561714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f561715c;

    public u() {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        this.f561713a = null;
        this.f561714b = null;
        this.f561715c = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        this.f561713a = new Messenger(r101);
        Message r102 = Message.obtain();
        r102.setData(this.f561714b);
        this.f561713a.send(r102);     // Catch: Exception -> L5
    L12:
        this.f561715c.unbindService(this);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L5:
        e = move-exception;
        e.getMessage();
        goto L12
    }
}
