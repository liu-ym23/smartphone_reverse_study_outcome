package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2WinLotteryInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t1 implements am3.c<ECV2WinLotteryInfo> {
    public t1() {
    }

    public static ECV2WinLotteryInfo a(am3.g r6) throws Exception {
        ECV2WinLotteryInfo r0 = new ECV2WinLotteryInfo();
        r0.activityPrice = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L31;
        if (r3 != 17) goto L8;
        r0.drawPrizeType = (int) r6.j();
        goto L3
    L8:
        if (r3 != 18) goto L10;
        r0.buttonBottomDesc = am3.h.c(r6);
        goto L3
    L10:
        if (r3 != 99) goto L11;
        r0.extraInfo = am3.h.c(r6);
        goto L3
    L11:
        switch(r3) {
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
        r0.productIdStr = am3.h.c(r6);
        goto L3
    L14:
        r0.lotteryType = (int) r6.j();
        goto L3
    L15:
        r0.buyTime = r6.j();
        goto L3
    L16:
        r0.activityPrice.add(Long.valueOf(r6.j()));
        goto L3
    L17:
        r0.productId = r6.j();
        goto L3
    L18:
        r0.jumpUrl = am3.h.c(r6);
        goto L3
    L19:
        r0.isWin = am3.h.a(r6);
        goto L3
    L20:
        r0.alert = s1.a(r6);
        goto L3
    L21:
        r0.isAddressed = am3.h.a(r6);
        goto L3
    L22:
        r0.activityId = am3.h.c(r6);
        goto L3
    L23:
        r0.winRecordId = am3.h.c(r6);
        goto L3
    L24:
        r0.buttonLabel = am3.h.c(r6);
        goto L3
    L25:
        r0.img = am3.h.c(r6);
        goto L3
    L26:
        r0.name = am3.h.c(r6);
        goto L3
    L27:
        r0.title = am3.h.c(r6);
        goto L3
    L12:
        am3.h.e(r6);
        goto L3
    L31:
        r6.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
