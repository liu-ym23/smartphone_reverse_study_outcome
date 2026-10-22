package com.larus.asr;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes24.dex */
public final class y4 extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x4 f288261a;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        x4.a(this.f288261a, 0);
        this.f288261a.f288253h.invoke();
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
        this.f288261a.getClass();
        x4.a(this.f288261a, r100);
    }

    public y4(x4 r100, long r101, long r102) {
        this.f288261a = r100;
        super(r101, r102);
    }
}
