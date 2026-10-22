package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2BrowseInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u0 implements am3.c<ECV2BrowseInfo> {
    public u0() {
    }

    public static ECV2BrowseInfo a(am3.g r5) throws Exception {
        ECV2BrowseInfo r0 = new ECV2BrowseInfo();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.duration = Integer.valueOf(r5.i());
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.taskIndex = am3.h.c(r5);
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.stopDuration = Integer.valueOf(r5.i());
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
