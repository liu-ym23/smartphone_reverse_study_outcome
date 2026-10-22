package com.bytedance.android.shopping.store.tabkit.anniex.component;

import com.bytedance.android.shopping.store.tabkit.brandmall.NaPrefetchSyncCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TabHybridComponent$prefetchCallbackV2$1 extends NaPrefetchSyncCallback {
    public final /* synthetic */ TabHybridComponent a;

    public TabHybridComponent$prefetchCallbackV2$1(TabHybridComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.brandmall.NaPrefetchSyncCallback
    public final void onFail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        this.a.k();
    }

    @Override // com.bytedance.android.shopping.store.tabkit.brandmall.NaPrefetchSyncCallback
    public final void onSuccess(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "result");
        this.a.b();
    }
}
