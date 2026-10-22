package com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECPromotionListHintBannerView;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewholder/LivePromotionListHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewholder/a;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListHeaderViewHolder extends RecyclerView.ViewHolder implements a {
    public final LivePromotionListHeaderWrapperView a;

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.a
    public final void doClear() {
    }

    public LivePromotionListHeaderViewHolder(LivePromotionListHeaderWrapperView r2) {
        Intrinsics.checkNotNullParameter(r2, "innerView");
        super(r2);
        this.a = r2;
    }

    public final void T3(boolean r7, boolean r8, LifecycleOwner r9, PageListLoadStatus r10, final LivePromotionListViewModel r11) {
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r11, "vm");
        LivePromotionListHeaderWrapperView r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r11, "vm");
        if (ECLiveABUtils.INSTANCE.getECOM_LIVE_PROMOTION_LIST_HINT_HAR_OPT_CONFIG().b() == false) goto L14;
        if (r7 == false) goto L6;
        r2.a.a.setVisibility(8);
        r2.b.a.setVisibility(0);
        r2.b.a(r9, r10, r11);
        return;
    L6:
        if (r8 == false) goto L13;
        r2.a.a.setVisibility(0);
        r2.b.a.setVisibility(8);
        final d r12 = r2.a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r11, "vm");
        if (r12.c == true) goto L17;
        ECPromotionListHintBannerView r13 = (ECPromotionListHintBannerView) r12.a.findViewById(2131374207);
        r12.b = r13;
        if (r13 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("hintBannerView");
    L12:
        r13.setRoomId(r11.getParams().getRoomId());
        com.bytedance.android.ec.core.arch.event.c.c(r11, r9, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.i.class), new LivePromotionListHeaderHintBarItem$init$1(r12));
        com.bytedance.android.ec.core.arch.state.c.a(r11, r9, LivePromotionListHeaderHintBarItem$init$2.INSTANCE, new LivePromotionListHeaderHintBarItem$init$3(r12, r11));
        r12.c = true;
        return;
    L17:
        return;
    L13:
        r2.a.a.setVisibility(8);
        r2.b.a.setVisibility(8);
        return;
    L14:
        r2.a.a.setVisibility(8);
        r2.b.a.setVisibility(0);
        r2.b.a(r9, r10, r11);
    }
}
