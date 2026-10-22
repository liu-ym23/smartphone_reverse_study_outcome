package com.ss.android.socialbase.appdownloader.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.appdownloader.AppUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class AnUtils {
    private static final HashMap<String, AppUtils.AppInfo> sInstalledPackage = null;

    public AnUtils() {
    }

    static {
        sInstalledPackage = new HashMap();
    }

    public static boolean checkAnConfig(JSONObject r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        JSONArray r101 = r100.optJSONArray(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_REQUIREMENTS);
        if (checkOsApiLevel(r100) == true) goto L8;
        return false;
    L8:
        if (checkRequirements(r101) == true) goto L10;
        return false;
    L10:
        if (checkSecure(r100) == true) goto L12;
        return false;
    L12:
        if (checkShouldOpenAH(r100) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public static boolean checkDeviceRomMatch(JSONObject r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        String r101 = r100.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_ROM);
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return true;
    L8:
        String r102 = RomUtils.getName();
        if (TextUtils.isEmpty(r102) == false) goto L12;
        return false;
    L12:
        if (r101.toLowerCase().contains(r102.toLowerCase()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static boolean checkOsApiLevel(JSONObject r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        int r101 = Build.VERSION.SDK_INT;
        String r102 = r100.optString(DownloadSettingKeys.AhPlans.KEY_ALLOW_OS_API_RANGE);
        int r103 = r100.optInt(DownloadSettingKeys.AhPlans.KEY_MIN_OS_API, -1);
        if (TextUtils.isEmpty(r102) == false) goto L23;
        if (r103 <= 0) goto L29;
        if (r101 >= r103) goto L30;
        return false;
    L30:
        return true;
    L29:
        return true;
    L23:
        String[] r104 = r102.split("[-,]");     // Catch: Exception -> L15
        int r105 = 0;
    L9:
        if (r105 >= r104.length) goto L17;
        int r106 = CastIntegerProtector.parseInt(r104[r105]);     // Catch: Exception -> L15
        int r107 = CastIntegerProtector.parseInt(r104[r105 + 1]);     // Catch: Exception -> L15
        if (r101 < r106) goto L14;
        if (r101 > r107) goto L14;
        return true;
    L14:
        r105 = r105 + 2;
    L17:
        return false;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static boolean checkRequirements(JSONArray r110) {
        if (r110 != null) goto L5;
        return true;
    L5:
        int r100 = r110.length();
        if (r100 != 0) goto L8;
        return true;
    L8:
        int r101 = 0;
        boolean r102 = false;
    L9:
        if (r101 >= r100) goto L27;
        JSONObject r103 = r110.optJSONObject(r101);
        if (r103 == null) goto L26;
        String r104 = r103.optString(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_PACKAGE_NAMES);
        JSONArray r105 = r103.optJSONArray(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_ALLOW);
        JSONArray r106 = r103.optJSONArray(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_BLOCK);
        String r107 = r103.optString(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ALLOW_VERSION_RANGE);
        if (TextUtils.isEmpty(r104) == true) goto L14;
        String[] r108 = r104.split(",");
        int r109 = r108.length;
        int r111 = 0;
    L16:
        if (r111 >= r109) goto L26;
        String r112 = r108[r111];
        if ("market".equals(r112) == false) goto L20;
        r112 = RomUtils.getMarketPackageName();
    L20:
        AppUtils.AppInfo r113 = getPackageInfo(r112);
        if (r113 == null) goto L25;
        r102 = isVersionFit(r105, r106, r107, r113);
        if (r102 == true) goto L25;
        return false;
    L25:
        r111 = r111 + 1;
        goto L16
    L14:
        return false;
    L26:
        r101 = r101 + 1;
        goto L9
    L27:
        return r102;
    }

    public static boolean checkSecure(JSONObject r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (SecurityUtils.isSecure() == false) goto L9;
        return true;
    L9:
        if (r100.optInt(DownloadSettingKeys.AhPlans.KEY_SECURITY_MODE) != 1) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean checkShouldOpenAH(JSONObject r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r100.optInt(DownloadSettingKeys.AhPlans.KEY_DYNAMIC_MODE, 0) != 0) goto L9;
        return true;
    L9:
        if (RomUtils.isVivo() == true) goto L11;
        return true;
    L11:
        return VIVOUtils.shouldInsertInstallPassword();
    }

    private static AppUtils.AppInfo getPackageInfo(String r100) {
        HashMap<String, AppUtils.AppInfo> r101 = sInstalledPackage;
        if (r101.containsKey(r100) == false) goto L7;
        AppUtils.AppInfo r102 = r101.get(r100);
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102;
    L7:
        AppUtils.AppInfo r103 = AppUtils.getAppInfo(r100);
        r101.put(r100, r103);
        if (r103 != null) goto L10;
        return null;
    L10:
        return r103;
    }

    public static AppUtils.AppInfo queryPackageInfo(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return null;
    L12:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        AppUtils.AppInfo r101 = getPackageInfo(r100);     // Catch: Throwable -> L11
        if (r101 == null) goto L10;
        return r101;
    L10:
        return null;
    }

    public static boolean enableAmPlan(JSONArray r100, String r101) {
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        int r102 = r100.length();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L18;
        JSONObject r104 = r100.optJSONObject(r103);
        if (r104 == null) goto L17;
        if (r101.equals(r104.optString("type")) == false) goto L17;
        if (checkAnConfig(r104) == false) goto L17;
        return true;
    L17:
        r103 = r103 + 1;
        goto L8
    }

    private static boolean jsonArrayContain(JSONArray r100, String r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        int r102 = r100.length();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L13;
        if (r101.equalsIgnoreCase(r100.optString(r103).trim()) == true) goto L10;
        r103 = r103 + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    }

    public static boolean modifyPackageName(JSONObject r100, Context r101, String r102) {
        if (TextUtils.isEmpty(r102) == true) goto L17;
        if (r101 == null) goto L17;
        if (r100 == null) goto L17;
        if (Build.VERSION.SDK_INT >= 30) goto L17;
        if (RomUtils.aboveMiuiV12() == true) goto L12;
    L14:
        String r103 = r100.optString("s");
        String r104 = DecryptUtils.decrypt(r100.optString("az"), r103);     // Catch: Exception -> L18
        String r105 = DecryptUtils.decrypt(r100.optString("ba"), r103);     // Catch: Exception -> L18
        Field r106 = ContextWrapper.class.getDeclaredField(r104);     // Catch: Exception -> L18
        r106.setAccessible(true);     // Catch: Exception -> L18
        Object r107 = r106.get(r101);     // Catch: Exception -> L18
        Field r108 = r107.getClass().getDeclaredField(r105);     // Catch: Exception -> L18
        r108.setAccessible(true);     // Catch: Exception -> L18
        r108.set(r107, r102);     // Catch: Exception -> L18
        return true;
    L12:
        if (RomUtils.isMiuiV12() == true) goto L14;
    L17:
        return false;
    }

    private static boolean isVersionFit(JSONArray r100, JSONArray r101, String r102, AppUtils.AppInfo r103) {
        String r104 = r103.getVersionName();
        int r105 = r103.getVersionCode();
        String r106 = r105 + "_" + r104;
        if (TextUtils.isEmpty(r102) == false) goto L27;
        if (r100 != null) goto L16;
    L20:
        if (r101 != null) goto L22;
    L26:
        return false;
    L22:
        if (r101.length() <= 0) goto L26;
        if (jsonArrayContain(r101, r106) == true) goto L26;
        return true;
    L16:
        if (r100.length() <= 0) goto L20;
        if (jsonArrayContain(r100, r106) == false) goto L26;
        return true;
    L27:
        String[] r107 = r102.split("[-,]");     // Catch: Exception -> L12
        int r108 = 0;
    L6:
        if (r108 >= r107.length) goto L26;
        int r109 = CastIntegerProtector.parseInt(r107[r108]);     // Catch: Exception -> L12
        int r110 = CastIntegerProtector.parseInt(r107[r108 + 1]);     // Catch: Exception -> L12
        if (r105 < r109) goto L11;
        if (r105 > r110) goto L11;
        return true;
    L11:
        r108 = r108 + 2;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }
}
