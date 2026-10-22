package com.ss.android.ugc.effectmanager.effect.listener;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener;
import com.ss.android.ugc.effectmanager.effect.model.FetchHotEffectResponse;

/* JADX INFO: loaded from: classes40.dex */
public interface IFetchHotEffectListener extends IEffectPlatformBaseListener<FetchHotEffectResponse> {
    void onFailed(ExceptionResult r100);
}
