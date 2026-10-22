package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.widget.FrameLayout;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.LynxPendentComponent;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ n c;
    public final /* synthetic */ FrameLayout d;

    @Override // java.lang.Runnable
    public final void run() {
        n r0 = this.c;
        if (r0.b != null) goto L10;
        LynxPendentComponent r1 = new LynxPendentComponent();
        m r2 = this.c.d;
        if (r2 == null) goto L7;
        int r6 = this.d.indexOfChild(r2.e2()) + 1;
    L8:
        n.b(this.c, this.d, r1, null, r6, 4);
        Unit r3 = Unit.INSTANCE;
        r0.b = r1;
        return;
    L7:
        r6 = 0;
        goto L8
    }

    public r(n r1, FrameLayout r2) {
        this.c = r1;
        this.d = r2;
        super("load_lynx_pendent_component");
    }
}
