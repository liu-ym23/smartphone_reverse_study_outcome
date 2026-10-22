package com.larus.canvas.feature.component.logic.helper;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class d {
    public static void a(String r100, Integer r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.putOpt("canvas_id", r100);     // Catch: JSONException -> L5
        r102.putOpt("cnt_sub_canvas", r101);     // Catch: JSONException -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("click_close_ai_generate_canvas");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("mobClickCloseAIGenerateCanvas", "error: " + e.getLocalizedMessage());
        goto L7
    }
}
