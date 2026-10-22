package com.larus.uaigc.createpage.bussiness.remove.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/widget/GesturePaletteView;", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "midPntX", "", "midPntY", "touchingPointList", "", "Landroid/graphics/PointF;", "circlePaint", "Landroid/graphics/Paint;", "gestureDetector", "Landroid/view/GestureDetector;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "updateTouchingPoints", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GesturePaletteView extends PaletteView {
    public float V0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public float f371492b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final List<PointF> f371493g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final GestureDetector f371494h1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final ScaleGestureDetector f371495k1;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GesturePaletteView f371496a;

        public a(GesturePaletteView r100) {
            this.f371496a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            if (r101.getPointerCount() <= 1) goto L6;
            this.f371496a.setInDrawingPath(false);
            this.f371496a.p(-r102, -r103);
            return true;
        L6:
            return false;
        }
    }

    public static final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GesturePaletteView f371497a;

        public b(GesturePaletteView r100) {
            this.f371497a = r100;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
            this.f371497a.setInDrawingPath(false);
            GesturePaletteView r101 = this.f371497a;
            float r102 = r100.getScaleFactor();
            GesturePaletteView r103 = this.f371497a;
            r101.o(r102, r103.V0, r103.f371492b1);
            return true;
        }
    }

    public GesturePaletteView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GesturePaletteView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.uaigc.createpage.bussiness.remove.widget.PaletteView, android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
    }

    @Override // com.larus.uaigc.createpage.bussiness.remove.widget.PaletteView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return false;
    L5:
        ((ArrayList) this.f371493g1).clear();
        if (r100.getActionMasked() != 0) goto L9;
        s();
    L9:
        if (r100.getPointerCount() <= 1) goto L11;
        float r102 = 2;
        this.V0 = (r100.getX(0) + r100.getX(1)) / r102;
        this.f371492b1 = (r100.getY(0) + r100.getY(1)) / r102;
    L11:
        this.f371494h1.onTouchEvent(r100);
        this.f371495k1.onTouchEvent(r100);
        if (r100.getActionMasked() != 1) goto L14;
    L15:
        setImageToWrapCropBounds(true);
        invalidate();
    L17:
        if (this.f371495k1.isInProgress() == false) goto L19;
    L23:
        setSingleTouchingPoint(null);
        ((ArrayList) this.f371493g1).clear();
        if (r100.getPointerCount() != 2) goto L28;
        int r103 = r100.getPointerCount();
    L26:
        if (r101 >= r103) goto L28;
        ((ArrayList) this.f371493g1).add(new PointF(r100.getX(r101), r100.getY(r101)));
        r101 = r101 + 1;
    L28:
        invalidate();
        return true;
    L19:
        if (r100.getPointerCount() > 1) goto L23;
        return super.onTouchEvent(r100);
    L14:
        if (r100.getActionMasked() != 3) goto L17;
        goto L15
    }

    public GesturePaletteView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f371493g1 = new ArrayList();
        Paint r103 = new Paint();
        r103.setStyle(Paint.Style.FILL);
        r103.setColor(ColorProtector.parseColor("#BFCCCCCC"));
        r103.setAntiAlias(true);
        this.f371494h1 = new GestureDetector(r100, new a(this));
        this.f371495k1 = new ScaleGestureDetector(r100, new b(this));
    }

    public /* synthetic */ GesturePaletteView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
