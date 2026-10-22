package si2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y1 implements am3.c<v> {
    public y1() {
    }

    public final Object decode(am3.g r6) throws Exception {
        v r0 = new v();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L21;
        if (r3 != 1) goto L8;
        r0.msgType = r6.i();
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.screenshotTimestamp = r6.j();
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.roomTagOfflineInfo = i1.a(r6);
        goto L3
    L12:
        if (r3 != 4) goto L14;
        r0.filterSwitchChangeData = com.bytedance.android.livesdk.livecommerce.model.g.a(r6);
        goto L3
    L14:
        if (r3 != 5) goto L15;
        r0.gmvData = z0.a(r6);
        goto L3
    L15:
        am3.h.e(r6);
        goto L3
    L21:
        r6.d(r1);
        return r0;
    }
}
