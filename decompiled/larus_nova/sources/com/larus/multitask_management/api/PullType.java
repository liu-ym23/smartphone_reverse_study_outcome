package com.larus.multitask_management.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/multitask_management/api/PullType;", "", "<init>", "(Ljava/lang/String;I)V", "ADDITIONAL", "REFRESH", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PullType extends Enum<PullType> {
    public static final PullType ADDITIONAL = null;
    public static final PullType REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PullType[] f359371a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359372b = null;

    public static EnumEntries<PullType> getEntries() {
        return f359372b;
    }

    static {
        PullType r100 = new PullType("ADDITIONAL", 0);
        ADDITIONAL = r100;
        PullType r101 = new PullType("REFRESH", 1);
        REFRESH = r101;
        PullType[] r102 = {r100, r101};
        f359371a = r102;
        f359372b = EnumEntriesKt.enumEntries(r102);
    }

    public static PullType[] values() {
        return (PullType[]) f359371a.clone();
    }

    public static PullType valueOf(String r100) {
        return (PullType) a.a(PullType.class, r100);
    }

    public PullType(String r100, int r101) {
        super(r100, r101);
    }
}
