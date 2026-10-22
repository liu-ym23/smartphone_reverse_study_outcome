package dj2;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h {
    public final ECUIPromotion a;
    public final boolean b;

    public h() {
        ECUIPromotion r1 = null;
        this(r1, 3);
    }

    public /* synthetic */ h(ECUIPromotion r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1, false);
    }

    public h(ECUIPromotion r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
