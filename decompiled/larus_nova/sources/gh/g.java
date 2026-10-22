package gh;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements am3.c<b> {
    public g() {
    }

    public static b a(am3.g r100) throws Exception {
        b r101 = new b();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.promotionId = am3.h.c(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final b decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
