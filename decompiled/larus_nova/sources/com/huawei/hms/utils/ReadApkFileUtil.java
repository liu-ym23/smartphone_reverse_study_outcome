package com.huawei.hms.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.UByte;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* JADX INFO: loaded from: classes23.dex */
public class ReadApkFileUtil {
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277900a = "ReadApkFileUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f277901b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f277902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f277903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f277904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f277905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f277906g;

    public ReadApkFileUtil() {
    }

    private static boolean b() {
    L9:
        e = move-exception;
        HMSLog.i(f277900a, "verifyMDMSignatureV2 MDM verify Exception!:" + e.getMessage());
    L11:
        return false;
    L4:
        if (a(Base64.decode(EMUI10_PK, 0), a(f277906g, "SHA-256"), b(f277903d), RSAUtil.SIGNATURE_ALGORITHM) == false) goto L7;
        HMSLog.i(f277900a, "verifyMDMSignatureV2 verify successful!");     // Catch: Exception -> L9
        return true;
    L7:
        HMSLog.i(f277900a, "verifyMDMSignatureV2 verify failure!");     // Catch: Exception -> L9
        goto L11
    }

    private static boolean c() {
    L9:
        e = move-exception;
        HMSLog.i(f277900a, "verifyMDMSignatureV3 MDM verify Exception!:" + e.getMessage());
    L11:
        return false;
    L4:
        if (a(Base64.decode(EMUI11_PK, 0), a(f277906g, McElieceCCA2KeyGenParameterSpec.SHA384), b(f277904e), "SHA384withRSA") == false) goto L7;
        HMSLog.i(f277900a, "verifyMDMSignatureV3 verify successful!");     // Catch: Exception -> L9
        return true;
    L7:
        HMSLog.i(f277900a, "verifyMDMSignatureV3 verify failure!");     // Catch: Exception -> L9
        goto L11
    }

    static {
        f277901b = PatternProtector.compile("\\s*|\t|\r|\n");
        f277905f = null;
        f277906g = null;
    }

