package com.larus.office.plugins.slides.media.imggen;

import com.larus.common.mockloading.ILoadingProgressMocker;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes30.dex */
public final class r0 implements ILoadingProgressMocker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlowImpl f363395a;

    @Override // com.larus.common.mockloading.ILoadingProgressMocker
    public final int getProgress() {
        return ((Number) this.f363395a.getValue()).intValue();
    }

    public r0() {
        this.f363395a = j1.a(0);
    }

    @Override // com.larus.common.mockloading.ILoadingProgressMocker
    public final void setProgress(int r100) {
        this.f363395a.setValue(Integer.valueOf(r100));
    }
}
