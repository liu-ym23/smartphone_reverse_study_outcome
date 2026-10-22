package com.bytedance.android.shopping.searchsimilar.viewholder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.adapter.SimilarProductCardAdapter;
import com.bytedance.android.shopping.searchsimilar.view.SimilarProductCardView;
import gh3.g;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/viewholder/SimilarProductCardVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductCardVH extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int e = 0;
    public final Function0<Unit> a;
    public final RecyclerView b;
    public final SimilarProductCardAdapter c;
    public final Set<String> d;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ SimilarProductCardVH a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        public a(SimilarProductCardVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r5) {
            Intrinsics.checkNotNullParameter(r5, "v");
            SimilarProductCardVH r6 = this.a;
            int r0 = SimilarProductCardVH.e;
            View r1 = ((RecyclerView.ViewHolder) r6).itemView;
            String r2 = null;
            if ((r1 instanceof SimilarProductCardView) == true) goto L5;
            r1 = null;
        L5:
            SimilarProductCardView r3 = (SimilarProductCardView) r1;
            if (r3 == null) goto L34;
            Set<String> r7 = r6.d;
            Intrinsics.checkNotNullParameter(r7, "watchList");
            rd3.a r4 = r3.l;
            if (r4 == null) goto L16;
            Promotion r8 = r4.f();
            if (r8 == null) goto L16;
            PromotionProductStruct r9 = r8.getPromotionInfo();
            if (r9 == null) goto L16;
            PromotionProductBaseStruct r10 = r9.getBaseInfo();
            if (r10 == null) goto L16;
            String r11 = r10.getProductId();
        L18:
            if (r7.contains(r11) == true) goto L35;
            rd3.a r12 = r3.l;
            if (r12 == null) goto L28;
            Promotion r13 = r12.f();
            if (r13 == null) goto L28;
            PromotionProductStruct r14 = r13.getPromotionInfo();
            if (r14 == null) goto L28;
            PromotionProductBaseStruct r15 = r14.getBaseInfo();
            if (r15 == null) goto L28;
            String r16 = r15.getProductId();
        L29:
            r7.add(r16);
            int r17 = g.a;
            Context r18 = r3.getContext();
            Integer r19 = r3.m;
            if (r19 == null) goto L32;
            r2 = String.valueOf(r19.intValue() + 1);
        L32:
            g.a(r18, "show_product", r2, r3.n, r3.l);
            return;
        L28:
            r16 = null;
            goto L29
        L35:
            return;
        L16:
            r11 = null;
            goto L18
        }
    }

    public static final class b {
    }

    static {
    }

    public SimilarProductCardVH(SimilarProductCardView r2, RecyclerView r3, SimilarProductCardAdapter r4, Set<String> r5) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r4, "adapter");
        Intrinsics.checkNotNullParameter(r5, "watchList");
        super(r2);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        if (r3 == null) goto L5;
        r3.addOnScrollListener(new AnonymousClass1(this));
    L5:
        ((RecyclerView.ViewHolder) this).itemView.addOnAttachStateChangeListener(new a(this));
        this.a = new SimilarProductCardVH$removeItemAction$1(this);
    }
}
