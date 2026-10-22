package lja;

import android.graphics.Path;

/* JADX INFO: loaded from: classes33.dex */
public final class g extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f509529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f509530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f509531e;

    public /* synthetic */ g() {
        this(0.375f);
    }

    @Override // lja.d
    public String getType() {
        return this.f509530d;
    }

    public g(float r100) {
        this.f509531e = r100;
        this.f509529c = 1.175f;
        this.f509530d = "QuadraticSmoothCornerImpl";
    }

    @Override // lja.d
    public final boolean c(float r100, float r101) {
        if (r100 >= (this.f509531e * r101)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // lja.d
    public final Path a(float r100, float r101, float r102, float r103, float r104) {
        float r105 = Math.min(r102 - r100, r103 - r101);
        if (r104 == 0.0f) goto L10;
        if (r104 >= (this.f509531e * r105)) goto L10;
        float r106 = Math.min(r105 / 2.0f, r104 * this.f509529c);
        float r107 = r101 + r106;
        float r108 = r103 - r106;
        float r109 = r102 - r106;
        float r110 = r106 + r100;
        Path r111 = new Path();
        r111.moveTo(r102, r107);
        r111.lineTo(r102, r108);
        r111.quadTo(r102, r103, r109, r103);
        r111.lineTo(r110, r103);
        r111.quadTo(r100, r103, r100, r108);
        r111.lineTo(r100, r107);
        r111.quadTo(r100, r101, r110, r101);
        r111.lineTo(r109, r101);
        r111.quadTo(r102, r101, r102, r107);
        r111.close();
        return r111;
    L10:
        return d.b(r100, r101, r102, r103, r104);
    }
}
