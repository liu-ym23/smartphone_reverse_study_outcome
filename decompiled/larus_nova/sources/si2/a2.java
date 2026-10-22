package si2;

/* JADX INFO: loaded from: classes10.dex */
public final class a2 implements am3.c<y> {
    public a2() {
    }

    @Override // am3.c
    public final y decode(am3.g r100) throws Exception {
        y r101 = new y();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.msgType = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.barrageBuyInfo = s0.a(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.interactionData = com.bytedance.android.livesdk.livecommerce.model.y.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }
}
