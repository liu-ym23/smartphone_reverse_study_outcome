package com.bytedance.bdp.bdpbase.core;

import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public interface BdpAppStatusListener {
    void onAppConfigDataReady(JSONObject r100);

    void onAppCreate(IBdpAppInstance r100);

    void onAppExit(int r100);

    boolean onAppFallback(String r100);

    void onCustomEvent(String r100, Bundle r101);

    void onLaunchFinish(int r100, String r101, Bundle r102);

    void onLaunchProgress(int r100);

    void onMetaReady(JSONObject r100);

    BdpStartUpParam onPluginInstalled(BdpStartUpParam r100);

    void onScreenStateChange(int r100);
}
