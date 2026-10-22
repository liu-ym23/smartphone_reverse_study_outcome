package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.livesdk.livecommerce.view.ECHostLiveNoPromotionLayoutImpl;
import com.bytedance.android.livesdk.livecommerce.view.ECLoadingStateView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lmj2/h;", "Lcom/bytedance/android/livesdk/livecommerce/base/paging/PageListLoadStatus;", "p1", "", "invoke", "(Lmj2/h;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListGroupPresenter$observeData$2 extends FunctionReferenceImpl implements Function1<mj2.h<PageListLoadStatus>, Unit> {
    public LivePromotionListGroupPresenter$observeData$2(LivePromotionListGroupPresenter r8) {
        super(1, r8, LivePromotionListGroupPresenter.class, "updateLoadInitialStatus", "updateLoadInitialStatus(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LoadStatusWrapper;)V", 0);
    }

    public final void invoke(mj2.h<PageListLoadStatus> r11) {
        LivePromotionListGroupPresenter r0 = (LivePromotionListGroupPresenter) ((CallableReference) this).receiver;
        int r1 = LivePromotionListGroupPresenter.D;
        r0.getClass();
        if (r11 == null) goto L102;
        int r2 = r11.a;
        if (r2 == 0) goto L12;
        if (r2 == 4) goto L12;
        if (r2 == 9) goto L12;
        boolean r3 = false;
    L13:
        int r12 = g.a[r11.b.ordinal()];
        if (r12 != 1) goto L16;
        ECHostLiveNoPromotionLayoutImpl r13 = r0.k;
        if (r13 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("noPromotionLayout");
    L86:
        r13.setVisibility(8);
        ECLoadingStateView r14 = r0.j;
        if (r14 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("loadingStateView");
    L89:
        o0.e(r14, (int) r0.x);
        ECLoadingStateView r15 = r0.j;
        if (r15 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("loadingStateView");
    L92:
        r15.setVisibility(0);
        ECLoadingStateView r16 = r0.j;
        if (r16 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("loadingStateView");
    L95:
        r16.e.showLoading();
        r16.d.setVisibility(8);
        r16.c.setVisibility(8);
        r0.l0(false, r3);
        return;
    L16:
        if (r12 != 2) goto L18;
        ECHostLiveNoPromotionLayoutImpl r17 = r0.k;
        if (r17 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("noPromotionLayout");
    L54:
        r17.setVisibility(8);
        ECLoadingStateView r18 = r0.j;
        if (r18 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("loadingStateView");
    L57:
        r18.setVisibility(8);
        if (EComABUtils.enableM3TrafficDistinguishMark() == false) goto L79;
        LiveRoomParams r19 = r0.d0().getPromotionListParams().getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r19 == null) goto L76;
        String r6 = r19.getCreativeId();
        if (r6 == null) goto L76;
        if (r6.length() <= 0) goto L66;
        boolean r7 = true;
    L67:
        if (r7 != true) goto L76;
        String r110 = r19.isOtherChannel();
        if (r110 == null) goto L76;
        if (r110.length() <= 0) goto L73;
        boolean r111 = true;
    L74:
        if (r111 != true) goto L76;
        boolean r112 = true;
    L77:
        if (r112 == false) goto L79;
        r0.Z().b(2131379328).f().setVisibility(0);
    L80:
        r0.l0(true, r3);
        wj2.g r113 = r0.d0().getInitialAction();
        if ((r113 instanceof wj2.g.b) == false) goto L100;
        sl.k r114 = ((wj2.g.b) r113).a;
        Lazy r4 = LiveDynamicContext.c;
        com.bytedance.android.livesdk.livecommerce.ability.b.a.a(LiveDynamicContext.a.a().a(), r0.Y().c(), new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", "show_dialog", r114), null, null, null, 28);
        r0.d0().setInitialAction(null);
        return;
    L100:
        return;
    L73:
        r111 = false;
        goto L74
    L66:
        r7 = false;
    L76:
        r112 = false;
    L79:
        r0.Z().b(2131379328).f().setVisibility(8);
        goto L80
    L18:
        if (r12 == 3) goto L42;
        if (r12 != 4) goto L103;
        ECHostLiveNoPromotionLayoutImpl r115 = r0.k;
        if (r115 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("noPromotionLayout");
    L24:
        r115.setVisibility(8);
        ECLoadingStateView r116 = r0.j;
        if (r116 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("loadingStateView");
    L27:
        o0.e(r116, (int) r0.x);
        ECLoadingStateView r117 = r0.j;
        if (r117 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("loadingStateView");
    L30:
        r117.setVisibility(0);
        ECLoadingStateView r118 = r0.j;
        if (r118 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("loadingStateView");
    L33:
        r118.c.setVisibility(8);
        r118.d.setVisibility(0);
        r118.d.setBackgroundGray(false);
        r118.e.reset();
        wj2.g r119 = r0.d0().getInitialAction();
        if ((r119 instanceof wj2.g.a) == true) goto L36;
        r119 = null;
    L36:
        wj2.g.a r120 = (wj2.g.a) r119;
        if (r120 == null) goto L41;
        String r121 = r120.b;
        if (r121 == null) goto L41;
        r0.j0(r121, false);
        r0.d0().setInitialAction(null);
    L41:
        r0.l0(false, r3);
        return;
    L103:
        return;
    L42:
        ECHostLiveNoPromotionLayoutImpl r122 = r0.k;
        if (r122 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("noPromotionLayout");
    L45:
        r122.setVisibility(0);
        ECLoadingStateView r123 = r0.j;
        if (r123 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("loadingStateView");
    L48:
        r123.setVisibility(8);
        r0.l0(false, false);
        if (EComABUtils.getAdaptProductBlockSwitch() == false) goto L98;
        r0.w = true;
        r0.d0().updateAllViewsVisible(true);
        return;
    L98:
        return;
    L12:
        r3 = true;
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((mj2.h) r1);
        return Unit.INSTANCE;
    }
}
