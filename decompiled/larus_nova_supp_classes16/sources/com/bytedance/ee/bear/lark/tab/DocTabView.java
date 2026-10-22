package com.bytedance.ee.bear.lark.tab;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import cc5.a;
import cc5.b;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.widget.tab.MainTabItemView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocTabView extends MainTabItemView {
    public int getRedDotCount() {
        return 0;
    }

    public DocTabView(Context r2) {
        this(r2, null);
    }

    public DocTabView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DocTabView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        setTabTitle(UIUtils.getString(r2, 2131891687));
        setId(2131369359);
        S5(UDIconUtils.getIconDrawable(getContext(), 2131255928, getResources().getColor(2131108723)), new a(this));
        b r5 = new b(r2);
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams(-2, -2);
        r6.rightToRight = 2131374718;
        r6.leftToRight = 2131374718;
        r6.topToTop = 2131374718;
        r6.bottomToTop = 2131374718;
        setRedDotView(r5);
    }
}
