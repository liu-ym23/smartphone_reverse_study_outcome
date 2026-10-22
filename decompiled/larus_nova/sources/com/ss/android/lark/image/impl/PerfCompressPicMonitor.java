package com.ss.android.lark.image.impl;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.statistics.Statistics;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public class PerfCompressPicMonitor {
    public static void sendCompressPicFailedToTea() {
        Statistics.sendEvent("lark_android_compress_pic", new JSONObject().put("compress_succ", OfficeSDKRequestTag.KEY_NEW_USER));     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ void access$000(Map r100) {
        sendCompressPicSuccToTea(r100);
    }

    private static void sendCompressPicSuccToTea(Map<String, Float> r100) {
        JSONObject r101 = new JSONObject();
        r101.put("compress_succ", "y");     // Catch: JSONException -> L8
        Iterator<Map.Entry<String, Float>> r102 = r100.entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, Float> r103 = r102.next();     // Catch: JSONException -> L8
        r101.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L8
    L10:
        Statistics.sendEvent("lark_android_compress_pic", r101);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static void reportCompressEvent(final long r100, final String r101, final String r102) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new AnonymousClass1(r101, r102, r100));
    }
}
