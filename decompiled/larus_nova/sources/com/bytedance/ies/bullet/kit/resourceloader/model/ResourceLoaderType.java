package com.bytedance.ies.bullet.kit.resourceloader.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/model/ResourceLoaderType;", "", "PPE", "BOE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ResourceLoaderType extends Enum<ResourceLoaderType> {
    public static final ResourceLoaderType BOE = null;
    public static final ResourceLoaderType PPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceLoaderType[] f246868a = null;

    public static ResourceLoaderType valueOf(String r100) {
        return (ResourceLoaderType) a.a(ResourceLoaderType.class, r100);
    }

    public static ResourceLoaderType[] values() {
        return (ResourceLoaderType[]) f246868a.clone();
    }

    static {
        ResourceLoaderType r100 = new ResourceLoaderType("PPE", 0);
        PPE = r100;
        ResourceLoaderType r101 = new ResourceLoaderType("BOE", 1);
        BOE = r101;
        f246868a = new ResourceLoaderType[]{r100, r101};
    }

    public ResourceLoaderType(String r100, int r101) {
        super(r100, r101);
    }
}
