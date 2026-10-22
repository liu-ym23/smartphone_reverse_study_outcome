package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class WikItemHomePageView extends WikItemLeafView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f242220t = 0;

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public float getItemHeightInDp() {
        return 46.0f;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void i(int r100, boolean r101) {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void e() {
        super.e();
        this.f242223b.setVisibility(8);
        this.f242233l.setVisibility(8);
        this.f242225d.setVisibility(8);
        this.f242222a.setPadding(cu5.c.b(24), this.f242222a.getTop(), this.f242222a.getRight(), this.f242222a.getBottom());
        setFocusable(true);
        View.OnClickListener r100 = new i(this);
        setOnClickListener(r100);
        this.f242222a.setOnClickListener(r100);
    }

    public WikItemHomePageView(Context r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void setFocus(boolean r100) {
        super.setFocus(r100);
        if (r100 == false) goto L5;
        int r101 = R.drawable.wiki_item_select_bg;
    L6:
        setBackgroundResource(r101);
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public WikItemHomePageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
