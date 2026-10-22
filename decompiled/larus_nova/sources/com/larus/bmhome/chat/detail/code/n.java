package com.larus.bmhome.chat.detail.code;

import android.view.View;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NestedScrollView f302763a;

    public /* synthetic */ n(NestedScrollView r100) {
        this.f302763a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NestedScrollView r100 = this.f302763a;
        int r101 = CodeBlockDetailFragment.f302708k0;
        View r102 = r100.getChildAt(0);
        if (r102 == null) goto L6;
        r100.smoothScrollTo(0, r102.getHeight() - r100.getHeight());
        return;
    }
}
