package com.bytedance.bdp.appbase.location.contextservice.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/bdp/appbase/location/contextservice/entity/LocationEntity$FailType", "", "Lcom/bytedance/bdp/appbase/location/contextservice/entity/LocationEntity$FailType;", "LOCATE_FAIL", "INVALID_LAT_LNG", "bdp-appbase-cpapi_release"}, k = 1, mv = {1, 4, 0})
public final enum LocationEntity$FailType extends Enum<LocationEntity$FailType> {
    public static final LocationEntity$FailType INVALID_LAT_LNG = null;
    public static final LocationEntity$FailType LOCATE_FAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocationEntity$FailType[] f200821a = null;

    static {
        LocationEntity$FailType r100 = new LocationEntity$FailType("LOCATE_FAIL", 0);
        LOCATE_FAIL = r100;
        LocationEntity$FailType r101 = new LocationEntity$FailType("INVALID_LAT_LNG", 1);
        INVALID_LAT_LNG = r101;
        f200821a = new LocationEntity$FailType[]{r100, r101};
    }

    public static LocationEntity$FailType valueOf(String r100) {
        return (LocationEntity$FailType) a.a(LocationEntity$FailType.class, r100);
    }

    public static LocationEntity$FailType[] values() {
        return (LocationEntity$FailType[]) f200821a.clone();
    }

    public LocationEntity$FailType(String r100, int r101) {
        super(r100, r101);
    }
}
