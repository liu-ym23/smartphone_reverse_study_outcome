package com.sun.jna;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.librarian.a;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public final class Native implements Version {
    public static final int BOOL_SIZE = 0;
    static final int CB_HAS_INITIALIZER = 1;
    static final int CB_OPTION_DIRECT = 1;
    static final int CB_OPTION_IN_DLL = 2;
    private static final int CVT_ARRAY_BOOLEAN = 13;
    private static final int CVT_ARRAY_BYTE = 6;
    private static final int CVT_ARRAY_CHAR = 8;
    private static final int CVT_ARRAY_DOUBLE = 12;
    private static final int CVT_ARRAY_FLOAT = 11;
    private static final int CVT_ARRAY_INT = 9;
    private static final int CVT_ARRAY_LONG = 10;
    private static final int CVT_ARRAY_SHORT = 7;
    private static final int CVT_BOOLEAN = 14;
    private static final int CVT_BUFFER = 5;
    private static final int CVT_BYTE = 29;
    private static final int CVT_CALLBACK = 15;
    private static final int CVT_DEFAULT = 0;
    private static final int CVT_FLOAT = 16;
    private static final int CVT_INTEGER_TYPE = 21;
    private static final int CVT_JNIENV = 27;
    private static final int CVT_NATIVE_MAPPED = 17;
    private static final int CVT_NATIVE_MAPPED_STRING = 18;
    private static final int CVT_NATIVE_MAPPED_WSTRING = 19;
    private static final int CVT_OBJECT = 26;
    private static final int CVT_POINTER = 1;
    private static final int CVT_POINTER_TYPE = 22;
    private static final int CVT_SHORT = 28;
    private static final int CVT_STRING = 2;
    private static final int CVT_STRUCTURE = 3;
    private static final int CVT_STRUCTURE_BYVAL = 4;
    private static final int CVT_TYPE_MAPPER = 23;
    private static final int CVT_TYPE_MAPPER_STRING = 24;
    private static final int CVT_TYPE_MAPPER_WSTRING = 25;
    private static final int CVT_UNSUPPORTED = -1;
    private static final int CVT_WSTRING = 20;
    public static final boolean DEBUG_JNA_LOAD = false;
    private static final Level DEBUG_JNA_LOAD_LEVEL = null;
    public static final boolean DEBUG_LOAD = false;
    public static final Charset DEFAULT_CHARSET = null;
    public static final String DEFAULT_ENCODING = null;
    private static final Callback.UncaughtExceptionHandler DEFAULT_HANDLER = null;
    static final String JNA_TMPLIB_PREFIX = "jna";
    private static final Logger LOG = null;
    public static final int LONG_DOUBLE_SIZE = 0;
    public static final int LONG_SIZE = 0;
    static final int MAX_ALIGNMENT = 0;
    static final int MAX_PADDING = 0;
    public static final int POINTER_SIZE = 0;
    public static final int SIZE_T_SIZE = 0;
    private static final int TYPE_BOOL = 4;
    private static final int TYPE_LONG = 1;
    private static final int TYPE_LONG_DOUBLE = 5;
    private static final int TYPE_SIZE_T = 3;
    private static final int TYPE_VOIDP = 0;
    private static final int TYPE_WCHAR_T = 2;
    public static final int WCHAR_SIZE = 0;
    private static final String _OPTION_ENCLOSING_LIBRARY = "enclosing-library";
    private static Callback.UncaughtExceptionHandler callbackExceptionHandler;
    private static final Object finalizer = null;
    static String jnidispatchPath;
    private static final Map<Class<?>, Reference<?>> libraries = null;
    private static final ThreadLocal<Memory> nativeThreadTerminationFlag = null;
    private static final Map<Thread, Pointer> nativeThreads = null;
    private static final Map<Class<?>, long[]> registeredClasses = null;
    private static final Map<Class<?>, NativeLibrary> registeredLibraries = null;
    private static final Map<Class<?>, Map<String, Object>> typeOptions = null;

    public static class AWT {
        private AWT() {
        }

        public static long getComponentID(Object r100) throws HeadlessException {
            if (GraphicsEnvironment.isHeadless() == true) goto L24;
            Component r101 = (Component) r100;
            if (r101.isLightweight() == true) goto L22;
            if (r101.isDisplayable() == false) goto L20;
            if (Platform.isX11() == false) goto L18;
            if (System.getProperty("java.version").startsWith("1.4") == false) goto L18;
            if (r101.isVisible() == true) goto L18;
            throw new IllegalStateException("Component must be visible");
        L18:
            return Native.getWindowHandle0(r101);
        L20:
            throw new IllegalStateException("Component must be displayable");
        L22:
            throw new IllegalArgumentException("Component must be heavyweight");
        L24:
            throw new HeadlessException("No native windows when headless");
        }

        public static long getWindowID(Window r100) throws HeadlessException {
            return getComponentID(r100);
        }
    }

    public static class Buffers {
        private Buffers() {
        }

        public static boolean isBuffer(Class<?> r100) {
            return Buffer.class.isAssignableFrom(r100);
        }
    }

    public interface ffi_callback {
        void invoke(long r100, long r101, long r102);
    }

    private Native() {
    }

    private static native long _getDirectBufferPointer(Buffer r100);

    private static native long _getPointer(long r100);

    public static /* synthetic */ void access$001(String r100) {
        System.loadLibrary(r100);
    }

    public static /* synthetic */ Class access$002(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static native void close(long r100);

    public static native synchronized long createNativeCallback(Callback r100, Method r101, Class<?>[] r102, Class<?> r103, int r104, int r105, String r106);

    public static native void ffi_call(long r100, long r101, long r102, long r103);

    public static native void ffi_free_closure(long r100);

    public static native long ffi_prep_cif(int r100, int r101, long r102, long r103);

    public static native long ffi_prep_closure(long r100, ffi_callback r101);

    public static native long findSymbol(long r100, String r101);

    public static native void free(long r100);

    public static native synchronized void freeNativeCallback(long r100);

    private static native String getAPIChecksum();

    public static native byte getByte(Pointer r100, long r101, long r102);

    public static native char getChar(Pointer r100, long r101, long r102);

    public static native ByteBuffer getDirectByteBuffer(Pointer r100, long r101, long r102, long r103);

    public static native double getDouble(Pointer r100, long r101, long r102);

    public static native float getFloat(Pointer r100, long r101, long r102);

    public static native int getInt(Pointer r100, long r101, long r102);

    public static native int getLastError();

    public static native long getLong(Pointer r100, long r101, long r102);

    private static native String getNativeVersion();

    public static native short getShort(Pointer r100, long r101, long r102);

    public static native byte[] getStringBytes(Pointer r100, long r101, long r102);

    public static native String getWideString(Pointer r100, long r101, long r102);

    public static native long getWindowHandle0(Component r100);

    public static native long indexOf(Pointer r100, long r101, long r102, byte r103);

    private static native void initIDs();

    public static native int initialize_ffi_type(long r100);

    public static native double invokeDouble(Function r100, long r101, int r102, Object[] r103);

    public static native float invokeFloat(Function r100, long r101, int r102, Object[] r103);

    public static native int invokeInt(Function r100, long r101, int r102, Object[] r103);

    public static native long invokeLong(Function r100, long r101, int r102, Object[] r103);

    public static native Object invokeObject(Function r100, long r101, int r102, Object[] r103);

    public static native long invokePointer(Function r100, long r101, int r102, Object[] r103);

    private static native void invokeStructure(Function r100, long r101, int r102, Object[] r103, long r104, long r105);

    public static native void invokeVoid(Function r100, long r101, int r102, Object[] r103);

    public static native synchronized boolean isProtected();

    public static native long malloc(long r100);

    public static native long open(String r100, int r101);

    public static native void read(Pointer r100, long r101, long r102, byte[] r103, int r104, int r105);

    public static native void read(Pointer r100, long r101, long r102, char[] r103, int r104, int r105);

    public static native void read(Pointer r100, long r101, long r102, double[] r103, int r104, int r105);

    public static native void read(Pointer r100, long r101, long r102, float[] r103, int r104, int r105);

    public static native void read(Pointer r100, long r101, long r102, int[] r103, int r104, int r105);

    public static native void read(Pointer r100, long r101, long r102, long[] r103, int r104, int r105);

    public static native void read(Pointer r100, long r101, long r102, short[] r103, int r104, int r105);

    private static native long registerMethod(Class<?> r100, String r101, String r102, int[] r103, long[] r104, long[] r105, int r106, long r107, long r108, Method r110, long r111, int r112, boolean r113, ToNativeConverter[] r114, FromNativeConverter r115, String r116);

    public static native void setByte(Pointer r100, long r101, long r102, byte r103);

    public static native void setChar(Pointer r100, long r101, long r102, char r103);

    private static native void setDetachState(boolean r100, long r101);

    public static native void setDouble(Pointer r100, long r101, long r102, double r103);

    public static native void setFloat(Pointer r100, long r101, long r102, float r103);

    public static native void setInt(Pointer r100, long r101, long r102, int r103);

    public static native void setLastError(int r100);

    public static native void setLong(Pointer r100, long r101, long r102, long r103);

    public static native void setMemory(Pointer r100, long r101, long r102, long r103, byte r104);

    public static native void setPointer(Pointer r100, long r101, long r102, long r103);

    public static native synchronized void setProtected(boolean r100);

    public static native void setShort(Pointer r100, long r101, long r102, short r103);

    public static native void setWideString(Pointer r100, long r101, long r102, String r103);

    private static native int sizeof(int r100);

    private static native void unregister(Class<?> r100, long[] r101);

    public static native void write(Pointer r100, long r101, long r102, byte[] r103, int r104, int r105);

    public static native void write(Pointer r100, long r101, long r102, char[] r103, int r104, int r105);

    public static native void write(Pointer r100, long r101, long r102, double[] r103, int r104, int r105);

    public static native void write(Pointer r100, long r101, long r102, float[] r103, int r104, int r105);

    public static native void write(Pointer r100, long r101, long r102, int[] r103, int r104, int r105);

    public static native void write(Pointer r100, long r101, long r102, long[] r103, int r104, int r105);

    public static native void write(Pointer r100, long r101, long r102, short[] r103, int r104, int r105);

    static {
        LOG = Logger.getLogger(Native.class.getName());
        String r100 = System.getProperty("native.encoding");
        if (r100 != null) goto L55;
    L8:
        Charset r101 = null;
    L9:
        if (r101 != null) goto L11;
        r101 = Charset.defaultCharset();
    L11:
        DEFAULT_CHARSET = r101;
        DEFAULT_ENCODING = r101.name();
        DEBUG_LOAD = Boolean.getBoolean("jna.debug_load");
        boolean r102 = Boolean.getBoolean("jna.debug_load.jna");
        DEBUG_JNA_LOAD = r102;
        if (r102 == false) goto L14;
        Level r103 = Level.INFO;
    L15:
        DEBUG_JNA_LOAD_LEVEL = r103;
        jnidispatchPath = null;
        typeOptions = Collections.synchronizedMap(new WeakHashMap());
        libraries = Collections.synchronizedMap(new WeakHashMap());
        Callback.UncaughtExceptionHandler r104 = new AnonymousClass1();
        DEFAULT_HANDLER = r104;
        callbackExceptionHandler = r104;
        loadNativeDispatchLibrary();
        if (isCompatibleVersion(Version.VERSION_NATIVE, getNativeVersion()) == true) goto L23;
        String r105 = System.lineSeparator();
        StringBuilder r106 = new StringBuilder();
        r106.append(r105);
        r106.append(r105);
        r106.append("There is an incompatible JNA native library installed on this system");
        r106.append(r105);
        r106.append("Expected: 7.0.0");
        r106.append(r105);
        r106.append("Found:    ");
        r106.append(getNativeVersion());
        r106.append(r105);
        if (jnidispatchPath == null) goto L20;
        String r107 = "(at " + jnidispatchPath + ")";
    L21:
        r106.append(r107);
        r106.append(".");
        r106.append(r105);
        r106.append("To resolve this issue you may do one of the following:");
        r106.append(r105);
        r106.append(" - remove or uninstall the offending library");
        r106.append(r105);
        r106.append(" - set the system property jna.nosys=true");
        r106.append(r105);
        r106.append(" - set jna.boot.library.path to include the path to the version of the ");
        r106.append(r105);
        r106.append("   jnidispatch library included with the JNA jar file you are using");
        r106.append(r105);
        throw new Error(r106.toString());
    L20:
        r107 = System.getProperty("java.library.path");
        goto L21
    L23:
        POINTER_SIZE = sizeof(0);
        int r108 = sizeof(1);
        LONG_SIZE = r108;
        WCHAR_SIZE = sizeof(2);
        SIZE_T_SIZE = sizeof(3);
        BOOL_SIZE = sizeof(4);
        LONG_DOUBLE_SIZE = sizeof(5);
        initIDs();
        if (Boolean.getBoolean("jna.protected") == false) goto L26;
        setProtected(true);
    L26:
        int r109 = 8;
        if (Platform.isSPARC() == false) goto L29;
    L46:
        r108 = 8;
    L47:
        MAX_ALIGNMENT = r108;
        if (Platform.isMac() == true) goto L50;
    L52:
        r109 = r108;
    L53:
        MAX_PADDING = r109;
        System.setProperty("jna.loaded", "true");
        finalizer = new AnonymousClass2();
        registeredClasses = new WeakHashMap();
        registeredLibraries = new WeakHashMap();
        nativeThreadTerminationFlag = new AnonymousClass7();
        nativeThreads = Collections.synchronizedMap(new WeakHashMap());
        return;
    L50:
        if (Platform.isPPC() == false) goto L52;
    L29:
        if (Platform.isWindows() == true) goto L46;
        if (Platform.isLinux() == false) goto L41;
        if (Platform.isARM() == true) goto L46;
        if (Platform.isPPC() == true) goto L46;
        if (Platform.isMIPS() == true) goto L46;
        if (Platform.isLoongArch() == true) goto L46;
    L41:
        if (Platform.isAIX() == true) goto L46;
        if (Platform.isAndroid() == false) goto L47;
        if (Platform.isIntel() == true) goto L47;
    L14:
        r103 = Level.FINE;
        goto L15
    L55:
        r101 = Charset.forName(r100);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        LOG.log(Level.WARNING, "Failed to get charset for native.encoding value : '" + r100 + "'", e);
        goto L8
    }

    public static Class<?> getCallingClass() {
        Class<?>[] r100 = new AnonymousClass6().getClassContext();
        if (r100 == null) goto L11;
        if (r100.length < 4) goto L9;
        return r100[3];
    L9:
        throw new IllegalStateException("This method must be called from the static initializer of a class");
    L11:
        throw new IllegalStateException("The SecurityManager implementation on this platform is broken; you must explicitly provide the class to register");
    }

    public static String getDefaultStringEncoding() {
        return System.getProperty("jna.encoding", DEFAULT_ENCODING);
    }

    public static File getTempDir() throws IOException {
        String r100 = System.getProperty("jna.tmpdir");
        if (r100 == null) goto L5;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        r101.mkdirs();
    L39:
        if (r101.exists() == false) goto L46;
        if (r101.canWrite() == false) goto L44;
        return r101;
    L44:
        throw new IOException("JNA temporary directory '" + r101 + "' is not writable");
    L46:
        throw new IOException("JNA temporary directory '" + r101 + "' does not exist");
    L5:
        r101 = new PolarisFileWrapper(System.getProperty("java.io.tmpdir"));
        if (Platform.isMac() == false) goto L9;
        PolarisFileWrapper r102 = new PolarisFileWrapper(System.getProperty("user.home"), "Library/Caches/JNA/temp");
    L32:
        r102.mkdirs();
        if (r102.exists() == false) goto L39;
        if (r102.canWrite() == false) goto L39;
        r101 = r102;
        goto L39
    L9:
        if (Platform.isLinux() == false) goto L11;
    L24:
        String r103 = System.getenv("XDG_CACHE_HOME");
        if (r103 != null) goto L27;
    L30:
        PolarisFileWrapper r104 = new PolarisFileWrapper(System.getProperty("user.home"), ".cache");
    L31:
        r102 = new PolarisFileWrapper(r104, "JNA/temp");
        goto L32
    L27:
        if (r103.trim().isEmpty() == true) goto L30;
        r104 = new PolarisFileWrapper(r103);
        goto L31
    L11:
        if (Platform.isSolaris() == true) goto L24;
        if (Platform.isAIX() == true) goto L24;
        if (Platform.isFreeBSD() == true) goto L24;
        if (Platform.isNetBSD() == true) goto L24;
        if (Platform.isOpenBSD() == true) goto L24;
        if (Platform.iskFreeBSD() == true) goto L24;
        r102 = new PolarisFileWrapper(r101, "jna-" + System.getProperty("user.name").hashCode());
        goto L32
    }

    private static void loadNativeDispatchLibrary() {
        if (Boolean.getBoolean("jna.nounpack") == false) goto L49;
    L8:
        String r100 = System.getProperty("jna.boot.library.name", "jnidispatch");
        String r101 = System.getProperty("jna.boot.library.path");
        if (r101 == null) goto L31;
        StringTokenizer r102 = new StringTokenizer(r101, File.pathSeparator);
    L12:
        if (r102.hasMoreTokens() == false) goto L31;
        PolarisFileWrapper r103 = new PolarisFileWrapper(new PolarisFileWrapper(r102.nextToken()), System.mapLibraryName(r100).replace(".dylib", ".jnilib"));
        String r104 = r103.getAbsolutePath();
        Logger r105 = LOG;
        Level r106 = DEBUG_JNA_LOAD_LEVEL;
        r105.log(r106, "Looking in {0}", r104);
        if (r103.exists() == false) goto L19;
        r105.log(r106, "Trying {0}", r104);     // Catch: UnsatisfiedLinkError -> L17
        System.setProperty("jnidispatch.path", r104);     // Catch: UnsatisfiedLinkError -> L17
        System.load(r104);     // Catch: UnsatisfiedLinkError -> L17
        jnidispatchPath = r104;     // Catch: UnsatisfiedLinkError -> L17
        r105.log(r106, "Found jnidispatch at {0}", r104);     // Catch: UnsatisfiedLinkError -> L17
        return;
    L19:
        if (Platform.isMac() == false) goto L12;
        String r107 = "dylib";
        String r108 = "jnilib";
        if (r104.endsWith("dylib") == true) goto L24;
        r108 = "dylib";
        r107 = "jnilib";
    L24:
        String r109 = r104.substring(0, r104.lastIndexOf(r107)) + r108;
        Logger r110 = LOG;
        Level r111 = DEBUG_JNA_LOAD_LEVEL;
        r110.log(r111, "Looking in {0}", r109);
        if (new PolarisFileWrapper(r109).exists() == false) goto L12;
        r110.log(r111, "Trying {0}", r109);     // Catch: UnsatisfiedLinkError -> L28
        System.setProperty("jnidispatch.path", r109);     // Catch: UnsatisfiedLinkError -> L28
        System.load(r109);     // Catch: UnsatisfiedLinkError -> L28
        jnidispatchPath = r109;     // Catch: UnsatisfiedLinkError -> L28
        r110.log(r111, "Found jnidispatch at {0}", r109);     // Catch: UnsatisfiedLinkError -> L28
        return;
    L28:
        e = move-exception;
        LOG.log(Level.WARNING, "File found at " + r109 + " but not loadable: " + e.getMessage(), e);
    L31:
        if (Boolean.parseBoolean(System.getProperty("jna.nosys", "true")) == true) goto L33;
    L47:
        Logger r112 = LOG;     // Catch: UnsatisfiedLinkError -> L36
        Level r113 = DEBUG_JNA_LOAD_LEVEL;     // Catch: UnsatisfiedLinkError -> L36
        r112.log(r113, "Trying (via loadLibrary) {0}", r100);     // Catch: UnsatisfiedLinkError -> L36
        INVOKESTATIC_com_sun_jna_Native_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);     // Catch: UnsatisfiedLinkError -> L36
        r112.log(r113, "Found jnidispatch on system path");     // Catch: UnsatisfiedLinkError -> L36
        return;
    L38:
        if (Boolean.getBoolean("jna.noclasspath") == true) goto L42;
        loadNativeDispatchLibraryFromClasspath();
        return;
    L42:
        throw new UnsatisfiedLinkError("Unable to locate JNA native support library");
    L33:
        if (Platform.isAndroid() == false) goto L38;
    L49:
        removeTemporaryFiles();     // Catch: IOException -> L6
    L6:
        e = move-exception;
        LOG.log(Level.WARNING, "JNA Warning: IOException removing temporary files", e);
        goto L8
    }

    private static void loadNativeDispatchLibraryFromClasspath() {
        String r100 = System.mapLibraryName("jnidispatch").replace(".dylib", ".jnilib");     // Catch: IOException -> L18
        if (Platform.isAIX() == false) goto L6;
        r100 = "libjnidispatch.a";
    L6:
        File r101 = extractFromResourcePath("/com/sun/jna/" + Platform.RESOURCE_PREFIX + HTTP.URL_DEFAULT + r100, Native.class.getClassLoader());     // Catch: IOException -> L18
        if (r101 != null) goto L12;
        if (r101 != null) goto L12;
        throw new UnsatisfiedLinkError("Could not find JNA native support");     // Catch: IOException -> L18
    L12:
        Logger r102 = LOG;     // Catch: IOException -> L18
        Level r103 = DEBUG_JNA_LOAD_LEVEL;     // Catch: IOException -> L18
        r102.log(r103, "Trying {0}", r101.getAbsolutePath());     // Catch: IOException -> L18
        System.setProperty("jnidispatch.path", r101.getAbsolutePath());     // Catch: IOException -> L18
        System.load(r101.getAbsolutePath());     // Catch: IOException -> L18
        String r104 = r101.getAbsolutePath();     // Catch: IOException -> L18
        jnidispatchPath = r104;     // Catch: IOException -> L18
        r102.log(r103, "Found jnidispatch at {0}", r104);     // Catch: IOException -> L18
        if (isUnpacked(r101) == true) goto L15;
        return;
    L15:
        if (Boolean.getBoolean("jnidispatch.preserve") == true) goto L23;
        deleteLibrary(r101);     // Catch: IOException -> L18
        return;
    L23:
        return;
    L18:
        e = move-exception;
        throw new UnsatisfiedLinkError(e.getMessage());
    }

    private static void unregisterAll() {
        Map<Class<?>, long[]> r100 = registeredClasses;
        monitor-enter(r100);
        Iterator<Map.Entry<Class<?>, long[]>> r101 = r100.entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<Class<?>, long[]> r102 = r101.next();     // Catch: Throwable -> L11
        unregister(r102.getKey(), r102.getValue());     // Catch: Throwable -> L11
        goto L6
    L8:
        registeredClasses.clear();     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static void dispose() {
        CallbackReference.disposeAll();
        Memory.disposeAll();
        NativeLibrary.disposeAll();
        unregisterAll();
        jnidispatchPath = null;
        System.setProperty("jna.loaded", "false");
    }

    public static void removeTemporaryFiles() throws IOException {
        File[] r100 = getTempDir().listFiles(new AnonymousClass5());
        int r101 = 0;
    L3:
        if (r100 == null) goto L12;
        if (r101 >= r100.length) goto L17;
        File r102 = r100[r101];
        String r103 = r102.getName();
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102.getParentFile(), r103.substring(0, r103.length() - 2));
        if (r104.exists() == true) goto L9;
    L10:
        r102.delete();
    L11:
        r101 = r101 + 1;
        goto L3
    L9:
        if (r104.delete() == false) goto L11;
    L17:
        return;
    }

    public static void unregister() {
        unregister(findDirectMappedClass(getCallingClass()));
    }

    public static /* synthetic */ Logger access$000() {
        return LOG;
    }

    public static /* synthetic */ void access$100() {
        dispose();
    }

    public static Callback.UncaughtExceptionHandler getCallbackExceptionHandler() {
        return callbackExceptionHandler;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_sun_jna_Native_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static boolean deleteLibrary(File r100) {
        if (r100.delete() == false) goto L6;
        return true;
    L6:
        markTemporaryFile(r100);
        return false;
    }

    public static void detach(boolean r100) {
        Thread r101 = ThreadMethodProxy.currentThread();
        if (r100 == false) goto L5;
        nativeThreads.remove(r101);
        Memory r102 = nativeThreadTerminationFlag.get();
        setDetachState(true, 0);
        return;
    L5:
        Map<Thread, Pointer> r103 = nativeThreads;
        if (r103.containsKey(r101) == true) goto L10;
        Memory r104 = nativeThreadTerminationFlag.get();
        r103.put(r101, r104);
        setDetachState(false, r104.peer);
        return;
    }

    public static File extractFromResourcePath(String r100) throws IOException {
        return extractFromResourcePath(r100, null);
    }

    public static Class<?> findDirectMappedClass(Class<?> r100) {
        Method[] r101 = r100.getDeclaredMethods();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if ((r101[r103].getModifiers() & 256) != 0) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r100;
    L8:
        int r104 = r100.getName().lastIndexOf("$");
        if (r104 == (-1)) goto L14;
        return findDirectMappedClass(INVOKESTATIC_com_sun_jna_Native_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100.getName().substring(0, r104), true, r100.getClassLoader()));
    L14:
        throw new IllegalArgumentException("Can't determine class with native methods from the current context (" + r100 + ")");
    }

    public static Class<?> findEnclosingLibraryClass(Class<?> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Map<String, Object> r101 = typeOptions.get(r100);
        if (r101 == null) goto L12;
        Class<?> r102 = (Class) r101.get(_OPTION_ENCLOSING_LIBRARY);
        if (r102 == null) goto L10;
        return r102;
    L10:
        return r100;
    L12:
        if (Library.class.isAssignableFrom(r100) == false) goto L15;
        return r100;
    L15:
        if (Callback.class.isAssignableFrom(r100) == false) goto L17;
        r100 = CallbackReference.findCallbackClass(r100);
    L17:
        Class<?> r103 = findEnclosingLibraryClass(r100.getDeclaringClass());
        if (r103 == null) goto L21;
        return r103;
    L21:
        return findEnclosingLibraryClass(r100.getSuperclass());
    }

    public static byte[] getBytes(String r100) {
        return getBytes(r100, getDefaultStringEncoding());
    }

    private static Charset getCharset(String r100) {
        if (r100 != null) goto L13;
    L9:
        Charset r101 = null;
    L10:
        if (r101 != null) goto L15;
        Logger r102 = LOG;
        Level r103 = Level.WARNING;
        Charset r104 = DEFAULT_CHARSET;
        r102.log(r103, "JNA Warning: Using fallback encoding {0}", r104);
        return r104;
    L15:
        return r101;
    L13:
        r101 = Charset.forName(r100);     // Catch: UnsupportedCharsetException -> L5 Throwable -> L7
    L7:
        e = move-exception;
        LOG.log(Level.WARNING, "JNA Warning: Encoding ''{0}'' is unsupported ({1})", new Object[]{r100, e.getMessage()});
        goto L9
    }

    public static long getComponentID(Component r100) throws HeadlessException {
        return AWT.getComponentID(r100);
    }

    public static Pointer getComponentPointer(Component r100) throws HeadlessException {
        return new Pointer(AWT.getComponentID(r100));
    }

    public static Pointer getDirectBufferPointer(Buffer r100) {
        long r101 = _getDirectBufferPointer(r100);
        if (r101 != 0) goto L6;
        return null;
    L6:
        return new Pointer(r101);
    }

    public static Map<String, Object> getLibraryOptions(Class<?> r100) {
        Map<Class<?>, Map<String, Object>> r101 = typeOptions;
        Map<String, Object> r102 = r101.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        Class<?> r103 = findEnclosingLibraryClass(r100);
        if (r103 == null) goto L8;
        loadLibraryInstance(r103);
    L9:
        Map<String, Object> r104 = r101.get(r103);
        if (r104 == null) goto L36;
        r101.put(r100, r104);
        return r104;
    L36:
        Field r105 = r103.getField("OPTIONS");     // Catch: Exception -> L19 NoSuchFieldException -> L22
        r105.setAccessible(true);     // Catch: Exception -> L19 NoSuchFieldException -> L22
        Map r106 = (Map) r105.get(null);     // Catch: Exception -> L19 NoSuchFieldException -> L22
        if (r106 == null) goto L18;
    L23:
        HashMap r107 = new HashMap(r106);
        if (r107.containsKey(Library.OPTION_TYPE_MAPPER) == true) goto L27;
        r107.put(Library.OPTION_TYPE_MAPPER, lookupField(r103, "TYPE_MAPPER", TypeMapper.class));
    L27:
        if (r107.containsKey(Library.OPTION_STRUCTURE_ALIGNMENT) == true) goto L30;
        r107.put(Library.OPTION_STRUCTURE_ALIGNMENT, lookupField(r103, "STRUCTURE_ALIGNMENT", Integer.class));
    L30:
        if (r107.containsKey(Library.OPTION_STRING_ENCODING) == true) goto L32;
        r107.put(Library.OPTION_STRING_ENCODING, lookupField(r103, "STRING_ENCODING", String.class));
    L32:
        Map<String, Object> r108 = cacheOptions(r103, r107, null);
        if (r100 == r103) goto L35;
        typeOptions.put(r100, r108);
    L35:
        return r108;
    L18:
        throw new IllegalStateException("Null options field");     // Catch: Exception -> L19 NoSuchFieldException -> L22
    L22:
        r106 = Collections.emptyMap();
    L19:
        e = move-exception;
        throw new IllegalArgumentException("OPTIONS must be a public field of type java.util.Map (" + e + "): " + r103);
    L8:
        r103 = r100;
        goto L9
    }

    public static int getNativeSize(Class<?> r100) {
        if (NativeMapped.class.isAssignableFrom(r100) == false) goto L6;
        r100 = NativeMappedConverter.getInstance(r100).nativeType();
    L6:
        if (r100 != Boolean.TYPE) goto L8;
    L80:
        return 4;
    L8:
        if (r100 == Boolean.class) goto L80;
        if (r100 != Byte.TYPE) goto L13;
        return 1;
    L13:
        if (r100 != Byte.class) goto L16;
        return 1;
    L16:
        if (r100 != Short.TYPE) goto L18;
        return 2;
    L18:
        if (r100 != Short.class) goto L21;
        return 2;
    L21:
        if (r100 == Character.TYPE) goto L75;
        if (r100 == Character.class) goto L75;
        if (r100 != Integer.TYPE) goto L28;
    L73:
        return 4;
    L28:
        if (r100 == Integer.class) goto L73;
        if (r100 != Long.TYPE) goto L33;
    L72:
        return 8;
    L33:
        if (r100 == Long.class) goto L72;
        if (r100 != Float.TYPE) goto L38;
    L71:
        return 4;
    L38:
        if (r100 == Float.class) goto L71;
        if (r100 != Double.TYPE) goto L43;
    L70:
        return 8;
    L43:
        if (r100 == Double.class) goto L70;
        if (Structure.class.isAssignableFrom(r100) == false) goto L54;
        if (Structure.ByValue.class.isAssignableFrom(r100) == false) goto L52;
        return Structure.size(r100);
    L52:
        return POINTER_SIZE;
    L54:
        if (Pointer.class.isAssignableFrom(r100) == true) goto L69;
        if (Platform.HAS_BUFFERS == false) goto L60;
        if (Buffers.isBuffer(r100) == true) goto L69;
    L60:
        if (Callback.class.isAssignableFrom(r100) == true) goto L69;
        if (String.class == r100) goto L69;
        if (WString.class == r100) goto L69;
        throw new IllegalArgumentException("Native size for type \"" + r100.getName() + "\" is unknown");
    L69:
        return POINTER_SIZE;
    L75:
        return WCHAR_SIZE;
    }

    public static Pointer getPointer(long r100) {
        long r101 = _getPointer(r100);
        if (r101 != 0) goto L6;
        return null;
    L6:
        return new Pointer(r101);
    }

    public static String getSignature(Class<?> r100) {
        if (r100.isArray() == false) goto L7;
        return "[" + getSignature(r100.getComponentType());
    L7:
        if (r100.isPrimitive() == false) goto L45;
        if (r100 != Void.TYPE) goto L13;
        return "V";
    L13:
        if (r100 != Boolean.TYPE) goto L17;
        return "Z";
    L17:
        if (r100 != Byte.TYPE) goto L21;
        return "B";
    L21:
        if (r100 != Short.TYPE) goto L25;
        return ExifInterface.LATITUDE_SOUTH;
    L25:
        if (r100 != Character.TYPE) goto L29;
        return "C";
    L29:
        if (r100 != Integer.TYPE) goto L33;
        return "I";
    L33:
        if (r100 != Long.TYPE) goto L37;
        return "J";
    L37:
        if (r100 != Float.TYPE) goto L41;
        return FaceService.girlLabel;
    L41:
        if (r100 != Double.TYPE) goto L45;
        return "D";
    L45:
        return "L" + replace(".", HTTP.URL_DEFAULT, r100.getName()) + i.f25853b;
    }

    public static String getStringEncoding(Class<?> r100) {
        String r101 = (String) getLibraryOptions(r100).get(Library.OPTION_STRING_ENCODING);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return getDefaultStringEncoding();
    }

    public static int getStructureAlignment(Class<?> r100) {
        Integer r101 = (Integer) getLibraryOptions(r100).get(Library.OPTION_STRUCTURE_ALIGNMENT);
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.intValue();
    }

    public static Pointer getTerminationFlag(Thread r100) {
        return nativeThreads.get(r100);
    }

    public static TypeMapper getTypeMapper(Class<?> r100) {
        return (TypeMapper) getLibraryOptions(r100).get(Library.OPTION_TYPE_MAPPER);
    }

    public static String getWebStartLibraryPath(String r100) {
        if (System.getProperty("javawebstart.version") != null) goto L11;
        return null;
    L11:
        ClassLoader r101 = Native.class.getClassLoader();     // Catch: Exception -> L10
        String r102 = (String) ((Method) AccessController.doPrivileged(new AnonymousClass4())).invoke(r101, new Object[]{r100});     // Catch: Exception -> L10
        if (r102 == null) goto L9;
        return new PolarisFileWrapper(r102).getParent();
    L9:
        return null;
    }

    public static long getWindowID(Window r100) throws HeadlessException {
        return AWT.getWindowID(r100);
    }

    public static Pointer getWindowPointer(Window r100) throws HeadlessException {
        return new Pointer(AWT.getWindowID(r100));
    }

    public static boolean isSupportedNativeType(Class<?> r100) {
        if (Structure.class.isAssignableFrom(r100) == false) goto L12;
        return true;
    L12:
        if (getNativeSize(r100) != 0) goto L14;
        return false;
    L14:
        return true;
    L11:
        return false;
    }

    public static boolean isUnpacked(File r100) {
        return r100.getName().startsWith(JNA_TMPLIB_PREFIX);
    }

    public static <T extends Library> T load(Class<T> r100) {
        return (T) load(null, r100);
    }

    public static <T> T loadLibrary(Class<T> r100) {
        return (T) loadLibrary(null, r100);
    }

    private static void loadLibraryInstance(Class<?> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (libraries.containsKey(r100) == true) goto L25;
        Field[] r101 = r100.getFields();     // Catch: Exception -> L15
        int r102 = 0;
    L7:
        if (r102 >= r101.length) goto L27;
        Field r103 = r101[r102];     // Catch: Exception -> L15
        if (r103.getType() != r100) goto L14;
        if (Modifier.isStatic(r103.getModifiers()) == false) goto L14;
        r103.setAccessible(true);     // Catch: Exception -> L15
        libraries.put(r100, new WeakReference(r103.get(null)));     // Catch: Exception -> L15
        return;
    L14:
        r102 = r102 + 1;
        goto L7
    L27:
        return;
    L15:
        e = move-exception;
        throw new IllegalArgumentException("Could not access instance of " + r100 + " (" + e + ")");
    }

    public static void main(String[] r100) {
        Package r101 = Native.class.getPackage();
        String r102 = "Java Native Access (JNA)";
        if (r101 == null) goto L5;
        String r103 = r101.getSpecificationTitle();
    L6:
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        String r104 = Version.VERSION;
        if (r101 == null) goto L12;
        String r105 = r101.getSpecificationVersion();
    L13:
        if (r105 == null) goto L16;
        r104 = r105;
    L16:
        System.out.println(r102 + " API Version " + r104);
        String r106 = "5.14.0 (package information missing)";
        if (r101 == null) goto L19;
        String r107 = r101.getImplementationVersion();
    L20:
        if (r107 == null) goto L23;
        r106 = r107;
    L23:
        System.out.println("Version: ".concat(r106));
        System.out.println(" Native: " + getNativeVersion() + " (" + getAPIChecksum() + ")");
        PrintStream r108 = System.out;
        StringBuilder r109 = new StringBuilder(" Prefix: ");
        r109.append(Platform.RESOURCE_PREFIX);
        r108.println(r109.toString());
        return;
    L19:
        r107 = "5.14.0 (package information missing)";
        goto L20
    L12:
        r105 = Version.VERSION;
        goto L13
    L5:
        r103 = "Java Native Access (JNA)";
        goto L6
    }

    public static void markTemporaryFile(File r100) {
        new PolarisFileWrapper(r100.getParentFile(), r100.getName() + ".x").createNewFile();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static Class<?> nativeType(Class<?> r100) {
        return NativeMappedConverter.getInstance(r100).nativeType();
    }

    public static long open(String r100) {
        return open(r100, -1);
    }

    public static void register(NativeLibrary r100) {
        register(findDirectMappedClass(getCallingClass()), r100);
    }

    public static boolean registered(Class<?> r100) {
        Map<Class<?>, long[]> r101 = registeredClasses;
        monitor-enter(r101);
        boolean r102 = r101.containsKey(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setCallbackExceptionHandler(Callback.UncaughtExceptionHandler r100) {
        if (r100 != null) goto L4;
        r100 = DEFAULT_HANDLER;
    L4:
        callbackExceptionHandler = r100;
    }

    public static Library synchronizedLibrary(final Library r100) {
        Class<?> r101 = r100.getClass();
        if (Proxy.isProxyClass(r101) == false) goto L11;
        InvocationHandler r102 = Proxy.getInvocationHandler(r100);
        if ((r102 instanceof Library.Handler) == false) goto L9;
        final Library.Handler r103 = (Library.Handler) r102;
        return (Library) Proxy.newProxyInstance(r101.getClassLoader(), r101.getInterfaces(), new AnonymousClass3(r103, r100));
    L9:
        throw new IllegalArgumentException("Unrecognized proxy handler: " + r102);
    L11:
        throw new IllegalArgumentException("Library must be a proxy class");
    }

    public static byte[] toByteArray(String r100) {
        return toByteArray(r100, getDefaultStringEncoding());
    }

    public static char[] toCharArray(String r100) {
        char[] r101 = r100.toCharArray();
        char[] r102 = new char[r101.length + 1];
        System.arraycopy(r101, 0, r102, 0, r101.length);
        return r102;
    }

    public static String toString(char[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (r100[r102] == 0) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        r101 = r102;
    L8:
        if (r101 != 0) goto L12;
        return "";
    L12:
        return new String(r100, 0, r101);
    }

    public static List<String> toStringList(char[] r100) {
        return toStringList(r100, 0, r100.length);
    }

    public static void unregister(Class<?> r100) {
        Map<Class<?>, long[]> r101 = registeredClasses;
        monitor-enter(r101);
        long[] r102 = r101.get(r100);     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        unregister(r100, r102);     // Catch: Throwable -> L9
        r101.remove(r100);     // Catch: Throwable -> L9
        registeredLibraries.remove(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void register(String r100) {
        register(findDirectMappedClass(getCallingClass()), r100);
    }

    public static String toString(byte[] r100) {
        return toString(r100, getDefaultStringEncoding());
    }

    public static File extractFromResourcePath(String r110, ClassLoader r111) throws IOException {
        if (DEBUG_LOAD == false) goto L5;
    L10:
        Level r100 = Level.INFO;
    L11:
        if (r111 != null) goto L15;
        r111 = ThreadMethodProxy.currentThread().getContextClassLoader();
        if (r111 != null) goto L15;
        r111 = Native.class.getClassLoader();
    L15:
        Logger r101 = LOG;
        r101.log(r100, "Looking in classpath from {0} for {1}", new Object[]{r111, r110});
        if (r110.startsWith(HTTP.URL_DEFAULT) == false) goto L18;
        String r102 = r110;
    L20:
        if (r110.startsWith(HTTP.URL_DEFAULT) == false) goto L22;
        String r103 = r110;
    L24:
        if (r103.startsWith(HTTP.URL_DEFAULT) == false) goto L26;
        r103 = r103.substring(1);
    L26:
        URL r104 = r111.getResource(r103);
        if (r104 != null) goto L42;
        String r105 = Platform.RESOURCE_PREFIX;
        if (r103.startsWith(r105) == false) goto L36;
        if (r105.startsWith("darwin") == false) goto L33;
        r104 = r111.getResource("darwin/" + r103.substring(r105.length() + 1));
    L33:
        if (r104 != null) goto L42;
        r104 = r111.getResource(r102);
        goto L42
    L36:
        if (r103.startsWith("com/sun/jna/" + r105 + HTTP.URL_DEFAULT) == false) goto L42;
        if (r105.startsWith("com/sun/jna/darwin") == false) goto L40;
        StringBuilder r106 = new StringBuilder("com/sun/jna/darwin");
        r106.append(r103.substring(("com/sun/jna/" + r105).length() + 1));
        r104 = r111.getResource(r106.toString());
    L40:
        if (r104 != null) goto L42;
        r104 = r111.getResource(r102);
    L42:
        if (r104 != null) goto L48;
        String r112 = System.getProperty("java.class.path");
        if ((r111 instanceof URLClassLoader) == false) goto L47;
        r112 = Arrays.asList(((URLClassLoader) r111).getURLs()).toString();
    L47:
        throw new IOException("Native library (" + r103 + ") not found in resource path (" + r112 + ")");
    L48:
        r101.log(r100, "Found library resource at {0}", r104);
        if (r104.getProtocol().toLowerCase().equals("file") == true) goto L103;
        PolarisFileOutputStreamWrapper r107 = null;
        if (Boolean.getBoolean("jna.nounpack") == true) goto L97;
        InputStream r113 = r104.openStream();
        if (r113 == null) goto L95;
        File r108 = getTempDir();     // Catch: Throwable -> L83 IOException -> L85
        if (Platform.isWindows() == false) goto L65;
        String r109 = ".dll";
    L66:
        File r114 = File.createTempFile(JNA_TMPLIB_PREFIX, r109, r108);     // Catch: Throwable -> L83 IOException -> L85
        if (Boolean.getBoolean("jnidispatch.preserve") == true) goto L69;
        r114.deleteOnExit();     // Catch: Throwable -> L83 IOException -> L85
    L69:
        r101.log(r100, "Extracting library to {0}", r114.getAbsolutePath());     // Catch: Throwable -> L83 IOException -> L85
        PolarisFileOutputStreamWrapper r115 = new PolarisFileOutputStreamWrapper(r114);     // Catch: Throwable -> L83 IOException -> L85
        byte[] r116 = new byte[1024];     // Catch: Throwable -> L79 IOException -> L81
    L72:
        int r117 = r113.read(r116, 0, 1024);     // Catch: Throwable -> L79 IOException -> L81
        if (r117 <= 0) goto L107;
        r115.write(r116, 0, r117);     // Catch: Throwable -> L79 IOException -> L81
    L107:
        r113.close();     // Catch: IOException -> L98
    L105:
        r115.close();     // Catch: IOException -> L99
    L119:
        return r114;
    L81:
        e = move-exception;
        e = e;
    L87:
        throw new IOException("Failed to create temporary file for " + r110 + " library: " + e.getMessage());     // Catch: Throwable -> L83
    L79:
        th = th;
        r107 = r115;
    L101:
        r113.close();     // Catch: IOException -> L90
    L91:
        if (r107 == null) goto L117;
        r107.close();     // Catch: IOException -> L100
        throw th;
    L118:
        throw th;
    L117:
        throw th;
    L65:
        r109 = null;
    L85:
        e = e;
        goto L87
    L95:
        throw new IOException("Can't obtain InputStream for " + r103);
    L83:
        th = th;
        goto L101
    L97:
        return null;
    L103:
        PolarisFileWrapper r118 = new PolarisFileWrapper(new URI(r104.toString()));     // Catch: URISyntaxException -> L52
    L53:
        LOG.log(r100, "Looking in {0}", r118.getAbsolutePath());
        if (r118.exists() == false) goto L57;
        return r118;
    L57:
        throw new IOException("File URL " + r104 + " could not be properly decoded");
    L52:
        r118 = new PolarisFileWrapper(r104.getPath());
        goto L53
    L22:
        r103 = Platform.RESOURCE_PREFIX + HTTP.URL_DEFAULT + r102;
        goto L24
    L18:
        r102 = NativeLibrary.mapSharedLibraryName(r110);
        goto L20
    L5:
        if (DEBUG_JNA_LOAD == true) goto L7;
    L9:
        r100 = Level.FINE;
        goto L11
    L7:
        if (r110.contains("jnidispatch") == false) goto L9;
        goto L9
    }

    private static NativeMapped fromNative(Method r100, Object r101) {
        Class<?> r102 = r100.getReturnType();
        return (NativeMapped) NativeMappedConverter.getInstance(r102).fromNative(r101, new MethodResultContext(r102, null, null, r100));
    }

    public static byte[] getBytes(String r100, String r101) {
        return getBytes(r100, getCharset(r101));
    }

    public static int getNativeSize(Class<?> r100, Object r101) {
        if (r100.isArray() == false) goto L11;
        int r102 = Array.getLength(r101);
        if (r102 <= 0) goto L9;
        return r102 * getNativeSize(r100.getComponentType(), Array.get(r101, 0));
    L9:
        throw new IllegalArgumentException("Arrays of length zero not allowed: " + r100);
    L11:
        if (Structure.class.isAssignableFrom(r100) == true) goto L13;
    L21:
        return getNativeSize(r100);
    L18:
        e = move-exception;
        throw new IllegalArgumentException("The type \"" + r100.getName() + "\" is not supported: " + e.getMessage());
    L13:
        if (Structure.ByReference.class.isAssignableFrom(r100) == true) goto L21;
        return Structure.size(r100, (Structure) r101);
    }

    public static String getString(Pointer r100, long r101) {
        return getString(r100, r101, getDefaultStringEncoding());
    }

    public static boolean isCompatibleVersion(String r100, String r101) {
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length >= 3) goto L5;
    L13:
        return false;
    L5:
        if (r103.length < 3) goto L13;
        int r104 = CastIntegerProtector.parseInt(r102[0]);
        int r105 = CastIntegerProtector.parseInt(r103[0]);
        int r106 = CastIntegerProtector.parseInt(r102[1]);
        int r107 = CastIntegerProtector.parseInt(r103[1]);
        if (r104 == r105) goto L10;
        return false;
    L10:
        if (r106 <= r107) goto L12;
        return false;
    L12:
        return true;
    }

    public static <T extends Library> T load(String r100, Class<T> r101) {
        return (T) load(r100, r101, Collections.emptyMap());
    }

    public static <T> T loadLibrary(String r100, Class<T> r101) {
        return (T) loadLibrary(r100, r101, Collections.emptyMap());
    }

    public static void register(Class<?> r310, NativeLibrary r311) {
        Class<?> r100 = r310;
        Method[] r101 = r310.getDeclaredMethods();
        ArrayList r110 = new ArrayList();
        Map<String, ?> r102 = r311.getOptions();
        TypeMapper r111 = (TypeMapper) r102.get(Library.OPTION_TYPE_MAPPER);
        boolean r112 = Boolean.TRUE.equals(r102.get(Library.OPTION_ALLOW_OBJECTS));
        cacheOptions(r100, r102, null);
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        Method r105 = r101[r104];
        if ((r105.getModifiers() & 256) == 0) goto L7;
        r110.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        int r113 = r110.size();
        long[] r106 = new long[r113];
        int r107 = 0;
    L9:
        if (r107 >= r113) goto L86;
        Method r108 = (Method) ListProtector.get(r110, r107);
        Class<?> r109 = r108.getReturnType();
        Class<?>[] r114 = r108.getParameterTypes();
        long[] r115 = new long[r114.length];
        long[] r116 = new long[r114.length];
        int[] r117 = new int[r114.length];
        ToNativeConverter[] r210 = new ToNativeConverter[r114.length];
        long[] r118 = r106;
        int r119 = getConversion(r109, r111, r112);
        if (r119 == (-1)) goto L85;
        int r211 = r107;
        if (r119 == 3) goto L29;
        if (r119 == 4) goto L27;
        switch(r119) {
            case 17: goto L26;
            case 18: goto L26;
            case 19: goto L26;
            default: goto L16;
        };
    L16:
        switch(r119) {
            case 21: goto L26;
            case 22: goto L26;
            case 23: goto L21;
            case 24: goto L21;
            case 25: goto L21;
            case 26: goto L29;
            default: goto L17;
        };
    L17:
        long r120 = Structure.FFIType.get(r109).getPointer().peer;
    L18:
        long r212 = r120;
        long r213 = r212;
    L19:
        FromNativeConverter r214 = null;
    L30:
        String r121 = "(";
        int r122 = 0;
    L32:
        if (r122 >= r114.length) goto L68;
        Class<?> r123 = r114[r122];
        Class<?>[] r124 = r114;
        String r125 = r121 + getSignature(r123);
        int r126 = getConversion(r123, r111, r112);
        r117[r122] = r126;
        if (r126 == (-1)) goto L67;
        if (r126 != 17) goto L38;
    L51:
        r123 = NativeMappedConverter.getInstance(r123).nativeType();
    L52:
        if (r126 != 0) goto L54;
        long r127 = Structure.FFIType.get(r123).getPointer().peer;
        r115[r122] = r127;
        r116[r122] = r127;
    L65:
        r122 = r122 + 1;
        r114 = r124;
        r109 = r109;
        r121 = r125;
        goto L32
    L54:
        if (r126 == 4) goto L63;
        switch(r126) {
            case 17: goto L63;
            case 18: goto L63;
            case 19: goto L63;
            default: goto L56;
        };
    L56:
        switch(r126) {
            case 21: goto L63;
            case 22: goto L63;
            case 23: goto L59;
            case 24: goto L59;
            case 25: goto L59;
            default: goto L57;
        };
    L57:
        long r128 = Structure.FFIType.get(Pointer.class).getPointer().peer;
        r115[r122] = r128;
        r116[r122] = r128;
        goto L65
    L59:
        if (r123.isPrimitive() == true) goto L62;
        r123 = Pointer.class;
    L62:
        r116[r122] = Structure.FFIType.get(r123).getPointer().peer;
        r115[r122] = Structure.FFIType.get(r210[r122].nativeType()).getPointer().peer;
    L63:
        r115[r122] = Structure.FFIType.get(r123).getPointer().peer;
        r116[r122] = Structure.FFIType.get(Pointer.class).getPointer().peer;
        goto L65
    L38:
        if (r126 == 18) goto L51;
        if (r126 == 19) goto L51;
        if (r126 == 21) goto L51;
        if (r126 != 23) goto L47;
    L50:
        r210[r122] = r111.getToNativeConverter(r123);
        goto L52
    L47:
        if (r126 == 24) goto L50;
        if (r126 != 25) goto L52;
    L67:
        throw new IllegalArgumentException(r123 + " is not a supported argument type (in method " + r108.getName() + " in " + r100 + ")");
    L68:
        String r129 = r121 + ")";
        String r130 = r129 + getSignature(r109);
        Class<?>[] r131 = r108.getExceptionTypes();
        int r132 = 0;
    L70:
        if (r132 >= r131.length) goto L75;
        if (LastErrorException.class.isAssignableFrom(r131[r132]) == true) goto L73;
        r132 = r132 + 1;
        goto L70
    L73:
        boolean r133 = true;
    L76:
        Function r134 = r311.getFunction(r108.getName(), r108);
        ArrayList r135 = r110;
        TypeMapper r215 = r111;
        Method r312 = r108;
        ToNativeConverter[] r136 = r210;
        int r216 = r113;
        boolean r217 = r112;
        r118[r211] = registerMethod(r310, r108.getName(), r130, r117, r116, r115, r119, r212, r213, r312, r134.peer, r134.getCallingConvention(), r133, r136, r214, r134.encoding);     // Catch: NoSuchMethodError -> L94
        r107 = r211 + 1;
        r106 = r118;
        r113 = r216;
        r112 = r217;
        r110 = r135;
        r111 = r215;
        r100 = r310;
    L83:
        throw new UnsatisfiedLinkError("No method " + r312.getName() + " with signature " + r130 + " in " + r310);
    L81:
        r312 = r108;
        goto L83
    L75:
        r133 = false;
        goto L76
    L21:
        r210 = r210;
        FromNativeConverter r137 = r111.getFromNativeConverter(r109);
        if (r109.isPrimitive() == false) goto L24;
        Class<?> r138 = r109;
    L25:
        long r139 = Structure.FFIType.get(r138).getPointer().peer;
        r214 = r137;
        r212 = r139;
        r213 = Structure.FFIType.get(r137.nativeType()).getPointer().peer;
        goto L30
    L24:
        r138 = Pointer.class;
    L26:
        r212 = Structure.FFIType.get(Pointer.class).getPointer().peer;
        long r140 = Structure.FFIType.get(NativeMappedConverter.getInstance(r109).nativeType()).getPointer().peer;
    L28:
        r213 = r140;
        goto L19
    L27:
        r212 = Structure.FFIType.get(Pointer.class).getPointer().peer;
        r140 = Structure.FFIType.get(r109).getPointer().peer;
    L29:
        r120 = Structure.FFIType.get(Pointer.class).getPointer().peer;
        goto L18
    L85:
        throw new IllegalArgumentException(r109 + " is not a supported return type (in method " + r108.getName() + " in " + r100 + ")");
    L86:
        Class<?> r141 = r100;
        long[] r142 = r106;
        Map<Class<?>, long[]> r143 = registeredClasses;
        monitor-enter(r143);
        r143.put(r141, r142);     // Catch: Throwable -> L91
        registeredLibraries.put(r141, r311);     // Catch: Throwable -> L91
        monitor-exit(r143);     // Catch: Throwable -> L91
        return;
    L91:
        th = move-exception;
        throw th;
    }

    public static void setCallbackThreadInitializer(Callback r100, CallbackThreadInitializer r101) {
        CallbackReference.setCallbackThreadInitializer(r100, r101);
    }

    public static byte[] toByteArray(String r100, Charset r101) {
        byte[] r102 = getBytes(r100, r101);
        byte[] r103 = new byte[r102.length + 1];
        System.arraycopy(r102, 0, r103, 0, r102.length);
        return r103;
    }

    private static Object toNative(ToNativeConverter r100, Object r101) {
        return r100.toNative(r101, new ToNativeContext());
    }

    public static String toString(byte[] r100, Charset r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r100[r103] == 0) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        r102 = r103;
    L8:
        if (r102 != 0) goto L12;
        return "";
    L12:
        return new String(r100, 0, r102, r101);
    }

    private static NativeMapped fromNative(Class<?> r100, Object r101) {
        return (NativeMapped) NativeMappedConverter.getInstance(r100).fromNative(r101, new FromNativeContext(r100));
    }

    public static byte[] getBytes(String r100, Charset r101) {
        return r100.getBytes(r101);
    }

    public static <T extends Library> T load(Class<T> r100, Map<String, ?> r101) {
        return (T) load(null, r100, r101);
    }

    public static <T> T loadLibrary(Class<T> r100, Map<String, ?> r101) {
        return (T) loadLibrary(null, r100, r101);
    }

    public static void register(Class<?> r100, String r101) {
        register(r100, NativeLibrary.getInstance(r101, Collections.singletonMap(Library.OPTION_CLASSLOADER, r100.getClassLoader())));
    }

    public static byte[] toByteArray(String r100, String r101) {
        return toByteArray(r100, getCharset(r101));
    }

    public static String toString(byte[] r100, String r101) {
        return toString(r100, getCharset(r101));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_sun_jna_Native_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$002(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$002(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    private static Map<String, Object> cacheOptions(Class<?> r100, Map<String, ?> r101, Object r102) {
        HashMap r103 = new HashMap(r101);
        r103.put(_OPTION_ENCLOSING_LIBRARY, r100);
        typeOptions.put(r100, r103);
        if (r102 == null) goto L6;
        libraries.put(r100, new WeakReference(r102));
    L6:
        if (r100.isInterface() == false) goto L8;
    L15:
        return r103;
    L8:
        if (Library.class.isAssignableFrom(r100) == false) goto L15;
        Class<?>[] r104 = r100.getInterfaces();
        int r105 = r104.length;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L15;
        Class<?> r107 = r104[r106];
        if (Library.class.isAssignableFrom(r107) == true) goto L13;
        r106 = r106 + 1;
        goto L10
    L13:
        cacheOptions(r107, r103, r102);
        goto L15
    }

    private static Object fromNative(FromNativeConverter r100, Object r101, Method r102) {
        return r100.fromNative(r101, new MethodResultContext(r102.getReturnType(), null, null, r102));
    }

    private static int getConversion(Class<?> r100, TypeMapper r101, boolean r102) {
        if (r100 != Void.class) goto L5;
        r100 = Void.TYPE;
    L5:
        if (r101 == null) goto L24;
        FromNativeConverter r103 = r101.getFromNativeConverter(r100);
        ToNativeConverter r104 = r101.getToNativeConverter(r100);
        if (r103 == null) goto L15;
        Class<?> r105 = r103.nativeType();
        if (r105 != String.class) goto L12;
        return 24;
    L12:
        if (r105 != WString.class) goto L14;
        return 25;
    L14:
        return 23;
    L15:
        if (r104 == null) goto L24;
        Class<?> r106 = r104.nativeType();
        if (r106 != String.class) goto L20;
        return 24;
    L20:
        if (r106 != WString.class) goto L22;
        return 25;
    L22:
        return 23;
    L24:
        if (Pointer.class.isAssignableFrom(r100) == false) goto L27;
        return 1;
    L27:
        if (String.class != r100) goto L31;
        return 2;
    L31:
        if (WString.class.isAssignableFrom(r100) == false) goto L35;
        return 20;
    L35:
        if (Platform.HAS_BUFFERS == false) goto L41;
        if (Buffers.isBuffer(r100) == false) goto L41;
        return 5;
    L41:
        if (Structure.class.isAssignableFrom(r100) == false) goto L49;
        if (Structure.ByValue.class.isAssignableFrom(r100) == false) goto L46;
        return 4;
    L46:
        return 3;
    L49:
        if (r100.isArray() == false) goto L79;
        char r107 = r100.getName().charAt(1);
        if (r107 != 'F') goto L53;
        return 11;
    L53:
        if (r107 != 'S') goto L55;
        return 7;
    L55:
        if (r107 != 'Z') goto L57;
        return 13;
    L57:
        if (r107 != 'I') goto L59;
        return 9;
    L59:
        if (r107 == 'J') goto L68;
        switch(r107) {
            case 66: goto L66;
            case 67: goto L64;
            case 68: goto L62;
            default: goto L79;
        };
    L62:
        return 12;
    L64:
        return 8;
    L66:
        return 6;
    L68:
        return 10;
    L79:
        if (r100.isPrimitive() == false) goto L86;
        if (r100 != Boolean.TYPE) goto L83;
        return 14;
    L83:
        return 0;
    L86:
        if (Callback.class.isAssignableFrom(r100) == false) goto L90;
        return 15;
    L90:
        if (IntegerType.class.isAssignableFrom(r100) == false) goto L94;
        return 21;
    L94:
        if (PointerType.class.isAssignableFrom(r100) == false) goto L98;
        return 22;
    L98:
        if (NativeMapped.class.isAssignableFrom(r100) == false) goto L110;
        Class<?> r108 = NativeMappedConverter.getInstance(r100).nativeType();
        if (r108 != String.class) goto L104;
        return 18;
    L104:
        if (r108 != WString.class) goto L107;
        return 19;
    L107:
        return 17;
    L110:
        if (JNIEnv.class != r100) goto L113;
        return 27;
    L113:
        if (r102 == false) goto L115;
        return 26;
    L115:
        return -1;
    }

    public static String getString(Pointer r100, long r101, String r102) {
        byte[] r103 = getStringBytes(r100, r100.peer, r101);
        if (r102 == null) goto L7;
        return new String(r103, r102);
    L7:
        return new String(r103);
    }

    public static <T extends Library> T load(String r100, Class<T> r101, Map<String, ?> r102) {
        if (Library.class.isAssignableFrom(r101) == false) goto L7;
        Object r103 = Proxy.newProxyInstance(r101.getClassLoader(), new Class[]{r101}, new Library.Handler(r100, r101, r102));
        cacheOptions(r101, r102, r103);
        return r101.cast(r103);
    L7:
        throw new IllegalArgumentException("Interface (" + r101.getSimpleName() + ") of library=" + r100 + " does not extend Library");
    }

    public static <T> T loadLibrary(String r100, Class<T> r101, Map<String, ?> r102) {
        if (Library.class.isAssignableFrom(r101) == false) goto L7;
        Object r103 = Proxy.newProxyInstance(r101.getClassLoader(), new Class[]{r101}, new Library.Handler(r100, r101, r102));
        cacheOptions(r101, r102, r103);
        return r101.cast(r103);
    L7:
        throw new IllegalArgumentException("Interface (" + r101.getSimpleName() + ") of library=" + r100 + " does not extend Library");
    }

    private static Object lookupField(Class<?> r100, String r101, Class<?> r102) {
        Field r103 = r100.getField(r101);     // Catch: Exception -> L5 NoSuchFieldException -> L8
        r103.setAccessible(true);     // Catch: Exception -> L5 NoSuchFieldException -> L8
        return r103.get(null);
    L8:
        return null;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(r101 + " must be a public field of type " + r102.getName() + " (" + e + "): " + r100);
    }

    public static String replace(String r100, String r101, String r102) {
        StringBuilder r103 = new StringBuilder();
    L3:
        int r104 = r102.indexOf(r100);
        if (r104 == (-1)) goto L5;
        r103.append(r102.substring(0, r104));
        r103.append(r101);
        r102 = r102.substring(r104 + r100.length());
        goto L3
    L5:
        r103.append(r102);
        return r103.toString();
    }

    public static List<String> toStringList(char[] r100, int r101, int r102) {
        ArrayList r103 = new ArrayList();
        int r104 = r102 + r101;
        int r105 = r101;
    L3:
        if (r101 >= r104) goto L11;
        if (r100[r101] != 0) goto L10;
        if (r105 == r101) goto L8;
        r103.add(new String(r100, r105, r101 - r105));
        r105 = r101 + 1;
        goto L10
    L8:
        return r103;
    L10:
        r101 = r101 + 1;
        goto L3
    L11:
        if (r105 >= r104) goto L13;
        r103.add(new String(r100, r105, r104 - r105));
    L13:
        return r103;
    }

    public static Structure invokeStructure(Function r110, long r111, int r112, Object[] r113, Structure r114) {
        invokeStructure(r110, r111, r112, r113, r114.getPointer().peer, r114.getTypeInfo().peer);
        return r114;
    }
}
