package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SelectItemView extends ConstraintLayout {
    public boolean a;
    public UDCheckBox b;
    public TextView c;
    public TextView d;
    public View e;

    public UDCheckBox getCheckBox() {
        return this.b;
    }

    public final boolean isSelected() {
        return this.a;
    }

    public SelectItemView(Context r2) {
        this(r2, null);
    }

    public void setDescription(String r2) {
        this.d.setText(r2);
    }

    public void setSelected(boolean r2) {
        this.a = r2;
        this.b.setChecked(r2);
        if (r2 == true) goto L5;
    L7:
        this.d.setVisibility(8);
        return;
    L5:
        if (TextUtils.isEmpty(this.d.getText().toString()) == true) goto L7;
        this.d.setVisibility(0);
    }

    public void setText(int r2) {
        this.c.setText(r2);
    }

    public void setTextColor(int r2) {
        this.c.setTextColor(r2);
    }

    public void setText(String r2) {
        this.c.setText(r2);
    }

    public SelectItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectItemView(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        View r8 = LayoutInflater.from(r5).inflate(2131564513, this);
        this.b = r8.findViewById(2131386067);
        this.c = (TextView) r8.findViewById(2131386098);
        this.d = (TextView) r8.findViewById(2131386097);
        this.e = r8.findViewById(2131386096);
        TypedArray r9 = r5.obtainStyledAttributes(r6, new int[]{2130969749, 2130974054, 2130974327, 2130974574});
        String r10 = r9.getString(3);
        if (TextUtils.isEmpty(r10) == true) goto L5;
        this.c.setText(r10);
    L5:
        int r11 = 0;
        String r12 = r9.getString(0);
        if (TextUtils.isEmpty(r12) == true) goto L8;
        this.d.setText(r12);
    L8:
        int r13 = (int) r9.getDimension(2, -1.0f);
        if (r13 != (-1)) goto L11;
    L13:
        boolean r14 = r9.getBoolean(1, true);
        View r0 = this.e;
        if (r14 == true) goto L17;
        r11 = 8;
    L17:
        r0.setVisibility(r11);
        r9.recycle();
        return;
    L11:
        if ((this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        r1.setMargins(r1.leftMargin, r13, r1.rightMargin, r1.bottomMargin);
        goto L13
    }
}
