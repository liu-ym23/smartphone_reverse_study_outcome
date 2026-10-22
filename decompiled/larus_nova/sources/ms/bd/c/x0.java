package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes6.dex */
public final class x0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y0 f515421a;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
    }

    public x0(y0 r100) {
        this.f515421a = r100;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        this.f515421a.f515439b.put(r101);     // Catch: Exception -> L4
        return;
    }
}
