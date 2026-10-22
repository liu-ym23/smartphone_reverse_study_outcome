package com.ttnet.org.chromium.base;

import android.os.StrictMode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
@MainDex
class TimezoneUtils {
    private TimezoneUtils() {
    }

    private static String getDefaultTimeZoneId() {
        StrictMode.ThreadPolicy r100 = StrictMode.allowThreadDiskReads();
        String r101 = TimeZone.getDefault().getID();
        StrictMode.setThreadPolicy(r100);
        return r101;
    }
}
