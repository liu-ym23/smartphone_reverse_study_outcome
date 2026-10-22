package com.lynx.devtoolwrapper;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes32.dex */
public class DevToolSettings {
    private static final String CDP_DOMAIN_KEY_PREFIX = "enable_cdp_domain_";
    private static final int MAX_REPORTED_CALLER_FRAMES = 3;
    private static final String SP_KEY_ACTIVATED_CDP_DOMAINS = "activated_cdp_domains";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_CSS = "enable_cdp_domain_css";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_DEBUGGER = "enable_cdp_domain_debugger";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_DOM = "enable_cdp_domain_dom";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_OVERLAY = "enable_cdp_domain_overlay";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_PAGE = "enable_cdp_domain_page";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_RUNTIME = "enable_cdp_domain_runtime";
    public static final String SP_KEY_ENABLE_DEBUG_MODE = "enable_debug_mode";
    public static final String SP_KEY_ENABLE_DEVTOOL = "enable_devtool";
    public static final String SP_KEY_ENABLE_DOM_TREE = "enable_dom_tree";
    public static final String SP_KEY_ENABLE_FSP_SCREENSHOT = "enable_fsp_screenshot";
    public static final String SP_KEY_ENABLE_HIGHLIGHT_TOUCH = "enable_highlight_touch";
    public static final String SP_KEY_ENABLE_LAUNCH_RECORD = "enable_launch_record";
    public static final String SP_KEY_ENABLE_LOGBOX = "enable_logbox";
    public static final String SP_KEY_ENABLE_LONG_PRESS_MENU = "enable_long_press_menu";
    public static final String SP_KEY_ENABLE_PERF_METRICS = "enable_perf_metrics";
    public static final String SP_KEY_ENABLE_PIXEL_COPY = "enable_pixel_copy";
    public static final String SP_KEY_ENABLE_PREVIEW_SCREEN_SHOT = "enable_preview_screen_shot";
    public static final String SP_KEY_ENABLE_QUICKJS_CACHE = "enable_quickjs_cache";
    public static final String SP_KEY_ENABLE_QUICKJS_DEBUG = "enable_quickjs_debug";
    public static final String SP_KEY_ENABLE_V8 = "enable_v8";
    private static final String SP_KEY_IGNORE_ERROR_TYPES = "ignore_error_types";
    private static final String SP_NAME = "lynx_env_config";
    private static final String TAG = "DevToolSettings";
    public static final int V8_ALIGN_WITH_PROD = 2;
    public static final int V8_OFF = 0;
    public static final int V8_ON = 1;
    private static final String VM_STACK_CLASS_NAME = "dalvik.system.VMStack";
    private static volatile DevToolSettings sInstance;
    private final BootstrapSettings mBootstrapSettings;
    private volatile boolean mHighlightTouchEnabled;
    private volatile boolean mPerfMetricsEnabled;
    private volatile boolean mPreviewScreenshotEnabled;
    private SharedPreferences mSharedPreferences;

