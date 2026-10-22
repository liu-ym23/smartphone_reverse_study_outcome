package kfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f503341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f503342b;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        this.f503342b.unbindService(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public g(Intent r100, Context r101) {
        this.f503341a = r100;
        this.f503342b = r101;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        Messenger r102 = new Messenger(r101);
        Message r103 = new Message();
        r103.what = 101;     // Catch: Throwable -> L8 Exception -> L10
        r103.getData().putParcelable("intent", this.f503341a);     // Catch: Throwable -> L8 Exception -> L10
        r102.send(r103);     // Catch: Throwable -> L8 Exception -> L10
        com.bytedance.push.utils.f.b("RedbadgeServiceConnection", "unbindService");
        Context r104 = this.f503342b;     // Catch: Throwable -> L15
    L6:
        r104.unbindService(this);     // Catch: Throwable -> L15
        return;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        com.bytedance.push.utils.f.b("RedbadgeServiceConnection", "unbindService");
        r104 = this.f503342b;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        th = move-exception;
        com.bytedance.push.utils.f.b("RedbadgeServiceConnection", "unbindService");
        this.f503342b.unbindService(this);     // Catch: Throwable -> L21
    L23:
        throw th;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    }
}
