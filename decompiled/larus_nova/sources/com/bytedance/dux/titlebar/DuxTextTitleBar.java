package com.bytedance.dux.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
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
public class DuxTextTitleBar extends DuxTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f205803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f205804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f205805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f205806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f205807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f205808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f205809k;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    public void setOnTitleBarClickListener(a r100) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextView r100 = this.f205803e;
        if (r100 == null) goto L5;
        n.b(r100, g.c(44), g.c(44), false);
    L5:
        TextView r101 = this.f205804f;
        if (r101 == null) goto L9;
        n.b(r101, g.c(44), g.c(44), false);
        return;
    }

    public ImageView getBackBtn() {
        return this.f205805g;
    }

    public int getEndButtonType() {
        return this.f205809k;
    }

    public TextView getEndText() {
        return this.f205804f;
    }

    public TextView getStartText() {
        return this.f205803e;
    }

    public DuxTextTitleBar(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.dux.titlebar.DuxTitleBar
    public void setDividerLineBackground(int r100) {
        this.f205808j.setBackgroundColor(r100);
    }

    public void setEndText(int r100) {
        this.f205804f.setText(r100);
    }

    public void setEndTextColor(int r100) {
        this.f205804f.setTextColor(r100);
    }

    public void setEndTextSize(float r100) {
        this.f205804f.setTextSize(r100);
    }

    public void setLineBackground(int r100) {
        this.f205808j.setBackgroundColor(r100);
    }

    public void setStartText(int r100) {
        this.f205803e.setText(r100);
    }

    public void setStartTextColor(int r100) {
        this.f205803e.setTextColor(r100);
    }

    public void setStartTextSize(float r100) {
        this.f205803e.setTextSize(r100);
    }

    public void setUseBackIcon(boolean r100) {
        if (this.f205806h == r100) goto L13;
        this.f205806h = r100;
        ImageView r101 = this.f205805g;
        int r102 = 0;
        if (r100 == false) goto L7;
        int r103 = 0;
    L8:
        r101.setVisibility(r103);
        this.f205805g.setImageResource(R.drawable.dux_ic_titlebar_back);
        TextView r104 = this.f205803e;
        if (this.f205806h == false) goto L11;
        r102 = 8;
    L11:
        r104.setVisibility(r102);
        this.f205805g.setContentDescription(getContext().getString(R.string.dux_iv_back_desc));
        return;
    L7:
        r103 = 8;
        goto L8
    }

    public void setUseCloseIcon(boolean r100) {
        if (this.f205807i == r100) goto L13;
        this.f205807i = r100;
        ImageView r101 = this.f205805g;
        int r102 = 0;
        if (r100 == false) goto L7;
        int r103 = 0;
    L8:
        r101.setVisibility(r103);
        this.f205805g.setImageResource(R.drawable.dux_ic_titlebar_close);
        TextView r104 = this.f205803e;
        if (this.f205807i == false) goto L11;
        r102 = 8;
    L11:
        r104.setVisibility(r102);
        this.f205805g.setContentDescription(getContext().getString(R.string.dux_iv_close_desc));
        return;
    L7:
        r103 = 8;
        goto L8
    }

    public void setEndText(CharSequence r100) {
        this.f205804f.setText(r100);
    }

    public void setStartText(CharSequence r100) {
        this.f205803e.setText(r100);
    }

    public DuxTextTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DuxTextTitleBar(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111, null);
        this.f205809k = 0;
        if (this.f205812b == false) goto L5;
        int r101 = R.layout.dux_view_text_title_bar_new;
    L6:
        FrameLayout.inflate(r100, r101, this);
        this.f205803e = (TextView) findViewById(R.id.text_left);
        this.f205811a = (TextView) findViewById(R.id.title);
        this.f205804f = (TextView) findViewById(R.id.text_right);
        this.f205805g = (ImageView) findViewById(R.id.back_btn);
        this.f205808j = findViewById(R.id.line);
        this.f205805g.setOnClickListener(this);
        this.f205803e.setOnClickListener(this);
        this.f205804f.setOnClickListener(this);
        fm4.a r102 = new fm4.a(0.5f);
        this.f205805g.setOnTouchListener(r102);
        this.f205803e.setOnTouchListener(r102);
        this.f205804f.setOnTouchListener(r102);
        b(new View[]{this.f205805g});
        c(new TextView[]{this.f205811a, this.f205803e, this.f205804f});
        if (r110 == null) goto L23;
        TypedArray r112 = r100.obtainStyledAttributes(r110, new int[]{R.attr.adaptLargeFontMode, R.attr.centerText, R.attr.centerTextColor, R.attr.centerTextSize, R.attr.dividerColor, R.attr.dividerVisible, R.attr.leftButtonText, R.attr.leftTextColor, R.attr.leftTextSize, R.attr.rightButtonText, R.attr.rightButtonType, R.attr.rightTextColor, R.attr.rightTextSize, R.attr.rightTextVisible, R.attr.useBackIcon, R.attr.useCloseIcon});
        String r103 = r112.getString(1);
        float r104 = r112.getDimension(3, a(17));
        int r105 = r112.getColor(2, ContextCompat.getColor(r100, R.color.TextPrimary));
        this.f205811a.setText(r103);
        this.f205811a.setTextSize(0, r104);
        this.f205811a.setTextColor(r105);
        this.f205806h = r112.getBoolean(14, false);
        boolean r106 = r112.getBoolean(15, false);
        this.f205807i = r106;
        if (this.f205806h == false) goto L11;
        this.f205805g.setVisibility(0);
        this.f205803e.setVisibility(8);
        this.f205805g.setContentDescription(r100.getString(R.string.dux_iv_back_desc));
    L14:
        int r107 = r112.getInt(10, 1);
        this.f205809k = r107;
        if (r107 != 1) goto L17;
        this.f205804f.setTextColor(ContextCompat.getColor(r100, R.color.Primary));
    L18:
        String r108 = r112.getString(9);
        float r109 = r112.getDimension(12, a(15));
        int r113 = r112.getColor(11, ContextCompat.getColor(r100, R.color.TextPrimary));
        int r114 = r112.getInt(13, 0);
        this.f205804f.setText(r108);
        this.f205804f.setTextSize(0, r109);
        if (r112.hasValue(11) == false) goto L21;
        this.f205804f.setTextColor(r113);
    L21:
        this.f205804f.setVisibility(r114);
        this.f205808j.setVisibility(r112.getInt(5, 0));
        this.f205808j.setBackgroundColor(r112.getColor(4, ContextCompat.getColor(r100, R.color.LinePrimary)));
        r112.recycle();
        return;
    L17:
        this.f205804f.setTextColor(ContextCompat.getColor(r100, R.color.TextPrimary));
        goto L18
    L11:
        if (r106 == false) goto L13;
        this.f205805g.setVisibility(0);
        this.f205805g.setImageResource(R.drawable.dux_ic_titlebar_close);
        this.f205803e.setVisibility(8);
        this.f205805g.setContentDescription(r100.getString(R.string.dux_iv_close_desc));
        goto L14
    L13:
        String r115 = r112.getString(6);
        float r116 = r112.getDimension(8, a(15));
        int r117 = r112.getColor(7, ContextCompat.getColor(r100, R.color.TextPrimary));
        this.f205805g.setVisibility(8);
        this.f205803e.setVisibility(0);
        this.f205803e.setText(r115);
        this.f205803e.setTextSize(0, r116);
        this.f205803e.setTextColor(r117);
        goto L14
    L23:
        return;
    L5:
        r101 = R.layout.dux_view_text_title_bar;
        goto L6
    }
}