    /* JADX INFO: renamed from: com.lynx.devtoolwrapper.DevToolSettings$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class BootstrapSettings {
        private volatile Boolean mLoadQJSBridge;
        private volatile Boolean mLoadV8Bridge;
        private volatile Boolean mLogBoxEnabled;
        private volatile Boolean mLynxDebugEnabled;

        private void resetForTesting() {
            this.mLynxDebugEnabled = null;
            this.mLogBoxEnabled = null;
            this.mLoadQJSBridge = null;
            this.mLoadV8Bridge = null;
        }

        public void applyDevelopmentDefaultsIfUnset() {
            if (this.mLynxDebugEnabled != null) goto L6;
            this.mLynxDebugEnabled = Boolean.TRUE;
        L6:
            if (this.mLogBoxEnabled != null) goto L9;
            this.mLogBoxEnabled = Boolean.TRUE;
        L9:
            if (this.mLoadQJSBridge != null) goto L12;
            this.mLoadQJSBridge = Boolean.TRUE;
        L12:
            if (this.mLoadV8Bridge != null) goto L15;
            this.mLoadV8Bridge = Boolean.TRUE;
            return;
        }

        public boolean isLogBoxEnabled() {
            return isEnabled(this.mLogBoxEnabled);
        }

        public boolean isLynxDebugEnabled() {
            return isEnabled(this.mLynxDebugEnabled);
        }

        public boolean shouldLoadQJSBridge() {
            return isEnabled(this.mLoadQJSBridge);
        }

        public boolean shouldLoadV8Bridge() {
            return isEnabled(this.mLoadV8Bridge);
        }

        private BootstrapSettings() {
            this.mLynxDebugEnabled = null;
            this.mLogBoxEnabled = null;
            this.mLoadQJSBridge = null;
            this.mLoadV8Bridge = null;
        }

        public /* synthetic */ BootstrapSettings(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ void access$100(BootstrapSettings r100) {
            r100.resetForTesting();
        }

        private static boolean isEnabled(Boolean r100) {
            if (r100 != null) goto L4;
        L6:
            return false;
        L4:
            if (r100.booleanValue() == false) goto L6;
            return true;
        }

        public void setLoadQJSBridge(boolean r100) {
            this.mLoadQJSBridge = Boolean.valueOf(r100);
        }

        public void setLoadV8Bridge(boolean r100) {
            this.mLoadV8Bridge = Boolean.valueOf(r100);
        }

        public void setLogBoxEnabled(boolean r100) {
            this.mLogBoxEnabled = Boolean.valueOf(r100);
        }

        public void setLynxDebugEnabled(boolean r100) {
            this.mLynxDebugEnabled = Boolean.valueOf(r100);
        }
    }

    public static /* synthetic */ Map a(String r100) {
        return lambda$reportEnableEventIfNeeded$0(r100);
    }

