package hj2;

import android.content.Context;
import android.util.LruCache;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements ij2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LivePromotionCardArgs f485393a;

    @Override // ij2.c
    public String getType() {
        return "ping_group_widget";
    }

    public c(LivePromotionCardArgs r100) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        this.f485393a = r100;
    }

    @Override // ij2.c
    public final boolean b(com.bytedance.android.ec.common.api.jump.model.e r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ECUIPromotion r101 = r100.f42855a;
        if (r101.isPriceDeduce() == true) goto L15;
        ECUICampaign r102 = r101.getCampaign();
        if (r102 == null) goto L7;
        Boolean r103 = r102.isGroup();
    L9:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L15;
        ECUICampaign r104 = r101.getCampaign();
        if (r104 == null) goto L15;
        if (r104.inCampaignTime() != true) goto L15;
        return true;
    L7:
        r103 = null;
    L15:
        return false;
    }

    @Override // ij2.c
    public final ij2.a c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new com.bytedance.android.livesdk.livecommerce.promotion.card.widget.a(r100, this.f485393a);
    }

    @Override // ij2.c
    public final ij2.a a(Context r100, LruCache<String, ij2.a> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return ij2.c.a.a(this, r100, r101);
    }
}
