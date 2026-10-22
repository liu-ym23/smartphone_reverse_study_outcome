package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import ak2.m;
import android.text.TextUtils;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import hh2.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECSendAdLog;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSendAdLog extends ECBaseBridgeMethod {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "sendECAdLog";
    }

    public ECSendAdLog() {
    }

    public final void c(JSONObject r5, ECBaseBridgeMethod.a r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "iReturn");
        String r7 = r5.optString(LocationMonitorConst.TAG);
        if (TextUtils.isEmpty(r7) == true) goto L14;
        int r0 = RoomContextController.h;
        RoomContextController r1 = RoomContextController.a.a();
        JSONObject r2 = r5.optJSONObject("param");
        if (r2 != null) goto L7;
        r2 = new JSONObject();
    L7:
        r2.put("anchor_id", r1.y());
        if (f.e() == false) goto L10;
        r2.put("anchor_open_id", r1.y());
    L10:
        r2.put("room_id", r1.B());
        boolean r3 = EntryController.M1;
        m r4 = EntryController.a.a().F;
        if (r4 == null) goto L15;
        r4.onClickPromotion(r7, r5.optString("label"), r5.optString("refer"), r2);
        return;
    L15:
        return;
    }
}
