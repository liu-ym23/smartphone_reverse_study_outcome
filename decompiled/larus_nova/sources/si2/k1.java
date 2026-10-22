package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2TaskInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class k1 implements am3.c<ECV2TaskInfo> {
    public k1() {
    }

    public static ECV2TaskInfo a(am3.g r100) throws Exception {
        ECV2TaskInfo r101 = new ECV2TaskInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.taskType = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.taskStatus = r100.i();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.reportEvent = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.browseInfo = u0.a(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2TaskInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
