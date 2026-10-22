package com.lynx.tasm.behavior.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.camera.video.AudioStats;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.animation.AnimationConstant;
import com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.text.AndroidText;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.BitmapUtils;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.LRUHashMap;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttvideoengine.model.SubInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes32.dex */
public abstract class LynxUI<T extends View> extends LynxBaseUI implements com.lynx.tasm.behavior.ui.a {
    protected static final boolean ENABLE_ZINDEX = false;
    private static final float OFFSET_ROTATE_AUTO = -1024.0f;
    private static final float OFFSET_ROTATE_AUTO_WITH_ANGLE_BASE = -1000000.0f;
    private static final float OFFSET_ROTATE_AUTO_WITH_ANGLE_RANGE = 360.0f;
    private static final String TAG = "LynxUI";
    protected float mAlpha;
    private s6a.a[] mAnimationInfos;
    private com.lynx.tasm.behavior.ui.utils.a mBackgroundManager;
    private float mBrightnessAmount;
    protected i7a.a mClipPath;
    private float mContrastAmount;
    protected LynxBaseUI mDrawHead;
    private boolean mEnableReuseAnimationState;
    protected boolean mFirstRender;
    private float mGrayscaleAmount;
    private w6a.e mHeroAnimOwner;
    private float mHueRotateAmount;
    protected boolean mIsAutoOffsetRotate;
    private com.lynx.tasm.animation.keyframe.a mKeyframeManager;
    private t6a.c mLayoutAnimator;
    protected float mOffsetDistance;
    protected boolean mOffsetHasChanged;
    protected i7a.a mOffsetPath;
    protected float mOffsetRotate;
    protected float mOffsetRotateAngle;
    protected com.lynx.tasm.base.h<T> mOnceTask;
    private boolean mOverlappingRendering;
    protected ReadableArray mRawOffsetShape;
    private float mSaturateAmount;
    private boolean mSetVisibleByCSS;
    private u6a.a mTransitionAnimator;
    protected T mView;
    protected m mViewInfo;

    public class a implements Callable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxUI f382356a;

        @Override // java.util.concurrent.Callable
        public T call() {
            LynxUI r100 = this.f382356a;     // Catch: Throwable -> L6
            if (r100.createView(r100.mContext, r100.mParam) != null) goto L12;
            LynxUI r101 = this.f382356a;     // Catch: Throwable -> L6
            return (T) r101.createView(r101.mContext);
        L12:
            return null;
        L6:
            th = move-exception;
            LLog.e(LynxUI.TAG, th.toString());
            return null;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() throws Exception {
            return call();
        }

        public a(LynxUI r100) {
            this.f382356a = r100;
        }
    }

    public class b implements Consumer<Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxUI f382357a;

        public b(LynxUI r100) {
            this.f382357a = r100;
        }

