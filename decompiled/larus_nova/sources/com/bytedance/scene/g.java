package com.bytedance.scene;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f268641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f268642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SceneActivityCompatibilityLayerFragment f268643c;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f268641a.getLifecycle().removeObserver(this);
        this.f268643c.f268604b.remove(this.f268642b);
    }

    public g(SceneActivityCompatibilityLayerFragment r100, LifecycleOwner r101, int r102) {
        this.f268643c = r100;
        this.f268641a = r101;
        this.f268642b = r102;
    }
}
