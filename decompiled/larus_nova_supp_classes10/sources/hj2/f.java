package hj2;

import android.content.Context;
import android.util.LruCache;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECSalePointCarouselData;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECTagAndSalePointWidget;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements ij2.c {
    public final LivePromotionCardArgs a;

    @Override // ij2.c
    public String getType() {
        return "tag_and_sales_point";
    }

    public f(LivePromotionCardArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.a = r2;
    }

    @Override // ij2.c
    public final boolean b(com.bytedance.android.ec.common.api.jump.model.e r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        ECUIPromotion r4 = r3.a;
        if (r4.isFindGoods() == false) goto L5;
        return true;
    L5:
        if (r4.isAuction() == false) goto L7;
        return true;
    L7:
        if (a2.b(r4.getLotteryElasticTitleText()) == true) goto L25;
        ECSalePointCarouselData r5 = r4.getRealSalePointCarouselData();
        if (r5 == null) goto L11;
        List r6 = r5.getData();
    L12:
        List r7 = r6;
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == false) goto L26;
        return false;
    L26:
        return true;
    L15:
        if (r7.isEmpty() == true) goto L18;
        r8 = false;
        goto L19
    L11:
        r6 = null;
        goto L12
    L25:
        return true;
    }

    @Override // ij2.c
    public final ij2.a c(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ECTagAndSalePointWidget r0 = new ECTagAndSalePointWidget(r4, false, 14);
        r0.setArgument(this.a);
        return r0;
    }

    @Override // ij2.c
    public final ij2.a a(Context r2, LruCache<String, ij2.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return ij2.c.a.a(this, r2, r3);
    }
}
