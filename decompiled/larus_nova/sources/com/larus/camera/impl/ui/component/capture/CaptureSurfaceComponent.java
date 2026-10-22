package com.larus.camera.impl.ui.component.capture;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.utils.a4;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.utils.CameraData;
import com.larus.camera.impl.utils.capture.ZoomRatio;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000÷\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r*\u0001a\u0018\u0000 ¬\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002¬\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020jH\u0014J\u0010\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020>H\u0014J\b\u0010n\u001a\u00020\u0007H\u0014J\b\u0010o\u001a\u00020\u0007H\u0002J\u0010\u0010p\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020f2\u0006\u0010s\u001a\u00020>H\u0002J\b\u0010t\u001a\u00020\u0017H\u0002J\b\u0010u\u001a\u00020\u0007H\u0003J \u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020x2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010y\u001a\u00020fH\u0002J\u0018\u0010z\u001a\u00020\u00072\u0006\u0010w\u001a\u00020x2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u0017H\u0002J\b\u0010}\u001a\u00020\u0007H\u0002J\n\u0010~\u001a\u0004\u0018\u00010\u007fH\u0002J\t\u0010\u0080\u0001\u001a\u00020\u0007H\u0002J\u001e\u0010\u0081\u0001\u001a\u00020\u00072\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\t\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\u0014\u0010\u0086\u0001\u001a\u00020\u00072\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\t\u0010\u0088\u0001\u001a\u00020\u001eH\u0002J\u0016\u0010\u0089\u0001\u001a\u00020\u00072\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u001eH\u0003J\u0011\u0010\u008b\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0011\u0010\u008c\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0011\u0010\u008d\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0011\u0010\u008e\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001b\u0010\u008f\u0001\u001a\u00020\u00072\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0006\u0010w\u001a\u00020xH\u0002J\u001a\u0010\u0099\u0001\u001a\u00020\u00072\u0007\u0010\u009a\u0001\u001a\u00020f2\u0006\u0010w\u001a\u00020xH\u0003J.\u0010\u0095\u0001\u001a\u00030\u0094\u00012\u0010\u0010\u009b\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u009c\u00012\u0010\u0010\u009d\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u009c\u0001H\u0002J\u0012\u0010\u009e\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u00020KH\u0002J\u000e\u0010\u009f\u0001\u001a\u00020\u000b*\u00030 \u0001H\u0002J\u0013\u0010¡\u0001\u001a\u00020\u00072\b\u0010¢\u0001\u001a\u00030 \u0001H\u0002J\t\u0010£\u0001\u001a\u00020\u0007H\u0002J\u001a\u0010¤\u0001\u001a\u00020\u00072\u0006\u0010w\u001a\u00020x2\u0007\u0010¥\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010¦\u0001\u001a\u00020\u00072\u0007\u0010§\u0001\u001a\u00020\u0017H\u0002J\u0011\u0010¨\u0001\u001a\u00020\u00072\u0006\u0010w\u001a\u00020xH\u0002J\t\u0010©\u0001\u001a\u00020\u0007H\u0014J\t\u0010ª\u0001\u001a\u00020\u0007H\u0002J\t\u0010«\u0001\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010&\u001a\u0004\b2\u0010$R\u001b\u00104\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010&\u001a\u0004\b5\u0010$R\u001b\u00107\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010&\u001a\u0004\b8\u0010$R\u001b\u0010:\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010&\u001a\u0004\b;\u0010$R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010&\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010&\u001a\u0004\bC\u0010@R\u001d\u0010E\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010&\u001a\u0004\bG\u0010HR\u001b\u0010J\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010&\u001a\u0004\bL\u0010MR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010&\u001a\u0004\bP\u0010MR\u0010\u0010R\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010T\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010&\u001a\u0004\bU\u0010VR\u001d\u0010X\u001a\u0004\u0018\u00010Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010&\u001a\u0004\bZ\u0010[R\u000e\u0010]\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010`\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010&\u001a\u0004\bb\u0010cR\u000f\u0010\u0092\u0001\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0093\u0001\u001a\u00030\u0094\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0097\u0001\u0010&\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u000f\u0010\u0098\u0001\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u00ad\u0001"}, d2 = {"Lcom/larus/camera/impl/ui/component/capture/CaptureSurfaceComponent;", "Lcom/larus/camera/impl/ui/arch/LayerComponent;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lcom/larus/camera/impl/ui/component/capture/CaptureComponent;", "<init>", "()V", WidgetCostModule.TYPE_ON_CREATE, "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "moveTotalLength", "", "previewFrameAnimator", "Landroid/animation/ObjectAnimator;", "cameraSurface", "Landroid/view/SurfaceView;", "mediaLayoutObserver", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "legacyFocusLayout", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "isCameraOpened", "", "isScanCameraPermissionRequested", "isScanCameraPermissionRequesting", "scanCameraPermissionRunnable", "Ljava/lang/Runnable;", "supportedCaptureMode", "", "", "getSupportedCaptureMode", "()Ljava/util/List;", "singleZoomRatioBtn", "Landroid/widget/TextView;", "getSingleZoomRatioBtn", "()Landroid/widget/TextView;", "singleZoomRatioBtn$delegate", "Lkotlin/Lazy;", "zoomRatioStep", "Lcom/larus/camera/impl/utils/capture/ZoomRatioStep;", "getZoomRatioStep", "()Lcom/larus/camera/impl/utils/capture/ZoomRatioStep;", "zoomRatioStep$delegate", "zoomRatioLayout", "Landroid/widget/LinearLayout;", "getZoomRatioLayout", "()Landroid/widget/LinearLayout;", "zoomRatioLayout$delegate", "multiZoomRatio1XBtn", "getMultiZoomRatio1XBtn", "multiZoomRatio1XBtn$delegate", "multiZoomRatio2XBtn", "getMultiZoomRatio2XBtn", "multiZoomRatio2XBtn$delegate", "multiZoomRatio3XBtn", "getMultiZoomRatio3XBtn", "multiZoomRatio3XBtn$delegate", "multiZoomRatio4XBtn", "getMultiZoomRatio4XBtn", "multiZoomRatio4XBtn$delegate", "zoomCheckedColor", "", "getZoomCheckedColor", "()I", "zoomCheckedColor$delegate", "zoomUncheckedColor", "getZoomUncheckedColor", "zoomUncheckedColor$delegate", "zoomCheckedBgDrawable", "Landroid/graphics/drawable/Drawable;", "getZoomCheckedBgDrawable", "()Landroid/graphics/drawable/Drawable;", "zoomCheckedBgDrawable$delegate", "zoomCheckedTextSize", "", "getZoomCheckedTextSize", "()F", "zoomCheckedTextSize$delegate", "zoomUncheckedTextSize", "getZoomUncheckedTextSize", "zoomUncheckedTextSize$delegate", "mobStartZoomRatio", "maxFloorZoomRatio", "maxMoveLength", "getMaxMoveLength", "()D", "maxMoveLength$delegate", "obricCameraService", "Lcom/larus/camera/contract/ICameraServiceDiff;", "getObricCameraService", "()Lcom/larus/camera/contract/ICameraServiceDiff;", "obricCameraService$delegate", "startRetryTime", "", "isUIStopped", "cameraActionCallback", "com/larus/camera/impl/ui/component/capture/CaptureSurfaceComponent$cameraActionCallback$2$1", "getCameraActionCallback", "()Lcom/larus/camera/impl/ui/component/capture/CaptureSurfaceComponent$cameraActionCallback$2$1;", "cameraActionCallback$delegate", "createView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "createLayoutParams", "Lcom/larus/camera/impl/ui/arch/CameraContainer$LayoutParams;", GXTemplateKey.GAIAX_LAYER_GRAVITY, "onViewCreated", "retryOpenCamera", LiveCommonConstants.REASON_ON_DEDTROY, "startRotation", BaseSwitches.V, "degree", "isFastZoomEnable", "initZoomRatioViews", "openCameraAfterPermissionIfNeeded", "viewModel", "Lcom/larus/camera/impl/ui/viewmodel/CameraCaptureViewModel;", "anchorView", "openCamera", "initZoomRatioVisibility", "isShow", "initZoomRatioViewsAttachToAlbumThumbList", "zoomManager", "Lcom/larus/camera/impl/utils/capture/IZoomManager;", "initZoomRatioClickEvents", "multiZoomRatioBtnClicked", "showRatio", "zoomRatio", "Lcom/larus/camera/impl/utils/capture/ZoomRatio;", "initZoomRatioAccessibility", "mobClickZoomOnCapturePage", "switchMethod", "mobCurZoomRatio", "updateMultiZoomBtnResourceState", "checkedRatioStr", "onPause", WidgetCostModule.TYPE_ON_START, "onStop", "onResume", "animatePreviewFrame", "view", "Landroid/widget/ImageView;", "isTouchZoomFinal", "swipeVerticalGestureDetector", "Landroid/view/GestureDetector;", "getSwipeVerticalGestureDetector", "()Landroid/view/GestureDetector;", "swipeVerticalGestureDetector$delegate", "isHideAlbumThumbListJustNow", "setTouchGesture", "operationContainer", "onSwipeUp", "Lkotlin/Function0;", "onSwipeDown", "adjustMoveTotalLength", "getPointerLength", "Landroid/view/MotionEvent;", "showFocus", "e", "hideFocus", "updateComponent", "mode", "adjustSurfaceRatio", "fullScreen", "applyUnifiedCaptureLayout", "onViewDestroyed", "apply4To3Surface", "applyFullScreenSurface", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureSurfaceComponent extends com.larus.camera.impl.ui.arch.b implements DefaultLifecycleObserver, com.larus.camera.impl.ui.component.capture.a {
    public static final /* synthetic */ int T = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f321842J;
    public float K;
    public final Lazy L;
    public final Lazy M;
    public long N;
    public boolean O;
    public final Lazy P;
    public boolean Q;
    public final Lazy R;
    public boolean S;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f321843m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ObjectAnimator f321844n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SurfaceView f321845o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b1 f321846p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ConstraintLayout.LayoutParams f321847q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SurfaceHolder f321848r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f321849s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f321850t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f321851u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public t0 f321852v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<String> f321853w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f321854x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f321855y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f321856z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f321859a = null;

        static {
            int[] r100 = new int[ZoomRatio.values().length];
            r100[ZoomRatio.RATIO_1X.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ZoomRatio.RATIO_2X.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ZoomRatio.RATIO_3X.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ZoomRatio.RATIO_4X.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f321859a = r100;
        }
    }

    static {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
    }

    public CaptureSurfaceComponent() {
        super(com.larus.camera.impl.ui.arch.c.f321810a, 1);
        this.f321853w = fx8.a.f479115f;
        this.f321854x = LazyKt.lazy(new e1(this));
        this.f321855y = LazyKt.lazy(new v1());
        this.f321856z = LazyKt.lazy(new w1(this));
        this.A = LazyKt.lazy(new u0(this));
        this.B = LazyKt.lazy(new v0(this));
        this.C = LazyKt.lazy(new w0(this));
        this.D = LazyKt.lazy(new x0(this));
        this.E = LazyKt.lazy(new y0(this));
        this.F = LazyKt.lazy(new z0(this));
        this.G = LazyKt.lazy(new a1(this));
        this.H = LazyKt.lazy(new p1(this));
        this.I = LazyKt.lazy(new q1(this));
        this.K = 3.0f;
        this.L = LazyKt.lazy(new r1());
        this.M = LazyKt.lazy(new s1());
        this.P = LazyKt.lazy(new t1(this));
        this.R = LazyKt.lazy(new u1(this));
    }

    public final LinearLayout A() {
        return (LinearLayout) this.f321856z.getValue();
    }

    public final xx8.i B() {
        return (xx8.i) this.f321855y.getValue();
    }

    public final int C() {
        return ((Number) this.F.getValue()).intValue();
    }

    public final float D() {
        return ((Number) this.I.getValue()).floatValue();
    }

    public final void F() {
        CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getAlbumThumbListStateChanged(), new CaptureSurfaceComponent$initZoomRatioViewsAttachToAlbumThumbList$1(this, null)), k());
    }

    public final boolean G() {
        CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return false;
    L5:
        List<String> r101 = fx8.a.f479110a;
        if (fx8.a.f479111b.contains(r100.getCurrentCaptureMode()) == false) goto L8;
        return false;
    L8:
        xx8.c r102 = M();
        if (r102 != null) goto L11;
        return false;
    L11:
        return r102.b();
    }

    public final xx8.c M() {
        CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getZoomService();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v31, types: [android.view.ViewTreeObserver$OnGlobalLayoutListener, com.larus.camera.impl.ui.component.capture.b1] */
    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        final CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r100, (ConstraintLayout) h(R.id.camera_container), 0, null, 6, null);
        if (r100.getCameraData().getUseUnifiedMediaCanvas() == false) goto L8;
        ViewGroup.LayoutParams r101 = h(R.id.focus_container).getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.f321847q = new ConstraintLayout.LayoutParams((ConstraintLayout.LayoutParams) r101);
        ?? r102 = new b1(this, r100);
        j().getViewTreeObserver().addOnGlobalLayoutListener(r102);
        this.f321846p = r102;
    L8:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getCaptureModeStatus(), new CaptureSurfaceComponent$onViewCreated$3(r100, this, null)), k());
        SurfaceView r103 = (SurfaceView) h(R.id.camera_surface);
        this.f321845o = r103;
        if (r103 == null) goto L11;
        SurfaceHolder r104 = r103.getHolder();
    L12:
        this.f321848r = r104;
        if (fx8.a.f479111b.contains(r100.getCurrentCaptureMode()) == true) goto L18;
        SurfaceHolder r105 = this.f321848r;
        if (r105 != null) goto L17;
        return;
    L17:
        K(r100, r105);
    L18:
        final View r106 = h(R.id.focus_container);
        final Ref.DoubleRef r107 = new Ref.DoubleRef();
        final GestureDetector r108 = r100.createGestureDetector(getContext(), new c1(this, r100, r106), new CaptureSurfaceComponent$setTouchGesture$listener$2(r100));
        r106.setOnTouchListener(new d1(r100, this, r108, r107));
        i().addObserver(this);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getScaleLengthStatus(), new CaptureSurfaceComponent$onViewCreated$4(this, null)), k());
        if (G() == false) goto L21;
        E();
        com.larus.utils.e1.d(x(), new f1(this));
        com.larus.utils.e1.d(t(), new g1(this));
        com.larus.utils.e1.d(u(), new h1(this));
        com.larus.utils.e1.d(v(), new i1(this));
        com.larus.utils.e1.d(w(), new j1(this));
        AccessibilityDelegateCompat r109 = new CaptureSurfaceComponent$initZoomRatioAccessibility$accessibilityDelegate$1();
        ViewCompat.setAccessibilityDelegate(x(), r109);
        ViewCompat.setAccessibilityDelegate(t(), r109);
        ViewCompat.setAccessibilityDelegate(u(), r109);
        ViewCompat.setAccessibilityDelegate(v(), r109);
        ViewCompat.setAccessibilityDelegate(w(), r109);
        com.larus.utils.e1.x(A());
    L22:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getOnOrientationChanged(), new CaptureSurfaceComponent$onViewCreated$5(this, null)), k());
        return;
    L21:
        com.larus.utils.e1.o(A());
        goto L22
    L11:
        r104 = null;
        goto L12
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        b1 r100 = this.f321846p;
        if (r100 != null) goto L5;
    L7:
        this.f321846p = null;
        this.f321847q = null;
        return;
    L5:
        if (j().getViewTreeObserver().isAlive() == false) goto L7;
        j().getViewTreeObserver().removeOnGlobalLayoutListener(r100);
        goto L7
    }

    public final double s() {
        return ((Number) this.L.getValue()).doubleValue();
    }

    public final TextView t() {
        return (TextView) this.A.getValue();
    }

    public final TextView u() {
        return (TextView) this.B.getValue();
    }

    public final TextView v() {
        return (TextView) this.C.getValue();
    }

    public final TextView w() {
        return (TextView) this.D.getValue();
    }

    public final TextView x() {
        return (TextView) this.f321854x.getValue();
    }

    public final int y() {
        return ((Number) this.E.getValue()).intValue();
    }

    public final float z() {
        return ((Number) this.H.getValue()).floatValue();
    }

    public final void E() {
        xx8.c r100 = M();
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.h() == false) goto L28;
        L(null);
        int r101 = (int) this.K;
        if (((oq9.d) com.larus.camera.impl.utils.k.f322785a.getValue()).b() == true) goto L10;
        com.larus.utils.e1.x(t());
        com.larus.utils.e1.x(u());
        com.larus.utils.e1.x(v());
        com.larus.utils.e1.o(w());
    L26:
        com.larus.utils.e1.x(A());
        com.larus.utils.e1.o(x());
        F();
        return;
    L10:
        if (r101 < 1) goto L12;
        com.larus.utils.e1.x(t());
    L14:
        if (r101 < 2) goto L16;
        com.larus.utils.e1.x(u());
    L18:
        if (r101 < 3) goto L20;
        com.larus.utils.e1.x(v());
    L22:
        if (r101 < 4) goto L24;
        com.larus.utils.e1.x(w());
        goto L26
    L24:
        com.larus.utils.e1.o(w());
        goto L26
    L20:
        com.larus.utils.e1.o(v());
        goto L22
    L16:
        com.larus.utils.e1.o(u());
        goto L18
    L12:
        com.larus.utils.e1.o(t());
        goto L14
    L28:
        if (r100.d() == false) goto L30;
        x().setText(ZoomRatio.RATIO_1X.getRatioStr());
        com.larus.utils.e1.x(A());
        com.larus.utils.e1.x(x());
        com.larus.utils.e1.o(t());
        com.larus.utils.e1.o(u());
        com.larus.utils.e1.o(v());
        com.larus.utils.e1.o(w());
        F();
        return;
    L30:
        com.larus.utils.e1.o(A());
        com.larus.utils.e1.o(x());
        com.larus.utils.e1.o(t());
        com.larus.utils.e1.o(u());
        com.larus.utils.e1.o(v());
        com.larus.utils.e1.o(w());
    }

    public final String I() {
        xx8.c r100 = M();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L40;
        xx8.c r103 = M();
        if (r103 != null) goto L13;
    L15:
        if (r101 == true) goto L17;
        return "";
    L17:
        if (((oq9.d) com.larus.camera.impl.utils.k.f322785a.getValue()).b() == false) goto L30;
        ZoomRatio r104 = B().f565353a;
        int r105 = b.f321859a[r104.ordinal()];
        if (r105 == 1) goto L44;
        if (r105 == 2) goto L43;
        if (r105 == 3) goto L42;
        if (r105 != 4) goto L26;
        return w().getText().toString();
    L26:
        throw new NoWhenBranchMatchedException();
    L42:
        return v().getText().toString();
    L43:
        return u().getText().toString();
    L44:
        return t().getText().toString();
    L30:
        ZoomRatio r106 = B().f565353a;
        int r107 = b.f321859a[r106.ordinal()];
        if (r107 == 1) goto L48;
        if (r107 == 2) goto L47;
        if (r107 == 3) goto L46;
        return v().getText().toString();
    L46:
        return v().getText().toString();
    L47:
        return u().getText().toString();
    L48:
        return t().getText().toString();
    L13:
        if (r103.h() != true) goto L15;
        r101 = true;
        goto L15
    L40:
        return x().getText().toString();
    L5:
        if (r100.d() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.f321853w;
    }

    public final void H(String r110) {
        if (G() == true) goto L5;
        return;
    L5:
        CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L8;
        return;
    L8:
        xx8.c r101 = M();
        boolean r102 = false;
        if (r101 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L16;
        String r104 = "multi_focus";
    L24:
        String r105 = this.f321842J;
        if (r105 == null) goto L27;
        String r106 = StringsKt.replace$default(r105, "x", "", false, 4, null);
    L28:
        r100.clickZoomOnCapturePage(r104, r106, StringsKt.replace$default(I(), "x", "", false, 4, null), r110);
        return;
    L27:
        r106 = null;
        goto L28
    L16:
        xx8.c r107 = M();
        if (r107 != null) goto L19;
    L21:
        if (r102 == false) goto L23;
        r104 = "single_focus";
        goto L24
    L23:
        r104 = "";
        goto L24
    L19:
        if (r107.d() != true) goto L21;
        r102 = true;
        goto L21
    L11:
        if (r101.h() != true) goto L13;
        r103 = true;
        goto L14
    }

    public final void L(String r110) {
        int r100 = b.f321859a[B().f565353a.ordinal()];     // Catch: Exception -> L33
        if (r100 != 1) goto L5;
        t().setTextColor(y());     // Catch: Exception -> L33
        u().setTextColor(C());     // Catch: Exception -> L33
        v().setTextColor(C());     // Catch: Exception -> L33
        w().setTextColor(C());     // Catch: Exception -> L33
        t().setBackground((Drawable) this.G.getValue());     // Catch: Exception -> L33
        u().setBackground(null);     // Catch: Exception -> L33
        v().setBackground(null);     // Catch: Exception -> L33
        w().setBackground(null);     // Catch: Exception -> L33
        TextView r101 = t();     // Catch: Exception -> L33
        if (r110 != null) goto L31;
        r110 = ZoomRatio.RATIO_1X.getRatioStr();     // Catch: Exception -> L33
    L31:
        r101.setText(r110);     // Catch: Exception -> L33
        u().setText(StringsKt.replace$default(ZoomRatio.RATIO_2X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        v().setText(StringsKt.replace$default(ZoomRatio.RATIO_3X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        w().setText(StringsKt.replace$default(ZoomRatio.RATIO_4X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        t().setTextSize(0, z());     // Catch: Exception -> L33
        u().setTextSize(0, D());     // Catch: Exception -> L33
        v().setTextSize(0, D());     // Catch: Exception -> L33
        w().setTextSize(0, D());     // Catch: Exception -> L33
        return;
    L5:
        if (r100 != 2) goto L7;
        t().setTextColor(C());     // Catch: Exception -> L33
        u().setTextColor(y());     // Catch: Exception -> L33
        v().setTextColor(C());     // Catch: Exception -> L33
        w().setTextColor(C());     // Catch: Exception -> L33
        t().setBackground(null);     // Catch: Exception -> L33
        u().setBackground((Drawable) this.G.getValue());     // Catch: Exception -> L33
        v().setBackground(null);     // Catch: Exception -> L33
        w().setBackground(null);     // Catch: Exception -> L33
        t().setText(StringsKt.replace$default(ZoomRatio.RATIO_1X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        TextView r102 = u();     // Catch: Exception -> L33
        if (r110 != null) goto L26;
        r110 = ZoomRatio.RATIO_2X.getRatioStr();     // Catch: Exception -> L33
    L26:
        r102.setText(r110);     // Catch: Exception -> L33
        v().setText(StringsKt.replace$default(ZoomRatio.RATIO_3X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        w().setText(StringsKt.replace$default(ZoomRatio.RATIO_4X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        t().setTextSize(0, D());     // Catch: Exception -> L33
        u().setTextSize(0, z());     // Catch: Exception -> L33
        v().setTextSize(0, D());     // Catch: Exception -> L33
        w().setTextSize(0, D());     // Catch: Exception -> L33
        return;
    L7:
        if (r100 != 3) goto L9;
        t().setTextColor(C());     // Catch: Exception -> L33
        u().setTextColor(C());     // Catch: Exception -> L33
        v().setTextColor(y());     // Catch: Exception -> L33
        w().setTextColor(C());     // Catch: Exception -> L33
        t().setBackground(null);     // Catch: Exception -> L33
        u().setBackground(null);     // Catch: Exception -> L33
        v().setBackground((Drawable) this.G.getValue());     // Catch: Exception -> L33
        w().setBackground(null);     // Catch: Exception -> L33
        t().setText(StringsKt.replace$default(ZoomRatio.RATIO_1X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        u().setText(StringsKt.replace$default(ZoomRatio.RATIO_2X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        TextView r103 = v();     // Catch: Exception -> L33
        if (r110 != null) goto L21;
        r110 = ZoomRatio.RATIO_3X.getRatioStr();     // Catch: Exception -> L33
    L21:
        r103.setText(r110);     // Catch: Exception -> L33
        w().setText(StringsKt.replace$default(ZoomRatio.RATIO_4X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        t().setTextSize(0, D());     // Catch: Exception -> L33
        u().setTextSize(0, D());     // Catch: Exception -> L33
        v().setTextSize(0, z());     // Catch: Exception -> L33
        w().setTextSize(0, D());     // Catch: Exception -> L33
        return;
    L9:
        if (r100 != 4) goto L16;
        t().setTextColor(C());     // Catch: Exception -> L33
        u().setTextColor(C());     // Catch: Exception -> L33
        v().setTextColor(C());     // Catch: Exception -> L33
        w().setTextColor(y());     // Catch: Exception -> L33
        t().setBackground(null);     // Catch: Exception -> L33
        u().setBackground(null);     // Catch: Exception -> L33
        v().setBackground(null);     // Catch: Exception -> L33
        w().setBackground((Drawable) this.G.getValue());     // Catch: Exception -> L33
        t().setText(StringsKt.replace$default(ZoomRatio.RATIO_1X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        u().setText(StringsKt.replace$default(ZoomRatio.RATIO_2X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        v().setText(StringsKt.replace$default(ZoomRatio.RATIO_3X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        TextView r104 = w();     // Catch: Exception -> L33
        if (r110 != null) goto L14;
        r110 = ZoomRatio.RATIO_4X.getRatioStr();     // Catch: Exception -> L33
    L14:
        r104.setText(r110);     // Catch: Exception -> L33
        t().setTextSize(0, D());     // Catch: Exception -> L33
        u().setTextSize(0, D());     // Catch: Exception -> L33
        v().setTextSize(0, D());     // Catch: Exception -> L33
        w().setTextSize(0, z());     // Catch: Exception -> L33
        return;
    L16:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        FLogger.f375446a.e("CaptureSurfaceComponent", "e=" + e.getMessage());
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r100) {
        CameraContainer.b r101 = super.f(r100);
        ((FrameLayout.LayoutParams) r101).width = -1;
        ((FrameLayout.LayoutParams) r101).height = -1;
        return r101;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onDestroy(this, r100);
        t0 r101 = this.f321852v;
        if (r101 == null) goto L7;
        SurfaceView r102 = this.f321845o;
        if (r102 == null) goto L7;
        r102.removeCallbacks(r101);
    L7:
        this.f321852v = null;
        this.f321851u = false;
        ObjectAnimator r103 = this.f321844n;
        if (r103 == null) goto L10;
        r103.cancel();
    L10:
        this.f321844n = null;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        CameraCaptureViewModel r101 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r101 != null) goto L6;
        return;
    L6:
        if (com.larus.camera.impl.ui.component.capture.a.C4152a.a(this, r101) == true) goto L8;
        return;
    L8:
        List<String> r102 = fx8.a.f479110a;
        if (fx8.a.f479111b.contains(r101.getCurrentCaptureMode()) == false) goto L11;
        return;
    L11:
        r101.captureCurrentFrame();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.larus.camera.impl.ui.component.capture.t0, java.lang.Runnable] */
    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(LifecycleOwner r110) {
        Intrinsics.checkNotNullParameter(r110, "owner");
        final CameraCaptureViewModel r111 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r111 != null) goto L5;
        return;
    L5:
        List<String> r100 = fx8.a.f479111b;
        final FragmentActivity r101 = null;
        if (r100.contains(r111.getCurrentCaptureMode()) == false) goto L36;
        final SurfaceHolder r102 = this.f321848r;
        if (r102 != null) goto L10;
        return;
    L10:
        SurfaceView r103 = this.f321845o;
        if (r103 != 0) goto L14;
        return;
    L14:
        if (this.f321849s == false) goto L17;
        return;
    L17:
        if (r100.contains(r111.getCurrentCaptureMode()) == true) goto L20;
        K(r111, r102);
        return;
    L20:
        if (this.f321851u == true) goto L45;
        com.larus.camera.impl.starter.a.f321747a.getClass();
        if (com.larus.camera.impl.starter.a.c() == false) goto L26;
        K(r111, r102);
        return;
    L26:
        if (this.f321850t == true) goto L46;
        Activity r104 = com.larus.utils.i.getActivity(getContext());
        if ((r104 instanceof FragmentActivity) == false) goto L32;
        r101 = (FragmentActivity) r104;
    L32:
        if (r101 != null) goto L34;
        FLogger.f375446a.w("CaptureSurfaceComponent", "scan camera permission request skip, activity null");
        return;
    L34:
        this.f321850t = true;
        this.f321851u = true;
        FLogger.f375446a.i("CaptureSurfaceComponent", "scan camera permission request scheduled");
        ?? r105 = new t0(this, r111, r102, r101);
        this.f321852v = r105;
        r103.postDelayed(r105, 300);
        return;
    L46:
        return;
    L45:
        return;
    L36:
        r111.checkCameraPermission();
        if (com.larus.camera.impl.ui.component.capture.a.C4152a.a(this, r111) == true) goto L39;
        return;
    L39:
        ImageView r106 = (ImageView) h(R.id.preview_frame);
        BuildersKt.launch$default(k(), null, null, new CaptureSurfaceComponent$animatePreviewFrame$1(r111, this, r106, null), 3, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
        this.O = false;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
        this.O = true;
    }

    public final void q(float r100) {
        xx8.c r101 = M();
        if (r101 == null) goto L5;
        double r102 = r101.e(r100, s());
    L6:
        this.f321843m = r102;
        FLogger.f375446a.i("CaptureSurfaceComponent", "adjustMoveTotalLength moveTotalLength=" + this.f321843m);
        return;
    L5:
        r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L6
    }

    public final void r(CameraCaptureViewModel r110) {
        CameraData r100 = r110.getCameraData();
        if (r100.getUseUnifiedMediaCanvas() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r110.getCurrentCaptureMode(), "CAPTURE_MODE_PHOTO") == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r100.getScene(), "ecom_page") == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r100.getScene(), "attach_photo_edit") == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r100.getScene(), "prompt_direct_send") == true) goto L63;
        ConstraintLayout r111 = (ConstraintLayout) h(R.id.camera_container);
        Intrinsics.checkNotNullParameter(r111, RootDescription.ROOT_ELEMENT);
        if (r111.getWidth() > 0) goto L16;
    L41:
        Rect r101 = null;
    L42:
        if (r101 != null) goto L44;
        return;
    L44:
        float r112 = Math.min(r101.width() / 3.0f, r101.height() / 4.0f);
        int r102 = MathKt.roundToInt(3.0f * r112);
        int r113 = MathKt.roundToInt(r112 * 4.0f);
        int r103 = r101.top + ((r101.height() - r113) / 2);
        View r104 = h(R.id.focus_container);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof ConstraintLayout.LayoutParams) == false) goto L47;
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
    L48:
        if (r106 != null) goto L51;
        return;
    L51:
        if (((ViewGroup.MarginLayoutParams) r106).width == r102) goto L53;
    L57:
        r106.dimensionRatio = null;
        ((ViewGroup.MarginLayoutParams) r106).width = r102;
        ((ViewGroup.MarginLayoutParams) r106).height = r113;
        r106.topToTop = 0;
        r106.topToBottom = -1;
        r106.bottomToBottom = -1;
        r106.bottomToTop = -1;
        ((ViewGroup.MarginLayoutParams) r106).topMargin = r103;
        ((ViewGroup.MarginLayoutParams) r106).bottomMargin = 0;
        r104.setLayoutParams(r106);
        return;
    L53:
        if (((ViewGroup.MarginLayoutParams) r106).height != r113) goto L57;
        if (((ViewGroup.MarginLayoutParams) r106).topMargin != r103) goto L57;
        return;
    L47:
        r106 = null;
        goto L48
    L16:
        if (r111.getHeight() <= 0) goto L41;
        Integer r107 = Integer.valueOf(r111.getRootView().getHeight());
        if (r107.intValue() <= 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L25;
        r107 = null;
    L25:
        if (r107 == null) goto L41;
        int r109 = r107.intValue();
        WindowInsetsCompat r114 = ViewCompat.getRootWindowInsets(r111);
        if (r114 == null) goto L29;
        Insets r115 = r114.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars());
    L30:
        Resources r116 = r111.getResources();
        float r117 = WindowDisplayMetricsOverride.apply(r116, r116.getDisplayMetrics()).density;
        int[] r118 = new int[2];
        r111.getLocationInWindow(r118);
        int r119 = r118[1];
        if (r115 == null) goto L33;
        int r120 = r115.top;
    L34:
        int r121 = RangesKt.coerceAtLeast((r120 + MathKt.roundToInt(52 * r117)) - r119, 0);
        if (r115 == null) goto L37;
        int r122 = r115.bottom;
    L38:
        int r123 = RangesKt.coerceAtMost(((r109 - r122) - MathKt.roundToInt(144 * r117)) - r119, r111.getHeight());
        if (r123 <= r121) goto L41;
        r101 = new Rect(0, r121, r111.getWidth(), r123);
        goto L42
    L37:
        r122 = 0;
        goto L38
    L33:
        com.larus.utils.i0.f375410a.getClass();
        r120 = com.larus.utils.i0.g();
        goto L34
    L29:
        r115 = null;
        goto L30
    L21:
        r108 = false;
        goto L22
    }

    public final void J(String r100, ZoomRatio r101) {
        CameraCaptureViewModel r102 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r102 != null) goto L5;
        return;
    L5:
        xx8.i r103 = B();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "zoomRatio");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        FLogger.f375446a.i(r103.f565354b, "multiSwitchToRatioStep: " + r100 + ", " + r101 + " wideMinRatio:null curZoomRatio:" + r103.f565353a);
        ZoomRatio r104 = r103.f565353a;
        if (r101 == r104) goto L8;
    L10:
        r103.f565353a = r101;
        xx8.c r105 = r102.getZoomService();
        if (r105 == null) goto L13;
        r102.zoomByValue(r105.f(r103.f565353a.getRatio()));
        boolean r106 = true;
    L14:
        if (r106 == false) goto L17;
        H("click");
        q(B().f565353a.getRatio());
        a4.f314971a.getClass();
        a4.a(a4.f314972b / ((long) 3));
        return;
    L17:
        return;
    L13:
        r106 = false;
        goto L14
    L8:
        if (Intrinsics.areEqual(r100, r104.getRatioStr()) == false) goto L10;
        goto L10
    }

    public final void K(final CameraCaptureViewModel r100, SurfaceHolder r101) {
        this.f321849s = true;
        r100.openCamera(r101, (CaptureSurfaceComponent$cameraActionCallback$2$1) this.P.getValue(), getContext());
        com.larus.utils.t0.f375468a.postDelayed(new k1(r100), 10000);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return r100.inflate(R.layout.larus_layout_view_surface_component, r101, false);
    }

    public static final void p(CaptureSurfaceComponent r100, View r101, int r102) {
        r100.getClass();
        ViewPropertyAnimator r103 = r101.animate();
        int r104 = com.larus.camera.impl.utils.c0.f322738d;
        r103.rotation(com.larus.camera.impl.utils.c0.a.a(r102, false));
        r103.setDuration(300);
        r103.start();
    }
}
