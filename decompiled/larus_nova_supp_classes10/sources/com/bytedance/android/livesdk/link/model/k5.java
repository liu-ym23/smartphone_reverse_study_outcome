package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004:\u0001:R.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001c\u0010\u0014R\u001a\u0010#\u001a\u00020\u001f8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010!R\"\u0010*\u001a\u00020$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\u000b\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u00100\u001a\u00060+j\u0002`,8&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\u000b\u001a\u0004\b-\u0010.R>\u00108\u001a&\u0012\b\u0012\u00060\u001fj\u0002`2\u0012\u0004\u0012\u00020301j\u0012\u0012\b\u0012\u00060\u001fj\u0002`2\u0012\u0004\u0012\u000203`48&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010\u000b\u001a\u0004\b5\u00106¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/k5;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/z0;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "Lcom/bytedance/android/livesdk/link/model/t1;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getUserScores", "()Ljava/util/List;", "getUserScores$annotations", "()V", "userScores", "", "getScoreUpdateLogId", "()Ljava/lang/String;", "getScoreUpdateLogId$annotations", "scoreUpdateLogId", "", "getUpdateMessageFrom", "()I", "getUpdateMessageFrom$annotations", "updateMessageFrom", "Lcom/bytedance/android/livesdk/link/model/n3;", "getBreakthroughInfo", "()Lcom/bytedance/android/livesdk/link/model/n3;", "getBreakthroughInfo$annotations", "breakthroughInfo", "getSwitchPlayMode", "getSwitchPlayMode$annotations", "switchPlayMode", "", "getMatchType", "()J", "getMatchType$annotations", "matchType", "Lcom/bytedance/android/livesdk/link/model/IBattleBarConfig;", "getBattleBarConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleBarConfig;", "setBattleBarConfig", "(Lcom/bytedance/android/livesdk/link/model/IBattleBarConfig;)V", "getBattleBarConfig$annotations", "battleBarConfig", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getFromUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getFromUser$annotations", "fromUser", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/UserId;", "Lcom/bytedance/android/livesdk/link/model/t0$a;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getAuxiliaryScoreInfo", "()Ljava/util/Map;", "getAuxiliaryScoreInfo$annotations", "auxiliaryScoreInfo", "Companion", "a", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k5 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.z0>, com.bytedance.android.livesdk.link.model.bridge.z0, yh6.c {
    public static final int BattleScoreUpdateFromType_AUDIENCE_P2P = 1;
    public static final int BattleScoreUpdateFromType_DEFAULT = 0;
    public static final a Companion = null;
    public static final int TYPE_AGREE_ADMIN_FIRST_INVITE = 15;
    public static final int TYPE_ALL_LIST_CHANGED = 7;
    public static final int TYPE_ANCHOR_INTERACT_TURN_ON = 100;
    public static final int TYPE_AUDIENCE_INVITED = 12;
    public static final int TYPE_AUDIENCE_REPLY = 13;
    public static final int TYPE_AUTO_JOIN = 14;
    public static final int TYPE_BATTLE_DATA = 202;
    public static final int TYPE_CANCELED_BY_SERVER = 105;
    public static final int TYPE_FAN_TICKET_CHANGED = 8;
    public static final int TYPE_FINISH = 4;
    public static final int TYPE_JOIN_GAME_BARRAGE_RTC = 18;
    public static final int TYPE_KICKED_OUT = 3;
    public static final int TYPE_LEAVE_GAME_BARRAGE_RTC = 19;
    public static final int TYPE_LINKED_LIST_CHANGED = 6;
    public static final int TYPE_PERMIT = 2;
    public static final int TYPE_SILENCE = 10;
    public static final int TYPE_SILENCE_PASSIVE = 16;
    public static final int TYPE_SWITCH_SCENE = 17;
    public static final int TYPE_TURN_ON = 1;
    public static final int TYPE_UNSILENCE = 11;
    public static final int TYPE_WAITING_LIST_CHANGED = 5;

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

    /* synthetic */ String getAckMessage();

    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.f getActionSource();

    /* synthetic */ long getAnchorLinkMicId();

    /* synthetic */ String getAnchorLinkMicIdStr();

    @FieldName(name = "auxiliary_score_infos")
    Map<Long, t0.a> getAuxiliaryScoreInfo();

    /* synthetic */ com.bytedance.android.livesdk.message.linker.b getBackupInfo();

    /* synthetic */ IBanUser getBanAnchorInfo();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getBaseMessage2();

    @FieldName(name = "battle_bar_config")
    IBattleBarConfig getBattleBarConfig();

    /* synthetic */ String getBizTag();

    @FieldName(name = "breakthrough_info")
    n3 getBreakthroughInfo();

    /* synthetic */ long getChannelId();

    /* synthetic */ com.bytedance.android.livesdk.chatroom.model.t getChorusAccompanimentInfo();

    /* synthetic */ com.bytedance.android.livesdk.chatroom.model.v getChorusCDNInfo();

    /* synthetic */ ClientUIInfo getClientUIInfo();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    /* synthetic */ int getControlType();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "from_user")
    IBaseUser getFromUser();

    /* synthetic */ String getFromUserIdStr();

    /* synthetic */ String getFunctionType2();

    /* synthetic */ String getGameBarrageLinkerFinishReason();

    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.e getGameInviteInfo();

    /* synthetic */ String getGetFromUserId();

    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.j1 getGuestLinkMicInfo();

    /* synthetic */ int getInitSource();

    /* synthetic */ py.k getInviteImage();

    /* synthetic */ com.bytedance.android.live.base.model.message.a5 getInviteMsg();

    /* synthetic */ String getInvitePrompt();

    /* synthetic */ String getInviteSubtitle();

    /* synthetic */ com.bytedance.android.livesdk.message.model.c8 getInvitorInfo();

    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.q0 getJoinChannelData();

    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.j0 getJoinTeamFightInfo();

    /* synthetic */ int getKickOutSource();

    /* synthetic */ int getLayout();

    /* synthetic */ long getLinkDuration();

    /* synthetic */ c6 getLinkGameInfo();

    /* synthetic */ int getLinkType();

    /* synthetic */ List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedListUsers();

    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.q getLinkerBaseInfo();

    /* synthetic */ Map<Long, com.bytedance.android.livesdk.link.model.bridge.g2> getLinkerContentMap();

    /* synthetic */ String getLinkerSessionId();

    /* synthetic */ String getLiveCoreExtInfo();

    /* synthetic */ List<LinkmicPositionItem> getLockedPositions();

    @FieldName(name = "match_type")
    long getMatchType();

    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.e0 getMcuContent();

    /* synthetic */ IMessageBoardInfo getMessageBoardInfo();

    /* synthetic */ long getMessageId2();

    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.u1 getMultiLiveCoreInfo();

    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo();

    /* synthetic */ String getOpenSource();

    /* synthetic */ long getPaidCount();

    /* synthetic */ List<Integer> getPlayModes();

    /* synthetic */ String getPrompts();

    /* synthetic */ int getPushRtcType();

    /* synthetic */ String getRemoteLinkerSessionId();

    /* synthetic */ String getReplyPrompts();

    /* synthetic */ int getReplyType();

    /* synthetic */ String getRivalLinkmicIdStr();

    /* synthetic */ String getRtcExtInfo();

    /* synthetic */ long getScene();

    /* synthetic */ String getSceneLayoutInfo();

    @FieldName(name = "score_update_log_id")
    String getScoreUpdateLogId();

    /* synthetic */ String getSecFromUserId();

    @FieldName(name = "switch_play_mode")
    int getSwitchPlayMode();

    /* synthetic */ boolean getSwitchToSilence();

    /* synthetic */ String getToUserId();

    /* synthetic */ String getTrackingData();

    /* synthetic */ long getType2();

    /* synthetic */ int getUiLayout();

    @FieldName(name = "update_message_from")
    int getUpdateMessageFrom();

    @FieldName(name = "user_scores")
    List<t1> getUserScores();

    /* synthetic */ int getValidScene();

    /* synthetic */ long getVersion();

    /* synthetic */ String get_fromUserId();

    /* synthetic */ String get_guestId();

    /* synthetic */ boolean isFromUser(String r1);

    /* synthetic */ boolean isSupportCamera();

    /* synthetic */ boolean isToUser(String r1);

    @FieldName(name = "battle_bar_config#setter")
    void setBattleBarConfig(IBattleBarConfig r1);

    /* synthetic */ void setChorusAccompanimentInfo(com.bytedance.android.livesdk.chatroom.model.t r1);

    /* synthetic */ void setChorusCDNInfo(com.bytedance.android.livesdk.chatroom.model.v r1);

    /* synthetic */ void setClientUIInfo(ClientUIInfo r1);

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r1);

    /* synthetic */ void setInitSource(int r1);

    /* synthetic */ void setInvitePrompt(String r1);

    /* synthetic */ void setInviteSubtitle(String r1);

    /* synthetic */ void setJoinChannelData(com.bytedance.android.live.liveinteract.plantform.model.q0 r1);

    /* synthetic */ void setLayout(int r1);

    /* synthetic */ void setLinkerSessionId(String r1);

    /* synthetic */ void setPushRtcType(int r1);

    /* synthetic */ void setRemoteLinkerSessionId(String r1);

    /* synthetic */ void setRivalLinkmicIdStr(String r1);

    /* synthetic */ void setScene(long r1);

    /* synthetic */ void setSupportCamera(boolean r1);

    /* synthetic */ void setTrackingData(String r1);

    /* synthetic */ void setUiLayout(int r1);
}
