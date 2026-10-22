package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CronetEngine {
    private static final String TAG = null;

    public static class Builder {
        public static final int HTTP_CACHE_DISABLED = 0;
        public static final int HTTP_CACHE_DISK = 3;
        public static final int HTTP_CACHE_DISK_NO_HTTP = 2;
        public static final int HTTP_CACHE_IN_MEMORY = 1;
        private static final String TAG = "CronetEngine.Builder";
        protected final ICronetEngineBuilder mBuilderDelegate;

        /* JADX INFO: loaded from: classes6.dex */
        public static abstract class LibraryLoader {
            public LibraryLoader() {
            }

            public abstract void loadLibrary(String r100);
        }

        public Builder enableSdch(boolean r100) {
            return this;
        }

        public CronetEngine build() {
            return this.mBuilderDelegate.build();
        }

        public Builder enableVerboseLog() {
            this.mBuilderDelegate.enableVerboseLog();
            return this;
        }

        public String getDefaultUserAgent() {
            return this.mBuilderDelegate.getDefaultUserAgent();
        }

        public Builder(ICronetEngineBuilder r100) {
            this.mBuilderDelegate = r100;
        }

        public Builder enableBoeProxy(boolean r100) {
            this.mBuilderDelegate.enableBoeProxy(r100);
            return this;
        }

        public Builder enableBrotli(boolean r100) {
            this.mBuilderDelegate.enableBrotli(r100);
            return this;
        }

        public Builder enableHttp2(boolean r100) {
            this.mBuilderDelegate.enableHttp2(r100);
            return this;
        }

        public Builder enableHttpDns(boolean r100) {
            this.mBuilderDelegate.enableHttpDns(r100);
            return this;
        }

        public Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r100) {
            this.mBuilderDelegate.enablePublicKeyPinningBypassForLocalTrustAnchors(r100);
            return this;
        }

        public Builder enableQuic(boolean r100) {
            this.mBuilderDelegate.enableQuic(r100);
            return this;
        }

        public Builder enableTncSecureMode(boolean r100) {
            this.mBuilderDelegate.enableTncSecureMode(r100);
            return this;
        }

        public Builder listenAppStateIndependently(boolean r100) {
            this.mBuilderDelegate.listenAppStateIndependently(r100);
            return this;
        }

        public Builder setALogFuncAddr(long r100) {
            this.mBuilderDelegate.setALogFuncAddr(r100);
            return this;
        }

        public Builder setAppInfoProvider(TTAppInfoProvider r100) {
            this.mBuilderDelegate.setAppInfoProvider(r100);
            return this;
        }

        public Builder setAppMonitorProvider(TTMonitorProvider r100) {
            this.mBuilderDelegate.setAppMonitorProvider(r100);
            return this;
        }

        public Builder setAppSecurityLevel(int r100) {
            this.mBuilderDelegate.setAppSecurityLevel(r100);
            return this;
        }

        public Builder setBypassBOEJSON(String r100) {
            this.mBuilderDelegate.setBypassBOEJSON(r100);
            return this;
        }

        public Builder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r100) {
            this.mBuilderDelegate.setClientOpaqueData(r100);
            return this;
        }

        public Builder setCronetSoPath(String r100) {
            this.mBuilderDelegate.setCronetSoPath(r100);
            return this;
        }

        public Builder setEventListener(TTEventListener r100) {
            this.mBuilderDelegate.setEventListener(r100);
            return this;
        }

        public Builder setGetDomainDefaultJSON(String r100) {
            this.mBuilderDelegate.setGetDomainDefaultJSON(r100);
            return this;
        }

        public Builder setIsMainProcess(boolean r100) {
            this.mBuilderDelegate.setIsMainProcess(r100);
            return this;
        }

        public Builder setLazyInitIPC(boolean r100) {
            this.mBuilderDelegate.setLazyInitIPC(r100);
            return this;
        }

        public Builder setLibraryLoader(LibraryLoader r100) {
            this.mBuilderDelegate.setLibraryLoader(r100);
            return this;
        }

        public Builder setOpaqueData(ArrayList<byte[]> r100) {
            this.mBuilderDelegate.setOpaqueData(r100);
            return this;
        }

        public Builder setOptInit(boolean r100) {
            this.mBuilderDelegate.setOptInit(r100);
            return this;
        }

        public Builder setProcessName(String r100) {
            this.mBuilderDelegate.setProcessName(r100);
            return this;
        }

        public Builder setProxyConfig(String r100) {
            this.mBuilderDelegate.setProxyConfig(r100);
            return this;
        }

        public Builder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r100) {
            this.mBuilderDelegate.setSlaSamplingSetting(r100);
            return this;
        }

        public Builder setStoragePath(String r100) {
            this.mBuilderDelegate.setStoragePath(r100);
            return this;
        }

        public Builder setStoreIdcRuleJSON(String r100) {
            this.mBuilderDelegate.setStoreIdcRuleJSON(r100);
            return this;
        }

        public Builder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r100) {
            this.mBuilderDelegate.setTTAppInfoColdStartSubset(r100);
            return this;
        }

        public Builder setTTNetInitStart(long r100) {
            this.mBuilderDelegate.setTTNetInitStart(r100);
            return this;
        }

        public Builder setTelemetryOptionFlags(int r100) {
            this.mBuilderDelegate.setTelemetryOptionFlags(r100);
            return this;
        }

        public Builder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r100) {
            this.mBuilderDelegate.setThreadConfigCallbackImpl(r100);
            return this;
        }

        public Builder setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r100) {
            this.mBuilderDelegate.setThreadConfigInfoList(r100);
            return this;
        }

        public Builder setUserAgent(String r100) {
            this.mBuilderDelegate.setUserAgent(r100);
            return this;
        }

        public Builder(Context r100, boolean r101) {
            this(createBuilderDelegate(r100, r101));
        }

        public static int compareVersions(String r100, String r101) {
            if (r100 == null) goto L20;
            if (r101 == null) goto L20;
            String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
            String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
            int r104 = 0;
        L6:
            if (r104 >= r102.length) goto L18;
            if (r104 >= r103.length) goto L18;
            int r105 = CastIntegerProtector.parseInt(r102[r104]);     // Catch: NumberFormatException -> L14
            int r106 = CastIntegerProtector.parseInt(r103[r104]);     // Catch: NumberFormatException -> L14
            if (r105 != r106) goto L11;
            r104 = r104 + 1;
            goto L6
        L11:
            return Integer.signum(r105 - r106);
        L14:
            e = move-exception;
            throw new IllegalArgumentException("Unable to convert version segments into integers: " + r102[r104] + " & " + r103[r104], e);
        L18:
            return Integer.signum(r102.length - r103.length);
        L20:
            throw new IllegalArgumentException("The input values cannot be null");
        }

        private static ICronetEngineBuilder createBuilderDelegate(Context r100, boolean r101) {
            CronetProvider r102 = (CronetProvider) ListProtector.get(getEnabledCronetProviders(r100, new ArrayList(CronetProvider.getAllProviders(r100))), 0);
            if (Log.isLoggable(TAG, 3) == false) goto L6;
            String.format("Using '%s' provider for creating CronetEngine.Builder.", new Object[]{r102});
        L6:
            return r102.createBuilder(r101).mBuilderDelegate;
        }

        public static List<CronetProvider> getEnabledCronetProviders(Context r100, List<CronetProvider> r101) {
            if (r101.size() == 0) goto L17;
            Iterator<CronetProvider> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L11;
            if (r102.next().isEnabled() == true) goto L6;
            r102.remove();
            goto L6
        L11:
            if (r101.size() == 0) goto L15;
            Collections.sort(r101, new AnonymousClass1());
            return r101;
        L15:
            throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
        L17:
            throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
        }

        public Builder enableHttpCache(int r100, long r101) {
            this.mBuilderDelegate.enableHttpCache(r100, r101);
            return this;
        }

        public Builder setOptNqeInit(boolean r100, boolean r101) {
            this.mBuilderDelegate.setOptNqeInit(r100, r101);
            return this;
        }

        public Builder setStackInfo(boolean r100, String r101) {
            this.mBuilderDelegate.setStackInfo(r100, r101);
            return this;
        }

        public Builder addQuicHint(String r100, int r101, int r102) {
            this.mBuilderDelegate.addQuicHint(r100, r101, r102);
            return this;
        }

        public Builder addPublicKeyPins(String r100, Set<byte[]> r101, boolean r102, Date r103) {
            this.mBuilderDelegate.addPublicKeyPins(r100, r101, r102, r103);
            return this;
        }
    }

    public CronetEngine() {
    }

    public abstract TTMpaService createTTMpaService();

    public abstract URLStreamHandlerFactory createURLStreamHandlerFactory();

    public abstract byte[] getGlobalMetricsDeltas();

    public abstract List<Long> getOpaqueFuncAddress();

    public abstract String getVersionString();

    public abstract TTNetDiagnosisRequest.Builder newNetDiagnosisRequestBuilder(TTNetDiagnosisRequest.Callback r100, Executor r101);

    public abstract UrlRequest.Builder newUrlRequestBuilder(String r100, UrlRequest.Callback r101, Executor r102);

    public abstract TTWebsocketConnection.Builder newWebsocketConnectionBuilder(TTWebsocketConnection.Callback r100, Executor r101);

    public abstract URLConnection openConnection(URL r100) throws IOException;

    public abstract URLConnection openConnection(URL r100, Proxy r101, boolean r102) throws IOException;

    public abstract void setAlogFuncAddr(long r100);

    public abstract void setAppStartUpState(int r100);

    public abstract void setCookieInitCompleted();

    public abstract void setHostResolverRules(String r100);

    public abstract void shutdown();

    public abstract void startNetLogToFile(String r100, boolean r101);

    public abstract void stopNetLog();

    static {
        TAG = "CronetEngine";
    }
}
