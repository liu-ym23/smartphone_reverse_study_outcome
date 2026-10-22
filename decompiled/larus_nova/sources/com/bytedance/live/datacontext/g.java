package com.bytedance.live.datacontext;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Class<?>, Object> f255084a;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function1<? super Class<?>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "func");
        this.f255084a = r100;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        Object r101 = this.f255084a.invoke(r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type T of com.bytedance.live.datacontext.FunctionalFactory.create");
        return (T) r101;
    }
}
