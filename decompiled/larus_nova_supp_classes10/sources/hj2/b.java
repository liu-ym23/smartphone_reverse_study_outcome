package hj2;

import android.content.Context;
import android.util.LruCache;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements ij2.c {
    public final LivePromotionCardArgs a;

    @Override // ij2.c
    public String getType() {
        return "coupon_group_widget";
    }

    public b(LivePromotionCardArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.a = r2;
    }

    @Override // ij2.c
    public final boolean b(com.bytedance.android.ec.common.api.jump.model.e r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        ECUIPromotion r6 = r5.a;
        List r0 = r6.getBenefitLabels();
        if (r0 != null) goto L5;
    L6:
        ECUILotteryInfo r1 = r6.getLotteryInfo();
        if (r1 == null) goto L9;
        PromotionBenefitLabel r2 = r1.getBenefitLabel();
    L10:
        if (r2 == null) goto L12;
    L11:
        boolean r3 = true;
    L35:
        if (com.bytedance.android.livesdk.livecommerce.promotion.card.utils.a.b() == false) goto L25;
        if (r3 == true) goto L32;
        ECUICampaign r4 = r6.getCampaign();     // Catch: Exception -> L34
        if (r4 != null) goto L19;
    L20:
        ECUICampaign r7 = r6.getCampaign();     // Catch: Exception -> L34
        if (r7 != null) goto L23;
        return false;
    L23:
        if (r7.isLimitQuantityBuy() == true) goto L32;
        return false;
    L19:
        if (r4.shouldShowLimitBuyV2() != true) goto L20;
    L32:
        return true;
    L25:
        if (r3 == true) goto L32;
        if (r6.isLimitBuy() == false) goto L38;
        ECUICampaign r8 = r6.getCampaign();     // Catch: Exception -> L34
        if (r8 != null) goto L31;
        return false;
    L31:
        if (r8.shouldShowLimitBuy() == true) goto L32;
        return false;
    L38:
        return false;
    L41:
        return false;
    L12:
        r3 = false;
        goto L35
    L9:
        r2 = null;
        goto L10
    L5:
        if ((!r0.isEmpty()) == true) goto L11;
        goto L6
    }

    @Override // ij2.c
    public final ij2.a c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new com.bytedance.android.livesdk.livecommerce.promotion.card.widget.c(r3, this.a);
    }

    @Override // ij2.c
    public final ij2.a a(Context r2, LruCache<String, ij2.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return ij2.c.a.a(this, r2, r3);
    }
}
