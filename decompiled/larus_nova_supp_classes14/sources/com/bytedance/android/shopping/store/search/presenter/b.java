package com.bytedance.android.shopping.store.search.presenter;

import android.view.ViewTreeObserver;
import com.bytedance.android.ec.store.search.history.HistoryChip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ HistoryChip.WrapCard a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int r0 = this.a.getHeight();
        if (r0 <= 0) goto L6;
        this.a.setRadius(r0 / 2.0f);
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    }

    public b(HistoryChip.WrapCard r1) {
        this.a = r1;
    }
}
