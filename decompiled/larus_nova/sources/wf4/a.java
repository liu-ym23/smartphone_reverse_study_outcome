package wf4;

import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f559464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f559465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f559466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f559467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f559468e;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Float.compare(this.f559464a, r101.f559464a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f559465b, r101.f559465b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f559466c, r101.f559466c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f559467d, r101.f559467d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f559468e, r101.f559468e) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((Float.floatToIntBits(this.f559464a) * 31) + Float.floatToIntBits(this.f559465b)) * 31) + Float.floatToIntBits(this.f559466c)) * 31) + Float.floatToIntBits(this.f559467d)) * 31) + Float.floatToIntBits(this.f559468e);
    }

    public final String toString() {
        return "Corners(radius=" + this.f559464a + ", topLeft=" + this.f559465b + ", topRight=" + this.f559466c + ", bottomLeft=" + this.f559467d + ", bottomRight=" + this.f559468e + ")";
    }

    public a(int r100) {
        FloatCompanionObject r101 = FloatCompanionObject.INSTANCE;
        float r102 = r101.getNaN();
        float r103 = r101.getNaN();
        float r104 = r101.getNaN();
        float r105 = r101.getNaN();
        this.f559464a = 0.0f;
        this.f559465b = r102;
        this.f559466c = r103;
        this.f559467d = r104;
        this.f559468e = r105;
    }

    public final float a(float r100) {
        Float r101 = Float.valueOf(r100);
        boolean r102 = false;
        if (r101.floatValue() < 0) goto L5;
        r102 = true;
    L5:
        if (r102 == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        return r101.floatValue();
    L11:
        return this.f559464a;
    }
}
