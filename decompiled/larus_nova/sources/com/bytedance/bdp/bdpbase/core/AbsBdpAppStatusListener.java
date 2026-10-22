package com.bytedance.bdp.bdpbase.core;

import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public abstract class AbsBdpAppStatusListener implements BdpAppStatusListener {
    public AbsBdpAppStatusListener() {
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public void onAppConfigDataReady(JSONObject r100) {
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public void onAppCreate(IBdpAppInstance r100) {
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public void onAppExit(int r100) {
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public boolean onAppFallback(String r100) {
        return false;
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public void onCustomEvent(String r100, Bundle r101) {
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public void onLaunchFinish(int r100, String r101, Bundle r102) {
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public void onLaunchProgress(int r100) {
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public void onMetaReady(JSONObject r100) {
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public BdpStartUpParam onPluginInstalled(BdpStartUpParam r100) {
        return null;
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public void onScreenStateChange(int r100) {
    }
}
