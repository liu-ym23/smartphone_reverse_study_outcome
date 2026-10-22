package com.ss.ttm.player;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import com.ss.ttm.vcshared.VCBaseKitLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class TTPlayerLibLoader {
    private static final int DEGRADED_VERSION = 2925;
    private static boolean IsErrored;
    private static final String TAG = null;
    private static ILibraryLoader mDebugLibraryLoader;
    private static ILibraryLoader mDefaultLibLoader;
    private static String mErrorInfo;
    private static boolean mLibraryLoaded;
    private static ILibraryLoader mLibraryLoader;
    private static int mVersion;
    private static String playerLibName;

    /* JADX INFO: renamed from: com.ss.ttm.player.TTPlayerLibLoader$1, reason: invalid class name */
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
        public static void INVOKESTATIC_com_ss_ttm_player_TTPlayerLibLoader$DefaultLibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
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
            INVOKESTATIC_com_ss_ttm_player_TTPlayerLibLoader$DefaultLibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r101.next());     // Catch: Throwable -> L8
            TTPlayerLibLoader.access$100();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            TTPlayerLibLoader.access$202(th.getMessage());
            TTPlayerLibLoader.access$100();
            TTPlayerLibLoader.access$200();
            return false;
        L11:
            return true;
        }
    }

    public TTPlayerLibLoader() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    static {
        TAG = "TTPlayerLibLoader";
        mDefaultLibLoader = new DefaultLibraryLoader(null);
        mLibraryLoaded = false;
        IsErrored = false;
        mErrorInfo = null;
        mVersion = 0;
        playerLibName = "";
    }

    public static final synchronized void loadLibrary() {
        monitor-enter(TTPlayerLibLoader.class);
        boolean r100 = false;
        if (mVersion != 0) goto L8;
        mVersion = TTPlayerConfiger.getValue(13, 0) / 1000;     // Catch: Throwable -> L189
    L8:
        VCBaseKitLoader.loadLibrary();     // Catch: Throwable -> L189
        TTPlayerConfiger.getValue(76, "");     // Catch: Throwable -> L189
        if (mVersion != DEGRADED_VERSION) goto L11;
        boolean r101 = true;
    L13:
        if (TTPlayerConfiger.getValue(3, false) == false) goto L75;
        if (r101 == true) goto L23;
        if (TTPlayerConfiger.getValue(30, false) == true) goto L19;
        INVOKESTATIC_com_ss_ttm_player_TTPlayerLibLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: Throwable -> L189
    L19:
        if (TTPlayerConfiger.getValue(28, false) == true) goto L21;
        loadPlayerlibrary("ttcrypto");     // Catch: Throwable -> L189
        loadPlayerlibrary("ttboringssl");     // Catch: Throwable -> L189
    L21:
        loadPlayerlibrary("ByteVC1_dec");     // Catch: Throwable -> L189
        loadPlayerlibrary("ttffmpeg");     // Catch: Throwable -> L189
    L23:
        if (TTPlayerConfiger.getValue(29, false) == false) goto L32;
        if (loadPlayerlibrary("ttmplayerbeta") == false) goto L27;
        playerLibName = "ttmplayerbeta";     // Catch: Throwable -> L189
    L71:
        if (IsErrored == false) goto L73;
    L191:
        monitor-exit(TTPlayerLibLoader.class);
        return;
    L73:
        if (playerLibName.isEmpty() == false) goto L191;
        playerLibName = "ttmplayer";     // Catch: Throwable -> L189
        goto L191
    L27:
        if (loadPlayerlibrary("ttmplayer") == true) goto L29;
        r100 = true;
    L29:
        IsErrored = r100;     // Catch: Throwable -> L189
        goto L71
    L32:
        if (TTPlayerConfiger.getValue(76, "").equals("default") == false) goto L41;
        if (loadPlayerlibrary("ttmplayerdef") == false) goto L36;
        playerLibName = "ttmplayerdef";     // Catch: Throwable -> L189
        goto L71
    L36:
        if (loadPlayerlibrary("ttmplayer") == true) goto L38;
        r100 = true;
    L38:
        IsErrored = r100;     // Catch: Throwable -> L189
        goto L71
    L41:
        if (TTPlayerConfiger.getValue(76, "").equals("pgo") == false) goto L50;
        if (loadPlayerlibrary("ttmplayerpgo") == false) goto L45;
        playerLibName = "ttmplayerpgo";     // Catch: Throwable -> L189
        goto L71
    L45:
        if (loadPlayerlibrary("ttmplayer") == true) goto L47;
        r100 = true;
    L47:
        IsErrored = r100;     // Catch: Throwable -> L189
        goto L71
    L50:
        if (TTPlayerConfiger.getValue(76, "").equals("bytepgo") == false) goto L59;
        if (loadPlayerlibrary("ttmplayerbytepgo") == false) goto L54;
        playerLibName = "ttmplayerbytepgo";     // Catch: Throwable -> L189
        goto L71
    L54:
        if (loadPlayerlibrary("ttmplayer") == true) goto L56;
        r100 = true;
    L56:
        IsErrored = r100;     // Catch: Throwable -> L189
        goto L71
    L59:
        if (TTPlayerConfiger.getValue(76, "").equals(DevicePlans.DEVICE_PLAN_OPPO3) == false) goto L68;
        if (loadPlayerlibrary("ttmplayero3") == false) goto L63;
        playerLibName = "ttmplayero3";     // Catch: Throwable -> L189
        goto L71
    L63:
        if (loadPlayerlibrary("ttmplayer") == true) goto L65;
        r100 = true;
    L65:
        IsErrored = r100;     // Catch: Throwable -> L189
        goto L71
    L68:
        if (loadPlayerlibrary("ttmplayer") == true) goto L71;
        IsErrored = true;     // Catch: Throwable -> L189
        goto L71
    L75:
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L189
        if (r101 == true) goto L85;
        if (TTPlayerConfiger.getValue(30, false) == true) goto L81;
        r102.add("c++_shared");     // Catch: Throwable -> L189
    L81:
        if (TTPlayerConfiger.getValue(28, false) == true) goto L83;
        r102.add("ttcrypto");     // Catch: Throwable -> L189
        r102.add("ttboringssl");     // Catch: Throwable -> L189
    L83:
        r102.add("ByteVC1_dec");     // Catch: Throwable -> L189
        r102.add("ttffmpeg");     // Catch: Throwable -> L189
    L85:
        if (TTPlayerConfiger.getValue(29, false) == false) goto L104;
        if (loadLibs(r102, false) == true) goto L89;
        boolean r103 = true;
    L90:
        IsErrored = r103;     // Catch: Throwable -> L189
        if (r103 == true) goto L184;
        r102.clear();     // Catch: Throwable -> L189
        r102.add("ttmplayerbeta");     // Catch: Throwable -> L189
        if (loadLibs(r102, true) == true) goto L95;
        boolean r104 = true;
    L96:
        IsErrored = r104;     // Catch: Throwable -> L189
        if (r104 == true) goto L99;
        playerLibName = "ttmplayerbeta";     // Catch: Throwable -> L189
        goto L184
    L99:
        r102.clear();     // Catch: Throwable -> L189
        r102.add("ttmplayer");     // Catch: Throwable -> L189
        if (loadLibs(r102, true) == true) goto L102;
        r100 = true;
    L102:
        IsErrored = r100;     // Catch: Throwable -> L189
        goto L184
    L95:
        r104 = false;
    L184:
        if (IsErrored == true) goto L191;
        if (playerLibName.isEmpty() == false) goto L191;
        playerLibName = "ttmplayer";     // Catch: Throwable -> L189
        goto L191
    L89:
        r103 = false;
        goto L90
    L104:
        if (TTPlayerConfiger.getValue(76, "").equals("default") == false) goto L123;
        if (loadLibs(r102, false) == true) goto L108;
        boolean r105 = true;
    L109:
        IsErrored = r105;     // Catch: Throwable -> L189
        if (r105 == true) goto L184;
        r102.clear();     // Catch: Throwable -> L189
        r102.add("ttmplayerdef");     // Catch: Throwable -> L189
        if (loadLibs(r102, true) == true) goto L114;
        boolean r106 = true;
    L115:
        IsErrored = r106;     // Catch: Throwable -> L189
        if (r106 == true) goto L118;
        playerLibName = "ttmplayerdef";     // Catch: Throwable -> L189
        goto L184
    L118:
        r102.clear();     // Catch: Throwable -> L189
        r102.add("ttmplayer");     // Catch: Throwable -> L189
        if (loadLibs(r102, true) == true) goto L121;
        r100 = true;
    L121:
        IsErrored = r100;     // Catch: Throwable -> L189
        goto L184
    L114:
        r106 = false;
        goto L115
    L108:
        r105 = false;
        goto L109
    L123:
        if (TTPlayerConfiger.getValue(76, "").equals("pgo") == false) goto L142;
        if (loadLibs(r102, false) == true) goto L127;
        boolean r107 = true;
    L128:
        IsErrored = r107;     // Catch: Throwable -> L189
        if (r107 == true) goto L184;
        r102.clear();     // Catch: Throwable -> L189
        r102.add("ttmplayerpgo");     // Catch: Throwable -> L189
        if (loadLibs(r102, true) == true) goto L133;
        boolean r108 = true;
    L134:
        IsErrored = r108;     // Catch: Throwable -> L189
        if (r108 == true) goto L137;
        playerLibName = "ttmplayerpgo";     // Catch: Throwable -> L189
        goto L184
    L137:
        r102.clear();     // Catch: Throwable -> L189
        r102.add("ttmplayer");     // Catch: Throwable -> L189
        if (loadLibs(r102, true) == true) goto L140;
        r100 = true;
    L140:
        IsErrored = r100;     // Catch: Throwable -> L189
        goto L184
    L133:
        r108 = false;
        goto L134
    L127:
        r107 = false;
        goto L128
    L142:
        if (TTPlayerConfiger.getValue(76, "").equals("bytepgo") == false) goto L161;
        if (loadLibs(r102, false) == true) goto L146;
        boolean r109 = true;
    L147:
        IsErrored = r109;     // Catch: Throwable -> L189
        if (r109 == true) goto L184;
        r102.clear();     // Catch: Throwable -> L189
        r102.add("ttmplayerbytepgo");     // Catch: Throwable -> L189
        if (loadLibs(r102, true) == true) goto L152;
        boolean r110 = true;
    L153:
        IsErrored = r110;     // Catch: Throwable -> L189
        if (r110 == true) goto L156;
        playerLibName = "ttmplayerbytepgo";     // Catch: Throwable -> L189
        goto L184
    L156:
        r102.clear();     // Catch: Throwable -> L189
        r102.add("ttmplayer");     // Catch: Throwable -> L189
        if (loadLibs(r102, true) == true) goto L159;
        r100 = true;
    L159:
        IsErrored = r100;     // Catch: Throwable -> L189
        goto L184
    L152:
        r110 = false;
        goto L153
    L146:
        r109 = false;
        goto L147
    L161:
        if (TTPlayerConfiger.getValue(76, "").equals(DevicePlans.DEVICE_PLAN_OPPO3) == true) goto L163;
        r102.add("ttmplayer");     // Catch: Throwable -> L189
        if (loadLibs(r102, false) == true) goto L182;
        r100 = true;
    L182:
        IsErrored = r100;     // Catch: Throwable -> L189
        goto L184
    L163:
        if (loadLibs(r102, false) == true) goto L165;
        boolean r111 = true;
    L166:
        IsErrored = r111;     // Catch: Throwable -> L189
        if (r111 == true) goto L184;
        r102.clear();     // Catch: Throwable -> L189
        r102.add("ttmplayero3");     // Catch: Throwable -> L189
        if (loadLibs(r102, true) == true) goto L171;
        boolean r112 = true;
    L172:
        IsErrored = r112;     // Catch: Throwable -> L189
        if (r112 == true) goto L175;
        playerLibName = "ttmplayero3";     // Catch: Throwable -> L189
        goto L184
    L175:
        r102.clear();     // Catch: Throwable -> L189
        r102.add("ttmplayer");     // Catch: Throwable -> L189
        if (loadLibs(r102, true) == true) goto L178;
        r100 = true;
    L178:
        IsErrored = r100;     // Catch: Throwable -> L189
        goto L184
    L171:
        r112 = false;
        goto L172
    L165:
        r111 = false;
        goto L166
    L11:
        r101 = false;
    L189:
        th = move-exception;
        IsErrored = true;     // Catch: Throwable -> L193
        th.printStackTrace();     // Catch: Throwable -> L193
        mErrorInfo = "load default library error." + th.toString();     // Catch: Throwable -> L193
    L193:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ String access$200() {
        return mErrorInfo;
    }

    public static String getErrorInfo() {
        return mErrorInfo;
    }

    public static String getPlayerLibName() {
        return playerLibName;
    }

    public static boolean isError() {
        return IsErrored;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_ttm_player_TTPlayerLibLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static /* synthetic */ String access$202(String r100) {
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

    private static boolean loadLibs(List<String> r100, boolean r101) {
        boolean r102 = mLibraryLoaded;
        if (((!r101) & r102) == false) goto L5;
        return r102;
    L5:
        ILibraryLoader r103 = mLibraryLoader;
        if (r103 != null) goto L14;
        mLibraryLoaded = mDefaultLibLoader.onLoadNativeLibs(r100);
    L13:
        return mLibraryLoaded;
    L14:
        mLibraryLoaded = r103.onLoadNativeLibs(r100);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        mErrorInfo = th.getMessage();
        goto L13
    }
}
