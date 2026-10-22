package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f430002a = 0;

    static {
    }

    public static void a(String r100, Pair... r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L7
        int r103 = r101.length;     // Catch: Exception -> L7
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        Pair r105 = r101[r104];     // Catch: Exception -> L7
        r102.put((String) r105.getFirst(), r105.getSecond());     // Catch: Exception -> L7
        r104 = r104 + 1;     // Catch: Exception -> L7
        goto L3
    L5:
        Statistics.sendEvent(r100, r102);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.e("AudioHitPointUtil", "sendHitPoint / event: " + r100 + ", error: " + e);
    }
}
