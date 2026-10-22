package si2;

/* JADX INFO: loaded from: classes10.dex */
public final class z1 implements am3.c<x> {
    public z1() {
    }

    @Override // am3.c
    public final x decode(am3.g r100) throws Exception {
        x r101 = new x();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.redirectData = g1.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.routeRule = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }
}
