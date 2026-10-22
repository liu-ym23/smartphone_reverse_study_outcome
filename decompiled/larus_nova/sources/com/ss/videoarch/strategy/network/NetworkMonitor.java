package com.ss.videoarch.strategy.network;

import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseLogInfo;

/* JADX INFO: loaded from: classes38.dex */
public class NetworkMonitor implements INetworkMonitor {
    public NetworkMonitor() {
    }

    @Override // com.ss.videoarch.strategy.network.INetworkMonitor
    public int getNetworkType() {
        BaseLogInfo.inst();
        return SDKMonitorUtils.getInstance(BaseLogInfo.REAL_SDK_APP_ID).getNetWorkType();
    }

    @Override // com.ss.videoarch.strategy.network.INetworkMonitor
    public String getStringNetworkType() {
        int r100 = getNetworkType();
        if (r100 != 1) goto L5;
        String r101 = "mobile";
    L19:
        return r101.toUpperCase();
    L5:
        if (r100 != 2) goto L7;
        r101 = CJPayBasicUtils.NETWORK_2G;
        goto L19
    L7:
        if (r100 != 3) goto L9;
        r101 = CJPayBasicUtils.NETWORK_3G;
        goto L19
    L9:
        if (r100 != 4) goto L11;
        r101 = "wifi";
        goto L19
    L11:
        if (r100 == 5) goto L13;
        r101 = UserProfileEvent.POSITION_NONE;
        goto L19
    L13:
        r101 = CJPayBasicUtils.NETWORK_4G;
        goto L19
    }
}
