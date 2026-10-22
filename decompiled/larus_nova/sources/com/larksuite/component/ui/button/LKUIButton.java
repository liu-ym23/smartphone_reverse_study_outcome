package com.larksuite.component.ui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes24.dex */
public class LKUIButton extends AppCompatButton {
    public LKUIButton(Context r100) {
        this(r100, null);
    }

    private void setCommonButtonStyle(Context r100) {
        setHeight((int) j08.b.a(r100, 28.0f));
        setMinWidth((int) j08.b.a(r100, 60.0f));
        setPadding((int) j08.b.a(r100, 12.0f), 0, (int) j08.b.a(r100, 12.0f), 0);
    }

    private void setCustomStyle(TypedArray r110) {
        int r100 = r110.getColor(2, getResources().getColor(R.color.colorful_blue));
        int r101 = r110.getColor(3, getResources().getColor(R.color.colorful_blue));
        int r102 = r110.getColor(1, getResources().getColor(R.color.ud_B200));
        int r103 = r110.getDimensionPixelSize(0, 0);
        int r104 = r110.getColor(4, getResources().getColor(R.color.colorful_blue));
        int r111 = r110.getDimensionPixelSize(5, 0);
        StateListDrawable r105 = new StateListDrawable();
        r105.addState(new int[]{android.R.attr.state_pressed}, b.a(r101, r103, r104, r111));
        r105.addState(new int[]{-16842910}, b.a(r102, r103, r104, r111));
        r105.addState(new int[0], b.a(r100, r103, r104, r111));
        setBackground(r105);
    }

    private void setLargeButtonStyle(Context r100) {
        setHeight((int) j08.b.a(r100, 48.0f));
    }

    public LKUIButton(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LKUIButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.button_corner_radius, R.attr.button_disable_color, R.attr.button_normal_color, R.attr.button_pressed_color, R.attr.button_stroke_color, R.attr.button_stroke_width, R.attr.button_style}, r102, 0);
        switch(r103.getInt(6, 0)) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        setCustomStyle(r103);
    L12:
        r103.recycle();
        setGravity(17);
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        return;
    L5:
        setTextAppearance(r100, R.style.GreyButton);
        setBackground(getResources().getDrawable(R.drawable.lkui_button_light_grey_border_bg));
        setCommonButtonStyle(r100);
        goto L12
    L6:
        setTextAppearance(r100, R.style.LightButton);
        setBackground(getResources().getDrawable(R.drawable.lkui_button_light_grey_border_bg));
        setCommonButtonStyle(r100);
        goto L12
    L7:
        setTextAppearance(r100, R.style.LightButton);
        setBackground(getResources().getDrawable(R.drawable.lkui_button_light_blue_border_bg));
        setCommonButtonStyle(r100);
        goto L12
    L8:
        setTextAppearance(r100, R.style.BlueButton);
        setBackground(getResources().getDrawable(R.drawable.lkui_button_blue_bg));
        setCommonButtonStyle(r100);
        goto L12
    L9:
        setTextAppearance(r100, R.style.LargeGreyButton);
        setBackground(getResources().getDrawable(R.drawable.lkui_button_large_grey_bg));
        setLargeButtonStyle(r100);
        goto L12
    L10:
        setTextAppearance(r100, R.style.LargeLightButton);
        setBackground(getResources().getDrawable(R.drawable.lkui_button_large_light_bg));
        setLargeButtonStyle(r100);
        goto L12
    L11:
        setTextAppearance(r100, R.style.LargeBlueButton);
        setBackground(getResources().getDrawable(R.drawable.lkui_button_blue_bg));
        setLargeButtonStyle(r100);
        goto L12
    }
}
