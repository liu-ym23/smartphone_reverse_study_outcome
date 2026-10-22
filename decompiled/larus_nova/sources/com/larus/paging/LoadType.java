package com.larus.paging;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/paging/LoadType;", "", "REFRESH", "PREPEND", "APPEND", "paging-common_release"}, k = 1, mv = {1, 7, 1})
public final enum LoadType extends Enum<LoadType> {
    public static final LoadType APPEND = null;
    public static final LoadType PREPEND = null;
    public static final LoadType REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadType[] f363665a = null;

    public static LoadType valueOf(String r100) {
        return (LoadType) r27.a.a(LoadType.class, r100);
    }

    public static LoadType[] values() {
        return (LoadType[]) f363665a.clone();
    }

    static {
        LoadType r100 = new LoadType("REFRESH", 0);
        REFRESH = r100;
        LoadType r101 = new LoadType("PREPEND", 1);
        PREPEND = r101;
        LoadType r102 = new LoadType("APPEND", 2);
        APPEND = r102;
        f363665a = new LoadType[]{r100, r101, r102};
    }

    public LoadType(String r100, int r101) {
        super(r100, r101);
    }
}
