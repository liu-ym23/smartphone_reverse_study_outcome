package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u0 implements com.bytedance.android.ecom.arch.slice.action.o {
    public final /* synthetic */ v0 a;

    public u0(v0 r1) {
        this.a = r1;
    }

    public final void a(IAction r11, com.bytedance.android.ecom.arch.slice.action.c r12, Map r13) {
        Intrinsics.checkNotNullParameter(r11, "action");
        int r0 = com.bytedance.android.shopping.anchorv4.event_chain.c.a;
        v0 r1 = this.a;
        l r2 = r1.i;
        if (r2 == null) goto L5;
        EventChain r3 = r2.l;
    L6:
        com.bytedance.android.shopping.anchorv4.event_chain.c.a(r3, null, r1.a, r11, null, null, r13, r12);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
