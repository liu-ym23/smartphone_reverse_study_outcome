package com.bytedance.navigation.kmp.handler.tracker;

import com.bytedance.bdnavigationsdk.c0;
import com.bytedance.bdnavigationsdk.contants.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h extends a {
    public final void e() {
        Map<String, Object> r100 = c();
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        i("bd_nav_sdk_kmp_continue_location_first", r100);
    }

    public final void f() {
        Map<String, Object> r100 = c();
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        i("bd_nav_sdk_kmp_init", r100);
    }

    public final void g() {
        Map<String, Object> r100 = c();
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        i("bd_nav_sdk_kmp_route_plan", r100);
    }

    public final void h() {
        Map<String, Object> r100 = c();
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        i("bd_nav_sdk_kmp_start", r100);
    }

    public h() {
    }

    public static void i(String r100, Map r101) {
        Map<String, ? extends Object> r102 = MapsKt.toMutableMap(r101);
        if (r102 != null) goto L5;
        r102 = new LinkedHashMap();
    L5:
        int r103 = w27.b.f558037a;
        r102.put("nav_sdk_version", "0.0.1-rc.44");
        int r104 = c0.f200006a;
        Intrinsics.areEqual("0.0.1-rc.44", Constants.Unspecified.getValue());
        r102.put("engine_sdk_version", "0.0.1-rc.44");
        e37.i r105 = n.f265930a.getValue();
        if (r105 == null) goto L9;
        r105.a(r100, r102);
        return;
    }
}
