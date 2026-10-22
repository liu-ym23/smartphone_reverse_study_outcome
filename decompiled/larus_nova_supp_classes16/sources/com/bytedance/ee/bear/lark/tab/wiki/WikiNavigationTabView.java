package com.bytedance.ee.bear.lark.tab.wiki;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.util.ui.l;
import com.ss.android.lark.widget.tab.NavigationTabItemView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WikiNavigationTabView extends NavigationTabItemView {
    /* JADX WARN: Multi-variable type inference failed */
    public final void initView() {
        setTabIcon(l.a(getContext(), 2131255954, 2131101111));
        setTabTitle(getResources().getString(2131892330));
    }

    public WikiNavigationTabView(Context r1) {
        super(r1);
        initView();
    }

    public WikiNavigationTabView(Context r1, AttributeSet r2) {
        super(r1, r2);
        initView();
    }

    public WikiNavigationTabView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        initView();
    }
}
