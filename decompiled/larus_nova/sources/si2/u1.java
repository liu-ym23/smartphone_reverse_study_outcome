package si2;

import com.bytedance.android.livesdk.livecommerce.model.EndTimeRefreshInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class u1 implements am3.c<EndTimeRefreshInfo> {
    public u1() {
    }

    public static EndTimeRefreshInfo a(am3.g r100) throws Exception {
        EndTimeRefreshInfo r101 = new EndTimeRefreshInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.endTime = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.toast = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final EndTimeRefreshInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
