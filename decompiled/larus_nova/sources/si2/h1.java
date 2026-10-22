package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2RedpackActivityInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class h1 implements am3.c<ECV2RedpackActivityInfo> {
    public h1() {
    }

    public static ECV2RedpackActivityInfo a(am3.g r100) throws Exception {
        ECV2RedpackActivityInfo r101 = new ECV2RedpackActivityInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L25;
        switch(r103) {
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
        r101.showType = (int) r100.j();
        goto L3
    L8:
        r101.maxAmount = r100.j();
        goto L3
    L9:
        r101.serverTime = r100.j();
        goto L3
    L10:
        r101.scatterTime = r100.j();
        goto L3
    L11:
        r101.redpackAfterBeltUrl = am3.h.c(r100);
        goto L3
    L12:
        r101.redpackAfterBackgroundUrl = am3.h.c(r100);
        goto L3
    L13:
        r101.redpackLabel = am3.h.c(r100);
        goto L3
    L14:
        r101.redpackFrontBackgroundUrl = am3.h.c(r100);
        goto L3
    L15:
        r101.pendantBackgroundUrl = am3.h.c(r100);
        goto L3
    L16:
        r101.authorName = am3.h.c(r100);
        goto L3
    L17:
        r101.authorAvatarUrl = am3.h.c(r100);
        goto L3
    L18:
        r101.totalAmount = r100.j();
        goto L3
    L19:
        r101.preHeatTime = r100.j();
        goto L3
    L20:
        r101.endApplyTime = r100.j();
        goto L3
    L21:
        r101.startApplyTime = r100.j();
        goto L3
    L22:
        r101.redPacketActivityName = am3.h.c(r100);
        goto L3
    L23:
        r101.redPacketActivityId = am3.h.c(r100);
        goto L3
    L24:
        r101.redPacketType = (int) r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L25:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2RedpackActivityInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
