package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceInputType;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL_PATH", "CONTENT_URI", "TOS_KEY", "REMOTE_URL", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceInputType extends Enum<ResourceInputType> {
    public static final ResourceInputType CONTENT_URI = null;
    public static final ResourceInputType LOCAL_PATH = null;
    public static final ResourceInputType REMOTE_URL = null;
    public static final ResourceInputType TOS_KEY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceInputType[] f313578a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313579b = null;

    public static EnumEntries<ResourceInputType> getEntries() {
        return f313579b;
    }

    static {
        ResourceInputType r100 = new ResourceInputType("LOCAL_PATH", 0);
        LOCAL_PATH = r100;
        ResourceInputType r101 = new ResourceInputType("CONTENT_URI", 1);
        CONTENT_URI = r101;
        ResourceInputType r102 = new ResourceInputType("TOS_KEY", 2);
        TOS_KEY = r102;
        ResourceInputType r103 = new ResourceInputType("REMOTE_URL", 3);
        REMOTE_URL = r103;
        ResourceInputType[] r104 = {r100, r101, r102, r103};
        f313578a = r104;
        f313579b = EnumEntriesKt.enumEntries(r104);
    }

    public static ResourceInputType[] values() {
        return (ResourceInputType[]) f313578a.clone();
    }

    public static ResourceInputType valueOf(String r100) {
        return (ResourceInputType) r27.a.a(ResourceInputType.class, r100);
    }

    public ResourceInputType(String r100, int r101) {
        super(r100, r101);
    }
}
