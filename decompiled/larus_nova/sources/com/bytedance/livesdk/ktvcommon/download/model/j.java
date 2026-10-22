package com.bytedance.livesdk.ktvcommon.download.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class j extends MusicCacheFactory {
    @Override // com.bytedance.livesdk.ktvcommon.download.model.MusicCacheFactory
    public MusicType getType() {
        return MusicType.MV;
    }

    public j(p r100, yk6.d r101, yk6.c r102) {
        Intrinsics.checkNotNullParameter(r100, "storageConfig");
        Intrinsics.checkNotNullParameter(r101, "fileOperator");
        Intrinsics.checkNotNullParameter(r102, "fileExecutor");
        super(r100, r101, r102);
    }
}
