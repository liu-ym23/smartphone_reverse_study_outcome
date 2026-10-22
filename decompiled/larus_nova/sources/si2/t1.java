package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2WinLotteryInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class t1 implements am3.c<ECV2WinLotteryInfo> {
    public t1() {
    }

    public static ECV2WinLotteryInfo a(am3.g r100) throws Exception {
        ECV2WinLotteryInfo r101 = new ECV2WinLotteryInfo();
        r101.activityPrice = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L31;
        if (r103 != 17) goto L8;
        r101.drawPrizeType = (int) r100.j();
        goto L3
    L8:
        if (r103 != 18) goto L10;
        r101.buttonBottomDesc = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 99) goto L11;
        r101.extraInfo = am3.h.c(r100);
        goto L3
    L11:
        switch(r103) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L14;
            case 15: goto L13;
            default: goto L12;
        };
    L13:
        r101.productIdStr = am3.h.c(r100);
        goto L3
    L14:
        r101.lotteryType = (int) r100.j();
        goto L3
    L15:
        r101.buyTime = r100.j();
        goto L3
    L16:
        r101.activityPrice.add(Long.valueOf(r100.j()));
        goto L3
    L17:
        r101.productId = r100.j();
        goto L3
    L18:
        r101.jumpUrl = am3.h.c(r100);
        goto L3
    L19:
        r101.isWin = am3.h.a(r100);
        goto L3
    L20:
        r101.alert = s1.a(r100);
        goto L3
    L21:
        r101.isAddressed = am3.h.a(r100);
        goto L3
    L22:
        r101.activityId = am3.h.c(r100);
        goto L3
    L23:
        r101.winRecordId = am3.h.c(r100);
        goto L3
    L24:
        r101.buttonLabel = am3.h.c(r100);
        goto L3
    L25:
        r101.img = am3.h.c(r100);
        goto L3
    L26:
        r101.name = am3.h.c(r100);
        goto L3
    L27:
        r101.title = am3.h.c(r100);
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L31:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2WinLotteryInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
