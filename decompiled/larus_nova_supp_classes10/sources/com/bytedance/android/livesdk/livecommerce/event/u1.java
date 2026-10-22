package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u1 extends ECEventV3 {
    @Override // com.bytedance.android.livesdk.livecommerce.event.ECEventV3
    public final void k() {
        f("source_page", i("enter_from_merge") + "_temai_" + i("enter_method"));
        super.k();
    }

    public u1(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "enterRoomParams");
        Intrinsics.checkNotNullParameter("livesdk_ec_room_enter_success", "eventName");
        super("livesdk_ec_room_enter_success");
        String r1 = (String) r5.get("ec_room_enter");
        if (r1 != null) goto L5;
        r1 = BDLocationException.ERROR_TIMEOUT;
    L5:
        f("ec_room_enter", r1);
        if (Intrinsics.areEqual("1", (String) r5.get("is_ec_open")) == false) goto L8;
        f("is_ec_open", "1");
    L9:
        String r0 = (String) r5.get("is_ec_open");
        String r2 = (String) r5.get("ec_room_enter_start_time");
        if (Intrinsics.areEqual("1", r0) == false) goto L13;
        if (r2 == null) goto L13;
        long r3 = CastLongProtector.parseLong(r2);
        e("ec_room_enter_duration", System.currentTimeMillis() - r3);
    L13:
        f("ecom_live_params", cd.a.c(r5).toString());
        return;
    L8:
        f("is_ec_open", BDLocationException.ERROR_TIMEOUT);
        goto L9
    }
}
