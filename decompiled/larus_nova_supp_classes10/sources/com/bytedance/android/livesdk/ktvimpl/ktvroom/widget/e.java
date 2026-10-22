package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ l a;

    public e(l r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        l r8 = this.a;
        boolean r0 = r8.t.isCurrentUserIsSinger();
        Context r1 = com.bytedance.android.live.core.utils.a.d();
        if (r1 != null) goto L6;
        r1 = r8.getContext();
    L6:
        com.bytedance.android.livesdk.widget.x0.b r2 = new com.bytedance.android.livesdk.widget.x0.b(r1, 0);
        r2.a.a = 7;
        r2.m(2131918451);
        r2.i(1, 2131918493, f.a);
        r2.i(0, 2131918494, new g(r8, r0));
        com.bytedance.android.livesdk.widget.x0.d r9 = r2.a;
        r9.k = false;
        r9.l = false;
        r2.n();
    }
}
