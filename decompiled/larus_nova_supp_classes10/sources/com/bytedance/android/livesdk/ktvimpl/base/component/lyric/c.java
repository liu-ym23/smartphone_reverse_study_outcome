package com.bytedance.android.livesdk.ktvimpl.base.component.lyric;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        ALogger.i("ttlive_ktv_karaoke_lyric", "lyricLog , " + r2 + ", " + r3);
    }
}
