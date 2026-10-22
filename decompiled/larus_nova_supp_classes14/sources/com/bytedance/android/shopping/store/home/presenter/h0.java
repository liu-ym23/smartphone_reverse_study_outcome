package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h0<T> implements Observer {
    public final /* synthetic */ ECShopFloatLynxPresenter a;

    public h0(ECShopFloatLynxPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        final com.bytedance.android.shopping.store.home.entity.l r8 = (com.bytedance.android.shopping.store.home.entity.l) r7;
        final ECShopFloatLynxPresenter r0 = this.a;
        int r1 = ECShopFloatLynxPresenter.K;
        r0.getClass();
        Lazy r2 = ECTaskManager.b;
        ECTaskManager.a.a().a(r0.T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopFloatLynxPresenter$handleActivityFloatData$1(r0, r8));
    }
}
