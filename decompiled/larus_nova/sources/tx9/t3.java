package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class t3 {
    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, Integer r111, String r112, String r113, JSONObject r114, int r115) {
        if ((r115 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r115 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r115 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r115 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r115 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r115 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r115 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r115 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r115 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r115 & 512) == 0) goto L33;
        r111 = null;
    L33:
        if ((r115 & 1024) == 0) goto L36;
        r112 = null;
    L36:
        if ((r115 & 2048) == 0) goto L39;
        r113 = null;
    L39:
        if ((r115 & 4096) == 0) goto L41;
        r114 = new JSONObject();
    L41:
        Intrinsics.checkNotNullParameter(r114, "params");
        if (r100 != null) goto L72;
    L46:
        if (r101 == null) goto L48;
        r114.put("show_way", r101);     // Catch: JSONException -> L44
    L48:
        if (r102 == null) goto L50;
        r114.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r102);     // Catch: JSONException -> L44
    L50:
        if (r103 == null) goto L52;
        r114.put("chat_type", r103);     // Catch: JSONException -> L44
    L52:
        if (r104 == null) goto L54;
        r114.put("title", r104);     // Catch: JSONException -> L44
    L54:
        if (r105 == null) goto L56;
        r114.put("prompt_type", r105);     // Catch: JSONException -> L44
    L56:
        if (r106 == null) goto L58;
        r114.put("prompt_position", r106);     // Catch: JSONException -> L44
    L58:
        if (r107 == null) goto L60;
        r114.put("prompt_position_row", r107);     // Catch: JSONException -> L44
    L60:
        if (r110 == null) goto L62;
        r114.put("show_scene", r110);     // Catch: JSONException -> L44
    L62:
        if (r111 == null) goto L64;
        r114.put("attachment_cnt", r111.intValue());     // Catch: JSONException -> L44
    L64:
        if (r112 == null) goto L66;
        r114.put("bot_id", r112);     // Catch: JSONException -> L44
    L66:
        if (r113 == null) goto L70;
        r114.put("click_from", r113);     // Catch: JSONException -> L44
    L44:
        e = move-exception;
        FLogger.f375446a.e("SuggestedActionEventHelper", "error in SuggestedActionEventHelper mobAttachmentSuggestPromptClick " + e.getLocalizedMessage());
    L70:
        TrackParams r108 = new TrackParams().merge(r114);
        by7.a r109 = new by7.a("attachment_suggest_prompt_click");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L72:
        r114.put("current_page", r100);     // Catch: JSONException -> L44
        goto L46
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, Integer r111, String r112, String r113, JSONObject r114, int r115) {
        if ((r115 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r115 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r115 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r115 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r115 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r115 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r115 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r115 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r115 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r115 & 512) == 0) goto L33;
        r111 = null;
    L33:
        if ((r115 & 1024) == 0) goto L36;
        r112 = null;
    L36:
        if ((r115 & 2048) == 0) goto L39;
        r113 = null;
    L39:
        if ((r115 & 4096) == 0) goto L41;
        r114 = new JSONObject();
    L41:
        Intrinsics.checkNotNullParameter(r114, "params");
        if (r100 != null) goto L80;
    L46:
        if (r101 == null) goto L48;
        r114.put("show_way", r101);     // Catch: JSONException -> L44
    L48:
        if (r102 == null) goto L50;
        r114.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r102);     // Catch: JSONException -> L44
    L50:
        if (r103 == null) goto L52;
        r114.put("chat_type", r103);     // Catch: JSONException -> L44
    L52:
        if (r104 == null) goto L54;
        r114.put("title", r104);     // Catch: JSONException -> L44
    L54:
        if (r105 == null) goto L56;
        r114.put("prompt_type", r105);     // Catch: JSONException -> L44
    L56:
        if (r106 == null) goto L58;
        r114.put("prompt_position", r106);     // Catch: JSONException -> L44
    L58:
        if (r107 == null) goto L60;
        r114.put("prompt_position_row", r107);     // Catch: JSONException -> L44
    L60:
        if (r110 == null) goto L62;
        r114.put("show_scene", r110);     // Catch: JSONException -> L44
    L62:
        if (r111 == null) goto L64;
        r114.put("attachment_cnt", r111.intValue());     // Catch: JSONException -> L44
    L64:
        if (r112 == null) goto L66;
        r114.put("bot_id", r112);     // Catch: JSONException -> L44
    L66:
        if (r113 == null) goto L70;
        r114.put("click_from", r113);     // Catch: JSONException -> L44
    L44:
        e = move-exception;
        FLogger.f375446a.e("SuggestedActionEventHelper", "error in SuggestedActionEventHelper mobAttachmentSuggestPromptShow " + e.getLocalizedMessage());
    L70:
        TrackParams r108 = new TrackParams().merge(r114);
        by7.a r109 = new by7.a("attachment_suggest_prompt_show");
        r109.f21463a.merge(r108);
        r109.b();
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L73
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("attachment_suggest_prompt_show", r114, null, null);     // Catch: Throwable -> L73
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L73
    L75:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L84;
        FLogger.f375446a.e("SuggestedActionEventHelper", "slardar report error, attachmentSuggestPromptShow " + r118.getLocalizedMessage());
        return;
    L84:
        return;
    L73:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L75
    L80:
        r114.put("current_page", r100);     // Catch: JSONException -> L44
        goto L46
    }
}
