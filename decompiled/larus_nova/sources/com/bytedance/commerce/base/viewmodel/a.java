package com.bytedance.commerce.base.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes15.dex */
public final class a<VM extends ViewModel> implements Lazy<VM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VM f202935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass<VM> f202936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<ViewModelStore> f202937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<ViewModelProvider.Factory> f202938d;

    @Override // kotlin.Lazy
    public final Object getValue() {
        VM r100 = this.f202935a;
        if (r100 != null) goto L6;
        ViewModelProvider.Factory r101 = this.f202938d.invoke();
        VM r102 = (VM) new ViewModelProvider(this.f202937c.invoke(), r101).get(JvmClassMappingKt.getJavaClass(this.f202936b));
        this.f202935a = r102;
        return r102;
    L6:
        return r100;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        if (this.f202935a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(KClass<VM> r100, Function0<? extends ViewModelStore> r101, Function0<? extends ViewModelProvider.Factory> r102) {
        this.f202936b = r100;
        this.f202937c = r101;
        this.f202938d = r102;
    }
}
