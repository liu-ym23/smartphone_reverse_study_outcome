package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import com.bytedance.android.ec.core.utils.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ WindowAnchorCardPresenter a;
    public final /* synthetic */ sq3.c b;

    public c(WindowAnchorCardPresenter r1, sq3.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        String r0 = this.a.d0().getShopParam().getSecAuthorId();
        sq3.c r1 = this.b;
        s0.a(new com.bytedance.android.window.shop.home.tab.tabplugin.a(r0, r1.j, r1.k, r1.l));
        this.a.i0("window_end_button_click");
    }
}
