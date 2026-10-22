package com.bytedance.livesdk.ktvcommon.api;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006RB\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/api/i;", "Lvh7/c;", "", "getScoreReportingDurationThreshold", "()Ljava/lang/Long;", "setScoreReportingDurationThreshold", "(Ljava/lang/Long;)V", "getScoreReportingDurationThreshold$annotations", "()V", "scoreReportingDurationThreshold", "", "", "Lcom/bytedance/livesdk/ktvcommon/api/j;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getRateFeedback", "()Ljava/util/Map;", "setRateFeedback", "(Ljava/util/Map;)V", "getRateFeedback$annotations", "rateFeedback", "getScoreReportingThresholdSungPercent", "getScoreReportingThresholdSungPercent$annotations", "scoreReportingThresholdSungPercent", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i extends vh7.c<i> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "rate_feedback")
    Map<String, j> getRateFeedback();

    @FieldName(name = "score_reporting_duration_threshold")
    Long getScoreReportingDurationThreshold();

    @FieldName(name = "score_reporting_threshold_sung_percent")
    Long getScoreReportingThresholdSungPercent();

    @FieldName(name = "rate_feedback#setter")
    void setRateFeedback(Map<String, ? extends j> r100);

    @FieldName(name = "score_reporting_duration_threshold#setter")
    void setScoreReportingDurationThreshold(Long r100);
}
