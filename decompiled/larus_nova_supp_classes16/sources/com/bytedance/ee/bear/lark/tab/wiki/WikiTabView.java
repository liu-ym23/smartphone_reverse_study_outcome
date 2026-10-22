package com.bytedance.ee.bear.lark.tab.wiki;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.widget.tab.MainTabItemView;
import dc5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WikiTabView extends MainTabItemView {
    public WikiTabView(Context r2) {
        this(r2, null);
    }

    public WikiTabView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WikiTabView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setId(2131393264);
        S5(UDIconUtils.getIconDrawable(getContext(), 2131255954, getResources().getColor(2131108723)), new a(this));
        setTabTitle(getResources().getString(2131892330));
    }
}
