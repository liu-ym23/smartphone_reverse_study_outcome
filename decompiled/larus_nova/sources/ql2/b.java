package ql2;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f533723a;

    public b(d r100) {
        this.f533723a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = (int) r101.getX();
        int r103 = (int) r101.getY();
        if (r101.getAction() != 0) goto L13;
        if (r102 < 0) goto L10;
        d r104 = this.f533723a;
        if (r102 >= r104.f533729e) goto L10;
        if (r103 < 0) goto L10;
        if (r103 < r104.f533730f) goto L13;
    L10:
        d r105 = this.f533723a;
        int r106 = r105.f533729e;
        int r107 = r105.f533730f;
        return true;
    L13:
        if (r101.getAction() != 4) goto L16;
        d r108 = this.f533723a;
        int r109 = r108.f533729e;
        int r110 = r108.f533730f;
        return true;
    L16:
        return false;
    }
}
