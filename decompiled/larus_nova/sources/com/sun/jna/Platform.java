package com.sun.jna;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public final class Platform {
    public static final int AIX = 7;
    public static final int ANDROID = 8;
    public static final String ARCH = null;
    public static final String C_LIBRARY_NAME = null;
    public static final int FREEBSD = 4;
    public static final int GNU = 9;
    public static final boolean HAS_AWT = false;
    public static final boolean HAS_BUFFERS = false;
    public static final boolean HAS_DLL_CALLBACKS = false;
    public static final boolean HAS_JAWT = false;
    public static final int KFREEBSD = 10;
    public static final int LINUX = 1;
    public static final int MAC = 0;
    public static final String MATH_LIBRARY_NAME = null;
    public static final int NETBSD = 11;
    public static final int OPENBSD = 5;
    public static final String RESOURCE_PREFIX = null;
    public static final boolean RO_FIELDS = false;
    public static final int SOLARIS = 3;
    public static final int UNSPECIFIED = -1;
    public static final int WINDOWS = 2;
    public static final int WINDOWSCE = 6;
    private static final int osType = 0;

    private Platform() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String getNativeLibraryResourcePrefix() {
        String r100 = System.getProperty("jna.prefix");
        if (r100 == null) goto L6;
        return r100;
    L6:
        return getNativeLibraryResourcePrefix(getOSType(), System.getProperty("os.arch"), System.getProperty("os.name"));
    }

    public static final boolean is64Bit() {
        String r100 = System.getProperty("sun.arch.data.model", System.getProperty("com.ibm.vm.bitmode"));
        if (r100 != null) goto L5;
        String r101 = ARCH;
        if ("x86-64".equals(r101) == false) goto L9;
        return true;
    L9:
        if ("ia64".equals(r101) == false) goto L11;
        return true;
    L11:
        if ("ppc64".equals(r101) == false) goto L13;
        return true;
    L13:
        if ("ppc64le".equals(r101) == false) goto L15;
        return true;
    L15:
        if ("sparcv9".equals(r101) == false) goto L17;
        return true;
    L17:
        if ("mips64".equals(r101) == false) goto L19;
        return true;
    L19:
        if ("mips64el".equals(r101) == false) goto L21;
        return true;
    L21:
        if ("loongarch64".equals(r101) == false) goto L23;
        return true;
    L23:
        if ("amd64".equals(r101) == false) goto L25;
        return true;
    L25:
        if ("aarch64".equals(r101) == false) goto L28;
        return true;
    L28:
        if (Native.POINTER_SIZE == 8) goto L42;
        return false;
    L42:
        return true;
    L5:
        return BDLocationException.ERROR_RESTRICTED_MODE_ON.equals(r100);
    }

    public static final boolean isAIX() {
        if (osType != 7) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isARM() {
        String r100 = ARCH;
        if (r100.startsWith("arm") == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.startsWith("aarch") == true) goto L8;
        return false;
    }

    public static final boolean isAndroid() {
        if (osType != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isFreeBSD() {
        if (osType != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isGNU() {
        if (osType != 9) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isIntel() {
        if (ARCH.startsWith("x86") == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static final boolean isLinux() {
        if (osType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean isLoongArch() {
        return ARCH.startsWith("loongarch");
    }

    public static final boolean isMIPS() {
        String r100 = ARCH;
        if (r100.equals("mips") == false) goto L5;
        return true;
    L5:
        if (r100.equals("mips64") == false) goto L7;
        return true;
    L7:
        if (r100.equals("mipsel") == false) goto L9;
        return true;
    L9:
        if (r100.equals("mips64el") == true) goto L17;
        return false;
    L17:
        return true;
    }

    public static final boolean isMac() {
        if (osType != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNetBSD() {
        if (osType != 11) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isOpenBSD() {
        if (osType != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isPPC() {
        if (ARCH.startsWith("ppc") == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static final boolean isSPARC() {
        return ARCH.startsWith("sparc");
    }

    public static boolean isSoftFloat() {
        PolarisFileWrapper r100 = new PolarisFileWrapper("/proc/self/exe");     // Catch: SecurityException -> L7 IOException -> L9
        if (r100.exists() == false) goto L15;
    L6:
        return !ELFAnalyser.analyse(r100.getCanonicalPath()).isArmHardFloat();
    L15:
        return false;
    L9:
        e = move-exception;
        Logger.getLogger(Platform.class.getName()).log(Level.INFO, "Failed to read '/proc/self/exe' or the target binary.", e);
        return false;
    L7:
        e = move-exception;
        Logger.getLogger(Platform.class.getName()).log(Level.INFO, "SecurityException while analysing '/proc/self/exe' or the target binary.", e);
        return false;
    }

    public static final boolean isSolaris() {
        if (osType != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isWindows() {
        int r100 = osType;
        if (r100 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 6) goto L8;
        return false;
    }

    public static final boolean isWindowsCE() {
        if (osType != 6) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean iskFreeBSD() {
        if (osType != 10) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        String r100 = System.getProperty("os.name");
        boolean r101 = false;
        if (r100.startsWith("Linux") == false) goto L9;
        if ("dalvik".equals(System.getProperty("java.vm.name").toLowerCase()) == false) goto L7;
        osType = 8;
        System.setProperty("jna.nounpack", "true");
    L82:
        INVOKESTATIC_com_sun_jna_Platform_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.nio.Buffer");     // Catch: ClassNotFoundException -> L47
        boolean r102 = true;
    L48:
        int r103 = osType;
        if (r103 == 6) goto L53;
        if (r103 == 8) goto L53;
        if (r103 == 7) goto L53;
        boolean r104 = true;
    L54:
        HAS_AWT = r104;
        if (r104 == false) goto L58;
        if (r103 == 0) goto L58;
        boolean r105 = true;
    L59:
        HAS_JAWT = r105;
        HAS_BUFFERS = r102;
        if (r103 == 6) goto L62;
        boolean r106 = true;
    L63:
        RO_FIELDS = r106;
        String r107 = "coredll";
        if (r103 != 2) goto L66;
        String r108 = "msvcrt";
    L69:
        C_LIBRARY_NAME = r108;
        if (r103 != 2) goto L72;
        r107 = "msvcrt";
    L75:
        MATH_LIBRARY_NAME = r107;
        String r109 = getCanonicalArchitecture(System.getProperty("os.arch"), r103);
        ARCH = r109;
        if (r103 == 2) goto L78;
    L80:
        HAS_DLL_CALLBACKS = r101;
        RESOURCE_PREFIX = getNativeLibraryResourcePrefix();
        return;
    L78:
        if (r109.startsWith("aarch") == true) goto L80;
        r101 = true;
        goto L80
    L72:
        if (r103 == 6) goto L75;
        r107 = "m";
        goto L75
    L66:
        if (r103 != 6) goto L68;
        r108 = "coredll";
        goto L69
    L68:
        r108 = "c";
        goto L69
    L62:
        r106 = false;
    L58:
        r105 = false;
    L53:
        r104 = false;
    L47:
        r102 = false;
        goto L48
    L7:
        osType = 1;
        goto L82
    L9:
        if (r100.startsWith("AIX") == false) goto L12;
        osType = 7;
        goto L82
    L12:
        if (r100.startsWith("Mac") == false) goto L14;
    L44:
        osType = 0;
        goto L82
    L14:
        if (r100.startsWith("Darwin") == true) goto L44;
        if (r100.startsWith("Windows CE") == false) goto L20;
        osType = 6;
        goto L82
    L20:
        if (r100.startsWith("Windows") == false) goto L23;
        osType = 2;
        goto L82
    L23:
        if (r100.startsWith("Solaris") == false) goto L25;
    L43:
        osType = 3;
        goto L82
    L25:
        if (r100.startsWith("SunOS") == true) goto L43;
        if (r100.startsWith("FreeBSD") == false) goto L31;
        osType = 4;
        goto L82
    L31:
        if (r100.startsWith("OpenBSD") == false) goto L34;
        osType = 5;
        goto L82
    L34:
        if (r100.equalsIgnoreCase("gnu") == false) goto L37;
        osType = 9;
        goto L82
    L37:
        if (r100.equalsIgnoreCase("gnu/kfreebsd") == false) goto L40;
        osType = 10;
        goto L82
    L40:
        if (r100.equalsIgnoreCase("netbsd") == false) goto L42;
        osType = 11;
        goto L82
    L42:
        osType = -1;
        goto L82
    }

    public static final boolean hasRuntimeExec() {
        if (isWindowsCE() == true) goto L5;
        return true;
    L5:
        if ("J9".equals(System.getProperty("java.vm.name")) == false) goto L10;
        return false;
    L10:
        return true;
    }

    public static final boolean isX11() {
        if (isWindows() == false) goto L5;
    L7:
        return false;
    L5:
        if (isMac() == true) goto L7;
        return true;
    }

    public static final int getOSType() {
        return osType;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_sun_jna_Platform_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    public static String getCanonicalArchitecture(String r100, int r101) {
        String r102 = r100.toLowerCase().trim();
        if ("powerpc".equals(r102) == false) goto L6;
        r102 = "ppc";
    L24:
        if ("ppc64".equals(r102) == false) goto L29;
        if ("little".equals(System.getProperty("sun.cpu.endian")) == false) goto L29;
        r102 = "ppc64le";
    L29:
        if ("arm".equals(r102) == true) goto L31;
        return r102;
    L31:
        if (r101 == 1) goto L33;
        return r102;
    L33:
        if (isSoftFloat() == false) goto L38;
        return "armel";
    L38:
        return r102;
    L6:
        if ("powerpc64".equals(r102) == false) goto L9;
        r102 = "ppc64";
        goto L24
    L9:
        if ("i386".equals(r102) == false) goto L11;
    L22:
        r102 = "x86";
        goto L24
    L11:
        if ("i686".equals(r102) == true) goto L22;
        if ("x86_64".equals(r102) == false) goto L16;
    L21:
        r102 = "x86-64";
        goto L24
    L16:
        if ("amd64".equals(r102) == true) goto L21;
        if ("zarch_64".equals(r102) == false) goto L24;
        r102 = "s390x";
        goto L24
    }

    public static String getNativeLibraryResourcePrefix(int r100, String r101, String r102) {
        String r103 = getCanonicalArchitecture(r101, r100);
        switch(r100) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L4;
            case 8: goto L10;
            case 9: goto L4;
            case 10: goto L23;
            case 11: goto L22;
            default: goto L4;
        };
    L4:
        String r104 = r102.toLowerCase();
        int r105 = r104.indexOf(" ");
        if (r105 == (-1)) goto L21;
        r104 = r104.substring(0, r105);
    L21:
        return r104 + "-" + r103;
    L22:
        return "netbsd-" + r103;
    L23:
        return "kfreebsd-" + r103;
    L10:
        if (r103.startsWith("arm") == false) goto L24;
        r103 = "arm";
    L24:
        return "android-".concat(r103);
    L25:
        return "w32ce-" + r103;
    L26:
        return "openbsd-" + r103;
    L27:
        return "freebsd-" + r103;
    L28:
        return "sunos-" + r103;
    L29:
        return "win32-" + r103;
    L30:
        return "linux-" + r103;
    L31:
        return "darwin-" + r103;
    }
}
