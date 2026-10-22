package com.ss.android.socialbase.appdownloader.util.package_info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.bytedance.mira.signature.ApkSignatureSchemeV1Verifier;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.util.parser.PackageInfoParser;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes38.dex */
public class PackageInfoUtilsImpl {
    private static final String TAG = "PackageInfoUtilsImpl";

    public PackageInfoUtilsImpl() {
    }

    private static String getPackage(int r100) {
        if ((r100 >>> 24) != 1) goto L6;
        return "android:";
    L6:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    public static PackageInfo getPackageInfo(File r110) {
        int r100 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.APK_PARSER_ZIP_FILE);
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "getPackageInfo", "ParseType:" + r100);
    L6:
        if (r100 != 1) goto L10;
        return PackageInfoParser.parseWithJarFile(r110);
    L10:
        if (r100 != 2) goto L14;
        return PackageInfoParser.parseWithAntZipFile(r110);
    L14:
        if (r100 == 3) goto L16;
        AXmlResourceParser r101 = null;
        r101 = null;
        String r102 = null;
        r101 = null;
        r101 = null;
    L106:
        th = th;
        ?? r103 = r101;
        ?? r104 = r103;
        ?? r105 = r104;
    L161:
        Logger.globalError(TAG, "getPackageInfo", "Error:" + th);     // Catch: Throwable -> L110
        throw new CustomGetPackageInfoFailedException("throwable: " + th.getMessage() + th.toString());     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        if (r101 != null) goto L135;
    L115:
        if (r103 != 0) goto L140;
    L119:
        if (r105 != 0) goto L148;
    L123:
        if (r104 == 0) goto L184;
        r104.close();     // Catch: Throwable -> L129
        throw th;
    L185:
        throw th;
    L184:
        throw th;
    L148:
        r105.close();     // Catch: Throwable -> L122
        goto L123
    L140:
        r103.close();     // Catch: Throwable -> L118
        goto L119
    L135:
        r101.close();     // Catch: Throwable -> L114
        goto L115
    L20:
        if (Build.VERSION.SDK_INT < 24) goto L37;
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L106
        ZipInputStream r111 = new ZipInputStream(r106);     // Catch: Throwable -> L35
    L23:
        ZipEntry r107 = r111.getNextEntry();     // Catch: Throwable -> L35
        if (r107 == null) goto L34;
        if (r107.isDirectory() == false) goto L29;
        r111.closeEntry();     // Catch: Throwable -> L126
        goto L23
    L29:
        if (ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME.equals(r107.getName()) == true) goto L33;
        r111.closeEntry();     // Catch: Throwable -> L126
        goto L23
    L33:
        PolarisZipFileWrapper r108 = null;
        ZipEntry r109 = r107;
        PolarisFileInputStreamWrapper r112 = r106;
        ?? r113 = r111;
        InputStream r114 = r111;
    L51:
        if (r109 == null) goto L101;
    L102:
        th = move-exception;
        r103 = r114;
        th = th;
        r104 = r112;
        r105 = r108;
    L132:
        goto L161
    L53:
        if (ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME.equals(r109.getName()) == false) goto L101;
        AXmlResourceParser r115 = new AXmlResourceParser();     // Catch: Throwable -> L102
        r115.open(r114);     // Catch: Throwable -> L98
    L56:
        int r116 = r115.next();     // Catch: Throwable -> L98
        if (r116 == 1) goto L97;
        if (r116 != 2) goto L56;
        int r117 = r115.getAttributeCount();     // Catch: Throwable -> L98
        String r118 = null;
        String r119 = null;
        int r120 = 0;
    L60:
        if (r120 == r117) goto L144;
        if ("versionName".equals(r115.getAttributeName(r120)) == false) goto L65;
        r118 = getAttributeValue(r115, r120);     // Catch: Throwable -> L98
    L70:
        r120 = r120 + 1;
        goto L60
    L65:
        if (RuleConditionBean.VERSION_CODE_KEY.equals(r115.getAttributeName(r120)) == false) goto L68;
        r102 = getAttributeValue(r115, r120);     // Catch: Throwable -> L98
        goto L70
    L68:
        if ("package".equals(r115.getAttributeName(r120)) == false) goto L70;
        r119 = getAttributeValue(r115, r120);     // Catch: Throwable -> L98
        goto L70
    L144:
        long r121 = Long.parseLong(r102);     // Catch: CustomGetPackageInfoFailedException -> L74 Throwable -> L98
    L76:
        if (r121 == (-1)) goto L95;
        PackageInfo r122 = new PackageInfo();     // Catch: Throwable -> L98
        r122.versionName = r118;     // Catch: Throwable -> L98
        r122.versionCode = (int) r121;     // Catch: Throwable -> L98
        r122.packageName = r119;     // Catch: Throwable -> L98
        if (r113 == 0) goto L150;
        r113.closeEntry();     // Catch: Throwable -> L127
    L150:
        r115.close();     // Catch: Throwable -> L82
    L83:
        if (r114 != null) goto L157;
    L87:
        if (r108 != null) goto L130;
    L91:
        if (r112 != null) goto L137;
    L93:
        return r122;
    L137:
        r112.close();     // Catch: Throwable -> L128
        goto L93
    L130:
        r108.close();     // Catch: Throwable -> L90
        goto L91
    L157:
        r114.close();     // Catch: Throwable -> L86
        goto L87
    L95:
        throw new CustomGetPackageInfoFailedException("versionCode获取失败: " + r102);     // Catch: Throwable -> L98
    L74:
        r121 = -1;
        goto L76
    L97:
        throw new CustomGetPackageInfoFailedException("已达到END_DOCUMENT");     // Catch: Throwable -> L98
    L98:
        th = move-exception;
        r103 = r114;
        th = th;
        r101 = r115;
        r104 = r112;
        r105 = r108;
    L101:
        throw new CustomGetPackageInfoFailedException("没有找到AndroidManifest.xml entry");     // Catch: Throwable -> L102
    L34:
        r108 = null;
        r109 = r107;
        r112 = r106;
        r113 = r111;
        r114 = null;
    L35:
        th = th;
        r103 = 0;
        r105 = 0;
        r104 = r106;
        goto L132
    L37:
        PolarisZipFileWrapper r123 = new PolarisZipFileWrapper(r110);     // Catch: Throwable -> L106
        Enumeration<? extends ZipEntry> r124 = r123.entries();     // Catch: Throwable -> L104
        ZipEntry r125 = null;
    L40:
        if (r124.hasMoreElements() == false) goto L49;
        r125 = r124.nextElement();     // Catch: Throwable -> L104
        if (r125.isDirectory() == true) goto L40;
        if (ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME.equals(r125.getName()) == false) goto L40;
        InputStream r126 = r123.getInputStream(r125);     // Catch: Throwable -> L104
        r109 = r125;
        PolarisFileInputStreamWrapper r127 = null;
        InputStream r128 = r126;
    L50:
        r112 = r127;
        r113 = r127;
        r108 = r123;
        r114 = r128;
        goto L51
    L49:
        r128 = null;
        r109 = r125;
        r127 = null;
    L104:
        th = th;
        r103 = 0;
        r104 = 0;
        r105 = r123;
        goto L132
    L16:
        return PackageInfoParser.parseWithAndroidApi(r110);
    }

    private static String getAttributeValue(AXmlResourceParser r100, int r101) {
        int r102 = r100.getAttributeValueType(r101);
        int r103 = r100.getAttributeValueData(r101);
        if (r102 != 3) goto L7;
        return r100.getAttributeValue(r101);
    L7:
        if (r102 != 2) goto L11;
        return String.format("?%s%08X", new Object[]{getPackage(r103), Integer.valueOf(r103)});
    L11:
        if (r102 < 16) goto L17;
        if (r102 > 31) goto L17;
        return String.valueOf(r103);
    L17:
        return String.format("<0x%X, type 0x%02X>", new Object[]{Integer.valueOf(r103), Integer.valueOf(r102)});
    }

    public static String getAppNameByPackageInfo(Context r100, PackageInfo r101, String r102) {
        if (r101 == null) goto L14;
        ApplicationInfo r103 = r101.applicationInfo;
        if (r103 == null) goto L15;
        r103.sourceDir = r102;
        r103.publicSourceDir = r102;
        return r103.loadLabel(r100.getPackageManager()).toString();
    L8:
        e = move-exception;
        Logger.globalError(TAG, "getAppNameByPackageInfo", " Error:" + e);
        return null;
    L15:
        return null;
    L14:
        return null;
    }

    public static PackageInfo getPackageInfo(Context r100, File r101, int r102) {
        StringBuilder r103 = new StringBuilder("ApkFile:");
        if (r101 == null) goto L5;
        String r104 = r101.getAbsolutePath();
    L6:
        r103.append(r104);
        AppDownloadUtils.addStats("getPackageInfo_1", r103.toString());
        int r105 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.PARSE_PACKAGE_INFO_BY_READ_FILE_MODE);
        if (r105 != 1) goto L14;
        PackageInfo r106 = getPackageInfo(r101);     // Catch: Throwable -> L10
        AppDownloadUtils.addStats("getPackageInfo_2", AppDownloadUtils.getPackageInfoLog(r106));     // Catch: Throwable -> L10
        return r106;
    L10:
        th = move-exception;
        AppDownloadUtils.addStats("getPackageInfo_3", "Error:" + th);
        return null;
    L14:
        if (r105 != 2) goto L21;
        AppDownloadUtils.addStats("getPackageInfo_4", AppDownloadUtils.getPackageInfoLog(getPackageInfo(r101)));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        AppDownloadUtils.addStats("getPackageInfo_5", "packageInfo:" + th);
        PackageInfo r107 = getPackageInfoByPackageManager(r100, r101, r102);
        AppDownloadUtils.addStats("getPackageInfo_6", AppDownloadUtils.getPackageInfoLog(r107));
        return r107;
    L21:
        if (Build.VERSION.SDK_INT <= 29) goto L34;
        PackageInfo r108 = getPackageInfoByPackageManager(r100, r101, r102);
        AppDownloadUtils.addStats("getPackageInfo_10", AppDownloadUtils.getPackageInfoLog(r108));
        if (r108 == null) goto L38;
    L32:
        AppDownloadUtils.addStats("getPackageInfo_13", AppDownloadUtils.getPackageInfoLog(r108));
        return r108;
    L38:
        r108 = getPackageInfo(r101);     // Catch: Exception -> L30
        AppDownloadUtils.addStats("getPackageInfo_11", AppDownloadUtils.getPackageInfoLog(r108));     // Catch: Exception -> L30
    L30:
        e = move-exception;
        AppDownloadUtils.addStats("getPackageInfo_12", "Error:" + e);
        goto L32
    L34:
        r108 = getPackageInfo(r101);     // Catch: Throwable -> L24
        AppDownloadUtils.addStats("getPackageInfo_7", AppDownloadUtils.getPackageInfoLog(r108));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        AppDownloadUtils.addStats("getPackageInfo_8", "Error:" + th);
        r108 = getPackageInfoByPackageManager(r100, r101, r102);
        AppDownloadUtils.addStats("getPackageInfo_9", AppDownloadUtils.getPackageInfoLog(r108));
        goto L32
    L5:
        r104 = "null";
        goto L6
    }

    private static PackageInfo getPackageInfoByPackageManager(Context r100, File r101, int r102) {
        PackageManager r103 = r100.getPackageManager();     // Catch: Throwable -> L9
        if (r103 != null) goto L7;
        Logger.globalError(TAG, "getPackageInfoByPackageManager", "PackageManager is null");     // Catch: Throwable -> L9
        AppDownloadUtils.addStats("getPackageInfoByPackageManager_1", "PackageManager is null");     // Catch: Throwable -> L9
        return null;
    L7:
        PackageInfo r104 = r103.getPackageArchiveInfo(r101.getPath(), r102);     // Catch: Throwable -> L9
        AppDownloadUtils.addStats("getPackageInfoByPackageManager_2", AppDownloadUtils.getPackageInfoLog(r104));     // Catch: Throwable -> L9
        return r104;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getPackageInfoByPackageManager", "Error:" + th);
        AppDownloadUtils.addStats("getPackageInfoByPackageManager_3", "Error:" + th);
        return null;
    }
}
