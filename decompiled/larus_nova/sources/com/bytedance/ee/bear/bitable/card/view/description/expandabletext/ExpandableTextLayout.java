package com.bytedance.ee.bear.bitable.card.view.description.expandabletext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import fq4.a;
import fq4.b;
import fq4.c;

/* JADX INFO: loaded from: classes15.dex */
public class ExpandableTextLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f208372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f208373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f208374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f208375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f208376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f208377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f208378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f208379h;

    public final void a() {
        this.f208372a.setMaxLines(Integer.MAX_VALUE);
        this.f208375d.setText(R.string.Bitable_Common_Hide);
        this.f208374c.setRotation(180.0f);
        RelativeLayout.LayoutParams r100 = (RelativeLayout.LayoutParams) this.f208373b.getLayoutParams();
        r100.removeRule(8);
        r100.addRule(3, this.f208372a.getId());
        this.f208373b.setLayoutParams(r100);
    }

    public final void b() {
        this.f208372a.setMaxLines(this.f208378g);
        this.f208375d.setText(R.string.Bitable_Common_Expand);
        this.f208374c.setRotation(0.0f);
        RelativeLayout.LayoutParams r100 = (RelativeLayout.LayoutParams) this.f208373b.getLayoutParams();
        r100.removeRule(3);
        r100.addRule(8, this.f208372a.getId());
        this.f208373b.setLayoutParams(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        View r102 = getChildAt(r101);
        if ((r102 instanceof TextView) == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        this.f208372a = (TextView) r102;
    L8:
        TextView r103 = this.f208372a;
        if (r103 != null) goto L11;
        return;
    L11:
        if (this.f208377f == false) goto L13;
        int r104 = this.f208378g;
    L14:
        r103.setMaxLines(r104);
        if (this.f208377f == false) goto L17;
        a();
    L18:
        TextView r105 = this.f208375d;
        Context r106 = getContext();
        int r107 = (int) this.f208372a.getTextSize();
        int r108 = n.f243167a;
        r105.setTextSize((int) ((r107 / n.a(r106.getResources()).scaledDensity) + 0.5f));
        setExpandBtnMarginBottom((int) this.f208372a.getLineSpacingExtra());
        this.f208373b.bringToFront();
        return;
    L17:
        b();
        goto L18
    L13:
        r104 = Integer.MAX_VALUE;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f208372a = null;
    }

    public ExpandableTextLayout(Context r100) {
        this(r100, null);
    }

    private void setExpandBtnMarginBottom(int r100) {
        ViewGroup.LayoutParams r101 = this.f208373b.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r101).setMargins(0, 0, 0, r100);
        this.f208373b.setLayoutParams(r101);
        return;
    }

    public void setMaskStyle(boolean r100) {
        if (r100 == false) goto L4;
        this.f208376e.setBackgroundResource(R.drawable.expandable_text_mask_float);
        this.f208375d.setBackgroundResource(R.color.bg_float_base);
        this.f208374c.setBackgroundResource(R.color.bg_float_base);
        return;
    L4:
        this.f208376e.setBackgroundResource(R.drawable.expandable_text_mask);
        this.f208375d.setBackgroundResource(R.color.bg_body);
        this.f208374c.setBackgroundResource(R.color.bg_body);
    }

    public void setMaxLine(int r100) {
        this.f208378g = r100;
    }

    public ExpandableTextLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        TextView r102 = this.f208372a;
        if (r102 == null) goto L15;
        int r103 = r102.getLineCount();
        int r104 = this.f208378g;
        if (r103 > r104) goto L7;
    L9:
        if (r103 <= r104) goto L11;
    L13:
        this.f208379h = r103;
        return;
    L11:
        if (this.f208379h <= r104) goto L13;
        post(new c(this));
        goto L13
    L7:
        if (this.f208379h > r104) goto L9;
        post(new b(this));
        goto L13
    }

    public ExpandableTextLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f208378g = 3;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxLines});
        if (r103.hasValue(0) == false) goto L5;
        this.f208378g = r103.getInteger(0, this.f208378g);
    L5:
        r103.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.expandable_text, this);
        this.f208373b = (LinearLayout) findViewById(R.id.expand_btn);
        this.f208375d = (TextView) findViewById(R.id.expand_btn_text);
        this.f208374c = (ImageView) findViewById(R.id.expand_arrow_icon);
        this.f208376e = findViewById(R.id.mask_view);
        this.f208373b.setOnClickListener(new a(this));
    }
}
