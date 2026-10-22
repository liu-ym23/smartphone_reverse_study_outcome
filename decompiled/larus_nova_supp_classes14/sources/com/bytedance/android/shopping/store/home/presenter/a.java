package com.bytedance.android.shopping.store.home.presenter;

import android.view.MotionEvent;
import com.bytedance.android.ec.base.service.ECServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements com.bytedance.android.ec.store.view.r {
    public final /* synthetic */ ECShopAbilityPresenter a;

    public a(ECShopAbilityPresenter r1) {
        this.a = r1;
    }

    public final void c(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        boolean r3 = ECServiceManager.a;
        s83.c r4 = ((s83.g) ECServiceManager.c(s83.g.class)).D();
        if (r4 == null) goto L6;
        Object r0 = this.a.x;
        r4.f();
        return;
    }
}
