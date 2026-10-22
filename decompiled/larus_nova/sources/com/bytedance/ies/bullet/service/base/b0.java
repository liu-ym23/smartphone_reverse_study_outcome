package com.bytedance.ies.bullet.service.base;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f247780a = null;

    static {
        int[] r100 = new int[CacheType.values().length];
        r100[CacheType.REUSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r100[CacheType.PRE_RENDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f247780a = r100;
    }
}
