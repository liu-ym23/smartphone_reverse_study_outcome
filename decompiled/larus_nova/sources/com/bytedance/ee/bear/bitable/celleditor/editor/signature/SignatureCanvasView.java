package com.bytedance.ee.bear.bitable.celleditor.editor.signature;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0014J\u0006\u0010#\u001a\u00020\u001dJ\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010%\u001a\u00020&J\u0018\u0010'\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/signature/SignatureCanvasView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "strokes", "", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/signature/Stroke;", "current", "baseWidth", "", "paint", "Landroid/graphics/Paint;", "exportPaint", "getExportPaint", "()Landroid/graphics/Paint;", "exportPaint$delegate", "Lkotlin/Lazy;", "onStrokeChange", "Lkotlin/Function0;", "", "getOnStrokeChange", "()Lkotlin/jvm/functions/Function0;", "setOnStrokeChange", "(Lkotlin/jvm/functions/Function0;)V", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "isEmpty", "clear", "exportTransparentPng", "Landroid/graphics/Bitmap;", "drawStrokes", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignatureCanvasView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f209511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f209512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f209513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f209514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f209515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f209516f;

    public static final class a {
    }

    static {
    }

    private final Paint getExportPaint() {
        return (Paint) this.f209515e.getValue();
    }

    public final Bitmap b() {
        Bitmap r100 = Bitmap.createBitmap(800, 450, Bitmap.Config.ARGB_8888);
        tt5.a.h("SignatureCanvasView", "exportTransparentPng, srcWidth: " + getWidth() + ", srcHeight: " + getHeight() + ", exportWidth: 800, exportHeight: 450, byteCount: " + r100.getByteCount() + " bytes (" + ((r100.getByteCount() / 1024.0f) / 1024.0f) + " MB)");
        if (getWidth() > 0) goto L5;
    L8:
        return r100;
    L5:
        if (getHeight() <= 0) goto L8;
        float r101 = Math.min(800.0f / getWidth(), 450.0f / getHeight());
        float r102 = (800 - (getWidth() * r101)) / 2.0f;
        float r103 = (450 - (getHeight() * r101)) / 2.0f;
        Canvas r104 = new Canvas(r100);
        r104.translate(r102, r103);
        r104.scale(r101, r101);
        a(r104, getExportPaint());
        goto L8
    }

    public final Function0<Unit> getOnStrokeChange() {
        return this.f209516f;
    }

    public SignatureCanvasView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        a(r100, this.f209514d);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L17;
        if (r101 != 1) goto L6;
        d r102 = this.f209512b;
        if (r102 == null) goto L14;
        ((ArrayList) this.f209511a).add(r102);
    L14:
        this.f209512b = null;
        Function0<Unit> r103 = this.f209516f;
        if (r103 == null) goto L20;
        r103.invoke();
    L20:
        invalidate();
        return true;
    L6:
        if (r101 != 2) goto L20;
        d r104 = this.f209512b;
        if (r104 == null) goto L20;
        float r105 = r100.getX();
        float r106 = r100.getY();
        float r107 = r100.getPressure();
        List<PointF> r108 = r104.f209549a;
        ArrayList r109 = (ArrayList) r108;
        r109.add(new PointF(r105, r106));
        Float r110 = Float.valueOf(r107);
        ((ArrayList) r104.f209550b).add(r110);
        goto L20
    L17:
        d r111 = new d();
        float r112 = r100.getX();
        float r113 = r100.getY();
        float r114 = r100.getPressure();
        List<PointF> r115 = r111.f209549a;
        ArrayList r116 = (ArrayList) r115;
        r116.add(new PointF(r112, r113));
        Float r117 = Float.valueOf(r114);
        ((ArrayList) r111.f209550b).add(r117);
        this.f209512b = r111;
        Function0<Unit> r118 = this.f209516f;
        if (r118 == null) goto L20;
        r118.invoke();
        goto L20
    }

    public final void setOnStrokeChange(Function0<Unit> r100) {
        this.f209516f = r100;
    }

    public SignatureCanvasView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f209511a = new ArrayList();
        Resources r102 = r100.getResources();
        this.f209513c = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density * 4.0f;
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeCap(Paint.Cap.ROUND);
        r103.setStrokeJoin(Paint.Join.ROUND);
        r103.setColor(c.a(r100));
        this.f209514d = r103;
        this.f209515e = LazyKt.lazy(new SignatureCanvasView$exportPaint$2(this));
    }

    public final void a(Canvas r100, Paint r101) {
        Iterator<T> r102 = this.f209511a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((d) r102.next()).a(r100, r101, this.f209513c);
        goto L4
    L6:
        d r103 = this.f209512b;
        if (r103 == null) goto L11;
        r103.a(r100, r101, this.f209513c);
        return;
    }
}
