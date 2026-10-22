package sg2;

import com.bytedance.android.livesdk.livecommerce.iron.helper.PromotionJumpDispatcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c0 implements fi2.b {
    public c0() {
    }

    @Override // fi2.b
    public final PromotionJumpDispatcher a(bk2.d r100, jf.c r101, com.bytedance.android.livesdk.livecommerce.promotion.card.d r102) {
        Intrinsics.checkNotNullParameter(r100, "disposableScope");
        Intrinsics.checkNotNullParameter(r102, "promotionSimpleSku");
        return new PromotionJumpDispatcher(r100, r101, r102);
    }
}
