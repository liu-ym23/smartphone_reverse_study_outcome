package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements com.bytedance.android.ecom.arch.slice.action.o {
    public final /* synthetic */ o a;

    public n(o r1) {
        this.a = r1;
    }

    public final void a(IAction r10, com.bytedance.android.ecom.arch.slice.action.c r11, Map r12) {
        Intrinsics.checkNotNullParameter(r10, "action");
        int r0 = com.bytedance.android.shopping.anchorv4.event_chain.c.a;
        com.bytedance.android.shopping.anchorv4.event_chain.c.a(null, null, this.a.a, r10, null, null, r12, r11);
    }
}
