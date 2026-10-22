package com.bytedance.ee.bear.sheet.inputbar.toolbar;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.util.ui.l;
import com.larksuite.component.universe_design.badge.UDBadgeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ToolbarItemView extends FrameLayout {
    public AppCompatImageView a;
    public TextView b;
    public UDBadgeView c;
    public View d;

    public int getBadgeVisibility() {
        return this.c.getVisibility();
    }

    @Override // android.view.View
    public final boolean isSelected() {
        return this.a.isSelected();
    }

    public ToolbarItemView(Context r2) {
        this(r2, null);
    }

    public void setBadgeVisibility(int r2) {
        this.c.setVisibility(r2);
    }

    public void setIconDrawable(Drawable r3) {
        this.b.setVisibility(8);
        this.a.setVisibility(0);
        if (r3 == null) goto L5;
        this.a.setImageDrawable(r3);
    L5:
        l.c(this.a, 2131102418);
    }

    public void setIconTint(int r2) {
        ColorStateList r3 = getResources().getColorStateList(r2);
        this.a.setImageTintList(r3);
    }

    public void setLeadingDividerVisible(boolean r2) {
        View r0 = this.d;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    @Override // android.view.View
    public void setSelected(boolean r5) {
        this.a.setSelected(r5);
        int r0 = 2131101111;
        if (r5 == false) goto L5;
        int r2 = 2131101111;
    L6:
        setIconTint(r2);
        TextView r3 = this.b;
        Resources r4 = getResources();
        if (r5 == true) goto L10;
        r0 = 2131108729;
    L10:
        r3.setTextColor(r4.getColor(r0));
        return;
    L5:
        r2 = 2131108729;
        goto L6
    }

    public void setText(String r3) {
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setGravity(17);
        this.b.setText(r3);
        this.b.setTextColor(getResources().getColor(2131102418));
    }

    public ToolbarItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ToolbarItemView(Context r6, AttributeSet r7, int r8) {
        super(r6, r7, r8);
        TypedArray r9 = r6.obtainStyledAttributes(r7, new int[]{2130970400});
        Drawable r10 = r9.getDrawable(0);
        r9.recycle();
        LayoutInflater.from(getContext()).inflate(2131564589, this, true);
        this.a = findViewById(2131375773);
        this.b = (TextView) findViewById(2131375863);
        this.c = findViewById(2131375707);
        this.d = findViewById(2131375789);
        setIconDrawable(r10);
        setIconTint(2131108729);
        l.c(this.a, 2131102418);
        StateListDrawable r11 = new StateListDrawable();
        r11.addState(new int[]{R.attr.state_pressed}, ResourcesCompat.getDrawable(getResources(), 2131233896, null));
        this.a.setBackgroundDrawable(r11);
        StateListDrawable r12 = new StateListDrawable();
        r12.addState(new int[]{R.attr.state_pressed}, ResourcesCompat.getDrawable(getResources(), 2131233879, null));
        this.b.setBackground(r12);
    }
}
