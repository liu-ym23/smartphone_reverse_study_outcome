package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.btm.api.model.PageFinder;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements com.bytedance.android.shopping.utils.e {
    public final d a;

    public final boolean e() {
        return this.a.e();
    }

    public i(d r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.a = r2;
    }

    public final void g(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.a.g(r2);
    }

    public final void f(final Map r11, final boolean r12, final boolean r13, final String r14, final PageFinder r15) {
        final String r5 = "add_cart_toast_show";
        Intrinsics.checkNotNullParameter("add_cart_toast_show", "eventName");
        this.a.d(new CartDependencyAdapter$track$1(this, r11, r14, r15, r5, r13, r12));
    }
}
