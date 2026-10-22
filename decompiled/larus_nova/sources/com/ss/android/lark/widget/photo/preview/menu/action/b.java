package com.ss.android.lark.widget.photo.preview.menu.action;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Lifecycle f446838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f446839b;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        com.ss.android.lark.compose.foundation.toast.g r100 = this.f446839b.f446849h;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f446838a.removeObserver(this);
    }

    public b(d r100, Lifecycle r101) {
        this.f446839b = r100;
        this.f446838a = r101;
    }
}
