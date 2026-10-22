package com.bytedance.applet.impl;

import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.z2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements z2 {
    public final /* synthetic */ r4.m a;
    public final /* synthetic */ q b;

    public r(com.bytedance.ai.bridge.method.system.location.g r1, q r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(LocationResult r13, GeoLocationInfo r14) {
        Intrinsics.checkNotNullParameter(r13, "code");
        Intrinsics.checkNotNullParameter(r14, "location");
        r4.m r15 = this.a;
        this.b.getClass();
        Float r0 = Float.valueOf(r14.getNaviAccuracy());
        float r1 = r0.floatValue();
        Float r10 = Float.valueOf(0.0f);
        if (r1 <= 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        float r3 = r0.floatValue();
    L12:
        double r4 = r14.getLatitude();
        double r5 = r14.getLongitude();
        float r6 = r14.getSpeed();
        double r7 = r14.getAltitude();
        String r11 = r14.getCity();
        r15.a(new r4.n(Double.valueOf(r4), Double.valueOf(r5), Float.valueOf(r6), Float.valueOf(r3), Double.valueOf(r7), r10, r10, r11));
        return;
    L11:
        r3 = r14.getRadius();
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public final void onError(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "code");
        Intrinsics.checkNotNullParameter(r4, "msg");
        r4.m r0 = this.a;
        if (StringsKt.isBlank(r4) == true) goto L6;
        r3 = r4;
    L6:
        r0.b(r3);
    }
}
