package es3;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;

/* JADX INFO: loaded from: classes14.dex */
public final class k extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f473755b;

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        h r101 = this.f473755b;
        if (r101.f473725h == true) goto L6;
        r101.f473719b.a(r100.getEventTime());
    L6:
        return this.f473767a.dispatchKeyEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        h r101 = this.f473755b;
        if (r101.f473725h == true) goto L6;
        r101.f473719b.a(r100.getEventTime());
    L6:
        return this.f473767a.dispatchTouchEvent(r100);
    }

    public k(h r100, Window.Callback r101) {
        this.f473755b = r100;
        super(r101);
    }
}
