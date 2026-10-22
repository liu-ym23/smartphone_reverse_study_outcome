package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b&\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000f\u0010\u0004R\u001e\u0010\u0017\u001a\u00060\u0012j\u0002`\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001b\u001a\u00060\u0012j\u0002`\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010!\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010$\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b\"\u0010\u0004R\u001a\u0010)\u001a\u00020%8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0006\u001a\u0004\b&\u0010'R\u001a\u0010,\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b*\u0010\u0004R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0006\u001a\u0004\b-\u0010\u0004R\u001e\u00102\u001a\u00060\u0012j\u0002`\u00138&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0006\u001a\u0004\b0\u0010\u0015R\u001a\u00105\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0006\u001a\u0004\b3\u0010\u0004R\u001a\u00108\u001a\u00020%8&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0006\u001a\u0004\b6\u0010'R\u001e\u0010;\u001a\u00060\u0012j\u0002`\u00138&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0006\u001a\u0004\b9\u0010\u0015R\u001a\u0010>\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0006\u001a\u0004\b<\u0010\u0004R\u001a\u0010A\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0006\u001a\u0004\b?\u0010\u0004R\u001a\u0010D\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0006\u001a\u0004\bB\u0010\u0004R\u001a\u0010G\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0006\u001a\u0004\bE\u0010\u0004R*\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\n8&X§\u0004¢\u0006\f\u0012\u0004\bI\u0010\u0006\u001a\u0004\bH\u0010\f¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/d2;", "Lvh7/c;", "", "getSponsorId", "()Ljava/lang/String;", "getSponsorId$annotations", "()V", "sponsorId", "", "Lcom/bytedance/android/livesdk/link/model/IBattlePrecisionMatcher;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getMatcherList", "()Ljava/util/List;", "getMatcherList$annotations", "matcherList", "getMatchReason", "getMatchReason$annotations", "matchReason", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/TimeInt64;", "getWaitSeconds", "()J", "getWaitSeconds$annotations", "waitSeconds", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/PrecisionMatchId;", "getPrecisionMatchId", "getPrecisionMatchId$annotations", "precisionMatchId", "getActivityName", "getActivityName$annotations", "activityName", "getRecommendReason", "getRecommendReason$annotations", "recommendReason", "getSignExtra", "getSignExtra$annotations", "signExtra", "", "getSource", "()I", "getSource$annotations", "source", "getNotDisturbText", "getNotDisturbText$annotations", "notDisturbText", "getActivityId", "getActivityId$annotations", "activityId", "getDuration", "getDuration$annotations", "duration", "getBattleAttachedInfo", "getBattleAttachedInfo$annotations", "battleAttachedInfo", "getPlayMode", "getPlayMode$annotations", "playMode", "getDefaultRespondType", "getDefaultRespondType$annotations", "defaultRespondType", "getToastContent", "getToastContent$annotations", "toastContent", "getTitle", "getTitle$annotations", "title", "getSubTitle", "getSubTitle$annotations", "subTitle", "getBattleRule", "getBattleRule$annotations", "battleRule", "getAutoAcceptAnchorIdList", "getAutoAcceptAnchorIdList$annotations", "autoAcceptAnchorIdList", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d2 extends vh7.c<d2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "activity_id")
    String getActivityId();

    @FieldName(name = "activity_name")
    String getActivityName();

    @FieldName(name = "auto_accept_anchor_id_list")
    List<String> getAutoAcceptAnchorIdList();

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfo();

    @FieldName(name = "cur_battle_rule")
    String getBattleRule();

    @FieldName(name = "default_respond_type")
    long getDefaultRespondType();

    @FieldName(name = "duration")
    long getDuration();

    @FieldName(name = "match_reason")
    String getMatchReason();

    @FieldName(name = "matchers")
    List<IBattlePrecisionMatcher> getMatcherList();

    @FieldName(name = "not_disturb_text")
    String getNotDisturbText();

    @FieldName(name = "play_mode")
    int getPlayMode();

    @FieldName(name = "precision_match_id")
    long getPrecisionMatchId();

    @FieldName(name = "recommend_reason")
    String getRecommendReason();

    @FieldName(name = "sign_extra")
    String getSignExtra();

    @FieldName(name = "source")
    int getSource();

    @FieldName(name = "sponsor_open_id")
    String getSponsorId();

    @FieldName(name = "sub_title")
    String getSubTitle();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "toast_content")
    String getToastContent();

    @FieldName(name = "wait_seconds")
    long getWaitSeconds();
}
