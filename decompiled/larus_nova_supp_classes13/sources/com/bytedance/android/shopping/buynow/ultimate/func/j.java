package com.bytedance.android.shopping.buynow.ultimate.func;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends com.bytedance.kmp.ec.yata.event.common.a {
    public final BuyNowFragment a;
    public final AndroidYaTaInstance b;

    public static final class a {
    }

    static {
    }

    public j(BuyNowFragment r2, AndroidYaTaInstance r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = r3;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r9, "input");
        Intrinsics.checkNotNullParameter(r10, "chainNextCallback");
        if (this.b != null) goto L6;
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "yataInstance is null", null, null, 57));
        return;
    L6:
        com.bytedance.android.shopping.sku.common.ability.b r1 = this.a.W90().getSkuService();
        FragmentActivity r2 = this.a.requireActivity();
        BuyNowFragment r4 = this.a;
        com.bytedance.kmp.ec.yata.common.platform.o r0 = r9.d.b;
        if (r0 == null) goto L10;
        View r3 = r0.a;
        if (r3 == null) goto L10;
    L11:
        r1.t(r2, r4, r4, r9, r3, new SelfPreviewImageFunction$onExecuteAsync$1(this));
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L10:
        r3 = r4.getView();
        Intrinsics.checkNotNull(r3);
        goto L11
    }
}
