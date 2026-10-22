package com.bytedance.awemeopen.apps.framework.framework.livedata;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/livedata/FlexibleLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "a", "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FlexibleLifecycleOwner implements LifecycleOwner {
    public static final /* synthetic */ int e = 0;
    public final Function0<Boolean> a;
    public WeakReference<Lifecycle> b;
    public final LifecycleRegistry c;
    public final List<b> d;

    public static final class a {
    }

    public interface b {
        void a();

        void b(int r1);

        void c();
    }

    static {
    }

    public final Lifecycle getLifecycle() {
        return this.c;
    }

    public FlexibleLifecycleOwner(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "activeCondition");
        this.a = r2;
        LifecycleRegistry r3 = new LifecycleRegistry(this);
        r3.markState(Lifecycle.State.CREATED);
        this.c = r3;
        this.d = new ArrayList();
    }

    public final void a(Lifecycle r4) {
        Intrinsics.checkNotNullParameter(r4, "realLifecycle");
        if (this.b == null) goto L5;
        AoLogger.h("FlexibleLifecycleOwner", new Object[]{"mAttachLifecycleRef is not null."});
    L5:
        this.b = new WeakReference(r4);
        r4.addObserver(new d04.a(this));
    }

    public final void b(int r5) {
        if (this.c.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        WeakReference<Lifecycle> r0 = this.b;
        boolean r1 = true;
        if (r0 == null) goto L14;
        Lifecycle r2 = r0.get();
        if (r2 == null) goto L14;
        Lifecycle.State r3 = r2.getCurrentState();
        if (r3 == null) goto L14;
        if (r3.isAtLeast(Lifecycle.State.STARTED) == true) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
    L21:
        r1 = false;
    L22:
        if (r1 == false) goto L27;
        this.c.markState(Lifecycle.State.STARTED);
        Iterator<T> r6 = this.d.iterator();
    L25:
        if (r6.hasNext() == false) goto L29;
        ((b) r6.next()).b(r5);
        goto L25
    L29:
        return;
    L27:
        return;
    L17:
        if (((Boolean) this.a.invoke()).booleanValue() == false) goto L21;
        if (this.c.getCurrentState() == Lifecycle.State.STARTED) goto L21;
    L14:
        r4 = false;
        goto L15
    }

    public final void c(int r4) {
        if (this.c.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        WeakReference<Lifecycle> r5 = this.b;
        boolean r0 = false;
        if (r5 == null) goto L14;
        Lifecycle r6 = r5.get();
        if (r6 == null) goto L14;
        Lifecycle.State r7 = r6.getCurrentState();
        if (r7 == null) goto L14;
        if (r7.isAtLeast(Lifecycle.State.STARTED) == true) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == true) goto L19;
        if (((Boolean) this.a.invoke()).booleanValue() == false) goto L19;
    L21:
        if (r0 == false) goto L26;
        this.c.markState(Lifecycle.State.CREATED);
        Iterator r9 = ((ArrayList) this.d).iterator();
    L24:
        if (r9.hasNext() == false) goto L28;
        ((b) r9.next()).c();
        goto L24
    L28:
        return;
    L26:
        return;
    L19:
        if (this.c.getCurrentState() == Lifecycle.State.CREATED) goto L21;
        r0 = true;
    L14:
        r8 = false;
        goto L15
    }
}
