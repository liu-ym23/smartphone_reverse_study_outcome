package wb4;

import android.content.Context;
import android.view.OrientationEventListener;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f558955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f558956b;

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int r100) {
        int r101 = 0;
        if (r100 < 0) goto L6;
        if (r100 > 45) goto L6;
    L20:
        if (r101 == this.f558955a) goto L29;
        this.f558955a = r101;
        g r102 = this.f558956b.f558958b;
        monitor-enter(r102);
        r102.f558951a = r101;     // Catch: Throwable -> L26
        monitor-exit(r102);
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        return;
    L6:
        if (r100 > 315) goto L20;
        if (r100 <= 45) goto L13;
        if (r100 > 135) goto L13;
        r101 = 90;
    L13:
        if (r100 <= 135) goto L16;
        if (r100 > 225) goto L16;
        r101 = 180;
    L16:
        if (r100 <= 225) goto L20;
        if (r100 > 315) goto L20;
        r101 = 270;
        goto L20
    }

    public h(i r100, Context r101) {
        this.f558956b = r100;
        super(r101);
    }
}
