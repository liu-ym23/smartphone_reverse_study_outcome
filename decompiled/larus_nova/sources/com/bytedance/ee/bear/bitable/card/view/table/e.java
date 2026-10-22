package com.bytedance.ee.bear.bitable.card.view.table;

import com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.AsyncFetchResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableCardViewPager f208864a;

    public e(BitableCardViewPager r100) {
        this.f208864a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        final AsyncFetchResult r101 = (AsyncFetchResult) r100;
        if (r101.f209051b == AsyncFetchResult.EResultState.LOADING) goto L5;
        this.f208864a.f208834x[0] = Boolean.FALSE;
    L5:
        final BitableCardViewPager r102 = this.f208864a;
        r102.r(new BitableCardViewPager$fetchRecordsPagingLeft$disposable$1$1(r102, r101));
    }
}
