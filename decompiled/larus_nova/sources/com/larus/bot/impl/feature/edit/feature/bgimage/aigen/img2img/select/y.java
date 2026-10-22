package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import com.larus.common.mockloading.ILoadingProgressMocker;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class y implements ILoadingProgressMocker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlowImpl f318850a;

    @Override // com.larus.common.mockloading.ILoadingProgressMocker
    public final int getProgress() {
        return ((Number) this.f318850a.getValue()).intValue();
    }

    public y() {
        this.f318850a = j1.a(0);
    }

    @Override // com.larus.common.mockloading.ILoadingProgressMocker
    public final void setProgress(int r100) {
        this.f318850a.setValue(Integer.valueOf(r100));
    }
}
