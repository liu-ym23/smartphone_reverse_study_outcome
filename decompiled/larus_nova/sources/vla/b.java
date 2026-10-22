package vla;

import com.obric.oui.constraintlayout.motion.widget.o;
import tla.l;
import tla.n;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tla.o f555709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f555710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f555711c;

    @Override // com.obric.oui.constraintlayout.motion.widget.o
    public final float a() {
        return this.f555711c.b();
    }

    public b() {
        tla.o r100 = new tla.o();
        this.f555709a = r100;
        this.f555711c = r100;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        return this.f555711c.getInterpolation(r100);
    }

    public final void b(float r100, float r101, float r102, float r110, float r111, float r112) {
        tla.o r103 = this.f555709a;
        this.f555711c = r103;
        r103.f546737l = r100;
        if (r100 <= r101) goto L5;
        boolean r104 = true;
    L6:
        r103.f546736k = r104;
        if (r104 == false) goto L9;
        r103.d(-r102, r100 - r101, r111, r112, r110);
        return;
    L9:
        r103.d(r102, r101 - r100, r111, r112, r110);
        return;
    L5:
        r104 = false;
        goto L6
    }
}
