package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.graphics.drawable.Animatable;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.opt.messagequeue.ForceDoFrameMessage;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o extends com.bytedance.android.ec.core.utils.y.d {
    public final /* synthetic */ BackgroundPresenter a;

    public o(BackgroundPresenter r1) {
        this.a = r1;
    }

    public final void onFailure(String r3, Throwable r4) {
        int r5 = zg2.a.a;
        ExplainCardViewModel r6 = this.a.e;
        if (r6 == null) goto L7;
        ml.b r7 = r6.getLiveRoomInfo();
        if (r7 == null) goto L7;
        String r8 = r7.roomId();
    L8:
        ExplainCardViewModel r0 = this.a.e;
        if (r0 == null) goto L13;
        RoomContextController r1 = r0.getRoomContextController();
        if (r1 == null) goto L13;
        String r2 = r1.D();
    L14:
        zg2.a.a(r8, r2, Action.GOODS_CARD_PIC_FAIL, null);
        return;
    L13:
        r2 = null;
    L7:
        r8 = null;
        goto L8
    }

    public final void a(String r1, ImageInfo r2, Animatable r3) {
        ExplainCardViewModel r4 = this.a.e;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isFromLive() != true) goto L18;
        OptCardUtil.b("image", "call onFinalImageSet");
        OptCardUtil.e = true;
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.m == true) goto L9;
    L11:
        ExplainCardViewModel r5 = this.a.e;
        if (r5 == null) goto L19;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.r r6 = r5.getCardCallback();
        if (r6 == null) goto L20;
        r6.d();
        return;
    L20:
        return;
    L19:
        return;
    L9:
        if (Intrinsics.areEqual(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.q, Boolean.TRUE) == false) goto L11;
        OptCardUtil.b(null, "call forceDoFrame");
        ForceDoFrameMessage.a();
        goto L11
    }

    public final /* bridge */ /* synthetic */ void onFinalImageSet(String r1, Object r2, Animatable r3) {
        a(r1, (ImageInfo) r2, r3);
    }
}
