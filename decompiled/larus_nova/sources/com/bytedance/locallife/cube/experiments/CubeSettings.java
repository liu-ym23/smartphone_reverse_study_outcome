package com.bytedance.locallife.cube.experiments;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class CubeSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f257202a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CubeErrorIgnoreConfig f257203b = null;

    static {
        f257202a = LazyKt.lazy(CubeSettings$VALUE$2.INSTANCE);
        f257203b = new CubeErrorIgnoreConfig(CollectionsKt.listOf(new String[]{"groupon_lynx_detail_takeout_components", "groupon_lynx_detail_components", "groupon_lynx_detail_components_secondary"}), CollectionsKt.listOf(new String[]{"delivery_main_info_group/template.js", "main_info_group/template.js", "mini_main_info/template.js"}), 1101, "ReferenceError: NativeModules is not defined");
    }

    public static CubeSetting b() {
        return (CubeSetting) f257202a.getValue();
    }

    public static String a() {
        String r100 = b().getCubeBid();
        if (r100 != null) goto L6;
        return "bid_poi";
    L6:
        return r100;
    }
}
