package com.bytedance.applet.impl;

import android.content.ClipData;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s0 implements r4.k {

    public static final class a implements a3 {
        public final /* synthetic */ r4.c a;
        public final /* synthetic */ s0 b;

        /* JADX INFO: renamed from: com.bytedance.applet.impl.s0$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0056a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[LocationResult.values().length];
                r0[LocationResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[LocationResult.NO_PERMISSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[LocationResult.NO_GPS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[LocationResult.TIME_OUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public a(r4.c r1, s0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(LocationResult r12, Integer r13, GeoLocationInfo r14) {
            Intrinsics.checkNotNullParameter(r12, "code");
            int r15 = C0056a.a[r12.ordinal()];
            boolean r1 = false;
            int r2 = 0;
            int r3 = 0;
            int r4 = 0;
            int r5 = 0;
            if (r15 != 1) goto L5;
            r4.c r16 = this.a;
            double r6 = 0.0d;
            if (r14 == null) goto L29;
            double r7 = r14.getLatitude();
        L30:
            if (r14 == null) goto L32;
            r6 = r14.getLongitude();
        L32:
            double r8 = r6;
            Float r0 = null;
            if (r14 == null) goto L35;
            String r9 = Long.valueOf(r14.getGpsTime()).toString();
        L36:
            if (r14 == null) goto L38;
            Float r10 = Float.valueOf(r14.getSpeed());
        L39:
            if (r14 == null) goto L41;
            r0 = Float.valueOf(r14.getRadius());
        L41:
            if (r14 == null) goto L43;
            r1 = r14.isLightLocation();
        L43:
            r16.b(new r4.d(r7, r8, r9, r10, r0, Boolean.valueOf(r1)));
            return;
        L38:
            r10 = null;
            goto L39
        L35:
            r9 = null;
            goto L36
        L29:
            r7 = 0.0d;
            goto L30
        L5:
            if (r15 != 2) goto L7;
            r4.c r17 = this.a;
            this.b.getClass();
            if (r13 == null) goto L25;
            r5 = r13.intValue();
        L25:
            r17.a("location_permission_denied", r5);
            return;
        L7:
            if (r15 != 3) goto L9;
            r4.c r18 = this.a;
            this.b.getClass();
            if (r13 == null) goto L21;
            r4 = r13.intValue();
        L21:
            r18.a("location_service_disabled", r4);
            return;
        L9:
            if (r15 == 4) goto L14;
            r4.c r19 = this.a;
            this.b.getClass();
            if (r13 == null) goto L13;
            r2 = r13.intValue();
        L13:
            r19.a("location_fail", r2);
            return;
        L14:
            r4.c r110 = this.a;
            this.b.getClass();
            if (r13 == null) goto L17;
            r3 = r13.intValue();
        L17:
            r110.a("location_timeout", r3);
        }
    }

    public s0() {
    }

    public final boolean a(Context r2, e3.d r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r5 == null) goto L5;
        r5.d0();
        return com.larus.home.impl.sdk.i1.a.h(r2, "bpea-applet-frontend");
    L5:
        return false;
    }

    public final ClipData c(Context r2, e3.d r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r5 == null) goto L5;
        r5.d0();
        return com.larus.home.impl.sdk.i1.a.e(r2, "bpea-applet-frontend");
    L5:
        return null;
    }

    public final void b(Context r2, e3.d r3, String r4, ClipData r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        Intrinsics.checkNotNullParameter(r5, "clipData");
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L6;
        r6.d0();
        com.larus.home.impl.sdk.i1.a.i(r2, r5, "bpea-applet-frontend");
        return;
    }

    public final Sensor e(SensorManager r2, e3.d r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "sensorManager");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        return r2.getDefaultSensor(r5);
    }

    public final void d(Context r13, Integer r14, Long r15, String r16, Long r17, r4.c r18, Boolean r19, String r20) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r18, "callback");
        com.larus.platform.service.m.a.c(LocateScene.APPLET, CoordinateType.GCJ_O2, r14, r15, r16, r17, new a(r18, this), r19, r20);
    }
}
