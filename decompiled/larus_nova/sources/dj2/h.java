package dj2;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;

/* JADX INFO: loaded from: classes10.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECUIPromotion f468898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f468899b;

    public h() {
        ECUIPromotion r100 = null;
        this(r100, 3);
    }

    public /* synthetic */ h(ECUIPromotion r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, false);
    }

    public h(ECUIPromotion r100, boolean r101) {
        this.f468898a = r100;
        this.f468899b = r101;
    }
}
