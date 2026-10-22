package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\rR\u001a\u0010\u001f\u001a\u00020\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/link/model/r9;", "Lvh7/c;", "", "getTargetUserCount", "()J", "getTargetUserCount$annotations", "()V", "targetUserCount", "getFinishUserCount", "getFinishUserCount$annotations", "finishUserCount", "", "getTeamTaskResult", "()I", "getTeamTaskResult$annotations", "teamTaskResult", "Lcom/bytedance/android/livesdk/link/model/t9;", "getTeamTaskReward", "()Lcom/bytedance/android/livesdk/link/model/t9;", "getTeamTaskReward$annotations", "teamTaskReward", "getRatio", "getRatio$annotations", "ratio", "getRole", "getRole$annotations", "role", "", "getProgressText", "()Ljava/lang/String;", "getProgressText$annotations", "progressText", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r9 extends vh7.c<r9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "finish_user_count")
    long getFinishUserCount();

    @FieldName(name = "progress_blur_text")
    String getProgressText();

    @FieldName(name = "ratio")
    long getRatio();

    @FieldName(name = "role")
    int getRole();

    @FieldName(name = "target_user_count")
    long getTargetUserCount();

    @FieldName(name = "result")
    int getTeamTaskResult();

    @FieldName(name = "reward")
    t9 getTeamTaskReward();
}
