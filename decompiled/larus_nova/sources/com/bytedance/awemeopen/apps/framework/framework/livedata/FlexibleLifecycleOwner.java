package com.bytedance.awemeopen.apps.framework.framework.livedata;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/livedata/FlexibleLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FlexibleLifecycleOwner implements LifecycleOwner {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f196957e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f196958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<Lifecycle> f196959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleRegistry f196960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f196961d;

    public static final class a {
    }

    public interface b {
        void a();

        void b(int r100);

        void c();
    }

    static {
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f196960c;
    }

    public FlexibleLifecycleOwner(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "activeCondition");
        this.f196958a = r100;
        LifecycleRegistry r101 = new LifecycleRegistry(this);
        r101.markState(Lifecycle.State.CREATED);
        this.f196960c = r101;
        this.f196961d = new ArrayList();
    }

    public final void a(Lifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "realLifecycle");
        if (this.f196959b == null) goto L5;
        AoLogger.h("FlexibleLifecycleOwner", new Object[]{"mAttachLifecycleRef is not null."});
    L5:
        this.f196959b = new WeakReference(r100);
        r100.addObserver(new d04.a(this));
    }

    public final void b(int r100) {
        if (this.f196960c.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        WeakReference<Lifecycle> r101 = this.f196959b;
        boolean r102 = true;
        if (r101 == null) goto L14;
        Lifecycle r103 = r101.get();
        if (r103 == null) goto L14;
        Lifecycle.State r104 = r103.getCurrentState();
        if (r104 == null) goto L14;
        if (r104.isAtLeast(Lifecycle.State.STARTED) == true) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L17;
    L21:
        r102 = false;
    L22:
        if (r102 == false) goto L27;
        this.f196960c.markState(Lifecycle.State.STARTED);
        Iterator<T> r106 = this.f196961d.iterator();
    L25:
        if (r106.hasNext() == false) goto L29;
        ((b) r106.next()).b(r100);
        goto L25
    L29:
        return;
    L27:
        return;
    L17:
        if (this.f196958a.invoke().booleanValue() == false) goto L21;
        if (this.f196960c.getCurrentState() == Lifecycle.State.STARTED) goto L21;
    L14:
        r105 = false;
        goto L15
    }

    public final void c(int r100) {
        if (this.f196960c.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        WeakReference<Lifecycle> r101 = this.f196959b;
        boolean r102 = false;
        if (r101 == null) goto L14;
        Lifecycle r103 = r101.get();
        if (r103 == null) goto L14;
        Lifecycle.State r104 = r103.getCurrentState();
        if (r104 == null) goto L14;
        if (r104.isAtLeast(Lifecycle.State.STARTED) == true) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L19;
        if (this.f196958a.invoke().booleanValue() == false) goto L19;
    L21:
        if (r102 == false) goto L26;
        this.f196960c.markState(Lifecycle.State.CREATED);
        Iterator r106 = ((ArrayList) this.f196961d).iterator();
    L24:
        if (r106.hasNext() == false) goto L28;
        ((b) r106.next()).c();
        goto L24
    L28:
        return;
    L26:
        return;
    L19:
        if (this.f196960c.getCurrentState() == Lifecycle.State.CREATED) goto L21;
        r102 = true;
    L14:
        r105 = false;
        goto L15
    }
}
