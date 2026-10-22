package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.tabkit.mixframe.MixFrameViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ ECTabKitMixFrameStatusPresenter a;

    public e(ECTabKitMixFrameStatusPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        MixFrameViewModel.initFetch$default((MixFrameViewModel) this.a.f.getValue(), false, ECTabKitMixFrameStatusPresenter$initStatusView$1$2$1.INSTANCE, 1, null);
    }
}
