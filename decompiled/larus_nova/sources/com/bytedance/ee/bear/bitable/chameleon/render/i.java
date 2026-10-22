package com.bytedance.ee.bear.bitable.chameleon.render;

import com.bytedance.ee.bear.bitable.chameleon.render.cache.BitableCacheBlockType;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f209796a = null;

    static {
        int[] r100 = new int[BitableCacheBlockType.values().length];
        r100[BitableCacheBlockType.Default.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L19:
        r100[BitableCacheBlockType.Table.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L27:
        r100[BitableCacheBlockType.Dashboard.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L21:
        r100[BitableCacheBlockType.LinkedDocx.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
    L23:
        r100[BitableCacheBlockType.Unsupported.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
    L17:
        r100[BitableCacheBlockType.Bitable.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
    L9:
        f209796a = r100;
    }
}
