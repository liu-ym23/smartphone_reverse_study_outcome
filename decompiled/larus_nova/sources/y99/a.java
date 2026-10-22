package y99;

import by7.e;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class a {
    public static final void a(String r100, JSONObject r101, e r102) {
        TrackParams r103 = new TrackParams().merge(r101);
        by7.a r104 = new by7.a(r100);
        if (r102 == null) goto L5;
        r104.f21464b = r102;
    L5:
        r104.f21463a.merge(r103);
        r104.b();
    }

    public static final void d(JSONObject r100, String r101, String r102) throws JSONException {
        if (r102 == null) goto L5;
        r100.put(r101, r102);
        return;
    }

    public static void b(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        d(r105, "click", r100);     // Catch: JSONException -> L5
        d(r105, "ai_reply_user_type", r101);     // Catch: JSONException -> L5
        d(r105, "ai_msg_id", r102);     // Catch: JSONException -> L5
        d(r105, "chat_id", r103);     // Catch: JSONException -> L5
        d(r105, NoticeInfo.KEY_REPLY_ID, r104);     // Catch: JSONException -> L5
    L7:
        a("flow_doc_im_chat_box_ai_reply_click", r105, null);
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("SmartReplyEventHelper", "error in SmartReplyEventHelper mobFlowDocImChatBoxAiReplyClick " + e.getLocalizedMessage());
        goto L7
    }

    public static void c(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        d(r105, "click", r100);     // Catch: JSONException -> L5
        d(r105, "ai_reply_user_type", r101);     // Catch: JSONException -> L5
        d(r105, "ai_msg_id", r102);     // Catch: JSONException -> L5
        d(r105, NoticeInfo.KEY_REPLY_ID, r103);     // Catch: JSONException -> L5
        d(r105, "chat_id", r104);     // Catch: JSONException -> L5
    L7:
        a("flow_doc_im_chat_box_ai_reply_detail_click", r105, null);
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("SmartReplyEventHelper", "error in SmartReplyEventHelper mobFlowDocImChatBoxAiReplyDetailClick " + e.getLocalizedMessage());
        goto L7
    }
}
