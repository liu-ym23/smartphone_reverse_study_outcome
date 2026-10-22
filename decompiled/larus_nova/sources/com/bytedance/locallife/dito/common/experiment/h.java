package com.bytedance.locallife.dito.common.experiment;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h extends PoiLynxOptExperiment<com.bytedance.locallife.dito.common.data.c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f257355d = null;

    static {
        f257355d = new h();
    }

    @Override // com.bytedance.locallife.dito.common.experiment.PoiLynxOptExperiment
    public final String c() {
        return "poi_dito_image_prefetch_to_mem";
    }

    public h() {
        super(com.bytedance.locallife.dito.common.data.c.class);
    }

    @JvmStatic
    public static final com.bytedance.locallife.dito.common.data.c d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        return f257355d.b(r100, null);
    }
}
