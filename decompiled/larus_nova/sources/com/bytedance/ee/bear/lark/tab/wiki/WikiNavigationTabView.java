package com.bytedance.ee.bear.lark.tab.wiki;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import com.ss.android.lark.widget.tab.NavigationTabItemView;

/* JADX INFO: loaded from: classes16.dex */
public class WikiNavigationTabView extends NavigationTabItemView {
    public final void initView() {
        setTabIcon(l.a(getContext(), R.drawable.ud_icon_tab_wiki_filled, R.color.colorful_blue));
        setTabTitle(getResources().getString(R.string.Lark_Legacy_WikiTab));
    }

    public WikiNavigationTabView(Context r100) {
        super(r100);
        initView();
    }

    public WikiNavigationTabView(Context r100, AttributeSet r101) {
        super(r100, r101);
        initView();
    }

    public WikiNavigationTabView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        initView();
    }
}
