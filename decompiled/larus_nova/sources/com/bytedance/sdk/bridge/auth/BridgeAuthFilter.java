package com.bytedance.sdk.bridge.auth;

import com.bytedance.sdk.bridge.BridgeMethodInfo;

/* JADX INFO: loaded from: classes22.dex */
public interface BridgeAuthFilter<T> {
    boolean doAuthFilter(T r100, BridgeMethodInfo r101, a<T> r102);
}
