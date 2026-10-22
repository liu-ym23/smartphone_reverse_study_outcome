package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/forest/model/ResourceFrom2;", "", "GECKO", "GECKO_UPDATE", "GECKO_OFFLINE_CDN", "BUILTIN", "CDN", "CDN_CACHE", "MEMORY", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum ResourceFrom2 extends Enum<ResourceFrom2> {
    public static final ResourceFrom2 BUILTIN = null;
    public static final ResourceFrom2 CDN = null;
    public static final ResourceFrom2 CDN_CACHE = null;
    public static final ResourceFrom2 GECKO = null;
    public static final ResourceFrom2 GECKO_OFFLINE_CDN = null;
    public static final ResourceFrom2 GECKO_UPDATE = null;
    public static final ResourceFrom2 MEMORY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceFrom2[] f244298a = null;

    static {
        ResourceFrom2 r100 = new ResourceFrom2("GECKO", 0);
        GECKO = r100;
        ResourceFrom2 r101 = new ResourceFrom2("GECKO_UPDATE", 1);
        GECKO_UPDATE = r101;
        ResourceFrom2 r102 = new ResourceFrom2("GECKO_OFFLINE_CDN", 2);
        GECKO_OFFLINE_CDN = r102;
        ResourceFrom2 r103 = new ResourceFrom2("BUILTIN", 3);
        BUILTIN = r103;
        ResourceFrom2 r104 = new ResourceFrom2("CDN", 4);
        CDN = r104;
        ResourceFrom2 r105 = new ResourceFrom2("CDN_CACHE", 5);
        CDN_CACHE = r105;
        ResourceFrom2 r106 = new ResourceFrom2("MEMORY", 6);
        MEMORY = r106;
        f244298a = new ResourceFrom2[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ResourceFrom2 valueOf(String r100) {
        return (ResourceFrom2) r27.a.a(ResourceFrom2.class, r100);
    }

    public static ResourceFrom2[] values() {
        return (ResourceFrom2[]) f244298a.clone();
    }

    public ResourceFrom2(String r100, int r101) {
        super(r100, r101);
    }
}
