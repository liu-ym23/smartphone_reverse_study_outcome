package com.xiaomi.NetworkBoost;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public abstract class MiuiNetworkCallback extends IAIDLMiuiNetworkCallback.Stub implements IAIDLMiuiNetQoECallback, IAIDLMiuiNetSelectCallback, IAIDLMiuiWlanQoECallback {
    public MiuiNetworkCallback() {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetSelectCallback
    public void avaliableBssidCb(List<String> r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetSelectCallback
    public void connectionStatusCb(int r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
    public void dsdaStateChanged(boolean r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
    public void ifaceAdded(List<String> r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
    public void ifaceRemoved(List<String> r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetQoECallback
    public void masterQoECallBack(NetLinkLayerQoE r100) {
    }

    public void mediaPlayerPolicyNotify(int r100, int r101, int r102) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
    public void onNetworkPriorityChanged(int r100, int r101, int r102) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
    public void onScanSuccussed(int r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
    public void onSetSlaveWifiResult(boolean r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
    public void onSlaveWifiConnected(boolean r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
    public void onSlaveWifiDisconnected(boolean r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
    public void onSlaveWifiEnable(boolean r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkCallback
    public void onSlaveWifiEnableV1(int r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetQoECallback
    public void slaveQoECallBack(NetLinkLayerQoE r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiWlanQoECallback
    public void wlanQoEReportUpdateMaster(Map<String, String> r100) {
    }

    @Override // com.xiaomi.NetworkBoost.IAIDLMiuiWlanQoECallback
    public void wlanQoEReportUpdateSlave(Map<String, String> r100) {
    }
}
