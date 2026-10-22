package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.view.View;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements View.OnLayoutChangeListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ DragRelativeLayout b;

    public f(a r1, DragRelativeLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        r1.setVisibility(0);
        if (this.a.j.d.b == false) goto L5;
        r1.setTranslationX(this.b.getWidth() - r1.getLeft());
    L6:
        r1.animate().translationX(0.0f).setDuration(300).start();
        return;
    L5:
        r1.setTranslationX(-r1.getRight());
        goto L6
    }
}
