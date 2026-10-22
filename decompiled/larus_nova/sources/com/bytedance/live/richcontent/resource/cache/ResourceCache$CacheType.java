package com.bytedance.live.richcontent.resource.cache;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/live/richcontent/resource/cache/ResourceCache$CacheType", "", "Lcom/bytedance/live/richcontent/resource/cache/ResourceCache$CacheType;", "MaxEntitySize", "MaxMemorySize", "richcontent_release"}, k = 1, mv = {1, 4, 2})
public final enum ResourceCache$CacheType extends Enum<ResourceCache$CacheType> {
    public static final ResourceCache$CacheType MaxEntitySize = null;
    public static final ResourceCache$CacheType MaxMemorySize = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceCache$CacheType[] f255776a = null;

    static {
        ResourceCache$CacheType r100 = new ResourceCache$CacheType("MaxEntitySize", 0);
        MaxEntitySize = r100;
        ResourceCache$CacheType r101 = new ResourceCache$CacheType("MaxMemorySize", 1);
        MaxMemorySize = r101;
        f255776a = new ResourceCache$CacheType[]{r100, r101};
    }

    public static ResourceCache$CacheType valueOf(String r100) {
        return (ResourceCache$CacheType) r27.a.a(ResourceCache$CacheType.class, r100);
    }

    public static ResourceCache$CacheType[] values() {
        return (ResourceCache$CacheType[]) f255776a.clone();
    }

    public ResourceCache$CacheType(String r100, int r101) {
        super(r100, r101);
    }
}
