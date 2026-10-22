package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvReuseRoomViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "Lsb0/b;", "dataEntity", "<init>", "(Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;Lsb0/b;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvReuseRoomViewModel extends KtvRoomViewModel {
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel, com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public KtvReuseRoomViewModel(KtvContext r2, sb0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "dataEntity");
        super(r2, r3);
    }
}
