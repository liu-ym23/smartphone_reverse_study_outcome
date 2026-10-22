package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent;
import com.bytedance.android.livesdk.chatroom.model.LinkerPrepareInviteContent;
import com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent;
import com.bytedance.android.livesdk.message.linker.LinkerLockPositionContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkRoomFightReplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerFollowStrongGuideContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerInvitePrepareContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLinkedListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLiveCoreBizTagChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLowBalanceForPaidLinkmicContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUILayoutChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeReplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerAudienceWaitingListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerAvatarAuditContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnlargeUpdateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInitChatRoomContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerRemoveWaitingUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u0000 `2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004:\u0001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001a8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u001f8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\t\u001a\u0004\b \u0010!R\u001c\u0010(\u001a\u0004\u0018\u00010$8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\t\u001a\u0004\b%\u0010&R\u001c\u0010-\u001a\u0004\u0018\u00010)8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\t\u001a\u0004\b*\u0010+R\u001c\u00102\u001a\u0004\u0018\u00010.8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\t\u001a\u0004\b/\u00100R\u001c\u00107\u001a\u0004\u0018\u0001038&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\t\u001a\u0004\b4\u00105R\u001c\u0010<\u001a\u0004\u0018\u0001088&X§\u0004¢\u0006\f\u0012\u0004\b;\u0010\t\u001a\u0004\b9\u0010:R\u001c\u0010A\u001a\u0004\u0018\u00010=8&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\t\u001a\u0004\b>\u0010?R\u001c\u0010F\u001a\u0004\u0018\u00010B8&X§\u0004¢\u0006\f\u0012\u0004\bE\u0010\t\u001a\u0004\bC\u0010DR\u001c\u0010K\u001a\u0004\u0018\u00010G8&X§\u0004¢\u0006\f\u0012\u0004\bJ\u0010\t\u001a\u0004\bH\u0010IR\u001c\u0010P\u001a\u0004\u0018\u00010L8&X§\u0004¢\u0006\f\u0012\u0004\bO\u0010\t\u001a\u0004\bM\u0010NR\u001c\u0010U\u001a\u0004\u0018\u00010Q8&X§\u0004¢\u0006\f\u0012\u0004\bT\u0010\t\u001a\u0004\bR\u0010SR\u001a\u0010Z\u001a\u00020V8&X§\u0004¢\u0006\f\u0012\u0004\bY\u0010\t\u001a\u0004\bW\u0010XR\u001c\u0010_\u001a\u0004\u0018\u00010[8&X§\u0004¢\u0006\f\u0012\u0004\b^\u0010\t\u001a\u0004\b\\\u0010]¨\u0006b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/i6;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/h1;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "Lcom/bytedance/android/livesdk/link/model/h6;", "getLinkedListChange", "()Lcom/bytedance/android/livesdk/link/model/h6;", "getLinkedListChange$annotations", "()V", "linkedListChange", "Lcom/bytedance/android/livesdk/link/model/r6;", "getWaitingListChange", "()Lcom/bytedance/android/livesdk/link/model/r6;", "getWaitingListChange$annotations", "waitingListChange", "Lcom/bytedance/android/livesdk/link/model/x5;", "getCancel", "()Lcom/bytedance/android/livesdk/link/model/x5;", "getCancel$annotations", "cancel", "Lcom/bytedance/android/livesdk/link/model/e6;", "getInvite", "()Lcom/bytedance/android/livesdk/link/model/e6;", "getInvite$annotations", "invite", "Lcom/bytedance/android/livesdk/link/model/k6;", "getReply", "()Lcom/bytedance/android/livesdk/link/model/k6;", "getReply$annotations", "reply", "Lcom/bytedance/android/livesdk/link/model/c4;", "getCrossRoomRTCInfoContent", "()Lcom/bytedance/android/livesdk/link/model/c4;", "getCrossRoomRTCInfoContent$annotations", "crossRoomRTCInfoContent", "Lcom/bytedance/android/livesdk/link/model/q6;", "getSwitchSceneContent", "()Lcom/bytedance/android/livesdk/link/model/q6;", "getSwitchSceneContent$annotations", "switchSceneContent", "Lcom/bytedance/android/livesdk/link/model/ILinkerCloseContent;", "getClose", "()Lcom/bytedance/android/livesdk/link/model/ILinkerCloseContent;", "getClose$annotations", "close", "Lcom/bytedance/android/livesdk/link/model/w5;", "getLinkerBanContent", "()Lcom/bytedance/android/livesdk/link/model/w5;", "getLinkerBanContent$annotations", "linkerBanContent", "Lcom/bytedance/android/livesdk/link/model/IAnchorUpdateLayoutContent;", "getAnchorUpdateLayoutContent", "()Lcom/bytedance/android/livesdk/link/model/IAnchorUpdateLayoutContent;", "getAnchorUpdateLayoutContent$annotations", "anchorUpdateLayoutContent", "Lcom/bytedance/android/livesdk/link/model/y5;", "getLinkerChangeMultiPkTeamInfoContent", "()Lcom/bytedance/android/livesdk/link/model/y5;", "getLinkerChangeMultiPkTeamInfoContent$annotations", "linkerChangeMultiPkTeamInfoContent", "Lcom/bytedance/android/live/base/model/data/i;", "getLinkerCrossRoomUpdateContent", "()Lcom/bytedance/android/live/base/model/data/i;", "getLinkerCrossRoomUpdateContent$annotations", "linkerCrossRoomUpdateContent", "Lcom/bytedance/android/livesdk/link/model/x;", "getAnchorUpdateLinkMicConfigContent", "()Lcom/bytedance/android/livesdk/link/model/x;", "getAnchorUpdateLinkMicConfigContent$annotations", "anchorUpdateLinkMicConfigContent", "Lcom/bytedance/android/livesdk/link/model/o6;", "getSwitchChannelInviteContent", "()Lcom/bytedance/android/livesdk/link/model/o6;", "getSwitchChannelInviteContent$annotations", "switchChannelInviteContent", "Lcom/bytedance/android/livesdk/link/model/p6;", "getSwitchChannelReplyContent", "()Lcom/bytedance/android/livesdk/link/model/p6;", "getSwitchChannelReplyContent$annotations", "switchChannelReplyContent", "Lcom/bytedance/android/livesdk/link/model/n6;", "getSwitchChannelCancelContent", "()Lcom/bytedance/android/livesdk/link/model/n6;", "getSwitchChannelCancelContent$annotations", "switchChannelCancelContent", "", "getVersion", "()J", "getVersion$annotations", "version", "", "getLynxData", "()Ljava/lang/String;", "getLynxData$annotations", "lynxData", "Companion", "a", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i6 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.h1>, com.bytedance.android.livesdk.link.model.bridge.h1, yh6.c {
    public static final a Companion = null;
    public static final int LINKER_APPLY = 4;
    public static final int LINKER_BAN = 15;
    public static final int LINKER_CANCEL_APPLY = 14;
    public static final int LINKER_CANCEL_INVITE = 9;
    public static final int LINKER_CLOSE = 2;
    public static final int LINKER_CREATE = 1;
    public static final int LINKER_DISPATCH_ITEM = 16;
    public static final int LINKER_ENTER = 6;
    public static final int LINKER_INVITE = 3;
    public static final int LINKER_KICK_OUT = 13;
    public static final int LINKER_LEAVE = 7;
    public static final int LINKER_LINKED_CHANGE = 11;
    public static final int LINKER_PERMIT = 8;
    public static final int LINKER_REPLY = 5;
    public static final int LINKER_SWITCH_CHANNEL_CANCEL = 62;
    public static final int LINKER_SWITCH_CHANNEL_INVITE = 60;
    public static final int LINKER_SWITCH_CHANNEL_REPLY = 61;
    public static final int LINKER_SYS_KICK_OUT = 101;
    public static final int LINKER_UPDATE_USER = 12;
    public static final int LINKER_WAITING_CHANGE = 10;
    public static final int TYPE_ANCHOR_STREAM_SWITCH = 24;
    public static final int TYPE_ANCHOR_UPDATE_LAYOUT = 51;
    public static final int TYPE_ANCHOR_UPDATE_LINKMIC_CONFIG = 50;
    public static final int TYPE_APPLY_STRONG_REMINDER = 23;
    public static final int TYPE_APPlY_EXPIRED = 22;
    public static final int TYPE_CHANGE_MEDIA_INFO = 53;
    public static final int TYPE_CROSS_ROOM_RTC_INFO = 49;
    public static final int TYPE_DEGRADE_ALERT = 35;
    public static final int TYPE_ENLARGE_GUEST_APPLY = 38;
    public static final int TYPE_ENLARGE_GUEST_INVITE = 36;
    public static final int TYPE_ENLARGE_GUEST_REPLY = 37;
    public static final int TYPE_FOLLOW_STRONG_GUIDE_CONTENT = 27;
    public static final int TYPE_GUEST_EXIT_CAST_SCREEN = 30;
    public static final int TYPE_GUEST_INVITE = 29;
    public static final int TYPE_LINKER_AVATAR_AUDIT_CONTENT = 20;
    public static final int TYPE_LINKER_CHANGE_MULTI_PK_TEAM_INFO = 42;
    public static final int TYPE_LINKER_CHANGE_PLAY_MODE = 33;
    public static final int TYPE_LINKER_CLICK_SCREEN = 25;
    public static final int TYPE_LINKER_CROSS_ROOM_UPDATE = 41;
    public static final int TYPE_LINKER_LIVE_CORE_BIZ_TAG_CHANGE = 72;
    public static final int TYPE_LINKER_SHARE_VIDEO_IM = 28;
    public static final int TYPE_LINKER_SWITCH_SCENE = 31;
    public static final int TYPE_LINKER_UILAYOUT_CHANGE = 54;
    public static final int TYPE_LINKER_UPDATE_LINK_TYPE_APPLY = 18;
    public static final int TYPE_LINKER_UPDATE_LINK_TYPE_REPLY = 19;
    public static final int TYPE_LINKER_VIOLATION_REMINDER = 17;
    public static final int TYPE_LINK_CANCEL_PREPARE_APPLY = 40;
    public static final int TYPE_LINK_PHASE = 32;
    public static final int TYPE_LINK_PREPARE_APPLY = 39;
    public static final int TYPE_LINK_RESUME_AUDIENCE = 46;
    public static final int TYPE_LOW_BALANCE_FOR_PAID_LINKMIC = 34;
    public static final int TYPE_RTC_ACTION = 64;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "anchor_stream_switch_content")
    /* synthetic */ u5 getAnchorStreamSwitchContent();

    @FieldName(name = "anchor_update_layout_content")
    IAnchorUpdateLayoutContent getAnchorUpdateLayoutContent();

    @FieldName(name = "anchor_update_linkmic_config_content")
    x getAnchorUpdateLinkMicConfigContent();

    /* synthetic */ com.bytedance.android.livesdk.message.linker.i getApplyStrongReminderContent();

    @FieldName(name = "audience_waiting_list_change")
    /* synthetic */ LinkerAudienceWaitingListChangeContent getAudienceWaitingListChangeContent();

    /* synthetic */ LinkerAvatarAuditContent getAvatarAuditContent();

    @FieldName(name = "cancel_content")
    x5 getCancel();

    @FieldName(name = "close_content")
    ILinkerCloseContent getClose();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "cross_room_rtc_info_content")
    c4 getCrossRoomRTCInfoContent();

    @FieldName(name = "enter_content")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.f1 getEnter();

    /* synthetic */ String getExtraStr();

    /* synthetic */ Object getFlexInstance();

    /* synthetic */ int getFromChannelFlex();

    @FieldName(name = "guest_invite_content")
    /* synthetic */ com.bytedance.android.live.base.model.data.j getGuestInviteContent();

    @FieldName(name = "invite_content")
    e6 getInvite();

    @FieldName(name = "leave_content")
    /* synthetic */ ILinkerLeaveContentBridge getLeave();

    /* synthetic */ com.bytedance.android.live.base.model.data.g getLinkRoomFightCancelInviteContent();

    @FieldName(name = "cross_room_link_invite_content")
    /* synthetic */ com.bytedance.android.live.base.model.data.h getLinkRoomFightInviteContent();

    /* synthetic */ ILinkRoomFightReplyContent getLinkRoomFightReplyContent();

    @FieldName(name = "linked_list_change_content")
    h6 getLinkedListChange();

    @FieldName(name = "ban_content")
    w5 getLinkerBanContent();

    @FieldName(name = "linker_base_info")
    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.q getLinkerBaseInfo();

    @FieldName(name = "linker_battle_connect_content")
    /* synthetic */ ILinkerBattleConnectContent getLinkerBattleConnectContent();

    @FieldName(name = "change_media_content")
    /* synthetic */ ILinkerChangeMediaInfoContent getLinkerChangeMediaInfoContent();

    @FieldName(name = "change_multi_pk_team_info_content")
    y5 getLinkerChangeMultiPkTeamInfoContent();

    @FieldName(name = "linker_client_ui_info_change_content")
    /* synthetic */ ILinkerClientUIInfoChangeContent getLinkerClientUIInfoChangeContent();

    /* synthetic */ LinkerConfirmUnsilenceContent getLinkerConfirmUnsilenceContent();

    @FieldName(name = "cross_room_update_content")
    com.bytedance.android.live.base.model.data.i getLinkerCrossRoomUpdateContent();

    /* synthetic */ com.bytedance.android.live.base.model.data.i getLinkerCrossRoomUpdateContentExt();

    /* synthetic */ com.bytedance.android.livesdk.message.linker.j getLinkerDegradeAlertContent();

    @FieldName(name = "enlarge_guest_apply_content")
    /* synthetic */ com.bytedance.android.livesdk.message.linker.f getLinkerEnlargeGuestApplyContent();

    @FieldName(name = "enlarge_guest_invite_content")
    /* synthetic */ com.bytedance.android.livesdk.message.linker.k getLinkerEnlargeGuestInviteContent();

    @FieldName(name = "enlarge_guest_reply_content")
    /* synthetic */ com.bytedance.android.livesdk.message.linker.g getLinkerEnlargeGuestReplyContent();

    @FieldName(name = "linker_enlarge_update_content")
    /* synthetic */ LinkerEnlargeUpdateContent getLinkerEnlargeUpdateContent();

    @FieldName(name = "linker_id")
    /* synthetic */ long getLinkerId();

    @FieldName(name = "init_chat_room_content")
    /* synthetic */ LinkerInitChatRoomContent getLinkerInitChatRoomContent();

    /* synthetic */ ILinkerInvitePrepareContent getLinkerInvitePrepareContent();

    @FieldName(name = "linker_live_core_biz_tag_change_content")
    /* synthetic */ ILinkerLiveCoreBizTagChangeContent getLinkerLiveCoreBizTagChangeContent();

    @FieldName(name = "linker_prepare_invite_content")
    /* synthetic */ LinkerPrepareInviteContent getLinkerPrepareInviteContent();

    @FieldName(name = "linker_prepare_reply_content")
    /* synthetic */ LinkerPrepareReplyContent getLinkerPrepareReplyContent();

    @FieldName(name = "linker_remove_waiting_user_content")
    /* synthetic */ LinkerRemoveWaitingUserContent getLinkerRemoveWaitingUserContent();

    @FieldName(name = "linker_resume_audience_content")
    /* synthetic */ l6 getLinkerResumeAudienceContent();

    /* synthetic */ ILinkerUILayoutChangeContent getLinkerUILayoutChangeContent();

    /* synthetic */ LinkerLockPositionContent getLockPositionContent();

    @FieldName(name = "linkmic_lynx_data")
    String getLynxData();

    @FieldName(name = "change_play_mode_content")
    /* synthetic */ com.bytedance.android.livesdk.message.linker.d getMChangePlayModeContent();

    @FieldName(name = "follow_strong_guide_content")
    /* synthetic */ ILinkerFollowStrongGuideContent getMFollowStrongGuideContent();

    @FieldName(name = "kick_out_content")
    /* synthetic */ com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent getMKickOut();

    /* synthetic */ ILinkerLinkedListChangeContent getMLinkedListChange();

    @FieldName(name = "sys_kick_out_content")
    /* synthetic */ LinkerSysKickOutContent getMLinkerSysKickOutContent();

    @FieldName(name = "low_balance_for_paid_linkmic_content")
    /* synthetic */ ILinkerLowBalanceForPaidLinkmicContent getMLowBalanceForPaidLinkContent();

    /* synthetic */ int getMType();

    @FieldName(name = "update_user_content")
    /* synthetic */ ILinkerUpdateUserContent getMUpdateUser();

    /* synthetic */ long getMessageId3();

    /* synthetic */ IPublicAreaCommon getOrInitPublicAreaCommon();

    @FieldName(name = "public_area_common")
    /* synthetic */ IPublicAreaCommon getPublicAreaCommon();

    /* synthetic */ long getReceiveNtpTimeFlex(long r1);

    @FieldName(name = "reply_content")
    k6 getReply();

    @FieldName(name = "rtc_action_content")
    /* synthetic */ ILinkerRTCActionContent getRtcActionContent();

    @FieldName(name = "scene")
    /* synthetic */ long getScene();

    @FieldName(name = "switch_channel_cancel_content")
    n6 getSwitchChannelCancelContent();

    @FieldName(name = "switch_channel_invite_content")
    o6 getSwitchChannelInviteContent();

    @FieldName(name = "switch_channel_reply_content")
    p6 getSwitchChannelReplyContent();

    @FieldName(name = "switch_scene_content")
    q6 getSwitchSceneContent();

    /* synthetic */ long getTimestampFlex();

    @FieldName(name = "message_type")
    /* synthetic */ long getType2();

    @FieldName(name = "update_link_type_apply_content")
    /* synthetic */ ILinkerUpdateLinkTypeApplyContent getUpdateLinkTypeApplyContent();

    @FieldName(name = "update_link_type_force_open_camera_content")
    /* synthetic */ ILinkerUpdateLinkTypeForceOpenCameraContent getUpdateLinkTypeForceOpenCameraContent();

    @FieldName(name = "update_link_type_reply_content")
    /* synthetic */ ILinkerUpdateLinkTypeReplyContent getUpdateLinkTypeReplyContent();

    /* synthetic */ IBaseUser getUserInMessage();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "waiting_list_change_content")
    r6 getWaitingListChange();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r1);

    /* synthetic */ void setLinkRoomFightCancelInviteContent(com.bytedance.android.live.base.model.data.g r1);

    @FieldName(name = "cross_room_link_invite_content#setter")
    /* synthetic */ void setLinkRoomFightInviteContent(com.bytedance.android.live.base.model.data.h r1);

    /* synthetic */ void setLinkRoomFightReplyContent(ILinkRoomFightReplyContent r1);

    /* synthetic */ void setLinkerCrossRoomUpdateContentExt(com.bytedance.android.live.base.model.data.i r1);

    @FieldName(name = "linker_live_core_biz_tag_change_content#setter")
    /* synthetic */ void setLinkerLiveCoreBizTagChangeContent(ILinkerLiveCoreBizTagChangeContent r1);
}
