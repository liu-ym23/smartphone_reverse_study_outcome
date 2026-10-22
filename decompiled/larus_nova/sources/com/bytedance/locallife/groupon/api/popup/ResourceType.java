package com.bytedance.locallife.groupon.api.popup;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/groupon/api/popup/ResourceType;", "", "", "value", "I", "getValue", "()I", "PENDANT", "POPUP", "BOTTOM_BANNER", "GUIDE_TOP", "ACTIVITY_ENTRANCE", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ResourceType extends Enum<ResourceType> {
    public static final ResourceType ACTIVITY_ENTRANCE = null;
    public static final ResourceType BOTTOM_BANNER = null;
    public static final ResourceType GUIDE_TOP = null;
    public static final ResourceType PENDANT = null;
    public static final ResourceType POPUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceType[] f258786a = null;
    private final int value;

    public static ResourceType valueOf(String r100) {
        return (ResourceType) a.a(ResourceType.class, r100);
    }

    public static ResourceType[] values() {
        return (ResourceType[]) f258786a.clone();
    }

    static {
        ResourceType r100 = new ResourceType("PENDANT", 0, 1);
        PENDANT = r100;
        ResourceType r101 = new ResourceType("POPUP", 1, 2);
        POPUP = r101;
        ResourceType r102 = new ResourceType("BOTTOM_BANNER", 2, 3);
        BOTTOM_BANNER = r102;
        ResourceType r103 = new ResourceType("GUIDE_TOP", 3, 4);
        GUIDE_TOP = r103;
        ResourceType r104 = new ResourceType("ACTIVITY_ENTRANCE", 4, 5);
        ACTIVITY_ENTRANCE = r104;
        f258786a = new ResourceType[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public ResourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
