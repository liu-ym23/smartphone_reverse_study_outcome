package com.bytedance.lynx.webview.glue.sdk113;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface ISdkToGlueSdk113 {

    public interface IGlobalResourceEventListener {

        /* JADX INFO: renamed from: com.bytedance.lynx.webview.glue.sdk113.ISdkToGlueSdk113$IGlobalResourceEventListener$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onResourceLoadedFailure(IGlobalResourceEventListener r100, String r101, int r102, int r103, int r104, String r105) {
            }

            public static void $default$onResourceLoadedSuccess(IGlobalResourceEventListener r100, String r101, int r102, Map r103, byte[] r104) {
            }
        }

        void onResourceLoadedFailure(String r100, int r101, int r102, int r103, String r104);

        void onResourceLoadedSuccess(String r100, int r101, Map<String, String> r102, byte[] r103);
    }

    public interface RequestDiskCacheCallback {
        void onReadFinish(String r100, String r101, int r102, Map<String, String> r103, byte[] r104);
    }

    void CreateBrowserUITaskExecutor();

    String addCustomExtraInterceptConfig(Map<String, String> r100);

    void addGlobalResourceEventListener(IGlobalResourceEventListener r100);

    void addGlobalResourceEventListener(Object r100);

    void cancelAllPreload();

    void cancelPreload(String r100);

    boolean checkSoRuntimeEnvironment(Context r100);

    void clearAllPreloadCache();

    void clearPreloadCache(String r100);

    void clearPrerenderQueue();

    boolean enableFeature(String r100, boolean r101);

    void ensureFactoryProviderCreated();

    String getDefaultUserAgentWithoutLoadWebView();

    WebSettings getPrerenderSettings(Context r100);

    int getSccSafeBrowsingStyle();

    String getTTCookiePath();

    int getTTNetNativeInitErrorCode();

    String getUserAgentString();

    long[] getV8PipeInterfaces();

    void initAwBrowserDependencies();

    boolean isAdblockEffective();

    boolean isDarkModeSupported();

    boolean isDarkStrategySupported();

    boolean isFeatureSupport(String r100, int r101);

    boolean isPrerenderExist(String r100);

    boolean isSupportAndroidX();

    boolean isTTwebviewAdblockAvailable();

    boolean launchRenderProcess();

    void onRequestAdblockRuleDone(String r100, String r101, String r102);

    void onSetSccEnable(boolean r100);

    void onUrlCheckDone(boolean r100, int r101, String r102, long r103, long r104, String r105);

    void pausePreload();

    void preInitAwBrowserAsync();

    boolean preloadClasses();

    boolean preloadResource(String r100, byte[] r101, String r102);

    boolean preloadResourceFromByteArray(String r100, String r101, byte[] r102, String r103);

    boolean preloadResourceFromLocalPath(String r100, Map<String, String> r101, String r102);

    boolean preloadResourceFromNetwork(String r100, String[] r101, String r102);

    void preloadUrl(String r100, long r101, String r102, String r103, boolean r104);

    boolean prerenderUrl(String r100, int r101, int r102, WebSettings r103);

    void preresolveHosts(String[] r100);

    void registerPiaManifest(String r100, String r101);

    void removeGlobalResourceEventListener(IGlobalResourceEventListener r100);

    void removeGlobalResourceEventListener(Object r100);

    void removePrerender(String r100);

    boolean removeResourcesByGroupId(String r100);

    void requestDiskCache(String r100, String r101, RequestDiskCacheCallback r102);

    void requestDiskCache(String r100, String r101, Object r102);

    void resumePreload();

    void setForceDark(WebSettings r100, int r101);

    void setForceDarkStrategy(WebSettings r100, int r101);

    boolean setRustRulesPath(String[] r100, String[] r101);

    void setSccSafeBrowsingStyle(int r100, boolean r101);

    boolean setSysClassLoader(ClassLoader r100);

    boolean setUsingSysCookieEnable();

    void trimMemory(int r100);

    void unregisterPiaManifest(String r100);

    boolean warmupRenderProcess();
}
