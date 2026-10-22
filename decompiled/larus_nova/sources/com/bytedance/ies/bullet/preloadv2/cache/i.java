package com.bytedance.ies.bullet.preloadv2.cache;

import com.bytedance.ies.bullet.preloadv2.PreloadV2;

/* JADX INFO: loaded from: classes19.dex */
public final class i extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f247714d = null;

    static {
        f247714d = new i();
    }

    public i() {
        boolean r100 = PreloadV2.f247628a;
        super(PreloadV2.f247629b);
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.f
    public final g b(int r100) {
        if (r100 > 0) goto L6;
        r100 = 10;
    L6:
        return new g("模版缓存池", r100);
    }
}
