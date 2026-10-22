package com.larus.bmhome.view.markableview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.bmhome.view.markableview.base.TransformImageView;
import com.larus.platform.model.chat.g;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 k2\u00020\u0001:\u0002klB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0015J\u0006\u0010;\u001a\u000209J\u0006\u0010<\u001a\u000209J\u0006\u0010=\u001a\u000209J\u000e\u0010>\u001a\u0002092\u0006\u0010?\u001a\u00020\u001fJ\u000e\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u0004\u0018\u00010\u0018J\u0010\u0010D\u001a\u0002092\b\u0010E\u001a\u0004\u0018\u00010\u0018J\u0006\u0010F\u001a\u00020\nJ\b\u0010G\u001a\u0004\u0018\u00010\u0018J\b\u0010H\u001a\u0004\u0018\u00010\u0018J\u0010\u0010I\u001a\u0002092\b\u0010J\u001a\u0004\u0018\u00010\u0018J(\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020B2\u0006\u0010M\u001a\u00020B2\u0006\u0010N\u001a\u00020B2\u0006\u0010O\u001a\u00020BH\u0002J\u000e\u0010P\u001a\u0002092\u0006\u0010Q\u001a\u00020\nJ\u0010\u0010R\u001a\u0002092\u0006\u0010E\u001a\u00020\u0018H\u0016J\b\u0010S\u001a\u000209H\u0014J\u0010\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020*H\u0014J\u0012\u0010V\u001a\u00020\n2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J \u0010Y\u001a\u0002092\u0006\u0010Z\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\u001f2\u0006\u0010\\\u001a\u00020\u001fH\u0016J\u0018\u0010]\u001a\u0002092\u0006\u0010^\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020\u001fH\u0016J\u0010\u0010`\u001a\u0002092\u0006\u0010a\u001a\u00020,H\u0016J\u0018\u0010b\u001a\u0002092\u0006\u0010c\u001a\u00020\u001f2\u0006\u0010d\u001a\u00020\u001fH\u0002J\u0018\u0010e\u001a\u0002092\u0006\u0010c\u001a\u00020\u001f2\u0006\u0010d\u001a\u00020\u001fH\u0002J\b\u0010f\u001a\u000209H\u0002J\b\u0010g\u001a\u000209H\u0002J\b\u0010h\u001a\u000209H\u0002J\b\u0010i\u001a\u000209H\u0002J\b\u0010j\u001a\u000209H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001d0/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Lcom/larus/bmhome/view/markableview/MarkableImageView;", "Lcom/larus/bmhome/view/markableview/base/TransformImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_undoEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "undoEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "getUndoEnabled", "()Lkotlinx/coroutines/flow/StateFlow;", "_redoEnabled", "redoEnabled", "getRedoEnabled", "_isInDrawing", "isInDrawing", "onUserMarkedListener", "Lcom/larus/bmhome/view/markableview/MarkableImageView$OnUserMarkedListener;", "markDisabledByOutside", "rawBitmap", "Landroid/graphics/Bitmap;", "paint", "Landroid/graphics/Paint;", "strokePaint", "curPath", "Landroid/graphics/Path;", "curBufferScale", "", "maxScale", "minScale", "mMaxScaleMultiplier", "mCropRect", "Landroid/graphics/RectF;", "mTargetAspectRatio", "lastX", "lastY", "bufferBitmap", "bufferCanvas", "Landroid/graphics/Canvas;", "bufferMatrix", "Landroid/graphics/Matrix;", "bufferInverseMatrix", "undoList", "", "redoList", "viewBitmapRect", "canDrawPathRect", "hasPathInBitmapRect", "penSizeAWaitNextTouch", "Ljava/lang/Float;", "initialBitmapCorners", "", "setOnUserMarkedListener", "", "listener", "redo", "undo", "clear", "setPenPxSize", "size", "setPenColor", "color", "", "getMarkedBitmap", "setRawBitmap", SimplayerImageStrategy.RESULT_BITMAP, "hasRawBitmap", "getRawMarkedBitmap", "getPathBitmap", "setPathBitmap", "pathBitmap", "hasSameAspectRatio", "widthA", "heightA", "widthB", "heightB", "setMarkEnabled", "enabled", "setImageBitmap", "onImageLaidOut", "onDraw", "canvas", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "postScale", "deltaScale", GXTemplateKey.GAIAX_PX, "py", "postTranslate", "deltaX", "deltaY", "setImageMatrix", "matrix", "calculateImageScaleBounds", "drawableWidth", "drawableHeight", "setupInitialImagePosition", "updateCanDrawPathRect", "redrawOnBufferCanvas", "saveDrawingPath", "checkUnRedo", "initBuffer", "Companion", "OnUserMarkedListener", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkableImageView extends TransformImageView {
    public static final g L = null;
    public static final float M = 0.0f;
    public static final int N = 0;
    public Bitmap A;
    public Canvas B;
    public final Matrix C;
    public final Matrix D;
    public final List<Path> E;
    public final List<Path> F;
    public RectF G;
    public RectF H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Float f317014J;
    public float[] K;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StateFlowImpl f317015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b1 f317016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final StateFlowImpl f317017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b1 f317018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final StateFlowImpl f317019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b1 f317020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f317021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f317022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Bitmap f317023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f317024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Paint f317025t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Path f317026u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f317027v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f317028w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f317029x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f317030y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f317031z;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    static {
        g r100 = z2.f365865a.c2();
        L = r100;
        M = c7.b(Float.valueOf(r100.b()));
        N = ColorProtector.parseColor("#FFD000");
    }

    public final void clear() {
        ((ArrayList) this.F).clear();
        ((ArrayList) this.E).clear();
        n();
        this.f317026u.reset();
        this.I = false;
        this.f317019n.setValue(Boolean.FALSE);
        q();
        invalidate();
        this.B = null;
        this.A = null;
    }

    public final Bitmap getPathBitmap() {
        Bitmap r100 = this.A;
        Object r101 = null;
        if (r100 == null) goto L22;
        Bitmap r102 = getViewBitmap();
        if (r102 == null) goto L23;
        RectF r103 = xt8.a.a(this.K);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        int r105 = RangesKt.coerceAtLeast(0, (int) r103.left);     // Catch: Throwable -> L9
        int r106 = RangesKt.coerceAtLeast(0, (int) r103.top);     // Catch: Throwable -> L9
        Object r107 = Result.m9449constructorimpl(Bitmap.createScaledBitmap(Bitmap.createBitmap(r100, r105, r106, RangesKt.coerceAtMost((int) (((double) r103.width()) + 0.5d), r100.getWidth() - r105), RangesKt.coerceAtMost((int) (((double) r103.height()) + 0.5d), r100.getHeight() - r106)), r102.getWidth(), r102.getHeight(), true));     // Catch: Throwable -> L9
    L11:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L15;
        FLogger.f375446a.e("MarkableImageView", "getMaskBitmap failed", r108);
    L15:
        if (Result.m9455isFailureimpl(r107) == true) goto L19;
        r101 = r107;
    L19:
        return (Bitmap) r101;
    L9:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L23:
        return null;
    L22:
        return null;
    }

    public final Bitmap getRawMarkedBitmap() {
        Bitmap r100 = this.f317023r;
        if (r100 == null) goto L33;
        Object r101 = null;
        if ((!r100.isRecycled()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L33;
        Bitmap r102 = getPathBitmap();
        if (r102 != null) goto L34;
        return r100;
    L34:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L21
        if (r102.getWidth() == r100.getWidth()) goto L16;
    L18:
        r102 = Bitmap.createScaledBitmap(r102, r100.getWidth(), r100.getHeight(), true);     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L21
    L19:
        Bitmap r104 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L21
        Canvas r105 = new Canvas(r104);     // Catch: Throwable -> L21
        r105.drawBitmap(r100, 0.0f, 0.0f, null);     // Catch: Throwable -> L21
        r105.drawBitmap(r102, 0.0f, 0.0f, null);     // Catch: Throwable -> L21
        Object r106 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r106) == true) goto L27;
        r101 = r106;
    L27:
        Bitmap r107 = (Bitmap) r101;
        if (r107 != null) goto L31;
        return r100;
    L31:
        return r107;
    L16:
        if (r102.getHeight() != r100.getHeight()) goto L18;
    L21:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L33:
        return getMarkedBitmap();
    }

    public final void n() {
        this.f317015j.setValue(Boolean.valueOf(!((ArrayList) this.E).isEmpty()));
        this.f317017l.setValue(Boolean.valueOf(!((ArrayList) this.F).isEmpty()));
    }

    public final void p() {
        if ((!((ArrayList) this.F).isEmpty()) == false) goto L8;
        List<Path> r100 = this.E;
        List<Path> r101 = this.F;
        ((ArrayList) r100).add(ListProtector.remove(r101, CollectionsKt.getLastIndex(r101)));
        q();
        invalidate();
        b r102 = this.f317021p;
        if (r102 == null) goto L9;
        r102.c();
        return;
    L9:
        return;
    }

    public final void q() {
        Canvas r100 = this.B;
        if (r100 == null) goto L11;
        r100.drawColor(0, PorterDuff.Mode.CLEAR);
        Iterator<T> r101 = this.E.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r100.drawPath((Path) r101.next(), this.f317024s);
        goto L6
    L8:
        n();
        return;
    }

    public final void r() {
        if ((!((ArrayList) this.E).isEmpty()) == false) goto L8;
        List<Path> r100 = this.F;
        List<Path> r101 = this.E;
        ((ArrayList) r100).add(ListProtector.remove(r101, CollectionsKt.getLastIndex(r101)));
        q();
        invalidate();
        b r102 = this.f317021p;
        if (r102 == null) goto L9;
        r102.a();
        return;
    L9:
        return;
    }

    public final void s() {
        float r100 = this.f317024s.getStrokeWidth() / 2;
        RectF r101 = this.G;
        this.H = new RectF(r101.left - r100, r101.top - r100, r101.right + r100, r101.bottom + r100);
    }

    public final Bitmap getMarkedBitmap() {
        Bitmap r100 = getPathBitmap();
        if (r100 == null) goto L18;
        Bitmap r101 = getViewBitmap();
        if (r101 == null) goto L18;
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        Bitmap r104 = Bitmap.createBitmap(r101.getWidth(), r101.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L9
        Canvas r105 = new Canvas(r104);     // Catch: Throwable -> L9
        r105.drawBitmap(r101, 0.0f, 0.0f, null);     // Catch: Throwable -> L9
        r105.drawBitmap(r100, 0.0f, 0.0f, null);     // Catch: Throwable -> L9
        Object r106 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r106) == true) goto L16;
        r102 = r106;
    L16:
        return (Bitmap) r102;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L18:
        return getViewBitmap();
    }

    @Override // com.larus.bmhome.view.markableview.base.TransformImageView
    public final void l() {
        super.l();
        Drawable r100 = getDrawable();
        if (r100 != null) goto L5;
        return;
    L5:
        float r101 = r100.getIntrinsicWidth();
        float r102 = r100.getIntrinsicHeight();
        FLogger r103 = FLogger.f375446a;
        r103.i("MarkableImageView", "[onImageLaidOut] mThisWidth:" + getMThisWidth() + " mThisHeight:" + getMThisHeight() + " drawable:" + r101 + Permission.EXECUTE + r102 + " mTargetAspectRatio:" + this.f317029x);
        if (getMThisWidth() != 0) goto L8;
    L26:
        r103.w("MarkableImageView", "[onImageLaidOut] view not laid out yet, skip matrix setup");
        return;
    L8:
        if (getMThisHeight() == 0) goto L26;
        if (this.f317029x != 0.0f) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        this.f317029x = r101 / r102;
    L16:
        int r105 = (int) (getMThisWidth() / this.f317029x);
        if (r105 <= getMThisHeight()) goto L19;
        int r106 = (int) (getMThisHeight() * this.f317029x);
        int r107 = (getMThisWidth() - r106) / 2;
        this.f317028w.set(r107, 0.0f, r106 + r107, getMThisHeight());
    L20:
        RangesKt.coerceAtMost(RangesKt.coerceAtMost(this.f317028w.width() / r101, this.f317028w.width() / r102), RangesKt.coerceAtMost(this.f317028w.height() / r102, this.f317028w.height() / r101));
        float r108 = this.f317028w.width();
        float r109 = this.f317028w.height();
        float r110 = Math.max(this.f317028w.width() / r101, this.f317028w.height() / r102);
        RectF r111 = this.f317028w;
        float r112 = ((r108 - (r101 * r110)) / 2.0f) + r111.left;
        float r113 = ((r109 - (r102 * r110)) / 2.0f) + r111.top;
        getMCurrentImageMatrix().reset();
        getMCurrentImageMatrix().postScale(r110, r110);
        getMCurrentImageMatrix().postTranslate(r112, r113);
        StringBuilder r114 = new StringBuilder("[setupInitialImagePosition] cropRect:");
        r114.append(this.f317028w);
        r114.append(" scale:");
        r114.append(r110);
        r114.append(" tw:");
        r114.append(r112);
        r114.append(" th:");
        r114.append(r113);
        r114.append(" drawable:");
        r114.append(r101);
        r114.append(Permission.EXECUTE);
        r114.append(r102);
        r114.append(" drawableBounds:");
        Drawable r115 = getDrawable();
        if (r115 == null) goto L23;
        Rect r116 = r115.getBounds();
    L24:
        r114.append(r116);
        r103.i("MarkableImageView", r114.toString());
        setImageMatrix(getMCurrentImageMatrix());
        return;
    L23:
        r116 = null;
        goto L24
    L19:
        int r117 = (getMThisHeight() - r105) / 2;
        this.f317028w.set(0.0f, r117, getMThisWidth(), r105 + r117);
        goto L20
    L13:
        r104 = false;
        goto L14
    }

    public final void o() {
        if (getViewBitmap() != null) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
    L20:
        FLogger.f375446a.w("MarkableImageView", "[initBuffer] view is not ready, view:" + getWidth() + Permission.EXECUTE + getHeight());
        return;
    L7:
        if (getHeight() <= 0) goto L20;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        Object r101 = Result.m9449constructorimpl(Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888));     // Catch: Throwable -> L11
    L14:
        if (Result.m9456isSuccessimpl(r101) == false) goto L16;
        Bitmap r102 = (Bitmap) r101;
        this.B = new Canvas(r102);
        this.A = r102;
        this.C.reset();
        this.K = CollectionsKt.toFloatArray(ArraysKt.toList(getMCurrentImageCorners()));
        getCurrentScale();
        getCurrentScale();
        this.f317027v = 1.0f;
    L16:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r101);
        if (r103 == null) goto L19;
        FLogger.f375446a.e("MarkableImageView", "[initBuffer] create buffer failed, view:" + getWidth() + Permission.EXECUTE + getHeight(), r103);
        this.B = null;
        this.A = null;
    L19:
        Result.m9448boximpl(r101);
        return;
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final i1<Boolean> getRedoEnabled() {
        return this.f317018m;
    }

    public final i1<Boolean> getUndoEnabled() {
        return this.f317016k;
    }

    public MarkableImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Bitmap r101 = this.A;
        if (r101 == null) goto L6;
        r100.save();
        r100.clipRect(this.G);
        r100.drawBitmap(r101, this.C, null);
        r100.restore();
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (this.f317022q == false) goto L6;
        return false;
    L6:
        if (getViewBitmap() != null) goto L8;
        return false;
    L8:
        if (r110 != null) goto L11;
        return false;
    L11:
        if (this.A != null) goto L13;
        o();
    L13:
        MotionEvent r100 = MotionEvent.obtain(r110);
        r100.transform(this.D);
        float r101 = r100.getX();
        float r102 = r100.getY();
        int r103 = r110.getActionMasked();
        if (r103 != 0) goto L16;
        Float r111 = this.f317014J;
        if (r111 == null) goto L56;
        float r112 = r111.floatValue();
        this.f317014J = null;
        this.f317024s.setStrokeWidth(r112);
        this.f317025t.setStrokeWidth(this.f317024s.getStrokeWidth());
        s();
    L56:
        FLogger.f375446a.i("MarkableImageView", "[onTouchEvent] ACTION_DOWN - emitting isInDrawing: true");
        this.f317019n.setValue(Boolean.TRUE);
        this.f317030y = r101;
        this.f317031z = r102;
        this.f317026u.moveTo(r101, r102);
        invalidate();
    L57:
        r100.recycle();
        return true;
    L16:
        if (r103 == 1) goto L40;
        if (r103 == 2) goto L22;
        if (r103 == 3) goto L40;
    L22:
        if (r100.getPointerCount() <= 1) goto L25;
        FLogger.f375446a.i("MarkableImageView", "[onTouchEvent] ACTION_MOVE - multi-touch detected, emitting isInDrawing: false");
        this.f317019n.setValue(Boolean.FALSE);
    L25:
        if (((Boolean) this.f317019n.getValue()).booleanValue() == true) goto L27;
    L39:
        this.f317030y = r101;
        this.f317031z = r102;
        goto L57
    L27:
        if (this.I == true) goto L33;
        if (this.H.contains(r110.getX(), r110.getY()) == true) goto L33;
        this.f317026u.moveTo(r101, r102);
    L33:
        if (this.I == true) goto L35;
        this.I = true;
        goto L39
    L35:
        Path r113 = this.f317026u;
        float r104 = this.f317030y;
        float r105 = this.f317031z;
        float r106 = 2;
        r113.quadTo(r104, r105, (r101 + r104) / r106, (r102 + r105) / r106);
        Canvas r114 = this.B;
        if (r114 == null) goto L38;
        r114.drawPath(this.f317026u, this.f317024s);
    L38:
        invalidate();
    L40:
        ((ArrayList) this.F).clear();
        b r107 = this.f317021p;
        if (r107 == null) goto L44;
        r107.b();
    L44:
        if (this.H.contains(r110.getX(), r110.getY()) == false) goto L49;
        this.I = true;
        Path r115 = this.f317026u;
        float r108 = this.f317030y;
        float r109 = this.f317031z;
        float r116 = 2;
        r115.quadTo(r108, r109, (r101 + r108) / r116, (r102 + r109) / r116);
        Canvas r117 = this.B;
        if (r117 == null) goto L49;
        r117.drawPath(this.f317026u, this.f317024s);
    L49:
        if (this.I == false) goto L52;
        ((ArrayList) this.E).add(new Path(this.f317026u));
        n();
    L52:
        this.f317026u.reset();
        this.I = false;
        FLogger.f375446a.i("MarkableImageView", "[onTouchEvent] ACTION_UP/CANCEL - emitting isInDrawing: false");
        this.f317019n.setValue(Boolean.FALSE);
        invalidate();
        goto L57
    }

    @Override // com.larus.bmhome.view.markableview.base.TransformImageView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        FLogger r101 = FLogger.f375446a;
        r101.i("MarkableImageView", "[setImageBitmap] bitmap:" + r100.getWidth() + Permission.EXECUTE + r100.getHeight() + " mThisWidth:" + getMThisWidth() + " mThisHeight:" + getMThisHeight() + " recycled:" + r100.isRecycled());
        if (r100.isRecycled() == false) goto L6;
        r101.e("MarkableImageView", "[setImageBitmap] bitmap is recycled, skip!");
        return;
    L6:
        this.f317029x = 0.0f;
        super.setImageBitmap(r100);
        l();
        m();
        s();
    }

    @Override // com.larus.bmhome.view.markableview.base.TransformImageView, android.widget.ImageView
    public void setImageMatrix(Matrix r100) {
        Intrinsics.checkNotNullParameter(r100, "matrix");
        super.setImageMatrix(r100);
        this.G = xt8.a.a(getMCurrentImageCorners());
        s();
    }

    public final void setMarkEnabled(boolean r100) {
        FLogger.f375446a.i("MarkableImageView", "[setMarkEnabled] enabled:" + r100);
        this.f317022q = r100 ^ true;
    }

    public final void setOnUserMarkedListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f317021p = r100;
    }

    public final void setPathBitmap(Bitmap r110) {
        if (r110 != null) goto L5;
        clear();
        return;
    L5:
        Bitmap r100 = getViewBitmap();
        if (r110.isRecycled() == true) goto L34;
        if (r100 == null) goto L36;
        int r101 = r110.getWidth();
        int r102 = r110.getHeight();
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        if (r101 <= 0) goto L18;
        if (r102 <= 0) goto L18;
        if (r103 <= 0) goto L18;
        if (r104 <= 0) goto L18;
        if (Math.abs((r101 / r102) - (r103 / r104)) > 0.01f) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == true) goto L23;
        FLogger.f375446a.w("MarkableImageView", "[setPathBitmap] skip mismatched mask:" + r110.getWidth() + Permission.EXECUTE + r110.getHeight() + ", bitmap:" + r100.getWidth() + Permission.EXECUTE + r100.getHeight());
        clear();
        return;
    L23:
        if (this.A != null) goto L25;
        o();
    L25:
        Canvas r106 = this.B;
        if (r106 == null) goto L35;
        ((ArrayList) this.F).clear();
        ((ArrayList) this.E).clear();
        n();
        r106.drawColor(0, PorterDuff.Mode.CLEAR);
        RectF r107 = xt8.a.a(this.K);
        float r108 = RangesKt.coerceAtLeast(r107.left, 0.0f);
        float r109 = RangesKt.coerceAtLeast(r107.top, 0.0f);
        float r111 = RangesKt.coerceAtMost(r107.right, getWidth());
        float r112 = RangesKt.coerceAtMost(r107.bottom, getHeight());
        if (r111 > r108) goto L30;
    L32:
        invalidate();
        return;
    L30:
        if (r112 <= r109) goto L32;
        r106.drawBitmap(r110, new Rect(0, 0, r110.getWidth(), r110.getHeight()), new RectF(r108, r109, r111, r112), new Paint(3));
        goto L32
    L35:
        return;
    L18:
        r105 = false;
        goto L19
    L36:
        return;
    }

    public final void setPenColor(int r100) {
        this.f317024s.setColor(r100);
        this.f317024s.setAlpha((int) (255 * L.a()));
        FLogger.f375446a.i("MarkableImageView", "[setPenColor] color:" + this.f317024s.getColor() + " alpha=" + this.f317024s.getAlpha());
    }

    public final void setPenPxSize(float r100) {
        if (((Boolean) this.f317019n.getValue()).booleanValue() == false) goto L5;
        this.f317014J = Float.valueOf(r100 / this.f317027v);
        return;
    L5:
        this.f317024s.setStrokeWidth(r100 / this.f317027v);
        this.f317025t.setStrokeWidth(this.f317024s.getStrokeWidth());
        s();
    }

    public final void setRawBitmap(Bitmap r100) {
        this.f317023r = r100;
    }

    public MarkableImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 4, 0);
        Boolean r102 = Boolean.FALSE;
        StateFlowImpl r103 = j1.a(r102);
        this.f317015j = r103;
        this.f317016k = e.b(r103);
        StateFlowImpl r104 = j1.a(r102);
        this.f317017l = r104;
        this.f317018m = e.b(r104);
        StateFlowImpl r105 = j1.a(r102);
        this.f317019n = r105;
        this.f317020o = e.b(r105);
        Paint r106 = new Paint();
        setLayerType(1, null);
        r106.setStyle(Paint.Style.STROKE);
        r106.setAntiAlias(true);
        r106.setDither(true);
        r106.setFilterBitmap(true);
        r106.setStrokeJoin(Paint.Join.ROUND);
        r106.setStrokeCap(Paint.Cap.ROUND);
        float r107 = M;
        r106.setStrokeWidth(r107);
        r106.setColor(N);
        r106.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f317024s = r106;
        Paint r108 = new Paint();
        r108.setStyle(Paint.Style.STROKE);
        r108.setAntiAlias(true);
        r108.setStrokeJoin(Paint.Join.ROUND);
        r108.setStrokeCap(Paint.Cap.ROUND);
        r108.setStrokeWidth(r107);
        r108.setColor(-1);
        r108.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f317025t = r108;
        this.f317026u = new Path();
        this.f317027v = 1.0f;
        this.f317028w = new RectF();
        this.C = new Matrix();
        this.D = new Matrix();
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new RectF();
        this.H = new RectF();
        this.K = new float[8];
    }
}
