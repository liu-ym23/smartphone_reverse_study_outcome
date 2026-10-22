package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z1 extends u0 {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.event.ECEventV3
    public final ECEventV3 g(Map r1) {
        super.g(r1);
        return this;
    }

    public final void p(Map r1) {
        super.g(r1);
    }

    public final void q(Map r1) {
        super.g(r1);
    }

    public z1(int r2, RoomContextController r3) {
        if (r2 == 9) goto L5;
        String r4 = "livesdk_show_product";
    L6:
        super(r3, r4);
        return;
    L5:
        r4 = "livesdk_unrec_show_product";
        goto L6
    }

    public final void o(boolean r3, String r4) {
        if (this.c.g("is_exist_matching_button").booleanValue() == true) goto L8;
        if (r3 == false) goto L6;
        String r0 = "1";
    L7:
        f("is_exist_matching_button", r0);
        goto L8
    L6:
        r0 = BDLocationException.ERROR_TIMEOUT;
    L8:
        if (r3 == false) goto L12;
        if (r4 == null) goto L13;
        f("combination_id", r4);
        return;
    L13:
        return;
    }
}
