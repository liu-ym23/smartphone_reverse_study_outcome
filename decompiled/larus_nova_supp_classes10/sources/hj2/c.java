package hj2;

import android.content.Context;
import android.util.LruCache;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements ij2.c {
    public final LivePromotionCardArgs a;

    @Override // ij2.c
    public String getType() {
        return "ping_group_widget";
    }

    public c(LivePromotionCardArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.a = r2;
    }

    @Override // ij2.c
    public final boolean b(com.bytedance.android.ec.common.api.jump.model.e r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        ECUIPromotion r4 = r3.a;
        if (r4.isPriceDeduce() == true) goto L15;
        ECUICampaign r0 = r4.getCampaign();
        if (r0 == null) goto L7;
        Boolean r1 = r0.isGroup();
    L9:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L15;
        ECUICampaign r5 = r4.getCampaign();
        if (r5 == null) goto L15;
        if (r5.inCampaignTime() != true) goto L15;
        return true;
    L7:
        r1 = null;
    L15:
        return false;
    }

    @Override // ij2.c
    public final ij2.a c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new com.bytedance.android.livesdk.livecommerce.promotion.card.widget.a(r3, this.a);
    }

    @Override // ij2.c
    public final ij2.a a(Context r2, LruCache<String, ij2.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return ij2.c.a.a(this, r2, r3);
    }
}
