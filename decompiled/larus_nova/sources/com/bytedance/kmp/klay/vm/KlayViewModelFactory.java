package com.bytedance.kmp.klay.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.kmp.klay.ui.KlayModuleNode;
import com.bytedance.kmp.klay.vm.KlayViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/klay/vm/KlayViewModelFactory;", "Lcom/bytedance/kmp/klay/vm/KlayViewModel;", "VM", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "klay_release"}, k = 1, mv = {1, 7, 0})
public abstract class KlayViewModelFactory<VM extends KlayViewModel> implements ViewModelProvider.Factory {
    public KlayViewModelFactory() {
    }

    public abstract VM a();

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(KClass<T> r100, CreationExtras r101) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        Intrinsics.checkNotNullParameter(r101, "extras");
        KlayViewModel r102 = a();
        r102.setModuleNode$klay_release((KlayModuleNode) r101.get(KlayModuleNodeCreationExtraKey.f252194a));
        if (r102.getModuleNode$klay_release() != null) goto L5;
        eb6.a.f471798a.getClass();
        eb6.a.b("internal error, moduleNode extra data is null");
    L5:
        r102.onCreated();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type T of com.bytedance.kmp.klay.vm.KlayViewModelFactory.create");
        return r102;
    }
}
