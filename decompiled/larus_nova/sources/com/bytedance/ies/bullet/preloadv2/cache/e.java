package com.bytedance.ies.bullet.preloadv2.cache;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends PreloadItem {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PreloadResourceType f247702v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f247703w;

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final PreloadResourceType c() {
        return this.f247702v;
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final int e() {
        return this.f247703w;
    }

    public e(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        super(r100);
        this.f247702v = PreloadResourceType.Lottie;
        this.f247703w = 1;
    }
}
