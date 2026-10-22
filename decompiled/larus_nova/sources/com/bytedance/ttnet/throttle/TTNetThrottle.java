package com.bytedance.ttnet.throttle;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;

/* JADX INFO: loaded from: classes22.dex */
public class TTNetThrottle {
    public static final int DIRECTION_TYPE_DOWN = 2;
    public static final int DIRECTION_TYPE_PC_DOWN = 8;
    public static final int DIRECTION_TYPE_PC_UP = 4;
    public static final int DIRECTION_TYPE_UP = 1;
    private static final String TAG = "TTNetThrottle";

    public TTNetThrottle() {
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Throwable {
        if (HttpClient.isCronetClientEnable() == false) goto L7;
        return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    public static void stop(String[] r100, int r101) {
        if (r100 == null) goto L18;
        if (r101 != 1) goto L6;
    L21:
        getCronetHttpClient().stopThrottle(r100, r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (r101 == 2) goto L21;
        if (r101 == 4) goto L21;
        if (r101 == 8) goto L21;
    L18:
        if (Logger.debug() == false) goto L24;
        Logger.e(TAG, "stop throttle params error hosts:" + r100 + " directionType:" + r101);
        return;
    }

    public static void start(String[] r100, int r101, long r102) {
        if (r100 == null) goto L20;
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L12;
        if (r101 == 4) goto L12;
        if (r101 != 8) goto L20;
    L12:
        if (r102 < 0) goto L20;
        getCronetHttpClient().startThrottle(r100, r101, r102);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L20:
        if (Logger.debug() == false) goto L26;
        Logger.e(TAG, "start throttle params error hosts:" + r100 + " directionType:" + r101 + " bytesPerSec:" + r102);
        return;
    }
}
