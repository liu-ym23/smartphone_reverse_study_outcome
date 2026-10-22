package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0017\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0014\u0010\u0005\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001f\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001d\u0010\u000fR\u001a\u0010\"\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0007\u001a\u0004\b \u0010\u000fR\u001c\u0010'\u001a\u0004\u0018\u00010#8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0007\u001a\u0004\b$\u0010%R\u001a\u0010*\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0007\u001a\u0004\b(\u0010\u000bR\u001a\u0010-\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0007\u001a\u0004\b+\u0010\u000bR\u001a\u00102\u001a\u00020.8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0007\u001a\u0004\b/\u00100R\u001a\u00105\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0007\u001a\u0004\b3\u0010\u000bR\u001a\u00108\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0007\u001a\u0004\b6\u0010\u0005R\u001a\u0010;\u001a\u00020.8&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0007\u001a\u0004\b9\u00100R\u001a\u0010>\u001a\u00020.8&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0007\u001a\u0004\b<\u00100R\u001a\u0010?\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0007\u001a\u0004\b?\u0010\u000bR\u001c\u0010D\u001a\u0004\u0018\u00010.8&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0007\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/a1;", "Lvh7/c;", "Laf2/b;", "", "getUserId", "()Ljava/lang/String;", "getUserId$annotations", "()V", "userId", "", "isHugeRewardPk", "()Z", "isHugeRewardPk$annotations", "", "getScore", "()I", "setScore", "(I)V", "getScore$annotations", "score", "getScoreText", "setScoreText", "(Ljava/lang/String;)V", "getScoreText$annotations", "scoreText", "getScoreRelativeText", "setScoreRelativeText", "getScoreRelativeText$annotations", "scoreRelativeText", "getBonus", "getBonus$annotations", "bonus", "getRank", "getRank$annotations", "rank", "Lcom/bytedance/android/livesdk/link/model/y2;", "getGrade", "()Lcom/bytedance/android/livesdk/link/model/y2;", "getGrade$annotations", "grade", "getScoreRelative", "getScoreRelative$annotations", "scoreRelative", "getRoomLikeTrigger", "getRoomLikeTrigger$annotations", "roomLikeTrigger", "", "getBattleRank", "()J", "getBattleRank$annotations", "battleRank", "getNewScoreOpen", "getNewScoreOpen$annotations", "newScoreOpen", "getMultiPkTeamScoreText", "getMultiPkTeamScoreText$annotations", "multiPkTeamScoreText", "getMultiPkTeamScore", "getMultiPkTeamScore$annotations", "multiPkTeamScore", "getMultiPkTeamRank", "getMultiPkTeamRank$annotations", "multiPkTeamRank", "isMultiPkTeamRelativeText", "isMultiPkTeamRelativeText$annotations", "getScoreVersion", "()Ljava/lang/Long;", "getScoreVersion$annotations", "scoreVersion", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a1 extends vh7.c<a1>, af2.b {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "battle_rank")
    long getBattleRank();

    @FieldName(name = "rank_bonus_score")
    int getBonus();

    @FieldName(name = "grade")
    y2 getGrade();

    @FieldName(name = "multi_pk_team_rank")
    long getMultiPkTeamRank();

    @FieldName(name = "multi_pk_team_score")
    long getMultiPkTeamScore();

    @FieldName(name = "multi_pk_team_score_text")
    String getMultiPkTeamScoreText();

    @FieldName(name = "new_score_open")
    boolean getNewScoreOpen();

    @FieldName(name = "weekly_rank")
    int getRank();

    @FieldName(name = "room_like_trigger")
    boolean getRoomLikeTrigger();

    @FieldName(name = "score")
    int getScore();

    @FieldName(name = "score_relative")
    boolean getScoreRelative();

    @FieldName(name = "score_relative_text")
    String getScoreRelativeText();

    @FieldName(name = "score_blur_text")
    String getScoreText();

    @FieldName(name = "score_version")
    Long getScoreVersion();

    @FieldName(name = "open_id")
    String getUserId();

    @FieldName(name = "is_large_pk_score")
    boolean isHugeRewardPk();

    @FieldName(name = "is_multi_pk_relative_text")
    boolean isMultiPkTeamRelativeText();

    @FieldName(name = "score#setter")
    void setScore(int r1);

    @FieldName(name = "score_relative_text#setter")
    void setScoreRelativeText(String r1);

    @FieldName(name = "score_blur_text#setter")
    void setScoreText(String r1);
}
