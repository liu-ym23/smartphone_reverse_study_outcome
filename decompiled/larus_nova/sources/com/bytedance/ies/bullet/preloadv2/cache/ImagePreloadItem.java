package com.bytedance.ies.bullet.preloadv2.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class ImagePreloadItem extends PreloadItem {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PreloadResourceType f247670v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CloseableReference<Bitmap> f247671w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f247672x;

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final void b() {
        CloseableReference<Bitmap> r100 = this.f247671w;
        if (r100 == null) goto L5;
        r100.close();
    L5:
        this.f247671w = null;
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final int e() {
        return ((Number) this.f247672x.getValue()).intValue();
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final PreloadResourceType c() {
        return this.f247670v;
    }

    public ImagePreloadItem(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        super(r100);
        this.f247670v = PreloadResourceType.Image;
        this.f247672x = LazyKt.lazy(new ImagePreloadItem$size$2(this));
    }
}
