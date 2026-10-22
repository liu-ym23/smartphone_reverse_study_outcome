package tx9;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a4 {
    public static final boolean a(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return false;
    L11:
        Object r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L36
        if (r100 != null) goto L15;
        r100 = "";
    L15:
        JSONObject r105 = new JSONObject(r100).optJSONObject("video_list");     // Catch: Throwable -> L36
        if (r105 == null) goto L20;
        Iterator<String> r106 = r105.keys();     // Catch: Throwable -> L36
        if (r106 == null) goto L20;
        String r107 = r106.next();     // Catch: Throwable -> L36
    L21:
        if (r105 == null) goto L23;
        JSONObject r108 = r105.optJSONObject(r107);     // Catch: Throwable -> L36
    L24:
        if (r108 == null) goto L28;
        String r109 = r108.optString("audio_channels");     // Catch: Throwable -> L36
        if (r109 == null) goto L28;
        Float r110 = StringsKt.toFloatOrNull(r109);     // Catch: Throwable -> L36
    L29:
        if (r110 != null) goto L31;
    L33:
        r101 = false;
    L34:
        Object r111 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L36
    L38:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L42;
        FLogger.f375446a.i("isHasVoice", "isHasVoice failed: " + r112);
    L42:
        if (Result.m9455isFailureimpl(r111) == true) goto L45;
        r103 = r111;
    L45:
        Boolean r113 = (Boolean) r103;
        if (r113 != null) goto L48;
        return false;
    L48:
        return r113.booleanValue();
    L31:
        if (r110.floatValue() <= 0.0f) goto L33;
    L28:
        r110 = null;
        goto L29
    L23:
        r108 = null;
    L20:
        r107 = null;
    L36:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final boolean b(Context r100, Boolean r101) {
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L27
        if (r100 == null) goto L6;
        Object r104 = r100.getSystemService("audio");     // Catch: Throwable -> L27
    L8:
        if ((r104 instanceof AudioManager) == false) goto L10;
        AudioManager r105 = (AudioManager) r104;     // Catch: Throwable -> L27
    L12:
        if (r105 == null) goto L14;
        int r106 = r105.getStreamVolume(3);     // Catch: Throwable -> L27
    L15:
        if (r105 == null) goto L17;
        int r107 = r105.getStreamMaxVolume(3);     // Catch: Throwable -> L27
    L18:
        FLogger.f375446a.i("isVoicePlay", "currentVolume=" + r106 + ", maxVolume=" + r107 + ", isVideoMute=" + r101);     // Catch: Throwable -> L27
        if (r106 <= 0) goto L24;
        if (r107 <= 0) goto L24;
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L24;
        boolean r108 = true;
    L25:
        Object r109 = Result.m9449constructorimpl(Boolean.valueOf(r108));     // Catch: Throwable -> L27
    L29:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L33;
        FLogger.f375446a.i("isVoicePlay", "isMediaVolumeOn failed: " + r110);
    L33:
        if (Result.m9455isFailureimpl(r109) == true) goto L36;
        r102 = r109;
    L36:
        Boolean r111 = (Boolean) r102;
        if (r111 != null) goto L39;
        return false;
    L39:
        return r111.booleanValue();
    L24:
        r108 = false;
        goto L25
    L17:
        r107 = 0;
        goto L18
    L14:
        r106 = 0;
        goto L15
    L10:
        r105 = null;
        goto L12
    L6:
        r104 = null;
    L27:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    }

    public static void c(String r100, String r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r103, "params");
    L13:
        e = move-exception;
        FLogger.f375446a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
    L15:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("ai_video_message_click");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L4:
        if (com.larus.utils.o0.d(r100) == false) goto L7;
        r103.put("video_id", r100);     // Catch: JSONException -> L13
    L7:
        if (com.larus.utils.o0.d(r101) == false) goto L10;
        r103.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L13
    L10:
        if (com.larus.utils.o0.d(r102) == false) goto L15;
        r103.put("bot_id", r102);     // Catch: JSONException -> L13
        goto L15
    }

    public static void g(String r100, String r101, String r102, String r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r104, "params");
    L16:
        e = move-exception;
        FLogger.f375446a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
    L18:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("ai_video_play_fail");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L4:
        if (com.larus.utils.o0.d(r100) == false) goto L7;
        r104.put("video_id", r100);     // Catch: JSONException -> L16
    L7:
        if (com.larus.utils.o0.d(r101) == false) goto L10;
        r104.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L16
    L10:
        if (com.larus.utils.o0.d(r102) == false) goto L13;
        r104.put("bot_id", r102);     // Catch: JSONException -> L16
    L13:
        if (com.larus.utils.o0.d(r103) == false) goto L18;
        r104.put("previous_page", r103);     // Catch: JSONException -> L16
        goto L18
    }

    public static void i(String r100, String r101, String r102, String r103, String r104, Long r105, int r106) {
        JSONObject r107 = null;
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r106 & 64) == 0) goto L23;
        r107 = new JSONObject();
    L23:
        Intrinsics.checkNotNullParameter(r107, "params");
    L42:
        e = move-exception;
        FLogger.f375446a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
    L44:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("ai_video_click_close");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L25:
        if (com.larus.utils.o0.d(r100) == false) goto L28;
        r107.put("video_id", r100);     // Catch: JSONException -> L42
    L28:
        if (com.larus.utils.o0.d(r101) == false) goto L31;
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L42
    L31:
        if (com.larus.utils.o0.d(r102) == false) goto L34;
        r107.put("bot_id", r102);     // Catch: JSONException -> L42
    L34:
        if (com.larus.utils.o0.d(r103) == false) goto L37;
        r107.put("previous_page", r103);     // Catch: JSONException -> L42
    L37:
        if (com.larus.utils.o0.d(r104) == false) goto L39;
        r107.put("is_upload_video", r104);     // Catch: JSONException -> L42
    L39:
        if (r105 == null) goto L44;
        r107.put("duration", r105.longValue());     // Catch: JSONException -> L42
        goto L44
    }

    public static void d(String r100, String r101, String r102, String r103, Integer r104, String r105, Float r106, JSONObject r107, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r110 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r110 & 128) == 0) goto L26;
        r107 = new JSONObject();
    L26:
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r105 != null) goto L51;
        r105 = "";
    L51:
        r107.putOpt("creation_task_id", r105);     // Catch: JSONException -> L47
        r107.putOpt("position", r104);     // Catch: JSONException -> L47
        if (r103 != null) goto L34;
        r103 = "";
    L34:
        r107.putOpt("ai_create_show_mode", r103);     // Catch: JSONException -> L47
        if (r106 == null) goto L38;
        r107.put("show_pct", r106);     // Catch: JSONException -> L47
    L38:
        if (com.larus.utils.o0.d(r100) == false) goto L41;
        r107.put("video_id", r100);     // Catch: JSONException -> L47
    L41:
        if (com.larus.utils.o0.d(r101) == false) goto L44;
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L47
    L44:
        if (com.larus.utils.o0.d(r102) == false) goto L49;
        r107.put("bot_id", r102);     // Catch: JSONException -> L47
    L49:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("ai_video_message_show");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L47:
        e = move-exception;
        FLogger.f375446a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageShow " + e.getLocalizedMessage());
        goto L49
    }

    public static void k(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, String r107, JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        if (r107 != null) goto L30;
        r107 = "";
    L30:
        r110.putOpt("creation_task_id", r107);     // Catch: JSONException -> L26
        r110.putOpt("position", r106);     // Catch: JSONException -> L26
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        r110.putOpt("ai_create_show_mode", r105);     // Catch: JSONException -> L26
        if (com.larus.utils.o0.d(r100) == false) goto L14;
        r110.put("video_id", r100);     // Catch: JSONException -> L26
    L14:
        if (com.larus.utils.o0.d(r101) == false) goto L17;
        r110.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L26
    L17:
        if (com.larus.utils.o0.d(r102) == false) goto L20;
        r110.put("bot_id", r102);     // Catch: JSONException -> L26
    L20:
        if (com.larus.utils.o0.d(r103) == false) goto L23;
        r110.put("previous_page", r103);     // Catch: JSONException -> L26
    L23:
        if (com.larus.utils.o0.d(r104) == false) goto L28;
        r110.put("is_upload_video", r104);     // Catch: JSONException -> L26
    L28:
        TrackParams r108 = new TrackParams().merge(r110);
        by7.a r109 = new by7.a("ai_video_click_share");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L26:
        e = move-exception;
        FLogger.f375446a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
        goto L28
    }

    public static void h(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r107, String r110, String r111, int r112) {
        JSONObject r108 = null;
        if ((r112 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r112 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r112 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r112 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r112 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r112 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r112 & 512) == 0) goto L33;
        r111 = null;
    L33:
        if ((r112 & 1024) == 0) goto L35;
        r108 = new JSONObject();
    L35:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r110 != null) goto L69;
        r110 = "";
    L69:
        r108.putOpt("creation_task_id", r110);     // Catch: JSONException -> L65
        r108.putOpt("position", r107);     // Catch: JSONException -> L65
        if (r106 != null) goto L43;
        r106 = "";
    L43:
        r108.putOpt("ai_create_show_mode", r106);     // Catch: JSONException -> L65
        if (com.larus.utils.o0.d(r100) == false) goto L47;
        r108.put("video_id", r100);     // Catch: JSONException -> L65
    L47:
        if (com.larus.utils.o0.d(r101) == false) goto L50;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L65
    L50:
        if (com.larus.utils.o0.d(r102) == false) goto L53;
        r108.put("bot_id", r102);     // Catch: JSONException -> L65
    L53:
        if (com.larus.utils.o0.d(r103) == false) goto L56;
        r108.put("enter_method", r103);     // Catch: JSONException -> L65
    L56:
        if (com.larus.utils.o0.d(r104) == false) goto L59;
        r108.put("previous_page", r104);     // Catch: JSONException -> L65
    L59:
        if (com.larus.utils.o0.d(r105) == false) goto L62;
        r108.put("is_upload_video", r105);     // Catch: JSONException -> L65
    L62:
        if (com.larus.utils.o0.d(r111) == false) goto L67;
        r108.put("user_type", r111);     // Catch: JSONException -> L65
    L67:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r113 = new by7.a("enter_video_detail");
        r113.f21463a.merge(r109);
        r113.b();
        return;
    L65:
        e = move-exception;
        FLogger.f375446a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
        goto L67
    }

    public static void j(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r107, String r110, String r111, JSONObject r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r113 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r113 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r113 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r113 & 512) == 0) goto L33;
        r111 = null;
    L33:
        if ((r113 & 1024) == 0) goto L35;
        r112 = new JSONObject();
    L35:
        Intrinsics.checkNotNullParameter(r112, "params");
        if (r110 != null) goto L69;
        r110 = "";
    L69:
        r112.putOpt("creation_task_id", r110);     // Catch: JSONException -> L65
        r112.putOpt("position", r107);     // Catch: JSONException -> L65
        if (r106 != null) goto L43;
        r106 = "";
    L43:
        r112.putOpt("ai_create_show_mode", r106);     // Catch: JSONException -> L65
        if (com.larus.utils.o0.d(r100) == false) goto L47;
        r112.put("video_id", r100);     // Catch: JSONException -> L65
    L47:
        if (com.larus.utils.o0.d(r101) == false) goto L50;
        r112.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L65
    L50:
        if (com.larus.utils.o0.d(r102) == false) goto L53;
        r112.put("bot_id", r102);     // Catch: JSONException -> L65
    L53:
        if (com.larus.utils.o0.d(r103) == false) goto L56;
        r112.put("click_method", r103);     // Catch: JSONException -> L65
    L56:
        if (com.larus.utils.o0.d(r104) == false) goto L59;
        r112.put("previous_page", r104);     // Catch: JSONException -> L65
    L59:
        if (com.larus.utils.o0.d(r105) == false) goto L61;
        r112.put("is_upload_video", r105);     // Catch: JSONException -> L65
    L61:
        r112.putOpt("save_type", "video");     // Catch: JSONException -> L65
        if (com.larus.utils.o0.d(r111) == false) goto L67;
        r112.put("creation_id", r111);     // Catch: JSONException -> L65
    L67:
        b2.f(r112, false);
        TrackParams r108 = new TrackParams().merge(b2.b(r112));
        by7.a r109 = new by7.a("ai_video_click_download");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L65:
        e = move-exception;
        FLogger.f375446a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
        goto L67
    }

    public static /* synthetic */ void f(String r210, String r211, String r212, Boolean r310, String r311, String r312, String r313, Integer r314, String r315, String r316, JSONObject r317, Boolean r318, Boolean r319, int r410) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r410 & 8) == 0) goto L17;
        Boolean r103 = Boolean.TRUE;
    L19:
        if ((r410 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r410 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r410 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r410 & 128) == 0) goto L33;
        Integer r110 = null;
    L35:
        if ((r410 & 256) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r410 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        JSONObject r113 = new JSONObject();
    L47:
        if ((r410 & 4096) == 0) goto L49;
        Boolean r114 = null;
    L51:
        if ((r410 & 8192) == 0) goto L53;
        Boolean r115 = null;
    L54:
        e(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, null, r114, r115, null, null, null, null, null, null, null, null, null, null);
        return;
    L53:
        r115 = r319;
        goto L54
    L49:
        r114 = r318;
        goto L51
    L45:
        r113 = r317;
        goto L47
    L41:
        r112 = r316;
        goto L43
    L37:
        r111 = r315;
        goto L39
    L33:
        r110 = r314;
        goto L35
    L29:
        r106 = r313;
        goto L31
    L25:
        r105 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public static /* synthetic */ void m(String r210, String r211, String r212, Boolean r310, String r311, Long r312, Boolean r313, String r314, String r315, String r316, JSONObject r317, Boolean r318, Boolean r319, int r410) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r410 & 8) == 0) goto L17;
        Boolean r103 = Boolean.TRUE;
    L19:
        if ((r410 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r410 & 32) == 0) goto L25;
        Long r105 = null;
    L27:
        if ((r410 & 64) == 0) goto L29;
        Boolean r106 = Boolean.TRUE;
    L31:
        if ((r410 & 128) == 0) goto L33;
        String r110 = null;
    L35:
        if ((r410 & 256) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r410 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        JSONObject r113 = new JSONObject();
    L47:
        if ((r410 & 4096) == 0) goto L49;
        Boolean r114 = null;
    L51:
        if ((r410 & 8192) == 0) goto L53;
        Boolean r115 = null;
    L54:
        l(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, null, r114, r115, null, null, null, null, null, null, null, null, null, null);
        return;
    L53:
        r115 = r319;
        goto L54
    L49:
        r114 = r318;
        goto L51
    L45:
        r113 = r317;
        goto L47
    L41:
        r112 = r316;
        goto L43
    L37:
        r111 = r315;
        goto L39
    L33:
        r110 = r314;
        goto L35
    L29:
        r106 = r313;
        goto L31
    L25:
        r105 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public static final void e(String r100, String r101, String r102, Boolean r103, String r110, String r111, String r112, Integer r113, String r114, String r115, JSONObject r116, by7.e r117, Boolean r118, Boolean r119, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219) {
        Intrinsics.checkNotNullParameter(r116, "params");
        r116.putOpt("current_page", r115);     // Catch: JSONException -> L74
        String r104 = "";
        if (r114 != null) goto L7;
        Object r105 = "";
    L8:
        r116.putOpt("creation_task_id", r105);     // Catch: JSONException -> L74
        r116.putOpt("position", r113);     // Catch: JSONException -> L74
        if (r112 == null) goto L12;
        r104 = r112;
    L12:
        r116.putOpt("ai_create_show_mode", r104);     // Catch: JSONException -> L74
        if (com.larus.utils.o0.d(r100) == false) goto L16;
        r116.put("video_id", r100);     // Catch: JSONException -> L74
    L16:
        if (com.larus.utils.o0.d(r101) == false) goto L19;
        r116.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L74
    L19:
        if (com.larus.utils.o0.d(r102) == false) goto L22;
        r116.put("bot_id", r102);     // Catch: JSONException -> L74
    L22:
        if (com.larus.utils.o0.d(r111) == false) goto L24;
        r116.put("is_upload_video", r111);     // Catch: JSONException -> L74
    L24:
        int r106 = 1;
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L27;
        int r107 = 1;
    L28:
        r116.put("is_auto_play", r107);     // Catch: JSONException -> L74
        if (com.larus.utils.o0.d(r110) == false) goto L32;
        r116.put("previous_page", r110);     // Catch: JSONException -> L74
    L32:
        if (com.larus.utils.o0.d(r210) == false) goto L35;
        r116.put("ai_generate_tab_id", r210);     // Catch: JSONException -> L74
    L35:
        if (com.larus.utils.o0.d(r211) == false) goto L38;
        r116.put("ai_generate_tab_name", r211);     // Catch: JSONException -> L74
    L38:
        if (com.larus.utils.o0.d(r212) == false) goto L41;
        r116.put("enter_method", r212);     // Catch: JSONException -> L74
    L41:
        if (com.larus.utils.o0.d(r213) == false) goto L44;
        r116.put("recommend_from", r213);     // Catch: JSONException -> L74
    L44:
        if (com.larus.utils.o0.d(r214) == false) goto L47;
        r116.put("template_source", r214);     // Catch: JSONException -> L74
    L47:
        if (com.larus.utils.o0.d(r215) == false) goto L50;
        r116.put("template_sub_type", r215);     // Catch: JSONException -> L74
    L50:
        if (com.larus.utils.o0.d(r216) == false) goto L53;
        r116.put("template_type", r216);     // Catch: JSONException -> L74
    L53:
        if (com.larus.utils.o0.d(r217) == false) goto L56;
        r116.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r217);     // Catch: JSONException -> L74
    L56:
        if (com.larus.utils.o0.d(r218) == false) goto L59;
        r116.put("template_rec_extra", r218);     // Catch: JSONException -> L74
    L59:
        if (com.larus.utils.o0.d(r219) == false) goto L61;
        r116.put("template_rec_req_id", r219);     // Catch: JSONException -> L74
    L61:
        if (r118 != null) goto L63;
    L67:
        if (r119 != null) goto L69;
    L76:
        TrackParams r108 = new TrackParams().merge(r116);
        by7.a r109 = new by7.a("ai_video_play");
        if (r117 == null) goto L79;
        r109.f21464b = r117;
    L79:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L69:
        if (r119.booleanValue() == true) goto L72;
        r106 = 0;
    L72:
        r116.put("is_voice_play", r106);     // Catch: JSONException -> L74
        goto L76
    L63:
        if (r118.booleanValue() == false) goto L65;
        int r120 = 1;
    L66:
        r116.put("is_has_voice", r120);     // Catch: JSONException -> L74
        goto L67
    L65:
        r120 = 0;
        goto L66
    L27:
        r107 = 0;
        goto L28
    L7:
        r105 = r114;
    L74:
        e = move-exception;
        FLogger.f375446a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
        goto L76
    }

    public static final void l(String r100, String r110, String r111, Boolean r112, String r113, Long r114, Boolean r115, String r116, String r117, String r118, JSONObject r119, by7.e r210, Boolean r211, Boolean r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312) {
        Intrinsics.checkNotNullParameter(r119, "params");
        r119.putOpt("current_page", r117);     // Catch: JSONException -> L77
        if (r118 != null) goto L6;
        String r101 = "";
    L7:
        r119.putOpt("creation_task_id", r101);     // Catch: JSONException -> L77
        if (com.larus.utils.o0.d(r100) == false) goto L11;
        r119.put("video_id", r100);     // Catch: JSONException -> L77
    L11:
        if (com.larus.utils.o0.d(r110) == false) goto L14;
        r119.put(MusicAppletPage.KEY_MESSAGE_ID, r110);     // Catch: JSONException -> L77
    L14:
        if (com.larus.utils.o0.d(r111) == false) goto L17;
        r119.put("bot_id", r111);     // Catch: JSONException -> L77
    L17:
        if (com.larus.utils.o0.d(r113) == false) goto L20;
        r119.put("previous_page", r113);     // Catch: JSONException -> L77
    L20:
        if (com.larus.utils.o0.d(r116) == false) goto L23;
        r119.put("is_upload_video", r116);     // Catch: JSONException -> L77
    L23:
        if (com.larus.utils.o0.d(r213) == false) goto L26;
        r119.put("ai_generate_tab_id", r213);     // Catch: JSONException -> L77
    L26:
        if (com.larus.utils.o0.d(r214) == false) goto L29;
        r119.put("ai_generate_tab_name", r214);     // Catch: JSONException -> L77
    L29:
        if (com.larus.utils.o0.d(r215) == false) goto L32;
        r119.put("enter_method", r215);     // Catch: JSONException -> L77
    L32:
        if (com.larus.utils.o0.d(r216) == false) goto L35;
        r119.put("recommend_from", r216);     // Catch: JSONException -> L77
    L35:
        if (com.larus.utils.o0.d(r217) == false) goto L38;
        r119.put("template_source", r217);     // Catch: JSONException -> L77
    L38:
        if (com.larus.utils.o0.d(r218) == false) goto L41;
        r119.put("template_sub_type", r218);     // Catch: JSONException -> L77
    L41:
        if (com.larus.utils.o0.d(r219) == false) goto L44;
        r119.put("template_type", r219);     // Catch: JSONException -> L77
    L44:
        if (com.larus.utils.o0.d(r310) == false) goto L47;
        r119.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r310);     // Catch: JSONException -> L77
    L47:
        if (com.larus.utils.o0.d(r311) == false) goto L50;
        r119.put("template_rec_extra", r311);     // Catch: JSONException -> L77
    L50:
        if (com.larus.utils.o0.d(r312) == false) goto L52;
        r119.put("template_rec_req_id", r312);     // Catch: JSONException -> L77
    L52:
        Boolean r102 = Boolean.TRUE;     // Catch: JSONException -> L77
        int r103 = 1;
        if (Intrinsics.areEqual(r112, r102) == false) goto L55;
        int r104 = 1;
    L56:
        r119.put("is_auto_play", r104);     // Catch: JSONException -> L77
        if (r114 == null) goto L60;
        r119.put("duration", r114.longValue());     // Catch: JSONException -> L77
    L60:
        if (Intrinsics.areEqual(r115, r102) == false) goto L62;
        int r105 = 1;
    L63:
        r119.put(EventConstant.Key.IS_FINISH, r105);     // Catch: JSONException -> L77
        if (r211 != null) goto L66;
    L70:
        if (r212 != null) goto L72;
    L79:
        TrackParams r106 = new TrackParams().merge(r119);
        by7.a r107 = new by7.a("ai_video_play_time");
        if (r210 == null) goto L82;
        r107.f21464b = r210;
    L82:
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L72:
        if (r212.booleanValue() == true) goto L75;
        r103 = 0;
    L75:
        r119.put("is_voice_play", r103);     // Catch: JSONException -> L77
        goto L79
    L66:
        if (r211.booleanValue() == false) goto L68;
        int r108 = 1;
    L69:
        r119.put("is_has_voice", r108);     // Catch: JSONException -> L77
        goto L70
    L68:
        r108 = 0;
        goto L69
    L62:
        r105 = 0;
        goto L63
    L55:
        r104 = 0;
        goto L56
    L6:
        r101 = r118;
    L77:
        e = move-exception;
        FLogger.f375446a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
        goto L79
    }
}
