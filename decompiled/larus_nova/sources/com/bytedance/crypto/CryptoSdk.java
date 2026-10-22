package com.bytedance.crypto;

import com.bytedance.crypto.bridge.IEventBridge;
import com.bytedance.crypto.bridge.ILogBridge;
import com.bytedance.crypto.utils.EventUtils;
import com.bytedance.crypto.utils.LogUtils;

/* JADX INFO: loaded from: classes6.dex */
public class CryptoSdk {
    public CryptoSdk() {
    }

    public static void initEventReporter(IEventBridge r100) {
        EventUtils.init(r100);
    }

    public static void initLogger(ILogBridge r100) {
        LogUtils.init(r100);
    }
}
