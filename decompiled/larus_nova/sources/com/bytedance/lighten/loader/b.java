package com.bytedance.lighten.loader;

import android.app.ActivityManager;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;

/* JADX INFO: loaded from: classes20.dex */
public final class b extends DefaultBitmapMemoryCacheParamsSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f254710a;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier, com.facebook.common.internal.Supplier
    public final MemoryCacheParams get() {
        return new MemoryCacheParams(this.f254710a.f254713b, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override // com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier, com.facebook.common.internal.Supplier
    public final /* bridge */ /* synthetic */ MemoryCacheParams get() {
        return get();
    }

    public b(c r100, ActivityManager r101) {
        this.f254710a = r100;
        super(r101);
    }
}
