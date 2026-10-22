package com.ss.android.lark.guide.ui.common.popup.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\nB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0014J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0019H\u0014J\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0012R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/ss/android/lark/guide/ui/common/popup/view/MaskView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mTargetRect", "Landroid/graphics/RectF;", "mOverlayRect", "mFullingPaint", "Landroid/graphics/Paint;", "mNeedHighlight", "", "mCorner", "mStyle", "mEraser", "mEraserBitmap", "Landroid/graphics/Bitmap;", "mEraserCanvas", "Landroid/graphics/Canvas;", "mInitHeight", "mChangedHeight", "mFirstFlag", "onDetachedFromWindow", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "setTargetRect", SVGRenderEngine.RECT, "Landroid/graphics/Rect;", "setFullingAlpha", "alpha", "setFullingColor", "color", "setHighlightTargetCorner", "corner", "setHighTargetGraphStyle", "style", "setTargetHighlight", "enable", "guide-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MaskView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f425774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f425775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f425776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f425777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f425778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f425779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f425780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f425781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Canvas f425782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f425783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f425784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f425785l;

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearFocus();     // Catch: Exception -> L5
        this.f425782i.setBitmap(null);     // Catch: Exception -> L5
        this.f425781h = null;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public MaskView(Context r100) {
        this(r100, null, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f425781h != null) goto L5;
        return;
    L5:
        int r101 = this.f425784k;
        if (r101 == 0) goto L8;
        this.f425774a.offset(0.0f, r101);
        this.f425783j += this.f425784k;
        this.f425784k = 0;
    L8:
        Bitmap r102 = this.f425781h;
        if (r102 == null) goto L11;
        r102.eraseColor(0);
    L11:
        this.f425782i.drawColor(this.f425776c.getColor());
        if (this.f425777d == false) goto L20;
        float r103 = this.f425778e;
        int r104 = this.f425779f;
        if (r104 != 0) goto L16;
        this.f425782i.drawCircle(this.f425774a.centerX(), this.f425774a.centerY(), this.f425774a.width() / 2, this.f425780g);
        goto L20
    L16:
        if (r104 == 1) goto L18;
        this.f425782i.drawRoundRect(this.f425774a, r103, r103, this.f425780g);
        goto L20
    L18:
        this.f425782i.drawRoundRect(this.f425774a, r103, r103, this.f425780g);
    L20:
        Bitmap r105 = this.f425781h;
        if (r105 == null) goto L24;
        RectF r106 = this.f425775b;
        r100.drawBitmap(r105, r106.left, r106.top, null);
        return;
    }

    public final void setFullingAlpha(int r100) {
        this.f425776c.setAlpha(r100);
    }

    public final void setFullingColor(int r100) {
        this.f425776c.setColor(r100);
    }

    public final void setHighTargetGraphStyle(int r100) {
        this.f425779f = r100;
    }

    public final void setHighlightTargetCorner(int r100) {
        this.f425778e = r100;
    }

    public final void setTargetHighlight(boolean r100) {
        this.f425777d = r100;
    }

    public final void setTargetRect(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        this.f425774a.set(r100);
    }

    public MaskView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = 0;
        if (this.f425785l == false) goto L5;
        this.f425783j = r103;
        this.f425785l = false;
    L5:
        int r105 = this.f425783j;
        if (r105 <= r103) goto L8;
    L7:
        r104 = r103 - r105;
    L10:
        this.f425784k = r104;
        setMeasuredDimension(r102, r103);
        this.f425775b.set(0.0f, 0.0f, r102, r103);
        return;
    L8:
        if (r105 >= r103) goto L10;
        goto L10
    }

    public MaskView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f425774a = new RectF();
        RectF r103 = new RectF();
        this.f425775b = r103;
        this.f425779f = 1;
        this.f425785l = true;
        setWillNotDraw(false);
        Object r104 = getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics r105 = new DisplayMetrics();
        ((WindowManager) r104).getDefaultDisplay().getRealMetrics(r105);
        int r106 = r105.widthPixels;
        int r107 = r105.heightPixels;
        r103.set(0.0f, 0.0f, r106, r107);
        this.f425781h = Bitmap.createBitmap(r106, r107, Bitmap.Config.ARGB_8888);
        Bitmap r108 = this.f425781h;
        Intrinsics.checkNotNull(r108);
        this.f425782i = new Canvas(r108);
        this.f425776c = new Paint();
        Paint r109 = new Paint();
        this.f425780g = r109;
        r109.setColor(-1);
        r109.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        r109.setFlags(1);
    }
}
