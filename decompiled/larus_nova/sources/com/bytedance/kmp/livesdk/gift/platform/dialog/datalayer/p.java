package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import oc6.d0;

/* JADX INFO: loaded from: classes19.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f252310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f252311b;

    public p(r r100, int r101) {
        this.f252310a = r100;
        this.f252311b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        r r102 = this.f252310a;
        r102.f252314b = this.f252311b;
        BehaviorSubject<d0> r103 = r102.f252316d;
        d0 r104 = new d0();
        r104.b(Boolean.FALSE);
        r104.c(this.f252310a.f252314b);
        Unit r105 = Unit.INSTANCE;
        r103.onNext(r104);
    }
}
