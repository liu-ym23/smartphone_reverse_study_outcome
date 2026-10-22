package com.obric.cae.libs.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.os.SystemProperties;
import com.bytedance.crypto.platform.PlatformConst;
import com.obric.cae.libs.BuildConfig;
import com.obric.sva.sdk.data.SettingsDAO;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes33.dex */
public class CaelibUtils {
    public CaelibUtils() {
    }

    public static String getCaelibVersion() {
        return BuildConfig.LIB_VERSION;
    }

    public static boolean is24GHz(int r100) {
        if (r100 >= 2412) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 2484) goto L7;
        return true;
    }

    public static boolean is5GHz(int r100) {
        if (r100 >= 5160) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 5885) goto L7;
        return true;
    }

    public static boolean isMtkPlatform() {
        if ("mtk".equalsIgnoreCase(SystemProperties.get("ro.hardware.soc.manufacturer", "")) == false) goto L5;
    L16:
        return true;
    L5:
        if ("Mediatek".equalsIgnoreCase(SystemProperties.get("ro.soc.manufacturer", "")) == true) goto L16;
        if (SystemProperties.get("ro.boot.hardware", "").startsWith("mt") == true) goto L16;
        if (SystemProperties.get("ro.board.platform", "").startsWith("mt") == true) goto L16;
        if (SystemProperties.get(SettingsDAO.HARDWARE, "").startsWith("mt") == true) goto L16;
        if (SystemProperties.get(PlatformConst.PROP_SOC_MODEL, "").startsWith("MT") == true) goto L16;
        return false;
    }

    public static boolean isQcomPlatform() {
        if ("qcom".equalsIgnoreCase(SystemProperties.get("ro.boot.hardware", "")) == false) goto L5;
    L8:
        return true;
    L5:
        if ("qcom".equalsIgnoreCase(SystemProperties.get(SettingsDAO.HARDWARE, "")) == true) goto L8;
        return false;
    }

    public static boolean isXiaomiPlatform() {
        List r100 = Arrays.asList(new String[]{"Xiaomi", "Redmi", "Poco"});
        String[] r101 = {"ro.product.brand", "ro.product.odm.brand", PlatformConst.PROP_MANUFACTURER, "ro.product.system.manufacturer"};
        int r102 = 0;
    L4:
        if (r102 >= 4) goto L13;
        String r103 = SystemProperties.get(r101[r102], "");
        Iterator r104 = r100.iterator();
    L7:
        if (r104.hasNext() == false) goto L12;
        if (((String) r104.next()).equalsIgnoreCase(r103) == false) goto L7;
        return true;
    L12:
        r102 = r102 + 1;
        goto L4
    L13:
        return false;
    }

    public static String getCallingPackageName(Context r100) {
        return r100.getOpPackageName();
    }

    public static int getWiFiAuthTypeFromScanResult(ScanResult r100) {
        if (r100 == null) goto L37;
        String r101 = r100.capabilities;
        if (r101 == null) goto L37;
        if (r101.contains("EAP") == false) goto L12;
        return 1;
    L12:
        if (r101.contains("PSK") == false) goto L15;
        return 2;
    L15:
        if (r101.contains("SAE") == false) goto L18;
        return 2;
    L18:
        if (r101.contains("WEP") == false) goto L21;
        return 2;
    L21:
        if (r101.contains("WAPI-PSK") == false) goto L24;
        return 2;
    L24:
        if (r101.contains("OWE") == false) goto L26;
    L36:
        return 3;
    L26:
        if (r101.contains("OSEN") == true) goto L36;
        if (r101.contains("WPA") == false) goto L31;
    L35:
        return 0;
    L31:
        if (r101.contains("WEP") == true) goto L35;
        if (r101.contains("EAP") == true) goto L35;
        return 3;
    L37:
        return 0;
    }

    public static String getAppNameByPID(Context r100, int r101) {
        Iterator<ActivityManager.RunningAppProcessInfo> r102 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        ActivityManager.RunningAppProcessInfo r103 = r102.next();
        if (r103.pid != r101) goto L4;
        return r103.processName;
    L9:
        return null;
    }

    public static String getAppNameByUID(Context r100, int r101) {
        Iterator<ActivityManager.RunningAppProcessInfo> r102 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        ActivityManager.RunningAppProcessInfo r103 = r102.next();
        if (r103.uid != r101) goto L4;
        return r103.processName;
    L9:
        return null;
    }

    public static boolean isFileLargerThanMB(File r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.exists() == true) goto L8;
        return false;
    L8:
        if ((r100.length() / 1048576.0d) <= r101) goto L12;
        return true;
    L12:
        return false;
    }
}
