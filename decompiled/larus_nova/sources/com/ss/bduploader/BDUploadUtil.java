package com.ss.bduploader;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.bduploader.logupload.VideoEventEngineUploader;
import com.ss.bduploader.net.BDUploadThreadPool;
import com.ss.bduploader.util.BDUrlDispatchInterface;
import com.ss.mediakit.vcnlib.VcnlibloadWrapper;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class BDUploadUtil {
    public static String DiskResumeConfigDir = "DiskResumeConfigDir";
    public static String RetryStatesInfoDir = "RetryStatesInfoDir";
    public static String SpeedTestcontextDir = "SpeedTestcontextDir";
    private static final int UPDATE_PEROID = 300000;
    public static VideoEventEngineUploader eventEngineUploader;
    public static Boolean mEnableDisaptch;
    public static Boolean mEnableNativeLog;
    private static volatile boolean mIsLibraryLoaded;
    private static volatile boolean mIsXQuicLoaded;
    private static final ReentrantLock mLock = null;
    private static volatile BDLibraryLoaderProxy mProxy;
    private static volatile String mServerIP;
    private static volatile long mServerIPTime;
    public static String sdkConfigDir;
    public static BDUrlDispatchInterface urlDispatch;

    public BDUploadUtil() {
    }

    public static /* synthetic */ void a() {
        lambda$getDNSServerIP$0();
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    static {
        mLock = new ReentrantLock();
        eventEngineUploader = null;
        urlDispatch = null;
        Boolean r100 = Boolean.FALSE;
        mEnableDisaptch = r100;
        mEnableNativeLog = r100;
    }

    public static synchronized String getDNSServerIP() {
        monitor-enter(BDUploadUtil.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if ((SystemClock.elapsedRealtime() - mServerIPTime) < 300000) goto L7;
        BDUploadThreadPool.addExecuteTask(new a());     // Catch: Throwable -> L10
    L7:
        String r100 = mServerIP;     // Catch: Throwable -> L10
        monitor-exit(BDUploadUtil.class);
        return r100;
    }

    private static boolean loadLibrary() {
        boolean r100 = true;
        if (mProxy != null) goto L6;
        return true;
    L6:
        if (mProxy == null) goto L27;
        if (mIsLibraryLoaded == true) goto L27;
        boolean r101 = pc4.a.b();
        boolean r102 = mProxy.loadLibrary("ttopenssl");
        if (r101 == true) goto L14;
        if (r102 == true) goto L14;
        boolean r103 = false;
    L15:
        mProxy.loadLibrary("vcn");
        mProxy.loadLibrary("vcnverify");
        boolean r104 = mProxy.loadLibrary("xquic");
        boolean r105 = mProxy.loadLibrary("xquicclient");
        boolean r106 = mProxy.loadLibrary("bdvideouploader");
        if (r104 == false) goto L19;
        if (r105 == false) goto L19;
        boolean r107 = true;
    L20:
        mIsXQuicLoaded = r107;
        if (r103 == false) goto L24;
        if (r106 == false) goto L24;
    L25:
        mIsLibraryLoaded = r100;
    L24:
        r100 = false;
    L19:
        r107 = false;
    L14:
        r103 = true;
    L27:
        return mIsLibraryLoaded;
    }

    public static synchronized void updateDNSServerIP() {
        monitor-enter(BDUploadUtil.class);
    L12:
        th = move-exception;
        throw th;
    L6:
        if ((SystemClock.elapsedRealtime() - mServerIPTime) >= 300000) goto L9;
        monitor-exit(BDUploadUtil.class);
        return;
    L9:
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(), "/BDUploadUtil"));     // Catch: Throwable -> L12
        monitor-exit(BDUploadUtil.class);
    }

    public static synchronized boolean xquicAvalilable() {
        monitor-enter(BDUploadUtil.class);
        boolean r100 = mIsXQuicLoaded;     // Catch: Throwable -> L7
        monitor-exit(BDUploadUtil.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$getDNSServerIP$0() {
        InetAddress r100 = InetAddress.getByName("whoami.akamai.net");     // Catch: UnknownHostException -> L6
        if (r100 == null) goto L9;
        mServerIP = r100.getHostAddress();     // Catch: UnknownHostException -> L6
        mServerIPTime = SystemClock.elapsedRealtime();     // Catch: UnknownHostException -> L6
        return;
    L9:
        return;
    }

    private static boolean loadVcn() {
        VcnlibloadWrapper.tryLoadVcnlib();
        VcnlibloadWrapper.tryLoadVcnverifylib();
        return true;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_bduploader_BDUploadUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static /* synthetic */ String access$002(String r100) {
        mServerIP = r100;
        return r100;
    }

    public static /* synthetic */ long access$102(long r100) {
        mServerIPTime = r100;
        return r100;
    }

    public static int createDir(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L5;
        String r102 = File.separator;
        if (r100.endsWith(r102) == true) goto L10;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append(r102);
    L10:
        if (r101.mkdirs() == false) goto L14;
        return 1;
    L14:
        return -1;
    L5:
        return 1;
    }

    public static synchronized boolean initInternal(StringBuffer r100) {
        monitor-enter(BDUploadUtil.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (loadLibrary() == true) goto L10;
        String.format("proxy library load fail", new Object[0]);     // Catch: Throwable -> L20
        monitor-exit(BDUploadUtil.class);
        return false;
    L10:
        if (mProxy == null) goto L12;
        boolean r101 = true;
    L14:
        if (systemLoadInit(r101, r100) == 1) goto L18;
        String.format("library has not been loaded", new Object[0]);     // Catch: Throwable -> L20
        monitor-exit(BDUploadUtil.class);
        return false;
    L18:
        monitor-exit(BDUploadUtil.class);
        return true;
    L12:
        r101 = false;
        goto L14
    }

    public static Map<String, String> jsonToHashMap(JSONObject r100) {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = String.valueOf(r102.next());
        r101.put(r103, r100.optString(r103));
        goto L4
    L6:
        return r101;
    }

    public static JSONObject mapToJSON(Map<String, Object> r100) {
        if (r100 != null) goto L17;
        return null;
    L17:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L14
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: Exception -> L14
    L7:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();     // Catch: Exception -> L14
        Object r104 = r100.get(r103);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r103) == true) goto L7;
        r101.put(r103, r104);     // Catch: Exception -> L14
        goto L7
    L13:
        return r101;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String mapToString(Map<String, Object> r100) {
        if (r100 != null) goto L15;
        return null;
    L15:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L14
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: Exception -> L14
    L7:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Exception -> L14
        Object r104 = r100.get(r103);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r103) == true) goto L7;
        r101.put(r103, r104);     // Catch: Exception -> L14
        goto L7
    L12:
        return r101.toString();
    L14:
        return null;
    }

    public static void setDispatchImp(BDUrlDispatchInterface r100) {
        urlDispatch = r100;
    }

    public static void setEnableDispatch(Boolean r100) {
        mEnableDisaptch = r100;
    }

    public static void setEnableNativeLog(Boolean r100) {
        mEnableNativeLog = r100;
    }

    public static void setLoadProxy(BDLibraryLoaderProxy r100) {
        ReentrantLock r101 = mLock;
        r101.lock();
        if (r100 != null) goto L11;
    L9:
        r101.unlock();
        return;
    L11:
        mProxy = r100;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        mLock.unlock();
        throw th;
    }

    public static void setSDKConfigDir(String r100) {
        String r101 = sdkConfigDir;
        if (r101 != null) goto L5;
    L7:
        sdkConfigDir = r100;
        return;
    L5:
        if (r101.length() <= 0) goto L7;
    }

    public static void setVideoEventUpload(VideoEventEngineUploader r100) {
        eventEngineUploader = r100;
    }

    private static int systemLoadInit(boolean r100, StringBuffer r101) {
        if (mIsLibraryLoaded == false) goto L5;
        return 1;
    L5:
        mIsLibraryLoaded = r100;
        if (mIsLibraryLoaded == true) goto L23;
        pc4.a.b();
        VcnlibloadWrapper.tryLoadVcnlib();
        VcnlibloadWrapper.tryLoadVcnverifylib();
        INVOKESTATIC_com_ss_bduploader_BDUploadUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("xquic");     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        INVOKESTATIC_com_ss_bduploader_BDUploadUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("xquicclient");     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        boolean r102 = true;
    L15:
        mIsXQuicLoaded = r102;
        INVOKESTATIC_com_ss_bduploader_BDUploadUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bdvideouploader");     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
        mIsLibraryLoaded = true;     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
    L20:
        e = move-exception;
        e.toString();
        r101.append(e.toString());
    L18:
        th = move-exception;
        th.toString();
        r101.append(th.toString());
        goto L23
    L12:
        e = move-exception;
        e.toString();
    L14:
        r102 = false;
    L10:
        th = move-exception;
        th.toString();
    L23:
        if (mIsLibraryLoaded == true) goto L26;
        return -1;
    L26:
        return 1;
    }
}
