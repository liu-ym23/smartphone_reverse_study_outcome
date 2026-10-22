package com.larus.uaigc.createpage.bussiness.remove.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import v19.c7;
import vqc.f;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0003cdeB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020BH\u0016J\b\u0010D\u001a\u00020BH\u0016J\u0010\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020\u0016H\u0016J\b\u0010G\u001a\u000203H\u0016J\u0010\u0010H\u001a\u00020B2\u0006\u0010I\u001a\u00020\bH\u0016J\u001a\u0010J\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010KH\u0016J\u0012\u0010L\u001a\u00020B2\b\u0010M\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010N\u001a\u00020B2\u0006\u0010O\u001a\u00020\"H\u0014J\u0012\u0010P\u001a\u00020\r2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J \u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\u0016H\u0016J\u0018\u0010W\u001a\u00020B2\u0006\u0010X\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u0016H\u0016J\u0012\u0010Z\u001a\u00020B2\b\u0010[\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010\\\u001a\u00020B2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010]\u001a\u00020BH\u0002J\b\u0010^\u001a\u00020BH\u0002J\b\u0010_\u001a\u00020BH\u0002J\b\u0010`\u001a\u00020BH\u0002J\b\u0010b\u001a\u00020BH\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u000108X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0012\u0010=\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteView;", "Lcom/yalantis/ucrop/view/CropImageView;", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/IPaletteViewAbility;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_enableUndo", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "enableUndo", "Lkotlinx/coroutines/flow/StateFlow;", "getEnableUndo", "()Lkotlinx/coroutines/flow/StateFlow;", "_enableRedo", "enableRedo", "getEnableRedo", "initPenSize", "", "initPenColor", "paint", "Landroid/graphics/Paint;", "maskPaint", "curPath", "Landroid/graphics/Path;", "lastX", "lastY", "bufferBitmap", "Landroid/graphics/Bitmap;", "bufferCanvas", "Landroid/graphics/Canvas;", "bufferMatrix", "Landroid/graphics/Matrix;", "bufferInverseMatrix", "needDrawMask", "maskBitmap", "maskCanvas", "undoList", "", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteView$DrawingInfo;", "redoList", "inDrawingPath", "getInDrawingPath", "()Z", "setInDrawingPath", "(Z)V", "viewBitmapRect", "Landroid/graphics/RectF;", "canDrawPathRect", "hasPathInBitmapRect", "ringPaint", "singleTouchingPoint", "Landroid/graphics/PointF;", "getSingleTouchingPoint", "()Landroid/graphics/PointF;", "setSingleTouchingPoint", "(Landroid/graphics/PointF;)V", "penSizeAWaitNextTouch", "Ljava/lang/Float;", "initialBitmapCorners", "", "redo", "", "undo", "clear", "setPenPxSize", "size", "getCurBitmapRect", "setPenColor", "color", "getMaskBitmap", "Lkotlin/Pair;", "setImageBitmap", SimplayerImageStrategy.RESULT_BITMAP, "onDraw", "canvas", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "postScale", "deltaScale", GXTemplateKey.GAIAX_PX, "py", "postTranslate", "deltaX", "deltaY", "setImageMatrix", "matrix", "updateTouchingPoint", "updateCanDrawPathRect", "redrawOnBufferCanvas", "saveDrawingPath", "checkUnRedo", "curBufferScale", "initBuffer", "DrawingInfo", "PathDrawingInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PaletteView extends CropImageView {
    public final StateFlowImpl B;
    public final b1 C;
    public final StateFlowImpl D;
    public final b1 E;
    public final Paint F;
    public final Paint G;
    public final Path H;
    public Float H0;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f371515J;
    public Bitmap K;
    public Canvas L;
    public float[] L0;
    public final Matrix M;
    public final Matrix N;
    public final boolean O;
    public Bitmap P;
    public float P0;
    public Canvas Q;
    public final List<b> R;
    public final List<b> S;
    public boolean T;
    public RectF U;
    public RectF V;
    public boolean W;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Paint f371516k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public PointF f371517p0;

    public static final class a {
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f371518a;

        public abstract void a(Canvas r100);

        public b(Paint r100) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            this.f371518a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f371519b;

        @Override // com.larus.uaigc.createpage.bussiness.remove.widget.PaletteView.b
        public final void a(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            r100.drawPath(this.f371519b, this.f371518a);
        }

        public c(Path r100, Paint r101) {
            Intrinsics.checkNotNullParameter(r100, "path");
            Intrinsics.checkNotNullParameter(r101, "paint");
            super(r101);
            this.f371519b = r100;
        }
    }

    static {
    }

    public PaletteView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PaletteView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void A() {
        float r100 = this.F.getStrokeWidth() / 2;
        RectF r101 = this.U;
        this.V = new RectF(r101.left - r100, r101.top - r100, r101.right + r100, r101.bottom + r100);
    }

    public RectF getCurBitmapRect() {
        return f.b(this.f464500a);
    }

    public Pair<Bitmap, Bitmap> getMaskBitmap() {
        Bitmap r100 = this.K;
        Object r101 = null;
        if (r100 == null) goto L30;
        Bitmap r102 = getViewBitmap();
        if (r102 == null) goto L31;
        RectF r103 = f.b(this.L0);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        int r105 = RangesKt.coerceAtLeast(0, (int) r103.left);     // Catch: Throwable -> L17
        int r106 = RangesKt.coerceAtLeast(0, (int) r103.top);     // Catch: Throwable -> L17
        int r107 = RangesKt.coerceAtMost((int) (((double) r103.width()) + 0.5d), r100.getWidth() - r105);     // Catch: Throwable -> L17
        int r108 = RangesKt.coerceAtMost((int) (((double) r103.height()) + 0.5d), r100.getHeight() - r106);     // Catch: Throwable -> L17
        Bitmap r109 = Bitmap.createBitmap(r100, r105, r106, r107, r108);     // Catch: Throwable -> L17
        Bitmap r110 = this.P;     // Catch: Throwable -> L17
        if (r110 == null) goto L10;
        Bitmap r111 = Bitmap.createBitmap(r110, r105, r106, r107, r108);     // Catch: Throwable -> L17
    L11:
        Bitmap r112 = Bitmap.createScaledBitmap(r109, r102.getWidth(), r102.getHeight(), true);     // Catch: Throwable -> L17
        if (r111 == null) goto L14;
        Bitmap r113 = Bitmap.createScaledBitmap(r111, r102.getWidth(), r102.getHeight(), true);     // Catch: Throwable -> L17
    L15:
        Object r114 = Result.m9449constructorimpl(TuplesKt.to(r112, r113));     // Catch: Throwable -> L17
    L19:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L23;
        FLogger.f375446a.e("PaletteView", "getMaskBitmap failed", r115);
    L23:
        if (Result.m9455isFailureimpl(r114) == true) goto L27;
        r101 = r114;
    L27:
        return (Pair) r101;
    L14:
        r113 = null;
        goto L15
    L10:
        r111 = null;
    L17:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L31:
        return null;
    L30:
        return null;
    }

    public final void y() {
        this.B.setValue(Boolean.valueOf(!((ArrayList) this.R).isEmpty()));
        this.D.setValue(Boolean.valueOf(!((ArrayList) this.S).isEmpty()));
    }

    public final void z() {
        Canvas r100 = this.L;
        if (r100 == null) goto L20;
        r100.drawColor(0, PorterDuff.Mode.CLEAR);
        Canvas r101 = this.Q;
        if (r101 == null) goto L7;
        r101.drawColor(-16777216, PorterDuff.Mode.CLEAR);
    L7:
        Iterator<T> r102 = this.R.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        b r103 = (b) r102.next();
        r103.a(r100);
        Canvas r104 = this.Q;
        if (r104 == null) goto L9;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.larus.uaigc.createpage.bussiness.remove.widget.PaletteView.PathDrawingInfo");
        Path r105 = ((c) r103).f371519b;
        Paint r106 = new Paint(r103.f371518a);
        r106.setColor(-1);
        Unit r107 = Unit.INSTANCE;
        r104.drawPath(r105, r106);
        goto L9
    L13:
        y();
        return;
    }

    public i1<Boolean> getEnableRedo() {
        return this.E;
    }

    public i1<Boolean> getEnableUndo() {
        return this.C;
    }

    public final boolean getInDrawingPath() {
        return this.T;
    }

    public final PointF getSingleTouchingPoint() {
        return this.f371517p0;
    }

    public final void B(MotionEvent r100) {
        this.f371517p0 = null;
        if (r100.getPointerCount() == 1) goto L5;
        return;
    L5:
        if (this.V.contains(r100.getX(), r100.getY()) == false) goto L9;
        this.f371517p0 = new PointF(r100.getX(), r100.getY());
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Bitmap r101 = this.K;
        if (r101 == null) goto L9;
        r100.save();
        r100.clipRect(this.U);
        r100.drawBitmap(r101, this.M, null);
        PointF r102 = this.f371517p0;
        if (r102 == null) goto L7;
        r100.drawCircle(r102.x, r102.y, (this.F.getStrokeWidth() * this.P0) / 2, this.f371516k0);
    L7:
        r100.restore();
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        if (getViewBitmap() != null) goto L5;
        return false;
    L5:
        if (r110 != null) goto L8;
        return false;
    L8:
        if (this.K == null) goto L10;
    L18:
        MotionEvent r100 = MotionEvent.obtain(r110);
        r100.transform(this.N);
        this.f371517p0 = null;
        float r101 = r100.getX();
        float r102 = r100.getY();
        int r103 = r110.getActionMasked();
        if (r103 == 0) goto L53;
        if (r103 != 1) goto L22;
    L48:
        ((ArrayList) this.S).clear();
        if (this.W == false) goto L52;
        Path r111 = new Path(this.H);
        Paint r104 = new Paint(this.F);
        ((ArrayList) this.R).add(new c(r111, r104));
        y();
    L52:
        this.H.reset();
        this.W = false;
        this.f371517p0 = null;
        this.T = false;
        invalidate();
    L57:
        r100.recycle();
        return true;
    L22:
        if (r103 == 2) goto L27;
        if (r103 == 3) goto L48;
    L27:
        if (r100.getPointerCount() <= 1) goto L30;
        this.T = false;
    L30:
        if (this.T == true) goto L32;
    L47:
        this.I = r101;
        this.f371515J = r102;
        goto L57
    L32:
        if (this.W == true) goto L38;
        if (this.V.contains(r110.getX(), r110.getY()) == true) goto L38;
        this.H.moveTo(r101, r102);
    L38:
        if (this.W == true) goto L40;
        this.W = true;
        goto L47
    L40:
        Path r105 = this.H;
        float r106 = this.I;
        float r107 = this.f371515J;
        float r108 = 2;
        r105.quadTo(r106, r107, (r101 + r106) / r108, (r102 + r107) / r108);
        Canvas r109 = this.L;
        if (r109 == null) goto L43;
        r109.drawPath(this.H, this.F);
    L43:
        Canvas r112 = this.Q;
        if (r112 == null) goto L46;
        r112.drawPath(this.H, this.G);
    L46:
        B(r110);
        invalidate();
        goto L47
    L53:
        Float r113 = this.H0;
        if (r113 == null) goto L56;
        float r114 = r113.floatValue();
        this.H0 = null;
        this.F.setStrokeWidth(r114);
        this.G.setStrokeWidth(this.F.getStrokeWidth());
        A();
    L56:
        this.T = true;
        this.I = r101;
        this.f371515J = r102;
        this.H.moveTo(r101, r102);
        B(r110);
        invalidate();
        goto L57
    L10:
        if (getViewBitmap() == null) goto L18;
        Bitmap r115 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.L = new Canvas(r115);
        this.K = r115;
        if (this.O == false) goto L17;
        Bitmap r116 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.Q = new Canvas(r116);
        Paint r117 = new Paint();
        r117.setColor(-16777216);
        Canvas r118 = this.Q;
        if (r118 == null) goto L16;
        r118.drawRect(0.0f, 0.0f, getWidth(), getHeight(), r117);
    L16:
        this.P = r116;
    L17:
        this.M.reset();
        this.L0 = CollectionsKt.toFloatArray(ArraysKt.toList(this.f464500a));
        setMaxScale(getCurrentScale() * 15.0f);
        setMinScale(getCurrentScale() * 0.7f);
        this.P0 = 1.0f;
        goto L18
    }

    @Override // com.yalantis.ucrop.view.TransformImageView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        if (r100 != null) goto L6;
        this.K = null;
        this.L = null;
        this.M.reset();
        this.N.reset();
        this.P = null;
        this.Q = null;
        this.f464510k = false;
        this.f464509j = false;
        return;
    }

    @Override // com.yalantis.ucrop.view.TransformImageView, android.widget.ImageView
    public void setImageMatrix(Matrix r100) {
        super.setImageMatrix(r100);
        this.U = f.b(this.f464500a);
        A();
    }

    public final void setInDrawingPath(boolean r100) {
        this.T = r100;
    }

    public void setPenColor(int r100) {
        this.F.setColor(r100);
    }

    public void setPenPxSize(float r100) {
        if (this.T == false) goto L5;
        this.H0 = Float.valueOf(r100 / this.P0);
        return;
    L5:
        this.F.setStrokeWidth(r100 / this.P0);
        this.G.setStrokeWidth(this.F.getStrokeWidth());
        A();
    }

    public final void setSingleTouchingPoint(PointF r100) {
        this.f371517p0 = r100;
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public final void p(float r100, float r101) {
        if (this.L == null) goto L5;
        this.M.postTranslate(r100, r101);
        this.M.invert(this.N);
    L5:
        super.p(r100, r101);
    }

    public PaletteView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Boolean r103 = Boolean.FALSE;
        StateFlowImpl r104 = j1.a(r103);
        this.B = r104;
        this.C = e.b(r104);
        StateFlowImpl r105 = j1.a(r103);
        this.D = r105;
        this.E = e.b(r105);
        float r106 = c7.b(20);
        int r107 = ColorProtector.parseColor("#4DFFD000");
        Paint r108 = new Paint();
        setLayerType(1, null);
        r108.setStyle(Paint.Style.STROKE);
        r108.setAntiAlias(true);
        r108.setDither(true);
        r108.setFilterBitmap(true);
        r108.setStrokeJoin(Paint.Join.ROUND);
        r108.setStrokeCap(Paint.Cap.ROUND);
        r108.setStrokeWidth(r106);
        r108.setColor(r107);
        r108.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.F = r108;
        Paint r109 = new Paint();
        r109.setStyle(Paint.Style.STROKE);
        r109.setAntiAlias(true);
        r109.setStrokeJoin(Paint.Join.ROUND);
        r109.setStrokeCap(Paint.Cap.ROUND);
        r109.setStrokeWidth(r106);
        r109.setColor(-1);
        r109.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.G = r109;
        this.H = new Path();
        this.M = new Matrix();
        this.N = new Matrix();
        this.O = true;
        this.R = new ArrayList();
        this.S = new ArrayList();
        this.U = new RectF();
        this.V = new RectF();
        Paint r110 = new Paint();
        r110.setStyle(Paint.Style.STROKE);
        r110.setStrokeWidth(c7.b(2));
        r110.setColor(ColorProtector.parseColor("#CCCCCC"));
        r110.setAntiAlias(true);
        this.f371516k0 = r110;
        this.L0 = new float[8];
        this.P0 = 1.0f;
    }

    @Override // com.yalantis.ucrop.view.CropImageView, com.yalantis.ucrop.view.TransformImageView
    public final void o(float r100, float r101, float r102) {
        if (this.L != null) goto L5;
    L13:
        super.o(r100, r101, r102);
        return;
    L5:
        if (r100 <= 1.0f) goto L9;
        if ((getCurrentScale() * r100) > getMaxScale()) goto L9;
    L12:
        this.M.postScale(r100, r100, r101, r102);
        this.M.invert(this.N);
        Paint r103 = this.F;
        r103.setStrokeWidth(r103.getStrokeWidth() / r100);
        this.G.setStrokeWidth(this.F.getStrokeWidth());
        this.M.getValues(this.f464502c);
        this.P0 = this.f464502c[0];
    L9:
        if (r100 >= 1.0f) goto L13;
        if ((getCurrentScale() * r100) < getMinScale()) goto L13;
        goto L12
    }

    public /* synthetic */ PaletteView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
