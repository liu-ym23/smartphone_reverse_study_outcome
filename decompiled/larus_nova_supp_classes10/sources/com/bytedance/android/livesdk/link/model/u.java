package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b0\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\n\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010!\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010$\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b\"\u0010\u0004R\"\u0010)\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\u0006\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010'R\"\u0010-\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b,\u0010\u0006\u001a\u0004\b*\u0010\u0004\"\u0004\b+\u0010'R\"\u00101\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\u0006\u001a\u0004\b.\u0010\u0004\"\u0004\b/\u0010'¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/u;", "Lvh7/c;", "", "isTurnOn", "()Z", "isTurnOn$annotations", "()V", "getAcceptMultiAnchorLink", "getAcceptMultiAnchorLink$annotations", "acceptMultiAnchorLink", "getAcceptNotFollowerInvite", "getAcceptNotFollowerInvite$annotations", "acceptNotFollowerInvite", "getAllowGiftToOtherAnchors", "getAllowGiftToOtherAnchors$annotations", "allowGiftToOtherAnchors", "getAcceptFriendInvite", "getAcceptFriendInvite$annotations", "acceptFriendInvite", "getAcceptHourlyRankInvite", "getAcceptHourlyRankInvite$annotations", "acceptHourlyRankInvite", "getAcceptPopularityRankInvite", "getAcceptPopularityRankInvite$annotations", "acceptPopularityRankInvite", "getAcceptRecommendSearchInvite", "getAcceptRecommendSearchInvite$annotations", "acceptRecommendSearchInvite", "getAcceptBigLayout", "getAcceptBigLayout$annotations", "acceptBigLayout", "getAllowGiftToOtherAnchorsInLinkmic", "getAllowGiftToOtherAnchorsInLinkmic$annotations", "allowGiftToOtherAnchorsInLinkmic", "getAllowGiftToOtherAnchorsInPK", "getAllowGiftToOtherAnchorsInPK$annotations", "allowGiftToOtherAnchorsInPK", "getAutoStartStealDragon", "setAutoStartStealDragon", "(Z)V", "getAutoStartStealDragon$annotations", "autoStartStealDragon", "getAcceptFindPeopleInvite", "setAcceptFindPeopleInvite", "getAcceptFindPeopleInvite$annotations", "acceptFindPeopleInvite", "getAcceptTeamTask", "setAcceptTeamTask", "getAcceptTeamTask$annotations", "acceptTeamTask", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u extends vh7.c<u> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "accept_big_small_layout")
    boolean getAcceptBigLayout();

    @FieldName(name = "accept_find_people_invite")
    boolean getAcceptFindPeopleInvite();

    @FieldName(name = "accept_friend_invite")
    boolean getAcceptFriendInvite();

    @FieldName(name = "accept_hourly_rank_invite")
    boolean getAcceptHourlyRankInvite();

    @FieldName(name = "accept_multi_linkmic")
    boolean getAcceptMultiAnchorLink();

    @FieldName(name = "accept_not_follower_invite")
    boolean getAcceptNotFollowerInvite();

    @FieldName(name = "accept_popularity_rank_invite")
    boolean getAcceptPopularityRankInvite();

    @FieldName(name = "accept_recommend_search_invite")
    boolean getAcceptRecommendSearchInvite();

    @FieldName(name = "accept_team_task")
    boolean getAcceptTeamTask();

    @FieldName(name = "allow_gift_to_other_anchors")
    boolean getAllowGiftToOtherAnchors();

    @FieldName(name = "linkmic_allow_gift_to_other_anchors")
    boolean getAllowGiftToOtherAnchorsInLinkmic();

    @FieldName(name = "pk_allow_gift_to_other_anchors")
    boolean getAllowGiftToOtherAnchorsInPK();

    @FieldName(name = "auto_start_steal_dragon")
    boolean getAutoStartStealDragon();

    @FieldName(name = "is_turn_on")
    boolean isTurnOn();

    @FieldName(name = "accept_find_people_invite#setter")
    void setAcceptFindPeopleInvite(boolean r1);

    @FieldName(name = "accept_team_task#setter")
    void setAcceptTeamTask(boolean r1);

    @FieldName(name = "auto_start_steal_dragon#setter")
    void setAutoStartStealDragon(boolean r1);
}
