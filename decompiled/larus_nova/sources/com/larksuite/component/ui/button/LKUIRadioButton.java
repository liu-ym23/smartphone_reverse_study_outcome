package com.larksuite.component.ui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.larus.nova.R;
import j08.d;

/* JADX INFO: loaded from: classes24.dex */
public class LKUIRadioButton extends AppCompatRadioButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f284085a;

    public LKUIRadioButton(Context r100) {
        super(r100);
        a(null);
    }

    public final void a(AttributeSet r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        TypedArray r102 = null;
    L6:
        if (r102 == null) goto L8;
        boolean r103 = r102.getBoolean(0, false);
        r102.recycle();
    L9:
        if (r100 != null) goto L11;
        TypedArray r104 = null;
    L12:
        if (r104 == null) goto L14;
        r101 = r104.getBoolean(0, false);
        r104.recycle();
    L14:
        if (r103 == false) goto L16;
        this.f284085a = d.b(getContext(), R.drawable.lkui_list_radio_button_bg);
        setClickable(r101);
    L17:
        setButtonDrawable(null);
        setBackground(null);
        return;
    L16:
        this.f284085a = d.b(getContext(), R.drawable.lkui_radio_button_bg);
        goto L17
    L11:
        r104 = getContext().obtainStyledAttributes(r100, new int[]{android.R.attr.clickable});
        goto L12
    L8:
        r103 = false;
        goto L9
    L5:
        r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.checkStyle});
        goto L6
    }

    public LKUIRadioButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r101);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 != null) goto L5;
    L9:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (r102.width != (-2)) goto L9;
        if (r102.height != (-2)) goto L9;
        int r103 = (int) j08.b.a(getContext(), 18.0f);
        int r104 = (getPaddingLeft() + r103) + getPaddingRight();
        int r105 = (r103 + getPaddingTop()) + getPaddingBottom();
        int r106 = View.MeasureSpec.makeMeasureSpec(r104, 1073741824);
        r101 = View.MeasureSpec.makeMeasureSpec(r105, 1073741824);
        r100 = r106;
        goto L9
    }

    public LKUIRadioButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r101);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L9;
        int r105 = (int) j08.b.a(getContext(), 18.0f);
        if (getLayoutParams() == null) goto L7;
        r105 = Math.min((getWidth() - getPaddingRight()) - getPaddingLeft(), (getHeight() - getPaddingTop()) - getPaddingBottom());
    L7:
        this.f284085a.setBounds(0, 0, r105, r105);
        setCompoundDrawables(this.f284085a, null, null, null);
        return;
    }
}
