package ku5;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ee.util.deviceinfo.Status;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.i0;
import com.ss.android.lark.utils.u;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import f06.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f506210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f506211b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f506212c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f506213d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f506214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f506215f = false;

    public static String e() {
        InputStream r100 = null;
        r100 = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();     // Catch: Throwable -> L13 IOException -> L15
        byte[] r101 = new byte[24];     // Catch: Throwable -> L13 IOException -> L15
        String r102 = "";
    L6:
        if (r100.read(r101) == (-1)) goto L9;
        r102 = r102 + new String(r101);     // Catch: Throwable -> L13 IOException -> L15
    L9:
        r100.close();     // Catch: IOException -> L11
    L31:
    L20:
        return r102.trim();
    L13:
        th = move-exception;
        if (r100 != null) goto L27;
    L26:
        throw th;
    L27:
        r100.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        r102 = "0";
        if (r100 == null) goto L20;
        r100.close();     // Catch: IOException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static long d() {
        Runtime r100 = Runtime.getRuntime();     // Catch: Throwable -> L5
        long r101 = (((r100.maxMemory() - r100.totalMemory()) + r100.freeMemory()) / 1024) / 1024;     // Catch: Throwable -> L5
        tt5.a.h("DeviceInfoUtils", "current JavaHeapFreeSize:" + r101 + "m");     // Catch: Throwable -> L5
        return r101;
    L5:
        th = move-exception;
        tt5.a.f("DeviceInfoUtils", th, false);
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.BufferedReader] */
    public static long h() {
        ?? r100 = "/proc/meminfo";
        PolarisFileReaderWrapper r101 = new PolarisFileReaderWrapper("/proc/meminfo");     // Catch: Throwable -> L24 IOException -> L26
        BufferedReader r102 = new BufferedReader(r101, 8192);     // Catch: Throwable -> L20 IOException -> L22
        String r103 = r102.readLine();     // Catch: IOException -> L18 Throwable -> L42
        String[] r104 = r103.split("\\s+");     // Catch: IOException -> L18 Throwable -> L42
        int r105 = r104.length;     // Catch: IOException -> L18 Throwable -> L42
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L8;
        tt5.a.h(r103, r104[r106] + "/t");     // Catch: IOException -> L18 Throwable -> L42
        r106 = r106 + 1;     // Catch: IOException -> L18 Throwable -> L42
        goto L6
    L8:
        long r107 = Integer.valueOf(r104[1]).intValue();     // Catch: IOException -> L18 Throwable -> L42
        r102.close();     // Catch: IOException -> L12
    L63:
        r101.close();     // Catch: IOException -> L16
    L41:
        return r107 / 1024;
    L16:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
    L18:
        IOException e100 = e;
    L28:
        e100.printStackTrace();     // Catch: Throwable -> L42
        if (r102 != null) goto L61;
    L34:
        if (r101 != null) goto L65;
    L39:
        r107 = 0;
        goto L41
    L65:
        r101.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L61:
        r102.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L34
    L22:
        e = move-exception;
        e100 = e;
        r102 = null;
    L20:
        th = move-exception;
        Throwable th10 = th;
        r100 = 0;
    L43:
        if (r100 != 0) goto L67;
    L48:
        if (r101 == null) goto L73;
        r101.close();     // Catch: IOException -> L51
        throw th10;
    L51:
        e = move-exception;
        e.printStackTrace();
        throw th10;
    L73:
        throw th10;
    L67:
        r100.close();     // Catch: IOException -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
        goto L48
    L42:
        th10 = th;
    L26:
        e = move-exception;
        r101 = null;
        e100 = e;
        r102 = null;
    L24:
        th = move-exception;
        r101 = null;
        th10 = th;
        r100 = 0;
        goto L43
    }

    public static long i() {
        long r100 = yu5.c.g(PatternProtector.compile("[^0-9]").matcher(Status.get(Process.myPid()).getValue("VmSize")).replaceAll("").trim(), 0) / 1024;     // Catch: Throwable -> L5
        tt5.a.h("DeviceInfoUtils", "vmSize:" + r100 + "M");     // Catch: Throwable -> L5
        return r100;
    L5:
        th = move-exception;
        tt5.a.f("DeviceInfoUtils", th, false);
        return -1;
    }

    public static boolean j() {
        Boolean r100 = f506210a;
        if (r100 == null) goto L104;
        return r100.booleanValue();
    L104:
        tt5.a.h("DeviceInfoUtils", "checkIsEmulator start");     // Catch: Exception -> L100
        String r101 = Build.FINGERPRINT;     // Catch: Exception -> L100
        String r102 = "";
        if (r101 == null) goto L11;
        String r103 = r101.toLowerCase();     // Catch: Exception -> L100
    L12:
        String r110 = Build.MODEL;     // Catch: Exception -> L100
        if (r110 == null) goto L15;
        String r111 = r110.toLowerCase();     // Catch: Exception -> L100
    L16:
        String r112 = Build.MANUFACTURER;     // Catch: Exception -> L100
        if (r112 == null) goto L19;
        String r113 = r112.toLowerCase();     // Catch: Exception -> L100
    L20:
        String r114 = Build.BRAND;     // Catch: Exception -> L100
        if (r114 == null) goto L23;
        String r115 = r114.toLowerCase();     // Catch: Exception -> L100
    L24:
        String r116 = Build.DEVICE;     // Catch: Exception -> L100
        if (r116 == null) goto L27;
        String r117 = r116.toLowerCase();     // Catch: Exception -> L100
    L28:
        String r118 = Build.PRODUCT;     // Catch: Exception -> L100
        if (r118 == null) goto L31;
        String r119 = r118.toLowerCase();     // Catch: Exception -> L100
    L32:
        String r120 = Build.HARDWARE;     // Catch: Exception -> L100
        if (r120 == null) goto L35;
        String r121 = r120.toLowerCase();     // Catch: Exception -> L100
    L36:
        String r122 = Build.BOARD;     // Catch: Exception -> L100
        if (r122 == null) goto L39;
        r102 = r122.toLowerCase();     // Catch: Exception -> L100
    L39:
        tt5.a.h("DeviceInfoUtils", "fingerprint: " + r103 + ", model: " + r111 + ", manufacturer: " + r113 + ", brand: " + r115 + ", device: " + r117 + ", product: " + r119 + ", hardware: " + r121 + ", board: " + r102);     // Catch: Exception -> L100
        if (r103.startsWith("generic") == false) goto L42;
    L99:
        boolean r104 = true;
    L102:
        f506210a = Boolean.valueOf(r104);
        tt5.a.h("DeviceInfoUtils", "isEmulator: " + f506210a);
        return f506210a.booleanValue();
    L42:
        if (r103.contains("vbox") == true) goto L99;
        if (r103.contains("test-keys") == true) goto L99;
        if (r111.contains("google_sdk") == true) goto L99;
        if (r111.contains("emulator") == true) goto L99;
        if (r111.contains("android sdk built for x86") == true) goto L99;
        if (r113.contains("genymotion") == true) goto L99;
        if (r115.startsWith("generic") == false) goto L58;
        if (r117.startsWith("generic") == true) goto L99;
    L58:
        if (r119.equals("google_sdk") == true) goto L99;
        if (r119.startsWith("sdk_gphone") == true) goto L99;
        if (r119.contains("vbox86p") == true) goto L99;
        if (r119.contains("nox") == true) goto L99;
        if (r121.contains("goldfish") == true) goto L99;
        if (r121.contains("ranchu") == true) goto L99;
        if (r121.contains("qemu") == true) goto L99;
        if (r121.contains("vbox") == true) goto L99;
        if (r121.contains("vbox86") == true) goto L99;
        if (r121.contains("nox") == true) goto L99;
        if (r121.contains("ttvm") == true) goto L99;
        if (r121.contains("bluestacks") == true) goto L99;
        if (r121.contains("cancro") == true) goto L99;
        if (r121.contains("intel") == true) goto L99;
        if (r121.contains("microvirt") == true) goto L99;
        if (r121.contains("android_x86") == true) goto L99;
        if (r121.contains("caas") == true) goto L99;
        if (r102.contains("nox") == true) goto L99;
        if (r102.contains("mumu") == true) goto L99;
        if (r102.contains("bluestacks") == true) goto L99;
    L98:
        r104 = false;
        goto L102
    L35:
        r121 = "";
        goto L36
    L31:
        r119 = "";
        goto L32
    L27:
        r117 = "";
        goto L28
    L23:
        r115 = "";
        goto L24
    L19:
        r113 = "";
        goto L20
    L15:
        r111 = "";
        goto L16
    L11:
        r103 = "";
    L100:
        e = move-exception;
        tt5.a.d("DeviceInfoUtils", "isEmulator error: " + e.getMessage());
        goto L98
    }

    public static boolean l() {
        if (f506215f == true) goto L5;
        return false;
    L5:
        String r100 = g("ro.mi.os.version.code");
        String r101 = g("ro.mi.os.version.name");
        String r102 = g("ro.mi.os.version.incremental");
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return false;
    L8:
        if (TextUtils.equals(r100, "unknown") == false) goto L10;
        return false;
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return false;
    L12:
        if (TextUtils.equals(r101, "unknown") == false) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r102) == false) goto L16;
        return false;
    L16:
        if (TextUtils.equals(r102, "unknown") == true) goto L24;
        return true;
    L24:
        return false;
    }

    public static String m() {
        String r100 = "";
        if (TextUtils.isEmpty(f506214e) == false) goto L5;
        BufferedReader r101 = null;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper("/proc/cpuinfo");     // Catch: Throwable -> L34 IOException -> L38
        BufferedReader r103 = new BufferedReader(r102);     // Catch: Throwable -> L32 IOException -> L40
        goto L39
    L45:
        String r104 = r103.readLine();     // Catch: Throwable -> L29 IOException -> L31
    L10:
        if (r104 == null) goto L20;
        if (r104.startsWith("Hardware") == false) goto L18;
        if (r104.contains(":") == false) goto L18;
        String r105 = r104.substring(r104.indexOf(":") + 1);     // Catch: Throwable -> L29 IOException -> L31
        if (TextUtils.isEmpty(r105) == true) goto L18;
        f506214e = r105.trim();     // Catch: Throwable -> L29 IOException -> L31
    L18:
        r104 = r103.readLine();     // Catch: Throwable -> L29 IOException -> L31
    L20:
        if (TextUtils.isEmpty(f506214e) == false) goto L23;
        f506214e = g("ro.board.platform");     // Catch: Throwable -> L29 IOException -> L31
    L23:
        if (TextUtils.isEmpty(f506214e) == true) goto L26;
        r100 = f506214e;     // Catch: Throwable -> L29 IOException -> L31
    L26:
        b(r103);
    L27:
        b(r102);
        return r100;
    L31:
        r101 = r103;
    L29:
        th = th;
        r101 = r103;
    L36:
        b(r101);
        b(r102);
        throw th;
    L32:
        th = th;
    L39:
        b(r101);
        goto L27
    L38:
        r102 = null;
    L34:
        th = th;
        r102 = null;
        goto L36
    L5:
        return f506214e;
    }

    static {
        boolean r100 = i0.b();
        f506215f = r100;
        if (r100 == false) goto L6;
        com.ss.android.lark.base.embedded.b.g();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00ab -> B:50:0x00ac). Please report as a decompilation issue!!! */
    public static long f() {
        if (i() > 0) goto L6;
        return -1;
    L6:
        boolean r100 = false;
        if (f506212c != (-1)) goto L33;
        if (f506211b == null) goto L65;
    L27:
        f506212c = f506211b.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) ? 1 : 0;
        StringBuilder r101 = new StringBuilder("is64BitDevice:");
        if (f506212c != 1) goto L30;
        boolean r102 = true;
    L31:
        r101.append(r102);
        tt5.a.h("DeviceInfoUtils", r101.toString());
        goto L33
    L30:
        r102 = false;
        goto L31
    L65:
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L25
        if (Build.SUPPORTED_ABIS.length <= 0) goto L19;
        int r104 = 0;
    L13:
        String[] r105 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L25
        if (r104 >= r105.length) goto L21;
        r103.append(r105[r104]);     // Catch: Exception -> L25
        if (r104 == (r105.length - 1)) goto L18;
        r103.append(", ");     // Catch: Exception -> L25
    L18:
        r104 = r104 + 1;     // Catch: Exception -> L25
    L21:
        if (TextUtils.isEmpty(r103.toString()) == false) goto L23;
        f506211b = "";     // Catch: Exception -> L25
    L23:
        f506211b = r103.toString();     // Catch: Exception -> L25
        goto L27
    L19:
        r103 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        tt5.a.f("DeviceInfoUtils", e, false);
        f506211b = "";
    L33:
        if (f506212c != 1) goto L35;
        boolean r106 = true;
    L36:
        if (r106 == true) goto L38;
        long r107 = 2764;
        long r108 = i();
    L62:
        long r109 = r107 - r108;
    L63:
        tt5.a.h("DeviceInfoUtils", "free vm memory size:" + r109 + "m");
        return r109;
    L38:
        if (f506213d != (-1)) goto L56;
    L47:
        e = move-exception;
        tt5.a.f("DeviceInfoUtils", e, false);
    L49:
        ?? r110 = 0;
    L50:
        f506213d = r110;
        StringBuilder r111 = new StringBuilder("is64BitApp:");
        if (f506213d != 1) goto L53;
        boolean r112 = true;
    L54:
        r111.append(r112);
        tt5.a.h("DeviceInfoUtils", r111.toString());
        goto L56
    L53:
        r112 = false;
        goto L54
    L40:
        if (Build.VERSION.SDK_INT < 23) goto L42;
        r110 = Process.is64Bit();     // Catch: Exception -> L47
        goto L50
    L42:
        String r113 = System.getProperty("os.arch");     // Catch: Exception -> L47
        if (r113 == null) goto L49;
        if (r113.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) == false) goto L49;
        r110 = 1;
    L56:
        if (f506213d != 1) goto L58;
        r100 = true;
    L58:
        if (r100 == false) goto L60;
        r109 = Long.MAX_VALUE;
        goto L63
    L60:
        r107 = 3788;
        r108 = i();
        goto L62
    L35:
        r106 = false;
        goto L36
    }

    public static void b(Reader r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static String c(TelephonyManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        d r112 = r100.b(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimOperator();
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, r113, r111, true);
        return r113;
    }

    public static String g(String r100) {
        Class r101 = a();     // Catch: Exception -> L6
        return (String) r101.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r101, new Object[]{r100, "unknown"});
    L9:
        return "unknown";
    }

    public static boolean k(Context r100) {
        boolean r101 = u.f444781a;
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100.getResources().getConfiguration().screenLayout & 15) < 3) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        r102 = DeviceUtils.isPad();
    L11:
        if (r102 == false) goto L14;
        return r102;
    L14:
        if (u.f444782b == true) goto L16;
        return false;
    L16:
        if (u.f444781a == false) goto L18;
        int r103 = Settings.Global.getInt(r100.getContentResolver(), "device_posture", 0);
    L19:
        if (r103 != 3) goto L24;
        return true;
    L24:
        return false;
    L18:
        r103 = 0;
        goto L19
    L8:
        r102 = false;
        goto L9
    }
}
