package com.bytedance.ee.bear.bizwidget.banner.util;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface BannerLifecycleObserver extends LifecycleObserver {
    void onDestroy(LifecycleOwner r1);

    void onStart(LifecycleOwner r1);

    void onStop(LifecycleOwner r1);
}
