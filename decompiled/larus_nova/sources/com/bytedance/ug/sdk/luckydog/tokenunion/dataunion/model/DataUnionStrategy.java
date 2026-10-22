package com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.model;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum DataUnionStrategy extends Enum<DataUnionStrategy> {
    public static final DataUnionStrategy UNION_ACCOUNT = null;
    public static final DataUnionStrategy UNION_ACTIVITY = null;
    public static final DataUnionStrategy UNION_CLIPBOARD = null;
    public static final DataUnionStrategy UNION_DEFAULT = null;
    public static final DataUnionStrategy UNION_FILE = null;
    public static final DataUnionStrategy UNION_PROVIDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataUnionStrategy[] f272288a = null;

    static {
        DataUnionStrategy r100 = new DataUnionStrategy("UNION_DEFAULT", 0);
        UNION_DEFAULT = r100;
        DataUnionStrategy r101 = new DataUnionStrategy("UNION_ACCOUNT", 1);
        UNION_ACCOUNT = r101;
        DataUnionStrategy r102 = new DataUnionStrategy("UNION_PROVIDER", 2);
        UNION_PROVIDER = r102;
        DataUnionStrategy r103 = new DataUnionStrategy("UNION_ACTIVITY", 3);
        UNION_ACTIVITY = r103;
        DataUnionStrategy r104 = new DataUnionStrategy("UNION_FILE", 4);
        UNION_FILE = r104;
        DataUnionStrategy r105 = new DataUnionStrategy("UNION_CLIPBOARD", 5);
        UNION_CLIPBOARD = r105;
        f272288a = new DataUnionStrategy[]{r100, r101, r102, r103, r104, r105};
    }

    public static DataUnionStrategy[] values() {
        return (DataUnionStrategy[]) f272288a.clone();
    }

    public static DataUnionStrategy valueOf(String r100) {
        return (DataUnionStrategy) a.a(DataUnionStrategy.class, r100);
    }

    public DataUnionStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
