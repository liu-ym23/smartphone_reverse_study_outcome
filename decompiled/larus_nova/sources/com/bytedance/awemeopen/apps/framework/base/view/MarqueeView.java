package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import com.ss.android.lark.widget.codeblock.entity.LineContent;

/* JADX INFO: loaded from: classes14.dex */
public class MarqueeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextPaint f193180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint.FontMetrics f193181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f193182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f193183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f193184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f193185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f193186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f193187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f193188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f193189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f193190k;

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r100 = this.f193187h;
        if (r100 == 0) goto L5;
        return;
    L5:
        if (r100 == 2) goto L10;
        this.f193187h = 2;
        this.f193185f = 0.0f;
        this.f193188i = 0;
        invalidate();
        return;
    }

    public MarqueeView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (TextUtils.isEmpty(this.f193182c) == true) goto L36;
        float r100 = 0.0f;
        if (this.f193186g == 0.0f) goto L38;
        long r101 = SystemClock.uptimeMillis();
        long r102 = this.f193188i;
        if (r102 <= 0) goto L15;
        float r103 = ((r101 - r102) * ((long) this.f193183d)) / 1000.0f;
        float r104 = this.f193185f;
        if (this.f193189j == false) goto L12;
        int r105 = 1;
    L13:
        this.f193185f = (r104 + (r103 * r105)) % this.f193186g;
        goto L15
    L12:
        r105 = -1;
    L15:
        if (this.f193187h != 0) goto L17;
        this.f193188i = r101;
    L17:
        this.f193180a.getFontMetrics(this.f193181b);
        float r106 = getMeasuredWidth();
        float r107 = this.f193185f;
        if (this.f193189j == false) goto L20;
        int r108 = 1;
    L21:
        float r109 = r106 + (r107 * r108);
    L23:
        if (r100 >= r109) goto L30;
        String r111 = this.f193182c;
        float r112 = this.f193185f;
        if (this.f193189j == false) goto L27;
        int r113 = -1;
    L28:
        r110.drawText(r111, r112 + (r113 * r100), -this.f193181b.top, this.f193180a);
        r100 = r100 + this.f193186g;
        goto L23
    L27:
        r113 = 1;
        goto L28
    L30:
        if (this.f193187h != 0) goto L37;
        postInvalidateDelayed(this.f193184e);
        return;
    L37:
        return;
    L20:
        r108 = -1;
        goto L21
    L38:
        return;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        super.setOnClickListener(r100);
    }

    public void setSpeed(int r100) {
        this.f193183d = r100;
    }

    public void setText(String r100) {
        String r101 = r100 + LineContent.FOUR_SPACE;
        this.f193182c = r101;
        this.f193186g = this.f193180a.measureText(r101);
    L4:
        if (this.f193186g >= this.f193190k) goto L6;
        String r102 = this.f193182c + this.f193182c;
        this.f193182c = r102;
        this.f193186g = this.f193180a.measureText(r102);
        goto L4
    L6:
        this.f193185f = 0.0f;
        this.f193188i = 0;
        requestLayout();
    }

    public void setTextColor(int r100) {
        TextPaint r101 = this.f193180a;
        if (r101 == null) goto L6;
        r101.setColor(r100);
        return;
    }

    public void setTextShadow(int r100) {
        TextPaint r101 = this.f193180a;
        if (r101 == null) goto L6;
        r101.setShadowLayer(1.0f, 1.0f, 1.0f, r100);
        return;
    }

    public void setTextSize(int r100) {
        TextPaint r101 = this.f193180a;
        if (r101 == null) goto L6;
        r101.setTextSize(r100);
        this.f193180a.getFontMetrics(this.f193181b);
        return;
    }

    public void setText(int r100) {
        setText(getResources().getString(r100));
    }

    public MarqueeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f193180a.getFontMetrics(this.f193181b);
        boolean r102 = false;
        if (TextUtils.isEmpty(this.f193182c) == true) goto L5;
        int r103 = (int) this.f193180a.measureText(this.f193182c);
    L7:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        r102 = true;
    L9:
        this.f193189j = r102;
        Paint.FontMetrics r104 = this.f193181b;
        int r105 = (int) (r104.bottom - r104.top);
        if (View.MeasureSpec.getSize(r100) > r103) goto L13;
        r103 = View.MeasureSpec.getSize(r100);
    L13:
        setMeasuredDimension(r103, r105);
        return;
    L5:
        r103 = 0;
        goto L7
    }

    public MarqueeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193181b = new Paint.FontMetrics();
        this.f193183d = 25;
        this.f193184e = 16;
        this.f193190k = 0;
        TextPaint r103 = new TextPaint();
        this.f193180a = r103;
        r103.setAntiAlias(true);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.speed, R.attr.txt_color, R.attr.txt_shadow, R.attr.txt_size});
        this.f193183d = r104.getDimensionPixelSize(0, this.f193183d);
        int r105 = r104.getColor(1, 0);
        int r106 = r104.getDimensionPixelSize(3, 28);
        int r107 = r104.getColor(2, 0);
        r104.recycle();
        this.f193180a.setTextSize(r106);
        this.f193180a.setShadowLayer(1.0f, 1.0f, 1.0f, r107);
        this.f193180a.setColor(r105);
        this.f193187h = 2;
        this.f193190k = r100.getResources().getDimensionPixelSize(R.dimen.aos_common_feed_music_title_block_width);
    }
}
