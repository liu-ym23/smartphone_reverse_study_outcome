package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class l {
    public static final String a(String r100) {
        if (r100 == null) goto L10;
        String r101 = StringsKt.substringBefore(r100, ':', "");
        if (r101 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r101)) == true) goto L9;
        return null;
    L9:
        return r101;
    L10:
        return null;
    }

    public static final String d(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if ((true ^ r101) == true) goto L13;
        r100 = null;
    L13:
        if (r100 != null) goto L16;
        return "0";
    L16:
        return r100;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        JSONObject r108 = new JSONObject();
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L23;
    L7:
        if (r101 == null) goto L9;
        r108.put("page_token", r101);     // Catch: Exception -> L5
    L9:
        if (r102 == null) goto L11;
        r108.put("feishu_record_generated_type", r102);     // Catch: Exception -> L5
    L11:
        if (r103 == null) goto L13;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r103);     // Catch: Exception -> L5
    L13:
        if (r104 == null) goto L15;
        r108.put("conversation_id", r104);     // Catch: Exception -> L5
    L15:
        r108.put("is_general_agent", d(r105));     // Catch: Exception -> L5
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        r108.put("chat_id", r106);     // Catch: Exception -> L5
        r108.putOpt("record_scene", r107);     // Catch: Exception -> L5
    L21:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r110 = new by7.a("aidoc_artifact_result_card_show");
        r110.f21463a.merge(r109);
        r110.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("AudioRecordEventHelper", e.getMessage(), e);
        goto L21
    L23:
        r108.put("feishu_record_id", r100);     // Catch: Exception -> L5
        goto L7
    }

    public static void c(boolean r100, String r101, String r102, String r103, String r104, String r105, String r110, String r111) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        r106.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "feishu_record_status_card");     // Catch: Exception -> L20
        if (r101 == null) goto L6;
        r106.put("progress_status", r101);     // Catch: Exception -> L20
    L6:
        if (r100 == false) goto L8;
        String r107 = "status";
    L9:
        r106.put(r107, r102);     // Catch: Exception -> L20
        if (r103 == null) goto L12;
        r106.put("feishu_record_id", r103);     // Catch: Exception -> L20
    L12:
        if (r104 == null) goto L14;
        r106.put("bot_id", r104);     // Catch: Exception -> L20
    L14:
        if (r105 == null) goto L16;
        r106.put(MusicAppletPage.KEY_MESSAGE_ID, r105);     // Catch: Exception -> L20
    L16:
        if (r110 == null) goto L18;
        r106.put("conversation_id", r110);     // Catch: Exception -> L20
    L18:
        r106.put("current_page", "chat");     // Catch: Exception -> L20
        r106.putOpt("record_scene", r111);     // Catch: Exception -> L20
    L22:
        TrackParams r108 = new TrackParams().merge(r106);
        if (r100 == false) goto L25;
        String r109 = "show_card";
    L26:
        by7.a r112 = new by7.a(r109);
        r112.f21463a.merge(r108);
        r112.b();
        return;
    L25:
        r109 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_CARD;
        goto L26
    L8:
        r107 = "click_effect";
    L20:
        e = move-exception;
        FLogger.f375446a.e("AudioRecordEventHelper", e.getMessage(), e);
        goto L22
    }
}
