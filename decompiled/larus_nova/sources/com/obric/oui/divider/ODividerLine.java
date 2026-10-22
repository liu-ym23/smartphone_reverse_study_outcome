package com.obric.oui.divider;

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
import java.util.Objects;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
public class ODividerLine extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f400795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f400796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f400797c;

    public TextView getTxtLeft() {
        return this.f400796b;
    }

    public ODividerLine(Context r100) {
        this(r100, null);
    }

    public ODividerLine(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ODividerLine(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        View r103 = View.inflate(r100, R.layout.o_view_divider_line, this);
        this.f400795a = r103;
        this.f400796b = (TextView) r103.findViewById(R.id.tv_left_text);
        this.f400797c = this.f400795a.findViewById(R.id.underline);
        this.f400795a.setBackgroundColor(ContextCompat.getColor(r100, R.color.BGPrimary));
        Objects.toString(r100);
        Objects.toString(r101);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_hideLine, R.attr.oui_isStartAllCap, R.attr.oui_startText});
        if (r104.getBoolean(0, false) == false) goto L5;
        this.f400797c.setVisibility(8);
    L5:
        this.f400797c.setBackgroundColor(ContextCompat.getColor(r100, R.color.LinePrimary));
        this.f400795a.setBackgroundColor(ContextCompat.getColor(r100, R.color.BGPrimary));
        String r105 = r104.getString(2);
        if (TextUtils.isEmpty(r105) == true) goto L8;
        this.f400796b.setText(r105);
    L9:
        this.f400796b.setTextColor(ContextCompat.getColor(r100, R.color.TextTertiary));
        if (r104.getBoolean(1, false) == false) goto L12;
        this.f400796b.setAllCaps(true);
    L12:
        r104.recycle();
        return;
    L8:
        this.f400796b.setVisibility(8);
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) this.f400797c.getLayoutParams();
        r106.bottomMargin = d.g(4);
        goto L9
    }
}
