package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceNodeStatus;", "", "<init>", "(Ljava/lang/String;I)V", "RUNNING", "SKIPPED", "CONTINUED", "READY", "FAILED", "FALLBACK", "CANCELLED", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceNodeStatus extends Enum<ResourceNodeStatus> {
    public static final ResourceNodeStatus CANCELLED = null;
    public static final ResourceNodeStatus CONTINUED = null;
    public static final ResourceNodeStatus FAILED = null;
    public static final ResourceNodeStatus FALLBACK = null;
    public static final ResourceNodeStatus READY = null;
    public static final ResourceNodeStatus RUNNING = null;
    public static final ResourceNodeStatus SKIPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceNodeStatus[] f313585a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313586b = null;

    public static EnumEntries<ResourceNodeStatus> getEntries() {
        return f313586b;
    }

    static {
        ResourceNodeStatus r100 = new ResourceNodeStatus("RUNNING", 0);
        RUNNING = r100;
        ResourceNodeStatus r101 = new ResourceNodeStatus("SKIPPED", 1);
        SKIPPED = r101;
        ResourceNodeStatus r102 = new ResourceNodeStatus("CONTINUED", 2);
        CONTINUED = r102;
        ResourceNodeStatus r103 = new ResourceNodeStatus("READY", 3);
        READY = r103;
        ResourceNodeStatus r104 = new ResourceNodeStatus("FAILED", 4);
        FAILED = r104;
        ResourceNodeStatus r105 = new ResourceNodeStatus("FALLBACK", 5);
        FALLBACK = r105;
        ResourceNodeStatus r110 = new ResourceNodeStatus("CANCELLED", 6);
        CANCELLED = r110;
        ResourceNodeStatus[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f313585a = r111;
        f313586b = EnumEntriesKt.enumEntries(r111);
    }

    public static ResourceNodeStatus[] values() {
        return (ResourceNodeStatus[]) f313585a.clone();
    }

    public static ResourceNodeStatus valueOf(String r100) {
        return (ResourceNodeStatus) r27.a.a(ResourceNodeStatus.class, r100);
    }

    public ResourceNodeStatus(String r100, int r101) {
        super(r100, r101);
    }
}
