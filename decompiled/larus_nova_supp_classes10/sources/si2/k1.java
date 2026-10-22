package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2TaskInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k1 implements am3.c<ECV2TaskInfo> {
    public k1() {
    }

    public static ECV2TaskInfo a(am3.g r5) throws Exception {
        ECV2TaskInfo r0 = new ECV2TaskInfo();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L18;
        if (r3 != 1) goto L8;
        r0.taskType = r5.i();
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.taskStatus = r5.i();
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.reportEvent = am3.h.c(r5);
        goto L3
    L12:
        if (r3 != 4) goto L13;
        r0.browseInfo = u0.a(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
