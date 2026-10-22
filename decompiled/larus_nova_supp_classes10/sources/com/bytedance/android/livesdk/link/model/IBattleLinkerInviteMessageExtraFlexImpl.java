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
@ProtoMessage("webcast.data.BattleLinkerInviteMessageExtra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bn\u0010oR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u001b\u0010\u001a\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\u001b\u0010\u001d\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u0013R\u001b\u0010 \u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000eR\u001d\u0010%\u001a\u0004\u0018\u00010!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010$R#\u0010+\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b)\u0010*R\u001b\u0010.\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\f\u001a\u0004\b-\u0010\u0013R\u001b\u00101\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\f\u001a\u0004\b0\u0010\u0013R\u001d\u00106\u001a\u0004\u0018\u0001028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\f\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\f\u001a\u0004\b9\u0010:R\u001b\u0010>\u001a\u0002078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\f\u001a\u0004\b=\u0010:R\u001d\u0010C\u001a\u0004\u0018\u00010?8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\f\u001a\u0004\bA\u0010BR\u001d\u0010H\u001a\u0004\u0018\u00010D8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\f\u001a\u0004\bF\u0010GR\u001d\u0010L\u001a\u0004\u0018\u0001078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\f\u001a\u0004\bJ\u0010KR#\u0010O\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\f\u001a\u0004\bN\u0010*R/\u0010W\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010P8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR#\u0010Z\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\f\u001a\u0004\bY\u0010*R\u001b\u0010]\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\f\u001a\u0004\b\\\u0010\u000eR\u001b\u0010b\u001a\u00020^8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\f\u001a\u0004\b`\u0010aR\u001b\u0010g\u001a\u00020c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\f\u001a\u0004\be\u0010fR#\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\f\u001a\u0004\bi\u0010*R#\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\f\u001a\u0004\bl\u0010*¨\u0006p"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleLinkerInviteMessageExtraFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IBattleLinkerInviteMessageExtra;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "inviteRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getInviteRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setInviteRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "", "matchType$delegate", "Ljava/lang/Object;", "getMatchType", "()J", "matchType", "", "tips$delegate", "getTips", "()Ljava/lang/String;", "tips", "inviteType$delegate", "getInviteType", "inviteType", "scene$delegate", "getScene", "scene", "theme$delegate", "getTheme", "theme", "duration$delegate", "getDuration", "duration", "Lcom/bytedance/android/livesdk/link/model/IInviterRivalExtraFlexImpl;", "extra$delegate", "getExtra", "()Lcom/bytedance/android/livesdk/link/model/IInviterRivalExtraFlexImpl;", "extra", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTagFlexImpl;", "tagList$delegate", "getTagList", "()Ljava/util/List;", "tagList", "recommendReason$delegate", "getRecommendReason", "recommendReason", "activityName$delegate", "getActivityName", "activityName", "Lcom/bytedance/android/livesdk/link/model/IBattleActivityUserFlexImpl;", "activityUser$delegate", "getActivityUser", "()Lcom/bytedance/android/livesdk/link/model/IBattleActivityUserFlexImpl;", "activityUser", "", "pkCheckState$delegate", "getPkCheckState", "()I", "pkCheckState", "switchPlayMode$delegate", "getSwitchPlayMode", "switchPlayMode", "Lcom/bytedance/android/livesdk/link/model/IVoteSettingFlexImpl;", "voteSetting$delegate", "getVoteSetting", "()Lcom/bytedance/android/livesdk/link/model/IVoteSettingFlexImpl;", "voteSetting", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSettingExtensionImpl;", "battleConfigSetting$delegate", "getBattleConfigSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleConfigSettingExtensionImpl;", "battleConfigSetting", "inviteStatus$delegate", "getInviteStatus", "()Ljava/lang/Integer;", "inviteStatus", "matchTags$delegate", "getMatchTags", "matchTags", "Lcom/bytedance/android/livesdk/link/model/h5;", "<set-?>", "linkMicBizExtra$delegate", "getLinkMicBizExtra", "()Lcom/bytedance/android/livesdk/link/model/h5;", "setLinkMicBizExtra", "(Lcom/bytedance/android/livesdk/link/model/h5;)V", "linkMicBizExtra", "semiFriendTags$delegate", "getSemiFriendTags", "semiFriendTags", "invitePanelStyle$delegate", "getInvitePanelStyle", "invitePanelStyle", "Lcom/bytedance/android/livesdk/link/model/IBattleInviteRankSeasonInfoFlexImpl;", "rankSeasonInfo$delegate", "getRankSeasonInfo", "()Lcom/bytedance/android/livesdk/link/model/IBattleInviteRankSeasonInfoFlexImpl;", "rankSeasonInfo", "Lcom/bytedance/android/livesdk/link/model/IBattleInviteAcceptTipFlexImpl;", "acceptTip$delegate", "getAcceptTip", "()Lcom/bytedance/android/livesdk/link/model/IBattleInviteAcceptTipFlexImpl;", "acceptTip", "cannotPkAnchorUidList$delegate", "getCannotPkAnchorUidList", "cannotPkAnchorUidList", "inviterFollowIds$delegate", "getInviterFollowIds", "inviterFollowIds", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleLinkerInviteMessageExtraFlexImpl extends FlexModelBase<IBattleLinkerInviteMessageExtra> implements IBattleLinkerInviteMessageExtra, vh7.h {

    @SerializedName("accept_tip")
    protected IBattleInviteAcceptTipFlexImpl _$$acceptTip;

    @SerializedName("activity_name")
    protected String _$$activityName;

    @SerializedName("activity_user")
    protected IBattleActivityUserFlexImpl _$$activityUser;

    @SerializedName("battle_config_setting")
    protected IBattleConfigSettingExtensionImpl _$$battleConfigSetting;

    @SerializedName("can_not_pass_anchor_open_ids")
    protected List<String> _$$cannotPkAnchorUidList;

    @SerializedName("duration")
    protected long _$$duration;

    @SerializedName("extra")
    protected IInviterRivalExtraFlexImpl _$$extra;

    @SerializedName("battle_invite_panel_opt")
    protected long _$$invitePanelStyle;

    @SerializedName("invite_status")
    protected Integer _$$inviteStatus;

    @SerializedName("invite_type")
    protected long _$$inviteType;

    @SerializedName("inviter_followed_open_ids")
    protected List<String> _$$inviterFollowIds;

    @SerializedName("link_mic_biz_extra")
    protected h5 _$$linkMicBizExtra;

    @SerializedName("match_tags")
    protected List<IBattleRivalTagFlexImpl> _$$matchTags;

    @SerializedName("match_type")
    protected long _$$matchType;

    @SerializedName("anchor_pk_check")
    protected int _$$pkCheckState;

    @SerializedName("rank_season_info")
    protected IBattleInviteRankSeasonInfoFlexImpl _$$rankSeasonInfo;

    @SerializedName("recommend_reason")
    protected String _$$recommendReason;

    @SerializedName("scene")
    protected long _$$scene;

    @SerializedName("half_friend_tags")
    protected List<IBattleRivalTagFlexImpl> _$$semiFriendTags;

    @SerializedName("switch_play_mode")
    protected int _$$switchPlayMode;

    @SerializedName("tags")
    protected List<IBattleRivalTagFlexImpl> _$$tagList;

    @SerializedName("theme")
    protected String _$$theme;

    @SerializedName("tips")
    protected String _$$tips;

    @SerializedName("vote_setting")
    protected IVoteSettingFlexImpl _$$voteSetting;

    @SerializedName("invite_room")
    protected IRoom inviteRoom;

    public IBattleLinkerInviteMessageExtraFlexImpl() {
        super(IBattleLinkerInviteMessageExtra.class);
        this._$$tips = "";
        this._$$theme = "";
        this._$$recommendReason = "";
        this._$$activityName = "";
        this._$$rankSeasonInfo = $defaultValue_rankSeasonInfo$();
        this._$$acceptTip = $defaultValue_acceptTip$();
    }

    public final IBattleInviteAcceptTipFlexImpl $defaultValue_acceptTip$() {
        return (IBattleInviteAcceptTipFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IBattleInviteAcceptTipFlexImpl.class);
    }

    public final IBattleInviteRankSeasonInfoFlexImpl $defaultValue_rankSeasonInfo$() {
        return (IBattleInviteRankSeasonInfoFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IBattleInviteRankSeasonInfoFlexImpl.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public /* bridge */ /* synthetic */ l1 getAcceptTip() {
        return getAcceptTip();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public /* bridge */ /* synthetic */ n0 getActivityUser() {
        return getActivityUser();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public /* bridge */ /* synthetic */ IBattleConfigSetting getBattleConfigSetting() {
        return getBattleConfigSetting();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public /* bridge */ /* synthetic */ m4 getExtra() {
        return getExtra();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public /* bridge */ /* synthetic */ m1 getRankSeasonInfo() {
        return getRankSeasonInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public /* bridge */ /* synthetic */ aa getVoteSetting() {
        return getVoteSetting();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final String getActivityName() {
        return this._$$activityName;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final List<String> getCannotPkAnchorUidList() {
        return this._$$cannotPkAnchorUidList;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final long getDuration() {
        return this._$$duration;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final long getInvitePanelStyle() {
        return this._$$invitePanelStyle;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public IRoom getInviteRoom() {
        return this.inviteRoom;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final Integer getInviteStatus() {
        return this._$$inviteStatus;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final long getInviteType() {
        return this._$$inviteType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final List<String> getInviterFollowIds() {
        return this._$$inviterFollowIds;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final h5 getLinkMicBizExtra() {
        return this._$$linkMicBizExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final List<IBattleRivalTagFlexImpl> getMatchTags() {
        return this._$$matchTags;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final long getMatchType() {
        return this._$$matchType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final int getPkCheckState() {
        return this._$$pkCheckState;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final String getRecommendReason() {
        return this._$$recommendReason;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final long getScene() {
        return this._$$scene;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final List<IBattleRivalTagFlexImpl> getSemiFriendTags() {
        return this._$$semiFriendTags;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final int getSwitchPlayMode() {
        return this._$$switchPlayMode;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final List<IBattleRivalTagFlexImpl> getTagList() {
        return this._$$tagList;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final String getTheme() {
        return this._$$theme;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final String getTips() {
        return this._$$tips;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final IBattleInviteAcceptTipFlexImpl getAcceptTip() {
        return this._$$acceptTip;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final IBattleActivityUserFlexImpl getActivityUser() {
        return this._$$activityUser;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final IBattleConfigSettingExtensionImpl getBattleConfigSetting() {
        return this._$$battleConfigSetting;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final IInviterRivalExtraFlexImpl getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final IBattleInviteRankSeasonInfoFlexImpl getRankSeasonInfo() {
        return this._$$rankSeasonInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final IVoteSettingFlexImpl getVoteSetting() {
        return this._$$voteSetting;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object, vh7.c] */
    /* JADX WARN: Type inference failed for: r2v29, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoom, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.livesdk.link.model.h5, java.lang.Object] */
    public IBattleLinkerInviteMessageExtraFlexImpl(am3.g r6) {
        super(IBattleLinkerInviteMessageExtra.class);
        this._$$tagList = new ArrayList();
        this._$$matchTags = new ArrayList();
        this._$$semiFriendTags = new ArrayList();
        this._$$cannotPkAnchorUidList = new ArrayList();
        this._$$inviterFollowIds = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L49;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$matchType = r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$tips = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$inviteType = r6.j();
        goto L3
    L12:
        if (r2 != 18) goto L14;
        this._$$pkCheckState = r6.i();
        goto L3
    L14:
        if (r2 == 5000) goto L43;
        if (r2 == 5001) goto L42;
        switch(r2) {
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            case 8: goto L38;
            case 9: goto L36;
            case 10: goto L35;
            default: goto L18;
        };
    L35:
        this.inviteRoom = vh7.f.a(r6, IRoom.class);
        goto L3
    L36:
        List r4 = this._$$tagList;
        Object r5 = new IBattleRivalTagFlexImpl(r6);
    L37:
        r4.add(r5);
        goto L3
    L38:
        this._$$extra = new IInviterRivalExtraFlexImpl(r6);
        goto L3
    L39:
        this._$$duration = r6.j();
        goto L3
    L40:
        this._$$theme = am3.h.c(r6);
        goto L3
    L41:
        this._$$scene = r6.j();
        goto L3
    L18:
        switch(r2) {
            case 14: goto L34;
            case 15: goto L33;
            case 16: goto L32;
            default: goto L19;
        };
    L32:
        this._$$activityUser = new IBattleActivityUserFlexImpl(r6);
        goto L3
    L33:
        this._$$activityName = am3.h.c(r6);
        goto L3
    L34:
        this._$$recommendReason = am3.h.c(r6);
        goto L3
    L19:
        switch(r2) {
            case 20: goto L31;
            case 21: goto L30;
            case 22: goto L29;
            case 23: goto L28;
            default: goto L20;
        };
    L28:
        this._$$inviteStatus = Integer.valueOf(r6.i());
        goto L3
    L29:
        this._$$battleConfigSetting = (IBattleConfigSettingExtensionImpl) vh7.f.a(r6, com.bytedance.android.livesdk.link.model.bridge.p.class).castToOrNull(IBattleConfigSettingExtensionImpl.class);
        goto L3
    L30:
        this._$$voteSetting = new IVoteSettingFlexImpl(r6);
        goto L3
    L31:
        this._$$switchPlayMode = r6.i();
        goto L3
    L20:
        switch(r2) {
            case 25: goto L27;
            case 26: goto L26;
            case 27: goto L25;
            case 28: goto L24;
            case 29: goto L23;
            case 30: goto L22;
            default: goto L21;
        };
    L22:
        this._$$acceptTip = new IBattleInviteAcceptTipFlexImpl(r6);
        goto L3
    L23:
        this._$$rankSeasonInfo = new IBattleInviteRankSeasonInfoFlexImpl(r6);
        goto L3
    L24:
        this._$$invitePanelStyle = r6.j();
        goto L3
    L25:
        r4 = this._$$semiFriendTags;
        r5 = new IBattleRivalTagFlexImpl(r6);
        goto L37
    L26:
        this._$$linkMicBizExtra = vh7.f.a(r6, h5.class);
        goto L3
    L27:
        r4 = this._$$matchTags;
        r5 = new IBattleRivalTagFlexImpl(r6);
        goto L37
    L21:
        am3.h.d(r3, r6);
        goto L3
    L42:
        r4 = this._$$inviterFollowIds;
    L44:
        r5 = am3.h.c(r6);
        goto L37
    L43:
        r4 = this._$$cannotPkAnchorUidList;
        goto L44
    L49:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$tips != null) goto L53;
        this._$$tips = "";
    L53:
        if (this._$$theme != null) goto L56;
        this._$$theme = "";
    L56:
        if (this._$$recommendReason != null) goto L59;
        this._$$recommendReason = "";
    L59:
        if (this._$$activityName != null) goto L62;
        this._$$activityName = "";
    L62:
        if (this._$$rankSeasonInfo != null) goto L65;
        this._$$rankSeasonInfo = $defaultValue_rankSeasonInfo$();
    L65:
        if (this._$$acceptTip != null) goto L125;
        this._$$acceptTip = $defaultValue_acceptTip$();
        return;
    }

    public void setInviteRoom(IRoom r1) {
        this.inviteRoom = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra
    public final void setLinkMicBizExtra(h5 r1) {
        this._$$linkMicBizExtra = r1;
    }
}
