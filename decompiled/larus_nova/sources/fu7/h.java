package fu7;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.flow.performance.perftag.LocationPermissionStateTagValue;
import com.larus.common.apphost.AppHost;
import com.obric.sva.sdk.utils.InteractConst;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f478911a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile i f478912b;

    public h() {
    }

    static {
        f478911a = new h();
        f478912b = new i(0);
    }

    public static String a() {
        AppHost.Companion r100 = AppHost.f326268a;
        Object r101 = r100.getApplication().getSystemService("location");
        if ((r101 instanceof LocationManager) == false) goto L5;
        LocationManager r102 = (LocationManager) r101;
    L6:
        boolean r103 = false;
        if (Build.VERSION.SDK_INT < 28) goto L12;
        if (r102 != null) goto L10;
    L25:
        if (r103 == true) goto L28;
        return "off";
    L28:
        Application r104 = r100.getApplication();
        if (b(r104, "android.permission.ACCESS_FINE_LOCATION") == false) goto L33;
        return LocationPermissionStateTagValue.FINE;
    L33:
        if (b(r104, "android.permission.ACCESS_COARSE_LOCATION") == false) goto L35;
        return LocationPermissionStateTagValue.COARSE;
    L35:
        return "no_permission";
    L10:
        if (r102.isLocationEnabled() != true) goto L25;
    L24:
        r103 = true;
        goto L25
    L12:
        if (r102 != null) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r102 != null) goto L19;
    L21:
        boolean r106 = false;
    L22:
        if (r105 == true) goto L24;
        if (r106 == false) goto L25;
    L19:
        if (r102.isProviderEnabled("network") != true) goto L21;
        r106 = true;
        goto L22
    L14:
        if (r102.isProviderEnabled(GeocodeSearch.GPS) != true) goto L16;
        r105 = true;
        goto L17
    L5:
        r102 = null;
        goto L6
    }

    public static void c(final String r100) {
        ThreadPlus.submitRunnable(new d(InteractConst.WAKEUP_SCREEN_STATE, r100, new c(r100)));
    }

    public static boolean b(Context r110, String r210) {
        if (Build.VERSION.SDK_INT < 23) goto L25;
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r210};
        f06.b r111 = new f06.b("auto_cert_com_flow_performance_perftag_EnergyControlPerfTagMgr_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L7;
        f06.a[] r103 = r102.f479473i;
    L8:
        f06.a[] r112 = r103;
        int r104 = r112.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L17;
        f06.a r106 = r112[r105];
        int r113 = r105;
        int r114 = r104;
        f06.a[] r115 = r112;
        f06.d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r111);     // Catch: Exception -> L27
        if (r107.f474982a == true) goto L19;
        r100.add(r106);     // Catch: Exception -> L27
    L19:
        if (r107.f474982a == false) goto L21;
        int r108 = ((Integer) r107.f474983b).intValue();
    L22:
        if (r108 == 0) goto L25;
        return false;
    L21:
        r108 = r110.checkSelfPermission(r210);
    L16:
        r105 = r113 + 1;
        r104 = r114;
        r112 = r115;
        goto L10
    L17:
        r107 = new f06.d(false, null);
        goto L19
    L7:
        r103 = ApiHookConfig.f245613d;
    L25:
        return true;
    }
}
