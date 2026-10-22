package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.widget.FrameLayout;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ n c;
    public final /* synthetic */ FrameLayout d;
    public final /* synthetic */ Ref.ObjectRef e;

    @Override // java.lang.Runnable
    public final void run() {
        int r6 = this.d.indexOfChild(((m) this.e.element).e2());
        n.b(this.c, this.d, new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.m(), null, r6, 4);
    }

    public p(n r1, FrameLayout r2, Ref.ObjectRef r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        super("root_component_first_screen_delay_load");
    }
}
