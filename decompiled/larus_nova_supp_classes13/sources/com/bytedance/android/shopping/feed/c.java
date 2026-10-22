package com.bytedance.android.shopping.feed;

import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Observer<InflowGuessFeedResponse> {
    public final /* synthetic */ d a;

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
    }

    public final void onComplete() {
        this.a.c = false;
    }

    public c(d r1) {
        this.a = r1;
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.b.setValue(null);
    }

    public final void onNext(Object r2) {
        InflowGuessFeedResponse r3 = (InflowGuessFeedResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "resp");
        this.a.b.setValue(r3);
    }
}
