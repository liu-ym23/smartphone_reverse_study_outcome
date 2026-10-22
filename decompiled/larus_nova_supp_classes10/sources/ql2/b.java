package ql2;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements View.OnTouchListener {
    public final /* synthetic */ d a;

    public b(d r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        int r7 = (int) r6.getX();
        int r0 = (int) r6.getY();
        if (r6.getAction() != 0) goto L13;
        if (r7 < 0) goto L10;
        d r1 = this.a;
        if (r7 >= r1.e) goto L10;
        if (r0 < 0) goto L10;
        if (r0 < r1.f) goto L13;
    L10:
        d r8 = this.a;
        int r9 = r8.e;
        int r10 = r8.f;
        return true;
    L13:
        if (r6.getAction() != 4) goto L16;
        d r11 = this.a;
        int r12 = r11.e;
        int r13 = r11.f;
        return true;
    L16:
        return false;
    }
}
