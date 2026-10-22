package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0014J\b\u0010 \u001a\u00020\u001aH\u0002JG\u0010!\u001a\u00020\u001a2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010'R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/RoundImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDrawRect", "Landroid/graphics/RectF;", "mPath", "Landroid/graphics/Path;", "mRadius", "", "mRadiusBottomLeft", "mRadiusBottomRight", "mRadiusChanged", "", "mRadiusTopLeft", "mRadiusTopRight", "strokeColor", "strokeWidth", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateClipPath", "updateRadius", "radius", "radiusTopLeft", "radiusTopRight", "radiusBottomLeft", "radiusBottomRight", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoundImageView extends AppCompatImageView {
    public Map<Integer, View> _$_findViewCache;
    private final RectF mDrawRect;
    private Path mPath;
    private float mRadius;
    private float mRadiusBottomLeft;
    private float mRadiusBottomRight;
    private boolean mRadiusChanged;
    private float mRadiusTopLeft;
    private float mRadiusTopRight;
    private final int strokeColor;
    private final float strokeWidth;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View _$_findCachedViewById(int r3) {
        Map<Integer, View> r0 = this._$_findViewCache;
        View r1 = r0.get(Integer.valueOf(r3));
        if (r1 != null) goto L9;
        View r2 = findViewById(r3);
        if (r2 == null) goto L7;
        r0.put(Integer.valueOf(r3), r2);
        return r2;
    L7:
        return null;
    L9:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateClipPath() {
        this.mPath.reset();
        this.mDrawRect.top = getPaddingTop();
        this.mDrawRect.left = getPaddingLeft();
        this.mDrawRect.right = getMeasuredWidth() - getPaddingRight();
        this.mDrawRect.bottom = getMeasuredHeight() - getPaddingBottom();
        float[] r1 = new float[8];
        int r2 = 0;
    L3:
        if (r2 >= 8) goto L20;
        if (r2 != 0) goto L6;
    L18:
        float r3 = this.mRadiusTopLeft;
    L19:
        r1[r2] = r3;
        r2 = r2 + 1;
        goto L3
    L6:
        if (r2 == 1) goto L18;
        if (r2 != 2) goto L10;
    L17:
        r3 = this.mRadiusTopRight;
        goto L19
    L10:
        if (r2 == 3) goto L17;
        if (r2 != 4) goto L14;
    L16:
        r3 = this.mRadiusBottomRight;
        goto L19
    L14:
        if (r2 == 5) goto L16;
        r3 = this.mRadiusBottomLeft;
        goto L19
    L20:
        this.mPath.addRoundRect(this.mDrawRect, r1, Path.Direction.CW);
    }

    public RoundImageView(Context r3) {
        this(r3, null, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r4) {
        if (r4 == null) goto L4;
        r4.clipPath(this.mPath);
    L4:
        super/*android.widget.ImageView*/.onDraw(r4);
        if (this.strokeWidth <= 0.0f) goto L10;
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.STROKE);
        r0.setColor(this.strokeColor);
        r0.setStrokeWidth(this.strokeWidth);
        if (r4 == null) goto L11;
        RectF r1 = this.mDrawRect;
        float r2 = this.mRadius;
        r4.drawRoundRect(r1, r2, r2, r0);
        return;
    L11:
        return;
    }

    public RoundImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r1, int r2) {
        super/*android.widget.ImageView*/.onMeasure(r1, r2);
        if (this.mRadiusChanged == false) goto L6;
        updateClipPath();
        return;
    }

    public RoundImageView(Context r3, AttributeSet r4, int r5) {
        this._$_findViewCache = new LinkedHashMap();
        Intrinsics.checkNotNull(r3);
        super(r3, r4, r5);
        this.mRadiusTopLeft = -1.0f;
        this.mRadiusTopRight = -1.0f;
        this.mRadiusBottomLeft = -1.0f;
        this.mRadiusBottomRight = -1.0f;
        this.mPath = new Path();
        float r0 = 0.0f;
        this.mDrawRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130973712, 2130973713, 2130973714, 2130973719, 2130973720, 2130974310, 2130974311});
        float r7 = r6.getDimension(0, 0.0f);
        this.mRadius = r7;
        if (r7 < 0.0f) goto L5;
        r0 = r7;
    L5:
        this.mRadius = r0;
        this.mRadiusTopLeft = r6.getDimension(3, r0);
        this.mRadiusTopRight = r6.getDimension(4, this.mRadius);
        this.mRadiusBottomLeft = r6.getDimension(1, this.mRadius);
        this.mRadiusBottomRight = r6.getDimension(2, this.mRadius);
        this.mRadiusChanged = true;
        this.strokeWidth = r6.getDimensionPixelSize(6, 0);
        this.strokeColor = r6.getColor(5, -1);
        r6.recycle();
    }

    public final void updateRadius(Float r7, Float r8, Float r9, Float r10, Float r11) {
        boolean r2 = false;
        if (r7 == null) goto L18;
        float r4 = r7.floatValue();
        if (r4 != this.mRadius) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == true) goto L16;
        r7 = null;
    L16:
        if (r7 == null) goto L18;
        float r12 = r7.floatValue();
        this.mRadius = r12;
        this.mRadiusTopLeft = r12;
        this.mRadiusTopRight = r12;
        this.mRadiusBottomLeft = r12;
        this.mRadiusBottomRight = r12;
        goto L18
    L10:
        if (r4 < 0.0f) goto L12;
        r6 = true;
        goto L13
    L7:
        r5 = false;
    L18:
        if (r8 == null) goto L33;
        float r13 = r8.floatValue();
        if (r13 != this.mRadiusTopLeft) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == false) goto L25;
    L27:
        boolean r15 = false;
    L28:
        if (r15 == true) goto L31;
        r8 = null;
    L31:
        if (r8 == null) goto L33;
        this.mRadiusTopLeft = r8.floatValue();
        goto L33
    L25:
        if (r13 < 0.0f) goto L27;
        r15 = true;
        goto L28
    L22:
        r14 = false;
    L33:
        if (r9 == null) goto L48;
        float r16 = r9.floatValue();
        if (r16 != this.mRadiusTopRight) goto L37;
        boolean r17 = true;
    L38:
        if (r17 == false) goto L40;
    L42:
        boolean r18 = false;
    L43:
        if (r18 == true) goto L46;
        r9 = null;
    L46:
        if (r9 == null) goto L48;
        this.mRadiusTopRight = r9.floatValue();
        goto L48
    L40:
        if (r16 < 0.0f) goto L42;
        r18 = true;
        goto L43
    L37:
        r17 = false;
    L48:
        if (r10 == null) goto L63;
        float r19 = r10.floatValue();
        if (r19 != this.mRadiusBottomLeft) goto L52;
        boolean r20 = true;
    L53:
        if (r20 == false) goto L55;
    L57:
        boolean r21 = false;
    L58:
        if (r21 == true) goto L61;
        r10 = null;
    L61:
        if (r10 == null) goto L63;
        this.mRadiusBottomLeft = r10.floatValue();
        goto L63
    L55:
        if (r19 < 0.0f) goto L57;
        r21 = true;
        goto L58
    L52:
        r20 = false;
    L63:
        if (r11 == null) goto L77;
        float r22 = r11.floatValue();
        if (r22 != this.mRadiusBottomRight) goto L67;
        boolean r23 = true;
    L68:
        if (r23 == false) goto L70;
    L72:
        if (r2 == true) goto L75;
        r11 = null;
    L75:
        if (r11 == null) goto L77;
        this.mRadiusBottomRight = r11.floatValue();
        goto L77
    L70:
        if (r22 < 0.0f) goto L72;
        r2 = true;
        goto L72
    L67:
        r23 = false;
    L77:
        this.mRadiusChanged = true;
    }

    public static /* synthetic */ void updateRadius$default(RoundImageView r1, Float r2, Float r3, Float r4, Float r5, Float r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        r1.updateRadius(r2, r3, r4, r5, r6);
    }
}
