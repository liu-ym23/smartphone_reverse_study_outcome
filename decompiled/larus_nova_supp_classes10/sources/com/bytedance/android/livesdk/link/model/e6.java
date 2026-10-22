package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001e\u0010\t\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\f\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010 \u001a\u00020\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\b\u001a\u0004\b!\u0010\u0006R\u001a\u0010(\u001a\u00020$8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\b\u001a\u0004\b%\u0010&R\u001c\u0010-\u001a\u0004\u0018\u00010)8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\b\u001a\u0004\b*\u0010+R\u001c\u00102\u001a\u0004\u0018\u00010.8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\b\u001a\u0004\b/\u00100R\u001a\u00105\u001a\u00020$8&X§\u0004¢\u0006\f\u0012\u0004\b4\u0010\b\u001a\u0004\b3\u0010&R\u001a\u00108\u001a\u00020$8&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010\b\u001a\u0004\b6\u0010&R\u001c\u0010;\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\b\u001a\u0004\b9\u0010\u0019R.\u0010B\u001a\u0016\u0012\u0004\u0012\u00020=\u0018\u00010<j\n\u0012\u0004\u0012\u00020=\u0018\u0001`>8&X§\u0004¢\u0006\f\u0012\u0004\bA\u0010\b\u001a\u0004\b?\u0010@R\u001a\u0010E\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\bD\u0010\b\u001a\u0004\bC\u0010\u0006R\u001a\u0010H\u001a\u00020\u001c8&X§\u0004¢\u0006\f\u0012\u0004\bG\u0010\b\u001a\u0004\bF\u0010\u001eR\u001a\u0010M\u001a\u00020I8&X§\u0004¢\u0006\f\u0012\u0004\bL\u0010\b\u001a\u0004\bJ\u0010KR\u001a\u0010P\u001a\u00020$8&X§\u0004¢\u0006\f\u0012\u0004\bO\u0010\b\u001a\u0004\bN\u0010&R\u001a\u0010S\u001a\u00020$8&X§\u0004¢\u0006\f\u0012\u0004\bR\u0010\b\u001a\u0004\bQ\u0010&R\u001a\u0010X\u001a\u00020T8&X§\u0004¢\u0006\f\u0012\u0004\bW\u0010\b\u001a\u0004\bU\u0010VR$\u0010_\u001a\u0004\u0018\u00010Y8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b^\u0010\b\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010c\u001a\u00060\u0003j\u0002``8&X§\u0004¢\u0006\f\u0012\u0004\bb\u0010\b\u001a\u0004\ba\u0010\u0006R\u001c\u0010f\u001a\u0004\u0018\u00010$8&X§\u0004¢\u0006\f\u0012\u0004\be\u0010\b\u001a\u0004\bd\u0010&R\u001a\u0010i\u001a\u00020I8&X§\u0004¢\u0006\f\u0012\u0004\bh\u0010\b\u001a\u0004\bg\u0010KR\u001c\u0010l\u001a\u0004\u0018\u00010$8&X§\u0004¢\u0006\f\u0012\u0004\bk\u0010\b\u001a\u0004\bj\u0010&R\u001c\u0010o\u001a\u0004\u0018\u00010$8&X§\u0004¢\u0006\f\u0012\u0004\bn\u0010\b\u001a\u0004\bm\u0010&¨\u0006p"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/e6;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/g1;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/RoomId;", "getFromRoomId", "()J", "getFromRoomId$annotations", "()V", "fromRoomId", "getToRoomId", "getToRoomId$annotations", "toRoomId", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo$annotations", "multiChannelInfo", "Lcom/bytedance/android/livesdk/link/model/j5;", "getFromLinkMicInfo", "()Lcom/bytedance/android/livesdk/link/model/j5;", "getFromLinkMicInfo$annotations", "fromLinkMicInfo", "Lcom/bytedance/android/livesdk/link/model/p;", "getAppliedUser", "()Lcom/bytedance/android/livesdk/link/model/p;", "getAppliedUser$annotations", "appliedUser", "", "getSupportMultiInvite", "()Z", "getSupportMultiInvite$annotations", "supportMultiInvite", "getCurInviteNum", "getCurInviteNum$annotations", "curInviteNum", "", "getToLinkMicIdStr", "()Ljava/lang/String;", "getToLinkMicIdStr$annotations", "toLinkMicIdStr", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo$annotations", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo$annotations", "multiLiveCoreInfo", "getToRtcExtInfo", "getToRtcExtInfo$annotations", "toRtcExtInfo", "getClientAttachedInfoStr", "getClientAttachedInfoStr$annotations", "clientAttachedInfoStr", "getInviteUser", "getInviteUser$annotations", "inviteUser", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTags", "()Ljava/util/List;", "getTags$annotations", "tags", "getWaitSec", "getWaitSec$annotations", "waitSec", "getSupportMultiPkTeamMode", "getSupportMultiPkTeamMode$annotations", "supportMultiPkTeamMode", "", "getMultiPkMode", "()I", "getMultiPkMode$annotations", "multiPkMode", "getInviteRejectTemporaryText", "getInviteRejectTemporaryText$annotations", "inviteRejectTemporaryText", "getGameAppId", "getGameAppId$annotations", "gameAppId", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getInviterVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getInviterVersionInfo$annotations", "inviterVersionInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "setPreRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/b2;)V", "getPreRtcInfo$annotations", "preRtcInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getToJoinChannelId", "getToJoinChannelId$annotations", "toJoinChannelId", "getBattleAttachedInfoStr", "getBattleAttachedInfoStr$annotations", "battleAttachedInfoStr", "getBizType", "getBizType$annotations", "bizType", "getPeerDesc", "getPeerDesc$annotations", "peerDesc", "getEventTrackingInfo", "getEventTrackingInfo$annotations", "eventTrackingInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e6 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.g1>, com.bytedance.android.livesdk.link.model.bridge.g1 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "applied_user")
    p getAppliedUser();

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfoStr();

    @FieldName(name = "biz_type")
    int getBizType();

    @FieldName(name = "client_attached_info")
    String getClientAttachedInfoStr();

    @FieldName(name = "cur_invite_num")
    long getCurInviteNum();

    @FieldName(name = "event_tracking_info")
    String getEventTrackingInfo();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "from_user_linkmic_info")
    j5 getFromLinkMicInfo();

    @FieldName(name = "from_room_id")
    long getFromRoomId();

    @FieldName(name = "open_game_app_id")
    String getGameAppId();

    @FieldName(name = "invite_reject_temporary_text")
    String getInviteRejectTemporaryText();

    /* synthetic */ int getInviteSource();

    @FieldName(name = "invite_user")
    p getInviteUser();

    /* synthetic */ List<com.bytedance.android.livesdk.link.model.bridge.k> getInviteeFollowUsers();

    /* synthetic */ List<com.bytedance.android.livesdk.link.model.bridge.k> getInviterUsers();

    @FieldName(name = "inviter_version_info")
    com.bytedance.android.livesdk.link.model.bridge.k2 getInviterVersionInfo();

    /* synthetic */ boolean getInviterWithAudience();

    @FieldName(name = "multi_channel_info")
    b7 getMultiChannelInfo();

    @FieldName(name = "multi_live_core_info")
    d7 getMultiLiveCoreInfo();

    @FieldName(name = "multi_pk_mode")
    int getMultiPkMode();

    @FieldName(name = "multi_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo();

    @FieldName(name = "peer_desc")
    String getPeerDesc();

    @FieldName(name = "pre_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo();

    @FieldName(name = "support_multi_invite")
    boolean getSupportMultiInvite();

    @FieldName(name = "support_multi_pk_team_mode")
    boolean getSupportMultiPkTeamMode();

    @FieldName(name = "tags")
    List<IBattleRivalTag> getTags();

    @FieldName(name = "to_join_channel_id")
    long getToJoinChannelId();

    @FieldName(name = "to_linkmic_id_str")
    String getToLinkMicIdStr();

    @FieldName(name = "to_room_id")
    long getToRoomId();

    @FieldName(name = "to_rtc_ext_info")
    String getToRtcExtInfo();

    @FieldName(name = "wait_sec")
    long getWaitSec();

    /* synthetic */ String get_fromUid();

    /* synthetic */ String get_secFromUid();

    @FieldName(name = "pre_rtc_info#setter")
    void setPreRtcInfo(com.bytedance.android.livesdk.link.model.bridge.b2 r1);
}
