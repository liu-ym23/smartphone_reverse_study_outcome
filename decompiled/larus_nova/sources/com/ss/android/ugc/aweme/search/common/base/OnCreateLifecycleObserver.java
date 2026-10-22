package com.ss.android.ugc.aweme.search.common.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ss.android.ugc.aweme.search.utils.EventBusWrapper;

/* JADX INFO: loaded from: classes40.dex */
public class OnCreateLifecycleObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        EventBusWrapper.a(null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        EventBusWrapper.b(null);
        throw null;
    }
}
