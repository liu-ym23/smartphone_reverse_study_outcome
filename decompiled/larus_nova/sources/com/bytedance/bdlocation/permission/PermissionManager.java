package com.bytedance.bdlocation.permission;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.IPermissionChecker;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PermissionManager {
    public static int BLUETOOTH_PERMISSION_NO = 71;
    public static int BLUETOOTH_PERMISSION_OK = 1;
    public static int LOCATION_PERMISSION_NO = 71;
    public static int LOCATION_PERMISSION_OK = 1;
    public static int LOCATION_PERMISSION_UNKNOWN;

    public PermissionManager() {
    }

    public static boolean canRequestLocationPermission() {
        LocationCache r100 = LocationCache.getInstance();
        if ((System.currentTimeMillis() - r100.getLocationDenyTime()) <= 172800000) goto L6;
        return true;
    L6:
        return false;
    }

    public static int checkBluetoothPermissions(Context r100) {
        if (hasAnyPermission(r100, new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"}) == false) goto L7;
        return BLUETOOTH_PERMISSION_OK;
    L7:
        return BLUETOOTH_PERMISSION_NO;
    L9:
        return BLUETOOTH_PERMISSION_NO;
    }

    public static int checkBluetoothScanPermission(Context r100) {
        if (LocationUtil.getTargetSdkVersion() < 31) goto L15;
        if (Build.VERSION.SDK_INT < 31) goto L15;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.BLUETOOTH_SCAN") != 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        return BLUETOOTH_PERMISSION_OK;
    L13:
        return BLUETOOTH_PERMISSION_NO;
    L9:
        r101 = false;
    L15:
        return BLUETOOTH_PERMISSION_OK;
    }

    public static int checkLocationPermissions(Context r100) {
        return checkLocationPermissions(r100, false);
    }

    public static int getBackgroundLocationPermissionStatus(Context r100) {
        if (r100 == null) goto L14;
    L11:
        e = move-exception;
        Logger.e("getBackgroundLocationPermissionStatus error", e);
        goto L14
    L4:
        if (Build.VERSION.SDK_INT < 29) goto L14;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) goto L10;
        return LOCATION_PERMISSION_OK;
    L10:
        return LOCATION_PERMISSION_NO;
    L14:
        return LOCATION_PERMISSION_UNKNOWN;
    }

    public static boolean hasAnyPermission(String... r100) {
        return hasAnyPermission(BDLocationConfig.getContext(), r100);
    }

    public static boolean hasBluetoothPermissions(Context r100) {
        if (checkBluetoothPermissions(r100) != BLUETOOTH_PERMISSION_OK) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasLocationPermissions(Context r100) {
        if (checkLocationPermissions(r100) != LOCATION_PERMISSION_OK) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isApproximateLocation(Context r100) {
        return isApproximateLocation(r100, false);
    }

    public static int checkLocationPermissions(Context r100, boolean r101) {
        if (hasAnyPermission(r100, r101, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L7;
        return LOCATION_PERMISSION_OK;
    L7:
        return LOCATION_PERMISSION_NO;
    L9:
        return LOCATION_PERMISSION_NO;
    }

    private static int forceUseSystemCheckSelfPermission(Context r100, String r101) {
        if (r100 != null) goto L4;
        return -1;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        IPermissionChecker r102 = BDLocationConfig.getPermissionChecker();
        if (r102 == null) goto L11;
        return r102.systemCheckSelfPermission(r100, r101);
    L11:
        return ContextCompat.checkSelfPermission(r100, r101);
    L14:
        return -1;
    }

    public static boolean hasAnyPermission(Context r100, String... r101) {
        return hasAnyPermission(r100, false, r101);
    }

    public static boolean isApproximateLocation(Context r100, boolean r101) {
        boolean r102 = hasAnyPermission(r100, new String[]{"android.permission.ACCESS_FINE_LOCATION"});
        boolean r103 = hasAnyPermission(r100, new String[]{"android.permission.ACCESS_COARSE_LOCATION"});
        Logger.i("PermissionManager isApproximateLocation coarseLocationPermission:" + r103 + "--fineLocationPermission:" + r102);
        if (r103 == false) goto L7;
        if (r102 == true) goto L7;
        return true;
    L7:
        if (r101 == false) goto L9;
    L19:
        return false;
    L9:
        if (BDLocationConfig.enableDimLocationCheck() == false) goto L19;
        if (LocationUtil.isTargetBrand(DimLocationCheckUtil.XIAOMI) == false) goto L13;
    L14:
        Logger.i("PermissionManager isApproximateLocation getDimLocationState:" + DimLocationCheckUtil.getDimLocationState());
        if (DimLocationCheckUtil.getDimLocationState() == 1) goto L20;
        return false;
    L20:
        return true;
    L13:
        if (LocationUtil.isTargetBrand(DimLocationCheckUtil.VIVO) == false) goto L19;
        goto L14
    }

    private static boolean checkPermissions(Context r100, boolean r101, String... r102) {
        if (Build.VERSION.SDK_INT < 31) goto L5;
    L14:
        int r103 = r102.length;
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L22;
        String r105 = r102[r104];
        if (TextUtils.isEmpty(r105) == true) goto L21;
        if (checkSelfPermissionWrapper(r101, r100, r105) != 0) goto L21;
        return true;
    L21:
        r104 = r104 + 1;
        goto L15
    L22:
        return false;
    L5:
        if (BDLocationConfig.enableUseCoarseLocation() == true) goto L14;
        List<String> r106 = getDeniedPermissions(r100, r101, r102);
        if (r106 != null) goto L10;
        return true;
    L10:
        if (r106.isEmpty() == true) goto L28;
        return false;
    L28:
        return true;
    }

    private static int checkSelfPermissionWrapper(boolean r100, Context r101, String r102) {
        if (r100 == false) goto L6;
        return forceUseSystemCheckSelfPermission(r101, r102);
    L6:
        return ContextCompat.checkSelfPermission(r101, r102);
    }

    private static List<String> getDeniedPermissions(Context r100, boolean r101, String... r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L11;
        String r106 = r102[r105];
        if (checkSelfPermissionWrapper(r101, r100, r106) != (-1)) goto L10;
        r103.add(r106);
    L10:
        r105 = r105 + 1;
        goto L6
    L11:
        return r103;
    }

    public static boolean hasAnyPermission(Context r100, LocationTraceLogger r101, String... r102) {
        LocationMonitor.locationTraceLogBegin(r101, LocationMonitorConst.CHECK_LOCATION_PERMISSION_DURATION);
        boolean r103 = hasAnyPermission(r100, false, r102);
        LocationMonitor.locationTraceLogEnd(r101, LocationMonitorConst.CHECK_LOCATION_PERMISSION_DURATION);
        return r103;
    }

    public static boolean hasAnyPermission(Context r100, boolean r101, String... r102) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return checkPermissions(r100, r101, r102);
    }
}
