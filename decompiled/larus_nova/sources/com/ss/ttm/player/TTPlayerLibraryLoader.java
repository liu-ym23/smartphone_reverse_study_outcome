package com.ss.ttm.player;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class TTPlayerLibraryLoader {
    private static final int DEGRADED_VERSION = 2925;
    private static boolean IsErrored;
    private static final String TAG = null;
    private static ILibraryLoader mDebugLibraryLoader;
    private static ILibraryLoader mDefaultLibLoader;
    private static String mErrorInfo;
    private static boolean mLibraryLoaded;
    private static ILibraryLoader mLibraryLoader;
    private static ILibraryLoader mPluginLibLoader;
    private static int mVersion;

    /* JADX INFO: renamed from: com.ss.ttm.player.TTPlayerLibraryLoader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DefaultLibraryLoader implements ILibraryLoader {
        private DefaultLibraryLoader() {
        }

        public static /* synthetic */ void access$000(String r100) {
            System.loadLibrary(r100);
        }

        public /* synthetic */ DefaultLibraryLoader(AnonymousClass1 r100) {
            this();
        }

        @JvmStatic
        public static void INVOKESTATIC_com_ss_ttm_player_TTPlayerLibraryLoader$DefaultLibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
            Intrinsics.checkNotNullParameter(r100, "libName");
            FLogger r101 = FLogger.f375446a;
            r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
            com.bytedance.librarian.a.c(r100);
            r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
        }

        @Override // com.ss.ttm.player.ILibraryLoader
        public boolean onLoadNativeLibs(List<String> r100) {
            Iterator<String> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            INVOKESTATIC_com_ss_ttm_player_TTPlayerLibraryLoader$DefaultLibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r101.next());     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            TTPlayerLibraryLoader.access$102(th.getMessage());
            TTPlayerLibraryLoader.access$200();
            TTPlayerLibraryLoader.access$100();
            return false;
        L11:
            return true;
        }
    }

    public TTPlayerLibraryLoader() {
    }

    static {
        TAG = "TTPlayerLibraryLoader";
        mDefaultLibLoader = new DefaultLibraryLoader(null);
        mLibraryLoaded = false;
        IsErrored = false;
        mErrorInfo = null;
        mVersion = 0;
    }

    public static final synchronized void loadLibrary() {
        monitor-enter(TTPlayerLibraryLoader.class);
        boolean r100 = false;
        if (mVersion != 0) goto L9;
        mVersion = TTPlayerConfiger.getValue(13, 0) / 1000;     // Catch: Throwable -> L27
    L9:
        if (mVersion != DEGRADED_VERSION) goto L11;
        boolean r101 = true;
    L13:
        if (TTPlayerConfiger.getValue(3, false) == false) goto L19;
        if (r101 == true) goto L17;
        loadPlayerlibrary("ttopenssl");     // Catch: Throwable -> L27
        loadPlayerlibrary("mffmpeg");     // Catch: Throwable -> L27
    L17:
        if (loadPlayerlibrary("ttmplayer") == true) goto L29;
        IsErrored = true;     // Catch: Throwable -> L27
    L29:
        monitor-exit(TTPlayerLibraryLoader.class);
        return;
    L19:
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L27
        if (r101 == true) goto L22;
        r102.add("ttopenssl");     // Catch: Throwable -> L27
        r102.add("mffmpeg");     // Catch: Throwable -> L27
    L22:
        r102.add("ttmplayer");     // Catch: Throwable -> L27
        if (loadLibs(r102, false) == true) goto L25;
        r100 = true;
    L25:
        IsErrored = r100;     // Catch: Throwable -> L27
        goto L29
    L11:
        r101 = false;
    L27:
        th = move-exception;
        IsErrored = true;     // Catch: Throwable -> L31
        th.printStackTrace();     // Catch: Throwable -> L31
        mErrorInfo = "load default library error." + th.toString();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ String access$100() {
        return mErrorInfo;
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static String getErrorInfo() {
        return mErrorInfo;
    }

    public static boolean isError() {
        return IsErrored;
    }

    public static /* synthetic */ String access$102(String r100) {
        mErrorInfo = r100;
        return r100;
    }

    private static boolean loadPlayerlibrary(String r100) {
        TTPlayerConfiger.setLibraryName("lib" + r100 + ".so");     // Catch: Throwable -> L14
        TTPlayerConfiger.checkDebugTTPlayerLib();     // Catch: Throwable -> L14
        String r101 = TTPlayerConfiger.getPlayerLibraryPath();     // Catch: Throwable -> L14
        if (r101 != null) goto L6;
    L8:
        if (r101 == null) goto L17;
        if (mDebugLibraryLoader == null) goto L12;
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L14
        r102.add(r101);     // Catch: Throwable -> L14
        mDebugLibraryLoader.onLoadNativeLibs(r102);     // Catch: Throwable -> L14
        goto L17
    L12:
        System.load(r101);     // Catch: Throwable -> L14
    L17:
        if (r101 == null) goto L23;
    L22:
        return true;
    L23:
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L20
        r103.add(r100);     // Catch: Throwable -> L20
        loadLibs(r103, true);     // Catch: Throwable -> L20
        mErrorInfo = null;
    L21:
        return false;
    L6:
        if (new PolarisFileWrapper(r101).exists() == true) goto L8;
        r101 = null;
    L14:
        th = move-exception;
        th.printStackTrace();
        mErrorInfo = "load path library error." + th.toString();
        r101 = null;
        goto L17
    }

    public static final void setDebugLibraryLoader(ILibraryLoader r100) {
        mDebugLibraryLoader = r100;
    }

    public static final void setLibraryLoader(ILibraryLoader r100) {
        mLibraryLoader = r100;
    }

    public static final void setPluginLibraryLoader(ILibraryLoader r100) {
        mPluginLibLoader = r100;
    }

    private static boolean loadLibs(List<String> r100, boolean r101) {
        boolean r102 = mLibraryLoaded;
        if (((!r101) & r102) == false) goto L5;
        return r102;
    L5:
        ILibraryLoader r103 = mLibraryLoader;
        if (r103 != null) goto L20;
        ILibraryLoader r104 = mPluginLibLoader;
        if (r104 != null) goto L22;
        mLibraryLoaded = mDefaultLibLoader.onLoadNativeLibs(r100);
    L19:
        return mLibraryLoaded;
    L22:
        mLibraryLoaded = r104.onLoadNativeLibs(r100);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        mErrorInfo = th.getMessage();
        goto L19
    L20:
        mLibraryLoaded = r103.onLoadNativeLibs(r100);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        mErrorInfo = th.getMessage();
        goto L19
    }
}
