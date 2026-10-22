package kh2;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements e<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f503452a;

    @Override // kh2.e
    public final Integer getValue() {
        return Integer.valueOf(this.f503452a);
    }

    public g(ECPromotionList r100) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L9:
        this.f503452a = r101;
        return;
    L5:
        List<ECPromotion> r102 = r100.promotionList;
        if (r102 != null) goto L8;
        r102 = CollectionsKt.emptyList();
    L8:
        r101 = !r102.isEmpty() ? 1 : 0;
        goto L9
    }
}
