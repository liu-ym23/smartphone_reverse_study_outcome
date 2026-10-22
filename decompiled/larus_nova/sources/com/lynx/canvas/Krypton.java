package com.lynx.canvas;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class Krypton {
    public static int FONT_STYLE_ITALIC = 1;
    public static int FONT_STYLE_NORMAL = 0;
    public static int FONT_WEIGHT_BOLD = 700;
    public static int FONT_WEIGHT_NORMAL = 400;
    private static final String TAG = "Krypton";
    private static volatile Krypton sInstance;
    private Context context;
    private volatile boolean hasInit;
    private ConcurrentHashMap<String, IKryptonJavaLogger> mLoggerDictionary;
    private IKryptonNativeLibraryLoader mNativeLibraryLoader;

    public interface IKryptonJavaLogger {
        void d(String r100, String r101);

        void e(String r100, String r101);

        void i(String r100, String r101);

        void v(String r100, String r101);

        void w(String r100, String r101);
    }

    public interface IKryptonNativeLibraryLoader {
        void loadLibrary(String r100) throws UnsatisfiedLinkError;
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public native void nativeRegisterLogger(String r100, long r101);

    public static Krypton inst() {
        if (sInstance != null) goto L15;
        monitor-enter(Krypton.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new Krypton();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Krypton.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private Krypton() {
        this.hasInit = false;
        this.mLoggerDictionary = new ConcurrentHashMap();
    }

    public Context getContext() {
        return this.context;
    }

    public ConcurrentHashMap<String, IKryptonJavaLogger> getLoggers() {
        return this.mLoggerDictionary;
    }

    public IKryptonNativeLibraryLoader getNativeLibraryLoader() {
        return this.mNativeLibraryLoader;
    }

    public boolean hasInitialized() {
        return this.hasInit;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_canvas_Krypton_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    private static boolean isES3Supported(Context r100) {
        if (((ActivityManager) r100.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion < 196608) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public void registerFontLazyProvider(KryptonFontLazyProvider r100) {
        CanvasFontRegistry.GetInstance().registerFontLazyProvider(r100);
    }

    public void setNativeLibraryLoader(IKryptonNativeLibraryLoader r100) {
        this.mNativeLibraryLoader = r100;
    }

    private static boolean triggerLoadLibrary(String r100, boolean r101) {
        return inst().loadLibrary(r100, r101);
    }

    public synchronized void init(IKryptonNativeLibraryLoader r100, Context r101) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (isES3Supported(r101) == true) goto L9;
        KryptonLLog.e(TAG, "Krypton not support with device do not support ES3");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L9:
        if (this.hasInit == false) goto L13;
        KryptonLLog.w(TAG, "Krypton has already been initialized");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L13:
        this.mNativeLibraryLoader = r100;     // Catch: Throwable -> L24
        this.context = r101;     // Catch: Throwable -> L24
        if (loadLibrary("lynxbase", true) == true) goto L18;
        monitor-exit(this);
        return;
    L18:
        if (loadLibrary("krypton", true) == true) goto L21;
        monitor-exit(this);
        return;
    L21:
        KryptonLLog.i(TAG, "Native Krypton Library load success ");     // Catch: Throwable -> L24
        this.hasInit = true;     // Catch: Throwable -> L24
        monitor-exit(this);
    }

    public boolean loadLibrary(String r100, boolean r101) {
        IKryptonNativeLibraryLoader r102 = this.mNativeLibraryLoader;     // Catch: RuntimeException -> L9 UnsatisfiedLinkError -> L16
        if (r102 == null) goto L6;
        r102.loadLibrary(r100);     // Catch: RuntimeException -> L9 UnsatisfiedLinkError -> L16
        KryptonLLog.i(TAG, "Native library load " + r100 + " success with native library loader");     // Catch: RuntimeException -> L9 UnsatisfiedLinkError -> L16
        return true;
    L6:
        INVOKESTATIC_com_lynx_canvas_Krypton_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);     // Catch: RuntimeException -> L9 UnsatisfiedLinkError -> L16
        KryptonLLog.i(TAG, "Native library load " + r100 + " success with System.loadLibrary");     // Catch: RuntimeException -> L9 UnsatisfiedLinkError -> L16
        return true;
    L9:
        e = move-exception;
        if (r101 == true) goto L12;
    L15:
        return false;
    L12:
        if (this.mNativeLibraryLoader != null) goto L14;
        KryptonLLog.e(TAG, "Native library load " + r100 + "from system with runtime exception " + e.getMessage());
        goto L15
    L14:
        KryptonLLog.e(TAG, "Native Library load from " + this.mNativeLibraryLoader.getClass().getName() + " with runtime exception " + e.getMessage());
    L16:
        e = move-exception;
        if (r101 == true) goto L19;
    L22:
        return false;
    L19:
        if (this.mNativeLibraryLoader != null) goto L21;
        KryptonLLog.e(TAG, "Native library load " + r100 + "from system with error message " + e.getMessage());
        goto L22
    L21:
        KryptonLLog.e(TAG, "Native Library load from " + this.mNativeLibraryLoader.getClass().getName() + " with error message " + e.getMessage());
        goto L22
    }

    public void registerLogger(String r100, IKryptonJavaLogger r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L7;
        this.mLoggerDictionary.remove(r100);
        return;
    L7:
        this.mLoggerDictionary.put(r100, r101);
    }

    public boolean registerFont(String r100, String r101, int r102, int r103) {
        return CanvasFontRegistry.GetInstance().registerFont(r100, r101, r102, r103);
    }
}
