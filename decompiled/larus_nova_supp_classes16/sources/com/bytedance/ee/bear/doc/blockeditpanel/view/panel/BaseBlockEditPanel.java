package com.bytedance.ee.bear.doc.blockeditpanel.view.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelViewModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.facade.common.widget.d;
import com.bytedance.ee.util.ui.n;
import dy4.c;
import ey4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseBlockEditPanel extends LinearLayout {
    public d a;
    public final FrameLayout b;
    public final View c;
    public c d;
    public BlockEditPanelViewModel e;
    public String f;
    public boolean g;
    public boolean h;
    public final int i;
    public final int j;
    public float k;
    public float l;
    public boolean m;
    public int n;

    public void a(boolean r1) {
    }

    public abstract void c(BlockEditPanelMenusModel.BlockEditPanel r1);

    public abstract View getContentView();

    public int getPanelHeight() {
        return 0;
    }

    public ViewGroup.LayoutParams b() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public String getPanelId() {
        return this.f;
    }

    public BaseBlockEditPanel(Context r2) {
        super(r2, null);
        this.g = false;
        this.h = false;
        this.j = n.d(10);
        this.m = false;
        this.n = -1;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        int r0 = r6.getAction();
        if (r0 != 2) goto L8;
        if (this.m == false) goto L8;
        return true;
    L8:
        if (r0 != 0) goto L10;
        this.n = r6.getPointerId(0);
        this.m = false;
        this.l = r6.getRawX();
        this.k = r6.getRawY();
    L27:
        return super.onInterceptTouchEvent(r6);
    L10:
        if (r0 == 1) goto L24;
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L24;
    L16:
        if (this.n == (-1)) goto L27;
        float r1 = Math.abs(this.l - r6.getRawX());
        float r2 = Math.abs(this.k - r6.getRawY());
        if (this.i >= r2) goto L27;
        if (r1 >= r2) goto L27;
        this.m = true;
        return true;
    L24:
        this.m = false;
        this.n = -1;
        goto L27
    }

    public void setNeedResetPanelLayoutParams(boolean r1) {
        this.h = r1;
    }

    public void setOnCloseListener(c r1) {
        this.d = r1;
    }

    public void setPanelId(String r1) {
        this.f = r1;
    }

    public void setViewModel(BlockEditPanelViewModel r1) {
        this.e = r1;
    }

    public BaseBlockEditPanel(Context r2, AttributeSet r3) {
        super(r2, r3, 0);
        this.g = false;
        this.h = false;
        this.j = n.d(10);
        this.m = false;
        this.n = -1;
    }

    public BaseBlockEditPanel(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.g = false;
        this.h = false;
        this.j = n.d(10);
        this.m = false;
        this.n = -1;
        LayoutInflater.from(r2).inflate(2131560064, this);
        setOrientation(1);
        setVisibility(4);
        FrameLayout r5 = (FrameLayout) findViewById(2131371428);
        this.b = r5;
        View r6 = getContentView();
        this.c = r6;
        r5.addView(r6, b());
        setClickable(true);
        setFocusable(true);
        r6.post(new a(this));
        this.i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
