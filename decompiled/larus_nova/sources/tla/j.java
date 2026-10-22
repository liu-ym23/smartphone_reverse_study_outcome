package tla;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f546709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f546710e;

    public j(String r100) {
        this.f546671a = r100;
        int r101 = r100.indexOf(40);
        int r102 = r100.indexOf(44, r101);
        this.f546709d = CastDoubleProtector.parseDouble(r100.substring(r101 + 1, r102).trim());
        int r103 = r102 + 1;
        this.f546710e = CastDoubleProtector.parseDouble(r100.substring(r103, r100.indexOf(44, r103)).trim());
    }

    @Override // tla.c
    public final double a(double r100) {
        double r101 = this.f546710e;
        if (r100 >= r101) goto L6;
        return (r101 * r100) / (r100 + (this.f546709d * (r101 - r100)));
    L6:
        return ((1.0d - r101) * (r100 - 1.0d)) / ((1.0d - r100) - (this.f546709d * (r101 - r100)));
    }

    @Override // tla.c
    public final double b(double r110) {
        double r100 = this.f546710e;
        if (r110 >= r100) goto L5;
        double r101 = this.f546709d;
        double r102 = (r101 * r100) * r100;
        double r103 = ((r100 - r110) * r101) + r110;
        return r102 / (r103 * r103);
    L5:
        double r104 = this.f546709d;
        double r105 = r100 - 1.0d;
        double r106 = (r105 * r104) * r105;
        double r107 = (((-r104) * (r100 - r110)) - r110) + 1.0d;
        return r106 / (r107 * r107);
    }
}
