package com.bytedance.awemeopen.apps.framework.feed.pinch.vm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/vm/FeedControlViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FeedControlViewModelFactory implements ViewModelProvider.Factory {
    public final LifecycleOwner a;
    public final String b;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final <T extends ViewModel> T create(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "modelClass");
        return new FeedSpeedControlViewModel(this.a, this.b);
    }

    public FeedControlViewModelFactory(LifecycleOwner r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        this.a = r2;
        this.b = r3;
    }
}
