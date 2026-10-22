package com.bytedance.ies.bullet.preloadv2.cache;

import com.lynx.tasm.TemplateBundle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class ByteArrayPreloadItem extends PreloadItem {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PreloadResourceType f247666v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public byte[] f247667w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TemplateBundle f247668x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f247669y;

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public final void b() {
        this.f247667w = null;
        this.f247668x = null;
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public int e() {
        return ((Number) this.f247669y.getValue()).intValue();
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadItem
    public PreloadResourceType c() {
        return this.f247666v;
    }

    public ByteArrayPreloadItem(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        super(r100);
        this.f247666v = PreloadResourceType.Template;
        this.f247669y = LazyKt.lazy(new ByteArrayPreloadItem$size$2(this));
    }

    public ByteArrayPreloadItem(String r100, PreloadResourceType r101) {
        Intrinsics.checkNotNullParameter(r100, "resUrl");
        Intrinsics.checkNotNullParameter(r101, "type");
        super(r100, r101);
        this.f247666v = PreloadResourceType.Template;
        this.f247669y = LazyKt.lazy(new ByteArrayPreloadItem$size$2(this));
    }
}
