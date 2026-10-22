package si2;

import com.bytedance.android.livesdk.livecommerce.model.DigitalAtmosphere;

/* JADX INFO: loaded from: classes10.dex */
public final class p0 implements am3.c<DigitalAtmosphere> {
    public p0() {
    }

    public static DigitalAtmosphere a(am3.g r100) throws Exception {
        DigitalAtmosphere r101 = new DigitalAtmosphere();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.frequencyKey = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.frequencyCount = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.data = g0.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final DigitalAtmosphere decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
