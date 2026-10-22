package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2LotteryInfoList;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b1 implements am3.c<ECV2LotteryInfoList> {
    public b1() {
    }

    public static ECV2LotteryInfoList a(am3.g r5) throws Exception {
        ECV2LotteryInfoList r0 = new ECV2LotteryInfoList();
        r0.text = new ArrayList();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L21;
        if (r3 != 99) goto L7;
        r0.extraInfo = am3.h.c(r5);
        goto L3
    L7:
        switch(r3) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            default: goto L8;
        };
    L9:
        r0.elasticTitle = am3.h.c(r5);
        goto L3
    L10:
        r0.lotteryType = (int) r5.j();
        goto L3
    L11:
        r0.jumpUrl = am3.h.c(r5);
        goto L3
    L12:
        r0.text.add(am3.h.c(r5));
        goto L3
    L13:
        r0.buttonLabel = am3.h.c(r5);
        goto L3
    L14:
        r0.resultLabel = am3.h.c(r5);
        goto L3
    L15:
        r0.winRecordId = am3.h.c(r5);
        goto L3
    L16:
        r0.userActivityStatus = r5.j();
        goto L3
    L17:
        r0.openTime = r5.j();
        goto L3
    L18:
        r0.taskType = r5.j();
        goto L3
    L19:
        r0.activityId = am3.h.c(r5);
        goto L3
    L8:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
