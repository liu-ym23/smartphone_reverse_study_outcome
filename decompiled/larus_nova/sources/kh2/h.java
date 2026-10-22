package kh2;

import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements e<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f503453a;

    @Override // kh2.e
    public final Integer getValue() {
        return Integer.valueOf(this.f503453a);
    }

    public h(ECPromotionList r100) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        this.f503453a = r101;
        return;
    L5:
        r101 = r100.showCart;
        goto L6
    }
}
