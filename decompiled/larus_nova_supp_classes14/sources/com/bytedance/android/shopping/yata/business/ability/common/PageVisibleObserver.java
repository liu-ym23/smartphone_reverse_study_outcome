package com.bytedance.android.shopping.yata.business.ability.common;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/yata/business/ability/common/PageVisibleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "onResume", "onPause", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageVisibleObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        throw null;
    }
}
