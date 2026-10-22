package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import android.os.Handler;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n extends com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a {
    public boolean e;
    public final RealRoomController f;

    public static final class a {
    }

    static {
    }

    public n(RealRoomController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        super(false);
        this.f = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r8) {
        Intrinsics.checkNotNullParameter(r8, "message");
        if ((r8 instanceof si2.c0) == true) goto L6;
        return false;
    L6:
        if (this.e == false) goto L8;
        return false;
    L8:
        Context r0 = this.f.m.getContext();
        LiveRoomParams r2 = this.f.m.l();
        if (r0 == null) goto L18;
        if (r2 == null) goto L18;
        si2.c0 r9 = (si2.c0) r8;
        String r6 = r9.schema;
        if (r6 != null) goto L16;
        dm.a.a("LiveTargetFlashMsgInterceptor").w("roomId: " + this.b + " roomUniqueKey: " + this.c + " promotionId: " + r9.promotionId + " create_time: " + r9.createTime + " schema is null", null);
        return false;
    L16:
        UrlBuilderV2 r10 = new UrlBuilderV2(r6);
        r10.addOrReplaceParam("room_id", r2.getRoomId());
        r10.addOrReplaceParam("author_id", r2.getAuthorId());
        r10.addOrReplaceParam("room_unique_key", r2.getRoomUniqueKey());
        String r3 = UUID.randomUUID().toString();
        r10.addOrReplaceParam("remained_view_id", r3);
        JSONObject r4 = new JSONObject();
        r4.put("remained_view_id", r3);
        Unit r5 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ec.live.targetFlashCloseOtherDialogs", r4);
        String r11 = r10.build();
        dm.a.a("LiveTargetFlashMsgInterceptor").i("open schema: " + r11);
        Handler r7 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.room.f.b(r0, r11);
        return false;
    L18:
        dm.a.a("LiveTargetFlashMsgInterceptor").w("liveRoomParams: " + r2 + " or context: " + r0 + " is null roomId: " + this.b + " roomUniqueKey: " + this.c, null);
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
        this.e = r2;
    }
}
