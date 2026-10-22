package yk5;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f568177a;

    public k(g r100) {
        this.f568177a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.getAction() != 1) goto L8;
        PointF r102 = this.f568177a.f568167x;
        r102.x = r101.getX();
        PointF r103 = this.f568177a.f568167x;
        r103.y = r101.getY();
    L8:
        return false;
    }
}
