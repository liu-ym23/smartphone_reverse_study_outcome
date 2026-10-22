package com.bytedance.assem.arch.extensions;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.assem.arch.core.Assem;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class VMExtKt {
    public static final Function0<ViewModelProvider.Factory> b() {
        return VMExtKt$getAssemFactoryProducer$1.INSTANCE;
    }

    public static final <S extends com.bytedance.assem.arch.viewModel.h> Function0<com.bytedance.assem.arch.viewModel.f<S>> h() {
        return VMExtKt$getDispatcherFactoryProducer$1.INSTANCE;
    }

    public static final Function0<ViewModelProvider.Factory> g(final Assem r1) {
        return new VMExtKt$getDefaultViewModelProviderFactoryProducer$1(r1);
    }

    public static final Function0<com.bytedance.assem.arch.core.b> j(final Assem r1) {
        return new VMExtKt$getHierarchyDataStoreProducer$1(r1);
    }

    public static final Function0<com.bytedance.assem.arch.core.d> k(final Assem r1) {
        return new VMExtKt$getHierarchyServiceStoreProducer$1(r1);
    }

    public static final Function0 l(LifecycleOwner r2) {
        return new VMExtKt$getLifecycleOwnerProducer$1(r2, true);
    }

    public static Function0 m(LifecycleOwner r2) {
        return new VMExtKt$getLifecycleOwnerProducer$1(r2, false);
    }

    public static final Function0 n(ViewModelStoreOwner r2) {
        return new VMExtKt$getVMStoreProducer$1(r2, true);
    }

    public static Function0 o(ViewModelStoreOwner r2) {
        return new VMExtKt$getVMStoreProducer$1(r2, false);
    }

    public static final Function0<com.bytedance.assem.arch.core.b> a(final Assem r1, final boolean r2) {
        return new VMExtKt$getAssemDataProducer$1(r1, r2);
    }

    public static final Function0<LifecycleOwner> c(final Assem r1, final boolean r2) {
        return new VMExtKt$getAssemLifecycleOwner$1(r1, r2);
    }

    public static final Function0<com.bytedance.assem.arch.core.d> d(final Fragment r1, final boolean r2) {
        return new VMExtKt$getAssemServiceStoreProducer$2(r1, r2);
    }

    public static final Function0<com.bytedance.assem.arch.core.d> e(final Assem r1, final boolean r2) {
        return new VMExtKt$getAssemServiceStoreProducer$3(r1, r2);
    }

    public static final Function0<ViewModelStore> f(final Assem r1, final boolean r2) {
        return new VMExtKt$getAssemViewModelStore$1(r1, r2);
    }

    public static final Function0<com.bytedance.assem.arch.core.b> i(final Fragment r1, final boolean r2) {
        return new VMExtKt$getFragmentAssemDataProducer$1(r1, r2);
    }
}
