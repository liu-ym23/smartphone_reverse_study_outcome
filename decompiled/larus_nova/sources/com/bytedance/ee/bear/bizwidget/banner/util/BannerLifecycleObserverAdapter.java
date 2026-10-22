package com.bytedance.ee.bear.bizwidget.banner.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ee.bear.bizwidget.banner.banner.Banner;

/* JADX INFO: loaded from: classes16.dex */
public class BannerLifecycleObserverAdapter implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BannerLifecycleObserver f216362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f216363b;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f216362a.onDestroy(this.f216363b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.f216362a.onStart(this.f216363b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.f216362a.onStop(this.f216363b);
    }

    public BannerLifecycleObserverAdapter(LifecycleOwner r100, Banner r101) {
        this.f216363b = r100;
        this.f216362a = r101;
    }
}
