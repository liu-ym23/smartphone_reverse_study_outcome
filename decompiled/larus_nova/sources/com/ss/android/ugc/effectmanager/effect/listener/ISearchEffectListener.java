package com.ss.android.ugc.effectmanager.effect.listener;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener;
import com.ss.android.ugc.effectmanager.effect.model.SearchEffectResponse;

/* JADX INFO: loaded from: classes40.dex */
public interface ISearchEffectListener extends IEffectPlatformBaseListener<SearchEffectResponse> {
    void onFail(ExceptionResult r100);
}
