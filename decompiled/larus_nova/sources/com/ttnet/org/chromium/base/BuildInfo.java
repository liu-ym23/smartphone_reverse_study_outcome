package com.ttnet.org.chromium.base;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BuildInfo {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_FINGERPRINT_LENGTH = 128;
    private static final String TAG = "BuildInfo";
    private static ApplicationInfo sBrowserApplicationInfo;
    private static PackageInfo sBrowserPackageInfo;
    private static String sFirebaseAppId;
    private static boolean sInitialized;
    public String abiString;
    public String androidBuildFingerprint;
    public String customThemes;
    public String gmsVersionCode;
    public String hostPackageLabel;
    public long hostVersionCode;
    public String installerPackageName;
    public boolean isAutomotive;
    public boolean isTV;
    public String packageName;
    public String resourcesVersion;
    public long versionCode;
    public String versionName;

    /* JADX INFO: loaded from: classes5.dex */
    public static class Holder {
        private static BuildInfo sInstance;

        private Holder() {
        }

        static {
            sInstance = new BuildInfo();
        }

        public static /* synthetic */ BuildInfo access$000() {
            return sInstance;
        }
    }

    static {
        sFirebaseAppId = "";
    }

    public static boolean isAtLeastT() {
        if (Build.VERSION.SDK_INT >= 32) goto L5;
    L7:
        return false;
    L5:
        if (isAtLeastPreReleaseCodename("Tiramisu", Build.VERSION.CODENAME) == false) goto L7;
        return true;
    }

    public static boolean isDebugAndroid() {
        String r100 = Build.TYPE;
        if ("eng".equals(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if ("userdebug".equals(r100) == true) goto L8;
        return false;
    }

    public BuildInfo() {
        this.hostPackageLabel = "";
        this.packageName = "";
        this.versionName = "";
        this.installerPackageName = "";
        this.gmsVersionCode = "";
        this.abiString = "";
        this.androidBuildFingerprint = "";
        this.customThemes = "";
        this.resourcesVersion = "";
        boolean r100 = true;
        sInitialized = true;
        Context r101 = ContextUtils.getApplicationContext();     // Catch: Exception -> L20
        String r102 = r101.getPackageName();     // Catch: Exception -> L20
        PackageManager r103 = r101.getPackageManager();     // Catch: Exception -> L20
        PackageInfo r104 = r103.getPackageInfo(r102, 0);     // Catch: Exception -> L20
        long r105 = packageVersionCode(r104);     // Catch: Exception -> L20
        this.hostVersionCode = r105;     // Catch: Exception -> L20
        PackageInfo r106 = sBrowserPackageInfo;     // Catch: Exception -> L20
        if (r106 == null) goto L6;
        this.packageName = r106.packageName;     // Catch: Exception -> L20
        this.versionCode = packageVersionCode(r106);     // Catch: Exception -> L20
        this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);     // Catch: Exception -> L20
        sBrowserApplicationInfo = sBrowserPackageInfo.applicationInfo;     // Catch: Exception -> L20
        sBrowserPackageInfo = null;     // Catch: Exception -> L20
    L7:
        this.hostPackageLabel = nullToEmpty(r103.getApplicationLabel(r104.applicationInfo));     // Catch: Exception -> L20
        this.installerPackageName = nullToEmpty(r103.getInstallerPackageName(this.packageName));     // Catch: Exception -> L20
        String r107 = "Not Enabled";
        if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) goto L25;
    L12:
        this.resourcesVersion = r107;     // Catch: Exception -> L20
        this.abiString = TextUtils.join(", ", Build.SUPPORTED_ABIS);     // Catch: Exception -> L20
        String r108 = Build.FINGERPRINT;     // Catch: Exception -> L20
        this.androidBuildFingerprint = r108.substring(0, Math.min(r108.length(), 128));     // Catch: Exception -> L20
        UiModeManager r109 = (UiModeManager) r101.getSystemService("uimode");     // Catch: Exception -> L20
        if (r109 != null) goto L15;
    L17:
        r100 = false;
    L18:
        this.isTV = r100;     // Catch: Exception -> L20
        this.isAutomotive = r101.getPackageManager().hasSystemFeature("android.hardware.type.automotive");     // Catch: Exception -> L20
        return;
    L15:
        if (r109.getCurrentModeType() != 4) goto L17;
    L25:
        r107 = ContextUtils.getApplicationContext().getString(BuildConfig.R_STRING_PRODUCT_VERSION);     // Catch: Exception -> L11
    L11:
        r107 = "Not found";
        goto L12
    L6:
        this.packageName = r102;     // Catch: Exception -> L20
        this.versionCode = r105;     // Catch: Exception -> L20
        this.versionName = nullToEmpty(r104.versionName);     // Catch: Exception -> L20
        sBrowserApplicationInfo = r101.getApplicationInfo();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Log.e(TAG, "NameNotFoundException: " + e, new Object[0]);
    }

    private static String[] getAll() {
        return getInstance().getAllProperties();
    }

    public static BuildInfo getInstance() {
        return Holder.access$000();
    }

    public static boolean targetsAtLeastT() {
        if (ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion < 33) goto L5;
        return true;
    L5:
        return false;
    }

    public String[] getAllProperties() {
        String r100 = ContextUtils.getApplicationContext().getPackageName();
        String[] r101 = new String[28];
        r101[0] = Build.BRAND;
        r101[1] = Build.DEVICE;
        r101[2] = Build.ID;
        r101[3] = Build.MANUFACTURER;
        r101[4] = Build.MODEL;
        r101[5] = String.valueOf(Build.VERSION.SDK_INT);
        r101[6] = Build.TYPE;
        r101[7] = Build.BOARD;
        r101[8] = r100;
        r101[9] = String.valueOf(this.hostVersionCode);
        r101[10] = this.hostPackageLabel;
        r101[11] = this.packageName;
        r101[12] = String.valueOf(this.versionCode);
        r101[13] = this.versionName;
        r101[14] = this.androidBuildFingerprint;
        r101[15] = this.gmsVersionCode;
        r101[16] = this.installerPackageName;
        r101[17] = this.abiString;
        r101[18] = sFirebaseAppId;
        r101[19] = this.customThemes;
        r101[20] = this.resourcesVersion;
        r101[21] = String.valueOf(ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion);
        String r102 = "1";
        if (isDebugAndroid() == false) goto L5;
        String r103 = "1";
    L6:
        r101[22] = r103;
        if (this.isTV == false) goto L9;
        String r104 = "1";
    L10:
        r101[23] = r104;
        r101[24] = Build.VERSION.INCREMENTAL;
        r101[25] = Build.HARDWARE;
        if (isAtLeastT() == false) goto L13;
        String r105 = "1";
    L14:
        r101[26] = r105;
        if (this.isAutomotive == true) goto L18;
        r102 = "0";
    L18:
        r101[27] = r102;
        return r101;
    L13:
        r105 = "0";
        goto L14
    L9:
        r104 = "0";
        goto L10
    L5:
        r103 = "0";
        goto L6
    }

    public static String getFirebaseAppId() {
        return sFirebaseAppId;
    }

    public ApplicationInfo getBrowserApplicationInfo() {
        return sBrowserApplicationInfo;
    }

    private static String nullToEmpty(CharSequence r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.toString();
    }

    public static long packageVersionCode(PackageInfo r100) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return ApiHelperForP.getLongVersionCode(r100);
    L7:
        return r100.versionCode;
    }

    public static void setBrowserPackageInfo(PackageInfo r100) {
        sBrowserPackageInfo = r100;
    }

    public static void setFirebaseAppId(String r100) {
        sFirebaseAppId = r100;
    }

    private static boolean isAtLeastPreReleaseCodename(String r100, String r101) {
        if ("REL".equals(r101) == false) goto L5;
        return false;
    L5:
        Locale r102 = Locale.ROOT;
        if (r101.toUpperCase(r102).compareTo(r100.toUpperCase(r102)) < 0) goto L9;
        return true;
    L9:
        return false;
    }
}
