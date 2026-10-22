package com.bytedance.ee.bear.document.toolbar.media.impl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class InsertMediaV2Fragment extends InsertMediaCompatFragment {
    @Override // com.bytedance.ee.bear.document.toolbar.media.impl.InsertMediaCompatFragment, com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment
    public final View getContentView() {
        LinearLayout r100 = new LinearLayout(getActivity());
        r100.setOrientation(1);
        View r101 = new View(getActivity());
        r101.setBackgroundColor(getActivity().getResources().getColor(R.color.ud_N300));
        r100.addView(r101, new FrameLayout.LayoutParams(-1, n.c(1.0f)));
        View r102 = super.getContentView();
        ViewGroup r103 = (ViewGroup) r102.getParent();
        if (r103 == null) goto L5;
        r103.removeAllViews();
    L5:
        r100.addView(r102);
        return r100;
    }

    public InsertMediaV2Fragment() {
    }
}
