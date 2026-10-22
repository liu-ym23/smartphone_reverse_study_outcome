package com.bytedance.assem.arch.core;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\b\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/assem/arch/core/Assem;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class Assem implements LifecycleOwner, ViewModelStoreOwner {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f192851g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f192852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f192853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleRegistry f192854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AssemSupervisor f192855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewModelStore f192856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f192857f;

    public static final class a extends i<LifecycleOwner> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Assem f192858c;

        public a(Assem r100) {
            this.f192858c = r100;
        }
    }

    static {
        f192851g = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(Assem.class), "parent", "getParent()Landroidx/lifecycle/LifecycleOwner;"))};
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
        AssemSupervisor r100 = this.f192855d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("supervisor");
    L6:
        return r100.getContext();
    }

    public final AssemSupervisor j() {
        AssemSupervisor r100 = this.f192855d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("supervisor");
    L5:
        return r100;
    }

    public final void l() {
        this.f192854c.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        onPause();
    }

    public final boolean o() {
        return this.f192854c.getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public Assem() {
        this.f192853b = true;
        this.f192854c = new LifecycleRegistry(this);
        this.f192856e = new ViewModelStore();
        int r100 = i.f192896b;
        this.f192857f = new a(this);
    }

    public final void k() {
        onCreate();
        this.f192854c.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public void m() {
        onResume();
        this.f192854c.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f192854c;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.f192856e;
    }
}
