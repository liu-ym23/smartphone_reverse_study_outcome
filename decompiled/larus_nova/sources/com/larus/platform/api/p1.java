package com.larus.platform.api;

import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public interface p1 {
    LocationResult a(CoordinateType r100, com.bytedance.applet.impl.r r101, String r102);

    void b(LocateScene r100, CoordinateType r101, hq9.a3 r102);

    void c(LocateScene r100, CoordinateType r101, Integer r102, Long r103, String r104, Long r105, com.bytedance.applet.impl.s0.a r106, Boolean r107, String r108);

    void d(String r100);

    void e(LocateScene r100, CoordinateType r101, Long r102, com.bytedance.applet.aibridge.navi.a r103);

    void f(String r100);

    LocationResult g(long r100, CoordinateType r101, JSONObject r102, hq9.z2 r103);

    LocationResult h(long r100, CoordinateType r101, com.bytedance.applet.aibridge.navigation.g0 r102, String r103, String r104);
}
