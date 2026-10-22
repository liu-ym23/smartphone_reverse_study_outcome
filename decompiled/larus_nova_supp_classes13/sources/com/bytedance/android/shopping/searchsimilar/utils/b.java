package com.bytedance.android.shopping.searchsimilar.utils;

import com.bytedance.android.shopping.searchsimilar.model.QuerySimilarProductGuideResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Observer<QuerySimilarProductGuideResponse> {
    public b() {
    }

    public final void onComplete() {
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onNext(Object r2) {
        QuerySimilarProductGuideResponse r3 = (QuerySimilarProductGuideResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "t");
        if (r3.getStatusCode() != 0) goto L6;
        boolean r0 = f.a;
        f.a = r3.getEnableShowGuide();
        return;
    }
}
