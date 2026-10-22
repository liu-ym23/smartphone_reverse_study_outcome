package com.bytedance.android.livesdk.livecommerce.promotionlist;

import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$b0;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$b0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListFragment$observeData$2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.b0, Unit> {
    public LivePromotionListFragment$observeData$2(LivePromotionListFragment r8) {
        super(1, r8, LivePromotionListFragment.class, "updateCartView", "updateCartView(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListEvent$NotifyUpdateShopCartIconEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.b0 r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        LivePromotionListFragment r0 = (LivePromotionListFragment) ((CallableReference) this).receiver;
        int r1 = LivePromotionListFragment.F;
        r0.getClass();
        ECLottieAnimationView r2 = r5.a;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r5.b == false) goto L11;
        if (((ArrayList) r0.m).size() < 1) goto L9;
        ListProtector.set(r0.m, 0, r2);
        return;
    L9:
        ((ArrayList) r0.m).add(r2);
        return;
    L11:
        if (((ArrayList) r0.m).size() < 2) goto L14;
        ListProtector.set(r0.m, 1, r2);
        return;
    L14:
        if (((ArrayList) r0.m).size() != 1) goto L21;
        ((ArrayList) r0.m).add(r2);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.b0) r1);
        return Unit.INSTANCE;
    }
}
