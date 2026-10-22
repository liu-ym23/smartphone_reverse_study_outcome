package com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$l;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/a$l;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LivePromotionListFooterViewHolder$bindData$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.l, Unit> {
    public LivePromotionListFooterViewHolder$bindData$1(LivePromotionListFooterViewHolder r8) {
        super(1, r8, LivePromotionListFooterViewHolder.class, "updateStatus", "updateStatus(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/viewmodel/LivePromotionListEvent$LoadAfterStatusChangeEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.l r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        LivePromotionListFooterViewHolder r0 = (LivePromotionListFooterViewHolder) ((CallableReference) this).receiver;
        int r1 = LivePromotionListFooterViewHolder.h;
        r0.U3(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.l) r1);
        return Unit.INSTANCE;
    }
}
