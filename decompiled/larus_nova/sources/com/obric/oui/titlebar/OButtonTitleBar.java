package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public class OButtonTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f403356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f403357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f403358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f403359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f403360f;

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

    public TextView getEndBtn() {
        return this.f403357c;
    }

    public int getEndButtonType() {
        return this.f403360f;
    }

    public ImageView getStartBtn() {
        return this.f403356b;
    }

    public OButtonTitleBar(Context r100) {
        this(r100, null);
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r100) {
        this.f403359e.setBackgroundColor(r100);
    }

    public OButtonTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public OButtonTitleBar(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        int r112 = 0;
        this.f403360f = 0;
        FrameLayout.inflate(r100, R.layout.o_view_button_title_bar, this);
        this.f403356b = (ImageView) findViewById(R.id.back_btn);
        this.f403462a = (TextView) findViewById(R.id.title);
        this.f403357c = (TextView) findViewById(R.id.right_btn);
        this.f403359e = findViewById(R.id.line);
        this.f403356b.setOnClickListener(this);
        this.f403357c.setOnClickListener(this);
        qla.a r101 = new qla.a();
        this.f403356b.setOnTouchListener(r101);
        this.f403357c.setOnTouchListener(r101);
        if (r110 == null) goto L20;
        TypedArray r113 = r100.obtainStyledAttributes(r110, new int[]{R.attr.oui_centerText, R.attr.oui_centerTextColor, R.attr.oui_centerTextSize, R.attr.oui_dividerColor, R.attr.oui_dividerVisible, R.attr.oui_rightButtonText, R.attr.oui_rightButtonTextBackground, R.attr.oui_rightButtonTextColor, R.attr.oui_rightButtonTextSize, R.attr.oui_rightButtonType, R.attr.oui_rightButtonVisible});
        String r102 = r113.getString(0);
        float r103 = r113.getDimension(2, pla.d.g(17));
        int r104 = r113.getColor(1, ContextCompat.getColor(r100, R.color.TextPrimary));
        this.f403462a.setText(r102);
        this.f403462a.setTextSize(0, r103);
        this.f403462a.setTextColor(r104);
        String r105 = r113.getString(5);
        int r106 = r113.getInt(9, 1);
        float r107 = r113.getDimension(8, pla.d.a(Resources.getSystem()).density * 17.0f);
        int r108 = r113.getColor(7, 0);
        this.f403358d = r113.getDrawable(6);
        int r109 = r113.getInt(10, 0);
        this.f403357c.setText(r105);
        this.f403360f = r106;
        if (r106 != 1) goto L7;
        this.f403357c.setTypeface(Typeface.defaultFromStyle(1));
        this.f403357c.setTextColor(ContextCompat.getColor(r100, R.color.Primary));
    L8:
        this.f403357c.setTextSize(0, r107);
        if (r108 == 0) goto L11;
        this.f403357c.setTextColor(r108);
    L11:
        Drawable r114 = this.f403358d;
        if (r114 == null) goto L14;
        this.f403357c.setBackground(r114);
    L14:
        this.f403357c.setVisibility(r109);
        boolean r115 = r113.getBoolean(4, false);
        View r116 = this.f403359e;
        if (r115 == true) goto L18;
        r112 = 4;
    L18:
        r116.setVisibility(r112);
        this.f403359e.setBackgroundColor(r113.getColor(3, ContextCompat.getColor(r100, R.color.LinePrimary)));
        r113.recycle();
        return;
    L7:
        this.f403357c.setTypeface(Typeface.defaultFromStyle(0));
        this.f403357c.setTextColor(ContextCompat.getColor(r100, R.color.TextPrimary));
        goto L8
    }
}
