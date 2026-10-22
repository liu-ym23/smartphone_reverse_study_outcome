package sg2;

import com.bytedance.android.livesdk.livecommerce.iron.helper.PromotionJumpDispatcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c0 implements fi2.b {
    public c0() {
    }

    @Override // fi2.b
    public final PromotionJumpDispatcher a(bk2.d r2, jf.c r3, com.bytedance.android.livesdk.livecommerce.promotion.card.d r4) {
        Intrinsics.checkNotNullParameter(r2, "disposableScope");
        Intrinsics.checkNotNullParameter(r4, "promotionSimpleSku");
        return new PromotionJumpDispatcher(r2, r3, r4);
    }
}
