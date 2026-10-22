package com.larus.voicecall.impl.component.feedback;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class v {
    public static void b(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != null) goto L10;
    L8:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("call_feedback_popup_show");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L10:
        r101.put("call_id", r100);     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.f375446a.e("RealtimeFeedbackTracer", "error in mobCallFeedbackPopupShow " + e.getLocalizedMessage());
        goto L8
    }

    public static void a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 != null) goto L12;
    L7:
        r102.put("click_from", r101);     // Catch: JSONException -> L5
    L10:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("call_feedback_popup_click");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("RealtimeFeedbackTracer", "error in mobCallFeedbackPopupClick " + e.getLocalizedMessage());
        goto L10
    L12:
        r102.put("call_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void c(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("call_id", r100);     // Catch: JSONException -> L8
        r103.put("click_from", r101);     // Catch: JSONException -> L8
        if (r102 == null) goto L6;
        r103.put(MusicAppletPage.KEY_MESSAGE_ID, r102);     // Catch: JSONException -> L8
    L6:
        r103.put("click_module", "call_subtitle");     // Catch: JSONException -> L8
    L10:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("complete_dislike_reason");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("RealtimeFeedbackTracer", "error in mobCompleteDislikeReason " + e.getLocalizedMessage());
        goto L10
    }
}
