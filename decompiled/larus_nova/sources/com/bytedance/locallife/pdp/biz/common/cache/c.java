package com.bytedance.locallife.pdp.biz.common.cache;

import com.bytedance.locallife.dito.core.v;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v.c f261017a;

    public c(lx6.a r100) {
        this.f261017a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        e.f261020a.remove(this.f261017a);
    }
}
