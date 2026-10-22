package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.bottom.d0;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements com.bytedance.android.shopping.utils.e {
    public final d0 a;

    public final boolean e() {
        return this.a.e();
    }

    public m(d0 r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.a = r2;
    }

    public final void g(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.a.g(r2);
    }

    public final void f(Map r8, boolean r9, boolean r10, String r11, PageFinder r12) {
        Intrinsics.checkNotNullParameter("add_cart_toast_show", "eventName");
        this.a.n("add_cart_toast_show", r8, r9, r10, r11, r12);
    }
}
