package si2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z1 implements am3.c<x> {
    public z1() {
    }

    public final Object decode(am3.g r6) throws Exception {
        x r0 = new x();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L12;
        if (r3 != 1) goto L8;
        r0.redirectData = g1.a(r6);
        goto L3
    L8:
        if (r3 != 2) goto L9;
        r0.routeRule = am3.h.c(r6);
        goto L3
    L9:
        am3.h.e(r6);
        goto L3
    L12:
        r6.d(r1);
        return r0;
    }
}
