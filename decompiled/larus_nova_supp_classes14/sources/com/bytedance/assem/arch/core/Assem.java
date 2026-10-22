package com.bytedance.assem.arch.core;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\b\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/assem/arch/core/Assem;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class Assem implements LifecycleOwner, ViewModelStoreOwner {
    public static final /* synthetic */ KProperty[] g = null;
    public boolean a;
    public volatile boolean b;
    public final LifecycleRegistry c;
    public AssemSupervisor d;
    public final ViewModelStore e;
    public final a f;

    public static final class a extends i<LifecycleOwner> {
        public final /* synthetic */ Assem c;

        public a(Assem r1) {
            this.c = r1;
        }
    }

    static {
        g = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(Assem.class), "parent", "getParent()Landroidx/lifecycle/LifecycleOwner;"))};
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final Context getContext() {
        AssemSupervisor r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("supervisor");
    L6:
        return r0.getContext();
    }

    public final AssemSupervisor j() {
        AssemSupervisor r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("supervisor");
    L5:
        return r0;
    }

    public final void l() {
        this.c.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        onPause();
    }

    public final boolean o() {
        return this.c.getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public Assem() {
        this.b = true;
        this.c = new LifecycleRegistry(this);
        this.e = new ViewModelStore();
        int r0 = i.b;
        this.f = new a(this);
    }

    public final void k() {
        onCreate();
        this.c.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public void m() {
        onResume();
        this.c.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    public Lifecycle getLifecycle() {
        return this.c;
    }

    public final ViewModelStore getViewModelStore() {
        return this.e;
    }
}
