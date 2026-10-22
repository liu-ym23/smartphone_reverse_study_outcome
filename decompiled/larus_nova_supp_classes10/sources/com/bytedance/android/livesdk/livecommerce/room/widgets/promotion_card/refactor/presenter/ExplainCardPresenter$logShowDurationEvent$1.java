package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "stamp", "", "promotion", "Lcom/bytedance/android/ec/model/promotion/ECUIPromotion;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ExplainCardPresenter$logShowDurationEvent$1 extends Lambda implements Function2<Long, ECUIPromotion, Unit> {
    final /* synthetic */ ExplainCardPresenter this$0;

    public ExplainCardPresenter$logShowDurationEvent$1(ExplainCardPresenter r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(long r9, ECUIPromotion r11) {
        Intrinsics.checkNotNullParameter(r11, "promotion");
        ExplainCardViewModel r0 = this.this$0.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFromLive() != true) goto L22;
        int r1 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a;
        long r5 = System.currentTimeMillis() - r9;
        ExplainCardViewModel r10 = this.this$0.e;
        RoomContextController r12 = null;
        if (r10 == null) goto L11;
        Function0<Map<String, Map<String, String>>> r13 = r10.getEventPassthroughParams();
        if (r13 == null) goto L11;
        Map r7 = (Map) r13.invoke();
    L12:
        ExplainCardViewModel r14 = this.this$0.e;
        if (r14 == null) goto L15;
        r12 = r14.getRoomContextController();
    L15:
        Intrinsics.checkNotNullParameter(r11, "uiPromotion");
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L18;
        RoomContextController r3 = r12;
    L19:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a("ExplainShowDurationEvent", new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.n(r3, r11, r5, r7));
        return;
    L18:
        int r15 = RoomContextController.h;
        r3 = RoomContextController.a.a();
    L11:
        r7 = null;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        invoke(((Number) r3).longValue(), (ECUIPromotion) r4);
        return Unit.INSTANCE;
    }
}
