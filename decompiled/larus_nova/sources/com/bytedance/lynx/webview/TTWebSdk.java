package com.bytedance.lynx.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewProvider;
import androidx.webkit.WebViewFeature;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.lynx.webview.adblock.TTAdblockClient;
import com.bytedance.lynx.webview.glue.ISdkToGlue;
import com.bytedance.lynx.webview.glue.PrerenderManager;
import com.bytedance.lynx.webview.glue.TTWebProviderWrapper;
import com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113;
import com.bytedance.lynx.webview.internal.EventStatistics;
import com.bytedance.lynx.webview.internal.LibraryLoader;
import com.bytedance.lynx.webview.internal.Setting;
import com.bytedance.lynx.webview.internal.TTAdblockContext;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.TTWebSDKDebug;
import com.bytedance.lynx.webview.internal.a1;
import com.bytedance.lynx.webview.internal.c0;
import com.bytedance.lynx.webview.internal.c1;
import com.bytedance.lynx.webview.internal.e0;
import com.bytedance.lynx.webview.internal.f0;
import com.bytedance.lynx.webview.internal.g0;
import com.bytedance.lynx.webview.internal.i0;
import com.bytedance.lynx.webview.internal.r;
import com.bytedance.lynx.webview.internal.s;
import com.bytedance.lynx.webview.internal.t;
import com.bytedance.lynx.webview.internal.t0;
import com.bytedance.lynx.webview.internal.u;
import com.bytedance.lynx.webview.internal.w;
import com.bytedance.lynx.webview.proxy.WebViewProviderProxy;
import com.bytedance.lynx.webview.util.DeleteReason;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.api.model.FlowDoraWifiScene;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import l17.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class TTWebSdk {
    private static AtomicBoolean isWebsdkInit;

    public static final enum DownloadType extends Enum<DownloadType> {
        private static final /* synthetic */ DownloadType[] $VALUES = null;
        public static final DownloadType KERNEL = null;
        public static final DownloadType OTHER = null;

        static {
            DownloadType r100 = new DownloadType(FlowDoraWifiScene.OTHER, 0);
            OTHER = r100;
            DownloadType r101 = new DownloadType("KERNEL", 1);
            KERNEL = r101;
            $VALUES = new DownloadType[]{r100, r101};
        }

        public static DownloadType[] values() {
            return (DownloadType[]) $VALUES.clone();
        }

        public static DownloadType valueOf(String r100) {
            return (DownloadType) r27.a.a(DownloadType.class, r100);
        }

        private DownloadType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class FailMessage {
        public static final int CHECK_ABI_DISABLE_LOAD = -5;
        public static final int CHECK_ABI_DISABLE_PREPARE = -6;
        public static final int CHECK_DECOMPRESS_DISABLE = -2;
        public static final int CHECK_DEX2OAT_DISABLE = -3;
        public static final int CHECK_EMPTY_DOWNLOAD_URL = -4;
        public static final int CHECK_INTEGRITY_FAILED = -114;
        public static final int CHECK_KERNEL_DISABLE = -1;
        public static final int CRASH_TOO_MANY_TIMES = -113;
        public static final int HOOK_FACTORY_PROVIDER_LATE = -111;
        public static final int LOAD_ADX_SUPPORTED_ERROR = -104;
        public static final int LOAD_CORE_VERSION_NOT_SUPPORT = 107;
        public static final int LOAD_DECOMPRESS_MD5_EMPTY = 102;
        public static final int LOAD_DEX_FILE_NOT_EXIST = 105;
        public static final int LOAD_DOWNLOAD_MD5_EMPTY = 101;
        public static final int LOAD_ERROR = 200;
        public static final int LOAD_FINISH_FILE_NOT_EXIST = 103;
        public static final int LOAD_HOST_ABI_DISABLE = -102;
        public static final int LOAD_ICU_FILE_NOT_AVAILABLE = 104;
        public static final int LOAD_INCOMPATIBLE_SO_VERSION = -103;
        public static final int LOAD_INTEGRITY_CHECK_FAILED = 108;
        public static final int LOAD_OSAPI_DISABLE = -101;
        public static final int LOAD_RESET_TO_SYSTEM = -106;
        public static final int LOAD_RE_ERROR = -105;
        public static final int LOAD_RS_KERNEL_WHITOUT_TTWEBCLASSLOADER = 106;
        public static final int LOAD_SWITCH_DISABLE = -100;
        public static final int LOAD_UNSUITED_SDK_SO_VERSION = 100;
        public static final int MD5_ERROR_CHECK = -112;
        private static final HashMap<Integer, String> MESSAGES = null;
        public static final int PROCESS_DECOMPRESS_FAIL = 2;
        public static final int PROCESS_DEX2OAT_FAIL = 3;
        public static final int PROCESS_DOWNLOAD_FAIL = 1;
        public static final int PROCESS_INTERNET_ERROR = 6;
        public static final int PROCESS_OTHER_FAIL = 4;
        public static final int PROCESS_PRE_SCHEDULE_ERROR = 5;

        public FailMessage() {
        }

        static {
            HashMap<Integer, String> r100 = new HashMap();
            MESSAGES = r100;
            r100.put(-1, "kernel disable in process");
            r100.put(-2, "decompress is disabled in settings when preparing kernel.");
            r100.put(-3, "dex2oat disable in settings when preparing kernel.");
            r100.put(-4, "empty download url of settings");
            r100.put(-6, "prepare abi is x86");
            r100.put(-5, "load abi is x86");
            r100.put(1, "download fail");
            r100.put(2, "decompress fail");
            r100.put(3, "dex2oat fail");
            r100.put(4, "other fail");
            r100.put(5, "pre-schedule error");
            r100.put(6, "cannot connect to Internet");
            r100.put(-100, "switch disable");
            r100.put(100, "incompatible sdk and so version");
            r100.put(101, "download md5 is empty");
            r100.put(102, "decompress md5 is empty");
            r100.put(103, "finish file not exists");
            r100.put(104, "icu file not available");
            r100.put(-101, "osapi is disable");
            r100.put(-102, "host api is disable");
            r100.put(105, "dex file not exits");
            r100.put(-103, "so version from md5 file is incompatible from compiled so");
            r100.put(-105, "load wrong runtime environment");
            r100.put(-104, "load error supported androidX");
            r100.put(-106, "unknown reason causes to reset to system webview");
            r100.put(200, "error occurs when load webview");
            r100.put(-111, "initTTWebView is too late to hook provider.");
            r100.put(-112, "md5 sum is not correct.");
            r100.put(-113, "User has crashed too many times.");
            r100.put(-114, "Check so integrity failed");
            r100.put(106, "RS Kernel with incorrect setting.");
        }

        public static String getMessage(int r100) {
            String r101 = MESSAGES.get(Integer.valueOf(r100));
            if (r101 != null) goto L6;
            return "";
        L6:
            return r101;
        }
    }

    public interface LoadListener {
        void onDecompress();

        void onDex2Oat();

        void onDownloadProgress(long r100, long r101);

        void onFail(int r100, String r101);

        void onSuccess();
    }

    public static final enum LoadPolicy extends Enum<LoadPolicy> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadPolicy[] f265027a = null;
        public static final LoadPolicy builtin_and_online = null;
        public static final LoadPolicy builtin_only = null;
        public static final LoadPolicy online_only = null;

        static {
            LoadPolicy r100 = new LoadPolicy("online_only", 0);
            online_only = r100;
            LoadPolicy r101 = new LoadPolicy("builtin_only", 1);
            builtin_only = r101;
            LoadPolicy r102 = new LoadPolicy("builtin_and_online", 2);
            builtin_and_online = r102;
            f265027a = new LoadPolicy[]{r100, r101, r102};
        }

        public static LoadPolicy[] values() {
            return (LoadPolicy[]) f265027a.clone();
        }

        public static LoadPolicy valueOf(String r100) {
            return (LoadPolicy) r27.a.a(LoadPolicy.class, r100);
        }

        public LoadPolicy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface QuickAppHandler {

        public static final enum QuickAppAction extends Enum<QuickAppAction> {
            public static final QuickAppAction QUICK_APP_ACTION_CANCEL = null;
            public static final QuickAppAction QUICK_APP_ACTION_COMPLAIN = null;
            public static final QuickAppAction QUICK_APP_ACTION_PROCEED = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ QuickAppAction[] f265028a = null;
            private final int value;

            static {
                QuickAppAction r100 = new QuickAppAction("QUICK_APP_ACTION_PROCEED", 0, 0);
                QUICK_APP_ACTION_PROCEED = r100;
                QuickAppAction r101 = new QuickAppAction("QUICK_APP_ACTION_CANCEL", 1, 1);
                QUICK_APP_ACTION_CANCEL = r101;
                QuickAppAction r102 = new QuickAppAction("QUICK_APP_ACTION_COMPLAIN", 2, 2);
                QUICK_APP_ACTION_COMPLAIN = r102;
                f265028a = new QuickAppAction[]{r100, r101, r102};
            }

            public static QuickAppAction[] values() {
                return (QuickAppAction[]) f265028a.clone();
            }

            public static QuickAppAction valueOf(String r100) {
                return (QuickAppAction) r27.a.a(QuickAppAction.class, r100);
            }

            public QuickAppAction(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }
    }

    public static final enum SafeBrowsingStyle extends Enum<SafeBrowsingStyle> {
        public static final SafeBrowsingStyle SAFE_BROWSING_DCAR = null;
        public static final SafeBrowsingStyle SAFE_BROWSING_DEFAULT = null;
        public static final SafeBrowsingStyle SAFE_BROWSING_DOUYIN_DARK = null;
        public static final SafeBrowsingStyle SAFE_BROWSING_DOUYIN_LIGHT = null;
        public static final SafeBrowsingStyle SAFE_BROWSING_NONE = null;
        public static final SafeBrowsingStyle SAFE_BROWSING_SECLINK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SafeBrowsingStyle[] f265029a = null;
        private final int value;

        static {
            SafeBrowsingStyle r100 = new SafeBrowsingStyle("SAFE_BROWSING_NONE", 0, 0);
            SAFE_BROWSING_NONE = r100;
            SafeBrowsingStyle r101 = new SafeBrowsingStyle("SAFE_BROWSING_DEFAULT", 1, 1);
            SAFE_BROWSING_DEFAULT = r101;
            SafeBrowsingStyle r102 = new SafeBrowsingStyle("SAFE_BROWSING_DOUYIN_LIGHT", 2, 2);
            SAFE_BROWSING_DOUYIN_LIGHT = r102;
            SafeBrowsingStyle r103 = new SafeBrowsingStyle("SAFE_BROWSING_DOUYIN_DARK", 3, 3);
            SAFE_BROWSING_DOUYIN_DARK = r103;
            SafeBrowsingStyle r104 = new SafeBrowsingStyle("SAFE_BROWSING_SECLINK", 4, 4);
            SAFE_BROWSING_SECLINK = r104;
            SafeBrowsingStyle r105 = new SafeBrowsingStyle("SAFE_BROWSING_DCAR", 5, 5);
            SAFE_BROWSING_DCAR = r105;
            f265029a = new SafeBrowsingStyle[]{r100, r101, r102, r103, r104, r105};
        }

        public static SafeBrowsingStyle[] values() {
            return (SafeBrowsingStyle[]) f265029a.clone();
        }

        public static int access$000(SafeBrowsingStyle r100) {
            return r100.value;
        }

        public static SafeBrowsingStyle access$100(int r100) {
            SafeBrowsingStyle r101 = SAFE_BROWSING_DEFAULT;
            if (r100 == r101.value) goto L19;
            SafeBrowsingStyle r102 = SAFE_BROWSING_DOUYIN_LIGHT;
            if (r100 == r102.value) goto L20;
            SafeBrowsingStyle r103 = SAFE_BROWSING_DOUYIN_DARK;
            if (r100 == r103.value) goto L21;
            SafeBrowsingStyle r104 = SAFE_BROWSING_SECLINK;
            if (r100 == r104.value) goto L22;
            SafeBrowsingStyle r105 = SAFE_BROWSING_DCAR;
            if (r100 != r105.value) goto L18;
            return r105;
        L18:
            return SAFE_BROWSING_NONE;
        L22:
            return r104;
        L21:
            return r103;
        L20:
            return r102;
        L19:
            return r101;
        }

        public static SafeBrowsingStyle valueOf(String r100) {
            return (SafeBrowsingStyle) r27.a.a(SafeBrowsingStyle.class, r100);
        }

        public SafeBrowsingStyle(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ScheduleTaskType extends Enum<ScheduleTaskType> {
        public static final ScheduleTaskType DexCompile = null;
        public static final ScheduleTaskType Download = null;
        public static final ScheduleTaskType PreInit = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScheduleTaskType[] f265030a = null;

        static {
            ScheduleTaskType r100 = new ScheduleTaskType("Download", 0);
            Download = r100;
            ScheduleTaskType r101 = new ScheduleTaskType("DexCompile", 1);
            DexCompile = r101;
            ScheduleTaskType r102 = new ScheduleTaskType("PreInit", 2);
            PreInit = r102;
            f265030a = new ScheduleTaskType[]{r100, r101, r102};
        }

        public static ScheduleTaskType[] values() {
            return (ScheduleTaskType[]) f265030a.clone();
        }

        public static ScheduleTaskType valueOf(String r100) {
            return (ScheduleTaskType) r27.a.a(ScheduleTaskType.class, r100);
        }

        public ScheduleTaskType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TaskType extends Enum<TaskType> {
        public static final TaskType Background = null;
        public static final TaskType HandlerThread = null;
        public static final TaskType IO = null;
        public static final TaskType Normal = null;
        public static final TaskType Single = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TaskType[] f265031a = null;

        static {
            TaskType r100 = new TaskType("Normal", 0);
            Normal = r100;
            TaskType r101 = new TaskType("IO", 1);
            IO = r101;
            TaskType r102 = new TaskType("Background", 2);
            Background = r102;
            TaskType r103 = new TaskType("Single", 3);
            Single = r103;
            TaskType r104 = new TaskType("HandlerThread", 4);
            HandlerThread = r104;
            f265031a = new TaskType[]{r100, r101, r102, r103, r104};
        }

        public static TaskType[] values() {
            return (TaskType[]) f265031a.clone();
        }

        public static TaskType valueOf(String r100) {
            return (TaskType) r27.a.a(TaskType.class, r100);
        }

        public TaskType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f265032a;

        public final void a() {
            if (TTWebContext.r() == true) goto L5;
        L19:
            this.f265032a.onReceiveValue(Boolean.FALSE);
            return;
        L5:
            if (com.bytedance.lynx.webview.internal.e.f265296c.get() == true) goto L19;
            r.d("[Interface] call TTWebSdk clearStorage");
            File[] r100 = TTWebContext.h().getContext().getFilesDir().getParentFile().listFiles();
            int r101 = r100.length;
            int r102 = 0;
            boolean r103 = false;
        L8:
            if (r102 >= r101) goto L17;
            File r104 = r100[r102];
            if (r104.getName().equals("app_webview") == false) goto L12;
        L15:
            r103 = true;
            l17.k.d(new String[]{"TTWebSDK.clearStorage directory " + r104.getAbsolutePath()});
            l17.g.b(r104, false);
        L16:
            r102 = r102 + 1;
            goto L8
        L12:
            if (r104.getName().startsWith("app_webview_") == true) goto L15;
            if (r104.getName().equals("org.chromium.android_webview") == false) goto L16;
        L17:
            this.f265032a.onReceiveValue(Boolean.valueOf(r103));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ValueCallback r100) {
            this.f265032a = r100;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
    }

    public static class h {
        public h() {
        }

        public void a() {
            throw null;
        }
    }

    public interface i {
    }

    public interface j {
        void onEvent(JSONObject r100);
    }

    public interface k {
    }

    public TTWebSdk() {
    }

    public static void disableHookDirectly() {
        TTWebContext.f265201J = false;
    }

    public static void enableFetchLynxSettings(boolean r100) {
    }

    public static boolean isSoSupportHotReload() {
        return false;
    }

    public static boolean isSupportReader() {
        return false;
    }

    public static void setNQEListener(t r100) {
    }

    static {
        isWebsdkInit = new AtomicBoolean(false);
    }

    public static void cancelAllPreload() {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r100 = TTWebContext.h();
        r100.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"cancelAllPreload: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r100.f265216b.f265149l.cancelAllPreload();
        return;
    }

    public static void clearAllPreloadCache() {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r100 = TTWebContext.h();
        r100.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"clearAllPreloadCache: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r100.f265216b.f265149l.clearAllPreloadCache();
        return;
    }

    public static void clearCustomedHeaders() {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r100 = TTWebContext.h();
        r100.getClass();
        if (TTWebContext.f() == false) goto L10;
        r100.f265216b.f265149l.setCustomedHeaders(null);
        return;
    L10:
        return;
    }

    public static void clearPrerenderQueue() {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r100 = TTWebContext.h();
        r100.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"clearPrerenderQueue: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r100.f265216b.f265149l.clearPrerenderQueue();
        return;
    }

    public static PrerenderManager createPrerenderManager() {
        if (isWebsdkInit.get() == false) goto L8;
        TTWebContext r100 = TTWebContext.h();
        r100.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"createPrerenderManager: native library hasn't been loaded yet, early return."});
        goto L8
    L7:
        r100.f265216b.getClass();
        return new i17.a();
    L8:
        return null;
    }

    public static void disableInitCrash() {
        AtomicInteger r100 = TTWebContext.f265202n;
        LibraryLoader.f265136w = false;
    }

    public static String getFailInfo() {
        JSONObject r100 = new JSONObject();
        r100.put("error_code", TTWebContext.j().f265229b);     // Catch: Exception -> L10
        int r101 = TTWebContext.j().f265229b;     // Catch: Exception -> L10
        if (r101 != 0) goto L6;
        String r102 = "success";
    L7:
        r100.put("error_message", r102);     // Catch: Exception -> L10
        goto L9
    L6:
        r102 = FailMessage.getMessage(r101);     // Catch: Exception -> L10
    L9:
        return r100.toString();
    }

    public static String getLoadSoVersionCode() {
        if (isWebsdkInit.get() == false) goto L6;
        TTWebContext.h().getClass();
        return TTWebContext.l(false);
    L6:
        return "0620010001";
    }

    public static String getLocalSoVersionCode() {
        if (isWebsdkInit.get() == true) goto L5;
        return "0620010001";
    L5:
        return TTWebContext.h().n(false);
    }

    public static SafeBrowsingStyle getSccSafeBrowsingStyle() {
        if (isWebsdkInit.get() == false) goto L9;
        i17.b r100 = TTWebContext.h().f265216b.f265149l;
        if (r100 == null) goto L9;
        return SafeBrowsingStyle.access$100(r100.getSccSafeBrowsingStyle());
    L9:
        return SafeBrowsingStyle.SAFE_BROWSING_NONE;
    }

    public static String getTTCookieDirectory() {
        if (isWebsdkInit.get() == false) goto L12;
        i17.b r100 = TTWebContext.h().f265216b.f265149l;
        if (r100 == null) goto L14;
        String r101 = r100.getTTCookiePath();
        if (r101 != null) goto L9;
        return "";
    L9:
        if (r101.isEmpty() == false) goto L11;
        return "";
    L11:
        return r101.concat("/Cookies");
    L14:
        return "";
    L12:
        return "";
    }

    public static int getTTNetNativeInitErrorCode() {
        if (isWebsdkInit.get() == false) goto L8;
        i17.b r100 = TTWebContext.h().f265216b.f265149l;
        if (r100 != null) goto L7;
        return -100;
    L7:
        return r100.getTTNetNativeInitErrorCode();
    L8:
        return -100;
    }

    public static String getUserAgentString() {
        if (isWebsdkInit.get() == false) goto L8;
        TTWebContext r100 = TTWebContext.h();
        r100.getClass();
        if (TTWebContext.f() == true) goto L10;
        l17.k.d(new String[]{"getUserAgentString: native library hasn't been loaded yet, early return."});
        goto L8
    L10:
        return r100.f265216b.f265149l.getUserAgentString();
    L8:
        return "";
    }

    public static void invokeTTWebViewDebugActivity() {
        Intent r100 = new Intent(TTWebContext.h().getContext(), TTWebSDKDebug.class);
        r100.setFlags(268435456);
        r100.putExtra("forDebug", true);
        TTWebContext.h().getContext().startActivity(r100);
    }

    public static boolean isAdblockEnable() {
        if (isWebsdkInit.get() == false) goto L10;
        TTWebContext.h().f265221g.getClass();
        TTAdblockContext.b();
        if (TTAdblockContext.d() == false) goto L9;
        ISdkToGlue r100 = a1.a();
        if (r100 == null) goto L10;
        boolean r101 = ((i17.b) r100).isAdblockEnable();
    L11:
        l17.k.d(new String[]{"call TTWebSdk isAdblockEnable  enable = " + r101});
        return r101;
    L9:
        r101 = TTAdblockClient.b.f265047a.e();
    L10:
        r101 = false;
        goto L11
    }

    public static boolean isSccEnable() {
        if (com.bytedance.lynx.webview.cloudservice.d.f265093b.get() == true) goto L6;
        return false;
    L6:
        return Setting.c().b("scc_cs_enable", false);
    }

    public static boolean isSettingSupportHotReload() {
        if (isWebsdkInit.get() == true) goto L6;
        return false;
    L6:
        return Setting.c().b("sdk_enable_hot_reload_ttwebview", false);
    }

    public static boolean isWebSdkInit() {
        return isWebsdkInit.get();
    }

    public static void launchBrowserAndRenderProcessOnUI() {
        if (isWebsdkInit.get() == true) goto L5;
        return;
    L5:
        if (TTWebContext.h().f265216b == null) goto L9;
        TTWebContext.h().f265216b.i(TTWebContext.h().getContext(), true);
        return;
    }

    public static boolean launchRenderProcess() {
        if (isWebsdkInit.get() == false) goto L8;
        i17.b r100 = TTWebContext.h().f265216b.f265149l;
        if (r100 == null) goto L10;
        r.d("[Interface] call TTWebSdk launchRenderProcess");
        return r100.launchRenderProcess();
    L10:
        return false;
    L8:
        return false;
    }

    public static void pausePreload() {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r100 = TTWebContext.h();
        r100.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"pausePreload: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r100.f265216b.f265149l.pausePreload();
        return;
    }

    public static void resetQuickAppHandler() {
        AtomicInteger r100 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        TTWebContext.f265214z = new TTWebContext.g();     // Catch: Throwable -> L7
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void resumePreload() {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r100 = TTWebContext.h();
        r100.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"resumePreload: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r100.f265216b.f265149l.resumePreload();
        return;
    }

    public static boolean tryLoadSysAdblockEngine() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 24) goto L5;
        return false;
    L5:
        String r101 = Build.BRAND;
        if (TextUtils.isEmpty(r101) == false) goto L8;
    L12:
        TTAdblockClient r102 = TTAdblockClient.b.f265047a;
        if (r102.f(null) == true) goto L15;
        return false;
    L15:
        l17.k.d(new String[]{"ensureCreateLoadEngine create adblock engine"});
        r102.f265039e = com.bytedance.lynx.webview.adblock.c.a.f265063a;
        r102.k();
        return true;
    L8:
        if (r101.equalsIgnoreCase(DimLocationCheckUtil.VIVO) == false) goto L12;
        if (r100 > 26) goto L12;
        return false;
    }

    public static boolean allowDownloadOnTheStage() {
        if (Setting.c().d("sdk_set_delay_download_on_the_stage", -1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void downloadIfNeeded() {
        Setting r100 = Setting.c();
        if (r100.f265170a != null) goto L5;
        return;
    L5:
        if (r100.g("sdk_upto_so_md5").equals(Setting.f265164p.c()) == true) goto L9;
        r100.m(0);
        return;
    }

    public static void executeHotReload() {
        if (isWebSdkInit() == false) goto L6;
        com.bytedance.lynx.webview.internal.e.a(TTWebContext.h().getContext());
        return;
    }

    public static int generateV8PortId() {
        return View.generateViewId();
    }

    public static String getDefaultUserAgentWithoutLoadWebView() {
        if (isWebSdkInit() == false) goto L13;
        TTWebContext r100 = TTWebContext.h();
        TTWebProviderWrapper r101 = r100.f265216b.m();
        if (r101 == null) goto L7;
        r101.ensureFactoryProviderCreated();
    L7:
        i17.b r102 = r100.f265216b.f265149l;
        if (r102 == null) goto L13;
        if (LibraryLoader.f265129p.f() == true) goto L13;
        return r102.getDefaultUserAgentWithoutLoadWebView();
    L13:
        return "";
    }

    public static String getLastDeleteReason() {
        return TTWebContext.h().p().f265273b.getString("last_delete_reason", "");
    }

    public static long[] getV8PipeInterfaces() {
        long[] r100 = null;
        if (isWebSdkInit() == true) goto L6;
        l17.k.d(new String[]{"TTWebSdk::getV8PipeInterfaces, web sdk has not init"});
        return null;
    L6:
        TTWebContext r101 = TTWebContext.h();
        if (r101.f265222h.get() == true) goto L9;
        l17.k.d(new String[]{"TTWebContext::getV8PipeInterfaces failed, TTWebView has not initialized native"});
    L10:
        String[] r102 = new String[1];
        StringBuilder r103 = new StringBuilder("TTWebSdk::getV8PipeInterfaces, interfaces.size= ");
        if (r100 != null) goto L13;
        int r104 = 0;
    L14:
        r103.append(r104);
        r102[0] = r103.toString();
        l17.k.d(r102);
        return r100;
    L13:
        r104 = r100.length;
        goto L14
    L9:
        r100 = r101.f265216b.f265149l.getV8PipeInterfaces();
        goto L10
    }

    public static boolean isTTWebView() {
        return TTWebContext.r();
    }

    public static boolean warmupRenderProcess() {
        if (isWebSdkInit() == true) goto L6;
        l17.k.d(new String[]{"TTWebSdk::warmupRenderProcess, web sdk has not init"});
        return false;
    L6:
        TTWebContext r100 = TTWebContext.h();
        if (r100.f265222h.get() == true) goto L10;
        l17.k.d(new String[]{"TTWebContext::warmupRenderProcess failed, TTWebView has not initialized native"});
        return false;
    L10:
        return r100.f265216b.f265149l.warmupRenderProcess();
    }

    public static boolean isActiveDownload() {
        return TTWebContext.f265212x;
    }

    public static String addCustomExtraInterceptConfig(Map<String, String> r100) {
        if (isWebsdkInit.get() == false) goto L8;
        i17.b r101 = TTWebContext.h().f265216b.f265149l;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.addCustomExtraInterceptConfig(r100);
    L8:
        return null;
    }

    public static void addGlobalResourceEventListener(ISdkToGlueSdk113.IGlobalResourceEventListener r100) {
        if (isWebsdkInit.get() == false) goto L8;
        i17.b r101 = TTWebContext.h().f265216b.f265149l;
        if (r101 == null) goto L9;
        r101.addGlobalResourceEventListener(r100);
        return;
    L9:
        return;
    }

    public static void cancelPreload(String r100) {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r101 = TTWebContext.h();
        r101.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"cancelPreload: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r101.f265216b.f265149l.cancelPreload(r100);
        return;
    }

    public static void clearPreloadCache(String r100) {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r101 = TTWebContext.h();
        r101.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"clearPreloadCache: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r101.f265216b.f265149l.clearPreloadCache(r100);
        return;
    }

    public static void clearStorage(ValueCallback<Boolean> r100) {
        TTWebContext.z(new a(r100));
    }

    public static boolean clearTTWebView(Context r100) {
        if (isWebsdkInit.get() == true) goto L11;
        if (TTWebContext.c(r100) != null) goto L7;
        return false;
    L7:
        return TTWebContext.a(DeleteReason.DELETE_BY_CLIENT);
    L11:
        throw new IllegalStateException("clearTTWebView can't be called after init");
    }

    public static void enableLoadSoAfterSdkInit(boolean r100) {
        TTWebContext.f265210v = r100;
    }

    public static void enableSetSettingLocal(boolean r100) {
        TTWebContext.B = r100;
    }

    public static boolean enableTTWebView(String r100) {
        return TTWebContext.b(r100);
    }

    public static void enableTextLongClickMenu(boolean r100) {
        TTWebContext.f265207s = r100;
    }

    public static WebSettings getPrerenderSettings(Context r100) {
        if (isWebsdkInit.get() == false) goto L8;
        TTWebContext r101 = TTWebContext.h();
        r101.getClass();
        if (TTWebContext.f() == true) goto L10;
        l17.k.d(new String[]{"getPrerenderSettings: native library hasn't been loaded yet, early return."});
        goto L8
    L10:
        return r101.f265216b.f265149l.getPrerenderSettings(r100);
    L8:
        return null;
    }

    public static void initTTWebView(Context r100) {
        initTTWebView(r100, null);
    }

    public static boolean isBuiltinTT(WebView r100) {
        if (isTTWebView(r100) == true) goto L5;
        return false;
    L5:
        if (Setting.c().b("sdk_is_builtin", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isDarkModeSupported(WebView r100) {
    L11:
        th = move-exception;
        l17.k.c(th);
    L13:
        boolean r101 = false;
    L15:
        return r101;
    L3:
        if (isWebSdkInit() == true) goto L5;
    L9:
        r101 = com.bytedance.lynx.webview.b.c(WebViewFeature.FORCE_DARK);     // Catch: Throwable -> L11
        goto L15
    L5:
        if (TTWebContext.s(r100) == false) goto L9;
        i17.b r102 = TTWebContext.h().f265216b.f265149l;     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        r101 = r102.isDarkModeSupported();     // Catch: Throwable -> L11
        goto L15
    L18:
        r101 = false;
        goto L15
    }

    public static boolean isDarkStrategySupported(WebView r100) {
    L11:
        th = move-exception;
        l17.k.c(th);
    L13:
        boolean r101 = false;
    L15:
        return r101;
    L3:
        if (isWebSdkInit() == true) goto L5;
    L9:
        r101 = com.bytedance.lynx.webview.b.c(WebViewFeature.FORCE_DARK_STRATEGY);     // Catch: Throwable -> L11
        goto L15
    L5:
        if (TTWebContext.s(r100) == false) goto L9;
        i17.b r102 = TTWebContext.h().f265216b.f265149l;     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        r101 = r102.isDarkStrategySupported();     // Catch: Throwable -> L11
        goto L15
    L18:
        r101 = false;
        goto L15
    }

    public static boolean isPrerenderExist(String r100) {
        if (isWebsdkInit.get() == false) goto L8;
        TTWebContext r101 = TTWebContext.h();
        r101.getClass();
        if (TTWebContext.f() == true) goto L10;
        l17.k.d(new String[]{"isPrerenderExist: native library hasn't been loaded yet, early return."});
        goto L8
    L10:
        return r101.f265216b.f265149l.isPrerenderExist(r100);
    L8:
        return false;
    }

    public static boolean isTTWebView(WebView r100) {
        return TTWebContext.s(r100);
    }

    public static boolean isWebViewSupportInterceptor(WebView r100) {
        if (isTTWebView(r100) == true) goto L14;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 26) goto L7;
    L9:
        if (r101 < 26) goto L16;
        return false;
    L16:
        Field r102 = WebView.class.getDeclaredField("mProvider");     // Catch: Throwable -> L15
        r102.setAccessible(true);     // Catch: Throwable -> L15
        return ((WebViewProvider) r102.get(r100)) instanceof WebViewProviderProxy.RealGetter;
    L18:
        return false;
    L7:
        if ((r100.getWebViewClient() instanceof c1) == false) goto L9;
    L14:
        return true;
    }

    public static boolean needInitIndependent(Context r100) {
        String r101 = n.b(r100);
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L18;
        String r103 = n.b(r100);
        if (r103 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == true) goto L18;
        return false;
    L12:
        if (r103.contains("privileged_process") == false) goto L14;
        r104 = true;
    L18:
        return true;
    L5:
        if (r101.contains("sandboxed_process") == false) goto L7;
        r102 = true;
        goto L8
    }

    public static void onCallMS(String r100) {
        TTWebContext r101 = TTWebContext.h();
        r101.getClass();
        if (TTWebContext.f() == false) goto L7;
        r101.f265216b.f265149l.onCallMS(r100);
        return;
    }

    public static void preresolveHosts(String[] r100) {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r101 = TTWebContext.h();
        r101.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"preresolveHosts: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r101.f265216b.f265149l.preresolveHosts(r100);
        return;
    }

    public static void registerGlobalWebViewHandler(InvocationHandler r100) {
        if (r100 == null) goto L6;
        ConcurrentLinkedQueue r101 = (ConcurrentLinkedQueue) s.f265360a;
        if (r101.contains(r100) == true) goto L8;
        r101.add(r100);
        return;
    L8:
        return;
    L6:
        Queue<InvocationHandler> r102 = s.f265360a;
    }

    public static void removeGlobalResourceEventListener(ISdkToGlueSdk113.IGlobalResourceEventListener r100) {
        if (isWebsdkInit.get() == false) goto L8;
        i17.b r101 = TTWebContext.h().f265216b.f265149l;
        if (r101 == null) goto L9;
        r101.removeGlobalResourceEventListener(r100);
        return;
    L9:
        return;
    }

    public static void removePrerender(String r100) {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r101 = TTWebContext.h();
        r101.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"removePrerender: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r101.f265216b.f265149l.removePrerender(r100);
        return;
    }

    public static void resetWebViewContext(Context r100) {
        if (TTWebContext.f() == true) goto L6;
        l17.k.b(new String[]{"tt_webview", "Do not call it before TTWebView init."});
        return;
    L6:
        monitor-enter(TTWebContext.class);
        TTWebContext.h().f265216b.getClass();     // Catch: Throwable -> L10
        LibraryLoader.j(r100);     // Catch: Throwable -> L10
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void setAdblockEventListener(b r100) {
        if (isWebsdkInit.get() == false) goto L6;
        TTWebContext.h().f265221g.getClass();
        return;
    }

    public static void setAppHandler(c r100) {
        AtomicInteger r101 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void setAppInfoGetter(com.bytedance.lynx.webview.internal.a r100) {
        r.d("[Interface] call TTWebSdk setAppInfoGetter");
        AtomicInteger r101 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        TTWebContext.f265208t = r100;     // Catch: Throwable -> L7
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setCodeCacheSize(int r100) {
        TTWebContext.F = r100;
    }

    public static void setConnectionGetter(d r100) {
        AtomicInteger r101 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void setControlSettings(boolean r100) {
        l17.k.d(new String[]{"call TTWebSdk setControlSettings = " + r100});
        TTWebContext.I = r100;
    }

    public static boolean setCustomedHeaders(Map<String, String> r100) {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r101 = TTWebContext.h();
        r101.getClass();
        if (TTWebContext.f() == true) goto L8;
        return false;
    L8:
        return r101.f265216b.f265149l.setCustomedHeaders(r100);
    L9:
        return false;
    }

    public static void setDebug(boolean r100) {
        l17.k.d(new String[]{"call TTWebSdk setDebug = " + r100});
        r.d("[Interface] setDebug :" + r100);
        l17.d.f506995a = r100;
    }

    public static void setDelayedTimeForSetting(int r100) {
        TTWebContext.f265211w = r100;
    }

    public static void setDifferedSettingsUploadHandler(e r100) {
        AtomicInteger r101 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void setDownloadHandler(f r100) {
        AtomicInteger r101 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void setDualWebViewTypeEnable(boolean r100) {
        AtomicInteger r101 = TTWebContext.f265202n;
    }

    public static void setHostAbi(String r100) {
        AtomicInteger r101 = TTWebContext.f265202n;
        if (Arrays.asList(new String[]{BDLocationException.ERROR_CONNECT_GOOGLE_FAIL, BDLocationException.ERROR_RESTRICTED_MODE_ON}).contains(r100) == false) goto L7;
        TTWebContext.C = r100;
        return;
    L7:
        throw new IllegalArgumentException("wrong hostabibit !");
    }

    public static void setHttpCacheSize(int r100) {
        TTWebContext.E = r100;
    }

    public static void setLoadPolicy(LoadPolicy r100) {
        r.d("[Builtin] call TTWebSdk setLoadPolicy = " + r100);
        TTWebContext.A = r100;
    }

    public static void setMiniAppLastLaunchTime(long r100) {
        TTWebContext.O = r100;
    }

    public static void setNetworkInfoGetter(u r100) {
        l17.k.d(new String[]{"call TTWebSdk setNetworkInfoGetter"});
        AtomicInteger r101 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void setPackageLoadedChecker(w r100) {
        AtomicInteger r101 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void setPrivacyComplianceCallback(i r100) {
        r.d("[Interface] call TTWebSdk setPrivacyComplianceCallback");
        AtomicInteger r101 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void setQuickAppHandler(QuickAppHandler r100) {
        AtomicInteger r101 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        TTWebContext.f265214z = r100;     // Catch: Throwable -> L7
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setRenderProcessStatus(boolean r100) {
        if (isWebsdkInit.get() == false) goto L6;
        l17.k.d(new String[]{"call TTWebSdk setRenderProcessStatus = " + r100});
        TTWebContext.h().getClass();
        r.d("Call setRenderProcessStatus: " + r100);
        com.bytedance.lynx.webview.internal.g.e().f265306d = r100 ? 1 : 0;
        return;
    }

    public static void setRunningProcessName(String r100) {
        AtomicInteger r101 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void setSccCloudServiceSceneID(long r100) {
        if (isWebsdkInit.get() == false) goto L6;
        TTWebContext.h();
        TTWebContext.K = r100;
        return;
    }

    public static void setSccEnable(boolean r100) {
        com.bytedance.lynx.webview.cloudservice.d.f265093b.set(r100);
        if (isWebsdkInit.get() == true) goto L5;
        return;
    L5:
        LibraryLoader r101 = TTWebContext.h().f265216b;
        if (r101.m() == null) goto L12;
        i17.b r102 = r101.f265149l;
        if (r102 != null) goto L10;
        return;
    L10:
        r102.onSetSccEnable(r100);
        return;
    L12:
        r.c("[Interface] Please call the interface after the TTWebView was loaded.", new Exception());
        throw new RuntimeException("Please call the interface after the TTWebView was loaded.");
    }

    public static boolean setSccEventListener(com.bytedance.lynx.webview.cloudservice.a r100) {
        com.bytedance.lynx.webview.cloudservice.a r101 = com.bytedance.lynx.webview.cloudservice.d.f265092a;
        monitor-enter(com.bytedance.lynx.webview.cloudservice.d.class);
        com.bytedance.lynx.webview.cloudservice.d.f265092a = r100;     // Catch: Throwable -> L8
        monitor-exit(com.bytedance.lynx.webview.cloudservice.d.class);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    public static void setSccWhitelistChecker(com.bytedance.lynx.webview.cloudservice.b r100) {
        com.bytedance.lynx.webview.cloudservice.a r101 = com.bytedance.lynx.webview.cloudservice.d.f265092a;
        monitor-enter(com.bytedance.lynx.webview.cloudservice.d.class);
        monitor-exit(com.bytedance.lynx.webview.cloudservice.d.class);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void setSettingByValue(String r100) {
        TTWebContext r101 = TTWebContext.h();
        if (n.d(r101.getContext()) == false) goto L5;
    L7:
        r.d("[Settings] setSettingByValue " + r100);
        r101.f265225k = r100;
        Setting r102 = Setting.c();
        r102.getClass();
        if (r100 != null) goto L10;
        return;
    L10:
        if (r100.isEmpty() == true) goto L26;
        r102.o(null);
        com.bytedance.lynx.webview.internal.g.e().g(r100);
        com.bytedance.lynx.webview.internal.g.c r103 = com.bytedance.lynx.webview.internal.g.e().f265304b;
        if (r103 == null) goto L21;
        Set<com.bytedance.lynx.webview.internal.g.b> r104 = r103.f265317a;
        monitor-enter(r104);
        ((HashSet) r103.f265317a).clear();     // Catch: Throwable -> L18
        monitor-exit(r104);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L21:
        TTWebContext.C(new f0());
        return;
    L26:
        return;
    L5:
        if (TTWebContext.B == true) goto L7;
    }

    public static void setSettingsOrigin(String r100) {
        r.d("[Interface] call TTWebSdk setSettingsOrigin:" + r100);
        com.bytedance.lynx.webview.internal.g.f265302j = r100;
        if (TTWebContext.h().p().f265273b.getBoolean("should_override_origin_setting_for_debug", false) == false) goto L8;
        c0 r101 = TTWebContext.h().p();
        if (r101.f265273b.getBoolean("should_override_origin_setting_for_debug", false) == false) goto L9;
        r101.f265273b.edit().putString("override_origin_setting_for_debug", r100).apply();
        return;
    L9:
        return;
    }

    public static void setSettingsRequestActive(boolean r100) {
        r.d("[Interface] call TTWebSdk#setSettingsRequestActive. flag:" + r100);
        TTWebContext.P.set(r100);
    }

    public static void setUseTTWebView(boolean r100) {
        r.d("[Interface] call TTWebSdk setUseTTWebView " + r100);
        TTWebContext.h().p().l(r100, "Call by TTWebSdk");
    }

    public static boolean setWebViewProviderProxyListener(k r100) {
        if (isWebsdkInit.get() == false) goto L6;
        TTWebContext.h().getClass();
        return true;
    L6:
        return false;
    }

    public static void trimMemory(int r100) {
        if (isWebSdkInit() == true) goto L6;
        l17.k.d(new String[]{"TTWebSdk::trimMemory, web sdk has not init"});
        return;
    L6:
        TTWebContext r101 = TTWebContext.h();
        if (r101.f265222h.get() == true) goto L9;
        l17.k.d(new String[]{"TTWebContext::trimMemory failed, TTWebView has not initialized native"});
        return;
    L9:
        r101.f265216b.f265149l.trimMemory(r100);
    }

    public static void tryLoadTTwebviewOnce(boolean r100) {
        r.d("call TTWebSdk tryLoadTTwebviewOnce = " + r100);
        if (n.d(TTWebContext.h().getContext()) == false) goto L9;
        if (r100 == false) goto L6;
        TTWebContext.f265202n.incrementAndGet();
    L6:
        TTWebContext.h().q().post(new t0());
        return;
    L9:
        throw new RuntimeException("TTWebView Setting must be pulled in main process");
    }

    public static void unregisterPiaManifest(String r100) {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r101 = TTWebContext.h();
        r101.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"unregisterPiaManifest: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r101.f265216b.f265149l.unregisterPiaManifest(r100);
        return;
    }

    public static boolean enableFeature(String r100, boolean r101) {
        if (isWebsdkInit.get() == false) goto L8;
        i17.b r102 = TTWebContext.h().f265216b.f265149l;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.enableFeature(r100, r101);
    L8:
        return false;
    }

    public static void initTTWebView(Context r100, h r101) {
        initTTWebView(r100, r101, false);
    }

    public static boolean isFeatureSupport(String r100, int r101) {
        if (isWebsdkInit.get() == false) goto L8;
        i17.b r102 = TTWebContext.h().f265216b.f265149l;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.isFeatureSupport(r100, r101);
    L8:
        return false;
    }

    public static void onDownloadProgress(long r100, long r101) {
        TTWebContext.j().c(r100, r101);
    }

    public static void preconnectUrl(String r100, int r101) {
        if (isWebsdkInit.get() == false) goto L11;
        TTWebContext r102 = TTWebContext.h();
        r102.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"preconnectUrl: native library hasn't been loaded yet, early return."});
        return;
    L7:
        i17.b r103 = r102.f265216b.f265149l;
        if (r103 == null) goto L13;
        r103.preconnectUrl(r100, r101);
        return;
    L13:
        return;
    }

    public static void pullSettings(boolean r100, g r101) {
        pullSettings(r100, "", r101, false, 0);
    }

    public static void registerPiaManifest(String r100, String r101) {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r102 = TTWebContext.h();
        r102.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"registerPiaManifest: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r102.f265216b.f265149l.registerPiaManifest(r100, r101);
        return;
    }

    public static void registerSpecificEventListener(String r100, j r101) {
        TTWebContext r102 = TTWebContext.h();
        monitor-enter(r102);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((HashMap) r102.f265227m).containsKey(r100) == false) goto L7;
        ((List) ((HashMap) r102.f265227m).get(r100)).add(r101);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r102);
        return;
    L7:
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L10
        r103.add(r101);     // Catch: Throwable -> L10
        ((HashMap) r102.f265227m).put(r100, r103);     // Catch: Throwable -> L10
        goto L8
    }

    public static boolean setAdblockDesializeFile(String r100, String r101) {
        l17.k.d(new String[]{"call TTWebSdk setAdblockDesializeFile  path = " + r100 + " md5 = " + r101});
        if (isWebsdkInit.get() == false) goto L8;
        TTWebContext.h().f265221g.getClass();
        TTAdblockContext.b();
        ISdkToGlue r102 = a1.a();
        if (r102 != null) goto L7;
        return false;
    L7:
        return ((i17.b) r102).setAdblockDeserializeFile(r100, r101);
    L8:
        return false;
    }

    public static boolean setAdblockEnable(boolean r100, ValueCallback<Boolean> r101) {
        boolean r102 = false;
        l17.k.d(new String[]{"call TTWebSdk setAdblockEnable  enable = " + r100});
        if (isWebsdkInit.get() == false) goto L19;
        TTWebContext.h().f265221g.getClass();
        TTAdblockContext.b();
        if (TTAdblockContext.d() == false) goto L11;
        ISdkToGlue r103 = a1.a();
        if (r103 == null) goto L9;
        r102 = ((i17.b) r103).setAdblockEnable(r100);
    L9:
        if (r101 == null) goto L17;
        r101.onReceiveValue(Boolean.valueOf(r102));
    L17:
        TTWebContext.h().p().f265273b.edit().putBoolean("host_adblock_enable", r100).apply();
        return true;
    L11:
        TTAdblockClient r104 = TTAdblockClient.b.f265047a;
        r104.f265035a.set(r100);
        EventStatistics.a("scc_adblock_status", "update_enable");
        EventStatistics.a("scc_adblock_enable", Boolean.valueOf(r100));
        if (r101 == null) goto L17;
        if (r104.f265039e == null) goto L16;
        r101.onReceiveValue(Boolean.valueOf(r104.e()));
        goto L17
    L16:
        r104.f265041g.set(r101);
        TTWebContext.w(new com.bytedance.lynx.webview.adblock.a(r104), 300000);
        goto L17
    L19:
        if (r101 == null) goto L21;
        r101.onReceiveValue(Boolean.FALSE);
    L21:
        return false;
    }

    public static boolean setAdblockRulesPath(String[] r100, String[] r101) {
        l17.k.d(new String[]{"call TTWebSdk setAdblockRulesPath  path = " + Arrays.toString(r100) + " md5 = " + Arrays.toString(r101)});
        if (isWebsdkInit.get() == false) goto L8;
        TTWebContext.h().f265221g.getClass();
        TTAdblockContext.b();
        ISdkToGlue r102 = a1.a();
        if (r102 != null) goto L7;
        return false;
    L7:
        return ((i17.b) r102).setAdblockRulesPath(r100, r101);
    L8:
        return false;
    }

    public static void setBoeBlockList(String r100, String r101) {
        TTWebContext.G = r100;
        TTWebContext.H = r101;
    }

    public static void setForceDark(WebSettings r100, int r101) {
    L14:
        th = move-exception;
        l17.k.c(th);
        return;
    L3:
        if (r100.getClass().getName().startsWith("com.bytedance") == true) goto L6;
    L17:
        return;
    L6:
        if (isWebSdkInit() == false) goto L12;
        i17.b r102 = TTWebContext.h().f265216b.f265149l;     // Catch: Throwable -> L14
        if (r102 == null) goto L17;
        if (r102.isDarkModeSupported() == false) goto L17;
        r102.setForceDark(r100, r101);     // Catch: Throwable -> L14
        goto L17
    L12:
        com.bytedance.lynx.webview.b.b(r100, r101);     // Catch: Throwable -> L14
        goto L17
    }

    public static void setForceDarkStrategy(WebSettings r100, int r101) {
    L14:
        th = move-exception;
        l17.k.c(th);
        return;
    L3:
        if (r100.getClass().getName().startsWith("com.bytedance") == true) goto L6;
    L17:
        return;
    L6:
        if (isWebSdkInit() == false) goto L12;
        i17.b r102 = TTWebContext.h().f265216b.f265149l;     // Catch: Throwable -> L14
        if (r102 == null) goto L17;
        if (r102.isDarkStrategySupported() == false) goto L17;
        r102.setForceDarkStrategy(r100, r101);     // Catch: Throwable -> L14
        goto L17
    L12:
        com.bytedance.lynx.webview.b.d(r100, r101);     // Catch: Throwable -> L14
        goto L17
    }

    public static void setIsolateDirectorySuffix(Context r100, String r101) {
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        if (TTWebContext.f265205q.get() == false) goto L8;
        l17.k.b(new String[]{"tt_webview", "Set data suffix should be called before native init"});
        return;
    L8:
        monitor-enter(TTWebContext.class);
        TTWebContext.f265206r = r101;     // Catch: Throwable -> L12
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void setPreconnectUrl(String r100, int r101) {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r102 = TTWebContext.h();
        r102.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"setPreconnectUrl: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r102.f265216b.f265149l.setPreconnectUrl(r100, r101);
        return;
    }

    public static void setSccSafeBrowsingStyle(SafeBrowsingStyle r100, boolean r101) {
        if (isWebsdkInit.get() == false) goto L11;
        LibraryLoader r102 = TTWebContext.h().f265216b;
        if (r102.m() == null) goto L9;
        i17.b r103 = r102.f265149l;
        if (r103 == null) goto L12;
        r103.setSccSafeBrowsingStyle(SafeBrowsingStyle.access$000(r100), r101);
        return;
    L12:
        return;
    L9:
        r.c("[Interface] Please call the interface after the TTWebView was loaded.", new Exception());
        throw new RuntimeException("Please call the interface after the TTWebView was loaded.");
    }

    public static void unRegisterSpecificEventListener(String r100, j r101) {
        TTWebContext r102 = TTWebContext.h();
        monitor-enter(r102);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (((HashMap) r102.f265227m).containsKey(r100) == false) goto L9;
        ((List) ((HashMap) r102.f265227m).get(r100)).remove(r101);     // Catch: Throwable -> L11
        if (((List) ((HashMap) r102.f265227m).get(r100)).size() != 0) goto L9;
        ((HashMap) r102.f265227m).remove(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r102);
    }

    public static void initTTWebView(Context r100, h r101, boolean r102) {
        if (r.f265356b == null) goto L15;
        r.d("[Load] Call TTWebSdk.initTTWebView(). process_name:" + n.b(r100));
        if (isWebsdkInit.compareAndSet(false, true) == false) goto L13;
        Trace.beginSection("TTWebSdk.initTTWebView");     // Catch: Throwable -> L9
        i0.f(n.d(r100));     // Catch: Throwable -> L9
        TTWebContext.c(r100).E(r101);     // Catch: Throwable -> L9
        i0.e();
        Trace.endSection();
        return;
    L9:
        th = move-exception;
        i0.e();
        Trace.endSection();
        throw th;
    L13:
        throw new IllegalStateException("initTTWebView can't be called more than once!");
    L15:
        throw new RuntimeException("We should call TTWebDataCenter.registerLogExCallback() before TTWebSdk.initTTWebView()!");
    }

    public static boolean preloadResource(String r100, byte[] r101, String r102) {
        if (isWebsdkInit.get() == true) goto L5;
        return false;
    L5:
        if (TTWebContext.h().f265216b == null) goto L12;
        i17.b r103 = TTWebContext.h().f265216b.f265149l;
        if (r103 != null) goto L9;
        return false;
    L9:
        return r103.preloadResource(r100, r101, r102);
    L12:
        return false;
    }

    public static void pullSettings(boolean r100, String r101, g r102) {
        pullSettings(r100, r101, r102, false, 0);
    }

    public static void requestDiskCache(String r100, String r101, ISdkToGlueSdk113.RequestDiskCacheCallback r102) {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r103 = TTWebContext.h();
        r103.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"requestDiskCache: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r103.f265216b.f265149l.requestDiskCache(r100, r101, r102);
        return;
    }

    public static void setForceDark(WebSettings r100, int r101, WebView r102) {
    L13:
        th = move-exception;
        l17.k.c(th);
        return;
    L3:
        if (isWebSdkInit() == true) goto L5;
    L11:
        com.bytedance.lynx.webview.b.b(r100, r101);     // Catch: Throwable -> L13
    L16:
        return;
    L5:
        if (TTWebContext.s(r102) == false) goto L11;
        i17.b r103 = TTWebContext.h().f265216b.f265149l;     // Catch: Throwable -> L13
        if (r103 == null) goto L16;
        if (r103.isDarkModeSupported() == false) goto L16;
        r103.setForceDark(r100, r101);     // Catch: Throwable -> L13
        goto L16
    }

    public static void setForceDarkStrategy(WebSettings r100, int r101, WebView r102) {
    L13:
        th = move-exception;
        l17.k.c(th);
        return;
    L3:
        if (isWebSdkInit() == true) goto L5;
    L11:
        com.bytedance.lynx.webview.b.d(r100, r101);     // Catch: Throwable -> L13
    L16:
        return;
    L5:
        if (TTWebContext.s(r102) == false) goto L11;
        i17.b r103 = TTWebContext.h().f265216b.f265149l;     // Catch: Throwable -> L13
        if (r103 == null) goto L16;
        if (r103.isDarkStrategySupported() == false) goto L16;
        r103.setForceDarkStrategy(r100, r101);     // Catch: Throwable -> L13
        goto L16
    }

    public static boolean setRustRulesPath(String[] r100, String[] r101, ValueCallback<Boolean> r102) {
        boolean r103 = false;
        l17.k.d(new String[]{"call TTWebSdk setRustRulesPath  path = " + Arrays.toString(r100) + " md5 = " + Arrays.toString(r101)});
        if (Looper.myLooper() == null) goto L9;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        l17.k.b(new String[]{"TTWebSdk.setRustRulesPath can't be called on UI thread"});
        return false;
    L9:
        if (isWebsdkInit.get() == false) goto L28;
        TTWebContext.h().f265221g.getClass();
        TTAdblockContext.b();
        if (TTAdblockContext.d() == false) goto L17;
        ISdkToGlue r104 = a1.a();
        if (r104 == null) goto L15;
        r103 = ((i17.b) r104).setRustRulesPath(r100, r101);
    L15:
        if (r102 == null) goto L27;
        r102.onReceiveValue(Boolean.valueOf(r103));
    L27:
        return r103;
    L17:
        TTAdblockClient r105 = TTAdblockClient.b.f265047a;
        r105.getClass();
        EventStatistics.a("scc_adblock_status", "update_rule_path");
        if (r105.f265036b.get() == true) goto L22;
        if (r102 == null) goto L27;
        r102.onReceiveValue(Boolean.FALSE);
        goto L27
    L22:
        if (r105.f265039e == null) goto L26;
        r103 = r105.c(r100, r101);
        if (r102 == null) goto L27;
        r102.onReceiveValue(Boolean.valueOf(r103));
        goto L27
    L26:
        r105.f265040f.set(new TTAdblockClient.c(r100, r101, r102));
        goto L27
    L28:
        if (r102 == null) goto L30;
        r102.onReceiveValue(Boolean.FALSE);
    L30:
        return false;
    }

    public static void tryDownloadKernel(boolean r100, LoadListener r101, String r102) {
        if (isWebSdkInit() == true) goto L6;
        r.d("[Interface] call TTWebSdk tryDownloadKernel failed, web sdk has not init");
        return;
    L6:
        r.d("[Interface] call TTWebSdk tryDownloadKernel");
        TTWebContext.f265209u = r102;
        monitor-enter(TTWebContext.class);
        TTWebContext.f265213y.f(r101);     // Catch: Throwable -> L18
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L18
        boolean r103 = true;
        TTWebContext.f265212x = true;
        Setting r104 = Setting.c();
        if (Setting.f265165q == false) goto L13;
        r104.l(0, true);
    L14:
        if (r103 == false) goto L16;
        return;
    L16:
        tryLoadTTwebviewOnce(r100);
        return;
    L13:
        r104.getClass();
        r103 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public static boolean prerenderUrl(String r100, int r101, int r102, WebSettings r103) {
        if (isWebsdkInit.get() == false) goto L8;
        TTWebContext r104 = TTWebContext.h();
        r104.getClass();
        if (TTWebContext.f() == true) goto L10;
        l17.k.d(new String[]{"prerenderUrl: native library hasn't been loaded yet, early return."});
        goto L8
    L10:
        return r104.f265216b.f265149l.prerenderUrl(r100, r101, r102, r103);
    L8:
        return false;
    }

    public static void preloadUrl(String r100, long r101, String r110, String r111, boolean r112) {
        if (isWebsdkInit.get() == false) goto L9;
        TTWebContext r102 = TTWebContext.h();
        r102.getClass();
        if (TTWebContext.f() == true) goto L7;
        l17.k.d(new String[]{"preloadUrl: native library hasn't been loaded yet, early return."});
        return;
    L7:
        r102.f265216b.f265149l.preloadUrl(r100, r101, r110, r111, r112);
        return;
    }

    public static boolean pullSettings(boolean r100, String r101, g r102, boolean r103, long r104) {
        boolean r105 = false;
        if (isWebSdkInit() == true) goto L6;
        r.d("[Interface] call TTWebSdk pullSettings failed, web sdk has not init");
        return false;
    L6:
        final Setting r106 = Setting.c();
        r106.getClass();
        boolean r107 = true;
        if (r100 == true) goto L9;
    L10:
        r105 = true;
    L11:
        if (r105 == true) goto L13;
        r107 = Setting.f265165q;
    L23:
        r.d("[Interface] Call pullSettings. result:" + r107);
        return r107;
    L13:
        if (r103 == false) goto L22;
        r106.n(Setting.RequestSource.PUSH_SYNC);
        r106.f265172c = new g0(r106);
        r106.j();
    L19:
        e = move-exception;
        r.c("[Settings] pullSettings error: ", e);
    L21:
        r107 = Setting.f265165q;
        goto L23
    L16:
        if (r106.f265175f.await(r104, TimeUnit.SECONDS) == true) goto L21;
        r.b("[Settings] OnConfigLoad Timeout! secondDelay: " + r104);     // Catch: InterruptedException -> L19
        goto L21
    L22:
        r106.n(Setting.RequestSource.PUSH_ASYNC);
        TTWebContext.y(new e0(r106), 5000);
        goto L23
    L9:
        if (Setting.f265163o.compareAndSet(false, true) == false) goto L11;
        goto L10
    }
}
