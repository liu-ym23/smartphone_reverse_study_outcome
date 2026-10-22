package com.ss.videoarch.strategy.network;

import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.LibraryLoader;
import com.ss.videoarch.strategy.utils.VeLSUtils;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class VeLSNetworkManager {
    static String TAG = "VeLSNetworkManager";
    private final ThreadPoolApi mThreadPoolApi;

    private native String nativeGetAbrAutoSettings();

    private native void nativeGetLSSettings();

    private native String nativeGetLSStrategySDKSettings();

    private native String nativeGetLivePlayerSettings();

    private native String nativeGetQuicSettings();

    private native String nativeGetRTMPlayer();

    private native String nativeGetStrategyConfig();

    private native String nativeGetStrategyConfigByName(String r100, String r101);

    private native void nativeStartPeriodicRequest();

    static {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L6;
        VeLSUtils.setLoadSoSuccess(loadLibrary("livestrategy"));
        return;
    }

    public VeLSNetworkManager() {
        this.mThreadPoolApi = new ThreadPoolApi();
    }

    public String GetAbrAutoSettings() {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L7;
        return "";
    L7:
        return nativeGetAbrAutoSettings();
    }

    public void GetLSSettings() {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return;
    L5:
        nativeGetLSSettings();
    }

    public String GetLSStrategySDKSettings() {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L7;
        return "";
    L7:
        return nativeGetLSStrategySDKSettings();
    }

    public String GetLivePlayerSettings() {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L7;
        return "";
    L7:
        return nativeGetLivePlayerSettings();
    }

    public String GetQuicSettings() {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L7;
        return "";
    L7:
        return nativeGetQuicSettings();
    }

    public String GetRTMPlayer() {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L7;
        return "";
    L7:
        return nativeGetRTMPlayer();
    }

    public String GetStrategyConfig() {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L7;
        return "";
    L7:
        return nativeGetStrategyConfig();
    }

    public void StartPeriodicRequest() {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return;
    L5:
        this.mThreadPoolApi.execute(new AnonymousClass1(this));
    }

    public static /* synthetic */ void access$000(VeLSNetworkManager r100) {
        r100.nativeStartPeriodicRequest();
    }

    private static boolean loadLibrary(String r100) {
        LibraryLoader.loadLibrary(r100);     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        th.getMessage();
        return false;
    }

    public void init(LSSDKConfig r100) {
        VeLSNetworkManagerImpl.getInstance().init(r100);
    }

    public String getStrategyConfigByName(String r100, String r101) {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L7;
        return "";
    L7:
        return nativeGetStrategyConfigByName(r100, r101);
    }
}
