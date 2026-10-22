package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LiveExplainCardPresenterV2$onUnBind$1 extends MutablePropertyReference0Impl {
    public LiveExplainCardPresenterV2$onUnBind$1(LiveExplainCardPresenterV2 r7) {
        super(r7, LiveExplainCardPresenterV2.class, "explainCardController", "getExplainCardController()Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/ExplainCardController;", 0);
    }

    public Object get() {
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r0 = ((LiveExplainCardPresenterV2) ((CallableReference) this).receiver).h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardController");
    L5:
        return r0;
    }

    public void set(Object r2) {
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r3 = (com.bytedance.android.livesdk.livecommerce.room.controller.business.n) r2;
        ((LiveExplainCardPresenterV2) ((CallableReference) this).receiver).h = r3;
    }
}
