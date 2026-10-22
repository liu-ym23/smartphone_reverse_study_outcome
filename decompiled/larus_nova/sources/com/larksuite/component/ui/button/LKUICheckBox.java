package com.larksuite.component.ui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.larus.nova.R;
import j08.d;

/* JADX INFO: loaded from: classes24.dex */
public class LKUICheckBox extends AppCompatCheckBox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f284069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f284070b;

    public LKUICheckBox(Context r100) {
        super(r100);
        this.f284070b = false;
        a(null);
    }

    public final void a(AttributeSet r100) {
        if (r100 != null) goto L5;
        TypedArray r101 = null;
    L6:
        if (r101 == null) goto L8;
        this.f284070b = r101.getBoolean(0, this.f284070b);
        r101.recycle();
    L8:
        setButtonDrawable(null);
        setBackground(null);
        return;
    L5:
        r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.radio});
        goto L6
    }

    public void setRadio(boolean r100) {
        this.f284070b = r100;
    }

    public LKUICheckBox(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f284070b = false;
        a(r101);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 == null) goto L10;
        int r103 = (int) j08.b.a(getContext(), 18.0f);
        if (r102.width != (-2)) goto L8;
        r100 = View.MeasureSpec.makeMeasureSpec((getPaddingLeft() + r103) + getPaddingRight(), 1073741824);
    L8:
        if (r102.height != (-2)) goto L10;
        r101 = View.MeasureSpec.makeMeasureSpec((r103 + getPaddingTop()) + getPaddingBottom(), 1073741824);
    L10:
        super.onMeasure(r100, r101);
    }

    public LKUICheckBox(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f284070b = false;
        a(r101);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f284070b == false) goto L7;
        this.f284069a = d.b(getContext(), R.drawable.lkui_radio_button_bg);
    L8:
        int r105 = (int) j08.b.a(getContext(), 18.0f);
        if (getLayoutParams() == null) goto L11;
        r105 = Math.min((getWidth() - getPaddingRight()) - getPaddingLeft(), (getHeight() - getPaddingTop()) - getPaddingBottom());
    L11:
        this.f284069a.setBounds(0, 0, r105, r105);
        setCompoundDrawables(this.f284069a, null, null, null);
        return;
    L7:
        this.f284069a = d.b(getContext(), R.drawable.lkui_check_box_bg);
        goto L8
    }
}
