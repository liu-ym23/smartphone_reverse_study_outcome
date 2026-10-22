package et3;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f473904a;

    public d(c r100) {
        this.f473904a = r100;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        c r101 = this.f473904a;
        if (r101.f473900k != (-1)) goto L5;
        r101.f473900k = r100;
    L5:
        r101.getClass();
        c r102 = this.f473904a;
        r102.f473902m++;
        if (r102.f473891b == false) goto L8;
        Choreographer.getInstance().postFrameCallback(this);
    L8:
        c r103 = this.f473904a;
        long r104 = r103.f473901l;
        if (r104 <= 0) goto L20;
        long r105 = r100 - r104;
        if ((r105 / 1000000) <= 0) goto L20;
        monitor-enter(r103);
    L22:
        th = move-exception;
        throw th;
    L16:
        if (r103.f473896g.size() <= 20000) goto L18;
        r103.f473896g.poll();     // Catch: Throwable -> L22
    L18:
        r103.f473896g.add(Integer.valueOf(((int) r105) / 10000));     // Catch: Throwable -> L22
        monitor-exit(r103);     // Catch: Throwable -> L22
    L20:
        this.f473904a.f473901l = r100;
    }
}
