package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2PopMsgProductInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d1 implements am3.c<ECV2PopMsgProductInfo> {
    public d1() {
    }

    public static ECV2PopMsgProductInfo a(am3.g r5) throws Exception {
        ECV2PopMsgProductInfo r0 = new ECV2PopMsgProductInfo();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.promotionId = r5.j();
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.productId = r5.j();
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.explainTime = r5.j();
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
