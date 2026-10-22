package com.bytedance.live.photoviewer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.ScrollingView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import uj6.d;
import wj6.c;
import wj6.e;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0016\u0010\u0013\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¨\u0006%"}, d2 = {"Lcom/bytedance/live/photoviewer/PhotoDraweeView;", "Lcom/facebook/drawee/view/GenericDraweeView;", "Landroidx/core/view/ScrollingView;", "", "enabled", "", "setHorizontalNestedScrollEnabled", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "tapListener", "setTapListener", "zoomingEnabled", "setZoomingEnabled", "setTranslationEnabled", "Lcom/facebook/drawee/interfaces/DraweeController;", "controller", "setController", "Lcom/facebook/drawee/controller/BaseControllerListener;", "", "listener", "setControllerListener", "", "maxScale", "setMaxScaleFactor", "", "duration", "setAnimationDuration", "Luj6/c;", "scaleFactorRetriever", "setScaleFactorRetriever", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "photoviewer_release"}, k = 1, mv = {1, 4, 0})
public class PhotoDraweeView extends GenericDraweeView implements ScrollingView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f255612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f255613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ZoomableControllerImp f255614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GestureDetector f255615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f255616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseControllerListener<Object> f255617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f255618g;

    public static final class a extends BaseControllerListener<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoDraweeView f255619a;

        public a(PhotoDraweeView r100) {
            this.f255619a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
            this.f255619a.f255614c.e(false);
            BaseControllerListener<Object> r101 = this.f255619a.f255617f;
            if (r101 == null) goto L6;
            r101.onRelease(r100);
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageSet(String r100, Object r101) {
            super.onIntermediateImageSet(r100, r101);
            BaseControllerListener<Object> r102 = this.f255619a.f255617f;
            if (r102 == null) goto L6;
            r102.onIntermediateImageSet(r100, r101);
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            PhotoDraweeView r103 = this.f255619a;
            ZoomableControllerImp r104 = r103.f255614c;
            if (r104.f550396c == true) goto L5;
            r104.e(true);
            r103.updateZoomableControllerBounds();
        L5:
            BaseControllerListener<Object> r105 = this.f255619a.f255617f;
            if (r105 == null) goto L9;
            r105.onFinalImageSet(r100, r101, r102);
            return;
        }
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoDraweeView f255620a;

        public b(PhotoDraweeView r100) {
            this.f255620a = r100;
        }

        @Override // uj6.d
        public final void a() {
            this.f255620a.invalidate();
        }
    }

    public PhotoDraweeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PhotoDraweeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollExtent() {
        return (int) this.f255614c.f550401h.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollOffset() {
        ZoomableControllerImp r100 = this.f255614c;
        return (int) (r100.f550401h.left - r100.f550403j.left);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollRange() {
        return (int) this.f255614c.f550403j.width();
    }

    @Override // android.view.View
    public final void computeScroll() {
        ZoomableControllerImp r100 = this.f255614c;
        if (r100.f255632y.computeScrollOffset() == false) goto L9;
        int r101 = r100.f255632y.getCurrX();
        int r102 = r100.f255632y.getCurrY();
        r100.f255624q.set(r100.f255626s);
        Matrix r103 = r100.f255624q;
        r103.postTranslate(r101, r102);
        r100.k(r103);
        Matrix r104 = r100.f255624q;
        if (r100.f255629v.isRunning() == false) goto L7;
        r100.q();
    L7:
        r100.f255625r.set(r104);
        r100.f550404k.set(r104);
        r100.c();
        return;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollExtent() {
        return (int) this.f255614c.f550401h.height();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollOffset() {
        ZoomableControllerImp r100 = this.f255614c;
        return (int) (r100.f550401h.top - r100.f550403j.top);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollRange() {
        return (int) this.f255614c.f550403j.height();
    }

    public ZoomableControllerImp f() {
        return new ZoomableControllerImp(new e(), getContext());
    }

    public wj6.a j() {
        return new wj6.a(this.f255614c);
    }

    public final void updateZoomableControllerBounds() {
        getHierarchy().getActualImageBounds(this.f255612a);
        this.f255613b.set(0.0f, 0.0f, getWidth(), getHeight());
        ZoomableControllerImp r100 = this.f255614c;
        RectF r101 = this.f255612a;
        if (r101.equals(r100.f550402i) == true) goto L5;
        r100.f550402i.set(r101);
        r100.f();
        r100.c();
    L5:
        ZoomableControllerImp r102 = this.f255614c;
        r102.f550401h.set(this.f255613b);
        r102.f();
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        return super.canScrollVertically(r100);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        int r101 = r100.save();
        r100.concat(this.f255614c.f550404k);
        super.onDraw(r100);
        r100.restoreToCount(r101);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        super.onTouchEvent(r100);
        this.f255615d.onTouchEvent(r100);
        if (this.f255614c.o(r100) == false) goto L6;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L6:
        getParent().requestDisallowInterceptTouchEvent(false);
        MotionEvent r101 = MotionEvent.obtain(r100);
        r101.setAction(3);
        this.f255615d.onTouchEvent(r101);
        this.f255614c.o(r101);
        r101.recycle();
        return false;
    }

    public final void setAnimationDuration(long r100) {
        this.f255614c.f255630w = r100;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(DraweeController r100) {
        DraweeController r101 = getController();
        if ((r101 instanceof AbstractDraweeController) == false) goto L6;
        ((AbstractDraweeController) r101).removeControllerListener(this.f255618g);
    L6:
        if ((r100 instanceof AbstractDraweeController) == false) goto L8;
        ((AbstractDraweeController) r100).addControllerListener(this.f255618g);
    L8:
        super.setController(r100);
    }

    public final void setControllerListener(BaseControllerListener<Object> r100) {
        this.f255617f = r100;
    }

    public final void setHorizontalNestedScrollEnabled(boolean r100) {
        this.f255614c.f255628u = r100;
    }

    public final void setMaxScaleFactor(float r100) {
        ZoomableControllerImp r101 = this.f255614c;
        r101.getClass();
        if (r100 < 1.0f) goto L8;
        if (r100 < 1.0f) goto L9;
        r101.f550399f = r100;
        return;
    L9:
        return;
    }

    public final void setScaleFactorRetriever(uj6.c r100) {
        this.f255614c.f255627t = r100;
    }

    public final void setTapListener(GestureDetector.SimpleOnGestureListener r100) {
        this.f255616e.f560019a = r100;
    }

    public final void setTranslationEnabled(boolean r100) {
        this.f255614c.f550398e = r100;
    }

    public final void setZoomingEnabled(boolean r100) {
        this.f255614c.f550397d = r100;
    }

    @Override // com.facebook.drawee.view.GenericDraweeView
    public final void inflateHierarchy(Context r100, AttributeSet r101) {
        GenericDraweeHierarchyBuilder r102 = new GenericDraweeHierarchyBuilder(r100.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        GenericDraweeHierarchyInflater.updateBuilder(r102, r100, r101);
        setAspectRatio(r102.getDesiredAspectRatio());
        setHierarchy(r102.build());
    }

    public PhotoDraweeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f255612a = new RectF();
        this.f255613b = new RectF();
        this.f255618g = new a(this);
        b r103 = new b(this);
        ZoomableControllerImp r104 = f();
        this.f255614c = r104;
        r104.f550395b = r103;
        c r105 = new c(j());
        this.f255616e = r105;
        GestureDetector r106 = new GestureDetector(r100, r105);
        this.f255615d = r106;
        r106.setIsLongpressEnabled(true);
    }

    public /* synthetic */ PhotoDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        updateZoomableControllerBounds();
    }
}
