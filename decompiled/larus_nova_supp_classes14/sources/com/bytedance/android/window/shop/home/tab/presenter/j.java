package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends WindowBstReport.a {
    public final /* synthetic */ ECWindowProductSharePresenter b;
    public final /* synthetic */ Map c;

    @Override // com.bytedance.android.window.shop.product.utils.WindowBstReport.a
    public final void b(String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.b.d0().doAnyEventAction("click_product", r4, new Pair[0]);
    }

    public j(ECWindowProductSharePresenter r1, Map r2, Map r3) {
        this.b = r1;
        this.c = r2;
        super(r3);
    }
}
