package com.bytedance.lighten.core;

import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum CacheChoice extends Enum<CacheChoice> {
    public static final CacheChoice CUSTOM = null;
    public static final CacheChoice DEFAULT = null;
    public static final CacheChoice SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheChoice[] f254600a = null;

    static {
        CacheChoice r100 = new CacheChoice("CUSTOM", 0);
        CUSTOM = r100;
        CacheChoice r101 = new CacheChoice("SMALL", 1);
        SMALL = r101;
        CacheChoice r102 = new CacheChoice("DEFAULT", 2);
        DEFAULT = r102;
        f254600a = new CacheChoice[]{r100, r101, r102};
    }

    public static CacheChoice[] values() {
        return (CacheChoice[]) f254600a.clone();
    }

    public static CacheChoice valueOf(String r100) {
        return (CacheChoice) a.a(CacheChoice.class, r100);
    }

    public CacheChoice(String r100, int r101) {
        super(r100, r101);
    }
}
