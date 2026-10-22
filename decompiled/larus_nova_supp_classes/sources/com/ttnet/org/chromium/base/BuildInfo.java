package com.ttnet.org.chromium.base;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.log.MiraMonitor;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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

    static {
        sFirebaseAppId = XmlPullParser.NO_NAMESPACE;
    }

    public static boolean isAtLeastT() {
        if (Build.VERSION.SDK_INT >= 32) goto L5;
    L7:
        return $assertionsDisabled;
    L5:
        if (isAtLeastPreReleaseCodename("Tiramisu", Build.VERSION.CODENAME) == false) goto L7;
        return true;
    }

    public static boolean isDebugAndroid() {
        String r0 = Build.TYPE;
        if ("eng".equals(r0) == false) goto L5;
    L8:
        return true;
    L5:
        if ("userdebug".equals(r0) == true) goto L8;
        return $assertionsDisabled;
    }

    public BuildInfo() {
        this.hostPackageLabel = XmlPullParser.NO_NAMESPACE;
        this.packageName = XmlPullParser.NO_NAMESPACE;
        this.versionName = XmlPullParser.NO_NAMESPACE;
        this.installerPackageName = XmlPullParser.NO_NAMESPACE;
        this.gmsVersionCode = XmlPullParser.NO_NAMESPACE;
        this.abiString = XmlPullParser.NO_NAMESPACE;
        this.androidBuildFingerprint = XmlPullParser.NO_NAMESPACE;
        this.customThemes = XmlPullParser.NO_NAMESPACE;
        this.resourcesVersion = XmlPullParser.NO_NAMESPACE;
        boolean r0 = true;
        sInitialized = true;
        Context r2 = ContextUtils.getApplicationContext();     // Catch: Exception -> L20
        String r3 = r2.getPackageName();     // Catch: Exception -> L20
        PackageManager r4 = r2.getPackageManager();     // Catch: Exception -> L20
        PackageInfo r5 = r4.getPackageInfo(r3, 0);     // Catch: Exception -> L20
        long r6 = packageVersionCode(r5);     // Catch: Exception -> L20
        this.hostVersionCode = r6;     // Catch: Exception -> L20
        PackageInfo r8 = sBrowserPackageInfo;     // Catch: Exception -> L20
        if (r8 == null) goto L6;
        this.packageName = r8.packageName;     // Catch: Exception -> L20
        this.versionCode = packageVersionCode(r8);     // Catch: Exception -> L20
        this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);     // Catch: Exception -> L20
        sBrowserApplicationInfo = sBrowserPackageInfo.applicationInfo;     // Catch: Exception -> L20
        sBrowserPackageInfo = null;     // Catch: Exception -> L20
    L7:
        this.hostPackageLabel = nullToEmpty(r4.getApplicationLabel(r5.applicationInfo));     // Catch: Exception -> L20
        this.installerPackageName = nullToEmpty(r4.getInstallerPackageName(this.packageName));     // Catch: Exception -> L20
        String r7 = "Not Enabled";
        if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) goto L25;
    L12:
        this.resourcesVersion = r7;     // Catch: Exception -> L20
        this.abiString = TextUtils.join(", ", Build.SUPPORTED_ABIS);     // Catch: Exception -> L20
        String r9 = Build.FINGERPRINT;     // Catch: Exception -> L20
        this.androidBuildFingerprint = r9.substring(0, Math.min(r9.length(), MAX_FINGERPRINT_LENGTH));     // Catch: Exception -> L20
        UiModeManager r10 = (UiModeManager) r2.getSystemService("uimode");     // Catch: Exception -> L20
        if (r10 != null) goto L15;
    L17:
        r0 = $assertionsDisabled;
    L18:
        this.isTV = r0;     // Catch: Exception -> L20
        this.isAutomotive = r2.getPackageManager().hasSystemFeature("android.hardware.type.automotive");     // Catch: Exception -> L20
        return;
    L15:
        if (r10.getCurrentModeType() != 4) goto L17;
    L25:
        r7 = ContextUtils.getApplicationContext().getString(BuildConfig.R_STRING_PRODUCT_VERSION);     // Catch: Exception -> L11
    L11:
        r7 = "Not found";
        goto L12
    L6:
        this.packageName = r3;     // Catch: Exception -> L20
        this.versionCode = r6;     // Catch: Exception -> L20
        this.versionName = nullToEmpty(r5.versionName);     // Catch: Exception -> L20
        sBrowserApplicationInfo = r2.getApplicationInfo();     // Catch: Exception -> L20
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
        return $assertionsDisabled;
    }

    public String[] getAllProperties() {
        String r0 = ContextUtils.getApplicationContext().getPackageName();
        String[] r1 = new String[28];
        r1[0] = Build.BRAND;
        r1[1] = Build.DEVICE;
        r1[2] = Build.ID;
        r1[3] = Build.MANUFACTURER;
        r1[4] = Build.MODEL;
        r1[5] = String.valueOf(Build.VERSION.SDK_INT);
        r1[6] = Build.TYPE;
        r1[7] = Build.BOARD;
        r1[8] = r0;
        r1[9] = String.valueOf(this.hostVersionCode);
        r1[10] = this.hostPackageLabel;
        r1[11] = this.packageName;
        r1[12] = String.valueOf(this.versionCode);
        r1[13] = this.versionName;
        r1[14] = this.androidBuildFingerprint;
        r1[15] = this.gmsVersionCode;
        r1[16] = this.installerPackageName;
        r1[17] = this.abiString;
        r1[18] = sFirebaseAppId;
        r1[19] = this.customThemes;
        r1[20] = this.resourcesVersion;
        r1[21] = String.valueOf(ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion);
        String r2 = "1";
        if (isDebugAndroid() == false) goto L5;
        String r3 = "1";
    L6:
        r1[22] = r3;
        if (this.isTV == false) goto L9;
        String r4 = "1";
    L10:
        r1[23] = r4;
        r1[24] = Build.VERSION.INCREMENTAL;
        r1[25] = Build.HARDWARE;
        if (isAtLeastT() == false) goto L13;
        String r5 = "1";
    L14:
        r1[26] = r5;
        if (this.isAutomotive == true) goto L18;
        r2 = MiraMonitor.VALUE_DEFAULT;
    L18:
        r1[27] = r2;
        return r1;
    L13:
        r5 = MiraMonitor.VALUE_DEFAULT;
        goto L14
    L9:
        r4 = MiraMonitor.VALUE_DEFAULT;
        goto L10
    L5:
        r3 = MiraMonitor.VALUE_DEFAULT;
        goto L6
    }

    public static String getFirebaseAppId() {
        return sFirebaseAppId;
    }

    public ApplicationInfo getBrowserApplicationInfo() {
        return sBrowserApplicationInfo;
    }

    private static String nullToEmpty(CharSequence r0) {
        if (r0 != null) goto L5;
        return XmlPullParser.NO_NAMESPACE;
    L5:
        return r0.toString();
    }

    public static long packageVersionCode(PackageInfo r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return ApiHelperForP.getLongVersionCode(r2);
    L7:
        return r2.versionCode;
    }

    public static void setBrowserPackageInfo(PackageInfo r0) {
        sBrowserPackageInfo = r0;
    }

    public static void setFirebaseAppId(String r0) {
        sFirebaseAppId = r0;
    }

    private static boolean isAtLeastPreReleaseCodename(String r2, String r3) {
        if ("REL".equals(r3) == false) goto L5;
        return $assertionsDisabled;
    L5:
        Locale r0 = Locale.ROOT;
        if (r3.toUpperCase(r0).compareTo(r2.toUpperCase(r0)) < 0) goto L9;
        return true;
    L9:
        return $assertionsDisabled;
    }
}
