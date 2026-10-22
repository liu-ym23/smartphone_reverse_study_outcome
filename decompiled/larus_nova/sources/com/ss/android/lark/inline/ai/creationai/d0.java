package com.ss.android.lark.inline.ai.creationai;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.log.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f427055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f427056b = 0;

    public static final class a {
        public static void a(Integer r100, String r101, int r102) {
            JSONObject r103 = new JSONObject();     // Catch: Exception -> L4
            r103.put("errCode", r100);     // Catch: Exception -> L4
            r103.put("errReason", r101);     // Catch: Exception -> L4
            r103.put(ChameleonOpenTracker.ParamKey.COST, r102);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Log.e("CreationAIReport", "Exception: " + e);
        }
    }

    static {
    }
}
