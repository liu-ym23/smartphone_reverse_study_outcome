package com.ss.android.lark.multitask;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/ss/android/lark/multitask/MultitaskHelper$init$2$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "multitask_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultitaskHelper$init$2$1 implements LifecycleEventObserver {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f432833a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f432833a = r100;
        }
    }

    public MultitaskHelper$init$2$1() {
        throw null;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (a.f432833a[r101.ordinal()] == 1) goto L6;
        return;
    L6:
        throw null;
    }
}