    public static DevToolSettings inst() {
        if (sInstance != null) goto L15;
        monitor-enter(DevToolSettings.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DevToolSettings();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DevToolSettings.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public Set<String> getEnabledCDPDomains() {
        return getPersistedStringSet("activated_cdp_domains");
    }

    public Set<String> getIgnoredErrorTypes() {
        return getPersistedStringSet("ignore_error_types");
    }

    public int getV8Enabled() {
        return getPersistedInt("enable_v8", 2);
    }

    public boolean isDOMTreeEnabled() {
        return getPersistedBoolean("enable_dom_tree", true);
    }

    public boolean isDebugModeEnabled() {
        return getPersistedBoolean("enable_debug_mode", false);
    }

    public boolean isDevToolEnabled() {
        return getPersistedBoolean("enable_devtool", false);
    }

    public boolean isFSPScreenshotEnabled() {
        return getPersistedBoolean("enable_fsp_screenshot", false);
    }

    public boolean isLaunchRecordEnabled() {
        return getPersistedBoolean("enable_launch_record", false);
    }

    public boolean isLogBoxEnabled() {
        return getPersistedBoolean("enable_logbox", true);
    }

    public boolean isLongPressMenuEnabled() {
        return getPersistedBoolean("enable_long_press_menu", false);
    }

    public boolean isPixelCopyEnabled() {
        return getPersistedBoolean("enable_pixel_copy", true);
    }

    public boolean isQuickJSCacheEnabled() {
        return getPersistedBoolean("enable_quickjs_cache", true);
    }

    public boolean isQuickJSDebugEnabled() {
        return getPersistedBoolean("enable_quickjs_debug", true);
    }

    public void resetNonPersistedSettingsForTesting() {
        BootstrapSettings.access$100(this.mBootstrapSettings);
        this.mHighlightTouchEnabled = false;
        this.mPreviewScreenshotEnabled = true;
        this.mPerfMetricsEnabled = false;
    }

    private DevToolSettings() {
        this.mBootstrapSettings = new BootstrapSettings(null);
        this.mHighlightTouchEnabled = false;
        this.mPreviewScreenshotEnabled = true;
        this.mPerfMetricsEnabled = false;
    }

    public boolean isCSSErrorIgnored() {
        return isErrorTypeIgnored(130100);
    }

    public void syncToNative() {
        if (DevToolLifecycle.getInstance().isInitialized() == true) goto L6;
        LLog.e(TAG, "DevTool is not initialized yet, can't sync references to native");
        return;
    L6:
        syncToNativeBoolean("enable_devtool", getPersistedBoolean("enable_devtool", false));
        syncToNativeBoolean("enable_quickjs_cache", getPersistedBoolean("enable_quickjs_cache", true));
        syncToNativeInt("enable_v8", getPersistedInt("enable_v8", 2));
        syncToNativeBoolean("enable_quickjs_debug", getPersistedBoolean("enable_quickjs_debug", true));
        syncToNativeBoolean("enable_dom_tree", getPersistedBoolean("enable_dom_tree", true));
        syncToNativeBoolean("enable_logbox", getPersistedBoolean("enable_logbox", true));
        syncToNativeEnabledCDPDomains(getEnabledCDPDomains());
    }

    public BootstrapSettings bootstrap() {
        return this.mBootstrapSettings;
    }

    public boolean isHighlightTouchEnabled() {
        return this.mHighlightTouchEnabled;
    }

    public boolean isPerfMetricsEnabled() {
        return this.mPerfMetricsEnabled;
    }

    public boolean isPreviewScreenshotEnabled() {
        return this.mPreviewScreenshotEnabled;
    }

    private String getEnableCaller(String r100) {
        String r101 = DevToolSettings.class.getName();
        String r102 = LynxEnv.class.getName();
        return getCallerBacktrace(r101, r100, new String[]{r102}, new String[]{Thread.class.getName(), r101, r102});
    }

    private Set<String> getPersistedStringSet(String r100) {
        SharedPreferences r101 = this.mSharedPreferences;
        if (r101 == null) goto L5;
        Set<String> r102 = r101.getStringSet(r100, Collections.emptySet());
        if (r102 != null) goto L11;
        return new HashSet();
    L11:
        return new HashSet(r102);
    L5:
        return new HashSet();
    }

    private static /* synthetic */ Map lambda$reportEnableEventIfNeeded$0(String r100) {
        HashMap r101 = new HashMap();
        r101.put(ReportConstant.COMMON_BACKTRACE, r100);
        return r101;
    }

    private void syncToNativeEnabledCDPDomains(Set<String> r100) {
        if (DevToolLifecycle.getInstance().isInitialized() == true) goto L5;
        return;
    L5:
        LynxEnv.inst().nativeSetGroupedEnvWithGroupSet("activated_cdp_domains", new HashSet(r100));
    }

    private boolean verifyCDPDomainKey(String r100) {
        if (r100.startsWith(CDP_DOMAIN_KEY_PREFIX) == true) goto L6;
        LLog.e(TAG, "Invalid CDP domain key: ".concat(r100));
        return false;
    L6:
        return true;
    }

    public void init(Context r100) {
        if (r100 != null) goto L5;
        LLog.e(TAG, "init with null context");
        return;
    L5:
        this.mSharedPreferences = r100.getSharedPreferences("lynx_env_config", 0);
    }

    public boolean isCDPDomainEnabled(String r100) {
        if (verifyCDPDomainKey(r100) == true) goto L7;
        return false;
    L7:
        return getEnabledCDPDomains().contains(r100);
    }

    public boolean isErrorTypeIgnored(int r100) {
        return getIgnoredErrorTypes().contains(String.valueOf(r100));
    }

    public void setCSSErrorIgnored(boolean r100) {
        setErrorTypeIgnored(130100, r100);
    }

    public void setDOMTreeEnabled(boolean r100) {
        setPersistedBoolean("enable_dom_tree", r100);
        syncToNativeBoolean("enable_dom_tree", r100);
    }

    public void setDebugModeEnabled(boolean r100) {
        setPersistedBoolean("enable_debug_mode", r100);
        reportEnableEventIfNeeded("setDebugModeEnabled", "lynxsdk_enable_debug_mode_event", r100);
    }

    public void setDevToolEnabled(boolean r100) {
        setPersistedBoolean("enable_devtool", r100);
        syncToNativeBoolean("enable_devtool", r100);
        reportEnableEventIfNeeded("setDevToolEnabled", "lynxsdk_enable_devtool_event", r100);
    }

    public void setEnabledCDPDomains(Collection<String> r100) {
        HashSet r101 = new HashSet(r100);
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (verifyCDPDomainKey((String) r102.next()) == true) goto L4;
        return;
    L8:
        setPersistedStringSet("activated_cdp_domains", r101);
        syncToNativeEnabledCDPDomains(r101);
    }

    public void setFSPScreenshotEnabled(boolean r100) {
        setPersistedBoolean("enable_fsp_screenshot", r100);
    }

    public void setHighlightTouchEnabled(boolean r100) {
        this.mHighlightTouchEnabled = r100;
    }

    public void setIgnoredErrorTypes(Collection<String> r100) {
        setPersistedStringSet("ignore_error_types", new HashSet(r100));
    }

    public void setLaunchRecordEnabled(boolean r100) {
        setPersistedBoolean("enable_launch_record", r100);
    }

    public void setLogBoxEnabled(boolean r100) {
        setPersistedBoolean("enable_logbox", r100);
        syncToNativeBoolean("enable_logbox", r100);
        reportEnableEventIfNeeded("setLogBoxEnabled", "lynxsdk_enable_logbox_event", r100);
    }

    public void setLongPressMenuEnabled(boolean r100) {
        setPersistedBoolean("enable_long_press_menu", r100);
    }

    public void setPerfMetricsEnabled(boolean r100) {
        this.mPerfMetricsEnabled = r100;
    }

    public void setPixelCopyEnabled(boolean r100) {
        setPersistedBoolean("enable_pixel_copy", r100);
    }

    public void setPreviewScreenshotEnabled(boolean r100) {
        this.mPreviewScreenshotEnabled = r100;
    }

    public void setQuickJSCacheEnabled(boolean r100) {
        setPersistedBoolean("enable_quickjs_cache", r100);
        syncToNativeBoolean("enable_quickjs_cache", r100);
    }

    public void setQuickJSDebugEnabled(boolean r100) {
        setPersistedBoolean("enable_quickjs_debug", r100);
        syncToNativeBoolean("enable_quickjs_debug", r100);
    }

    public void setV8Enabled(int r100) {
        setPersistedInt("enable_v8", r100);
        syncToNativeInt("enable_v8", r100);
    }

    private static String buildBacktrace(StackTraceElement[] r100, int r101) {
        StringBuilder r102 = new StringBuilder();
        int r103 = Math.min(r101 + 3, r100.length);
    L3:
        if (r101 >= r103) goto L9;
        if (r102.length() <= 0) goto L7;
        r102.append('\n');
    L7:
        r102.append(r100[r101]);
        r101 = r101 + 1;
        goto L3
    L9:
        return r102.toString();
    }

    private static int findFirstExternalFrameIndex(StackTraceElement[] r100, String... r101) {
        return findFirstNonSkippedFrameIndex(r100, 0, r101, true);
    }

    private boolean getPersistedBoolean(String r100, boolean r101) {
        SharedPreferences r102 = this.mSharedPreferences;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getBoolean(r100, r101);
    }

    private int getPersistedInt(String r100, int r101) {
        SharedPreferences r102 = this.mSharedPreferences;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getInt(r100, r101);
    }

    private static boolean matchesAnyClassName(String r100, String[] r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (r101[r103].equals(r100) == true) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private void setPersistedBoolean(String r100, boolean r101) {
        SharedPreferences r102 = this.mSharedPreferences;
        if (r102 == null) goto L6;
        r102.edit().putBoolean(r100, r101).apply();
        return;
    }

    private void setPersistedInt(String r100, int r101) {
        SharedPreferences r102 = this.mSharedPreferences;
        if (r102 == null) goto L6;
        r102.edit().putInt(r100, r101).apply();
        return;
    }

    private void setPersistedStringSet(String r100, Set<String> r101) {
        SharedPreferences r102 = this.mSharedPreferences;
        if (r102 == null) goto L6;
        r102.edit().putStringSet(r100, new HashSet(r101)).apply();
        return;
    }

    private void syncToNativeBoolean(String r100, boolean r101) {
        if (DevToolLifecycle.getInstance().isInitialized() == true) goto L5;
        return;
    L5:
        LynxEnv r102 = LynxEnv.inst();
        if (r101 == false) goto L8;
        String r103 = "1";
    L9:
        r102.nativeSetLocalEnv(r100, r103);
        return;
    L8:
        r103 = "0";
        goto L9
    }

    private void syncToNativeInt(String r100, int r101) {
        if (DevToolLifecycle.getInstance().isInitialized() == true) goto L5;
        return;
    L5:
        LynxEnv.inst().nativeSetLocalEnv(r100, String.valueOf(r101));
    }

    public void setCDPDomainEnabled(String r100, boolean r101) {
        if (verifyCDPDomainKey(r100) == true) goto L5;
        return;
    L5:
        Set<String> r102 = getEnabledCDPDomains();
        if (r101 == false) goto L8;
        boolean r103 = r102.add(r100);
    L9:
        if (r103 == true) goto L11;
        return;
    L11:
        setPersistedStringSet("activated_cdp_domains", r102);
        syncToNativeEnabledCDPDomains(r102);
        return;
    L8:
        r103 = r102.remove(r100);
        goto L9
    }

    public void setErrorTypeIgnored(int r100, boolean r101) {
        Set<String> r102 = getIgnoredErrorTypes();
        String r103 = String.valueOf(r100);
        if (r101 == false) goto L5;
        boolean r104 = r102.add(r103);
    L6:
        if (r104 == true) goto L8;
        return;
    L8:
        setPersistedStringSet("ignore_error_types", r102);
        return;
    L5:
        r104 = r102.remove(r103);
        goto L6
    }

    private static int findFirstNonSkippedFrameIndex(StackTraceElement[] r100, int r101, String... r102) {
        return findFirstNonSkippedFrameIndex(r100, r101, r102, false);
    }

    private void reportEnableEventIfNeeded(String r100, String r101, boolean r102) {
        if (r102 == true) goto L4;
        return;
    L4:
        final String r103 = getEnableCaller(r100);
        LynxEventReporter.onEvent(r101, -1, new a(r103));
    }

    private static int findFirstNonSkippedFrameIndex(StackTraceElement[] r100, int r101, String[] r102, boolean r103) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        int r104 = Math.max(r101, 0);
    L7:
        if (r104 >= r100.length) goto L17;
        String r105 = r100[r104].getClassName();
        if (r103 == false) goto L14;
        if (VM_STACK_CLASS_NAME.equals(r105) == false) goto L14;
    L16:
        r104 = r104 + 1;
    L14:
        if (matchesAnyClassName(r105, r102) == true) goto L16;
        return r104;
    L17:
        return -1;
    }

    public static String getCallerBacktrace(String r100, String r101, String[] r102, String[] r103) {
        return getCallerBacktrace(ThreadMethodProxy.currentThread().getStackTrace(), r100, r101, r102, r103);
    }

    public static String getCallerBacktrace(StackTraceElement[] r100, String r101, String r102, String[] r103, String[] r104) {
        if (r100 != null) goto L5;
    L24:
        return "Unknown caller";
    L5:
        if (r100.length == 0) goto L24;
        int r105 = 0;
    L9:
        if (r105 >= r100.length) goto L20;
        StackTraceElement r106 = r100[r105];
        if (r102.equals(r106.getMethodName()) == false) goto L19;
        if (r101.equals(r106.getClassName()) == false) goto L19;
        int r107 = findFirstNonSkippedFrameIndex(r100, r105 + 1, r103);
        if (r107 < 0) goto L20;
        return buildBacktrace(r100, r107);
    L19:
        r105 = r105 + 1;
    L20:
        int r108 = findFirstExternalFrameIndex(r100, r104);
        if (r108 < 0) goto L24;
        return buildBacktrace(r100, r108);
    }
}
