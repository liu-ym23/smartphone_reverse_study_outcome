package com.bytedance.ies.bullet.preloadv2.cache;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends ByteArrayPreloadItem {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final PreloadResourceType f247697z;

    @Override // com.bytedance.ies.bullet.preloadv2.cache.ByteArrayPreloadItem, com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final PreloadResourceType c() {
        return this.f247697z;
    }

    public a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        super(r100);
        this.f247697z = PreloadResourceType.DynamicComponent;
    }
}
