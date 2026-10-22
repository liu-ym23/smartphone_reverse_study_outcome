package com.obric.assistant.card.manager;

import android.os.CountDownTimer;
import android.os.Handler;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f386524a;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        a.f386515b.remove(this.f386524a);
        a.f386514a.remove(this.f386524a);
        Handler r100 = a.f386517d;
        final String r101 = this.f386524a;
        r100.post(new b(r101));
        a.b(this.f386524a, 1);
    }

    public d(String r100) {
        this.f386524a = r100;
        super(5000, 1000);
    }

    @Override // android.os.CountDownTimer
    public final void onTick(final long r100) {
        Long r101 = Long.valueOf(r100);
        a.f386515b.put(this.f386524a, r101);
        Handler r102 = a.f386517d;
        final String r103 = this.f386524a;
        r102.post(new c(r103, r100));
    }
}
