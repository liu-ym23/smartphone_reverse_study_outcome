package com.ss.android.ugc.effectmanager.effect.listener;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener;
import com.ss.android.ugc.effectmanager.effect.model.ProviderEffect;

/* JADX INFO: loaded from: classes40.dex */
public interface IDownloadProviderEffectListener extends IEffectPlatformBaseListener<ProviderEffect> {
    void onFail(ProviderEffect r100, ExceptionResult r101);
}
