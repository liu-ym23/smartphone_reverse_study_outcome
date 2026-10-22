package com.bytedance.lighten.loader;

import android.app.ActivityManager;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.MemoryCacheUtil;

/* JADX INFO: loaded from: classes20.dex */
public final class d implements Supplier<MemoryCacheParams> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActivityManager f254717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f254718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f254719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f254720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f254721e;

    public final int a() {
        int r100 = this.f254718b;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        int r101 = Math.min(this.f254717a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (r101 >= 33554432) goto L10;
        return 4194304;
    L10:
        if (r101 >= 67108864) goto L14;
        return BmLocated.ALIGN_LEFT_BOTTOM;
    L14:
        return r101 / 8;
    }

    @Override // com.facebook.common.internal.Supplier
    public final MemoryCacheParams get() {
        MemoryCacheUtil.setOptReuseBitmapCache(this.f254720d);
        if (this.f254719c <= 0) goto L6;
        return new MemoryCacheParams(this.f254721e, a(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, this.f254719c, this.f254720d);
    L6:
        return new MemoryCacheParams(this.f254721e, a(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, false, 0, this.f254720d);
    }

    public d(ActivityManager r100, int r101, int r102, boolean r103, int r104) {
        this.f254719c = 0;
        this.f254720d = false;
        this.f254721e = 0;
        this.f254717a = r100;
        this.f254718b = r101;
        this.f254719c = r102;
        this.f254720d = r103;
        this.f254721e = r104;
    }
}
