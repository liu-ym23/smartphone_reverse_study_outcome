package com.bytedance.android.livesdk.log;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final String a;
    public final String b;

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        b0 r0 = b0.o();
        String r1 = this.b;
        String r6 = this.a + ' ' + r5;
        r0.getClass();
        com.bytedance.android.live.core.log.g.a(r1, r6);
    }

    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        b0 r0 = b0.o();
        String r1 = this.b;
        String r6 = this.a + ' ' + r5;
        r0.getClass();
        com.bytedance.android.live.core.log.g.i(r1, r6);
    }

    public b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        this.b = r2;
        if (r3 != null) goto L5;
        r3 = "[" + Integer.toHexString(hashCode()) + ']';
    L5:
        this.a = r3;
    }
}
