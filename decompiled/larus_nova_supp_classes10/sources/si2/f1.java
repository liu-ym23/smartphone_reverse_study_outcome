package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2ProductInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f1 implements am3.c<ECV2ProductInfo> {
    public f1() {
    }

    public final Object decode(am3.g r7) throws Exception {
        ECV2ProductInfo r0 = new ECV2ProductInfo();
        r0.targetFlashUids = new ArrayList();
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L18;
        if (r3 != 1) goto L8;
        r0.promotionId = r7.j();
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.index = r7.i();
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.targetFlashUids.add(Long.valueOf(r7.j()));
        goto L3
    L12:
        if (r3 != 4) goto L13;
        r0.explainType = (int) r7.j();
        goto L3
    L13:
        am3.h.e(r7);
        goto L3
    L18:
        r7.d(r1);
        return r0;
    }
}
