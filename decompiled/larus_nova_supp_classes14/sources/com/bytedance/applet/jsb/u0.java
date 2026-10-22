package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.LocationResult;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u0 extends bx7.c {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LocationResult.values().length];
            r0[LocationResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LocationResult.NO_PERMISSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final String getName() {
        return "applet.startLocation";
    }

    public u0() {
    }

    public final void a(dx7.b r7, ux7.d.d r8, IvyBridgePlatformType r9) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        Intrinsics.checkNotNullParameter(r9, "type");
        int r10 = b.a[com.larus.platform.service.m.a.g(5000, CoordinateType.WGS_84, null, new v0()).ordinal()];
        if (r10 != 1) goto L5;
        r8.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1)}));
        return;
    L5:
        if (r10 == 2) goto L7;
        r8.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 0)}));
        return;
    L7:
        r8.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", -1)}));
    }
}
