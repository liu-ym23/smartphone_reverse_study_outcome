package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.PermissionChecker;
import f06.b;
import f06.c;
import f06.d;
import java.util.Calendar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState;

    public static class TwilightState {
        boolean isNight;
        long nextUpdate;
        long todaySunrise;
        long todaySunset;
        long tomorrowSunrise;
        long yesterdaySunset;

        public TwilightState() {
        }
    }

    private Location getLastKnownLocation() {
        Location r1 = null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L5;
        Location r0 = getLastKnownLocationForProvider("network");
    L7:
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L9;
        r1 = getLastKnownLocationForProvider("gps");
    L9:
        if (r1 == null) goto L15;
        if (r0 == null) goto L15;
        if (r1.getTime() > r0.getTime()) goto L14;
        return r0;
    L14:
        return r1;
    L15:
        if (r1 != null) goto L17;
        return r0;
    L17:
        return r1;
    L5:
        r0 = null;
        goto L7
    }

    private boolean isStateValid() {
        if (this.mTwilightState.nextUpdate <= System.currentTimeMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNight() {
        TwilightState r0 = this.mTwilightState;
        if (isStateValid() == true) goto L5;
        Location r1 = getLastKnownLocation();
        if (r1 == null) goto L10;
        updateState(r1);
        return r0.isNight;
    L10:
        int r2 = Calendar.getInstance().get(11);
        if (r2 >= 6) goto L13;
    L16:
        return true;
    L13:
        if (r2 >= SUNSET) goto L16;
        return false;
    L5:
        return r0.isNight;
    }

    public static TwilightManager getInstance(Context r2) {
        if (sInstance != null) goto L6;
        Context r3 = r2.getApplicationContext();
        sInstance = new TwilightManager(r3, (LocationManager) r3.getSystemService("location"));
    L6:
        return sInstance;
    }

    private Location getLastKnownLocationForProvider(String r2) {
        if (this.mLocationManager.isProviderEnabled(r2) == false) goto L6;
        return androidx_appcompat_app_TwilightManager_android_location_LocationManager_getLastKnownLocation(this.mLocationManager, r2);
    L6:
        return null;
    L11:
        return null;
    }

    public static void setInstance(TwilightManager r0) {
        sInstance = r0;
    }

    private void updateState(Location r23) {
        TwilightState r1 = this.mTwilightState;
        long r9 = System.currentTimeMillis();
        TwilightCalculator r11 = TwilightCalculator.getInstance();
        r11.calculateTwilight(r9 - 86400000, r23.getLatitude(), r23.getLongitude());
        long r14 = r11.sunset;
        r11.calculateTwilight(r9, r23.getLatitude(), r23.getLongitude());
        if (r11.state != 1) goto L5;
        boolean r7 = true;
    L6:
        long r5 = r11.sunrise;
        long r3 = r11.sunset;
        boolean r0 = r7;
        r11.calculateTwilight(86400000 + r9, r23.getLatitude(), r23.getLongitude());
        long r2 = r11.sunrise;
        if (r5 != (-1)) goto L9;
    L19:
        long r4 = 43200000 + r9;
    L20:
        r1.isNight = r0;
        r1.yesterdaySunset = r14;
        r1.todaySunrise = r5;
        r1.todaySunset = r3;
        r1.tomorrowSunrise = r2;
        r1.nextUpdate = r4;
        return;
    L9:
        if (r3 == (-1)) goto L19;
        if (r9 <= r3) goto L15;
        long r6 = 0 + r2;
    L18:
        r4 = r6 + 60000;
        goto L20
    L15:
        if (r9 <= r5) goto L17;
        r6 = 0 + r3;
        goto L18
    L17:
        r6 = 0 + r5;
        goto L18
    L5:
        r7 = false;
        goto L6
    }

    public TwilightManager(Context r2, LocationManager r3) {
        this.mTwilightState = new TwilightState();
        this.mContext = r2;
        this.mLocationManager = r3;
    }

    private static Location androidx_appcompat_app_TwilightManager_android_location_LocationManager_getLastKnownLocation(LocationManager r12, String r13) {
        c r8 = new c();
        Object[] r9 = {r13};
        b r10 = new b();
        d r11 = r8.b(100000, "android/location/LocationManager", "getLastKnownLocation", r12, r9, "android.location.Location", r10);
        if (r11.a == false) goto L6;
        r8.a(100000, "android/location/LocationManager", "getLastKnownLocation", r12, r9, null, r10, false);
        return (Location) r11.b;
    L6:
        Location r14 = r12.getLastKnownLocation(r13);
        r8.a(100000, "android/location/LocationManager", "getLastKnownLocation", r12, r9, r14, r10, true);
        return r14;
    }
}
