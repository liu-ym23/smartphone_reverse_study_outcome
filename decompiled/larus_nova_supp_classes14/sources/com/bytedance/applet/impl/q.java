package com.bytedance.applet.impl;

import android.content.Context;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.LocationResult;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements r4.e {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LocationResult.values().length];
            r0[LocationResult.NO_PERMISSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[LocationResult.TIME_OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[LocationResult.NO_GPS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[LocationResult.REACH_LIMITATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[LocationResult.INTERVAL_NOT_REACH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[LocationResult.NO_DATA.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[LocationResult.STOP_POLL_IN_BACKGROUND.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[LocationResult.NOT_INITIALIZED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[LocationResult.NOT_SUPPORT_CONTINUOUS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[LocationResult.NO_IMPL_MODULE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[LocationResult.SDK_INTERNAL_ERROR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[LocationResult.SUCCESS.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    static {
    }

    public q() {
    }

    public final r4.l c(e3.d r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeName");
        Intrinsics.checkNotNullParameter(r4, "identifier");
        com.larus.platform.service.m r5 = com.larus.platform.service.m.a;     // Catch: Exception -> L9
        com.larus.platform.api.p1 r6 = com.larus.platform.service.m.i();     // Catch: Exception -> L9
        if (r6 != null) goto L7;
        r4.l r7 = r4.l.c;     // Catch: Exception -> L9
        return r4.l.a.a("location_service_not_available", f3.a.g);
    L7:
        r6.d(r4);     // Catch: Exception -> L9
        return r4.l.c;
    L9:
        e = move-exception;
        r4.l r8 = r4.l.c;
        return r4.l.a.a("internal_error: " + e.getMessage(), f3.a.f);
    }

    public final void d(Context r2, e3.d r3, String r4, com.bytedance.ai.bridge.method.system.location.b r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        Intrinsics.checkNotNullParameter(r5, "callback");
        r5.a();
    }

    public final void b(Context r2, e3.d r3, String r4, r4.o r5, com.bytedance.ai.bridge.method.system.location.i r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "callback");
        r6.a();
    }

    public final r4.l a(Context r2, e3.d r3, String r4, String r5, String r6, com.bytedance.ai.bridge.method.system.location.g r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "identifier");
        Intrinsics.checkNotNullParameter(r7, "callback");
        com.larus.platform.service.m r8 = com.larus.platform.service.m.a;     // Catch: Exception -> L27
        com.larus.platform.api.p1 r9 = com.larus.platform.service.m.i();     // Catch: Exception -> L27
        if (r9 != null) goto L8;
        r4.l r10 = r4.l.c;     // Catch: Exception -> L27
        return r4.l.a.a("location_service_not_available", f3.a.g);
    L8:
        if (Intrinsics.areEqual(r5.toLowerCase(Locale.US), "wgs84") == false) goto L10;
        CoordinateType r11 = CoordinateType.WGS_84;     // Catch: Exception -> L27
    L11:
        LocationResult r12 = r9.a(r11, new r(r7, this), r6);     // Catch: Exception -> L27
        if (r12 != LocationResult.SUCCESS) goto L17;
        return r4.l.c;
    L17:
        switch(b.a[r12.ordinal()]) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L22;
            case 5: goto L22;
            case 6: goto L22;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L21;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L31;
            default: goto L26;
        };
    L20:
        r4.l r13 = r4.l.c;     // Catch: Exception -> L27
        return r4.l.a.a("location_start_failed: " + r12.getMessage(), f3.a.f);
    L21:
        r4.l r14 = r4.l.c;     // Catch: Exception -> L27
        return r4.l.a.a("location_sdk_not_initialized", f3.a.g);
    L22:
        r4.l r15 = r4.l.c;     // Catch: Exception -> L27
        String r16 = "location_start_failed: " + r12.getMessage();     // Catch: Exception -> L27
        f3.a.a r17 = f3.a.c;     // Catch: Exception -> L27
        f3.a r18 = f3.b.a;     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r17, "<this>");     // Catch: Exception -> L27
        return r4.l.a.a(r16, f3.b.j);
    L23:
        r4.l r19 = r4.l.c;     // Catch: Exception -> L27
        String r20 = "location_start_failed: " + r12.getMessage();     // Catch: Exception -> L27
        f3.a.a r21 = f3.a.c;     // Catch: Exception -> L27
        f3.a r22 = f3.b.a;     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r21, "<this>");     // Catch: Exception -> L27
        return r4.l.a.a(r20, f3.b.k);
    L24:
        r4.l r23 = r4.l.c;     // Catch: Exception -> L27
        f3.a.a r24 = f3.a.c;     // Catch: Exception -> L27
        f3.a r25 = f3.b.a;     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r24, "<this>");     // Catch: Exception -> L27
        return r4.l.a.a("no_location_permission", f3.b.i);
    L26:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L27
    L31:
        return r4.l.c;
    L10:
        r11 = CoordinateType.GCJ_O2;     // Catch: Exception -> L27
    L27:
        e = move-exception;
        r4.l r26 = r4.l.c;
        return r4.l.a.a("internal_error: " + e.getMessage(), f3.a.f);
    }
}
