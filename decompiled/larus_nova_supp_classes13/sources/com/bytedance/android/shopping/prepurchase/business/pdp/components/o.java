package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import com.bytedance.android.shopping.prepurchase.business.pdp.services.ScreenCaptureComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ n c;

    @Override // java.lang.Runnable
    public final void run() {
        this.c.i.d(new ScreenCaptureComponent());
    }

    public o(n r1) {
        this.c = r1;
        super("loadScreenCaptureComponent");
    }
}
