package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public class OTextTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f403455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f403456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f403457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f403458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f403459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f403460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f403461h;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    public void setOnTitleBarClickListener(tma.a r100) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextView r100 = this.f403455b;
        if (r100 == null) goto L5;
        pla.j.b(r100, pla.d.g(44), pla.d.g(44), false);
    L5:
        TextView r101 = this.f403456c;
        if (r101 == null) goto L9;
        pla.j.b(r101, pla.d.g(44), pla.d.g(44), false);
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r100 = pla.d.j(getContext());
        int r101 = ((r100 / 2) - Math.max(this.f403455b.getMeasuredWidth(), this.f403456c.getMeasuredWidth())) * 2;
        this.f403462a.setMaxWidth(Math.max(r101, pla.d.g(112)));
    }

    public ImageView getBackBtn() {
        return this.f403457d;
    }

    public int getEndButtonType() {
        return this.f403461h;
    }

    public TextView getEndText() {
        return this.f403456c;
    }

    public TextView getStartText() {
        return this.f403455b;
    }

    public OTextTitleBar(Context r100) {
        this(r100, null);
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r100) {
        this.f403460g.setBackgroundColor(r100);
    }

    public void setEndText(int r100) {
        this.f403456c.setText(r100);
    }

    public void setEndTextColor(int r100) {
        this.f403456c.setTextColor(r100);
    }

    public void setEndTextSize(float r100) {
        this.f403456c.setTextSize(r100);
    }

    public void setLineBackground(int r100) {
        this.f403460g.setBackgroundColor(r100);
    }

    public void setStartText(int r100) {
        this.f403455b.setText(r100);
    }

    public void setStartTextColor(int r100) {
        this.f403455b.setTextColor(r100);
    }

    public void setStartTextSize(float r100) {
        this.f403455b.setTextSize(r100);
    }

    public void setUseBackIcon(boolean r100) {
        if (this.f403458e == r100) goto L13;
        this.f403458e = r100;
        ImageView r101 = this.f403457d;
        int r102 = 0;
        if (r100 == false) goto L7;
        int r103 = 0;
    L8:
        r101.setVisibility(r103);
        this.f403457d.setImageResource(R.drawable.o_ic_titlebar_back);
        TextView r104 = this.f403455b;
        if (this.f403458e == false) goto L11;
        r102 = 8;
    L11:
        r104.setVisibility(r102);
        this.f403457d.setContentDescription(getContext().getString(R.string.oui_iv_back_desc));
        return;
    L7:
        r103 = 8;
        goto L8
    }

    public void setUseCloseIcon(boolean r100) {
        if (this.f403459f == r100) goto L13;
        this.f403459f = r100;
        ImageView r101 = this.f403457d;
        int r102 = 0;
        if (r100 == false) goto L7;
        int r103 = 0;
    L8:
        r101.setVisibility(r103);
        this.f403457d.setImageResource(R.drawable.o_ic_titlebar_close);
        TextView r104 = this.f403455b;
        if (this.f403459f == false) goto L11;
        r102 = 8;
    L11:
        r104.setVisibility(r102);
        this.f403457d.setContentDescription(getContext().getString(R.string.oui_iv_close_desc));
        return;
    L7:
        r103 = 8;
        goto L8
    }

    public void setEndText(CharSequence r100) {
        this.f403456c.setText(r100);
    }

    public void setStartText(CharSequence r100) {
        this.f403455b.setText(r100);
    }

    public OTextTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public OTextTitleBar(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        this.f403461h = 0;
        FrameLayout.inflate(r100, R.layout.o_view_text_title_bar, this);
        this.f403455b = (TextView) findViewById(R.id.text_left);
        this.f403462a = (TextView) findViewById(R.id.title);
        this.f403456c = (TextView) findViewById(R.id.text_right);
        this.f403457d = (ImageView) findViewById(R.id.back_btn);
        this.f403460g = findViewById(R.id.line);
        this.f403457d.setOnClickListener(this);
        this.f403455b.setOnClickListener(this);
        this.f403456c.setOnClickListener(this);
        qla.a r101 = new qla.a();
        this.f403457d.setOnTouchListener(r101);
        this.f403455b.setOnTouchListener(r101);
        this.f403456c.setOnTouchListener(r101);
        if (r110 == null) goto L19;
        TypedArray r112 = r100.obtainStyledAttributes(r110, new int[]{R.attr.oui_centerText, R.attr.oui_centerTextColor, R.attr.oui_centerTextSize, R.attr.oui_dividerColor, R.attr.oui_dividerVisible, R.attr.oui_leftButtonText, R.attr.oui_leftTextColor, R.attr.oui_leftTextSize, R.attr.oui_rightButtonText, R.attr.oui_rightButtonType, R.attr.oui_rightTextColor, R.attr.oui_rightTextSize, R.attr.oui_rightTextVisible, R.attr.oui_useBackIcon, R.attr.oui_useCloseIcon});
        String r102 = r112.getString(0);
        float r103 = r112.getDimension(2, pla.d.g(17));
        int r104 = r112.getColor(1, ContextCompat.getColor(r100, R.color.TextPrimary));
        this.f403462a.setText(r102);
        this.f403462a.setTextSize(0, r103);
        this.f403462a.setTextColor(r104);
        this.f403458e = r112.getBoolean(13, false);
        boolean r105 = r112.getBoolean(14, false);
        this.f403459f = r105;
        if (this.f403458e == false) goto L7;
        this.f403457d.setVisibility(0);
        this.f403455b.setVisibility(8);
        this.f403457d.setContentDescription(r100.getString(R.string.oui_iv_back_desc));
    L10:
        int r106 = r112.getInt(9, 1);
        this.f403461h = r106;
        if (r106 != 1) goto L13;
        this.f403456c.setTextColor(ContextCompat.getColor(r100, R.color.Primary));
    L14:
        String r107 = r112.getString(8);
        float r108 = r112.getDimension(11, pla.d.g(15));
        int r109 = r112.getColor(10, ContextCompat.getColor(r100, R.color.TextPrimary));
        int r113 = r112.getInt(12, 0);
        this.f403456c.setText(r107);
        this.f403456c.setTextSize(0, r108);
        if (r112.hasValue(10) == false) goto L17;
        this.f403456c.setTextColor(r109);
    L17:
        this.f403456c.setVisibility(r113);
        this.f403460g.setVisibility(r112.getInt(4, 0));
        this.f403460g.setBackgroundColor(r112.getColor(3, ContextCompat.getColor(r100, R.color.LinePrimary)));
        r112.recycle();
        return;
    L13:
        this.f403456c.setTextColor(ContextCompat.getColor(r100, R.color.TextPrimary));
        goto L14
    L7:
        if (r105 == false) goto L9;
        this.f403457d.setVisibility(0);
        this.f403457d.setImageResource(R.drawable.o_ic_titlebar_close);
        this.f403455b.setVisibility(8);
        this.f403457d.setContentDescription(r100.getString(R.string.oui_iv_close_desc));
        goto L10
    L9:
        String r114 = r112.getString(5);
        float r115 = r112.getDimension(7, pla.d.g(15));
        int r116 = r112.getColor(6, ContextCompat.getColor(r100, R.color.TextPrimary));
        this.f403457d.setVisibility(8);
        this.f403455b.setVisibility(0);
        this.f403455b.setText(r114);
        this.f403455b.setTextSize(0, r115);
        this.f403455b.setTextColor(r116);
        goto L10
    }
}
