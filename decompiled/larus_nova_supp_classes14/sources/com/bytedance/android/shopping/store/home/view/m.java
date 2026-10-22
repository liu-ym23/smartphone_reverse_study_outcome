package com.bytedance.android.shopping.store.home.view;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ n a;

    public m(n r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        n r3 = this.a;
        ViewGroup r0 = r3.g;
        if (r0 == null) goto L5;
        r0.removeView(r3);
    L5:
        ECBubbleControllerManager r1 = ECBubbleControllerManager.b;
        com.bytedance.android.ec.store.common.bubble.c r4 = r1.a(r3.e);
        r4.d();
        com.bytedance.android.ec.store.common.bubble.c.e(r4);
        com.bytedance.android.ec.store.common.bubble.c.e(r1.a(this.a.getLifecycleOwner()));
    }
}
