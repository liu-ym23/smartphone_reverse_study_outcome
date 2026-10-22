package com.larus.photopicker.v2.impl;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$3"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class Injection$provideViewModel$$inlined$viewModels$default$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ Function0 $ownerProducer;
    final /* synthetic */ Fragment $this_viewModels;

    public Injection$provideViewModel$$inlined$viewModels$default$2(Function0 r100, Fragment r101) {
        this.$ownerProducer = r100;
        this.$this_viewModels = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        Object r100 = this.$ownerProducer.invoke();
        ViewModelProvider.Factory r101 = null;
        if ((r100 instanceof HasDefaultViewModelProviderFactory) == false) goto L5;
        HasDefaultViewModelProviderFactory r102 = (HasDefaultViewModelProviderFactory) r100;
    L6:
        if (r102 == null) goto L9;
        r101 = r102.getDefaultViewModelProviderFactory();
    L9:
        if (r101 == null) goto L11;
        return r101;
    L11:
        return this.$this_viewModels.getDefaultViewModelProviderFactory();
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
        return invoke();
    }
}
