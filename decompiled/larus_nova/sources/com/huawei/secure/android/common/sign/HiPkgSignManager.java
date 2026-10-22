package com.huawei.secure.android.common.sign;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.huawei.secure.android.common.util.LogsUtil;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public class HiPkgSignManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278055a = "HiPkgSignManager";

    public HiPkgSignManager() {
    }

    private static String a(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.length;
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L13;
        byte r104 = r100[r103];
        if ((r104 & UByte.MAX_VALUE) >= 16) goto L10;
        r102.append("0" + Integer.toHexString(r100[r103] & UByte.MAX_VALUE));
    L11:
        r103 = r103 + 1;
        goto L6
    L10:
        r102.append(Integer.toHexString(r104 & UByte.MAX_VALUE));
        goto L11
    L13:
        return r102.toString().toUpperCase(Locale.ENGLISH);
    }

    private static String b(byte[] r100) {
        return a(MessageDigest.getInstance("SHA-256").digest(r100));
    L4:
        e = move-exception;
        LogsUtil.e(f278055a, "NoSuchAlgorithmException" + e.getMessage());
        return "";
    }

    private static List<String> a(Signature[] r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L10:
        return r101;
    L5:
        if (r100.length == 0) goto L10;
        int r102 = r100.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L10;
        r101.add(b(r100[r103].toByteArray()));
        r103 = r103 + 1;
        goto L8
    }

    private static PackageInfo a(Context r100, String r101) {
        PackageManager r102 = r100.getPackageManager();     // Catch: Exception -> L6
        if (r102 == null) goto L12;
        return r102.getPackageArchiveInfo(r101, 64);
    L12:
        return null;
    L6:
        e = move-exception;
        LogsUtil.e(f278055a, "Exception : " + e.getMessage(), true);
        return null;
    }

    public static byte[] getInstalledAPPSignature(Context r100, String r101) {
        if (r100 != null) goto L5;
    L20:
        LogsUtil.e(f278055a, "packageName is null or context is null");
        return new byte[0];
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L20;
        PackageManager r102 = r100.getPackageManager();     // Catch: Exception -> L14 PackageManager.NameNotFoundException -> L16
        if (r102 == null) goto L19;
        PackageInfo r103 = r102.getPackageInfo(r101, 64);     // Catch: Exception -> L14 PackageManager.NameNotFoundException -> L16
        if (r103 == null) goto L19;
        return r103.signatures[0].toByteArray();
    L19:
        return new byte[0];
    L16:
        e = move-exception;
        LogsUtil.e(f278055a, "PackageManager.NameNotFoundException : " + e.getMessage(), true);
    L14:
        e = move-exception;
        LogsUtil.e(f278055a, "Exception : " + e.getMessage(), true);
        goto L19
    }

    public static String getInstalledAppHash(Context r100, String r101) {
        byte[] r102 = getInstalledAPPSignature(r100, r101);
        if (r102 != null) goto L5;
    L7:
        return "";
    L5:
        if (r102.length <= 0) goto L7;
        return b(r102);
    }

    public static List<String> getInstalledAppHashV2V3(Context r100, String r101) {
        PackageManager r102 = r100.getPackageManager();     // Catch: Throwable -> L29
        if (Build.VERSION.SDK_INT < 28) goto L17;
        PackageInfo r103 = r102.getPackageInfo(r101, AMapEngineUtils.HALF_MAX_P20_WIDTH);     // Catch: Throwable -> L29
        if (r103 == null) goto L16;
        SigningInfo r104 = r103.signingInfo;     // Catch: Throwable -> L29
        if (r104 == null) goto L16;
        if (r104.hasMultipleSigners() == false) goto L15;
        return a(r103.signingInfo.getApkContentsSigners());
    L15:
        return a(r103.signingInfo.getSigningCertificateHistory());
    L16:
        return null;
    L17:
        PackageInfo r105 = r102.getPackageInfo(r101, 64);     // Catch: Throwable -> L29
        if (r105 == null) goto L28;
        Signature[] r106 = r105.signatures;     // Catch: Throwable -> L29
        if (r106 == null) goto L28;
        if (r106.length == 0) goto L28;
        if (r106[0] == null) goto L28;
        return a(r106);
    L28:
        return null;
    }

    public static String getUnInstalledAPPPackageName(Context r100, String r101) {
        if (r100 != null) goto L5;
    L12:
        LogsUtil.e(f278055a, "archiveFilePath is null or context is null");
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        PackageInfo r102 = a(r100, r101);
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102.packageName;
    }

    public static byte[] getUnInstalledAPPSignature(Context r100, String r101) {
        if (r100 != null) goto L5;
    L16:
        LogsUtil.e(f278055a, "archiveFilePath is null or context is null");
        return new byte[0];
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        PackageInfo r102 = a(r100, r101);
        if (r102 == null) goto L13;
        Signature r103 = r102.signatures[0];
        if (r103 == null) goto L15;
        return r103.toByteArray();
    L15:
        return new byte[0];
    L13:
        LogsUtil.e(f278055a, "PackageInfo is null ");
        goto L15
    }

    public static String getUnInstalledAppHash(Context r100, String r101) {
        byte[] r102 = getUnInstalledAPPSignature(r100, r101);
        if (r102 != null) goto L5;
    L7:
        return "";
    L5:
        if (r102.length <= 0) goto L7;
        return b(r102);
    }

    public static boolean doCheckInstalled(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (r100 != null) goto L9;
        return false;
    L9:
        return r101.equalsIgnoreCase(getInstalledAppHash(r100, r102));
    L12:
        return false;
    }

    public static boolean doCheckInstalledV2V3(Context r100, List<String> r101, String r102) {
        if (TextUtils.isEmpty(r102) == true) goto L22;
        if (r101 == null) goto L22;
        if (r100 == null) goto L22;
        List<String> r103 = getInstalledAppHashV2V3(r100, r102);
        if (r103 != null) goto L10;
        return false;
    L10:
        ArrayList r104 = new ArrayList();
        Iterator<String> r105 = r101.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        r104.add(r105.next().toUpperCase(Locale.ENGLISH));
        goto L12
    L14:
        Iterator<String> r106 = r103.iterator();
    L16:
        if (r106.hasNext() == false) goto L20;
        if (r104.contains(r106.next()) == true) goto L16;
        return false;
    L20:
        return true;
    L22:
        return false;
    }

    public static boolean doCheckArchiveApk(Context r100, String r101, String r102, String r103) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (r100 != null) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r103) == true) goto L24;
        PackageInfo r104 = a(r100, r102);
        if (r104 == null) goto L21;
        String r105 = b(r104.signatures[0].toByteArray());
        String r106 = r104.packageName;
        if (r101.equalsIgnoreCase(r105) == true) goto L15;
        return false;
    L15:
        if (r103.equals(r106) == false) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L24:
        return false;
    L19:
        return false;
    }
}
