package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECLiveGlobalInfoMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveGlobalInfoMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECLiveGlobalInfoMethod() {
        this.e = "ecLiveGlobalInfo";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r4, ECBaseBridgeMethod.a r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "iReturn");
        String r0 = r4.optString("room_id", "");
        String r6 = a2.d(r4.optString("room_unique_key", ""));
        int r1 = RoomContextController.h;
        LiveRoomParams r7 = RoomContextController.a.b(r0, r6).l();
        if (r7 != null) goto L6;
        r5.onFailed(-1, "don't get liveRoomParams in roomId: " + r0);
        return;
    L6:
        r5.onSuccess(new JSONObject(r7.generaInitialData()));
    }
}
