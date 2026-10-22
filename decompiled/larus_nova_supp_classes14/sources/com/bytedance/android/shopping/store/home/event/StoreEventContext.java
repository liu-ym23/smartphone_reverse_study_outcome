package com.bytedance.android.shopping.store.home.event;

import com.bytedance.android.ec.core.event.BaseEventContext;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/home/event/StoreEventContext;", "Lcom/bytedance/android/ec/core/event/BaseEventContext;", "viewModel", "Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;", "(Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)V", "getViewModel", "()Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreEventContext extends BaseEventContext {
    private final ECStoreViewModel viewModel;

    public final ECStoreViewModel getViewModel() {
        return this.viewModel;
    }

    public StoreEventContext(ECStoreViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.viewModel = r2;
    }
}
