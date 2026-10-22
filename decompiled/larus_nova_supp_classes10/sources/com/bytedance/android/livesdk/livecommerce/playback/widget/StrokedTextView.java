package com.bytedance.android.livesdk.livecommerce.playback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/widget/StrokedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "color", "", "setStrokeColor", "Landroid/graphics/Typeface;", "tf", "setTypeface", "maxPixels", "setMaxWidth", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StrokedTextView extends AppCompatTextView {
    public final AppCompatTextView a;

    public StrokedTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StrokedTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        AppCompatTextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.draw(r2);
    L5:
        super/*android.widget.TextView*/.onDraw(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLayoutParams(ViewGroup.LayoutParams r2) {
        super/*android.widget.TextView*/.setLayoutParams(r2);
        AppCompatTextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setLayoutParams(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaxWidth(int r2) {
        super/*android.widget.TextView*/.setMaxWidth(r2);
        AppCompatTextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setMaxWidth(r2);
        return;
    }

    public final void setStrokeColor(int r2) {
        AppCompatTextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTypeface(Typeface r2) {
        super/*android.widget.TextView*/.setTypeface(r2);
        AppCompatTextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setTypeface(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        AppCompatTextView r0 = this.a;
        if (r0 == null) goto L5;
        CharSequence r1 = r0.getText();
    L6:
        if (r1 != null) goto L8;
    L9:
        AppCompatTextView r2 = this.a;
        if (r2 == null) goto L12;
        r2.setText(getText());
    L12:
        postInvalidate();
    L13:
        AppCompatTextView r5 = this.a;
        if (r5 == null) goto L17;
        r5.measure(r3, r4);
        return;
    L17:
        return;
    L8:
        if ((!Intrinsics.areEqual(r1, getText())) == false) goto L13;
    L5:
        r1 = null;
        goto L6
    }

    public final void setTextSize(int r2, float r3) {
        super.setTextSize(r2, r3);
        AppCompatTextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setTextSize(r2, r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StrokedTextView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        AppCompatTextView r0 = new AppCompatTextView(r3, r4, r5);
        this.a = r0;
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130974310, 2130974311});
        int r7 = r6.getColor(0, -16777216);
        float r8 = r6.getDimension(1, 1.0f);
        TextPaint r9 = r0.getPaint();
        if (r9 == null) goto L5;
        r9.setStrokeWidth(r8);
    L5:
        if (r9 == null) goto L7;
        r9.setStyle(Paint.Style.STROKE);
    L7:
        r0.setTextColor(r7);
        r0.setGravity(getGravity());
    }

    public /* synthetic */ StrokedTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setShadowLayer(float r2, float r3, float r4, int r5) {
        super/*android.widget.TextView*/.setShadowLayer(r2, r3, r4, r5);
        AppCompatTextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setShadowLayer(r2, r3, r4, r5);
        return;
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        AppCompatTextView r6 = this.a;
        if (r6 == null) goto L6;
        r6.layout(r2, r3, r4, r5);
        return;
    }
}
