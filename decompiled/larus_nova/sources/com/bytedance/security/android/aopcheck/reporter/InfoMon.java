package com.bytedance.security.android.aopcheck.reporter;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.security.android.aopcheck.utils.LogPrint;
import com.bytedance.security.android.aopcheck.utils.ThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class InfoMon {
    public InfoMon() {
    }

    public static void doPathTraversalReport(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L14
        r103.put(MapBundleKey.OfflineMapKey.OFFLINE_CHILD, r100);     // Catch: JSONException -> L14
        r103.put("parent", r101);     // Catch: JSONException -> L14
        StackTraceElement[] r104 = ThreadMethodProxy.currentThread().getStackTrace();     // Catch: JSONException -> L14
        StringBuffer r105 = new StringBuffer();     // Catch: JSONException -> L14
        int r106 = r104.length;     // Catch: JSONException -> L14
        int r107 = 0;
        int r108 = 0;
    L3:
        if (r107 >= r106) goto L12;
        StackTraceElement r109 = r104[r107];     // Catch: JSONException -> L14
        if (r108 >= 3) goto L8;
        r108 = r108 + 1;     // Catch: JSONException -> L14
    L11:
        r107 = r107 + 1;     // Catch: JSONException -> L14
        goto L3
    L8:
        if (r105.length() <= 0) goto L10;
        r105.append(System.getProperty("line.separator"));     // Catch: JSONException -> L14
    L10:
        r105.append(r109.toString());     // Catch: JSONException -> L14
        goto L11
    L12:
        final AOPReportEvent r110 = new AOPReportEvent(r102, System.currentTimeMillis(), r103.toString(), r105.toString());     // Catch: JSONException -> L14
        ThreadPool.getDefaultThreadPool().execute(new AnonymousClass1(r110));     // Catch: JSONException -> L14
        LogPrint.d("AOPReportEvent: " + r110);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        LogPrint.printStackTrace(e);
    }
}
