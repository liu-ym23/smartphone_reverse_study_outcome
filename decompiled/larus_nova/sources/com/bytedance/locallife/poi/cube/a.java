package com.bytedance.locallife.poi.cube;

import android.app.Activity;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f262354a = 0;

    static {
    }

    public a() {
    }

    public static CubeConfig a(Activity r110, String r111, final String r112, int r113) {
        if ((r113 & 4) == 0) goto L5;
        r112 = "poi_detail";
    L5:
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r112, "enterFrom");
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "scene");
        CubeConfig r114 = new CubeConfig(r110, r111, null, null, null, 28, null);
        final String r115 = null;
        cp6.a.a(r114, new PreDefinedPreCreateBuilder$getPoiDetailCubeConfig$1(r112, r115));
        cp6.a.b(r114, PreDefinedPreCreateBuilder$getPoiDetailCubeConfig$2.INSTANCE);
        cp6.a.c(r114, PreDefinedPreCreateBuilder$getPoiDetailCubeConfig$3.INSTANCE);
        return r114;
    }
}
