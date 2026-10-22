package com.larus.platform.service;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class m implements com.larus.platform.api.p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f365762a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365763b = null;

    public m() {
    }

    static {
        f365762a = new m();
        f365763b = LazyKt.lazy(new l());
    }

    public static com.larus.platform.api.p1 i() {
        return (com.larus.platform.api.p1) f365763b.getValue();
    }

    @Override // com.larus.platform.api.p1
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter("jsb_stop_location", "reason");
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        com.larus.platform.api.p1 r101 = i();
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // com.larus.platform.api.p1
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        com.larus.platform.api.p1 r101 = i();
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.larus.platform.api.p1
    public final LocationResult a(CoordinateType r100, com.bytedance.applet.impl.r r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "coordinateType");
        Intrinsics.checkNotNullParameter(r102, LocationMonitorConst.IDENTIFIER);
        com.larus.platform.api.p1 r103 = i();
        if (r103 == null) goto L7;
        LocationResult r104 = r103.a(r100, r101, r102);
        if (r104 == null) goto L7;
        return r104;
    L7:
        return LocationResult.NO_IMPL_MODULE;
    }

    @Override // com.larus.platform.api.p1
    public final void b(LocateScene r100, CoordinateType r101, hq9.a3 r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "coordinateType");
        com.larus.platform.api.p1 r103 = i();
        if (r103 == null) goto L6;
        r103.b(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.p1
    public final void e(LocateScene r100, CoordinateType r101, Long r102, com.bytedance.applet.aibridge.navi.a r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "coordinateType");
        com.larus.platform.api.p1 r104 = i();
        if (r104 == null) goto L6;
        r104.e(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.platform.api.p1
    public final LocationResult g(long r100, CoordinateType r110, JSONObject r111, hq9.z2 r112) {
        Intrinsics.checkNotNullParameter(r110, "coordinateType");
        com.larus.platform.api.p1 r101 = i();
        if (r101 == null) goto L7;
        LocationResult r102 = r101.g(r100, r110, r111, r112);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return LocationResult.NO_IMPL_MODULE;
    }

    @Override // com.larus.platform.api.p1
    public final LocationResult h(long r100, CoordinateType r110, com.bytedance.applet.aibridge.navigation.g0 r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "coordinateType");
        Intrinsics.checkNotNullParameter(r112, LocationMonitorConst.IDENTIFIER);
        com.larus.platform.api.p1 r101 = i();
        if (r101 == null) goto L7;
        LocationResult r102 = r101.h(r100, r110, r111, r112, r113);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return LocationResult.NO_IMPL_MODULE;
    }

    @Override // com.larus.platform.api.p1
    public final void c(LocateScene r110, CoordinateType r111, Integer r112, Long r113, String r114, Long r115, com.bytedance.applet.impl.s0.a r116, Boolean r117, String r210) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r111, "coordinateType");
        com.larus.platform.api.p1 r100 = i();
        if (r100 == null) goto L6;
        r100.c(r110, r111, r112, r113, r114, r115, r116, r117, r210);
        return;
    }
}
