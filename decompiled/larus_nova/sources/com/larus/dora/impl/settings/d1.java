package com.larus.dora.impl.settings;

import android.os.CountDownTimer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final class d1 extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f338027a;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
    }

    public d1(Function0<Unit> r100) {
        this.f338027a = r100;
        super(2000, 1000);
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
        if (DoraSetting.f338024b == false) goto L6;
        this.f338027a.invoke();
        cancel();
        return;
    }
}
