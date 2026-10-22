package com.bytedance.locallife.pdp.biz.common.cache;

import com.bytedance.locallife.dito.core.v;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v.c f261018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<lp6.a, Unit> f261019b;

    public d(lx6.a r100, Function1 r101) {
        this.f261018a = r100;
        this.f261019b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        lp6.a r101 = (lp6.a) r100;
        e.f261020a.remove(this.f261018a);
        Function1<lp6.a, Unit> r102 = this.f261019b;
        if (r102 == null) goto L6;
        r102.invoke(r101);
        return;
    }
}
