package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainCardPresenter extends p {
    public Long g;
    public ECUIPromotion h;

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void C() {
        UtilityKotlinExtentionsKt.f(this.g, this.h, new ExplainCardPresenter$logShowDurationEvent$1(this));
        RoomContextController r0 = null;
        this.g = null;
        ExplainCardViewModel r1 = this.e;
        if (r1 == null) goto L20;
        QLiveData<ECUIPromotion> r2 = r1.getPromotionState();
        if (r2 == null) goto L20;
        ECUIPromotion r3 = (ECUIPromotion) r2.a();
        if (r3 == null) goto L20;
        String r4 = r3.getProductId();
        if (r4 == null) goto L20;
        int r5 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a;
        ExplainCardViewModel r6 = this.e;
        if (r6 == null) goto L15;
        ml.b r7 = r6.getLiveRoomInfo();
        if (r7 == null) goto L15;
        String r8 = r7.roomId();
    L16:
        ExplainCardViewModel r9 = this.e;
        if (r9 == null) goto L19;
        r0 = r9.getRoomContextController();
    L19:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a("ECProductIntroduceEvent", new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.m(ControllerExtensionsKt.c(r0, r8), r4));
    L15:
        r8 = null;
    L20:
        clearDisposable();
    }

    public ExplainCardPresenter() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(final com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r6) {
        Intrinsics.checkNotNullParameter(r6, "model");
        final ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L5;
        r0.getShowBeforeAnimAction().b(r6.getLifecycleOwner(), new ActionObserver(new ExplainCardPresenter$bind$$inlined$let$lambda$1(r0, this, r6)));
        r0.getShowAfterAnimAction().b(r6.getLifecycleOwner(), new ActionObserver(new ExplainCardPresenter$bind$$inlined$let$lambda$2(this, r6)));
        r0.getPromotionState().b(r6.getLifecycleOwner(), new ExplainCardPresenter$bind$$inlined$let$lambda$3(r0, this, r6));
        r0.getShowCardAction().b(r6.getLifecycleOwner(), new ActionObserver(new ExplainCardPresenter$bind$$inlined$let$lambda$4(this, r6)));
    L5:
        com.bytedance.android.ec.core.widget.f.c(w().f(), null, "bind_key_live_cart_card", new ExplainCardPresenter$bind$2(this), 1);
        View r7 = w().f();
        AccessibilityDelegateCompat r1 = new ExplainCardPresenter$bind$3(this);
        int r2 = com.bytedance.android.livesdk.livecommerce.utils.a.a;
        ViewCompat.setAccessibilityDelegate(r7, r1);
    }
}
