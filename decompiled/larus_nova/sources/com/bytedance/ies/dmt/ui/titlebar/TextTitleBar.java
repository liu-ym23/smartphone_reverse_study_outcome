package com.bytedance.ies.dmt.ui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.larus.nova.R;
import h46.a;

/* JADX INFO: loaded from: classes19.dex */
public class TextTitleBar extends AbstractTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DmtTextView f248383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DmtTextView f248384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f248385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f248386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f248387g;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    public void setOnTitleBarClickListener(a r100) {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f248381a.setMaxWidth((int) Math.max(((j46.a.b(getContext()) / 2) - Math.max(this.f248383c.getMeasuredWidth(), this.f248384d.getMeasuredWidth())) * 2, dm4.a.a(getContext(), 112.0f)));
    }

    public ImageView getBackBtn() {
        return this.f248385e;
    }

    public DmtTextView getEndText() {
        return this.f248384d;
    }

    public DmtTextView getStartText() {
        return this.f248383c;
    }

    public TextTitleBar(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ies.dmt.ui.titlebar.AbstractTitleBar, e46.b
    public final void a(int r100) {
        ImageView r101 = this.f248385e;
        boolean r102 = true;
        if (r100 == 1) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L8;
        int r103 = R.drawable.uikit_ic_titlebar_back;
    L9:
        r101.setImageResource(r103);
        return;
    L8:
        r103 = R.drawable.uikit_ic_titlebar_back_black;
        goto L9
    }

    @Override // com.bytedance.ies.dmt.ui.titlebar.AbstractTitleBar
    public void setDividerLineBackground(int r100) {
        this.f248387g.setBackgroundColor(r100);
    }

    public void setEndText(int r100) {
        this.f248384d.setText(r100);
    }

    public void setEndTextColor(int r100) {
        this.f248384d.setTextColor(r100);
    }

    public void setEndTextSize(float r100) {
        this.f248384d.setTextSize(r100);
    }

    public void setLineBackground(int r100) {
        this.f248387g.setBackgroundColor(r100);
    }

    public void setStartText(int r100) {
        this.f248383c.setText(r100);
    }

    public void setStartTextColor(int r100) {
        this.f248383c.setTextColor(r100);
    }

    public void setStartTextSize(float r100) {
        this.f248383c.setTextSize(r100);
    }

    public void setUseBackIcon(boolean r100) {
        if (this.f248386f == r100) goto L13;
        this.f248386f = r100;
        ImageView r101 = this.f248385e;
        int r102 = 0;
        if (r100 == false) goto L7;
        int r103 = 0;
    L8:
        r101.setVisibility(r103);
        DmtTextView r104 = this.f248383c;
        if (this.f248386f == false) goto L11;
        r102 = 8;
    L11:
        r104.setVisibility(r102);
        return;
    L7:
        r103 = 8;
        goto L8
    }

    public void setEndText(CharSequence r100) {
        this.f248384d.setText(r100);
    }

    public void setStartText(CharSequence r100) {
        this.f248383c.setText(r100);
    }

    public TextTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public TextTitleBar(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        FrameLayout.inflate(r110, R.layout.view_text_title_bar, this);
        this.f248383c = (DmtTextView) findViewById(R.id.text_left);
        this.f248381a = (DmtTextView) findViewById(R.id.title);
        this.f248384d = (DmtTextView) findViewById(R.id.text_right);
        this.f248385e = (ImageView) findViewById(R.id.back_btn);
        this.f248387g = findViewById(R.id.line);
        this.f248385e.setOnClickListener(this);
        this.f248383c.setOnClickListener(this);
        this.f248384d.setOnClickListener(this);
        com.bytedance.ies.dmt.ui.widget.a r113 = new com.bytedance.ies.dmt.ui.widget.a();
        this.f248385e.setOnTouchListener(r113);
        this.f248383c.setOnTouchListener(r113);
        this.f248384d.setOnTouchListener(r113);
        if (r111 == null) goto L13;
        TypedArray r114 = r110.obtainStyledAttributes(r111, new int[]{R.attr.endButtonType, R.attr.endText, R.attr.endTextColor, R.attr.endTextSize, R.attr.endTextVisible, R.attr.lineColor, R.attr.lineVisible, R.attr.startText, R.attr.startTextColor, R.attr.startTextSize, R.attr.titleText, R.attr.titleTextColor, R.attr.titleTextSize, R.attr.useBackIcon});
        String r100 = r114.getString(10);
        float r101 = r114.getDimension(12, dm4.a.a(r110, 17.0f));
        int r102 = r114.getColor(11, ContextCompat.getColor(r110, R.color.TextPrimary));
        this.f248381a.setText(r100);
        this.f248381a.setTextSize(0, r101);
        this.f248381a.setTextColor(r102);
        boolean r103 = r114.getBoolean(13, false);
        this.f248386f = r103;
        if (r103 == false) goto L7;
        this.f248385e.setVisibility(0);
        this.f248383c.setVisibility(8);
    L8:
        String r104 = r114.getString(1);
        float r105 = r114.getDimension(3, dm4.a.a(r110, 15.0f));
        int r115 = r114.getColor(2, ContextCompat.getColor(r110, R.color.TextPrimary));
        int r106 = r114.getInt(4, 0);
        this.f248384d.setText(r104);
        this.f248384d.setTextSize(0, r105);
        this.f248384d.setTextColor(r115);
        this.f248384d.setVisibility(r106);
        if (r114.getInt(0, 1) != 1) goto L11;
        this.f248384d.setTypeface(Typeface.defaultFromStyle(1));
        this.f248384d.setTextColor(getResources().getColor(R.color.Primary));
    L12:
        int r116 = r114.getInt(6, 0);
        this.f248387g.setVisibility(r116);
        int r117 = r114.getColor(5, getResources().getColor(R.color.LinePrimary));
        this.f248387g.setBackgroundColor(r117);
        r114.getDimension(12, 17.0f);
        r114.recycle();
        goto L13
    L11:
        this.f248384d.setTypeface(Typeface.defaultFromStyle(0));
        this.f248384d.setTextColor(getResources().getColor(R.color.TextPrimary));
        goto L12
    L7:
        String r107 = r114.getString(7);
        float r108 = r114.getDimension(9, dm4.a.a(r110, 15.0f));
        int r109 = r114.getColor(8, ContextCompat.getColor(r110, R.color.TextPrimary));
        this.f248385e.setVisibility(8);
        this.f248383c.setVisibility(0);
        this.f248383c.setText(r107);
        this.f248383c.setTextSize(0, r108);
        this.f248383c.setTextColor(r109);
    L13:
        setColorMode(1);
    }
}
