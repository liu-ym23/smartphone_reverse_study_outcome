package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceTraceStage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TASK_LIFECYCLE", "REMOTE_FALLBACK", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceTraceStage extends Enum<ResourceTraceStage> {
    public static final ResourceTraceStage REMOTE_FALLBACK = null;
    public static final ResourceTraceStage TASK_LIFECYCLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceTraceStage[] f313597a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313598b = null;
    private final String value;

    public static EnumEntries<ResourceTraceStage> getEntries() {
        return f313598b;
    }

    static {
        ResourceTraceStage r100 = new ResourceTraceStage("TASK_LIFECYCLE", 0, "task_lifecycle");
        TASK_LIFECYCLE = r100;
        ResourceTraceStage r101 = new ResourceTraceStage("REMOTE_FALLBACK", 1, "remote_fallback");
        REMOTE_FALLBACK = r101;
        ResourceTraceStage[] r102 = {r100, r101};
        f313597a = r102;
        f313598b = EnumEntriesKt.enumEntries(r102);
    }

    public static ResourceTraceStage[] values() {
        return (ResourceTraceStage[]) f313597a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ResourceTraceStage valueOf(String r100) {
        return (ResourceTraceStage) r27.a.a(ResourceTraceStage.class, r100);
    }

    public ResourceTraceStage(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
