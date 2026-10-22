package com.bytedance.android.window.shop.widget;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ SortBarView a;

    public l(SortBarView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        int r0 = rp.a.a;
        if (rp.a.a(this.a.getId()) == false) goto L5;
        return;
    L5:
        int r1 = this.a.getChildCount();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L16;
        View r5 = this.a.getChildAt(r2);
        if (r5 == null) goto L15;
        SortBarView.b r6 = (SortBarView.b) r5;
        if ((!Intrinsics.areEqual(r6, r7)) == false) goto L13;
        int r4 = SortBarView.b.g;
        r6.a(false, true);
    L13:
        r2 = r2 + 1;
        goto L7
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.SortBarView.SortItem");
    L16:
        if (r7 == null) goto L20;
        int r3 = SortBarView.b.g;
        ((SortBarView.b) r7).a(true, true);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.SortBarView.SortItem");
    }
}
