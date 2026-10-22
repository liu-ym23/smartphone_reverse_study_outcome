package com.bytedance.android.livesdk.linkvideo;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/AnchorLinkVideoListViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLinkVideoListViewModelFactory implements ViewModelProvider.Factory {
    public final int a;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public AnchorLinkVideoListViewModelFactory() {
        this.a = 0;
    }

    public final <T extends ViewModel> T create(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "modelClass");
        return new AnchorLinkVideoListViewModel(this.a);
    }
}
