package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class u0 extends ECEventV3 {
    public u0(String r3) {
        super(r3);
        this.c.c("follow_status", l0.f());
    }

    public final void n(String r3) {
        if (r3 == null) goto L19;
        k0 r0 = this.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.a == null) goto L30;
        Map r4 = EcomBcmTracker.f(PageFinder.via(r3), this.c.a);
        if (r4 == null) goto L31;
        Iterator r5 = r4.entrySet().iterator();
    L11:
        if (r5.hasNext() == false) goto L32;
        Map.Entry r1 = (Map.Entry) r5.next();
        if (r1.getKey() == null) goto L11;
        if (((String) r1.getKey()).isEmpty() == true) goto L11;
        if (r1.getValue() == null) goto L11;
        f((String) r1.getKey(), r1.getValue().toString());
        goto L11
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }

    public u0(RoomContextController r2, String r3) {
        super(r2, r3);
        this.c.c("follow_status", l0.f());
    }
}
