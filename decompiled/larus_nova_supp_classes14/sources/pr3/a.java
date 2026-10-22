package pr3;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import com.bytedance.api.location.ByteLocationClientOption;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import java.util.concurrent.CopyOnWriteArrayList;
import qr3.c;
import qr3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public ByteLocationClientOption a;
    public final d b;

    public final void b() {
        Logger.i("ByteLocationClient: startLocation() is executed.");
        d r0 = this.b;
        ByteLocationClientOption r1 = this.a;
        if (PermissionManager.hasLocationPermissions(r0.a) == true) goto L5;
        Logger.i("ByteLocationManagerImpl: startLocation() but has no location permission!");
        r0.b.d(new BDLocationException("No Location Permission", "ByteLocation", "30"));
        return;
    L5:
        Context r2 = r0.a;
        ByteLocationClientOption.LocationMode r6 = r1.e;
        if (LocationUtil.isEnableLocationService(r2) == true) goto L16;
        int r3 = d.a.a[r6.ordinal()];
        if (r3 == 1) goto L14;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L16;
    L15:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        Logger.i("ByteLocationManagerImpl: startLocation() but need GPS location service!");
        r0.b.d(new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", "ByteLocation", "86"));
        return;
    L20:
        r0.e = r1;
        StringBuilder r5 = new StringBuilder("ByteLocationManagerImpl: startLocation() and locationMode:");
        r5.append(r1.e);
        r5.append("geocodeMode:");
        int r11 = r1.d;
        if (r11 == 0) goto L25;
        if (r11 == 1) goto L24;
        String r12 = r1.d + "";
    L26:
        r5.append(r12);
        r5.append("intervalMs:");
        r5.append(r1.a);
        Logger.i(r5.toString());
        int r7 = d.a.a[r1.e.ordinal()];
        if (r7 == 1) goto L52;
        if (r7 == 2) goto L33;
        if (r7 != 3) goto L65;
        r1.c = 1;
        d.b(r1, new d.h(r0, r1));
        return;
    L65:
        return;
    L33:
        if (PermissionManager.hasAnyPermission(r0.a, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L36;
        Logger.i("ByteLocationManagerImpl: startLocationInternalForDeviceSensors() but has no location permission!");
        r0.b.d(new BDLocationException("No Location Permission", "ByteLocation", "30"));
        return;
    L36:
        if (LocationUtil.isGpsProviderEnabled(r0.a) == true) goto L38;
        Logger.i("ByteLocationManagerImpl: startLocationInternalForDeviceSensors() but need GPS location service!");
        r0.b.d(new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", "ByteLocation", "86"));
        return;
    L38:
        r1.c = 2;
        r0.c = (LocationManager) r0.a.getSystemService("location");
        if (Build.VERSION.SDK_INT < 24) goto L41;
        r0.h = new d.e(r0, r1.l);
        BDLocationExtrasService.getBPEAManager().registerGnssStatusCallback(r0.c, r0.h, r1.n);
    L42:
        r0.f = new d.C0159d(r0);
        if (PermissionManager.hasAnyPermission(r0.a, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L63;
        Logger.i("ByteLocationManagerImpl: startLocationInternalForDeviceSensors() is executed.");
    L50:
        e = move-exception;
        Logger.i("ByteLocationManagerImpl startLocationInternalForDeviceSensors requestUpdate exception" + e.toString() + r1.l);
        return;
    L46:
        if (r1.l == false) goto L48;
        BDLocationExtrasService.getBPEAManager().requestSingleUpdate(r0.c, "gps", r0.f, null, r1.n);     // Catch: Exception -> L50
    L54:
        return;
    L48:
        BDLocationExtrasService.getBPEAManager().requestLocationUpdates(r0.c, "gps", Math.max(r1.a, 1000), 0.0f, r0.f, null, r1.n);     // Catch: Exception -> L50
        goto L54
    L63:
        return;
    L41:
        r0.g = new d.f(r0, r1.l);
        BDLocationExtrasService.getBPEAManager().addGpsStatusListener(r0.c, r0.g, r1.n);
        goto L42
    L52:
        Logger.i("ByteLocationManagerImpl: startLocationInternalForBatterySaving() is executed.");
        r1.c = 1;
        d.b(r1, new d.c(r0, r1, d.e(null)));
        return;
    L24:
        r12 = "default_accuracy";
        goto L26
    L25:
        r12 = "no";
        goto L26
    L14:
        if (Build.VERSION.SDK_INT >= 26) goto L15;
    L16:
        r4 = false;
        goto L18
    }

    public a(Context r2) {
        this.b = new d(r2);
    }

    public final void a(b r3) {
        c r0 = this.b.b;
        if (((CopyOnWriteArrayList) r0.b).contains(r3) == true) goto L6;
        ((CopyOnWriteArrayList) r0.b).add(r3);
        return;
    }
}
