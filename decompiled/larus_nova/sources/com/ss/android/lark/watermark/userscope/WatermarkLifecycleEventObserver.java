package com.ss.android.lark.watermark.userscope;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u0002\u001a\u0016\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\"\u0010\u0002\u001a\u0016\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/watermark/userscope/WatermarkLifecycleEventObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "watermarkBundleRegistry", "Ljava/util/WeakHashMap;", "", "Lcom/ss/android/lark/watermark/userscope/WatermarkTarget;", "Lcom/ss/android/lark/watermark/v2/WatermarkBundle;", "Lcom/ss/android/lark/watermark/userscope/WatermarkBundleRegistry;", "<init>", "(Ljava/util/WeakHashMap;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "watermark_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WatermarkLifecycleEventObserver implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<Object, com.ss.android.lark.watermark.v2.t> f445378a;

    public WatermarkLifecycleEventObserver(WeakHashMap<Object, com.ss.android.lark.watermark.v2.t> r100) {
        Intrinsics.checkNotNullParameter(r100, "watermarkBundleRegistry");
        this.f445378a = r100;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L6;
        this.f445378a.remove(r100);
        return;
    }
}
