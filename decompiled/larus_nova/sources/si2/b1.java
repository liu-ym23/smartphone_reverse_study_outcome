package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2LotteryInfoList;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class b1 implements am3.c<ECV2LotteryInfoList> {
    public b1() {
    }

    public static ECV2LotteryInfoList a(am3.g r100) throws Exception {
        ECV2LotteryInfoList r101 = new ECV2LotteryInfoList();
        r101.text = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 99) goto L7;
        r101.extraInfo = am3.h.c(r100);
        goto L3
    L7:
        switch(r103) {
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
        r101.elasticTitle = am3.h.c(r100);
        goto L3
    L10:
        r101.lotteryType = (int) r100.j();
        goto L3
    L11:
        r101.jumpUrl = am3.h.c(r100);
        goto L3
    L12:
        r101.text.add(am3.h.c(r100));
        goto L3
    L13:
        r101.buttonLabel = am3.h.c(r100);
        goto L3
    L14:
        r101.resultLabel = am3.h.c(r100);
        goto L3
    L15:
        r101.winRecordId = am3.h.c(r100);
        goto L3
    L16:
        r101.userActivityStatus = r100.j();
        goto L3
    L17:
        r101.openTime = r100.j();
        goto L3
    L18:
        r101.taskType = r100.j();
        goto L3
    L19:
        r101.activityId = am3.h.c(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2LotteryInfoList decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
