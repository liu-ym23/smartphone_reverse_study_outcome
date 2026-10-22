package com.bytedance.badger.collect.impl.network.interfaces;

import android.net.Network;

/* JADX INFO: loaded from: classes47.dex */
public interface INetworkTypeSwitchCallback {
    void onComplete(Network r100);

    void onError(Exception r100);
}
