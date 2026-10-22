package com.bytedance.locallife.groupon.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/groupon/event/CityDataSource;", "", "FEED_DATA", "NO_LOGIN_SAME_CITY_DATA", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum CityDataSource extends Enum<CityDataSource> {
    public static final CityDataSource FEED_DATA = null;
    public static final CityDataSource NO_LOGIN_SAME_CITY_DATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CityDataSource[] f258797a = null;

    public static CityDataSource valueOf(String r100) {
        return (CityDataSource) a.a(CityDataSource.class, r100);
    }

    public static CityDataSource[] values() {
        return (CityDataSource[]) f258797a.clone();
    }

    static {
        CityDataSource r100 = new CityDataSource("FEED_DATA", 0);
        FEED_DATA = r100;
        CityDataSource r101 = new CityDataSource("NO_LOGIN_SAME_CITY_DATA", 1);
        NO_LOGIN_SAME_CITY_DATA = r101;
        f258797a = new CityDataSource[]{r100, r101};
    }

    public CityDataSource(String r100, int r101) {
        super(r100, r101);
    }
}