        @Override // androidx.core.util.Consumer
        public final void accept(Exception r100) {
            Exception r101 = r100;
            LynxContext r102 = this.f382357a.mContext;
            if (r102 == null) goto L6;
            r102.handleException(r101);
            return;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.lynx.tasm.base.h f382358a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f382358a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(com.lynx.tasm.base.h r100) {
            this.f382358a = r100;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f382359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f382360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Bitmap.CompressFormat f382361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f382362d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Callback f382363e;

        public final void a() {
            if (this.f382359a == 1.0f) goto L5;
            Matrix r100 = new Matrix();
            float r101 = this.f382359a;
            r100.setScale(r101, r101);
            Bitmap r102 = this.f382360b;
            Bitmap r103 = Bitmap.createBitmap(r102, 0, 0, r102.getWidth(), this.f382360b.getHeight(), r100, true);
            this.f382360b.recycle();
        L6:
            String r104 = BitmapUtils.bitmapToBase64(r103, this.f382361c, 100, 2);
            JavaOnlyMap r105 = new JavaOnlyMap();
            r105.putInt("width", r103.getWidth());
            r105.putInt("height", r103.getHeight());
            r105.putString("data", this.f382362d + r104);
            this.f382363e.invoke(new Object[]{0, r105});
            r103.recycle();
            return;
        L5:
            r103 = this.f382360b;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(float r100, Bitmap r101, Bitmap.CompressFormat r102, String r103, Callback r104) {
            this.f382359a = r100;
            this.f382360b = r101;
            this.f382361c = r102;
            this.f382362d = r103;
            this.f382363e = r104;
        }
    }

    static {
        ENABLE_ZINDEX = false;
    }

    private static boolean isEncodedAutoOffsetRotate(float r100) {
        if (r100 <= OFFSET_ROTATE_AUTO_WITH_ANGLE_BASE) goto L5;
    L7:
        return false;
    L5:
        if (r100 <= (-1000360.0f)) goto L7;
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void afterDispatchProcessViewInfo(m r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void afterProcessChildViewInfo(m r100, View r101, long r102) {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void afterProcessViewInfo(m r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void beforeDispatchProcessViewInfo(m r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void beforeProcessChildViewInfo(m r100, View r101, long r102) {
    }

    public T createView(Context r100) {
        return null;
    }

    public LynxUI getTransitionUI() {
        return null;
    }

    public void initAccessibilityDelegate() {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void processLayoutChildren() {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void processMeasureChildren() {
    }

    public void setLayoutAnimationCreateTimingFunc(String r100) {
    }

    private void prepareKeyframeManager() {
        if (this.mKeyframeManager != null) goto L6;
        this.mKeyframeManager = new com.lynx.tasm.animation.keyframe.a(this);
        return;
    }

    private void prepareLayoutAnimator() {
        if (this.mLayoutAnimator != null) goto L6;
        this.mLayoutAnimator = new t6a.c();
        return;
    }

    private boolean shouldDoTransformTransition() {
        if (this.mIsFirstAnimatedReady == false) goto L5;
    L11:
        return false;
    L5:
        if (this.hasTransformChanged == false) goto L11;
        u6a.a r100 = this.mTransitionAnimator;
        if (r100 == null) goto L11;
        if (r100.b(4096) == false) goto L11;
        return true;
    }

    public void didEnsureCreateView() {
        com.lynx.tasm.behavior.ui.utils.a r100 = this.mBackgroundManager;
        if (r100 == null) goto L8;
        Drawable r101 = r100.f383142b;
        if (((BackgroundDrawable) r101) == null) goto L8;
        this.mView.setBackground((BackgroundDrawable) r101);
    L8:
        if (this.mAlpha == this.mView.getAlpha()) goto L11;
        this.mView.setAlpha(this.mAlpha);
    L11:
        if (this.mAnimationInfos == null) goto L14;
        prepareKeyframeManager();
        com.lynx.tasm.animation.keyframe.a r102 = this.mKeyframeManager;
        r102.f381825b = this.mAnimationInfos;
        r102.c();
        return;
    }

    public void dispatchProcessViewInfo() {
        LynxBaseUI r100 = this.mDrawHead;
    L3:
        if (r100 == null) goto L8;
        if ((r100 instanceof LynxUI) == false) goto L7;
        processChildViewInfo((LynxUI) r100);
    L7:
        r100 = r100.mNextDrawUI;
        goto L3
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean enableLayoutAnimation() {
        t6a.c r100 = this.mLayoutAnimator;
        if (r100 == null) goto L21;
        t6a.d r101 = r100.f544722t;
        if (r101 != null) goto L7;
    L8:
        t6a.e r102 = r100.f544724v;
        if (r102 != null) goto L11;
    L12:
        t6a.g r103 = r100.f544723u;
        if (r103 != null) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L22;
        return true;
    L22:
        return false;
    L15:
        if (r103.c() == false) goto L17;
    L16:
        r104 = true;
        goto L18
    L11:
        if (r102.c() == true) goto L16;
    L7:
        if (r101.c() == true) goto L16;
    L21:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ensureCreateView() {
        com.lynx.tasm.base.h<T> r100 = this.mOnceTask;
        if (r100 == null) goto L6;
        r100.run();
        this.mView = this.mOnceTask.a();
        this.mOnceTask = null;
    L6:
        if (this.mView != null) goto L10;
        T r101 = (T) createView(this.mContext, this.mParam);
        this.mView = r101;
        if (r101 != null) goto L10;
        this.mView = (T) createView(this.mContext);
    L10:
        T r102 = this.mView;
        if ((r102 instanceof IDrawChildHook.IDrawChildHookBinding) == false) goto L16;
        if ((this instanceof IDrawChildHook) == false) goto L16;
        ((IDrawChildHook.IDrawChildHookBinding) r102).bindDrawChildHook((IDrawChildHook) this);
    L16:
        if ((this.mDrawParent instanceof UIGroup) == true) goto L18;
    L20:
        didEnsureCreateView();
        this.mView.requestLayout();
        this.mView.invalidate();
        return;
    L18:
        if (this.mView.getParent() != null) goto L20;
        ((UIGroup) this.mDrawParent).insertChildWhenRebuildView(this);
        goto L20
    }

    public void execPauseAnim() {
        w6a.e r100 = this.mHeroAnimOwner;
        r100.getClass();
        if (w6a.h.a.f558471a.f558470g == true) goto L5;
        return;
    L5:
        if (r100.a() == true) goto L16;
        s6a.a r101 = r100.f558454g;
        if (r101 == null) goto L14;
        r100.f558448a.setAnimation(r101);
        if (r100.f558448a.getKeyframeManager() == null) goto L15;
        r100.f558448a.getKeyframeManager().c();
        return;
    L15:
        return;
    L14:
        return;
    }

    public void execResumeAnim() {
        w6a.e r100 = this.mHeroAnimOwner;
        r100.getClass();
        if (w6a.h.a.f558471a.f558470g == true) goto L5;
        return;
    L5:
        if (r100.a() == true) goto L16;
        s6a.a r101 = r100.f558455h;
        if (r101 == null) goto L14;
        r100.f558448a.setAnimation(r101);
        if (r100.f558448a.getKeyframeManager() == null) goto L15;
        r100.f558448a.getKeyframeManager().c();
        return;
    L15:
        return;
    L14:
        return;
    }

    public int getBackgroundColor() {
        return this.mBackgroundManager.f383140e;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getRealTimeTranslationZ() {
        return this.mView.getTranslationZ();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getScaleX() {
        T r100 = this.mView;
        if (r100 != null) goto L7;
        return 1.0f;
    L7:
        return r100.getScaleX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getScaleY() {
        T r100 = this.mView;
        if (r100 != null) goto L7;
        return 1.0f;
    L7:
        return r100.getScaleY();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public Matrix getTransformMatrix() {
        T r100 = this.mView;
        if (r100 == null) goto L10;
        if (r100.getMatrix() == null) goto L10;
        return this.mView.getMatrix();
    L10:
        return super.getTransformMatrix();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getTranslationX() {
        return this.mView.getTranslationX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getTranslationY() {
        return this.mView.getTranslationY();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean getVisibility() {
        if (this.mSetVisibleByCSS == true) goto L5;
    L7:
        return false;
    L5:
        if (super.getVisibility() == false) goto L7;
        return true;
    }

    public boolean hasAnimationRunning() {
        com.lynx.tasm.animation.keyframe.a r100 = this.mKeyframeManager;
        if (r100 == null) goto L17;
        HashMap<String, LynxKeyframeAnimator> r101 = r100.f381826c;
        if (r101 == null) goto L15;
        Iterator<LynxKeyframeAnimator> r102 = r101.values().iterator();
    L8:
        if (r102.hasNext() == false) goto L15;
        if (r102.next().f381800h != LynxKeyframeAnimator.LynxKFAnimatorState.RUNNING) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L8;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L17;
    L25:
        return true;
    L12:
        r103 = false;
    L15:
        r104 = false;
    L17:
        u6a.a r105 = this.mTransitionAnimator;
        if (r105 != null) goto L20;
    L21:
        T r106 = this.mView;
        if (r106 != null) goto L24;
        return false;
    L24:
        if (r106.getAnimation() != null) goto L25;
        return false;
    L20:
        if ((!r105.f548950h.isEmpty()) == true) goto L25;
        goto L21
    }

    public boolean hasOverlappingRenderingEnabled() {
        if (SystemUtils.PRODUCT_HUAWEI.equals(Build.MANUFACTURER) == false) goto L9;
        if (DeviceUtils.is64BitDevice() == true) goto L9;
        LLog.i(TAG, "Disable overlap rendering for Huawei 32bit machine");
        return false;
    L9:
        return this.mOverlappingRendering;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public void invalidate() {
        T r100 = this.mView;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.invalidate();
    }

    public boolean isRtl() {
        if (this.mLynxDirection != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean isUserInteractionEnabled() {
        if (this.userInteractionEnabled == false) goto L9;
        T r100 = this.mView;
        if (r100 == null) goto L9;
        if (r100.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean isVisible() {
        T r100 = this.mView;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getVisibility() == 0) goto L9;
        return false;
    L9:
        if (this.mView.getAlpha() >= 0.01d) goto L12;
        return false;
    L12:
        return this.mView.isAttachedToWindow();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDrawingPositionChanged() {
        if (this.mView.isLayoutRequested() == true) goto L6;
        handleLayout();
        invalidate();
        return;
    }

    public void processViewInfo() {
        beforeProcessViewInfo(this.mViewInfo);
        beforeDispatchProcessViewInfo(this.mViewInfo);
        dispatchProcessViewInfo();
        afterDispatchProcessViewInfo(this.mViewInfo);
        afterProcessViewInfo(this.mViewInfo);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void registerViewAccordingToNodeIndex() {
        LynxContext r100 = this.mContext;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getUIBodyView() == null) goto L10;
        this.mContext.getUIBodyView().registerViewAccordingToNodeIndex(this.mNodeIndex, this.mView);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public void requestLayout() {
        this.mView.requestLayout();
    }

    public void setLayoutParamsInternal() {
        k r100 = this.mParent;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof UIGroup) == true) goto L7;
        return;
    L7:
        if (((UIGroup) r100).needCustomLayout() == false) goto L15;
        ViewGroup.LayoutParams r101 = this.mView.getLayoutParams();
        ViewGroup.LayoutParams r102 = ((UIGroup) this.mParent).generateLayoutParams(r101);
        if (r102 == null) goto L16;
        if (r101 == r102) goto L17;
        updateLayoutParams(r102);
        return;
    L17:
        return;
    L16:
        return;
    }

    public void updatePerspectiveToView() {
        float r100 = this.mContext.getScreenMetrics().density;
        ReadableArray r101 = this.mPerspective;
        if (r101 == null) goto L25;
        if (r101.size() <= 1) goto L25;
        if (this.mPerspective.getInt(1) == 3) goto L25;
        if (this.mPerspective.getInt(1) != 0) goto L12;
        double r102 = r100;
        float r103 = (float) (((this.mPerspective.getDouble(0) * r102) * r102) * ((double) LynxBaseUI.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
    L31:
        if (this.mPrePerspectiveValue == r103) goto L34;
        this.mPrePerspectiveValue = r103;
        this.mView.setCameraDistance(r103);
        return;
    L34:
        return;
    L12:
        if (this.mPerspective.getInt(1) == 1) goto L16;
        if (this.mPerspective.getInt(1) == 2) goto L16;
    L22:
        double r104 = this.mPerspective.getDouble(0);
    L23:
        float r105 = ((float) r104) * r100;
        float r106 = LynxBaseUI.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    L29:
        r103 = r106 * r105;
    L16:
        if (this.mContext.getUIBody() == null) goto L22;
        if (this.mPerspective.getInt(1) != 1) goto L20;
        double r107 = this.mPerspective.getDouble(0) / 100.0d;
        int r108 = this.mContext.getUIBody().getLatestWidth();
    L21:
        r104 = r107 * ((double) r108);
        goto L23
    L20:
        r107 = this.mPerspective.getDouble(0) / 100.0d;
        r108 = this.mContext.getUIBody().getLatestHeight();
    L25:
        if (getWidth() <= getHeight()) goto L27;
        int r109 = getWidth();
    L28:
        r105 = (r109 * r100) * LynxBaseUI.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        r106 = 100.0f;
        goto L29
    L27:
        r109 = getHeight();
        goto L28
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void createViewAsync() {
        super.createViewAsync();
        com.lynx.tasm.base.h<T> r100 = new com.lynx.tasm.base.h(new a(this), new b(this));
        this.mOnceTask = r100;
        LynxThreadPool.g(new c(r100));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        u6a.a r100 = this.mTransitionAnimator;
        if (r100 == null) goto L5;
        r100.e();
    L5:
        com.lynx.tasm.animation.keyframe.a r101 = this.mKeyframeManager;
        if (r101 == null) goto L9;
        r101.b();
        return;
    }

    public void handleLayout() {
        if (isDetachedWithView() == false) goto L6;
        return;
    L6:
        if (TraceEvent.isTracingStarted() == false) goto L8;
        String r100 = "LynxUI.layout." + getTagName();
        TraceEvent.beginSection(r100);
    L9:
        this.mView.layout(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
        if ((getParent() instanceof UIShadowProxy) == false) goto L13;
        ((UIShadowProxy) getParent()).f382373a.getTransformRaws();
    L13:
        if ((this.mView.getParent() instanceof ViewGroup) == false) goto L28;
        ViewGroup r101 = (ViewGroup) this.mView.getParent();
        if (getSkewX() == 0.0f) goto L17;
    L20:
        boolean r102 = true;
    L22:
        if (getOverflow() != 0) goto L24;
        if (r102 == true) goto L24;
    L25:
        if (r102 == true) goto L28;
        ViewCompat.setClipBounds(this.mView, getBoundRectForOverflow());
    L24:
        r101.setClipChildren(false);
        goto L25
    L17:
        if (getSkewY() != 0.0f) goto L20;
        r102 = false;
    L28:
        if (getOverflow() == 0) goto L37;
        if (getWidth() != 0) goto L32;
    L33:
        T r103 = this.mView;
        if ((r103 instanceof AndroidText) == false) goto L37;
        ((AndroidText) r103).setOverflow(getOverflow());
        goto L37
    L32:
        if (getHeight() == 0) goto L33;
    L37:
        if (TraceEvent.isTracingStarted() == false) goto L40;
        TraceEvent.endSection(r100);
        return;
    L40:
        return;
    L8:
        r100 = null;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void initialize() {
        super.initialize();
        T r100 = (T) getOrCreateView(this.mContext, this.mParam);
        this.mView = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        this.mHeroAnimOwner = new w6a.e(this);
        com.lynx.tasm.behavior.ui.utils.a r101 = new com.lynx.tasm.behavior.ui.utils.a(this, getLynxContext());
        this.mBackgroundManager = r101;
        setLynxBackground(r101);
        com.lynx.tasm.behavior.ui.utils.a r102 = this.mBackgroundManager;
        r102.f383143c = this.mDrawableCallback;
        com.lynx.tasm.behavior.ui.accessibility.d r103 = this.mContext.getLynxAccessibilityWrapper();
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.f() == false) goto L12;
        initAccessibilityDelegate();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void measure() {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        String r100 = "LynxUI.measure." + getTagName();
        TraceEvent.beginSection(r100);
    L7:
        if (isDetachedWithView() == true) goto L10;
        setLayoutParamsInternal();
        this.mView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    L10:
        if (TraceEvent.isTracingStarted() == false) goto L13;
        TraceEvent.endSection(r100);
        return;
    L13:
        return;
    L5:
        r100 = null;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAnimationNodeReady() {
        super.onAnimationNodeReady();
        updatePerspectiveToView();
        if (shouldDoTransform() == false) goto L59;
        com.lynx.tasm.behavior.ui.utils.a r100 = this.mBackgroundManager;
        com.lynx.tasm.behavior.ui.utils.l r101 = this.mTransformOrigin;
        LynxUI r102 = r100.f383127f.get();
        if (r102 == null) goto L46;
        if (r102.getView() == null) goto L46;
        if (r101 == null) goto L46;
        float r103 = r102.getLatestWidth();
        float r104 = r102.getLatestHeight();
        com.lynx.tasm.behavior.ui.utils.m r105 = new com.lynx.tasm.behavior.ui.utils.m();
        r105.f383159a = r103 * 0.5f;
        r105.f383160b = r104 * 0.5f;
        if (r101 == com.lynx.tasm.behavior.ui.utils.l.f383154e) goto L44;
        float r106 = r101.f383155a;
        if (r106 == 0.5f) goto L17;
    L20:
        boolean r107 = true;
    L21:
        if (r107 == true) goto L23;
    L29:
        float r108 = r101.f383157c;
        if (r108 == 0.5f) goto L32;
    L35:
        boolean r109 = true;
    L36:
        if (r109 == false) goto L44;
        if (r101.f383158d != 1) goto L40;
        boolean r110 = true;
    L41:
        if (r110 == false) goto L43;
        r108 = r108 * r104;
    L43:
        r105.f383160b = r108;
        goto L44
    L40:
        r110 = false;
        goto L41
    L32:
        if (r101.f383158d != 1) goto L35;
        r109 = false;
        goto L36
    L23:
        if (r101.f383156b != 1) goto L25;
        boolean r111 = true;
    L26:
        if (r111 == false) goto L28;
        r106 = r106 * r103;
    L28:
        r105.f383159a = r106;
        goto L29
    L25:
        r111 = false;
        goto L26
    L17:
        if (r101.f383156b != 1) goto L20;
        r107 = false;
    L44:
        r102.getView().setPivotX(r105.f383159a);
        r102.getView().setPivotY(r105.f383160b);
        r102.getView().invalidate();
    L46:
        if (shouldDoTransformTransition() == false) goto L52;
        u6a.a r112 = this.mTransitionAnimator;
        LynxBaseUI r113 = r112.f548949g;
        if (r113 != null) goto L51;
        r113 = this;
    L51:
        r112.a(r113, 4096, r113.getTransformRaws());
        goto L59
    L52:
        u6a.a r114 = this.mTransitionAnimator;
        if (r114 == null) goto L55;
        r114.f(4096);
    L55:
        this.mBackgroundManager.t(this.mTransformRaw);
        if (this.mOffsetPath == null) goto L59;
        this.mOffsetHasChanged = true;
    L59:
        if (this.mOffsetHasChanged == false) goto L91;
        i7a.a r115 = this.mOffsetPath;
        if (r115 == null) goto L90;
        Path r116 = r115.c(getWidth(), getHeight());
        float r117 = this.mOffsetDistance;
        LRUHashMap<Path, i7a.b.a> r118 = i7a.b.f488498a;
        if (r116 != null) goto L65;
        float[] r119 = {0.0f, 0.0f, 0.0f};
    L87:
        if (this.mIsAutoOffsetRotate == false) goto L89;
        applyOffsetAndRotate(r119[0], r119[1], r119[2] + this.mOffsetRotateAngle);
        goto L90
    L89:
        applyOffsetAndRotate(r119[0], r119[1], this.mOffsetRotate);
        goto L90
    L65:
        float r120 = Math.max(0.0f, Math.min(1.0f, r117));
        i7a.b.a r121 = i7a.b.f488498a.get(r116);
        if (r121 != null) goto L71;
        i7a.b.a r122 = new i7a.b.a();
        PathMeasure r123 = new PathMeasure(r116, false);
    L68:
        float r124 = r123.getLength();
        ((ArrayList) r122.f488500b).add(Float.valueOf(r124));
        r122.f488499a += r124;
        if (r123.nextContour() == true) goto L68;
        i7a.b.f488498a.put(r116, r122);
        r121 = r122;
    L71:
        float r125 = r121.f488499a * r120;
        int r126 = 0;
        float r127 = 0.0f;
    L73:
        if (r126 >= ((ArrayList) r121.f488500b).size()) goto L78;
        float r128 = ((Float) ListProtector.get(r121.f488500b, r126)).floatValue() + r127;
        if (r125 <= r128) goto L79;
        r126 = r126 + 1;
        r127 = r128;
    L79:
        PathMeasure r129 = new PathMeasure(r116, false);
        int r130 = 0;
    L80:
        if (r130 >= r126) goto L82;
        r129.nextContour();
        r130 = r130 + 1;
        goto L80
    L82:
        float[] r131 = new float[2];
        float[] r132 = new float[2];
        r129.getPosTan(r125 - r127, r131, r132);
        float r133 = (float) Math.toDegrees(Math.atan2(r132[1], r132[0]));
        if (r133 >= 0.0f) goto L85;
        r133 = r133 + 360.0f;
    L85:
        r119 = new float[]{r131[0], r131[1], r133};
        goto L87
    L78:
        r126 = 0;
    L90:
        this.mOffsetHasChanged = false;
    L91:
        u6a.a r134 = this.mTransitionAnimator;
        if (r134 != null) goto L94;
    L110:
        com.lynx.tasm.animation.keyframe.a r135 = this.mKeyframeManager;
        if (r135 == null) goto L113;
        r135.c();
    L113:
        LynxContext r136 = this.mContext;
        if (r136 != null) goto L116;
    L120:
        this.mHasTranslateDiff = false;
        return;
    L116:
        if (r136.isTouchMoving() == false) goto L120;
        if (this.mHasTranslateDiff == false) goto L120;
        this.mContext.onPropsChanged(this);
        goto L120
    L94:
        if (r134.f548951i.isEmpty() == true) goto L110;
        Iterator<Map.Entry<Integer, Animator>> r137 = r134.f548951i.entrySet().iterator();
    L98:
        if (r137.hasNext() == false) goto L109;
        Map.Entry<Integer, Animator> r138 = r137.next();
        Animator r139 = r134.f548950h.get(r138.getKey());
        if (r139 == null) goto L102;
        r139.cancel();
    L102:
        Animator r140 = r138.getValue().clone();
        r140.setDuration(StackLeakChecker.CHECK_INTERVAL_10_SEC);
        r140.setStartDelay(0);
        if ((r140 instanceof AnimatorSet) == false) goto L108;
        Iterator<Animator> r141 = ((AnimatorSet) r140).getChildAnimations().iterator();
    L106:
        if (r141.hasNext() == false) goto L108;
        r141.next().removeAllListeners();
    L108:
        r140.removeAllListeners();
        r140.addListener(new u6a.a.f());
        r140.start();
        r138.getValue().start();
        r134.f548950h.put(r138.getKey(), r138.getValue());
        goto L98
    L109:
        r134.f548951i.clear();
        goto L110
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        com.lynx.tasm.animation.keyframe.a r100 = this.mKeyframeManager;
        if (r100 == null) goto L16;
        HashMap<String, LynxKeyframeAnimator> r101 = r100.f381826c;
        if (r101 == null) goto L24;
        Iterator<LynxKeyframeAnimator> r102 = r101.values().iterator();
    L9:
        if (r102.hasNext() == false) goto L25;
        LynxKeyframeAnimator r103 = r102.next();
        ObjectAnimator[] r104 = r103.f381799g;
        if (r104 == null) goto L9;
        int r105 = r104.length;
        if (r105 <= 0) goto L9;
        r104[r105 - 1].addListener(new LynxKeyframeAnimator.c(r103));
        goto L9
    L25:
        return;
    L24:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        com.lynx.tasm.animation.keyframe.a r100 = this.mKeyframeManager;
        if (r100 == null) goto L15;
        HashMap<String, LynxKeyframeAnimator> r101 = r100.f381826c;
        if (r101 == null) goto L15;
        Iterator<LynxKeyframeAnimator> r102 = r101.values().iterator();
    L9:
        if (r102.hasNext() == false) goto L15;
        ObjectAnimator[] r103 = r102.next().f381799g;
        if (r103 == null) goto L9;
        int r104 = r103.length;
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L9;
        r103[r105].removeAllListeners();
        r105 = r105 + 1;
    L15:
        t6a.c r106 = this.mLayoutAnimator;
        if (r106 == null) goto L24;
        r106.c();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        if (getBound() != null) goto L5;
    L10:
        boolean r100 = true;
    L11:
        if (r100 == true) goto L13;
    L15:
        if (r100 == true) goto L19;
        this.mView.setVisibility(8);
        return;
    L19:
        return;
    L13:
        if (this.mSetVisibleByCSS == false) goto L15;
        this.mView.setVisibility(0);
        return;
    L5:
        if (getBound().width() > 0) goto L7;
    L9:
        r100 = false;
        goto L11
    L7:
        if (getBound().height() <= 0) goto L9;
        goto L9
    }

    public com.lynx.tasm.behavior.ui.utils.a getBackgroundManager() {
        return this.mBackgroundManager;
    }

    public LynxBaseUI getDrawHead() {
        return this.mDrawHead;
    }

    public w6a.e getFakeSharedElementManager() {
        return this.mHeroAnimOwner;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public com.lynx.tasm.animation.keyframe.a getKeyframeManager() {
        return this.mKeyframeManager;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public t6a.c getLayoutAnimator() {
        return this.mLayoutAnimator;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public u6a.a getTransitionAnimator() {
        return this.mTransitionAnimator;
    }

    public T getView() {
        return this.mView;
    }

    public m getViewInfo() {
        return this.mViewInfo;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void layout() {
        handleLayout();
    }

    public LynxUI(Context r100) {
        this((LynxContext) r100);
    }

    private static float decodeAutoOffsetRotateAngle(float r100) {
        if (isEncodedAutoOffsetRotate(r100) == true) goto L7;
        return 0.0f;
    L7:
        return OFFSET_ROTATE_AUTO_WITH_ANGLE_BASE - r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void attachToView(LynxContext r100) {
        this.mContext = r100;
        if (this.mView != null) goto L8;
        T r101 = (T) r100.getUIBodyView().obtainViewAccordingToNodeIndex(this.mNodeIndex);
        if (r101 == null) goto L7;
        this.mView = r101;
        goto L8
    L7:
        createViewAsync();
    L8:
        this.mContext.getUIBody().appendUIWithCreateViewAsync(this);
        super.attachToView(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void beforeProcessViewInfo(m r100) {
        r100.f382812e = getSkewX();
        r100.f382813f = getSkewY();
        r100.f382814g = this.mClipPath;
        r100.f382810c = getWidth();
        r100.f382811d = getHeight();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void detachWithViewInfo(m r100) {
        registerViewAccordingToNodeIndex();
        m r101 = this.mViewInfo;
        if (r101 == null) goto L5;
        r100 = r101;
    L5:
        super.detachWithViewInfo(r100);
        m r102 = this.mViewInfo;
        if (r102 != null) goto L8;
    L11:
        this.mView = null;
        return;
    L8:
        if (this.mKeyframeManager == null) goto L10;
        r102.getClass();
        this.mKeyframeManager = null;
    L10:
        this.mViewInfo.f382808a = null;
        this.mViewInfo = null;
        goto L11
    }

    public void execEnterAnim(w6a.h.b r110) {
        w6a.e r100 = this.mHeroAnimOwner;
        r100.getClass();
        w6a.h r101 = w6a.h.a.f558471a;
        if (r101.f558470g == true) goto L5;
        return;
    L5:
        if (r100.a() == true) goto L68;
        s6a.a r102 = r100.f558452e;
        if (r102 != null) goto L10;
        return;
    L10:
        if (r100.f558456i == null) goto L50;
        r100.f558457j = true;
        String r103 = r100.f558456i;
        LynxUI r104 = r100.f558448a;
        monitor-enter(r101);
        WeakReference<View> r105 = r101.f558464a.get(r103);     // Catch: Throwable -> L47
        if (r105 == null) goto L16;
        View r106 = r105.get();     // Catch: Throwable -> L47
    L17:
        if (r106 != null) goto L28;
        Iterator<Map.Entry<LynxUI, String>> r107 = r101.f558469f.entrySet().iterator();     // Catch: Throwable -> L47
    L20:
        if (r107.hasNext() == false) goto L28;
        Map.Entry<LynxUI, String> r108 = r107.next();     // Catch: Throwable -> L47
        LynxUI r109 = r108.getKey();     // Catch: Throwable -> L47
        if (r104 == r109) goto L20;
        if (r108.getValue().equals(r103) == false) goto L20;
        r106 = r109.getView();     // Catch: Throwable -> L47
        monitor-exit(r101);
    L29:
        UIBody.UIBodyView r111 = r100.f558448a.getLynxContext().getUIBody().getBodyView();
        if (r111 == null) goto L46;
        View r112 = r100.f558448a.getView();
        if (r106 == null) goto L45;
        r112.setVisibility(r106.getVisibility());
        r112.setAlpha(r106.getAlpha());
        r112.setTranslationX(r106.getTranslationX());
        r112.setTranslationY(r106.getTranslationY());
        r112.setRotation(r106.getRotation());
        r112.setRotationX(r106.getRotationX());
        r112.setRotationY(r106.getRotationY());
        r112.setScaleX(r106.getScaleX());
        r112.setScaleY(r106.getScaleY());
        int r113 = r106.getWidth();
        int r114 = r106.getHeight();
        if ((r111.getRootView() instanceof ViewGroup) == false) goto L46;
        ViewGroup r115 = (ViewGroup) r111.getRootView();
        if (r112.getParent() == null) goto L44;
        ViewGroup r116 = (ViewGroup) r112.getParent();
        r100.f558450c = r116;
        int r117 = r116.getChildCount();
        int r118 = 0;
    L38:
        if (r118 >= r117) goto L43;
        if (r112 == r100.f558450c.getChildAt(r118)) goto L41;
        r118 = r118 + 1;
        goto L38
    L41:
        r100.f558449b = r118;
    L43:
        r100.f558450c.removeView(r112);
        r100.f558451d = (UIGroup) r100.f558448a.getParent();
    L44:
        ViewGroup.MarginLayoutParams r119 = new ViewGroup.MarginLayoutParams(r113, r114);
        int[] r120 = new int[2];
        r106.getLocationInWindow(r120);
        r119.setMargins(r120[0], r120[1], 0, 0);
        r115.addView(r112, r119);
        UIThreadUtils.runOnUiThread(new w6a.a(r100));
        goto L46
    L45:
        UIThreadUtils.runOnUiThread(new w6a.b(r100));
    L46:
        String r121 = r100.f558452e.f540860a;
        r100.f558459l.put(r121, new w6a.d(r100, r110));
        return;
    L28:
        monitor-exit(r101);
        goto L29
    L16:
        r106 = null;
    L47:
        th = move-exception;
        throw th;
    L50:
        r100.f558448a.setAnimation(r102);
        if (r100.f558448a.getKeyframeManager() == null) goto L67;
        r100.f558448a.getKeyframeManager().c();
        return;
    L67:
        return;
    }

    public void execExitAnim(w6a.h.c r100) {
        w6a.e r101 = this.mHeroAnimOwner;
        r101.getClass();
        if (w6a.h.a.f558471a.f558470g == true) goto L5;
        return;
    L5:
        if (r101.a() == true) goto L26;
        s6a.a r102 = r101.f558453f;
        if (r102 == null) goto L22;
        String r103 = r102.f540860a;
        r101.f558459l.put(r103, new w6a.c(r101, r100));
        if (r101.f558456i == null) goto L17;
        r101.f558458k = true;
        ViewGroup r104 = (ViewGroup) r101.f558448a.getLynxContext().getUIBody().getBodyView().getRootView();
        View r105 = r101.f558448a.getView();
        r105.getLocationInWindow(new int[2]);
        ViewParent r106 = r105.getParent();
        if (r106 == null) goto L14;
        ((ViewGroup) r106).removeView(r105);
    L14:
        r104.addView(r105);
        r101.f558448a.setAnimation(r101.f558453f);
        if (r101.f558448a.getKeyframeManager() == null) goto L23;
        r101.f558448a.getKeyframeManager().c();
        return;
    L23:
        return;
    L17:
        r101.f558448a.setAnimation(r101.f558453f);
        if (r101.f558448a.getKeyframeManager() == null) goto L25;
        r101.f558448a.getKeyframeManager().c();
        return;
    L25:
        return;
    L22:
        return;
    }

    public ReadableMap getKeyframes(String r100) {
        LynxContext r101 = this.mContext;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getKeyframes(r100);
    }

    public boolean hasTranslateDiff(ReadableArray r100) {
        List<n> r101 = n.d(r100);
        if (Float.compare(n.b(this.mTransformRaw), n.b(r101)) == 0) goto L5;
        boolean r102 = true;
    L7:
        if (Float.compare(n.c(this.mTransformRaw), n.c(r101)) == 0) goto L9;
        boolean r103 = true;
    L10:
        if (r102 == true) goto L15;
        if (r103 == true) goto L16;
        return false;
    L16:
        return true;
    L15:
        return true;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void initTransitionAnimator(ReadableMap r110) {
        if (this.mTransitionAnimator != null) goto L5;
        this.mTransitionAnimator = new u6a.a(getTransitionUI());
    L5:
        u6a.a r100 = this.mTransitionAnimator;
        r100.getClass();
        int r101 = 0;
        if (r110 == null) goto L55;
        ReadableArray r102 = r110.getArray("transition");
        if (r102 != null) goto L11;
        r100.e();
        goto L55
    L11:
        SparseArray<s6a.a> r103 = r100.f548952j;
        r100.f548952j = new SparseArray();
        int r104 = 0;
    L13:
        if (r104 >= r102.size()) goto L42;
        ReadableArray r105 = r102.getArray(r104);
        int r106 = r105.getInt(r101);
        int[] r107 = AnimationConstant.f381792a;
        if (r106 == 8177) goto L27;
        if (r106 == 16369) goto L27;
        if (r106 == 262129) goto L27;
        if (r106 == 262144) goto L27;
        int r111 = 0;
    L21:
        if (r111 >= 10) goto L26;
        if (r106 == r107[r111]) goto L27;
        r111 = r111 + 1;
        goto L21
    L26:
        boolean r108 = false;
    L28:
        if (r108 == false) goto L38;
        s6a.a r109 = new s6a.a();
        r109.f540863d = r106;
        r109.f540861b = (long) r105.getDouble(1);
        r109.f540862c = (long) r105.getDouble(r109.c(r105, 2));
        r109.f540875p = r104;
        int r112 = r109.f540863d;
        if (r112 == 8177) goto L39;
        if (r112 == 16369) goto L39;
        if (r112 == 262129) goto L39;
        if (r112 == 262144) goto L39;
        r100.f548952j.put(r112, r109);
    L39:
        r100.f548952j.clear();
        int r113 = 0;
        int r114 = 0;
    L40:
        if (r113 >= 10) goto L42;
        int r115 = r107[r113];
        s6a.a r116 = new s6a.a(r109);
        int r117 = r114 + 1;
        r116.f540875p = r114;
        r116.f540863d = r115;
        r100.f548952j.put(r115, r116);
        r113 = r113 + 1;
        r114 = r117;
    L38:
        r104 = r104 + 1;
        r101 = 0;
    L27:
        r108 = true;
    L42:
        s6a.a.b(r100.f548952j, 256, 1024);
        s6a.a.b(r100.f548952j, 512, 2048);
        if (r103 == null) goto L52;
        int r118 = 0;
    L46:
        if (r118 >= r103.size()) goto L52;
        int r119 = r103.keyAt(r118);
        if (r100.f548952j.indexOfKey(r119) >= 0) goto L50;
        r100.f(Integer.valueOf(r119));
    L50:
        r118 = r118 + 1;
    L52:
        if (r100.f548952j.size() == 0) goto L54;
        r101 = 1;
        goto L55
    L54:
        r101 = 0;
    L55:
        if (r101 != 0) goto L71;
        this.mTransitionAnimator = null;
        return;
    }

    public void onAnimationEnd(String r100) {
        w6a.e r101 = this.mHeroAnimOwner;
        LynxKeyframeAnimator.e r102 = r101.f558459l.get(r100);
        if (r102 == null) goto L6;
        r102.a(r100);
        r101.f558459l.remove(r100);
        return;
    }

    public void processChildViewInfo(com.lynx.tasm.behavior.ui.a r100) {
        LynxUI r101 = (LynxUI) r100;
        beforeProcessChildViewInfo(this.mViewInfo, r101.getView(), 0);
        r101.processViewInfo();
        afterProcessChildViewInfo(this.mViewInfo, r101.getView(), 0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAccessibilityElement(f6a.a r100) {
        super.setAccessibilityElement(r100);
        com.lynx.tasm.behavior.ui.accessibility.d r101 = this.mContext.getLynxAccessibilityWrapper();
        if (this.mView != null) goto L5;
        return;
    L5:
        if (this.mAccessibilityElementStatus == (-1)) goto L16;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.f() == false) goto L18;
        T r102 = this.mView;
        int r103 = 1;
        if (this.mAccessibilityElementStatus == 1) goto L13;
        r103 = 2;
    L13:
        ViewCompat.setImportantForAccessibility(r102, r103);
        return;
    L18:
        return;
    }

    @LynxProp(defaultBoolean = false, name = "accessibility-elements-hidden")
    public void setAccessibilityElementsHidden(boolean r100) {
        T r101 = this.mView;
        if (r100 == false) goto L5;
        int r102 = 4;
    L6:
        r101.setImportantForAccessibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAccessibilityHeading(boolean r100) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.mView.setAccessibilityHeading(r100);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "accessibility-label")
    public void setAccessibilityLabel(f6a.a r100) {
        super.setAccessibilityLabel(r100);
        T r101 = this.mView;
        if (r101 == null) goto L6;
        r101.setFocusable(true);
        this.mView.setContentDescription(getAccessibilityLabel());
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAccessibilityValue(String r100) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.mView.setStateDescription(r100);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(defaultFloat = 1.0f, name = GXTemplateKey.STYLE_OPACITY)
    public void setAlpha(float r100) {
        super.setAlpha(r100);
        if (getKeyframeManager() == null) goto L5;
        getKeyframeManager().d("Alpha", Float.valueOf(r100));
    L5:
        u6a.a r101 = this.mTransitionAnimator;
        if (r101 == null) goto L12;
        if (r101.b(1) == false) goto L12;
        this.mTransitionAnimator.a(this, 1, Float.valueOf(r100));
        return;
    L12:
        if (r100 == this.mView.getAlpha()) goto L14;
        this.mView.setAlpha(r100);
    L14:
        t6a.c r102 = this.mLayoutAnimator;
        if (r102 == null) goto L18;
        r102.f544726x = r100;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAnimation(ReadableArray r100) {
        if (r100 != null) goto L8;
        com.lynx.tasm.animation.keyframe.a r101 = this.mKeyframeManager;
        if (r101 == null) goto L6;
        r101.b();
        this.mKeyframeManager = null;
    L6:
        this.mAnimationInfos = null;
        return;
    L8:
        prepareKeyframeManager();
        int r102 = r100.size();
        s6a.a[] r103 = new s6a.a[r102];
        int r104 = 0;
    L9:
        if (r104 >= r102) goto L11;
        r103[r104] = s6a.a.d(r100.getArray(r104));
        r104 = r104 + 1;
        goto L9
    L11:
        this.mAnimationInfos = r103;
        this.mKeyframeManager.f381825b = r103;
    }

    @LynxProp(name = "clip-path")
    public void setClipPath(ReadableArray r100) {
        this.mClipPath = i7a.a.a(r100, this.mContext.getScreenMetrics().density);
    }

    public void setDrawHead(LynxBaseUI r100) {
        this.mDrawHead = r100;
    }

    @LynxProp(defaultBoolean = true, name = "enable-reuse-animation-state")
    public void setEnableReuseAnimationState(boolean r100) {
        this.mEnableReuseAnimationState = r100;
        if (r100 == true) goto L8;
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L9;
        LynxFeatureCounter.a(82, r101.getInstanceId());
        return;
    L9:
        return;
    }

    public void setEnterAnim(s6a.a r100) {
        this.mHeroAnimOwner.f558452e = r100;
    }

    @LynxProp(name = "enter-transition-name")
    public void setEnterTransitionName(ReadableArray r100) {
        s6a.a r101 = s6a.a.d(r100);
        if (r101 == null) goto L15;
        LynxContext r102 = this.mContext;
        if (r102 == null) goto L7;
        LynxFeatureCounter.a(77, r102.getInstanceId());
    L7:
        w6a.h r103 = w6a.h.a.f558471a;
        monitor-enter(r103);
        r103.f558466c.put(this, r101);     // Catch: Throwable -> L12
        setEnterAnim(r101);     // Catch: Throwable -> L12
        monitor-exit(r103);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void setExitAnim(s6a.a r100) {
        this.mHeroAnimOwner.f558453f = r100;
    }

    @LynxProp(name = "exit-transition-name")
    public void setExitTransitionName(ReadableArray r100) {
        s6a.a r101 = s6a.a.d(r100);
        if (r101 == null) goto L15;
        LynxContext r102 = this.mContext;
        if (r102 == null) goto L7;
        LynxFeatureCounter.a(78, r102.getInstanceId());
    L7:
        w6a.h r103 = w6a.h.a.f558471a;
        monitor-enter(r103);
        r103.f558465b.put(this, r101);     // Catch: Throwable -> L12
        setExitAnim(r101);     // Catch: Throwable -> L12
        monitor-exit(r103);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @LynxProp(name = "filter")
    public void setFilter(ReadableArray r110) {
        if (this.mView != null) goto L6;
        return;
    L6:
        if (r110 != null) goto L8;
    L10:
        double r100 = 0.0d;
        int r101 = 0;
    L12:
        if (r101 != 0) goto L14;
        this.mView.setLayerType(0, null);
        T r102 = this.mView;
        if ((r102 instanceof com.lynx.tasm.behavior.ui.view.a) == false) goto L63;
        ((com.lynx.tasm.behavior.ui.view.a) r102).removeBlur();
    L63:
        this.mGrayscaleAmount = 1.0f;
        return;
    L14:
        if (r101 == 1) goto L51;
        if (r101 == 2) goto L48;
        if (r101 != 3) goto L18;
        Double r103 = Double.valueOf(r100);
        Double r104 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        Double r105 = Double.valueOf(2.0d);
        if (r103.compareTo(r104) >= 0) goto L43;
        r103 = r104;
    L45:
        float r106 = (float) r103.doubleValue();
        if (com.lynx.tasm.utils.b.a(this.mBrightnessAmount, r106) == true) goto L69;
        ColorMatrix r107 = new ColorMatrix();
        r107.setScale(r106, r106, r106, 1.0f);
        Paint r108 = new Paint(1);
        r108.setColorFilter(new ColorMatrixColorFilter(r107));
        this.mView.setLayerType(2, r108);
        this.mBrightnessAmount = r106;
        return;
    L69:
        return;
    L43:
        if (r103.compareTo(r105) <= 0) goto L45;
        r103 = r105;
        goto L45
    L18:
        if (r101 == 4) goto L30;
        if (r101 == 5) goto L22;
        return;
    L22:
        if (r100 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L25;
        r100 = 1.0d;
    L27:
        float r109 = (float) r100;
        if (com.lynx.tasm.utils.b.a(this.mSaturateAmount, r109) == true) goto L65;
        ColorMatrix r111 = new ColorMatrix();
        r111.setSaturation(r109);
        Paint r112 = new Paint(1);
        r112.setColorFilter(new ColorMatrixColorFilter(r111));
        this.mView.setLayerType(2, r112);
        this.mSaturateAmount = r109;
        return;
    L65:
        return;
    L25:
        if (r100 <= 3.0d) goto L27;
        r100 = 3.0d;
        goto L27
    L30:
        Double r113 = Double.valueOf(r100);
        Double r114 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        Double r115 = Double.valueOf(3.0d);
        if (r113.compareTo(r114) >= 0) goto L34;
        r113 = r114;
    L36:
        float r116 = (float) r113.doubleValue();
        if (com.lynx.tasm.utils.b.a(this.mContrastAmount, r116) == true) goto L67;
        ColorMatrix r117 = new ColorMatrix();
        float r118 = (1.0f - r116) * 128.0f;
        r117.set(new float[]{r116, 0.0f, 0.0f, 0.0f, r118, 0.0f, r116, 0.0f, 0.0f, r118, 0.0f, 0.0f, r116, 0.0f, r118, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        Paint r119 = new Paint(1);
        r119.setColorFilter(new ColorMatrixColorFilter(r117));
        this.mView.setLayerType(2, r119);
        this.mContrastAmount = r116;
        return;
    L67:
        return;
    L34:
        if (r113.compareTo(r115) <= 0) goto L36;
        r113 = r115;
        goto L36
    L48:
        T r120 = this.mView;
        if ((r120 instanceof com.lynx.tasm.behavior.ui.view.a) == false) goto L71;
        ((com.lynx.tasm.behavior.ui.view.a) r120).setBlur((float) r100);
        return;
    L71:
        return;
    L51:
        Double r121 = Double.valueOf(1.0d - r100);
        Double r122 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        Double r123 = Double.valueOf(1.0d);
        if (r121.compareTo(r122) >= 0) goto L55;
        r121 = r122;
    L57:
        float r124 = (float) r121.doubleValue();
        if (com.lynx.tasm.utils.b.a(this.mGrayscaleAmount, r124) == true) goto L73;
        ColorMatrix r125 = new ColorMatrix();
        r125.setSaturation(r124);
        Paint r126 = new Paint(1);
        r126.setColorFilter(new ColorMatrixColorFilter(r125));
        this.mView.setLayerType(2, r126);
        this.mGrayscaleAmount = r124;
        return;
    L73:
        return;
    L55:
        if (r121.compareTo(r123) <= 0) goto L57;
        r121 = r123;
        goto L57
    L8:
        if (r110.size() != 3) goto L10;
        r101 = r110.getInt(0);
        r100 = r110.getDouble(1);
        goto L12
    }

    @LynxProp(name = "layout-animation-create-delay")
    public void setLayoutAnimationCreateDelay(double r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(74, r101.getInstanceId());
    L5:
        this.mLayoutAnimator.e().f544702a.f540862c = (long) r100;
    }

    @LynxProp(name = "layout-animation-create-duration")
    public void setLayoutAnimationCreateDuration(double r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(74, r101.getInstanceId());
    L5:
        t6a.c r102 = this.mLayoutAnimator;
        r102.e().f544702a.f540861b = (long) r100;
        if (r102.e().c() == true) goto L9;
        r102.d("layout-animation-create");
        return;
    }

    @LynxProp(name = "layout-animation-create-property")
    public void setLayoutAnimationCreateProperty(int r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(74, r101.getInstanceId());
    L5:
        this.mLayoutAnimator.e().f544702a.f540863d = r100;
    }

    @LynxProp(name = "layout-animation-create-timing-function")
    public void setLayoutAnimationCreateTimingFunc(ReadableArray r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(74, r101.getInstanceId());
    L5:
        this.mLayoutAnimator.e().f544702a.c(r100, 0);
    }

    @LynxProp(name = "layout-animation-delete-delay")
    public void setLayoutAnimationDeleteDelay(double r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(76, r101.getInstanceId());
    L5:
        this.mLayoutAnimator.f().f544702a.f540862c = (long) r100;
    }

    @LynxProp(name = "layout-animation-delete-duration")
    public void setLayoutAnimationDeleteDuration(double r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(76, r101.getInstanceId());
    L5:
        t6a.c r102 = this.mLayoutAnimator;
        r102.f().f544702a.f540861b = (long) r100;
        if (r102.f().c() == true) goto L9;
        r102.d("layout-animation-delete");
        return;
    }

    @LynxProp(name = "layout-animation-delete-property")
    public void setLayoutAnimationDeleteProperty(int r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(76, r101.getInstanceId());
    L5:
        this.mLayoutAnimator.f().f544702a.f540863d = r100;
    }

    @LynxProp(name = "layout-animation-delete-timing-function")
    public void setLayoutAnimationDeleteTimingFunc(ReadableArray r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(76, r101.getInstanceId());
    L5:
        this.mLayoutAnimator.f().f544702a.c(r100, 0);
    }

    @LynxProp(name = "layout-animation-update-delay")
    public void setLayoutAnimationUpdateDelay(double r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(75, r101.getInstanceId());
    L5:
        this.mLayoutAnimator.g().f544702a.f540862c = (long) r100;
    }

    @LynxProp(name = "layout-animation-update-duration")
    public void setLayoutAnimationUpdateDuration(double r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(75, r101.getInstanceId());
    L5:
        t6a.c r102 = this.mLayoutAnimator;
        r102.g().f544702a.f540861b = (long) r100;
        if (r102.g().c() == true) goto L9;
        r102.d("layout-animation-update");
        return;
    }

    @LynxProp(name = "layout-animation-update-property")
    public void setLayoutAnimationUpdateProperty(int r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(75, r101.getInstanceId());
    L5:
        this.mLayoutAnimator.g().f544702a.f540863d = r100;
    }

    @LynxProp(name = "layout-animation-update-timing-function")
    public void setLayoutAnimationUpdateTimingFunc(ReadableArray r100) {
        prepareLayoutAnimator();
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(75, r101.getInstanceId());
    L5:
        this.mLayoutAnimator.g().f544702a.c(r100, 0);
    }

    @LynxProp(name = "offset-distance")
    public void setOffsetDistance(float r100) {
        if (this.mOffsetDistance == r100) goto L6;
        this.mOffsetDistance = r100;
        this.mOffsetHasChanged = true;
        return;
    }

    @LynxProp(name = "offset-path")
    public void setOffsetPath(ReadableArray r100) {
        if (this.mRawOffsetShape == r100) goto L6;
        this.mRawOffsetShape = r100;
        this.mOffsetPath = i7a.a.a(r100, this.mContext.getScreenMetrics().density);
        this.mOffsetHasChanged = true;
        return;
    }

    @LynxProp(name = "offset-rotate")
    public void setOffsetRotate(float r100) {
        if (this.mOffsetRotate == r100) goto L12;
        this.mOffsetRotate = r100;
        this.mOffsetHasChanged = true;
        if (r100 != OFFSET_ROTATE_AUTO) goto L8;
        this.mIsAutoOffsetRotate = true;
        this.mOffsetRotateAngle = 0.0f;
        return;
    L8:
        if (isEncodedAutoOffsetRotate(r100) == false) goto L10;
        this.mIsAutoOffsetRotate = true;
        this.mOffsetRotateAngle = decodeAutoOffsetRotateAngle(this.mOffsetRotate);
        return;
    L10:
        this.mIsAutoOffsetRotate = false;
        this.mOffsetRotateAngle = 0.0f;
        return;
    }

    @LynxProp(name = "overlap")
    public void setOverlap(f6a.a r100) {
        if (r100 != null) goto L5;
        this.mOverlappingRendering = true;
        return;
    L5:
        ReadableType r101 = r100.getType();
        if (r101 != ReadableType.Boolean) goto L9;
        this.mOverlappingRendering = r100.asBoolean();
        return;
    L9:
        if (r101 != ReadableType.String) goto L13;
        this.mOverlappingRendering = r100.asString().equalsIgnoreCase("true");
        return;
    }

    public void setPauseAnim(s6a.a r100) {
        this.mHeroAnimOwner.f558454g = r100;
    }

    @LynxProp(name = "pause-transition-name")
    public void setPauseTransitionName(ReadableArray r100) {
        s6a.a r101 = s6a.a.d(r100);
        if (r101 == null) goto L15;
        LynxContext r102 = this.mContext;
        if (r102 == null) goto L7;
        LynxFeatureCounter.a(79, r102.getInstanceId());
    L7:
        w6a.h r103 = w6a.h.a.f558471a;
        monitor-enter(r103);
        r103.f558468e.put(this, r101);     // Catch: Throwable -> L12
        setPauseAnim(r101);     // Catch: Throwable -> L12
        monitor-exit(r103);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @LynxProp(name = "hardware-layer")
    public void setRenderToHardwareTexture(boolean r100) {
        if (r100 == false) goto L7;
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L6;
        LynxFeatureCounter.a(72, r101.getInstanceId());
    L6:
        int r102 = 2;
    L8:
        this.mView.setLayerType(r102, null);
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public void setResumeAnim(s6a.a r100) {
        this.mHeroAnimOwner.f558455h = r100;
    }

    @LynxProp(name = "resume-transition-name")
    public void setResumeTransitionName(ReadableArray r100) {
        s6a.a r101 = s6a.a.d(r100);
        if (r101 == null) goto L15;
        LynxContext r102 = this.mContext;
        if (r102 == null) goto L7;
        LynxFeatureCounter.a(80, r102.getInstanceId());
    L7:
        w6a.h r103 = w6a.h.a.f558471a;
        monitor-enter(r103);
        r103.f558467d.put(this, r101);     // Catch: Throwable -> L12
        setResumeAnim(r101);     // Catch: Throwable -> L12
        monitor-exit(r103);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @LynxProp(name = "shared-element")
    public void setShareElement(String r100) {
        w6a.e r101 = this.mHeroAnimOwner;
        r101.f558456i = r100;
        w6a.h r102 = w6a.h.a.f558471a;
        LynxUI r103 = r101.f558448a;
        monitor-enter(r102);
        r102.f558469f.put(r103, r100);     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setStickyTranslate(PointF r100) {
        super.setStickyTranslate(r100);
        com.lynx.tasm.behavior.ui.utils.a r101 = this.mBackgroundManager;
        if (r101 == null) goto L6;
        r101.f383129h = r100;
        r101.u();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "lynx-test-tag")
    public void setTestID(String r100) {
        this.mView.setTag(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "transform")
    public void setTransform(ReadableArray r100) {
        this.mHasTranslateDiff = hasTranslateDiff(r100);
        super.setTransform(r100);
        if (getKeyframeManager() == null) goto L6;
        getKeyframeManager().d("Transform", this.mTransformRaw);
        return;
    }

    @LynxProp(name = "transform-order")
    public void setTransformOrder(f6a.a r100) {
        if (r100 != null) goto L5;
        this.mBackgroundManager.f383131j = true;
        return;
    L5:
        ReadableType r101 = r100.getType();
        if (r101 != ReadableType.Boolean) goto L9;
        com.lynx.tasm.behavior.ui.utils.a r102 = this.mBackgroundManager;
        r102.f383131j = r100.asBoolean();
        return;
    L9:
        if (r101 != ReadableType.String) goto L13;
        String r103 = r100.asString();
        com.lynx.tasm.behavior.ui.utils.a r104 = this.mBackgroundManager;
        r104.f383131j = r103.equalsIgnoreCase("true");
        return;
    }

    @LynxProp(defaultInt = 1, name = RemoteMessageConst.Notification.VISIBILITY)
    public void setVisibility(int r100) {
        u6a.a r101 = this.mTransitionAnimator;
        if (r101 != null) goto L5;
    L8:
        int r102 = this.mView.getVisibility();
        if (r100 != 1) goto L11;
        this.mSetVisibleByCSS = true;
        this.mView.setVisibility(0);
        r102 = 0;
    L14:
        if ((getParent() instanceof UIShadowProxy) == false) goto L17;
        ((UIShadowProxy) getParent()).setVisibilityForView(r102);
        return;
    L17:
        return;
    L11:
        if (r100 != 0) goto L14;
        this.mSetVisibleByCSS = false;
        r102 = 4;
        this.mView.setVisibility(4);
        goto L14
    L5:
        if (r101.b(128) == false) goto L8;
        this.mTransitionAnimator.a(this, 128, Integer.valueOf(r100));
    }

    public void setVisibilityForView(int r100) {
        if (r100 != 0) goto L6;
        this.mSetVisibleByCSS = true;
        this.mView.setVisibility(0);
        return;
    L6:
        if (r100 != 4) goto L10;
        this.mSetVisibleByCSS = false;
        this.mView.setVisibility(4);
        return;
    }

    public void updateLayoutParams(ViewGroup.LayoutParams r100) {
        if (r100 == null) goto L8;
        r100.width = getWidth();
        r100.height = getHeight();
        if (r100 == this.mView.getLayoutParams()) goto L9;
        this.mView.setLayoutParams(r100);
        return;
    L9:
        return;
    L8:
        throw new RuntimeException("LayoutPrams should not be null");
    }

    public LynxUI(LynxContext r100) {
        this(r100, null);
    }

    public void setAnimation(s6a.a r100) {
        prepareKeyframeManager();
        com.lynx.tasm.animation.keyframe.a r101 = this.mKeyframeManager;
        r101.getClass();
        r101.f381825b = new s6a.a[]{r100};
    }

    public LynxUI(LynxContext r100, Object r101) {
        super(r100, r101);
        this.mGrayscaleAmount = 1.0f;
        this.mBrightnessAmount = 1.0f;
        this.mContrastAmount = 1.0f;
        this.mSaturateAmount = 1.0f;
        this.mHueRotateAmount = 0.0f;
        this.mSetVisibleByCSS = true;
        this.mLayoutAnimator = null;
        this.mOverlappingRendering = true;
        this.mEnableReuseAnimationState = true;
        this.mAnimationInfos = null;
        this.mFirstRender = true;
        this.mAlpha = 1.0f;
        this.mDrawHead = null;
        this.mOffsetRotate = OFFSET_ROTATE_AUTO;
        this.mOffsetRotateAngle = 0.0f;
        this.mIsAutoOffsetRotate = true;
        this.mOffsetHasChanged = false;
    }

    private void restoreKeyframeStateFromStorage(String r100, UIList r101) {
        if (this.mEnableReuseAnimationState == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        if (this.mAnimationInfos == null) goto L27;
        String r102 = "Animation_" + constructListStateCacheKey(getTagName(), r100, getIdSelector());
        com.lynx.tasm.animation.keyframe.a r103 = (com.lynx.tasm.animation.keyframe.a) ((HashMap) r101.f382656y).get(r102);
        if (r103 == null) goto L22;
        ((HashMap) r101.f382656y).remove(r102);
        com.lynx.tasm.animation.keyframe.a r104 = this.mKeyframeManager;
        if (r104 == null) goto L14;
        r104.a();
        this.mKeyframeManager = null;
    L14:
        r103.f381824a = new WeakReference(this);
        HashMap<String, LynxKeyframeAnimator> r105 = r103.f381826c;
        if (r105 == null) goto L21;
        Iterator<LynxKeyframeAnimator> r106 = r105.values().iterator();
    L19:
        if (r106.hasNext() == false) goto L21;
        LynxKeyframeAnimator r107 = r106.next();
        r107.getClass();
        r107.f381794b = new WeakReference(this);
        r107.f381795c = new WeakReference(getView());
        r107.b(r107.f381801i);
    L21:
        this.mKeyframeManager = r103;
    L23:
        com.lynx.tasm.animation.keyframe.a r108 = this.mKeyframeManager;
        r108.f381825b = this.mAnimationInfos;
        r108.c();
        return;
    L22:
        prepareKeyframeManager();
        goto L23
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean checkStickyOnParentScroll(int r100, int r101) {
        boolean r102 = super.checkStickyOnParentScroll(r100, r101);
        if (this.mSticky == null) goto L5;
        LynxBaseUI.Sticky r103 = this.mSticky;
        PointF r104 = new PointF(r103.f382343a, r103.f382344b);
    L6:
        com.lynx.tasm.behavior.ui.utils.a r105 = this.mBackgroundManager;
        if (r105 == null) goto L9;
        r105.f383129h = r104;
        r105.u();
    L9:
        return r102;
    L5:
        r104 = null;
        goto L6
    }

    public T createView(Context r100, Object r101) {
        return (T) createView(r100);
    }

    public T getOrCreateView(Context r100, Object r101) {
        LynxContext r102 = this.mContext;
        if (r102 == null) goto L15;
        if (r102.isFallbackProcess() == false) goto L15;
        if (this.mContext.getUIBodyView() == null) goto L15;
        if ((r101 instanceof j) == false) goto L15;
        setNodeIndex(((j) r101).f382563b);
        T r103 = (T) this.mContext.getUIBodyView().obtainViewAccordingToNodeIndex(this.mNodeIndex);
        if (r103 == null) goto L15;
        r103.setBackground(null);
        return r103;
    L15:
        return (T) createView(r100, r101);
    }

    public void insertDrawList(LynxBaseUI r100, LynxBaseUI r101) {
        r101.setDrawParent(this);
        if (r100 != null) goto L8;
        LynxBaseUI r102 = this.mDrawHead;
        if (r102 == null) goto L7;
        r102.mPreviousDrawUI = r101;
        r101.mNextDrawUI = r102;
    L7:
        this.mDrawHead = r101;
        return;
    L8:
        LynxBaseUI r103 = r100.mNextDrawUI;
        if (r103 == null) goto L11;
        r103.mPreviousDrawUI = r101;
        r101.mNextDrawUI = r103;
    L11:
        r101.mPreviousDrawUI = r100;
        r100.mNextDrawUI = r101;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void onFocusChanged(boolean r100, boolean r101) {
        if (r101 == true) goto L11;
        InputMethodManager r102 = LynxEnv.inst().getInputMethodManager();
        if (r102 != null) goto L7;
        LLog.w(TAG, "Failed to get InputMethodManager");
        return;
    L7:
        if (r100 == false) goto L9;
        r102.showSoftInput(this.mView, 1);
        return;
    L9:
        r102.hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
        return;
    }

    public void onListCellAppear(String r100, UIList r101) {
        super.onListCellAppear(r100, r101);
        restoreKeyframeStateFromStorage(r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setSign(int r100, String r101) {
        super.setSign(r100, r101);
    }

    @LynxUIMethod
    public void takeScreenshot(ReadableMap r110, Callback r111) {
        if (this.mView != null) goto L6;
        r111.invoke(new Object[]{6, new JavaOnlyMap()});
        return;
    L6:
        String r100 = r110.getString(SubInfo.KEY_FORMAT, LoadParams.ImageFormat.JPEG);
        boolean r101 = r110.getBoolean("androidEnablePixelCopy", false);
        if (r100.equals(LoadParams.ImageFormat.PNG) == false) goto L9;
        Bitmap.Config r102 = Bitmap.Config.ARGB_8888;
        Bitmap.CompressFormat r103 = Bitmap.CompressFormat.PNG;
        String r104 = "data:image/png;base64,";
    L10:
        Bitmap.CompressFormat r105 = r103;
        String r106 = r104;
        float r107 = (float) r110.getDouble("scale", 1.0d);
        i8a.h r112 = (i8a.h) i8a.n.c().a(i8a.h.class);     // Catch: Throwable -> L27
        if (r112 == null) goto L15;
        Bitmap r113 = r112.c(this.mView, r102);     // Catch: Throwable -> L27
    L25:
        LynxThreadPool.b().execute(new d(r107, r113, r105, r106, r111));     // Catch: Throwable -> L27
        return;
    L15:
        r113 = Bitmap.createBitmap(this.mView.getWidth(), this.mView.getHeight(), r102);     // Catch: Throwable -> L27
        Canvas r108 = new Canvas(r113);     // Catch: Throwable -> L27
        if (r101 == false) goto L22;
        LynxContext r109 = this.mContext;     // Catch: Throwable -> L27
        if (r109 == null) goto L22;
        if (r109.getUIBodyView() == null) goto L22;
        ((LynxUIRenderer) this.mContext.getUIBodyView().getLynxUIRendererInternal()).d(this.mView, r108);     // Catch: Throwable -> L27
    L22:
        boolean r114 = this.mView.isDirty();     // Catch: Throwable -> L27
        this.mView.draw(r108);     // Catch: Throwable -> L27
        if (r114 == false) goto L25;
        this.mView.postInvalidate();     // Catch: Throwable -> L27
    L27:
        r111.invoke(new Object[]{1, new JavaOnlyMap()});
        return;
    L9:
        r102 = Bitmap.Config.RGB_565;
        r103 = Bitmap.CompressFormat.JPEG;
        r104 = "data:image/jpeg;base64,";
        goto L10
    }

    private void saveKeyframeStateToStorage(String r100, LynxBaseUI r101, boolean r102) {
        if (this.mEnableReuseAnimationState == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L22;
        if (r102 == true) goto L9;
    L10:
        if (r102 == true) goto L21;
    L11:
        String r103 = "Animation_" + constructListStateCacheKey(getTagName(), r100, getIdSelector());
        if (r102 == true) goto L14;
        r101.removeKeyFromNativeStorage(r103);
    L15:
        com.lynx.tasm.animation.keyframe.a r104 = this.mKeyframeManager;
        if (r104 == null) goto L18;
        r104.a();
    L18:
        this.mKeyframeManager = null;
        return;
    L14:
        r101.storeKeyToNativeStorage(r103, this.mKeyframeManager);
        goto L15
    L21:
        return;
    L9:
        if (this.mKeyframeManager != null) goto L11;
    }

    public void applyOffsetAndRotate(float r100, float r101, float r110) {
        com.lynx.tasm.behavior.ui.utils.a r102 = this.mBackgroundManager;
        r102.f383130i = new PointF(r100, r101);
        r102.u();
        ArrayList r103 = new ArrayList();
        r103.add(new n(32, r110, 0, 0.0f, 0, 0));
        List<n> r104 = this.mTransformRaw;
        if (r104 == null) goto L5;
        r103.addAll(r104);
    L5:
        this.mBackgroundManager.t(r103);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onListCellDisAppear(String r100, LynxBaseUI r101, boolean r102) {
        super.onListCellDisAppear(r100, r101, r102);
        saveKeyframeStateToStorage(r100, r101, r102);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean calculateStickyTranslateWithOffset(int r100, boolean r101, int r102, int r103) {
        boolean r104 = super.calculateStickyTranslateWithOffset(r100, r101, r102, r103);
        if (r104 == true) goto L5;
    L7:
        PointF r105 = null;
    L8:
        com.lynx.tasm.behavior.ui.utils.a r106 = this.mBackgroundManager;
        if (r106 == null) goto L11;
        r106.f383129h = r105;
        r106.u();
    L11:
        return r104;
    L5:
        if (this.mSticky == null) goto L7;
        LynxBaseUI.Sticky r107 = this.mSticky;
        r105 = new PointF(r107.f382343a, r107.f382344b);
        goto L8
    }
}
