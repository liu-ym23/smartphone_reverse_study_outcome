package com.obric.cae.libs.location;

import android.location.Location;
import com.amap.api.location.AMapLocation;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public class CoordinateTransformUtils {

    public static final enum CoordinateSystem extends Enum<CoordinateSystem> {
        public static final CoordinateSystem BD09 = null;
        public static final CoordinateSystem GCJ02 = null;
        public static final CoordinateSystem WGS84 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CoordinateSystem[] f395867a = null;

        static {
            CoordinateSystem r100 = new CoordinateSystem(AMapLocation.COORD_TYPE_WGS84, 0);
            WGS84 = r100;
            CoordinateSystem r101 = new CoordinateSystem(AMapLocation.COORD_TYPE_GCJ02, 1);
            GCJ02 = r101;
            CoordinateSystem r102 = new CoordinateSystem("BD09", 2);
            BD09 = r102;
            f395867a = new CoordinateSystem[]{r100, r101, r102};
        }

        public static CoordinateSystem[] values() {
            return (CoordinateSystem[]) f395867a.clone();
        }

        public static CoordinateSystem valueOf(String r100) {
            return (CoordinateSystem) r27.a.a(CoordinateSystem.class, r100);
        }

        public CoordinateSystem(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f395868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f395869b;

        public a(double r100, double r101) {
            this.f395868a = r100;
            this.f395869b = r101;
        }
    }

    public CoordinateTransformUtils() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native double[] bd09ToGcj02Native(double r100, double r101);

    private static native double[] gcj02ToBd09Native(double r100, double r101);

    private static native double[] gcj02ToWgs84Native(double r100, double r101);

    private static native double[] wgs84ToGcj02Native(double r100, double r101);

    static {
        INVOKESTATIC_com_obric_cae_libs_location_CoordinateTransformUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("coordinate_transform");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_obric_cae_libs_location_CoordinateTransformUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static Location convertLocation(CoordinateSystem r100, CoordinateSystem r101, Location r102) {
        if (r100 == r101) goto L30;
        if (r102 == null) goto L30;
        CoordinateSystem r103 = CoordinateSystem.WGS84;
        if (r100 == r103) goto L8;
    L10:
        CoordinateSystem r104 = CoordinateSystem.GCJ02;
        if (r100 != r104) goto L14;
        if (r101 != r103) goto L14;
        double[] r105 = gcj02ToWgs84Native(r102.getLatitude(), r102.getLongitude());
        a r106 = new a(r105[0], r105[1]);
    L28:
        Location r107 = new Location(r102);
        r107.setLatitude(r106.f395868a);
        r107.setLongitude(r106.f395869b);
        return r107;
    L14:
        CoordinateSystem r108 = CoordinateSystem.BD09;
        if (r100 != r108) goto L18;
        if (r101 != r104) goto L18;
        double[] r109 = bd09ToGcj02Native(r102.getLatitude(), r102.getLongitude());
        r106 = new a(r109[0], r109[1]);
    L18:
        if (r100 != r104) goto L21;
        if (r101 != r108) goto L21;
        double[] r110 = gcj02ToBd09Native(r102.getLatitude(), r102.getLongitude());
        r106 = new a(r110[0], r110[1]);
    L21:
        if (r100 != r103) goto L24;
        if (r101 != r108) goto L24;
        double[] r111 = wgs84ToGcj02Native(r102.getLatitude(), r102.getLongitude());
        double[] r112 = gcj02ToBd09Native(r111[0], r111[1]);
        r106 = new a(r112[0], r112[1]);
    L24:
        if (r100 != r108) goto L27;
        if (r101 != r103) goto L27;
        double[] r113 = bd09ToGcj02Native(r102.getLatitude(), r102.getLongitude());
        double[] r114 = gcj02ToWgs84Native(r113[0], r113[1]);
        r106 = new a(r114[0], r114[1]);
    L27:
        r106 = new a(r102.getLatitude(), r102.getLongitude());
        goto L28
    L8:
        if (r101 != CoordinateSystem.GCJ02) goto L10;
        double[] r115 = wgs84ToGcj02Native(r102.getLatitude(), r102.getLongitude());
        r106 = new a(r115[0], r115[1]);
    L30:
        return r102;
    }
}
