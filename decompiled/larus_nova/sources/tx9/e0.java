package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class e0 {
    public static void b(Long r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != null) goto L10;
    L8:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("delete_own_voice_result");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L10:
        r101.put("success", r100.longValue());     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.f375446a.e("CloneVoiceEventHelper", "error in CloneVoiceEventHelper refreshBotResult " + e.getLocalizedMessage());
        goto L8
    }

    public static void c(Long r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != null) goto L10;
    L8:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("edit_own_voice_name_result");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L10:
        r101.put("success", r100.longValue());     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.f375446a.e("CloneVoiceEventHelper", "error in CloneVoiceEventHelper refreshBotResult " + e.getLocalizedMessage());
        goto L8
    }

    public static void a(String r100, Long r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 != null) goto L13;
    L7:
        if (r101 == null) goto L11;
        r102.put("success", r101.longValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("CloneVoiceEventHelper", "error in CloneVoiceEventHelper refreshBotResult " + e.getLocalizedMessage());
    L11:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("check_own_voice_result");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L13:
        r102.put("previous_page", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
