package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.TimeUnit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ VisibleLogManager c;

    @Override // java.lang.Runnable
    public final void run() {
        VisibleLogManager r0 = this.c;
        if (r0.f == false) goto L6;
        r0.getClass();
        int r1 = com.bytedance.android.ec.hybrid.card.service.a.a;
        int r2 = bk.a.a;
        long r3 = RangesKt.coerceAtLeast(-1, 500);
        CompositeDisposable r4 = new CompositeDisposable();
        r0.e = r4;
        r4.add(com.bytedance.android.ec.core.rxjava.a.a(0, r3, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r0)));
        return;
    }

    public g(VisibleLogManager r1) {
        this.c = r1;
        super("start_impression_scan");
    }
}
