package com.bytedance.android.livesdk.lottie;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ k a;

    public h(k r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        ((LottieService.a) this.a.c).a.onNext(0);
    }
}
