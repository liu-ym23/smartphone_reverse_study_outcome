package com.bytedance.ee.bear.edit.component.toolbar2.insertblock;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class InsertNewBlockItemView extends RelativeLayout {
    public AppCompatImageView a;
    public TextView b;
    public View c;

    public InsertNewBlockItemView(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r2) {
        View.inflate(r2, 2131560112, this);
        this.a = findViewById(2131375199);
        this.b = (TextView) findViewById(2131375200);
        this.c = findViewById(2131375193);
        l.c(this.a, 2131102418);
    }

    public void setBadge(boolean r2) {
        View r0 = this.c;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setIcon(int r2) {
        this.a.setImageResource(kac.a.b(r2));
    }

    public void setIconBackground(int r2) {
        this.a.setBackgroundResource(kac.a.b(r2));
    }

    public void setIconBackgroundTint(int r2) {
        ColorStateList r3 = getResources().getColorStateList(r2);
        this.a.setBackgroundTintList(r3);
    }

    public void setIconImageTint(int r2) {
        ColorStateList r3 = getResources().getColorStateList(r2);
        this.a.setImageTintList(r3);
    }

    public void setText(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        this.b.setVisibility(8);
        return;
    L5:
        this.b.setVisibility(0);
        this.b.setText(r3);
    }

    public void setIconBackgroundTint(String r2) {
        ColorStateList r3 = ColorStateList.valueOf(ColorUtils.h(r2));
        this.a.setBackgroundTintList(r3);
    }

    public void setIconImageTint(String r2) {
        ColorStateList r3 = ColorStateList.valueOf(ColorUtils.h(r2));
        this.a.setImageTintList(r3);
    }

    public InsertNewBlockItemView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }
}
