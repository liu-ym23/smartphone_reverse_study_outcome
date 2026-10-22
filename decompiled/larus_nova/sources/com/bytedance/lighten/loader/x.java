package com.bytedance.lighten.loader;

import android.app.ActivityManager;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;

/* JADX INFO: loaded from: classes20.dex */
public final class x implements Supplier<MemoryCacheParams> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActivityManager f254784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f254785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f254786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f254787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f254788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f254789f;

    @Override // com.facebook.common.internal.Supplier
    public final MemoryCacheParams get() {
        int r100 = 0;
        if (this.f254788e <= 0) goto L5;
        boolean r101 = true;
    L6:
        int r102 = this.f254785b;
        if (r102 > 0) goto L16;
        int r103 = Math.min(this.f254784a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (r103 >= 33554432) goto L13;
        int r104 = 4194304;
    L17:
        int r105 = this.f254786c;
        if (r105 <= 0) goto L20;
        int r106 = r105;
    L21:
        int r107 = this.f254787d;
        if (r107 <= 0) goto L24;
        int r108 = r107;
    L26:
        if (r101 == false) goto L28;
        r100 = this.f254788e;
    L28:
        int r109 = r104;
        int r110 = r106;
        int r111 = r108;
        int r112 = r100;
        return new MemoryCacheParams(5, r109, r110, r111, Integer.MAX_VALUE, Integer.MAX_VALUE, r101, r112, this.f254789f);
    L24:
        r108 = Integer.MAX_VALUE;
        goto L26
    L20:
        r106 = 256;
        goto L21
    L13:
        if (r103 >= 67108864) goto L15;
        r104 = BmLocated.ALIGN_LEFT_BOTTOM;
        goto L17
    L15:
        r102 = r103 / 4;
    L16:
        r104 = r102;
        goto L17
    L5:
        r101 = false;
        goto L6
    }

    public x(ActivityManager r100, int r101, int r102, int r103, int r104, boolean r105) {
        this.f254788e = 0;
        this.f254789f = false;
        this.f254784a = r100;
        this.f254785b = r101;
        this.f254786c = r102;
        this.f254787d = r103;
        this.f254788e = r104;
        this.f254789f = r105;
    }
}
