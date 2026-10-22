package com.bytedance.android.shopping.store.home.frame.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.home.presenter.preview.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements e {
    public b() {
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.e
    public final void a(ShopContainerType r2, vi3.c r3) {
        Intrinsics.checkNotNullParameter(r2, "containerType");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.e
    public final void b(ShopContainerType r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "listener");
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.e
    public final View c(ShopContainerType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return null;
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.e
    public final vi3.c d(ShopContainerType r2) {
        Intrinsics.checkNotNullParameter(r2, "containerType");
        return null;
    }
}
