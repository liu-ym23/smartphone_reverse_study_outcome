package com.bytedance.ies.bullet.preloadv2.cache;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends ByteArrayPreloadItem {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final PreloadResourceType f247698z;

    @Override // com.bytedance.ies.bullet.preloadv2.cache.ByteArrayPreloadItem, com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final PreloadResourceType c() {
        return this.f247698z;
    }

    public b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        super(r100);
        this.f247698z = PreloadResourceType.ExternalJs;
    }
}
