package com.bytedance.map.api.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes21.dex */
public class StrokeTextView extends TextView {
    private TextView outlineTextView;

    public StrokeTextView(Context r100) {
        this(r100, null);
    }

    private void init(AttributeSet r100) {
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.stroke_color, R.attr.stroke_width, R.attr.ttlive_stroke_color, R.attr.ttlive_stroke_width});
        int r102 = r101.getColor(0, -1);
        float r103 = r101.getDimension(1, 2.0f);
        TextPaint r104 = this.outlineTextView.getPaint();
        r104.setStrokeWidth(r103);
        r104.setStyle(Paint.Style.STROKE);
        this.outlineTextView.setTextColor(r102);
        this.outlineTextView.setGravity(getGravity());
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        this.outlineTextView.draw(r100);
        super.onDraw(r100);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt r100) {
        super.setEllipsize(r100);
        TextView r101 = this.outlineTextView;
        if (r101 == null) goto L6;
        r101.setEllipsize(r100);
        return;
    }

    @Override // android.widget.TextView
    public void setGravity(int r100) {
        super.setGravity(r100);
        TextView r101 = this.outlineTextView;
        if (r101 == null) goto L6;
        r101.setGravity(r100);
        return;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        super.setLayoutParams(r100);
        this.outlineTextView.setLayoutParams(r100);
    }

    @Override // android.widget.TextView
    public void setLines(int r100) {
        super.setLines(r100);
        TextView r101 = this.outlineTextView;
        if (r101 == null) goto L6;
        r101.setLines(r100);
        return;
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int r100) {
        super.setMaxWidth(r100);
        TextView r101 = this.outlineTextView;
        if (r101 == null) goto L6;
        r101.setMaxWidth(r100);
        return;
    }

    public void setStrokeColor(int r100) {
        this.outlineTextView.setTextColor(r100);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r100) {
        super.setTypeface(r100);
        TextView r101 = this.outlineTextView;
        if (r101 == null) goto L6;
        r101.setTypeface(r100);
        return;
    }

    public StrokeTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        CharSequence r102 = this.outlineTextView.getText();
        if (r102 != null) goto L5;
    L6:
        this.outlineTextView.setText(getText());
        postInvalidate();
    L7:
        this.outlineTextView.measure(r100, r101);
        return;
    L5:
        if (r102.equals(getText()) == true) goto L7;
        goto L6
    }

    @Override // android.widget.TextView
    public void setTextSize(int r100, float r101) {
        super.setTextSize(r100, r101);
        TextView r102 = this.outlineTextView;
        if (r102 == null) goto L6;
        r102.setTextSize(r100, r101);
        return;
    }

    public StrokeTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.outlineTextView = null;
        this.outlineTextView = new TextView(r100, r101, r102);
        init(r101);
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float r100, float r101, float r102, int r103) {
        super.setShadowLayer(r100, r101, r102, r103);
        this.outlineTextView.setShadowLayer(r100, r101, r102, r103);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.outlineTextView.layout(r101, r102, r103, r104);
    }
}
