package es3;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends n {
    public final /* synthetic */ h b;

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r4) {
        h r0 = this.b;
        if (r0.h == true) goto L6;
        r0.b.a(r4.getEventTime());
    L6:
        return this.a.dispatchKeyEvent(r4);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        h r0 = this.b;
        if (r0.h == true) goto L6;
        r0.b.a(r4.getEventTime());
    L6:
        return this.a.dispatchTouchEvent(r4);
    }

    public k(h r1, Window.Callback r2) {
        this.b = r1;
        super(r2);
    }
}
