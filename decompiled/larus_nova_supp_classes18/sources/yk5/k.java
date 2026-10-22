package yk5;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements View.OnTouchListener {
    public final /* synthetic */ g a;

    public k(g r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getAction() != 1) goto L8;
        PointF r0 = this.a.x;
        r0.x = r4.getX();
        PointF r1 = this.a.x;
        r1.y = r4.getY();
    L8:
        return false;
    }
}
