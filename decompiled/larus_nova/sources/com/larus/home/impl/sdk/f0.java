package com.larus.home.impl.sdk;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.larus.api.CoordinateType;
import com.larus.api.LocationService;
import com.larus.platform.api.x2;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import hq9.a3;
import hq9.y2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class f0 implements x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f346174a = null;

    static {
        f346174a = new f0();
    }

    public f0() {
    }

    @Override // com.larus.platform.api.x2
    public final boolean c() {
        return LocationService.f286873a.c();
    }

    @Override // com.larus.platform.api.x2
    public final void g() {
        Intrinsics.checkNotNullParameter("dora_location_poll_disabled", "reason");
        LocationService.f286873a.t("dora_location_poll_disabled");
    }

    @Override // com.larus.platform.api.x2
    public final void b(y2 r100) {
        LocationService.f286873a.b(r100);
    }

    @Override // com.larus.platform.api.x2
    public final Dialog d(FragmentActivity r100) {
        return LocationService.f286873a.d(r100);
    }

    @Override // com.larus.platform.api.x2
    public final GeoLocationInfo e(long r100) {
        return LocationService.f286873a.e(r100);
    }

    @Override // com.larus.platform.api.x2
    public final void a(LocateScene r100, a3 r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        LocationService.a.a(LocationService.f286873a, r100, null, r101, 26);
    }

    @Override // com.larus.platform.api.x2
    public final void f(LocateScene r100, com.bytedance.applet.utils.g r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        LocationService.f286873a.q(r100, CoordinateType.WGS_84, r110, r111, null, null);
    }
}
