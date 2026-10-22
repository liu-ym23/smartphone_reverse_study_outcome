package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ TopNavigationComponentV2 c;
    public final /* synthetic */ String d;

    @Override // java.lang.Runnable
    public final void run() {
        this.c.p2(this.d, false);
    }

    public h(TopNavigationComponentV2 r1, String r2) {
        this.c = r1;
        this.d = r2;
        super("select_tab");
    }
}
