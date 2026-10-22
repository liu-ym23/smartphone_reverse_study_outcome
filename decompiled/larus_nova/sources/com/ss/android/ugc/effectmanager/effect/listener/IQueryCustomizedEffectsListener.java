package com.ss.android.ugc.effectmanager.effect.listener;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener;
import com.ss.android.ugc.effectmanager.effect.model.CustomizedEffectsResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/listener/IQueryCustomizedEffectsListener;", "Lcom/ss/android/ugc/effectmanager/common/task/IEffectPlatformBaseListener;", "Lcom/ss/android/ugc/effectmanager/effect/model/CustomizedEffectsResponse;", "onFail", "", "e", "Lcom/ss/android/ugc/effectmanager/common/task/ExceptionResult;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public interface IQueryCustomizedEffectsListener extends IEffectPlatformBaseListener<CustomizedEffectsResponse> {
    void onFail(ExceptionResult r100);
}
