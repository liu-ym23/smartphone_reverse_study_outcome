package com.bytedance.common.utility;

/* JADX INFO: loaded from: classes6.dex */
public class NetClientChecker {
    public static boolean isNetworkClientSet() {
        return !(NetworkClient.getDefault() instanceof DummyNetworkClient);
    }
}
