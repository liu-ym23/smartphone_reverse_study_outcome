package com.bytedance.ies.ugc.aweme.fmp.core.diff;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/ugc/aweme/fmp/core/diff/DiffType;", "", "ADD", "REMOVE", "LOCATION_CHANGE", "SIZE_CHANGE", "LOCATION_SIZE_CHANGE", "fmp-core_saasRelease"}, k = 1, mv = {1, 6, 0})
public final enum DiffType extends Enum<DiffType> {
    public static final DiffType ADD = null;
    public static final DiffType LOCATION_CHANGE = null;
    public static final DiffType LOCATION_SIZE_CHANGE = null;
    public static final DiffType REMOVE = null;
    public static final DiffType SIZE_CHANGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DiffType[] f248911a = null;

    public static DiffType valueOf(String r100) {
        return (DiffType) a.a(DiffType.class, r100);
    }

    public static DiffType[] values() {
        return (DiffType[]) f248911a.clone();
    }

    static {
        DiffType r100 = new DiffType("ADD", 0);
        ADD = r100;
        DiffType r101 = new DiffType("REMOVE", 1);
        REMOVE = r101;
        DiffType r102 = new DiffType("LOCATION_CHANGE", 2);
        LOCATION_CHANGE = r102;
        DiffType r103 = new DiffType("SIZE_CHANGE", 3);
        SIZE_CHANGE = r103;
        DiffType r104 = new DiffType("LOCATION_SIZE_CHANGE", 4);
        LOCATION_SIZE_CHANGE = r104;
        f248911a = new DiffType[]{r100, r101, r102, r103, r104};
    }

    public DiffType(String r100, int r101) {
        super(r100, r101);
    }
}
