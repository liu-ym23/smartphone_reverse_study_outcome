package com.bytedance.ee.bear.document.editionmanager.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceLoadingImage;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.d;
import cqa.h;
import dqa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditionListMoreFooter extends RelativeLayout implements d {
    public final b a;
    public SpaceLoadingImage b;
    public boolean c;

    public final boolean a() {
        return false;
    }

    public final void d(float r1, int r2, int r3) {
    }

    public final void e(h r1, RefreshState r2, RefreshState r3) {
    }

    public final void f(h r1, int r2, int r3) {
    }

    public View getView() {
        return this;
    }

    public final void i(h r1, int r2, int r3) {
    }

    public final int j(SmartRefreshLayout r1, boolean r2) {
        return 0;
    }

    public void setPrimaryColors(int... r1) {
    }

    public b getSpinnerStyle() {
        return this.a;
    }

    public EditionListMoreFooter(Context r2) {
        super(r2);
        this.a = b.d;
        k(r2);
    }

    public final boolean c(boolean r3) {
        if (this.c == r3) goto L7;
        this.c = r3;
        if (r3 == false) goto L7;
        this.b.stop();
        this.b.setVisibility(8);
    L7:
        return r3;
    }

    public final void k(Context r5) {
        SpaceLoadingImage r0 = new SpaceLoadingImage(r5);
        this.b = r0;
        r0.a.setColorSchemeColors(new int[]{UDColorUtils.getColor(r5, 2131105548)});
        this.b.setVisibility(0);
        RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(-1, n.f(r5, 54));
        r1.addRule(13);
        addView(this.b, r1);
    }

    public EditionListMoreFooter(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = b.d;
        k(r1);
    }

    public EditionListMoreFooter(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = b.d;
        k(r1);
    }

    public final void g(SmartRefreshLayout.j r1, int r2, int r3) {
        r1.a.K = false;
    }

    public final void b(boolean r1, float r2, int r3, int r4, int r5) {
        if (r1 == false) goto L4;
        return;
    L4:
        if (this.c == true) goto L10;
        this.b.setVisibility(0);
        UDLoadingDrawable r6 = this.b.a;
        if (r6 == null) goto L11;
        r6.start();
        return;
    L11:
        return;
    }
}
