package com.bytedance.locallife.poi.poidetail.container;

import android.app.Activity;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static CubeConfig a(Activity r110, final String r111, final Map r112) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter("cube_poi_detail", "scene");
        final String r100 = "poi_detail_ng";
        Intrinsics.checkNotNullParameter("poi_detail_ng", "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "lynxModuleMap");
        CubeConfig r101 = new CubeConfig(r110, "cube_poi_detail", null, null, null, 28, null);
        cp6.a.a(r101, new ConfigKt$commonPoiCubeConfig$1(r100, r111));
        cp6.a.b(r101, new ConfigKt$commonPoiCubeConfig$2(r112));
        cp6.a.c(r101, ConfigKt$commonPoiCubeConfig$3.INSTANCE);
        return r101;
    }
}
