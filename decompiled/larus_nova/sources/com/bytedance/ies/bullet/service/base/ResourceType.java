package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ResourceType;", "", "DISK", "ASSET", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ResourceType extends Enum<ResourceType> {
    public static final ResourceType ASSET = null;
    public static final ResourceType DISK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceType[] f247778a = null;

    public static ResourceType valueOf(String r100) {
        return (ResourceType) r27.a.a(ResourceType.class, r100);
    }

    public static ResourceType[] values() {
        return (ResourceType[]) f247778a.clone();
    }

    static {
        ResourceType r100 = new ResourceType("DISK", 0);
        DISK = r100;
        ResourceType r101 = new ResourceType("ASSET", 1);
        ASSET = r101;
        f247778a = new ResourceType[]{r100, r101};
    }

    public ResourceType(String r100, int r101) {
        super(r100, r101);
    }
}
