package com.bytedance.android.shopping.feed.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.FlowTinyProductView;
import com.bytedance.android.shopping.feed.widget.SoldOutMainProductCard;
import com.bytedance.android.shopping.feed.widget.w;
import com.bytedance.android.shopping.monitor.d;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewholder/SoldOutMainProductCardVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "Landroid/content/Context;", "n", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SoldOutMainProductCardVH extends JediSimpleViewHolder<ProductFeedAdapter.b<PromotionProductStruct>> {
    public rd3.a l;
    public final Lazy m;
    public final Context n;
    public final ProductFeedAdapter o;

    public final Context getContext() {
        return this.n;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [android.widget.FrameLayout, com.bytedance.android.ec.core.widget.RoundedFrameLayout, com.bytedance.android.shopping.feed.widget.SoldOutMainProductCard] */
    /* JADX WARN: Type inference failed for: r0v19, types: [android.widget.FrameLayout, com.bytedance.android.ec.core.widget.RoundedFrameLayout, com.bytedance.android.shopping.feed.widget.SoldOutMainProductCard] */
    public final void a4(Object r11) {
        ProductFeedAdapter.b r12 = (ProductFeedAdapter.b) r11;
        Intrinsics.checkNotNullParameter(r12, "item");
        rd3.a.C0231a r0 = rd3.a.r;
        ProductFeedViewModel r1 = (ProductFeedViewModel) this.m.getValue();
        PromotionProductStruct r2 = (PromotionProductStruct) r12.b;
        if (r2 == null) goto L8;
        PromotionProductBaseStruct r3 = r2.getBaseInfo();
        if (r3 == null) goto L8;
        String r4 = r3.getPromotionId();
        if (r4 == null) goto L8;
    L9:
        r0.getClass();
        rd3.a r13 = rd3.a.C0231a.b(r1, r4, r12);
        this.l = r13;
        String r5 = this.o.B2();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r13.m = r5;
        rd3.a r14 = this.l;
        if (r14 == null) goto L12;
        r14.f = getPosition();
    L12:
        rd3.a r15 = this.l;
        if (r15 == null) goto L49;
        AnchorV3Param r6 = ((ProductFeedViewModel) this.m.getValue()).m907getAnchorV3Param();
        if (r6 == null) goto L30;
        PromotionProductStruct r7 = r6.getCurrentPromotion();
        if (r7 == null) goto L30;
        if (r7.isApiBack() == true) goto L30;
        Object r8 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r8 instanceof SoldOutMainProductCard) == true) goto L23;
        r8 = null;
    L23:
        ?? r9 = (SoldOutMainProductCard) r8;
        if (r9 == 0) goto L50;
        Intrinsics.checkNotNullParameter(r15, "anchorInflowFeedItem");
        r9.removeAllViews();
        float r10 = 8;
        r9.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, r10, SoldOutMainProductCard.y(Resources.getSystem()))));
        FlowTinyProductView r16 = new FlowTinyProductView(r9.getContext(), null, 6, 0);
        r16.setLayoutParams(new FrameLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 110, SoldOutMainProductCard.y(Resources.getSystem())))));
        float r17 = 6;
        r16.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r17, SoldOutMainProductCard.y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r10, SoldOutMainProductCard.y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r17, SoldOutMainProductCard.y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r10, SoldOutMainProductCard.y(Resources.getSystem()))));
        r16.setStyle(7);
        Unit r18 = Unit.INSTANCE;
        r9.b = r16;
        r9.addView(r16);
        r9.setBackgroundColor(-1);
        r9.b.b(r15);
        Promotion r19 = r15.f();
        if (r19 == null) goto L51;
        PromotionProductStruct r110 = r19.getPromotionInfo();
        if (r110 == null) goto L52;
        r9.b.getBuyButton().a(r110);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L30:
        Object r20 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r20 instanceof SoldOutMainProductCard) == true) goto L33;
        r20 = null;
    L33:
        ?? r21 = (SoldOutMainProductCard) r20;
        if (r21 == 0) goto L40;
        Intrinsics.checkNotNullParameter(r15, "anchorInflowFeedItem");
        r21.removeAllViews();
        float r22 = 8;
        r21.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, r22, SoldOutMainProductCard.y(Resources.getSystem()))));
        FlowTinyProductView r23 = new FlowTinyProductView(r21.getContext(), null, 6, 0);
        r23.setLayoutParams(new FrameLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 110, SoldOutMainProductCard.y(Resources.getSystem())))));
        float r24 = 6;
        r23.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r24, SoldOutMainProductCard.y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r22, SoldOutMainProductCard.y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r24, SoldOutMainProductCard.y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r22, SoldOutMainProductCard.y(Resources.getSystem()))));
        r23.setStyle(4);
        Unit r25 = Unit.INSTANCE;
        r21.b = r23;
        r21.addView(r23);
        r21.setBackgroundColor(-1);
        r21.b.b(r15);
        r21.b.setOnClickListener(new w(r21, r15));
        Promotion r111 = r15.f();
        if (r111 == null) goto L40;
        PromotionProductStruct r112 = r111.getPromotionInfo();
        if (r112 == null) goto L40;
        r21.b.getBuyButton().a(r112);
    L40:
        d.f(this.o.C).h();
        String r113 = this.o.D;
        if (r113 == null) goto L54;
        i r26 = i.a;
        com.bytedance.android.ec.monitor.duration.d r27 = r26.get(r113);
        if (r27 == null) goto L45;
        r27.a("render_end");
    L45:
        com.bytedance.android.ec.monitor.duration.d r114 = r26.get(r113);
        if (r114 == null) goto L55;
        r114.report();
        return;
    L55:
        return;
    L54:
        return;
    L49:
        return;
    L8:
        r4 = "-1";
        goto L9
    }

    public SoldOutMainProductCardVH(Context r4, ProductFeedAdapter r5) {
        RoundedFrameLayout r0 = new SoldOutMainProductCard(r4, null, 0);
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "adapter");
        Intrinsics.checkNotNullParameter(r0, FreqActions.ACTION_VIEW);
        super(r0);
        this.n = r4;
        this.o = r5;
        final KClass r6 = Reflection.getOrCreateKotlinClass(ProductFeedViewModel.class);
        this.m = LazyKt.lazy(new SoldOutMainProductCardVH$$special$$inlined$hostViewModel$1(this, r6, r6));
    }
}
