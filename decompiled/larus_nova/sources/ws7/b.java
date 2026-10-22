package ws7;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f561057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f561058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f561059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HandlerThread f561060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f561061e;

    public interface a {
    }

    public final void a() {
        this.f561059c = true;
        this.f561061e.removeMessages(0);
        this.f561061e.removeCallbacks(null);
        b();
    }

    public final void b() {
        HandlerThread r100 = this.f561060d;
        if (r100 == null) goto L5;
        r100.quit();
    L5:
        monitor-enter(this);
        this.f561058b = null;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        if (this.f561059c == false) goto L5;
        return false;
    L5:
        a r101 = this.f561058b;
        if (r101 == null) goto L8;
        vs7.f.g r102 = (vs7.f.g) r101;
        r102.a(this.f561057a);
    L8:
        int r103 = this.f561057a - 1;
        this.f561057a = r103;
        if (r103 < 0) goto L11;
        this.f561061e.sendEmptyMessageDelayed(0, 1000);
    L18:
        return false;
    L11:
        this.f561059c = true;
        monitor-enter(this);
        a r104 = this.f561058b;     // Catch: Throwable -> L19
        if (r104 == null) goto L16;
        ((vs7.f.g) r104).b();     // Catch: Throwable -> L19
    L16:
        monitor-exit(this);     // Catch: Throwable -> L19
        b();
    L19:
        th = move-exception;
        throw th;
    }

    public b(int r100, vs7.f.g r101) {
        this.f561059c = false;
        this.f561057a = r100;
        this.f561058b = r101;
        HandlerThread r102 = new HandlerThread("CountdownUpdater");
        this.f561060d = r102;
        r102.start();
        Handler r103 = new Handler(r102.getLooper(), this);
        this.f561061e = r103;
        handleMessage(r103.obtainMessage());
    }
}