    private static boolean a() {
    L8:
        e = move-exception;
        HMSLog.i(f277900a, "verifyMDMSignatureV1 MDM verify Exception!:" + e.getMessage());
        return false;
    L3:
        if (a(b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), a(f277906g, "SHA-256"), b(f277902c), RSAUtil.SIGNATURE_ALGORITHM) == false) goto L6;
        HMSLog.i(f277900a, "verifyMDMSignatureV1 verify successful!");     // Catch: Exception -> L8
        return true;
    L6:
        HMSLog.i(f277900a, "verifyMDMSignatureV1 verify failure!");     // Catch: Exception -> L8
        return false;
    }

    public static boolean checkSignature() {
        if (f277904e == null) goto L7;
        return c();
    L7:
        if (f277903d == null) goto L11;
        return b();
    L11:
        if (f277902c != null) goto L13;
        return false;
    L13:
        return a();
    }

    private static byte[] a(ArrayList<String> r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        BufferedWriter r102 = new BufferedWriter(new OutputStreamWriter(r101, StandardCharsets.UTF_8));
        Collections.sort(r100);     // Catch: Throwable -> L8 Exception -> L10
        int r103 = r100.size();     // Catch: Throwable -> L8 Exception -> L10
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L6;
        String r105 = r100.get(r104);     // Catch: Throwable -> L8 Exception -> L10
        r102.write(r105, 0, r105.length());     // Catch: Throwable -> L8 Exception -> L10
        r102.write("\r\n", 0, 2);     // Catch: Throwable -> L8 Exception -> L10
        r104 = r104 + 1;     // Catch: Throwable -> L8 Exception -> L10
        goto L4
    L6:
        r102.flush();     // Catch: Throwable -> L8 Exception -> L10
    L12:
        IOUtils.closeQuietly(r101);
        IOUtils.closeQuietly(r102);
        return r101.toByteArray();
    L8:
        th = move-exception;
        IOUtils.closeQuietly(r101);
        IOUtils.closeQuietly(r102);
        throw th;
    L10:
        e = move-exception;
        HMSLog.i(f277900a, "getManifestBytesbySorted Exception!" + e.getMessage());     // Catch: Throwable -> L8
        goto L12
    }

    private static void b(byte[] r100) {
        if (r100 != null) goto L5;
        HMSLog.e(f277900a, "manifest is null！");
        return;
    L5:
        StringBuffer r101 = new StringBuffer();
        ByteArrayInputStream r102 = null;
        BufferedReader r103 = null;
        BufferedReader r104 = null;
        r103 = null;
        f277902c = null;
        f277903d = null;
        f277904e = null;
        ByteArrayInputStream r105 = new ByteArrayInputStream(r100);     // Catch: Throwable -> L34 Exception -> L36
    L54:
        BufferedReader r106 = new BufferedReader(new InputStreamReader(r105, StandardCharsets.UTF_8));     // Catch: Throwable -> L32 Exception -> L47
        String r107 = a(r106);     // Catch: Throwable -> L29 Exception -> L31
    L9:
        if (r107 == null) goto L27;
        if (r107.length() == 0) goto L26;
        if (r107.startsWith("ApkHash:") == false) goto L17;
        f277905f = a(r107.substring(r107.indexOf(":") + 1));     // Catch: Throwable -> L29 Exception -> L31
    L17:
        if (r107.startsWith(KEY_SIGNATURE) == true) goto L18;
        if (r107.startsWith(KEY_SIGNATURE2) == true) goto L21;
        if (r107.startsWith(KEY_SIGNATURE3) == true) goto L24;
        r101.append(r107);     // Catch: Throwable -> L29 Exception -> L31
        r101.append("\r\n");     // Catch: Throwable -> L29 Exception -> L31
        goto L26
    L24:
        f277904e = a(r107.substring(r107.indexOf(":") + 1));     // Catch: Throwable -> L29 Exception -> L31
        r107 = a(r106);     // Catch: Throwable -> L29 Exception -> L31
        goto L9
    L21:
        f277903d = a(r107.substring(r107.indexOf(":") + 1));     // Catch: Throwable -> L29 Exception -> L31
        r107 = a(r106);     // Catch: Throwable -> L29 Exception -> L31
        goto L9
    L18:
        f277902c = a(r107.substring(r107.indexOf(":") + 1));     // Catch: Throwable -> L29 Exception -> L31
        r107 = a(r106);     // Catch: Throwable -> L29 Exception -> L31
    L26:
        r107 = a(r106);     // Catch: Throwable -> L29 Exception -> L31
        goto L9
    L27:
        f277906g = r101.toString();     // Catch: Throwable -> L29 Exception -> L31
    L39:
        IOUtils.closeQuietly(r105);
        IOUtils.closeQuietly(r106);
        return;
    L31:
        r103 = r106;
    L29:
        Throwable th10 = th;
    L44:
        r104 = r106;
    L45:
        IOUtils.closeQuietly(r105);
        IOUtils.closeQuietly(r104);
        throw th10;
    L32:
        th = move-exception;
        th10 = th;
    L48:
        HMSLog.e(f277900a, "loadApkCert Exception!");     // Catch: Throwable -> L41
        r106 = r103;
    L41:
        th = move-exception;
        th10 = th;
        r106 = r103;
        r102 = r105;
    L43:
        r105 = r102;
    L36:
        r105 = null;
    L34:
        th = move-exception;
        th10 = th;
        r106 = null;
        goto L43
    }

    public static String bytesToString(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        char[] r101 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        char[] r102 = new char[r100.length * 2];
        int r103 = 0;
    L7:
        if (r103 >= r100.length) goto L10;
        int r104 = r100[r103] & UByte.MAX_VALUE;
        int r105 = r103 * 2;
        r102[r105] = r101[r104 >>> 4];
        r102[r105 + 1] = r101[r104 & 15];
        r103 = r103 + 1;
        goto L7
    L10:
        return String.valueOf(r102);
    }

    public static String getHmsPath(Context r100) {
        return r100.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
    L4:
        HMSLog.e(f277900a, "HMS is not found!");
        return null;
    }

    public static boolean isCertFound(String r100) {
        boolean r101 = false;
        PolarisZipFileWrapper r102 = null;
        PolarisZipFileWrapper r103 = new PolarisZipFileWrapper(r100);     // Catch: Throwable -> L19 Exception -> L21
    L17:
        e = e;
        r102 = r103;
    L22:
        HMSLog.e(f277900a, "isCertFound Exception!" + e.getMessage());     // Catch: Throwable -> L19
        if (r102 != null) goto L41;
    L36:
        return r101;
    L41:
        r102.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        HMSLog.e(f277900a, "zipFile.close Exception!" + e.getMessage());
    L15:
        th = th;
    L30:
        if (r103 != null) goto L44;
    L35:
        throw th;
    L44:
        r103.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        HMSLog.e(f277900a, "zipFile.close Exception!" + e.getMessage());
        goto L35
    L5:
        if (r103.getEntry("META-INF/HUAWEI.CER") == null) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L39;
        b(a(r103, "META-INF/HUAWEI.CER"));     // Catch: Throwable -> L15 Exception -> L17
    L39:
        r103.close();     // Catch: IOException -> L12
    L14:
        r101 = r104;
    L12:
        e = move-exception;
        HMSLog.e(f277900a, "zipFile.close Exception!" + e.getMessage());
        goto L14
    L7:
        r104 = false;
    L19:
        th = th;
        r103 = r102;
    L21:
        e = e;
        goto L22
    }

    public static boolean verifyApkHash(String r100) {
        PolarisZipFileWrapper r101 = null;
        PolarisZipFileWrapper r102 = new PolarisZipFileWrapper(r100);     // Catch: Throwable -> L25 Exception -> L27
        byte[] r103 = a(r102);     // Catch: Throwable -> L21 Exception -> L23
        ArrayList<String> r104 = a(r103);     // Catch: Throwable -> L21 Exception -> L23
        if (r104 == null) goto L7;
        r103 = a(r104);     // Catch: Throwable -> L21 Exception -> L23
    L7:
        MessageDigest r105 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L21 Exception -> L23
        r105.update(r103);     // Catch: Throwable -> L21 Exception -> L23
        String r106 = bytesToString(r105.digest());     // Catch: Throwable -> L21 Exception -> L23
        String r107 = f277905f;     // Catch: Throwable -> L21 Exception -> L23
        if (r107 == null) goto L49;
        if (r107.equals(r106) == false) goto L49;
        r102.close();     // Catch: Exception -> L13
        return true;
    L13:
        e = move-exception;
        HMSLog.i(f277900a, "close stream Exception!" + e.getMessage());
        return true;
    L49:
        r102.close();     // Catch: Exception -> L19
        return false;
    L19:
        e = move-exception;
        HMSLog.i(f277900a, "close stream Exception!" + e.getMessage());
        return false;
    L23:
        e = e;
        r101 = r102;
    L28:
        HMSLog.i(f277900a, "verifyApkHash Exception!" + e.getMessage());     // Catch: Throwable -> L25
        if (r101 == null) goto L58;
        r101.close();     // Catch: Exception -> L32
        return false;
    L32:
        e = move-exception;
        HMSLog.i(f277900a, "close stream Exception!" + e.getMessage());
        return false;
    L58:
        return false;
    L21:
        th = th;
    L37:
        if (r102 != null) goto L45;
    L42:
        throw th;
    L45:
        r102.close();     // Catch: Exception -> L40
    L40:
        e = move-exception;
        HMSLog.i(f277900a, "close stream Exception!" + e.getMessage());
    L27:
        e = e;
    L25:
        th = th;
        r102 = r101;
        goto L37
    }

    private static ArrayList<String> a(byte[] r100) {
        if (r100 != null) goto L6;
        HMSLog.e(f277900a, "manifest is null！");
        return null;
    L6:
        ArrayList<String> r101 = new ArrayList();
        ByteArrayInputStream r102 = new ByteArrayInputStream(r100);     // Catch: IOException -> L29
        BufferedReader r103 = new BufferedReader(new InputStreamReader(r102, StandardCharsets.UTF_8));     // Catch: Throwable -> L23
        if (a(r103, r101) == true) goto L14;
        r103.close();     // Catch: Throwable -> L23
        r102.close();     // Catch: IOException -> L29
        return null;
    L14:
        r103.close();     // Catch: Throwable -> L23
        r102.close();     // Catch: IOException -> L29
        return r101;
    L17:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: IOException -> L29
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L29
    L29:
        HMSLog.e(f277900a, "getManifestLinesArrary IOException!");
        return null;
    }

    private static byte[] b(String r100) {
        int r101 = 0;
        if (TextUtils.isEmpty(r100) == true) goto L5;
        int r102 = r100.length();
        if ((r102 % 2) != 0) goto L9;
        int r103 = r102 / 2;
    L10:
        byte[] r104 = new byte[r103];
    L11:
        if (r101 >= r102) goto L17;
        int r105 = r101 + 1;
        if (r105 >= r102) goto L15;
        r104[r101 / 2] = (byte) ((Character.digit(r100.charAt(r101), 16) << 4) + Character.digit(r100.charAt(r105), 16));
    L16:
        r101 = r101 + 2;
        goto L11
    L15:
        r104[r101 / 2] = (byte) (Character.digit(r100.charAt(r101), 16) << 4);
        goto L16
    L17:
        return r104;
    L9:
        r103 = (r102 / 2) + 1;
        goto L10
    L5:
        return new byte[0];
    }

    private static String a(BufferedReader r100) throws IOException {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.read();
        if (r101 != (-1)) goto L8;
        return null;
    L8:
        StringBuilder r102 = new StringBuilder(10);
    L9:
        if (r101 == (-1)) goto L18;
        char r103 = (char) r101;
        if (r103 == '\n') goto L18;
        if (r102.length() >= 4096) goto L17;
        r102.append(r103);
        r101 = r100.read();
        goto L9
    L17:
        throw new IOException("cert line is too long!");
    L18:
        String r104 = r102.toString();
        if (r104.isEmpty() == false) goto L21;
        return r104;
    L21:
        if (r104.endsWith("\r") == true) goto L23;
        return r104;
    L23:
        return r104.substring(0, r104.length() - 1);
    }

    private static String a(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        return f277901b.matcher(r100).replaceAll("");
    }

    private static byte[] a(ZipFile r100) {
        return a(r100, "META-INF/MANIFEST.MF");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private static byte[] a(ZipFile r100, String r101) {
        ZipEntry r102 = r100.getEntry(r101);
        ?? r103 = 0;
        r103 = 0;
        if (r102 != null) goto L58;
        return null;
    L58:
        InputStream r104 = r100.getInputStream(r102);     // Catch: Throwable -> L36 Exception -> L39
        if (r104 != null) goto L60;
        IOUtils.closeQuietly(r104);
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(null);
        return null;
    L60:
        BufferedInputStream r105 = new BufferedInputStream(r104);     // Catch: Throwable -> L32 Exception -> L34
    L54:
        byte[] r106 = new byte[4096];     // Catch: Throwable -> L28 Exception -> L30
        ByteArrayOutputStream r107 = new ByteArrayOutputStream();     // Catch: Throwable -> L28 Exception -> L30
    L62:
        ?? r108 = new BufferedOutputStream(r107);     // Catch: Throwable -> L24 Exception -> L26
    L56:
        int r109 = r105.read(r106, 0, 4096);     // Catch: Throwable -> L20 Exception -> L22
    L15:
        if (r109 <= 0) goto L17;
        r108.write(r106, 0, r109);     // Catch: Throwable -> L20 Exception -> L22
        r109 = r105.read(r106, 0, 4096);     // Catch: Throwable -> L20 Exception -> L22
        goto L15
    L17:
        r108.flush();     // Catch: Throwable -> L20 Exception -> L22
        byte[] r110 = r107.toByteArray();     // Catch: Throwable -> L20 Exception -> L22
        IOUtils.closeQuietly(r104);
        IOUtils.closeQuietly(r105);
        IOUtils.closeQuietly(r107);
        IOUtils.closeQuietly(r108);
        return r110;
    L22:
        Exception e100 = e;
    L52:
        HMSLog.i(f277900a, "getManifestBytes Exception!" + e100.getMessage());     // Catch: Throwable -> L46
        IOUtils.closeQuietly(r104);
        IOUtils.closeQuietly(r105);
        IOUtils.closeQuietly(r107);
        IOUtils.closeQuietly(r108);
        return null;
    L46:
        th = move-exception;
        Throwable th10 = th;
        ?? r111 = r108;
    L48:
        r105 = r105;
        ?? r112 = r111;
    L49:
        r103 = r112;
    L50:
        IOUtils.closeQuietly(r104);
        IOUtils.closeQuietly(r105);
        IOUtils.closeQuietly(r107);
        IOUtils.closeQuietly(r103);
        throw th10;
    L20:
        th = move-exception;
        th10 = th;
        r112 = r108;
    L26:
        e100 = e;
        r108 = 0;
    L24:
        th10 = th;
    L30:
        e100 = e;
        r107 = null;
    L42:
        r108 = r107;
    L28:
        th10 = th;
        r107 = null;
        r111 = 0;
    L34:
        e = move-exception;
        e100 = e;
    L41:
        r105 = null;
        r107 = null;
    L32:
        Throwable th11 = th;
    L38:
        th10 = th11;
        r105 = null;
        r107 = null;
        goto L50
    L39:
        e = move-exception;
        e100 = e;
        r104 = null;
    L36:
        th = move-exception;
        th11 = th;
        r104 = null;
        goto L38
    }

    private static boolean a(BufferedReader r100, ArrayList<String> r101) throws IOException {
        String r102 = a(r100);
        boolean r103 = false;
    L3:
        if (r102 == null) goto L18;
        if (r102.equals("Name: META-INF/HUAWEI.CER") == false) goto L15;
        String r104 = a(r100);
    L8:
        if (r104 == null) goto L13;
        if (r104.startsWith("Name:") == true) goto L11;
        r104 = a(r100);
        goto L8
    L11:
        r102 = r104;
    L13:
        r103 = true;
    L15:
        if (r102.length() == 0) goto L17;
        r101.add(r102);
    L17:
        r102 = a(r100);
        goto L3
    L18:
        return r103;
    }

    private static byte[] a(String r100, String r101) throws Exception {
        MessageDigest r102 = MessageDigest.getInstance(r101);
        r102.update(r100.getBytes(StandardCharsets.UTF_8.name()));
        return r102.digest();
    }

    private static boolean a(byte[] r100, byte[] r101, byte[] r102, String r103) throws Exception {
        Signature r104 = Signature.getInstance(r103);
        r104.initVerify(KeyFactory.getInstance(d.f25615a).generatePublic(new X509EncodedKeySpec(r100)));
        r104.update(r101);
        return r104.verify(r102);
    }
}
