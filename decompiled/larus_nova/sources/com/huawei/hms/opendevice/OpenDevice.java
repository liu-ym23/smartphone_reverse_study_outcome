package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.utils.Checker;

/* JADX INFO: loaded from: classes23.dex */
public class OpenDevice {
    private OpenDevice() {
    }

    public static OpenDeviceClient getOpenDeviceClient(Context r100) {
        Checker.assertNonNull(r100);
        return new OpenDeviceClientImpl(r100);
    }
}
