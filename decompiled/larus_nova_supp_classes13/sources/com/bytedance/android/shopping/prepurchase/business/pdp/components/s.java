package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv4.ai.PdpAIComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live.LivePreviewComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ n c;
    public final /* synthetic */ FrameLayout d;

    @Override // java.lang.Runnable
    public final void run() {
        n r0 = this.c;
        FrameLayout r1 = this.d;
        com.bytedance.android.shopping.prepurchase.business.pdp.e r2 = (com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r0.g);
        Intrinsics.checkNotNullParameter(r2, "$this$nativeParams");
        if (r2.a.getNativeParams().getFullMode() == true) goto L5;
        r0.i.c(new LivePreviewComponent(), r1);
    L6:
        n r3 = this.c;
        FrameLayout r4 = this.d;
        PdpAIComponent r5 = r3.e;
        if (r5 == null) goto L12;
        View r6 = r5.e2();
        if (r6 == null) goto L13;
        r4.bringChildToFront(r6);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0.i.d(new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live.a());
        goto L6
    }

    public s(n r1, FrameLayout r2) {
        this.c = r1;
        this.d = r2;
        super("loadLivePreviewComponent");
    }
}
