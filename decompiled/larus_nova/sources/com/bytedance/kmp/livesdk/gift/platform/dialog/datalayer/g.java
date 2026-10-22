package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f252297a;

    public g(f r100) {
        this.f252297a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        if (this.f252297a.f252288i == false) goto L5;
        f r102 = this.f252297a;
        r102.getClass();
        jy0.b.d("GiftListShowDataStore", "onGiftRequestReady");
        r102.f252289j = true;
    L5:
        f r103 = this.f252297a;
        BehaviorSubject<u> r104 = r103.f252283d;
        AtomicInteger r105 = u.f252334c;
        r104.onNext(u.a.a(f.c(r103, r101)));
    }
}
