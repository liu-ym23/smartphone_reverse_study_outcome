package com.bytedance.android.shopping.verify.api;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/verify/api/LawHintRequestListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "onClearDisposable", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LawHintRequestListener implements LifecycleObserver {
    public final CompositeDisposable a;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onClearDisposable() {
        this.a.clear();
    }

    public LawHintRequestListener(CompositeDisposable r2) {
        Intrinsics.checkNotNullParameter(r2, "compositeDisposable");
        this.a = r2;
    }
}
