package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceRouteReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ARTIFACT_READY", "TOS_KEY_DIRECT", "REMOTE_URL_NEEDS_LOCAL_SOURCE", "REMOTE_RESOLVE_DISABLED", "REMOTE_FALLBACK_DISABLED", "UNSUPPORTED_REMOTE_INPUT", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceRouteReason extends Enum<ResourceRouteReason> {
    public static final ResourceRouteReason ARTIFACT_READY = null;
    public static final ResourceRouteReason REMOTE_FALLBACK_DISABLED = null;
    public static final ResourceRouteReason REMOTE_RESOLVE_DISABLED = null;
    public static final ResourceRouteReason REMOTE_URL_NEEDS_LOCAL_SOURCE = null;
    public static final ResourceRouteReason TOS_KEY_DIRECT = null;
    public static final ResourceRouteReason UNSUPPORTED_REMOTE_INPUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceRouteReason[] f313593a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313594b = null;
    private final String value;

    public static EnumEntries<ResourceRouteReason> getEntries() {
        return f313594b;
    }

    static {
        ResourceRouteReason r100 = new ResourceRouteReason("ARTIFACT_READY", 0, "artifact_ready");
        ARTIFACT_READY = r100;
        ResourceRouteReason r101 = new ResourceRouteReason("TOS_KEY_DIRECT", 1, "tos_key_direct");
        TOS_KEY_DIRECT = r101;
        ResourceRouteReason r102 = new ResourceRouteReason("REMOTE_URL_NEEDS_LOCAL_SOURCE", 2, "remote_url_needs_local_source");
        REMOTE_URL_NEEDS_LOCAL_SOURCE = r102;
        ResourceRouteReason r103 = new ResourceRouteReason("REMOTE_RESOLVE_DISABLED", 3, "remote_resolve_disabled");
        REMOTE_RESOLVE_DISABLED = r103;
        ResourceRouteReason r104 = new ResourceRouteReason("REMOTE_FALLBACK_DISABLED", 4, "remote_fallback_disabled");
        REMOTE_FALLBACK_DISABLED = r104;
        ResourceRouteReason r105 = new ResourceRouteReason("UNSUPPORTED_REMOTE_INPUT", 5, "unsupported_remote_input");
        UNSUPPORTED_REMOTE_INPUT = r105;
        ResourceRouteReason[] r110 = {r100, r101, r102, r103, r104, r105};
        f313593a = r110;
        f313594b = EnumEntriesKt.enumEntries(r110);
    }

    public static ResourceRouteReason[] values() {
        return (ResourceRouteReason[]) f313593a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ResourceRouteReason valueOf(String r100) {
        return (ResourceRouteReason) r27.a.a(ResourceRouteReason.class, r100);
    }

    public ResourceRouteReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
