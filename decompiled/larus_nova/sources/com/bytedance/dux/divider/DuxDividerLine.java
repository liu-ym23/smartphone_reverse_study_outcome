package com.bytedance.dux.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import dm4.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes15.dex */
public class DuxDividerLine extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f204978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f204979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f204980c;

    public TextView getTxtLeft() {
        return this.f204979b;
    }

    public DuxDividerLine(Context r100) {
        this(r100, null);
    }

    public DuxDividerLine(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DuxDividerLine(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        View r103 = View.inflate(r100, R.layout.dux_view_divider_line, this);
        this.f204978a = r103;
        this.f204979b = (TextView) r103.findViewById(R.id.tv_left_text);
        this.f204980c = this.f204978a.findViewById(R.id.underline);
        this.f204978a.setBackgroundColor(ContextCompat.getColor(r100, R.color.BGPrimary));
        Objects.toString(r100);
        Objects.toString(r101);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.hideLine, R.attr.isStartAllCap, R.attr.startText});
        if (r104.getBoolean(0, false) == false) goto L5;
        this.f204980c.setVisibility(8);
    L5:
        this.f204980c.setBackgroundColor(ContextCompat.getColor(r100, R.color.LinePrimary));
        this.f204978a.setBackgroundColor(ContextCompat.getColor(r100, R.color.BGPrimary));
        String r105 = r104.getString(2);
        if (TextUtils.isEmpty(r105) == true) goto L8;
        this.f204979b.setText(r105);
    L9:
        this.f204979b.setTextColor(ContextCompat.getColor(r100, R.color.TextTertiary));
        if (r104.getBoolean(1, false) == false) goto L12;
        this.f204979b.setAllCaps(true);
    L12:
        r104.recycle();
        return;
    L8:
        this.f204979b.setVisibility(8);
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) this.f204980c.getLayoutParams();
        r106.bottomMargin = a.b(4);
        goto L9
    }
}
