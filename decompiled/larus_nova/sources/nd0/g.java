package nd0;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.e1;
import com.bytedance.android.livesdk.chatroom.model.interact.d2;
import com.bytedance.android.livesdk.chatroom.model.k1;
import com.bytedance.android.livesdk.message.model.ILinkmicProfitMessage;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import gm2.i;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Deprecated(message = "大多数逻辑已经下沉KMP-TalkRoomBusinessFullLinkMonitor，遗留部分在此，新增考虑加在TalkRoomBusinessFullLinkMonitor")
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f518750a = 0;

    static {
    }

    public static String e(int r100) {
        if (r100 != 1) goto L5;
        return "switch_on";
    L5:
        if (r100 != 2) goto L7;
    L12:
        return "switch_off";
    L7:
        if (r100 == 3) goto L12;
        if (r100 != 4) goto L15;
        return "switch_continue";
    L15:
        return "unknown(" + r100 + ')';
    }

    public static void g(int r100) {
        JSONObject r101 = new JSONObject();
        r101.put("target_status", e(r100));
        c.o(c.f518746a, LinkMonitorData.SelfDisciplineManagePanelOpenMonitorData, r101, 0, null, false, 28);
    }

    public static void d(long r100, ExtraResponse r101) {
        Intrinsics.checkNotNullParameter(r101, "response");
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        e1 r104 = (e1) r101.data;
        if (r104 == null) goto L10;
        List<k1> r105 = r104.getInteractItems();
        if (r105 == null) goto L10;
        Iterator<k1> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        k1 r107 = r106.next();
        r103.put(String.valueOf(r107.getType()), r107.getTitle());
    L10:
        r102.put("play_mode_list", r103);
        TalkRoomBusinessFullLinkMonitor r108 = TalkRoomBusinessFullLinkMonitor.f71456a;
        LinkMonitorData r109 = LinkMonitorData.InteractListApiMonitorData;
        r108.getClass();
        TalkRoomBusinessFullLinkMonitor.Z(r109, TalkRoomBusinessFullLinkMonitor.h(r100), r101.logId, r102);
    }

    public static void f(long r100, long r110, ILinkmicProfitMessage r111) {
        Intrinsics.checkNotNullParameter(r111, "message");
        JSONObject r101 = new JSONObject();
        r101.put("msg_id", r111.getMessageId());
        int r102 = r111.getMsgType();
        if (r102 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_AudioSubtitleCheckIn.getValue()) goto L6;
        String r112 = "checkin";
    L12:
        r101.put(SeiMessageConst.MSG_TYPE, r112);
        r101.put("current_version_id", r100);
        r101.put("msg_version_id", r110);
        c.o(c.f518746a, LinkMonitorData.ReceiveAudioSubtitleMsgMonitorData, r101, 0, null, false, 28);
        return;
    L6:
        if (r102 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_AudioSubtitleStart.getValue()) goto L9;
        r112 = "start";
        goto L12
    L9:
        if (r102 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_AudioSubtitleClose.getValue()) goto L11;
        r112 = "close";
        goto L12
    L11:
        r112 = "unknown: " + r111.getMsgType();
        goto L12
    }

    public static void h(i r100, long r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, IAllianceService.LAUNCH_FROM_SIGNAL);
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
    L6:
        JSONObject r103 = new JSONObject();
        switch(r100.type) {
            case 100101: goto L10;
            case 100102: goto L9;
            default: goto L8;
        };
    L8:
        String r104 = "unknown: " + r100.type;
    L11:
        r103.put("signal_type", r104);
        TalkRoomBusinessFullLinkMonitor r105 = TalkRoomBusinessFullLinkMonitor.f71456a;
        LinkMonitorData r106 = LinkMonitorData.SendSignalingApiMonitorData;
        r105.getClass();
        TalkRoomBusinessFullLinkMonitor.Y(r106, TalkRoomBusinessFullLinkMonitor.h(r101), r102, r103);
        return;
    L9:
        r104 = "foreground";
        goto L11
    L10:
        r104 = "background";
        goto L11
    L5:
        if (((IInteractService) k.n(IInteractService.class)).isAudienceLinkEngineOn() == true) goto L6;
    }

    public static void i(i r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, IAllianceService.LAUNCH_FROM_SIGNAL);
        Intrinsics.checkNotNullParameter(r102, "logId");
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
    L6:
        JSONObject r103 = new JSONObject();
        switch(r100.type) {
            case 100101: goto L10;
            case 100102: goto L9;
            default: goto L8;
        };
    L8:
        String r104 = "unknown: " + r100.type;
    L11:
        r103.put("signal_type", r104);
        TalkRoomBusinessFullLinkMonitor r105 = TalkRoomBusinessFullLinkMonitor.f71456a;
        LinkMonitorData r106 = LinkMonitorData.SendSignalingApiMonitorData;
        r105.getClass();
        TalkRoomBusinessFullLinkMonitor.Z(r106, TalkRoomBusinessFullLinkMonitor.h(r101), r102, r103);
        return;
    L9:
        r104 = "foreground";
        goto L11
    L10:
        r104 = "background";
        goto L11
    L5:
        if (((IInteractService) k.n(IInteractService.class)).isAudienceLinkEngineOn() == true) goto L6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(boolean r100, boolean r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "duration");
        Intrinsics.checkNotNullParameter(r112, "requestPage");
        JSONObject r101 = new JSONObject();
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
        String r102 = "anchor";
    L12:
        r101.put("open_status", r100);
        r101.put("subtitle_is_show", r110);
        r101.put("user_type", r102);
        r101.put("duration", r111);
        r101.put("request_page", r112);
        c.o(c.f518746a, LinkMonitorData.AudioSubtitleDurationMonitorData, r101, 0, null, false, 28);
        return;
    L5:
        Integer r103 = (Integer) hd0.c.f().f481009b;
        if (r103 != null) goto L9;
    L10:
        r102 = "guest";
        goto L12
    L9:
        if (r103.intValue() != 0) goto L10;
        r102 = "user";
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(boolean r100, boolean r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "duration");
        Intrinsics.checkNotNullParameter(r112, "requestPage");
        JSONObject r101 = new JSONObject();
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
        String r102 = "anchor";
    L12:
        r101.put("open_status", r100);
        r101.put("subtitle_is_show", r110);
        r101.put("user_type", r102);
        r101.put("duration", r111);
        r101.put("request_page", r112);
        c.o(c.f518746a, LinkMonitorData.AudioSubtitlePauseDurationMonitorData, r101, 0, null, false, 28);
        return;
    L5:
        Integer r103 = (Integer) hd0.c.f().f481009b;
        if (r103 != null) goto L9;
    L10:
        r102 = "guest";
        goto L12
    L9:
        if (r103.intValue() != 0) goto L10;
        r102 = "user";
        goto L12
    }

    public static void j(String r100, int r101, long r102, ExtraResponse r103) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        Intrinsics.checkNotNullParameter(r103, "response");
        JSONObject r104 = new JSONObject();
        r104.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        pd0.b r105 = pd0.b.f528640a;
        r104.put("target_link_type", pd0.b.g(r101));
        TalkRoomBusinessFullLinkMonitor r106 = TalkRoomBusinessFullLinkMonitor.f71456a;
        LinkMonitorData r107 = LinkMonitorData.UpdateLinkTypeApplyApiMonitorData;
        r106.getClass();
        TalkRoomBusinessFullLinkMonitor.Z(r107, TalkRoomBusinessFullLinkMonitor.h(r102), r103.logId, r104);
        d2 r108 = (d2) r103.data;
        Intrinsics.checkNotNullParameter(r108, "$this$getLiveCoreExtInfo");
        String r109 = r108.getLiveCoreExtInfoRaw();
        String r110 = "";
        if (r109 != null) goto L5;
        r109 = "";
    L5:
        d2 r111 = (d2) r103.data;
        Intrinsics.checkNotNullParameter(r111, "$this$getRtcExtInfo");
        String r112 = r111.getRtcExtInfoRaw();
        if (r112 == null) goto L9;
        r110 = r112;
    L9:
        InteractLinkFullLinkMonitor.t0("update_link_type_apply_success", r109, r110, null, null);
    }

    public static void c(int r100, int r101, int r102, long r103, ExtraResponse r104) {
        Intrinsics.checkNotNullParameter(r104, "response");
        JSONObject r105 = new JSONObject();
        r105.put("target_scene", r100);
        pd0.b r106 = pd0.b.f528640a;
        r105.put("emoji_type", pd0.b.b(r101));
        r105.put("category", pd0.b.a(r102));
        TalkRoomBusinessFullLinkMonitor r107 = TalkRoomBusinessFullLinkMonitor.f71456a;
        LinkMonitorData r108 = LinkMonitorData.ListEmojisApiMonitorData;
        r107.getClass();
        TalkRoomBusinessFullLinkMonitor.Z(r108, TalkRoomBusinessFullLinkMonitor.h(r103), r104.logId, r105);
    }

    public static void k(int r100, int r101, String r102, long r103, Throwable r104) {
        Intrinsics.checkNotNullParameter(r102, "sourceFrom");
        JSONObject r105 = new JSONObject();
        r105.put("target_status", e(r100));
        r105.put("setting_value", r101);
        r105.put("source_from", r102);
        TalkRoomBusinessFullLinkMonitor r106 = TalkRoomBusinessFullLinkMonitor.f71456a;
        LinkMonitorData r107 = LinkMonitorData.SelfDisciplineConfigApiMonitorData;
        r106.getClass();
        TalkRoomBusinessFullLinkMonitor.Y(r107, TalkRoomBusinessFullLinkMonitor.h(r103), r104, r105);
    }

    public static void l(int r100, int r101, String r102, long r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "sourceFrom");
        Intrinsics.checkNotNullParameter(r104, "logId");
        JSONObject r105 = new JSONObject();
        r105.put("target_status", e(r100));
        r105.put("setting_value", r101);
        r105.put("source_from", r102);
        TalkRoomBusinessFullLinkMonitor r106 = TalkRoomBusinessFullLinkMonitor.f71456a;
        LinkMonitorData r107 = LinkMonitorData.SelfDisciplineConfigApiMonitorData;
        r106.getClass();
        TalkRoomBusinessFullLinkMonitor.Z(r107, TalkRoomBusinessFullLinkMonitor.h(r103), r104, r105);
    }
}
