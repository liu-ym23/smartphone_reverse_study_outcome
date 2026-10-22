package com.ss.android.ugc.effectmanager.effect.bridge;

import com.ss.android.ugc.effectmanager.common.task.SyncTask;
import com.ss.android.ugc.effectmanager.effect.task.result.EffectTaskResult;

/* JADX INFO: loaded from: classes40.dex */
public interface EffectFetcher {
    SyncTask<EffectTaskResult> fetchEffect(EffectFetcherArguments r100);
}
