package com.bytedance.live.richcontent.resource.cache;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/live/richcontent/resource/cache/ResourceCache$ReferenceType", "", "Lcom/bytedance/live/richcontent/resource/cache/ResourceCache$ReferenceType;", "StrongReference", "SoftReference", "richcontent_release"}, k = 1, mv = {1, 4, 2})
public final enum ResourceCache$ReferenceType extends Enum<ResourceCache$ReferenceType> {
    public static final ResourceCache$ReferenceType SoftReference = null;
    public static final ResourceCache$ReferenceType StrongReference = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceCache$ReferenceType[] f255777a = null;

    static {
        ResourceCache$ReferenceType r100 = new ResourceCache$ReferenceType("StrongReference", 0);
        StrongReference = r100;
        ResourceCache$ReferenceType r101 = new ResourceCache$ReferenceType("SoftReference", 1);
        SoftReference = r101;
        f255777a = new ResourceCache$ReferenceType[]{r100, r101};
    }

    public static ResourceCache$ReferenceType valueOf(String r100) {
        return (ResourceCache$ReferenceType) r27.a.a(ResourceCache$ReferenceType.class, r100);
    }

    public static ResourceCache$ReferenceType[] values() {
        return (ResourceCache$ReferenceType[]) f255777a.clone();
    }

    public ResourceCache$ReferenceType(String r100, int r101) {
        super(r100, r101);
    }
}
