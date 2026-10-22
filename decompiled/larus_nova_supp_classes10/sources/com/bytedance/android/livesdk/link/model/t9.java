package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001e\u0010\b\u001a\u00060\u0002j\u0002`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001e\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/t9;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/TimeInt64;", "getBeginSecond", "()J", "getBeginSecond$annotations", "()V", "beginSecond", "getEndSecond", "getEndSecond$annotations", "endSecond", "getRewardScore", "getRewardScore$annotations", "rewardScore", "getCurrentRewardBuffMultiple", "getCurrentRewardBuffMultiple$annotations", "currentRewardBuffMultiple", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t9 extends vh7.c<t9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "begin_second_relative_battle_finish")
    long getBeginSecond();

    @FieldName(name = "current_reward_buff_multiple")
    long getCurrentRewardBuffMultiple();

    @FieldName(name = "end_second_relative_battle_finish")
    long getEndSecond();

    @FieldName(name = "reward_score")
    long getRewardScore();
}
