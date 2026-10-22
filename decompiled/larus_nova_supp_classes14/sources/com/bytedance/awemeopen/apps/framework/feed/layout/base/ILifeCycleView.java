package com.bytedance.awemeopen.apps.framework.feed.layout.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0017J\b\u0010\u0006\u001a\u00020\u0004H\u0017J\b\u0010\u0007\u001a\u00020\u0004H\u0017J\b\u0010\b\u001a\u00020\u0004H\u0017J\b\u0010\t\u001a\u00020\u0004H\u0017J\b\u0010\n\u001a\u00020\u0004H\u0017¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/base/ILifeCycleView;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "", "", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public interface ILifeCycleView extends LifecycleObserver, LifecycleOwner {

    public static final class a {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public static void onCreate(ILifeCycleView r1) {
            r1.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public static void onDestroy(ILifeCycleView r1) {
            r1.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public static void onPause(ILifeCycleView r1) {
            r1.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public static void onResume(ILifeCycleView r1) {
            r1.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public static void onStart(ILifeCycleView r1) {
            r1.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_START);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public static void onStop(ILifeCycleView r1) {
            r1.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
    }

    LifecycleRegistry getLifecycleRegistry();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate();

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy();

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume();

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart();

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop();
}
