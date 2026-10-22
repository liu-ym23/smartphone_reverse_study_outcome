package si2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h2 implements am3.c<d0> {
    public h2() {
    }

    public final Object decode(am3.g r6) throws Exception {
        d0 r0 = new d0();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L12;
        if (r3 != 1) goto L8;
        r0.updateTimeStamp = r6.j();
        goto L3
    L8:
        if (r3 != 2) goto L9;
        r0.updateToast = am3.h.c(r6);
        goto L3
    L9:
        am3.h.e(r6);
        goto L3
    L12:
        r6.d(r1);
        return r0;
    }
}
