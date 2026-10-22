package com.bytedance.assem.arch.viewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/AssemViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public final class AssemViewModelFactory implements ViewModelProvider.Factory {
    public AssemViewModelFactory() {
    }

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final <T extends ViewModel> T create(Class<T> r5) {
        if (AssemViewModel.class.isAssignableFrom(r5) == false) goto L19;
        return r5.newInstance();
    L12:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r5, e);
    L9:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r5, e);
    L15:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r5, e);
    L6:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r5, e);
    L19:
        throw new IllegalArgumentException("Custom ViewModel must be a subclass of LifeAwareViewModel.");
    }
}
