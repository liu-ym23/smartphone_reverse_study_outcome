package com.bytedance.tiktok.proxy;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/tiktok/proxy/LifecycleForceNotifyObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/Observer;", "reused-proxy_release"}, k = 1, mv = {1, 4, 0})
public final class LifecycleForceNotifyObserver<T> implements LifecycleEventObserver, Observer<T> {
    @Override // androidx.lifecycle.Observer
    public final void onChanged(T r100) {
        throw null;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        throw null;
    }
}
