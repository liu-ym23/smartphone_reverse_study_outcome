package et3;

import android.view.Choreographer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements Choreographer.FrameCallback {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r9) {
        c r0 = this.a;
        if (r0.k != (-1)) goto L5;
        r0.k = r9;
    L5:
        r0.getClass();
        c r1 = this.a;
        r1.m++;
        if (r1.b == false) goto L8;
        Choreographer.getInstance().postFrameCallback(this);
    L8:
        c r2 = this.a;
        long r3 = r2.l;
        if (r3 <= 0) goto L20;
        long r4 = r9 - r3;
        if ((r4 / 1000000) <= 0) goto L20;
        monitor-enter(r2);
    L22:
        th = move-exception;
        throw th;
    L16:
        if (r2.g.size() <= 20000) goto L18;
        r2.g.poll();     // Catch: Throwable -> L22
    L18:
        r2.g.add(Integer.valueOf(((int) r4) / 10000));     // Catch: Throwable -> L22
        monitor-exit(r2);     // Catch: Throwable -> L22
    L20:
        this.a.l = r9;
    }
}
