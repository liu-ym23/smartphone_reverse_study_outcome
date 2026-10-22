package si2;

/* JADX INFO: loaded from: classes10.dex */
public final class y1 implements am3.c<v> {
    public y1() {
    }

    @Override // am3.c
    public final v decode(am3.g r100) throws Exception {
        v r101 = new v();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L8;
        r101.msgType = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.screenshotTimestamp = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.roomTagOfflineInfo = i1.a(r100);
        goto L3
    L12:
        if (r103 != 4) goto L14;
        r101.filterSwitchChangeData = com.bytedance.android.livesdk.livecommerce.model.g.a(r100);
        goto L3
    L14:
        if (r103 != 5) goto L15;
        r101.gmvData = z0.a(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        return r101;
    }
}
