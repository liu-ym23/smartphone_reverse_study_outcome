package dl0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.config.qd1;
import com.bytedance.android.livesdk.message.model.Cif;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.m1;

/* JADX INFO: loaded from: classes46.dex */
public final class m extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f469074a = null;

    static {
        f469074a = new m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String p() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r101 = r100.isAnchor();
        if (r101 == null) goto L9;
        if (r101.getValue().booleanValue() != true) goto L9;
        return "2";
    L9:
        Integer r102 = (Integer) hd0.c.f().f481009b;
        if (r102 != null) goto L13;
    L15:
        return "1";
    L13:
        if (r102.intValue() != 2) goto L15;
        return "3";
    }

    public m() {
    }

    public static void l(JSONObject r100) {
        BaseMonitor.add(r100, "channel_id", String.valueOf(((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiDataHolder().getChannelId()));
        Room r101 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        IRoom.Companion r102 = IRoom.Companion;
        if (r102.isValid(r101) == false) goto L5;
        Room r103 = r101;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        if (r102.isValid(r101) == false) goto L10;
        String r104 = r103.getOwnerUserIdString();
    L11:
        BaseMonitor.add(r100, "anchor_id", r104);
        return;
    L10:
        r104 = "0";
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    public static void m(JSONObject r100) {
        lc0.c r101 = ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiDataHolder();
        BaseMonitor.add(r100, "channel_id", String.valueOf(r101.getChannelId()));
        BaseMonitor.add(r100, "event_session_id", String.valueOf(r101.getChannelId()));
        Room r102 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        IRoom.Companion r103 = IRoom.Companion;
        if (r103.isValid(r102) == false) goto L5;
        Room r104 = r102;
    L6:
        String r105 = "0";
        if (r104 != null) goto L9;
    L17:
        gy.c.f483309c2.getClass();
        gy.c r106 = gy.c.a.a();
        long r107 = 1;
        if (r106 == null) goto L26;
        gy.f r108 = r106.getRtcManager();
        if (r108 == null) goto L26;
        if (r108.F() != true) goto L24;
        long r109 = 1;
    L25:
        BaseMonitor.add(r100, "is_client_mixstream", r109);
        goto L26
    L24:
        r109 = 0;
    L26:
        String r110 = r101.y();
        if (r110 == null) goto L33;
        com.bytedance.android.live.livepkaudience.service.f.f82256z0.getClass();
        com.bytedance.android.live.livepkaudience.service.f r111 = com.bytedance.android.live.livepkaudience.service.f.a.a();
        if (r111 == null) goto L33;
        com.bytedance.android.live.livepkaudience.rtc.a r112 = r111.P2();
        if (r112 == null) goto L33;
        Intrinsics.checkNotNullParameter(r110, "interactId");
        boolean r113 = r112.f82196t.contains(r110);
    L34:
        if (r113 == true) goto L37;
        r107 = 0;
    L37:
        BaseMonitor.add(r100, "disable_opposite_mic", r107);
        BaseMonitor.add(r100, "pk_id", r101.getPkId());
        BaseMonitor.add(r100, "invitee_list", r101.getInviteType());
        BaseMonitor.add(r100, "invitee_id", r101.a().toString());
        BaseMonitor.add(r100, "inviter_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
        BaseMonitor.add(r100, "use_multi_channel", "1");
        if (FoldScreenUtils.f() == false) goto L40;
        String r114 = "1";
    L41:
        BaseMonitor.add(r100, "is_fold_screen", r114);
        if (PadConfigUtils.c() == false) goto L44;
    L45:
        r105 = "1";
    L46:
        BaseMonitor.add(r100, "is_pad", r105);
        BaseMonitor.add(r100, "current_user_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
        BaseMonitor.add(r100, "current_mode", ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode());
        return;
    L44:
        if (PadConfigUtils.c() == false) goto L46;
    L40:
        r114 = "0";
    L33:
        r113 = false;
        goto L34
    L9:
        if (r103.isValid(r102) == false) goto L11;
        String r115 = r104.getIdStr();
    L12:
        BaseMonitor.add(r100, "room_id", r115);
        if (r103.isValid(r102) == false) goto L15;
        String r116 = r104.getOwnerUserIdString();
    L16:
        BaseMonitor.add(r100, "anchor_id", r116);
        goto L17
    L15:
        r116 = "0";
        goto L16
    L11:
        r115 = "0";
        goto L12
    L5:
        r104 = null;
        goto L6
    }

    public static boolean t(m1.b r100) {
        if (r100.getLeft() == 1.0f) goto L5;
    L10:
        float r101 = 0;
        if (r100.getLeft() >= r101) goto L13;
    L14:
        return true;
    L13:
        if (r100.getRight() < r101) goto L14;
        return false;
    L5:
        if (r100.getRight() != 1.1f) goto L10;
        if (r100.getTop() != 1.0f) goto L10;
        if (r100.getBottom() == 1.1f) goto L14;
        goto L10
    }

    public static void v(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        JSONObject r101 = new JSONObject();
        OperateType r102 = r100.getOperateType();
        switch(l.f469073a[r102.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        String r103 = "universal_anim_for_saas";
    L14:
        BaseMonitor.add(r101, "operate_type", r103);
        BaseMonitor.add(r101, "check_type", r100.getCheckType().name());
        String r104 = r100.getMessage();
        String r105 = "";
        if (r104 != null) goto L17;
        r104 = "";
    L17:
        BaseMonitor.add(r101, "error_msg", r104);
        Throwable r106 = r100.getCause();
        if (r106 != null) goto L20;
    L32:
        A("audience_check_link_permission_failed", r101);
        return;
    L20:
        if ((r106 instanceof CustomApiServerException) == false) goto L23;
        CustomApiServerException r107 = (CustomApiServerException) r106;
        BaseMonitor.add(r101, "url", r107.getUrl());
        BaseMonitor.add(r101, "xTtLogId", r107.getXTtLogId());
    L23:
        if ((r106 instanceof ApiServerException) == false) goto L30;
        String r108 = r106.getMessage();
        if (r108 == null) goto L28;
        r105 = r108;
    L28:
        BaseMonitor.add(r101, "cause_msg", r105);
    L30:
        if ((r106 instanceof ApiException) == false) goto L32;
        BaseMonitor.add(r101, "error_code", ((ApiException) r106).getErrorCode());
        goto L32
    L7:
        r103 = KtvSubElement.MIDI;
        goto L14
    L8:
        r103 = "pre_reply";
        goto L14
    L9:
        r103 = "join";
        goto L14
    L10:
        r103 = "resume";
        goto L14
    L11:
        r103 = "pre_apply";
        goto L14
    L12:
        r103 = "reply";
        goto L14
    L13:
        r103 = e1.REPLY_ACTION_APPLY;
        goto L14
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static void A(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (r100 != null) goto L5;
        String r102 = "";
    L6:
        BaseMonitor.add(r101, "business_api_name", r102);
        m(r101);
        LiveTracingMonitor.EventModule r103 = LiveTracingMonitor.EventModule.PK;
        LiveTracingMonitor.d("ttlive_pk_business_api_call", r103, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r101);
        HashMap r104 = new HashMap();
        r104.put("business_api_name", r100);
        r104.put("role_type", p());
        dy.b r105 = dy.b.f470518a;
        r104.put("android_event_key", r100);
        dy.b.e("ttlive_pk_business_api_call", r103, r104, r101);
        return;
    L5:
        r102 = r100;
        goto L6
    }

    public static /* synthetic */ void B(m r100, String r101) {
        JSONObject r102 = new JSONObject();
        r100.getClass();
        A(r101, r102);
    }

    public static void C(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "apiName");
        JSONObject r102 = new JSONObject();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        BaseMonitor.add(r102, "extra_msg", r101);
        A("pk_audience_" + r100, r102);
    }

    @JvmStatic
    public static final void n(long r100, Throwable r101) {
        JSONObject r102 = new JSONObject();
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof ApiServerException) == false) goto L10;
        m r103 = f469074a;
        ApiServerException r104 = (ApiServerException) r101;
        int r105 = r104.getErrorCode();
        String r106 = r104.getErrorMsg();
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        long r107 = System.currentTimeMillis() - r100;
        r103.getClass();
        z("linkmic_audience/invite_list", r105, r106, r107, r102);
        return;
    L10:
        m r108 = f469074a;
        String r109 = r101.toString();
        long r110 = System.currentTimeMillis() - r100;
        r108.getClass();
        z("linkmic_audience/invite_list", 1, r109, r110, r102);
    }

    @JvmStatic
    public static final void o(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "logId");
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "api_log_id", r101);
        m r103 = f469074a;
        long r104 = System.currentTimeMillis() - r100;
        r103.getClass();
        z("linkmic_audience/invite_list", 0, "", r104, r102);
    }

    @JvmStatic
    public static final void q(long r100, Throwable r101) {
        JSONObject r102 = new JSONObject();
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof ApiServerException) == false) goto L10;
        m r103 = f469074a;
        ApiServerException r104 = (ApiServerException) r101;
        int r105 = r104.getErrorCode();
        String r106 = r104.getErrorMsg();
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        long r107 = System.currentTimeMillis() - r100;
        r103.getClass();
        z("linkmic_audience/waiting_list", r105, r106, r107, r102);
        return;
    L10:
        m r108 = f469074a;
        String r109 = r101.toString();
        long r110 = System.currentTimeMillis() - r100;
        r108.getClass();
        z("linkmic_audience/waiting_list", 1, r109, r110, r102);
    }

    @JvmStatic
    public static final void r(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "logId");
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "api_log_id", r101);
        m r103 = f469074a;
        long r104 = System.currentTimeMillis() - r100;
        r103.getClass();
        z("linkmic_audience/waiting_list", 0, "", r104, r102);
    }

    @JvmStatic
    public static final void s(Throwable r100, long r101) {
        JSONObject r102 = new JSONObject();
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ApiServerException) == false) goto L10;
        m r103 = f469074a;
        ApiServerException r104 = (ApiServerException) r100;
        int r105 = r104.getErrorCode();
        String r106 = r104.getErrorMsg();
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        r103.getClass();
        z("audience_pre_apply", r105, r106, r101, r102);
        return;
    L10:
        m r107 = f469074a;
        String r108 = r100.toString();
        r107.getClass();
        z("audience_pre_apply", 1, r108, r101, r102);
    }

    @JvmStatic
    public static final void u(Throwable r100, long r101, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reqFrom");
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "request_source", r110);
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ApiServerException) == false) goto L10;
        m r111 = f469074a;
        ApiServerException r103 = (ApiServerException) r100;
        int r104 = r103.getErrorCode();
        String r105 = r103.getErrorMsg();
        if (r105 != null) goto L9;
        r105 = "";
    L9:
        r111.getClass();
        z("audience_leave", r104, r105, r101, r102);
        return;
    L10:
        m r112 = f469074a;
        String r106 = r100.toString();
        r112.getClass();
        z("audience_leave", 1, r106, r101, r102);
    }

    public static void D(String r100, int r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "remoteViewIds");
        JSONObject r104 = new JSONObject();
        BaseMonitor.add(r104, "business_api_name", "update_first_video_frame");
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        BaseMonitor.add(r104, "self_linkmic_id", r100);
        BaseMonitor.add(r104, "remote_view_size", r101);
        BaseMonitor.add(r104, "remote_view_ids", r102);
        BaseMonitor.add(r104, IPerformanceManager.Params.is_anchor, r103 ? 1 : 0);
        l(r104);
        LiveTracingMonitor.EventModule r105 = LiveTracingMonitor.EventModule.PK;
        LiveTracingMonitor.d("ttlive_pk_business_api_call", r105, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r104);
        HashMap r106 = new HashMap();
        r106.put("business_api_name", "update_first_video_frame");
        r106.put("role_type", p());
        dy.b r107 = dy.b.f470518a;
        r106.put("android_event_key", "update_first_video_frame");
        dy.b.e("ttlive_pk_business_api_call", r105, r106, r104);
    }

    @JvmStatic
    public static final void w(int r100, long r110, String r111, String r112) {
        if (r111 == null) goto L13;
        int r101 = 1;
        if (r111.length() <= 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 != true) goto L13;
        if (Intrinsics.areEqual(r111, e1.REPLY_ACTION_APPLY) == true) goto L12;
        r101 = 2;
    L12:
        r100 = r100 + (r101 * 1000);
        goto L13
    L6:
        r102 = false;
    L13:
        LinkedHashMap r103 = new LinkedHashMap();
        if (r111 != null) goto L16;
        r111 = "";
    L16:
        r103.put("join_channel_type", r111);
        r103.put("stats", Integer.valueOf(r100));
        r103.put("duration", Long.valueOf(r110));
        r103.put("first_video_frame_type", "guest_self");
        m r104 = f469074a;
        LiveTracingMonitor.EventModule r105 = LiveTracingMonitor.EventModule.PK;
        if (r112 != null) goto L19;
        r112 = "";
    L19:
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "eventModule");
        Intrinsics.checkNotNullParameter("first_remote_video_decoded_of_uid", "rtcCallBackName");
        Intrinsics.checkNotNullParameter(r112, "linkmicId");
        Intrinsics.checkNotNullParameter("", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        dy.b r113 = dy.b.f470518a;
        if (dy.b.c("first_remote_video_decoded_of_uid") == true) goto L29;
        JSONObject r106 = new JSONObject();
        BaseMonitor.add(r106, "rtc_callback_name", "first_remote_video_decoded_of_uid");
        BaseMonitor.add(r106, "linkmic_id", r112);
        Iterator r114 = r103.entrySet().iterator();
    L24:
        if (r114.hasNext() == false) goto L26;
        Map.Entry r115 = (Map.Entry) r114.next();
        r106.putOpt((String) r115.getKey(), r115.getValue());
        goto L24
    L26:
        HashMap r107 = new HashMap();
        r107.put("sdk_callback_name", "first_remote_video_decoded_of_uid");
        r107.put("role_type", p());
        dy.b r108 = dy.b.f470518a;
        r107.put("android_event_key", "callback_".concat("first_remote_video_decoded_of_uid"));
        r108.d("ttlive_interact_sdk_callback", r105, 0, "", r107, r106);
        return;
    }

    public static /* synthetic */ void y(BaseMessage r100, long r101, int r110, long r111) {
        x(r100, r101, r110, r111, new JSONObject());
    }

    @JvmStatic
    public static final void x(BaseMessage r110, long r111, int r112, long r113, JSONObject r210) {
        Intrinsics.checkNotNullParameter(r110, "baseMessage");
        Intrinsics.checkNotNullParameter(r210, "extra");
        CommonMessageData r100 = r110.baseMessage;
        if (r100 == null) goto L10;
        String r101 = r100.method;
        if (r101 == null) goto L10;
        dy.b r102 = dy.b.f470518a;
        if (dy.b.c(r101) == false) goto L10;
        return;
    L10:
        if (r110.baseMessage != null) goto L12;
        return;
    L12:
        BaseMonitor.add(r210, "server_message_type", r112);
        CommonMessageData r103 = r110.getBaseMessage();
        long r104 = 0;
        if (r103 == null) goto L15;
        long r105 = r103.messageId;
    L16:
        BaseMonitor.add(r210, "server_message_id", r105);
        CommonMessageData r106 = r110.getBaseMessage();
        if (r106 == null) goto L19;
        r104 = r106.createTime;
    L19:
        BaseMonitor.add(r210, "server_message_fetch_time", r104);
        BaseMonitor.add(r210, "server_message_process_time", r113);
        CommonMessageData r107 = r110.getBaseMessage();
        String r108 = "";
        if (r107 == null) goto L23;
        String r109 = r107.logId;
        if (r109 == null) goto L23;
    L24:
        BaseMonitor.add(r210, "server_message_log_id", r109);
        BaseMonitor.add(r210, "server_message_channel_id", r111);
        CommonMessageData r114 = r110.getBaseMessage();
        if (r114 == null) goto L28;
        String r115 = r114.method;
        if (r115 == null) goto L28;
    L29:
        BaseMonitor.add(r210, "server_message_name", r115);
        BaseMonitor.add(r210, "message_data", GsonProtectorUtils.toJson(GsonHelper.get(), r110));
        if ((r110 instanceof xe) == false) goto L35;
        xe r116 = (xe) r110;
        BaseMonitor.add(r210, "server_link_mic_scene", r116.getScene());
        String r117 = r116.getRtcExtInfo();
        if (r117 != null) goto L34;
        r117 = "";
    L34:
        BaseMonitor.add(r210, "server_rtc_extra_info", r117);
    L35:
        f469074a.getClass();
        m(r210);
        LiveTracingMonitor.EventModule r118 = LiveTracingMonitor.EventModule.PK;
        LiveTracingMonitor.d("ttlive_pk_server_message_receive", r118, LiveTracingMonitor.EventType.MESSAGE_RECEIVED, r210);
        HashMap r119 = new HashMap();
        CommonMessageData r120 = r110.getBaseMessage();
        if (r120 == null) goto L38;
        String r121 = r120.method;
    L39:
        r119.put("server_message_name", r121);
        if ((r110 instanceof Cif) == false) goto L70;
        Cif r122 = (Cif) r110;
        if (r122.getMType() != 101) goto L65;
        dy.b r123 = dy.b.f470518a;
        StringBuilder r124 = new StringBuilder();
        CommonMessageData r125 = r110.getBaseMessage();
        if (r125 == null) goto L46;
        String r126 = r125.method;
    L47:
        r124.append(r126);
        r124.append("_");
        r124.append(r122.getMType());
        r124.append("_");
        LinkerSysKickOutContent r127 = r122.getMLinkerSysKickOutContent();
        if (r127 == null) goto L50;
        Integer r128 = Integer.valueOf(r127.getKickOutSource());
    L51:
        r124.append(r128.intValue());
        Comparable r129 = r124.toString();
        if (r129 != null) goto L54;
        r129 = 0;
    L54:
        r119.put("android_event_key", r129);
        LinkerSysKickOutContent r130 = r122.getMLinkerSysKickOutContent();
        if (r130 == null) goto L57;
        Integer r131 = Integer.valueOf(r130.getKickOutSource());
    L58:
        BaseMonitor.add(r210, "sys_kick_out_source", r131.intValue());
        LinkerSysKickOutContent r132 = r122.getMLinkerSysKickOutContent();
        if (r132 == null) goto L64;
        String r133 = r132.getLocalReasonToast();
        if (r133 == null) goto L64;
        r108 = r133;
    L64:
        BaseMonitor.add(r210, "sys_kick_out_reason", r108);
    L75:
        r119.put("role_type", p());
        dy.b r134 = dy.b.f470518a;
        CommonMessageData r135 = r110.getBaseMessage();
        if (r135 == null) goto L78;
        String r136 = r135.logId;
    L79:
        Intrinsics.checkNotNullParameter("ttlive_pk_server_message_receive", "event");
        Intrinsics.checkNotNullParameter(r118, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r119, "index");
        if (qd1.f121047a.getValue().booleanValue() == true) goto L83;
        return;
    L83:
        if (dy.b.c("ttlive_pk_server_message_receive") == true) goto L88;
        dy.b.a(r210);
        com.bytedance.android.live.core.monitor.trace.c.b(dy.b.b(r134, "ttlive_pk_server_message_receive", r118, r119, 0, null, r136, 0, 24), r210);
        return;
    L88:
        return;
    L78:
        r136 = null;
        goto L79
    L57:
        r131 = null;
        goto L58
    L50:
        r128 = null;
        goto L51
    L46:
        r126 = null;
        goto L47
    L65:
        dy.b r137 = dy.b.f470518a;
        StringBuilder r138 = new StringBuilder();
        CommonMessageData r139 = r110.getBaseMessage();
        if (r139 == null) goto L68;
        String r140 = r139.method;
    L69:
        r138.append(r140);
        r138.append("_");
        r138.append(r122.getMType());
        r119.put("android_event_key", r138.toString());
        goto L75
    L68:
        r140 = null;
        goto L69
    L70:
        dy.b r141 = dy.b.f470518a;
        CommonMessageData r142 = r110.getBaseMessage();
        if (r142 == null) goto L73;
        String r143 = r142.method;
    L74:
        r119.put("android_event_key", r143);
        goto L75
    L73:
        r143 = null;
        goto L74
    L38:
        r121 = null;
    L28:
        r115 = "";
    L23:
        r109 = "";
        goto L24
    L15:
        r105 = 0;
        goto L16
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void z(String r100, int r110, String r111, long r112, JSONObject r113) {
        dy.b r101 = dy.b.f470518a;
        if (dy.b.c(r100) == false) goto L5;
        return;
    L5:
        m(r113);
        BaseMonitor.add(r113, "duration", r112);
        BaseMonitor.add(r113, "server_api_name", r100);
        LiveTracingMonitor.EventModule r114 = LiveTracingMonitor.EventModule.PK;
        LiveTracingMonitor.c("ttlive_pk_server_api_call", r114, LiveTracingMonitor.EventType.SERVER_API_CALL, r110, r111, null, null, r113);
        HashMap r102 = new HashMap();
        r102.put("server_api_name", r100);
        r102.put("android_event_key", r100);
        r102.put("role_type", p());
        r101.d("ttlive_pk_server_api_call", r114, r110, r111, r102, r113);
    }
}
