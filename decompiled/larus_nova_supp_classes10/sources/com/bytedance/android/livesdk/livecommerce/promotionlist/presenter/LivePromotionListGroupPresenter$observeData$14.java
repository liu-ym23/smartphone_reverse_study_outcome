package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import android.view.ViewStub;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$x;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$x;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListGroupPresenter$observeData$14 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.x, Unit> {
    public LivePromotionListGroupPresenter$observeData$14(LivePromotionListGroupPresenter r8) {
        super(1, r8, LivePromotionListGroupPresenter.class, "showUserChooseEntryView", "showUserChooseEntryView(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListEvent$NotifyLoadUserChooseStoreEntryEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.x r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        final LivePromotionListGroupPresenter r6 = (LivePromotionListGroupPresenter) ((CallableReference) this).receiver;
        View r0 = r6.o;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L8:
        r6.Y().d().q(nj2.f.class, 8);
        r6.Y().d().r(nj2.f.class);
        oh.a.c("ECBackStoreEntryShowEvent", new m(r6));
        return;
    L5:
        View r1 = ((ViewStub) r6.Z().b(2131383374).f()).inflate();
        if (r1 == null) goto L8;
        com.bytedance.android.ec.core.widget.f.c(r1, null, null, new LivePromotionListGroupPresenter$showUserChooseEntryView$$inlined$let$lambda$1(r6), 3);
        r6.o = r1;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.x) r1);
        return Unit.INSTANCE;
    }
}
