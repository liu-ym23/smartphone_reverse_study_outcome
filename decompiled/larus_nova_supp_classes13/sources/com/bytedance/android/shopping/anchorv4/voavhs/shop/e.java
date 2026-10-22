package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements Runnable {
    public final /* synthetic */ AnchorV4ShopAndStoreView a;

    public e(AnchorV4ShopAndStoreView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.findViewById(2131362875);     // Catch: Throwable -> L7
        View r1 = this.a.f;     // Catch: Throwable -> L7
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveOrDouyinViewBackground");     // Catch: Throwable -> L7
    L5:
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();     // Catch: Throwable -> L7
        r2.width = r0.getWidth();     // Catch: Throwable -> L7
        r2.height = r0.getWidth();     // Catch: Throwable -> L7
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
        r1.setLayoutParams(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
