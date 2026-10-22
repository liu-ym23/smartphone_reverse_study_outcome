package hi1;

import am2.q;
import am2.t;
import am2.x;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.livesdk.chatroom.multitask.LiveInnerIndependentManager;
import com.bytedance.android.livesdk.chatroom.utils.r3;
import com.bytedance.android.livesdk.config.q21;
import com.bytedance.android.livesdk.live.listprovider.DouyinXTabListProvider;
import com.bytedance.android.livesdk.log.filter.b0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;
import com.bytedance.android.livesdk.utils.d6;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.live.IBackRoomStackKt;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.enterparam.CommonEnterParamsData;
import com.bytedance.android.livesdkapi.enterparam.LiveCommonEnterParamUtil;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.larus.bmhome.share.panel.ShareChannel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jk1.i;
import ls2.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static void b(n0 r100, Bundle r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_SINGLE_ROOM_LIVE_REASON) == false) goto L7;
        String r102 = r101.getString(ILiveRoomPlayFragmentConstant.EXTRA_SINGLE_ROOM_LIVE_REASON, "");
        r100.f153324u.put("live_reason", r102);
    L7:
        if (r101.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_INSERT_TYPE) == false) goto L11;
        String r103 = r101.getString(ILiveRoomPlayFragmentConstant.EXTRA_INSERT_TYPE, "");
        r100.f153324u.put(ILiveRoomPlayFragmentConstant.EXTRA_INSERT_TYPE, r103);
        return;
    }

    public static void a(d r410, ik1.b r411, ik1.d r412, String r413, Bundle r414) {
        d r100 = r410;
        if (r414 == null) goto L496;
        o r101 = u.l().c(x.class);
        if (r101 == null) goto L422;
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_IS_SIMILAR);
        r101.remove("source");
        r101.remove("enter_from");
        r101.remove("enter_from_merge");
        r101.remove("enter_from_ad_type");
        r101.remove("video_id");
        r101.remove("first_video_id");
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_SUPERIOR_PAGE_FROM);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PUSH_TYPE);
        r101.remove("push_event");
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ACTIVE_TAG);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_INSTATION_PUSH_TYPE);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID);
        r101.remove("enter_method");
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_LOG_TOP_MESSAGE_TYPE);
        r101.remove("card_id");
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION);
        r101.remove("is_other_channel");
        r101.remove("search_id");
        r101.remove("search_type");
        r101.remove("tag_image_type");
        r101.remove("is_game_data");
        r101.remove("is_tag");
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_CAMERA_ENTER_FROM);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE);
        r101.remove("anchor_type");
        r101.remove("live_reason");
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_VIDEO_POINT_TYPE);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_OPERATION_LABEL);
        r101.remove("is_repeat");
        r101.remove("is_first_label");
        r101.remove("is_second_label");
        r101.remove("label_city");
        r101.remove("is_self_shared");
        r101.remove("magic3_comptype");
        r101.remove("magic3_activityId");
        r101.remove("magic3_source");
        r101.remove("entrance_form");
        r101.remove("vs_from_episode_id");
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_FROM_PUSH_ROOM_ID);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_REFLOW_VERSION_ID);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_VIDEO_TYPES);
        r101.remove(ILiveRoomPlayFragmentConstant.PROGRAM_ID);
        r101.remove(VSConstants.EXTRA_RECOMMEND_TYPE);
        r101.remove(VSConstants.EXTRA_BOOST_TASK_ID);
        r101.remove(VSConstants.EXTRA_INSERT_TASK_ID);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ENTRANCE_IS_CACHE_BUBBLE);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_PARAMS);
        r101.remove("is_cache_minimize");
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_REFLOW_VERSION_ID);
        r101.remove("vs_app_theme");
        r101.remove("is_follow_group");
        r101.remove("is_from_ad");
        r101.remove("module_name");
        r101.remove("page_type");
        r101.remove("search_type");
        r101.remove("from_bottom_bar");
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_IS_ECOM);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_BANNER_ORDER);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE);
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_SCHEMA_WITH_OUT_ROOM_ID);
        r101.remove("multi_live_style");
        r101.remove("is_from_dynamic_island");
        r101.remove("multi_live_id");
        r101.remove("multi_live_click_num");
        r101.remove("is_live_streaming");
        r101.remove("streaming_layout");
        r101.remove("to_anchor_id");
        r101.remove("to_room_id");
        r101.remove("to_room_name");
        r101.remove(LocationMonitorConst.IS_BACKGROUND);
        r101.remove("aggr_room_type");
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_CLICK_ROOM_ID);
        r101.remove("is_follow_bubble");
        r101.remove("entrance_room_id");
        r101.remove("previous_page");
        r101.remove("drawtab_page");
        r101.remove("is_drawtab");
        if (r410.f().containsKey(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID) == false) goto L10;
        r101.c("entrance_room_id", String.valueOf(r410.f().getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID)));
    L10:
        if (r410.f().containsKey("preview_stream_status") == false) goto L12;
        r101.c("preview_stream_status", r410.f().getString("preview_stream_status"));
    L12:
        boolean r102 = r101 instanceof n0;
        if (r102 == false) goto L16;
        n0 r110 = (n0) r101;
        r110.J();
        r110.r(false);
        r110.K();
        r110.f153324u.clear();
        b(r110, r414);
    L16:
        i.f(r410.f(), RoomParamsConsumeStage.PRE_INIT_LOGGER);
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_PARAMS) == false) goto L20;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_PARAMS, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_PARAMS));
    L20:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_ENV_PARAMS) == false) goto L23;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_ENV_PARAMS, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_ENV_PARAMS));
    L23:
        if (r414.containsKey("previous_page") == false) goto L26;
        r101.c("previous_page", r414.getString("previous_page"));
    L26:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_SCHEMA_WITH_OUT_ROOM_ID) == false) goto L33;
        if (r414.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_SCHEMA_WITH_OUT_ROOM_ID) == false) goto L30;
        String r103 = "1";
    L31:
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_SCHEMA_WITH_OUT_ROOM_ID, r103);
        goto L33
    L30:
        r103 = "0";
    L33:
        if (r414.containsKey("module_name") == false) goto L36;
        r101.c("module_name", r414.getString("module_name"));
    L36:
        if (r414.containsKey("page_type") == false) goto L39;
        r101.c("page_type", r414.getString("page_type"));
    L39:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_REFLOW_VERSION_ID) == false) goto L42;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_REFLOW_VERSION_ID, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_REFLOW_VERSION_ID));
    L42:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_FROM_PUSH_ROOM_ID) == false) goto L45;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_FROM_PUSH_ROOM_ID, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_FROM_PUSH_ROOM_ID));
    L45:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_PAID_LIVE_ENTRANCE_FORM) == false) goto L48;
        r101.c("entrance_form", r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_PAID_LIVE_ENTRANCE_FORM));
    L48:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_VIDEO_POINT_TYPE) == false) goto L51;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_VIDEO_POINT_TYPE, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_VIDEO_POINT_TYPE));
    L51:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_BANNER_ORDER) == false) goto L54;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_BANNER_ORDER, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_BANNER_ORDER));
    L54:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE) == false) goto L57;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE));
    L57:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.PROGRAM_ID) == false) goto L59;
        r101.c(ILiveRoomPlayFragmentConstant.PROGRAM_ID, r414.getString(ILiveRoomPlayFragmentConstant.PROGRAM_ID));
    L59:
        Bundle r104 = r410.f();
        if (r104 != null) goto L62;
        String r105 = "search_type";
    L115:
        if (r102 == 0) goto L124;
        if (r410.f() == null) goto L124;
        n0 r106 = (n0) r101;
        r106.T(r410.f().getString(ILiveRoomPlayFragmentConstant.IS_CHAT_AUTO_JOIN, null));
        if ("friend_delegate".equals(r410.f().getString(ILiveRoomPlayFragmentConstant.EXTRA_USER_DISTRIBUTION_SOURCE, "")) == false) goto L121;
        r106.U("chat_guest");
    L122:
        r106.F(r410.f().getString(ILiveRoomPlayFragmentConstant.IS_AUTO_LINK_MIC, null));
        r106.Q(r410.f().getString(ILiveRoomPlayFragmentConstant.AUTO_LINK_MIC_FROM_SEC_UID, null));
        r106.t(r410.f().getString("action", null));
        r106.S(r410.f().getString("from_user_id", null));
        r106.R(r410.f().getString(ILiveRoomPlayFragmentConstant.AUTO_LINK_MIC_FROM_TYPE, null));
        r106.P(r410.f().getInt(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE, -1));
        r106.O(r410.f().getString(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_SOURCE, null));
        r106.V(r410.f().getString(ILiveRoomPlayFragmentConstant.EXTRA_ENABLE_HINT_FROM_LINK_MIC_FLOAT, null));
        r106.Z(r410.f().getString(ILiveRoomPlayFragmentConstant.EXTRA_RELEVANT_LIVE_REQ_PARAMS, null));
        r106.Y(r410.f().getString(ILiveRoomPlayFragmentConstant.EXTRA_RELEVANT_LIVE_EXTRA_PARAMS, null));
        goto L124
    L121:
        r106.U("");
    L124:
        if (r414.containsKey("enter_method") == false) goto L137;
        String r107 = r414.getString("enter_method", "");
        r101.c("enter_method", r107);
        if (r102 == false) goto L140;
        if (TextUtils.equals(com.bytedance.android.livesdk.chatroom.backroom.utils.a.a(r410.f()), IBackRoomStackKt.JUMP_SOURCE_ROOM_BACK) == true) goto L130;
        ((n0) r101).W(r107);
    L132:
        if (ChatMatchViewModel.ENTER_METHOD_CONNECTION_MATCH_RESULT.equals(r107) == false) goto L140;
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LOG_ROOM_TAG) == false) goto L136;
        n0 r108 = (n0) r101;
        r108.a0(r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LOG_ROOM_TAG, ""));
        goto L140
    L136:
        ((n0) r101).a0("");
        goto L140
    L130:
        ((n0) r101).W("");
    L140:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE) == false) goto L144;
        String r109 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, "");
        if (r102 == 0) goto L147;
        ((n0) r101).X(r109);
    L147:
        if (r414.containsKey("enter_from_merge") == false) goto L150;
        r101.c("enter_from_merge", r414.getString("enter_from_merge", ""));
    L150:
        if (r414.containsKey("enter_from_ad_type") == false) goto L153;
        r101.c("enter_from_ad_type", r414.getString("enter_from_ad_type", ""));
    L153:
        if (r414.containsKey("source") == false) goto L156;
        String r111 = r414.getString("source", "");
        r414.remove("source");
        r101.c("source", String.valueOf(r111));
    L156:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_NOTICE_VIDEO_ROOM_INFO) == false) goto L158;
        String r112 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_NOTICE_VIDEO_ROOM_INFO, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_NOTICE_VIDEO_ROOM_INFO);
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_NOTICE_VIDEO_ROOM_INFO, r112);
    L158:
        r101.c("enter_from", r413);
        if (r414.containsKey("enter_from") == false) goto L162;
        r101.c("enter_from", r414.getString("enter_from", ""));
    L162:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID) == false) goto L165;
        long r113 = r414.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID, 0);
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID);
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID, String.valueOf(r113));
    L165:
        if (r414.containsKey(VSConstants.EXTRA_VS_FROM_EPISODE_ID) == false) goto L168;
        String r114 = r414.getString(VSConstants.EXTRA_VS_FROM_EPISODE_ID, "");
        r414.remove(VSConstants.EXTRA_VS_FROM_EPISODE_ID);
        r101.c("vs_from_episode_id", r114);
    L168:
        if (r414.containsKey("video_id") == false) goto L180;
        long r115 = r414.getLong("video_id", 0);
        String r116 = String.valueOf(r115);
        if (r115 != 0) goto L172;
        r116 = r414.getString("video_id");
    L172:
        r414.remove("video_id");
        r101.c("video_id", r116);
        r101.c("first_video_id", r116);
        Bundle r117 = r414.getBundle(ILiveRoomPlayFragmentConstant.EXTRA_FIRST_ROOM_LOG);
        if (r117 != null) goto L176;
        r117 = new Bundle();
        r414.putBundle(ILiveRoomPlayFragmentConstant.EXTRA_FIRST_ROOM_LOG, r117);
    L176:
        if (TextUtils.isEmpty(r116) == true) goto L180;
        if (r117.containsKey("video_id") == true) goto L180;
        r117.putString("video_id", r116);
    L180:
        String r118 = "order";
        if (r414.containsKey(r118) == false) goto L184;
        r101.c(r118, String.valueOf(r414.getInt(r118, 0)));
    L184:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_OPERATION_LABEL) == false) goto L187;
        String r119 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_OPERATION_LABEL, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_OPERATION_LABEL);
        r101.c("sub_info", r119);
    L187:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_SUPERIOR_PAGE_FROM) == false) goto L190;
        String r120 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_SUPERIOR_PAGE_FROM, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_SUPERIOR_PAGE_FROM);
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_SUPERIOR_PAGE_FROM, r120);
    L190:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PUSH_TYPE) == false) goto L193;
        String r121 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PUSH_TYPE, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PUSH_TYPE);
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PUSH_TYPE, r121);
    L193:
        if (r414.containsKey("event_type") == false) goto L196;
        String r122 = r414.getString("event_type", "");
        r414.remove("event_type");
        r101.c("push_event", r122);
    L196:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE) == false) goto L199;
        String r123 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE);
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r123);
    L199:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID) == false) goto L202;
        String r124 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID);
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r124);
    L202:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ACTIVE_TAG) == false) goto L205;
        String r125 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ACTIVE_TAG, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ACTIVE_TAG);
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ACTIVE_TAG, r125);
    L205:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_INSTATION_PUSH_TYPE) == false) goto L208;
        int r126 = r414.getInt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_INSTATION_PUSH_TYPE, 0);
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_INSTATION_PUSH_TYPE);
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_INSTATION_PUSH_TYPE, String.valueOf(r126));
    L208:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LOG_TOP_MESSAGE_TYPE) == false) goto L211;
        String r127 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LOG_TOP_MESSAGE_TYPE, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_LOG_TOP_MESSAGE_TYPE);
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_LOG_TOP_MESSAGE_TYPE, r127);
    L211:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.XT_EXTRA_PREVIOUS_ENTER_FROM_MERGE) == false) goto L216;
        if (r101.getMap().containsKey(ILiveRoomPlayFragmentConstant.XT_EXTRA_PREVIOUS_ENTER_FROM_MERGE) == true) goto L216;
        String r128 = r414.getString(ILiveRoomPlayFragmentConstant.XT_EXTRA_PREVIOUS_ENTER_FROM_MERGE);
        r414.remove(ILiveRoomPlayFragmentConstant.XT_EXTRA_PREVIOUS_ENTER_FROM_MERGE);
        r101.c(ILiveRoomPlayFragmentConstant.XT_EXTRA_PREVIOUS_ENTER_FROM_MERGE, r128);
    L216:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.XT_EXTRA_PREVIOUS_ENTER_METHOD) == false) goto L221;
        if (r101.getMap().containsKey(ILiveRoomPlayFragmentConstant.XT_EXTRA_PREVIOUS_ENTER_METHOD) == true) goto L221;
        String r129 = r414.getString(ILiveRoomPlayFragmentConstant.XT_EXTRA_PREVIOUS_ENTER_METHOD);
        r414.remove(ILiveRoomPlayFragmentConstant.XT_EXTRA_PREVIOUS_ENTER_METHOD);
        r101.c(ILiveRoomPlayFragmentConstant.XT_EXTRA_PREVIOUS_ENTER_METHOD, r129);
    L221:
        if (r414.containsKey(AppConstants.BUNDLE_GD_LABEL) == false) goto L224;
        r101.c(AppConstants.BUNDLE_GD_LABEL, r414.getString(AppConstants.BUNDLE_GD_LABEL, ""));
    L224:
        if (r414.containsKey("card_id") == false) goto L227;
        r101.c("card_id", r414.getString("card_id"));
    L227:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION) == false) goto L230;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION));
    L230:
        if (r414.containsKey("live_reason") == false) goto L233;
        r101.c("live_reason", r414.getString("live_reason", ""));
    L233:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO) == false) goto L236;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO, ""));
    L236:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_CHALLENGE_PAGE) == false) goto L239;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_CHALLENGE_PAGE, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_CHALLENGE_PAGE));
    L239:
        if (r414.containsKey("tag_id") == false) goto L242;
        r101.c("tag_id", r414.getString("tag_id"));
    L242:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_HOTSPOT_TITLE) == false) goto L245;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_HOTSPOT_TITLE, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_HOTSPOT_TITLE));
    L245:
        if (r410.f() == null) goto L249;
        String r130 = "search_id";
        if (r410.f().containsKey(r130) == false) goto L251;
        r101.c(r130, r410.f().getString(r130));
    L251:
        if (r410.f() == null) goto L256;
        if (r410.f().containsKey(r105) == false) goto L256;
        r101.c(r105, r410.f().getString(r105));
    L256:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_TITLE) == false) goto L259;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_TITLE, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_TITLE, ""));
    L259:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_CONTENT) == false) goto L262;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_CONTENT, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_CONTENT, ""));
    L262:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_CREATE_TIME_TO_NOW) == false) goto L265;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_CREATE_TIME_TO_NOW, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_CREATE_TIME_TO_NOW, ""));
    L265:
        if (r410.f() == null) goto L270;
        if (r410.f().getBoolean("enter_from_effect_ad", false) == false) goto L270;
        r101.c("is_other_channel", com.bytedance.android.ec.core.event.a.VALUE_EFFECTIVE_AD);
    L270:
        if (r410.f() == null) goto L275;
        if (r410.f().getBoolean("enter_from_dou_plus", false) == false) goto L275;
        r101.c("is_other_channel", IPerformanceManager.SCENE_CLICK_DOU_PLUS);
    L275:
        if (r410.f() == null) goto L280;
        if (TextUtils.isEmpty(r410.f().getString("search_params")) == true) goto L280;
        r101.c("search_params", r410.f().getString("search_params"));
    L280:
        if (r410.f() == null) goto L284;
        Bundle r131 = r410.f();
        String r132 = ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE;
        if (r131.containsKey(r132) == false) goto L286;
        r101.c(r132, r410.f().getString(r132));
    L289:
        if (r410.f() == null) goto L293;
        String r133 = "anchor_type";
        if (r410.f().containsKey(r133) == false) goto L295;
        r101.c(r133, r410.f().getString(r133));
    L298:
        if (r410.f() == null) goto L303;
        if (r410.f().containsKey(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FRIEND_SOURCE) == false) goto L303;
        r101.c("is_repeat", String.valueOf(r410.f().getInt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FRIEND_SOURCE)));
    L303:
        if (r410.f() == null) goto L308;
        if (r410.f().containsKey(ILiveRoomPlayFragmentConstant.AUTO_LINK_MIC_FROM_TYPE) == false) goto L308;
        r101.c(ILiveRoomPlayFragmentConstant.AUTO_LINK_MIC_FROM_TYPE, r410.f().getString(ILiveRoomPlayFragmentConstant.AUTO_LINK_MIC_FROM_TYPE));
    L308:
        if (r410.f() == null) goto L313;
        if (r410.f().containsKey("is_cache_minimize") == false) goto L313;
        r101.c("is_cache_minimize", r410.f().getString("is_cache_minimize"));
    L313:
        if (r410.f() == null) goto L318;
        if (r410.f().containsKey("from_user_id") == false) goto L318;
        r101.c("from_user_id", r410.f().getString("from_user_id"));
    L318:
        if (r410.f() == null) goto L323;
        if (r410.f().containsKey("content_type") == false) goto L323;
        r101.c("content_type", r410.f().getString("content_type"));
    L323:
        if (r410.f() == null) goto L328;
        if (r410.f().containsKey("token_form") == false) goto L328;
        r101.c("token_form", r410.f().getString("token_form"));
    L328:
        if (r410.f() == null) goto L333;
        if (r410.f().containsKey("is_follow_bubble") == false) goto L333;
        r101.c("is_follow_bubble", r410.f().getString("is_follow_bubble", "0"));
    L333:
        if (StringUtils.isEmpty(r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_FEED_FIRST_LABEL, "")) == true) goto L336;
        r101.c("is_first_label", r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_FEED_FIRST_LABEL));
    L336:
        if (StringUtils.isEmpty(r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_FEED_SECOND_LABEL, "")) == true) goto L339;
        r101.c("is_second_label", r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_FEED_SECOND_LABEL));
    L339:
        if (StringUtils.isEmpty(r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_FEED_LABEL_CITY, "")) == true) goto L342;
        r101.c("label_city", r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_FEED_LABEL_CITY));
    L342:
        if (StringUtils.isEmpty(r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_FEED_LABEL_RECOMMEND, "")) == true) goto L345;
        r101.c("is_self_shared", r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_FEED_LABEL_RECOMMEND, ""));
    L345:
        if (StringUtils.isEmpty(r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_MAGIC3_COMPTYPE, "")) == true) goto L348;
        r101.c("magic3_comptype", r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_MAGIC3_COMPTYPE));
    L348:
        if (StringUtils.isEmpty(r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_MAGIC3_ACTIVITYID, "")) == true) goto L351;
        r101.c("magic3_activityId", r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_MAGIC3_ACTIVITYID));
    L351:
        if (StringUtils.isEmpty(r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_MAGIC3_SOURCE, "")) == true) goto L354;
        r101.c("magic3_source", r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_MAGIC3_SOURCE));
    L354:
        if (StringUtils.isEmpty(r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ENTRANCE_IS_CACHE_BUBBLE, "")) == true) goto L357;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ENTRANCE_IS_CACHE_BUBBLE, r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ENTRANCE_IS_CACHE_BUBBLE));
    L357:
        if (r410.f() == null) goto L362;
        if (r410.f().containsKey(LocationMonitorConst.IS_BACKGROUND) == false) goto L362;
        r101.c(LocationMonitorConst.IS_BACKGROUND, "1");
    L362:
        if (r410.f() == null) goto L364;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ENTER_CONTENT_CATEGORY, r410.f().getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_CONTENT_CATEGORY, "0"));
    L364:
        if (r102 == 0) goto L379;
        if (StringUtils.isEmpty(r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_EXTRA_PARAMS, "")) == true) goto L379;
        JSONObject r134 = new JSONObject(r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_EXTRA_PARAMS));     // Catch: Exception -> L376
        Iterator<String> r135 = r134.keys();     // Catch: Exception -> L376
    L369:
        if (r135.hasNext() == false) goto L379;
        String r136 = r135.next();     // Catch: Exception -> L376
        String r137 = r134.optString(r136);     // Catch: Exception -> L376
        if (StringUtils.isEmpty(r136) == true) goto L369;
        if (StringUtils.isEmpty(r137) == true) goto L369;
        ((n0) r101).E(r136, r137);     // Catch: Exception -> L376
    L376:
        e = move-exception;
        Logger.e("LoggerInitHelper", "parse schema event_pass_params error ", e);
    L379:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_VIDEO_TYPES) == false) goto L382;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_VIDEO_TYPES, String.valueOf(r414.getInt(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_VIDEO_TYPES, 0)));
    L382:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_FIRST_ROOM_LOG) == false) goto L385;
        n0 r138 = (n0) r101;
        r138.M(r414.getBundle(ILiveRoomPlayFragmentConstant.EXTRA_FIRST_ROOM_LOG));
    L385:
        if (r410.f() != null) goto L387;
    L394:
        CommonEnterParamsData r139 = LiveCommonEnterParamUtil.getCommonParamsData(r410.f());
        if (r139 == null) goto L397;
        n0 r140 = (n0) r101;
        r140.s(r139.getMobParams());
        int r141 = 0;
        r140.G(r139.getFirstRoomMobParams(), false);
    L398:
        i.f(r410.f(), RoomParamsConsumeStage.POST_INIT_LOGGER);
        if (q21.a() == true) goto L401;
        r101.c("vs_app_theme", sm3.a.b());
    L401:
        if (r411 != null) goto L403;
    L411:
        r100 = r410;
        IExternalConfigJudger r142 = ((ti1.b) r100.a(ti1.b.class)).getExternalConfigJudger();
        if (r142 == null) goto L419;
        if (r142.getCommonParams() == null) goto L419;
        if (r142.getCommonParams().size() <= 0) goto L419;
        ((n0) r101).L(r142.getCommonParams());
    L419:
        if (LiveInnerIndependentManager.c(r410.e()) == false) goto L421;
        r101.c("session_type", "aweme_live");
    L423:
        o r143 = u.l().c(q.class);
        if (r143 == null) goto L443;
        r143.remove(r118);
        r143.remove("is_auto_play");
        r143.remove("first_request_page");
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ORDER) == false) goto L429;
        String r144 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ORDER, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ORDER);
        r143.c(r118, r144);
    L429:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_IS_AUTO_PLAY) == false) goto L432;
        String r145 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_IS_AUTO_PLAY, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_IS_AUTO_PLAY);
        r143.c("is_auto_play", r145);
    L432:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_FIRST_REQUEST_PAGE) == false) goto L435;
        String r146 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_FIRST_REQUEST_PAGE, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_FIRST_REQUEST_PAGE);
        r143.c("first_request_page", r146);
    L435:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_IS_INSERTED) == false) goto L438;
        String r147 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_IS_INSERTED, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_IS_INSERTED);
        r143.c("is_inserted", r147);
    L438:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ANCHOR_ID) == false) goto L441;
        String r148 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ANCHOR_ID, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ANCHOR_ID);
        r143.c("lifve_end_anchor_id", r148);
    L441:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ROOM_ID) == false) goto L443;
        String r149 = r414.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ROOM_ID, "");
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_END_ROOM_ID);
        r143.c("live_end_room_id", r149);
    L443:
        o r150 = u.l().c(am2.o.class);
        if ((r150 instanceof b0) == true) goto L446;
    L453:
        o r151 = u.l().c(t.class);
        if (r151 == null) goto L496;
        t r152 = new t();
        long[] r153 = r414.getLongArray(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SEARCH_ROOM_ID);
        if (r153 != null) goto L458;
    L480:
        r151.getMap().clear();
    L481:
        int r154 = d6.f158931a;
        r152.g(d6.a(r410.f()));
        if (r410.f() != null) goto L484;
        Serializable r155 = null;
    L486:
        if ((r155 instanceof HashMap) == false) goto L490;
        Object r156 = ((HashMap) r155).get("log_extra");
        if ((r156 instanceof String) == false) goto L490;
        r152.f((String) r156);
    L490:
        ck1.d r157 = (ck1.d) r100.a(ck1.d.class);
        r151.setData(r152);
        if (r412 == null) goto L496;
        if (r412.d() == null) goto L496;
        r3.a(r157.V2(), r412.d().a(), r412.d().b(), r152.c());
        goto L496
    L484:
        r155 = r410.f().getSerializable(ILiveRoomPlayFragmentConstant.DATA_LIVE_EFFECT_AD_LOG_EXTRA_MAP);
        goto L486
    L458:
        if (r153.length <= 0) goto L480;
        String[] r158 = r414.getStringArray(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SEARCH_ID);
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SEARCH_ID) == false) goto L462;
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SEARCH_ID);
    L462:
        String[] r159 = r414.getStringArray(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SEARCH_RESULT_ID);
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SEARCH_RESULT_ID) == false) goto L466;
        r414.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SEARCH_RESULT_ID);
    L466:
        if (r141 >= r153.length) goto L481;
        if (r158 != null) goto L469;
    L471:
        String r160 = "";
    L472:
        if (r159 != null) goto L474;
    L476:
        String r161 = "";
    L477:
        r152.a().put(Long.valueOf(r153[r141]), r160);
        r152.e().put(Long.valueOf(r153[r141]), r161);
        JSONObject r162 = new JSONObject();     // Catch: JSONException -> L501
        r162.put(r130, r160);     // Catch: JSONException -> L501
        r162.put("search_result_id", r161);     // Catch: JSONException -> L501
        r152.d().put(Long.valueOf(r153[r141]), r162.toString());     // Catch: JSONException -> L501
    L479:
        r141 = r141 + 1;
        goto L466
    L474:
        if (r141 >= r159.length) goto L476;
        r161 = r159[r141];
        goto L477
    L469:
        if (r141 >= r158.length) goto L471;
        r160 = r158[r141];
        goto L472
    L446:
        if (r410.f() == null) goto L448;
        long r163 = r410.f().getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID);
    L450:
        if (r414.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LOG_DRAWER) == false) goto L452;
        Map<? extends String, ? extends String> r164 = (Map) r414.getSerializable(ILiveRoomPlayFragmentConstant.EXTRA_LOG_DRAWER);
        r150.getMap().putAll(r164);
    L452:
        ((b0) r150).J(r163);
        goto L453
    L448:
        r163 = 0;
        goto L450
    L421:
        r101.c("session_type", ShareChannel.DOUYIN);
        goto L423
    L403:
        if (r411.d() == null) goto L411;
        if ((r411.d() instanceof DouyinXTabListProvider) == false) goto L411;
        if (r411.d().getRoomArgs(r410.d()) == null) goto L411;
        String r165 = r411.d().getRoomArgs(r410.d()).getString(ILiveRoomPlayFragmentConstant.EXTRA_IS_SIMILAR);
        if (TextUtils.isEmpty(r165) == true) goto L411;
        r101.c(ILiveRoomPlayFragmentConstant.EXTRA_IS_SIMILAR, r165);
        goto L411
    L397:
        r141 = 0;
        goto L398
    L387:
        if (r410.f().containsKey(ILiveRoomPlayFragmentConstant.EXTRA_COMMON_LOG) == false) goto L394;
        Bundle r166 = r410.f().getBundle(ILiveRoomPlayFragmentConstant.EXTRA_COMMON_LOG);
        if (r166 == null) goto L394;
        Iterator<String> r167 = r166.keySet().iterator();
    L392:
        if (r167.hasNext() == false) goto L394;
        String r168 = r167.next();
        ((n0) r101).E(r168, String.valueOf(r166.get(r168)));
    L295:
        if (r414.containsKey(r133) == false) goto L298;
        r101.c(r133, r414.getString(r133));
        goto L298
    L293:
        r133 = "anchor_type";
    L286:
        if (r414.containsKey(r132) == false) goto L289;
        r101.c(r132, r414.getString(r132));
        goto L289
    L284:
        r132 = ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE;
        goto L286
    L249:
        r130 = "search_id";
        goto L251
    L144:
        if (r102 == 0) goto L147;
        ((n0) r101).X("");
        goto L147
    L137:
        if (r102 == 0) goto L140;
        ((n0) r101).W("");
        goto L140
    L62:
        if (r104.containsKey("aggr_room_type") == false) goto L65;
        r101.c("aggr_room_type", r104.getString("aggr_room_type"));
    L65:
        if (r104.containsKey("multi_live_style") == false) goto L70;
        int r169 = r104.getInt("multi_live_style", 0);
        r101.c("multi_live_style", String.valueOf(r169));
        if (r169 != 1) goto L70;
        r101.c("multi_live_id", String.valueOf(r104.getLong("multi_live_id", 0)));
        r101.c("multi_live_click_num", String.valueOf(r104.getInt("multi_live_click_num", 0)));
    L70:
        if (r104.containsKey(VSConstants.EXTRA_RECOMMEND_TYPE) == false) goto L73;
        r101.c("vs_rec_type", r410.f().getString(VSConstants.EXTRA_RECOMMEND_TYPE));
    L73:
        if (r104.containsKey(VSConstants.EXTRA_INSERT_TASK_ID) == false) goto L76;
        r101.c("vs_force_task_id", r410.f().getString(VSConstants.EXTRA_INSERT_TASK_ID));
    L76:
        if (r104.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_FOLLOW_GROUP_ID) == false) goto L79;
        r101.c("is_follow_group", "1");
    L79:
        if (r104.containsKey(VSConstants.EXTRA_BOOST_TASK_ID) == false) goto L82;
        r101.c("vs_boost_task_id", r410.f().getString(VSConstants.EXTRA_BOOST_TASK_ID, ""));
    L82:
        if (r104.containsKey("is_from_ad") == false) goto L84;
        r101.c("is_from_ad", String.valueOf(r104.getInt("is_from_ad", 0)));
    L84:
        r105 = "search_type";
        if (r104.containsKey(r105) == false) goto L88;
        r101.c(r105, r104.getString(r105, ""));
    L88:
        if (r104.containsKey("is_live_streaming") == false) goto L91;
        r101.c("is_live_streaming", r104.getString("is_live_streaming", ""));
    L91:
        if (r104.containsKey("streaming_layout") == false) goto L94;
        r101.c("streaming_layout", r104.getString("streaming_layout", ""));
    L94:
        if (r104.containsKey("to_anchor_id") == false) goto L97;
        r101.c("to_anchor_id", r104.getString("to_anchor_id", ""));
    L97:
        if (r104.containsKey("to_room_id") == false) goto L100;
        r101.c("to_room_id", r104.getString("to_room_id", ""));
    L100:
        if (r104.containsKey("to_room_name") == false) goto L103;
        r101.c("to_room_name", r104.getString("to_room_name", ""));
    L103:
        if (r104.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_MULTI_TAB_DRAWTAB_PAGE) == false) goto L111;
        if (r411 == null) goto L111;
        if (r411.e() == null) goto L111;
        if (r411.e().getHasTabChanged() == false) goto L111;
        r101.c("drawtab_page", r104.getString(ILiveRoomPlayFragmentConstant.EXTRA_MULTI_TAB_DRAWTAB_PAGE));
    L111:
        if (r104.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_MULTI_TAB_CONTAINER, false) == false) goto L113;
        r101.c("is_drawtab", "1");
        goto L115
    L113:
        r101.c("is_drawtab", "0");
        goto L115
    L422:
        r118 = "order";
        r130 = "search_id";
        r141 = 0;
    L496:
        if (r410.f() != null) goto L498;
        return;
    L498:
        if (r410.f().containsKey(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE) == false) goto L518;
        long r170 = r410.f().getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID);
        com.bytedance.android.livesdk.log.o.a().b(r170, r410.f().getString(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE));
        r410.f().remove(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE);
        return;
    }
}
