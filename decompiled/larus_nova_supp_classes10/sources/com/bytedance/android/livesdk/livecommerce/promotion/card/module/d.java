package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.promotion.card.i;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends y.d {
    public final /* synthetic */ ListItemImageAreaModule a;

    public d(ListItemImageAreaModule r1) {
        this.a = r1;
    }

    public final void onFailure(String r3, Throwable r4) {
        i r5 = this.a.c;
        if (r5 == null) goto L7;
        com.bytedance.android.ec.common.api.jump.model.e r6 = r5.a;
        if (r6 == null) goto L7;
        LiveRoomParams r7 = (LiveRoomParams) r6.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
    L8:
        int r0 = zg2.a.a;
        if (r7 == null) goto L11;
        String r1 = r7.getRoomId();
    L12:
        if (r7 == null) goto L14;
        String r8 = r7.getRoomUniqueKey();
    L15:
        zg2.a.a(r1, r8, Action.SHOP_LIST_PIC_FAIL, null);
        return;
    L14:
        r8 = null;
        goto L15
    L11:
        r1 = null;
    L7:
        r7 = null;
        goto L8
    }
}
