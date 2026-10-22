package com.larus.call_plugins_doubao_common.manager;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f321394a;

    public /* synthetic */ d(ValueAnimator r100) {
        this.f321394a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ValueAnimator r100 = this.f321394a;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }
}
