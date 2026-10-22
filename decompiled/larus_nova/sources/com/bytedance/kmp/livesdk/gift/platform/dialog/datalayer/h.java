package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f252298a;

    public h(f r100) {
        this.f252298a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f r101 = this.f252298a;
        r101.f252286g = (List) r100;
        List r102 = (List) r101.f252290k.j6(false, -1).getValue();
        if (r102 == null) goto L6;
        f r103 = this.f252298a;
        BehaviorSubject<u> r104 = r103.f252283d;
        AtomicInteger r105 = u.f252334c;
        r104.onNext(u.a.a(f.c(r103, r102)));
        return;
    }
}
