package tx9;

import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class v {
    public static void a(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214, String r215, Boolean r216, Integer r217, Boolean r218, String r219, String r310, String r311, Boolean r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, Boolean r412, Boolean r413, Integer r414, String r415, String r416, Boolean r417, Boolean r418, TraceFragment r419) {
        JSONObject r116 = new JSONObject();
        Intrinsics.checkNotNullParameter(r116, "params");
        if (r110 != null) goto L95;
    L7:
        if (r111 == null) goto L9;
        r116.put("enter_method", r111);     // Catch: JSONException -> L5
    L9:
        r116.put("if_allow_search", r112);     // Catch: JSONException -> L5
        r116.put("if_auto_filled", r113);     // Catch: JSONException -> L5
        r116.put("if_generate_picture", r114);     // Catch: JSONException -> L5
        r116.put("if_has_voice", r115);     // Catch: JSONException -> L5
        r116.put("if_system_prompt_added", r210);     // Catch: JSONException -> L5
        r116.put(DocCallbackImpl.KEY_IS_EDITED, r211);     // Catch: JSONException -> L5
        if (r212 == null) goto L12;
        r116.put("previous_page", r212);     // Catch: JSONException -> L5
    L12:
        r116.put("profile_photo_type", r213);     // Catch: JSONException -> L5
        r116.put("create_way", r214);     // Catch: JSONException -> L5
        if (r215 == null) goto L15;
        r116.put("creation_id", r215);     // Catch: JSONException -> L5
    L15:
        String r100 = "0";
        if (r216 != null) goto L18;
    L22:
        if (r217 == null) goto L24;
        r116.put("sp_cnt", r217.intValue());     // Catch: JSONException -> L5
    L24:
        if (r218 != null) goto L26;
    L30:
        if (r219 == null) goto L32;
        r116.put("from_activity_name", r219);     // Catch: JSONException -> L5
    L32:
        if (r310 == null) goto L34;
        r116.put("from_activity_module", r310);     // Catch: JSONException -> L5
    L34:
        r116.put("image_type", r311);     // Catch: JSONException -> L5
        if (r312 != null) goto L37;
    L41:
        if (r313 == null) goto L43;
        r116.put("voice_id", r313);     // Catch: JSONException -> L5
    L43:
        if (r314 == null) goto L46;
        r116.put("voice_type", r314);     // Catch: JSONException -> L5
    L46:
        if (com.larus.utils.o0.d(r319) == false) goto L49;
        r116.put("suggested_prompt_add_type", r319);     // Catch: JSONException -> L5
    L49:
        if (com.larus.utils.o0.d(r410) == false) goto L52;
        r116.put("bio_add_type", r410);     // Catch: JSONException -> L5
    L52:
        if (com.larus.utils.o0.d(r411) == false) goto L54;
        r116.put("onboarding_add_type", r411);     // Catch: JSONException -> L5
    L54:
        if (r412 != null) goto L56;
    L60:
        if (r413 != null) goto L62;
    L66:
        if (r414 == null) goto L68;
        r116.put("polish_cnt", String.valueOf(r414.intValue()));     // Catch: JSONException -> L5
    L68:
        if (r415 == null) goto L70;
        r116.put("polish_status", r415);     // Catch: JSONException -> L5
    L70:
        if (r416 == null) goto L72;
        r116.put("private_status", r416);     // Catch: JSONException -> L5
    L72:
        if (r417 == null) goto L80;
        boolean r101 = r417.booleanValue();     // Catch: JSONException -> L5
        if (Intrinsics.areEqual(r415, "1") == false) goto L80;
        if (r101 == false) goto L78;
        Object r102 = "1";
    L79:
        r116.put("if_polish_use_internet", r102);     // Catch: JSONException -> L5
        goto L80
    L78:
        r102 = "0";
    L80:
        if (r418 == null) goto L87;
        boolean r103 = r418.booleanValue();     // Catch: JSONException -> L5
        if (Intrinsics.areEqual(r113, "1") == false) goto L87;
        if (r103 == false) goto L86;
        r100 = "1";
    L86:
        r116.put("if_auto_fill_use_internet", r100);     // Catch: JSONException -> L5
    L87:
        r116.putOpt("name_add_type", r315).putOpt("sp_add_type", r316).putOpt("profile_photo_add_type", r317).putOpt("voice_add_type", r318);     // Catch: JSONException -> L5
    L90:
        TrackParams r104 = new TrackParams().merge(r116);
        by7.a r105 = new by7.a("cancel_create_new_bot");
        if (r419 == null) goto L93;
        r105.f21464b = r419;
    L93:
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("CancelEventHelper", "error in CancelEventHelper cancelCreateNewBot " + e.getLocalizedMessage());
        goto L90
    L62:
        if (r413.booleanValue() == false) goto L64;
        Object r106 = "1";
    L65:
        r116.put("if_polish", r106);     // Catch: JSONException -> L5
        goto L66
    L64:
        r106 = "0";
        goto L65
    L56:
        if (r412.booleanValue() == false) goto L58;
        Object r107 = "1";
    L59:
        r116.put("if_has_bio", r107);     // Catch: JSONException -> L5
        goto L60
    L58:
        r107 = "0";
        goto L59
    L37:
        if (r312.booleanValue() == false) goto L39;
        Object r108 = "1";
    L40:
        r116.put("background_status", r108);     // Catch: JSONException -> L5
        goto L41
    L39:
        r108 = "0";
        goto L40
    L26:
        if (r218.booleanValue() == false) goto L28;
        Object r109 = "1";
    L29:
        r116.put("sp_status", r109);     // Catch: JSONException -> L5
        goto L30
    L28:
        r109 = "0";
        goto L29
    L18:
        if (r216.booleanValue() == false) goto L20;
        Object r117 = "1";
    L21:
        r116.put("if_has_onboarding", r117);     // Catch: JSONException -> L5
        goto L22
    L20:
        r117 = "0";
        goto L21
    L95:
        r116.put("enter_from", r110);     // Catch: JSONException -> L5
        goto L7
    }
}
