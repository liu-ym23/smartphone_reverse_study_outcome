package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCampaignInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class l1 implements am3.c<ECV2UpdatedCampaignInfo> {
    public l1() {
    }

    public static ECV2UpdatedCampaignInfo a(am3.g r100) throws Exception {
        ECV2UpdatedCampaignInfo r101 = new ECV2UpdatedCampaignInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        switch(r103) {
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
        r101.campaignId = am3.h.c(r100);
        goto L3
    L8:
        r101.isPreheat = am3.h.c(r100);
        goto L3
    L9:
        r101.userLimit = am3.h.c(r100);
        goto L3
    L10:
        r101.endLabel = am3.h.c(r100);
        goto L3
    L11:
        r101.startLabel = am3.h.c(r100);
        goto L3
    L12:
        r101.endTime = am3.h.c(r100);
        goto L3
    L13:
        r101.startTime = am3.h.c(r100);
        goto L3
    L14:
        r101.f149481pic = am3.h.c(r100);
        goto L3
    L15:
        r101.price = am3.h.c(r100);
        goto L3
    L16:
        r101.label = am3.h.c(r100);
        goto L3
    L17:
        r101.isValid = am3.h.a(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2UpdatedCampaignInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
