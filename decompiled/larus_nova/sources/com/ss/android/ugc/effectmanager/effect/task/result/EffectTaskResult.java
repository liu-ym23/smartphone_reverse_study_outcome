package com.ss.android.ugc.effectmanager.effect.task.result;

import com.ss.android.ugc.effectmanager.common.task.BaseTaskResult;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.model.Effect;

/* JADX INFO: loaded from: classes40.dex */
public class EffectTaskResult extends BaseTaskResult {
    private Effect effect;
    private ExceptionResult exception;
    private int progress;
    private long totalSize;

    public Effect getEffect() {
        return this.effect;
    }

    public ExceptionResult getException() {
        return this.exception;
    }

    public int getProgress() {
        return this.progress;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public void setEffect(Effect r100) {
        this.effect = r100;
    }

    public void setException(ExceptionResult r100) {
        this.exception = r100;
    }

    public EffectTaskResult setProgress(int r100) {
        this.progress = r100;
        return this;
    }

    public EffectTaskResult setTotalSize(long r100) {
        this.totalSize = r100;
        return this;
    }

    public EffectTaskResult(Effect r100, ExceptionResult r101) {
        this.effect = r100;
        this.exception = r101;
    }
}
