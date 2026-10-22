package com.bytedance.ee.bear.lark.tab;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.util.ui.l;
import com.ss.android.lark.widget.tab.NavigationTabItemView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocNavigationTabView extends NavigationTabItemView {
    public DocNavigationTabView(Context r2) {
        this(r2, null);
    }

    public DocNavigationTabView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DocNavigationTabView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setTabIcon(l.a(getContext(), 2131255928, 2131101111));
        setTabTitle(getResources().getString(2131891687));
    }
}
