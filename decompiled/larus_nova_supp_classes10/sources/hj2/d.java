package hj2;

import android.content.Context;
import android.util.LruCache;
import com.bytedance.android.ec.model.response.ECSalePointCarouselData;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECTagAndSalePointWidget;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements ij2.c {
    public final LivePromotionCardArgs a;

    @Override // ij2.c
    public String getType() {
        return "recommend_sales_point";
    }

    public d(LivePromotionCardArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.a = r2;
    }

    @Override // ij2.c
    public final boolean b(com.bytedance.android.ec.common.api.jump.model.e r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        ECSalePointCarouselData r3 = r2.a.recommendPointData;
        if (r3 == null) goto L5;
        List r4 = r3.getData();
    L6:
        List r5 = r4;
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L14:
        return !r6;
    L9:
        if (r5.isEmpty() == true) goto L12;
        r6 = false;
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    @Override // ij2.c
    public final ij2.a c(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ECTagAndSalePointWidget r0 = new ECTagAndSalePointWidget(r4, true, 12);
        r0.setArgument(this.a);
        return r0;
    }

    @Override // ij2.c
    public final ij2.a a(Context r2, LruCache<String, ij2.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return ij2.c.a.a(this, r2, r3);
    }
}
