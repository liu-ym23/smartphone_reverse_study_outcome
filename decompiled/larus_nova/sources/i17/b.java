package i17;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebViewFactoryProvider;
import com.bytedance.lynx.webview.glue.ISdkToGlue;
import com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113;
import com.bytedance.lynx.webview.internal.TTWebContext;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import l17.i;
import l17.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements ISdkToGlue {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Method> f488004b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f488005a;

    static {
        f488004b = i.a(ISdkToGlue.class, "com.bytedance.webview.chromium.SdkToGlueImpl");
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void CreateBrowserUITaskExecutor() {
        Method r100 = (Method) ((HashMap) f488004b).get("CreateBrowserUITaskExecutor");
        Object r101 = this.f488005a;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L10
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "CreateBrowserUITaskExecutor invoke failure"});
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void cancelAllPreload() {
        Method r100 = (Method) ((HashMap) f488004b).get("cancelAllPreload");
        Object r101 = this.f488005a;
        if (r101 == null) goto L11;
        if (r100 != null) goto L9;
        return;
    L9:
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void clearAllPreloadCache() {
        Method r100 = (Method) ((HashMap) f488004b).get("clearAllPreloadCache");
        Object r101 = this.f488005a;
        if (r101 == null) goto L11;
        if (r100 != null) goto L9;
        return;
    L9:
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void clearPrerenderQueue() {
        Method r100 = (Method) ((HashMap) f488004b).get("clearPrerenderQueue");
        Object r101 = this.f488005a;
        if (r101 == null) goto L11;
        if (r100 != null) goto L9;
        return;
    L9:
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void ensureFactoryProviderCreated() {
        Method r100 = (Method) ((HashMap) f488004b).get("ensureFactoryProviderCreated");
        Object r101 = this.f488005a;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L10
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "ensureFactoryProviderCreated invoke failure"});
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final Map<String, String> getCrashInfo() {
        Method r100 = (Method) ((HashMap) f488004b).get("getCrashInfo");
        Object r101 = this.f488005a;
        if (r101 == null) goto L9;
        if (r100 == null) goto L9;
        return (Map) r100.invoke(r101, new Object[0]);
    L9:
        return new HashMap();
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final String getDefaultUserAgentWithoutLoadWebView() {
        Method r100 = (Method) ((HashMap) f488004b).get("getDefaultUserAgentWithoutLoadWebView");
        Object r101 = this.f488005a;
        if (r101 == null) goto L8;
        if (r100 != null) goto L11;
        return "";
    L11:
        return (String) r100.invoke(r101, new Object[0]);
    L14:
        return "";
    L8:
        return "";
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final String getLatestUrl() {
        Method r100 = (Method) ((HashMap) f488004b).get("getLatestUrl");
        Object r101 = this.f488005a;
        if (r101 == null) goto L8;
        if (r100 != null) goto L11;
        return null;
    L11:
        return (String) r100.invoke(r101, new Object[0]);
    L14:
        return null;
    L8:
        return null;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final int getSccSafeBrowsingStyle() {
        Method r100 = (Method) ((HashMap) f488004b).get("getSccSafeBrowsingStyle");
        Object r101 = this.f488005a;
        if (r101 == null) goto L8;
        if (r100 != null) goto L11;
        return -1;
    L11:
        return ((Integer) r100.invoke(r101, new Object[0])).intValue();
    L14:
        return -1;
    L8:
        return -1;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final String getTTCookiePath() {
        Method r100 = (Method) ((HashMap) f488004b).get("getTTCookiePath");
        Object r101 = this.f488005a;
        if (r101 == null) goto L10;
        if (r100 == null) goto L10;
        return (String) r100.invoke(r101, new Object[0]);
    L9:
        k.b(new String[]{"TT_WEBVIEW", "getTTCookiePath reflect error"});
    L10:
        return "";
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final int getTTNetNativeInitErrorCode() {
        Method r100 = (Method) ((HashMap) f488004b).get("getTTNetNativeInitErrorCode");
        Object r101 = this.f488005a;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        return ((Integer) r100.invoke(r101, new Object[0])).intValue();
    L8:
        k.b(new String[]{"TT_WEBVIEW", "getTTNetNativeInitErrorCode invoke failure"});
        return -101;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final String getUserAgentString() {
        Method r100 = (Method) ((HashMap) f488004b).get("getUserAgentString");
        Object r101 = this.f488005a;
        if (r101 == null) goto L8;
        if (r100 != null) goto L11;
        return "";
    L11:
        return (String) r100.invoke(r101, new Object[0]);
    L14:
        return "";
    L8:
        return "";
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final long[] getV8PipeInterfaces() {
        Method r100 = (Method) ((HashMap) f488004b).get("getV8PipeInterfaces");
        Object r101 = this.f488005a;
        if (r101 == null) goto L8;
        if (r100 != null) goto L11;
        return null;
    L11:
        return (long[]) r100.invoke(r101, new Object[0]);
    L14:
        return null;
    L8:
        return null;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final int getWebViewCount() {
        Method r100 = (Method) ((HashMap) f488004b).get("getWebViewCount");
        Object r101 = this.f488005a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        return ((Integer) r100.invoke(r101, new Object[0])).intValue();
    L7:
        return 0;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void initAwBrowserDependencies() {
        Method r100 = (Method) ((HashMap) f488004b).get("initAwBrowserDependencies");
        Object r101 = this.f488005a;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L10
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "initAwBrowserDependencies invoke failure"});
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean isAdblockEffective() {
        Method r100 = (Method) ((HashMap) f488004b).get("isAdblockEffective");
        Object r101 = this.f488005a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        return ((Boolean) r100.invoke(r101, new Object[0])).booleanValue();
    L7:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final boolean isAdblockEnable() {
        Method r100 = (Method) ((HashMap) f488004b).get("isAdblockEnable");
        Object r101 = this.f488005a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        return ((Boolean) r100.invoke(r101, new Object[0])).booleanValue();
    L7:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean isDarkModeSupported() {
        Method r100 = (Method) ((HashMap) f488004b).get("isDarkModeSupported");
        Object r101 = this.f488005a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        return ((Boolean) r100.invoke(r101, new Object[0])).booleanValue();
    L7:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean isDarkStrategySupported() {
        Method r100 = (Method) ((HashMap) f488004b).get("isDarkStrategySupported");
        Object r101 = this.f488005a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        return ((Boolean) r100.invoke(r101, new Object[0])).booleanValue();
    L7:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean isSupportAndroidX() {
        Method r100 = (Method) ((HashMap) f488004b).get("isSupportAndroidX");
        Object r101 = this.f488005a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        return ((Boolean) r100.invoke(r101, new Object[0])).booleanValue();
    L7:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean isTTwebviewAdblockAvailable() {
        if (this.f488005a != null) goto L5;
        return false;
    L5:
        Method r100 = (Method) ((HashMap) f488004b).get("isTTwebviewAdblockAvailable");
        if (r100 != null) goto L12;
        return true;
    L12:
        return ((Boolean) r100.invoke(this.f488005a, new Object[0])).booleanValue();
    L9:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean launchRenderProcess() {
        Method r100 = (Method) ((HashMap) f488004b).get("launchRenderProcess");
        Object r101 = this.f488005a;
        if (r101 == null) goto L9;
        if (r100 == null) goto L9;
        return ((Boolean) r100.invoke(r101, new Object[0])).booleanValue();
    L7:
        e = move-exception;
        k.b(new String[]{"TT_WEBVIEW", "launchRenderProcess error" + e.toString()});
    L9:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final void notifyAppInfoGetterAvailable() {
        Method r100 = (Method) ((HashMap) f488004b).get("notifyAppInfoGetterAvailable");
        Object r101 = this.f488005a;
        if (r101 == null) goto L11;
        if (r100 != null) goto L9;
        return;
    L9:
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void pausePreload() {
        Method r100 = (Method) ((HashMap) f488004b).get("pausePreload");
        Object r101 = this.f488005a;
        if (r101 == null) goto L11;
        if (r100 != null) goto L9;
        return;
    L9:
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void preInitAwBrowserAsync() {
        Method r100 = (Method) ((HashMap) f488004b).get("preInitAwBrowserAsync");
        Object r101 = this.f488005a;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L10
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "preInitAwBrowserAsync invoke failure"});
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean preloadClasses() {
        Method r100 = (Method) ((HashMap) f488004b).get("preloadClasses");
        Object r101 = this.f488005a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        return ((Boolean) r100.invoke(r101, new Object[0])).booleanValue();
    L7:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void resumePreload() {
        Method r100 = (Method) ((HashMap) f488004b).get("resumePreload");
        Object r101 = this.f488005a;
        if (r101 == null) goto L11;
        if (r100 != null) goto L9;
        return;
    L9:
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean setUsingSysCookieEnable() {
        Method r100 = (Method) ((HashMap) f488004b).get("setUsingSysCookieEnable");
        Object r101 = this.f488005a;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        return ((Boolean) r100.invoke(r101, new Object[0])).booleanValue();
    L7:
        k.b(new String[]{"TT_WEBVIEW", "setUsingSysCookieEnable error"});
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean warmupRenderProcess() {
        Method r100 = (Method) ((HashMap) f488004b).get("warmupRenderProcess");
        Object r101 = this.f488005a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        return ((Boolean) r100.invoke(r101, new Object[0])).booleanValue();
    L7:
        return false;
    }

    public b() {
        this.f488005a = null;
        this.f488005a = TTWebContext.h().f265216b.f("com.bytedance.webview.chromium.SdkToGlueImpl", false).newInstance();     // Catch: Exception -> L5
        return;
    L5:
        k.b(new String[]{"TT_WEBVIEW", "get SdkToGlue failure"});
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.ISdkToGlueSdk112
    public final boolean CheckGlueVersion(String r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("CheckGlueVersion");
        Object r102 = this.f488005a;
        if (r102 == null) goto L9;
        if (r101 == null) goto L9;
        return ((Boolean) r101.invoke(r102, new Object[]{r100})).booleanValue();
    L8:
        k.b(new String[]{"TT_WEBVIEW", "CheckGlueVersion error"});
    L9:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.ISdkToGlueSdk112
    public final boolean CheckSdkVersion(String r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("CheckSdkVersion");
        Object r102 = this.f488005a;
        if (r102 == null) goto L9;
        if (r101 == null) goto L9;
        return ((Boolean) r101.invoke(r102, new Object[]{r100})).booleanValue();
    L8:
        k.b(new String[]{"TT_WEBVIEW", "CheckSdkVersion error"});
    L9:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final String addCustomExtraInterceptConfig(Map<String, String> r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("addCustomExtraInterceptConfig");
        Object r102 = this.f488005a;
        if (r102 == null) goto L8;
        if (r101 != null) goto L11;
        return null;
    L11:
        return (String) r101.invoke(r102, new Object[]{r100});
    L14:
        return null;
    L8:
        return null;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void addGlobalResourceEventListener(Object r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("addGlobalResourceEventListener");
        Object r102 = this.f488005a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void cancelPreload(String r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("cancelPreload");
        Object r102 = this.f488005a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean checkSoRuntimeEnvironment(Context r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("checkSoRuntimeEnvironment");
        Object r102 = this.f488005a;
        if (r102 == null) goto L8;
        if (r101 == null) goto L8;
        return ((Boolean) r101.invoke(r102, new Object[]{r100})).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void clearPreloadCache(String r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("clearPreloadCache");
        Object r102 = this.f488005a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final WebSettings getPrerenderSettings(Context r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("getPrerenderSettings");
        Object r102 = this.f488005a;
        if (r102 == null) goto L8;
        if (r101 != null) goto L11;
        return null;
    L11:
        return (WebSettings) r101.invoke(r102, new Object[]{r100});
    L14:
        return null;
    L8:
        return null;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final WebViewFactoryProvider getProviderInstance(String r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("getProviderInstance");
        Object r102 = this.f488005a;
        if (r102 == null) goto L13;
        if (r101 != null) goto L11;
        return null;
    L11:
        return (WebViewFactoryProvider) r101.invoke(r102, new Object[]{r100});
    L8:
        k.b(new String[]{"TT_WEBVIEW", "getProviderInstance error"});
        return null;
    L13:
        return null;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean isPrerenderExist(String r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("isPrerenderExist");
        Object r102 = this.f488005a;
        if (r102 == null) goto L8;
        if (r101 == null) goto L8;
        return ((Boolean) r101.invoke(r102, new Object[]{r100})).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final void loadLibrary(String r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("loadLibrary");
        Object r102 = this.f488005a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.ISdkToGlueSdk112
    public final void onCallMS(String r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("onCallMS");
        Object r102 = this.f488005a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void onSetSccEnable(boolean r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("onSetSccEnable");
        Object r102 = this.f488005a;
        if (r102 == null) goto L13;
        if (r101 != null) goto L11;
        return;
    L11:
        r101.invoke(r102, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L9
        return;
    L9:
        k.b(new String[]{"TT_WEBVIEW", "onSetSccEnable reflect error"});
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void preresolveHosts(String[] r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("preresolveHosts");
        Object r102 = this.f488005a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void removeGlobalResourceEventListener(Object r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("removeGlobalResourceEventListener");
        Object r102 = this.f488005a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void removePrerender(String r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("removePrerender");
        Object r102 = this.f488005a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean removeResourcesByGroupId(String r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("removeResourcesByGroupId");
        Object r102 = this.f488005a;
        if (r102 == null) goto L10;
        if (r101 == null) goto L10;
        return ((Boolean) r101.invoke(r102, new Object[]{r100})).booleanValue();
    L8:
        e = move-exception;
        k.b(new String[]{"TT_WEBVIEW", "removeResourcesByGroupId error" + e.toString()});
    L10:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final boolean setAdblockEnable(boolean r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("setAdblockEnable");
        Object r102 = this.f488005a;
        if (r102 == null) goto L8;
        if (r101 == null) goto L8;
        return ((Boolean) r101.invoke(r102, new Object[]{Boolean.valueOf(r100)})).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.ISdkToGlueSdk112
    public final boolean setCustomedHeaders(Map<String, String> r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("setCustomedHeaders");
        Object r102 = this.f488005a;
        if (r102 == null) goto L8;
        if (r101 == null) goto L8;
        return ((Boolean) r101.invoke(r102, new Object[]{r100})).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final void setJsonObject(JSONObject r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("setJsonObject");
        Object r102 = this.f488005a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean setSysClassLoader(ClassLoader r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("setSysClassLoader");
        Object r102 = this.f488005a;
        if (r102 == null) goto L10;
        if (r101 == null) goto L10;
        return ((Boolean) r101.invoke(r102, new Object[]{r100})).booleanValue();
    L8:
        e = move-exception;
        k.b(new String[]{"TT_WEBVIEW", "setSysClassLoader error" + e.toString()});
    L10:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void trimMemory(int r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("trimMemory");
        Object r102 = this.f488005a;
        if (r102 == null) goto L8;
        if (r101 == null) goto L8;
        r101.invoke(r102, new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L10
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "trimMemory invoke failure"});
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void unregisterPiaManifest(String r100) {
        Method r101 = (Method) ((HashMap) f488004b).get("unregisterPiaManifest");
        Object r102 = this.f488005a;
        if (r102 == null) goto L12;
        if (r101 != null) goto L10;
        return;
    L10:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "unregisterPiaManifest reflect error"});
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void addGlobalResourceEventListener(ISdkToGlueSdk113.IGlobalResourceEventListener r100) {
        addGlobalResourceEventListener(r100);
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void removeGlobalResourceEventListener(ISdkToGlueSdk113.IGlobalResourceEventListener r100) {
        removeGlobalResourceEventListener(r100);
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean enableFeature(String r100, boolean r101) {
        Method r102 = (Method) ((HashMap) f488004b).get("enableFeature");
        Object r103 = this.f488005a;
        if (r103 == null) goto L8;
        if (r102 == null) goto L8;
        return ((Boolean) r102.invoke(r103, new Object[]{r100, Boolean.valueOf(r101)})).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean isFeatureSupport(String r100, int r101) {
        Method r102 = (Method) ((HashMap) f488004b).get("isFeatureSupport");
        Object r103 = this.f488005a;
        if (r103 == null) goto L8;
        if (r102 == null) goto L8;
        return ((Boolean) r102.invoke(r103, new Object[]{r100, Integer.valueOf(r101)})).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.ISdkToGlueSdk112
    public final void preconnectUrl(String r100, int r101) {
        Method r102 = (Method) ((HashMap) f488004b).get("preconnectUrl");
        Object r103 = this.f488005a;
        if (r103 == null) goto L11;
        if (r102 != null) goto L9;
        return;
    L9:
        r102.invoke(r103, new Object[]{r100, Integer.valueOf(r101)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void registerPiaManifest(String r100, String r101) {
        Method r102 = (Method) ((HashMap) f488004b).get("registerPiaManifest");
        Object r103 = this.f488005a;
        if (r103 == null) goto L12;
        if (r102 != null) goto L10;
        return;
    L10:
        r102.invoke(r103, new Object[]{r100, r101});     // Catch: Exception -> L8
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "registerPiaManifest reflect error"});
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final boolean setAdblockDeserializeFile(String r100, String r101) {
        Method r102 = (Method) ((HashMap) f488004b).get("setAdblockDeserializeFile");
        Object r103 = this.f488005a;
        if (r103 == null) goto L8;
        if (r102 == null) goto L8;
        return ((Boolean) r102.invoke(r103, new Object[]{r100, r101})).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final boolean setAdblockRulesPath(String[] r100, String[] r101) {
        Method r102 = (Method) ((HashMap) f488004b).get("setAdblockRulesPath");
        Object r103 = this.f488005a;
        if (r103 == null) goto L8;
        if (r102 == null) goto L8;
        return ((Boolean) r102.invoke(r103, new Object[]{r100, r101})).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void setForceDark(WebSettings r100, int r101) {
        Method r102 = (Method) ((HashMap) f488004b).get("setForceDark");
        Object r103 = this.f488005a;
        if (r103 == null) goto L11;
        if (r102 != null) goto L9;
        return;
    L9:
        r102.invoke(r103, new Object[]{r100, Integer.valueOf(r101)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void setForceDarkStrategy(WebSettings r100, int r101) {
        Method r102 = (Method) ((HashMap) f488004b).get("setForceDarkStrategy");
        Object r103 = this.f488005a;
        if (r103 == null) goto L11;
        if (r102 != null) goto L9;
        return;
    L9:
        r102.invoke(r103, new Object[]{r100, Integer.valueOf(r101)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ISdkToGlueSdk111
    public final void setPreconnectUrl(String r100, int r101) {
        Method r102 = (Method) ((HashMap) f488004b).get("setPreconnectUrl");
        Object r103 = this.f488005a;
        if (r103 == null) goto L11;
        if (r102 != null) goto L9;
        return;
    L9:
        r102.invoke(r103, new Object[]{r100, Integer.valueOf(r101)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean setRustRulesPath(String[] r100, String[] r101) {
        Method r102 = (Method) ((HashMap) f488004b).get("setRustRulesPath");
        Object r103 = this.f488005a;
        if (r103 == null) goto L8;
        if (r102 == null) goto L8;
        return ((Boolean) r102.invoke(r103, new Object[]{r100, r101})).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void setSccSafeBrowsingStyle(int r100, boolean r101) {
        Method r102 = (Method) ((HashMap) f488004b).get("setSccSafeBrowsingStyle");
        Object r103 = this.f488005a;
        if (r103 == null) goto L11;
        if (r102 != null) goto L9;
        return;
    L9:
        r102.invoke(r103, new Object[]{Integer.valueOf(r100), Boolean.valueOf(r101)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void onRequestAdblockRuleDone(String r100, String r101, String r102) {
        Method r103 = (Method) ((HashMap) f488004b).get("onRequestAdblockRuleDone");
        Object r104 = this.f488005a;
        if (r104 == null) goto L12;
        if (r103 != null) goto L10;
        return;
    L10:
        r103.invoke(r104, new Object[]{r100, r101, r102});     // Catch: Exception -> L8
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "onRequestAdblockRuleDone reflect error"});
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean preloadResource(String r100, byte[] r101, String r102) {
        Method r103 = (Method) ((HashMap) f488004b).get("preloadResource");
        Object r104 = this.f488005a;
        if (r104 == null) goto L10;
        if (r103 == null) goto L10;
        return ((Boolean) r103.invoke(r104, new Object[]{r100, r101, r102})).booleanValue();
    L8:
        e = move-exception;
        k.b(new String[]{"TT_WEBVIEW", "preloadResource error" + e.toString()});
    L10:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean preloadResourceFromLocalPath(String r100, Map<String, String> r101, String r102) {
        Method r103 = (Method) ((HashMap) f488004b).get("preloadResourceFromLocalPath");
        Object r104 = this.f488005a;
        if (r104 == null) goto L10;
        if (r103 == null) goto L10;
        return ((Boolean) r103.invoke(r104, new Object[]{r100, r101, r102})).booleanValue();
    L8:
        e = move-exception;
        k.b(new String[]{"TT_WEBVIEW", "preloadResourceFromLocalPath error" + e.toString()});
    L10:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean preloadResourceFromNetwork(String r100, String[] r101, String r102) {
        Method r103 = (Method) ((HashMap) f488004b).get("preloadResourceFromNetwork");
        Object r104 = this.f488005a;
        if (r104 == null) goto L10;
        if (r103 == null) goto L10;
        return ((Boolean) r103.invoke(r104, new Object[]{r100, r101, r102})).booleanValue();
    L8:
        e = move-exception;
        k.b(new String[]{"TT_WEBVIEW", "preloadResourceFromNetwork error" + e.toString()});
    L10:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void requestDiskCache(String r100, String r101, Object r102) {
        Method r103 = (Method) ((HashMap) f488004b).get("requestDiskCache");
        Object r104 = this.f488005a;
        if (r104 == null) goto L11;
        if (r103 != null) goto L9;
        return;
    L9:
        r103.invoke(r104, new Object[]{r100, r101, r102});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void requestDiskCache(String r100, String r101, ISdkToGlueSdk113.RequestDiskCacheCallback r102) {
        requestDiskCache(r100, r101, r102);
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean preloadResourceFromByteArray(String r100, String r101, byte[] r102, String r110) {
        Method r103 = (Method) ((HashMap) f488004b).get("preloadResourceFromByteArray");
        Object r104 = this.f488005a;
        if (r104 == null) goto L10;
        if (r103 == null) goto L10;
        return ((Boolean) r103.invoke(r104, new Object[]{r100, r101, r102, r110})).booleanValue();
    L8:
        e = move-exception;
        k.b(new String[]{"TT_WEBVIEW", "preloadResourceFromByteArray error" + e.toString()});
    L10:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final boolean prerenderUrl(String r100, int r101, int r102, WebSettings r103) {
        Method r104 = (Method) ((HashMap) f488004b).get("prerenderUrlOnUI");
        Object r105 = this.f488005a;
        if (r105 == null) goto L8;
        if (r104 == null) goto L8;
        return ((Boolean) r104.invoke(r105, new Object[]{r100, Integer.valueOf(r101), Integer.valueOf(r102), r103})).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void preloadUrl(String r100, long r101, String r102, String r103, boolean r110) {
        Method r104 = (Method) ((HashMap) f488004b).get("preloadUrl");
        Object r105 = this.f488005a;
        if (r105 == null) goto L11;
        if (r104 != null) goto L9;
        return;
    L9:
        r104.invoke(r105, new Object[]{r100, Long.valueOf(r101), r102, r103, Boolean.valueOf(r110)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113
    public final void onUrlCheckDone(boolean r100, int r101, String r102, long r103, long r110, String r111) {
        Method r104 = (Method) ((HashMap) f488004b).get("onUrlCheckDone");
        Object r105 = this.f488005a;
        if (r105 == null) goto L12;
        if (r104 != null) goto L10;
        return;
    L10:
        r104.invoke(r105, new Object[]{Boolean.valueOf(r100), Integer.valueOf(r101), r102, Long.valueOf(r103), Long.valueOf(r110), r111});     // Catch: Exception -> L8
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "onUrlCheckDone reflect error"});
        return;
    }
}
