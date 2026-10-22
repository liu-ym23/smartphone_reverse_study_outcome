package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f252306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f252307b;

    public m(r r100, long r101) {
        this.f252306a = r100;
        this.f252307b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        r.a(this.f252306a, this.f252307b, false);
    }
}
