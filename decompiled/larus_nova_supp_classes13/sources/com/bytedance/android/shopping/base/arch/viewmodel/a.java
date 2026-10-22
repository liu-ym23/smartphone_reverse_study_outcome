package com.bytedance.android.shopping.base.arch.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<VM extends ViewModel> implements Lazy<VM> {
    public VM a;
    public final KClass<VM> b;
    public final Function0<ViewModelStore> c;
    public final Function0<ViewModelProvider.Factory> d;

    public final Object getValue() {
        VM r0 = this.a;
        if (r0 != null) goto L6;
        ViewModelProvider.Factory r1 = (ViewModelProvider.Factory) this.d.invoke();
        VM r2 = (VM) new ViewModelProvider((ViewModelStore) this.c.invoke(), r1).get(JvmClassMappingKt.getJavaClass(this.b));
        this.a = r2;
        return r2;
    L6:
        return r0;
    }

    public final boolean isInitialized() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public a(KClass r2, FragmentViewModelLazyKt$viewModels$2 r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModelClass");
        Intrinsics.checkNotNullParameter(r3, "storeProducer");
        Intrinsics.checkNotNullParameter(r4, "factoryProducer");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
