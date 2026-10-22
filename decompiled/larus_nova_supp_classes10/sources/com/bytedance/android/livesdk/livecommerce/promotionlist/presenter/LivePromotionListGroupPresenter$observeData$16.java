package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.ViewGroup;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListJumpToOtherPageEventData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$d;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListGroupPresenter$observeData$16 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d, Unit> {
    public LivePromotionListGroupPresenter$observeData$16(LivePromotionListGroupPresenter r8) {
        super(1, r8, LivePromotionListGroupPresenter.class, "changeComponentVisibility", "changeComponentVisibility(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListEvent$ChangeComponentVisibilityEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        LivePromotionListGroupPresenter r0 = (LivePromotionListGroupPresenter) ((CallableReference) this).receiver;
        int r1 = LivePromotionListGroupPresenter.D;
        r0.getClass();
        String r2 = r6.a;
        if (r2.hashCode() == 1908904590) goto L6;
        return;
    L6:
        if (r2.equals("list_with_tab_banner") == false) goto L17;
        ViewGroup r3 = (ViewGroup) r0.Z().b(2131378074).f();
        if (r6.b == false) goto L10;
        int r4 = 0;
    L11:
        r3.setVisibility(r4);
        if (r6.b == true) goto L18;
        com.bytedance.android.shopping.ligo.context.b<?> r7 = r0.d0().getLigoContext();
        if (r7 == null) goto L19;
        r7.g(new we3.a.c(new LiveLigoListJumpToOtherPageEventData("non_live_tab", null, 2, null)));
        return;
    L19:
        return;
    L18:
        return;
    L10:
        r4 = 8;
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d) r1);
        return Unit.INSTANCE;
    }
}
