package com.bytedance.android.shopping.widget.rittag;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements LifecycleEventObserver {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3 != Lifecycle.Event.ON_DESTROY) goto L6;
        RitTagViewCache.e.remove(r2);
        return;
    }
}
