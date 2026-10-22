package com.bytedance.locallife.biz.base.cube;

import android.net.Uri;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.i.ICubeCustomizeInterceptor;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements ICubeCustomizeInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f256540a = null;

    static {
        f256540a = new h();
    }

    public h() {
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeCustomizeInterceptor
    public final Float getFontScale(CubeConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "cubeConfig");
        HostServiceUtilsKt.z().b(r100);
        return null;
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeCustomizeInterceptor
    public final Uri interceptSchema(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "originSchemaUri");
        return HostServiceUtilsKt.Z().interceptSchema(r100);
    }

    @Override // com.bytedance.locallife.cube.api.i.ICubeCustomizeInterceptor
    public final String appendCacheUniqueKey(CubeInternalSchemaModel r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaModel");
        Intrinsics.checkNotNullParameter(r101, "schemaUri");
        return HostServiceUtilsKt.Z().appendCacheUniqueKey(r100, r101);
    }
}
