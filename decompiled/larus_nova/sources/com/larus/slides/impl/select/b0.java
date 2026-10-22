package com.larus.slides.impl.select;

import com.larus.common.mockloading.ILoadingProgressMocker;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes31.dex */
public final class b0 implements ILoadingProgressMocker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlowImpl f369632a;

    @Override // com.larus.common.mockloading.ILoadingProgressMocker
    public final int getProgress() {
        return ((Number) this.f369632a.getValue()).intValue();
    }

    public b0() {
        this.f369632a = j1.a(0);
    }

    @Override // com.larus.common.mockloading.ILoadingProgressMocker
    public final void setProgress(int r100) {
        this.f369632a.setValue(Integer.valueOf(r100));
    }
}
