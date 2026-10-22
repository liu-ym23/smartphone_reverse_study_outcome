package com.bytedance.android.livesdk.ktvimpl.multichorus;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        ALogger.i("MultiChorus_".concat(r1), r2);
    }
}
