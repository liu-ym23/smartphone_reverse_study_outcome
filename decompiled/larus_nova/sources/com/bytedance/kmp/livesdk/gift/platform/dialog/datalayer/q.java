package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import oc6.d0;

/* JADX INFO: loaded from: classes19.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f252312a;

    public q(r r100) {
        this.f252312a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        BehaviorSubject<d0> r102 = this.f252312a.f252316d;
        d0 r103 = new d0();
        r103.b(Boolean.FALSE);
        r103.c(this.f252312a.f252314b);
        Unit r104 = Unit.INSTANCE;
        r102.onNext(r103);
    }
}
