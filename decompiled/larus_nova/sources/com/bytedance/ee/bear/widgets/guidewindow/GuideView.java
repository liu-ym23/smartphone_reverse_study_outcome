package com.bytedance.ee.bear.widgets.guidewindow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class GuideView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f240215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f240216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f240217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f240218d;

    public GuideView(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.widget_guide_view, this, true);
        this.f240215a = (ImageView) findViewById(R.id.indicator);
        this.f240216b = (TextView) findViewById(R.id.guide_text);
        this.f240217c = (ImageView) findViewById(R.id.shadow);
    }

    public void setIndicatorOffsetX(int r100) {
        this.f240218d = r100;
        requestLayout();
    }

    public void setText(String r100) {
        this.f240216b.setText(r100);
    }

    public GuideView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public GuideView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = this.f240215a.getMeasuredWidth();
        int r106 = this.f240218d;
        int r107 = r105 / 2;
        int r108 = r106 - r107;
        int r109 = r107 + r106;
        if (r108 < r101) goto L6;
        r101 = r108;
    L6:
        if (r109 > r103) goto L9;
        r103 = r109;
    L9:
        if (r106 == 0) goto L11;
        ImageView r110 = this.f240215a;
        r110.layout(r101, r110.getTop(), r103, this.f240215a.getBottom());
    L11:
        int r111 = n.f(getContext(), 12);
        TextView r112 = this.f240216b;
        r112.layout(r112.getLeft(), this.f240215a.getBottom(), this.f240216b.getRight(), this.f240215a.getBottom() + this.f240216b.getHeight());
        this.f240217c.layout(this.f240216b.getLeft(), this.f240216b.getTop() - r111, this.f240216b.getRight(), r111);
    }
}
