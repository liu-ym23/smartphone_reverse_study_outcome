package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes42.dex */
public final class a3 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b3 f515100a;

    public a3(b3 r100) {
        this.f515100a = r100;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        b3 r101 = this.f515100a;
        r101.f515112c = null;
        r101.f515113d.countDown();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        b3 r102 = this.f515100a;
        r102.f515112c = new c3(r101);
        r102.f515113d.countDown();
    }
}
