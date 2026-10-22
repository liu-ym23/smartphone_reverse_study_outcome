package com.bytedance.lighten.loader;

import androidx.collection.SieveCacheKt;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;

/* JADX INFO: loaded from: classes20.dex */
public final class f implements Supplier<MemoryCacheParams> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f254731a;

    @Override // com.facebook.common.internal.Supplier
    public final MemoryCacheParams get() {
        int r100 = this.f254731a;
        if (r100 <= 0) goto L5;
        int r101 = r100;
    L12:
        int r102 = r101;
        MemoryCacheParams r103 = new MemoryCacheParams(r102, Integer.MAX_VALUE, r101, Integer.MAX_VALUE, r101 / 8);
        r103.mCacheType = 1;
        return r103;
    L5:
        int r104 = (int) Math.min(Runtime.getRuntime().maxMemory(), SieveCacheKt.NodeLinkMask);
        if (r104 >= 16777216) goto L9;
        r101 = 1048576;
        goto L12
    L9:
        if (r104 >= 33554432) goto L11;
        r101 = 2097152;
        goto L12
    L11:
        r101 = 4194304;
        goto L12
    }

    public f(int r100) {
        this.f254731a = r100;
    }
}
