package com.obric.audio.continuous_talk;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class d0 {
    public static final void a(JSONObject r100, a r101) {
        String r102 = r101.f395149a;
        if (r102 == null) goto L5;
        r100.put("bot_id", r102);
    L5:
        String r103 = r101.f395151c;
        if (r103 == null) goto L8;
        r100.put("call_id", r103);
    L8:
        String r104 = r101.f395150b;
        if (r104 == null) goto L11;
        r100.put("conversation_id", r104);
    L11:
        String r105 = r101.f395152d;
        if (r105 == null) goto L15;
        r100.put("enter_method", r105);
        return;
    }

    public static final void b(String r100, String r101, String r102, String r103, Integer r104) {
        JSONObject r105 = new JSONObject();
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
        r105.put(MusicAppletPage.KEY_MESSAGE_ID, "");
        r105.put(ObricAssistantForAudioDelegate.f385669b.b5(), r103);
        r105.put("duration", r104);
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("obric_continuous_talk_end");
        r107.f21463a.merge(r106);
        r107.b();
        FLogger.f375446a.i("mobObricContinuousTalkEnd", "params:" + r105);
    }

    public static final void c(String r100, String r101, String r102, boolean r103, String r104) {
        JSONObject r105 = new JSONObject();
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
        by7.a r108 = new by7.a("obric_continuous_talk_start");
        r108.f21463a.merge(r107);
        r108.b();
        FLogger.f375446a.i("mobObricContinuousTalkStart", "params:" + r105);
        return;
    L14:
        r106 = "failure";
        goto L15
    }

    public static final void d(a r100, String r101, String r102, Integer r103, Long r104) {
        Intrinsics.checkNotNullParameter(r100, "commonTraceParams");
        JSONObject r105 = new JSONObject();
        a(r105, r100);
        if (r104 == null) goto L5;
        r105.put("duration", r104.longValue());
    L5:
        if (r102 == null) goto L7;
        r105.put("fail_reason", r102);
    L7:
        if (r103 == null) goto L9;
        r105.put("error_code", r103.intValue());
    L9:
        r105.put("success", r101);
        r105.put("status", !Intrinsics.areEqual(r101, "1") ? 1 : 0);
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("obric_continuous_talk_start_finish");
        r107.f21463a.merge(r106);
        r107.b();
        FLogger.f375446a.i("mobObricContinuousTalkStarted", "params:" + r105);
    }
}
