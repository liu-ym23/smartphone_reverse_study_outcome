package com.ss.android.ugc.effectmanager.effect.listener;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener;
import com.ss.android.ugc.effectmanager.effect.model.CategoryInfoModelList;

/* JADX INFO: loaded from: classes40.dex */
public interface IFetchCategoryInfoListener extends IEffectPlatformBaseListener<CategoryInfoModelList> {
    void onFail(ExceptionResult r100);
}
