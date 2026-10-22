package com.bytedance.ee.bear.lark.tab;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import com.ss.android.lark.widget.tab.NavigationTabItemView;

/* JADX INFO: loaded from: classes16.dex */
public class DocNavigationTabView extends NavigationTabItemView {
    public DocNavigationTabView(Context r100) {
        this(r100, null);
    }

    public DocNavigationTabView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DocNavigationTabView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setTabIcon(l.a(getContext(), R.drawable.ud_icon_tab_drive_filled, R.color.colorful_blue));
        setTabTitle(getResources().getString(R.string.Lark_Legacy_Docs));
    }
}
