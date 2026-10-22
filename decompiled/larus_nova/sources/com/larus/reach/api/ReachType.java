package com.larus.reach.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/reach/api/ReachType;", "", "<init>", "(Ljava/lang/String;I)V", "BANNER", "TOAST", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReachType extends Enum<ReachType> {
    public static final ReachType BANNER = null;
    public static final ReachType TOAST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReachType[] f367137a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367138b = null;

    public static EnumEntries<ReachType> getEntries() {
        return f367138b;
    }

    static {
        ReachType r100 = new ReachType("BANNER", 0);
        BANNER = r100;
        ReachType r101 = new ReachType("TOAST", 1);
        TOAST = r101;
        ReachType[] r102 = {r100, r101};
        f367137a = r102;
        f367138b = EnumEntriesKt.enumEntries(r102);
    }

    public static ReachType[] values() {
        return (ReachType[]) f367137a.clone();
    }

    public static ReachType valueOf(String r100) {
        return (ReachType) a.a(ReachType.class, r100);
    }

    public ReachType(String r100, int r101) {
        super(r100, r101);
    }
}
