package com.bytedance.ee.bear.doc.blockeditpanel.view;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnLayoutChangeListener {
    public final /* synthetic */ BlockEditPanelFragment a;

    public d(BlockEditPanelFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        int r10 = r5 - r3;
        int r11 = r4 - r2;
        if (r10 <= 0) goto L7;
        BlockEditPanelFragment r12 = this.a;
        if (r10 == r12.j) goto L7;
        r12.j = r10;
        r12.Z90().onPanelHeightChanged(r10);
    L7:
        if (r11 <= 0) goto L18;
        BlockEditPanelFragment r13 = this.a;
        if (r11 == r13.k) goto L19;
        FragmentActivity r14 = r13.getActivity();
        if (r14 == null) goto L15;
        Resources r16 = r14.getResources();
        if (r16 == null) goto L15;
        Configuration r17 = r16.getConfiguration();
    L16:
        r13.da0(r17);
        this.a.k = r11;
        return;
    L15:
        r17 = null;
        goto L16
    L19:
        return;
    }
}
