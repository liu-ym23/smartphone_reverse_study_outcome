package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ResourceFrom;", "", "GECKO", "BUILTIN", "CDN", "LOCAL_FILE", "PRELOAD", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ResourceFrom extends Enum<ResourceFrom> {
    public static final ResourceFrom BUILTIN = null;
    public static final ResourceFrom CDN = null;
    public static final ResourceFrom GECKO = null;
    public static final ResourceFrom LOCAL_FILE = null;
    public static final ResourceFrom PRELOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceFrom[] f247777a = null;

    public static ResourceFrom valueOf(String r100) {
        return (ResourceFrom) r27.a.a(ResourceFrom.class, r100);
    }

    public static ResourceFrom[] values() {
        return (ResourceFrom[]) f247777a.clone();
    }

    static {
        ResourceFrom r100 = new ResourceFrom("GECKO", 0);
        GECKO = r100;
        ResourceFrom r101 = new ResourceFrom("BUILTIN", 1);
        BUILTIN = r101;
        ResourceFrom r102 = new ResourceFrom("CDN", 2);
        CDN = r102;
        ResourceFrom r103 = new ResourceFrom("LOCAL_FILE", 3);
        LOCAL_FILE = r103;
        ResourceFrom r104 = new ResourceFrom("PRELOAD", 4);
        PRELOAD = r104;
        f247777a = new ResourceFrom[]{r100, r101, r102, r103, r104};
    }

    public ResourceFrom(String r100, int r101) {
        super(r100, r101);
    }
}
