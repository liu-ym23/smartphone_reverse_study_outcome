package com.bytedance.android.shopping.store.hybridproduct;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopProductListBffResponseDTO;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public g(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        ECShopProductListBffResponseDTO r5 = (ECShopProductListBffResponseDTO) r4;
        if (((QFragmentPresenter) this.a).e.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L15;
        ECShopHybridProductListPresenter r0 = this.a;
        int r1 = ECShopHybridProductListPresenter.O;
        monitor-enter(r0);
    L17:
    L12:
        th = move-exception;
        throw th;
    L7:
        if ((!((ArrayList) r0.w).isEmpty()) == false) goto L10;
        ((Runnable) ListProtector.remove(r0.w, 0)).run();     // Catch: Throwable -> L12
        goto L17
    L10:
        monitor-exit(r0);
        ECShopHybridProductListPresenter.d0(this.a, r5);
        return;
    L15:
        ((ArrayList) this.a.w).add(new f(this, r5));
    }
}
