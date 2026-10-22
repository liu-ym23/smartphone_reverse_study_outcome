package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v0 extends ECEventV3 {
    public final void o() {
        Intrinsics.checkNotNullParameter("live_ad", LocationMonitorConst.TAG);
        d("is_ad_event", 1);
        f("category", "umeng");
        f(LocationMonitorConst.TAG, "live_ad");
    }

    public v0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
    }

    public final void n(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        JSONObject r0 = new JSONObject();
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r5.next();
        r0.put((String) r1.getKey(), (String) r1.getValue());
        goto L4
    L6:
        f("ad_extra_data", r0.toString());
    }
}
