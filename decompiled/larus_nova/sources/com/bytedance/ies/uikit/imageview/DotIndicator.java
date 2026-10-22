package com.bytedance.ies.uikit.imageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public class DotIndicator extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f248953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f248954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f248955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f248956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f248957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f248958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f248959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f248960h;

    public final void a() {
        int r100 = this.f248954b;
        int r101 = r100 * 2;
        this.f248956d = r101;
        this.f248955c = (r100 * 0) + (0 * this.f248953a);
        setMaxHeight(r101);
        setMinimumHeight(this.f248956d);
        setMinimumWidth(this.f248955c);
        Paint r102 = new Paint();
        this.f248957e = r102;
        r102.setAntiAlias(true);
        this.f248957e.setColor(this.f248960h);
        Paint r103 = new Paint();
        this.f248958f = r103;
        r103.setAntiAlias(true);
        this.f248958f.setColor(this.f248959g);
        invalidate();
    }

    public DotIndicator(Context r100) {
        super(r100);
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public void setCurrentPosition(int r100) {
        if (r100 < 0) goto L4;
        return;
    L4:
        invalidate();
    }

    public void setDotRadius(int r100) {
        this.f248954b = r100;
    }

    public void setSelectedColor(int r100) {
        this.f248959g = r100;
        this.f248958f.setColor(r100);
    }

    public void setSpace(int r100) {
        this.f248953a = r100;
    }

    public void setUnSelectedColor(int r100) {
        this.f248960h = r100;
        this.f248957e.setColor(r100);
    }

    public DotIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DotIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        Resources r103 = r100.getResources();
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.diameter, R.attr.dot_radius, R.attr.selected_color, R.attr.space, R.attr.unselected_color}, r102, 0);
        this.f248959g = r104.getColor(2, r103.getColor(R.color.dot_select_color));
        this.f248960h = r104.getColor(4, r103.getColor(R.color.dot_unselect_color));
        this.f248953a = r104.getDimensionPixelSize(3, (int) UIUtils.dip2Px(r100, 4.0f));
        this.f248954b = r104.getDimensionPixelSize(1, (int) UIUtils.dip2Px(r100, 4.0f));
        r104.recycle();
        a();
    }
}
