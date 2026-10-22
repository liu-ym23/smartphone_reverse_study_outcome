package com.bytedance.ies.bullet.preloadv2.cache;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class j extends ByteArrayPreloadItem {
    public final int A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final PreloadResourceType f247715z;

    @Override // com.bytedance.ies.bullet.preloadv2.cache.ByteArrayPreloadItem, com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final PreloadResourceType c() {
        return this.f247715z;
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.ByteArrayPreloadItem, com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final int e() {
        return this.A;
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resUrl");
        PreloadResourceType r101 = PreloadResourceType.Template;
        super(r100, r101);
        this.f247715z = r101;
        this.A = 1;
    }

    public j(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        super(r100);
        this.f247715z = PreloadResourceType.Template;
        this.A = 1;
    }
}
