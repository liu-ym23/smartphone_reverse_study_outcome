package k56;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f501846a;

    public a(b r100) {
        this.f501846a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 != 0) goto L5;
        b r103 = this.f501846a;
        r103.f501865s = r101.getY();
        b r104 = this.f501846a;
        r104.getClass();
        b.a(r104, 1.0f, 0.98f);
        return false;
    L5:
        if (r102 != 1) goto L7;
        b r105 = this.f501846a;
        r105.getClass();
        b.a(r105, 0.98f, 1.0f);
        b r106 = this.f501846a;
        if (r106.f501860n == false) goto L25;
        float r107 = r106.f501866t - r106.f501865s;
        if (r107 < 0.0f) goto L18;
        return false;
    L18:
        if (Math.abs(r107) <= 20.0f) goto L27;
        c.b().c(this.f501846a);
        return false;
    L27:
        return false;
    L25:
        return false;
    L7:
        if (r102 != 2) goto L9;
        b r108 = this.f501846a;
        r108.f501866t = r101.getY();
        return false;
    L9:
        if (r102 != 3) goto L29;
        b r109 = this.f501846a;
        r109.getClass();
        b.a(r109, 0.98f, 1.0f);
        return false;
    L29:
        return false;
    }
}
