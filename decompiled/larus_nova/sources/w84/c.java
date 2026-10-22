package w84;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558624a = 0;

    static {
    }

    public static double c(double r100) {
        return (r100 * 3.141592653589793d) / 180.0d;
    }

    public static double a(com.bytedance.bdnavigationsdk.pojo.a r110, com.bytedance.bdnavigationsdk.pojo.a r111) {
        Intrinsics.checkNotNullParameter(r110, "from");
        Intrinsics.checkNotNullParameter(r111, RemoteMessageConst.TO);
        double r100 = c(r110.f200330a);
        double r101 = c(r110.f200331b);
        double r102 = c(r111.f200330a);
        double r112 = c(r111.f200331b) - r101;
        return (((Math.atan2(Math.sin(r112) * Math.cos(r102), (Math.cos(r100) * Math.sin(r102)) - ((Math.sin(r100) * Math.cos(r102)) * Math.cos(r112))) * 180.0d) / 3.141592653589793d) + 360.0d) % 360.0d;
    }

    public static double b(com.bytedance.bdnavigationsdk.pojo.a r100, com.bytedance.bdnavigationsdk.pojo.a r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        double r102 = c(r100.f200330a);
        double r103 = c(r100.f200331b);
        double r104 = c(r101.f200330a);
        double r105 = c(r101.f200331b) - r103;
        double r106 = 2;
        double r107 = Math.pow(Math.sin((r104 - r102) / r106), r106) + ((Math.cos(r102) * Math.cos(r104)) * Math.pow(Math.sin(r105 / r106), r106));
        return (r106 * Math.atan2(Math.sqrt(r107), Math.sqrt(((double) 1) - r107))) * 6378137.0d;
    }
}
