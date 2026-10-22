package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2WinLotteryAlert;

/* JADX INFO: loaded from: classes10.dex */
public final class s1 implements am3.c<ECV2WinLotteryAlert> {
    public s1() {
    }

    public static ECV2WinLotteryAlert a(am3.g r100) throws Exception {
        ECV2WinLotteryAlert r101 = new ECV2WinLotteryAlert();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.title = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.content = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.buttonLabel = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2WinLotteryAlert decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
