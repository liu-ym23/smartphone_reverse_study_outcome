package com.bytedance.ies.bullet.preloadv2.cache;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends PreloadItem {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PreloadResourceType f247699v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f247700w;

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final void b() {
        this.f247700w = null;
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final PreloadResourceType c() {
        return this.f247699v;
    }

    public c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        super(r100);
        this.f247699v = PreloadResourceType.Font;
    }
}
