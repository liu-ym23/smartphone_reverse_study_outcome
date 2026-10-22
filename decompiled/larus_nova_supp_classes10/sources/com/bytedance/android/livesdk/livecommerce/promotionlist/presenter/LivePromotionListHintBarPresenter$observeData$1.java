package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECPromotionListHintBannerView;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ExplainingPromotionBar;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImplV2;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$i0;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$i0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListHintBarPresenter$observeData$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.i0, Unit> {
    public LivePromotionListHintBarPresenter$observeData$1(LivePromotionListHintBarPresenter r8) {
        super(1, r8, LivePromotionListHintBarPresenter.class, "updateExplainingPromotionBar", "updateExplainingPromotionBar(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListEvent$UpdateExplainingPromotionBarEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.i0 r19) {
        Intrinsics.checkNotNullParameter(r19, "p1");
        final LivePromotionListHintBarPresenter r2 = (LivePromotionListHintBarPresenter) ((CallableReference) this).receiver;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r19, "event");
        PromotionCategory r3 = r2.d0().getCurrentCategory();
        String r4 = r19.a;
        boolean r5 = false;
        if (r4 != null) goto L5;
    L71:
        ECPromotionListHintBannerView r0 = r2.j;
        if (r0 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("hintBannerView");
    L75:
        if (r0.d.getVisibility() != 0) goto L77;
        r5 = true;
    L77:
        if (r5 == false) goto L83;
        r0.d.b();
        return;
    L83:
        return;
    L5:
        if (r4.length() <= 0) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == false) goto L13;
        if (r3 == null) goto L13;
        if (r3.isAllTab() == true) goto L13;
        boolean r9 = true;
    L14:
        Map r10 = null;
        if (r9 == true) goto L18;
        r4 = null;
    L18:
        if (r4 == null) goto L71;
        List<String> r1 = r19.b;
        if (r1 == null) goto L33;
        if (r3 == null) goto L23;
        String r6 = r3.getUniqueIndex();
    L24:
        if (r6 != null) goto L27;
        r6 = "";
    L27:
        if (r1.contains(r6) != true) goto L33;
        ECPromotionListHintBannerView r7 = r2.j;
        if (r7 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("hintBannerView");
    L32:
        r7.setPreviousPromotionId(r4);
        r4 = null;
        goto L33
    L23:
        r6 = null;
    L33:
        if (r4 == null) goto L71;
        ql.a r11 = r2.d0().getCurrentTopPromotion();
        if (r11 == null) goto L71;
        ECPromotionListHintBannerView r12 = r2.j;
        if (r12 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("hintBannerView");
    L39:
        String r13 = r11.getPromotionId();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "promotionId");
        ExplainingPromotionBar r14 = r12.d;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "promotionId");
        if (Intrinsics.areEqual(r13, r14.d) == true) goto L80;
        final ql.a r15 = com.bytedance.android.livesdk.livecommerce.utils.l.a(r11);
        if (r15 == null) goto L81;
        r15.getClientData().a = true;
        ECPromotionListHintBannerView r16 = r2.j;
        if (r16 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("hintBannerView");
    L46:
        JSONObject r17 = r2.d0().getEntranceInfo();
        PromotionCategory.a r18 = PromotionCategory.Companion;
        PromotionCategory r20 = r2.d0().getCurrentCategory();
        if (r20 == null) goto L49;
        String r21 = r20.getUniqueIndex();
    L50:
        r18.getClass();
        final String r22 = "a1.b0715.c9204.d10885";
        r16.a(r15, r17, PromotionCategory.a.b(r21), r2.d0().getCurrentTabIndex(), r2.d0().getPromotionListParams(), new LivePromotionListHintBarPresenter$updateExplainingPromotionBar$$inlined$let$lambda$1(r15, r22, r2), new LivePromotionListHintBarPresenter$updateExplainingPromotionBar$$inlined$let$lambda$2(r22, r2));
        ECPromotionListHintBannerView r23 = r2.j;
        if (r23 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("hintBannerView");
    L53:
        ECPromotionList.p r24 = r23.b;
        if (r24 != null) goto L56;
    L60:
        ExplainingPromotionBar r25 = r23.d;
        r25.setVisibility(0);
        r25.removeCallbacks(r25.c);
        r25.postDelayed(r25.c, 10000);
        r23.d();
    L61:
        com.bytedance.android.ec.core.arch.event.c.d(r2.d0(), new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.h(true));
        di2.b r26 = r2.d0().getPromotionListEventActionImpl();
        if (r26 == null) goto L64;
        r26.a(r15, "a1.b0715.c9204.d10885");
    L64:
        com.bytedance.android.ec.common.api.jump.model.g r27 = r2.d0().getPromotionListParams().buildParams(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class), new com.bytedance.android.ec.common.api.jump.model.g.a(r15));
        if ((r15 instanceof ECUIPromotionV2) == false) goto L67;
        r10 = ((PromotionListEventActionImplV2) r2.k.getValue()).i(r27, "a1.b0715.c9204.d10885");
    L67:
        ECPromotionListHintBannerView r28 = r2.j;
        if (r28 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("hintBannerView");
    L70:
        r28.getClass();
        Intrinsics.checkNotNullParameter(r27, "promotion");
        r28.d.a(r27, r10);
        return;
    L56:
        if (r24.priority <= 40) goto L58;
        boolean r29 = true;
    L59:
        if (r29 == true) goto L61;
    L58:
        r29 = false;
        goto L59
    L49:
        r21 = null;
        goto L50
    L81:
        return;
    L80:
        return;
    L13:
        r9 = false;
        goto L14
    L7:
        r8 = false;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.i0) r1);
        return Unit.INSTANCE;
    }
}
