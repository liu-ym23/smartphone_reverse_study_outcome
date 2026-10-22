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
import com.larus.nova.R;
import dy4.c;
import ey4.a;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseBlockEditPanel extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f217670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f217671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f217672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f217673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BlockEditPanelViewModel f217674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f217675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f217676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f217677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f217678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f217679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f217680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f217681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f217682m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f217683n;

    public void a(boolean r100) {
    }

    public abstract void c(BlockEditPanelMenusModel.BlockEditPanel r100);

    public abstract View getContentView();

    public int getPanelHeight() {
        return 0;
    }

    public ViewGroup.LayoutParams b() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public String getPanelId() {
        return this.f217675f;
    }

    public BaseBlockEditPanel(Context r100) {
        super(r100, null);
        this.f217676g = false;
        this.f217677h = false;
        this.f217679j = n.d(10);
        this.f217682m = false;
        this.f217683n = -1;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 != 2) goto L8;
        if (this.f217682m == false) goto L8;
        return true;
    L8:
        if (r101 != 0) goto L10;
        this.f217683n = r100.getPointerId(0);
        this.f217682m = false;
        this.f217681l = r100.getRawX();
        this.f217680k = r100.getRawY();
    L27:
        return super.onInterceptTouchEvent(r100);
    L10:
        if (r101 == 1) goto L24;
        if (r101 == 2) goto L16;
        if (r101 == 3) goto L24;
    L16:
        if (this.f217683n == (-1)) goto L27;
        float r102 = Math.abs(this.f217681l - r100.getRawX());
        float r103 = Math.abs(this.f217680k - r100.getRawY());
        if (this.f217678i >= r103) goto L27;
        if (r102 >= r103) goto L27;
        this.f217682m = true;
        return true;
    L24:
        this.f217682m = false;
        this.f217683n = -1;
        goto L27
    }

    public void setNeedResetPanelLayoutParams(boolean r100) {
        this.f217677h = r100;
    }

    public void setOnCloseListener(c r100) {
        this.f217673d = r100;
    }

    public void setPanelId(String r100) {
        this.f217675f = r100;
    }

    public void setViewModel(BlockEditPanelViewModel r100) {
        this.f217674e = r100;
    }

    public BaseBlockEditPanel(Context r100, AttributeSet r101) {
        super(r100, r101, 0);
        this.f217676g = false;
        this.f217677h = false;
        this.f217679j = n.d(10);
        this.f217682m = false;
        this.f217683n = -1;
    }

    public BaseBlockEditPanel(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f217676g = false;
        this.f217677h = false;
        this.f217679j = n.d(10);
        this.f217682m = false;
        this.f217683n = -1;
        LayoutInflater.from(r100).inflate(R.layout.doc_block_edit_panel_container, this);
        setOrientation(1);
        setVisibility(4);
        FrameLayout r103 = (FrameLayout) findViewById(R.id.edit_panel_container);
        this.f217671b = r103;
        View r104 = getContentView();
        this.f217672c = r104;
        r103.addView(r104, b());
        setClickable(true);
        setFocusable(true);
        r104.post(new a(this));
        this.f217678i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
