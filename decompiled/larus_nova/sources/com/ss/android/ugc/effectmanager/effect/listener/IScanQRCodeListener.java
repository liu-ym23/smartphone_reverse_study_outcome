package com.ss.android.ugc.effectmanager.effect.listener;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;

/* JADX INFO: loaded from: classes40.dex */
public interface IScanQRCodeListener extends IEffectPlatformBaseListener<Effect> {
    void onFail(ExceptionResult r100);
}
