package com.bytedance.android.shopping.mall.homepage.pagecard;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements com.bytedance.android.ec.hybrid.card.event.a {
    public final /* synthetic */ PageCard a;

    public final void release() {
    }

    public b(PageCard r1) {
        this.a = r1;
    }

    public final void a(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        ECLynxCard r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.p(r2, r3);
        return;
    }
}
