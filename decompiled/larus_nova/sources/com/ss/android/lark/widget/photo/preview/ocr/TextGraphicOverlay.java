package com.ss.android.lark.widget.photo.preview.ocr;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.common_selection.f;
import com.larksuite.common_selection.s;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0004RSTUB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u0013J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010&\u001a\u00020\u0016J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001bH\u0014J\u0010\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.J\u000e\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020!J\u0014\u00101\u001a\u00020(2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013J\u0016\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001bJ\b\u00106\u001a\u00020(H\u0002J\u000e\u00107\u001a\u00020(2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u00108\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020\u001bJ\u0010\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020=H\u0014J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u001dH\u0002J\u0010\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001dH\u0002J\u000e\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001dJ\u000e\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001dJ\b\u0010F\u001a\u00020(H\u0002J\b\u0010G\u001a\u00020(H\u0002J\b\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020(H\u0002J\u0014\u0010K\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010L\u001a\u00020\u001dH\u0002J\b\u0010M\u001a\u00020(H\u0014J\b\u0010N\u001a\u00020(H\u0014J\u0012\u0010O\u001a\u00020(2\b\u0010P\u001a\u0004\u0018\u00010QH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/ocr/TextGraphicOverlay;", "Landroid/view/View;", "Lcom/larksuite/common_selection/SelectableView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lock", "", "graphics", "", "Lcom/ss/android/lark/widget/photo/preview/ocr/TextGraphic;", "textElements", "Lcom/ss/android/lark/widget/photo/preview/ocr/TextElement;", "textGraphicStrategy", "Lcom/ss/android/lark/widget/photo/preview/ocr/TextGraphicStrategy;", "indexMap", "", "Lcom/ss/android/lark/widget/photo/preview/ocr/TextGraphicOverlay$GraphicInfo;", "virtualText", "", "drawMask", "", "drawOverlay", "maskColor", "", "previewWidth", "", "previewHeight", "textGraphicInvalidate", "graphicFitCoordinator", "Lcom/ss/android/lark/widget/photo/preview/ocr/TextGraphicOverlay$GraphicFitCoordinator;", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getGraphics", "getGraphicInfo", "getVirtualText", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "transformToViewCoordinates", "Landroid/graphics/RectF;", "targetRect", "Landroid/graphics/Rect;", "setGraphicPicCoordinator", "coordinator", "resetTextElements", SlcElement.KEY_ELEMENTS, "setPreviewSize", "width", "height", "invalidateTextGraphics", "setDrawOverlay", "setDrawMask", "setMaskColor", "color", "onDraw", "canvas", "Landroid/graphics/Canvas;", LiveDegradeFpsAnimator.SCALE_X, "horizontal", LiveDegradeFpsAnimator.SCALE_Y, "vertical", "translateX", "x", "translateY", "y", "buildVirtualText", "buildIndexMap", "getSelectionStrategy", "Lcom/larksuite/common_selection/SelectionStrategy;", "calculateTextGraphic", "createWithScale", "scaleFactor", "onAttachedToWindow", "onDetachedFromWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "GraphicInfo", "GraphicFitCoordinator", "DefaultGraphicFitCoordinator", "Companion", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextGraphicOverlay extends View implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f447055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.ss.android.lark.widget.photo.preview.ocr.d> f447056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.ss.android.lark.widget.photo.preview.ocr.c> f447057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.widget.photo.preview.ocr.e f447058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<d> f447059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f447060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f447061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f447062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f447063i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f447064j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f447065k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f447066l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f447067m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f447068n;

    public static final class a {
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f447069a = null;

        static {
            f447069a = new b();
        }

        public b() {
        }

        @Override // com.ss.android.lark.widget.photo.preview.ocr.TextGraphicOverlay.c
        public final Triple<Float, Float, Float> a(int r100, int r101, int r102, int r103) {
            float r104 = r100;
            float r105 = r102;
            float r106 = r101;
            float r107 = r103;
            float r108 = Math.min(r104 / r105, r106 / r107);
            return new Triple(Float.valueOf(r108), Float.valueOf((r104 - (r105 * r108)) / 2.0f), Float.valueOf((r106 - (r107 * r108)) / 2.0f));
        }
    }

    public interface c {
        Triple<Float, Float, Float> a(int r100, int r101, int r102, int r103);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.widget.photo.preview.ocr.d f447070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f447071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f447072c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f447070a, r101.f447070a) == true) goto L12;
            return false;
        L12:
            if (this.f447071b == r101.f447071b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f447070a.hashCode() * 31) + this.f447071b;
        }

        public final String toString() {
            return "GraphicInfo(graphic=" + this.f447070a + ", startGlobalIndex=" + this.f447071b + ')';
        }

        public d(com.ss.android.lark.widget.photo.preview.ocr.d r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "graphic");
            this.f447070a = r100;
            this.f447071b = r101;
            this.f447072c = r100.f447080a.f447077a.length() + 1;
        }
    }

    public static final class e implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextGraphicOverlay f447073a;

        public e(TextGraphicOverlay r100) {
            this.f447073a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            TextGraphicOverlay r100 = this.f447073a;
            int r101 = 1;
            if (r100.f447066l == false) goto L84;
            Object r102 = r100.getParent();
            if ((r102 instanceof View) == false) goto L7;
            View r103 = (View) r102;
        L8:
            int r104 = 0;
            if (r103 == null) goto L71;
            int r105 = r103.getWidth();
            int r106 = r103.getHeight();
            float r107 = r100.f447064j;
            float r108 = r100.f447065k;
            if (r107 != 0.0f) goto L14;
            boolean r109 = true;
        L15:
            if (r109 == true) goto L71;
            if (r108 != 0.0f) goto L19;
            boolean r110 = true;
        L20:
            if (r110 == true) goto L71;
            if (r105 == 0) goto L71;
            Triple<Float, Float, Float> r111 = r100.f447067m.a(r105, r106, MathKt.roundToInt(r107), MathKt.roundToInt(r108));
            float r112 = r111.component1().floatValue();
            float r113 = r111.component2().floatValue();
            float r114 = r111.component3().floatValue();
            List<com.ss.android.lark.widget.photo.preview.ocr.c> r115 = r100.f447057c;
            int r116 = 10;
            ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
            Iterator r118 = ((ArrayList) r115).iterator();
        L25:
            if (r118.hasNext() == false) goto L62;
            com.ss.android.lark.widget.photo.preview.ocr.c r119 = (com.ss.android.lark.widget.photo.preview.ocr.c) r118.next();
            Rect r120 = r119.f447078b;
            Rect r121 = new Rect((int) (r120.left * r112), (int) (r120.top * r112), (int) (r120.right * r112), (int) (r120.bottom * r112));
            List<Point> r122 = r119.f447079c;
            ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, r116));
            Iterator<T> r124 = r122.iterator();
        L28:
            if (r124.hasNext() == false) goto L30;
            Point r125 = (Point) r124.next();
            r123.add(new Point((int) (r125.x * r112), (int) (r125.y * r112)));
            goto L28
        L30:
            com.ss.android.lark.widget.photo.preview.ocr.c r126 = new com.ss.android.lark.widget.photo.preview.ocr.c(r119.f447077a, r121, r123);
            List<Point> r127 = r126.f447079c;
            String r128 = r126.f447077a;
            TextPaint r129 = TextDrawUtils.f447050a;
            if (r128 != null) goto L33;
        L36:
            boolean r130 = true;
        L37:
            if (r130 == true) goto L60;
            if (r127 == null) goto L60;
            if (r127.size() != 4) goto L60;
            float r131 = (float) Math.atan2(((Point) ListProtector.get(r127, r101)).y - ((Point) ListProtector.get(r127, r104)).y, ((Point) ListProtector.get(r127, r101)).x - ((Point) ListProtector.get(r127, r104)).x);
            Point r132 = (Point) ListProtector.get(r127, r104);
            Point r133 = (Point) ListProtector.get(r127, r101);
            int r134 = r133.x - r132.x;
            int r135 = r133.y - r132.y;
            float r136 = (float) Math.sqrt((r134 * r134) + (r135 * r135));
            Point r137 = (Point) ListProtector.get(r127, r101);
            Point r138 = (Point) ListProtector.get(r127, 2);
            int r139 = r138.x - r137.x;
            int r140 = r138.y - r137.y;
            float r141 = (float) Math.sqrt((r139 * r139) + (r140 * r140));
            float r142 = 0.5f;
            float r143 = r141 * 0.5f;
            float r144 = 1.2f * r141;
            TextPaint r145 = TextDrawUtils.f447050a;
            r145.setTextSize(r141);
            float r146 = r145.measureText(r128);
            if (r146 > r136) goto L46;
            TextDrawUtils.a r147 = TextDrawUtils.a(r128, r141, r136, r131, r146);
        L61:
            com.ss.android.lark.widget.photo.preview.ocr.d r148 = new com.ss.android.lark.widget.photo.preview.ocr.d(r100, r126);
            r148.f447082c.setTextSize(r147.f447052a);
            r148.f447085f = r147.f447053b;
            r148.f447086g = (float) Math.toDegrees(r147.f447054c);
            r148.f447083d = r113;
            r148.f447084e = r114;
            r148.f447087h.offset(r113, r114);
            r117.add(r148);
            r101 = 1;
            r104 = 0;
            r116 = 10;
            goto L25
        L46:
            if (Math.abs(r146 - r136) > 0.5f) goto L49;
            r147 = TextDrawUtils.a(r128, r141, r136, r131, r146);
        L49:
            if ((r144 - r143) <= r142) goto L58;
            float r149 = (r143 + r144) / 2;
            TextPaint r150 = TextDrawUtils.f447050a;
            r150.setTextSize(r149);
            float r151 = r150.measureText(r128);
            if (Math.abs(r151 - r136) <= 0.5f) goto L52;
            if (r151 <= r136) goto L56;
            r144 = r149;
        L57:
            r146 = r151;
            r142 = 0.5f;
            goto L49
        L56:
            r143 = r149;
            goto L57
        L52:
            r147 = TextDrawUtils.a(r128, r149, r136, r131, r151);
            goto L61
        L58:
            r147 = TextDrawUtils.a(r128, r143, r136, r131, r146);
        L60:
            r147 = new TextDrawUtils.a(0.0f, 0.0f, 0.0f);
            goto L61
        L33:
            if (r128.length() == 0) goto L36;
            r130 = false;
            goto L37
        L62:
            Log.d("TextGraphicOverlay", "calculateTextGraphic: " + r117);
            ((ArrayList) r100.f447056b).clear();
            ((ArrayList) r100.f447056b).addAll(r117);
            StringBuilder r152 = new StringBuilder();
            Iterator r153 = ((ArrayList) r100.f447056b).iterator();
        L64:
            if (r153.hasNext() == false) goto L66;
            r152.append(((com.ss.android.lark.widget.photo.preview.ocr.d) r153.next()).f447080a.f447077a);
            r152.append(" ");
            goto L64
        L66:
            r100.f447060f = r152.toString();
            ArrayList r154 = new ArrayList();
            Iterator r155 = ((ArrayList) r100.f447056b).iterator();
            int r156 = 0;
        L68:
            if (r155.hasNext() == false) goto L70;
            d r157 = new d((com.ss.android.lark.widget.photo.preview.ocr.d) r155.next(), r156);
            r154.add(r157);
            r156 = r156 + r157.f447072c;
            goto L68
        L70:
            r100.f447059e = r154;
            goto L71
        L19:
            r110 = false;
            goto L20
        L14:
            r109 = false;
        L71:
            this.f447073a.f447066l = false;
            return true;
        L7:
            r103 = null;
            goto L8
        L84:
            return true;
        }
    }

    static {
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.f447068n);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.f447068n);
    }

    public final List<d> getGraphicInfo() {
        return this.f447059e;
    }

    public final List<com.ss.android.lark.widget.photo.preview.ocr.d> getGraphics() {
        return this.f447056b;
    }

    @Override // com.larksuite.common_selection.f
    public s getSelectionStrategy() {
        return this.f447058d;
    }

    public final CharSequence getVirtualText() {
        return this.f447060f;
    }

    public static RectF a(Rect r110) {
        if (r110 == null) goto L4;
        RectF r100 = new RectF(r110);
        float r111 = r100.left;
        float r101 = r100.top;
        float r102 = r100.right;
        float r103 = r100.bottom;
        double r104 = r111;
        double r105 = r102;
        double r106 = r101;
        double r107 = r103;
        r100.set((float) Math.min(r104, r105), (float) Math.min(r106, r107), (float) Math.max(r104, r105), (float) Math.max(r106, r107));
        return r100;
    L4:
        return new RectF();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        setScaleX(1.0f);
        setScaleY(1.0f);
        setTranslationY(0.0f);
        setTranslationX(0.0f);
        this.f447066l = true;
        postInvalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Object r101 = this.f447055a;
        monitor-enter(r101);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.f447062h == false) goto L11;
        Iterator<T> r102 = this.f447056b.iterator();     // Catch: Throwable -> L26
    L8:
        if (r102.hasNext() == false) goto L11;
        ((com.ss.android.lark.widget.photo.preview.ocr.d) r102.next()).a(r100);     // Catch: Throwable -> L26
    L11:
        if (this.f447061g == false) goto L23;
        int r103 = r100.save();     // Catch: Throwable -> L26
        Iterator r104 = ((ArrayList) this.f447056b).iterator();     // Catch: Throwable -> L17
    L15:
        if (r104.hasNext() == false) goto L19;
        r100.clipPath(((com.ss.android.lark.widget.photo.preview.ocr.d) r104.next()).f447087h, Region.Op.DIFFERENCE);     // Catch: Throwable -> L17
        goto L15
    L19:
        r100.drawColor(this.f447063i);     // Catch: Throwable -> L17
        r100.restoreToCount(r103);     // Catch: Throwable -> L26
        goto L23
    L17:
        th = move-exception;
        r100.restoreToCount(r103);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L23:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r101);
    }

    public final void setDrawMask(boolean r100) {
        this.f447061g = r100;
        postInvalidate();
    }

    public final void setDrawOverlay(boolean r100) {
        this.f447062h = r100;
        postInvalidate();
    }

    public final void setGraphicPicCoordinator(c r100) {
        Intrinsics.checkNotNullParameter(r100, "coordinator");
        this.f447067m = r100;
    }

    public final void setMaskColor(int r100) {
        this.f447063i = r100;
    }

    public TextGraphicOverlay(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f447055a = new Object();
        this.f447056b = new ArrayList();
        this.f447057c = new ArrayList();
        this.f447058d = new com.ss.android.lark.widget.photo.preview.ocr.e();
        this.f447059e = CollectionsKt.emptyList();
        this.f447060f = "";
        this.f447063i = UIUtils.getColor(r100, R.color.bg_mask);
        this.f447067m = b.f447069a;
        this.f447068n = new e(this);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        float r104 = this.f447064j;
        if (r104 > 0.0f) goto L5;
    L8:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (this.f447065k <= 0.0f) goto L8;
        if (r102 <= 0) goto L8;
        float r105 = this.f447067m.a(r102, r103, MathKt.roundToInt(r104), MathKt.roundToInt(this.f447065k)).component1().floatValue();
        int r106 = MathKt.roundToInt(this.f447064j * r105);
        int r107 = MathKt.roundToInt(this.f447065k * r105);
        setMeasuredDimension(Math.max(r106, r102), Math.max(r107, r103));
    }
}
