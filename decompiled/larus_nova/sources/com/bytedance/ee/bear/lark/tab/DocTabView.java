package com.bytedance.ee.bear.lark.tab;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import cc5.a;
import cc5.b;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.widget.tab.MainTabItemView;

/* JADX INFO: loaded from: classes16.dex */
public class DocTabView extends MainTabItemView {
    public int getRedDotCount() {
        return 0;
    }

    public DocTabView(Context r100) {
        this(r100, null);
    }

    public DocTabView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DocTabView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setTabTitle(UIUtils.getString(r100, R.string.Lark_Legacy_Docs));
        setId(R.id.doc_tab);
        S5(UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_tab_drive_filled, getResources().getColor(R.color.ud_N500)), new a(this));
        b r103 = new b(r100);
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(-2, -2);
        r104.rightToRight = R.id.icon;
        r104.leftToRight = R.id.icon;
        r104.topToTop = R.id.icon;
        r104.bottomToTop = R.id.icon;
        setRedDotView(r103);
    }
}
