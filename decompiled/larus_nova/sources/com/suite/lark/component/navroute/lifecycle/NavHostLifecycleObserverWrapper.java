package com.suite.lark.component.navroute.lifecycle;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.suite.lark.component.navroute.api.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001e\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/suite/lark/component/navroute/lifecycle/NavHostLifecycleObserverWrapper;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "navHost", "Lcom/suite/lark/component/navroute/api/NavRouteHost;", "Lcom/suite/lark/component/navroute/api/IRouter;", "observer", "Lcom/suite/lark/component/navroute/lifecycle/NavHostLifecycleObserver;", "<init>", "(Lcom/suite/lark/component/navroute/api/NavRouteHost;Lcom/suite/lark/component/navroute/lifecycle/NavHostLifecycleObserver;)V", WidgetCostModule.TYPE_ON_CREATE, "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onResume", "onPause", LiveCommonConstants.REASON_ON_DEDTROY, "equals", "", "other", "", "hashCode", "", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NavHostLifecycleObserverWrapper implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f<? extends com.suite.lark.component.navroute.api.a<?, ?>> f460390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f460391b;

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
    }

    public final int hashCode() {
        return this.f460391b.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NavHostLifecycleObserverWrapper) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f460391b, ((NavHostLifecycleObserverWrapper) r100).f460391b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f460391b.d(this.f460390a);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f460391b.b(this.f460390a);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f460391b.c(this.f460390a);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f460391b.a(this.f460390a);
    }

    public NavHostLifecycleObserverWrapper(f<? extends com.suite.lark.component.navroute.api.a<?, ?>> r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "navHost");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f460390a = r100;
        this.f460391b = r101;
    }
}
