package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class FrescoImageView extends SimpleDraweeView implements x6a.e {
    public static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
    private boolean mAutoPlay;
    private m8a.d mBigImageHelper;
    private BorderRadius mBorderRadii;
    private final Object mCallerContext;
    private boolean mConsumeHoverEvent;
    private ControllerListener mControllerForTesting;
    private ControllerListener mControllerListener;
    private boolean mCoverStart;
    private ImageRequest mCurImageRequest;
    private boolean mDeferInvalidation;
    private boolean mDisableDefaultPlaceholder;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private int mFadeDurationMs;
    private boolean mFixFrescoBug;
    private boolean mFrescoNinePatch;
    private e mGlobalImageLoadListener;
    private h mImageDelegate;
    private int mImageOrigin;
    private m mImageRequestBuilderHook;
    protected boolean mIsBorderRadiusDirty;
    protected boolean mIsDirty;
    public boolean mIsFrescoAttach;
    public boolean mIsFrescoVisible;
    private boolean mIsNoSubSampleMode;
    private boolean mIsPixelated;
    private l mLoaderCallback;
    private LynxBaseUI mLynxBaseUI;
    private int mOverlayColor;
    private float mPreFetchHeight;
    private float mPreFetchWidth;
    private CloseableReference<?> mRef;
    private x6a.i mRenderer;
    private boolean mRepeat;
    private ScalingUtils.ScaleType mScaleType;
    private int mShowCnt;
    private int mSourceImageHeight;
    private int mSourceImageWidth;
    private long mStartTimeStamp;
    private CloseableReference<Bitmap> mTempPlaceHolder;
    private boolean mUsePostprocessorScaling;

    public class a implements h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrescoImageView f383830a;

        @Override // com.lynx.tasm.ui.image.h.c
        public final void a() {
            this.f383830a.maybeUpdateView();
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final void clear() {
            this.f383830a.setController(null);
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final void d() {
            FrescoImageView r100 = this.f383830a;
            FrescoImageView.access$500(r100, r100.getWidth(), this.f383830a.getHeight(), this.f383830a.getPaddingLeft(), this.f383830a.getPaddingTop(), this.f383830a.getPaddingRight(), this.f383830a.getPaddingBottom());
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final boolean e() {
            return FrescoImageView.access$300(this.f383830a);
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final void g() {
            FrescoImageView.access$000(this.f383830a);
            if (FrescoImageView.access$100(this.f383830a) == null) goto L6;
            FrescoImageView.access$100(this.f383830a).close();
            FrescoImageView.access$102(this.f383830a, null);
        L6:
            if (FrescoImageView.access$200(this.f383830a) == null) goto L12;
            GenericDraweeHierarchy r100 = this.f383830a.getHierarchy();
            if (r100 == null) goto L10;
            r100.setPlaceholderImage(null);
        L10:
            FrescoImageView.access$200(this.f383830a).close();
            FrescoImageView.access$202(this.f383830a, null);
            return;
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final void markDirty() {
            this.f383830a.markDirty();
        }

        public a(FrescoImageView r100) {
            this.f383830a = r100;
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final void b(List<Postprocessor> r100) {
            this.f383830a.onPostprocessorPreparing(r100);
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final ImageRequestBuilder c(Uri r100) {
            return this.f383830a.createImageRequestBuilder(r100);
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final void f(CloseableReference<?> r100) {
            Bitmap r101 = null;
            if (FrescoImageView.access$100(this.f383830a) == null) goto L5;
            FrescoImageView.access$100(this.f383830a).close();
            FrescoImageView.access$102(this.f383830a, null);
        L5:
            FrescoImageView.access$102(this.f383830a, r100.clone());
            if (FrescoImageView.access$400(this.f383830a) != null) goto L8;
        L20:
            this.f383830a.postInvalidate();
            return;
        L8:
            if (FrescoImageView.access$100(this.f383830a) == null) goto L20;
            Object r102 = FrescoImageView.access$100(this.f383830a).get();
            if ((r102 instanceof CloseableBitmap) == false) goto L13;
            r101 = ((CloseableBitmap) r102).getUnderlyingBitmap();
        L15:
            if (r101 != null) goto L17;
        L19:
            LLog.e("FrescoImageView", "onLocalCacheGet error bitmap is null or recycled");
            goto L20
        L17:
            if (r101.isRecycled() == true) goto L19;
            FrescoImageView.access$400(this.f383830a).onImageLoadSuccess(r101.getWidth(), r101.getHeight());
            goto L20
        L13:
            if ((r102 instanceof Bitmap) == false) goto L15;
            r101 = (Bitmap) r102;
            goto L15
        }
    }

    public class b extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f383831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f383832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FrescoImageView f383833c;

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r110, Throwable r111) {
            if (FrescoImageView.access$900(this.f383833c).m(this.f383832b) == false) goto L5;
            return;
        L5:
            this.f383833c.mIsDirty = true;
            int r100 = u7a.b.a(r111);
            int r101 = u7a.b.b(r100);
            if (FrescoImageView.access$400(this.f383833c) == null) goto L15;
            LynxError r102 = new LynxError(r101, "Android FrescoImageView loading image failed", "", "error");
            if (r111 == null) goto L11;
            r102.setRootCause(r111.getMessage());
        L11:
            if (FrescoImageView.access$1200(this.f383833c) == null) goto L13;
            int r103 = FrescoImageView.access$1200(this.f383833c).getNodeIndex();
        L14:
            r102.addCustomInfo("node_index", Integer.toString(r103));
            FrescoImageView.access$400(this.f383833c).onImageLoadFailed(r102, r101, r100);
            goto L15
        L13:
            r103 = 0;
        L15:
            FrescoImageView.access$1002(this.f383833c, -1);
            long r112 = System.currentTimeMillis();
            FrescoImageView.access$900(this.f383833c).j(FrescoImageView.access$900(this.f383833c).f383984v, false, FrescoImageView.access$1100(this.f383833c), r112, 0, null);
            FrescoImageView.access$900(this.f383833c).l(FrescoImageView.access$900(this.f383833c).f383984v, false, false, FrescoImageView.access$1100(this.f383833c), r112, r100, 0);
            FrescoImageView.access$900(this.f383833c).k(FrescoImageView.access$900(this.f383833c).f383984v, r100, false, FrescoImageView.access$1000(this.f383833c), FrescoImageView.access$1100(this.f383833c), r112, false, 0, 0);
            h r104 = FrescoImageView.access$900(this.f383833c);
            FrescoImageView.access$1100(this.f383833c);
            FrescoImageView.access$1000(this.f383833c);
            r111.getMessage();
            r104.getClass();
            LLog.e("FrescoImageView", "onFailed src:" + this.f383832b + "with reason" + r111.getMessage());
        }

        public b(FrescoImageView r100, WeakReference r101, String r102) {
            this.f383833c = r100;
            this.f383831a = r101;
            this.f383832b = r102;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r110, Object r111, Animatable r112) {
            ImageInfo r100 = (ImageInfo) r111;
            if (this.f383831a.get() == null) goto L6;
            ((FrescoImageView) this.f383831a.get()).onImageRequestLoaded();
        L6:
            if (FrescoImageView.access$600(this.f383833c) == false) goto L20;
            if ((r100 instanceof CloseableStaticBitmap) == false) goto L20;
            if (FrescoImageView.access$200(this.f383833c) == null) goto L12;
            FrescoImageView.access$200(this.f383833c).close();
            FrescoImageView.access$202(this.f383833c, null);
        L12:
            FrescoImageView.access$202(this.f383833c, ((CloseableStaticBitmap) r100).cloneUnderlyingBitmapReference());
            GenericDraweeHierarchy r113 = this.f383833c.getHierarchy();
            if (r113 == null) goto L20;
            if (FrescoImageView.access$200(this.f383833c) == null) goto L20;
            if (FrescoImageView.access$200(this.f383833c).get() == null) goto L20;
            r113.setPlaceholderImage(new ScaleTypeDrawable(new BitmapDrawable(this.f383833c.getResources(), (Bitmap) FrescoImageView.access$200(this.f383833c).get()), FrescoImageView.access$700(this.f383833c)));
        L20:
            if (FrescoImageView.access$800(this.f383833c) == false) goto L25;
            if (this.f383833c.getTopLevelDrawable() == null) goto L25;
            this.f383833c.getTopLevelDrawable().setFilterBitmap(false);
        L25:
            if (FrescoImageView.access$900(this.f383833c).f383980r0 == null) goto L28;
            if (r100 == null) goto L28;
            FrescoImageView r114 = this.f383833c;
            FrescoImageView.access$1002(r114, FrescoImageView.access$900(r114).f383980r0.getImageOrigin(r100));
        L28:
            FrescoImageView.access$900(this.f383833c).h(this.f383833c.getWidth(), this.f383833c.getHeight(), r100, r112, FrescoImageView.access$1100(this.f383833c), false, FrescoImageView.access$1000(this.f383833c), FrescoImageView.access$400(this.f383833c));
        }
    }

    public class c implements m8a.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrescoImageView f383834a;

        @Override // m8a.d.b
        public final void onImageLoadFailed(String r100) {
        }

        public c(FrescoImageView r100) {
            this.f383834a = r100;
        }

        @Override // m8a.d.b
        public final void onImageLoadSuccess(m8a.d.c r100) {
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            this.f383834a.invalidate();
            return;
        L5:
            this.f383834a.postInvalidate();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f383836b;

        public d(int r100, int r101) {
            this.f383835a = r100;
            this.f383836b = r101;
        }
    }

    public /* bridge */ /* synthetic */ void applyRendererClipBounds(boolean r100, Rect r101) {
        x6a.d.a(this, r100, r101);
    }

    public /* bridge */ /* synthetic */ void applyRendererOpacity(float r100) {
        x6a.d.b(this, r100);
    }

    public /* bridge */ /* synthetic */ void applyRendererTransform(float[] r100) {
        x6a.d.c(this, r100);
    }

    public /* bridge */ /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r100) {
        return x6a.d.d(this, r100);
    }

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // x6a.e
    public View getView() {
        return this;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public /* bridge */ /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r100, ReadableMap r101, Callback r102) {
        return false;
    }

    public void markDirty() {
        this.mIsDirty = true;
    }

    public void onImageRequestLoaded() {
    }

    public void onPostprocessorPreparing(List<Postprocessor> r100) {
    }

    public /* bridge */ /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    public void setImageRequestBuilderHook(m r100) {
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    private void onSourceSetted() {
        int r100 = this.mShowCnt + 1;
        this.mShowCnt = r100;
        m8a.d r101 = this.mBigImageHelper;
        if (r101 == null) goto L6;
        r101.f512505d = r100;
        r101.f();
        return;
    }

    public void destroy() {
        m8a.d r100 = this.mBigImageHelper;
        if (r100 == null) goto L5;
        r100.f();
    L5:
        CloseableReference<?> r101 = this.mRef;
        if (r101 == null) goto L8;
        r101.close();
        this.mRef = null;
    L8:
        h r102 = this.mImageDelegate;
        r102.f383951d = 0;
        r102.f383953e = 0;
        if (this.mTempPlaceHolder == null) goto L15;
        GenericDraweeHierarchy r103 = getHierarchy();
        if (r103 == null) goto L13;
        r103.setPlaceholderImage(null);
    L13:
        this.mTempPlaceHolder.close();
        this.mTempPlaceHolder = null;
        return;
    }

    public long getBitmapMemorySizeBytes() {
        h r100 = this.mImageDelegate;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f383977q;
    }

    public int getLoopCount() {
        return this.mImageDelegate.N;
    }

    public String getSrc() {
        m8a.g r100 = this.mImageDelegate.f383986x;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.b().toString();
    }

    public void maybeUpdateView() {
        if (this.mIsDirty == false) goto L11;
        if (getWidth() <= 0) goto L9;
        if (getHeight() <= 0) goto L9;
    L16:
        if (getWidth() > 0) goto L18;
    L20:
        tryFetchImage((int) this.mPreFetchWidth, (int) this.mPreFetchHeight, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L18:
        if (getHeight() <= 0) goto L20;
        maybeUpdateViewInternal(getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L9:
        if (this.mImageDelegate.f383969m == true) goto L16;
    L11:
        if (this.mPreFetchWidth > 0.0f) goto L16;
        if (this.mPreFetchHeight > 0.0f) goto L16;
    }

    public void onNodeReady() {
        h r100 = this.mImageDelegate;
        if (r100.W == false) goto L8;
        r100.W = false;
        if (r100.f383969m == false) goto L9;
        r100.i();
        return;
    L9:
        return;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void onAttach() {
        this.mStartTimeStamp = System.currentTimeMillis();
        super.onAttach();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsFrescoVisible == false) goto L6;
        setFrescoVisible();
    L6:
        if (this.mIsFrescoAttach == false) goto L9;
        setFrescoAttach();
        return;
    }

    public boolean pauseAnimate() {
        if (getController() != null) goto L5;
        return false;
    L5:
        if (getController().getAnimatable() == null) goto L12;
        Animatable r100 = getController().getAnimatable();
        if ((r100 instanceof AnimatedDrawable2) == true) goto L9;
        return false;
    L9:
        return m8a.e.d((AnimatedDrawable2) r100);
    L12:
        return false;
    }

    public void setFrescoVisible() {
        Drawable r100 = getDrawable();
        if (r100 == null) goto L6;
        r100.setVisible(true, false);
        return;
    }

    public void startAnimate() {
        if (getController() != null) goto L5;
        return;
    L5:
        if (getController().getAnimatable() == null) goto L9;
        getController().getAnimatable().start();
        return;
    }

    public void stopAnimate() {
        if (getController() != null) goto L5;
        return;
    L5:
        if (getController().getAnimatable() == null) goto L9;
        getController().getAnimatable().stop();
        return;
    }

    public ScalingUtils.ScaleType getFrescoScaleType() {
        return this.mScaleType;
    }

    @Override // x6a.e
    public x6a.i getRenderer() {
        return this.mRenderer;
    }

    public void setFrescoAttach() {
        doAttach();
    }

    public static /* synthetic */ void access$000(FrescoImageView r100) {
        r100.onSourceSetted();
    }

    public static /* synthetic */ CloseableReference access$100(FrescoImageView r100) {
        return r100.mRef;
    }

    public static /* synthetic */ int access$1000(FrescoImageView r100) {
        return r100.mImageOrigin;
    }

    public static /* synthetic */ long access$1100(FrescoImageView r100) {
        return r100.mStartTimeStamp;
    }

    public static /* synthetic */ LynxBaseUI access$1200(FrescoImageView r100) {
        return r100.mLynxBaseUI;
    }

    public static /* synthetic */ CloseableReference access$200(FrescoImageView r100) {
        return r100.mTempPlaceHolder;
    }

    public static /* synthetic */ boolean access$300(FrescoImageView r100) {
        return r100.mUsePostprocessorScaling;
    }

    public static /* synthetic */ l access$400(FrescoImageView r100) {
        return r100.mLoaderCallback;
    }

    public static /* synthetic */ boolean access$600(FrescoImageView r100) {
        return r100.mDisableDefaultPlaceholder;
    }

    public static /* synthetic */ ScalingUtils.ScaleType access$700(FrescoImageView r100) {
        return r100.mScaleType;
    }

    public static /* synthetic */ boolean access$800(FrescoImageView r100) {
        return r100.mIsPixelated;
    }

    public static /* synthetic */ h access$900(FrescoImageView r100) {
        return r100.mImageDelegate;
    }

    private float[] adjustBorderRadiusArrayWithPadding(float[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length != 8) goto L13;
        float[] r101 = new float[8];
        int r102 = 0;
        r101[0] = getPaddingLeft();
        r101[1] = getPaddingTop();
        r101[2] = getPaddingRight();
        r101[3] = getPaddingTop();
        r101[4] = getPaddingRight();
        r101[5] = getPaddingBottom();
        r101[6] = getPaddingLeft();
        r101[7] = getPaddingBottom();
    L7:
        if (r102 >= 8) goto L9;
        r101[r102] = Math.max(0.0f, r100[r102] - r101[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    L13:
        return null;
    }

    private static GenericDraweeHierarchy buildHierarchy(Context r100) {
        return new GenericDraweeHierarchyBuilder(r100.getResources()).setRoundingParams(null).build();
    }

    public ImageRequestBuilder createImageRequestBuilder(Uri r100) {
        return this.mImageDelegate.e(r100);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
        x6a.i r101 = this.mRenderer;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public void fixFrescoWebPBug(boolean r100) {
        this.mFixFrescoBug = r100;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r110) {
        prepareRendererForDraw(r110);
        l r100 = this.mLoaderCallback;
        if (r100 == null) goto L7;
        r100.onImageDstSize(getWidth(), getHeight());
        if (this.mLoaderCallback.isPendingLoad() == false) goto L7;
        return;
    L7:
        CloseableReference<?> r101 = this.mRef;
        if (r101 == null) goto L26;
        if (r101.isValid() == false) goto L26;
        if (this.mImageDelegate.f383982t == false) goto L26;
        Object r102 = this.mRef.get();
        if ((r102 instanceof CloseableBitmap) == false) goto L18;
        Bitmap r103 = ((CloseableBitmap) r102).getUnderlyingBitmap();
    L16:
        Bitmap r111 = r103;
        if (r111 == null) goto L26;
        LLog.i("Lynx Android Image", "draw image from local cache");
        int r104 = r110.getWidth();
        int r105 = r110.getHeight();
        int r106 = r111.getWidth();
        int r107 = r111.getHeight();
        ScalingUtils.ScaleType r108 = this.mScaleType;
        h r109 = this.mImageDelegate;
        if (l8a.a.customDraw(r104, r105, r106, r107, r108, r109.f383957g, r109.f383959h, r110, r111) == false) goto L26;
        return;
    L18:
        if ((r102 instanceof Bitmap) == false) goto L20;
        r103 = (Bitmap) r102;
        goto L16
    L20:
        r103 = null;
    L26:
        if (this.mFrescoNinePatch == true) goto L38;
        if (this.mImageDelegate.f383957g == null) goto L38;
        if (LynxEnv.inst().disableBigImageHelper() == true) goto L38;
        LLog.i("Lynx Android Image", "load origin bitmap to draw image with cap-insets");
        if (this.mBigImageHelper != null) goto L34;
        this.mBigImageHelper = new m8a.d(new c(this), this.mShowCnt);
    L34:
        int r112 = this.mShowCnt;
        float r113 = getWidth();
        float r114 = getHeight();
        boolean r115 = this.mRepeat;
        ScalingUtils.ScaleType r116 = this.mScaleType;
        String r117 = getSrc();
        Point r118 = m8a.d.l(r110);
        h r119 = this.mImageDelegate;
        if (this.mBigImageHelper.i(getContext(), r110, this.mCurImageRequest, new m8a.d.a(r112, r113, r114, r115, r116, r117, r118, r119.f383957g, r119.f383959h)) == false) goto L38;
        return;
    L38:
        if (TraceEvent.isTracingStarted() == false) goto L54;
        HashMap r120 = new HashMap();
        LynxBaseUI r121 = this.mLynxBaseUI;
        if (r121 != null) goto L42;
    L44:
        String r122 = this.mImageDelegate.f383984v;
        if (r122 != null) goto L47;
    L49:
        boolean r123 = false;
    L50:
        if (r123 == false) goto L52;
        r120.put("src", this.mImageDelegate.f383984v);
    L52:
        TraceEvent.beginSection("FrescoImageView.onDraw", r120);
        goto L54
    L47:
        if (r122.startsWith("http") == false) goto L49;
        r123 = true;
        goto L50
    L42:
        if (r121.getLynxContext() == null) goto L44;
        r120.put("instance_id", String.valueOf(this.mLynxBaseUI.getLynxContext().getInstanceId()));
    L54:
        if (LynxEnv.inst().disableBigImageHelper() == false) goto L56;
    L90:
        super.onDraw(r110);     // Catch: OutOfMemoryError -> L84
    L87:
        if (TraceEvent.isTracingStarted() == false) goto L94;
        TraceEvent.endSection("FrescoImageView.onDraw");
        return;
    L94:
        return;
    L84:
        e = move-exception;
        LLog.e("FrescoImageView", e.getMessage());
        goto L87
    L56:
        if (this.mIsNoSubSampleMode == true) goto L64;
        if (getController() == null) goto L90;
        if (getController().getAnimatable() != null) goto L90;
        if (this.mImageDelegate.f383957g != null) goto L90;
    L64:
        if (this.mBigImageHelper != null) goto L66;
        this.mBigImageHelper = new m8a.d(new c(this), this.mShowCnt);
    L66:
        int r124 = this.mShowCnt;
        float r125 = getWidth();
        float r126 = getHeight();
        boolean r127 = this.mRepeat;
        ScalingUtils.ScaleType r128 = this.mScaleType;
        String r129 = getSrc();
        Point r130 = m8a.d.l(r110);
        h r131 = this.mImageDelegate;
        m8a.d.a r132 = new m8a.d.a(r124, r125, r126, r127, r128, r129, r130, r131.f383957g, r131.f383959h);
        if (this.mIsNoSubSampleMode == false) goto L72;
        this.mBigImageHelper.j(getContext(), r110, this.mCurImageRequest, r132);
        if (TraceEvent.isTracingStarted() == false) goto L92;
        TraceEvent.endSection("FrescoImageView.onDraw");
        return;
    L92:
        return;
    L72:
        LynxBaseUI r133 = this.mLynxBaseUI;
        if (r133 != null) goto L75;
        DisplayMetrics r134 = DisplayMetricsHolder.getRealScreenDisplayMetrics(getContext());
    L77:
        if (this.mBigImageHelper.h(getContext(), r110, this.mCurImageRequest, r132, r134) == false) goto L90;
        if (TraceEvent.isTracingStarted() == false) goto L93;
        TraceEvent.endSection("FrescoImageView.onDraw");
        return;
    L93:
        return;
    L75:
        r134 = r133.getLynxContext().getScreenMetrics();
        goto L77
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r100) {
        if (super.onHoverEvent(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mConsumeHoverEvent == true) goto L8;
        return false;
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    L4:
        th = move-exception;
        LLog.e("Lynx FrescoImageView", "catch onTouchEvent exception: " + th.toString());
        return false;
    }

    public void prepareRendererForDraw(Canvas r100) {
        if (this.mRenderer == null) goto L6;
        this.mRenderer.g(r100);
        this.mRenderer.c(r100);
        return;
    }

    public void setAsyncRedirect(boolean r100) {
        this.mImageDelegate.X = r100;
    }

    public void setAutoPlay(boolean r100) {
        this.mAutoPlay = r100;
    }

    public void setAutoSize(boolean r100) {
        h r101 = this.mImageDelegate;
        r101.f383969m = r100;
        if (r100 == true) goto L5;
    L8:
        r101.i();
    L9:
        r101.A.markDirty();
        return;
    L5:
        if (r101.f383953e == 0) goto L9;
        if (r101.f383951d == 0) goto L9;
        goto L8
    }

    public void setAwaitLocalCache(boolean r100) {
        this.mImageDelegate.f383983u = r100;
    }

    public void setBitmapConfig(Bitmap.Config r100) {
        h r101 = this.mImageDelegate;
        r101.f383975p = r100;
        r101.A.markDirty();
    }

    public void setBlurRadius(int r100) {
        this.mImageDelegate.p(r100);
    }

    public void setBorderRadius(BorderRadius r100) {
        this.mBorderRadii = r100;
        this.mIsDirty = true;
        this.mIsBorderRadiusDirty = true;
    }

    public void setCacheKeyPathOnly(boolean r100) {
        this.mImageDelegate.f383967l = r100;
    }

    public void setCapInsets(String r100) {
        h r101 = this.mImageDelegate;
        r101.f383957g = r100;
        r101.A.markDirty();
    }

    public void setCapInsetsScale(String r100) {
        h r101 = this.mImageDelegate;
        r101.f383959h = r100;
        r101.A.markDirty();
    }

    public void setConsumeHoverEvent(boolean r100) {
        this.mConsumeHoverEvent = r100;
    }

    public void setControllerListener(ControllerListener r100) {
        this.mControllerForTesting = r100;
        this.mIsDirty = true;
        maybeUpdateView();
    }

    public void setCoverStart(boolean r100) {
        this.mCoverStart = r100;
        this.mIsDirty = true;
    }

    public void setDeferInvalidation(boolean r100) {
        this.mDeferInvalidation = r100;
    }

    public void setDisableDefaultPlaceHolder(boolean r100) {
        this.mDisableDefaultPlaceholder = r100;
    }

    public void setEnableCustomGifDecoder(boolean r100) {
        this.mImageDelegate.V = r100;
    }

    public void setEnableImageSR(boolean r100) {
        h r101 = this.mImageDelegate;
        r101.Y = r100;
        r101.f383975p = Bitmap.Config.ARGB_8888;
    }

    public void setEnableReportInfo(boolean r100) {
        this.mImageDelegate.Q = r100;
    }

    public void setEnableResourceHint(boolean r100) {
        this.mImageDelegate.f383955f = r100;
    }

    public void setExtraLoadInfo(boolean r100) {
        this.mImageDelegate.P = r100;
    }

    public void setFadeDuration(int r100) {
        this.mFadeDurationMs = r100;
    }

    public void setFrescoNinePatch(boolean r100) {
        this.mFrescoNinePatch = r100;
    }

    public void setHeaders(ReadableMap r100) {
        this.mImageDelegate.C = r100;
    }

    public void setImageCacheChoice(String r100) {
        this.mImageDelegate.f383963j = r100;
    }

    public void setImageCustomParams(ReadableMap r100) {
        this.mImageDelegate.q(r100);
    }

    public void setImageEvents(Map<String, EventsListener> r100) {
        this.mImageDelegate.r(r100);
    }

    public void setImageLoaderCallback(l r100) {
        this.mLoaderCallback = r100;
    }

    public void setImagePlaceHolderHashConfig(ReadableMap r100) {
        this.mImageDelegate.s(r100);
    }

    public void setImageRedirectListener(f r100) {
        this.mImageDelegate.f383988z = r100;
    }

    public void setImageRequestPriority(String r100) {
        this.mImageDelegate.f383961i = r100;
    }

    public void setImageSRScale(float r100) {
        h r101 = this.mImageDelegate;
        if (r100 <= 0.0f) goto L5;
        r101.Y = true;
        r101.f383975p = Bitmap.Config.ARGB_8888;
        r101.Z = r100;
        return;
    L5:
        r101.Y = false;
        r101.Z = 0.0f;
    }

    public void setImageTransitionStyle(String r100) {
        if ("fadeIn".equals(r100) == false) goto L5;
        this.mFadeDurationMs = 300;
        return;
    L5:
        this.mFadeDurationMs = 0;
    }

    public void setIsPixelated(boolean r100) {
        this.mIsPixelated = r100;
        this.mIsDirty = true;
    }

    public void setLocalCache(boolean r100) {
        this.mImageDelegate.f383982t = r100;
    }

    public void setLoopCount(int r100) {
        this.mImageDelegate.N = r100;
    }

    public void setLynxBaseUI(LynxBaseUI r100) {
        this.mLynxBaseUI = r100;
        this.mImageDelegate.E = r100;
    }

    public void setNoSubSampleMode(boolean r100) {
        this.mIsNoSubSampleMode = r100;
        this.mImageDelegate.f383972n0 = r100;
    }

    public void setOverlayColor(int r100) {
        this.mOverlayColor = r100;
        this.mIsDirty = true;
    }

    public void setPlaceholder(String r100) {
        this.mImageDelegate.u(null, r100);
    }

    public void setPreFetchHeight(float r100) {
        this.mPreFetchHeight = r100;
    }

    public void setPreFetchWidth(float r100) {
        this.mPreFetchWidth = r100;
    }

    public void setProgressiveRendering(boolean r100) {
        this.mImageDelegate.f383968l0 = r100;
    }

    public void setProgressiveRenderingEnabled(boolean r100) {
        this.mImageDelegate.f383973o = r100;
    }

    public void setRegionToDecode(Rect r100) {
        h r101 = this.mImageDelegate;
        if (r100 != null) goto L5;
        r101.f383970m0 = null;
    L6:
        this.mIsDirty = true;
        return;
    L5:
        r101.getClass();
        r101.f383970m0 = new Rect(r100);
        goto L6
    }

    @Override // x6a.e
    public void setRenderer(x6a.i r100) {
        this.mRenderer = r100;
    }

    public void setRepeat(boolean r100) {
        this.mRepeat = r100;
    }

    public void setResizeMethod(ImageResizeMethod r100) {
        h r101 = this.mImageDelegate;
        r101.f383979r = r100;
        r101.A.markDirty();
    }

    public void setScaleType(ScalingUtils.ScaleType r100) {
        this.mScaleType = r100;
        this.mIsDirty = true;
    }

    public void setSimpleCacheKey(boolean r100) {
        this.mImageDelegate.f383965k = r100;
    }

    public void setSmoothAnimation(boolean r100) {
        this.mImageDelegate.O = r100;
    }

    public void setSource(String r100) {
        this.mImageDelegate.w(r100);
    }

    public void setSrc(String r100) {
        this.mImageDelegate.v(r100, true);
    }

    public void setSrcSkippingRedirection(String r100) {
        this.mImageDelegate.v(r100, false);
    }

    public void setTintColor(String r100) {
        if (ColorUtils.a(r100) == true) goto L5;
        PorterDuffColorFilter r101 = null;
    L7:
        if (getHierarchy() == null) goto L10;
        getHierarchy().setActualImageColorFilter(r101);
        return;
    L10:
        return;
    L5:
        r101 = new PorterDuffColorFilter(ColorUtils.b(r100), PorterDuff.Mode.SRC_IN);
        goto L7
    }

    public static /* synthetic */ int access$1002(FrescoImageView r100, int r101) {
        r100.mImageOrigin = r101;
        return r101;
    }

    public static /* synthetic */ CloseableReference access$102(FrescoImageView r100, CloseableReference r101) {
        r100.mRef = r101;
        return r101;
    }

    public static /* synthetic */ CloseableReference access$202(FrescoImageView r100, CloseableReference r101) {
        r100.mTempPlaceHolder = r101;
        return r101;
    }

    public int bitmapMemorySize(int r100, int r101) {
        h r102 = this.mImageDelegate;
        if (r102 != null) goto L7;
        return 0;
    L7:
        return r102.c(r100, r101);
    }

    @Override // x6a.e
    public x6a.i createRenderer(PlatformRendererContext r100, int r101) {
        return new x6a.i(r100, r101);
    }

    public void setPlaceholder(String r100, boolean r101) {
        h r102 = this.mImageDelegate;
        if (r101 == false) goto L5;
        r102.u(null, r100);
        return;
    L5:
        r102.t(r100);
    }

    public void setRedirectImageSource(String r100, String r101) {
        this.mImageDelegate.u(r100, r101);
    }

    public FrescoImageView(Context r100, AbstractDraweeControllerBuilder r101, e r102, Object r110) {
        this(r100, r101, r102, r110, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L7;
        if (r101 <= 0) goto L8;
        maybeUpdateView();
        return;
    L8:
        return;
    }

    public void updateRedirectCheckResult(String r100, String r101, boolean r102, boolean r103) {
        this.mImageDelegate.z(r100, r101, r102, r103);
    }

    public FrescoImageView(Context r100, AbstractDraweeControllerBuilder r101, e r102, Object r103, LynxBaseUI r104) {
        super(r100, buildHierarchy(r100));
        this.mUsePostprocessorScaling = false;
        this.mSourceImageWidth = 0;
        this.mSourceImageHeight = 0;
        this.mPreFetchWidth = -1.0f;
        this.mPreFetchHeight = -1.0f;
        this.mIsFrescoVisible = false;
        this.mIsFrescoAttach = false;
        this.mFrescoNinePatch = false;
        this.mAutoPlay = true;
        this.mIsPixelated = false;
        this.mFadeDurationMs = 0;
        this.mBorderRadii = null;
        this.mIsNoSubSampleMode = false;
        this.mRef = null;
        this.mDisableDefaultPlaceholder = false;
        this.mTempPlaceHolder = null;
        this.mConsumeHoverEvent = false;
        this.mLynxBaseUI = null;
        this.mImageOrigin = -1;
        this.mScaleType = ScalingUtils.ScaleType.FIT_XY;
        this.mDraweeControllerBuilder = r101;
        this.mCallerContext = r103;
        this.mShowCnt = 0;
        this.mRepeat = false;
        this.mCoverStart = false;
        h r105 = new h(r100, new a(this));
        this.mImageDelegate = r105;
        r105.f383962i0 = getHierarchy();
        setLynxBaseUI(r104);
    }

    @Override // android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (r100 == false) goto L8;
        x6a.i r105 = this.mRenderer;
        if (r105 == null) goto L8;
        LynxBaseUI r106 = r105.f562747h;
        if (r106 == null) goto L8;
        r106.measure();
    L8:
        super.onLayout(r100, r101, r102, r103, r104);
    }

    private void maybeUpdateViewInternal(int r100, int r101, int r102, int r103, int r104, int r105) {
        h r106 = this.mImageDelegate;
        m8a.g r107 = r106.f383986x;
        if (r107 != null) goto L8;
        if (r106.f383987y != null) goto L8;
        return;
    L8:
        if (m8a.f.a(r107, r106.f383979r) == true) goto L10;
    L12:
        boolean r108 = false;
    L13:
        if (r108 == false) goto L17;
        if (r100 <= 0) goto L16;
        if (r101 > 0) goto L17;
        return;
    L16:
        return;
    L17:
        this.mImageOrigin = -1;
        l r109 = this.mLoaderCallback;
        if (r109 == null) goto L20;
        r109.onImageStartLoad();
    L20:
        TraceEvent.beginSection("FrescoImageView.maybeUpdateViewInternal");
        h r110 = this.mImageDelegate;
        if (r110.f383982t == false) goto L30;
        if (r110.K == true) goto L25;
        r110.x(r100, r101);
        goto L30
    L25:
        if (r110.y(r100, r101) == false) goto L30;
        TraceEvent.endSection("FrescoImageView.maybeUpdateViewInternal");
        return;
    L30:
        if (this.mImageDelegate.f383982t == false) goto L41;
        CloseableReference<?> r111 = this.mRef;
        if (r111 == null) goto L38;
        if (r111.isValid() == false) goto L38;
        if (this.mRef.get() == null) goto L38;
    L39:
        TraceEvent.endSection("FrescoImageView.maybeUpdateViewInternal");
        return;
    L38:
        if (this.mImageDelegate.f383983u == true) goto L39;
    L41:
        tryFetchImageFromFresco(r100, r101, r102, r103, r104, r105);
        TraceEvent.endSection("FrescoImageView.maybeUpdateViewInternal");
        return;
    L10:
        if (this.mImageDelegate.f383969m == true) goto L12;
        r108 = true;
        goto L13
    }

    private void tryFetchImageFromFresco(int r210, int r211, int r212, int r213, int r214, int r215) {
        if (TraceEvent.isTracingStarted() == false) goto L13;
        HashMap r100 = new HashMap();
        String r101 = this.mImageDelegate.f383984v;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L12;
        r100.put("url", this.mImageDelegate.f383984v);
    L12:
        TraceEvent.beginSection("LynxImageManager.tryFetchImageFromFresco", r100);
        goto L13
    L7:
        if (r101.startsWith("http") == false) goto L9;
        r102 = true;
    L13:
        GenericDraweeHierarchy r103 = getHierarchy();
        if (this.mFixFrescoBug == true) goto L16;
        r103.setActualImageScaleType(this.mScaleType);
    L16:
        ScalingUtils.ScaleType r104 = this.mScaleType;
        ScalingUtils.ScaleType r105 = ScalingUtils.ScaleType.CENTER_CROP;
        if (r104 == r105) goto L19;
    L21:
        h r106 = this.mImageDelegate;
        if (r106.Y == true) goto L34;
        ScalingUtils.ScaleType r107 = this.mScaleType;
        if (r107 == r105) goto L34;
        if (r107 == ScalingUtils.ScaleType.FOCUS_CROP) goto L34;
        if (r106.f383969m == true) goto L34;
        if (this.mIsPixelated == true) goto L34;
        if (r106.f383955f == true) goto L34;
        boolean r108 = true;
    L35:
        this.mUsePostprocessorScaling = r108;
        BorderRadius r109 = this.mBorderRadii;
        RoundingParams r110 = null;
        if (r109 != null) goto L38;
        float[] r111 = null;
    L43:
        if (this.mIsBorderRadiusDirty == true) goto L45;
    L52:
        int r112 = this.mFadeDurationMs;
        if (r112 >= 0) goto L56;
        r112 = 0;
    L56:
        r103.setFadeDuration(r112);
        ImageRequest r113 = createImageRequest(this.mImageDelegate.f383986x, r210, r211, 0, 0, 0, 0, r111, this.mScaleType);
        ImageRequest r114 = this.mCurImageRequest;
        this.mCurImageRequest = r113;
        ImageRequest r115 = createImageRequest(this.mImageDelegate.f383987y, r210, r211, 0, 0, 0, 0, r111, this.mScaleType);
        if (this.mDeferInvalidation == false) goto L59;
        r115 = r114;
    L59:
        this.mDraweeControllerBuilder.reset();
        WeakReference r116 = new WeakReference(this);
        AbstractDraweeControllerBuilder r117 = this.mDraweeControllerBuilder.setAutoPlayAnimations(this.mAutoPlay).setCallerContext(this.mCallerContext).setOldController(getController()).setImageRequest(r113);
        if (r115 == null) goto L62;
        boolean r118 = true;
    L63:
        r117.setRetainImageOnFailure(r118).setLowResImageRequest(r115);
        String r119 = this.mImageDelegate.f383984v;
        this.mStartTimeStamp = System.currentTimeMillis();
        b r120 = new b(this, r116, r119);
        this.mControllerListener = r120;
        if (this.mControllerForTesting != null) goto L66;
        this.mDraweeControllerBuilder.setControllerListener(r120);
    L67:
        setController(this.mDraweeControllerBuilder.build());
        this.mIsDirty = false;
        h r121 = this.mImageDelegate;
        r121.f383947b = r210;
        r121.f383949c = r211;
        this.mDraweeControllerBuilder.reset();
        if (TraceEvent.isTracingStarted() == false) goto L71;
        TraceEvent.endSection("LynxImageManager.tryFetchImageFromFresco");
        return;
    L71:
        return;
    L66:
        ForwardingControllerListener r122 = new ForwardingControllerListener();
        r122.addListener(this.mControllerListener);
        r122.addListener(this.mControllerForTesting);
        this.mDraweeControllerBuilder.setControllerListener(r122);
        goto L67
    L62:
        r118 = false;
        goto L63
    L45:
        if (this.mUsePostprocessorScaling == true) goto L51;
        if (r111 == null) goto L51;
        r110 = RoundingParams.fromCornersRadii(r111);
        int r123 = this.mOverlayColor;
        if (r123 == 0) goto L50;
        r110.setOverlayColor(r123);
        goto L51
    L50:
        r110.setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
    L51:
        r103.setRoundingParams(r110);
        this.mIsBorderRadiusDirty = true;
        goto L52
    L38:
        if (r109.d((r210 + r212) + r214, (r211 + r213) + r215) == false) goto L40;
        this.mIsBorderRadiusDirty = true;
    L40:
        r111 = adjustBorderRadiusArrayWithPadding(this.mBorderRadii.a());
    L34:
        r108 = false;
        goto L35
    L19:
        if (this.mCoverStart == false) goto L21;
        t r124 = new t();
        this.mScaleType = r124;
        r103.setActualImageScaleType(r124);
        goto L21
    }

    public void tryFetchImage(int r100, int r101, int r102, int r103, int r104, int r105) {
        maybeUpdateViewInternal(r100, r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ void access$500(FrescoImageView r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        r100.tryFetchImageFromFresco(r101, r102, r103, r104, r105, r106);
    }

    public ImageRequest createImageRequest(m8a.g r110, int r111, int r112, int r113, int r114, int r115, int r116, float[] r117, ScalingUtils.ScaleType r210) {
        return this.mImageDelegate.d(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }
}
