package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f252301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f252302b;

    public k(r r100, long r101) {
        this.f252301a = r100;
        this.f252302b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Disposable r101 = (Disposable) r100;
        r.a(this.f252301a, this.f252302b, true);
    }
}
