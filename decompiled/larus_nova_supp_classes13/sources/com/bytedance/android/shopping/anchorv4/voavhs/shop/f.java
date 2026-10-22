package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements Runnable {
    public final /* synthetic */ AnchorV4ShopAndStoreView a;
    public final /* synthetic */ Background b;

    public f(AnchorV4ShopAndStoreView r1, Background r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinearLayout r0 = this.a.a;     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("llShopInfo");     // Catch: Throwable -> L7
    L5:
        ExtensionsKt.j(r0, this.b);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
