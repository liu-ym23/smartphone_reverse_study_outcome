package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\u000fR\u001e\u0010 \u001a\u00060\rj\u0002`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u000fR\u001a\u0010#\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u000fR\"\u0010)\u001a\n\u0018\u00010$j\u0004\u0018\u0001`%8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0006\u001a\u0004\b&\u0010'R\u001a\u0010,\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b*\u0010\u0004R\u001a\u0010/\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0006\u001a\u0004\b-\u0010\u0017R\u001a\u00102\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0006\u001a\u0004\b0\u0010\u0017R\u001a\u00107\u001a\u0002038&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0006\u001a\u0004\b4\u00105R\u001a\u0010:\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0006\u001a\u0004\b8\u0010\u000fR\u001a\u0010=\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0006\u001a\u0004\b;\u0010\u000fR\u001a\u0010@\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0006\u001a\u0004\b>\u0010\u000fR\u001a\u0010C\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0006\u001a\u0004\bA\u0010\u0004R\u001c\u0010F\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\bE\u0010\u0006\u001a\u0004\bD\u0010\u0004R\u001c\u0010J\u001a\u0004\u0018\u0001038&X§\u0004¢\u0006\f\u0012\u0004\bI\u0010\u0006\u001a\u0004\bG\u0010HR\u001c\u0010M\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0006\u001a\u0004\bK\u0010\u0004R\u001c\u0010R\u001a\u0004\u0018\u00010N8&X§\u0004¢\u0006\f\u0012\u0004\bQ\u0010\u0006\u001a\u0004\bO\u0010PR\u001c\u0010W\u001a\u0004\u0018\u00010S8&X§\u0004¢\u0006\f\u0012\u0004\bV\u0010\u0006\u001a\u0004\bT\u0010UR\u001a\u0010Z\u001a\u00020\u00158&X§\u0004¢\u0006\f\u0012\u0004\bY\u0010\u0006\u001a\u0004\bX\u0010\u0017¨\u0006["}, d2 = {"Lcom/bytedance/android/livesdk/link/model/f2;", "Lvh7/c;", "", "getRivalSecUserId", "()Ljava/lang/String;", "getRivalSecUserId$annotations", "()V", "rivalSecUserId", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfo;", "getBattleUserInfo", "()Lcom/bytedance/android/livesdk/link/model/IBattleUserInfo;", "getBattleUserInfo$annotations", "battleUserInfo", "", "getBattleStartTime", "()J", "getBattleStartTime$annotations", "battleStartTime", "getRivalLivingRoomId", "getRivalLivingRoomId$annotations", "rivalLivingRoomId", "", "getBattleResultType", "()I", "getBattleResultType$annotations", "battleResultType", "getOwnHistoricRoomId", "getOwnHistoricRoomId$annotations", "ownHistoricRoomId", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "getChannelId$annotations", "channelId", "getMatchType", "getMatchType$annotations", "matchType", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getRivalLivingRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRivalLivingRoom$annotations", "rivalLivingRoom", "getSignExtra", "getSignExtra$annotations", "signExtra", "getFollowType", "getFollowType$annotations", "followType", "getIncreaseOrDecreaseInvite", "getIncreaseOrDecreaseInvite$annotations", "increaseOrDecreaseInvite", "", "getInviteRejectPermanent", "()Z", "getInviteRejectPermanent$annotations", "inviteRejectPermanent", "getAllCount", "getAllCount$annotations", "allCount", "getWinCount", "getWinCount$annotations", "winCount", "getLoseCount", "getLoseCount$annotations", "loseCount", "getBattleAttachedInfo", "getBattleAttachedInfo$annotations", "battleAttachedInfo", "getBattleId", "getBattleId$annotations", "battleId", "getInviteRejectTemporary", "()Ljava/lang/Boolean;", "getInviteRejectTemporary$annotations", "inviteRejectTemporary", "getChannleIdStr", "getChannleIdStr$annotations", "channleIdStr", "Lcom/bytedance/android/livesdk/link/model/h4;", "getFeedbackInfo", "()Lcom/bytedance/android/livesdk/link/model/h4;", "getFeedbackInfo$annotations", "feedbackInfo", "Lcom/bytedance/android/livesdk/link/model/h2;", "getSeasonInfo", "()Lcom/bytedance/android/livesdk/link/model/h2;", "getSeasonInfo$annotations", "seasonInfo", "getPlayMode", "getPlayMode$annotations", "playMode", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f2 extends vh7.c<f2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "all_count")
    long getAllCount();

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfo();

    @FieldName(name = "battle_id")
    String getBattleId();

    @FieldName(name = "battle_result_type")
    int getBattleResultType();

    @FieldName(name = "battle_start_time")
    long getBattleStartTime();

    @FieldName(name = "user_info")
    IBattleUserInfo getBattleUserInfo();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "channel_id_str")
    String getChannleIdStr();

    @FieldName(name = "feedback_info")
    h4 getFeedbackInfo();

    @FieldName(name = "follow_type")
    int getFollowType();

    @FieldName(name = "increase_or_decrease_invite")
    int getIncreaseOrDecreaseInvite();

    @FieldName(name = "invite_reject_permanent")
    boolean getInviteRejectPermanent();

    @FieldName(name = "invite_reject_temporary")
    Boolean getInviteRejectTemporary();

    @FieldName(name = "lose_count")
    long getLoseCount();

    @FieldName(name = "match_type")
    long getMatchType();

    @FieldName(name = "own_historic_room_id")
    long getOwnHistoricRoomId();

    @FieldName(name = "play_mode")
    int getPlayMode();

    @FieldName(name = "rival_living_room")
    IRoom getRivalLivingRoom();

    @FieldName(name = "rival_living_room_id")
    long getRivalLivingRoomId();

    @FieldName(name = "rival_open_id")
    String getRivalSecUserId();

    @FieldName(name = "season_info")
    h2 getSeasonInfo();

    @FieldName(name = "sign_extra")
    String getSignExtra();

    @FieldName(name = "win_count")
    long getWinCount();
}
