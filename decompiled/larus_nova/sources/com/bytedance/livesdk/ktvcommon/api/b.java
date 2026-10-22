package com.bytedance.livesdk.ktvcommon.api;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010(\u001a\u0004\u0018\u00010\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R$\u0010,\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\b\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015¨\u0006-"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/api/b;", "Lvh7/c;", "", "getRank", "()Ljava/lang/Long;", "setRank", "(Ljava/lang/Long;)V", "getRank$annotations", "()V", "rank", "Lcom/bytedance/livesdk/ktvcommon/api/c;", "getUserInfo", "()Lcom/bytedance/livesdk/ktvcommon/api/c;", "setUserInfo", "(Lcom/bytedance/livesdk/ktvcommon/api/c;)V", "getUserInfo$annotations", "userInfo", "", "isHighScoreSinging", "()Ljava/lang/Boolean;", "setHighScoreSinging", "(Ljava/lang/Boolean;)V", "isHighScoreSinging$annotations", "", "getHighScoreSongThreshold", "()Ljava/lang/Double;", "setHighScoreSongThreshold", "(Ljava/lang/Double;)V", "getHighScoreSongThreshold$annotations", "highScoreSongThreshold", "", "getHighScoreFeedbackText", "()Ljava/lang/String;", "setHighScoreFeedbackText", "(Ljava/lang/String;)V", "getHighScoreFeedbackText$annotations", "highScoreFeedbackText", "getComponentNotHighScoreEndingText", "setComponentNotHighScoreEndingText", "getComponentNotHighScoreEndingText$annotations", "componentNotHighScoreEndingText", "getIfSingForEnoughTime", "setIfSingForEnoughTime", "getIfSingForEnoughTime$annotations", "ifSingForEnoughTime", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.c<b> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "component_not_high_score_ending_text")
    String getComponentNotHighScoreEndingText();

    @FieldName(name = "high_score_feedback_text")
    String getHighScoreFeedbackText();

    @FieldName(name = "high_score_song_threshold")
    Double getHighScoreSongThreshold();

    @FieldName(name = "if_sing_for_enough_time")
    Boolean getIfSingForEnoughTime();

    @FieldName(name = "rank_percent")
    Long getRank();

    @FieldName(name = "SingerUserInfo")
    c getUserInfo();

    @FieldName(name = "is_high_score_singing")
    Boolean isHighScoreSinging();

    @FieldName(name = "component_not_high_score_ending_text#setter")
    void setComponentNotHighScoreEndingText(String r100);

    @FieldName(name = "high_score_feedback_text#setter")
    void setHighScoreFeedbackText(String r100);

    @FieldName(name = "is_high_score_singing#setter")
    void setHighScoreSinging(Boolean r100);

    @FieldName(name = "high_score_song_threshold#setter")
    void setHighScoreSongThreshold(Double r100);

    @FieldName(name = "if_sing_for_enough_time#setter")
    void setIfSingForEnoughTime(Boolean r100);

    @FieldName(name = "rank_percent#setter")
    void setRank(Long r100);

    @FieldName(name = "SingerUserInfo#setter")
    void setUserInfo(c r100);
}
