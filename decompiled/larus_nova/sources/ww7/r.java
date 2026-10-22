package ww7;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes23.dex */
public final class r implements ServiceConnection {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f561696d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f561697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f561698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f561699c;

    static {
        f561696d = new Object();
    }

    public final void b() {
        c0.f561643e.a().unbindService(this);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.getMessage();
    }

    public r(xw7.a r100) {
        this.f561698b = null;
        this.f561699c = false;
    }

    public final void a(int r100) {
        j r101 = this.f561697a;
        if (r101 == null) goto L10;
        AtomicInteger r102 = r101.f561666a.f561673a;
        if (r100 != HonorPushErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode) goto L7;
        int r103 = 2;
    L8:
        r102.set(r103);
        r101.f561666a.a(r100);
        r101.f561666a.f561674b = null;
        return;
    L7:
        r103 = 1;
        goto L8
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r100) {
        if (this.f561699c == false) goto L6;
        this.f561699c = false;
        return;
    L6:
        b();
        Object r101 = f561696d;
        monitor-enter(r101);
        Handler r102 = this.f561698b;     // Catch: Throwable -> L16
        if (r102 == null) goto L11;
        r102.removeMessages(1001);     // Catch: Throwable -> L16
        this.f561698b = null;     // Catch: Throwable -> L16
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L16
        j r103 = this.f561697a;
        if (r103 == null) goto L21;
        r103.f561666a.f561673a.set(1);
        r103.f561666a.a(8002005);
        r103.f561666a.f561674b = null;
        return;
    L21:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        j r101 = this.f561697a;
        if (r101 == null) goto L6;
        r101.f561666a.f561673a.set(1);
        r101.f561666a.a(8002002);
        r101.f561666a.f561674b = null;
        return;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        Object r102 = f561696d;
        monitor-enter(r102);
        Handler r103 = this.f561698b;     // Catch: Throwable -> L20
        if (r103 == null) goto L7;
        r103.removeMessages(1001);     // Catch: Throwable -> L20
        this.f561698b = null;     // Catch: Throwable -> L20
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L20
        j r104 = this.f561697a;
        if (r104 == null) goto L25;
        l r105 = r104.f561666a;
        r105.f561674b = IPushInvoke.Stub.asInterface(r101);
        if (r104.f561666a.f561674b != null) goto L13;
        r104.f561666a.f561676d.b();
        r104.f561666a.f561673a.set(1);
        r104.f561666a.a(8002001);
        return;
    L13:
        r104.f561666a.f561673a.set(3);
        g r106 = r104.f561666a.f561675c;
        if (r106 == null) goto L27;
        y0.a r107 = (y0.a) r106;
        if (Looper.myLooper() != r107.f561733f.f561726a.getLooper()) goto L18;
        r107.d();
        return;
    L18:
        r107.f561733f.f561726a.post(new v0(r107));
        return;
    L27:
        return;
    L25:
        return;
    L20:
        th = move-exception;
        throw th;
    }
}
