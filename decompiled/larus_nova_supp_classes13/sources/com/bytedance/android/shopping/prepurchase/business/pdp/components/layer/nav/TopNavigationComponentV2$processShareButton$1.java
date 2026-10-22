package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TopNavigationComponentV2$processShareButton$1 extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ TopNavigationComponentV2 c;
    public final /* synthetic */ TopNavVO d;

    @Override // java.lang.Runnable
    public final void run() {
        BuildersKt.launch$default(this.c.Q1(), Dispatchers.getIO(), null, new TopNavigationComponentV2$processShareButton$1$run$1(this, null), 2, null);
    }

    public TopNavigationComponentV2$processShareButton$1(TopNavigationComponentV2 r1, TopNavVO r2) {
        this.c = r1;
        this.d = r2;
        super("processShareButton");
    }
}
