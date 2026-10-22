package ms.bd.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f515099a;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
    }

    public a(b r100) {
        this.f515099a = r100;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        this.f515099a.f515105b.put(r101);     // Catch: Exception -> L4
        return;
    }
}
