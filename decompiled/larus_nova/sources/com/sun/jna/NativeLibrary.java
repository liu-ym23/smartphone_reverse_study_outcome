package com.sun.jna;

import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.librarian.a;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.sun.jna.internal.Cleaner;
import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class NativeLibrary implements Closeable {
    private static final Level DEBUG_LOAD_LEVEL = null;
    private static final int DEFAULT_OPEN_OPTIONS = -1;
    private static final Logger LOG = null;
    private static final SymbolProvider NATIVE_SYMBOL_PROVIDER = null;
    private static Method addSuppressedMethod;
    private static final Map<String, Reference<NativeLibrary>> libraries = null;
    private static final LinkedHashSet<String> librarySearchPath = null;
    private static final Map<String, List<String>> searchPaths = null;
    private final int callFlags;
    private final Cleaner.Cleanable cleanable;
    private final String encoding;
    private final Map<String, Function> functions;
    private volatile long handle;
    private final String libraryName;
    private final String libraryPath;
    private final Map<String, ?> options;
    private final SymbolProvider symbolProvider;

    public static final class NativeLibraryDisposer implements Runnable {
        private long handle;

        public synchronized void com_sun_jna_NativeLibrary$NativeLibraryDisposer__run$___twin___() {
            monitor-enter(this);
            long r100 = this.handle;     // Catch: Throwable -> L13
            if (r100 != 0) goto L17;
        L11:
            monitor-exit(this);
            return;
        L17:
            Native.close(r100);     // Catch: Throwable -> L8
            this.handle = 0;     // Catch: Throwable -> L13
            goto L11
        L8:
            th = move-exception;
            this.handle = 0;     // Catch: Throwable -> L13
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            monitor-enter(this);
            com_sun_jna_NativeLibrary$NativeLibraryDisposer_com_larus_apm_impl_protector_RunnableLancet_run(this);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public NativeLibraryDisposer(long r100) {
            this.handle = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_sun_jna_NativeLibrary$NativeLibraryDisposer_com_larus_apm_impl_protector_RunnableLancet_run(NativeLibraryDisposer r100) {
            r100.com_sun_jna_NativeLibrary$NativeLibraryDisposer__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static /* synthetic */ void access$001(String r100) {
        System.loadLibrary(r100);
    }

    static {
        LOG = Logger.getLogger(NativeLibrary.class.getName());
        if (Native.DEBUG_LOAD == false) goto L5;
        Level r100 = Level.INFO;
    L6:
        DEBUG_LOAD_LEVEL = r100;
        NATIVE_SYMBOL_PROVIDER = new AnonymousClass1();
        libraries = new HashMap();
        searchPaths = new ConcurrentHashMap();
        librarySearchPath = new LinkedHashSet();
        if (Native.POINTER_SIZE == 0) goto L67;
        addSuppressedMethod = null;
        int r101 = 0;
        addSuppressedMethod = Throwable.class.getMethod("addSuppressed", new Class[]{Throwable.class});     // Catch: SecurityException -> L11 NoSuchMethodException -> L13
    L11:
        e = move-exception;
        Logger.getLogger(NativeLibrary.class.getName()).log(Level.SEVERE, "Failed to initialize 'addSuppressed' method", e);
    L14:
        String r102 = Native.getWebStartLibraryPath("jnidispatch");
        if (r102 == null) goto L18;
        librarySearchPath.add(r102);
    L18:
        if (System.getProperty("jna.platform.library.path") == null) goto L20;
    L64:
        librarySearchPath.addAll(initPaths("jna.platform.library.path"));
        return;
    L20:
        if (Platform.isWindows() == true) goto L64;
        if (Platform.isLinux() == false) goto L24;
    L31:
        StringBuilder r103 = new StringBuilder();
        if (Platform.isSolaris() == false) goto L34;
        String r104 = HTTP.URL_DEFAULT;
    L35:
        r103.append(r104);
        r103.append(Native.POINTER_SIZE * 8);
        String r105 = r103.toString();
    L36:
        String[] r106 = {"/usr/lib" + r105, "/lib" + r105, "/usr/lib", "/lib"};
        if (Platform.isLinux() == false) goto L39;
    L42:
        String r107 = getMultiArchPath();
        r106 = new String[]{"/usr/lib/" + r107, "/lib/" + r107, "/usr/lib" + r105, "/lib" + r105, "/usr/lib", "/lib"};
    L44:
        if (Platform.isLinux() == false) goto L52;
        ArrayList<String> r108 = getLinuxLdPaths();
        int r109 = r106.length - 1;
    L46:
        if (r109 < 0) goto L51;
        int r110 = r108.indexOf(r106[r109]);
        if (r110 == (-1)) goto L50;
        ListProtector.remove(r108, r110);
    L50:
        ListProtector.add(r108, 0, r106[r109]);
        r109 = r109 - 1;
        goto L46
    L51:
        r106 = (String[]) r108.toArray(new String[0]);
    L52:
        String r111 = "";
        String r112 = r111;
    L54:
        if (r101 >= r106.length) goto L62;
        PolarisFileWrapper r113 = new PolarisFileWrapper(r106[r101]);
        if (r113.exists() == false) goto L60;
        if (r113.isDirectory() == false) goto L60;
        r111 = r111 + r112 + r106[r101];
        r112 = File.pathSeparator;
    L60:
        r101 = r101 + 1;
        goto L54
    L62:
        if ("".equals(r111) == true) goto L64;
        System.setProperty("jna.platform.library.path", r111);
        goto L64
    L39:
        if (Platform.iskFreeBSD() == true) goto L42;
        if (Platform.isGNU() == false) goto L44;
    L34:
        r104 = "";
        goto L35
    L24:
        if (Platform.isSolaris() == true) goto L31;
        if (Platform.isFreeBSD() == true) goto L31;
        if (Platform.iskFreeBSD() == true) goto L31;
        r105 = "";
        goto L36
    L67:
        throw new Error("Native library not initialized");
    L5:
        r100 = Level.FINE;
        goto L6
    }

    public static void disposeAll() {
        Map<String, Reference<NativeLibrary>> r100 = libraries;
        monitor-enter(r100);
        LinkedHashSet r101 = new LinkedHashSet(r100.values());     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        NativeLibrary r103 = (NativeLibrary) ((Reference) r102.next()).get();
        if (r103 == null) goto L8;
        r103.close();
        goto L8
    L12:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private static ArrayList<String> getLinuxLdPaths() {
        ArrayList<String> r100 = new ArrayList();
        BufferedReader r101 = null;
        Process r102 = com_sun_jna_NativeLibrary_java_lang_Runtime_exec(Runtime.getRuntime(), "/sbin/ldconfig -p");     // Catch: Throwable -> L24 Exception -> L33
        BufferedReader r103 = new BufferedReader(new InputStreamReader(r102.getInputStream()));     // Catch: Throwable -> L21 Exception -> L23
    L58:
        String r104 = r103.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r104 == null) goto L46;
        int r105 = r104.indexOf(" => ");     // Catch: Throwable -> L18 Exception -> L20
        int r106 = r104.lastIndexOf(47);     // Catch: Throwable -> L18 Exception -> L20
        if (r105 == (-1)) goto L58;
        if (r106 == (-1)) goto L58;
        if (r105 >= r106) goto L58;
        String r107 = r104.substring(r105 + 4, r106);     // Catch: Throwable -> L18 Exception -> L20
        if (r100.contains(r107) == true) goto L58;
        r100.add(r107);     // Catch: Throwable -> L18 Exception -> L20
    L46:
        r103.close();     // Catch: IOException -> L41
    L48:
        r102.waitFor();     // Catch: InterruptedException -> L42
    L40:
        return r100;
    L20:
        r101 = r103;
    L18:
        th = th;
        r101 = r103;
    L26:
        if (r101 != null) goto L52;
    L30:
        if (r102 == null) goto L70;
        r102.waitFor();     // Catch: InterruptedException -> L43
        throw th;
    L71:
        throw th;
    L70:
        throw th;
    L52:
        r101.close();     // Catch: IOException -> L29
    L21:
        th = th;
    L34:
        if (r101 != null) goto L50;
    L38:
        if (r102 == null) goto L40;
    L50:
        r101.close();     // Catch: IOException -> L37
        goto L38
    L33:
        r102 = null;
    L24:
        th = th;
        r102 = null;
        goto L26
    }

    private static String getMultiArchPath() {
        String r100 = Platform.ARCH;
        if (Platform.iskFreeBSD() == false) goto L6;
        String r101 = "-kfreebsd";
    L9:
        String r102 = "-gnu";
        if (Platform.isIntel() == false) goto L16;
        if (Platform.is64Bit() == false) goto L14;
        r100 = "x86_64";
    L28:
        return r100 + r101 + r102;
    L14:
        r100 = "i386";
        goto L28
    L16:
        if (Platform.isPPC() == false) goto L22;
        if (Platform.is64Bit() == false) goto L20;
        r100 = "powerpc64";
        goto L28
    L20:
        r100 = "powerpc";
        goto L28
    L22:
        if (Platform.isARM() == false) goto L25;
        r100 = "arm";
        r102 = "-gnueabi";
        goto L28
    L25:
        if (r100.equals("mips64el") == false) goto L28;
        r102 = "-gnuabi64";
        goto L28
    L6:
        if (Platform.isGNU() == false) goto L8;
        r101 = "";
        goto L9
    L8:
        r101 = "-linux";
        goto L9
    }

    public static final synchronized NativeLibrary getProcess() {
        monitor-enter(NativeLibrary.class);
        NativeLibrary r100 = getInstance(null);     // Catch: Throwable -> L8
        monitor-exit(NativeLibrary.class);
        return r100;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        HashSet r100 = new HashSet();
        Map<String, Reference<NativeLibrary>> r101 = libraries;
        monitor-enter(r101);
        Iterator<Map.Entry<String, Reference<NativeLibrary>>> r102 = r101.entrySet().iterator();     // Catch: Throwable -> L24
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, Reference<NativeLibrary>> r103 = r102.next();     // Catch: Throwable -> L24
        if (r103.getValue().get() != this) goto L6;
        r100.add(r103.getKey());     // Catch: Throwable -> L24
        goto L6
    L10:
        Iterator r104 = r100.iterator();     // Catch: Throwable -> L24
    L12:
        if (r104.hasNext() == false) goto L14;
        String r105 = (String) r104.next();     // Catch: Throwable -> L24
        libraries.remove(r105);     // Catch: Throwable -> L24
        goto L12
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L24
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L17:
        if (this.handle == 0) goto L19;
        this.handle = 0;     // Catch: Throwable -> L21
        this.cleanable.clean();     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public File getFile() {
        if (this.libraryPath != null) goto L7;
        return null;
    L7:
        return new PolarisFileWrapper(this.libraryPath);
    }

    public String toString() {
        return "Native Library <" + this.libraryPath + "@" + this.handle + ">";
    }

    public void dispose() {
        close();
    }

    public String getName() {
        return this.libraryName;
    }

    public Map<String, ?> getOptions() {
        return this.options;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_sun_jna_NativeLibrary_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static /* synthetic */ boolean access$000(String r100) {
        return isVersionedName(r100);
    }

    public static final NativeLibrary getInstance(String r100) {
        return getInstance(r100, Collections.emptyMap());
    }

    private String getLibraryName(String r100) {
        String r101 = mapSharedLibraryName("---");
        int r102 = r101.indexOf("---");
        if (r102 > 0) goto L5;
    L7:
        int r103 = r100.indexOf(r101.substring(r102 + 3));
        if (r103 != (-1)) goto L10;
        return r100;
    L10:
        return r100.substring(0, r103);
    L5:
        if (r100.startsWith(r101.substring(0, r102)) == false) goto L7;
        r100 = r100.substring(r102);
        goto L7
    }

    public static final synchronized NativeLibrary getProcess(Map<String, ?> r100) {
        monitor-enter(NativeLibrary.class);
        NativeLibrary r101 = getInstance(null, r100);     // Catch: Throwable -> L8
        monitor-exit(NativeLibrary.class);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    private static List<String> initPaths(String r100) {
        String r101 = System.getProperty(r100, "");
        if ("".equals(r101) == true) goto L5;
        StringTokenizer r102 = new StringTokenizer(r101, File.pathSeparator);
        ArrayList r103 = new ArrayList();
    L8:
        if (r102.hasMoreTokens() == false) goto L12;
        String r104 = r102.nextToken();
        if ("".equals(r104) == true) goto L8;
        r103.add(r104);
        goto L8
    L12:
        return r103;
    L5:
        return Collections.emptyList();
    }

    private static boolean isVersionedName(String r100) {
        if (r100.startsWith("lib") == false) goto L18;
        int r101 = r100.lastIndexOf(".so.");
        if (r101 == (-1)) goto L18;
        int r102 = r101 + 4;
        if (r102 >= r100.length()) goto L18;
    L9:
        if (r102 >= r100.length()) goto L16;
        char r103 = r100.charAt(r102);
        if (Character.isDigit(r103) == true) goto L15;
        if (r103 == '.') goto L15;
        return false;
    L15:
        r102 = r102 + 1;
        goto L9
    L16:
        return true;
    L18:
        return false;
    }

    public static String mapSharedLibraryName(String r100) {
        if (Platform.isMac() == false) goto L16;
        if (r100.startsWith("lib") == true) goto L7;
    L11:
        String r101 = System.mapLibraryName(r100);
        if (r101.endsWith(".jnilib") == true) goto L14;
        return r101;
    L14:
        return r101.substring(0, r101.lastIndexOf(".jnilib")) + ".dylib";
    L7:
        if (r100.endsWith(".dylib") == false) goto L9;
    L10:
        return r100;
    L9:
        if (r100.endsWith(".jnilib") == false) goto L11;
    L16:
        if (Platform.isLinux() == true) goto L41;
        if (Platform.isFreeBSD() == true) goto L41;
        if (Platform.isAIX() == false) goto L32;
        if (isVersionedName(r100) == false) goto L25;
    L30:
        return r100;
    L25:
        if (r100.endsWith(".so") == true) goto L30;
        if (r100.startsWith("lib") == true) goto L30;
        if (r100.endsWith(".a") == true) goto L30;
    L45:
        String r102 = System.mapLibraryName(r100);
        if (Platform.isAIX() == true) goto L48;
        return r102;
    L48:
        if (r102.endsWith(".so") == true) goto L50;
        return r102;
    L50:
        return r102.replaceAll(".so$", ".a");
    L32:
        if (Platform.isWindows() == false) goto L45;
        if (r100.endsWith(".drv") == false) goto L36;
    L39:
        return r100;
    L36:
        if (r100.endsWith(".dll") == true) goto L39;
        if (r100.endsWith(".ocx") == false) goto L45;
    L41:
        if (isVersionedName(r100) == false) goto L43;
        return r100;
    L43:
        if (r100.endsWith(".so") == false) goto L45;
        return r100;
    }

    public static String[] matchFramework(String r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.isAbsolute() == true) goto L5;
        String[] r103 = {System.getProperty("user.home"), "", "/System"};
        if (r100.contains(".framework") == true) goto L19;
        r100 = r100 + ".framework/" + r100;
    L19:
        int r104 = 0;
    L20:
        if (r104 >= 3) goto L27;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103[r104] + "/Library/Frameworks/" + r100);
        if (r105.exists() == true) goto L24;
        r101.add(r105.getAbsolutePath());
        r104 = r104 + 1;
        goto L20
    L24:
        return new String[]{r105.getAbsolutePath()};
    L27:
        return (String[]) r101.toArray(new String[0]);
    L5:
        if (r100.contains(".framework") == true) goto L7;
        PolarisFileWrapper r106 = new PolarisFileWrapper(new PolarisFileWrapper(r102.getParentFile(), r102.getName() + ".framework"), r102.getName());
        if (r106.exists() == true) goto L14;
        r101.add(r106.getAbsolutePath());
        goto L27
    L14:
        return new String[]{r106.getAbsolutePath()};
    L7:
        if (r102.exists() == true) goto L9;
        r101.add(r102.getAbsolutePath());
        goto L27
    L9:
        return new String[]{r102.getAbsolutePath()};
    }

    private static int openFlags(Map<String, ?> r100) {
        Object r101 = r100.get(Library.OPTION_OPEN_FLAGS);
        if ((r101 instanceof Number) == true) goto L5;
        return -1;
    L5:
        return ((Number) r101).intValue();
    }

    public static double parseVersion(String r110) {
        int r100 = r110.indexOf(".");
        double r101 = 1.0d;
        double r102 = 0.0d;
    L3:
        if (r110 == null) goto L11;
        if (r100 == (-1)) goto L7;
        String r103 = r110.substring(0, r100);
        String r111 = r110.substring(r100 + 1);
        r100 = r111.indexOf(".");
        String r104 = r111;
        r110 = r103;
    L12:
        r102 = r102 + (((double) CastIntegerProtector.parseInt(r110)) / r101);
        r101 = r101 * 100.0d;
        r110 = r104;
    L10:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        r104 = null;
        goto L12
    L11:
        return r102;
    }

    public Function getFunction(String r100) {
        return getFunction(r100, this.callFlags);
    }

    public Pointer getGlobalVariableAddress(String r100) {
        return new Pointer(getSymbolAddress(r100));
    L4:
        e = move-exception;
        throw new UnsatisfiedLinkError("Error looking up '" + r100 + "': " + e.getMessage());
    }

    public long getSymbolAddress(String r100) {
        if (this.handle == 0) goto L7;
        return this.symbolProvider.getSymbolAddress(this.handle, r100, NATIVE_SYMBOL_PROVIDER);
    L7:
        throw new UnsatisfiedLinkError("Library has been unloaded");
    }

    public static final void addSearchPath(String r100, String r101) {
        Map<String, List<String>> r102 = searchPaths;
        List<String> r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = Collections.synchronizedList(new ArrayList());
        r102.put(r100, r103);
    L5:
        r103.add(r101);
    }

    private static void addSuppressedReflected(Throwable r100, Throwable r101) {
        Method r102 = addSuppressedMethod;
        if (r102 != null) goto L15;
        return;
    L15:
        r102.invoke(r100, new Object[]{r101});     // Catch: InvocationTargetException -> L8 Throwable -> L10 IllegalAccessException -> L12
        return;
    L10:
        e = move-exception;
        throw new RuntimeException("Failed to call addSuppressedMethod", e);
    }

    private static Process com_sun_jna_NativeLibrary_java_lang_Runtime_exec(Runtime r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    private static String findLibraryPath(String r100, Collection<String> r101) {
        if (new PolarisFileWrapper(r100).isAbsolute() == false) goto L5;
        return r100;
    L5:
        String r102 = mapSharedLibraryName(r100);
        Iterator<String> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L29;
        String r104 = r103.next();
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104, r102);
        if (r105.exists() == true) goto L11;
        if (Platform.isMac() == false) goto L7;
        if (r102.endsWith(".dylib") == false) goto L7;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r104, r102.substring(0, r102.lastIndexOf(".dylib")) + ".jnilib");
        if (r106.exists() == false) goto L7;
        return r106.getAbsolutePath();
    L11:
        return r105.getAbsolutePath();
    L29:
        return r102;
    }

    public static final NativeLibrary getInstance(String r100, Map<String, ?> r101) {
        HashMap r102 = new HashMap(r101);
        if (r102.get(Library.OPTION_CALLING_CONVENTION) != null) goto L6;
        r102.put(Library.OPTION_CALLING_CONVENTION, 0);
    L6:
        if (Platform.isLinux() == true) goto L12;
        if (Platform.isFreeBSD() == true) goto L12;
        if (Platform.isAIX() == true) goto L12;
    L14:
        Map<String, Reference<NativeLibrary>> r103 = libraries;
        monitor-enter(r103);
        Reference<NativeLibrary> r104 = r103.get(r100 + r102);     // Catch: Throwable -> L29
        if (r104 == null) goto L19;
        NativeLibrary r105 = r104.get();     // Catch: Throwable -> L29
    L20:
        if (r105 != null) goto L27;
        if (r100 != null) goto L23;
        NativeLibrary r106 = new NativeLibrary("<process>", null, Native.open(null, openFlags(r102)), r102);     // Catch: Throwable -> L29
    L24:
        r105 = r106;
        WeakReference r107 = new WeakReference(r105);     // Catch: Throwable -> L29
        r103.put(r105.getName() + r102, r107);     // Catch: Throwable -> L29
        File r108 = r105.getFile();     // Catch: Throwable -> L29
        if (r108 == null) goto L27;
        r103.put(r108.getAbsolutePath() + r102, r107);     // Catch: Throwable -> L29
        r103.put(r108.getName() + r102, r107);     // Catch: Throwable -> L29
        goto L27
    L23:
        r106 = loadLibrary(r100, r102);     // Catch: Throwable -> L29
    L27:
        monitor-exit(r103);     // Catch: Throwable -> L29
        return r105;
    L19:
        r105 = null;
    L29:
        th = move-exception;
        throw th;
    L12:
        if (Platform.C_LIBRARY_NAME.equals(r100) == false) goto L14;
        r100 = null;
        goto L14
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private static NativeLibrary loadLibrary(String r110, Map<String, ?> r111) {
        Logger r100 = LOG;
        Level r101 = DEBUG_LOAD_LEVEL;
        r100.log(r101, "Looking for library '" + r110 + "'");
        ArrayList r102 = new ArrayList();
        boolean r103 = new PolarisFileWrapper(r110).isAbsolute();
        LinkedHashSet r104 = new LinkedHashSet();
        int r112 = openFlags(r111);
        List<String> r113 = searchPaths.get(r110);
        if (r113 == null) goto L11;
        monitor-enter(r113);
        r104.addAll(r113);     // Catch: Throwable -> L8
        monitor-exit(r113);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        String r114 = Native.getWebStartLibraryPath(r110);
        if (r114 == null) goto L14;
        r100.log(r101, "Adding web start path ".concat(r114));
        r104.add(r114);
    L14:
        r100.log(r101, "Adding paths from jna.library.path: " + System.getProperty("jna.library.path"));
        r104.addAll(initPaths("jna.library.path"));
        String r115 = findLibraryPath(r110, r104);
        r100.log(r101, "Trying " + r115);     // Catch: UnsatisfiedLinkError -> L17
        long r105 = Native.open(r115, r112);     // Catch: UnsatisfiedLinkError -> L17
    L20:
        if (r105 != 0) goto L102;
        r115 = findLibraryPath(r110, r104);     // Catch: UnsatisfiedLinkError -> L26
        LOG.log(DEBUG_LOAD_LEVEL, "Trying " + r115);     // Catch: UnsatisfiedLinkError -> L26
        r105 = Native.open(r115, r112);     // Catch: UnsatisfiedLinkError -> L26
        if (r105 != 0) goto L102;
        throw new UnsatisfiedLinkError("Failed to load library '" + r110 + "'");     // Catch: UnsatisfiedLinkError -> L26
    L26:
        e = move-exception;
        Logger r106 = LOG;
        Level r107 = DEBUG_LOAD_LEVEL;
        r106.log(r107, "Loading failed with message: " + e.getMessage());
        r102.add(e);
        if (Platform.isAndroid() == false) goto L34;
        r106.log(r107, "Preload (via System.loadLibrary) " + r110);     // Catch: UnsatisfiedLinkError -> L31
        INVOKESTATIC_com_sun_jna_NativeLibrary_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r110);     // Catch: UnsatisfiedLinkError -> L31
        r105 = Native.open(r115, r112);     // Catch: UnsatisfiedLinkError -> L31
    L67:
        if (r105 != 0) goto L91;
        File r108 = Native.extractFromResourcePath(r110, (ClassLoader) r111.get(Library.OPTION_CLASSLOADER));     // Catch: IOException -> L84
        if (r108 == null) goto L91;
        r105 = Native.open(r108.getAbsolutePath(), r112);     // Catch: Throwable -> L79
        String r109 = r108.getAbsolutePath();     // Catch: Throwable -> L79
    L108:
    L77:
        e = e;
        r115 = r109;
    L88:
        LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e.getMessage());
        r102.add(e);
        goto L91
    L74:
        if (Native.isUnpacked(r108) == false) goto L76;
        Native.deleteLibrary(r108);     // Catch: IOException -> L77
    L76:
        r115 = r109;
    L79:
        th = move-exception;
        if (Native.isUnpacked(r108) == false) goto L83;
        Native.deleteLibrary(r108);     // Catch: IOException -> L84
    L83:
        throw th;     // Catch: IOException -> L84
    L84:
        e = e;
    L91:
        if (r105 != 0) goto L102;
        StringBuilder r116 = new StringBuilder("Unable to load library '");
        r116.append(r110);
        r116.append("':");
        Iterator r117 = r102.iterator();
    L94:
        if (r117.hasNext() == false) goto L96;
        Throwable r118 = (Throwable) r117.next();
        r116.append("\n");
        r116.append(r118.getMessage());
        goto L94
    L96:
        UnsatisfiedLinkError r119 = new UnsatisfiedLinkError(r116.toString());
        Iterator r120 = r102.iterator();
    L98:
        if (r120.hasNext() == false) goto L100;
        addSuppressedReflected(r119, (Throwable) r120.next());
        goto L98
    L100:
        throw r119;
    L31:
        e = move-exception;
        LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e.getMessage());
        r102.add(e);
        goto L67
    L34:
        if (Platform.isLinux() == false) goto L36;
    L59:
        r106.log(r107, "Looking for version variants");
        r115 = matchLibrary(r110, r104);
        if (r115 == null) goto L67;
        r106.log(r107, "Trying ".concat(r115));
        r105 = Native.open(r115, r112);     // Catch: UnsatisfiedLinkError -> L64
    L64:
        e = move-exception;
        LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e.getMessage());
        r102.add(e);
        goto L67
    L36:
        if (Platform.isFreeBSD() == true) goto L59;
        if (Platform.isMac() == false) goto L50;
        if (r110.endsWith(".dylib") == true) goto L50;
        String[] r121 = matchFramework(r110);
        int r122 = r121.length;
        int r123 = 0;
    L43:
        if (r123 >= r122) goto L67;
        String r124 = r121[r123];
        LOG.log(DEBUG_LOAD_LEVEL, "Trying " + r124);     // Catch: UnsatisfiedLinkError -> L47
        r105 = Native.open(r124, r112);     // Catch: UnsatisfiedLinkError -> L47
    L47:
        e = move-exception;
        LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e.getMessage());
        r102.add(e);
        r123 = r123 + 1;
    L50:
        if (Platform.isWindows() == false) goto L67;
        if (r103 == true) goto L67;
        r106.log(r107, "Looking for lib- prefix");
        r115 = findLibraryPath("lib" + r110, r104);
        if (r115 == null) goto L67;
        r106.log(r107, "Trying ".concat(r115));
        r105 = Native.open(r115, r112);     // Catch: UnsatisfiedLinkError -> L57
    L57:
        e = move-exception;
        LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + e.getMessage());
        r102.add(e);
    L102:
        String r125 = r115;
        LOG.log(DEBUG_LOAD_LEVEL, "Found library '" + r110 + "' at " + r125);
        return new NativeLibrary(r110, r125, r105, r111);
    L17:
        e = move-exception;
        Logger r126 = LOG;
        Level r127 = DEBUG_LOAD_LEVEL;
        r126.log(r127, "Loading failed with message: " + e.getMessage());
        StringBuilder r128 = new StringBuilder("Adding system paths: ");
        LinkedHashSet<String> r129 = librarySearchPath;
        r128.append(r129);
        r126.log(r127, r128.toString());
        r102.add(e);
        r104.addAll(r129);
        r105 = 0;
        goto L20
    }

    public static String matchLibrary(final String r100, Collection<String> r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.isAbsolute() == false) goto L5;
        r101 = Arrays.asList(new String[]{r102.getParent()});
    L5:
        FilenameFilter r103 = new AnonymousClass3(r100);
        LinkedList r104 = new LinkedList();
        Iterator<String> r105 = r101.iterator();
    L7:
        if (r105.hasNext() == false) goto L13;
        File[] r106 = new PolarisFileWrapper(r105.next()).listFiles(r103);
        if (r106 == null) goto L7;
        if (r106.length <= 0) goto L7;
        r104.addAll(Arrays.asList(r106));
        goto L7
    L13:
        Iterator r107 = r104.iterator();
        double r108 = -1.0d;
        String r109 = null;
    L15:
        if (r107.hasNext() == false) goto L19;
        String r110 = ((File) r107.next()).getAbsolutePath();
        double r111 = parseVersion(r110.substring(r110.lastIndexOf(".so.") + 4));
        if (r111 <= r108) goto L15;
        r109 = r110;
        r108 = r111;
        goto L15
    L19:
        return r109;
    }

    public Function getFunction(String r100, Method r101) {
        FunctionMapper r102 = (FunctionMapper) this.options.get(Library.OPTION_FUNCTION_MAPPER);
        if (r102 == null) goto L5;
        r100 = r102.getFunctionName(this, r101);
    L5:
        String r103 = System.getProperty("jna.profiler.prefix", "$$YJP$$");
        if (r100.startsWith(r103) == false) goto L8;
        r100 = r100.substring(r103.length());
    L8:
        int r104 = this.callFlags;
        Class<?>[] r105 = r101.getExceptionTypes();
        int r106 = 0;
    L10:
        if (r106 >= r105.length) goto L16;
        if (LastErrorException.class.isAssignableFrom(r105[r106]) == false) goto L14;
        r104 = r104 | 64;
    L14:
        r106 = r106 + 1;
        goto L10
    L16:
        return getFunction(r100, r104);
    }

    public static final NativeLibrary getInstance(String r100, ClassLoader r101) {
        return getInstance(r100, Collections.singletonMap(Library.OPTION_CLASSLOADER, r101));
    }

    public Function getFunction(String r100, int r101) {
        return getFunction(r100, r101, this.encoding);
    }

    private static String functionKey(String r100, int r101, String r102) {
        return r100 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r102;
    }

    public Function getFunction(String r100, int r101, String r102) {
        if (r100 == null) goto L14;
        Map<String, Function> r103 = this.functions;
        monitor-enter(r103);
        String r104 = functionKey(r100, r101, r102);     // Catch: Throwable -> L10
        Function r105 = this.functions.get(r104);     // Catch: Throwable -> L10
        if (r105 != null) goto L8;
        r105 = new Function(this, r100, r101, r102);     // Catch: Throwable -> L10
        this.functions.put(r104, r105);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r103);     // Catch: Throwable -> L10
        return r105;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new NullPointerException("Function name may not be null");
    }

    private NativeLibrary(String r100, String r101, long r110, Map<String, ?> r111) {
        HashMap r102 = new HashMap();
        this.functions = r102;
        String r103 = getLibraryName(r100);
        this.libraryName = r103;
        this.libraryPath = r101;
        this.handle = r110;
        this.cleanable = Cleaner.getCleaner().register(this, new NativeLibraryDisposer(r110));
        Object r104 = r111.get(Library.OPTION_CALLING_CONVENTION);
        if ((r104 instanceof Number) == false) goto L5;
        int r105 = ((Number) r104).intValue();
    L6:
        this.callFlags = r105;
        this.options = r111;
        SymbolProvider r112 = (SymbolProvider) r111.get(Library.OPTION_SYMBOL_PROVIDER);
        if (r112 != null) goto L9;
        this.symbolProvider = NATIVE_SYMBOL_PROVIDER;
    L10:
        String r113 = (String) r111.get(Library.OPTION_STRING_ENCODING);
        if (r113 != null) goto L13;
        r113 = Native.getDefaultStringEncoding();
    L13:
        this.encoding = r113;
        if (Platform.isWindows() == true) goto L16;
        return;
    L16:
        if ("kernel32".equals(r103.toLowerCase()) == false) goto L27;
        monitor-enter(r102);
        final String r106 = "GetLastError";
        final int r107 = 63;
        final String r108 = r113;
        Function r109 = new AnonymousClass2(this, this, r106, r107, r108);     // Catch: Throwable -> L21
        r102.put(functionKey("GetLastError", r105, r113), r109);     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L27:
        return;
    L9:
        this.symbolProvider = r112;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }
}
