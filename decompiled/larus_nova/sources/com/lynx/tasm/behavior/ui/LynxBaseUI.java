package com.lynx.tasm.behavior.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableMap;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxPropGroup;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.a0;
import com.lynx.tasm.behavior.b1;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.r0;
import com.lynx.tasm.behavior.u;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityHelper;
import com.lynx.tasm.behavior.ui.list.AbsLynxList;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll;
import com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BorderStyle;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.utils.LynxUISetter;
import com.lynx.tasm.behavior.utils.PropsUpdater;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.behavior.y;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.SizeValue;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public abstract class LynxBaseUI implements k, EventTarget, Cloneable, p7a.a, p7a.b {
    private static final Set<String> BACKGROUND_PROPS = null;
    protected static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 0.0f;
    protected static final int DEFAULT_PERSPECTIVE_FACTOR = 100;
    private static final int INVALID_STICKY_SIGN = -1;
    public static final short OVERFLOW_HIDDEN = 0;
    public static final short OVERFLOW_X = 1;
    public static final short OVERFLOW_XY = 3;
    public static final short OVERFLOW_Y = 2;
    public static final int[] SPACING_TYPES = null;
    private static final String TAG = "LynxBaseUI";
    private static final int[] sDefaultOffsetToLynxView = null;
    protected boolean hasTransformChanged;
    private ArrayList mAccessibilityActions;
    protected int mAccessibilityElementStatus;
    private ArrayList<String> mAccessibilityElements;
    private ArrayList<String> mAccessibilityElementsA11y;
    protected boolean mAccessibilityEnableTap;
    private String mAccessibilityId;
    protected boolean mAccessibilityKeepFocused;
    private String mAccessibilityLabel;
    private String mAccessibilityRoleDescription;
    private String mAccessibilityStatus;
    private LynxAccessibilityHelper.LynxAccessibilityTraits mAccessibilityTraits;
    private float mAlpha;
    protected int mBackgroundColor;
    protected Bitmap.Config mBitmapConfig;
    private boolean mBlockListEvent;
    private boolean mBlockNativeEvent;
    private ArrayList<ArrayList<SizeValue>> mBlockNativeEventAreas;
    protected int mBorderBottomWidth;
    protected int mBorderLeftWidth;
    protected int mBorderRightWidth;
    private int mBorderSpacingIndex;
    protected int mBorderTopWidth;
    private int mBorderWidth;
    private Rect mBound;
    protected ArrayList<Runnable> mBoundingClientRectCallbacks;
    protected int mCSSPosition;
    protected final List<LynxBaseUI> mChildren;
    private boolean mClipToRadius;
    protected boolean mConsumeHoverEvent;
    private ArrayList<ArrayList<Float>> mConsumeSlideEventAngles;
    protected LynxContext mContext;
    private ReadableMap mDataset;
    private boolean mDisableDefaultResize;
    private boolean mDisplayNone;
    protected k mDrawParent;
    protected c mDrawableCallback;
    private boolean mEnableBitmapGradient;
    private EventTarget.EnableStatus mEnableExposureUIClip;
    private Boolean mEnableExposureUIMargin;
    private boolean mEnableScrollMonitor;
    protected boolean mEnableTouchPseudoPropagation;
    protected EventTarget.EnableStatus mEventThrough;
    protected ArrayList<ArrayList<SizeValue>> mEventThroughActiveRegions;
    protected Map<String, EventsListener> mEvents;
    private String mExposureArea;
    private String mExposureID;
    private String mExposureScene;
    private float mExposureScreenMarginBottom;
    private float mExposureScreenMarginLeft;
    private float mExposureScreenMarginRight;
    private float mExposureScreenMarginTop;
    private String mExposureUIMarginBottom;
    private String mExposureUIMarginLeft;
    private String mExposureUIMarginRight;
    private String mExposureUIMarginTop;
    private float mExtraOffsetX;
    private float mExtraOffsetY;
    protected int mFlattenChildrenCount;
    protected boolean mFocusable;
    protected float mFontSize;
    protected int mGestureArenaMemberId;
    protected Map<Integer, s7a.a> mGestureDetectors;
    protected Map<Integer, t7a.a> mGestureHandlers;
    private boolean mHasRadius;
    protected boolean mHasTranslateDiff;
    private int mHeight;
    private float mHitSlopBottom;
    private float mHitSlopLeft;
    private float mHitSlopRight;
    private float mHitSlopTop;
    private Matrix mHitTestMatrix;
    private String mIdSelector;
    protected EventTarget.EnableStatus mIgnoreFocus;
    protected int mImageRendering;
    protected boolean mIncludeNativeGesture;
    private boolean mIsDetachedWithView;
    protected boolean mIsFirstAnimatedReady;
    protected boolean mIsTransformNode;
    private final Point mLastSize;
    private float mLastTranslateZ;
    private final Point mLatestSize;
    private int mLeft;
    protected com.lynx.tasm.behavior.ui.utils.e mLynxBackground;
    protected int mLynxDirection;
    protected com.lynx.tasm.behavior.ui.utils.g mLynxMask;
    protected int mMarginBottom;
    protected int mMarginLeft;
    protected int mMarginRight;
    protected int mMarginTop;
    protected float mMaxHeight;
    private String mName;
    private boolean mNeedSortChildren;
    private boolean mNeedsBackgroundRecreation;
    protected LynxBaseUI mNextDrawUI;
    protected int mNodeIndex;
    protected ArrayList<Runnable> mNodeReadyBlockArray;
    private WeakReference<int[]> mOffsetDescendantRectToLynxView;
    private boolean mOnResponseChain;
    private int mOriginLeft;
    private int mOriginTop;
    protected int mOverflow;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;
    protected EventTarget.PanInterceptDirection mPanInterceptDirection;
    protected EventTarget.PanInterceptScope mPanInterceptScope;
    protected Object mParam;
    protected k mParent;
    protected ReadableArray mPerspective;
    protected EventTarget.PointerEventsValue mPointerEvents;
    protected float mPrePerspectiveValue;
    protected LynxBaseUI mPreviousDrawUI;
    protected final JavaOnlyMap mProps;
    private int mPseudoStatus;
    private String mRefId;
    private String mScrollMonitorTag;
    private volatile f mScrollStateChangeListener;
    private boolean mShouldAttachChildrenView;
    private int mSign;
    private float mSkewX;
    private float mSkewY;
    private boolean mSkipLayoutUpdated;
    private boolean mSkipRedirection;
    private volatile Set<f> mStateChangeListeners;
    protected Sticky mSticky;
    private int mStickyScrollerSign;
    private String mTagName;
    private String mTestTagName;
    private int mTop;
    private float mTouchSlop;
    private Matrix mTransformMatrix;
    protected com.lynx.tasm.behavior.ui.utils.l mTransformOrigin;
    protected List<n> mTransformRaw;
    protected float mTranslationZ;
    private com.lynx.tasm.behavior.g mUIPaintStyles;
    private f6a.a mUseLocalCache;
    private int mWidth;
    protected boolean nativeInteractionEnabled;
    protected boolean userInteractionEnabled;

    public class Sticky extends RectF {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f382343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f382344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f382345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f382346d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f382347e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f382348f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f382349g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f382350h;

        public Sticky() {
        }
    }

    public class TransOffset {
        public float[] left_bottom;
        public float[] left_top;
        public float[] right_bottom;
        public float[] right_top;
        final /* synthetic */ LynxBaseUI this$0;

        public TransOffset(LynxBaseUI r100) {
            this.this$0 = r100;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReadableMap f382351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Callback f382352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LynxBaseUI f382353c;

        @Override // java.lang.Runnable
        public final void run() {
            LynxBaseUI.access$100(this.f382353c, this.f382351a, this.f382352b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LynxBaseUI r100, ReadableMap r101, Callback r102) {
            this.f382353c = r100;
            this.f382351a = r101;
            this.f382352b = r102;
        }
    }

    public class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxBaseUI f382354a;

        public b(LynxBaseUI r100) {
            this.f382354a = r100;
        }

        @Override // com.lynx.tasm.behavior.ui.f
        public final void onScrollStateChanged(int r100) {
            LynxBaseUI r101 = this.f382354a;
            monitor-enter(r101);
            f[] r102 = (f[]) LynxBaseUI.access$300(this.f382354a).toArray(new f[LynxBaseUI.access$300(this.f382354a).size()]);     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            int r103 = r102.length;
            int r104 = 0;
        L7:
            if (r104 >= r103) goto L9;
            r102[r104].onScrollStateChanged(r100);
            r104 = r104 + 1;
            goto L7
        L9:
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public class c implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxBaseUI f382355a;

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        }

        public c(LynxBaseUI r100) {
            this.f382355a = r100;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            this.f382355a.invalidate();
        }
    }

    static {
        SPACING_TYPES = new int[]{8, 0, 2, 1, 3, 4, 5};
        sDefaultOffsetToLynxView = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = (float) Math.sqrt(5.0d);
        BACKGROUND_PROPS = new HashSet(Arrays.asList(new String[]{GXTemplateKey.STYLE_BACKGROUND_COLOR, GXTemplateKey.STYLE_BACKGROUND_IMAGE, "background-origin", "background-position", "background-repeat", "background-size", GXTemplateKey.STYLE_BORDER_BOTTOM_LEFT_RADIUS, GXTemplateKey.STYLE_BORDER_BOTTOM_RIGHT_RADIUS, GXTemplateKey.STYLE_BORDER_TOP_LEFT_RADIUS, GXTemplateKey.STYLE_BORDER_TOP_RIGHT_RADIUS, GXTemplateKey.STYLE_BORDER_RADIUS}));
    }

    private synchronized void initScrollStateChangeListener() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mScrollStateChangeListener == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mScrollStateChangeListener = new b(this);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public boolean canConsumeGesture(float r100, float r101) {
        return false;
    }

    public boolean canHaveFlattenChild() {
        return true;
    }

    public void consumeGesture(boolean r100) {
    }

    public void createViewAsync() {
    }

    public boolean dispatchEvent(LynxEventDetail r100) {
        return false;
    }

    public void dispatchProperties(x0 r100) {
    }

    public boolean dispatchTouch(MotionEvent r100) {
        return false;
    }

    public boolean enableLayoutAnimation() {
        return false;
    }

    public void ensureCreateView(View r100) {
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return null;
    }

    public LynxBaseUI getExposeReceiveTarget() {
        return this;
    }

    public long getFirstMeaningfulContentPresentedTimestampMicros() {
        return -1;
    }

    public int getInitialOverflowType() {
        return 1;
    }

    public com.lynx.tasm.animation.keyframe.a getKeyframeManager() {
        return null;
    }

    public t6a.c getLayoutAnimator() {
        return null;
    }

    public int getMemberScrollX() {
        return 0;
    }

    public int getMemberScrollY() {
        return 0;
    }

    public long getMemoryUsageBytes() {
        return 0;
    }

    public Map<String, String> getMemoryUsageDetail() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget getRootLynxPageUI() {
        EventTarget r100 = this;
    L3:
        if (r100 == null) goto L7;
        if (r100.getParentLynxPageUI() == null) goto L7;
        r100 = r100.getParentLynxPageUI();
    L7:
        return r100;
    }

    public float getScaleX() {
        return 1.0f;
    }

    public float getScaleY() {
        return 1.0f;
    }

    public int getScrollContainerDirection() {
        return 0;
    }

    public int getScrollX() {
        return 0;
    }

    public int getScrollY() {
        return 0;
    }

    public u6a.a getTransitionAnimator() {
        return null;
    }

    public float getTranslationX() {
        return 0.0f;
    }

    public float getTranslationY() {
        return 0.0f;
    }

    public Object getValueFromNativeStorage(String r100) {
        return null;
    }

    public void initTransitionAnimator(ReadableMap r100) {
    }

    public boolean initialPropsFlushed(String r100, String r101) {
        return true;
    }

    public void initialize() {
    }

    public void interceptGesture(boolean r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.k
    public void invalidate() {
    }

    public boolean isAccessibilityDirectionVertical() {
        return true;
    }

    public boolean isAccessibilityHostUI() {
        return false;
    }

    public boolean isAtBorder(boolean r100) {
        return true;
    }

    public boolean isCustomHittest() {
        return false;
    }

    public boolean isFlatten() {
        return false;
    }

    public boolean isOverlay() {
        return false;
    }

    public boolean isScrollContainer() {
        return false;
    }

    public boolean isScrollable() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public boolean needCustomLayout() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void offResponseChain() {
        this.mOnResponseChain = false;
    }

    public void onAnimationNodeReady() {
    }

    public void onAnimationUpdated() {
    }

    public void onBeforeAnimation(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
    }

    public void onBorderRadiusUpdated(int r100) {
    }

    public void onDrawingPositionChanged() {
    }

    public void onFocusChanged(boolean r100, boolean r101) {
    }

    public void onGestureScrollBy(float r100, float r101) {
    }

    public void onInvalidate() {
    }

    public void onLayoutFinish(long r100) {
    }

    public void onLayoutFinish(long r100, LynxBaseUI r101) {
    }

    public void onNodeReload() {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onResponseChain() {
        this.mOnResponseChain = true;
    }

    public void registerViewAccordingToNodeIndex() {
    }

    public void removeChildrenExposureUI() {
    }

    public void removeKeyFromNativeStorage(String r100) {
    }

    public void renderIfNeeded() {
    }

    public boolean requestChildUIRectangleOnScreen(LynxBaseUI r100, Rect r101, boolean r102) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.k
    public void requestLayout() {
    }

    public float[] scrollBy(float r100, float r101) {
        return new float[]{0.0f, 0.0f, r100, r101};
    }

    @LynxProp(name = "accessibility-heading")
    public void setAccessibilityHeading(boolean r100) {
    }

    @LynxProp(name = "accessibility-value")
    public void setAccessibilityValue(String r100) {
    }

    public void setAnimation(ReadableArray r100) {
    }

    @LynxProp(name = "caret-color")
    public void setCaretColor(String r100) {
    }

    public void setInitialPropsHasFlushed(String r100, String r101) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setPanInterceptAncestors(boolean r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setPanInterceptDescendants(boolean r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setPanInterceptSelf(boolean r100) {
    }

    public void setStickyTranslate(PointF r100) {
    }

    public void storeKeyToNativeStorage(String r100, Object r101) {
    }

    public void updateExtraData(Object r100) {
    }

    private void ensureLynxBackground() {
        if (this.mLynxBackground != null) goto L5;
    L6:
        com.lynx.tasm.behavior.ui.utils.e r100 = new com.lynx.tasm.behavior.ui.utils.e(this.mContext);
        this.mLynxBackground = r100;
        r100.f383143c = this.mDrawableCallback;
        r100.f383144d = this.mFontSize;
        this.mNeedsBackgroundRecreation = false;
        restoreBackgroundProps();
        return;
    L5:
        if (this.mNeedsBackgroundRecreation == true) goto L6;
    }

    private com.lynx.tasm.behavior.ui.utils.g getOrCreateLynxMask() {
        if (this.mLynxMask != null) goto L8;
        com.lynx.tasm.behavior.ui.utils.g r100 = new com.lynx.tasm.behavior.ui.utils.g(this.mContext);
        this.mLynxMask = r100;
        r100.f383143c = this.mDrawableCallback;
        r100.f383144d = this.mFontSize;
        boolean r101 = this.mEnableBitmapGradient;
        com.lynx.tasm.behavior.ui.utils.i r102 = r100.b();
        r102.f383137e.f2103j = r101;
        r102.invalidateSelf();
        this.mLynxMask.f(this.mBitmapConfig);
        com.lynx.tasm.behavior.ui.utils.g r103 = this.mLynxMask;
        r103.b().c(SPACING_TYPES[this.mBorderSpacingIndex], this.mBorderWidth);
        com.lynx.tasm.behavior.ui.utils.g r104 = this.mLynxMask;
        float r105 = this.mPaddingTop;
        float r106 = this.mPaddingRight;
        float r107 = this.mPaddingBottom;
        float r108 = this.mPaddingLeft;
        T r109 = r104.f383142b;
        if (r109 == 0) goto L8;
        r109.d(r105, r106, r107, r108);
    L8:
        return this.mLynxMask;
    }

    private float getTouchSlop() {
        if (this.mOnResponseChain == true) goto L5;
        return 0.0f;
    L5:
        return this.mTouchSlop * INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_LynxBaseUI_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density;
    }

    private boolean isImageConfigBadCase() {
        if (Build.VERSION.SDK_INT == 25) goto L5;
    L7:
        return false;
    L5:
        if (isMeizu15() == false) goto L7;
        return true;
    }

    private static boolean isMeizu() {
        String r100 = Build.BRAND;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.toLowerCase(Locale.ENGLISH).indexOf("meizu") <= (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    private void removeSelfFromStickyScrollerIfNeeded() {
        int r100 = this.mStickyScrollerSign;
        if (r100 != (-1)) goto L5;
        return;
    L5:
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L8;
        Cloneable r102 = r101.findLynxUIBySign(r100);
    L10:
        if ((r102 instanceof g7a.c) == false) goto L12;
        ((g7a.c) r102).z(getSign());
    L12:
        this.mStickyScrollerSign = -1;
        return;
    L8:
        r102 = null;
        goto L10
    }

    private void restoreBackgroundProps() {
        ReadableMapKeySetIterator r100 = this.mProps.keySetIterator();
        x0 r101 = null;
        LynxUISetter r102 = null;
    L4:
        if (r100.hasNextKey() == false) goto L11;
        String r103 = r100.nextKey();
        if (BACKGROUND_PROPS.contains(r103) == false) goto L4;
        if (r101 != null) goto L9;
        r101 = new x0(this.mProps);
        Map<Class<?>, LynxUISetter<?>> r104 = PropsUpdater.f383181a;
        r102 = PropsUpdater.c(getClass());
    L9:
        if (r102 == null) goto L4;
        r102.setProperty(this, r103, r101);
        goto L4
    }

    public void afterAnimationNodeReady() {
        if (this.mIsFirstAnimatedReady == false) goto L5;
        this.mIsFirstAnimatedReady = false;
    L5:
        Point r100 = this.mLastSize;
        Point r101 = this.mLatestSize;
        r100.x = r101.x;
        r100.y = r101.y;
        this.hasTransformChanged = false;
    }

    public LynxBaseUI clone() throws CloneNotSupportedException {
        LynxBaseUI r100 = this.mContext.getLynxUIOwner().createUI(this.mTagName, false);
        applyUIPaintStylesToTarget(r100);
        Iterator<LynxBaseUI> r101 = getChildren().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        LynxBaseUI r102 = r101.next().clone();
        r100.insertChild(r102, r100.getChildren().size());
        ((UIGroup) r100).insertView((LynxUI) r102);
        goto L4
    L6:
        r100.updateProperties(new x0(this.mProps));
        r100.updateLayoutSize(getWidth(), getHeight());
        r100.updateLayout(getLeft(), getTop(), getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), getMarginLeft(), getMarginTop(), getMarginRight(), r100.getMarginBottom(), getBorderLeftWidth(), getBorderTopWidth(), getBorderRightWidth(), getBorderBottomWidth(), getBound());
        r100.onLayoutFinish(0, null);
        r100.onNodeReady();
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void destroy() {
        if ((this instanceof r0) == false) goto L6;
        this.mContext.unregisterPatchFinishListener((r0) this);
    L6:
        if ((this instanceof com.lynx.tasm.behavior.j) == false) goto L11;
        LynxUIOwner r100 = this.mContext.getLynxUIOwner();
        if (r100 == null) goto L11;
        r100.unregisterForegroundListener((com.lynx.tasm.behavior.j) this);
    L11:
        if (this.mContext.getIntersectionObserverManager() == null) goto L13;
        d0 r101 = this.mContext.getIntersectionObserverManager();
        r101.getClass();
        UIThreadUtils.runOnUiThreadImmediately(new a0(r101, this));
    L13:
        com.lynx.tasm.behavior.ui.utils.e r102 = this.mLynxBackground;
        if (r102 == null) goto L16;
        r102.d();
    L16:
        com.lynx.tasm.behavior.ui.utils.g r103 = this.mLynxMask;
        if (r103 == null) goto L19;
        r103.d();
    L19:
        com.lynx.tasm.behavior.ui.accessibility.d r104 = this.mContext.getLynxAccessibilityWrapper();
        if (r104 == null) goto L22;
        r104.c(this, false);
    L22:
        q7a.b r105 = getGestureArenaManager();
        if (r105 == null) goto L25;
        r105.f(this);
    L25:
        Map<Integer, t7a.a> r106 = this.mGestureHandlers;
        if (r106 == null) goto L29;
        r106.clear();
        return;
    }

    public void flattenChildrenCountDecrement() {
        this.mFlattenChildrenCount--;
    }

    public void flattenChildrenCountIncrement() {
        this.mFlattenChildrenCount++;
    }

    public Rect getBoundingClientRect() {
        ViewGroup r100 = this.mContext.getUIBody().getBodyView();
        int r101 = 0;
        if (r100 != null) goto L7;
        return new Rect(0, 0, getWidth() + 0, getHeight() + 0);
    L7:
        if ((this instanceof LynxUI) == false) goto L26;
        View r102 = ((LynxUI) this).mView;
        if ((r102 instanceof UIShadowProxy.d) == false) goto L13;
        UIShadowProxy.d r103 = (UIShadowProxy.d) r102;
        if (r103.getChildCount() <= 0) goto L13;
        r102 = r103.getChildAt(0);
    L13:
        Rect r104 = new Rect();
        View r105 = r102.getRootView();
        if (r100.getRootView() != r105) goto L16;
    L43:
        r100.offsetDescendantRectToMyCoords(r102, r104);     // Catch: IllegalArgumentException -> L20
        r104.offset(r102.getScrollX(), r102.getScrollY());     // Catch: IllegalArgumentException -> L20
    L21:
        int[] r106 = getOffsetDescendantRectToLynxView();
        int r107 = r106[0];
        if (r107 == Integer.MIN_VALUE) goto L24;
        r104.offset(r107, r106[1]);
    L24:
        int r108 = r104.top;
        r101 = r104.left;
        int r109 = r108;
    L42:
        return new Rect(r101, r109, getWidth() + r101, getHeight() + r109);
    L16:
        if ((r105 instanceof ViewGroup) == false) goto L43;
        r100 = (ViewGroup) r105;
        goto L43
    L26:
        if ((this instanceof LynxFlattenUI) == false) goto L40;
        k r110 = this.mParent;
        if (r110 != null) goto L30;
    L39:
        r101 = this.mLeft;
        r109 = this.mTop;
        goto L42
    L30:
        if (r110 == this.mContext.getUIBody()) goto L39;
        r109 = 0;
        LynxBaseUI r111 = this;
    L33:
        if ((r111 instanceof LynxFlattenUI) == false) goto L37;
        if (r111 == this.mContext.getUIBody()) goto L37;
        r101 = r101 + r111.getOriginLeft();
        r109 = r109 + r111.getOriginTop();
        r111 = r111.getParentBaseUI();
    L37:
        if (r111 == null) goto L42;
        Rect r112 = r111.getBoundingClientRect();
        r101 = r101 + (r112.left - r111.getScrollX());
        r109 = r109 + (r112.top - r111.getScrollY());
        goto L42
    L40:
        r109 = 0;
        goto L42
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public HashMap<String, EventTarget> getChildrenLynxPageUI() {
        LynxContext r100 = this.mContext;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.getUIBody() != null) goto L8;
        return null;
    L8:
        return this.mContext.getUIBody().getChildrenLynxPageUI();
    }

    public LynxBaseUI getDrawParent() {
        return (LynxBaseUI) this.mDrawParent;
    }

    public boolean getEnableExposureUIMargin() {
        Boolean r100 = this.mEnableExposureUIMargin;
        if (r100 == null) goto L6;
        return r100.booleanValue();
    L6:
        return this.mContext.getEnableExposureUIMargin();
    }

    public String getExposeUniqueID() {
        return String.valueOf(this.mSign);
    }

    public q7a.b getGestureArenaManager() {
        LynxContext r100 = this.mContext;
        if (r100 != null) goto L5;
        return null;
    L5:
        LynxUIOwner r101 = r100.getLynxUIOwner();
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.getGestureArenaManager();
    }

    public Matrix getHitTestMatrix() {
        this.mHitTestMatrix.reset();
        return this.mHitTestMatrix;
    }

    public final int getLatestHeight() {
        return this.mLatestSize.y;
    }

    public final int getLatestWidth() {
        return this.mLatestSize.x;
    }

    public int[] getOffsetDescendantRectToLynxView() {
        int[] r100 = this.mOffsetDescendantRectToLynxView.get();
        if (r100 == null) goto L6;
        return r100;
    L6:
        return sDefaultOffsetToLynxView;
    }

    public com.lynx.tasm.behavior.g getOrCreateUIPaintStyles() {
        if (this.mUIPaintStyles != null) goto L6;
        this.mUIPaintStyles = new com.lynx.tasm.behavior.g();
    L6:
        return this.mUIPaintStyles;
    }

    public LynxBaseUI getParentBaseUI() {
        k r100 = this.mParent;
        if ((r100 instanceof UIShadowProxy) == false) goto L7;
        return (LynxBaseUI) ((UIShadowProxy) r100).getParent();
    L7:
        return (LynxBaseUI) r100;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget getParentLynxPageUI() {
        LynxContext r100 = this.mContext;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.getUIBody() != null) goto L8;
        return null;
    L8:
        return this.mContext.getUIBody().getParentLynxPageUI();
    }

    public JSONObject getPlatformCustomInfo() {
        return new JSONObject();
    }

    public Rect getRectToWindow() {
        UIBody.UIBodyView r100 = this.mContext.getUIBody().getBodyView();
        if (r100 == null) goto L5;
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        Rect r102 = getBoundingClientRect();
        r102.offset(r101[0], r101[1]);
        return r102;
    L5:
        return new Rect();
    }

    public String getTestID() {
        String r100 = this.mTestTagName;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public b1 getTouchEventDispatcher() {
        LynxContext r100 = this.mContext;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getTouchEventDispatcher();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public Matrix getTransformMatrix() {
        this.mTransformMatrix.reset();
        return this.mTransformMatrix;
    }

    public boolean getVisibility() {
        return !this.mDisplayNone;
    }

    public Window getWindow() {
        Context r100 = this.mContext;
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L9;
        if ((r100 instanceof Activity) == true) goto L13;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L4
    L13:
        return ((Activity) r100).getWindow();
    L9:
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean hasConsumeSlideEventAngles() {
        ArrayList<ArrayList<Float>> r100 = this.mConsumeSlideEventAngles;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L7;
        return true;
    }

    public final boolean hasSizeChanged() {
        return !this.mLastSize.equals(this.mLatestSize);
    }

    public boolean ignoreFocus() {
        EventTarget.EnableStatus r100 = this.mIgnoreFocus;
        if (r100 != EventTarget.EnableStatus.Enable) goto L7;
        return true;
    L7:
        if (r100 != EventTarget.EnableStatus.Disable) goto L10;
        return false;
    L10:
        if (parent() != null) goto L12;
        return false;
    L12:
        return parent().ignoreFocus();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isClickable() {
        Map<String, EventsListener> r100 = this.mEvents;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.containsKey("tap") == false) goto L7;
        return true;
    }

    public boolean isEnableNewGesture() {
        if (this.mGestureArenaMemberId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isLongClickable() {
        Map<String, EventsListener> r100 = this.mEvents;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.containsKey("longpress") == false) goto L7;
        return true;
    }

    public void layout() {
        Iterator<LynxBaseUI> r100 = this.mChildren.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().layout();
        goto L4
    }

    public void measure() {
        Iterator<LynxBaseUI> r100 = this.mChildren.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().measure();
        goto L4
    }

    public void onAttach() {
        com.lynx.tasm.behavior.ui.utils.e r100 = this.mLynxBackground;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        com.lynx.tasm.behavior.ui.utils.g r101 = this.mLynxMask;
        if (r101 == null) goto L9;
        r101.c();
        return;
    }

    public void onDetach() {
        com.lynx.tasm.behavior.ui.utils.e r100 = this.mLynxBackground;
        if (r100 == null) goto L5;
        r100.d();
    L5:
        com.lynx.tasm.behavior.ui.utils.g r101 = this.mLynxMask;
        if (r101 == null) goto L9;
        r101.d();
        return;
    }

    public void onLayoutUpdated() {
        if (this.mSkipLayoutUpdated == false) goto L5;
        return;
    L5:
        com.lynx.tasm.behavior.ui.utils.e r100 = this.mLynxBackground;
        if (r100 == null) goto L10;
        float r101 = this.mPaddingTop;
        float r102 = this.mPaddingRight;
        float r103 = this.mPaddingBottom;
        float r104 = this.mPaddingLeft;
        T r105 = r100.f383142b;
        if (r105 == 0) goto L10;
        r105.d(r101, r102, r103, r104);
    L10:
        com.lynx.tasm.behavior.ui.utils.g r106 = this.mLynxMask;
        if (r106 == null) goto L15;
        float r107 = this.mPaddingTop;
        float r108 = this.mPaddingRight;
        float r109 = this.mPaddingBottom;
        float r110 = this.mPaddingLeft;
        T r111 = r106.f383142b;
        if (r111 == 0) goto L15;
        r111.d(r107, r108, r109, r110);
    L15:
        invalidate();
        requestLayout();
    }

    public void onNodeRemoved() {
        LynxContext r100 = this.mContext;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getEnableNewSticky() == false) goto L9;
        removeSelfFromStickyScrollerIfNeeded();
        setStickyTranslate(null);
        return;
    }

    public void onPropsUpdated() {
        LynxContext r100 = this.mContext;
        if (r100 == null) goto L6;
        r100.addUIToExposedMap(this);
    L6:
        if (this.mGestureHandlers == null) goto L13;
        q7a.b r101 = getGestureArenaManager();
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.e(getGestureArenaMemberId()) == true) goto L15;
        this.mGestureArenaMemberId = r101.a(this);
        return;
    L15:
        return;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget parent() {
        k r100 = this.mParent;
        if ((r100 instanceof EventTarget) == true) goto L5;
        return null;
    L5:
        return (EventTarget) r100;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public v6a.a parentResponder() {
        k r100 = this.mParent;
        if ((r100 instanceof v6a.a) == true) goto L5;
        return null;
    L5:
        return (v6a.a) r100;
    }

    public EventTarget.PointerEventsValue pointerEvents() {
        EventTarget.PointerEventsValue r100 = this.mPointerEvents;
        if (r100 == EventTarget.PointerEventsValue.Unset) goto L6;
        return r100;
    L6:
        if (parent() == null) goto L10;
        return parent().pointerEvents();
    L10:
        return EventTarget.PointerEventsValue.Auto;
    }

    public void recognizeGesturere() {
        LynxContext r100 = this.mContext;
        if (r100 == null) goto L6;
        r100.onGestureRecognized(this);
        return;
    }

    public void sendLayoutChangeEvent() {
        Map<String, EventsListener> r100 = this.mEvents;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.containsKey("layoutchange") == false) goto L9;
        Map<String, Object> r101 = buildLayoutChangeEventDetail();
        getLynxContext().getEventEmitter().sendCustomEvent(new com.lynx.tasm.event.a(getSign(), "layoutchange", r101));
        return;
    }

    public final boolean shouldDoTransform() {
        if (this.hasTransformChanged == false) goto L5;
        return true;
    L5:
        if (n.a(this.mTransformRaw) == true) goto L46;
        com.lynx.tasm.behavior.ui.utils.l r100 = this.mTransformOrigin;
        com.lynx.tasm.behavior.ui.utils.l r101 = com.lynx.tasm.behavior.ui.utils.l.f383154e;
        if (r100 != null) goto L9;
    L43:
        boolean r102 = false;
    L44:
        if (r102 == true) goto L46;
    L48:
        return false;
    L9:
        if (r100.f383155a == 0.5f) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
    L26:
        boolean r104 = true;
    L27:
        if (r104 == false) goto L43;
        if (r100.f383156b != 1) goto L31;
        boolean r105 = true;
    L32:
        if (r105 == false) goto L34;
    L40:
        boolean r106 = true;
    L41:
        if (r106 == false) goto L43;
        r102 = true;
        goto L44
    L34:
        if (r100.f383158d != 1) goto L36;
        boolean r107 = true;
    L37:
        if (r107 == true) goto L40;
        r106 = false;
        goto L41
    L36:
        r107 = false;
        goto L37
    L31:
        r105 = false;
        goto L32
    L17:
        if (r100.f383157c == 0.5f) goto L19;
    L22:
        boolean r108 = true;
    L23:
        if (r108 == true) goto L26;
        r104 = false;
        goto L27
    L19:
        if (r100.f383158d != 1) goto L22;
        r108 = false;
        goto L23
    L11:
        if (r100.f383156b != 1) goto L14;
        r103 = false;
    L46:
        if (hasSizeChanged() == false) goto L48;
        return true;
    }

    public void uiOwnerDidPerformLayout() {
        if (this.mBoundingClientRectCallbacks.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r100 = new ArrayList(this.mBoundingClientRectCallbacks);
        this.mBoundingClientRectCallbacks.clear();
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((Runnable) r101.next()).run();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private g7a.c getStickyScroller() {
        LynxBaseUI r100 = getParentBaseUI();
    L3:
        if (r100 == 0) goto L9;
        if ((r100 instanceof g7a.c) == true) goto L7;
        r100 = r100.getParentBaseUI();
        goto L3
    L7:
        return (g7a.c) r100;
    L9:
        return null;
    }

    private static boolean isMeizu15() {
        if (isMeizu() == false) goto L8;
        String r100 = Build.DEVICE;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return r100.contains(Constants.VIA_REPORT_TYPE_WPA_STATE);
    L8:
        return false;
    }

    public Map<String, Object> buildLayoutChangeEventDetail() {
        return getPositionInfo(LynxEnv.inst().enableTransformForPositionCalculation());
    }

    public Rect getBoundRectForOverflow() {
        if (getOverflow() != 3) goto L7;
        return null;
    L7:
        return getClipBounds();
    }

    public Rect getClipBounds() {
        int r100 = getWidth();
        int r101 = getHeight();
        DisplayMetrics r102 = getLynxContext().getScreenMetrics();
        int r103 = 0;
        if ((getOverflow() & 1) == 0) goto L5;
        int r104 = r102.widthPixels;
        int r105 = 0 - r104;
        r100 = r100 + (r104 * 2);
    L7:
        if ((getOverflow() & 2) == 0) goto L10;
        int r106 = r102.heightPixels;
        r103 = 0 - r106;
        r101 = r101 + (r106 * 2);
    L10:
        return new Rect(r105, r103, r100 + r105, r101 + r103);
    L5:
        r105 = 0;
        goto L7
    }

    public Map<Integer, t7a.a> getGestureHandlers() {
        if (isEnableNewGesture() == true) goto L7;
        return null;
    L7:
        if (this.mGestureHandlers != null) goto L10;
        this.mGestureHandlers = t7a.a.c(getSign(), getLynxContext(), this, getGestureDetectorMap());
    L10:
        return this.mGestureHandlers;
    }

    public Rect getRect() {
        float r100 = getOriginLeft() + (getWidth() / 2.0f);
        float r101 = getOriginTop() + (getHeight() / 2.0f);
        float r102 = getWidth() * getScaleX();
        float r103 = getHeight() * getScaleY();
        float r104 = (r100 - (r102 / 2.0f)) + getTranslationX();
        float r105 = (r101 - (r103 / 2.0f)) + getTranslationY();
        return new Rect((int) r104, (int) r105, (int) (r104 + r102), (int) (r105 + r103));
    }

    public Rect getRectWithoutTransform() {
        float r100 = getOriginLeft();
        float r101 = getOriginTop();
        return new Rect((int) r100, (int) r101, (int) (r100 + getWidth()), (int) (r101 + getHeight()));
    }

    public void invalidateMeaningfulPaintingArea() {
        if (getLynxContext() != null) goto L6;
        return;
    L6:
        if (getLynxContext().getUIBodyView() != null) goto L8;
        return;
    L8:
        getLynxContext().getUIBodyView().invalidateMeaningfulPaintingArea();
    }

    public boolean needGenerateMeaningfulPaintingArea() {
        if (getMeaningfulContentStatus() == ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT) goto L5;
        return true;
    L5:
        return false;
    }

    public void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        Iterator<Runnable> r100 = this.mNodeReadyBlockArray.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().run();
        goto L4
    L6:
        this.mNodeReadyBlockArray.clear();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean enableTouchPseudoPropagation() {
        return this.mEnableTouchPseudoPropagation;
    }

    public int flattenChildrenCount() {
        return this.mFlattenChildrenCount;
    }

    public ArrayList<String> getAccessibilityActions() {
        return this.mAccessibilityActions;
    }

    public int getAccessibilityElementStatus() {
        return this.mAccessibilityElementStatus;
    }

    public ArrayList<String> getAccessibilityElements() {
        return this.mAccessibilityElements;
    }

    public ArrayList<String> getAccessibilityElementsA11y() {
        return this.mAccessibilityElementsA11y;
    }

    public boolean getAccessibilityEnableTap() {
        return this.mAccessibilityEnableTap;
    }

    public String getAccessibilityId() {
        return this.mAccessibilityId;
    }

    public boolean getAccessibilityKeepFocused() {
        return this.mAccessibilityKeepFocused;
    }

    public CharSequence getAccessibilityLabel() {
        return this.mAccessibilityLabel;
    }

    public String getAccessibilityRoleDescription() {
        return this.mAccessibilityRoleDescription;
    }

    public String getAccessibilityStatus() {
        return this.mAccessibilityStatus;
    }

    public LynxAccessibilityHelper.LynxAccessibilityTraits getAccessibilityTraits() {
        return this.mAccessibilityTraits;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public int getBorderBottomWidth() {
        return this.mBorderBottomWidth;
    }

    public int getBorderLeftWidth() {
        return this.mBorderLeftWidth;
    }

    public int getBorderRightWidth() {
        return this.mBorderRightWidth;
    }

    public int getBorderTopWidth() {
        return this.mBorderTopWidth;
    }

    public Rect getBound() {
        return this.mBound;
    }

    public int getCSSPositionType() {
        return this.mCSSPosition;
    }

    public List<LynxBaseUI> getChildren() {
        return this.mChildren;
    }

    public boolean getClipToRadius() {
        return this.mClipToRadius;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public ReadableMap getDataset() {
        return this.mDataset;
    }

    public boolean getDisableDefaultResize() {
        return this.mDisableDefaultResize;
    }

    public EventTarget.EnableStatus getEnableExposureUIClip() {
        return this.mEnableExposureUIClip;
    }

    public f6a.a getEnableLocalCache() {
        return this.mUseLocalCache;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public Map<String, EventsListener> getEvents() {
        return this.mEvents;
    }

    public String getExposureArea() {
        return this.mExposureArea;
    }

    public String getExposureID() {
        return this.mExposureID;
    }

    public String getExposureScene() {
        return this.mExposureScene;
    }

    public float getExposureScreenMarginBottom() {
        return this.mExposureScreenMarginBottom;
    }

    public float getExposureScreenMarginLeft() {
        return this.mExposureScreenMarginLeft;
    }

    public float getExposureScreenMarginRight() {
        return this.mExposureScreenMarginRight;
    }

    public float getExposureScreenMarginTop() {
        return this.mExposureScreenMarginTop;
    }

    public String getExposureUIMarginBottom() {
        return this.mExposureUIMarginBottom;
    }

    public String getExposureUIMarginLeft() {
        return this.mExposureUIMarginLeft;
    }

    public String getExposureUIMarginRight() {
        return this.mExposureUIMarginRight;
    }

    public String getExposureUIMarginTop() {
        return this.mExposureUIMarginTop;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public int getGestureArenaMemberId() {
        return this.mGestureArenaMemberId;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public Map<Integer, s7a.a> getGestureDetectorMap() {
        return this.mGestureDetectors;
    }

    public boolean getHasRadius() {
        return this.mHasRadius;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getIdSelector() {
        return this.mIdSelector;
    }

    public int getImageRendering() {
        return this.mImageRendering;
    }

    public boolean getIncludeNativeGesture() {
        return this.mIncludeNativeGesture;
    }

    public Point getLastSize() {
        return this.mLastSize;
    }

    public float getLastTranslateZ() {
        return this.mLastTranslateZ;
    }

    public Point getLatestSize() {
        return this.mLatestSize;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public com.lynx.tasm.behavior.ui.utils.e getLynxBackground() {
        return this.mLynxBackground;
    }

    public LynxContext getLynxContext() {
        return this.mContext;
    }

    public com.lynx.tasm.behavior.ui.utils.g getLynxMask() {
        return this.mLynxMask;
    }

    public int getMarginBottom() {
        return this.mMarginBottom;
    }

    public int getMarginLeft() {
        return this.mMarginLeft;
    }

    public int getMarginRight() {
        return this.mMarginRight;
    }

    public int getMarginTop() {
        return this.mMarginTop;
    }

    public ILynxUIMeaningfulContent$MeaningfulContentStatus getMeaningfulContentStatus() {
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT;
    }

    public String getName() {
        return this.mName;
    }

    public boolean getNeedSortChildren() {
        return this.mNeedSortChildren;
    }

    public LynxBaseUI getNextDrawUI() {
        return this.mNextDrawUI;
    }

    public int getNodeIndex() {
        return this.mNodeIndex;
    }

    public int getOriginLeft() {
        return this.mOriginLeft;
    }

    public int getOriginTop() {
        return this.mOriginTop;
    }

    public int getOverflow() {
        return this.mOverflow;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public k getParent() {
        return this.mParent;
    }

    public LynxBaseUI getPreviousDrawUI() {
        return this.mPreviousDrawUI;
    }

    public JavaOnlyMap getProps() {
        return this.mProps;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public int getPseudoStatus() {
        return this.mPseudoStatus;
    }

    public float getRealTimeTranslationZ() {
        return this.mTranslationZ;
    }

    public String getRefIdSelector() {
        return this.mRefId;
    }

    public String getScrollMonitorTag() {
        return this.mScrollMonitorTag;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public int getSign() {
        return this.mSign;
    }

    public float getSkewX() {
        return this.mSkewX;
    }

    public float getSkewY() {
        return this.mSkewY;
    }

    public boolean getSkipRedirection() {
        return this.mSkipRedirection;
    }

    public String getTagName() {
        return this.mTagName;
    }

    public int getTop() {
        return this.mTop;
    }

    public com.lynx.tasm.behavior.ui.utils.l getTransformOriginStr() {
        return this.mTransformOrigin;
    }

    public List<n> getTransformRaws() {
        return this.mTransformRaw;
    }

    public float getTranslationZ() {
        return this.mTranslationZ;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isDetachedWithView() {
        return this.mIsDetachedWithView;
    }

    public boolean isEnableScrollMonitor() {
        return this.mEnableScrollMonitor;
    }

    public boolean isFirstAnimatedReady() {
        return this.mIsFirstAnimatedReady;
    }

    public boolean isFocusable() {
        return this.mFocusable;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isOnResponseChain() {
        return this.mOnResponseChain;
    }

    public boolean isUserInteractionEnabled() {
        return this.userInteractionEnabled;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget.PanInterceptDirection panInterceptDirection() {
        return this.mPanInterceptDirection;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget.PanInterceptScope panInterceptScope() {
        return this.mPanInterceptScope;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8574clone() throws CloneNotSupportedException {
        return clone();
    }

    public LynxBaseUI(Context r100) {
        this((LynxContext) r100);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_LynxBaseUI_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ Set access$300(LynxBaseUI r100) {
        return r100.mStateChangeListeners;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void bindStickyScrollerIfNeeded(g7a.c r100) {
        if ((r100 instanceof LynxBaseUI) == false) goto L10;
        int r101 = ((LynxBaseUI) r100).getSign();
        int r102 = this.mStickyScrollerSign;
        if (r102 == (-1)) goto L8;
        if (r102 == r101) goto L8;
        removeSelfFromStickyScrollerIfNeeded();
    L8:
        this.mStickyScrollerSign = r101;
        r100.r(getSign());
        return;
    }

    private void setBorderColorForAllSpacingIndex(Integer r100) {
        ensureLynxBackground();
        float r101 = 1.0E21f;
        if (r100 != null) goto L5;
        float r102 = 1.0E21f;
    L6:
        if (r100 == null) goto L9;
        r101 = r100.intValue() >>> 24;
    L9:
        int r103 = 1;
    L11:
        if (r103 > 4) goto L13;
        this.mLynxBackground.o(SPACING_TYPES[r103], r102, r101);
        r103 = r103 + 1;
        goto L11
    L13:
        return;
    L5:
        r102 = r100.intValue() & 16777215;
        goto L6
    }

    private float toPix(String r100) {
        UIBody r101 = this.mContext.getUIBody();
        return com.lynx.tasm.utils.n.b(r100, r101.getFontSize(), getFontSize(), r101.getWidth(), r101.getHeight(), 1.0E21f, this.mContext.getScreenMetrics());
    }

    public void addNodeReadyBlock(Runnable r100) {
        if (r100 == null) goto L5;
        this.mNodeReadyBlockArray.add(r100);
        return;
    }

    public void afterPropsUpdated(x0 r100) {
        if (r100 != null) goto L4;
    L6:
        onPropsUpdated();
        onAnimationUpdated();
        com.lynx.tasm.behavior.ui.accessibility.d r101 = this.mContext.getLynxAccessibilityWrapper();
        if (r101 != null) goto L9;
    L17:
        if (r100 != null) goto L19;
        return;
    L19:
        if (r100.j() == false) goto L21;
        return;
    L21:
        if (r100.i(GXTemplateKey.STYLE_BACKGROUND_IMAGE) == false) goto L26;
        com.lynx.tasm.behavior.ui.utils.e r102 = this.mLynxBackground;
        if (r102 == null) goto L26;
        r102.e();
    L26:
        if (r100.i("mask-image") == false) goto L34;
        com.lynx.tasm.behavior.ui.utils.g r103 = this.mLynxMask;
        if (r103 == null) goto L35;
        r103.e();
        return;
    L35:
        return;
    L34:
        return;
    L9:
        if (r101.f382465k == null) goto L17;
        if (r101.m() == false) goto L17;
        if (r100 == null) goto L17;
        ReadableMapKeySetIterator r104 = r100.f383219a.keySetIterator();
    L15:
        if (r104.hasNextKey() == false) goto L17;
        String r105 = r104.nextKey();
        r101.f382465k.a(4, this, r105);
        goto L15
    L4:
        if (r100.j() == true) goto L6;
        invalidate();
        goto L6
    }

    public void applyUIPaintStylesToTarget(LynxBaseUI r100) {
        com.lynx.tasm.behavior.g r101 = this.mUIPaintStyles;
        if (r100 == null) goto L10;
        if (r101 == null) goto L12;
        r100.setBackgroundClip(r101.f382041a);
        r100.setBackgroundColor(r101.f382043b);
        r100.setBackgroundImage(r101.f382045c);
        r100.setBackgroundOrigin(r101.f382047d);
        r100.setBackgroundPosition(r101.f382049e);
        r100.setBackgroundRepeat(r101.f382051f);
        r100.setBackgroundSize(r101.f382053g);
        r100.setMaskImage(r101.f382055h);
        r100.setMaskOrigin(r101.f382057i);
        r100.setMaskRepeat(r101.f382058j);
        r100.setMaskSize(r101.f382059k);
        r100.setMaskPosition(r101.f382060l);
        r100.setMaskClip(r101.f382061m);
        r100.setBorderRadius(0, r101.f382062n);
        r100.setBorderRadius(1, r101.f382063o);
        r100.setBorderRadius(2, r101.f382064p);
        r100.setBorderRadius(3, r101.f382065q);
        r100.setBorderRadius(4, r101.f382066r);
        r100.setOverflow(r101.G);
        r100.setOverflowX(r101.H);
        r100.setOverflowY(r101.I);
        r100.setBorderStyle(0, r101.f382067s);
        r100.setBorderStyle(1, r101.f382068t);
        r100.setBorderStyle(2, r101.f382069u);
        r100.setBorderStyle(3, r101.f382070v);
        r100.setBorderStyle(4, r101.f382071w);
        r100.setBorderWidth(0, r101.f382072x);
        r100.setBorderWidth(1, r101.f382073y);
        r100.setBorderWidth(2, r101.f382074z);
        r100.setBorderWidth(3, r101.A);
        r100.setBorderWidth(4, r101.B);
        r100.setBorderColor(0, r101.C);
        r100.setBorderColor(1, r101.D);
        r100.setBorderColor(2, r101.E);
        r100.setBorderColor(3, r101.F);
        r100.setOutlineColor(r101.f382040J);
        r100.setOutlineWidth(r101.K);
        r100.setOutlineStyle(r101.L);
        r100.setFontSize(r101.M);
        r100.setLynxDirection(r101.N);
        r100.setTransformOrigin(r101.O);
        r100.setPerspective(r101.P);
        r100.setBoxShadow(r101.Q);
        r100.setImageRendering(r101.S);
        if ((r100 instanceof LynxUI) == false) goto L11;
        LynxUI r102 = (LynxUI) r100;
        r102.setClipPath(r101.T);
        r102.setFilter(r101.U);
        r102.setLayoutAnimationCreateDelay(r101.V);
        r102.setLayoutAnimationCreateDuration(r101.W);
        r102.setLayoutAnimationCreateProperty(r101.X);
        r102.setLayoutAnimationCreateTimingFunc(r101.Y);
        r102.setLayoutAnimationDeleteDelay(r101.Z);
        r102.setLayoutAnimationDeleteDuration(r101.f382042a0);
        r102.setLayoutAnimationDeleteProperty(r101.f382044b0);
        r102.setLayoutAnimationDeleteTimingFunc(r101.f382046c0);
        r102.setLayoutAnimationUpdateDelay(r101.f382048d0);
        r102.setLayoutAnimationUpdateDuration(r101.f382050e0);
        r102.setLayoutAnimationUpdateTimingFunc(r101.f382052f0);
        r102.setAlpha(r101.f382054g0);
        r102.setVisibility(r101.f382056h0);
        r102.setTransform(r101.R);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void attachToView(LynxContext r100) {
        this.mContext = r100;
        Iterator<LynxBaseUI> r101 = this.mChildren.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().attachToView(r100);
        goto L4
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean blockNativeEvent(MotionEvent r110) {
        if (this.mBlockNativeEvent == false) goto L6;
        return true;
    L6:
        if (this.mBlockNativeEventAreas != null) goto L8;
        return false;
    L8:
        Rect r100 = getLynxContext().getUIBody().getBoundingClientRect();
        Rect r101 = getBoundingClientRect();
        float r102 = r110.getX();
        float r111 = r110.getY();
        float r103 = (r100.left - r101.left) + r102;
        float r104 = (r100.top - r101.top) + r111;
        int r112 = 0;
        boolean r105 = false;
    L10:
        if (r112 >= this.mBlockNativeEventAreas.size()) goto L28;
        ArrayList r106 = (ArrayList) ListProtector.get(this.mBlockNativeEventAreas, r112);
        if (r106 == null) goto L27;
        if (r106.size() != 4) goto L27;
        float r107 = ((SizeValue) ListProtector.get(r106, 0)).a(r101.right - r101.left);
        float r108 = ((SizeValue) ListProtector.get(r106, 1)).a(r101.bottom - r101.top);
        float r109 = ((SizeValue) ListProtector.get(r106, 2)).a(r101.right - r101.left) + r107;
        float r113 = ((SizeValue) ListProtector.get(r106, 3)).a(r101.bottom - r101.top) + r108;
        if (r103 >= r107) goto L18;
    L24:
        r105 = false;
    L25:
        if (r105 == false) goto L27;
        LLog.i(TAG, "blocked this point!");
        goto L28
    L18:
        if (r103 >= r109) goto L24;
        if (r104 < r108) goto L24;
        if (r104 >= r113) goto L24;
        r105 = true;
    L27:
        r112 = r112 + 1;
    L28:
        return r105;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean consumeSlideEvent(float r100) {
        ArrayList<ArrayList<Float>> r101 = this.mConsumeSlideEventAngles;
        if (r101 != null) goto L5;
        return false;
    L5:
        Iterator<ArrayList<Float>> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        ArrayList<Float> r103 = r102.next();
        if (r100 < ((Float) ListProtector.get(r103, 0)).floatValue()) goto L7;
        if (r100 > ((Float) ListProtector.get(r103, 1)).floatValue()) goto L7;
        return true;
    L13:
        return false;
    }

    public void copyPropFromOldUiInUpdateFlatten(LynxBaseUI r100) {
        this.mIsFirstAnimatedReady = r100.mIsFirstAnimatedReady;
        this.mLastSize.set(r100.getLastSize().x, r100.getLastSize().y);
        this.mLatestSize.set(r100.getLatestSize().x, r100.getLatestSize().y);
        this.mFlattenChildrenCount = r100.mFlattenChildrenCount;
        setEvents(r100.getEvents());
    }

    public void detachWithViewInfo(m r100) {
        Iterator<LynxBaseUI> r101 = this.mChildren.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().detachWithViewInfo(r100);
        goto L4
    }

    public LynxBaseUI getChildAt(int r100) {
        return (LynxBaseUI) ListProtector.get(this.mChildren, r100);
    }

    public int getIndex(LynxBaseUI r100) {
        return this.mChildren.indexOf(r100);
    }

    public float[] getLocationOnScreen(float[] r100) {
        int[] r101 = new int[2];
        if (isFlatten() == false) goto L6;
        r100[0] = r100[0] + getLeft();
        r100[1] = r100[1] + getTop();
    L6:
        if (isFlatten() == false) goto L12;
        k r102 = this.mDrawParent;
        if (r102 != null) goto L11;
        LLog.e(TAG, "mDrawParent of flattenUI is null, which causes the value getLocationOnScreen returns is not the correct coordinates relative to the screen!");
        return r100;
    L11:
        View r103 = ((LynxUI) r102).getView();
        r100[0] = r100[0] - r103.getScrollX();
        r100[1] = r100[1] - r103.getScrollY();
    L13:
        r103.getRootView().getLocationOnScreen(r101);
        transformFromViewToRootView(r103, r100);
        r100[0] = r100[0] + r101[0];
        r100[1] = r100[1] + r101[1];
        return r100;
    L12:
        r103 = ((LynxUI) this).getView();
        goto L13
    }

    public JavaOnlyMap getPositionInfo(boolean r100) {
        new RectF();
        if (r100 == false) goto L5;
        RectF r101 = com.lynx.tasm.behavior.ui.utils.h.e(this, new RectF(0.0f, 0.0f, getWidth(), getHeight()));
    L6:
        float r102 = getLynxContext().getScreenMetrics().density;
        JavaOnlyMap r103 = new JavaOnlyMap();
        r103.putString("id", getIdSelector());
        r103.putMap("dataset", (WritableMap) getDataset());
        r103.putDouble("left", r101.left / r102);
        r103.putDouble("top", r101.top / r102);
        r103.putDouble("right", r101.right / r102);
        r103.putDouble("bottom", r101.bottom / r102);
        r103.putDouble("width", r101.width() / r102);
        r103.putDouble("height", r101.height() / r102);
        return r103;
    L5:
        r101 = new RectF(getBoundingClientRect());
        goto L6
    }

    public void markDetachWithViewRecursively(boolean r100) {
        this.mIsDetachedWithView = r100;
        this.mNeedsBackgroundRecreation = r100;
        Iterator<LynxBaseUI> r101 = this.mChildren.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().markDetachWithViewRecursively(r100);
        goto L4
    }

    public void notifyScrollStateChanged(int r100) {
        if (this.mStateChangeListeners != null) goto L5;
        return;
    L5:
        monitor-enter(this);
        f[] r101 = (f[]) this.mStateChangeListeners.toArray(new f[this.mStateChangeListeners.size()]);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L11;
        r101[r103].onScrollStateChanged(r100);
        r103 = r103 + 1;
        goto L9
    L11:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // p7a.a
    public void onPlatformGestureStatusChanged(int r100) {
        LynxContext r101 = this.mContext;
        if (r101 != null) goto L5;
        return;
    L5:
        b1 r102 = r101.getTouchEventDispatcher();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r100 != 2) goto L10;
        boolean r103 = true;
    L11:
        r102.I = r103;
        return;
    L10:
        r103 = false;
        goto L11
    }

    public void registerScrollStateListener(f r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L6:
        if (this.mStateChangeListeners != null) goto L8;
        this.mStateChangeListeners = new HashSet();     // Catch: Throwable -> L17
    L8:
        this.mStateChangeListeners.add(r100);     // Catch: Throwable -> L17
        if (this.mStateChangeListeners.size() == 1) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L17
        initScrollStateChangeListener();
        k r101 = getParent();
        if ((r101 instanceof LynxBaseUI) == false) goto L21;
        ((LynxBaseUI) r101).registerScrollStateListener(this.mScrollStateChangeListener);
        return;
    }

    public void removeChild(LynxBaseUI r100) {
        this.mChildren.remove(r100);
        r100.setParent(null);
    }

    public void scrollIntoView(ReadableMap r100) {
        scrollIntoView(r100, null);
    }

    @LynxProp(name = "a11y-id")
    public void setA11yId(f6a.a r100) {
        if (r100 != null) goto L4;
    L6:
        String r101 = "";
    L7:
        this.mAccessibilityId = r101;
        return;
    L4:
        if (ReadableType.String != r100.getType()) goto L6;
        r101 = r100.asString();
        goto L7
    }

    @LynxProp(name = "accessibility-actions")
    public void setAccessibilityActions(ReadableArray r100) {
        this.mAccessibilityActions = r100.asArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @LynxProp(name = "accessibility-element")
    public void setAccessibilityElement(f6a.a r100) {
        ?? r101 = 1;
        r101 = 1;
        r101 = 1;
        if (r100 == null) goto L21;
        ReadableType r102 = r100.getType();
        if (r102 != ReadableType.String) goto L8;
        r101 = Boolean.parseBoolean(r100.asString());
        goto L21
    L8:
        if (r102 == ReadableType.Int) goto L18;
        if (r102 == ReadableType.Number) goto L18;
        if (r102 == ReadableType.Long) goto L18;
        if (r102 != ReadableType.Boolean) goto L21;
        r101 = r100.asBoolean();
    L18:
        if (r100.asInt() != 0) goto L21;
        r101 = 0;
    L21:
        this.mAccessibilityElementStatus = r101;
    }

    @LynxProp(name = "accessibility-elements")
    public void setAccessibilityElements(f6a.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getType() != ReadableType.String) goto L21;
        String[] r101 = r100.asString().split(",");
        if (r101.length > 0) goto L8;
        return;
    L8:
        if (this.mAccessibilityElements != null) goto L10;
        this.mAccessibilityElements = new ArrayList();
    L10:
        this.mAccessibilityElements.clear();
        int r102 = r101.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L13;
        String r104 = r101[r103];
        this.mAccessibilityElements.add(r104);
        r103 = r103 + 1;
        goto L11
    L13:
        com.lynx.tasm.behavior.ui.accessibility.d r105 = this.mContext.getLynxAccessibilityWrapper();
        if (r105 != null) goto L16;
        return;
    L16:
        if (r105.f() == false) goto L24;
        r105.f382468n.f382428c.add(new WeakReference(this));
        return;
    L24:
        return;
    }

    @LynxProp(name = "accessibility-elements-a11y")
    public void setAccessibilityElementsA11y(f6a.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getType() != ReadableType.String) goto L21;
        String[] r101 = r100.asString().split(",");
        if (r101.length > 0) goto L8;
        return;
    L8:
        if (this.mAccessibilityElementsA11y != null) goto L10;
        this.mAccessibilityElementsA11y = new ArrayList();
    L10:
        this.mAccessibilityElementsA11y.clear();
        int r102 = r101.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L13;
        String r104 = r101[r103];
        this.mAccessibilityElementsA11y.add(r104);
        r103 = r103 + 1;
        goto L11
    L13:
        com.lynx.tasm.behavior.ui.accessibility.d r105 = this.mContext.getLynxAccessibilityWrapper();
        if (r105 != null) goto L16;
        return;
    L16:
        if (r105.f() == false) goto L24;
        r105.f382468n.f382429d.add(new WeakReference(this));
        return;
    L24:
        return;
    }

    @LynxProp(name = "accessibility-enable-tap")
    public void setAccessibilityEnableTap(f6a.a r100) {
        if (r100 == null) goto L9;
        ReadableType r101 = r100.getType();
        if (r101 != ReadableType.String) goto L7;
        boolean r102 = Boolean.parseBoolean(r100.asString());
    L10:
        this.mAccessibilityEnableTap = r102;
        return;
    L7:
        if (r101 != ReadableType.Boolean) goto L9;
        r102 = r100.asBoolean();
    L9:
        r102 = false;
        goto L10
    }

    @LynxProp(defaultBoolean = false, name = "accessibility-exclusive-focus")
    public void setAccessibilityExclusiveFocus(boolean r100) {
        com.lynx.tasm.behavior.ui.accessibility.d r101 = this.mContext.getLynxAccessibilityWrapper();
        if (r101 == null) goto L6;
        r101.c(this, r100);
        return;
    }

    @LynxProp(name = "android-accessibility-keep-focused")
    public void setAccessibilityKeepFocused(f6a.a r100) {
        if (r100 == null) goto L9;
        ReadableType r101 = r100.getType();
        if (r101 != ReadableType.String) goto L7;
        boolean r102 = Boolean.parseBoolean(r100.asString());
    L10:
        this.mAccessibilityKeepFocused = r102;
        return;
    L7:
        if (r101 != ReadableType.Boolean) goto L9;
        r102 = r100.asBoolean();
    L9:
        r102 = false;
        goto L10
    }

    @LynxProp(name = "accessibility-label")
    public void setAccessibilityLabel(f6a.a r100) {
        if (r100 == null) goto L17;
        ReadableType r101 = r100.getType();
        if (r101 != ReadableType.String) goto L7;
        String r102 = r100.asString();
    L18:
        this.mAccessibilityLabel = r102;
        return;
    L7:
        if (r101 != ReadableType.Int) goto L9;
    L16:
        r102 = String.valueOf(r100.asInt());
        goto L18
    L9:
        if (r101 == ReadableType.Number) goto L16;
        if (r101 == ReadableType.Long) goto L16;
        if (r101 != ReadableType.Boolean) goto L17;
        r102 = String.valueOf(r100.asBoolean());
    L17:
        r102 = "";
        goto L18
    }

    @LynxProp(name = "accessibility-role-description")
    public void setAccessibilityRoleDescription(f6a.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getType() != ReadableType.String) goto L8;
        this.mAccessibilityRoleDescription = r100.asString();
        return;
    }

    @LynxProp(name = "accessibility-status")
    public void setAccessibilityStatus(f6a.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getType() != ReadableType.String) goto L8;
        this.mAccessibilityStatus = r100.asString();
        return;
    }

    @LynxProp(name = "accessibility-traits")
    public void setAccessibilityTraits(f6a.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getType() != ReadableType.String) goto L8;
        this.mAccessibilityTraits = LynxAccessibilityHelper.LynxAccessibilityTraits.fromValue(r100.asString());
        return;
    }

    public void setAlpha(float r100) {
        this.mAlpha = r100;
    }

    @LynxProp(name = "background-clip")
    public void setBackgroundClip(ReadableArray r100) {
        ensureLynxBackground();
        this.mLynxBackground.g(r100);
    }

    @LynxProp(defaultInt = 0, name = GXTemplateKey.STYLE_BACKGROUND_COLOR)
    public void setBackgroundColor(int r100) {
        this.mBackgroundColor = r100;
        if (getKeyframeManager() == null) goto L6;
        getKeyframeManager().d("BackgroundColor", Integer.valueOf(r100));
    L6:
        if (getTransitionAnimator() != null) goto L8;
    L10:
        ensureLynxBackground();
        this.mLynxBackground.n(r100);
        invalidate();
        return;
    L8:
        if (getTransitionAnimator().b(64) == false) goto L10;
        getTransitionAnimator().a(this, 64, Integer.valueOf(r100));
    }

    @LynxProp(name = GXTemplateKey.STYLE_BACKGROUND_IMAGE)
    public void setBackgroundImage(ReadableArray r100) {
        ensureLynxBackground();
        this.mLynxBackground.b().f383137e.d(r100, this);
        invalidate();
    }

    @LynxProp(name = "background-origin")
    public void setBackgroundOrigin(ReadableArray r100) {
        ensureLynxBackground();
        this.mLynxBackground.h(r100);
        invalidate();
    }

    @LynxProp(name = "background-position")
    public void setBackgroundPosition(ReadableArray r100) {
        ensureLynxBackground();
        this.mLynxBackground.i(r100);
        invalidate();
    }

    @LynxProp(name = "background-repeat")
    public void setBackgroundRepeat(ReadableArray r100) {
        ensureLynxBackground();
        this.mLynxBackground.j(r100);
        invalidate();
    }

    @LynxProp(name = "background-size")
    public void setBackgroundSize(ReadableArray r100) {
        ensureLynxBackground();
        this.mLynxBackground.k(r100);
        invalidate();
    }

    @LynxProp(defaultBoolean = false, name = "block-list-event")
    public void setBlockListEvent(boolean r100) {
        this.mBlockListEvent = r100;
    }

    @LynxProp(defaultBoolean = false, name = "block-native-event")
    public void setBlockNativeEvent(boolean r100) {
        this.mBlockNativeEvent = r100;
    }

    @LynxProp(name = "block-native-event-areas")
    public void setBlockNativeEventAreas(f6a.a r110) {
        this.mBlockNativeEventAreas = null;
        if (r110 != null) goto L5;
    L31:
        LLog.w(TAG, "setBlockNativeEventAreas input type error");
        return;
    L5:
        if (r110.getType() != ReadableType.Array) goto L31;
        if (r110.asArray() == null) goto L31;
        ReadableArray r111 = r110.asArray();
        ArrayList<ArrayList<SizeValue>> r100 = new ArrayList();
        int r101 = 0;
    L11:
        if (r101 >= r111.size()) goto L27;
        ReadableArray r102 = r111.getArray(r101);
        if (r102 != null) goto L15;
    L24:
        LLog.w(TAG, "setBlockNativeEventAreas " + r101 + "th type error, size != 4");
    L25:
        r101 = r101 + 1;
        goto L11
    L15:
        if (r102.size() != 4) goto L24;
        SizeValue r103 = SizeValue.b(r102.getString(0));
        SizeValue r104 = SizeValue.b(r102.getString(1));
        SizeValue r105 = SizeValue.b(r102.getString(2));
        SizeValue r106 = SizeValue.b(r102.getString(3));
        if (r103 == null) goto L23;
        if (r104 == null) goto L23;
        if (r105 == null) goto L23;
        if (r106 == null) goto L23;
        ArrayList<SizeValue> r107 = new ArrayList();
        r107.add(r103);
        r107.add(r104);
        r107.add(r105);
        r107.add(r106);
        r100.add(r107);
    L23:
        LLog.w(TAG, "setBlockNativeEventAreas " + r101 + "th type error");
        goto L25
    L27:
        if (r100.size() <= 0) goto L29;
        this.mBlockNativeEventAreas = r100;
        return;
    L29:
        LLog.w(TAG, "setBlockNativeEventAreas empty areas");
    }

    public void setBorderColor(String r100) {
        LLog.DTHROW(new RuntimeException("setBorderColor(String) is deprecated.This has no effect."));
    }

    public void setBound(Rect r100) {
        this.mBound = r100;
    }

    @LynxProp(name = GXTemplateKey.STYLE_BOX_SHADOW)
    public void setBoxShadow(ReadableArray r100) {
        k r101 = this.mParent;
        if ((r101 instanceof UIShadowProxy) == false) goto L6;
        ((UIShadowProxy) r101).setBoxShadow(r100);
        return;
    }

    @LynxProp(defaultFloat = 1.0f, name = "position")
    public final void setCSSPosition(int r100) {
        this.mCSSPosition = r100;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setChildrenLynxPageUI(HashMap<String, EventTarget> r100) {
        LynxContext r101 = this.mContext;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUIBody() == null) goto L10;
        this.mContext.getUIBody().setChildrenLynxPageUI(r100);
        return;
    }

    @LynxProp(name = "clip-radius")
    public void setClipToRadius(f6a.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ReadableType r101 = r100.getType();
        if (r101 != ReadableType.Boolean) goto L8;
        this.mClipToRadius = r100.asBoolean();
        return;
    L8:
        if (r101 != ReadableType.String) goto L19;
        String r102 = r100.asString();
        if (r102.equalsIgnoreCase("true") == false) goto L12;
    L15:
        boolean r103 = true;
    L16:
        this.mClipToRadius = r103;
        return;
    L12:
        if (r102.equalsIgnoreCase(BdpAppEventConstant.YES) == true) goto L15;
        r103 = false;
        goto L16
    }

    @LynxProp(defaultBoolean = false, name = "android-consume-hover-event")
    public void setConsumeHoverEvent(boolean r100) {
        com.lynx.tasm.behavior.ui.accessibility.d r101 = this.mContext.getLynxAccessibilityWrapper();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f() == false) goto L9;
        this.mConsumeHoverEvent = r100;
        return;
    }

    @LynxProp(name = "consume-slide-event")
    public void setConsumeSlideEvent(ReadableArray r100) {
        if (r100 != null) goto L21;
        this.mConsumeSlideEventAngles = null;
        return;
    L21:
        ArrayList<Object> r101 = r100.toArrayList();     // Catch: Throwable -> L18
        this.mConsumeSlideEventAngles = new ArrayList();     // Catch: Throwable -> L18
        Iterator<Object> r102 = r101.iterator();     // Catch: Throwable -> L18
    L7:
        if (r102.hasNext() == false) goto L34;
        Object r103 = r102.next();     // Catch: Throwable -> L18
        if ((r103 instanceof ArrayList) == false) goto L7;
        if (((ArrayList) r103).size() != 2) goto L7;
        if ((ListProtector.get((ArrayList) r103, 0) instanceof Number) == false) goto L7;
        if ((ListProtector.get((ArrayList) r103, 1) instanceof Number) == false) goto L7;
        ArrayList<Float> r104 = new ArrayList();     // Catch: Throwable -> L18
        r104.add(Float.valueOf(((Number) ListProtector.get((ArrayList) r103, 0)).floatValue()));     // Catch: Throwable -> L18
        r104.add(Float.valueOf(((Number) ListProtector.get((ArrayList) r103, 1)).floatValue()));     // Catch: Throwable -> L18
        this.mConsumeSlideEventAngles.add(r104);     // Catch: Throwable -> L18
        goto L7
    L34:
        return;
    L18:
        th = move-exception;
        LLog.e(TAG, "setConsumeSlideEvent failed since " + th.getMessage());
    }

    @LynxProp(name = "dataset")
    public void setDataset(ReadableMap r100) {
        this.mDataset = r100;
    }

    @LynxProp(name = "disable-default-resize")
    public void setDisableDefaultResize(boolean r100) {
        this.mDisableDefaultResize = r100;
    }

    public void setDisplayNone(boolean r100) {
        this.mDisplayNone = r100;
    }

    public void setDrawParent(k r100) {
        this.mDrawParent = r100;
    }

    @LynxProp(name = "bitmap-gradient")
    public void setEnableBitmapGradient(boolean r100) {
        this.mEnableBitmapGradient = r100;
        BackgroundDrawable r101 = this.mLynxBackground.b();
        r101.f383137e.f2103j = r100;
        r101.invalidateSelf();
        com.lynx.tasm.behavior.ui.utils.g r102 = this.mLynxMask;
        if (r102 == null) goto L5;
        com.lynx.tasm.behavior.ui.utils.i r103 = r102.b();
        r103.f383137e.f2103j = r100;
        r103.invalidateSelf();
    L5:
        invalidate();
    }

    @LynxProp(name = "enable-exposure-ui-clip")
    public void setEnableExposureUIClip(boolean r100) {
        if (r100 == false) goto L4;
        EventTarget.EnableStatus r101 = EventTarget.EnableStatus.Enable;
    L5:
        this.mEnableExposureUIClip = r101;
        return;
    L4:
        r101 = EventTarget.EnableStatus.Disable;
        goto L5
    }

    @LynxProp(name = "enable-exposure-ui-margin")
    public void setEnableExposureUIMargin(boolean r100) {
        this.mEnableExposureUIMargin = Boolean.valueOf(r100);
    }

    @LynxProp(name = "enable-scroll-monitor")
    public void setEnableScrollMonitor(boolean r100) {
        this.mEnableScrollMonitor = r100;
    }

    @LynxProp(name = "enable-touch-pseudo-propagation")
    public void setEnableTouchPseudoPropagation(f6a.a r100) {
        if (r100 != null) goto L11;
        this.mEnableTouchPseudoPropagation = true;
        return;
    L11:
        this.mEnableTouchPseudoPropagation = r100.asBoolean();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        LLog.i(TAG, th.toString());
        this.mEnableTouchPseudoPropagation = true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setEventID(long r100) {
        if (getChildrenLynxPageUI() != null) goto L5;
        return;
    L5:
        LynxBaseUI r101 = (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this)));
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.getLynxContext() != null) goto L10;
        return;
    L10:
        if (r101.getLynxContext().getEventEmitter() == null) goto L15;
        r101.getLynxContext().getEventEmitter().setEventID(r100);
        return;
    }

    @LynxProp(name = "event-through")
    public void setEventThrough(f6a.a r100) {
        if (r100 != null) goto L14;
        this.mEventThrough = EventTarget.EnableStatus.Undefined;
        return;
    L14:
    L11:
        th = move-exception;
        LLog.i(TAG, th.toString());
        this.mEventThrough = EventTarget.EnableStatus.Undefined;
        return;
    L6:
        if (r100.asBoolean() == false) goto L8;
        EventTarget.EnableStatus r101 = EventTarget.EnableStatus.Enable;     // Catch: Throwable -> L11
    L9:
        this.mEventThrough = r101;     // Catch: Throwable -> L11
        return;
    L8:
        r101 = EventTarget.EnableStatus.Disable;     // Catch: Throwable -> L11
        goto L9
    }

    @LynxProp(name = "event-through-active-regions")
    public void setEventThroughActiveRegions(f6a.a r110) {
        this.mEventThroughActiveRegions = null;
        if (r110 != null) goto L5;
    L31:
        LLog.w(TAG, "setEventThroughActiveRegions input type error");
        return;
    L5:
        if (r110.getType() != ReadableType.Array) goto L31;
        if (r110.asArray() == null) goto L31;
        ReadableArray r111 = r110.asArray();
        ArrayList<ArrayList<SizeValue>> r100 = new ArrayList();
        int r101 = 0;
    L11:
        if (r101 >= r111.size()) goto L27;
        ReadableArray r102 = r111.getArray(r101);
        if (r102 != null) goto L15;
    L24:
        LLog.w(TAG, "setEventThroughActiveRegions " + r101 + "th type error, size != 4");
    L25:
        r101 = r101 + 1;
        goto L11
    L15:
        if (r102.size() != 4) goto L24;
        SizeValue r103 = SizeValue.b(r102.getString(0));
        SizeValue r104 = SizeValue.b(r102.getString(1));
        SizeValue r105 = SizeValue.b(r102.getString(2));
        SizeValue r106 = SizeValue.b(r102.getString(3));
        if (r103 == null) goto L23;
        if (r104 == null) goto L23;
        if (r105 == null) goto L23;
        if (r106 == null) goto L23;
        ArrayList<SizeValue> r107 = new ArrayList();
        r107.add(r103);
        r107.add(r104);
        r107.add(r105);
        r107.add(r106);
        r100.add(r107);
    L23:
        LLog.w(TAG, "setEventThroughActiveRegions " + r101 + "th type error");
        goto L25
    L27:
        if (r100.size() <= 0) goto L29;
        this.mEventThroughActiveRegions = r100;
        return;
    L29:
        LLog.w(TAG, "setEventThroughActiveRegions empty regions");
    }

    public void setEvents(Map<String, EventsListener> r100) {
        this.mEvents = r100;
    }

    @LynxProp(name = "exposure-area")
    public void setExposureArea(String r100) {
        this.mExposureArea = r100;
    }

    @LynxProp(name = "exposure-id")
    public void setExposureID(f6a.a r100) {
        this.mContext.removeUIFromExposedMap(this);
        String r101 = r100.asString();
        if (r101 != null) goto L5;
    L8:
        this.mExposureID = null;
        LLog.e(TAG, "setExposureID(Dynamic exposureID) failed, since it is not number/string, or it is empty string");
        LLog.DTHROW(new RuntimeException("setExposureID(Dynamic exposureID) failed, since it is not number/string, or it is empty string"));
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        this.mExposureID = r101;
    }

    @LynxProp(name = "exposure-scene")
    public void setExposureScene(String r100) {
        this.mContext.removeUIFromExposedMap(this);
        this.mExposureScene = r100;
    }

    @LynxProp(name = "exposure-screen-margin-bottom")
    public void setExposureScreenMarginBottom(String r100) {
        this.mExposureScreenMarginBottom = com.lynx.tasm.utils.n.a(r100, 0.0f);
    }

    @LynxProp(name = "exposure-screen-margin-left")
    public void setExposureScreenMarginLeft(String r100) {
        this.mExposureScreenMarginLeft = com.lynx.tasm.utils.n.a(r100, 0.0f);
    }

    @LynxProp(name = "exposure-screen-margin-right")
    public void setExposureScreenMarginRight(String r100) {
        this.mExposureScreenMarginRight = com.lynx.tasm.utils.n.a(r100, 0.0f);
    }

    @LynxProp(name = "exposure-screen-margin-top")
    public void setExposureScreenMarginTop(String r100) {
        this.mExposureScreenMarginTop = com.lynx.tasm.utils.n.a(r100, 0.0f);
    }

    @LynxProp(name = "exposure-ui-margin-bottom")
    public void setExposureUIMarginBottom(String r100) {
        this.mExposureUIMarginBottom = r100;
    }

    @LynxProp(name = "exposure-ui-margin-left")
    public void setExposureUIMarginLeft(String r100) {
        this.mExposureUIMarginLeft = r100;
    }

    @LynxProp(name = "exposure-ui-margin-right")
    public void setExposureUIMarginRight(String r100) {
        this.mExposureUIMarginRight = r100;
    }

    @LynxProp(name = "exposure-ui-margin-top")
    public void setExposureUIMarginTop(String r100) {
        this.mExposureUIMarginTop = r100;
    }

    @LynxProp(name = "focusable")
    public void setFocusable(Boolean r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100.booleanValue();
    L5:
        this.mFocusable = r101;
        return;
    L4:
        r101 = false;
        goto L5
    }

    @LynxProp(defaultFloat = 1.0E21f, name = GXTemplateKey.STYLE_FONT_SIZE)
    public void setFontSize(float r100) {
        if (r100 == 1.0E21f) goto L8;
        ensureLynxBackground();
        this.mFontSize = r100;
        this.mLynxBackground.f383144d = r100;
        com.lynx.tasm.behavior.ui.utils.g r101 = this.mLynxMask;
        if (r101 == null) goto L9;
        r101.f383144d = r100;
        return;
    L9:
        return;
    }

    public void setGestureDetectors(Map<Integer, s7a.a> r100) {
        this.mGestureDetectors = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L32;
        q7a.b r101 = getGestureArenaManager();
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.e(getGestureArenaMemberId()) == false) goto L16;
        Map<Integer, t7a.a> r102 = this.mGestureHandlers;
        if (r102 == null) goto L16;
        r102.clear();
        this.mGestureHandlers = null;
    L16:
        if (this.mGestureHandlers == null) goto L18;
        return;
    L18:
        if (getSign() <= 0) goto L31;
        Map<Integer, t7a.a> r103 = t7a.a.c(getSign(), getLynxContext(), this, getGestureDetectorMap());
        this.mGestureHandlers = r103;
        this.mIncludeNativeGesture = false;
        Iterator<Integer> r104 = r103.keySet().iterator();
    L21:
        if (r104.hasNext() == false) goto L33;
        if (r104.next().intValue() != 7) goto L21;
        this.mIncludeNativeGesture = true;
        return;
    L33:
        return;
    L31:
        return;
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
        onLayoutUpdated();
    }

    @LynxProp(name = "hit-slop")
    public void setHitSlop(f6a.a r100) {
        if (r100 == null) goto L73;
        ReadableType r101 = r100.getType();
        ReadableType r102 = ReadableType.Map;
        if (r101 == r102) goto L9;
        if (r100.getType() == ReadableType.String) goto L9;
        return;
    L9:
        if (r100.getType() == r102) goto L11;
    L47:
        float r103 = com.lynx.tasm.utils.n.a(r100.asString(), 0.0f);
        if (this.mHitSlopTop == r103) goto L50;
    L55:
        this.mHitSlopRight = r103;
        this.mHitSlopLeft = r103;
        this.mHitSlopBottom = r103;
        this.mHitSlopTop = r103;
        return;
    L50:
        if (this.mHitSlopBottom != r103) goto L55;
        if (this.mHitSlopLeft != r103) goto L55;
        if (this.mHitSlopRight != r103) goto L55;
        return;
    L11:
        if (r100.asMap().size() <= 0) goto L47;
        ReadableMap r104 = r100.asMap();
        ReadableMapKeySetIterator r105 = r104.keySetIterator();
        List r106 = Arrays.asList(new String[]{"top", "bottom", "left", "right"});
    L14:
        if (r105.hasNextKey() == false) goto L46;
        String r107 = r105.nextKey();
        if (r106.contains(r107) == false) goto L14;
        float r108 = com.lynx.tasm.utils.n.a(r104.getString(r107), 0.0f);
        int r109 = r106.indexOf(r107);
        if (r109 != 0) goto L20;
        float r110 = this.mHitSlopTop;
        if (r110 != r108) goto L45;
        r108 = r110;
    L45:
        this.mHitSlopTop = r108;
        goto L14
    L20:
        if (r109 != 1) goto L22;
        float r111 = this.mHitSlopBottom;
        if (r111 != r108) goto L40;
        r108 = r111;
    L40:
        this.mHitSlopBottom = r108;
        goto L14
    L22:
        if (r109 != 2) goto L24;
        float r112 = this.mHitSlopLeft;
        if (r112 != r108) goto L35;
        r108 = r112;
    L35:
        this.mHitSlopLeft = r108;
        goto L14
    L24:
        if (r109 != 3) goto L14;
        float r113 = this.mHitSlopRight;
        if (r113 != r108) goto L30;
        r108 = r113;
    L30:
        this.mHitSlopRight = r108;
        goto L14
    L46:
        return;
    }

    @LynxProp(name = "idSelector")
    public void setIdSelector(String r100) {
        this.mIdSelector = r100;
    }

    @LynxProp(name = "ignore-focus")
    public void setIgnoreFocus(f6a.a r100) {
        if (r100 != null) goto L14;
        this.mIgnoreFocus = EventTarget.EnableStatus.Undefined;
        return;
    L14:
    L11:
        th = move-exception;
        LLog.i(TAG, th.toString());
        this.mIgnoreFocus = EventTarget.EnableStatus.Undefined;
        return;
    L6:
        if (r100.asBoolean() == false) goto L8;
        EventTarget.EnableStatus r101 = EventTarget.EnableStatus.Enable;     // Catch: Throwable -> L11
    L9:
        this.mIgnoreFocus = r101;     // Catch: Throwable -> L11
        return;
    L8:
        r101 = EventTarget.EnableStatus.Disable;     // Catch: Throwable -> L11
        goto L9
    }

    @LynxProp(name = "image-config")
    public void setImageConfig(String r100) {
        if (r100 != null) goto L5;
    L39:
        this.mBitmapConfig = null;
        return;
    L5:
        if (r100.equalsIgnoreCase("") == true) goto L39;
        if (r100.equalsIgnoreCase("ALPHA_8") == false) goto L11;
        this.mBitmapConfig = Bitmap.Config.ALPHA_8;
    L32:
        com.lynx.tasm.behavior.ui.utils.e r101 = this.mLynxBackground;
        if (r101 == null) goto L35;
        r101.f(this.mBitmapConfig);
    L35:
        com.lynx.tasm.behavior.ui.utils.g r102 = this.mLynxMask;
        if (r102 == null) goto L41;
        r102.f(this.mBitmapConfig);
        return;
    L41:
        return;
    L11:
        if (r100.equalsIgnoreCase("RGB_565") == false) goto L17;
        if (isImageConfigBadCase() == true) goto L15;
        this.mBitmapConfig = Bitmap.Config.RGB_565;
        goto L32
    L15:
        LLog.w("LynxBaseUI setImageConfig warn: ", "RGB_565 can't be set on Meizu15");
        this.mBitmapConfig = null;
        goto L32
    L17:
        if (r100.equalsIgnoreCase("ARGB_8888") == false) goto L20;
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        goto L32
    L20:
        if (r100.equalsIgnoreCase("RGBA_F16") == false) goto L26;
        if (Build.VERSION.SDK_INT < 26) goto L24;
        this.mBitmapConfig = Bitmap.Config.RGBA_F16;
        goto L32
    L24:
        LLog.w("LynxBaseUI setImageConfig warn: ", "RGBA_F16 requires build version >= VERSION_CODES.O");
        this.mBitmapConfig = null;
        goto L32
    L26:
        if (r100.equalsIgnoreCase("HARDWARE") == true) goto L28;
        this.mBitmapConfig = null;
        goto L32
    L28:
        if (Build.VERSION.SDK_INT < 26) goto L30;
        this.mBitmapConfig = Bitmap.Config.HARDWARE;
        goto L32
    L30:
        this.mBitmapConfig = null;
        LLog.w("LynxBaseUI setImageConfig warn: ", "HARDWARE requires build version >= VERSION_CODES.O");
        goto L32
    }

    @LynxProp(name = "image-rendering")
    public void setImageRendering(int r100) {
        this.mImageRendering = r100;
    }

    @LynxProp(name = "intersection-observers")
    public void setIntersectionObservers(ReadableArray r100) {
        d0 r101 = this.mContext.getIntersectionObserverManager();
        r101.getClass();
        UIThreadUtils.runOnUiThreadImmediately(new a0(r101, this));
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mEvents.containsKey("intersection") == false) goto L18;
        int r102 = 0;
    L9:
        if (r102 >= r100.size()) goto L19;
        ReadableMap r103 = r100.getMap(r102);
        if (r103 == null) goto L13;
        u r104 = new u(this.mContext.getIntersectionObserverManager(), r103, this);
        d0 r105 = this.mContext.getIntersectionObserverManager();
        r105.getClass();
        UIThreadUtils.runOnUiThreadImmediately(new y(r105, r104));
    L13:
        r102 = r102 + 1;
        goto L9
    L19:
        return;
    }

    public void setLastTranslateZ(float r100) {
        this.mLastTranslateZ = r100;
    }

    public void setLeft(int r100) {
        this.mLeft = r100;
        this.mOriginLeft = r100;
        onLayoutUpdated();
    }

    @LynxProp(name = "local-cache")
    public void setLocalCache(f6a.a r100) {
        this.mUseLocalCache = r100;
    }

    public void setLynxBackground(com.lynx.tasm.behavior.ui.utils.e r100) {
        this.mLynxBackground = r100;
    }

    @LynxProp(defaultInt = 3, name = "direction")
    public void setLynxDirection(int r100) {
        this.mLynxDirection = r100;
    }

    public void setLynxMask(com.lynx.tasm.behavior.ui.utils.g r100) {
        this.mLynxMask = r100;
    }

    @LynxProp(name = "mask-clip")
    public void setMaskClip(ReadableArray r100) {
        getOrCreateLynxMask().g(r100);
        invalidate();
    }

    @LynxProp(name = "mask-image")
    public void setMaskImage(ReadableArray r100) {
        getOrCreateLynxMask().b().f383137e.d(r100, this);
        invalidate();
    }

    @LynxProp(name = "mask-origin")
    public void setMaskOrigin(ReadableArray r100) {
        getOrCreateLynxMask().h(r100);
        invalidate();
    }

    @LynxProp(name = "mask-position")
    public void setMaskPosition(ReadableArray r100) {
        getOrCreateLynxMask().i(r100);
        invalidate();
    }

    @LynxProp(name = "mask-repeat")
    public void setMaskRepeat(ReadableArray r100) {
        getOrCreateLynxMask().j(r100);
        invalidate();
    }

    @LynxProp(name = "mask-size")
    public void setMaskSize(ReadableArray r100) {
        getOrCreateLynxMask().k(r100);
        invalidate();
    }

    @LynxProp(name = "name")
    public void setName(String r100) {
        this.mName = r100;
    }

    @LynxProp(defaultBoolean = false, name = "native-interaction-enabled")
    public void setNativeInteractionEnabled(boolean r100) {
        this.nativeInteractionEnabled = r100;
    }

    public void setNeedSortChildren(boolean r100) {
        this.mNeedSortChildren = r100;
    }

    public void setNextDrawUI(LynxBaseUI r100) {
        this.mNextDrawUI = r100;
    }

    public void setNodeIndex(int r100) {
        this.mNodeIndex = r100;
    }

    public void setOffsetDescendantRectToLynxView(int[] r100) {
        this.mOffsetDescendantRectToLynxView = new WeakReference(r100);
    }

    public void setOriginLeft(int r100) {
        this.mOriginLeft = r100;
    }

    public void setOriginTop(int r100) {
        this.mOriginTop = r100;
    }

    @LynxProp(defaultInt = -16777216, name = "outline-color")
    public void setOutlineColor(int r100) {
        k r101 = this.mParent;
        if ((r101 instanceof UIShadowProxy) == false) goto L6;
        ((UIShadowProxy) r101).setOutlineColor(r100);
        return;
    }

    @LynxProp(defaultInt = -1, name = "outline-style")
    public void setOutlineStyle(int r100) {
        k r101 = this.mParent;
        if ((r101 instanceof UIShadowProxy) == false) goto L6;
        ((UIShadowProxy) r101).M().f382381a = BorderStyle.parse(r100);
        return;
    }

    @LynxProp(defaultInt = 0, name = "outline-width")
    public void setOutlineWidth(float r100) {
        k r101 = this.mParent;
        if ((r101 instanceof UIShadowProxy) == false) goto L6;
        ((UIShadowProxy) r101).setOutlineWidth(r100);
        return;
    }

    @LynxProp(name = "overflow")
    public void setOverflow(Integer r100) {
        if (r100 != null) goto L4;
        int r101 = getInitialOverflowType();
    L5:
        setOverflow(r101);
        return;
    L4:
        r101 = r100.intValue();
        goto L5
    }

    @LynxProp(name = "overflow-x")
    public void setOverflowX(Integer r100) {
        if (r100 != null) goto L4;
        int r101 = getInitialOverflowType();
    L5:
        setOverflowWithMask(1, r101);
        return;
    L4:
        r101 = r100.intValue();
        goto L5
    }

    @LynxProp(name = "overflow-y")
    public void setOverflowY(Integer r100) {
        if (r100 != null) goto L4;
        int r101 = getInitialOverflowType();
    L5:
        setOverflowWithMask(2, r101);
        return;
    L4:
        r101 = r100.intValue();
        goto L5
    }

    @LynxProp(name = "pan-intercept-direction")
    public void setPanInterceptDirection(int r100) {
        if (r100 >= EventTarget.PanInterceptDirection.Horizontal.ordinal()) goto L5;
        return;
    L5:
        if (r100 >= EventTarget.PanInterceptDirection.None.ordinal()) goto L9;
        this.mPanInterceptDirection = EventTarget.PanInterceptDirection.values()[r100];
        return;
    }

    @LynxProp(name = "pan-intercept-scope")
    public void setPanInterceptScope(int r100) {
        if (r100 >= EventTarget.PanInterceptScope.Self.ordinal()) goto L5;
        return;
    L5:
        if (r100 >= EventTarget.PanInterceptScope.None.ordinal()) goto L9;
        this.mPanInterceptScope = EventTarget.PanInterceptScope.values()[r100];
        return;
    }

    public void setParent(k r100) {
        if (this.mStateChangeListeners != null) goto L6;
        this.mParent = r100;
        return;
    L6:
        int r101 = 0;
        if ((r100 instanceof LynxBaseUI) == false) goto L18;
        monitor-enter(this);
        f[] r102 = (f[]) this.mStateChangeListeners.toArray(new f[this.mStateChangeListeners.size()]);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        int r103 = r102.length;
    L12:
        if (r101 >= r103) goto L28;
        LynxBaseUI r104 = (LynxBaseUI) r100;
        r104.registerScrollStateListener(r102[r101]);
        r101 = r101 + 1;
    L28:
        this.mParent = r100;
        return;
    L14:
        th = move-exception;
        throw th;
    L18:
        if ((this.mParent instanceof LynxBaseUI) == false) goto L28;
        monitor-enter(this);
        f[] r105 = (f[]) this.mStateChangeListeners.toArray(new f[this.mStateChangeListeners.size()]);     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        int r106 = r105.length;
    L23:
        if (r101 >= r106) goto L28;
        f r107 = r105[r101];
        ((LynxBaseUI) this.mParent).unRegisterScrollStateListener(r107);
        r101 = r101 + 1;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setParentLynxPageUI(EventTarget r100) {
        LynxContext r101 = this.mContext;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUIBody() == null) goto L10;
        this.mContext.getUIBody().setParentLynxPageUI(r100);
        return;
    }

    @LynxProp(name = "perspective")
    public void setPerspective(ReadableArray r100) {
        this.mPerspective = r100;
    }

    @LynxProp(name = "pointer-events")
    public void setPointerEvents(int r100) {
        if (r100 >= EventTarget.PointerEventsValue.Auto.ordinal()) goto L5;
        return;
    L5:
        if (r100 >= EventTarget.PointerEventsValue.Unset.ordinal()) goto L9;
        this.mPointerEvents = EventTarget.PointerEventsValue.values()[r100];
        return;
    }

    public void setPreviousDrawUI(LynxBaseUI r100) {
        this.mPreviousDrawUI = r100;
    }

    @LynxProp(name = "react-ref")
    public void setRefIdSelector(String r100) {
        this.mRefId = r100;
    }

    @LynxProp(name = "scroll-monitor-tag")
    public void setScrollMonitorTag(String r100) {
        this.mScrollMonitorTag = r100;
    }

    public void setSkewX(float r100) {
        this.mSkewX = r100;
    }

    public void setSkewY(float r100) {
        this.mSkewY = r100;
    }

    @LynxProp(name = "skip-redirection")
    public void setSkipRedirection(boolean r100) {
        this.mSkipRedirection = r100;
    }

    @LynxProp(name = "lynx-test-tag")
    public void setTestID(String r100) {
        this.mTestTagName = r100;
    }

    public void setTop(int r100) {
        this.mTop = r100;
        this.mOriginTop = r100;
        onLayoutUpdated();
    }

    public void setTransform(ReadableArray r100) {
        this.hasTransformChanged = true;
        List<n> r101 = n.d(r100);
        this.mTransformRaw = r101;
        float r102 = 0.0f;
        if (r101 == null) goto L17;
        ArrayList r103 = (ArrayList) r101;
        if (r103.isEmpty() == true) goto L17;
        Iterator r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L17;
        n r105 = (n) r104.next();
        int r106 = r105.f383162a;
        if (r106 != 8) goto L13;
        r102 = r105.f383164c.a();
        goto L9
    L13:
        if (r106 != 16) goto L9;
        r102 = r105.f383169h.a();
    L17:
        setTranslationZ(r102);
        if ((getParent() instanceof UIShadowProxy) == false) goto L29;
        ((UIShadowProxy) getParent()).f382373a.getTransformRaws();
        return;
    }

    @LynxProp(name = "transform-origin")
    public void setTransformOrigin(ReadableArray r100) {
        this.hasTransformChanged = true;
        com.lynx.tasm.behavior.ui.utils.l r101 = com.lynx.tasm.behavior.ui.utils.l.f383154e;
        this.mTransformOrigin = r101;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
    L10:
        com.lynx.tasm.behavior.ui.utils.l r102 = null;
    L11:
        this.mTransformOrigin = r102;
        if (r102 != null) goto L15;
        LLog.e(TAG, "transform params error.");
        this.mTransformOrigin = r101;
        return;
    L15:
        return;
    L7:
        if (r100.size() < 2) goto L10;
        r102 = new com.lynx.tasm.behavior.ui.utils.l(r100);
        goto L11
    }

    public void setTranslationZ(float r100) {
        this.mTranslationZ = r100;
    }

    @LynxProp(defaultBoolean = true, name = "user-interaction-enabled")
    public void setUserInteractionEnabled(boolean r100) {
        this.userInteractionEnabled = r100;
    }

    public void setWidth(int r100) {
        this.mWidth = r100;
        onLayoutUpdated();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventBubble(long r100) {
        LynxContext r101 = this.mContext;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getEventEmitter() == null) goto L10;
        this.mContext.getEventEmitter().startEventBubble(r100);
        return;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventCapture(long r100) {
        LynxContext r101 = this.mContext;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getEventEmitter() == null) goto L10;
        this.mContext.getEventEmitter().startEventCapture(r100);
        return;
    }

    public void unRegisterScrollStateListener(f r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mStateChangeListeners == null) goto L22;
        monitor-enter(this);
        this.mStateChangeListeners.remove(r100);     // Catch: Throwable -> L14
        boolean r101 = this.mStateChangeListeners.isEmpty();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        if (r101 == false) goto L20;
        k r102 = getParent();
        if ((r102 instanceof LynxBaseUI) == false) goto L21;
        ((LynxBaseUI) r102).unRegisterScrollStateListener(this.mScrollStateChangeListener);
        return;
    L21:
        return;
    L20:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void updateLayoutInfo(LynxBaseUI r110) {
        updateLayoutInfo(r110.getLeft(), r110.getTop(), r110.getWidth(), r110.getHeight(), r110.getPaddingLeft(), r110.getPaddingTop(), r110.getPaddingRight(), r110.getPaddingBottom(), r110.getMarginLeft(), r110.getMarginTop(), r110.getMarginRight(), r110.getMarginBottom(), r110.getBorderLeftWidth(), r110.getBorderTopWidth(), r110.getBorderRightWidth(), r110.getBorderBottomWidth(), r110.getBound());
        this.mOriginLeft = r110.getOriginLeft();
        this.mOriginTop = r110.getOriginTop();
    }

    public void updateMaxHeight(float r100) {
        this.mMaxHeight = r100;
    }

    public void updateNewSticky(float[] r100) {
        if (r100 != null) goto L5;
    L12:
        removeSelfFromStickyScrollerIfNeeded();
        setStickyTranslate(null);
        this.mSticky = null;
        return;
    L5:
        if (r100.length < 10) goto L12;
        Sticky r101 = new Sticky();
        this.mSticky = r101;
        ((RectF) r101).left = r100[0];
        ((RectF) r101).top = r100[1];
        ((RectF) r101).right = r100[2];
        ((RectF) r101).bottom = r100[3];
        r101.f382345c = r100[4];
        r101.f382346d = r100[5];
        r101.f382347e = r100[6];
        r101.f382348f = r100[7];
        r101.f382349g = r100[8];
        r101.f382350h = r100[9];
        r101.f382344b = 0.0f;
        r101.f382343a = 0.0f;
        g7a.c r102 = getStickyScroller();
        if (r102 == null) goto L10;
        bindStickyScrollerIfNeeded(r102);
        r102.l();
        return;
    L10:
        removeSelfFromStickyScrollerIfNeeded();
        setStickyTranslate(null);
    }

    public final void updateProperties(x0 r100) {
        updatePropertiesInterval(r100);
        afterPropsUpdated(r100);
    }

    public void updatePropertiesInterval(x0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.j() == true) goto L365;
        this.mProps.merge(r100.f383219a);
        Map<Class<?>, LynxUISetter<?>> r101 = PropsUpdater.f383181a;
        LynxUISetter r102 = PropsUpdater.c(getClass());
        ReadableMapKeySetIterator r103 = r100.f383219a.keySetIterator();
    L8:
        if (r103.hasNextKey() == false) goto L14;
        String r104 = r103.nextKey();
        r102.setProperty(this, r104, r100);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        LynxError r105 = new LynxError(130100, "Error while updating property '" + r104 + "' in ui '" + getTagName() + "': " + th, "", "error");
        r105.setCallStack(CallStackUtil.getStackTraceStringWithLineTrimmed(th));
        r105.setUserDefineInfo(getPlatformCustomInfo());
        getLynxContext().handleLynxError(r105);
        goto L8
    L14:
        MapBuffer r106 = r100.f383220b;
        if (r106 == null) goto L366;
        com.lynx.tasm.behavior.g r107 = getOrCreateUIPaintStyles();
        if (r107 == null) goto L367;
        Iterator<MapBuffer.a> r108 = r106.iterator();
    L22:
        if (r108.hasNext() == false) goto L368;
        MapBuffer.a r109 = r108.next();
        int r110 = r109.getKey();
        if (r110 != 5) goto L26;
        setCSSPosition(r109.a());
        goto L22
    L26:
        if (r110 == 7) goto L160;
        if (r110 != 76) goto L30;
        com.lynx.react.bridge.mapbuffer.e r111 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBoxShadow(r111);
        r107.Q = r111;
        goto L22
    L30:
        if (r110 != 77) goto L32;
        com.lynx.react.bridge.mapbuffer.e r112 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setTransformOrigin(r112);
        r107.O = r112;
        goto L22
    L32:
        if (r110 != 120) goto L34;
        int r113 = r109.a();
        setOverflowX(Integer.valueOf(r113));
        r107.H = Integer.valueOf(r113);
        goto L22
    L34:
        if (r110 != 121) goto L36;
        int r114 = r109.a();
        setOverflowY(Integer.valueOf(r114));
        r107.I = Integer.valueOf(r114);
        goto L22
    L36:
        if (r110 != 129) goto L38;
        setCaretColor(r109.getString());
        goto L22
    L38:
        if (r110 != 130) goto L40;
        int r115 = r109.a();
        setLynxDirection(r115);
        r107.N = r115;
        goto L22
    L40:
        if (r110 != 142) goto L42;
        if ((this instanceof LynxUI) == false) goto L22;
        ((LynxUI) this).setEnterTransitionName(new com.lynx.react.bridge.mapbuffer.e(r109.f()));
        goto L22
    L42:
        if (r110 != 143) goto L44;
        if ((this instanceof LynxUI) == false) goto L22;
        ((LynxUI) this).setExitTransitionName(new com.lynx.react.bridge.mapbuffer.e(r109.f()));
        goto L22
    L44:
        switch(r110) {
            case 7: goto L160;
            case 8: goto L66;
            case 9: goto L65;
            case 10: goto L64;
            case 11: goto L63;
            case 12: goto L62;
            case 13: goto L61;
            case 14: goto L60;
            case 15: goto L59;
            case 16: goto L58;
            case 17: goto L57;
            case 18: goto L56;
            case 19: goto L55;
            case 20: goto L54;
            case 21: goto L53;
            default: goto L45;
        };
    L53:
        int r116 = (int) r109.b();
        setBorderWidth(4, r116);
        r107.B = r116;
        goto L22
    L54:
        int r117 = (int) r109.b();
        setBorderWidth(3, r117);
        r107.A = r117;
        goto L22
    L55:
        int r118 = (int) r109.b();
        setBorderWidth(2, r118);
        r107.f382074z = r118;
        goto L22
    L56:
        int r119 = (int) r109.b();
        setBorderWidth(1, r119);
        r107.f382073y = r119;
        goto L22
    L57:
        int r120 = (int) r109.b();
        setBorderWidth(0, r120);
        r107.f382072x = r120;
        goto L22
    L58:
        com.lynx.react.bridge.mapbuffer.e r121 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBorderRadius(3, r121);
        r107.f382065q = r121;
        goto L22
    L59:
        com.lynx.react.bridge.mapbuffer.e r122 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBorderRadius(2, r122);
        r107.f382064p = r122;
        goto L22
    L60:
        com.lynx.react.bridge.mapbuffer.e r123 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBorderRadius(4, r123);
        r107.f382066r = r123;
        goto L22
    L61:
        com.lynx.react.bridge.mapbuffer.e r124 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBorderRadius(1, r124);
        r107.f382063o = r124;
        goto L22
    L62:
        com.lynx.react.bridge.mapbuffer.e r125 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBorderRadius(0, r125);
        r107.f382062n = r125;
        goto L22
    L63:
        int r126 = r109.a();
        setBorderColor(4, Integer.valueOf(r126));
        r107.F = Integer.valueOf(r126);
        goto L22
    L64:
        int r127 = r109.a();
        setBorderColor(3, Integer.valueOf(r127));
        r107.E = Integer.valueOf(r127);
        goto L22
    L65:
        int r128 = r109.a();
        setBorderColor(2, Integer.valueOf(r128));
        r107.D = Integer.valueOf(r128);
        goto L22
    L66:
        int r129 = r109.a();
        setBorderColor(1, Integer.valueOf(r129));
        r107.C = Integer.valueOf(r129);
        goto L22
    L45:
        switch(r110) {
            case 23: goto L87;
            case 25: goto L85;
            case 47: goto L84;
            case 63: goto L82;
            case 74: goto L80;
            case 104: goto L78;
            case 123: goto L76;
            case 147: goto L74;
            case 170: goto L72;
            case 190: goto L71;
            case 193: goto L69;
            case 208: goto L67;
            default: goto L46;
        };
    L67:
        int r130 = r109.a();
        setImageRendering(r130);
        r107.S = r130;
        goto L22
    L69:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r131 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        ((LynxUI) this).setClipPath(r131);
        r107.T = r131;
        goto L22
    L71:
        com.lynx.react.bridge.mapbuffer.e r132 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setPerspective(r132);
        r107.P = r132;
        goto L22
    L72:
        com.lynx.react.bridge.mapbuffer.e r133 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setMaskImage(r133);
        r107.f382055h = r133;
        goto L22
    L74:
        if ((this instanceof UIComponent) == false) goto L22;
        ((UIComponent) this).setZIndex(r109.a());
        goto L22
    L76:
        com.lynx.react.bridge.mapbuffer.e r134 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBackgroundClip(r134);
        r107.f382041a = r134;
        goto L22
    L78:
        if ((this instanceof LynxUI) == false) goto L22;
        int r135 = r109.a();
        ((LynxUI) this).setVisibility(r135);
        r107.f382056h0 = r135;
        goto L22
    L80:
        int r136 = r109.a();
        setBorderStyle(0, r136);
        r107.f382067s = r136;
        goto L22
    L82:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r137 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        ((LynxUI) this).setTransform(r137);
        r107.R = r137;
        goto L22
    L84:
        float r138 = r109.a();
        setFontSize(r138);
        r107.M = r138;
        goto L22
    L85:
        int r139 = r109.a();
        setOverflow(r139);
        r107.G = Integer.valueOf(r139);
        goto L22
    L87:
        if ((this instanceof LynxUI) == false) goto L22;
        float r140 = r109.a();
        ((LynxUI) this).setAlpha(r140);
        r107.f382054g0 = r140;
        goto L22
    L46:
        switch(r110) {
            case 200: goto L93;
            case 201: goto L92;
            case 202: goto L91;
            case 203: goto L90;
            case 204: goto L89;
            default: goto L47;
        };
    L89:
        com.lynx.react.bridge.mapbuffer.e r141 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setMaskSize(r141);
        r107.f382059k = r141;
        goto L22
    L90:
        com.lynx.react.bridge.mapbuffer.e r142 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setMaskOrigin(r142);
        r107.f382057i = r142;
        goto L22
    L91:
        com.lynx.react.bridge.mapbuffer.e r143 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setMaskClip(r143);
        r107.f382061m = r143;
        goto L22
    L92:
        com.lynx.react.bridge.mapbuffer.e r144 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setMaskPosition(r144);
        r107.f382060l = r144;
        goto L22
    L93:
        com.lynx.react.bridge.mapbuffer.e r145 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setMaskRepeat(r145);
        r107.f382058j = r145;
        goto L22
    L47:
        switch(r110) {
            case 83: goto L125;
            case 84: goto L122;
            case 85: goto L119;
            case 86: goto L116;
            case 87: goto L113;
            case 88: goto L110;
            case 89: goto L107;
            case 90: goto L104;
            case 91: goto L101;
            case 92: goto L98;
            case 93: goto L95;
            default: goto L48;
        };
    L95:
        if ((this instanceof LynxUI) == false) goto L22;
        double r146 = r109.b();
        ((LynxUI) this).setLayoutAnimationUpdateDelay(r146);
        r107.f382048d0 = r146;
        goto L22
    L98:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r147 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        ((LynxUI) this).setLayoutAnimationUpdateTimingFunc(r147);
        r107.f382052f0 = r147;
        goto L22
    L101:
        if ((this instanceof LynxUI) == false) goto L22;
        double r148 = r109.b();
        ((LynxUI) this).setLayoutAnimationUpdateDuration(r148);
        r107.f382050e0 = r148;
        goto L22
    L104:
        if ((this instanceof LynxUI) == false) goto L22;
        int r149 = r109.a();
        ((LynxUI) this).setLayoutAnimationDeleteProperty(r149);
        r107.f382044b0 = r149;
        goto L22
    L107:
        if ((this instanceof LynxUI) == false) goto L22;
        double r150 = r109.b();
        ((LynxUI) this).setLayoutAnimationDeleteDelay(r150);
        r107.Z = r150;
        goto L22
    L110:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r151 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        ((LynxUI) this).setLayoutAnimationDeleteTimingFunc(r151);
        r107.f382046c0 = r151;
        goto L22
    L113:
        if ((this instanceof LynxUI) == false) goto L22;
        double r152 = r109.b();
        ((LynxUI) this).setLayoutAnimationDeleteDuration(r152);
        r107.f382042a0 = r152;
        goto L22
    L116:
        if ((this instanceof LynxUI) == false) goto L22;
        int r153 = r109.a();
        ((LynxUI) this).setLayoutAnimationCreateProperty(r153);
        r107.X = r153;
        goto L22
    L119:
        if ((this instanceof LynxUI) == false) goto L22;
        double r154 = r109.b();
        ((LynxUI) this).setLayoutAnimationCreateDelay(r154);
        r107.V = r154;
        goto L22
    L122:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r155 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        ((LynxUI) this).setLayoutAnimationCreateTimingFunc(r155);
        r107.Y = r155;
        goto L22
    L125:
        if ((this instanceof LynxUI) == false) goto L22;
        double r156 = r109.b();
        ((LynxUI) this).setLayoutAnimationCreateDuration(r156);
        r107.W = r156;
        goto L22
    L48:
        switch(r110) {
            case 98: goto L131;
            case 99: goto L130;
            case 100: goto L129;
            case 101: goto L128;
            case 102: goto L127;
            default: goto L49;
        };
    L127:
        com.lynx.react.bridge.mapbuffer.e r157 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBackgroundSize(r157);
        r107.f382053g = r157;
        goto L22
    L128:
        com.lynx.react.bridge.mapbuffer.e r158 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBackgroundRepeat(r158);
        r107.f382051f = r158;
        goto L22
    L129:
        com.lynx.react.bridge.mapbuffer.e r159 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBackgroundOrigin(r159);
        r107.f382047d = r159;
        goto L22
    L130:
        com.lynx.react.bridge.mapbuffer.e r160 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBackgroundPosition(r160);
        r107.f382049e = r160;
        goto L22
    L131:
        com.lynx.react.bridge.mapbuffer.e r161 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        setBackgroundImage(r161);
        r107.f382045c = r161;
        goto L22
    L49:
        switch(r110) {
            case 115: goto L135;
            case 116: goto L134;
            case 117: goto L133;
            case 118: goto L132;
            default: goto L50;
        };
    L132:
        int r162 = r109.a();
        setBorderStyle(4, r162);
        r107.f382071w = r162;
        goto L22
    L133:
        int r163 = r109.a();
        setBorderStyle(3, r163);
        r107.f382070v = r163;
        goto L22
    L134:
        int r164 = r109.a();
        setBorderStyle(2, r164);
        r107.f382069u = r164;
        goto L22
    L135:
        int r165 = r109.a();
        setBorderStyle(1, r165);
        r107.f382068t = r165;
        goto L22
    L50:
        switch(r110) {
            case 125: goto L138;
            case 126: goto L137;
            case 127: goto L136;
            default: goto L51;
        };
    L136:
        float r166 = (float) r109.b();
        setOutlineWidth(r166);
        r107.K = r166;
        goto L22
    L137:
        int r167 = r109.a();
        setOutlineStyle(r167);
        r107.L = r167;
        goto L22
    L138:
        int r168 = r109.a();
        setOutlineColor(r109.a());
        r107.f382040J = r168;
        goto L22
    L51:
        switch(r110) {
            case 186: goto L146;
            case 187: goto L143;
            case 188: goto L140;
            default: goto L22;
        };
    L140:
        if ((this instanceof AbsLynxList) == false) goto L22;
        ((AbsLynxList) this).setCrossAxisGap((float) r109.b());
        goto L22
    L143:
        if ((this instanceof AbsLynxList) == false) goto L22;
        ((AbsLynxList) this).setMainAxisGap((float) r109.b());
        goto L22
    L146:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r169 = new com.lynx.react.bridge.mapbuffer.e(r109.f());
        ((LynxUI) this).setFilter(r169);
        r107.U = r169;
    L160:
        int r170 = r109.a();
        setBackgroundColor(r170);
        r107.f382043b = r170;
        goto L22
    L368:
        return;
    L367:
        return;
    L366:
        return;
    }

    public void updateSticky(float[] r100) {
        LynxContext r101 = this.mContext;
        if (r101 != null) goto L5;
    L7:
        if (r100 != null) goto L9;
    L15:
        this.mSticky = null;
        return;
    L9:
        if (r100.length < 4) goto L15;
        Sticky r102 = new Sticky();
        this.mSticky = r102;
        ((RectF) r102).left = r100[0];
        ((RectF) r102).top = r100[1];
        ((RectF) r102).right = r100[2];
        ((RectF) r102).bottom = r100[3];
        r102.f382344b = 0.0f;
        r102.f382343a = 0.0f;
        Cloneable r103 = getParentBaseUI();
        if ((r103 instanceof g7a.c) == false) goto L18;
        ((g7a.c) r103).t();
        return;
    L18:
        return;
    L5:
        if (r101.getEnableNewSticky() == false) goto L7;
        updateNewSticky(r100);
    }

    public LynxBaseUI(LynxContext r100) {
        this(r100, null);
    }

    public void setBorderColor(Integer r100) {
        setBorderColorForAllSpacingIndex(r100);
    }

    public void setOverflow(int r100) {
        setOverflowWithMask(3, r100);
    }

    public LynxBaseUI(LynxContext r100, Object r101) {
        this.mPreviousDrawUI = null;
        this.mNextDrawUI = null;
        this.mTranslationZ = 0.0f;
        this.mGestureArenaMemberId = 0;
        this.mIsTransformNode = false;
        this.mChildren = new ArrayList();
        this.mProps = new JavaOnlyMap();
        this.mIncludeNativeGesture = false;
        this.mDataset = new JavaOnlyMap();
        this.mNodeIndex = 0;
        this.mNodeReadyBlockArray = new ArrayList();
        this.mHasRadius = false;
        this.mSkipLayoutUpdated = false;
        this.mDisplayNone = false;
        this.mOverflow = 0;
        this.mClipToRadius = false;
        this.mFocusable = false;
        EventTarget.EnableStatus r102 = EventTarget.EnableStatus.Undefined;
        this.mIgnoreFocus = r102;
        this.mPerspective = null;
        this.mPrePerspectiveValue = 0.0f;
        this.hasTransformChanged = false;
        this.userInteractionEnabled = true;
        this.nativeInteractionEnabled = false;
        this.mSticky = null;
        this.mStickyScrollerSign = -1;
        this.mMaxHeight = -1.0f;
        this.mBackgroundColor = 0;
        this.mEnableExposureUIMargin = null;
        this.mEnableExposureUIClip = r102;
        this.mIsDetachedWithView = false;
        this.mNeedsBackgroundRecreation = false;
        this.mAlpha = 1.0f;
        this.mSkewX = 0.0f;
        this.mSkewY = 0.0f;
        this.mShouldAttachChildrenView = false;
        this.mExtraOffsetX = 0.0f;
        this.mExtraOffsetY = 0.0f;
        this.mAccessibilityLabel = "";
        this.mAccessibilityId = "";
        this.mAccessibilityElementStatus = -1;
        this.mAccessibilityEnableTap = false;
        this.mAccessibilityKeepFocused = false;
        this.mConsumeHoverEvent = false;
        this.mAccessibilityTraits = LynxAccessibilityHelper.LynxAccessibilityTraits.NONE;
        this.mDrawableCallback = new c(this);
        this.mBitmapConfig = null;
        this.mCSSPosition = 1;
        this.mTouchSlop = 8.0f;
        this.mOnResponseChain = false;
        this.mBlockNativeEvent = false;
        this.mBlockNativeEventAreas = null;
        this.mEventThrough = r102;
        this.mEventThroughActiveRegions = null;
        this.mPointerEvents = EventTarget.PointerEventsValue.Unset;
        this.mPanInterceptDirection = EventTarget.PanInterceptDirection.None;
        this.mPanInterceptScope = EventTarget.PanInterceptScope.None;
        this.mFlattenChildrenCount = 0;
        this.mNeedSortChildren = false;
        this.mLastTranslateZ = 0.0f;
        this.mEnableTouchPseudoPropagation = true;
        this.mTransformMatrix = new Matrix();
        this.mHitTestMatrix = new Matrix();
        this.mConsumeSlideEventAngles = null;
        this.mBlockListEvent = false;
        this.mOffsetDescendantRectToLynxView = new WeakReference(null);
        this.mUseLocalCache = null;
        this.mSkipRedirection = false;
        this.mDisableDefaultResize = false;
        this.mImageRendering = -1;
        this.mBoundingClientRectCallbacks = new ArrayList();
        this.mIsFirstAnimatedReady = true;
        this.mHasTranslateDiff = false;
        this.mLynxDirection = 3;
        this.mContext = r100;
        this.mParam = r101;
        this.nativeInteractionEnabled = r100.getEnableNativeInteraction();
        com.lynx.tasm.behavior.ui.utils.e r103 = new com.lynx.tasm.behavior.ui.utils.e(r100);
        this.mLynxBackground = r103;
        r103.f383143c = this.mDrawableCallback;
        float r104 = com.lynx.tasm.utils.i.b(14.0f, r100.getScreenMetrics().density);
        this.mFontSize = r104;
        this.mLynxBackground.f383144d = r104;
        this.mLatestSize = new Point();
        this.mLastSize = new Point();
        initialize();
    }

    private void boundingClientRectInner(ReadableMap r100, Callback r101) {
        RectF r102 = com.lynx.tasm.behavior.ui.utils.h.g(this, r100);
        float r103 = getLynxContext().getScreenMetrics().density;
        JavaOnlyMap r104 = new JavaOnlyMap();
        r104.putString("id", getIdSelector());
        r104.putMap("dataset", (WritableMap) getDataset());
        r104.putDouble("left", r102.left / r103);
        r104.putDouble("top", r102.top / r103);
        r104.putDouble("right", r102.right / r103);
        r104.putDouble("bottom", r102.bottom / r103);
        r104.putDouble("width", r102.width() / r103);
        r104.putDouble("height", r102.height() / r103);
        r101.invoke(new Object[]{0, r104});
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.View] */
    @LynxUIMethod
    public void boundingClientRect(ReadableMap r100, Callback r101) {
        LynxUIOwner r102 = this.mContext.getLynxUIOwner();
        if (r102 != null) goto L6;
        boundingClientRectInner(r100, r101);
        return;
    L6:
        UIBody r103 = r102.getRootUI();
        if (r103 != null) goto L10;
        boundingClientRectInner(r100, r101);
        return;
    L10:
        ?? r104 = r103.getView();
        if (r104 != 0) goto L15;
        boundingClientRectInner(r100, r101);
        return;
    L15:
        if (r104.isLayoutRequested() == true) goto L18;
        boundingClientRectInner(r100, r101);
        return;
    L18:
        this.mContext.getLynxUIOwner().registerBoundingClientRectUI(this);
        this.mBoundingClientRectCallbacks.add(new a(this, r100, r101));
    }

    public boolean checkStickyOnParentScroll(int r110, int r111) {
        if (this.mSticky != null) goto L5;
        return false;
    L5:
        float r112 = getLeft() - r110;
        float r113 = getTop() - r111;
        Sticky r100 = this.mSticky;
        float r101 = ((RectF) r100).left;
        if (r112 >= r101) goto L9;
        r100.f382343a = r101 - r112;
    L16:
        Sticky r114 = this.mSticky;
        float r102 = ((RectF) r114).top;
        if (r113 >= r102) goto L20;
        r114.f382344b = r102 - r113;
        return true;
    L20:
        if (getParentBaseUI() != null) goto L23;
        LLog.e(TAG, "checkStickyOnParentScroll failed, parent is null.");
        return false;
    L23:
        int r115 = getParentBaseUI().getHeight();
        float r103 = getHeight() + r113;
        Sticky r104 = this.mSticky;
        float r105 = ((RectF) r104).bottom;
        float r116 = r115;
        if ((r103 + r105) <= r116) goto L26;
        r104.f382344b = Math.max((r116 - r103) - r105, ((RectF) r104).top - r113);
        return true;
    L26:
        r104.f382344b = 0.0f;
        return true;
    L9:
        if (getParentBaseUI() != null) goto L12;
        LLog.e(TAG, "checkStickyOnParentScroll failed, parent is null.");
        return false;
    L12:
        int r106 = getParentBaseUI().getWidth();
        float r107 = getWidth() + r112;
        Sticky r108 = this.mSticky;
        float r109 = ((RectF) r108).right;
        float r117 = r106;
        if ((r107 + r109) <= r117) goto L15;
        r108.f382343a = Math.max((r117 - r107) - r109, ((RectF) r108).left - r112);
        goto L16
    L15:
        r108.f382343a = 0.0f;
        goto L16
    }

    public boolean childrenContainPoint(float r100, float r101) {
        return childrenContainPoint(r100, r101, false);
    }

    @Override // p7a.b
    public void consumeGesture(int r100, ReadableMap r101) {
        if (isEnableNewGesture() == false) goto L11;
        if (r101 == null) goto L13;
        boolean r102 = r101.getBoolean(RNParamRegisterEventHandler.SRC_INNER, true);
        boolean r103 = r101.getBoolean("consume", true);
        if (r102 == false) goto L9;
        consumeGesture(r103);
        return;
    L9:
        interceptGesture(r103);
        return;
    L13:
        return;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean containsPoint(float r100, float r101) {
        return containsPoint(r100, r101, false);
    }

    public e convertToMeaningfulPaintingArea(int r100, int r101) {
        if (needGenerateMeaningfulPaintingArea() == true) goto L6;
        return null;
    L6:
        e r102 = new e(r100, r101, getWidth(), getHeight());
        getAlpha();
        getScaleX();
        getScaleY();
        r102.f382492e = getMeaningfulContentStatus();
        r102.f382493f = getFirstMeaningfulContentPresentedTimestampMicros();
        return r102;
    }

    public boolean eventThrough(float r110, float r111) {
        EventTarget.EnableStatus r100 = this.mEventThrough;
        if (r100 != EventTarget.EnableStatus.Enable) goto L6;
        boolean r101 = true;
    L20:
        if (this.mEventThroughActiveRegions != null) goto L22;
        return r101;
    L22:
        int r102 = 0;
        boolean r103 = false;
    L24:
        if (r102 >= this.mEventThroughActiveRegions.size()) goto L42;
        ArrayList r104 = (ArrayList) ListProtector.get(this.mEventThroughActiveRegions, r102);
        if (r104 == null) goto L41;
        if (r104.size() != 4) goto L41;
        float r105 = ((SizeValue) ListProtector.get(r104, 0)).a(this.mWidth);
        float r106 = ((SizeValue) ListProtector.get(r104, 1)).a(this.mHeight);
        float r107 = ((SizeValue) ListProtector.get(r104, 2)).a(this.mWidth) + r105;
        float r108 = ((SizeValue) ListProtector.get(r104, 3)).a(this.mHeight) + r106;
        if (r110 >= r105) goto L32;
    L38:
        r103 = false;
    L39:
        if (r103 == false) goto L41;
        LLog.i(TAG, "hit the event through active regions!");
        goto L42
    L32:
        if (r110 >= r107) goto L38;
        if (r111 < r106) goto L38;
        if (r111 >= r108) goto L38;
        r103 = true;
    L41:
        r102 = r102 + 1;
    L42:
        if (r103 == true) goto L53;
        if (r101 == false) goto L54;
        return false;
    L54:
        return true;
    L53:
        return r101;
    L6:
        if (r100 != EventTarget.EnableStatus.Disable) goto L9;
    L18:
        r101 = false;
        goto L20
    L9:
        if (parent() == null) goto L18;
        EventTarget r109 = parent();
        if ((r109 instanceof UIBody) == true) goto L18;
        if ((r109 instanceof LynxBaseUI) == false) goto L16;
        LynxBaseUI r112 = (LynxBaseUI) r109;
        RectF r113 = com.lynx.tasm.behavior.ui.utils.h.d(this, r112, new RectF(0.0f, 0.0f, r112.getWidth(), r112.getHeight()));
        float r114 = r110 - r113.left;
        float r115 = r111 - r113.top;
    L17:
        r101 = r109.eventThrough(r114, r115);
        goto L20
    L16:
        r114 = r110;
        r115 = r111;
        goto L17
    }

    @LynxUIMethod
    public void fetchAccessibilityTargets(ReadableMap r100, Callback r101) {
        if (this.mContext.getLynxAccessibilityWrapper() == null) goto L12;
        com.lynx.tasm.behavior.ui.accessibility.d r102 = this.mContext.getLynxAccessibilityWrapper();
        if (r102.e() == false) goto L7;
    L10:
        JavaOnlyArray r103 = new JavaOnlyArray();
        com.lynx.tasm.behavior.ui.accessibility.d.g(this, false, r103);
        r101.invoke(new Object[]{0, r103});
        return;
    L7:
        if (r102.f() == true) goto L10;
        r101.invoke(new Object[]{1, "fetch accessibility targets fail!"});
        return;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float r100, float r101) {
        return hitTest(r100, r101, false);
    }

    @LynxUIMethod
    public void innerText(ReadableMap r100, Callback r101) {
        if (this.mContext.getLynxAccessibilityWrapper() == null) goto L12;
        com.lynx.tasm.behavior.ui.accessibility.d r102 = this.mContext.getLynxAccessibilityWrapper();
        if (r102.e() == false) goto L7;
    L10:
        JavaOnlyArray r103 = new JavaOnlyArray();
        com.lynx.tasm.behavior.ui.accessibility.d.g(this, true, r103);
        r101.invoke(new Object[]{0, r103});
        return;
    L7:
        if (r102.f() == true) goto L10;
        r101.invoke(new Object[]{1, "fetch accessibility inner text fail!"});
        return;
    }

    public void insertChild(LynxBaseUI r100, int r101) {
        ListProtector.add(this.mChildren, r101, r100);
        r100.setParent(this);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventBubble(boolean r100, long r101) {
        if (r100 == false) goto L8;
        if (getRootLynxPageUI() == null) goto L12;
        getRootLynxPageUI().startEventFire(false, r101);
        return;
    L12:
        return;
    L8:
        if (getParentLynxPageUI() == null) goto L10;
        getParentLynxPageUI().startEventBubble(r101);
        return;
    L10:
        startEventFire(false, r101);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventCapture(boolean r100, long r101) {
        if (r100 == false) goto L7;
        if (getRootLynxPageUI() == null) goto L18;
        getRootLynxPageUI().startEventFire(false, r101);
        return;
    L18:
        return;
    L7:
        if (getChildrenLynxPageUI() == null) goto L9;
        LynxBaseUI r102 = (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this)));
    L10:
        if (r102 != null) goto L12;
        startEventBubble(r101);
        return;
    L12:
        if (r102.getLynxContext() != null) goto L14;
        return;
    L14:
        if (r102.getLynxContext().getEventEmitter() == null) goto L21;
        r102.getLynxContext().getEventEmitter().startEventCapture(r101);
        return;
    L21:
        return;
    L9:
        r102 = null;
        goto L10
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventFire(boolean r100, long r101) {
        if (getChildrenLynxPageUI() == null) goto L5;
        LynxBaseUI r102 = (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this)));
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getLynxContext() != null) goto L10;
        return;
    L10:
        if (r102.getLynxContext().getEventEmitter() == null) goto L15;
        r102.getLynxContext().getEventEmitter().startEventFire(r100, r101);
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public void onListCellAppear(String r100, LynxBaseUI r101) {
        if (this.mBlockListEvent == false) goto L5;
        return;
    L5:
        Iterator<LynxBaseUI> r102 = this.mChildren.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().onListCellAppear(r100, r101);
        goto L7
    }

    public void onListCellPrepareForReuse(String r100, LynxBaseUI r101) {
        if (this.mBlockListEvent == false) goto L5;
        return;
    L5:
        Iterator<LynxBaseUI> r102 = this.mChildren.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().onListCellPrepareForReuse(r100, r101);
        goto L7
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onPseudoStatusChanged(int r100, int r101) {
        this.mPseudoStatus = r101;
    }

    @LynxUIMethod
    public void requestAccessibilityFocus(ReadableMap r100, Callback r101) {
        if (this.mContext.getLynxAccessibilityWrapper() == null) goto L36;
        com.lynx.tasm.behavior.ui.accessibility.d r102 = this.mContext.getLynxAccessibilityWrapper();
        if (r102.k() == true) goto L8;
        r101.invoke(new Object[]{1, "System accessibility is disable!"});
        return;
    L8:
        if (r102.f() == false) goto L21;
        LynxAccessibilityHelper r103 = r102.f382468n;
        r103.getClass();
        if ((this instanceof LynxUI) == false) goto L18;
        LynxUI r104 = (LynxUI) this;
        if (r104.getView() == null) goto L18;
        if (r103.a(this) == false) goto L18;
        r104.getView().sendAccessibilityEvent(128);
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
    L33:
        r101.invoke(new Object[]{0, "Accessibility element on focused"});
        return;
    L18:
        r105 = false;
    L21:
        if (r102.e() == false) goto L34;
        LynxAccessibilityDelegate r106 = r102.f382467m;
        if (r106.a() == true) goto L25;
    L31:
        boolean r107 = false;
    L32:
        if (r107 == false) goto L34;
    L25:
        if (r106.f382423e.k(this) == false) goto L31;
        int r108 = r106.f382423e.e(this);
        if (r108 == (-1)) goto L31;
        r107 = r106.requestAccessibilityFocus(r108);
    L34:
        r101.invoke(new Object[]{1, "Request accessibility focus fail!"});
        return;
    }

    @LynxUIMethod
    public void requestUIInfo(ReadableMap r100, Callback r101) {
        ArrayList r102 = new ArrayList();
        if (r100 == null) goto L11;
        ReadableMapKeySetIterator r103 = r100.keySetIterator();
    L6:
        if (r103.hasNextKey() == false) goto L11;
        String r104 = r103.nextKey();
        if (r100.getBoolean(r104, false) == false) goto L6;
        r102.add(r104);
    L11:
        if (r100 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        JavaOnlyMap r106 = getPositionInfo(r105);
        JavaOnlyMap r107 = new JavaOnlyMap();
        if (r102.contains("id") == false) goto L20;
        r107.put("id", getIdSelector());
    L20:
        if (r102.contains("dataset") == false) goto L23;
        r107.put("dataset", getDataset());
    L23:
        if (r102.contains(SVGRenderEngine.RECT) == false) goto L26;
        r107.put("left", r106.get("left"));
        r107.put("top", r106.get("top"));
        r107.put("right", r106.get("right"));
        r107.put("bottom", r106.get("bottom"));
    L26:
        if (r102.contains("size") == false) goto L29;
        r107.put("width", r106.get("width"));
        r107.put("height", r106.get("height"));
    L29:
        if (r102.contains("scrollOffset") == false) goto L32;
        float r108 = getLynxContext().getScreenMetrics().density;
        r107.put("scrollLeft", Float.valueOf(getScrollX() / r108));
        r107.put("scrollTop", Float.valueOf(getScrollY() / r108));
    L32:
        if (r102.contains("node") == false) goto L34;
        r107.put("node", new JavaOnlyMap());
    L34:
        r101.invoke(new Object[]{0, r107});
        return;
    L13:
        if (r100.getBoolean("androidEnableTransformProps", false) == false) goto L15;
        r105 = true;
        goto L16
    }

    @LynxUIMethod
    public void scrollIntoView(ReadableMap r100, Callback r101) {
        if (r100 != null) goto L7;
        if (r101 == null) goto L25;
        r101.invoke(new Object[]{4, "missing the param of `scrollIntoViewOptions`"});
        return;
    L25:
        return;
    L7:
        HashMap r102 = (HashMap) r100.asHashMap().get("scrollIntoViewOptions");
        if (r102 != null) goto L12;
        r101.invoke(new Object[]{4, "missing the param of `scrollIntoViewOptions`"});
        return;
    L12:
        if (r102.containsKey("behavior") == false) goto L14;
        String r103 = (String) r102.get("behavior");
    L16:
        if (r102.containsKey("block") == false) goto L18;
        String r104 = (String) r102.get("block");
    L20:
        if (r102.containsKey(BrowserDependency.UrlClickType.INLINE) == false) goto L22;
        String r105 = (String) r102.get(BrowserDependency.UrlClickType.INLINE);
    L23:
        scrollIntoView(r103.equals("smooth"), r104, r105, r101);
        return;
    L22:
        r105 = "nearest";
        goto L23
    L18:
        r104 = "start";
        goto L20
    L14:
        r103 = "auto";
        goto L16
    }

    @LynxPropGroup(customType = "Color", names = {GXTemplateKey.STYLE_BORDER_COLOR, "border-left-color", "border-right-color", "border-top-color", "border-bottom-color"})
    public void setBorderColor(int r100, Integer r101) {
        ensureLynxBackground();
        this.mLynxBackground.p(SPACING_TYPES[r100], r101);
    }

    @LynxPropGroup(names = {GXTemplateKey.STYLE_BORDER_RADIUS, GXTemplateKey.STYLE_BORDER_TOP_LEFT_RADIUS, GXTemplateKey.STYLE_BORDER_TOP_RIGHT_RADIUS, GXTemplateKey.STYLE_BORDER_BOTTOM_RIGHT_RADIUS, GXTemplateKey.STYLE_BORDER_BOTTOM_LEFT_RADIUS})
    public void setBorderRadius(int r100, ReadableArray r101) {
        ensureLynxBackground();
        this.mHasRadius = false;
        if (this.mLynxBackground.q(r100, r101) == false) goto L5;
        this.mHasRadius = true;
    L5:
        onBorderRadiusUpdated(r100);
    }

    @LynxPropGroup(defaultInt = -1, names = {"border-style", "border-left-style", "border-right-style", "border-top-style", "border-bottom-style"})
    public void setBorderStyle(int r100, int r101) {
        ensureLynxBackground();
        this.mLynxBackground.s(SPACING_TYPES[r100], r101);
    }

    @LynxPropGroup(names = {GXTemplateKey.STYLE_BORDER_WIDTH, "border-left-width", "border-right-width", "border-top-width", "border-bottom-width"})
    public void setBorderWidth(int r100, int r101) {
        ensureLynxBackground();
        this.mBorderSpacingIndex = r100;
        this.mBorderWidth = r101;
        com.lynx.tasm.behavior.ui.utils.e r102 = this.mLynxBackground;
        int[] r103 = SPACING_TYPES;
        float r104 = r101;
        r102.b().c(r103[r100], r104);
        com.lynx.tasm.behavior.ui.utils.g r105 = this.mLynxMask;
        if (r105 == null) goto L6;
        r105.b().c(r103[r100], r104);
        return;
    }

    @Override // p7a.b
    public void setGestureDetectorState(int r100, int r101) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        q7a.b r102 = getGestureArenaManager();
        if (r102 != null) goto L8;
        return;
    L8:
        int r103 = getGestureArenaMemberId();
        if (r102.d() == true) goto L11;
        return;
    L11:
        if (r102.f531996h == null) goto L42;
        Map<Integer, WeakReference<p7a.a>> r104 = r102.f531989a;
        if (r104 == null) goto L46;
        HashMap r105 = (HashMap) r104;
        WeakReference r106 = (WeakReference) r105.get(Integer.valueOf(r103));
        t7a.d r107 = r102.f531996h;
        p7a.a r108 = (p7a.a) r106.get();
        r107.getClass();
        if (r108 == null) goto L47;
        Map<Integer, t7a.a> r109 = r108.getGestureHandlers();
        if (r109 == null) goto L27;
        Iterator<t7a.a> r110 = r109.values().iterator();
    L23:
        if (r110.hasNext() == false) goto L27;
        t7a.a r111 = r110.next();
        if (r111.f544907e.f540932a != r100) goto L23;
    L29:
        if (r101 != 2) goto L31;
        if (r111 == null) goto L45;
        r111.e();
        return;
    L45:
        return;
    L31:
        if (r101 != 3) goto L48;
        if (r111 == null) goto L43;
        r111.d();
        return;
    L43:
        return;
    L48:
        return;
    L27:
        r111 = null;
        goto L29
    L47:
        return;
    L46:
        return;
    }

    public void setOverflowWithMask(short r100, int r101) {
        int r102 = this.mOverflow;
        if (r101 != 0) goto L5;
        int r103 = r100 | r102;
    L6:
        this.mOverflow = r103;
        requestLayout();
        return;
    L5:
        r103 = (~r100) & r102;
        goto L6
    }

    public void setPosition(int r100, int r101) {
        this.mLeft = r100;
        this.mTop = r101;
        this.mOriginTop = r101;
        this.mOriginLeft = r100;
    }

    public void setSign(int r100, String r101) {
        this.mSign = r100;
        this.mTagName = r101;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventFire(boolean r100, long r101) {
        LynxContext r102 = this.mContext;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getEventEmitter() == null) goto L10;
        this.mContext.getEventEmitter().startEventFire(r100, r101);
        return;
    }

    public void transformFromViewToRootView(View r100, float[] r101) {
        if (r100.getMatrix().isIdentity() == true) goto L5;
        r100.getMatrix().mapPoints(r101);
    L5:
        View r102 = r100.getRootView();
    L6:
        if (r100 == r102) goto L19;
        View r103 = (View) r100.getParent();
        if (r103 == null) goto L9;
        r101[0] = r101[0] + r100.getLeft();
        r101[1] = r101[1] + r100.getTop();
        r101[0] = r101[0] - r103.getScrollX();
        r101[1] = r101[1] - r103.getScrollY();
        if (r103.getMatrix().isIdentity() == true) goto L13;
        r103.getMatrix().mapPoints(r101);
    L13:
        r100 = r103;
        goto L6
    L9:
        LLog.e(TAG, "transformFromViewToRootView failed, parent is null.");
        return;
    }

    public final void updateLayoutSize(int r100, int r101) {
        Point r102 = this.mLatestSize;
        r102.x = r100;
        r102.y = r101;
    }

    public void setBorderRadius(int r100, String r101) {
        LLog.DTHROW(new RuntimeException("setBorderWidth(int, String) is deprecated.This has no effect."));
    }

    public void setBorderWidth(int r100, String r101) {
        LLog.DTHROW(new RuntimeException("setBorderWidth(int, String) is deprecated.This has no effect."));
    }

    public static /* synthetic */ void access$100(LynxBaseUI r100, ReadableMap r101, Callback r102) {
        r100.boundingClientRectInner(r101, r102);
    }

    private float[] calculateSiblingCoordinates(LynxBaseUI r100, float r110, float r111) {
        if (this.mContext.getEnableEventRefactor() == false) goto L7;
        return getTargetPoint(r110, r111, getScrollX(), getScrollY(), r100.getRectWithoutTransform(), r100.getTransformMatrix());
    L7:
        if (r100.isCustomHittest() == false) goto L9;
    L13:
        float r112 = r110 + ((r100.getScrollX() - r100.getOriginLeft()) - r100.getTranslationX());
        float r113 = r111 + ((r100.getScrollY() - r100.getOriginTop()) - r100.getTranslationY());
    L15:
        return new float[]{r112, r113};
    L9:
        if (r100.needCustomLayout() == false) goto L13;
        if ((r100 instanceof UIGroup) == false) goto L13;
        r112 = r110 - r100.getOriginLeft();
        r113 = r111 - r100.getOriginTop();
        goto L15
    }

    public boolean childrenContainPoint(float r110, float r111, boolean r112) {
        if (this.mContext.getEnableEventRefactor() == false) goto L20;
        Iterator<LynxBaseUI> r100 = this.mChildren.iterator();
    L6:
        if (r100.hasNext() == false) goto L19;
        LynxBaseUI r101 = r100.next();
        if ((r101 instanceof UIShadowProxy) == false) goto L10;
        r101 = ((UIShadowProxy) r101).f382373a;
    L10:
        float[] r102 = getTargetPoint(r110, r111, getScrollX(), getScrollY(), r101.getRectWithoutTransform(), r101.getTransformMatrix());
        if (r112 == true) goto L15;
        if (r101.isUserInteractionEnabled() == false) goto L6;
    L15:
        if (r101.getVisibility() == false) goto L6;
        if (r101.containsPoint(r102[0], r102[1], r112) == false) goto L6;
        return true;
    L19:
        return false;
    L20:
        float r113 = ((r110 + getScrollX()) - getOriginLeft()) - getTranslationX();
        float r114 = ((r111 + getScrollY()) - getOriginTop()) - getTranslationY();
        Iterator<LynxBaseUI> r103 = this.mChildren.iterator();
    L22:
        if (r103.hasNext() == false) goto L32;
        LynxBaseUI r104 = r103.next();
        if (r112 == true) goto L28;
        if (r104.isUserInteractionEnabled() == false) goto L22;
    L28:
        if (r104.getVisibility() == false) goto L22;
        if (r104.containsPoint(r113, r114, r112) == false) goto L22;
        return true;
    L32:
        return false;
    }

    public String constructListStateCacheKey(String r100, String r101, String r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append("_");
        r103.append(r101);
        r103.append("_");
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        r103.append(r102);
        return r103.toString();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean containsPoint(float r100, float r110, boolean r111) {
        float r101 = getTouchSlop();
        boolean r102 = false;
        if (this.mContext.getEnableEventRefactor() == false) goto L32;
        float r103 = -r101;
        float r104 = r103 - this.mHitSlopLeft;
        float r105 = (this.mWidth + r101) + this.mHitSlopRight;
        float r106 = r103 - this.mHitSlopTop;
        float r107 = (this.mHeight + r101) + this.mHitSlopBottom;
        if (r104 <= r100) goto L7;
    L13:
        if (r102 == false) goto L15;
        return r102;
    L15:
        if (getOverflow() != 0) goto L17;
        return r102;
    L17:
        if (getOverflow() != 1) goto L24;
        if (r110 >= r106) goto L21;
    L22:
        return r102;
    L21:
        if (r110 > r107) goto L22;
    L31:
        return childrenContainPoint(r100, r110, r111);
    L24:
        if (getOverflow() != 2) goto L31;
        if (r100 >= r104) goto L28;
    L29:
        return r102;
    L28:
        if (r100 <= r105) goto L31;
    L7:
        if (r105 < r100) goto L13;
        if (r106 > r110) goto L13;
        if (r107 < r110) goto L13;
        r102 = true;
        goto L13
    L32:
        Rect r108 = getRect();
        if ((r108.left - r101) < r100) goto L35;
    L41:
        if (r102 == false) goto L43;
        return r102;
    L43:
        if (getOverflow() != 0) goto L45;
        return r102;
    L45:
        if (getOverflow() != 1) goto L52;
        if ((r108.top - r101) < r110) goto L49;
    L50:
        return r102;
    L49:
        if ((r108.bottom + r101) <= r110) goto L50;
    L59:
        return childrenContainPoint(r100, r110, r111);
    L52:
        if (getOverflow() != 2) goto L59;
        if ((r108.left - r101) < r100) goto L56;
    L57:
        return r102;
    L56:
        if ((r108.right + r101) > r100) goto L59;
    L35:
        if ((r108.right + r101) <= r100) goto L41;
        if ((r108.top - r101) >= r110) goto L41;
        if ((r108.bottom + r101) <= r110) goto L41;
        r102 = true;
        goto L41
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.lynx.tasm.behavior.event.EventTarget] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.lynx.tasm.behavior.event.EventTarget] */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.lynx.tasm.behavior.event.EventTarget, com.lynx.tasm.behavior.ui.LynxBaseUI] */
    public EventTarget hitTest(float r110, float r111, boolean r210) {
        ArrayList r100 = new ArrayList();
        float r112 = r110;
        float r113 = r111;
        int r114 = this.mChildren.size() - 1;
        LynxBaseUI r115 = null;
    L3:
        if (r114 < 0) goto L41;
        LynxBaseUI r101 = (LynxBaseUI) ListProtector.get(this.mChildren, r114);
        if ((r101 instanceof UIShadowProxy) == false) goto L7;
        r101 = ((UIShadowProxy) r101).f382373a;
    L7:
        LynxBaseUI r116 = r101;
        if ((r116 instanceof UIComponent) == false) goto L14;
        UIComponent r102 = (UIComponent) r116;
        if (r102.getView() == null) goto L14;
        if (((com.lynx.tasm.behavior.ui.view.a) r102.getView()).getParent() != null) goto L14;
        boolean r103 = true;
    L15:
        if (r210 == true) goto L19;
        if (r116.isUserInteractionEnabled() == true) goto L19;
    L40:
        r114 = r114 - 1;
    L19:
        if (r116.getVisibility() == false) goto L40;
        if (r116.getDrawParent() != null) goto L23;
    L26:
        if (r103 == true) goto L40;
        float[] r104 = {r110, r111};
        if (this.mContext.getEnableEventRefactor() == false) goto L31;
        r104 = getTargetPoint(r104[0], r104[1], getScrollX(), getScrollY(), r116.getRectWithoutTransform(), r116.getTransformMatrix());
        boolean r105 = r116.containsPoint(r104[0], r104[1], r210);
    L32:
        if (r105 == false) goto L40;
        r100.add(r116);
        if (r116.isOnResponseChain() == true) goto L35;
        if (r115 != null) goto L38;
    L39:
        r112 = r104[0];
        r113 = r104[1];
        r115 = r116;
        goto L40
    L38:
        if (r115.getRealTimeTranslationZ() >= r116.getRealTimeTranslationZ()) goto L40;
    L35:
        float r106 = r104[0];
        float r107 = r104[1];
        float r108 = r106;
        r115 = r116;
    L42:
        if (r115 != null) goto L44;
        ?? r109 = this;
    L45:
        if (r109 == 0) goto L48;
        EventTarget.PointerEventsValue r117 = r109.pointerEvents();
        ?? r118 = r109;
        if (r117 == EventTarget.PointerEventsValue.None) goto L48;
    L49:
        if (r118 == 0) goto L52;
        return r118;
    L52:
        return this;
    L48:
        r118 = findHitTargetInSiblings(r100, r115, r110, r111, r210);
        goto L49
    L44:
        r109 = performHitTestOnTarget(r115, r110, r111, r108, r107, r210);
        goto L45
    L31:
        r105 = r116.containsPoint(r104[0], r104[1], r210);
        goto L32
    L23:
        if (((LynxUI) r116.getDrawParent()).getView() == null) goto L26;
        if (((LynxUI) r116.getDrawParent()).getView().getParent() == null) goto L40;
    L14:
        r103 = false;
        goto L15
    L41:
        r108 = r112;
        r107 = r113;
        goto L42
    }

    public void onListCellDisAppear(String r100, LynxBaseUI r101, boolean r102) {
        if (this.mBlockListEvent == false) goto L5;
        return;
    L5:
        Iterator<LynxBaseUI> r103 = this.mChildren.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r103.next().onListCellDisAppear(r100, r101, r102);
        goto L7
    }

    public void scrollIntoView(boolean r100, String r101, String r102) {
        scrollIntoView(r100, r101, r102, null);
    }

    public boolean updateDrawingLayoutInfo(int r100, int r101, Rect r102) {
        boolean r103 = true;
        if (this.mLeft == r100) goto L5;
        this.mLeft = r100;
        boolean r104 = true;
    L7:
        if (this.mTop == r101) goto L9;
        this.mTop = r101;
    L10:
        this.mBound = r102;
        if (r103 == false) goto L13;
        onDrawingPositionChanged();
    L13:
        return r103;
    L9:
        r103 = r104;
        goto L10
    L5:
        r104 = false;
        goto L7
    }

    private EventTarget performHitTestOnSibling(LynxBaseUI r100, float r101, float r102, boolean r103) {
        float[] r104 = calculateSiblingCoordinates(r100, r101, r102);
        float r105 = r104[0];
        float r106 = r104[1];
        if (r100.isCustomHittest() == true) goto L11;
        if (r100.needCustomLayout() == false) goto L11;
        if ((r100 instanceof UIGroup) == false) goto L11;
        UIGroup r107 = (UIGroup) r100;
        return r107.findUIWithCustomLayout(r105, r106, r107);
    L11:
        return r100.hitTest(r105, r106, r103);
    }

    public boolean calculateStickyTranslateWithOffset(int r110, boolean r111, int r210, int r211) {
        Sticky r100 = this.mSticky;
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r111 == false) goto L7;
        float r102 = ((RectF) r100).top;
        float r103 = ((RectF) r100).bottom;
        float r104 = r100.f382346d;
        float r105 = r100.f382348f;
        float r106 = getHeight();
        float r107 = this.mSticky.f382350h;
    L9:
        if (r104 >= 0.0f) goto L11;
        boolean r112 = true;
    L12:
        float r113 = r105 - r102;
        float r114 = r210;
        float r108 = ((r105 + r106) + r103) - r114;
        float r115 = r211;
        if (r113 >= r115) goto L15;
        boolean r116 = true;
    L17:
        if (r108 <= 0.0f) goto L19;
        boolean r117 = true;
    L20:
        if (r116 == true) goto L24;
        if (r117 == true) goto L24;
        Sticky r109 = this.mSticky;
        r109.f382343a = 0.0f;
        r109.f382344b = 0.0f;
        return true;
    L24:
        if (r116 == false) goto L30;
        if (r112 == true) goto L30;
        r115 = Math.min(((r104 + r107) - r102) - r106, r115);
        if (r115 <= r113) goto L29;
        r116 = true;
        goto L30
    L29:
        r116 = false;
    L30:
        if (r117 == false) goto L36;
        if (r112 == true) goto L36;
        float r118 = Math.max(((r107 + r106) + r103) - r114, 0.0f);
        if (r118 >= r108) goto L35;
        r101 = true;
    L35:
        r117 = r101;
    L37:
        if (r116 == false) goto L40;
        if (r117 == false) goto L40;
        r108 = Math.min(r108, r113);
    L40:
        if (r117 == false) goto L44;
        float r119 = r110;
        if (r119 >= r108) goto L44;
        float r120 = Math.max(r119, r118) - r108;
    L49:
        if (r111 == false) goto L51;
        Sticky r121 = this.mSticky;
        r121.f382343a = 0.0f;
        r121.f382344b = r120;
    L52:
        return true;
    L51:
        Sticky r122 = this.mSticky;
        r122.f382343a = r120;
        r122.f382344b = 0.0f;
    L44:
        if (r116 == false) goto L48;
        float r123 = r110;
        if (r123 <= r113) goto L48;
        r120 = Math.min(r123, r115) - r113;
    L48:
        r120 = 0.0f;
    L36:
        r118 = 0.0f;
        goto L37
    L19:
        r117 = false;
        goto L20
    L15:
        r116 = false;
        goto L17
    L11:
        r112 = false;
        goto L12
    L7:
        r102 = ((RectF) r100).left;
        r103 = ((RectF) r100).right;
        r104 = r100.f382345c;
        r105 = r100.f382347e;
        r106 = getWidth();
        r107 = this.mSticky.f382349g;
        goto L9
    }

    public TransOffset getTransformValue(float r100, float r101, float r102, float r110) {
        TransOffset r103 = new TransOffset(this);
        r103.left_top = getLocationOnScreen(new float[]{r100, r102});
        r103.right_top = getLocationOnScreen(new float[]{this.mWidth + r101, r102});
        r103.right_bottom = getLocationOnScreen(new float[]{this.mWidth + r101, this.mHeight + r110});
        r103.left_bottom = getLocationOnScreen(new float[]{r100, this.mHeight + r110});
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void scrollIntoView(boolean r100, String r101, String r102, Callback r103) {
        Boolean r104 = Boolean.FALSE;
        LynxBaseUI r105 = (LynxBaseUI) getParent();
    L3:
        if (r105 == null) goto L16;
        if ((r105 instanceof AbsLynxUIScroll) == true) goto L6;
        if ((r105 instanceof LynxUIScrollViewInternal) == true) goto L9;
        r105 = (LynxBaseUI) r105.getParent();
        goto L3
    L9:
        LynxUIScrollViewInternal r106 = (LynxUIScrollViewInternal) r105;
        if (((LynxBaseScrollView) r106.getView()).f382969c == true) goto L13;
        r101 = r102;
    L13:
        r106.N(this, r100, r101);
        r104 = Boolean.TRUE;
        goto L16
    L6:
        ((AbsLynxUIScroll) r105).M(this, r100, r101, r102);
        r104 = Boolean.TRUE;
    L16:
        if (r104.booleanValue() == true) goto L20;
        LLog.e(TAG, "scrollIntoView failed for nodeId:" + getSign());
        if (r103 == null) goto L26;
        r103.invoke(new Object[]{8, "scrollIntoView failed for nodeId:" + getSign()});
        return;
    L26:
        return;
    L20:
        if (r103 == null) goto L28;
        r103.invoke(new Object[]{0});
        return;
    }

    private EventTarget findHitTargetInSiblings(List<EventTarget> r100, EventTarget r101, float r102, float r103, boolean r104) {
        int r105 = 0;
    L4:
        if (r105 >= r100.size()) goto L16;
        LynxBaseUI r106 = (LynxBaseUI) ListProtector.get(r100, r105);
        if (r106 == null) goto L15;
        if (r106 == r101) goto L15;
        EventTarget r107 = performHitTestOnSibling(r106, r102, r103, r104);
        if (r107 == null) goto L15;
        if (r107.pointerEvents() == EventTarget.PointerEventsValue.None) goto L15;
        return r107;
    L15:
        r105 = r105 + 1;
        goto L4
    L16:
        return null;
    }

    private EventTarget performCustomLayoutHitTest(UIGroup r100, float r101, float r102, float r103, float r104) {
        if (this.mContext.getEnableEventRefactor() == false) goto L7;
        return r100.findUIWithCustomLayout(r103, r104, r100);
    L7:
        return r100.findUIWithCustomLayout(r101 - r100.getOriginLeft(), r102 - r100.getOriginTop(), r100);
    }

    public void convertToMeaningfulPaintingAreaRecursive(int r100, int r101, int r110, int r111, ArrayList<e> r112) {
        int r102 = r100 + getOriginLeft();
        int r103 = r101 + getOriginTop();
        if (r102 >= r110) goto L21;
        if (r103 >= r111) goto L28;
        e r104 = convertToMeaningfulPaintingArea(r102, r103);
        if (r104 == null) goto L9;
        r112.add(r104);
    L9:
        List<LynxBaseUI> r105 = this.mChildren;
        if (r105 != null) goto L12;
        return;
    L12:
        if (r105.size() <= 0) goto L29;
        Iterator<LynxBaseUI> r106 = this.mChildren.iterator();
    L16:
        if (r106.hasNext() == false) goto L30;
        LynxBaseUI r107 = r106.next();
        if (r107 == null) goto L16;
        r107.convertToMeaningfulPaintingAreaRecursive(r102, r103, r110, r111, r112);
        goto L16
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    private EventTarget performHitTestOnTarget(LynxBaseUI r100, float r101, float r110, float r111, float r112, boolean r113) {
        if (r100.isCustomHittest() == true) goto L11;
        if (r100.needCustomLayout() == false) goto L11;
        if ((r100 instanceof UIGroup) == false) goto L11;
        return performCustomLayoutHitTest((UIGroup) r100, r101, r110, r111, r112);
    L11:
        return performStandardHitTest(r100, r101, r110, r111, r112, r113);
    }

    private EventTarget performStandardHitTest(LynxBaseUI r100, float r101, float r102, float r103, float r104, boolean r105) {
        if (this.mContext.getEnableEventRefactor() == false) goto L7;
        return r100.hitTest(r103, r104, r105);
    L7:
        return r100.hitTest(((r101 + r100.getScrollX()) - r100.getOriginLeft()) - r100.getTranslationX(), ((r102 + r100.getScrollY()) - r100.getOriginTop()) - r100.getTranslationY(), r105);
    }

    public float[] getTargetPoint(float r100, float r101, int r102, int r103, Rect r104, Matrix r105) {
        float[] r106 = {(r100 + r102) - r104.left, (r101 + r103) - r104.top};
        Matrix r107 = getHitTestMatrix();
        if (r105.invert(r107) == false) goto L5;
        float[] r108 = {r106[0], r106[1]};
        r107.mapPoints(r108);
        r106[0] = r108[0];
        r106[1] = r108[1];
    L6:
        return r106;
    L5:
        r106[0] = Float.MAX_VALUE;
        r106[1] = Float.MAX_VALUE;
        goto L6
    }

    public float[] getTargetPoint(float r100, float r101, int r110, int r111, View r112, Matrix r113) {
        return getTargetPoint(r100, r101, r110, r111, new Rect(r112.getLeft(), r112.getTop(), 0, 0), r113);
    }

    public void updateLayout(int r110, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, Rect r311) {
        updateLayoutInfo(r110, r210, r211, r212, r213, r214, r215, r216, 0, 0, 0, 0, r217, r218, r219, r310, r311);
        onLayoutUpdated();
    }

    public void updateLayout(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, Rect r119) {
        this.mSkipLayoutUpdated = true;
        updateLayoutInfo(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
        this.mSkipLayoutUpdated = false;
        onLayoutUpdated();
        sendLayoutChangeEvent();
    }

    public void updateLayoutInfo(int r100, int r101, int r102, int r103, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, int r211, Rect r212) {
        LynxContext r104 = this.mContext;
        if (r104 == null) goto L18;
        if (r104.isTouchMoving() == false) goto L18;
        if (Float.compare(this.mWidth, 0.0f) == 0) goto L18;
        if (Float.compare(this.mHeight, 0.0f) == 0) goto L18;
        if (Float.compare(this.mLeft, r100) != 0) goto L16;
        if (Float.compare(this.mTop, r101) == 0) goto L18;
    L16:
        this.mContext.onPropsChanged(this);
    L18:
        setPosition(r100, r101);
        this.mWidth = r102;
        this.mHeight = r103;
        this.mPaddingLeft = r110;
        this.mPaddingRight = r112;
        this.mPaddingBottom = r113;
        this.mPaddingTop = r111;
        this.mMarginLeft = r114;
        this.mMarginTop = r115;
        this.mMarginRight = r116;
        this.mMarginBottom = r117;
        this.mBorderTopWidth = r119;
        this.mBorderBottomWidth = r211;
        this.mBorderLeftWidth = r118;
        this.mBorderRightWidth = r210;
        this.mBound = r212;
    }
}
