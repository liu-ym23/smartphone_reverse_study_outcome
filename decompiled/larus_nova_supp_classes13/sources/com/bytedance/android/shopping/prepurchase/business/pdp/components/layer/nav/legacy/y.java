package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ TopRightControlsComponent c;
    public final /* synthetic */ TopRightControlsVO d;

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.d);
    }

    public y(TopRightControlsComponent r1, TopRightControlsVO r2) {
        this.c = r1;
        this.d = r2;
        super("bindIconsInnerOpt");
    }
}
