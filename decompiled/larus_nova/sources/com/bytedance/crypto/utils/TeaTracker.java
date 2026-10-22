package com.bytedance.crypto.utils;

import com.bytedance.crypto.bridge.ITeaBridge;

/* JADX INFO: loaded from: classes15.dex */
public class TeaTracker {
    private static final String TAG = "TeaTracker";
    private static ITeaBridge mTeaBridge;

    public TeaTracker() {
    }

    public static String getDeviceId() {
        ITeaBridge r100 = mTeaBridge;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.onGetDeviceId();
    }

    public static void init(ITeaBridge r100) {
        mTeaBridge = r100;
    }
}
