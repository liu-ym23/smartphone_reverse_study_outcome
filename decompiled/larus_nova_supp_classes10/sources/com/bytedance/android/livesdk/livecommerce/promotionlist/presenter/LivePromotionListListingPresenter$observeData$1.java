package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionListPageAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$e;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListListingPresenter$observeData$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.e, Unit> {
    public LivePromotionListListingPresenter$observeData$1(LivePromotionListListingPresenter r8) {
        super(1, r8, LivePromotionListListingPresenter.class, "changeSelectedCategoryEvent", "changeSelectedCategoryEvent(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListEvent$ChangeSelectedCategoryEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.e r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        LivePromotionListListingPresenter r0 = (LivePromotionListListingPresenter) ((CallableReference) this).receiver;
        LivePromotionListPageAdapter r1 = r0.m;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r1.submitList(null);
        LivePromotionListPageAdapter r2 = r0.m;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L9:
        if (r2.b == false) goto L11;
        r2.b = false;
        r2.H2(false);
    L11:
        LivePromotionListPageAdapter r3 = r0.m;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L15:
        if (r3.G2(r6.a.isAllTab()) == false) goto L20;
        if (true == r3.c) goto L22;
        r3.c = true;
        r3.I2(true);
    L22:
        LivePromotionListPageAdapter r7 = r0.m;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L25:
        r0.p0(r7.c ? 1 : 0, 0);
        return;
    L20:
        if (r3.c == false) goto L22;
        r3.c = false;
        r3.I2(false);
        goto L22
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.e) r1);
        return Unit.INSTANCE;
    }
}
