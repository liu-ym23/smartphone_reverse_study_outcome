package com.obric.oui.titlebar;

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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public class ONormalTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f403451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f403452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f403453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f403454e;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    public void setOnTitleBarClickListener(tma.a r100) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        pla.j.b(getStartBtn(), pla.d.g(44), pla.d.g(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        pla.j.b(getEndBtn(), pla.d.g(44), pla.d.g(44), false);
        return;
    }

    public ImageView getEndBtn() {
        return this.f403452c;
    }

    public ImageView getStartBtn() {
        return this.f403451b;
    }

    public ONormalTitleBar(Context r100) {
        this(r100, null);
    }

    public void setCenterText(CharSequence r100) {
        this.f403462a.setText(r100);
    }

    public void setDividerHeight(int r100) {
        ViewGroup.LayoutParams r101 = this.f403453d.getLayoutParams();
        r101.height = r100;
        this.f403453d.setLayoutParams(r101);
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r100) {
        this.f403453d.setBackgroundColor(r100);
    }

    public void setEndBtnIcon(int r100) {
        this.f403452c.setImageResource(r100);
    }

    public void setStartBtnIcon(int r100) {
        this.f403451b.setImageResource(r100);
    }

    public void setStartText(String r100) {
        this.f403451b.setVisibility(8);
        this.f403454e.setVisibility(0);
        this.f403454e.setText(r100);
    }

    public void setStartTextSize(float r100) {
        this.f403454e.setTextSize(0, r100);
    }

    public ONormalTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ONormalTitleBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.o_view_normal_title_bar, this);
        this.f403451b = (ImageView) findViewById(R.id.back_btn);
        this.f403462a = (TextView) findViewById(R.id.title);
        this.f403452c = (ImageView) findViewById(R.id.right_btn);
        this.f403453d = findViewById(R.id.line);
        this.f403454e = (TextView) findViewById(R.id.text_left);
        this.f403451b.setOnClickListener(this);
        this.f403452c.setOnClickListener(this);
        this.f403454e.setOnClickListener(this);
        qla.a r103 = new qla.a();
        this.f403451b.setOnTouchListener(r103);
        this.f403452c.setOnTouchListener(r103);
        this.f403454e.setOnTouchListener(r103);
        if (r101 == null) goto L16;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_centerText, R.attr.oui_centerTextColor, R.attr.oui_centerTextSize, R.attr.oui_dividerColor, R.attr.oui_dividerVisible, R.attr.oui_rightDrawable, R.attr.oui_rightDrawableTint});
        int r105 = 0;
        String r106 = r104.getString(0);
        float r107 = r104.getDimension(2, pla.d.g(17));
        int r108 = r104.getColor(1, ContextCompat.getColor(r100, R.color.TextPrimary));
        this.f403462a.setText(r106);
        this.f403462a.setTextSize(0, r107);
        this.f403462a.setTextColor(r108);
        Drawable r109 = r104.getDrawable(5);
        if (r104.hasValue(6) == false) goto L8;
        if (r109 == null) goto L8;
        int r110 = r104.getColor(6, 0);
        r109 = r109.mutate();
        DrawableCompat.setTint(r109, r110);
    L8:
        if (r109 == null) goto L10;
        this.f403452c.setImageDrawable(r109);
    L10:
        boolean r111 = r104.getBoolean(4, true);
        View r112 = this.f403453d;
        if (r111 == true) goto L14;
        r105 = 8;
    L14:
        r112.setVisibility(r105);
        this.f403453d.setBackgroundColor(r104.getColor(3, ContextCompat.getColor(r100, R.color.LinePrimary)));
        r104.recycle();
        return;
    }
}
