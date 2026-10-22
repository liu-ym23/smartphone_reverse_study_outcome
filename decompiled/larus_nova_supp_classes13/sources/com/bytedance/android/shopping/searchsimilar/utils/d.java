package com.bytedance.android.shopping.searchsimilar.utils;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements Observer<CommerceBaseResponse> {
    public d() {
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
        Intrinsics.checkNotNullParameter((CommerceBaseResponse) r2, "t");
    }
}
