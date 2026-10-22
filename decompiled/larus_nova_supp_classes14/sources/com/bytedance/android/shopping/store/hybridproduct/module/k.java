package com.bytedance.android.shopping.store.hybridproduct.module;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public k(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        dm.a.a("ECShopMemberCardPresenter").a("applyCoupon：" + r5);
        Function1 r0 = this.a;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(r5);
    L5:
        EnsureManager.ensureNotReachHere(r5);
    }
}
