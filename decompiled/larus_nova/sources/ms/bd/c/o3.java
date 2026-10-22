package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes42.dex */
public final class o3 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p3 f515274a;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
    }

    public o3(p3 r100) {
        this.f515274a = r100;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        this.f515274a.f515289b.put(r101);     // Catch: Exception -> L4
        return;
    }
}
