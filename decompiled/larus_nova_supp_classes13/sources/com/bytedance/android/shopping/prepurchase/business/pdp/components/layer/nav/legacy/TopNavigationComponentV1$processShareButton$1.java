package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TopNavigationComponentV1$processShareButton$1 extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ TopNavigationComponentV1 c;
    public final /* synthetic */ ShareMeta d;

    @Override // java.lang.Runnable
    public final void run() {
        BuildersKt.launch$default(this.c.Q1(), Dispatchers.getIO(), null, new TopNavigationComponentV1$processShareButton$1$run$1(this, null), 2, null);
    }

    public TopNavigationComponentV1$processShareButton$1(TopNavigationComponentV1 r1, ShareMeta r2) {
        this.c = r1;
        this.d = r2;
        super("processShareButton");
    }
}
