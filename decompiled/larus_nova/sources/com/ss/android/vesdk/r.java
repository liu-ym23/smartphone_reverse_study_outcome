package com.ss.android.vesdk;

import com.ss.android.ttve.nativePort.TEVideoUtils;

/* JADX INFO: loaded from: classes40.dex */
public final class r implements TEVideoUtils.AVInterleaveCheckListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VEAVInterleaveChecker.AVInterleaveCheckListener f455881a;

    public r(com.ss.android.lark.videosend.checker.raw.c r100) {
        this.f455881a = r100;
    }

    @Override // com.ss.android.ttve.nativePort.TEVideoUtils.AVInterleaveCheckListener
    public final void onInfo(int r100, boolean r101, long r102) {
        this.f455881a.onInfo(r100, r101, r102);
    }
}
