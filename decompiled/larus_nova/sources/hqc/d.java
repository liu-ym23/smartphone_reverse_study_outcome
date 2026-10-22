package hqc;

import android.content.pm.PackageInfo;
import com.bytedance.mira.signature.ApkSignatureSchemeV1Verifier;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import mqc.i;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static e b(File r110) {
    L71:
        th = move-exception;
        a r100 = null;
        Throwable th10 = th;
        PolarisZipFileWrapper r101 = null;
    L100:
        PackageInfo r111 = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(r110.getPath(), 0);     // Catch: Throwable -> L85
        if (r111 != null) goto L80;
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th10);     // Catch: Throwable -> L85
        if (r100 != null) goto L109;
    L78:
        i.b(r101);
        return null;
    L109:
        r100.a();     // Catch: Throwable -> L93
        goto L78
    L80:
        e r102 = new e(r111.packageName, r111.versionCode);     // Catch: Throwable -> L85
        if (r100 != null) goto L114;
    L83:
        i.b(r101);
        return r102;
    L114:
        r100.a();     // Catch: Throwable -> L94
    L85:
        th = move-exception;
        if (r100 != null) goto L103;
    L88:
        i.b(r101);
        throw th;
    L103:
        r100.a();     // Catch: Throwable -> L95
        goto L88
    L4:
        if (r110.exists() == true) goto L7;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, r110.getAbsolutePath() + " not exists!");     // Catch: Throwable -> L71
        return null;
    L7:
        r101 = new PolarisZipFileWrapper(r110);     // Catch: Throwable -> L71
        ZipEntry r103 = r101.getEntry(ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME);     // Catch: Throwable -> L69
        if (r103 != null) goto L13;
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");     // Catch: Throwable -> L69
        i.b(r101);
        return null;
    L13:
        r100 = new a();     // Catch: Throwable -> L69
        InputStream r104 = r101.getInputStream(r103);     // Catch: Throwable -> L50
        r100.a();     // Catch: Throwable -> L50
        if (r104 == null) goto L101;
        r100.f486837c = new b(r104);     // Catch: Throwable -> L50
    L101:
    L66:
        e = move-exception;
        r100.a();     // Catch: Throwable -> L50
        throw e;     // Catch: Throwable -> L50
    L18:
        if (r100.f486837c == null) goto L65;
        r100.b();     // Catch: Throwable -> L50 IOException -> L66
        int r105 = r100.f486835a;     // Catch: Throwable -> L50 IOException -> L66
        if (r105 == 1) goto L22;
        if (r105 != 2) goto L101;
        if (r105 == 2) goto L31;
        int r106 = -1;
    L32:
        String r107 = null;
        String r112 = null;
        int r108 = 0;
    L33:
        if (r108 == r106) goto L96;
        int r113 = r100.f486838d[r100.c(r108) + 1];     // Catch: Throwable -> L50
        String r114 = "";
        if (r113 != (-1)) goto L38;
        String r115 = "";
    L40:
        if (RuleConditionBean.VERSION_CODE_KEY.equals(r115) == false) goto L42;
        r107 = a(r100, r108);     // Catch: Throwable -> L50
    L49:
        r108 = r108 + 1;
        goto L33
    L42:
        int r116 = r100.f486838d[r100.c(r108) + 1];     // Catch: Throwable -> L50
        if (r116 == (-1)) goto L47;
        r114 = r100.f486840f.a(r116);     // Catch: Throwable -> L50
    L47:
        if ("package".equals(r114) == false) goto L49;
        r112 = a(r100, r108);     // Catch: Throwable -> L50
        goto L49
    L38:
        r115 = r100.f486840f.a(r113);     // Catch: Throwable -> L50
        goto L40
    L96:
        int r109 = Integer.parseInt(r107);     // Catch: Throwable -> L54
    L55:
        if (r109 != (-1)) goto L60;
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:" + r107);     // Catch: Throwable -> L50
        r100.a();     // Catch: Throwable -> L91
    L58:
        i.b(r101);
        return null;
    L60:
        e r117 = new e(r112, r109);     // Catch: Throwable -> L50
        r100.a();     // Catch: Throwable -> L92
    L62:
        i.b(r101);
        return r117;
    L54:
        r109 = -1;
        goto L55
    L31:
        r106 = r100.f486838d.length / 5;     // Catch: Throwable -> L50
        goto L32
    L22:
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");     // Catch: Throwable -> L50
        r100.a();     // Catch: Throwable -> L90
    L24:
        i.b(r101);
        return null;
    L65:
        throw new IOException("Parser is not opened.");     // Catch: Throwable -> L50 IOException -> L66
    L50:
        th10 = th;
    L69:
        th10 = th;
        r100 = null;
        goto L100
    }

    public static String a(a r100, int r101) {
        int r102 = r100.f486838d[r100.c(r101) + 3];
        int r103 = r100.f486838d[r100.c(r101) + 4];
        String r104 = "";
        if (r102 != 3) goto L10;
        int r105 = r100.c(r101);
        int[] r106 = r100.f486838d;
        if (r106[r105 + 3] == 3) goto L24;
        int r107 = r106[r105 + 4];
        return "";
    L24:
        return r100.f486840f.a(r106[r105 + 2]);
    L10:
        if (r102 != 2) goto L17;
        Object[] r108 = new Object[2];
        if ((r103 >>> 24) != 1) goto L14;
        r104 = "android:";
    L14:
        r108[0] = r104;
        r108[1] = Integer.valueOf(r103);
        return String.format("?%s%08X", r108);
    L17:
        if (r102 < 16) goto L23;
        if (r102 > 31) goto L23;
        return String.valueOf(r103);
    L23:
        return String.format("<0x%X, type 0x%02X>", new Object[]{Integer.valueOf(r103), Integer.valueOf(r102)});
    }
}
