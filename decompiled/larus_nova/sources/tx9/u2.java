package tx9;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class u2 {
    public static final void b(Integer r100, JSONObject r101, by7.e r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != null) goto L13;
    L8:
        TrackParams r103 = new TrackParams().merge(r101);
        by7.a r104 = new by7.a("finish_album_choose");
        if (r102 == null) goto L11;
        r104.f21464b = r102;
    L11:
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L13:
        r101.put("choose_cnt", r100.intValue());     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.f375446a.e("PictureEventHelper", "error in PictureEventHelper mobFinishAlbumChoose " + e.getLocalizedMessage());
        goto L8
    }

    public static void a(String r310, String r311, Boolean r312, Long r313, String r314, String r315, String r316, String r317, String r318, Boolean r319, int r410) {
        Boolean r100 = null;
        if ((r410 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r110 = null;
    L11:
        if ((r410 & 4) == 0) goto L13;
        Boolean r111 = null;
    L15:
        if ((r410 & 8) == 0) goto L17;
        Long r112 = null;
    L19:
        if ((r410 & 16) == 0) goto L21;
        String r113 = null;
    L23:
        if ((r410 & 32) == 0) goto L25;
        JSONObject r114 = new JSONObject();
    L27:
        if ((r410 & 512) == 0) goto L29;
        String r210 = null;
    L31:
        if ((r410 & 1024) == 0) goto L33;
        String r211 = null;
    L35:
        if ((r410 & 2048) == 0) goto L37;
        String r212 = null;
    L39:
        if ((r410 & 4096) == 0) goto L41;
        String r115 = "download_btn";
    L43:
        if ((r410 & 8192) != 0) goto L46;
        r100 = r319;
    L46:
        Intrinsics.checkNotNullParameter(r114, "params");
        Intrinsics.checkNotNullParameter(r115, "source");
        JSONObject r102 = new JSONObject(r114.toString());     // Catch: JSONException -> L49
    L50:
        JSONObject r116 = r102;
        String r103 = r101;
        String r320 = r115;
        String r213 = r101;
        JSONObject r104 = r114;
        e(r114, r103, r110, r111, r112, r113, null, null, r210, r211, r212, r115, r100);     // Catch: JSONException -> L53
        String r117 = "PictureEventHelper";
    L55:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("ai_creation_download_status");
        r106.f21463a.merge(r105);
        r106.b();
        Intrinsics.checkNotNullParameter(r116, "params");
        Intrinsics.checkNotNullParameter(r320, "source");
        String r107 = r117;
        e(r116, r213, r110, r111, r112, r113, null, null, r210, r211, r212, r320, r100);     // Catch: JSONException -> L58
    L60:
        TrackParams r108 = new TrackParams().merge(r116);
        by7.a r109 = new by7.a("ai_creation_download_complete");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L58:
        e = move-exception;
        FLogger.f375446a.e(r107, "error in PictureEventHelper mobAICreationDownloadComplete " + e.getLocalizedMessage());
    L53:
        e = move-exception;
        r117 = "PictureEventHelper";
        FLogger.f375446a.e(r117, "error in PictureEventHelper mobAICreationDownloadStatus " + e.getLocalizedMessage());
    L49:
        r102 = new JSONObject();
        goto L50
    L41:
        r115 = r318;
        goto L43
    L37:
        r212 = r317;
        goto L39
    L33:
        r211 = r316;
        goto L35
    L29:
        r210 = r315;
        goto L31
    L25:
        r114 = null;
        goto L27
    L21:
        r113 = r314;
        goto L23
    L17:
        r112 = r313;
        goto L19
    L13:
        r111 = r312;
        goto L15
    L9:
        r110 = r311;
        goto L11
    L5:
        r101 = r310;
        goto L7
    }

    public static final void e(JSONObject r110, String r111, String r112, Boolean r113, Long r114, String r115, Long r116, String r117, String r210, String r211, String r212, String r213, Boolean r214) {
        boolean r100 = true;
        String r101 = null;
        if (r210 != null) goto L5;
    L20:
        y0 r102 = null;
    L21:
        if (r111 == null) goto L23;
        r110.put(MusicAppletPage.KEY_MESSAGE_ID, r111);
    L23:
        if (r112 == null) goto L25;
        r110.put("creation_id", r112);
    L25:
        if (r113 == null) goto L27;
        r110.put("success", r113.booleanValue() ? 1 : 0);
    L27:
        if (r114 == null) goto L29;
        r110.put("duration", r114.longValue());
    L29:
        if (r115 == null) goto L31;
        r110.put("type", r115);
    L31:
        if (r116 != null) goto L35;
        if (r102 == null) goto L34;
        Long r103 = Long.valueOf(r102.f547915a);
    L36:
        if (r103 == null) goto L38;
        r110.put("file_size", r103.longValue());
    L38:
        if (r117 != null) goto L59;
        if (r102 == null) goto L41;
        String r104 = r102.f547916b;
    L42:
        if (r104 != null) goto L60;
        if (r210 != null) goto L45;
    L58:
        r104 = null;
        goto L60
    L45:
        if ((!StringsKt.isBlank(r210)) == false) goto L47;
        String r105 = r210;
    L48:
        if (r105 == null) goto L58;
        String r106 = StringsKt.substringBefore$default(r105, '?', null, 2, null);
        if (r106 == null) goto L58;
        String r107 = StringsKt.substringBefore$default(r106, '#', null, 2, null);
        if (r107 == null) goto L58;
        String r108 = StringsKt.substringAfterLast$default(r107, '/', null, 2, null);
        if (r108 == null) goto L58;
        r104 = StringsKt.substringAfterLast(r108, '.', "");
        if ((!StringsKt.isBlank(r104)) == false) goto L58;
    L47:
        r105 = null;
    L60:
        if (r104 == null) goto L62;
        r110.put("file_format", r104);
    L62:
        if (r211 == null) goto L64;
        r110.put("error_code", r211);
    L64:
        if (r212 != null) goto L70;
        if (r211 != null) goto L68;
        r100 = false;
    L68:
        if (r100 == false) goto L71;
        r101 = "download failed";
    L71:
        if (r101 == null) goto L73;
        r110.put("error_msg", r101);
    L73:
        if (r213 == null) goto L75;
        r110.put("source", r213);
    L75:
        if (r214 == null) goto L78;
        r110.put("mdl_cache_hit", r214.booleanValue() ? 1 : 0);
        return;
    L78:
        return;
    L70:
        r101 = r212;
        goto L71
    L41:
        r104 = null;
        goto L42
    L59:
        r104 = r117;
        goto L60
    L34:
        r103 = null;
        goto L36
    L35:
        r103 = r116;
        goto L36
    L5:
        if ((!StringsKt.isBlank(r210)) == false) goto L7;
        String r109 = r210;
    L8:
        if (r109 == null) goto L20;
        PolarisFileWrapper r118 = new PolarisFileWrapper(r109);
        if (r118.exists() == false) goto L20;
        if (r118.isFile() == false) goto L20;
        long r119 = r118.length();
        String r120 = FilesKt.getExtension(r118);
        if ((!StringsKt.isBlank(r120)) == true) goto L19;
        r120 = null;
    L19:
        r102 = new y0(r119, r120);
        goto L21
    L7:
        r109 = null;
        goto L8
    }

    public static void c(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, Boolean r216, Boolean r217, Boolean r218, String r219, JSONObject r310, String r311, int r312) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r312 & 512) == 0) goto L41;
        Boolean r114 = null;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        Boolean r115 = null;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Boolean r116 = null;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        String r117 = null;
    L55:
        if ((r312 & 16384) == 0) goto L57;
        JSONObject r118 = new JSONObject();
    L59:
        if ((r312 & 32768) == 0) goto L61;
        String r108 = null;
    L62:
        Intrinsics.checkNotNullParameter(r118, "params");
        if (r116 != null) goto L104;
    L67:
        String r119 = "0";
    L68:
        r118.putOpt("is_deep_thinking", r119);     // Catch: JSONException -> L100
        r118.putOpt("ai_create_show_mode", r117);     // Catch: JSONException -> L100
        if (r115 == null) goto L71;
        Integer r120 = Integer.valueOf(r115.booleanValue() ? 1 : 0);     // Catch: JSONException -> L100
    L72:
        r118.put("is_image_edit", r120);     // Catch: JSONException -> L100
        if (r100 == null) goto L75;
        r118.put("bot_id", r100);     // Catch: JSONException -> L100
    L75:
        if (r101 == null) goto L77;
        r118.put("conversation_id", r101);     // Catch: JSONException -> L100
    L77:
        if (r102 == null) goto L79;
        r118.put("is_onboarding", r102);     // Catch: JSONException -> L100
    L79:
        if (r103 == null) goto L81;
        r118.put("log_id", r103);     // Catch: JSONException -> L100
    L81:
        if (r104 == null) goto L83;
        r118.put(MusicAppletPage.KEY_MESSAGE_ID, r104);     // Catch: JSONException -> L100
    L83:
        if (r105 == null) goto L85;
        r118.put("original_content_source", r105);     // Catch: JSONException -> L100
    L85:
        if (r106 == null) goto L87;
        r118.put("pic_id", r106);     // Catch: JSONException -> L100
    L87:
        if (r107 == null) goto L89;
        r118.put("request_id", r107);     // Catch: JSONException -> L100
    L89:
        if (r113 == null) goto L91;
        r118.put("user_type", r113);     // Catch: JSONException -> L100
    L91:
        if (r108 == null) goto L93;
        r118.put("show_from", r108);     // Catch: JSONException -> L100
    L93:
        if (r114 != null) goto L95;
    L102:
        TrackParams r109 = new TrackParams().merge(r118);
        by7.a r121 = new by7.a("picture_message_show");
        r121.f21463a.merge(r109);
        r121.b();
        return;
    L95:
        if (r114.booleanValue() == false) goto L97;
        int r122 = 1;
    L98:
        r118.put("is_replica_gen", r122);     // Catch: JSONException -> L100
    L100:
        e = move-exception;
        FLogger.f375446a.e("PictureEventHelper", "error in PictureEventHelper pictureMessageShow " + e.getLocalizedMessage());
        goto L102
    L97:
        r122 = 0;
        goto L98
    L71:
        r120 = null;
        goto L72
    L104:
        r119 = l3.f(r116);     // Catch: JSONException -> L100
        if (r119 != null) goto L68;
    L61:
        r108 = r311;
        goto L62
    L57:
        r118 = r310;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L49:
        r116 = r218;
        goto L51
    L45:
        r115 = r217;
        goto L47
    L41:
        r114 = r216;
        goto L43
    L37:
        r113 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static void d(String r110, Integer r111, Long r112, String r113, String r210, String r211, String r212, Boolean r213, Boolean r214, Boolean r215, String r216, Boolean r217, Float r218, String r219, JSONObject r310, int r311) {
        if ((r311 & 1) == 0) goto L5;
        Object r100 = null;
    L7:
        if ((r311 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r311 & 4) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r311 & 8) == 0) goto L17;
        Object r103 = null;
    L19:
        if ((r311 & 16) == 0) goto L21;
        Object r104 = null;
    L23:
        if ((r311 & 32) == 0) goto L25;
        Object r105 = null;
    L27:
        if ((r311 & 64) == 0) goto L29;
        Object r106 = null;
    L31:
        if ((r311 & 128) == 0) goto L33;
        Boolean r107 = null;
    L35:
        if ((r311 & 256) == 0) goto L37;
        Boolean r114 = null;
    L39:
        if ((r311 & 512) == 0) goto L41;
        Boolean r115 = null;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        Object r116 = null;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        Boolean r117 = null;
    L51:
        if ((r311 & 4096) == 0) goto L53;
        Object r118 = null;
    L55:
        if ((r311 & 8192) == 0) goto L57;
        Object r119 = null;
    L59:
        if ((r311 & 16384) == 0) goto L61;
        JSONObject r108 = new JSONObject();
    L62:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r115 != null) goto L105;
        String r120 = null;
    L67:
        r108.putOpt("is_deep_thinking", r120);     // Catch: JSONException -> L101
        r108.putOpt("ai_create_show_mode", r116);     // Catch: JSONException -> L101
        if (r114 == null) goto L70;
        Integer r121 = Integer.valueOf(r114.booleanValue() ? 1 : 0);     // Catch: JSONException -> L101
    L71:
        r108.putOpt("is_image_edit", r121);     // Catch: JSONException -> L101
        if (r117 == null) goto L74;
        Integer r122 = Integer.valueOf(r117.booleanValue() ? 1 : 0);     // Catch: JSONException -> L101
    L75:
        r108.putOpt("success", r122);     // Catch: JSONException -> L101
        if (r100 == null) goto L78;
        r108.put("original_content_source", r100);     // Catch: JSONException -> L101
    L78:
        if (r101 == null) goto L80;
        r108.put("position", r101.intValue());     // Catch: JSONException -> L101
    L80:
        if (r102 == null) goto L82;
        r108.put("from_pic_template_id", r102.longValue());     // Catch: JSONException -> L101
    L82:
        if (r103 == null) goto L84;
        r108.put("bot_id", r103);     // Catch: JSONException -> L101
    L84:
        if (r104 == null) goto L86;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r104);     // Catch: JSONException -> L101
    L86:
        if (r105 == null) goto L88;
        r108.put("request_id", r105);     // Catch: JSONException -> L101
    L88:
        if (r106 == null) goto L90;
        r108.put("pic_id", r106);     // Catch: JSONException -> L101
    L90:
        if (r118 == null) goto L92;
        r108.put("show_pct", r118);     // Catch: JSONException -> L101
    L92:
        if (r119 == null) goto L94;
        r108.put("creation_task_id", r119);     // Catch: JSONException -> L101
    L94:
        if (r107 != null) goto L96;
    L103:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r123 = new by7.a("picture_message_show_single");
        r123.f21463a.merge(r109);
        r123.b();
        return;
    L96:
        if (r107.booleanValue() == false) goto L98;
        int r124 = 1;
    L99:
        r108.put("is_replica_gen", r124);     // Catch: JSONException -> L101
    L101:
        e = move-exception;
        FLogger.f375446a.e("PictureEventHelper", "error in PictureEventHelper mobScrollPictureSingleShow " + e.getLocalizedMessage());
        goto L103
    L98:
        r124 = 0;
        goto L99
    L74:
        r122 = null;
        goto L75
    L70:
        r121 = null;
        goto L71
    L105:
        r120 = l3.f(r115);     // Catch: JSONException -> L101
        goto L67
    L61:
        r108 = r310;
        goto L62
    L57:
        r119 = r219;
        goto L59
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
