package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2RedpackActivityInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h1 implements am3.c<ECV2RedpackActivityInfo> {
    public h1() {
    }

    public static ECV2RedpackActivityInfo a(am3.g r5) throws Exception {
        ECV2RedpackActivityInfo r0 = new ECV2RedpackActivityInfo();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L25;
        switch(r3) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L8;
            case 18: goto L7;
            default: goto L6;
        };
    L7:
        r0.showType = (int) r5.j();
        goto L3
    L8:
        r0.maxAmount = r5.j();
        goto L3
    L9:
        r0.serverTime = r5.j();
        goto L3
    L10:
        r0.scatterTime = r5.j();
        goto L3
    L11:
        r0.redpackAfterBeltUrl = am3.h.c(r5);
        goto L3
    L12:
        r0.redpackAfterBackgroundUrl = am3.h.c(r5);
        goto L3
    L13:
        r0.redpackLabel = am3.h.c(r5);
        goto L3
    L14:
        r0.redpackFrontBackgroundUrl = am3.h.c(r5);
        goto L3
    L15:
        r0.pendantBackgroundUrl = am3.h.c(r5);
        goto L3
    L16:
        r0.authorName = am3.h.c(r5);
        goto L3
    L17:
        r0.authorAvatarUrl = am3.h.c(r5);
        goto L3
    L18:
        r0.totalAmount = r5.j();
        goto L3
    L19:
        r0.preHeatTime = r5.j();
        goto L3
    L20:
        r0.endApplyTime = r5.j();
        goto L3
    L21:
        r0.startApplyTime = r5.j();
        goto L3
    L22:
        r0.redPacketActivityName = am3.h.c(r5);
        goto L3
    L23:
        r0.redPacketActivityId = am3.h.c(r5);
        goto L3
    L24:
        r0.redPacketType = (int) r5.j();
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L25:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
