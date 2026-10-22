package com.bytedance.ee.bear.document.toolbar.media.impl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class InsertMediaV2Fragment extends InsertMediaCompatFragment {
    @Override // com.bytedance.ee.bear.document.toolbar.media.impl.InsertMediaCompatFragment, com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment
    public final View getContentView() {
        LinearLayout r0 = new LinearLayout(getActivity());
        r0.setOrientation(1);
        View r1 = new View(getActivity());
        r1.setBackgroundColor(getActivity().getResources().getColor(2131108718));
        r0.addView(r1, new FrameLayout.LayoutParams(-1, n.c(1.0f)));
        View r2 = super.getContentView();
        ViewGroup r3 = (ViewGroup) r2.getParent();
        if (r3 == null) goto L5;
        r3.removeAllViews();
    L5:
        r0.addView(r2);
        return r0;
    }

    public InsertMediaV2Fragment() {
    }
}
