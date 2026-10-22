package com.bytedance.ttnet;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class TTReportAllLog {
    private static final int INVALID_DEFAULT_CODE = Integer.MAX_VALUE;
    private static final String LOG_TYPE = "ttnet_all_log";
    private static final String TAG = "TTReportAllLog";

    public TTReportAllLog() {
    }

    public static void reportInternalAllLog(String r100, JSONObject r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        reportInternalAllLog(r100, r101, Integer.MAX_VALUE, null);
    }

    public static void reportInternalAllLog(String r100, JSONObject r101, int r102, String r103) {
        ITTNetDepend r104 = TTNetInit.getTTNetDepend();     // Catch: Throwable -> L15
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L15
        r105.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_TYPE, r100);     // Catch: Throwable -> L15
        if (r102 == Integer.MAX_VALUE) goto L6;
        r105.put("code", r102);     // Catch: Throwable -> L15
    L6:
        if (TextUtils.isEmpty(r103) == true) goto L8;
        r105.put("message", r103);     // Catch: Throwable -> L15
    L8:
        if (r101 == null) goto L11;
        r105.put("detail_log", r101);     // Catch: Throwable -> L15
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, r105.toString());     // Catch: Throwable -> L15
    L13:
        r104.monitorLogSend(LOG_TYPE, r105);     // Catch: Throwable -> L15
        return;
    }
}
