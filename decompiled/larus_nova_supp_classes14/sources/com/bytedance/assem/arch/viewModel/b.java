package com.bytedance.assem.arch.viewModel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.assem.arch.viewModel.AssemViewModel;
import com.bytedance.assem.arch.viewModel.h;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<S extends h, VM extends AssemViewModel<S>> implements Lazy<VM> {
    public VM a;
    public final KClass<VM> b;
    public final Function0<String> c;
    public final Function0<f<S>> d;
    public final Function0<LifecycleOwner> e;
    public final Function0<ViewModelStore> f;
    public final Function0<ViewModelProvider.Factory> g;
    public final Function1<S, S> h;
    public final Function0<com.bytedance.assem.arch.core.b> i;
    public final Function0<com.bytedance.assem.arch.core.d> j;

    public final Object getValue() {
        VM r0 = this.a;
        if (r0 != null) goto L12;
        r0 = (VM) new ViewModelProvider((ViewModelStore) this.f.invoke(), (ViewModelProvider.Factory) this.g.invoke()).get((String) this.c.invoke(), JvmClassMappingKt.getJavaClass(this.b));
        this.a = r0;
        r0.setLifecycleRef(new WeakReference(((LifecycleOwner) this.e.invoke()).getLifecycle()));
        Function0<com.bytedance.assem.arch.core.b> r1 = this.i;
        com.bytedance.assem.arch.core.d r2 = null;
        if (r1 == null) goto L7;
        com.bytedance.assem.arch.core.b r3 = (com.bytedance.assem.arch.core.b) r1.invoke();
    L8:
        r0.injectHierarchyDataStore(r3);
        Function0<com.bytedance.assem.arch.core.d> r4 = this.j;
        if (r4 == null) goto L11;
        r2 = (com.bytedance.assem.arch.core.d) r4.invoke();
    L11:
        r0.injectHierarchyServiceStore(r2);
        r0.initialize((f) this.d.invoke(), this.h);
        goto L12
    L7:
        r3 = null;
    L12:
        return r0;
    }

    public final boolean isInitialized() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(KClass<VM> r1, Function0<String> r2, Function0<? extends f<S>> r3, Function0<? extends LifecycleOwner> r4, Function0<? extends ViewModelStore> r5, Function0<? extends ViewModelProvider.Factory> r6, Function1<? super S, ? extends S> r7, Function0<com.bytedance.assem.arch.core.b> r8, Function0<com.bytedance.assem.arch.core.d> r9) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
    }
}
