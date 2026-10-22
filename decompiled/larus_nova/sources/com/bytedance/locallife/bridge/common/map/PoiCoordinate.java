package com.bytedance.locallife.bridge.common.map;

import com.amap.api.location.AMapLocation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiCoordinate {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f257027c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f257028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f257029b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/bridge/common/map/PoiCoordinate$CoordinateType;", "", AMapLocation.COORD_TYPE_WGS84, AMapLocation.COORD_TYPE_GCJ02, "locallife-bridge_release"}, k = 1, mv = {1, 4, 3})
    public static final enum CoordinateType extends Enum<CoordinateType> {
        public static final CoordinateType GCJ02 = null;
        public static final CoordinateType WGS84 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CoordinateType[] f257030a = null;

        public static CoordinateType valueOf(String r100) {
            return (CoordinateType) r27.a.a(CoordinateType.class, r100);
        }

        public static CoordinateType[] values() {
            return (CoordinateType[]) f257030a.clone();
        }

        static {
            CoordinateType r100 = new CoordinateType(AMapLocation.COORD_TYPE_WGS84, 0);
            WGS84 = r100;
            CoordinateType r101 = new CoordinateType(AMapLocation.COORD_TYPE_GCJ02, 1);
            GCJ02 = r101;
            f257030a = new CoordinateType[]{r100, r101};
        }

        public CoordinateType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f257031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f257032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CoordinateType f257033c;

        public a() {
            this.f257033c = CoordinateType.WGS84;
        }
    }

    public static final class b {
        public static boolean b(double r100, double r101) {
            if (r101 >= 72.004d) goto L5;
        L12:
            return true;
        L5:
            if (r101 > 137.8347d) goto L12;
            if (r100 < 0.8293d) goto L12;
            if (r100 > 55.8271d) goto L12;
            return false;
        }

        public b() {
        }

        public static final PoiCoordinate a(double r310, double r311) {
            if (b(r310, r311) == true) goto L7;
            double r100 = r311 - 105.0d;
            double r101 = r310 - 35.0d;
            double r102 = r100 * 2.0d;
            double r110 = r100 * 0.1d;
            double r111 = r110 * r101;
            double r103 = (((((-100.0d) + r102) + (r101 * 3.0d)) + ((r101 * 0.2d) * r101)) + r111) + (Math.sqrt(Math.abs(r100)) * 0.2d);
            double r112 = (6.0d * r100) * 3.141592653589793d;
            double r104 = r102 * 3.141592653589793d;
            double r210 = r101 * 3.141592653589793d;
            double r105 = ((r103 + ((((Math.sin(r112) * 20.0d) + (Math.sin(r104) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r210) * 20.0d) + (Math.sin((r101 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r101 / 12.0d) * 3.141592653589793d) * 160.0d) + (((double) 320) * Math.sin(r210 / 30.0d))) * 2.0d) / 3.0d);
            double r211 = (((((((r100 + 300.0d) + (r101 * 2.0d)) + (r110 * r100)) + r111) + (Math.sqrt(Math.abs(r100)) * 0.1d)) + ((((Math.sin(r112) * 20.0d) + (Math.sin(r104) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r100 * 3.141592653589793d) * 20.0d) + (Math.sin((r100 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r100 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin(r100 / 30.0d) * 300.0d)) * 2.0d) / 3.0d);
            double r106 = (r310 / 180.0d) * 3.141592653589793d;
            double r107 = Math.sin(r106);
            double r108 = 1;
            double r109 = r108 - ((r107 * 0.006693421622965943d) * r107);
            double r113 = Math.sqrt(r109);
            return new PoiCoordinate(r310 + ((r105 * 180.0d) / ((((r108 - 0.006693421622965943d) * 6378245.0d) / (r109 * r113)) * 3.141592653589793d)), r311 + ((r211 * 180.0d) / (((6378245.0d / r113) * Math.cos(r106)) * 3.141592653589793d)), CoordinateType.GCJ02);
        L7:
            return new PoiCoordinate(r310, r311, CoordinateType.WGS84);
        }
    }

    static {
        new b();
    }

    public PoiCoordinate(double r100, double r101, CoordinateType r102) {
        this.f257028a = r100;
        this.f257029b = r101;
    }
}
