package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.widget.ECProductBottomView;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCombination;
import com.bytedance.android.ec.model.response.ECCombinationProduct;
import com.bytedance.android.ec.model.response.ECGivenProduct;
import com.bytedance.android.ec.model.response.ECGivenProductStruck;
import com.bytedance.android.ec.model.response.ECSpannableText;
import com.bytedance.android.ec.model.response.t;
import com.bytedance.android.ec.model.response.u;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.g;
import com.bytedance.android.livesdk.livecommerce.promotion.card.i;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImpl;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/module/ListItemBottomModule;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/model/LivePromotionCardArgs;", "argument", "", "setArgument", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListItemBottomModule extends LinearLayout {
    public com.bytedance.android.ec.common.api.jump.model.e a;
    public LivePromotionCardArgs b;
    public final ECProductBottomView c;

    public ListItemBottomModule(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ListItemBottomModule(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(i r37) {
        Intrinsics.checkNotNullParameter(r37, "promotionCardItem");
        com.bytedance.android.ec.common.api.jump.model.e r0 = r37.a;
        this.a = r0;
        String r1 = "promotionParams";
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionParams");
    L5:
        final ECUIPromotion r4 = r0.a;
        com.bytedance.android.ec.common.api.jump.model.e r2 = this.a;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("promotionParams");
    L9:
        if (r2.a.isOnTopExplain() == false) goto L21;
        com.bytedance.android.ec.common.api.jump.model.e r3 = this.a;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("promotionParams");
    L14:
        if (r3.a.getCombination() != null) goto L20;
        com.bytedance.android.ec.common.api.jump.model.e r5 = this.a;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("promotionParams");
    L19:
        if (r5.a.shouldShowGivenProduct() == false) goto L21;
    L20:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L25;
        r4.setShowCombination(false);
        setVisibility(8);
        this.c.setVisibility(8);
        return;
    L25:
        setVisibility(0);
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = null;
        ECCombination r7 = r4.getCombination();
        if (r7 == null) goto L58;
        r4.setShowCombination(true);
        LivePromotionCardArgs r11 = this.b;
        if (r11 == null) goto L41;
        ILivePromotionCardContainerHandler r12 = r11.b;
        if (r12 == null) goto L41;
        if (r12.h(Decision.ADJUST_INSTANT_FUSION) != true) goto L41;
        List r13 = r7.getCombinationProducts();
        if (r13 == null) goto L40;
        List r14 = r13;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L37:
        if (r16.hasNext() == false) goto L39;
        ECCombinationProduct r17 = (ECCombinationProduct) r16.next();
        r15.add(new t(r17.getCoverUrl(), r17.getMinPrice()));
        r1 = r1;
        goto L37
    L39:
        String r38 = r1;
        List r18 = CollectionsKt.take(r15, 2);
    L49:
        String r19 = r7.getJumpUrl();
        List r20 = CollectionsKt.listOf(new ECSpannableText(r7.getPoi(), "#A6161823"));
        long r24 = r7.getOriginMinPrice();
        long r26 = r7.getCombinationMinPrice();
        LivePromotionCardArgs r9 = this.b;
        if (r9 == null) goto L56;
        ILivePromotionCardContainerHandler r10 = r9.b;
        if (r10 == null) goto L56;
        if (r10.h(Decision.ADJUST_INSTANT_FUSION) != true) goto L56;
        int r21 = 2131234284;
    L57:
        u r22 = new u(r18, r19, r20, null, null, null, r24, r26, null, Integer.valueOf(r21), 2131234560, 2131234559, 2131234283, new Rect(0, 0, 0, 0), new Rect(8, 0, 0, 0), 312);
        r8.element = r22;
        r22.a = new ListItemBottomModule$updateProductBottom$$inlined$let$lambda$1(this, r4, r8);
    L59:
        final ECGivenProductStruck r23 = r4.givenProduct;
        if (r23 == null) goto L92;
        LivePromotionCardArgs r25 = this.b;
        if (r25 == null) goto L66;
        g.a r27 = r25.a;
        if (r27 == null) goto L66;
        final String r28 = r27.a(ListItemBottomModule$updateProductBottom$2$btm$1.INSTANCE, r4.getIronIndex());
    L67:
        List r29 = r23.getProducts();
        if (r29 == null) goto L74;
        List r30 = r29;
        ArrayList r31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
        Iterator r32 = r30.iterator();
    L71:
        if (r32.hasNext() == false) goto L73;
        r31.add(new t(((ECGivenProduct) r32.next()).getCover(), 2));
        goto L71
    L73:
        ArrayList r110 = r31;
    L75:
        r8.element = new u(r110, r23.getJumpUrl(), r23.getRightText(), r23.getBackground(), r23.getLeftIcon(), r23.getRightIcon(), 0, 0, r23.getEventParams(), null, null, null, null, null, null, 32448);
        LivePromotionCardArgs r33 = this.b;
        if (r33 == null) goto L89;
        PromotionListEventActionImpl r34 = r33.h;
        if (r34 == null) goto L89;
        com.bytedance.android.ec.common.api.jump.model.e r35 = this.a;
        if (r35 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException(r38);
    L82:
        com.bytedance.android.ec.common.api.jump.model.g r36 = r35.b;
        Intrinsics.checkNotNullParameter(r36, r38);
        ECUIPromotion r39 = r36.a;
        if (r39 == null) goto L88;
        ECUIPromotion r40 = r39;
        if (r34.b.b("livesdk_ecom_gift_bar_show", r40.getPromotionId()) == true) goto L89;
        r34.b.d("livesdk_ecom_gift_bar_show", r40.getPromotionId());
        oh.a.c("livesdk_ecom_gift_bar_show", new l(r34, r36, r40));
        goto L89
    L88:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    L89:
        u r41 = (u) r8.element;
        if (r41 == null) goto L92;
        r41.a = new ListItemBottomModule$updateProductBottom$$inlined$let$lambda$2(r23, r28, this, r4, r8);
        goto L92
    L74:
        r110 = null;
    L66:
        r28 = null;
    L92:
        u r42 = (u) r8.element;
        if (r42 == null) goto L100;
        this.c.setVisibility(0);
        this.c.R5(r42);
        return;
    L100:
        return;
    L56:
        r21 = 2131234282;
        goto L57
    L40:
        r38 = "promotionParams";
    L48:
        r18 = null;
    L41:
        r38 = "promotionParams";
        List r43 = r7.getCombinationProducts();
        if (r43 == null) goto L48;
        List r44 = r43;
        ArrayList r45 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r44, 10));
        Iterator r46 = r44.iterator();
    L45:
        if (r46.hasNext() == false) goto L47;
        ECCombinationProduct r111 = (ECCombinationProduct) r46.next();
        r45.add(new t(r111.getCoverUrl(), r111.getMinPrice()));
        goto L45
    L47:
        r18 = r45;
        goto L49
    L58:
        r38 = "promotionParams";
    L21:
        r6 = false;
        goto L23
    }

    public final void setArgument(LivePromotionCardArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.b = r2;
    }

    public ListItemBottomModule(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131564746, this, true);
        this.c = findViewById(2131382058);
    }

    public /* synthetic */ ListItemBottomModule(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
