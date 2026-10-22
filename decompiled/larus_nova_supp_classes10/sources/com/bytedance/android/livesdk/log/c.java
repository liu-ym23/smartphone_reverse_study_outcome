package com.bytedance.android.livesdk.log;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, LocationMonitorConst.INFO);
        HashMap r0 = new HashMap();
        r0.put("event_name", r4);
        r0.put("event_info", r5);
        if (r2 == false) goto L5;
        b0.o().f(r3, r0);
        return;
    L5:
        b0.o().b(r3, r0);
    }
}
