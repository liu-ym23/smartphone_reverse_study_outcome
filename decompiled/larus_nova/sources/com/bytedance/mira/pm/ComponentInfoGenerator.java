package com.bytedance.mira.pm;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageParser;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.compat.q.DoubleReflector;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.ReflectUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.camera_export.CameraParam;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes21.dex */
public class ComponentInfoGenerator {
    public static final int PARSE_IGNORE_PROCESSES = 4;
    private static Field sAppInfoOverlayPathsField;
    private static Field sAppInfoResourceDirsField;

    public ComponentInfoGenerator() {
    }

    static {
        sAppInfoResourceDirsField = ReflectUtils.findDeclaredField(ApplicationInfo.class, "resourceDirs");
        sAppInfoOverlayPathsField = ReflectUtils.findDeclaredField(ApplicationInfo.class, "overlayPaths");
    }

    public static void addProcessName(ComponentInfo r100) {
        String r101 = r100.processName;
        if (r101 != null) goto L5;
    L6:
        r100.processName = r100.applicationInfo.processName;
        return;
    L5:
        if (r101.length() <= 0) goto L6;
    }

    public static ActivityInfo generateActivityInfo(PackageParser.Activity r100, int r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ActivityInfo r102 = new ActivityInfo(r100.info);
        if ((r101 & 128) == 0) goto L8;
        r102.metaData = r100.metaData;
    L8:
        r102.applicationInfo = generateApplicationInfo(r100.owner, r101);
        addProcessName(r102);
        return r102;
    }

