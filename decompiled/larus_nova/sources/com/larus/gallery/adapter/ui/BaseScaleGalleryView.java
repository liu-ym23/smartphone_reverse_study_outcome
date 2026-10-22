package com.larus.gallery.adapter.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.gallery.adapter.GalleryCenterStatusSaver;
import com.larus.gallery.adapter.r;
import com.larus.gallery.api.DisplayGravity;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002¥\u0001B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\b\u0002\u0010K\u001a\u000202H&J\b\u0010L\u001a\u00020HH\u0002J\b\u0010P\u001a\u00020HH\u0002J\b\u0010Q\u001a\u00020HH\u0002J\b\u0010R\u001a\u000202H\u0002J\n\u0010S\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010T\u001a\u00020HH\u0002J\b\u0010U\u001a\u00020HH\u0002J\u000e\u0010V\u001a\u00020H2\u0006\u0010\u0016\u001a\u00020!J\u0010\u0010W\u001a\u0002052\u0006\u00104\u001a\u000205H&J\u0010\u0010X\u001a\u00020H2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J4\u0010Y\u001a\u00020H2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\b\b\u0002\u0010\\\u001a\u0002002\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010:J%\u0010`\u001a\u00020H2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tH\u0000¢\u0006\u0002\bbJ \u0010c\u001a\u00020H2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u000200H\u0002J\u0012\u0010d\u001a\u00020H2\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u0016\u0010e\u001a\u00020H2\u0006\u0010f\u001a\u0002022\u0006\u0010g\u001a\u000202J0\u0010h\u001a\u00020H2\u0006\u0010i\u001a\u0002022\u0006\u0010j\u001a\u00020\t2\u0006\u0010k\u001a\u00020\t2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020\tH\u0014J\u0010\u0010n\u001a\u00020H2\u0006\u0010o\u001a\u00020'H\u0002J\u0010\u0010p\u001a\u0002022\u0006\u0010q\u001a\u00020rH\u0016J\u0010\u0010s\u001a\u00020H2\u0006\u0010t\u001a\u00020uH\u0014J\u0010\u0010v\u001a\u0002022\u0006\u0010w\u001a\u00020xH\u0002J\u0010\u0010y\u001a\u00020H2\u0006\u0010\u0016\u001a\u00020\u001eH\u0016J\u0010\u0010z\u001a\u00020H2\u0006\u0010\u0016\u001a\u00020\u001eH\u0016J\u000e\u0010{\u001a\u00020H2\u0006\u0010|\u001a\u000202J\u0006\u0010}\u001a\u00020HR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010(\u001a\u0004\u0018\u00010)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u000205X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010B\u001a\u0004\u0018\u00010A2\b\u0010(\u001a\u0004\u0018\u00010A8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010M\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010~\u001a\u00020\tX\u0096\u000f¢\u0006\u000f\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001e\u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001d\u0010\u0089\u0001\u001a\u000202X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001d\u0010\u008d\u0001\u001a\u000202X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u008d\u0001\u0010\u008a\u0001\"\u0006\b\u008e\u0001\u0010\u008c\u0001R\u001d\u0010\u008f\u0001\u001a\u000202X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u008f\u0001\u0010\u008a\u0001\"\u0006\b\u0090\u0001\u0010\u008c\u0001R\u001d\u0010\u0091\u0001\u001a\u00020JX\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001d\u0010\u0096\u0001\u001a\u00020\tX\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u0097\u0001\u0010\u0080\u0001\"\u0006\b\u0098\u0001\u0010\u0082\u0001R \u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001e\u0010\u009f\u0001\u001a\u00030 \u0001X\u0096\u000f¢\u0006\u0010\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001¨\u0006¦\u0001"}, d2 = {"Lcom/larus/gallery/adapter/ui/BaseScaleGalleryView;", "Landroid/widget/FrameLayout;", "Lcom/larus/common_ui/photoviewer/transition/TransitionView;", "Lcom/larus/common_ui/photoviewer/transition/ITransitionParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "controllerImp", "Lcom/larus/gallery/adapter/ui/GalleryZoomableControllerImpl;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/larus/gallery/adapter/ui/GalleryZoomableControllerImpl;)V", "getControllerImp", "()Lcom/larus/gallery/adapter/ui/GalleryZoomableControllerImpl;", "tag", "", "scalableView", "Landroid/view/View;", "getScalableView", "()Landroid/view/View;", "listener", "Lcom/larus/gallery/adapter/InternalGalleryItemListener;", "getListener", "()Lcom/larus/gallery/adapter/InternalGalleryItemListener;", "setListener", "(Lcom/larus/gallery/adapter/InternalGalleryItemListener;)V", "transitionListeners", "Ljava/util/LinkedHashSet;", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "Lkotlin/collections/LinkedHashSet;", "onViewChangedListener", "Lcom/larus/gallery/adapter/ui/BaseScaleGalleryView$OnViewChangedListener;", "gestureDetector", "Landroid/view/GestureDetector;", "tapListenerWrapper", "Lcom/larus/common_ui/photoviewer/gestures/GestureListenerWrapper;", "defaultGestureHandler", "Lcom/larus/common_ui/photoviewer/gestures/DefaultGestureHandler;", "value", "Lcom/larus/common_ui/photoviewer/ScaleFactorRetriever;", "scaleFactorRetriever", "getScaleFactorRetriever", "()Lcom/larus/common_ui/photoviewer/ScaleFactorRetriever;", "setScaleFactorRetriever", "(Lcom/larus/common_ui/photoviewer/ScaleFactorRetriever;)V", "startGravity", "Lcom/larus/gallery/api/DisplayGravity;", "isCentered", "", "isAnimating", "imageBounds", "Landroid/graphics/RectF;", "getImageBounds", "()Landroid/graphics/RectF;", "viewBounds", "centerStatusSaver", "Lcom/larus/gallery/adapter/GalleryCenterStatusSaver;", "mediaCanvasWidth", "mediaCanvasHeight", "mediaCanvasTopMargin", "isPageSelected", "centerCollectJob", "Lkotlinx/coroutines/Job;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "tapListener", "getTapListener", "()Landroid/view/GestureDetector$SimpleOnGestureListener;", "setTapListener", "(Landroid/view/GestureDetector$SimpleOnGestureListener;)V", "setCenteringProgress", "", "progress", "", "isReset", "resetScalableViewOffest", "transitionListenerWrapper", "originalLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "toggleFullscreen", "checkIfNeedChangeScaleOrPosition", "isGravitySameWithStart", "childView", "notifyScalableViewBottomChanged", "updateControllerImageBounds", "setOnViewChangedListener", "getScalableViewBounds", "bindListener", "updateScalableViewStartPosition", "width", "height", GXTemplateKey.GAIAX_LAYER_GRAVITY, "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "saver", "updateMediaCanvas", "topMargin", "updateMediaCanvas$gallery_mainlandRelease", "refreshScalableViewPosition", "observeCenterStatus", "setGestureConfig", "enableScale", "enableTransition", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "setGestureHandler", "gestureHandler", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "hasScale", "matrix", "Landroid/graphics/Matrix;", "addTransitionListener", "removeTransitionListener", "setIsPageSelected", "isSelected", "onViewDetachedFromWindow", "dismissAnimationType", "getDismissAnimationType", "()I", "setDismissAnimationType", "(I)V", "enterTransitionStartRect", "Landroid/graphics/Rect;", "getEnterTransitionStartRect", "()Landroid/graphics/Rect;", "setEnterTransitionStartRect", "(Landroid/graphics/Rect;)V", "isDismissAnimatedEnable", "()Z", "setDismissAnimatedEnable", "(Z)V", "isDragTransitionEnabled", "setDragTransitionEnabled", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "maxDragTransitionFactor", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "getPos", "setPos", "restoreTransitionProvider", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "getRestoreTransitionProvider", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "transitionAnimationDuration", "", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "OnViewChangedListener", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseScaleGalleryView extends FrameLayout implements l19.i, l19.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f343728u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f343729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f343730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f343731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<l19.f> f343732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GestureDetector f343733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k19.c f343734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k19.a f343735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j19.l f343736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DisplayGravity f343737i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f343738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f343739k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f343740l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f343741m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public GalleryCenterStatusSaver f343742n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f343743o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f343744p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f343745q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f343746r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Job f343747s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final FrameLayout.LayoutParams f343748t;

    public interface a {
    }

    public BaseScaleGalleryView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public BaseScaleGalleryView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public BaseScaleGalleryView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public abstract RectF a(RectF r100);

    public abstract View getScalableView();

    public abstract void i(float r100, boolean r101);

    @Override // l19.a
    public final boolean isSingleTagDismissEnabled() {
        this.f343729a.getClass();
        return false;
    }

    public void setDismissAnimatedEnable(boolean r100) {
        this.f343729a.getClass();
    }

    @Override // l19.a
    public void setEnterTransitionStartRect(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f343729a.setEnterTransitionStartRect(r100);
    }

    public final void setOnViewChangedListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // l19.a
    public void setSingleTagDismissEnabled(boolean r100) {
        this.f343729a.getClass();
    }

    public final boolean f() {
        boolean r100 = this.f343738j;
        if (r100 == true) goto L5;
    L6:
        if (r100 == false) goto L8;
    L10:
        return false;
    L8:
        if (this.f343737i == DisplayGravity.CENTER) goto L10;
    L9:
        return true;
    L5:
        if (this.f343737i == DisplayGravity.CENTER) goto L9;
        goto L6
    }

    public final void g() {
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f343730b, "onViewDetachedFromWindow");
        if (d(this.f343729a.f327679l) == false) goto L8;
        r100.i(this.f343730b, "onViewDetachedFromWindow: reset scale");
        this.f343729a.v(new Matrix());
        r r101 = this.f343731c;
        if (r101 == null) goto L9;
        r101.h(f());
        return;
    L9:
        return;
    }

    @Override // l19.a
    public int getDismissAnimationType() {
        return this.f343729a.R;
    }

    @Override // l19.a
    public Rect getEnterTransitionStartRect() {
        return this.f343729a.N;
    }

    @Override // l19.a
    public float getMaxDragTransitionFactor() {
        return this.f343729a.I.f496872d;
    }

    @Override // l19.a
    public int getPos() {
        return this.f343729a.Q;
    }

    @Override // l19.a
    public j19.e getRestoreTransitionProvider() {
        return this.f343729a.P;
    }

    public final GestureDetector.SimpleOnGestureListener getTapListener() {
        k19.c r100 = this.f343734f;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
        r100 = null;
    L6:
        return r100.f501391b;
    }

    @Override // l19.a
    public long getTransitionAnimationDuration() {
        return this.f343729a.K;
    }

    @Override // l19.a
    public final boolean isDragTransitionEnabled() {
        return this.f343729a.L;
    }

    @Override // l19.i
    public final View b() {
        return getScalableView();
    }

    public final p getControllerImp() {
        return this.f343729a;
    }

    public final RectF getImageBounds() {
        return this.f343740l;
    }

    public final r getListener() {
        return this.f343731c;
    }

    public final j19.l getScaleFactorRetriever() {
        return this.f343736h;
    }

    private final void setGestureHandler(k19.a r100) {
        this.f343735g = r100;
        k19.a r101 = this.f343735g;
        k19.c r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
        r101 = null;
    L5:
        this.f343734f = new k19.c(r101);
        Context r103 = getContext();
        k19.c r104 = this.f343734f;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
    L9:
        GestureDetector r105 = new GestureDetector(r103, r102);
        this.f343733e = r105;
        r105.setIsLongpressEnabled(true);
        r100.f501388c = this.f343736h;
        return;
    L8:
        r102 = r104;
        goto L9
    }

    @Override // l19.i
    public final void c(l19.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f343732d.add(r100);
    }

    public final boolean d(Matrix r100) {
        float[] r101 = new float[9];
        r100.getValues(r101);
        if (r101[0] <= 1.0f) goto L5;
    L6:
        return true;
    L5:
        if (r101[4] > 1.0f) goto L6;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        r100.concat(this.f343729a.f327679l);
        super.dispatchDraw(r100);
        r100.restore();
    }

    @Override // l19.i
    public final void e(l19.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f343732d.remove(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        GestureDetector r101 = this.f343733e;
        GestureDetector r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
        r101 = null;
    L5:
        r101.onTouchEvent(r100);
        if (this.f343729a.t(r100) == false) goto L9;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L9:
        getParent().requestDisallowInterceptTouchEvent(false);
        MotionEvent r103 = MotionEvent.obtain(r100);
        r103.setAction(3);
        this.f343729a.t(r103);
        GestureDetector r104 = this.f343733e;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
    L13:
        r102.onTouchEvent(r103);
        r103.recycle();
        return false;
    L12:
        r102 = r104;
        goto L13
    }

    @Override // l19.a
    public void setDismissAnimationType(int r100) {
        this.f343729a.R = r100;
    }

    @Override // l19.a
    public void setDragTransitionEnabled(boolean r100) {
        this.f343729a.L = r100;
    }

    public final void setIsPageSelected(boolean r100) {
        FLogger.f375446a.i(this.f343730b, "setIsPageSelected: isSelected " + r100);
        if (this.f343746r != r100) goto L5;
        return;
    L5:
        this.f343746r = r100;
    }

    public final void setListener(r r100) {
        this.f343731c = r100;
    }

    @Override // l19.a
    public void setMaxDragTransitionFactor(float r100) {
        this.f343729a.I.f496872d = r100;
    }

    @Override // l19.a
    public void setPos(int r100) {
        this.f343729a.Q = r100;
    }

    @Override // l19.a
    public void setRestoreTransitionProvider(j19.e r100) {
        this.f343729a.P = r100;
    }

    public final void setScaleFactorRetriever(j19.l r100) {
        this.f343736h = r100;
        k19.a r101 = this.f343735g;
        if (r101 == null) goto L8;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
        r101 = null;
    L6:
        r101.f501388c = r100;
        return;
    }

    public final void setTapListener(GestureDetector.SimpleOnGestureListener r100) {
        k19.c r101 = this.f343734f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
        r101 = null;
    L5:
        r101.f501391b = r100;
    }

    @Override // l19.a
    public void setTransitionAnimationDuration(long r100) {
        this.f343729a.K = r100;
    }

    public final void h(int r100, int r101, DisplayGravity r102) {
        if (f() == false) goto L5;
        View r103 = getScalableView();
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(r100, r101);
        r104.gravity = com.larus.gallery.api.c.a(r102);
        r103.setLayoutParams(r104);
        return;
    L5:
        getScalableView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public final void j(int r100, int r101, int r102) {
        if (r100 <= 0) goto L14;
        if (r101 > 0) goto L6;
        return;
    L6:
        if (this.f343743o == r100) goto L8;
    L12:
        this.f343743o = r100;
        this.f343744p = r101;
        this.f343745q = r102;
        this.f343737i = DisplayGravity.CENTER;
        this.f343738j = true;
        this.f343742n = null;
        View r103 = getScalableView();
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(r100, r101);
        r104.gravity = 49;
        r104.topMargin = r102;
        r103.setLayoutParams(r104);
        FrameLayout.LayoutParams r105 = this.f343748t;
        r105.width = r100;
        r105.height = r101;
        i(1.0f, true);
        requestLayout();
        return;
    L8:
        if (this.f343744p != r101) goto L12;
        if (this.f343745q != r102) goto L12;
        return;
    }

    public BaseScaleGalleryView(Context r100, AttributeSet r101, int r102, int r103) {
        p r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r104 = new p(new k19.e(), r100);
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "controllerImp");
        super(r100, r101, r102);
        this.f343729a = r104;
        this.f343730b = getClass().getSimpleName() + hashCode();
        this.f343732d = new LinkedHashSet();
        this.f343737i = DisplayGravity.CENTER;
        this.f343738j = true;
        this.f343740l = new RectF();
        this.f343741m = new RectF();
        this.f343746r = true;
        h r105 = new h(this);
        r104.c(r105);
        setScaleFactorRetriever(new j19.a(r104));
        setGestureHandler(new k19.a(r104));
        r104.g(3.0f);
        r104.f(true);
        r104.f327661v = true;
        r104.c(r105);
        r104.f327669b = new com.larus.gallery.adapter.ui.a(this);
        setTapListener(new d(this));
        r104.A = new e(this);
        this.f343748t = new FrameLayout.LayoutParams(-2, -2);
    }

    public final void k(int r110, int r111, DisplayGravity r112, CoroutineScope r113, GalleryCenterStatusSaver r114) {
        Intrinsics.checkNotNullParameter(r112, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        this.f343737i = r112;
        boolean r100 = false;
        if (r112 != DisplayGravity.CENTER) goto L5;
        boolean r101 = true;
    L6:
        float r102 = 1.0f;
        if (r101 == true) goto L20;
        if (r114 == null) goto L12;
        b1 r103 = r114.f343656d;
        if (r103 == null) goto L12;
        r100 = ((Boolean) r103.getValue()).booleanValue();
    L12:
        this.f343738j = r100;
        this.f343742n = r114;
        h(r110, r111, r112);
        Job r115 = null;
        if (r113 == null) goto L15;
        r115 = BuildersKt.launch$default(r113, null, null, new BaseScaleGalleryView$observeCenterStatus$1(this, null), 3, null);
    L15:
        this.f343747s = r115;
        if (this.f343738j == true) goto L19;
        r102 = 0.0f;
    L19:
        i(r102, true);
    L21:
        FrameLayout.LayoutParams r116 = this.f343748t;
        r116.width = r110;
        r116.height = r111;
        FLogger.f375446a.i(this.f343730b, "updateScalableViewStartPosition: width " + r110 + ", height " + r111 + ", gravity " + r112 + ", isCentered " + this.f343738j);
        return;
    L20:
        this.f343738j = true;
        h(r110, r111, r112);
        i(1.0f, false);
        goto L21
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = r104 - r102;
        int r106 = r103 - r101;
        a(this.f343740l);
        this.f343740l.offset(getScalableView().getLeft(), getScalableView().getTop());
        p r107 = this.f343729a;
        RectF r108 = this.f343740l;
        if (r108.equals(r107.f327677j) == true) goto L5;
        r107.f327679l.reset();
        r107.f327677j.set(r108);
        r107.i();
        r107.d();
    L5:
        this.f343741m.set(0.0f, 0.0f, r106, r105);
        this.f343729a.h(this.f343741m);
    }
}
