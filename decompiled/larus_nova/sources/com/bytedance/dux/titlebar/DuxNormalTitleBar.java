package com.bytedance.dux.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import cm4.a;
import com.larus.nova.R;
import em4.g;
import em4.n;

/* JADX INFO: loaded from: classes15.dex */
public class DuxNormalTitleBar extends DuxTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f205799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f205800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f205801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f205802h;

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

    public ImageView getEndBtn() {
        return this.f205800f;
    }

    public ImageView getStartBtn() {
        return this.f205799e;
    }

    public TextView getStartText() {
        return this.f205802h;
    }

    public DuxNormalTitleBar(Context r100) {
        this(r100, null);
    }

    public void setCenterText(CharSequence r100) {
        this.f205811a.setText(r100);
    }

    public void setDividerHeight(int r100) {
        ViewGroup.LayoutParams r101 = this.f205801g.getLayoutParams();
        r101.height = r100;
        this.f205801g.setLayoutParams(r101);
    }

    @Override // com.bytedance.dux.titlebar.DuxTitleBar
    public void setDividerLineBackground(int r100) {
        this.f205801g.setBackgroundColor(r100);
    }

    public void setEndBtnIcon(int r100) {
        this.f205800f.setImageResource(r100);
    }

    public void setStartBtnIcon(int r100) {
        this.f205799e.setImageResource(r100);
    }

    public void setStartText(String r100) {
        this.f205799e.setVisibility(8);
        this.f205802h.setVisibility(0);
        this.f205802h.setText(r100);
    }

    public void setStartTextSize(float r100) {
        this.f205802h.setTextSize(0, r100);
    }

    public DuxNormalTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DuxNormalTitleBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102, null);
        if (this.f205812b == false) goto L5;
        int r103 = R.layout.dux_view_normal_title_bar_new;
    L6:
        FrameLayout.inflate(r100, r103, this);
        this.f205799e = (ImageView) findViewById(R.id.back_btn);
        this.f205811a = (TextView) findViewById(R.id.title);
        this.f205800f = (ImageView) findViewById(R.id.right_btn);
        this.f205801g = findViewById(R.id.line);
        this.f205802h = (TextView) findViewById(R.id.text_left);
        this.f205799e.setOnClickListener(this);
        this.f205800f.setOnClickListener(this);
        this.f205802h.setOnClickListener(this);
        fm4.a r104 = new fm4.a(0.5f);
        this.f205799e.setOnTouchListener(r104);
        this.f205800f.setOnTouchListener(r104);
        this.f205802h.setOnTouchListener(r104);
        int r105 = 0;
        b(new View[]{this.f205799e, this.f205800f});
        c(new TextView[]{this.f205802h, this.f205811a});
        if (r101 == null) goto L20;
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.adaptLargeFontMode, R.attr.centerText, R.attr.centerTextColor, R.attr.centerTextSize, R.attr.dividerColor, R.attr.dividerVisible, R.attr.rightDrawable, R.attr.rightDrawableTint});
        String r107 = r106.getString(1);
        float r108 = r106.getDimension(3, a(17));
        int r109 = r106.getColor(2, ContextCompat.getColor(r100, R.color.TextPrimary));
        this.f205811a.setText(r107);
        this.f205811a.setTextSize(0, r108);
        this.f205811a.setTextColor(r109);
        Drawable r110 = r106.getDrawable(6);
        if (r106.hasValue(7) == false) goto L12;
        if (r110 == null) goto L12;
        int r111 = r106.getColor(7, 0);
        r110 = r110.mutate();
        DrawableCompat.setTint(r110, r111);
    L12:
        if (r110 == null) goto L14;
        this.f205800f.setImageDrawable(r110);
    L14:
        boolean r112 = r106.getBoolean(5, true);
        View r113 = this.f205801g;
        if (r112 == true) goto L18;
        r105 = 8;
    L18:
        r113.setVisibility(r105);
        this.f205801g.setBackgroundColor(r106.getColor(4, ContextCompat.getColor(r100, R.color.LinePrimary)));
        r106.recycle();
        return;
    L20:
        return;
    L5:
        r103 = R.layout.dux_view_normal_title_bar;
        goto L6
    }
}
