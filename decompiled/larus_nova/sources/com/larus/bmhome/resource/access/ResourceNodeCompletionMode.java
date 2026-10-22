package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceNodeCompletionMode;", "", "<init>", "(Ljava/lang/String;I)V", "BLOCKING", "DETACHED", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceNodeCompletionMode extends Enum<ResourceNodeCompletionMode> {
    public static final ResourceNodeCompletionMode BLOCKING = null;
    public static final ResourceNodeCompletionMode DETACHED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceNodeCompletionMode[] f313582a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313583b = null;

    public static EnumEntries<ResourceNodeCompletionMode> getEntries() {
        return f313583b;
    }

    static {
        ResourceNodeCompletionMode r100 = new ResourceNodeCompletionMode("BLOCKING", 0);
        BLOCKING = r100;
        ResourceNodeCompletionMode r101 = new ResourceNodeCompletionMode("DETACHED", 1);
        DETACHED = r101;
        ResourceNodeCompletionMode[] r102 = {r100, r101};
        f313582a = r102;
        f313583b = EnumEntriesKt.enumEntries(r102);
    }

    public static ResourceNodeCompletionMode[] values() {
        return (ResourceNodeCompletionMode[]) f313582a.clone();
    }

    public static ResourceNodeCompletionMode valueOf(String r100) {
        return (ResourceNodeCompletionMode) r27.a.a(ResourceNodeCompletionMode.class, r100);
    }

    public ResourceNodeCompletionMode(String r100, int r101) {
        super(r100, r101);
    }
}
