package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2BrowseInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class u0 implements am3.c<ECV2BrowseInfo> {
    public u0() {
    }

    public static ECV2BrowseInfo a(am3.g r100) throws Exception {
        ECV2BrowseInfo r101 = new ECV2BrowseInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.duration = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.taskIndex = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.stopDuration = Integer.valueOf(r100.i());
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2BrowseInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
