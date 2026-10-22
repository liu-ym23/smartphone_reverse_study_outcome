package com.larus.call_plugins_doubao_common.manager;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f321408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f321409b;

    public /* synthetic */ h(ValueAnimator r100, ValueAnimator r101) {
        this.f321408a = r100;
        this.f321409b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ValueAnimator r100 = this.f321408a;
        ValueAnimator r101 = this.f321409b;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        r101.start();
    }
}
