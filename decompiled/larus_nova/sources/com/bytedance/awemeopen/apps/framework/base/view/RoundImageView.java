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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0014J\b\u0010 \u001a\u00020\u001aH\u0002JG\u0010!\u001a\u00020\u001a2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010'R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/RoundImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDrawRect", "Landroid/graphics/RectF;", "mPath", "Landroid/graphics/Path;", "mRadius", "", "mRadiusBottomLeft", "mRadiusBottomRight", "mRadiusChanged", "", "mRadiusTopLeft", "mRadiusTopRight", "strokeColor", "strokeWidth", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateClipPath", "updateRadius", "radius", "radiusTopLeft", "radiusTopRight", "radiusBottomLeft", "radiusBottomRight", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public View _$_findCachedViewById(int r100) {
        Map<Integer, View> r101 = this._$_findViewCache;
        View r102 = r101.get(Integer.valueOf(r100));
        if (r102 != null) goto L9;
        View r103 = findViewById(r100);
        if (r103 == null) goto L7;
        r101.put(Integer.valueOf(r100), r103);
        return r103;
    L7:
        return null;
    L9:
        return r102;
    }

    private final void updateClipPath() {
        this.mPath.reset();
        this.mDrawRect.top = getPaddingTop();
        this.mDrawRect.left = getPaddingLeft();
        this.mDrawRect.right = getMeasuredWidth() - getPaddingRight();
        this.mDrawRect.bottom = getMeasuredHeight() - getPaddingBottom();
        float[] r100 = new float[8];
        int r101 = 0;
    L3:
        if (r101 >= 8) goto L20;
        if (r101 != 0) goto L6;
    L18:
        float r102 = this.mRadiusTopLeft;
    L19:
        r100[r101] = r102;
        r101 = r101 + 1;
        goto L3
    L6:
        if (r101 == 1) goto L18;
        if (r101 != 2) goto L10;
    L17:
        r102 = this.mRadiusTopRight;
        goto L19
    L10:
        if (r101 == 3) goto L17;
        if (r101 != 4) goto L14;
    L16:
        r102 = this.mRadiusBottomRight;
        goto L19
    L14:
        if (r101 == 5) goto L16;
        r102 = this.mRadiusBottomLeft;
        goto L19
    L20:
        this.mPath.addRoundRect(this.mDrawRect, r100, Path.Direction.CW);
    }

    public RoundImageView(Context r100) {
        this(r100, null, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        if (r100 == null) goto L4;
        r100.clipPath(this.mPath);
    L4:
        super.onDraw(r100);
        if (this.strokeWidth <= 0.0f) goto L10;
        Paint r101 = new Paint(1);
        r101.setStyle(Paint.Style.STROKE);
        r101.setColor(this.strokeColor);
        r101.setStrokeWidth(this.strokeWidth);
        if (r100 == null) goto L11;
        RectF r102 = this.mDrawRect;
        float r103 = this.mRadius;
        r100.drawRoundRect(r102, r103, r103, r101);
        return;
    L11:
        return;
    }

    public RoundImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 9);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.mRadiusChanged == false) goto L6;
        updateClipPath();
        return;
    }

    public RoundImageView(Context r100, AttributeSet r101, int r102) {
        this._$_findViewCache = new LinkedHashMap();
        Intrinsics.checkNotNull(r100);
        super(r100, r101, r102);
        this.mRadiusTopLeft = -1.0f;
        this.mRadiusTopRight = -1.0f;
        this.mRadiusBottomLeft = -1.0f;
        this.mRadiusBottomRight = -1.0f;
        this.mPath = new Path();
        float r103 = 0.0f;
        this.mDrawRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.radius, R.attr.radiusBottomLeft, R.attr.radiusBottomRight, R.attr.radiusTopLeft, R.attr.radiusTopRight, R.attr.strokeColor, R.attr.strokeWidth});
        float r105 = r104.getDimension(0, 0.0f);
        this.mRadius = r105;
        if (r105 < 0.0f) goto L5;
        r103 = r105;
    L5:
        this.mRadius = r103;
        this.mRadiusTopLeft = r104.getDimension(3, r103);
        this.mRadiusTopRight = r104.getDimension(4, this.mRadius);
        this.mRadiusBottomLeft = r104.getDimension(1, this.mRadius);
        this.mRadiusBottomRight = r104.getDimension(2, this.mRadius);
        this.mRadiusChanged = true;
        this.strokeWidth = r104.getDimensionPixelSize(6, 0);
        this.strokeColor = r104.getColor(5, -1);
        r104.recycle();
    }

    public final void updateRadius(Float r100, Float r101, Float r102, Float r110, Float r111) {
        boolean r103 = false;
        if (r100 == null) goto L18;
        float r104 = r100.floatValue();
        if (r104 != this.mRadius) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == true) goto L16;
        r100 = null;
    L16:
        if (r100 == null) goto L18;
        float r107 = r100.floatValue();
        this.mRadius = r107;
        this.mRadiusTopLeft = r107;
        this.mRadiusTopRight = r107;
        this.mRadiusBottomLeft = r107;
        this.mRadiusBottomRight = r107;
        goto L18
    L10:
        if (r104 < 0.0f) goto L12;
        r106 = true;
        goto L13
    L7:
        r105 = false;
    L18:
        if (r101 == null) goto L33;
        float r108 = r101.floatValue();
        if (r108 != this.mRadiusTopLeft) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == false) goto L25;
    L27:
        boolean r112 = false;
    L28:
        if (r112 == true) goto L31;
        r101 = null;
    L31:
        if (r101 == null) goto L33;
        this.mRadiusTopLeft = r101.floatValue();
        goto L33
    L25:
        if (r108 < 0.0f) goto L27;
        r112 = true;
        goto L28
    L22:
        r109 = false;
    L33:
        if (r102 == null) goto L48;
        float r113 = r102.floatValue();
        if (r113 != this.mRadiusTopRight) goto L37;
        boolean r114 = true;
    L38:
        if (r114 == false) goto L40;
    L42:
        boolean r115 = false;
    L43:
        if (r115 == true) goto L46;
        r102 = null;
    L46:
        if (r102 == null) goto L48;
        this.mRadiusTopRight = r102.floatValue();
        goto L48
    L40:
        if (r113 < 0.0f) goto L42;
        r115 = true;
        goto L43
    L37:
        r114 = false;
    L48:
        if (r110 == null) goto L63;
        float r116 = r110.floatValue();
        if (r116 != this.mRadiusBottomLeft) goto L52;
        boolean r117 = true;
    L53:
        if (r117 == false) goto L55;
    L57:
        boolean r118 = false;
    L58:
        if (r118 == true) goto L61;
        r110 = null;
    L61:
        if (r110 == null) goto L63;
        this.mRadiusBottomLeft = r110.floatValue();
        goto L63
    L55:
        if (r116 < 0.0f) goto L57;
        r118 = true;
        goto L58
    L52:
        r117 = false;
    L63:
        if (r111 == null) goto L77;
        float r119 = r111.floatValue();
        if (r119 != this.mRadiusBottomRight) goto L67;
        boolean r120 = true;
    L68:
        if (r120 == false) goto L70;
    L72:
        if (r103 == true) goto L75;
        r111 = null;
    L75:
        if (r111 == null) goto L77;
        this.mRadiusBottomRight = r111.floatValue();
        goto L77
    L70:
        if (r119 < 0.0f) goto L72;
        r103 = true;
        goto L72
    L67:
        r120 = false;
    L77:
        this.mRadiusChanged = true;
    }

    public static /* synthetic */ void updateRadius$default(RoundImageView r100, Float r101, Float r102, Float r103, Float r104, Float r105, int r106, Object r107) {
        if ((r106 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r103 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r104 = null;
    L15:
        if ((r106 & 16) == 0) goto L17;
        r105 = null;
    L17:
        r100.updateRadius(r101, r102, r103, r104, r105);
    }
}
