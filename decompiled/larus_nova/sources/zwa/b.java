package zwa;

import android.os.SystemClock;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.log.Log;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends wwa.a implements Observer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f573858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f573859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f573860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f573861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f573862f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f573863a = null;

        static {
            f573863a = new b();
        }
    }

    public final boolean d() {
        monitor-enter(this);
        int r100 = this.f573859c;     // Catch: Throwable -> L12
        if (r100 != 0) goto L6;
    L9:
        boolean r101 = true;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return r101;
    L6:
        if (r100 == 3) goto L9;
        r101 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f573858b = 5000;
        this.f573859c = 3;
        this.f573860d = 0;
        this.f573861e = new AtomicBoolean(false);
        this.f573862f = 1;
    }

    @Override // wwa.a
    public final void b() {
        if (com.ss.android.lark.appcontext.applifecycle2.api.a.b() == false) goto L5;
        this.f573859c = 0;
        this.f573861e.set(true);
        Log.i("BatteryMonitor", "AppLifecycle2 app front now!");
    L5:
        com.ss.android.lark.appcontext.applifecycle2.api.a.c(new zwa.a(this));
        e(!AppLifecycle.a.f408803a.h() ? 1 : 0);
    }

    public final void e(int r100) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (r100 != this.f573859c) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L8:
        this.f573859c = r100;     // Catch: Throwable -> L23
        if (r100 != 0) goto L14;
        this.f573860d = 0;     // Catch: Throwable -> L23
        Log.d("BatteryMonitor", "updateAppState: set mBgStartTime is 0");     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L14:
        if (r100 != 1) goto L19;
        this.f573860d = SystemClock.elapsedRealtime();     // Catch: Throwable -> L23
        Log.d("BatteryMonitor", "updateAppState: set mBgStartTime is " + this.f573860d);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L19:
        if (r100 != 2) goto L21;
        this.f573860d = SystemClock.elapsedRealtime() - this.f573858b;     // Catch: Throwable -> L23
        Log.d("BatteryMonitor", "updateAppState: set mBgStartTime is " + this.f573860d);     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);     // Catch: Throwable -> L23
    }

    @Override // java.util.Observer
    public void update(Observable r100, Object r101) {
        Log.i("BatteryMonitor", b.class.getSimpleName().concat(" update called. current process already background start."));
        if (this.f573861e.get() == false) goto L6;
        Log.i("BatteryMonitor", b.class.getSimpleName().concat(" app have front, so cannel set app back start state"));
        return;
    L6:
        e(this.f573862f);
        c();
    }
}
