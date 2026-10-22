package wb4;

import android.content.Context;
import android.view.OrientationEventListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends OrientationEventListener {
    public int a;
    public final /* synthetic */ i b;

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int r5) {
        int r0 = 0;
        if (r5 < 0) goto L6;
        if (r5 > 45) goto L6;
    L20:
        if (r0 == this.a) goto L29;
        this.a = r0;
        g r6 = this.b.b;
        monitor-enter(r6);
        r6.a = r0;     // Catch: Throwable -> L26
        monitor-exit(r6);
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        return;
    L6:
        if (r5 > 315) goto L20;
        if (r5 <= 45) goto L13;
        if (r5 > 135) goto L13;
        r0 = 90;
    L13:
        if (r5 <= 135) goto L16;
        if (r5 > 225) goto L16;
        r0 = 180;
    L16:
        if (r5 <= 225) goto L20;
        if (r5 > 315) goto L20;
        r0 = 270;
        goto L20
    }

    public h(i r1, Context r2) {
        this.b = r1;
        super(r2);
    }
}
