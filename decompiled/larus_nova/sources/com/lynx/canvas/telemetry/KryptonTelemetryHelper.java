package com.lynx.canvas.telemetry;

import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonTelemetryHelper {
    private static final String SEPARATOR_PARAM = ",";
    private static final String TAG = "KryptonTelemetryHelper";

    public KryptonTelemetryHelper() {
    }

    public static void reportEvent(KryptonApp r100, String r101, String r102) {
        KryptonTelemetryService r103 = (KryptonTelemetryService) r100.getService(KryptonTelemetryService.class);
        if (r103 != null) goto L6;
        KryptonLLog.e(TAG, "no service found");
        return;
    L6:
        HashMap r104 = new HashMap();
        if (r102 != null) goto L9;
    L18:
        r103.reportEvent(r101, r104);
        return;
    L9:
        if (r102.isEmpty() == true) goto L18;
        String[] r105 = r102.split(",");
        if ((r105.length % 2) != 0) goto L16;
        int r106 = 0;
    L14:
        if (r106 >= r105.length) goto L18;
        r104.put(r105[r106], r105[r106 + 1]);
        r106 = r106 + 2;
        goto L14
    L16:
        KryptonLLog.e(TAG, "params format error, length should be even");
    }
}
