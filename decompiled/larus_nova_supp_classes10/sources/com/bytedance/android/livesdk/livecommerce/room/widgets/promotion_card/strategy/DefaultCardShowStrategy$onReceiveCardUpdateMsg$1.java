package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPingGroup;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCampaignInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedProductInfo;
import com.bytedance.android.livesdk.livecommerce.room.utils.g;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import si2.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lsi2/f0;", "msg", "Lcom/bytedance/android/ec/model/promotion/ECUIPromotion;", "uiPromotion", "", "invoke", "(Lsi2/f0;Lcom/bytedance/android/ec/model/promotion/ECUIPromotion;)Lkotlin/Unit;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class DefaultCardShowStrategy$onReceiveCardUpdateMsg$1 extends Lambda implements Function2<f0, ECUIPromotion, Unit> {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ ExplainCardViewModel $vm;
    final /* synthetic */ DefaultCardShowStrategy this$0;

    public DefaultCardShowStrategy$onReceiveCardUpdateMsg$1(DefaultCardShowStrategy r1, ExplainCardViewModel r2, Function1 r3) {
        this.this$0 = r1;
        this.$vm = r2;
        this.$callback = r3;
        super(2);
    }

    public final Unit invoke(final f0 r10, final ECUIPromotion r11) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r11, "uiPromotion");
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = true;
        if (DefaultCardShowStrategy.c(this.this$0, r10, r11, 6) == true) goto L16;
        DefaultCardShowStrategy.f(this.this$0, r11, r10.productInfo);
        ECV2UpdatedProductInfo r2 = r10.productInfo;
        if (r2 == null) goto L7;
        long r5 = r2.price;
    L9:
        if (r5 <= 0) goto L16;
        g r3 = this.this$0.g;
        if (r3 == null) goto L13;
        r3.c("card_price", 0, true, new AnonymousClass1(this, r11));
    L13:
        int r4 = com.bytedance.android.livesdk.livecommerce.message.a.i;
        com.bytedance.android.livesdk.livecommerce.message.a r6 = com.bytedance.android.livesdk.livecommerce.message.a.C0078a.a(r10.getCommon());
        if (r6 == null) goto L16;
        r6.b("explain_card");
    L18:
        if (DefaultCardShowStrategy.c(this.this$0, r10, r11, 3) == true) goto L29;
        DefaultCardShowStrategy.f(this.this$0, r11, r10.productInfo);
        r11.isCampaign = true;
        ECV2UpdatedCampaignInfo r7 = r10.campaignInfo;
        if (r7 != null) goto L22;
    L24:
        r11.setCampaign(null);
    L25:
        ExplainCardViewModel r8 = this.$vm;
        if (r8 == null) goto L29;
        r8.queryPromotionCampaign(r11.getPromotionId(), new AnonymousClass3(this, r11));
        goto L29
    L22:
        if (r7.isValid != true) goto L24;
        r0.element = false;
    L29:
        if (DefaultCardShowStrategy.c(this.this$0, r10, r11, 5) == true) goto L36;
        ECUICampaign r9 = r11.campaign;
        if (r9 == null) goto L33;
        ECUIPingGroup r12 = r9.groupData;
    L34:
        UtilityKotlinExtentionsKt.f(r12, r10.updatedGroupInfo, AnonymousClass4.INSTANCE);
        goto L36
    L33:
        r12 = null;
    L36:
        if (DefaultCardShowStrategy.c(this.this$0, r10, r11, 1) == true) goto L39;
        UtilityKotlinExtentionsKt.f(r11, Boolean.valueOf(r10.soldOut), AnonymousClass5.INSTANCE);
    L39:
        if (DefaultCardShowStrategy.c(this.this$0, r10, r11, 9) == true) goto L44;
        if (this.this$0.f.i().v() == true) goto L44;
        UtilityKotlinExtentionsKt.f(r11, r10.hotAtmosphere, new AnonymousClass6(this, r10, r0));
    L44:
        if (DefaultCardShowStrategy.c(this.this$0, r10, r11, 11) == true) goto L47;
        r11.setCombination(null);
        r0.element = true;
    L47:
        if (r0.element == false) goto L49;
        this.this$0.f.f(r11);
        this.$callback.invoke(r11);
    L49:
        if (r6 == null) goto L52;
        r6.a();
        return Unit.INSTANCE;
    L52:
        return null;
    L7:
        r5 = -1;
    L16:
        r6 = null;
        goto L18
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((f0) r1, (ECUIPromotion) r2);
    }
}
