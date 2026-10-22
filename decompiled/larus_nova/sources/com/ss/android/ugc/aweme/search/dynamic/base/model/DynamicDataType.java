package com.ss.android.ugc.aweme.search.dynamic.base.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/base/model/DynamicDataType;", "", "LYNX", "WEB", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final enum DynamicDataType extends Enum<DynamicDataType> {
    public static final DynamicDataType LYNX = null;
    public static final DynamicDataType WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DynamicDataType[] f452591a = null;

    public static DynamicDataType valueOf(String r100) {
        return (DynamicDataType) a.a(DynamicDataType.class, r100);
    }

    public static DynamicDataType[] values() {
        return (DynamicDataType[]) f452591a.clone();
    }

    static {
        DynamicDataType r100 = new DynamicDataType("LYNX", 0);
        LYNX = r100;
        DynamicDataType r101 = new DynamicDataType("WEB", 1);
        WEB = r101;
        f452591a = new DynamicDataType[]{r100, r101};
    }

    public DynamicDataType(String r100, int r101) {
        super(r100, r101);
    }
}
