package com.larus.dora.impl.device.manage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0012H\u0007J\b\u0010\u0019\u001a\u00020\u0012H\u0007J\b\u0010\u001a\u001a\u00020\u0012H\u0007J\b\u0010\u001b\u001a\u00020\u0012H\u0007J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020\u0012H\u0017J\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'J\b\u0010!\u001a\u00020\u0012H\u0017J\b\u0010\"\u001a\u00020\u0012H\u0017J\b\u0010#\u001a\u00020\u0012H\u0017J\b\u0010$\u001a\u00020\u0012H\u0017J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0017J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\b\u0010)\u001a\u00020*H\u0007J\b\u0010+\u001a\u00020*H\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\t\u0010\u0007R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006-"}, d2 = {"Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "getLifecycleRegistry", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "_rootView", "Landroid/view/View;", "rootView", "getRootView", "()Landroid/view/View;", "performOnCreate", "", "performCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "performOnStart", "performOnStop", "performOnDestroy", "requestRefresh", "performDeviceSwitch", "event", "Lcom/larus/dora/impl/device/manage/DeviceSwitchEvent;", WidgetCostModule.TYPE_ON_CREATE, "onCreateAndSetupView", WidgetCostModule.TYPE_ON_START, "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "onRefreshRequested", "onBind", "data", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "onDeviceSwitch", "isDestroyed", "", "checkLifecycleAlive", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class LifecycleUIComponent implements LifecycleOwner {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f333691c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f333692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f333693b;

    public static final class a {
    }

    static {
    }

    public void b(p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public abstract View c(LayoutInflater r100, ViewGroup r101);

    public void e(com.larus.dora.impl.device.manage.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final LifecycleRegistry getLifecycle() {
        return (LifecycleRegistry) this.f333692a.getValue();
    }

    public LifecycleUIComponent() {
        this.f333692a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new y0(this));
    }

    public final boolean a() {
        if (getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        boolean r100 = true;
    L7:
        return !r100;
    L5:
        r100 = false;
        goto L7
    }

    public final void g() {
        if (a() == true) goto L5;
        return;
    L5:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L9;
        onStop();
        return;
    }

    public void onDestroy() {
        getLifecycle().setCurrentState(Lifecycle.State.DESTROYED);
        this.f333693b = null;
    }

    public void onStart() {
        getLifecycle().setCurrentState(Lifecycle.State.STARTED);
    }

    public void onStop() {
        getLifecycle().setCurrentState(Lifecycle.State.CREATED);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return getLifecycle();
    }

    public final View f(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        if (a() == true) goto L5;
        g49.d.c("LifecycleUIComponent", "performCreateView() called after DESTROYED", new RuntimeException());
    L5:
        View r102 = c(r100, r101);
        this.f333693b = r102;
        return r102;
    }
}