    public static ApplicationInfo generateApplicationInfo(PackageParser.Package r100, int r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ApplicationInfo r102 = new ApplicationInfo(r100.applicationInfo);
        Plugin r103 = PluginManager.getInstance().getPlugin(r102.packageName);
        if ((r101 & 128) == 0) goto L8;
        r102.metaData = r100.mAppMetaData;
    L8:
        String r104 = r102.className;
        if (r104 == null) goto L11;
        r102.className = buildClassName(r102.packageName, r104, null);
    L12:
        if (r103 == null) goto L81;
        String r105 = PluginDirHelper.getSourceFile(r103.mPackageName, r103.mVersionCode);
    L27:
        if (r102.sourceDir != null) goto L31;
        if (r105 == null) goto L31;
        r102.sourceDir = r105;
    L31:
        if (r102.publicSourceDir != null) goto L35;
        if (r105 == null) goto L35;
        r102.publicSourceDir = r105;
    L35:
        if (r102.dataDir != null) goto L85;
        if (r103 == null) goto L38;
        r102.dataDir = Mira.getAppContext().getApplicationInfo().dataDir;
        goto L85
    L38:
        r102.dataDir = PluginDirHelper.getDataDir(r102.packageName);
    L85:
    L44:
        th = move-exception;
        th.printStackTrace();
    L83:
    L50:
        th = move-exception;
        th.printStackTrace();
    L53:
        if (MiraManager.getInstance().getParam().enableOptResourcesArch() == false) goto L65;
        ApplicationInfo r106 = Mira.getAppContext().getApplicationInfo();
        r102.publicSourceDir = r106.publicSourceDir;
        Field r107 = sAppInfoResourceDirsField;     // Catch: Throwable -> L62
        if (r107 == null) goto L58;
        r107.set(r102, r107.get(r106));     // Catch: Throwable -> L62
    L58:
        Field r108 = sAppInfoOverlayPathsField;     // Catch: Throwable -> L62
        if (r108 == null) goto L65;
        r108.set(r102, r108.get(r106));     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        th.printStackTrace();
    L65:
        if (r102.nativeLibraryDir != null) goto L72;
        if (r105 == null) goto L72;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r105);
        if (r109.getParentFile() == null) goto L72;
        if (r109.getParentFile().getParentFile() == null) goto L72;
        r102.nativeLibraryDir = new PolarisFileWrapper(r109.getParentFile().getParentFile(), "lib").getPath();
    L72:
        String r110 = Mira.getAppContext().getPackageName();
        String r111 = r102.packageName;
        String r112 = buildProcessName(r111, r111, r110, r101, null);
        r102.processName = r112;
        if (TextUtils.isEmpty(r112) == false) goto L75;
        r102.processName = r102.packageName;
    L75:
        r102.uid = Mira.getAppContext().getApplicationInfo().uid;
        r102.labelRes = Mira.getAppContext().getApplicationInfo().labelRes;
        r102.nonLocalizedLabel = Mira.getAppContext().getApplicationInfo().nonLocalizedLabel;
        return r102;
    L47:
        if (FieldUtils.readField(r102, "scanPublicSourceDir") != null) goto L53;
        FieldUtils.writeField(r102, "scanPublicSourceDir", r102.publicSourceDir);     // Catch: Throwable -> L50
        goto L53
    L40:
        if (FieldUtils.readField(r102, "scanSourceDir") != null) goto L42;
        FieldUtils.writeField(r102, "scanSourceDir", r102.sourceDir);     // Catch: Throwable -> L44
    L42:
        FieldUtils.writeField(r102, MiraMonitor.KEY_PRIMARY_CPU_ABI, Mira.getHostAbi());     // Catch: Throwable -> L44
        goto L83
    L81:
        String r113 = (String) FieldUtils.readField(DoubleReflector.getField(r100.getClass(), "codePath"), r100);     // Catch: IllegalAccessException -> L17
    L19:
        if (r113 == null) goto L79;
    L25:
        r105 = r113;
        goto L27
    L79:
        r105 = (String) FieldUtils.readField(DoubleReflector.getField(r100.getClass(), "baseCodePath"), r100);     // Catch: IllegalAccessException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L17:
        e = move-exception;
        e.printStackTrace();
        r113 = null;
        goto L19
    L11:
        r102.className = "android.app.Application";
        goto L12
    }

    public static PackageInfo generatePackageInfo(PackageParser.Package r100, int r110) {
        PackageInfo r101 = new PackageInfo();
        r101.packageName = r100.packageName;
        r101.versionCode = r100.mVersionCode;
        r101.versionName = r100.mVersionName;
        r101.applicationInfo = generateApplicationInfo(r100, r110);
        if ((r110 & 1) == 0) goto L24;
        int r102 = r100.activities.size();
        if (r102 <= 0) goto L24;
        int r103 = r110 & 512;
        if (r103 == 0) goto L9;
        r101.activities = new ActivityInfo[r102];
    L16:
        int r104 = 0;
        int r105 = 0;
    L17:
        if (r104 >= r102) goto L24;
        if (((PackageParser.Activity) ListProtector.get(r100.activities, r104)).info.enabled == true) goto L21;
        if (r103 != 0) goto L21;
    L22:
        r104 = r104 + 1;
    L21:
        r101.activities[r105] = generateActivityInfo((PackageParser.Activity) ListProtector.get(r100.activities, r104), r110);
        r105 = r105 + 1;
        goto L22
    L9:
        int r106 = 0;
        int r107 = 0;
    L10:
        if (r106 >= r102) goto L15;
        if (((PackageParser.Activity) ListProtector.get(r100.activities, r106)).info.enabled == false) goto L14;
        r107 = r107 + 1;
    L14:
        r106 = r106 + 1;
        goto L10
    L15:
        r101.activities = new ActivityInfo[r107];
    L24:
        if ((r110 & 2) == 0) goto L45;
        int r108 = r100.receivers.size();
        if (r108 <= 0) goto L45;
        int r109 = r110 & 512;
        if (r109 == 0) goto L30;
        r101.receivers = new ActivityInfo[r108];
    L37:
        int r111 = 0;
        int r112 = 0;
    L38:
        if (r111 >= r108) goto L45;
        if (((PackageParser.Activity) ListProtector.get(r100.receivers, r111)).info.enabled == true) goto L42;
        if (r109 != 0) goto L42;
    L43:
        r111 = r111 + 1;
    L42:
        r101.receivers[r112] = generateActivityInfo((PackageParser.Activity) ListProtector.get(r100.receivers, r111), r110);
        r112 = r112 + 1;
        goto L43
    L30:
        int r113 = 0;
        int r114 = 0;
    L31:
        if (r113 >= r108) goto L36;
        if (((PackageParser.Activity) ListProtector.get(r100.receivers, r113)).info.enabled == false) goto L35;
        r114 = r114 + 1;
    L35:
        r113 = r113 + 1;
        goto L31
    L36:
        r101.receivers = new ActivityInfo[r114];
    L45:
        if ((r110 & 4) == 0) goto L66;
        int r115 = r100.services.size();
        if (r115 <= 0) goto L66;
        int r116 = r110 & 512;
        if (r116 == 0) goto L51;
        r101.services = new ServiceInfo[r115];
    L58:
        int r117 = 0;
        int r118 = 0;
    L59:
        if (r117 >= r115) goto L66;
        if (((PackageParser.Service) ListProtector.get(r100.services, r117)).info.enabled == true) goto L63;
        if (r116 != 0) goto L63;
    L64:
        r117 = r117 + 1;
    L63:
        r101.services[r118] = generateServiceInfo((PackageParser.Service) ListProtector.get(r100.services, r117), r110);
        r118 = r118 + 1;
        goto L64
    L51:
        int r119 = 0;
        int r120 = 0;
    L52:
        if (r119 >= r115) goto L57;
        if (((PackageParser.Service) ListProtector.get(r100.services, r119)).info.enabled == false) goto L56;
        r120 = r120 + 1;
    L56:
        r119 = r119 + 1;
        goto L52
    L57:
        r101.services = new ServiceInfo[r120];
    L66:
        if ((r110 & 8) == 0) goto L87;
        int r121 = r100.providers.size();
        if (r121 <= 0) goto L87;
        int r122 = r110 & 512;
        if (r122 == 0) goto L72;
        r101.providers = new ProviderInfo[r121];
    L79:
        int r123 = 0;
        int r124 = 0;
    L80:
        if (r123 >= r121) goto L87;
        if (((PackageParser.Provider) ListProtector.get(r100.providers, r123)).info.enabled == true) goto L84;
        if (r122 != 0) goto L84;
    L85:
        r123 = r123 + 1;
    L84:
        r101.providers[r124] = generateProviderInfo((PackageParser.Provider) ListProtector.get(r100.providers, r123), r110);
        r124 = r124 + 1;
        goto L85
    L72:
        int r125 = 0;
        int r126 = 0;
    L73:
        if (r125 >= r121) goto L78;
        if (((PackageParser.Provider) ListProtector.get(r100.providers, r125)).info.enabled == false) goto L77;
        r126 = r126 + 1;
    L77:
        r125 = r125 + 1;
        goto L73
    L78:
        r101.providers = new ProviderInfo[r126];
    L87:
        if ((r110 & 4096) == 0) goto L97;
        int r127 = r100.permissions.size();
        if (r127 <= 0) goto L93;
        r101.permissions = new PermissionInfo[r127];
        int r128 = 0;
    L91:
        if (r128 >= r127) goto L93;
        r101.permissions[r128] = generatePermissionInfo((PackageParser.Permission) ListProtector.get(r100.permissions, r128), r110);
        r128 = r128 + 1;
    L93:
        int r129 = r100.requestedPermissions.size();
        if (r129 <= 0) goto L97;
        r101.requestedPermissions = new String[r129];
    L97:
        if ((r110 & 256) == 0) goto L99;
    L115:
        PackageInfo r130 = Mira.getAppContext().getPackageManager().getPackageInfo(Mira.getAppContext().getPackageName(), r110);     // Catch: Exception -> L102
    L103:
        if (r130 == null) goto L114;
        r101.gids = r130.gids;
        if ((r110 & 64) == 0) goto L114;
        if (r101.signatures != null) goto L114;
        Signature[] r131 = r130.signatures;
        if (r131 == null) goto L111;
        int r132 = r131.length;
    L112:
        if (r132 <= 0) goto L114;
        Signature[] r133 = new Signature[r132];
        r101.signatures = r133;
        System.arraycopy(r130.signatures, 0, r133, 0, r132);
        goto L114
    L111:
        r132 = 0;
    L114:
        return r101;
    L102:
        r130 = null;
        goto L103
    L99:
        if ((r110 & 64) == 0) goto L114;
        goto L114
    }

    public static PermissionInfo generatePermissionInfo(PackageParser.Permission r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r101 & 128) == 0) goto L8;
        PermissionInfo r102 = new PermissionInfo(r100.info);
        r102.metaData = r100.metaData;
        return r102;
    L8:
        return r100.info;
    }

    public static ProviderInfo generateProviderInfo(PackageParser.Provider r100, int r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ProviderInfo r102 = new ProviderInfo(r100.info);
        if ((r101 & 128) == 0) goto L9;
        r102.metaData = r100.metaData;
    L9:
        if ((r101 & 2048) != 0) goto L11;
        r102.uriPermissionPatterns = null;
    L11:
        r102.applicationInfo = generateApplicationInfo(r100.owner, r101);
        addProcessName(r102);
        return r102;
    }

    public static ServiceInfo generateServiceInfo(PackageParser.Service r100, int r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ServiceInfo r102 = new ServiceInfo(r100.info);
        if ((r101 & 128) == 0) goto L8;
        r102.metaData = r100.metaData;
    L8:
        r102.applicationInfo = generateApplicationInfo(r100.owner, r101);
        addProcessName(r102);
        return r102;
    }

    private static String validateName(String r100, boolean r101) {
        int r102 = r100.length();
        int r103 = 0;
        boolean r104 = false;
        boolean r105 = true;
    L3:
        if (r103 >= r102) goto L27;
        char r106 = r100.charAt(r103);
        if (r106 < 'a') goto L9;
        if (r106 > 'z') goto L9;
    L12:
        r105 = false;
    L24:
        r103 = r103 + 1;
    L9:
        if (r106 >= 'A') goto L11;
    L13:
        if (r105 == true) goto L22;
        if (r106 < '0') goto L19;
        if (r106 <= '9') goto L24;
    L19:
        if (r106 == '_') goto L24;
    L22:
        if (r106 != '.') goto L26;
        r104 = true;
        r105 = true;
        goto L24
    L26:
        return "bad character '" + r106 + "'";
    L11:
        if (r106 > 'Z') goto L13;
    L27:
        if (r104 == true) goto L31;
        if (r101 == false) goto L31;
        return "must have at least one '.' separator";
    L31:
        return null;
    }

    private static String buildClassName(String r100, CharSequence r101, String[] r102) {
        if (r101 != null) goto L5;
    L23:
        r102[0] = "Empty class name in package " + r100;
        return null;
    L5:
        if (r101.length() <= 0) goto L23;
        String r103 = r101.toString();
        char r104 = r103.charAt(0);
        if (r104 != '.') goto L12;
        return (r100 + r103).intern();
    L12:
        if (r103.indexOf(46) >= 0) goto L16;
        return (r100 + '.' + r103).intern();
    L16:
        if (r104 >= 'a') goto L18;
    L21:
        r102[0] = "Bad class name " + r103 + " in package " + r100;
        return null;
    L18:
        if (r104 > 'z') goto L21;
        return r103.intern();
    }

    private static String buildCompoundName(String r100, CharSequence r110, String r111, String[] r112) {
        String r113 = r110.toString();
        char r101 = r113.charAt(0);
        if (r100 != null) goto L5;
    L16:
        String r102 = validateName(r113, true);
        if (r102 == null) goto L23;
        if (CameraParam.TYPE_SYSTEM_CAMERA.equals(r113) == true) goto L23;
        r112[0] = "Invalid " + r111 + " name " + r113 + " in package " + r100 + ": " + r102;
        return null;
    L23:
        return r113.intern();
    L5:
        if (r101 != ':') goto L16;
        if (r113.length() >= 2) goto L10;
        r112[0] = "Bad " + r111 + " name " + r113 + " in package " + r100 + ": must be at least two characters";
        return null;
    L10:
        String r103 = validateName(r113.substring(1), false);
        if (r103 == null) goto L15;
        r112[0] = "Invalid " + r111 + " name " + r113 + " in package " + r100 + ": " + r103;
        return null;
    L15:
        return r100.concat(r113).intern();
    }

    private static String buildProcessName(String r100, String r101, CharSequence r102, int r103, String[] r104) {
        if ((r103 & 4) != 0) goto L5;
    L9:
        if (r102 != null) goto L11;
    L15:
        return r101;
    L11:
        if (r102.length() <= 0) goto L15;
        return buildCompoundName(r100, r102, "process", r104);
    L5:
        if (CameraParam.TYPE_SYSTEM_CAMERA.equals(r102) == true) goto L9;
        if (r101 != null) goto L8;
        return r100;
    L8:
        return r101;
    }
}
