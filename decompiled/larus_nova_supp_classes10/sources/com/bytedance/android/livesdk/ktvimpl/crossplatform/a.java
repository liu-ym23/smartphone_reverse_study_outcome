package com.bytedance.android.livesdk.ktvimpl.crossplatform;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "msg");
        ALogger.i("ttlive_ktv_karaoke_dynamic_log", "tag , " + r2 + " ; msg, " + r3);
    }
}
