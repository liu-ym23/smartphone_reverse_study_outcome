package com.bytedance.jedi.ext.adapter.internal;

import androidx.lifecycle.JediViewHolderProxyViewModelStore;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.LifecycleOwnerHolder;
import com.bytedance.jedi.arch.NestedLifecycleOwner;
import com.bytedance.jedi.arch.ReceiverHolder;
import com.bytedance.jedi.ext.adapter.JediViewHolder;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/internal/JediViewHolderProxy;", "", "Lcom/bytedance/jedi/arch/NestedLifecycleOwner;", "Landroidx/lifecycle/LifecycleObserver;", "", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroid/arch/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/JediViewHolderProxyViewModelStore;", "getStore", "()Landroid/arch/lifecycle/JediViewHolderProxyViewModelStore;", ComplianceConstants.ComplianceRequest.MARKET_STORE, "<init>", "()V", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public final class JediViewHolderProxy implements LifecycleOwnerHolder, ReceiverHolder, NestedLifecycleOwner, LifecycleObserver {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f251001h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f251002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JediViewHolder<? extends IReceiver, ?> f251003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f251004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy<JediViewHolderProxyViewModelStore> f251005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f251006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f251007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f251008g;

    static {
        f251001h = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JediViewHolderProxy.class), "lifecycleRegistry", "getLifecycleRegistry()Landroid/arch/lifecycle/LifecycleRegistry;"))};
    }

    @Override // com.bytedance.jedi.arch.LifecycleOwnerHolder
    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    public final LifecycleRegistry getLifecycleRegistry() {
        Lazy r100 = this.f251008g;
        KProperty r101 = f251001h[0];
        return (LifecycleRegistry) r100.getValue();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        this.f251006e = false;
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // com.bytedance.jedi.arch.ReceiverHolder
    public final IReceiver getReceiver() {
        if (this.f251004c == false) goto L6;
        return null;
    L6:
        return this.f251003b;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        if (this.f251004c == false) goto L5;
        JediViewHolder<? extends IReceiver, ?> r100 = null;
    L6:
        if (r100 == null) goto L11;
        this.f251002a = true;
        if (this.f251007f == false) goto L12;
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_START);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r100 = this.f251003b;
        goto L6
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        if (this.f251004c == false) goto L5;
        JediViewHolder<? extends IReceiver, ?> r100 = null;
    L6:
        if (r100 == null) goto L9;
        this.f251002a = true;
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        return;
    L9:
        return;
    L5:
        r100 = this.f251003b;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("Proxy@");
        r100.append(Integer.toHexString(hashCode()));
        r100.append("(holder@");
        JediViewHolder<? extends IReceiver, ?> r101 = this.f251003b;
        if (r101 == null) goto L5;
        String r102 = Integer.toHexString(r101.hashCode());
    L6:
        r100.append(r102);
        r100.append(",detached:");
        r100.append(this.f251004c);
        r100.append(",state:");
        r100.append(getLifecycleRegistry().getCurrentState());
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public JediViewHolderProxy() {
        this.f251002a = true;
        this.f251005d = LazyKt.lazy(JediViewHolderProxy$realStore$1.INSTANCE);
        this.f251008g = LazyKt.lazy(new JediViewHolderProxy$lifecycleRegistry$2(this));
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        if (this.f251005d.isInitialized() == false) goto L5;
        this.f251005d.getValue().clear();
    L5:
        this.f251006e = true;
    }

    @Override // com.bytedance.jedi.arch.NestedLifecycleOwner
    public final boolean isLastEventEmittedByParent() {
        return this.f251002a;
    }

    public final void a(JediViewHolderProxyManager r100, JediViewHolder<? extends IReceiver, ?> r101) {
        if (r101 == null) goto L6;
        this.f251003b = r101;
        r101.f250960g = this;
        this.f251004c = false;
        r100.getClass();
        if (r100.f251018c.add(this) == false) goto L8;
        r100.f251019d.addObserver(this);
        return;
    L8:
        return;
    L6:
        this.f251003b = null;
    }
}
