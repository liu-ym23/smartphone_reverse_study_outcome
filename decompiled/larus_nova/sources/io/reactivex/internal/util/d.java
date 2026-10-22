package io.reactivex.internal.util;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes41.dex */
public final class d extends CountDownLatch implements Consumer<Throwable>, Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f495049a;

    public d() {
        super(1);
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        countDown();
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        this.f495049a = r100;
        countDown();
    }
}
