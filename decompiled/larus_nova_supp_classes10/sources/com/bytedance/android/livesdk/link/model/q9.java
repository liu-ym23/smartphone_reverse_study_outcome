package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R:\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\t\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0019\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0011R.\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\t\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0011¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/q9;", "Lvh7/c;", "", "", "Lcom/bytedance/android/livesdk/link/model/s9;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getTeamTaskPeriodConfig", "()Ljava/util/Map;", "getTeamTaskPeriodConfig$annotations", "()V", "teamTaskPeriodConfig", "getRewardBuffMultiple", "()J", "getRewardBuffMultiple$annotations", "rewardBuffMultiple", "", "getTaskType", "()I", "getTaskType$annotations", "taskType", "getTargetType", "getTargetType$annotations", "targetType", "getRewardType", "getRewardType$annotations", "rewardType", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getStageRewardBuffMultiple", "()Ljava/util/List;", "getStageRewardBuffMultiple$annotations", "stageRewardBuffMultiple", "getWorkType", "getWorkType$annotations", "workType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q9 extends vh7.c<q9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "reward_buff_multiple")
    long getRewardBuffMultiple();

    @FieldName(name = "reward_type")
    int getRewardType();

    @FieldName(name = "stage_reward_buff_multiple")
    List<Long> getStageRewardBuffMultiple();

    @FieldName(name = "target_type")
    int getTargetType();

    @FieldName(name = "task_type")
    int getTaskType();

    @FieldName(name = "period_config")
    Map<Long, s9> getTeamTaskPeriodConfig();

    @FieldName(name = "team_work_team_task_type")
    int getWorkType();
}
