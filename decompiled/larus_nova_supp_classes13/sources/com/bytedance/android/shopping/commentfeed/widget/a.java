package com.bytedance.android.shopping.commentfeed.widget;

import bc3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements d {
    public final /* synthetic */ CommentImageIndicatorNumView a;

    public a(CommentImageIndicatorNumView r1) {
        this.a = r1;
    }

    @Override // bc3.d
    public final void onItemSelected(int r7) {
        CommentImageIndicatorNumView r0 = this.a;
        int r8 = r7 + 1;
        if (r8 >= 0) goto L5;
    L8:
        r0.setVisibility(8);
        return;
    L5:
        if (r8 > r0.b) goto L8;
        r0.setVisibility(0);
        r0.a.setText(th.a.f(r0.getContext()).getString(2131914059, new Object[]{String.valueOf(r8), String.valueOf(r0.b)}));
    }
}
