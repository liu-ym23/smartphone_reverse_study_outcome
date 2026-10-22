package com.larus.contextwindow.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowUsageSource;", "", "<init>", "(Ljava/lang/String;I)V", "CURRENT", "FALLBACK_ADJACENT", "FALLBACK_HISTORICAL", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextWindowUsageSource extends Enum<ContextWindowUsageSource> {
    public static final ContextWindowUsageSource CURRENT = null;
    public static final ContextWindowUsageSource FALLBACK_ADJACENT = null;
    public static final ContextWindowUsageSource FALLBACK_HISTORICAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContextWindowUsageSource[] f330271a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330272b = null;

    public static EnumEntries<ContextWindowUsageSource> getEntries() {
        return f330272b;
    }

    static {
        ContextWindowUsageSource r100 = new ContextWindowUsageSource("CURRENT", 0);
        CURRENT = r100;
        ContextWindowUsageSource r101 = new ContextWindowUsageSource("FALLBACK_ADJACENT", 1);
        FALLBACK_ADJACENT = r101;
        ContextWindowUsageSource r102 = new ContextWindowUsageSource("FALLBACK_HISTORICAL", 2);
        FALLBACK_HISTORICAL = r102;
        ContextWindowUsageSource[] r103 = {r100, r101, r102};
        f330271a = r103;
        f330272b = EnumEntriesKt.enumEntries(r103);
    }

    public static ContextWindowUsageSource[] values() {
        return (ContextWindowUsageSource[]) f330271a.clone();
    }

    public static ContextWindowUsageSource valueOf(String r100) {
        return (ContextWindowUsageSource) r27.a.a(ContextWindowUsageSource.class, r100);
    }

    public ContextWindowUsageSource(String r100, int r101) {
        super(r100, r101);
    }
}
