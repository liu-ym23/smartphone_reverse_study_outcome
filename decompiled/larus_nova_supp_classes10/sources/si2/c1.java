package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2OpenPriceTriggerInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c1 implements am3.c<ECV2OpenPriceTriggerInfo> {
    public c1() {
    }

    public static ECV2OpenPriceTriggerInfo a(am3.g r5) throws Exception {
        ECV2OpenPriceTriggerInfo r0 = new ECV2OpenPriceTriggerInfo();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L12;
        if (r3 != 1) goto L8;
        r0.triggerType = r5.i();
        goto L3
    L8:
        if (r3 != 2) goto L9;
        r0.delayParam = y0.a(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
