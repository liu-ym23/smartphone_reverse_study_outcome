package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w {
    public static final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        ALogger.i("vs_concert_dynamic", "concertDynamicLog, " + r2 + ", " + r3);
    }

    public static final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        ALogger.i("vs_concert_stage", "concertStageLog, " + r2 + ", " + r3);
    }
}
