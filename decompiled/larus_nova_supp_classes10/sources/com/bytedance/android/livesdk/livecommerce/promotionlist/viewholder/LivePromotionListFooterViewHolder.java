package com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECPromotionListFooterView;
import com.bytedance.android.livesdk.livecommerce.iron.ui.j;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewholder/LivePromotionListFooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewholder/a;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListFooterViewHolder extends RecyclerView.ViewHolder implements a {
    public static final /* synthetic */ int h = 0;
    public boolean a;
    public final LoadMoreStatusView b;
    public final View c;
    public final ECPromotionListFooterView d;
    public final Space e;
    public final j f;
    public final LifecycleOwner g;

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.a
    public final void doClear() {
        this.d.getClass();
    }

    public final void U3(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.l r2) {
        r2.getClass();
        PageListLoadStatus r3 = r2.a;
        int r4 = c.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        ExtensionsKt.visible(((RecyclerView.ViewHolder) this).itemView);
        this.b.a();
        ExtensionsKt.gone(this.c);
        ExtensionsKt.gone(this.d);
        return;
    L5:
        if (r4 != 2) goto L7;
        ExtensionsKt.visible(((RecyclerView.ViewHolder) this).itemView);
        this.b.b();
        ExtensionsKt.visible(this.c);
        ExtensionsKt.gone(this.d);
        this.d.Y5();
        return;
    L7:
        if (r4 != 3) goto L15;
        ExtensionsKt.visible(((RecyclerView.ViewHolder) this).itemView);
        this.b.b();
        ExtensionsKt.gone(this.c);
        ExtensionsKt.visible(this.d);
        this.d.b6(this.f);
        return;
    }

    public LivePromotionListFooterViewHolder(ViewGroup r4, j r5, LifecycleOwner r6) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "footerViewModel");
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        super(th.a.c(r4.getContext(), 2131564761, r4, false));
        this.f = r5;
        this.g = r6;
        this.b = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131387786);
        this.c = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390661);
        this.d = (ECPromotionListFooterView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373397);
        this.e = (Space) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131364525);
    }

    public final void T3(LifecycleOwner r3, PageListLoadStatus r4, LivePromotionListViewModel r5) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "vm");
        if (this.a == true) goto L5;
        this.a = true;
        com.bytedance.android.ec.core.arch.event.c.c(r5, r3, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.l.class), new LivePromotionListFooterViewHolder$bindData$1(this));
        com.bytedance.android.ec.core.arch.event.c.c(r5, r3, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.c.class), new LivePromotionListFooterViewHolder$bindData$2(this));
        com.bytedance.android.ec.core.arch.event.c.c(r5, r3, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.u.class), new LivePromotionListFooterViewHolder$bindData$3(this));
    L5:
        if (r4 == null) goto L7;
        U3(new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.l(r4));
    L7:
        ViewGroup.LayoutParams r6 = this.d.getLayoutParams();
        if ((r6 instanceof FrameLayout.LayoutParams) == true) goto L10;
        r6 = null;
    L10:
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
        if (r7 == null) goto L14;
        r7.gravity = 80;
        return;
    }
}
