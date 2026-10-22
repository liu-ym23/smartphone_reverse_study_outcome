package com.larus.platform.service;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class l1 implements com.larus.platform.api.x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l1 f365760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365761b = null;

    public l1() {
    }

    static {
        f365760a = new l1();
        f365761b = LazyKt.lazy(new k1());
    }

    public static com.larus.platform.api.x2 h() {
        return (com.larus.platform.api.x2) f365761b.getValue();
    }

    @Override // com.larus.platform.api.x2
    public final void g() {
        Intrinsics.checkNotNullParameter("dora_location_poll_disabled", "reason");
        com.larus.platform.api.x2 r100 = h();
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // com.larus.platform.api.x2
    public final boolean c() {
        com.larus.platform.api.x2 r100 = h();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.c();
    }

    @Override // com.larus.platform.api.x2
    public final void b(hq9.y2 r100) {
        com.larus.platform.api.x2 r101 = h();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.larus.platform.api.x2
    public final Dialog d(FragmentActivity r100) {
        com.larus.platform.api.x2 r101 = h();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.d(r100);
    }

    @Override // com.larus.platform.api.x2
    public final GeoLocationInfo e(long r100) {
        com.larus.platform.api.x2 r101 = h();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.e(r100);
    }

    @Override // com.larus.platform.api.x2
    public final void a(LocateScene r100, hq9.a3 r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        com.larus.platform.api.x2 r102 = h();
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.x2
    public final void f(LocateScene r100, com.bytedance.applet.utils.g r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        com.larus.platform.api.x2 r103 = h();
        if (r103 == null) goto L6;
        r103.f(r100, r101, r102);
        return;
    }
}
