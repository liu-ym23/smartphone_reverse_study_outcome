package com.bytedance.bdp.bdpbase.core;

import android.os.Bundle;
import com.bytedance.bdp.bdpbase.core.container.BdpAppContainer;

/* JADX INFO: loaded from: classes11.dex */
public interface IBdpAppInstance {
    void addEventListener(String r100, BdpAppInstanceEventListener r101);

    Bundle executeCommand(String r100, Bundle r101) throws Throwable;

    void executeCommandAsync(String r100, Bundle r101, BdpResultListener<Bundle> r102);

    void finish();

    BdpAppContainer getAppContainer();

    String getSchema();

    void removeEventListener(String r100, BdpAppInstanceEventListener r101);

    void sendCustomEvent(String r100, Bundle r101);
}
