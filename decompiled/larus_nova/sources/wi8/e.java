package wi8;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.n2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f559860a = 0;

    static {
    }

    public e() {
    }

    public static /* synthetic */ void b(boolean r110, String r111, boolean r112, String r113, String r114, boolean r115, boolean r116, String r210, String r211, by7.e r212, int r213) {
        if ((r213 & 256) == 0) goto L5;
        String r100 = "click_tts_button";
    L6:
        a(r110, r111, r112, r113, r114, r115, r116, r210, r100, null, null, r212);
        return;
    L5:
        r100 = r211;
        goto L6
    }

    public static void a(boolean r210, String r211, boolean r212, String r213, String r214, boolean r215, boolean r216, String r217, String r218, Long r219, Long r310, by7.e r311) {
        Intrinsics.checkNotNullParameter(r211, "botId");
        Intrinsics.checkNotNullParameter(r213, "conversationId");
        Intrinsics.checkNotNullParameter(r214, "chatType");
        String r100 = r218;
        Intrinsics.checkNotNullParameter(r100, "ttsOpenMethod");
        long r101 = -1;
        if (r212 == false) goto L5;
        long r110 = -1;
    L8:
        if (r212 == true) goto L11;
        r101 = 1 - r110;
    L11:
        String r102 = "1";
        if (r215 == false) goto L14;
        Object r111 = "1";
    L15:
        if (r310 == null) goto L17;
        long r112 = r310.longValue();
    L18:
        Long r113 = Long.valueOf(r112);
        if (r219 == null) goto L21;
        r101 = r219.longValue();
    L21:
        Long r103 = Long.valueOf(r101);
        Long r104 = 1L;
        Boolean r114 = Boolean.valueOf(r216);
        Integer r115 = Integer.valueOf(n2.a());
        if (r310 == null) goto L25;
        r110 = r310.longValue();
    L25:
        if (r110 == 1) goto L28;
        r100 = "";
    L28:
        JSONObject r116 = new JSONObject();
        Intrinsics.checkNotNullParameter(r116, "params");
        r116.put("bot_id", r211);     // Catch: JSONException -> L55
        if (r113 == null) goto L33;
        r116.put("status", r113.longValue());     // Catch: JSONException -> L55
    L33:
        if (r103 == null) goto L35;
        r116.put("from_status", r103.longValue());     // Catch: JSONException -> L55
    L35:
        r116.put("conversation_id", r213);     // Catch: JSONException -> L55
        if (r104 == null) goto L38;
        r116.put("bot_cnt", r104.longValue());     // Catch: JSONException -> L55
    L38:
        r116.put("group_type", BridgePrivilege.PRIVATE);     // Catch: JSONException -> L55
        if (r214 == null) goto L41;
        r116.put("chat_type", r214);     // Catch: JSONException -> L55
    L41:
        r116.put("is_message_generating", r111);     // Catch: JSONException -> L55
        if (r217 == null) goto L44;
        r116.put("enter_method", r217);     // Catch: JSONException -> L55
    L44:
        if (r115 == null) goto L46;
        r116.put("tts_speaker_volume", r115.intValue());     // Catch: JSONException -> L55
    L46:
        if (r100 == null) goto L48;
        r116.put("tts_open_method", r100);     // Catch: JSONException -> L55
    L48:
        if (r114 != null) goto L50;
    L57:
        TrackParams r105 = new TrackParams().merge(r116);
        by7.a r106 = new by7.a("click_tts_switch");
        if (r311 == null) goto L60;
        r106.f21464b = r311;
    L60:
        r106.f21463a.merge(r105);
        r106.b();
        g.f365738a.monitorEventForSlardar("click_tts_switch", r106.c(), null, null);
        return;
    L50:
        if (r114.booleanValue() == true) goto L53;
        r102 = "0";
    L53:
        r116.put("is_thinking_generating", r102);     // Catch: JSONException -> L55
    L55:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickTtsSwitch " + e.getLocalizedMessage());
        goto L57
    L17:
        r112 = r110;
        goto L18
    L14:
        r111 = "0";
        goto L15
    L5:
        if (r210 == false) goto L7;
        r110 = 1;
        goto L8
    L7:
        r110 = 0;
        goto L8
    }
}
