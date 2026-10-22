package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCampaignInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l1 implements am3.c<ECV2UpdatedCampaignInfo> {
    public l1() {
    }

    public static ECV2UpdatedCampaignInfo a(am3.g r5) throws Exception {
        ECV2UpdatedCampaignInfo r0 = new ECV2UpdatedCampaignInfo();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L18;
        switch(r3) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        r0.campaignId = am3.h.c(r5);
        goto L3
    L8:
        r0.isPreheat = am3.h.c(r5);
        goto L3
    L9:
        r0.userLimit = am3.h.c(r5);
        goto L3
    L10:
        r0.endLabel = am3.h.c(r5);
        goto L3
    L11:
        r0.startLabel = am3.h.c(r5);
        goto L3
    L12:
        r0.endTime = am3.h.c(r5);
        goto L3
    L13:
        r0.startTime = am3.h.c(r5);
        goto L3
    L14:
        r0.pic = am3.h.c(r5);
        goto L3
    L15:
        r0.price = am3.h.c(r5);
        goto L3
    L16:
        r0.label = am3.h.c(r5);
        goto L3
    L17:
        r0.isValid = am3.h.a(r5);
        goto L3
    L6:
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
