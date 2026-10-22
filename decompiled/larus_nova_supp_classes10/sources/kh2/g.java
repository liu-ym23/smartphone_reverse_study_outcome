package kh2;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements e<Integer> {
    public final int a;

    @Override // kh2.e
    public final Integer getValue() {
        return Integer.valueOf(this.a);
    }

    public g(ECPromotionList r1) {
        if (r1 != null) goto L5;
        int r2 = 0;
    L9:
        this.a = r2;
        return;
    L5:
        List<ECPromotion> r3 = r1.promotionList;
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        r2 = !r3.isEmpty() ? 1 : 0;
        goto L9
    }
}
