package com.bytedance.ee.bear.bizwidget.banner.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ee.bear.bizwidget.banner.banner.Banner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BannerLifecycleObserverAdapter implements LifecycleObserver {
    public final BannerLifecycleObserver a;
    public final LifecycleOwner b;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.a.onDestroy(this.b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.a.onStart(this.b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.a.onStop(this.b);
    }

    public BannerLifecycleObserverAdapter(LifecycleOwner r1, Banner r2) {
        this.b = r1;
        this.a = r2;
    }
}
