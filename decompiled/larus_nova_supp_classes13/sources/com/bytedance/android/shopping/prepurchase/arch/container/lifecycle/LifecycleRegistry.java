package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleObserver;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LifecycleRegistry extends Lifecycle {
    public final LifecycleRegistry$owner$1 b;
    public final Map<d, LifecycleObserver> c;
    public final Lazy d;
    public final e e;

    public final androidx.lifecycle.LifecycleRegistry e() {
        return (androidx.lifecycle.LifecycleRegistry) this.d.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle
    public final Lifecycle.State b() {
        androidx.lifecycle.Lifecycle.State r0 = e().getCurrentState();
        int r1 = g.a[r0.ordinal()];
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L22;
        if (r1 == 4) goto L21;
        if (r1 != 5) goto L14;
        return Lifecycle.State.RESUMED;
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return Lifecycle.State.STARTED;
    L22:
        return Lifecycle.State.CREATED;
    L23:
        return Lifecycle.State.INITIALIZED;
    L19:
        return Lifecycle.State.DESTROYED;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleRegistry$owner$1] */
    public LifecycleRegistry(e r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.e = r2;
        this.b = new LifecycleRegistry$owner$1(this);
        this.c = new LinkedHashMap();
        this.d = LazyKt.lazy(new LifecycleRegistry$lifecycleRegistry$2(this));
    }

    public static void d(String r2) {
        Handler r0 = com.bytedance.android.shopping.prepurchase.arch.utils.a.a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(("Method " + r2 + " must be called on the main thread").toString());
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle
    public final void a(final d r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        d("addObserver");
        LifecycleObserver r0 = new LifecycleRegistry$addObserver$realObserver$1(this, r3);
        this.c.put(r3, r0);
        e().addObserver(r0);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle
    public final void c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        d("removeObserver");
        LifecycleObserver r3 = this.c.remove(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        e().removeObserver(r3);
    }

    public final void f(Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        androidx.lifecycle.LifecycleRegistry r0 = e();
        switch(g.c[r3.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        androidx.lifecycle.Lifecycle.Event r4 = androidx.lifecycle.Lifecycle.Event.ON_ANY;
    L13:
        r0.handleLifecycleEvent(r4);
        return;
    L7:
        r4 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY;
        goto L13
    L8:
        r4 = androidx.lifecycle.Lifecycle.Event.ON_STOP;
        goto L13
    L9:
        r4 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE;
        goto L13
    L10:
        r4 = androidx.lifecycle.Lifecycle.Event.ON_RESUME;
        goto L13
    L11:
        r4 = androidx.lifecycle.Lifecycle.Event.ON_START;
        goto L13
    L12:
        r4 = androidx.lifecycle.Lifecycle.Event.ON_CREATE;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
