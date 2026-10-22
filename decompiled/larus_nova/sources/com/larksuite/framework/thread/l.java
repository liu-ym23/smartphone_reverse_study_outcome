package com.larksuite.framework.thread;

import com.ss.android.lark.log.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class l {
    public static JSONObject a(String r100, String r101, long r102, long r103, long r104, long r110) {
        JSONObject r105 = new JSONObject();
        r105.put("taskname", r100);     // Catch: Exception -> L13
        r105.put("poolname", r101);     // Catch: Exception -> L13
        r105.put("run_time", r103);     // Catch: Exception -> L13
        r105.put("maxruntime", r110);     // Catch: Exception -> L13
        if (r103 <= r110) goto L7;
        r105.put("overruntaskname", r100);     // Catch: Exception -> L13
    L7:
        if (r104 <= 0) goto L11;
        r105.put("poolqueuewaittime", r102);     // Catch: Exception -> L13
        r105.put("maxdispatchtime", r104);     // Catch: Exception -> L13
        if (r102 <= r104) goto L11;
        r105.put("overwaittaskname", r100);     // Catch: Exception -> L13
    L11:
        r105.put("appbacktask", CoreThreadPool.sAppFront);     // Catch: Exception -> L13
    L14:
        return r105;
    L13:
        Log.e("CoreTaskMonitor", "genTaskEvent gen json failed");
        goto L14
    }
}
