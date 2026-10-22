package n4a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f517286a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f517287b = null;

    static {
        f517286a = new String[]{"arm64-v8a", "x86_64"};
        f517287b = new String[]{"arm", "x86"};
        int r100 = 0;
    L4:
        if (r100 >= 80) goto L6;
        r100 = r100 + 1;
        goto L4
    }

    public static String b(long r100, String r101) {
        return new SimpleDateFormat(r101, Locale.CHINA).format(new Date(r100));
    L4:
        th = move-exception;
        n.a(th, "ut", "ctt");
        return null;
    }

    public static String c(Context r100) {
        if (Build.VERSION.SDK_INT < 28) goto L38;
    L8:
        String r101 = "";
    L10:
        if (Build.VERSION.SDK_INT < 28) goto L33;
        String[] r102 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);     // Catch: Throwable -> L30
        if (r102 == null) goto L17;
        if (r102.length <= 0) goto L17;
        r101 = r102[0];     // Catch: Throwable -> L30
    L17:
        if (TextUtils.isEmpty(r101) == true) goto L33;
        if (Arrays.asList(f517286a).contains(r101) == false) goto L33;
        String r103 = r100.getApplicationInfo().nativeLibraryDir;     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r103) == true) goto L33;
        String r104 = r103.substring(r103.lastIndexOf(File.separator) + 1);     // Catch: Throwable -> L30
        if (Arrays.asList(f517287b).contains(r104) == false) goto L33;
        String[] r105 = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null);     // Catch: Throwable -> L30
        if (r105 == null) goto L33;
        if (r105.length <= 0) goto L33;
        r101 = r105[0];     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        n.a(th, "ut", "gct_p");
    L33:
        if (TextUtils.isEmpty(r101) == true) goto L35;
        return r101;
    L35:
        return Build.CPU_ABI;
    L38:
        ApplicationInfo r106 = r100.getApplicationInfo();     // Catch: Throwable -> L6
        Field r107 = a(ApplicationInfo.class.getName()).getDeclaredField(MiraMonitor.KEY_PRIMARY_CPU_ABI);     // Catch: Throwable -> L6
        r107.setAccessible(true);     // Catch: Throwable -> L6
        r101 = (String) r107.get(r106);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        n.a(th, "ut", "gct");
        goto L8
    }

    public static String d(byte[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L14;
        return new String(r100, "UTF-8");
    L9:
        return new String(r100);
    L14:
        return "";
    }

    public static void f(ByteArrayOutputStream r100, byte r101, byte[] r102) {
        r100.write(new byte[]{r101});     // Catch: IOException -> L11
        int r103 = r101 & UByte.MAX_VALUE;     // Catch: IOException -> L11
        if (r103 >= 255) goto L8;
        if (r103 <= 0) goto L8;
        r100.write(r102);     // Catch: IOException -> L11
        return;
    L8:
        if (r103 != 255) goto L15;
        r100.write(r102, 0, 255);     // Catch: IOException -> L11
        return;
    L15:
        return;
    L11:
        e = move-exception;
        n.a(e, "ut", "wFie");
    }

    public static void g(ByteArrayOutputStream r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L15;
        int r102 = r101.length();
        if (r102 <= 255) goto L13;
        r102 = 255;
    L13:
        f(r100, (byte) r102, j(r101));
        return;
    L15:
        r100.write(new byte[]{0});     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        n.a(e, "ut", "wsf");
    }

    public static boolean h(JSONObject r100, String r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.has(r101) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static byte[] i(int r100) {
        return new byte[]{(byte) (r100 / 256), (byte) (r100 % 256)};
    }

    public static byte[] j(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100.getBytes("UTF-8");
    L9:
        return r100.getBytes();
    L5:
        return new byte[0];
    }

    public static byte[] n(byte[] r100) {
        return t(r100);
    L4:
        th = move-exception;
        n.a(th, "ut", "gZp");
        return new byte[0];
    }

    public static byte[] p() {
        String[] r100 = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");     // Catch: Throwable -> L13
        byte[] r101 = new byte[r100.length];     // Catch: Throwable -> L13
        int r102 = 0;
        int r103 = 0;
    L5:
        if (r103 >= r100.length) goto L7;
        r101[r103] = CastByteProtector.parseByte(r100[r103]);     // Catch: Throwable -> L13
        r103 = r103 + 1;     // Catch: Throwable -> L13
        goto L5
    L7:
        String[] r104 = new StringBuffer(new String(y4.e(new String(r101)))).reverse().toString().split(",");     // Catch: Throwable -> L13
        byte[] r105 = new byte[r104.length];     // Catch: Throwable -> L13
    L8:
        if (r102 >= r104.length) goto L12;
        r105[r102] = CastByteProtector.parseByte(r104[r102]);     // Catch: Throwable -> L13
        r102 = r102 + 1;
        goto L8
    L12:
        return r105;
    L13:
        th = move-exception;
        n.a(th, "ut", "gIV");
        return new byte[16];
    }

    public static PublicKey q() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream r100 = new ByteArrayInputStream(y4.e("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));     // Catch: Throwable -> L19
        CertificateFactory r101 = CertificateFactory.getInstance(o("IWC41MDk"));     // Catch: Throwable -> L26
        KeyFactory r102 = KeyFactory.getInstance(o("EUlNB"));     // Catch: Throwable -> L26
        Certificate r103 = r101.generateCertificate(r100);     // Catch: Throwable -> L26
        if (r103 == null) goto L29;
        if (r102 == null) goto L29;
        PublicKey r104 = r102.generatePublic(new X509EncodedKeySpec(r103.getPublicKey().getEncoded()));     // Catch: Throwable -> L26
        r100.close();     // Catch: Throwable -> L11
    L13:
        return r104;
    L11:
        th = move-exception;
        th.printStackTrace();
    L29:
        r100.close();     // Catch: Throwable -> L16
    L18:
        return null;
    L16:
        th = move-exception;
        th.printStackTrace();
    L20:
        if (r100 != null) goto L27;
    L25:
        return null;
    L27:
        r100.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
    L19:
        r100 = null;
        goto L20
    }

    public static void r(String r100) {
    L2:
        int r101 = 0;
        if (r100.length() < 78) goto L6;
        r100.substring(0, 78);
        r100 = r100.substring(78);
    L6:
        if (r101 >= (78 - r100.length())) goto L8;
        r101 = r101 + 1;
        goto L6
    }

    public static String s(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 != null) goto L6;
        return null;
    L6:
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L14;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L12;
        r103 = "0".concat(r103);
    L12:
        r101.append(r103);
        r102 = r102 + 1;
        goto L8
    L14:
        return r101.toString();
    }

    public static byte[] t(byte[] r100) throws IOException, Throwable {
        GZIPOutputStream r101 = null;
        if (r100 != null) goto L42;
        return null;
    L42:
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L19
        GZIPOutputStream r103 = new GZIPOutputStream(r102);     // Catch: Throwable -> L17
        r103.write(r100);     // Catch: Throwable -> L15
        r103.finish();     // Catch: Throwable -> L15
        byte[] r104 = r102.toByteArray();     // Catch: Throwable -> L15
        r103.close();     // Catch: Throwable -> L13
        r102.close();     // Catch: Throwable -> L11
        return r104;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        throw th;
    L15:
        th = th;
        r101 = r103;
    L46:
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r101 != null) goto L36;
    L28:
        if (r102 != null) goto L44;
    L33:
        throw th;
    L44:
        r102.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L36:
        r101.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L17:
        th = th;
    L19:
        th = th;
        r102 = null;
        goto L46
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static String k(String r100) {
        String r101 = null;
        if (r100 != null) goto L17;
        return null;
    L17:
        r101 = y4.g(j(r100));     // Catch: Throwable -> L8
    L15:
        return ((char) ((r101.length() % 26) + 65)) + r101;
    L12:
        th = move-exception;
        n.a(th, "ut", "tsfb64");
        return "";
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public static String l(Map<String, String> r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = ((HashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (r101.length() <= 0) goto L8;
        r101.append("&");
    L8:
        r101.append((String) r103.getKey());
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append((String) r103.getValue());
        goto L4
    L9:
        String r104 = r101.toString();
    L23:
        th = move-exception;
        n.a(th, "ut", "sPa");
        return r104;
    L11:
        if (TextUtils.isEmpty(r104) == true) goto L34;
        String[] r105 = r104.split("&");     // Catch: Throwable -> L23
        Arrays.sort(r105);     // Catch: Throwable -> L23
        StringBuffer r106 = new StringBuffer();     // Catch: Throwable -> L23
        int r107 = r105.length;     // Catch: Throwable -> L23
        int r108 = 0;
    L14:
        if (r108 >= r107) goto L19;
        String r109 = r105[r108];     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r109) == true) goto L18;
        r106.append(r109);     // Catch: Throwable -> L23
        r106.append("&");     // Catch: Throwable -> L23
    L18:
        r108 = r108 + 1;     // Catch: Throwable -> L23
        goto L14
    L19:
        String r110 = r106.toString();     // Catch: Throwable -> L23
        if (r110.length() <= 1) goto L35;
        return (String) r110.subSequence(0, r110.length() - 1);
    L35:
        return r104;
    L34:
        return "";
    }

    public static boolean m(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(l.f517452a) == false) goto L20;
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L26
        if (r101 == null) goto L17;
        String r102 = r101.getNetworkOperator();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r102) == true) goto L17;
        if (r102.length() < 3) goto L17;
        String r103 = r102.substring(0, 3);     // Catch: Throwable -> L26
    L18:
        l.f517452a = r103;
    L17:
        r103 = "";
    L20:
        if (TextUtils.isEmpty(l.f517452a) == false) goto L22;
        return false;
    L22:
        if (TextUtils.isDigitsOnly(l.f517452a) == true) goto L25;
        return false;
    L25:
        return ",202,204,206,208,212,213,214,216,218,219,220,222,225,226,228,230,231,232,234,235,238,240,242,244,246,247,248,250,255,257,259,260,262,266,268,270,272,274,276,278,280,282,283,284,286,288,289,290,292,293,294,295,297,302,308,310,311,312,313,314,315,316,310,330,332,334,338,340,342,344,346,348,350,352,354,356,358,360,362,363,364,365,366,368,370,372,374,376,400,401,402,404,405,406,410,412,413,414,415,416,417,418,419,420,421,422,424,425,426,427,428,429,430,431,432,434,436,437,438,440,441,450,452,454,455,456,457,466,467,470,472,502,505,510,514,515,520,525,528,530,534,535,536,537,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,555,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,645,646,647,648,649,650,651,652,653,654,655,657,659,702,704,706,708,710,712,714,716,722,724,730,732,734,736,738,740,742,744,746,748,750,901,".contains("," + l.f517452a + ",");
    }

    public static String o(String r100) {
        if (r100.length() >= 2) goto L7;
        return "";
    L7:
        return d(y4.e(r100.substring(1)));
    }

    public static void e(Context r100, String r101, String r110, JSONObject r111) {
        String r102 = v4.f(r100);
        String r103 = b5.a(r102);
        String r104 = v4.h(r100);     // Catch: Throwable -> L5
    L42:
        String r105 = "";
        if (r111.has("info") == false) goto L11;
        String r106 = JSONObjectProtectorUtils.getString(r111, "info");     // Catch: Throwable -> L39
    L13:
        if ("INVALID_USER_SCODE".equals(r106) == false) goto L27;
        if (r111.has("sec_code") == false) goto L17;
        String r107 = JSONObjectProtectorUtils.getString(r111, "sec_code");     // Catch: Throwable -> L39
    L19:
        if (r111.has("sec_code_debug") == false) goto L22;
        r105 = JSONObjectProtectorUtils.getString(r111, "sec_code_debug");     // Catch: Throwable -> L39
    L22:
        if (r103.equals(r107) == false) goto L24;
    L25:
        String r108 = "C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si";
    L36:
        o(r108);     // Catch: Throwable -> L39
        goto L37
    L24:
        if (r103.equals(r105) == false) goto L37;
    L17:
        r107 = "";
        goto L19
    L27:
        if ("INVALID_USER_KEY".equals(r106) == false) goto L37;
        if (r111.has("key") == false) goto L32;
        r105 = JSONObjectProtectorUtils.getString(r111, "key");     // Catch: Throwable -> L39
    L32:
        if (r105.length() <= 0) goto L37;
        if (r104.equals(r105) == true) goto L37;
        r108 = "C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=";
        goto L36
    L11:
        r106 = "";
    L37:
        r("SHA1Package:".concat(String.valueOf(r102)));
        r("key:".concat(String.valueOf(r104)));
        r("csid:".concat(String.valueOf(r101)));
        r("gsid:".concat(String.valueOf(r110)));
        r("json:" + r111.toString());
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        r104 = v4.f517834d;
        goto L42
    }
}
