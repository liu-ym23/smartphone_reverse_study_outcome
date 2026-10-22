package com.bytedance.android.shopping.store.router.hybridpage.view;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.hybrid.list.ability.k0;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends k0 {
    public final /* synthetic */ b a;
    public final /* synthetic */ LifecycleOwner b;

    public final void a() {
        HybridPageViewModel r0 = this.a.R3;
        if (r0 == null) goto L7;
        QLiveData<LoadStatus> r1 = r0.getLoadStatus();
        if (r1 == null) goto L7;
        r1.g(LoadStatus.LoadMoreIn);
    L7:
        wj3.a r2 = this.a.P3;
        if (r2 == null) goto L11;
        r2.a();
        return;
    }

    public e(b r1, LifecycleOwner r2) {
        this.a = r1;
        this.b = r2;
    }
}
