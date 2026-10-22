package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv4.widgets.TopRoundFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z {
    public final /* synthetic */ PdpRootComponent a;
    public final /* synthetic */ FrameLayout b;
    public final /* synthetic */ FrameLayout c;

    public final TopRoundFrameLayout a() {
        TopRoundFrameLayout r0 = this.a.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("draggableView");
    L5:
        return r0;
    }

    public z(PdpRootComponent r1, FrameLayout r2, FrameLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
