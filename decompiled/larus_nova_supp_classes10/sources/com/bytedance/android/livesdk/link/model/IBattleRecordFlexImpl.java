package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RecordResponse.BattleRecord")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\\\u0010]R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010!\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010 R\u001b\u0010$\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u0018R\u001b\u0010'\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b&\u0010\u0018R\u001b\u0010*\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b)\u0010\u0018R\u001b\u0010-\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\f\u001a\u0004\b,\u0010\u000eR\u001b\u00100\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010 R\u001b\u00103\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\f\u001a\u0004\b2\u0010 R\u001b\u00108\u001a\u0002048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\f\u001a\u0004\b6\u00107R\u001b\u0010;\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\f\u001a\u0004\b:\u0010\u0018R\u001b\u0010>\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\f\u001a\u0004\b=\u0010\u0018R\u001b\u0010A\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\f\u001a\u0004\b@\u0010\u0018R\u001b\u0010D\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\f\u001a\u0004\bC\u0010\u000eR\u001d\u0010G\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\f\u001a\u0004\bF\u0010\u000eR\u001d\u0010K\u001a\u0004\u0018\u0001048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\f\u001a\u0004\bI\u0010JR\u001d\u0010N\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\f\u001a\u0004\bM\u0010\u000eR\u001d\u0010S\u001a\u0004\u0018\u00010O8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\f\u001a\u0004\bQ\u0010RR\u001d\u0010X\u001a\u0004\u0018\u00010T8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\f\u001a\u0004\bV\u0010WR\u001b\u0010[\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\f\u001a\u0004\bZ\u0010 ¨\u0006^"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRecordFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/f2;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "rivalLivingRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRivalLivingRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setRivalLivingRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "", "rivalSecUserId$delegate", "Ljava/lang/Object;", "getRivalSecUserId", "()Ljava/lang/String;", "rivalSecUserId", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfoFlexImpl;", "battleUserInfo$delegate", "getBattleUserInfo", "()Lcom/bytedance/android/livesdk/link/model/IBattleUserInfoFlexImpl;", "battleUserInfo", "", "battleStartTime$delegate", "getBattleStartTime", "()J", "battleStartTime", "rivalLivingRoomId$delegate", "getRivalLivingRoomId", "rivalLivingRoomId", "", "battleResultType$delegate", "getBattleResultType", "()I", "battleResultType", "ownHistoricRoomId$delegate", "getOwnHistoricRoomId", "ownHistoricRoomId", "channelId$delegate", "getChannelId", "channelId", "matchType$delegate", "getMatchType", "matchType", "signExtra$delegate", "getSignExtra", "signExtra", "followType$delegate", "getFollowType", "followType", "increaseOrDecreaseInvite$delegate", "getIncreaseOrDecreaseInvite", "increaseOrDecreaseInvite", "", "inviteRejectPermanent$delegate", "getInviteRejectPermanent", "()Z", "inviteRejectPermanent", "allCount$delegate", "getAllCount", "allCount", "winCount$delegate", "getWinCount", "winCount", "loseCount$delegate", "getLoseCount", "loseCount", "battleAttachedInfo$delegate", "getBattleAttachedInfo", "battleAttachedInfo", "battleId$delegate", "getBattleId", "battleId", "inviteRejectTemporary$delegate", "getInviteRejectTemporary", "()Ljava/lang/Boolean;", "inviteRejectTemporary", "channleIdStr$delegate", "getChannleIdStr", "channleIdStr", "Lcom/bytedance/android/livesdk/link/model/IFeedBackInfoFlexImpl;", "feedbackInfo$delegate", "getFeedbackInfo", "()Lcom/bytedance/android/livesdk/link/model/IFeedBackInfoFlexImpl;", "feedbackInfo", "Lcom/bytedance/android/livesdk/link/model/IBattleRecordsSeasonInfoFlexImpl;", "seasonInfo$delegate", "getSeasonInfo", "()Lcom/bytedance/android/livesdk/link/model/IBattleRecordsSeasonInfoFlexImpl;", "seasonInfo", "playMode$delegate", "getPlayMode", "playMode", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleRecordFlexImpl extends FlexModelBase<f2> implements f2, vh7.h {

    @SerializedName("all_count")
    protected long _$$allCount;

    @SerializedName("battle_attached_info")
    protected String _$$battleAttachedInfo;

    @SerializedName("battle_id")
    protected String _$$battleId;

    @SerializedName("battle_result_type")
    protected int _$$battleResultType;

    @SerializedName("battle_start_time")
    protected long _$$battleStartTime;

    @SerializedName("user_info")
    protected IBattleUserInfoFlexImpl _$$battleUserInfo;

    @SerializedName("channel_id")
    protected long _$$channelId;

    @SerializedName("channel_id_str")
    protected String _$$channleIdStr;

    @SerializedName("feedback_info")
    protected IFeedBackInfoFlexImpl _$$feedbackInfo;

    @SerializedName("follow_type")
    protected int _$$followType;

    @SerializedName("increase_or_decrease_invite")
    protected int _$$increaseOrDecreaseInvite;

    @SerializedName("invite_reject_permanent")
    protected boolean _$$inviteRejectPermanent;

    @SerializedName("invite_reject_temporary")
    protected Boolean _$$inviteRejectTemporary;

    @SerializedName("lose_count")
    protected long _$$loseCount;

    @SerializedName("match_type")
    protected long _$$matchType;

    @SerializedName("own_historic_room_id")
    protected long _$$ownHistoricRoomId;

    @SerializedName("play_mode")
    protected int _$$playMode;

    @SerializedName("rival_living_room_id")
    protected long _$$rivalLivingRoomId;

    @SerializedName("rival_open_id")
    protected String _$$rivalSecUserId;

    @SerializedName("season_info")
    protected IBattleRecordsSeasonInfoFlexImpl _$$seasonInfo;

    @SerializedName("sign_extra")
    protected String _$$signExtra;

    @SerializedName("win_count")
    protected long _$$winCount;

    @SerializedName("rival_living_room")
    protected IRoom rivalLivingRoom;

    public IBattleRecordFlexImpl() {
        super(f2.class);
        this._$$signExtra = "";
        this._$$inviteRejectPermanent = false;
        this._$$battleAttachedInfo = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public /* bridge */ /* synthetic */ IBattleUserInfo getBattleUserInfo() {
        return getBattleUserInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public /* bridge */ /* synthetic */ h4 getFeedbackInfo() {
        return getFeedbackInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public /* bridge */ /* synthetic */ h2 getSeasonInfo() {
        return getSeasonInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final long getAllCount() {
        return this._$$allCount;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final String getBattleAttachedInfo() {
        return this._$$battleAttachedInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final String getBattleId() {
        return this._$$battleId;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final int getBattleResultType() {
        return this._$$battleResultType;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final long getBattleStartTime() {
        return this._$$battleStartTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final long getChannelId() {
        return this._$$channelId;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final String getChannleIdStr() {
        return this._$$channleIdStr;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final int getFollowType() {
        return this._$$followType;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final int getIncreaseOrDecreaseInvite() {
        return this._$$increaseOrDecreaseInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final boolean getInviteRejectPermanent() {
        return this._$$inviteRejectPermanent;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final Boolean getInviteRejectTemporary() {
        return this._$$inviteRejectTemporary;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final long getLoseCount() {
        return this._$$loseCount;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final long getMatchType() {
        return this._$$matchType;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final long getOwnHistoricRoomId() {
        return this._$$ownHistoricRoomId;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final int getPlayMode() {
        return this._$$playMode;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public IRoom getRivalLivingRoom() {
        return this.rivalLivingRoom;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final long getRivalLivingRoomId() {
        return this._$$rivalLivingRoomId;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final String getRivalSecUserId() {
        return this._$$rivalSecUserId;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final String getSignExtra() {
        return this._$$signExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final long getWinCount() {
        return this._$$winCount;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final IBattleUserInfoFlexImpl getBattleUserInfo() {
        return this._$$battleUserInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final IFeedBackInfoFlexImpl getFeedbackInfo() {
        return this._$$feedbackInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.f2
    public final IBattleRecordsSeasonInfoFlexImpl getSeasonInfo() {
        return this._$$seasonInfo;
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoom, java.lang.Object] */
    public IBattleRecordFlexImpl(am3.g r8) {
        super(f2.class);
        setThreadSafe(false);
        long r1 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L34;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 5000) goto L7;
        this._$$rivalSecUserId = am3.h.c(r8);
        goto L3
    L7:
        switch(r4) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            default: goto L8;
        };
    L26:
        this._$$matchType = r8.j();
        r3 = r3 | 32;
        goto L3
    L27:
        this._$$channelId = r8.j();
        r3 = r3 | 16;
        goto L3
    L28:
        this._$$ownHistoricRoomId = r8.j();
        r3 = r3 | 8;
        goto L3
    L29:
        this._$$battleResultType = r8.i();
        r3 = r3 | 4;
        goto L3
    L30:
        this._$$rivalLivingRoomId = r8.j();
        r3 = r3 | 2;
        goto L3
    L31:
        this._$$battleStartTime = r8.j();
        r3 = r3 | 1;
        goto L3
    L32:
        this._$$battleUserInfo = new IBattleUserInfoFlexImpl(r8);
        goto L3
    L8:
        switch(r4) {
            case 9: goto L25;
            case 10: goto L24;
            case 11: goto L23;
            case 12: goto L22;
            case 13: goto L21;
            case 14: goto L20;
            case 15: goto L19;
            case 16: goto L18;
            default: goto L9;
        };
    L18:
        this._$$loseCount = r8.j();
        r3 = r3 | 2048;
        goto L3
    L19:
        this._$$winCount = r8.j();
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION;
        goto L3
    L20:
        this._$$allCount = r8.j();
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE;
        goto L3
    L21:
        this._$$inviteRejectPermanent = am3.h.a(r8);
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_LOCATION_MODE;
        goto L3
    L22:
        this._$$increaseOrDecreaseInvite = r8.i();
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
        goto L3
    L23:
        this._$$followType = r8.i();
        r3 = r3 | 64;
        goto L3
    L24:
        this._$$signExtra = am3.h.c(r8);
        goto L3
    L25:
        this.rivalLivingRoom = vh7.f.a(r8, IRoom.class);
        goto L3
    L9:
        switch(r4) {
            case 22: goto L17;
            case 23: goto L16;
            case 24: goto L15;
            case 25: goto L14;
            case 26: goto L13;
            case 27: goto L12;
            case 28: goto L11;
            default: goto L10;
        };
    L11:
        this._$$playMode = r8.i();
        r3 = r3 | 4096;
        goto L3
    L12:
        this._$$seasonInfo = new IBattleRecordsSeasonInfoFlexImpl(r8);
        goto L3
    L13:
        this._$$channleIdStr = am3.h.c(r8);
        goto L3
    L14:
        this._$$inviteRejectTemporary = Boolean.valueOf(am3.h.a(r8));
        goto L3
    L15:
        this._$$battleId = am3.h.c(r8);
        goto L3
    L16:
        this._$$feedbackInfo = new IFeedBackInfoFlexImpl(r8);
        goto L3
    L17:
        this._$$battleAttachedInfo = am3.h.c(r8);
        goto L3
    L10:
        am3.h.d(r5, r8);
        goto L3
    L34:
        r8.d(r1);
        setThreadSafe(true);
        if (this._$$signExtra != null) goto L38;
        this._$$signExtra = "";
    L38:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L41;
        this._$$inviteRejectPermanent = false;
    L41:
        if (this._$$battleAttachedInfo != null) goto L97;
        this._$$battleAttachedInfo = "";
        return;
    }

    public void setRivalLivingRoom(IRoom r1) {
        this.rivalLivingRoom = r1;
    }
}
