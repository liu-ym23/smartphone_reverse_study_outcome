package com.bytedance.bdp.bdpbase.core;

/* JADX INFO: loaded from: classes11.dex */
public interface BdpPluginStateListener {
    void onFailed(BdpError r100);

    void onSucceed(boolean r100, long r101);
}
