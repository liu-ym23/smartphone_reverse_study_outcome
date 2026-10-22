package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/disk/api/ManagedCacheCleanMode;", "", "<init>", "(Ljava/lang/String;I)V", "MANUAL_ONLY", "EXPIRED_FILES", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ManagedCacheCleanMode extends Enum<ManagedCacheCleanMode> {
    public static final ManagedCacheCleanMode EXPIRED_FILES = null;
    public static final ManagedCacheCleanMode MANUAL_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ManagedCacheCleanMode[] f330513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330514b = null;

    public static EnumEntries<ManagedCacheCleanMode> getEntries() {
        return f330514b;
    }

    static {
        ManagedCacheCleanMode r100 = new ManagedCacheCleanMode("MANUAL_ONLY", 0);
        MANUAL_ONLY = r100;
        ManagedCacheCleanMode r101 = new ManagedCacheCleanMode("EXPIRED_FILES", 1);
        EXPIRED_FILES = r101;
        ManagedCacheCleanMode[] r102 = {r100, r101};
        f330513a = r102;
        f330514b = EnumEntriesKt.enumEntries(r102);
    }

    public static ManagedCacheCleanMode[] values() {
        return (ManagedCacheCleanMode[]) f330513a.clone();
    }

    public static ManagedCacheCleanMode valueOf(String r100) {
        return (ManagedCacheCleanMode) r27.a.a(ManagedCacheCleanMode.class, r100);
    }

    public ManagedCacheCleanMode(String r100, int r101) {
        super(r100, r101);
    }
}
