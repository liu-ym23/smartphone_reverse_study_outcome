package com.bytedance.android.window.shop.widget;

import android.view.KeyEvent;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements ECTabLayout.OnTabSelectedListener {
    public d() {
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final /* synthetic */ void onTabSelected(ECTabLayout.Tab r1, boolean r2) {
        ECTabLayout.BaseOnTabSelectedListener.CC.$default$onTabSelected(this, r1, r2);
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(ECTabLayout.Tab r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        KeyEvent.Callback r3 = r2.getCustomView();
        if ((r3 instanceof com.bytedance.android.window.shop.widget.category.a) == true) goto L7;
        r3 = null;
    L7:
        com.bytedance.android.window.shop.widget.category.a r4 = (com.bytedance.android.window.shop.widget.category.a) r3;
        if (r4 == null) goto L11;
        r4.u();
        return;
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(ECTabLayout.Tab r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        KeyEvent.Callback r3 = r2.getCustomView();
        if ((r3 instanceof com.bytedance.android.window.shop.widget.category.a) == true) goto L7;
        r3 = null;
    L7:
        com.bytedance.android.window.shop.widget.category.a r4 = (com.bytedance.android.window.shop.widget.category.a) r3;
        if (r4 == null) goto L11;
        r4.u();
        return;
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(ECTabLayout.Tab r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        KeyEvent.Callback r3 = r2.getCustomView();
        if ((r3 instanceof com.bytedance.android.window.shop.widget.category.a) == true) goto L7;
        r3 = null;
    L7:
        com.bytedance.android.window.shop.widget.category.a r4 = (com.bytedance.android.window.shop.widget.category.a) r3;
        if (r4 == null) goto L11;
        r4.w();
        return;
    }
}
