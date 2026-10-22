package com.larus.bmhome.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 62\u00020\u0001:\u00016B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J(\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0014J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020#H\u0014J\u000e\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\nJ\b\u00101\u001a\u00020#H\u0002J\u0010\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\nH\u0002J\b\u00104\u001a\u00020\nH\u0002J\b\u00105\u001a\u00020#H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/bmhome/view/ShadowChatConstraintLayout;", "Lcom/larus/bmhome/view/ChatConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shadowPaint", "Landroid/graphics/Paint;", "shadowBitmapPaint", "shadowClearPaint", "shadowRect", "Landroid/graphics/RectF;", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "topShadowRect", "topShadowPath", "cornerRadii", "", "shadowBitmap", "Landroid/graphics/Bitmap;", "cachedShadowColor", "shadowBitmapDirty", "", "outwardShadowAlpha", "topCornerRadiusPx", "shadowBlurRadiusPx", "shadowBitmapTopPaddingPx", "topShadowContentHeightPx", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "setOutwardShadowAlpha", "alpha", "updateShadowPath", "ensureShadowBitmap", "shadowColor", "resolveShadowFillColor", "recycleShadowBitmap", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShadowChatConstraintLayout extends ChatConstraintLayout {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f315599k0 = 0;
    public final Paint I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Paint f315600J;
    public final Paint K;
    public final RectF L;
    public final Path M;
    public final RectF N;
    public final Path O;
    public final float[] P;
    public Bitmap Q;
    public int R;
    public boolean S;
    public int T;
    public final int U;
    public final int V;
    public final int W;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.view.ChatConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Bitmap r100 = this.Q;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        this.Q = null;
        super.onDetachedFromWindow();
    }

    public ShadowChatConstraintLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Paint r101 = new Paint(1);
        r101.setStyle(Paint.Style.FILL);
        this.I = r101;
        Paint r102 = new Paint(1);
        r102.setFilterBitmap(true);
        this.f315600J = r102;
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.FILL);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.K = r103;
        this.L = new RectF();
        this.M = new Path();
        this.N = new RectF();
        this.O = new Path();
        this.P = new float[]{c7.b(24), c7.b(24), c7.b(24), c7.b(24), 0.0f, 0.0f, 0.0f, 0.0f};
        this.S = true;
        this.T = 255;
        int r104 = c7.b(24);
        int r105 = c7.b(8);
        this.U = r105;
        this.V = Math.max(c7.b(8), r105 + c7.b(1));
        this.W = r104 + c7.b(1);
        setWillNotDraw(false);
        setBackgroundColor(0);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_base_1, getContext(), R.color.larus_base_1));
        if (getWidth() > 0) goto L5;
    L18:
        Bitmap r102 = this.Q;
        if (r102 == null) goto L21;
        this.f315600J.setAlpha(this.T);
        r100.drawBitmap(r102, 0.0f, -this.V, this.f315600J);
    L21:
        int r103 = r100.save();
        r100.clipPath(this.M);
        super.draw(r100);
        r100.restoreToCount(r103);
        return;
    L5:
        if (getHeight() <= 0) goto L18;
        if (this.S == false) goto L10;
    L14:
        Bitmap r104 = this.Q;
        if (r104 == null) goto L17;
        r104.recycle();
    L17:
        this.Q = null;
        Bitmap r105 = Bitmap.createBitmap(getWidth(), this.V + Math.min(getHeight(), this.W), Bitmap.Config.ARGB_8888);
        Canvas r106 = new Canvas(r105);
        r106.translate(0.0f, this.V);
        this.I.setColor(r101);
        this.I.setShadowLayer(this.U, 0.0f, 0.0f, Color.argb(26, 0, 0, 0));
        r106.drawPath(this.O, this.I);
        this.I.clearShadowLayer();
        r106.drawPath(this.O, this.K);
        this.Q = r105;
        this.R = r101;
        this.S = false;
        goto L18
    L10:
        if (this.Q == null) goto L14;
        if (this.R != r101) goto L14;
        goto L14
    }

    @Override // com.larus.bmhome.view.ChatConstraintLayout, android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.S = true;
    }

    public final void setOutwardShadowAlpha(int r100) {
        int r101 = RangesKt.coerceIn(r100, 0, 255);
        if (this.T != r101) goto L5;
        return;
    L5:
        this.T = r101;
        invalidate();
    }

    public ShadowChatConstraintLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        Paint r102 = new Paint(1);
        r102.setStyle(Paint.Style.FILL);
        this.I = r102;
        Paint r103 = new Paint(1);
        r103.setFilterBitmap(true);
        this.f315600J = r103;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.FILL);
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.K = r104;
        this.L = new RectF();
        this.M = new Path();
        this.N = new RectF();
        this.O = new Path();
        this.P = new float[]{c7.b(24), c7.b(24), c7.b(24), c7.b(24), 0.0f, 0.0f, 0.0f, 0.0f};
        this.S = true;
        this.T = 255;
        int r105 = c7.b(24);
        int r106 = c7.b(8);
        this.U = r106;
        this.V = Math.max(c7.b(8), r106 + c7.b(1));
        this.W = r105 + c7.b(1);
        setWillNotDraw(false);
        setBackgroundColor(0);
    }

    public ShadowChatConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.FILL);
        this.I = r103;
        Paint r104 = new Paint(1);
        r104.setFilterBitmap(true);
        this.f315600J = r104;
        Paint r105 = new Paint(1);
        r105.setStyle(Paint.Style.FILL);
        r105.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.K = r105;
        this.L = new RectF();
        this.M = new Path();
        this.N = new RectF();
        this.O = new Path();
        this.P = new float[]{c7.b(24), c7.b(24), c7.b(24), c7.b(24), 0.0f, 0.0f, 0.0f, 0.0f};
        this.S = true;
        this.T = 255;
        int r106 = c7.b(24);
        int r107 = c7.b(8);
        this.U = r107;
        this.V = Math.max(c7.b(8), r107 + c7.b(1));
        this.W = r106 + c7.b(1);
        setWillNotDraw(false);
        setBackgroundColor(0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.L.set(c7.b(2), c7.b(1), getWidth() - c7.b(2), getHeight());
        this.M.reset();
        this.M.addRoundRect(this.L, this.P, Path.Direction.CW);
        RectF r104 = this.N;
        RectF r105 = this.L;
        float r106 = r105.left;
        float r107 = r105.top;
        r104.set(r106, r107, r105.right, Math.min(r105.bottom, this.W + r107));
        this.O.reset();
        this.O.addRoundRect(this.N, this.P, Path.Direction.CW);
        this.S = true;
    }
}
