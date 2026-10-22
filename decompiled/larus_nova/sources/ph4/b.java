package ph4;

import oh4.d;
import zg4.i;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f529264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f529265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f529266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f529267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f529268l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f529269m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f529270n;

    @Override // oh4.d
    public final String toString() {
        return "fdTrackEnable=" + this.f529264h + "\nwaterLine=" + this.f529267k + "\ndumpLine=" + this.f529268l + "\nloopMonitorEnable=" + this.f529265i + "\nmSleepTime=" + this.f529270n + "\nmBacktraceLimit=" + this.f529269m + "\ndebug=" + this.f529266j + "\n";
    }

    public b(boolean r100, int r101, int r102, long r103, int r110) {
        super(21, 35, 2);
        this.f529264h = false;
        this.f529265i = false;
        this.f529266j = false;
        this.f529267k = 500;
        this.f529268l = 1000;
        this.f529269m = 10;
        this.f529270n = 60000;
        if (i.b() == false) goto L5;
        this.f529264h = true;
        this.f529265i = true;
        this.f529267k = 200;
        this.f529268l = 400;
        this.f529270n = 1000;
        this.f529269m = 10;
        this.f529266j = true;
        return;
    L5:
        this.f529264h = true;
        this.f529265i = r100;
        this.f529267k = r101;
        this.f529268l = r102;
        this.f529270n = Math.max(1000, r103);
        this.f529269m = r110;
    }
}
