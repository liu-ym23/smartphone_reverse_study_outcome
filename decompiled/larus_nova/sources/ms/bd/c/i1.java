package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes6.dex */
public final class i1 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j1 f515163a;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
    }

    public i1(j1 r100) {
        this.f515163a = r100;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        j1 r102 = this.f515163a;
        r102.f515170b = new k1(r101);
    }
}
