package com.bytedance.mira.pm.packageinfo;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.mira.Mira;
import com.bytedance.mira.event.PluginEventManager;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.signature.ApkSignatureSchemeV1Verifier;
import com.bytedance.mira.util.IOUtils;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.io.File;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes21.dex */
public class PackageInfoUtils {
    public PackageInfoUtils() {
    }

    private static String getPackage(int r100) {
        if ((r100 >>> 24) != 1) goto L6;
        return "android:";
    L6:
        return "";
    }

    public static PackageInfo getPackageInfo(File r100) {
        return getPackageInfo(r100, 0);
    L5:
        return null;
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

    public static PackageInfo getPackageInfo(File r110, int r111) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        AXmlResourceParser r100 = null;
        String r101 = null;
        r100 = null;
        PolarisZipFileWrapper r102 = new PolarisZipFileWrapper(r110);     // Catch: Throwable -> L65
        Enumeration<? extends ZipEntry> r103 = r102.entries();     // Catch: Throwable -> L77
        ZipEntry r104 = null;
    L11:
        if (r103.hasMoreElements() == false) goto L22;
        ZipEntry r105 = r103.nextElement();     // Catch: Throwable -> L20
        goto L80
    L14:
        if (r105.isDirectory() == false) goto L17;
    L18:
        r104 = r105;
        goto L11
    L17:
        if (ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME.equals(r105.getName()) == false) goto L18;
        r104 = r105;
    L20:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_INSTALL, "PackageInfoUtils entries.nextElement failed." + r110.getPath(), th);     // Catch: Throwable -> L77
        PluginEventManager.getInstance().notifyPluginErrorEvent(PluginEventManager.InstallStatusCode.INSTALL_CHECK_ZIP_ENTRY_FAILED, null, 0, th, System.currentTimeMillis());     // Catch: Throwable -> L77
    L22:
        if (r104 == null) goto L64;
        if (ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME.equals(r104.getName()) == false) goto L64;
        AXmlResourceParser r106 = new AXmlResourceParser();     // Catch: Throwable -> L77
        r106.open(r102.getInputStream(r104));     // Catch: Throwable -> L62
    L27:
        int r107 = r106.next();     // Catch: Throwable -> L62
        if (r107 == 1) goto L61;
        if (r107 != 2) goto L27;
        int r108 = r106.getAttributeCount();     // Catch: Throwable -> L62
        String r109 = null;
        String r112 = null;
        String r113 = null;
        int r114 = 0;
    L34:
        if (r114 == r108) goto L91;
        if ("versionName".equals(r106.getAttributeName(r114)) == false) goto L39;
        r109 = getAttributeValue(r106, r114);     // Catch: Throwable -> L62
    L47:
        r114 = r114 + 1;
        goto L34
    L39:
        if (RuleConditionBean.VERSION_CODE_KEY.equals(r106.getAttributeName(r114)) == false) goto L42;
        r101 = getAttributeValue(r106, r114);     // Catch: Throwable -> L62
        goto L47
    L42:
        if ("package".equals(r106.getAttributeName(r114)) == false) goto L45;
        r112 = getAttributeValue(r106, r114);     // Catch: Throwable -> L62
        goto L47
    L45:
        if ("sld_release_build".equals(r106.getAttributeName(r114)) == false) goto L47;
        r113 = getAttributeValue(r106, r114);     // Catch: Throwable -> L62
        goto L47
    L91:
        long r115 = Long.parseLong(r101);     // Catch: CustomGetPackageInfoFailedException -> L51 Throwable -> L62
    L53:
        if (r115 == (-1)) goto L59;
        PackageInfo r116 = new PackageInfo();     // Catch: Throwable -> L62
        r116.versionName = r109;     // Catch: Throwable -> L62
        r116.versionCode = (int) r115;     // Catch: Throwable -> L62
        r116.packageName = r112;     // Catch: Throwable -> L62
        ApplicationInfo r117 = new ApplicationInfo();     // Catch: Throwable -> L62
        r116.applicationInfo = r117;     // Catch: Throwable -> L62
        r117.metaData = new Bundle();     // Catch: Throwable -> L62
        r116.applicationInfo.metaData.putString("sld_release_build", r113);     // Catch: Throwable -> L62
        r106.close();     // Catch: Throwable -> L76
    L56:
        IOUtils.closeSilently(r102);
        return r116;
    L59:
        throw new CustomGetPackageInfoFailedException("versionCode获取失败: " + r101);     // Catch: Throwable -> L62
    L51:
        r115 = -1;
        goto L53
    L61:
        throw new CustomGetPackageInfoFailedException("已达到END_DOCUMENT");     // Catch: Throwable -> L62
    L62:
        r100 = r106;
    L64:
        throw new CustomGetPackageInfoFailedException("没有找到AndroidManifest.xml entry");     // Catch: Throwable -> L77
    L80:
        PackageInfo r118 = Mira.getAppContext().getPackageManager().getPackageArchiveInfo(r110.getPath(), r111);     // Catch: Throwable -> L71
        if (r100 != null) goto L94;
    L69:
        IOUtils.closeSilently(r102);
        return r118;
    L94:
        r100.close();     // Catch: Throwable -> L78
    L71:
        th = move-exception;
        if (r100 != null) goto L84;
    L74:
        IOUtils.closeSilently(r102);
        throw th;
    L84:
        r100.close();     // Catch: Throwable -> L79
    L65:
        r102 = null;
        goto L80
    L5:
        return Mira.getAppContext().getPackageManager().getPackageArchiveInfo(r110.getPath(), r111);
    }
}
