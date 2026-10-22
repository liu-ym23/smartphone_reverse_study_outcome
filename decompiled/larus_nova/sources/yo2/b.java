package yo2;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f568637a;

    public b(d r100) {
        this.f568637a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = (int) r101.getX();
        int r103 = (int) r101.getY();
        if (r101.getAction() != 0) goto L13;
        if (r102 < 0) goto L10;
        d r104 = this.f568637a;
        if (r102 >= r104.f568646h) goto L10;
        if (r103 < 0) goto L10;
        if (r103 < r104.f568647i) goto L13;
    L10:
        d r105 = this.f568637a;
        int r106 = r105.f568646h;
        int r107 = r105.f568647i;
        return true;
    L13:
        if (r101.getAction() != 4) goto L16;
        d r108 = this.f568637a;
        int r109 = r108.f568646h;
        int r110 = r108.f568647i;
        return true;
    L16:
        return false;
    }
}
