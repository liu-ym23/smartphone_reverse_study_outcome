package com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewholder/LivePromotionItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/b;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionItemViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.livesdk.livecommerce.promotion.card.b {
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.b a;

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final void A1(g r2, UpdateType r3) {
        Intrinsics.checkNotNullParameter(r2, "promotionParams");
        Intrinsics.checkNotNullParameter(r3, "updateType");
        this.a.A1(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final View F0(PromotionCardModuleName r2) {
        Intrinsics.checkNotNullParameter(r2, "module");
        return this.a.F0(r2);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final g Y0() {
        return this.a.Y0();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final Map<PromotionCardModuleName, IPromotionUIConfig.d> getUIConfig() {
        return this.a.getUIConfig();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final void release() {
        this.a.release();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.b
    public final void w2(Map<PromotionCardModuleName, IPromotionUIConfig.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a.w2(r2);
    }

    public LivePromotionItemViewHolder(com.bytedance.android.livesdk.livecommerce.promotion.card.b r2) {
        Intrinsics.checkNotNullParameter(r2, "promotionCard");
        super(com.bytedance.android.livesdk.livecommerce.promotion.card.b.a.a(r2));
        this.a = r2;
    }
}
