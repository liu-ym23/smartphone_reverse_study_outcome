package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes37.dex */
public class LineHeightTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f435635d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f435636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f435637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView.BufferType f435638c;

    public class a extends SparseIntArray {
        public a() {
            put(26, 34);
            put(24, 32);
            put(20, 28);
            put(17, 24);
            put(16, 22);
            put(14, 20);
            put(12, 18);
            put(10, 14);
        }
    }

    public static class b extends SpannableStringBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f435639a;

        public b() {
        }
    }

    public static class c implements LineHeightSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f435640a;

        public c(float r100) {
            this.f435640a = (int) Math.ceil(r100);
        }

        @Override // android.text.style.LineHeightSpan
        public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
            int r106 = r105.descent;
            int r107 = this.f435640a;
            if (r106 <= r107) goto L5;
            int r108 = Math.min(r107, r106);
            r105.descent = r108;
            r105.bottom = r108;
            r105.ascent = 0;
            r105.top = 0;
            return;
        L5:
            int r109 = r105.ascent;
            if (((-r109) + r106) <= r107) goto L8;
            r105.bottom = r106;
            int r110 = (-r107) + r106;
            r105.ascent = r110;
            r105.top = r110;
            return;
        L8:
            int r111 = r105.bottom;
            if (((-r109) + r111) <= r107) goto L11;
            r105.top = r109;
            r105.bottom = r109 + r107;
            return;
        L11:
            int r112 = r105.top;
            if (((-r112) + r111) <= r107) goto L14;
            r105.top = r111 - r107;
            return;
        L14:
            double r113 = r112;
            double r114 = (r107 - ((-r112) + r111)) / 2.0f;
            r105.top = (int) (r113 - Math.ceil(r114));
            int r115 = (int) (((double) r105.bottom) + Math.floor(r114));
            r105.bottom = r115;
            r105.ascent = r105.top;
            r105.descent = r115;
        }
    }

    static {
        f435635d = new a();
    }

    private b getBuilder() {
        if (this.f435636a != null) goto L6;
        this.f435636a = new b();
    L6:
        return this.f435636a;
    }

    public LineHeightTextView(Context r100) {
        super(r100);
        this.f435637b = -1.0f;
        this.f435638c = TextView.BufferType.NORMAL;
    }

    public void setUXLineHeight(float r100) {
        this.f435637b = r100;
        setText(getText(), this.f435638c);
    }

    public void setUXLineHeightInDp(float r100) {
        Resources r101 = getContext().getResources();
        setUXLineHeight(WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
    }

    public LineHeightTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f435637b = -1.0f;
        this.f435638c = TextView.BufferType.NORMAL;
        x(r100, r101);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.f435638c = r101;
        if (this.f435637b > 1.0f) goto L7;
        super.setText(r100, r101);
        return;
    L7:
        b r102 = getBuilder();
        float r103 = this.f435637b;
        r102.clear();
        r102.clearSpans();
        c r104 = r102.f435639a;
        if (r104 != null) goto L10;
        r102.f435639a = new c(r103);
    L11:
        r102.append(r100);
        r102.setSpan(r102.f435639a, 0, r100.length(), 17);
        super.setText(r102, r101);
        return;
    L10:
        r104.f435640a = (int) Math.ceil(r103);
        goto L11
    }

    public final void x(Context r100, AttributeSet r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ux_line_height});
        int r103 = r102.getDimensionPixelSize(0, -1);
        if (r103 >= 0) goto L7;
        Resources r104 = getResources();
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        r103 = (int) (f435635d.get((int) (getTextSize() / r105), -1) * r105);
    L7:
        setUXLineHeight(r103);
        r102.recycle();
    }

    public LineHeightTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f435637b = -1.0f;
        this.f435638c = TextView.BufferType.NORMAL;
        x(r100, r101);
    }
}
