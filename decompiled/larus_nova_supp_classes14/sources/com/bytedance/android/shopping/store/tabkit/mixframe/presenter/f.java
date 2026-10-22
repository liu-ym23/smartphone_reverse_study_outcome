package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import com.bytedance.android.shopping.store.tabkit.mixframe.MixFrameViewModel;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements gqa.d {
    public final /* synthetic */ ECTabKitMixRefreshPresenter a;

    public f(ECTabKitMixRefreshPresenter r1) {
        this.a = r1;
    }

    public final void d2(h r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        final ECTabKitMixRefreshPresenter r6 = this.a;
        ((MixFrameViewModel) r6.f.getValue()).setRefresh(true);
        ((MixFrameViewModel) r6.f.getValue()).setCursor(0);
        ((MixFrameViewModel) r6.f.getValue()).initFetch(true, new ECTabKitMixRefreshPresenter$refresh$1(r6));
    }
}
