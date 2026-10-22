package com.lynx.tasm.behavior;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RenderNode;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClientV2;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.render.NativePaintingContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.frame.LynxFrameView;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.LynxLayoutProxy;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.fluency.FluencyTraceHelper;
import com.lynx.tasm.fontface.FontFace;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.q1;
import com.lynx.tasm.recording.LynxFrameRecorder;
import com.lynx.tasm.service.ILynxTextService;
import com.lynx.tasm.t1;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public abstract class LynxContext extends r implements i {
    public static final int INSTANCE_ID_DEFAULT = -1;
    private static final String TAG = "LynxContext";
    private static final String UIAPPEAREVENT = "uiappear";
    private static final String UIDISAPPEAREVENT = "uidisappear";
    private static ILynxTextService sLynxTextService = null;
    private static boolean sSupportUsageHint = true;
    private int embeddedMode;
    private w7a.a.b fontLoader;
    private f8a.a genericResourceFetcher;
    private boolean hasCustomGenericFetcher;
    private boolean hasCustomMediaFetcher;
    private boolean hasCustomTemplateFetcher;
    private boolean isFallbackProcess;
    private com.lynx.tasm.group.d lynxViewGroup;
    private m mAsyncImageInterceptor;
    private WeakReference<UIBody.UIBodyView> mBodyView;
    private final Map<String, ReadableMap> mCSSFontFaces;
    private JavaOnlyMap mCSSKeyframes;
    private h mClaySnapshotProvider;
    private Map<String, Object> mContextData;
    private boolean mEnableAsyncImageCallback;
    private Boolean mEnableAsyncLoadImage;
    private boolean mEnableAutoExpose;
    private boolean mEnableEngineReuse;
    private boolean mEnableImageResourceHint;
    private boolean mEnableImageSmallDiskCache;
    private boolean mEnableVSyncAligned;
    private EventEmitter mEventEmitter;
    private com.lynx.tasm.behavior.ui.h mExposure;
    private Map<String, com.lynx.jsbridge.d> mExtensionModules;
    private FluencyTraceHelper mFluencyTraceHelper;
    private Float mFontScale;
    private boolean mForceDarkAllowed;
    private boolean mForceImageAsyncRequest;
    private final LynxFrameRecorder.d mFrameCallback;
    private Object mFrescoCallerContext;
    private Map<String, String> mImageCustomParams;
    private v7a.h mImageFetcher;
    private m mImageInterceptor;
    private boolean mInPreLoad;
    private int mInstanceId;
    private WeakReference<d0> mIntersectionObserverManager;
    private String mJSGroupThreadName;
    private WeakReference<JSProxy> mJSProxy;
    private WeakReference<LynxLayoutProxy> mLayoutProxy;
    private boolean mLayoutThreadChanged;
    private com.lynx.tasm.g mListNodeInfoFetcher;
    private LynxBooleanOption mLongTaskMonitorEnabled;
    private Object mLynxExtraData;
    private t mLynxFrameViewProvider;
    private u7a.h mLynxImageConfig;
    private WeakReference<LynxUIOwner> mLynxUIOwner;
    private q1 mLynxViewClient;
    private WeakReference<LynxViewClientV2> mLynxViewClientV2;
    private t1 mPageConfig;
    private Map<String, FontFace> mParsedFontFace;
    private List<r0> mPatchFinishListeners;
    private WeakReference<PerformanceController> mPerfController;
    private int mPlatformMeasureHeightCache;
    private int mPlatformMeasureWidthCache;
    private boolean mPrefetchImageOnCreate;
    private WeakReference<v0> mShadowNodeOwnerRef;
    private Map<String, Object> mSharedData;
    private String mTemplateUrl;
    private b1 mTouchEventDispatcher;
    private UIBody mUIBody;
    private DisplayMetrics mVirtualScreenMetrics;
    private g8a.a mediaResourceFetcher;
    private d8a.f providerRegistry;
    private String tapSlop;
    private h8a.a templateResourceFetcher;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f381880a;

        @Override // java.lang.Runnable
        public final void run() {
            LynxViewClientV2 r100 = (LynxViewClientV2) this.f381880a.get();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.c();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(WeakReference r100) {
            this.f381880a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f381881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f381882b;

        @Override // java.lang.Runnable
        public final void run() {
            LynxViewClientV2 r100 = (LynxViewClientV2) this.f381881a.get();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a(this.f381882b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(WeakReference r100, JSONObject r101) {
            this.f381881a = r100;
            this.f381882b = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f381883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxContext f381884b;

        @Override // java.lang.Runnable
        public final void run() {
            LynxContext.access$100(this.f381884b).s(this.f381883a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(LynxContext r100, HashMap r101) {
            this.f381884b = r100;
            this.f381883a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxContext f381885a;

        @Override // java.lang.Runnable
        public final void run() {
            LynxContext.access$100(this.f381885a).p();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(LynxContext r100) {
            this.f381885a = r100;
        }
    }

    public static final class e implements LynxFrameRecorder.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LynxContext> f381886a;

        public e(LynxContext r100) {
            this.f381886a = new WeakReference(r100);
        }

        @Override // com.lynx.tasm.recording.LynxFrameRecorder.d
        public final void a(JSONObject r100) {
            LynxContext r101 = this.f381886a.get();
            if (r101 == null) goto L6;
            LynxContext.access$200(r101, r100);
            return;
        }
    }

    public static /* synthetic */ void a(LynxContext r100, int r101, com.lynx.tasm.base.e r102) {
        r100.lambda$findShadowNodeAndRunTask$0(r101, r102);
    }

    public h getClaySnapshotProvider() {
        return null;
    }

    public boolean getEnableAutoConcurrency() {
        return false;
    }

    public v7a.h getImageFetcher() {
        return null;
    }

    public t getLynxFrameViewProvider() {
        return null;
    }

    public u7a.h getLynxImageConfig() {
        return null;
    }

    public String getLynxSessionID() {
        return "";
    }

    public abstract void handleException(Exception r100);

    public void handleException(Exception r100, int r101) {
    }

    public void handleException(Exception r100, int r101, JSONObject r102) {
    }

    public void handleException(Exception r100, JSONObject r101) {
    }

    public void handleLynxError(LynxError r100) {
    }

    public void setClaySnapshotProvider(h r100) {
    }

    public void setEnableAutoConcurrency(boolean r100) {
    }

    public void setImageFetcher(v7a.h r100) {
    }

    public void setLynxFrameViewProvider(t r100) {
    }

    public void setLynxImageConfig(u7a.h r100) {
    }

    private void syncFrameRecorderCallback() {
        int r100 = this.mInstanceId;
        if (r100 != (-1)) goto L5;
        return;
    L5:
        LynxFrameRecorder r101 = LynxFrameRecorder.f383583k;
        LynxFrameRecorder.d r102 = this.mFrameCallback;
        if (r102 != null) goto L8;
        r101.f383589f.remove(Integer.valueOf(r100));
        return;
    L8:
        r101.f383589f.put(Integer.valueOf(r100), r102);
    }

    public void EnsureEventDispatcher() {
        if (this.mTouchEventDispatcher == null) goto L5;
        return;
    L5:
        UIBody.UIBodyView r100 = getUIBodyView();
        if (r100 != null) goto L8;
        return;
    L8:
        ILynxUIRenderer r101 = r100.getLynxUIRendererInternal();
        if (r101 != null) goto L11;
        return;
    L11:
        if ((r101 instanceof LynxUIRenderer) == false) goto L15;
        ((LynxUIRenderer) r101).a();
        return;
    }

    public void clearExposure() {
        com.lynx.tasm.behavior.ui.h r100 = this.mExposure;
        if (r100 == null) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.behavior.ui.i(r100));
        return;
    }

    public void destory() {
        com.lynx.tasm.behavior.ui.h r100 = this.mExposure;
        if (r100 == null) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.behavior.ui.i(r100));
    L6:
        if (getEnableNewIntersectionObserver() == false) goto L13;
        WeakReference<d0> r101 = this.mIntersectionObserverManager;
        if (r101 == null) goto L14;
        d0 r102 = r101.get();
        if (r102 == null) goto L15;
        UIThreadUtils.runOnUiThreadImmediately(new c0(r102));
        return;
    L15:
        return;
    L14:
        return;
    }

    public boolean enableEventThrough() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383777b;
    }

    public boolean getAutoExpose() {
        if (this.mEnableAutoExpose == false) goto L10;
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L9;
        LLog.e(TAG, "PageConfig is null.GetAutoExpose get default true!");
        return true;
    L9:
        return r100.f383776a;
    L10:
        return false;
    }

    public boolean getCssAlignWithLegacyW3c() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383791p;
    }

    public boolean getDefaultOverflowVisible() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383778c;
    }

    public boolean getDefaultTextIncludePadding() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.A;
    }

    public boolean getEnableAutoNonFlatten() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.X;
    }

    public boolean getEnableCreateViewAsync() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383789n;
    }

    public boolean getEnableDisexposureWhenLynxHidden() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.C;
    }

    public boolean getEnableEventRefactor() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.B;
    }

    public boolean getEnableExposureUIMargin() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.M;
    }

    public boolean getEnableExposureWhenLayout() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.D;
    }

    public boolean getEnableExposureWhenReload() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.E;
    }

    public boolean getEnableFiberArch() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383775J;
    }

    public boolean getEnableFlattenTranslateZ() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.F;
    }

    public boolean getEnableLoadImageFromService() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.f383785j;
    }

    public double getEnableLynxScrollFluency() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return -1.0d;
    L5:
        return r100.P;
    }

    public boolean getEnableNativeInteraction() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.V;
    }

    public boolean getEnableNewIntersectionObserver() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.I;
    }

    public boolean getEnableNewSticky() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.T;
    }

    public boolean getEnableTransformedTouchPosition() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.S;
    }

    public boolean getEnableVsyncAlignedFlush() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383790o;
    }

    public FluencyTraceHelper getFluencyTraceHelper() {
        if (this.mFluencyTraceHelper != null) goto L6;
        this.mFluencyTraceHelper = new FluencyTraceHelper(this);
    L6:
        return this.mFluencyTraceHelper;
    }

    public float getFontScale() {
        if (this.mFontScale != null) goto L6;
        this.mFontScale = Float.valueOf(getResources().getConfiguration().fontScale);
    L6:
        return this.mFontScale.floatValue();
    }

    public f8a.a getGenericResourceFetcher() {
        if (this.hasCustomGenericFetcher == false) goto L7;
        return null;
    L7:
        return this.genericResourceFetcher;
    }

    public d0 getIntersectionObserverManager() {
        WeakReference<d0> r100 = this.mIntersectionObserverManager;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public int getLongPressDuration() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.N;
    }

    public com.lynx.tasm.behavior.ui.accessibility.d getLynxAccessibilityWrapper() {
        UIBody r100 = this.mUIBody;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getLynxAccessibilityWrapper();
    }

    public LynxUIOwner getLynxUIOwner() {
        return this.mLynxUIOwner.get();
    }

    public int getMapContainerType() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.O;
    }

    public g8a.a getMediaResourceFetcher() {
        if (this.hasCustomMediaFetcher == false) goto L7;
        return null;
    L7:
        return this.mediaResourceFetcher;
    }

    public int getObserverFrameRate() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return 20;
    L5:
        return r100.L;
    }

    public String getPageVersion() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L7;
        LLog.e(TAG, "PageConfig is null.GetPageVersion get default error;");
        return "error";
    L7:
        return r100.f383779d;
    }

    public PerformanceController getPerfController() {
        WeakReference<PerformanceController> r100 = this.mPerfController;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public Long getRuntimeId() {
        JSProxy r100 = this.mJSProxy.get();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r100.f383237b);
    }

    public h8a.a getTemplateResourceFetcher() {
        if (this.hasCustomTemplateFetcher == false) goto L7;
        return null;
    L7:
        return this.templateResourceFetcher;
    }

    public UIBody.UIBodyView getUIBodyView() {
        WeakReference<UIBody.UIBodyView> r100 = this.mBodyView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public void initUIExposure() {
        this.mExposure = new com.lynx.tasm.behavior.ui.h();
        LynxUIOwner r100 = this.mLynxUIOwner.get();
        if (r100 == null) goto L17;
        com.lynx.tasm.behavior.ui.h r101 = this.mExposure;
        UIBody r102 = r100.getRootUI();
        r101.getClass();
        r101.f382006a = new WeakReference(r102);
        if (r102 == null) goto L7;
        LynxContext r103 = r102.getLynxContext();
    L8:
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        r101.A = r104;
        if (r104 == true) goto L17;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.behavior.ui.i(r101));
        goto L17
    L10:
        if (r103.isFragmentLayerRenderOn() == false) goto L13;
        r104 = false;
        goto L14
    L7:
        r103 = null;
    L17:
        WeakReference r105 = new WeakReference(this);
        com.lynx.tasm.behavior.ui.h r106 = this.mExposure;
        r106.B = new com.lynx.tasm.behavior.ui.h.d(r105);
        r106.l(this);
    }

    public boolean isAsyncInitTTVideoEngine() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383787l;
    }

    public boolean isAsyncRedirect() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383780e;
    }

    public boolean isEmbeddedModeOn() {
        if ((this.embeddedMode & 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isEnableAsyncLoadImage() {
        Boolean r100 = this.mEnableAsyncLoadImage;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isEnableAsyncRequestImage() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383783h;
    }

    public boolean isEnableCheckLocalImage() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.f383782g;
    }

    public boolean isEnableNewGesture() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.G;
    }

    public boolean isFragmentLayerRenderOn() {
        if ((this.embeddedMode & 8) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLayoutInElementModeOn() {
        if ((this.embeddedMode & 12) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNewClipModeEnabled() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383800y;
    }

    public boolean isSyncImageAttach() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.f383781f;
    }

    public boolean isTextBoringLayoutEnabled() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383799x;
    }

    public boolean isTextLayoutCacheEnabled() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.R;
    }

    public boolean isTextOverflowEnabled() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383798w;
    }

    public boolean isTextRefactorEnabled() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383797v;
    }

    public boolean isTextServiceModeOn() {
        if ((this.embeddedMode & 16) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTouchMoving() {
        b1 r100 = this.mTouchEventDispatcher;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f381983q;
    }

    public boolean isUseImagePostProcessor() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383784i;
    }

    public boolean isUseNewSwiper() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383786k;
    }

    public void onAttachedToWindow() {
        com.lynx.tasm.behavior.ui.h r100 = this.mExposure;
        if (r100 == null) goto L6;
        r100.j();
        return;
    }

    public void onGestureRecognized() {
        b1 r100 = this.mTouchEventDispatcher;
        if (r100 == null) goto L8;
        r100.f381985s = true;
        if (r100.f381974h.isEmpty() == true) goto L9;
        r100.g(8);
        return;
    L9:
        return;
    }

    public void reset() {
        Map<String, ReadableMap> r100 = this.mCSSFontFaces;
        monitor-enter(r100);
        this.mCSSFontFaces.clear();     // Catch: Throwable -> L20
        monitor-exit(r100);     // Catch: Throwable -> L20
        b1 r101 = this.mTouchEventDispatcher;
        if (r101 == null) goto L9;
        r101.f381969c = null;
        r101.f381975i = null;
        r101.f381976j.clear();
    L9:
        com.lynx.tasm.behavior.ui.h r102 = this.mExposure;
        if (r102 == null) goto L13;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.behavior.ui.i(r102));
    L13:
        if (getEnableNewIntersectionObserver() == false) goto L25;
        WeakReference<d0> r103 = this.mIntersectionObserverManager;
        if (r103 == null) goto L26;
        d0 r104 = r103.get();
        if (r104 == null) goto L27;
        UIThreadUtils.runOnUiThreadImmediately(new c0(r104));
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void resumeExposure() {
        if (this.mExposure == null) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new d(this));
        return;
    }

    public boolean useRelativeKeyboardHeightApi() {
        t1 r100 = this.mPageConfig;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.f383801z;
    }

    public boolean enableEventReporter() {
        return !isEmbeddedModeOn();
    }

    public boolean enableTiming() {
        return !isEmbeddedModeOn();
    }

    @Override // com.lynx.tasm.behavior.r
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public LynxBaseInspectorOwner getBaseInspectorOwner() {
        LynxView r100 = getLynxView();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBaseInspectorOwner();
    }

    public UIBody.UIBodyView getBodyView() {
        return getUIBodyView();
    }

    @Override // com.lynx.tasm.behavior.r
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public LynxView getLynxView() {
        UIBody.UIBodyView r100 = getUIBodyView();
        if ((r100 instanceof LynxView) == false) goto L7;
        return (LynxView) r100;
    L7:
        if ((r100 instanceof LynxFrameView) == true) goto L9;
        return null;
    L9:
        return ((LynxFrameView) r100).getRootView();
    }

    public m getAsyncImageInterceptor() {
        return this.mAsyncImageInterceptor;
    }

    public Map getContextData() {
        return this.mContextData;
    }

    public boolean getEnableImageResourceHint() {
        return this.mEnableImageResourceHint;
    }

    public boolean getEnableImageSmallDiskCache() {
        return this.mEnableImageSmallDiskCache;
    }

    public boolean getEnableVSyncAligned() {
        return this.mEnableVSyncAligned;
    }

    public EventEmitter getEventEmitter() {
        return this.mEventEmitter;
    }

    public com.lynx.tasm.behavior.ui.h getExposure() {
        return this.mExposure;
    }

    public Map<String, com.lynx.jsbridge.d> getExtensionModules() {
        return this.mExtensionModules;
    }

    public w7a.a.b getFontLoader() {
        return this.fontLoader;
    }

    public boolean getForceDarkAllowed() {
        return this.mForceDarkAllowed;
    }

    public Object getFrescoCallerContext() {
        return this.mFrescoCallerContext;
    }

    public Map<String, String> getImageCustomParam() {
        return this.mImageCustomParams;
    }

    public int getInstanceId() {
        return this.mInstanceId;
    }

    public String getJSGroupThreadName() {
        return this.mJSGroupThreadName;
    }

    public com.lynx.tasm.g getListNodeInfoFetcher() {
        return this.mListNodeInfoFetcher;
    }

    public LynxBooleanOption getLongTaskMonitorEnabled() {
        return this.mLongTaskMonitorEnabled;
    }

    public Object getLynxExtraData() {
        return this.mLynxExtraData;
    }

    public q1 getLynxViewClient() {
        return this.mLynxViewClient;
    }

    public List<r0> getPatchFinishListeners() {
        return this.mPatchFinishListeners;
    }

    public int getPlatformMeasureHeightCache() {
        return this.mPlatformMeasureHeightCache;
    }

    public int getPlatformMeasureWidthCache() {
        return this.mPlatformMeasureWidthCache;
    }

    public d8a.f getProviderRegistry() {
        return this.providerRegistry;
    }

    public com.lynx.tasm.group.d getRuntimeCacheManager() {
        return this.lynxViewGroup;
    }

    public DisplayMetrics getScreenMetrics() {
        return this.mVirtualScreenMetrics;
    }

    public String getTapSlop() {
        return this.tapSlop;
    }

    public String getTemplateUrl() {
        return this.mTemplateUrl;
    }

    public ILynxTextService getTextService() {
        return sLynxTextService;
    }

    public b1 getTouchEventDispatcher() {
        return this.mTouchEventDispatcher;
    }

    public UIBody getUIBody() {
        return this.mUIBody;
    }

    public boolean hasLayoutThreadChanged() {
        return this.mLayoutThreadChanged;
    }

    public m imageInterceptor() {
        return this.mImageInterceptor;
    }

    public boolean isEnableAsyncImageCallback() {
        return this.mEnableAsyncImageCallback;
    }

    public boolean isEnginePoolEnabled() {
        return this.mEnableEngineReuse;
    }

    public boolean isFallbackProcess() {
        return this.isFallbackProcess;
    }

    public boolean isForceImageAsyncRequest() {
        return this.mForceImageAsyncRequest;
    }

    public boolean isInPreLoad() {
        return this.mInPreLoad;
    }

    public boolean isPrefetchImageOnCreate() {
        return this.mPrefetchImageOnCreate;
    }

    public static /* synthetic */ com.lynx.tasm.behavior.ui.h access$100(LynxContext r100) {
        return r100.mExposure;
    }

    private void notifyLynxFrame(JSONObject r100) {
        WeakReference<LynxViewClientV2> r101 = this.mLynxViewClientV2;
        if (r101 != null) goto L5;
        return;
    L5:
        LynxEventReporter.runOnReportThread(new b(r101, r100));
    }

    public void addUIToExposedMap(LynxBaseUI r100) {
        addUIToExposedMap(r100, null, null, null);
    }

    public LynxBaseUI findLynxUIByComponentId(String r100) {
        LynxUIOwner r101 = this.mLynxUIOwner.get();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.findLynxUIByComponentId(r100);
    }

    public LynxBaseUI findLynxUIByName(String r100) {
        LynxUIOwner r101 = this.mLynxUIOwner.get();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.findLynxUIByName(r100);
    }

    public LynxBaseUI findLynxUIBySign(int r100) {
        LynxUIOwner r101 = this.mLynxUIOwner.get();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getNode(r100);
    }

    public ShadowNode findShadowNodeBySign(int r100) {
        v0 r101 = this.mShadowNodeOwnerRef.get();
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.f383208g.a(r100);
    }

    public com.lynx.jsbridge.d getExtensionModuleByKey(String r100) {
        return this.mExtensionModules.get(r100);
    }

    public FontFace getFontFace(String r100) {
        String[] r101 = r100.split(",");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L26;
        String r104 = com.lynx.tasm.utils.c.d(r101[r103]);
        if (TextUtils.isEmpty(r104) == true) goto L20;
        monitor-enter(com.lynx.tasm.utils.c.class);
    L23:
        th = move-exception;
        throw th;
    L10:
        if (this.mParsedFontFace != null) goto L12;
        this.mParsedFontFace = new HashMap();     // Catch: Throwable -> L23
    L12:
        FontFace r105 = this.mParsedFontFace.get(r104);     // Catch: Throwable -> L23
        if (r105 != null) goto L21;
        FontFace r106 = com.lynx.tasm.utils.c.b(this, r104);     // Catch: Throwable -> L23
        if (r106 != null) goto L16;
        monitor-exit(com.lynx.tasm.utils.c.class);     // Catch: Throwable -> L23
        goto L20
    L16:
        this.mParsedFontFace.put(r104, r106);     // Catch: Throwable -> L23
        monitor-exit(com.lynx.tasm.utils.c.class);     // Catch: Throwable -> L23
        return r106;
    L21:
        monitor-exit(com.lynx.tasm.utils.c.class);     // Catch: Throwable -> L23
        return r105;
    L20:
        r103 = r103 + 1;     // Catch: Throwable -> L23
        goto L3
    L26:
        return null;
    }

    public Map getFontFaces(String r100) {
        Map<String, ReadableMap> r101 = this.mCSSFontFaces;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mCSSFontFaces.containsKey(r100) == false) goto L7;
        ReadableMap r102 = this.mCSSFontFaces.get(r100);     // Catch: Throwable -> L14
    L8:
        if (r102 == null) goto L12;
        HashMap<String, Object> r103 = r102.asHashMap();     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        return r103;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return null;
    L7:
        r102 = null;
        goto L8
    }

    public com.lynx.jsbridge.c getJSModule(String r100) {
        WeakReference<JSProxy> r101 = this.mJSProxy;
        if (r101 != null) goto L5;
        return null;
    L5:
        JSProxy r102 = r101.get();
        if (r102 != null) goto L8;
        return null;
    L8:
        return new com.lynx.jsbridge.c(r100, r102);
    }

    public ReadableMap getKeyframes(String r100) {
        JavaOnlyMap r101 = this.mCSSKeyframes;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.hasKey(r100) == true) goto L8;
        return null;
    L8:
        return this.mCSSKeyframes.getMap(r100);
    }

    public Object getSharedData(String r100) {
        Map<String, Object> r101 = this.mSharedData;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public void markFallbackProcess(boolean r100) {
        this.isFallbackProcess = r100;
        if (r100 == false) goto L5;
        return;
    L5:
        if (getUIBodyView() == null) goto L9;
        getUIBodyView().clearNodeIndexImageMap();
        getUIBodyView().markNeedRemoveExistingViews();
        getUIBodyView().removeExistingViews();
        return;
    }

    public void notifyResourceLoaded(LynxViewClientV2.a r100) {
        WeakReference<LynxViewClientV2> r101 = this.mLynxViewClientV2;
        if (r101 != null) goto L5;
        return;
    L5:
        LynxEventReporter.runOnReportThread(new a(r101));
    }

    public void onGestureRecognized(LynxBaseUI r100) {
        b1 r101 = this.mTouchEventDispatcher;
        if (r101 == null) goto L8;
        HashSet<Integer> r102 = r101.f381987u;
        if (r102 == null) goto L9;
        r102.add(Integer.valueOf(r100.getSign()));
        return;
    L9:
        return;
    }

    public void onPageConfigDecoded(t1 r100) {
        this.mPageConfig = r100;
        PerformanceController r101 = getPerfController();
        if (r101 == null) goto L9;
        if (r100 != null) goto L6;
        Boolean r102 = null;
    L7:
        r101.f383538j = r102;
        return;
    L6:
        r102 = Boolean.valueOf(r100.Q);
        goto L7
    }

    public void onPropsChanged(LynxBaseUI r100) {
        b1 r101 = this.mTouchEventDispatcher;
        if (r101 == null) goto L8;
        HashSet<Integer> r102 = r101.f381988v;
        if (r102 == null) goto L9;
        r102.add(Integer.valueOf(r100.getSign()));
        return;
    L9:
        return;
    }

    public void onRootViewDraw(Canvas r100) {
        com.lynx.tasm.behavior.ui.h r101 = this.mExposure;
        if (r101 == null) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new f0(r101));
    L6:
        if (getEnableNewIntersectionObserver() == false) goto L13;
        WeakReference<d0> r102 = this.mIntersectionObserverManager;
        if (r102 == null) goto L14;
        d0 r103 = r102.get();
        if (r103 == null) goto L15;
        UIThreadUtils.runOnUiThreadImmediately(new f0(r103));
        return;
    L15:
        return;
    L14:
        return;
    }

    public void registerPatchFinishListener(r0 r100) {
        if (this.mPatchFinishListeners != null) goto L5;
        this.mPatchFinishListeners = new ArrayList();
    L5:
        this.mPatchFinishListeners.add(r100);
    }

    public void removeAnimationKeyframe(String r100) {
        JavaOnlyMap r101 = this.mCSSKeyframes;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeUIFromExposedMap(LynxBaseUI r100) {
        removeUIFromExposedMap(r100, null);
    }

    public void reportModuleCustomError(String r100) {
        this.mLynxViewClient.onReceivedError(new LynxError(r100, 99800));
    }

    public void reportResourceError(String r100) {
        q1 r101 = this.mLynxViewClient;
        if (r101 == null) goto L6;
        r101.onReceivedError(new LynxError(r100, 39800));
        return;
    }

    public void runOnJSThread(Runnable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSProxy r101 = this.mJSProxy.get();
        if (r101 != null) goto L7;
        return;
    L7:
        r101.h(r100);
    }

    public void runOnLayoutThread(Runnable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        WeakReference<LynxLayoutProxy> r101 = this.mLayoutProxy;
        if (r101 != null) goto L7;
        return;
    L7:
        LynxLayoutProxy r102 = r101.get();
        if (r102 != null) goto L10;
        return;
    L10:
        r102.c(r100);
    }

    public void runOnTasmThread(Runnable r100) {
        UIBody.UIBodyView r101 = getUIBodyView();
        if (r101 == null) goto L6;
        r101.runOnTasmThread(r100);
        return;
    }

    public void setAsyncImageInterceptor(m r100) {
        this.mAsyncImageInterceptor = r100;
    }

    @Override // com.lynx.tasm.behavior.r, android.content.MutableContextWrapper
    public /* bridge */ /* synthetic */ void setBaseContext(Context r100) {
        super.setBaseContext(r100);
    }

    public void setContextData(HashMap<String, Object> r100) {
        this.mContextData = r100;
    }

    public void setEmbeddedMode(int r100) {
        this.embeddedMode = r100;
    }

    public void setEnableAsyncImageCallback(boolean r100) {
        this.mEnableAsyncImageCallback = r100;
    }

    public void setEnableAsyncLoadImage(boolean r100) {
        this.mEnableAsyncLoadImage = Boolean.valueOf(r100);
    }

    public void setEnableAutoExpose(boolean r100) {
        this.mEnableAutoExpose = r100;
    }

    public void setEnableImageResourceHint(boolean r100) {
        this.mEnableImageResourceHint = r100;
    }

    public void setEnableImageSmallDiskCache(boolean r100) {
        this.mEnableImageSmallDiskCache = r100;
    }

    public void setEnableReuseEngine(boolean r100) {
        this.mEnableEngineReuse = r100;
    }

    public void setEnableVSyncAligned(boolean r100) {
        this.mEnableVSyncAligned = r100;
    }

    public void setEventEmitter(EventEmitter r100) {
        this.mEventEmitter = r100;
    }

    public void setFontFaces(ReadableMap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Map<String, ReadableMap> r101 = this.mCSSFontFaces;
        monitor-enter(r101);
        ReadableMapKeySetIterator r102 = r100.keySetIterator();     // Catch: Throwable -> L15
    L8:
        if (r102.hasNextKey() == false) goto L13;
        String r103 = r102.nextKey();     // Catch: Throwable -> L15
        ReadableMap r104 = r100.getMap(r103);     // Catch: Throwable -> L15
        if (r104 == null) goto L8;
        this.mCSSFontFaces.put(r103, r104);     // Catch: Throwable -> L15
        goto L8
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public void setFontLoader(w7a.a.b r100) {
        this.fontLoader = r100;
    }

    public void setForceDarkAllowed(boolean r100) {
        this.mForceDarkAllowed = r100;
        if (r100 == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L7;
        return;
    L7:
        if (sSupportUsageHint == true) goto L9;
        return;
    L9:
        if (LynxFlattenUI.sSetUsageHint == null) goto L15;
        return;
    L15:
        LynxFlattenUI.sSetUsageHint = RenderNode.class.getMethod("setUsageHint", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L13
        return;
    L13:
        sSupportUsageHint = false;
        LLog.e(TAG, "NoSuchMethodException: setUsageHint");
    }

    public void setForceImageAsyncRequest(boolean r100) {
        this.mForceImageAsyncRequest = r100;
    }

    public void setFrescoCallerContext(Object r100) {
        this.mFrescoCallerContext = r100;
    }

    public void setGenericResourceFetcher(f8a.a r100) {
        this.genericResourceFetcher = r100;
    }

    public void setHasCustomGenericFetcher(boolean r100) {
        LLog.i(TAG, "setHasCustomGenericFetcher: " + r100);
        this.hasCustomGenericFetcher = r100;
    }

    public void setHasCustomMediaFetcher(boolean r100) {
        LLog.i(TAG, "setHasCustomMediaFetcher: " + r100);
        this.hasCustomMediaFetcher = r100;
    }

    public void setHasCustomTemplateFetcher(boolean r100) {
        LLog.i(TAG, "setHasCustomTemplateFetcher: " + r100);
        this.hasCustomTemplateFetcher = r100;
    }

    public void setImageCustomParam(Map<String, String> r100) {
        this.mImageCustomParams = r100;
    }

    public void setImageInterceptor(m r100) {
        this.mImageInterceptor = r100;
    }

    public void setInPreLoad(boolean r100) {
        this.mInPreLoad = r100;
        EventEmitter r101 = this.mEventEmitter;
        if (r101 == null) goto L6;
        r101.setInPreLoad(r100);
        return;
    }

    public void setInstanceId(int r100) {
        int r101 = this.mInstanceId;
        if (r101 == (-1)) goto L6;
        if (r101 == r100) goto L6;
        LynxFrameRecorder r102 = LynxFrameRecorder.f383583k;
        r102.x(r101);
        int r103 = this.mInstanceId;
        r102.f383589f.remove(Integer.valueOf(r103));
    L6:
        this.mInstanceId = r100;
        if (isEmbeddedModeOn() == true) goto L10;
        syncFrameRecorderCallback();
        return;
    }

    public void setIntersectionObserverManager(d0 r100) {
        this.mIntersectionObserverManager = new WeakReference(r100);
    }

    public void setJSGroupThreadName(String r100) {
        this.mJSGroupThreadName = r100;
    }

    public void setJSProxy(JSProxy r100) {
        this.mJSProxy = new WeakReference(r100);
    }

    public void setKeyframes(ReadableMap r100) {
        if (this.mCSSKeyframes != null) goto L5;
        this.mCSSKeyframes = new JavaOnlyMap();
    L5:
        if (r100 == null) goto L8;
        this.mCSSKeyframes.merge(r100);
        return;
    }

    public void setLayoutProxy(LynxLayoutProxy r100) {
        this.mLayoutProxy = new WeakReference(r100);
    }

    public void setLayoutThreadChanged(boolean r100) {
        this.mLayoutThreadChanged = r100;
    }

    public void setListNodeInfoFetcher(com.lynx.tasm.g r100) {
        this.mListNodeInfoFetcher = r100;
    }

    public void setLongTaskMonitorEnabled(LynxBooleanOption r100) {
        this.mLongTaskMonitorEnabled = r100;
    }

    public void setLynxExtraData(Object r100) {
        this.mLynxExtraData = r100;
    }

    public void setLynxUIOwner(LynxUIOwner r100) {
        this.mLynxUIOwner = new WeakReference(r100);
    }

    public void setLynxView(LynxView r100) {
        setUIBodyView(r100);
    }

    public void setLynxViewClient(q1 r100) {
        this.mLynxViewClient = r100;
    }

    public void setLynxViewClientV2(LynxViewClientV2 r100) {
        this.mLynxViewClientV2 = new WeakReference(r100);
    }

    public void setMediaResourceFetcher(g8a.a r100) {
        this.mediaResourceFetcher = r100;
    }

    public void setPerfController(PerformanceController r100) {
        if (r100 == null) goto L5;
        this.mPerfController = new WeakReference(r100);
        return;
    }

    public void setPlatformMeasureHeightCache(int r100) {
        this.mPlatformMeasureHeightCache = r100;
    }

    public void setPlatformMeasureWidthCache(int r100) {
        this.mPlatformMeasureWidthCache = r100;
    }

    public void setPrefetchImageOnCreate(boolean r100) {
        this.mPrefetchImageOnCreate = r100;
    }

    public void setProviderRegistry(d8a.f r100) {
        this.providerRegistry = r100;
    }

    public void setRuntimeCacheManager(com.lynx.tasm.group.d r100) {
        this.lynxViewGroup = r100;
    }

    public void setShadowNodeOwner(v0 r100) {
        this.mShadowNodeOwnerRef = new WeakReference(r100);
    }

    public void setTapSlop(String r100) {
        this.tapSlop = r100;
    }

    public void setTemplateResourceFetcher(h8a.a r100) {
        this.templateResourceFetcher = r100;
    }

    public void setTemplateUrl(String r100) {
        this.mTemplateUrl = r100;
    }

    public void setTouchEventDispatcher(b1 r100) {
        this.mTouchEventDispatcher = r100;
    }

    public void setUIBody(UIBody r100) {
        this.mUIBody = r100;
    }

    public void setUIBodyView(UIBody.UIBodyView r100) {
        if (r100 == null) goto L4;
        boolean r101 = true;
    L5:
        setHasLynxViewAttached(r101);
        LLog.i("LynxUIRenderer", "lynxContext setUIBodyView" + r100 + this);
        this.mBodyView = new WeakReference(r100);
        return;
    L4:
        r101 = false;
        goto L5
    }

    public void stopExposure(HashMap<String, Object> r100) {
        if (this.mExposure == null) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new c(this, r100));
        return;
    }

    public void unregisterPatchFinishListener(r0 r100) {
        List<r0> r101 = this.mPatchFinishListeners;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void onGestureRecognized(int r100) {
        b1 r101 = this.mTouchEventDispatcher;
        if (r101 == null) goto L8;
        HashSet<Integer> r102 = r101.f381987u;
        if (r102 == null) goto L9;
        r102.add(Integer.valueOf(r100));
        return;
    L9:
        return;
    }

    public LynxContext(Context r100, DisplayMetrics r101) {
        super(r100);
        this.mCSSKeyframes = null;
        this.mCSSFontFaces = new HashMap();
        this.mTouchEventDispatcher = null;
        this.mPerfController = null;
        this.mTemplateUrl = null;
        this.mJSGroupThreadName = null;
        this.mLynxViewClient = null;
        this.mLynxViewClientV2 = null;
        this.mBodyView = null;
        this.mExposure = null;
        this.mFrescoCallerContext = null;
        this.mEnableImageSmallDiskCache = false;
        this.mPrefetchImageOnCreate = false;
        this.mEnableAsyncImageCallback = false;
        this.mEnableImageResourceHint = false;
        this.mLongTaskMonitorEnabled = LynxBooleanOption.UNSET;
        this.mInstanceId = -1;
        this.mForceImageAsyncRequest = false;
        this.mExtensionModules = new HashMap();
        this.embeddedMode = 0;
        this.isFallbackProcess = false;
        this.mLayoutThreadChanged = false;
        this.mEnableEngineReuse = false;
        this.tapSlop = "50px";
        this.mFrameCallback = new e(this);
        this.mVirtualScreenMetrics = r101;
        if (sLynxTextService != null) goto L6;
        sLynxTextService = (ILynxTextService) i8a.n.c().a(ILynxTextService.class);
        return;
    }

    public static /* synthetic */ void access$200(LynxContext r100, JSONObject r101) {
        r100.notifyLynxFrame(r101);
    }

    private void lambda$findShadowNodeAndRunTask$0(int r100, com.lynx.tasm.base.e r101) {
        v0 r102 = this.mShadowNodeOwnerRef.get();
        if (r102 == null) goto L6;
        r101.accept(r102.f383208g.a(r100));
        return;
    }

    public LynxBaseUI findLynxUIByIdSelector(String r100, LynxBaseUI r101) {
        LynxUIOwner r102 = this.mLynxUIOwner.get();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.findLynxUIByIdSelector(r100, r101);
    }

    public void findShadowNodeAndRunTask(final int r100, final com.lynx.tasm.base.e<ShadowNode> r101) {
        runOnLayoutThread(new s(this, r100, r101));
    }

    public <T> T getSharedData(String r100, Class<T> r101) {
        Map<String, Object> r102 = this.mSharedData;
        if (r102 != null) goto L5;
        return null;
    L5:
        Object r103 = r102.get(r100);
        if (r101.isInstance(r103) == true) goto L8;
        return null;
    L8:
        return r101.cast(r103);
    }

    public void putSharedData(String r100, Object r101) {
        if (this.mSharedData != null) goto L5;
        this.mSharedData = new HashMap();
    L5:
        this.mSharedData.put(r100, r101);
    }

    public void removeUIFromExposedMap(LynxBaseUI r100, String r101) {
        if (r101 == null) goto L4;
    L13:
        if (r101 != null) goto L17;
        if (r100.getExposureID() != null) goto L17;
        return;
    L17:
        if (this.mExposure != null) goto L19;
        initUIExposure();
    L19:
        this.mExposure.o(r100, r101);
        return;
    L4:
        if (r100.getEvents() == null) goto L13;
        if (r100.getEvents().containsKey(UIAPPEAREVENT) == true) goto L10;
        if (r100.getEvents().containsKey(UIDISAPPEAREVENT) == false) goto L13;
    L10:
        if (this.mExposure != null) goto L12;
        initUIExposure();
    L12:
        this.mExposure.o(r100, String.valueOf(r100.getSign()));
        goto L13
    }

    public void sendGlobalEvent(String r100, JavaOnlyArray r101) {
        LLog.i(TAG, "LynxContext sendGlobalEvent " + r100 + " with this: " + toString());
        com.lynx.jsbridge.c r102 = getJSModule("GlobalEventEmitter");
        if (r102 != null) goto L6;
        LLog.e(TAG, "LynxContext sendGlobalEvent failed since eventEmitter is null with this: " + toString());
        return;
    L6:
        JavaOnlyArray r103 = new JavaOnlyArray();
        r103.pushString(r100);
        r103.pushArray(r101);
        r102.a("emit", r103);
    }

    public void sendKeyEvent(int r100, String r101) {
        com.lynx.jsbridge.c r102 = getJSModule("GlobalEventEmitter");
        if (r102 != null) goto L6;
        LLog.e("Lynx", "sendGlobalEvent error, can't get GlobalEventEmitter");
        return;
    L6:
        JavaOnlyArray r103 = new JavaOnlyArray();
        r103.pushString(r101);
        JavaOnlyArray r104 = new JavaOnlyArray();
        r104.pushString(r101);
        r104.pushInt(r100);
        r103.pushArray(r104);
        r102.a("emit", r103);
    }

    public void setExtensionModuleForKey(com.lynx.jsbridge.d r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mExtensionModules.put(r101, r100);
    }

    public void setPlatformEventRootActive(int r100, boolean r101) {
        LynxUIOwner r102 = this.mLynxUIOwner.get();
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102.getPaintingContext() instanceof NativePaintingContext) == false) goto L14;
        NativePaintingContext r103 = (NativePaintingContext) r102.getPaintingContext();
        long r104 = r103.f382171a;
        if (r104 != 0) goto L9;
        return;
    L9:
        if (r103.f382173c == true) goto L16;
        r103.nativeSetPlatformEventRootActive(r104, r100, r101);
        return;
    L16:
        return;
    }

    public void updateScreenSize(int r100, int r101) {
        DisplayMetrics r102 = this.mVirtualScreenMetrics;
        r102.widthPixels = r100;
        r102.heightPixels = r101;
        com.lynx.tasm.behavior.ui.h r103 = this.mExposure;
        if (r103 == null) goto L6;
        r103.l(this);
        return;
    }

    public boolean isPlatformEventTargetEventThrough(int r100, float r110, float r111) {
        LynxUIOwner r101 = this.mLynxUIOwner.get();
        if (r101 != null) goto L5;
        return false;
    L5:
        if ((r101.getPaintingContext() instanceof NativePaintingContext) == false) goto L14;
        NativePaintingContext r102 = (NativePaintingContext) r101.getPaintingContext();
        long r103 = r102.f382171a;
        if (r103 != 0) goto L9;
        return false;
    L9:
        if (r102.f382173c == false) goto L12;
        return false;
    L12:
        return r102.nativeIsPlatformEventTargetEventThrough(r103, r100, r110, r111);
    L14:
        return false;
    }

    public void reportResourceError(String r100, String r101, LynxError r102) {
        if (this.mLynxViewClient == null) goto L8;
        if (r102 == null) goto L9;
        r102.setTemplateUrl(this.mTemplateUrl);
        r102.addCustomInfo("src", r100);
        r102.addCustomInfo("type", r101);
        this.mLynxViewClient.onReceivedError(r102);
        return;
    L9:
        return;
    }

    public void setPlatformEventRootOffset(int r100, float r101, float r110) {
        LynxUIOwner r102 = this.mLynxUIOwner.get();
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102.getPaintingContext() instanceof NativePaintingContext) == false) goto L14;
        NativePaintingContext r103 = (NativePaintingContext) r102.getPaintingContext();
        long r104 = r103.f382171a;
        if (r104 != 0) goto L9;
        return;
    L9:
        if (r103.f382173c == true) goto L16;
        r103.nativeSetPlatformEventRootOffset(r104, r100, r101, r110);
        return;
    L16:
        return;
    }

    public void reportResourceError(String r100, String r101, String r102) {
        reportResourceError(39800, r100, r101, r102);
    }

    public void addUIToExposedMap(LynxBaseUI r100, String r101, JavaOnlyMap r102, JavaOnlyMap r103) {
        if (r101 == null) goto L4;
    L13:
        if (r101 != null) goto L17;
        if (r100.getExposureID() != null) goto L17;
        return;
    L17:
        if (this.mExposure != null) goto L19;
        initUIExposure();
    L19:
        this.mExposure.m(r100, r101, r102, r103);
        return;
    L4:
        if (r100.getEvents() == null) goto L13;
        if (r100.getEvents().containsKey(UIAPPEAREVENT) == true) goto L10;
        if (r100.getEvents().containsKey(UIDISAPPEAREVENT) == false) goto L13;
    L10:
        if (this.mExposure != null) goto L12;
        initUIExposure();
    L12:
        JavaOnlyMap r104 = new JavaOnlyMap();
        r104.put("sendCustom", Boolean.TRUE);
        this.mExposure.m(r100, String.valueOf(r100.getSign()), null, r104);
        goto L13
    }

    public void reportResourceError(int r100, String r101, String r102, String r103) {
        reportResourceError(r101, r102, new LynxError(r100, r103));
    }

    public void invokeUIMethod(String r100, ReadableArray r101, String r110, ReadableMap r111, Callback r112) {
        LynxUIOwner r102 = this.mLynxUIOwner.get();
        if (r102 == null) goto L6;
        r102.invokeUIMethod(r100, r101, r110, r111, r112);
        return;
    }
}
