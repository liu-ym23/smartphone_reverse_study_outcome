package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.AnchorLinkmicUserSettings")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b3\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b4\u00105R\u001b\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001b\u0010\u001f\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\"\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R\u001b\u0010%\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007R+\u0010+\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010*R+\u0010/\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010*R+\u00103\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0005\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010*¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorLinkmicUserSettingsFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/u;", "", "isTurnOn$delegate", "Ljava/lang/Object;", "isTurnOn", "()Z", "acceptMultiAnchorLink$delegate", "getAcceptMultiAnchorLink", "acceptMultiAnchorLink", "acceptNotFollowerInvite$delegate", "getAcceptNotFollowerInvite", "acceptNotFollowerInvite", "allowGiftToOtherAnchors$delegate", "getAllowGiftToOtherAnchors", "allowGiftToOtherAnchors", "acceptFriendInvite$delegate", "getAcceptFriendInvite", "acceptFriendInvite", "acceptHourlyRankInvite$delegate", "getAcceptHourlyRankInvite", "acceptHourlyRankInvite", "acceptPopularityRankInvite$delegate", "getAcceptPopularityRankInvite", "acceptPopularityRankInvite", "acceptRecommendSearchInvite$delegate", "getAcceptRecommendSearchInvite", "acceptRecommendSearchInvite", "acceptBigLayout$delegate", "getAcceptBigLayout", "acceptBigLayout", "allowGiftToOtherAnchorsInLinkmic$delegate", "getAllowGiftToOtherAnchorsInLinkmic", "allowGiftToOtherAnchorsInLinkmic", "allowGiftToOtherAnchorsInPK$delegate", "getAllowGiftToOtherAnchorsInPK", "allowGiftToOtherAnchorsInPK", "<set-?>", "autoStartStealDragon$delegate", "getAutoStartStealDragon", "setAutoStartStealDragon", "(Z)V", "autoStartStealDragon", "acceptFindPeopleInvite$delegate", "getAcceptFindPeopleInvite", "setAcceptFindPeopleInvite", "acceptFindPeopleInvite", "acceptTeamTask$delegate", "getAcceptTeamTask", "setAcceptTeamTask", "acceptTeamTask", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorLinkmicUserSettingsFlexImpl extends FlexModelBase<u> implements u, vh7.h {

    @SerializedName("accept_big_small_layout")
    protected boolean _$$acceptBigLayout;

    @SerializedName("accept_find_people_invite")
    protected boolean _$$acceptFindPeopleInvite;

    @SerializedName("accept_friend_invite")
    protected boolean _$$acceptFriendInvite;

    @SerializedName("accept_hourly_rank_invite")
    protected boolean _$$acceptHourlyRankInvite;

    @SerializedName("accept_multi_linkmic")
    protected boolean _$$acceptMultiAnchorLink;

    @SerializedName("accept_not_follower_invite")
    protected boolean _$$acceptNotFollowerInvite;

    @SerializedName("accept_popularity_rank_invite")
    protected boolean _$$acceptPopularityRankInvite;

    @SerializedName("accept_recommend_search_invite")
    protected boolean _$$acceptRecommendSearchInvite;

    @SerializedName("accept_team_task")
    protected boolean _$$acceptTeamTask;

    @SerializedName("allow_gift_to_other_anchors")
    protected boolean _$$allowGiftToOtherAnchors;

    @SerializedName("linkmic_allow_gift_to_other_anchors")
    protected boolean _$$allowGiftToOtherAnchorsInLinkmic;

    @SerializedName("pk_allow_gift_to_other_anchors")
    protected boolean _$$allowGiftToOtherAnchorsInPK;

    @SerializedName("auto_start_steal_dragon")
    protected boolean _$$autoStartStealDragon;

    @SerializedName("is_turn_on")
    protected boolean _$$isTurnOn;

    public IAnchorLinkmicUserSettingsFlexImpl() {
        super(u.class);
        this._$$isTurnOn = false;
        this._$$acceptMultiAnchorLink = false;
        this._$$acceptNotFollowerInvite = false;
        this._$$allowGiftToOtherAnchors = false;
        this._$$acceptFriendInvite = false;
        this._$$acceptHourlyRankInvite = false;
        this._$$acceptPopularityRankInvite = false;
        this._$$acceptRecommendSearchInvite = false;
        this._$$acceptBigLayout = false;
        this._$$allowGiftToOtherAnchorsInLinkmic = false;
        this._$$allowGiftToOtherAnchorsInPK = false;
        this._$$autoStartStealDragon = false;
        this._$$acceptFindPeopleInvite = false;
        this._$$acceptTeamTask = false;
    }

    public IAnchorLinkmicUserSettingsFlexImpl(am3.g r7) {
        super(u.class);
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L22;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L7;
            case 13: goto L10;
            case 14: goto L7;
            case 15: goto L9;
            case 16: goto L8;
            default: goto L7;
        };
    L8:
        this._$$acceptTeamTask = am3.h.a(r7);
        r3 = r3 | 8192;
        goto L3
    L9:
        this._$$acceptFindPeopleInvite = am3.h.a(r7);
        r3 = r3 | 4096;
        goto L3
    L10:
        this._$$autoStartStealDragon = am3.h.a(r7);
        r3 = r3 | 2048;
        goto L3
    L11:
        this._$$allowGiftToOtherAnchorsInPK = am3.h.a(r7);
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION;
        goto L3
    L12:
        this._$$allowGiftToOtherAnchorsInLinkmic = am3.h.a(r7);
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE;
        goto L3
    L13:
        this._$$acceptBigLayout = am3.h.a(r7);
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_LOCATION_MODE;
        goto L3
    L14:
        this._$$acceptRecommendSearchInvite = am3.h.a(r7);
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
        goto L3
    L15:
        this._$$acceptPopularityRankInvite = am3.h.a(r7);
        r3 = r3 | 64;
        goto L3
    L16:
        this._$$acceptHourlyRankInvite = am3.h.a(r7);
        r3 = r3 | 32;
        goto L3
    L17:
        this._$$acceptFriendInvite = am3.h.a(r7);
        r3 = r3 | 16;
        goto L3
    L18:
        this._$$allowGiftToOtherAnchors = am3.h.a(r7);
        r3 = r3 | 8;
        goto L3
    L19:
        this._$$acceptNotFollowerInvite = am3.h.a(r7);
        r3 = r3 | 4;
        goto L3
    L20:
        this._$$acceptMultiAnchorLink = am3.h.a(r7);
        r3 = r3 | 2;
        goto L3
    L21:
        this._$$isTurnOn = am3.h.a(r7);
        r3 = r3 | 1;
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L22:
        r7.d(r1);
        setThreadSafe(true);
        if ((r3 & 1) != 0) goto L26;
        this._$$isTurnOn = false;
    L26:
        if ((r3 & 2) != 0) goto L29;
        this._$$acceptMultiAnchorLink = false;
    L29:
        if ((r3 & 4) != 0) goto L32;
        this._$$acceptNotFollowerInvite = false;
    L32:
        if ((r3 & 8) != 0) goto L35;
        this._$$allowGiftToOtherAnchors = false;
    L35:
        if ((r3 & 16) != 0) goto L38;
        this._$$acceptFriendInvite = false;
    L38:
        if ((r3 & 32) != 0) goto L41;
        this._$$acceptHourlyRankInvite = false;
    L41:
        if ((r3 & 64) != 0) goto L44;
        this._$$acceptPopularityRankInvite = false;
    L44:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L47;
        this._$$acceptRecommendSearchInvite = false;
    L47:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L50;
        this._$$acceptBigLayout = false;
    L50:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) != 0) goto L53;
        this._$$allowGiftToOtherAnchorsInLinkmic = false;
    L53:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) != 0) goto L56;
        this._$$allowGiftToOtherAnchorsInPK = false;
    L56:
        if ((r3 & 2048) != 0) goto L59;
        this._$$autoStartStealDragon = false;
    L59:
        if ((r3 & 4096) != 0) goto L62;
        this._$$acceptFindPeopleInvite = false;
    L62:
        if ((r3 & 8192) != 0) goto L97;
        this._$$acceptTeamTask = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAcceptBigLayout() {
        return this._$$acceptBigLayout;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAcceptFindPeopleInvite() {
        return this._$$acceptFindPeopleInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAcceptFriendInvite() {
        return this._$$acceptFriendInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAcceptHourlyRankInvite() {
        return this._$$acceptHourlyRankInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAcceptMultiAnchorLink() {
        return this._$$acceptMultiAnchorLink;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAcceptNotFollowerInvite() {
        return this._$$acceptNotFollowerInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAcceptPopularityRankInvite() {
        return this._$$acceptPopularityRankInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAcceptRecommendSearchInvite() {
        return this._$$acceptRecommendSearchInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAcceptTeamTask() {
        return this._$$acceptTeamTask;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAllowGiftToOtherAnchors() {
        return this._$$allowGiftToOtherAnchors;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAllowGiftToOtherAnchorsInLinkmic() {
        return this._$$allowGiftToOtherAnchorsInLinkmic;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAllowGiftToOtherAnchorsInPK() {
        return this._$$allowGiftToOtherAnchorsInPK;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean getAutoStartStealDragon() {
        return this._$$autoStartStealDragon;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final boolean isTurnOn() {
        return this._$$isTurnOn;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final void setAcceptFindPeopleInvite(boolean r1) {
        this._$$acceptFindPeopleInvite = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final void setAcceptTeamTask(boolean r1) {
        this._$$acceptTeamTask = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.u
    public final void setAutoStartStealDragon(boolean r1) {
        this._$$autoStartStealDragon = r1;
    }
}
