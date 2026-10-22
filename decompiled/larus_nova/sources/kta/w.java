package kta;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes34.dex */
public final class w<SERVICE, RESULT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f506156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f506157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<SERVICE, RESULT> f506158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f506159d;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f506160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<SERVICE, RESULT> f506161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SERVICE f506162c;

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            Objects.toString(r100);
            this.f506160a.countDown();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        public a(CountDownLatch r100, b r101) {
            this.f506160a = r100;
            this.f506161b = r101;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            Objects.toString(r100);
            this.f506162c = this.f506161b.b(r101);     // Catch: Throwable -> L8
            this.f506160a.countDown();     // Catch: Exception -> L6
        L24:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L12
            this.f506160a.countDown();     // Catch: Exception -> L6
        L12:
            th = move-exception;
            this.f506160a.countDown();     // Catch: Exception -> L15
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
        a r100 = new a(this.f506156a, this.f506158c);     // Catch: Throwable -> L12
        this.f506159d.bindService(this.f506157b, r100, 1);     // Catch: Throwable -> L12
        this.f506156a.await();     // Catch: Throwable -> L12
        RESULT r101 = this.f506158c.a(r100.f506162c);     // Catch: Throwable -> L10
        this.f506159d.unbindService(r100);     // Catch: Throwable -> L7
    L9:
        return r101;
    L7:
        th = move-exception;
        th.printStackTrace();
    L10:
        Throwable th10 = th;
    L38:
        th10.printStackTrace();     // Catch: Throwable -> L21
        if (r100 != null) goto L32;
    L20:
        return null;
    L32:
        this.f506159d.unbindService(r100);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
    L21:
        th = move-exception;
        if (r100 != null) goto L30;
    L27:
        throw th;
    L30:
        this.f506159d.unbindService(r100);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();
    L12:
        th = move-exception;
        th10 = th;
        r100 = null;
        goto L38
    }

    public w(Context r100, Intent r101, b<SERVICE, RESULT> r102) {
        this.f506159d = r100;
        this.f506157b = r101;
        this.f506158c = r102;
        this.f506156a = new CountDownLatch(1);
    }
}
