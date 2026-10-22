package com.bytedance.ee.bear.lark.tab.wiki;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.widget.tab.MainTabItemView;
import dc5.a;

/* JADX INFO: loaded from: classes16.dex */
public class WikiTabView extends MainTabItemView {
    public WikiTabView(Context r100) {
        this(r100, null);
    }

    public WikiTabView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public WikiTabView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setId(R.id.wiki_tab);
        S5(UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_tab_wiki_filled, getResources().getColor(R.color.ud_N500)), new a(this));
        setTabTitle(getResources().getString(R.string.Lark_Legacy_WikiTab));
    }
}
