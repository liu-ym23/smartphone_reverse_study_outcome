package si2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a2 implements am3.c<y> {
    public a2() {
    }

    public final Object decode(am3.g r6) throws Exception {
        y r0 = new y();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.msgType = r6.i();
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.barrageBuyInfo = s0.a(r6);
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.interactionData = com.bytedance.android.livesdk.livecommerce.model.y.a(r6);
        goto L3
    L11:
        am3.h.e(r6);
        goto L3
    L15:
        r6.d(r1);
        return r0;
    }
}
