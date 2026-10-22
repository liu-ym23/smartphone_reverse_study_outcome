package com.bytedance.dux.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cm4.a;
import com.larus.nova.R;
import em4.g;
import em4.n;

/* JADX INFO: loaded from: classes15.dex */
public class DuxButtonTitleBar extends DuxTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f205775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f205776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f205777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f205778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f205779i;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    public void setOnTitleBarClickListener(a r100) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        n.b(getStartBtn(), g.c(44), g.c(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        n.b(getEndBtn(), g.c(44), g.c(44), false);
        return;
    }

    public TextView getEndBtn() {
        return this.f205776f;
    }

    public int getEndButtonType() {
        return this.f205779i;
    }

    public ImageView getStartBtn() {
        return this.f205775e;
    }

    public DuxButtonTitleBar(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.dux.titlebar.DuxTitleBar
    public void setDividerLineBackground(int r100) {
        this.f205778h.setBackgroundColor(r100);
    }

    public DuxButtonTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DuxButtonTitleBar(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111, null);
        int r112 = 0;
        this.f205779i = 0;
        if (this.f205812b == false) goto L5;
        int r101 = R.layout.dux_view_button_title_bar_new;
    L6:
        FrameLayout.inflate(r100, r101, this);
        this.f205775e = (ImageView) findViewById(R.id.back_btn);
        this.f205811a = (TextView) findViewById(R.id.title);
        this.f205776f = (TextView) findViewById(R.id.right_btn);
        this.f205778h = findViewById(R.id.line);
        this.f205775e.setOnClickListener(this);
        this.f205776f.setOnClickListener(this);
        fm4.a r102 = new fm4.a(0.5f);
        this.f205775e.setOnTouchListener(r102);
        this.f205776f.setOnTouchListener(r102);
        b(new View[]{this.f205775e});
        c(new TextView[]{this.f205776f, this.f205811a});
        if (r110 == null) goto L24;
        TypedArray r113 = r100.obtainStyledAttributes(r110, new int[]{R.attr.adaptLargeFontMode, R.attr.centerText, R.attr.centerTextColor, R.attr.centerTextSize, R.attr.dividerColor, R.attr.dividerVisible, R.attr.rightButtonText, R.attr.rightButtonTextBackground, R.attr.rightButtonTextColor, R.attr.rightButtonTextSize, R.attr.rightButtonType, R.attr.rightButtonVisible});
        String r103 = r113.getString(1);
        float r104 = r113.getDimension(3, a(17));
        int r105 = r113.getColor(2, ContextCompat.getColor(r100, R.color.TextPrimary));
        this.f205811a.setText(r103);
        this.f205811a.setTextSize(0, r104);
        this.f205811a.setTextColor(r105);
        String r106 = r113.getString(6);
        int r107 = r113.getInt(10, 1);
        float r108 = r113.getDimension(9, a(15));
        int r109 = r113.getColor(8, 0);
        this.f205777g = r113.getDrawable(7);
        int r114 = r113.getInt(11, 0);
        this.f205776f.setText(r106);
        this.f205779i = r107;
        if (r107 != 1) goto L11;
        this.f205776f.setTypeface(Typeface.defaultFromStyle(1));
        this.f205776f.setTextColor(ContextCompat.getColor(r100, R.color.Primary));
    L12:
        this.f205776f.setTextSize(0, r108);
        if (r109 == 0) goto L15;
        this.f205776f.setTextColor(r109);
    L15:
        Drawable r115 = this.f205777g;
        if (r115 == null) goto L18;
        this.f205776f.setBackground(r115);
    L18:
        this.f205776f.setVisibility(r114);
        boolean r116 = r113.getBoolean(5, false);
        View r117 = this.f205778h;
        if (r116 == true) goto L22;
        r112 = 4;
    L22:
        r117.setVisibility(r112);
        this.f205778h.setBackgroundColor(r113.getColor(4, ContextCompat.getColor(r100, R.color.LinePrimary)));
        r113.recycle();
        return;
    L11:
        this.f205776f.setTypeface(Typeface.defaultFromStyle(0));
        this.f205776f.setTextColor(ContextCompat.getColor(r100, R.color.TextPrimary));
        goto L12
    L24:
        return;
    L5:
        r101 = R.layout.dux_view_button_title_bar;
        goto L6
    }
}
