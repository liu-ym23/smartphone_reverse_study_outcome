package com.bytedance.android.livesdk.ktvimpl.base;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvMidiStageViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/KtvStageViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvStageViewModelFactory implements ViewModelProvider.Factory {
    public final KtvContext a;
    public final KtvRoomViewModel b;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final <T extends ViewModel> T create(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "modelClass");
        if (r3.isAssignableFrom(KtvMidiStageViewModel.class) == false) goto L7;
        return new KtvMidiStageViewModel(this.a, this.b);
    L7:
        return new KtvMidiStageViewModel(this.a, this.b);
    }

    public KtvStageViewModelFactory(KtvContext r2, KtvRoomViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "vm");
        this.a = r2;
        this.b = r3;
    }
}
