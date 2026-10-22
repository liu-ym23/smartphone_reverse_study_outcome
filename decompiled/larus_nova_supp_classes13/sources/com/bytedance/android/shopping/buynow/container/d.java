package com.bytedance.android.shopping.buynow.container;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements View.OnLongClickListener {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        r2.setVisibility(8);
        return true;
    }
}
