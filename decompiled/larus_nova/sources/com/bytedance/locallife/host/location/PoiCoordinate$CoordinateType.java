package com.bytedance.locallife.host.location;

import com.amap.api.location.AMapLocation;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum PoiCoordinate$CoordinateType extends Enum<PoiCoordinate$CoordinateType> {
    public static final PoiCoordinate$CoordinateType GCJ02 = null;
    public static final PoiCoordinate$CoordinateType WGS84 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiCoordinate$CoordinateType[] f258907a = null;

    static {
        PoiCoordinate$CoordinateType r100 = new PoiCoordinate$CoordinateType(AMapLocation.COORD_TYPE_WGS84, 0);
        WGS84 = r100;
        PoiCoordinate$CoordinateType r101 = new PoiCoordinate$CoordinateType(AMapLocation.COORD_TYPE_GCJ02, 1);
        GCJ02 = r101;
        f258907a = new PoiCoordinate$CoordinateType[]{r100, r101};
    }

    public static PoiCoordinate$CoordinateType[] values() {
        return (PoiCoordinate$CoordinateType[]) f258907a.clone();
    }

    public static PoiCoordinate$CoordinateType valueOf(String r100) {
        return (PoiCoordinate$CoordinateType) a.a(PoiCoordinate$CoordinateType.class, r100);
    }

    public PoiCoordinate$CoordinateType(String r100, int r101) {
        super(r100, r101);
    }
}
