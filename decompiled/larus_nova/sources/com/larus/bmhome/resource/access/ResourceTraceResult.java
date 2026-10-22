package com.larus.bmhome.resource.access;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.sdk.account.platform.api.IVKService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceTraceResult;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CREATED", GXAnimation.STATE_START, "CONTINUE", "SKIP", "FAILED", "FALLBACK", "FALLBACK_TO_LOCAL", "READY", "CANCELLED", "REUSE_ACTIVE", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceTraceResult extends Enum<ResourceTraceResult> {
    public static final ResourceTraceResult CANCELLED = null;
    public static final ResourceTraceResult CONTINUE = null;
    public static final ResourceTraceResult CREATED = null;
    public static final ResourceTraceResult FAILED = null;
    public static final ResourceTraceResult FALLBACK = null;
    public static final ResourceTraceResult FALLBACK_TO_LOCAL = null;
    public static final ResourceTraceResult READY = null;
    public static final ResourceTraceResult REUSE_ACTIVE = null;
    public static final ResourceTraceResult SKIP = null;
    public static final ResourceTraceResult START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceTraceResult[] f313595a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313596b = null;
    private final String value;

    public static EnumEntries<ResourceTraceResult> getEntries() {
        return f313596b;
    }

    static {
        ResourceTraceResult r100 = new ResourceTraceResult("CREATED", 0, IVKService.ResponseConstants.CREATED);
        CREATED = r100;
        ResourceTraceResult r101 = new ResourceTraceResult(GXAnimation.STATE_START, 1, "start");
        START = r101;
        ResourceTraceResult r102 = new ResourceTraceResult("CONTINUE", 2, "continue");
        CONTINUE = r102;
        ResourceTraceResult r103 = new ResourceTraceResult("SKIP", 3, "skip");
        SKIP = r103;
        ResourceTraceResult r104 = new ResourceTraceResult("FAILED", 4, "failed");
        FAILED = r104;
        ResourceTraceResult r105 = new ResourceTraceResult("FALLBACK", 5, "fallback");
        FALLBACK = r105;
        ResourceTraceResult r110 = new ResourceTraceResult("FALLBACK_TO_LOCAL", 6, "fallback_to_local");
        FALLBACK_TO_LOCAL = r110;
        ResourceTraceResult r111 = new ResourceTraceResult("READY", 7, "ready");
        READY = r111;
        ResourceTraceResult r112 = new ResourceTraceResult("CANCELLED", 8, "cancelled");
        CANCELLED = r112;
        ResourceTraceResult r113 = new ResourceTraceResult("REUSE_ACTIVE", 9, "reuse_active");
        REUSE_ACTIVE = r113;
        ResourceTraceResult[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f313595a = r114;
        f313596b = EnumEntriesKt.enumEntries(r114);
    }

    public static ResourceTraceResult[] values() {
        return (ResourceTraceResult[]) f313595a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ResourceTraceResult valueOf(String r100) {
        return (ResourceTraceResult) r27.a.a(ResourceTraceResult.class, r100);
    }

    public ResourceTraceResult(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
