package com.bytedance.forest.model;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use ResourceFrom2 for more detail")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/forest/model/ResourceFrom;", "", "GECKO", "BUILTIN", "CDN", "MEMORY", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum ResourceFrom extends Enum<ResourceFrom> {
    public static final ResourceFrom BUILTIN = null;
    public static final ResourceFrom CDN = null;
    public static final ResourceFrom GECKO = null;
    public static final ResourceFrom MEMORY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceFrom[] f244297a = null;

    static {
        ResourceFrom r100 = new ResourceFrom("GECKO", 0);
        GECKO = r100;
        ResourceFrom r101 = new ResourceFrom("BUILTIN", 1);
        BUILTIN = r101;
        ResourceFrom r102 = new ResourceFrom("CDN", 2);
        CDN = r102;
        ResourceFrom r103 = new ResourceFrom("MEMORY", 3);
        MEMORY = r103;
        f244297a = new ResourceFrom[]{r100, r101, r102, r103};
    }

    public static ResourceFrom valueOf(String r100) {
        return (ResourceFrom) r27.a.a(ResourceFrom.class, r100);
    }

    public static ResourceFrom[] values() {
        return (ResourceFrom[]) f244297a.clone();
    }

    public ResourceFrom(String r100, int r101) {
        super(r100, r101);
    }
}
