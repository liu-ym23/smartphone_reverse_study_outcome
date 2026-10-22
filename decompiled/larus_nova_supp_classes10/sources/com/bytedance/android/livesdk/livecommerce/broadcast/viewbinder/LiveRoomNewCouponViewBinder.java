package com.bytedance.android.livesdk.livecommerce.broadcast.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.multitype.b;
import com.bytedance.android.livesdk.livecommerce.view.ECHostDistributeCouponStatusLayout;
import com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewCouponLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import si2.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveRoomNewCouponViewBinder extends b<p, ItemViewHolder> {
    public final a a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/broadcast/viewbinder/LiveRoomNewCouponViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final ECNewCouponLayout a;
        public final a b;

        public static final class a implements ECNewCouponLayout.a {
            public final /* synthetic */ ItemViewHolder a;

            public a(ItemViewHolder r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewCouponLayout.a
            public final void a(ECHostDistributeCouponStatusLayout r2) {
                a r0 = this.a.b;
                if (r0 == null) goto L6;
                r0.showBubble(r2);
                return;
            }

            @Override // com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewCouponLayout.a
            public final void distributeCoupon(p r2) {
                Intrinsics.checkNotNullParameter(r2, "coupon");
                a r0 = this.a.b;
                if (r0 == null) goto L6;
                r0.distributeCoupon(r2);
                return;
            }
        }

        public ItemViewHolder(ViewGroup r4, a r5) {
            Intrinsics.checkNotNullParameter(r4, "parentView");
            super(th.a.c(r4.getContext(), 2131560791, r4, false));
            this.b = r5;
            ECNewCouponLayout r6 = (ECNewCouponLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131370708);
            this.a = r6;
            r6.setCouponHandler(new a(this));
        }
    }

    public interface a {
        void distributeCoupon(p r1);

        void showBubble(View r1);
    }

    public LiveRoomNewCouponViewBinder(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.multitype.b
    public final void a(RecyclerView.ViewHolder r2, Object r3) {
        ItemViewHolder r4 = (ItemViewHolder) r2;
        p r5 = (p) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "coupon");
        r4.a.b(r5);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.multitype.b
    public final ItemViewHolder b(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new ItemViewHolder(r3, this.a);
    }
}
