package com.larus.account.base.impl;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f286189a;

    public /* synthetic */ y(Function0 r100) {
        this.f286189a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r100 = this.f286189a;
        int r101 = MultiAccountServiceImpl.f286128f;
        r100.invoke();
    }
}
