package kh2;

import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements e<Integer> {
    public final int a;

    @Override // kh2.e
    public final Integer getValue() {
        return Integer.valueOf(this.a);
    }

    public h(ECPromotionList r1) {
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        this.a = r2;
        return;
    L5:
        r2 = r1.showCart;
        goto L6
    }
}
