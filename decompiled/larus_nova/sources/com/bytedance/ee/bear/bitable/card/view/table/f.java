package com.bytedance.ee.bear.bitable.card.view.table;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableCardViewPager f208865a;

    public f(BitableCardViewPager r100) {
        this.f208865a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("BitableCardViewPager_async", "fetchRecordsPagingLeft error", (Throwable) r100, false);
        this.f208865a.f208834x[0] = Boolean.FALSE;
    }
}
