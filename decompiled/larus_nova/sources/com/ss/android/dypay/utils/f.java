package com.ss.android.dypay.utils;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes34.dex */
public final class f extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f408490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f408491b;

    public f(g r100, String r101, long r102, long r103) {
        this.f408490a = r100;
        this.f408491b = r101;
        super(r102, r103);
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        this.f408490a.c("COUNTDOWN_CANCEL", null);
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
        g r101 = this.f408490a;
        String r102 = this.f408491b;
        int r103 = r101.f408494c;
        r101.f408494c = r103 + 1;
        g.b(r101, r102, Integer.valueOf(r103), null, 4);
    }
}
