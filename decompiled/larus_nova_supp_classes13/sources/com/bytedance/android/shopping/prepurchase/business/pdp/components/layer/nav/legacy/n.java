package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements com.bytedance.android.shopping.anchorv4.nav.f {
    public final a0 a;

    public final Boolean d() {
        return null;
    }

    public final CommonMeta a() {
        return this.a.a();
    }

    public final LinkedTreeMap<String, Object> b() {
        return this.a.b();
    }

    public n(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.a = r2;
    }

    public final void f(final Map r10, final boolean r11, final boolean r12, final String r13, final PageFinder r14) {
        final String r5 = "share_product";
        Intrinsics.checkNotNullParameter("share_product", "eventName");
        Function1<vg3.z, Unit> r8 = new ShareDependImpl$track$1(this, r10, r13, r14, r5, r12, r11);
        this.a.d(r8);
    }
}
