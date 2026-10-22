package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceCancelReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_CANCEL", "PAGE_DESTROY", "REPLACED", "UNKNOWN", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceCancelReason extends Enum<ResourceCancelReason> {
    public static final ResourceCancelReason PAGE_DESTROY = null;
    public static final ResourceCancelReason REPLACED = null;
    public static final ResourceCancelReason UNKNOWN = null;
    public static final ResourceCancelReason USER_CANCEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceCancelReason[] f313576a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313577b = null;

    public static EnumEntries<ResourceCancelReason> getEntries() {
        return f313577b;
    }

    static {
        ResourceCancelReason r100 = new ResourceCancelReason("USER_CANCEL", 0);
        USER_CANCEL = r100;
        ResourceCancelReason r101 = new ResourceCancelReason("PAGE_DESTROY", 1);
        PAGE_DESTROY = r101;
        ResourceCancelReason r102 = new ResourceCancelReason("REPLACED", 2);
        REPLACED = r102;
        ResourceCancelReason r103 = new ResourceCancelReason("UNKNOWN", 3);
        UNKNOWN = r103;
        ResourceCancelReason[] r104 = {r100, r101, r102, r103};
        f313576a = r104;
        f313577b = EnumEntriesKt.enumEntries(r104);
    }

    public static ResourceCancelReason[] values() {
        return (ResourceCancelReason[]) f313576a.clone();
    }

    public static ResourceCancelReason valueOf(String r100) {
        return (ResourceCancelReason) r27.a.a(ResourceCancelReason.class, r100);
    }

    public ResourceCancelReason(String r100, int r101) {
        super(r100, r101);
    }
}
