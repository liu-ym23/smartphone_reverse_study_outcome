package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BattleRival")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b`\u0010aR*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\bR\u001d\u0010$\u001a\u0004\u0018\u00010 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u0004\u0018\u00010%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010(R\u001d\u0010.\u001a\u0004\u0018\u00010*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0013\u001a\u0004\b1\u00102R\u001b\u00106\u001a\u00020/8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0013\u001a\u0004\b5\u00102R\u001b\u0010;\u001a\u0002078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0013\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0013\u001a\u0004\b>\u0010?R\u001b\u0010C\u001a\u00020<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0013\u001a\u0004\bB\u0010?R\u001b\u0010F\u001a\u00020<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0013\u001a\u0004\bE\u0010?R\u001b\u0010I\u001a\u00020<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0013\u001a\u0004\bH\u0010?R\u001b\u0010L\u001a\u00020<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0013\u001a\u0004\bK\u0010?R!\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0013\u001a\u0004\bN\u0010\bR\u001b\u0010R\u001a\u00020<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0013\u001a\u0004\bQ\u0010?R+\u0010X\u001a\u00020<2\u0006\u0010S\u001a\u00020<8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bT\u0010\u0013\u001a\u0004\bU\u0010?\"\u0004\bV\u0010WR/\u0010_\u001a\u0004\u0018\u00010Y2\b\u0010S\u001a\u0004\u0018\u00010Y8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010\u0013\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^¨\u0006b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRivalFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/m2;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "participantRooms", "Ljava/util/List;", "getParticipantRooms", "()Ljava/util/List;", "setParticipantRooms", "(Ljava/util/List;)V", "Lpy/k;", "pkStageMedal", "Lpy/k;", "getPkStageMedal", "()Lpy/k;", "setPkStageMedal", "(Lpy/k;)V", "room$delegate", "Ljava/lang/Object;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfoFlexImpl;", "rivalExtraInfo$delegate", "getRivalExtraInfo", "()Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfoFlexImpl;", "rivalExtraInfo", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTagFlexImpl;", "battleRivalTagList$delegate", "getBattleRivalTagList", "battleRivalTagList", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalInviteButtonFlexImpl;", "inviteButton$delegate", "getInviteButton", "()Lcom/bytedance/android/livesdk/link/model/IBattleRivalInviteButtonFlexImpl;", "inviteButton", "Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeMedalFlexImpl;", "activityMedal$delegate", "getActivityMedal", "()Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeMedalFlexImpl;", "activityMedal", "Lcom/bytedance/android/livesdk/link/model/IBattleActivityUserFlexImpl;", "activityUser$delegate", "getActivityUser", "()Lcom/bytedance/android/livesdk/link/model/IBattleActivityUserFlexImpl;", "activityUser", "", "serverInviteType$delegate", "getServerInviteType", "()I", "serverInviteType", "roomScene$delegate", "getRoomScene", "roomScene", "", "status$delegate", "getStatus", "()J", "status", "", "linkText$delegate", "getLinkText", "()Ljava/lang/String;", "linkText", "recommendInfo$delegate", "getRecommendInfo", "recommendInfo", "battleAttachedInfo$delegate", "getBattleAttachedInfo", "battleAttachedInfo", "pkStageDesc$delegate", "getPkStageDesc", "pkStageDesc", "roomStatusDesc$delegate", "getRoomStatusDesc", "roomStatusDesc", "semiFriendTags$delegate", "getSemiFriendTags", "semiFriendTags", "canReserve$delegate", "getCanReserve", "canReserve", "<set-?>", "reserveDesc$delegate", "getReserveDesc", "setReserveDesc", "(Ljava/lang/String;)V", "reserveDesc", "Lcom/bytedance/android/livesdk/link/model/p2;", "rankSeasonInfo$delegate", "getRankSeasonInfo", "()Lcom/bytedance/android/livesdk/link/model/p2;", "setRankSeasonInfo", "(Lcom/bytedance/android/livesdk/link/model/p2;)V", "rankSeasonInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleRivalFlexImpl extends FlexModelBase<m2> implements m2, vh7.h {

    @SerializedName("activity_medal")
    protected IBattleStarActivityGradeMedalFlexImpl _$$activityMedal;

    @SerializedName("activity_user")
    protected IBattleActivityUserFlexImpl _$$activityUser;

    @SerializedName("battle_attached_info")
    protected String _$$battleAttachedInfo;

    @SerializedName("tags")
    protected List<IBattleRivalTagFlexImpl> _$$battleRivalTagList;

    @SerializedName("reserve_button")
    protected String _$$canReserve;

    @SerializedName("invite_button")
    protected IBattleRivalInviteButtonFlexImpl _$$inviteButton;

    @SerializedName("link_text")
    protected String _$$linkText;

    @SerializedName("pk_stage_desc")
    protected String _$$pkStageDesc;

    @SerializedName("rank_season_info")
    protected p2 _$$rankSeasonInfo;

    @SerializedName("recommend_info")
    protected String _$$recommendInfo;

    @SerializedName("reserve_desc")
    protected String _$$reserveDesc;

    @SerializedName("extra_info")
    protected IRivalExtraInfoFlexImpl _$$rivalExtraInfo;

    @SerializedName("room")
    protected IRoom _$$room;

    @SerializedName("scene")
    protected int _$$roomScene;

    @SerializedName("room_status_desc")
    protected String _$$roomStatusDesc;

    @SerializedName("half_friend_tags")
    protected List<IBattleRivalTagFlexImpl> _$$semiFriendTags;

    @SerializedName("from_server_invite_type")
    protected int _$$serverInviteType;

    @SerializedName("link_status")
    protected long _$$status;

    @SerializedName("participant_rooms")
    protected List<? extends IRoom> participantRooms;

    @SerializedName("pk_stage_medal")
    protected py.k pkStageMedal;

    public IBattleRivalFlexImpl() {
        super(m2.class);
        this._$$room = $defaultValue_room$();
        this._$$linkText = "";
        this._$$recommendInfo = "";
        this._$$battleAttachedInfo = "";
        this._$$pkStageDesc = "";
        this._$$roomStatusDesc = "";
        this._$$semiFriendTags = $defaultValue_semiFriendTags$();
        this._$$canReserve = "";
        this._$$reserveDesc = "";
    }

    public final IRoom $defaultValue_room$() {
        return vh7.f.c(IRoom.class);
    }

    public final List<IBattleRivalTagFlexImpl> $defaultValue_semiFriendTags$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public /* bridge */ /* synthetic */ a3 getActivityMedal() {
        return getActivityMedal();
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public /* bridge */ /* synthetic */ n0 getActivityUser() {
        return getActivityUser();
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public /* bridge */ /* synthetic */ n2 getInviteButton() {
        return getInviteButton();
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public /* bridge */ /* synthetic */ IRivalExtraInfo getRivalExtraInfo() {
        return getRivalExtraInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final String getBattleAttachedInfo() {
        return this._$$battleAttachedInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final List<IBattleRivalTagFlexImpl> getBattleRivalTagList() {
        return this._$$battleRivalTagList;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final String getCanReserve() {
        return this._$$canReserve;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final String getLinkText() {
        return this._$$linkText;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public List<IRoom> getParticipantRooms() {
        return this.participantRooms;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final String getPkStageDesc() {
        return this._$$pkStageDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public py.k getPkStageMedal() {
        return this.pkStageMedal;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final p2 getRankSeasonInfo() {
        return this._$$rankSeasonInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final String getRecommendInfo() {
        return this._$$recommendInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final String getReserveDesc() {
        return this._$$reserveDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final IRoom getRoom() {
        return this._$$room;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final int getRoomScene() {
        return this._$$roomScene;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final String getRoomStatusDesc() {
        return this._$$roomStatusDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final List<IBattleRivalTagFlexImpl> getSemiFriendTags() {
        return this._$$semiFriendTags;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final int getServerInviteType() {
        return this._$$serverInviteType;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final long getStatus() {
        return this._$$status;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final IBattleStarActivityGradeMedalFlexImpl getActivityMedal() {
        return this._$$activityMedal;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final IBattleActivityUserFlexImpl getActivityUser() {
        return this._$$activityUser;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final IBattleRivalInviteButtonFlexImpl getInviteButton() {
        return this._$$inviteButton;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final IRivalExtraInfoFlexImpl getRivalExtraInfo() {
        return this._$$rivalExtraInfo;
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoom, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v24, types: [com.bytedance.android.livesdk.link.model.p2, java.lang.Object] */
    public IBattleRivalFlexImpl(am3.g r5) {
        super(m2.class);
        this._$$battleRivalTagList = new ArrayList();
        this.participantRooms = new ArrayList();
        this._$$semiFriendTags = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L29;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L21;
            case 14: goto L20;
            case 15: goto L19;
            case 16: goto L18;
            case 17: goto L17;
            case 18: goto L16;
            case 19: goto L15;
            case 20: goto L14;
            case 21: goto L7;
            case 22: goto L7;
            case 23: goto L13;
            case 24: goto L12;
            case 25: goto L11;
            case 26: goto L10;
            case 27: goto L9;
            case 28: goto L8;
            default: goto L7;
        };
    L8:
        this._$$rankSeasonInfo = vh7.f.a(r5, p2.class);
        goto L3
    L9:
        this._$$reserveDesc = am3.h.c(r5);
        goto L3
    L10:
        this._$$canReserve = am3.h.c(r5);
        goto L3
    L11:
        List r4 = this._$$semiFriendTags;
        Object r6 = new IBattleRivalTagFlexImpl(r5);
    L26:
        r4.add(r6);
        goto L3
    L12:
        this._$$roomStatusDesc = am3.h.c(r5);
        goto L3
    L13:
        this._$$pkStageDesc = am3.h.c(r5);
        goto L3
    L14:
        this.pkStageMedal = vh7.f.a(r5, py.k.class);
        goto L3
    L15:
        this._$$battleAttachedInfo = am3.h.c(r5);
        goto L3
    L16:
        this._$$recommendInfo = am3.h.c(r5);
        goto L3
    L17:
        this._$$linkText = am3.h.c(r5);
        goto L3
    L18:
        this._$$status = r5.j();
        goto L3
    L19:
        this._$$roomScene = r5.i();
        goto L3
    L20:
        r4 = this.participantRooms;
        r6 = vh7.f.a(r5, IRoom.class);
        goto L26
    L21:
        this._$$serverInviteType = r5.i();
        goto L3
    L22:
        this._$$activityUser = new IBattleActivityUserFlexImpl(r5);
        goto L3
    L23:
        this._$$inviteButton = new IBattleRivalInviteButtonFlexImpl(r5);
        goto L3
    L24:
        this._$$activityMedal = new IBattleStarActivityGradeMedalFlexImpl(r5);
        goto L3
    L25:
        r4 = this._$$battleRivalTagList;
        r6 = new IBattleRivalTagFlexImpl(r5);
        goto L26
    L27:
        this._$$rivalExtraInfo = new IRivalExtraInfoFlexImpl(r5);
        goto L3
    L28:
        this._$$room = vh7.f.a(r5, IRoom.class);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L29:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$room != null) goto L33;
        this._$$room = $defaultValue_room$();
    L33:
        if (this._$$linkText != null) goto L36;
        this._$$linkText = "";
    L36:
        if (this._$$recommendInfo != null) goto L39;
        this._$$recommendInfo = "";
    L39:
        if (this._$$battleAttachedInfo != null) goto L42;
        this._$$battleAttachedInfo = "";
    L42:
        if (this._$$pkStageDesc != null) goto L45;
        this._$$pkStageDesc = "";
    L45:
        if (this._$$roomStatusDesc != null) goto L48;
        this._$$roomStatusDesc = "";
    L48:
        if (this._$$semiFriendTags.isEmpty() == false) goto L51;
        this._$$semiFriendTags = $defaultValue_semiFriendTags$();
    L51:
        if (this._$$canReserve != null) goto L54;
        this._$$canReserve = "";
    L54:
        if (this._$$reserveDesc != null) goto L99;
        this._$$reserveDesc = "";
        return;
    }

    public void setParticipantRooms(List<? extends IRoom> r1) {
        this.participantRooms = r1;
    }

    public void setPkStageMedal(py.k r1) {
        this.pkStageMedal = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final void setRankSeasonInfo(p2 r1) {
        this._$$rankSeasonInfo = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.m2
    public final void setReserveDesc(String r1) {
        this._$$reserveDesc = r1;
    }
}
