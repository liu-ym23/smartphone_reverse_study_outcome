package com.ss.android.lark.location.dto;

import android.location.Location;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public class LarkLocation extends Location {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f431174k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f431175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f431176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f431177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f431178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f431179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f431180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f431181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f431182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f431183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CoordinateSystem f431184j;

    public static final enum CoordinateSystem extends Enum<CoordinateSystem> {
        public static final CoordinateSystem DEFAULT = null;
        public static final CoordinateSystem GCJ = null;
        public static final CoordinateSystem WGS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CoordinateSystem[] f431185a = null;
        private final int value;

        static {
            CoordinateSystem r100 = new CoordinateSystem("DEFAULT", 0, 0);
            DEFAULT = r100;
            CoordinateSystem r101 = new CoordinateSystem("WGS", 1, 1);
            WGS = r101;
            CoordinateSystem r102 = new CoordinateSystem("GCJ", 2, 2);
            GCJ = r102;
            f431185a = new CoordinateSystem[]{r100, r101, r102};
        }

        public static CoordinateSystem[] values() {
            return (CoordinateSystem[]) f431185a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public static CoordinateSystem forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return DEFAULT;
        L10:
            return GCJ;
        L12:
            return WGS;
        L14:
            return DEFAULT;
        }

        public static CoordinateSystem valueOf(String r100) {
            return (CoordinateSystem) a.a(CoordinateSystem.class, r100);
        }

        public CoordinateSystem(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Override // android.location.Location
    public final String toString() {
        return "LarkLocation{errorCode=" + this.f431181g + ", errorMsg='" + this.f431183i + "', coordinateSystem=" + this.f431184j + '}';
    }

    public LarkLocation(Location r100) {
        super(r100);
        this.f431182h = -1;
        this.f431184j = CoordinateSystem.WGS;
    }
}
