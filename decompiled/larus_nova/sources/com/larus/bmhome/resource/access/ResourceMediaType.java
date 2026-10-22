package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "FILE", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceMediaType extends Enum<ResourceMediaType> {
    public static final ResourceMediaType FILE = null;
    public static final ResourceMediaType IMAGE = null;
    public static final ResourceMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceMediaType[] f313580a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313581b = null;

    public static EnumEntries<ResourceMediaType> getEntries() {
        return f313581b;
    }

    static {
        ResourceMediaType r100 = new ResourceMediaType("IMAGE", 0);
        IMAGE = r100;
        ResourceMediaType r101 = new ResourceMediaType("VIDEO", 1);
        VIDEO = r101;
        ResourceMediaType r102 = new ResourceMediaType("FILE", 2);
        FILE = r102;
        ResourceMediaType[] r103 = {r100, r101, r102};
        f313580a = r103;
        f313581b = EnumEntriesKt.enumEntries(r103);
    }

    public static ResourceMediaType[] values() {
        return (ResourceMediaType[]) f313580a.clone();
    }

    public static ResourceMediaType valueOf(String r100) {
        return (ResourceMediaType) r27.a.a(ResourceMediaType.class, r100);
    }

    public ResourceMediaType(String r100, int r101) {
        super(r100, r101);
    }
}
