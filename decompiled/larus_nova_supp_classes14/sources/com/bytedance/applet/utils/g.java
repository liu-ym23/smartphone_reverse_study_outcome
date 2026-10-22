package com.bytedance.applet.utils;

import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements a3 {
    public final /* synthetic */ d a;

    public g(d r1) {
        this.a = r1;
    }

    public final void a(LocationResult r2, Integer r3, GeoLocationInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "code");
        d r5 = this.a;
        if (r2 != LocationResult.SUCCESS) goto L5;
        boolean r6 = true;
    L6:
        d.a.a(r5, r6, false, false, 6);
        return;
    L5:
        r6 = false;
        goto L6
    }
}
