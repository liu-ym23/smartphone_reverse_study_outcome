package e84;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes8.dex */
public final class u<SERVICE, RESULT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f471345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f471346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<SERVICE, RESULT> f471347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f471348d;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f471349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<SERVICE, RESULT> f471350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SERVICE f471351c;

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName r100) {
        }

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName r100) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            com.bytedance.bdinstall.t.a("Oaid#ServiceBlockBinder#onServiceDisconnected" + r100);
            this.f471349a.countDown();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        public a(CountDownLatch r100, b r101) {
            this.f471349a = r100;
            this.f471350b = r101;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            com.bytedance.bdinstall.t.a("Oaid#ServiceBlockBinder#onServiceConnected " + r100);
            this.f471351c = this.f471350b.b(r101);     // Catch: Throwable -> L8
            this.f471349a.countDown();     // Catch: Exception -> L6
        L24:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L12
            com.bytedance.bdinstall.t.a("Oaid#ServiceBlockBinder#onServiceConnected #Throwable " + th);     // Catch: Throwable -> L12
            this.f471349a.countDown();     // Catch: Exception -> L6
        L12:
            th = move-exception;
            this.f471349a.countDown();     // Catch: Exception -> L15
        L17:
            throw th;
        L15:
            e = move-exception;
            e.printStackTrace();
        L6:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public interface b<T, RESULT> {
        RESULT a(T r100) throws Exception;

        T b(IBinder r100);
    }

    public final RESULT a() {
        a r100 = new a(this.f471345a, this.f471347c);     // Catch: Throwable -> L14
        if (this.f471348d.bindService(this.f471346b, r100, 1) == false) goto L22;
        this.f471345a.await();     // Catch: Throwable -> L14
        RESULT r101 = this.f471347c.a(r100.f471351c);     // Catch: Throwable -> L12
        this.f471348d.unbindService(r100);     // Catch: Throwable -> L9
    L11:
        return r101;
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        Throwable th10 = th;
    L30:
        th10.printStackTrace();     // Catch: Throwable -> L23
        if (r100 == null) goto L22;
        this.f471348d.unbindService(r100);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();
    L23:
        th = move-exception;
        if (r100 != null) goto L34;
    L29:
        throw th;
    L34:
        this.f471348d.unbindService(r100);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
    L22:
        return null;
    L14:
        th = move-exception;
        th10 = th;
        r100 = null;
        goto L30
    }

    public u(Context r100, Intent r101, b<SERVICE, RESULT> r102) {
        this.f471348d = r100;
        this.f471346b = r101;
        this.f471347c = r102;
        this.f471345a = new CountDownLatch(1);
    }
}
