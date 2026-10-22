package com.ss.videoarch.live.ttquic;

import android.os.Build;

/* JADX INFO: loaded from: classes38.dex */
class TTUtils {
    public static final int DISABLE = 0;
    public static final int ENABLE = 1;
    public static final String LOG_TAG = "tt_preload";

    public TTUtils() {
    }

    public static int sdk_int() {
        return Build.VERSION.SDK_INT;
    }
}
