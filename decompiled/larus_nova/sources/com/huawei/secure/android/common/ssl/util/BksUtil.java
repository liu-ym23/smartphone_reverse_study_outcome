package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public class BksUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278160a = "BksUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278161b = "com.huawei.hwid";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f278162c = "com.huawei.hwid";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f278163d = "com.huawei.hms";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f278164e = "com.huawei.hwid.tv";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Uri f278165f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f278166g = "files/hmsrootcas.bks";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f278167h = "4.0.2.300";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f278168i = "aegis";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f278169j = "hmsrootcas.bks";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f278170k = 604800000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f278171l = "last_update_time";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f278172m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f278173n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f278174o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String[] f278175p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f278176q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f278177r = "bks_hash";

    private static boolean a(int r100) {
        if (r100 < 40002300) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        f278165f = UriProtector.parse("content://com.huawei.hwid");
        f278175p = new String[]{"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539"};
    }

    private BksUtil() {
    }

    private static String a(Context r100) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return r100.createDeviceProtectedStorageContext().getFilesDir() + File.separator + f278168i;
    L6:
        return r100.getApplicationContext().getFilesDir() + File.separator + f278168i;
    }

    private static void b(Context r100) {
        ByteArrayInputStream r101 = null;
        InputStream r102 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), Uri.withAppendedPath(f278165f, f278166g));     // Catch: Throwable -> L29 Exception -> L32
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L25 Exception -> L27
    L42:
        byte[] r104 = new byte[1024];     // Catch: Exception -> L23 Throwable -> L38
    L7:
        int r105 = r102.read(r104);     // Catch: Exception -> L23 Throwable -> L38
        if (r105 <= (-1)) goto L10;
        r103.write(r104, 0, r105);     // Catch: Exception -> L23 Throwable -> L38
        goto L7
    L10:
        r103.flush();     // Catch: Exception -> L23 Throwable -> L38
        ByteArrayInputStream r106 = new ByteArrayInputStream(r103.toByteArray());     // Catch: Exception -> L23 Throwable -> L38
        String r107 = g.a(f278177r, "", r100);     // Catch: Throwable -> L19 Exception -> L21
        String r108 = b(r103.toByteArray());     // Catch: Throwable -> L19 Exception -> L21
        if (d(r100) == true) goto L14;
    L17:
        e.c(f278160a, "update bks and sp");     // Catch: Throwable -> L19 Exception -> L21
        a(r106, r100);     // Catch: Throwable -> L19 Exception -> L21
        g.b(f278177r, r108, r100);     // Catch: Throwable -> L19 Exception -> L21
    L18:
        d.a(r102);
        d.a(r103);
        d.a(r106);
        return;
    L14:
        if (r107.equals(r108) == false) goto L17;
        e.c(f278160a, "bks not update");     // Catch: Throwable -> L19 Exception -> L21
    L21:
        e = e;
        r101 = r106;
    L35:
        e.b(f278160a, "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());     // Catch: Throwable -> L38
        d.a(r102);
        d.a(r103);
        d.a(r101);
        return;
    L19:
        th = th;
        r101 = r106;
    L39:
        d.a(r102);
        d.a(r103);
        d.a(r101);
        throw th;
    L23:
        e = e;
    L27:
        e = e;
    L34:
        r103 = null;
    L25:
        th = th;
    L31:
        r103 = null;
        goto L39
    L38:
        th = th;
    L32:
        e = e;
        r102 = null;
    L29:
        th = th;
        r102 = null;
        goto L31
    }

    private static String c(byte[] r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.length == 0) goto L15;
        return a(MessageDigest.getInstance("SHA-256").digest(r100));
    L9:
        e = move-exception;
        e.getMessage();
        return "";
    L15:
        return "";
    }

    private static boolean d(Context r100) {
        return new PolarisFileWrapper(a(r100) + File.separator + "hmsrootcas.bks").exists();
    }

    public static synchronized InputStream getBksFromTss(Context r100) {
        monitor-enter(BksUtil.class);
        e.c(f278160a, "get bks from tss begin");     // Catch: Throwable -> L29
        if (r100 == null) goto L7;
        ContextUtil.setContext(r100);     // Catch: Throwable -> L29
    L7:
        Context r101 = ContextUtil.getInstance();     // Catch: Throwable -> L29
        if (r101 != null) goto L13;
        e.b(f278160a, "context is null");     // Catch: Throwable -> L29
        monitor-exit(BksUtil.class);
        return null;
    L13:
        if (b(f.a("com.huawei.hwid")) == true) goto L20;
        if (b(f.a("com.huawei.hms")) == true) goto L20;
        e.b(f278160a, "hms version code is too low : " + f.a("com.huawei.hwid"));     // Catch: Throwable -> L29
        monitor-exit(BksUtil.class);
        return null;
    L20:
        if (c(r101, "com.huawei.hwid") == false) goto L22;
    L26:
        b(r101);     // Catch: Throwable -> L29
        InputStream r102 = getFilesBksIS(r101);     // Catch: Throwable -> L29
        monitor-exit(BksUtil.class);
        return r102;
    L22:
        if (b(r101, "com.huawei.hms") == true) goto L26;
        e.b(f278160a, "hms sign error");     // Catch: Throwable -> L29
        monitor-exit(BksUtil.class);
        return null;
    L29:
        th = move-exception;
        throw th;
    }

    public static InputStream getFilesBksIS(Context r100) {
        if (d(r100) == false) goto L12;
        e.c(f278160a, "getFilesBksIS ");
        return new PolarisFileInputStreamWrapper(c(r100));
    L7:
        e.b(f278160a, "FileNotFoundExceptio: ");
        return null;
    L12:
        return null;
    }

    private static String a(byte[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L19;
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L13;
        String r104 = Integer.toHexString(r100[r103] & UByte.MAX_VALUE);
        if (r104.length() != 1) goto L11;
        r101.append('0');
    L11:
        r101.append(r104);
        r103 = r103 + 1;
        goto L7
    L13:
        return r101.toString();
    L19:
        return "";
    }

    private static boolean b(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return false;
    L5:
        e.c(f278160a, "hms version code is : " + r110);
        String[] r111 = r110.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r100 = f278167h.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        int r101 = r111.length;
        int r102 = r100.length;
        int r103 = Math.max(r101, r102);
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L26;
        if (r104 < r101) goto L27;
        int r105 = 0;
    L13:
        if (r104 >= r102) goto L20;
        int r106 = CastIntegerProtector.parseInt(r100[r104]);     // Catch: Exception -> L10
    L21:
        if (r105 < r106) goto L22;
        if (r105 > r106) goto L24;
        r104 = r104 + 1;
        goto L7
    L24:
        return true;
    L22:
        return false;
    L20:
        r106 = 0;
        goto L21
    L27:
        r105 = CastIntegerProtector.parseInt(r111[r104]);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.b(f278160a, " exception : " + e.getMessage());
        if (r104 < r102) goto L32;
        return true;
    L32:
        return false;
    L26:
        return true;
    }

    private static String c(Context r100) {
        return a(r100) + File.separator + "hmsrootcas.bks";
    }

    private static int a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return -1;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L10;
        e.e(f278160a, "The directory  has already exists");
        return 1;
    L10:
        if (r101.mkdirs() == false) goto L13;
        e.a(f278160a, "create directory  success");
        return 0;
    L13:
        e.b(f278160a, "create directory  failed");
        return -1;
    }

    private static String b(byte[] r100) {
        if (r100 != null) goto L9;
        return "";
    L9:
        MessageDigest r101 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L7
        r101.update(r100);     // Catch: NoSuchAlgorithmException -> L7
        return a(r101.digest());
    L7:
        e.b(f278160a, "inputstraem exception");
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static void a(InputStream r100, Context r101) {
        if (r100 == null) goto L30;
        if (r101 == null) goto L40;
        String r102 = a(r101);
        if (new PolarisFileWrapper(r102).exists() == true) goto L9;
        a(r102);
    L9:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, "hmsrootcas.bks");
        if (r103.exists() == false) goto L12;
        r103.delete();
    L12:
        ?? r104 = 0;
        PolarisFileOutputStreamWrapper r105 = null;
        e.c(f278160a, "write output stream ");     // Catch: IOException -> L31 Throwable -> L27
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r103);     // Catch: IOException -> L31 Throwable -> L27
        r104 = 2048(0x800, float:2.87E-42);
        byte[] r107 = new byte[2048];     // Catch: Throwable -> L21 IOException -> L23
    L16:
        int r108 = r100.read(r107, 0, 2048);     // Catch: Throwable -> L21 IOException -> L23
        if (r108 == (-1)) goto L20;
        r106.write(r107, 0, r108);     // Catch: Throwable -> L21 IOException -> L23
    L20:
        d.a(r106);
    L32:
        return;
    L23:
        r105 = r106;
    L21:
        th = th;
        r104 = r106;
    L28:
        d.a(r104);
        throw th;
    L27:
        th = th;
    L24:
        e.b(f278160a, " IOException");     // Catch: Throwable -> L27
        d.a(r105);
        r104 = r105;
        goto L32
    L40:
        return;
    }

    private static boolean b(Context r100, String r101) {
        return "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539".equalsIgnoreCase(c(a(r100, r101)));
    }

    private static boolean c(Context r100, String r101) {
        byte[] r102 = a(r100, r101);
        String[] r103 = f278175p;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        if (r103[r105].equalsIgnoreCase(c(r102)) == true) goto L6;
        r105 = r105 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static byte[] a(Context r100, String r101) {
        if (r100 == null) goto L20;
        if (TextUtils.isEmpty(r101) == true) goto L20;
        PackageManager r102 = r100.getPackageManager();     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L15
        if (r102 == null) goto L18;
        PackageInfo r103 = r102.getPackageInfo(r101, 64);     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L15
        if (r103 == null) goto L18;
        return r103.signatures[0].toByteArray();
    L18:
        return new byte[0];
    L15:
        e = move-exception;
        e.getMessage();
    L13:
        e = move-exception;
        e.getMessage();
    L20:
        return new byte[0];
    }
}
