package com.bytedance.android.livesdk.log;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class BroadcastLogInterceptor implements d0 {
    public final Lazy a;

    public BroadcastLogInterceptor() {
        this.a = LazyKt.lazy(BroadcastLogInterceptor$blockTagList$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.log.d0
    public final boolean a(String r5) {
        Intrinsics.checkNotNullParameter(r5, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter("loadStickerByEffectId", "message");
        if (com.bytedance.android.live.core.utils.v.b() == false) goto L9;
        if (StringsKt.startsWith$default(r5, "ttlive_anchor", false, 2, null) == true) goto L9;
        ALogger.w(r5, "TAG not start with ttlive_anchor");
        return false;
    L9:
        if ((!((List) this.a.getValue()).isEmpty()) == true) goto L11;
    L13:
        return true;
    L11:
        if (((List) this.a.getValue()).contains(r5) == false) goto L13;
        return false;
    }
}
