package com.bytedance.locallife.pdp.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.dux.text.DuxTextView;

/* JADX INFO: loaded from: classes21.dex */
public class SearchTabTextView extends DuxTextView {
    public SearchTabTextView(Context r100) {
        super(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        if (r100 == false) goto L5;
        getPaint().setFakeBoldText(true);
        return;
    L5:
        getPaint().setFakeBoldText(false);
    }

    public SearchTabTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
