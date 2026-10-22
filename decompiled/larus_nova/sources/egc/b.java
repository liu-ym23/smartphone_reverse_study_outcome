package egc;

import android.graphics.Matrix;
import android.graphics.Path;
import dgc.d;

/* JADX INFO: loaded from: classes38.dex */
public class b extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f472630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Path f472631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Matrix f472632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f472633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f472634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f472635p;

    public b(int r100) {
        this.f472630k = new Path();
        this.f472631l = new Path();
        this.f472632m = new Matrix();
        this.f472633n = new float[2];
        this.f472635p = -1;
        this.f472635p = r100;
    }

    public final void c(float r100, float r101) {
        this.f472630k.reset();
        this.f472631l.reset();
        float[] r102 = this.f472633n;
        d r103 = this.f472634o;
        r102[0] = r103.f468557a;
        r102[1] = r103.f468558b;
        this.f472632m.reset();
        float[] r104 = this.f472633n;
        float r105 = Math.min(r100 / r104[0], r101 / r104[1]);
        float r106 = Math.round((r100 - (this.f472633n[0] * r105)) * 0.5f);
        float r107 = Math.round((r101 - (this.f472633n[1] * r105)) * 0.5f);
        this.f472632m.setScale(r105, r105);
        this.f472632m.postTranslate(r106, r107);
        d r108 = this.f472634o;
        r108.f468559c.transform(this.f472632m, this.f472630k);
        Path r109 = this.f472630k;
        float r110 = this.f472622c;
        r109.offset(r110, r110);
        if (this.f472622c <= 0) goto L5;
        this.f472632m.reset();
        int r111 = this.f472620a;
        int r112 = this.f472622c;
        float r113 = r111 - r112;
        float r114 = this.f472621b - r112;
        float r115 = r112 / 2.0f;
        float[] r116 = this.f472633n;
        float r117 = Math.min(r113 / r116[0], r114 / r116[1]);
        float r118 = Math.round(((r113 - (this.f472633n[0] * r117)) * 0.5f) + r115);
        float r119 = Math.round(((r114 - (this.f472633n[1] * r117)) * 0.5f) + r115);
        this.f472632m.setScale(r117, r117);
        this.f472632m.postTranslate(r118, r119);
        d r120 = this.f472634o;
        r120.f468559c.transform(this.f472632m, this.f472631l);
    L5:
        this.f472632m.reset();
        this.f472629j.invert(this.f472632m);
        this.f472630k.transform(this.f472632m);
    }
}
