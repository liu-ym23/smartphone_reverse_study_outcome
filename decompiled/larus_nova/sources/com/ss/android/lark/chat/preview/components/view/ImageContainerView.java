package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.byted.cast.common.CastMonitor;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0013J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0014J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010&\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010'\u001a\u00020\u0018H\u0002J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\bH\u0016J0\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bH\u0014J\b\u00100\u001a\u00020\u0018H\u0002J\b\u00101\u001a\u00020\u0018H\u0014J\u0018\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0016J\u0010\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u000208H\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/ImageContainerView;", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "Landroid/graphics/drawable/Drawable$Callback;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageDrawable", "Landroid/graphics/drawable/Drawable;", "imageMatrix", "Landroid/graphics/Matrix;", "imageDrawMatrix", "imageWidth", "imageHeight", "imageScaleType", "Landroid/widget/ImageView$ScaleType;", "tempSrc", "Landroid/graphics/RectF;", "tempDst", "setImageDrawable", "", "drawable", "setScaleType", "scaleType", "verifyDrawable", "", "who", "jumpDrawablesToCurrentState", "invalidateDrawable", "hasOverlappingRendering", "setSelected", "selected", "setImageMatrix", "matrix", "updateDrawable", "resizeFromDrawable", "onRtlPropertiesChanged", "layoutDirection", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "configureBounds", "drawableStateChanged", "drawableHotspotChanged", "x", "", "y", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageContainerView extends LKUIRoundableLayout implements Drawable.Callback {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f416123r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Matrix f416124s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Matrix f416125t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f416126u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f416127v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ImageView.ScaleType f416128w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RectF f416129x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f416130y;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f416131a = null;

        static {
            int[] r100 = new int[ImageView.ScaleType.values().length];
            r100[ImageView.ScaleType.FIT_XY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ImageView.ScaleType.FIT_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ImageView.ScaleType.FIT_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f416131a = r100;
        }
    }

    static {
    }

    public ImageContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ImageContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void f() {
        Drawable r100 = this.f416123r;
        if (r100 != null) goto L5;
        return;
    L5:
        ImageView.ScaleType r101 = this.f416128w;
        int r102 = this.f416126u;
        int r103 = this.f416127v;
        int r104 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r105 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (r102 < 0) goto L8;
        if (r104 == r102) goto L8;
    L11:
        boolean r106 = false;
    L13:
        Matrix.ScaleToFit r107 = null;
        Matrix r108 = null;
        if (r102 <= 0) goto L62;
        if (r103 <= 0) goto L62;
        if (ImageView.ScaleType.FIT_XY == r101) goto L62;
        r100.setBounds(0, 0, r102, r103);
        if (ImageView.ScaleType.MATRIX == r101) goto L22;
        if (r106 == false) goto L29;
        this.f416125t = null;
        return;
    L29:
        if (ImageView.ScaleType.CENTER != r101) goto L31;
        Matrix r109 = this.f416124s;
        r109.setTranslate(Math.round((r104 - r102) * 0.5f), Math.round((r105 - r103) * 0.5f));
        this.f416125t = r109;
        return;
    L31:
        float r110 = 0.0f;
        if (ImageView.ScaleType.CENTER_CROP != r101) goto L39;
        Matrix r111 = this.f416124s;
        if ((r102 * r105) <= (r104 * r103)) goto L36;
        float r112 = r105 / r103;
        r110 = (r104 - (r102 * r112)) * 0.5f;
        float r113 = 0.0f;
    L37:
        r111.setScale(r112, r112);
        r111.postTranslate(Math.round(r110), Math.round(r113));
        this.f416125t = r111;
        return;
    L36:
        r112 = r104 / r102;
        r113 = (r105 - (r103 * r112)) * 0.5f;
        goto L37
    L39:
        if (ImageView.ScaleType.CENTER_INSIDE != this.f416128w) goto L46;
        Matrix r114 = this.f416124s;
        if (r102 > r104) goto L44;
        if (r103 > r105) goto L44;
        float r115 = 1.0f;
    L45:
        float r116 = Math.round((r104 - (r102 * r115)) * 0.5f);
        float r117 = Math.round((r105 - (r103 * r115)) * 0.5f);
        r114.setScale(r115, r115);
        r114.postTranslate(r116, r117);
        this.f416125t = r114;
        return;
    L44:
        r115 = (float) Math.min(r104 / r102, r105 / r103);
        goto L45
    L46:
        Matrix r118 = this.f416124s;
        int r119 = b.f416131a[r101.ordinal()];
        if (r119 != 1) goto L49;
        r107 = Matrix.ScaleToFit.FILL;
    L59:
        if (r107 == null) goto L61;
        this.f416129x.set(0.0f, 0.0f, r102, r103);
        this.f416130y.set(0.0f, 0.0f, r104, r105);
        r118.setRectToRect(this.f416129x, this.f416130y, r107);
    L61:
        this.f416125t = r118;
        return;
    L49:
        if (r119 != 2) goto L51;
        r107 = Matrix.ScaleToFit.START;
        goto L59
    L51:
        if (r119 != 3) goto L53;
        r107 = Matrix.ScaleToFit.CENTER;
        goto L59
    L53:
        if (r119 != 4) goto L59;
        r107 = Matrix.ScaleToFit.END;
        goto L59
    L22:
        if (this.f416124s.isIdentity() == true) goto L25;
        r108 = this.f416124s;
    L25:
        this.f416125t = r108;
        return;
    L62:
        r100.setBounds(0, 0, r104, r105);
        this.f416125t = null;
        return;
    L8:
        if (r103 < 0) goto L12;
        if (r105 != r103) goto L11;
    L12:
        r106 = true;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.f416123r;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isStateful() == true) goto L7;
        return;
    L7:
        if (r100.setState(getDrawableState()) == false) goto L12;
        invalidateDrawable(r100);
        return;
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        Drawable r100 = getBackground();
        if (r100 == null) goto L5;
        Drawable r101 = r100.getCurrent();
    L6:
        if (r101 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r100 = this.f416123r;
        if (r100 == null) goto L6;
        r100.jumpToCurrentState();
        return;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        if (r100 != this.f416123r) goto L11;
        int r101 = r100.getIntrinsicWidth();
        int r102 = r100.getIntrinsicHeight();
        if (r101 == this.f416126u) goto L7;
    L8:
        this.f416126u = r101;
        this.f416127v = r102;
        f();
    L9:
        invalidate();
        return;
    L7:
        if (r102 == this.f416127v) goto L9;
    L11:
        super.invalidateDrawable(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Drawable r101 = this.f416123r;
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = this.f416126u;
        int r103 = this.f416127v;
        if (r102 == 0) goto L27;
        if (r103 != 0) goto L10;
        return;
    L10:
        if (this.f416125t == null) goto L12;
    L17:
        int r104 = r100.save();
        r100.translate(getPaddingLeft(), getPaddingTop());     // Catch: Throwable -> L24
        Matrix r105 = this.f416125t;     // Catch: Throwable -> L24
        if (r105 == null) goto L21;
        r100.concat(r105);     // Catch: Throwable -> L24
    L21:
        r101.draw(r100);     // Catch: Throwable -> L24
        r100.restoreToCount(r104);
        return;
    L24:
        th = move-exception;
        r100.restoreToCount(r104);
        throw th;
    L12:
        if (getPaddingTop() != 0) goto L17;
        if (getPaddingLeft() != 0) goto L17;
        r101.draw(r100);
        return;
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int r100) {
        super.onRtlPropertiesChanged(r100);
        Drawable r101 = this.f416123r;
        if (r101 == null) goto L6;
        DrawableCompat.setLayoutDirection(r101, r100);
        return;
    }

    public final void setImageDrawable(Drawable r100) {
        Drawable r101 = this.f416123r;
        if (r101 != r100) goto L5;
        return;
    L5:
        int r102 = this.f416126u;
        int r103 = this.f416127v;
        if (r101 == null) goto L8;
        r101.setCallback(null);
        unscheduleDrawable(r101);
    L8:
        this.f416123r = r100;
        if (r100 == null) goto L14;
        r100.setCallback(this);
        DrawableCompat.setLayoutDirection(r100, getLayoutDirection());
        if (r100.isStateful() == false) goto L13;
        r100.setState(getDrawableState());
    L13:
        this.f416126u = r100.getIntrinsicWidth();
        this.f416127v = r100.getIntrinsicHeight();
        f();
    L16:
        if (r102 == this.f416126u) goto L18;
    L19:
        requestLayout();
    L20:
        invalidate();
        return;
    L18:
        if (r103 == this.f416127v) goto L20;
    L14:
        this.f416127v = -1;
        this.f416126u = -1;
        goto L16
    }

    public final void setImageMatrix(Matrix r100) {
        if (r100 != null) goto L4;
    L6:
        if (r100 == null) goto L8;
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(this.f416124s, r100) == true) goto L15;
    L12:
        this.f416124s.set(r100);
        f();
        invalidate();
        return;
    L15:
        return;
    L8:
        if (this.f416124s.isIdentity() == false) goto L12;
    L4:
        if (r100.isIdentity() == false) goto L6;
        r100 = null;
        goto L6
    }

    public final void setScaleType(ImageView.ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "scaleType");
        if (this.f416128w != r100) goto L5;
        return;
    L5:
        this.f416128w = r100;
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        Drawable r101 = this.f416123r;
        if (r101 == null) goto L16;
        int r102 = r101.getIntrinsicWidth();
        if (r102 >= 0) goto L7;
        r102 = this.f416126u;
    L7:
        int r103 = r101.getIntrinsicHeight();
        if (r103 >= 0) goto L11;
        r103 = this.f416127v;
    L11:
        if (r102 == this.f416126u) goto L13;
    L14:
        this.f416126u = r102;
        this.f416127v = r103;
        requestLayout();
        return;
    L13:
        if (r103 != this.f416127v) goto L14;
        return;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (r100 != this.f416123r) goto L5;
    L8:
        return true;
    L5:
        if (super.verifyDrawable(r100) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public final void drawableHotspotChanged(float r100, float r101) {
        super.drawableHotspotChanged(r100, r101);
        Drawable r102 = this.f416123r;
        if (r102 == null) goto L6;
        r102.setHotspot(r100, r101);
        return;
    }

    public ImageContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f416124s = new Matrix();
        this.f416128w = ImageView.ScaleType.FIT_CENTER;
        this.f416129x = new RectF();
        this.f416130y = new RectF();
        setWillNotDraw(false);
    }

    public /* synthetic */ ImageContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        f();
    }
}
