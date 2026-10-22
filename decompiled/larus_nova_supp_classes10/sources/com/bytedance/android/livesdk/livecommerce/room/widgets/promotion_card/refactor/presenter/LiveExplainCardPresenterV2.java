package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveExplainCardPresenterV2 extends p {
    public final Lazy g;
    public com.bytedance.android.livesdk.livecommerce.room.controller.business.n h;

    public LiveExplainCardPresenterV2() {
        this.g = LazyKt.lazy(new LiveExplainCardPresenterV2$ecContext$2(this));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void C() {
        clearDisposable();
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardController");
    L7:
        r0.f = null;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r1 = this.h;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardController");
    L10:
        r1.e = null;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r2 = this.h;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardController");
    L13:
        r2.h = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        ExplainCardViewModel r4 = this.e;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isFromLive() != true) goto L36;
        ECContext r5 = (ECContext) this.g.getValue();
        if (r5 != null) goto L9;
    L11:
        ECContext r6 = (ECContext) this.g.getValue();
        String r0 = null;
        if (r6 == null) goto L16;
        com.bytedance.live.datacontext.i<String> r7 = r6.getRoomId();
        if (r7 == null) goto L16;
        String r8 = (String) r7.getValue();
    L17:
        ExplainCardViewModel r1 = this.e;
        if (r1 == null) goto L27;
        RoomContextController r2 = r1.getRoomContextController();
        if (r2 == null) goto L27;
        RoomContextController r9 = ControllerExtensionsKt.c(r2, r8);
        if (r9 == null) goto L27;
        RealRoomController r10 = r9.A();
        if (r10 == null) goto L27;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r11 = r10.q;
        if (r11 == null) goto L27;
    L33:
        this.h = r11;
        return;
    L27:
        int r12 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.o;
        ExplainCardViewModel r13 = this.e;
        if (r13 == null) goto L32;
        RoomContextController r14 = r13.getRoomContextController();
        if (r14 == null) goto L32;
        r0 = r14.D();
    L32:
        r11 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.a.a(r8, r0);
    L16:
        r8 = null;
        goto L17
    L9:
        if (r5.isCleared() != true) goto L11;
        return;
    }
}
