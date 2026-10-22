package mha;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class a {
    public static void b(String r100, String r101, String r102, boolean r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r105.put("bot_id", r100);
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r105.put("conversation_id", r101);
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        r105.put("call_id", r102);
        if (r103 == false) goto L14;
        String r106 = "success";
    L15:
        r105.put("status", r106);
        if (r104 != null) goto L18;
        r104 = "";
    L18:
        r105.put(BdpAppEventConstant.PARAMS_FAIL_TYPE, r104);
        TrackParams r107 = new TrackParams().merge(r105);
        by7.a r108 = new by7.a("obric_click_speak_start");
        r108.f21463a.merge(r107);
        r108.b();
        FLogger.f375446a.i("mobClickTalkStart", "params:" + r105);
        return;
    L14:
        r106 = "failure";
        goto L15
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, Integer r105) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r106.put("bot_id", r100);
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r106.put("conversation_id", r101);
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        r106.put("call_id", r102);
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        r106.put(MusicAppletPage.KEY_MESSAGE_ID, r103);
        r106.put("end_type", r104);
        r106.put("duration", r105);
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("obric_click_speak_end");
        r108.f21463a.merge(r107);
        r108.b();
        FLogger.f375446a.i("mobClickTalkEnd", "params:" + r106);
    }
}
