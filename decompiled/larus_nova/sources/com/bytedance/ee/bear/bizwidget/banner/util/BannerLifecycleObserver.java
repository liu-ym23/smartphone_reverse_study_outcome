package com.bytedance.ee.bear.bizwidget.banner.util;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes16.dex */
public interface BannerLifecycleObserver extends LifecycleObserver {
    void onDestroy(LifecycleOwner r100);

    void onStart(LifecycleOwner r100);

    void onStop(LifecycleOwner r100);
}
