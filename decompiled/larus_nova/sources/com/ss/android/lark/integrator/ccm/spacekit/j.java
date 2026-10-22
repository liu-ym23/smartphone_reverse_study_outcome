package com.ss.android.lark.integrator.ccm.spacekit;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements Consumer<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long[] f427902a;

    public j(long[] r100) {
        this.f427902a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Long r100) throws Exception {
        long[] r101 = this.f427902a;
        r101[0] = r101[0] + r100.longValue();
    }
}
