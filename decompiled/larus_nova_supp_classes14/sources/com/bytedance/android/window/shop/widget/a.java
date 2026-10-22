package com.bytedance.android.window.shop.widget;

import android.view.View;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ClickSeparatedTabSelectListener a;
    public final /* synthetic */ ECTabLayout.Tab b;

    public a(ECWindowTabLayout.c r1, ECTabLayout.Tab r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.a.put(this.b, Boolean.TRUE);
    }
}
