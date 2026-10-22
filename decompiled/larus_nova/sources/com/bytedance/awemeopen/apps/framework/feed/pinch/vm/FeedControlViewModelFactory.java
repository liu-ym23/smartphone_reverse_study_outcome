package com.bytedance.awemeopen.apps.framework.feed.pinch.vm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/vm/FeedControlViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FeedControlViewModelFactory implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f195866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f195867b;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        return new FeedSpeedControlViewModel(this.f195866a, this.f195867b);
    }

    public FeedControlViewModelFactory(LifecycleOwner r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.f195866a = r100;
        this.f195867b = r101;
    }
}
