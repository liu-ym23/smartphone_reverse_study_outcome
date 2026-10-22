package com.ss.android.lark.message.card.view;

import com.ss.android.lark.log.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class j {
    public static void a(String r100, JSONObject r101, JSONObject r102) {
        com.ss.android.lark.message.card.b.a().monitorEvent(r100, r101, r102, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("ReportUtil", e.getMessage());
    }
}
