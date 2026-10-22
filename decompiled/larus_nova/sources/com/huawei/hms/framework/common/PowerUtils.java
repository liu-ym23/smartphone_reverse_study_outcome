package com.huawei.hms.framework.common;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;

/* JADX INFO: loaded from: classes23.dex */
public class PowerUtils {
    private static final String TAG = "PowerUtils";

    public static final class PowerMode {
        static final int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        static final int POWER_SAVER_MODE = 4;
        static final String SMART_MODE_STATUS = "SmartModeStatus";

        public PowerMode() {
        }
    }

    public PowerUtils() {
    }

    public static boolean isAppIdleMode(Context r100) {
        if (r100 == null) goto L17;
        String r101 = r100.getPackageName();
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 22) goto L10;
        Object r103 = r100.getSystemService("usagestats");
        if ((r103 instanceof UsageStatsManager) == false) goto L9;
        UsageStatsManager r104 = (UsageStatsManager) r103;
    L11:
        if (r104 != null) goto L13;
        Logger.i(TAG, "isAppIdleMode statsManager is null!");
        return false;
    L13:
        if (r102 >= 23) goto L20;
        return false;
    L20:
        return r104.isAppInactive(r101);
    L9:
        return false;
    L10:
        r104 = null;
        goto L11
    L17:
        Logger.i(TAG, "isAppIdleMode Context is null!");
        return false;
    }

    public static boolean isDozeIdleMode(Context r100) {
        if (r100 == null) goto L19;
        Object r101 = ContextCompat.getSystemService(r100, BatteryTypeInf.BATTERY_POWER_LOCK);
        if ((r101 instanceof PowerManager) == false) goto L7;
        PowerManager r102 = (PowerManager) r101;
    L8:
        if (r102 != null) goto L10;
        Logger.i(TAG, "isDozeIdleMode powerManager is null!");
        return false;
    L10:
        if (Build.VERSION.SDK_INT >= 23) goto L21;
        Logger.i(TAG, "isDozeIdleMode is version control state!");
        return false;
    L21:
        return r102.isDeviceIdleMode();
    L13:
        e = move-exception;
        Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
        return false;
    L7:
        r102 = null;
        goto L8
    L19:
        Logger.i(TAG, "isDozeIdleMode Context is null!");
        return false;
    }

    public static boolean isInteractive(Context r100) {
        if (r100 == null) goto L10;
        Object r101 = ContextCompat.getSystemService(r100, BatteryTypeInf.BATTERY_POWER_LOCK);
        if ((r101 instanceof PowerManager) == false) goto L10;
        return ((PowerManager) r101).isInteractive();
    L8:
        e = move-exception;
        Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName() + e.getMessage());
    L10:
        return false;
    }

    public static boolean isWhilteList(Context r100) {
        if (r100 == null) goto L15;
        Object r101 = ContextCompat.getSystemService(r100, BatteryTypeInf.BATTERY_POWER_LOCK);
        if ((r101 instanceof PowerManager) == false) goto L6;
        PowerManager r102 = (PowerManager) r101;
    L7:
        String r103 = r100.getPackageName();
        if (r102 == null) goto L15;
        if (Build.VERSION.SDK_INT < 23) goto L15;
        return r102.isIgnoringBatteryOptimizations(r103);
    L13:
        e = move-exception;
        Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
        goto L15
    L6:
        r102 = null;
    L15:
        return false;
    }

    public static int readDataSaverMode(Context r100) {
        if (r100 == null) goto L20;
        Object r101 = r100.getSystemService("connectivity");
        if ((r101 instanceof ConnectivityManager) == false) goto L7;
        ConnectivityManager r102 = (ConnectivityManager) r101;
    L8:
        if (r102 == null) goto L18;
        int r103 = Build.VERSION.SDK_INT;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_NETWORK_STATE") == false) goto L13;
        return 0;
    L13:
        if (r102.isActiveNetworkMetered() == true) goto L15;
        Logger.v(TAG, "ConnectType is not Mobile Network!");
        return 0;
    L15:
        if (r103 >= 24) goto L23;
        return 0;
    L23:
        return r102.getRestrictBackgroundStatus();
    L18:
        Logger.i(TAG, "readDataSaverMode Context is null!");
        return 0;
    L7:
        r102 = null;
        goto L8
    L20:
        Logger.i(TAG, "readDataSaverMode manager is null!");
        return 0;
    }

    public static int readPowerSaverMode(Context r100) {
        if (r100 == null) goto L17;
        int r101 = SettingUtil.getSystemInt(r100.getContentResolver(), "SmartModeStatus", 0);
        if (r101 != 0) goto L23;
        Object r102 = ContextCompat.getSystemService(r100, BatteryTypeInf.BATTERY_POWER_LOCK);
        if ((r102 instanceof PowerManager) == false) goto L9;
        PowerManager r103 = (PowerManager) r102;
    L10:
        if (r103 == null) goto L23;
        if (r103.isPowerSaveMode() == false) goto L21;
        return 4;
    L21:
        return 0;
    L14:
        e = move-exception;
        Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
        goto L23
    L9:
        r103 = null;
    L23:
        return r101;
    L17:
        Logger.i(TAG, "readPowerSaverMode Context is null!");
        return 0;
    }
}
