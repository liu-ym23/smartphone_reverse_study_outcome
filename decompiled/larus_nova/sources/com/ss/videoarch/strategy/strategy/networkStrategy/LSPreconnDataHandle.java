package com.ss.videoarch.strategy.strategy.networkStrategy;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class LSPreconnDataHandle {
    static final String TAG = "LiveStrategyManager";

    public static class LiveStartOptToggles {
        public String LSEngineParamJson;
        public int UseLSQUIC;
        public boolean enableLiveStartingOpt;
        public String enableNetworkClass;
        public int enableSuggestSendingRate;
        public String httpConfigJson;
        public String networkType;
        public int suggestSendingRate;

        public LiveStartOptToggles() {
            this.enableLiveStartingOpt = false;
            this.enableNetworkClass = "0";
            this.enableSuggestSendingRate = 0;
            this.httpConfigJson = "";
            this.suggestSendingRate = 0;
            this.networkType = UserProfileEvent.POSITION_NONE;
            this.UseLSQUIC = 0;
            this.LSEngineParamJson = "";
        }
    }

    public static class PreconnToggles {
        public int enablePrecreate;
        public boolean enableTTQuicH2Q;
        public int getPreconnIpTimeout;
        public int maxRetryTimes;
        public int socketIdleTimeoutMs;

        public PreconnToggles() {
            this.maxRetryTimes = 3;
            this.enableTTQuicH2Q = true;
            this.socketIdleTimeoutMs = 0;
            this.getPreconnIpTimeout = 0;
            this.enablePrecreate = 0;
        }
    }

    public LSPreconnDataHandle() {
    }

    private native String nativeGetPreconnectIp(String r100);

    private native int nativeSetLSConnectToggles(int r100, boolean r101, int r102, int r103, int r104);

    private native int nativeSetLiveStartOptToggles(boolean r100, String r101, int r102, String r103, String r104, int r105, int r106, String r107);

    public String getPreconnIp(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        if (VeLSUtils.isLoadSoSuccess() == true) goto L8;
        return "";
    L8:
        return nativeGetPreconnectIp(r100);
    }

    public void setLSConnectToggles(PreconnToggles r100) {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return;
    L5:
        nativeSetLSConnectToggles(r100.maxRetryTimes, r100.enableTTQuicH2Q, r100.socketIdleTimeoutMs, r100.getPreconnIpTimeout, r100.enablePrecreate);
    }

    public void setLiveStartOptToggles(LiveStartOptToggles r110) {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return;
    L5:
        nativeSetLiveStartOptToggles(r110.enableLiveStartingOpt, r110.enableNetworkClass, r110.enableSuggestSendingRate, r110.httpConfigJson, r110.networkType, r110.suggestSendingRate, r110.UseLSQUIC, r110.LSEngineParamJson);
    }
}
