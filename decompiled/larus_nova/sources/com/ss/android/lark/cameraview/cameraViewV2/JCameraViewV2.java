package com.ss.android.lark.cameraview.cameraViewV2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c0b.f;
import c0b.h;
import c0b.i;
import c0b.j;
import c0b.k;
import c0b.m;
import c0b.n;
import c0b.o;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.camera_export.CameraFG;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.cameraview.FocusView;
import com.ss.android.lark.cameraview.l;
import com.ss.android.lark.cameraview.w;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fna.g;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u008c\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u008b\u0001\u008c\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020FH\u0002J\u0018\u0010H\u001a\u00020F2\u0006\u0010I\u001a\u0002052\u0006\u0010J\u001a\u00020\tH\u0002J\u0010\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\u0005H\u0002J\u0018\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0014J\b\u0010P\u001a\u00020FH\u0016J\u0006\u0010Q\u001a\u00020FJ\u0006\u0010R\u001a\u00020FJ\u0006\u0010S\u001a\u00020FJ\u0006\u0010T\u001a\u00020FJ\u0006\u0010C\u001a\u00020\u001eJ\u0006\u0010U\u001a\u00020VJ\u000e\u0010W\u001a\u00020F2\u0006\u0010X\u001a\u00020VJ\u0006\u0010Y\u001a\u00020FJ\u0010\u0010Z\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020\\H\u0016J\u0018\u0010]\u001a\u00020F2\u0006\u0010^\u001a\u0002002\u0006\u0010_\u001a\u000200H\u0002J\"\u0010`\u001a\u00020F2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020\tH\u0002J\u0010\u0010e\u001a\u00020F2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010f\u001a\u00020F2\b\u0010>\u001a\u0004\u0018\u00010?J\u0006\u0010g\u001a\u00020FJ\u0010\u0010h\u001a\u00020F2\u0006\u0010i\u001a\u00020\tH\u0016J\u0010\u0010j\u001a\u00020F2\u0006\u0010i\u001a\u00020\tH\u0016J\u0018\u0010k\u001a\u00020F2\u0006\u0010l\u001a\u0002022\u0006\u0010m\u001a\u00020\u001eH\u0016J\u0010\u0010n\u001a\u00020F2\u0006\u0010l\u001a\u000202H\u0016J\b\u0010o\u001a\u00020FH\u0016J\u0018\u0010p\u001a\u00020F2\u0006\u0010l\u001a\u0002022\u0006\u0010m\u001a\u00020\u001eH\u0016J\u001c\u0010q\u001a\u00020F2\b\u00103\u001a\u0004\u0018\u0001022\b\u0010r\u001a\u0004\u0018\u000105H\u0016J\b\u0010s\u001a\u00020FH\u0016J\u0010\u0010t\u001a\u00020F2\u0006\u0010u\u001a\u00020\u001eH\u0002J\u0018\u0010v\u001a\u00020\u001e2\u0006\u0010^\u001a\u0002002\u0006\u0010_\u001a\u000200H\u0016J\u0010\u0010w\u001a\u00020F2\b\u0010x\u001a\u0004\u0018\u00010\u0011J\u0010\u0010y\u001a\u00020F2\b\u0010x\u001a\u0004\u0018\u00010\u0011J\u000e\u0010z\u001a\u00020F2\u0006\u0010{\u001a\u00020|J\u0010\u0010}\u001a\u00020F2\u0006\u0010~\u001a\u00020\tH\u0002J\u0011\u0010\u007f\u001a\u00020F2\u0007\u0010\u0080\u0001\u001a\u000205H\u0002J\t\u0010\u0086\u0001\u001a\u00020\u001eH\u0002J\t\u0010\u0087\u0001\u001a\u00020\tH\u0002J\t\u0010\u0088\u0001\u001a\u00020FH\u0002J\t\u0010\u0089\u0001\u001a\u00020FH\u0002J\t\u0010\u008a\u0001\u001a\u00020FH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0081\u0001\u001a\u00020\t8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0017\u0010\u0084\u0001\u001a\u00020\t8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0083\u0001¨\u0006\u008d\u0001"}, d2 = {"Lcom/ss/android/lark/cameraview/cameraViewV2/JCameraViewV2;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/cameraview/CameraInterface$CameraOpenOverCallback;", "Lcom/ss/android/lark/cameraview/view/ICameraView;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "machine", "Lcom/ss/android/lark/cameraview/state/CameraMachine;", "jCameraListener", "Lcom/ss/android/lark/cameraview/listener/JCameraListener;", "leftClickListener", "Lcom/ss/android/lark/cameraview/listener/ClickListener;", "rightClickListener", "mVideoView", "Lcom/ss/android/lark/cameraview/cameraViewV2/VideoPreview;", "mPlayView", "mPhoto", "Landroid/widget/ImageView;", "mBackButton", "Landroid/widget/LinearLayout;", "mTipTextView", "Landroid/widget/TextView;", "mFlashStatus", "mFlashSimulationStatus", "", "mFlipCameraFlag", "mTipsRunnable", "Ljava/lang/Runnable;", "mPlayVideoLayout", "mPreviewLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mBackToPreviewPage", "mDownloadButton", "mSendButton", "Landroid/widget/Button;", "mCaptureLayout", "Lcom/ss/android/lark/cameraview/cameraViewV2/CaptureLayoutV2;", "mFocusView", "Lcom/ss/android/lark/cameraview/FocusView;", "mMediaPlayer", "Landroid/media/MediaPlayer;", "screenProp", "", "captureBitmap", "Landroid/graphics/Bitmap;", "firstFrame", "videoUrl", "", "iconSize", "iconMargin", "iconSrc", "iconLeft", "iconRight", "duration", "firstTouch", "firstTouchLength", "errorListener", "Lcom/ss/android/lark/cameraview/listener/ErrorListener;", "cameraService", "Ljava/util/concurrent/ExecutorService;", "hadPaused", "needRebuildOnResume", "cameraMode", "initData", "", "initView", "switchFlash", "tips", "resId", "getStatusBarHeight", PerfLog.PARAM_KEY_CONTEXT_ID, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "cameraHasOpened", "onResume", "onPause", WidgetCostModule.TYPE_ON_START, "onStop", "exportUiState", "Lcom/ss/android/lark/cameraview/cameraViewV2/JCameraViewV2$CameraUiState;", "applyUiState", "state", LiveCommonConstants.REASON_ON_DEDTROY, "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setFocusViewWidthAnimation", "x", "y", "updateSurfaceSize", "videoView", "Landroid/widget/VideoView;", "videoWidth", "videoHeight", "setJCameraListener", "setErrorListener", "switchCamera", "resetState", "type", "confirmState", "showPicture", SimplayerImageStrategy.RESULT_BITMAP, "isVertical", "startEditPicture", "videoErrPromp", "justCapturePicture", "playVideo", "url", "stopVideo", "switchVideoViewForContainer", "isPlayState", "handleFocus", "setLeftClickListener", "clickListener", "setRightClickListener", "initCameraView", "param", "Lcom/ss/android/lark/camera_export/CameraParam;", "setMaxDuration", "maxDuration", "setButtonMode", "mode", "maxWidth", "getMaxWidth", "()I", "zoomGradient", "getZoomGradient", "isNavigationBarTransparent", "getNavigationBarHeight", "restartCameraOnResumeIfNeeded", "setFlashOnIfNeed", "setFlashOffIfNeed", "CameraUiState", "Companion", "cameraview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JCameraViewV2 extends FrameLayout implements g0b.a {
    public final ExecutorService A;
    public boolean B;
    public boolean C;
    public String D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f410894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0b.c f410895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0b.d f410896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d0b.b f410897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VideoPreview f410898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VideoPreview f410899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f410900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f410901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f410902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f410903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f410904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f410905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f410906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FrameLayout f410907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ConstraintLayout f410908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LinearLayout f410909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LinearLayout f410910q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Button f410911r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CaptureLayoutV2 f410912s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public FocusView f410913t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public MediaPlayer f410914u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f410915v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Bitmap f410916w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f410917x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f410918y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f410919z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f410920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f410921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f410922c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f410920a == r101.f410920a) goto L12;
            return false;
        L12:
            if (this.f410921b == r101.f410921b) goto L15;
            return false;
        L15:
            if (this.f410922c == r101.f410922c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f410920a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f410921b == true) goto L11;
            r100 = 1237;
        L11:
            return ((r102 + r100) * 31) + this.f410922c;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "CameraUiState(isFront=" + this.f410920a + ", flashOn=" + this.f410921b + ", flashStatus=" + this.f410922c + ')';
        }

        public a(boolean r100, boolean r101, int r102) {
            this.f410920a = r100;
            this.f410921b = r101;
            this.f410922c = r102;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JCameraViewV2 f410923a;

        public c(JCameraViewV2 r100) {
            this.f410923a = r100;
        }

        public final void a() {
            String r100 = this.f410923a.D;
            if (Intrinsics.areEqual(r100, CameraParam.MODE_ONLY_PHOTO) == false) goto L6;
            int r101 = R.string.Lark_Camera_TapTakePhoto_Desc;
        L9:
            Log.i("JCameraViewV2", "initCameraView, cameraMode = " + this.f410923a.D);
            TextView r102 = this.f410923a.f410902i;
            if (r102 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("mTipTextView");
            r102 = null;
        L12:
            r102.setText(this.f410923a.getResources().getString(r101));
            return;
        L6:
            if (Intrinsics.areEqual(r100, CameraParam.MODE_ONLY_VIDEO) == false) goto L8;
            r101 = R.string.Lark_Camera_HoldRecord_Desc;
            goto L9
        L8:
            r101 = R.string.Lark_Legacy_CameraRecordTip;
            goto L9
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
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JCameraViewV2 f410924a;

        public static final class a implements MediaPlayer.OnVideoSizeChangedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JCameraViewV2 f410925a;

            public a(JCameraViewV2 r100) {
                this.f410925a = r100;
            }

            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(MediaPlayer r100, int r101, int r102) {
                JCameraViewV2 r103 = this.f410925a;
                VideoPreview r104 = r103.f410899f;
                if (r104 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                r104 = null;
            L5:
                JCameraViewV2.j(r103, r104, r101, r102);
            }
        }

        public static final class b implements MediaPlayer.OnPreparedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JCameraViewV2 f410926a;

            public b(JCameraViewV2 r100) {
                this.f410926a = r100;
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer r100) {
                VideoPreview r101 = this.f410926a.f410899f;
                if (r101 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                r101 = null;
            L5:
                Surface r102 = r101.getHolder().getSurface();
                if (r102 != null) goto L8;
                return;
            L8:
                if (r102.isValid() == false) goto L20;
                MediaPlayer r103 = this.f410926a.f410914u;
                if (r103 == null) goto L12;
                r103.setSurface(r102);
            L12:
                MediaPlayer r104 = this.f410926a.f410914u;
                if (r104 != null) goto L15;
                return;
            L15:
                if (g.d() == true) goto L17;
                r104.start();
                return;
            L17:
                r104.start();
                gna.a.c(r104.hashCode());
                return;
            }
        }

        public d(JCameraViewV2 r100) {
            this.f410924a = r100;
        }

        public final void a() {
            JCameraViewV2 r100 = this.f410924a;     // Catch: Exception -> L29
            MediaPlayer r101 = r100.f410914u;     // Catch: Exception -> L29
            if (r101 != null) goto L5;
            r100.f410914u = new MediaPlayer();     // Catch: Exception -> L29
        L7:
            JCameraViewV2 r102 = this.f410924a;     // Catch: Exception -> L29
            MediaPlayer r103 = r102.f410914u;     // Catch: Exception -> L29
            if (r103 == null) goto L10;
            r103.setDataSource(r102.f410917x);     // Catch: Exception -> L29
        L10:
            MediaPlayer r104 = this.f410924a.f410914u;     // Catch: Exception -> L29
            if (r104 == null) goto L13;
            r104.setVideoScalingMode(1);     // Catch: Exception -> L29
        L13:
            MediaPlayer r105 = this.f410924a.f410914u;     // Catch: Exception -> L29
            if (r105 == null) goto L16;
            r105.setAudioStreamType(3);     // Catch: Exception -> L29
        L16:
            JCameraViewV2 r106 = this.f410924a;     // Catch: Exception -> L29
            MediaPlayer r107 = r106.f410914u;     // Catch: Exception -> L29
            if (r107 == null) goto L19;
            r107.setOnVideoSizeChangedListener(new a(r106));     // Catch: Exception -> L29
        L19:
            JCameraViewV2 r108 = this.f410924a;     // Catch: Exception -> L29
            MediaPlayer r109 = r108.f410914u;     // Catch: Exception -> L29
            if (r109 == null) goto L22;
            r109.setOnPreparedListener(new b(r108));     // Catch: Exception -> L29
        L22:
            MediaPlayer r110 = this.f410924a.f410914u;     // Catch: Exception -> L29
            if (r110 == null) goto L25;
            r110.setLooping(true);     // Catch: Exception -> L29
        L25:
            MediaPlayer r111 = this.f410924a.f410914u;     // Catch: Exception -> L29
            if (r111 == null) goto L34;
            r111.prepare();     // Catch: Exception -> L29
            return;
        L34:
            return;
        L5:
            if (r101 == null) goto L7;
            r101.reset();     // Catch: Exception -> L29
        L29:
            e = move-exception;
            e.printStackTrace();
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
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f410927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f410928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JCameraViewV2 f410929c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            this.f410927a.setVisibility(4);
            if (this.f410928b == true) goto L13;
            VideoPreview r101 = this.f410929c.f410899f;
            VideoPreview r102 = null;
            if (r101 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            r101 = null;
        L7:
            r101.setVisibility(4);
            VideoPreview r103 = this.f410929c.f410898e;
            if (r103 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        L11:
            r102.setVisibility(0);
            return;
        L10:
            r102 = r103;
            goto L11
        }

        public e(ViewGroup r100, boolean r101, JCameraViewV2 r102) {
            this.f410927a = r100;
            this.f410928b = r101;
            this.f410929c = r102;
        }
    }

    static {
    }

    public JCameraViewV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public JCameraViewV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this(r100, r101, 4, 0);
    }

    @Override // g0b.a
    public final void a() {
        f(4);
        e0b.c r100 = this.f410895b;
        w r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r100 = null;
    L5:
        VideoPreview r102 = this.f410898e;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        r102 = null;
    L8:
        r100.h(r102.getHolder(), this.f410915v);
        TextView r103 = this.f410902i;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTipTextView");
        r103 = null;
    L11:
        r103.setText(getResources().getString(R.string.Lark_IM_RecordFailRetry_Toast));
        removeCallbacks(this.f410906m);
        postDelayed(this.f410906m, 2000);
        CaptureLayoutV2 r104 = this.f410912s;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r104 = null;
    L14:
        w r105 = r104.f410881d;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
    L18:
        r101.setEnabled(true);
        return;
    L17:
        r101 = r105;
        goto L18
    }

    public final void setLeftClickListener(d0b.b r100) {
    }

    public final void l() {
        Log.i("JCameraViewV2", "JCameraView: onDestroy");
        l.a().b();
        VideoPreview r100 = this.f410898e;
        VideoPreview r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        r100 = null;
    L5:
        r100.animate().cancel();
        VideoPreview r102 = this.f410899f;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
    L9:
        r101.animate().cancel();
        return;
    L8:
        r101 = r102;
        goto L9
    }

    public final void m() {
        Log.i("JCameraViewV2", "JCameraView onResume");
        FrameLayout r100 = this.f410907n;
        VideoPreview r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayVideoLayout");
        r100 = null;
    L6:
        if (r100.getVisibility() != 4) goto L29;
        l.a().g(this.f410894a);
        com.ss.android.lark.cameraview.e r102 = l.a();
        if ((r102 instanceof com.ss.android.lark.cameraview.e) == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L14;
        r102.d(this.f410894a);
    L14:
        if (this.B == false) goto L32;
        FrameLayout r103 = this.f410907n;
        if (r103 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayVideoLayout");
        r103 = null;
    L19:
        if (r103.getVisibility() != 4) goto L33;
        f(4);
        e0b.c r104 = this.f410895b;
        if (r104 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r104 = null;
    L23:
        VideoPreview r105 = this.f410898e;
        if (r105 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
    L27:
        r104.h(r101.getHolder(), this.f410915v);
        return;
    L26:
        r101 = r105;
        goto L27
    L33:
        return;
    L32:
        return;
    L29:
        if (this.f410917x == null) goto L35;
        this.A.execute(new d(this));
        return;
    }

    public final void n() {
        MediaPlayer r100 = this.f410914u;
        if (r100 == null) goto L20;
        boolean r101 = true;
        if (r100.isPlaying() == true) goto L8;
        r101 = false;
    L8:
        if (r101 == false) goto L21;
        MediaPlayer r102 = this.f410914u;
        if (r102 != null) goto L12;
    L15:
        MediaPlayer r103 = this.f410914u;
        if (r103 == null) goto L18;
        r103.release();
    L18:
        this.f410914u = null;
        return;
    L12:
        if (g.d() == true) goto L14;
        r102.stop();
        goto L15
    L14:
        r102.stop();
        gna.a.a(r102.hashCode());
        goto L15
    L21:
        return;
    }

    private final int getMaxWidth() {
        if (CameraFG.getEnableBigScreenCompat() == false) goto L9;
        int r100 = getMeasuredWidth();
        if (r100 > 0) goto L11;
        Log.w("JCameraViewV2", "getMaxWidth / Invalid measuredWidth " + r100 + ", use screenWidth");
        return DeviceUtils.getScreenWidth(this.f410894a);
    L11:
        return r100;
    L9:
        return DeviceUtils.getScreenWidth(this.f410894a);
    }

    private final int getNavigationBarHeight() {
        Window r100 = Contexts.requireActivity(getContext()).getWindow();
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        int r103 = r101.getHeight();
        DisplayMetrics r104 = new DisplayMetrics();
        r100.getWindowManager().getDefaultDisplay().getMetrics(r104);
        if (r103 != r104.heightPixels) goto L10;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == true) goto L21;
        int r106 = getResources().getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r106 > 0) goto L20;
        return 0;
    L20:
        return getResources().getDimensionPixelSize(r106);
    L21:
        return 0;
    L10:
        if ((r100.getAttributes().flags & AMapEngineUtils.HALF_MAX_P20_WIDTH) != 0) goto L15;
        if ((r100.getAttributes().flags & 1024) != 0) goto L15;
        r105 = false;
        goto L16
    }

    private final int getZoomGradient() {
        return (int) (getMaxWidth() / 16.0f);
    }

    public static final void g(JCameraViewV2 r100) {
        if (r100.f410904k == true) goto L5;
        return;
    L5:
        if (r100.f410905l == false) goto L15;
        Activity r101 = ContextsKt.findActivity(r100.f410894a);
        if (r101 != null) goto L9;
        return;
    L9:
        if (CameraFG.getEnableFrontCameraWithoutFlash() == false) goto L11;
        return;
    L11:
        if (r101.isFinishing() == false) goto L13;
        return;
    L13:
        if (r101.isDestroyed() == true) goto L24;
        int r102 = b0b.a.f16907a;
        Intrinsics.checkNotNullParameter(r101, "activity");
        Window r103 = r101.getWindow();
        WindowManager.LayoutParams r104 = r103.getAttributes();
        r104.screenBrightness = -1.0f;
        r103.setAttributes(r104);
        return;
    L24:
        return;
    L15:
        e0b.c r105 = r100.f410895b;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r105 = null;
    L18:
        r105.b("CAMERA_FLASH_OFF");
    }

    public static final void h(JCameraViewV2 r100) {
        if (r100.f410904k == true) goto L5;
        return;
    L5:
        if (r100.f410905l == true) goto L7;
        e0b.c r101 = r100.f410895b;
        if (r101 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r101 = null;
    L18:
        r101.b("CAMERA_FLASH_TORCH");
        return;
    L7:
        if (CameraFG.getEnableFrontCameraWithoutFlash() == true) goto L21;
        Activity r102 = ContextsKt.findActivity(r100.f410894a);
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.isFinishing() == false) goto L13;
        return;
    L13:
        if (r102.isDestroyed() == true) goto L24;
        int r103 = b0b.a.f16907a;
        Intrinsics.checkNotNullParameter(r102, "activity");
        float r104 = RangesKt.coerceIn(1.0f, 0.0f, 1.0f);
        Window r105 = r102.getWindow();
        WindowManager.LayoutParams r106 = r105.getAttributes();
        r106.screenBrightness = r104;
        r105.setAttributes(r106);
        return;
    L24:
        return;
    }

    private final void setButtonMode(String r100) {
        CaptureLayoutV2 r101 = this.f410912s;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r101 = null;
    L5:
        r101.setButtonMode(r100);
    }

    private final void setMaxDuration(int r100) {
        if (r100 > 0) goto L4;
        r100 = 30000;
    L4:
        CaptureLayoutV2 r101 = this.f410912s;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r101 = null;
    L7:
        r101.setDuration(r100);
    }

    @Override // g0b.a
    public final void b(String r100) {
        o(true);
        this.f410917x = r100;
        CaptureLayoutV2 r101 = null;
        this.A.execute(new n(this, r100));
        CaptureLayoutV2 r102 = this.f410912s;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
    L6:
        r101.getClass();
        r101.postDelayed(new c0b.a(r101), 300);
        return;
    L5:
        r101 = r102;
        goto L6
    }

    @Override // g0b.a
    public final void d(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        this.f410916w = r100;
        CaptureLayoutV2 r101 = this.f410912s;
        e0b.c r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r101 = null;
    L5:
        r101.getClass();
        r101.postDelayed(new c0b.a(r101), 300);
        e0b.c r103 = this.f410895b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
    L9:
        r102.f470659c.e(1);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    @Override // g0b.a
    public final void e(int r100) {
        CaptureLayoutV2 r101 = null;
        if (r100 != 1) goto L5;
        ImageView r102 = this.f410900g;
        if (r102 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mPhoto");
        r102 = null;
    L19:
        r102.setVisibility(4);
        d0b.d r103 = this.f410896c;
        if (r103 == null) goto L22;
        r103.a(this.f410916w);
    L22:
        CaptureLayoutV2 r104 = this.f410912s;
        if (r104 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
    L26:
        r101.b();
        return;
    L25:
        r101 = r104;
        goto L26
    L5:
        if (r100 != 2) goto L22;
        n();
        e0b.c r105 = this.f410895b;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r105 = null;
    L10:
        VideoPreview r106 = this.f410898e;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        r106 = null;
    L13:
        r105.h(r106.getHolder(), this.f410915v);
        d0b.d r107 = this.f410896c;
        if (r107 == null) goto L22;
        r107.c(this.f410917x);
        goto L22
    }

    @Override // g0b.a
    public final void f(int r100) {
        CaptureLayoutV2 r101 = null;
        if (r100 != 1) goto L5;
        ImageView r102 = this.f410900g;
        if (r102 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mPhoto");
        r102 = null;
    L25:
        r102.setVisibility(4);
    L26:
        CaptureLayoutV2 r103 = this.f410912s;
        if (r103 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
    L30:
        r101.b();
        return;
    L29:
        r101 = r103;
        goto L30
    L5:
        if (r100 != 2) goto L7;
        o(false);
        n();
        FileUtils.g(this.f410917x);
        e0b.c r104 = this.f410895b;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r104 = null;
    L18:
        VideoPreview r105 = this.f410898e;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        r105 = null;
    L21:
        r104.h(r105.getHolder(), this.f410915v);
        goto L26
    L7:
        if (r100 == 3) goto L11;
        if (r100 != 4) goto L26;
        o(false);
        goto L26
    L11:
        TextView r106 = this.f410902i;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mTipTextView");
        r106 = null;
    L14:
        r106.setText(getResources().getString(R.string.Lark_Legacy_RecordShortTime));
        removeCallbacks(this.f410906m);
        postDelayed(this.f410906m, 2000);
        goto L26
    }

    public final void k(CameraParam r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.D = r100.getMode();
        Log.i("JCameraViewV2", "initCameraView, cameraMode = " + this.D);
        this.f410906m.run();
        setMaxDuration(r100.getMaxDuration());
        setButtonMode(r100.getMode());
        com.ss.android.lark.cameraview.e r101 = l.a();
        Context r102 = getContext();
        VideoPreview r103 = this.f410898e;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        r103 = null;
    L5:
        r101.e(r102, r103, r100);
    }

    public final void o(boolean r100) {
        VideoPreview r101 = null;
        if (r100 == false) goto L8;
        ViewGroup r102 = this.f410907n;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayVideoLayout");
    L7:
        r102 = null;
    L11:
        if (r100 == false) goto L16;
        ViewGroup r103 = this.f410908o;
        if (r103 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mPreviewLayout");
    L15:
        r103 = null;
    L20:
        r102.setAlpha(1.0f);
        r102.setVisibility(0);
        if (r100 == false) goto L30;
        VideoPreview r104 = this.f410899f;
        if (r104 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
        r104 = null;
    L25:
        r104.setVisibility(0);
        VideoPreview r105 = this.f410898e;
        if (r105 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
    L29:
        r101.setVisibility(8);
        goto L30
    L28:
        r101 = r105;
    L30:
        r103.animate().setDuration(200).alpha(0.0f).setListener(new e(r103, r100, this));
        return;
    L16:
        FrameLayout r106 = this.f410907n;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayVideoLayout");
        goto L15
    L19:
        r103 = r106;
        goto L20
    L8:
        r102 = this.f410908o;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPreviewLayout");
        goto L7
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        int r100 = r110.getAction();
        VideoPreview r101 = null;
        e0b.c r102 = null;
        if (r100 == 0) goto L24;
        if (r100 == 1) goto L22;
        if (r100 == 2) goto L8;
    L40:
        return true;
    L8:
        if (r110.getPointerCount() != 1) goto L11;
        this.f410918y = true;
    L11:
        if (r110.getPointerCount() != 2) goto L40;
        float r103 = r110.getX(0);
        float r104 = r110.getY(0);
        float r111 = (float) Math.sqrt(Math.pow(r103 - r110.getX(1), 2.0d) + Math.pow(r104 - r110.getY(1), 2.0d));
        if (this.f410918y == false) goto L16;
        this.f410919z = r111;
        this.f410918y = false;
    L16:
        if ((((int) (r111 - this.f410919z)) / getZoomGradient()) == 0) goto L40;
        this.f410918y = true;
        e0b.c r105 = this.f410895b;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
    L21:
        r102.d((r111 - this.f410919z) / getZoomGradient());
        goto L40
    L20:
        r102 = r105;
        goto L21
    L22:
        this.f410918y = true;
        goto L40
    L24:
        if (r110.getPointerCount() != 1) goto L38;
        float r106 = r110.getX();
        float r107 = r110.getY();
        e0b.c r108 = this.f410895b;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        e0b.c r109 = null;
    L29:
        VideoPreview r112 = this.f410898e;
        if (r112 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        r112 = null;
    L32:
        int r113 = r112.getWidth();
        VideoPreview r114 = this.f410898e;
        if (r114 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
    L36:
        r109.c(r106, r107, r113, r101.getHeight(), new o(this));
        goto L38
    L35:
        r101 = r114;
        goto L36
    L28:
        r109 = r108;
    L38:
        if (r110.getPointerCount() != 2) goto L40;
        Log.i("JCameraViewV2", "ACTION_DOWN = 2");
        goto L40
    }

    public final void setErrorListener(d0b.c r100) {
        l.a().f410948d = r100;
    }

    public final void setJCameraListener(d0b.d r100) {
        this.f410896c = r100;
    }

    public final void setRightClickListener(d0b.b r100) {
        this.f410897d = r100;
    }

    @Override // g0b.a
    public final boolean c(float r100, float r101) {
        CaptureLayoutV2 r102 = this.f410912s;
        FocusView r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r102 = null;
    L6:
        if (r101 <= r102.getTop()) goto L8;
        return false;
    L8:
        FocusView r104 = this.f410913t;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r104 = null;
    L11:
        r104.setVisibility(0);
        FocusView r105 = this.f410913t;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r105 = null;
    L15:
        if (r100 >= (r105.getWidth() / 2)) goto L20;
        FocusView r106 = this.f410913t;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r106 = null;
    L19:
        r100 = r106.getWidth() / 2;
    L20:
        int r107 = getMaxWidth();
        FocusView r108 = this.f410913t;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r108 = null;
    L24:
        if (r100 <= (r107 - (r108.getWidth() / 2))) goto L29;
        int r109 = getMaxWidth();
        FocusView r110 = this.f410913t;
        if (r110 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r110 = null;
    L28:
        r100 = r109 - (r110.getWidth() / 2);
    L29:
        FocusView r111 = this.f410913t;
        if (r111 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r111 = null;
    L33:
        if (r101 >= (r111.getWidth() / 2)) goto L38;
        FocusView r112 = this.f410913t;
        if (r112 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r112 = null;
    L37:
        r101 = r112.getWidth() / 2;
    L38:
        CaptureLayoutV2 r113 = this.f410912s;
        if (r113 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r113 = null;
    L41:
        int r114 = r113.getTop();
        FocusView r115 = this.f410913t;
        if (r115 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r115 = null;
    L45:
        if (r101 <= (r114 - (r115.getWidth() / 2))) goto L53;
        CaptureLayoutV2 r116 = this.f410912s;
        if (r116 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r116 = null;
    L49:
        int r117 = r116.getTop();
        FocusView r118 = this.f410913t;
        if (r118 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r118 = null;
    L52:
        r101 = r117 - (r118.getWidth() / 2);
    L53:
        FocusView r119 = this.f410913t;
        if (r119 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r119 = null;
    L56:
        FocusView r120 = this.f410913t;
        if (r120 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r120 = null;
    L59:
        r119.setX(r100 - (r120.getWidth() / 2));
        FocusView r121 = this.f410913t;
        if (r121 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r121 = null;
    L62:
        FocusView r122 = this.f410913t;
        if (r122 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r122 = null;
    L65:
        r121.setY(r101 - (r122.getHeight() / 2));
        FocusView r123 = this.f410913t;
        if (r123 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r123 = null;
    L68:
        ObjectAnimator r124 = ObjectAnimator.ofFloat(r123, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.6f});
        FocusView r125 = this.f410913t;
        if (r125 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r125 = null;
    L71:
        ObjectAnimator r126 = ObjectAnimator.ofFloat(r125, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.6f});
        FocusView r127 = this.f410913t;
        if (r127 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
    L75:
        ObjectAnimator r128 = ObjectAnimator.ofFloat(r103, "alpha", new float[]{1.0f, 0.4f, 1.0f, 0.4f, 1.0f, 0.4f, 1.0f});
        AnimatorSet r129 = new AnimatorSet();
        r129.play(r124).with(r126).before(r128);
        r129.setDuration(400);
        r129.start();
        return true;
    L74:
        r103 = r127;
        goto L75
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        LinearLayout r101 = (LinearLayout) findViewById(R.id.translucent_send_bar);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        VideoPreview r103 = null;
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r102;
    L6:
        boolean r105 = false;
        if (r104 == null) goto L32;
        int r106 = getNavigationBarHeight();
        Button r107 = this.f410911r;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSendButton");
        r107 = null;
    L11:
        int r108 = r106 + r107.getMeasuredHeight();
        Button r109 = this.f410911r;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSendButton");
        r109 = null;
    L14:
        ViewGroup.LayoutParams r111 = r109.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
    L18:
        if (r112 == null) goto L20;
        int r113 = r112.topMargin;
    L21:
        int r114 = r108 + r113;
        Button r115 = this.f410911r;
        if (r115 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mSendButton");
        r115 = null;
    L24:
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
    L28:
        if (r117 == null) goto L30;
        int r118 = r117.bottomMargin;
    L31:
        r104.height = r114 + r118;
        r101.requestLayout();
        goto L32
    L30:
        r118 = 0;
        goto L31
    L27:
        r117 = null;
        goto L28
    L20:
        r113 = 0;
        goto L21
    L17:
        r112 = null;
    L32:
        super.onMeasure(r100, r110);
        VideoPreview r119 = this.f410898e;
        if (r119 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        r119 = null;
    L35:
        float r120 = r119.getMeasuredWidth();
        VideoPreview r121 = this.f410898e;
        if (r121 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
    L39:
        float r122 = r103.getMeasuredHeight();
        if (this.f410915v != 0.0f) goto L42;
        r105 = true;
    L42:
        if (r105 == false) goto L45;
        this.f410915v = r122 / r120;
        return;
    L45:
        return;
    L38:
        r103 = r121;
        goto L39
    L5:
        r104 = null;
        goto L6
    }

    public JCameraViewV2(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r110, r111);
        this.f410894a = r100;
        this.f410903j = 1;
        this.f410906m = new c(this);
        this.f410918y = true;
        this.A = CoreThreadPool.getDefault().getSingleScheduledThreadPool("ve_camera");
        this.D = CameraParam.MODE_PHOTO_VIDEO_BOTH;
        TypedArray r112 = r100.getTheme().obtainStyledAttributes(r110, new int[]{R.attr.duration_max, R.attr.iconLeft, R.attr.iconMargin, R.attr.iconRight, R.attr.iconSize, R.attr.iconSrc}, r111, 0);
        Resources r113 = getResources();
        r112.getDimensionPixelSize(4, (int) TypedValue.applyDimension(2, 35.0f, WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics())));
        Resources r114 = getResources();
        r112.getDimensionPixelSize(2, (int) TypedValue.applyDimension(2, 15.0f, WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics())));
        r112.getResourceId(5, R.drawable.ic_svg_camera);
        int r115 = r112.getResourceId(1, 0);
        int r101 = r112.getResourceId(3, 0);
        int r102 = r112.getInteger(0, 30000);
        r112.recycle();
        this.f410895b = new e0b.c(getContext(), this);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.camera_view_v2, this);
        this.f410898e = (VideoPreview) r103.findViewById(R.id.video_preview);
        this.f410899f = (VideoPreview) r103.findViewById(R.id.video_play);
        this.f410900g = (ImageView) r103.findViewById(R.id.image_photo);
        CaptureLayoutV2 r116 = (CaptureLayoutV2) r103.findViewById(R.id.buttons);
        this.f410912s = r116;
        CaptureLayoutV2 r104 = null;
        if (r116 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r116 = null;
    L5:
        r116.setDuration(r102);
        CaptureLayoutV2 r117 = this.f410912s;
        if (r117 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r117 = null;
    L8:
        r117.f410886i = r115;
        r117.f410887j = r101;
        if (r115 == 0) goto L20;
        ImageView r105 = r117.f410882e;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r105 = null;
    L13:
        r105.setImageResource(r115);
        ImageView r118 = r117.f410882e;
        if (r118 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r118 = null;
    L16:
        r118.getDrawable().setTint(UIUtils.getColor(r117.getContext(), R.color.white));
        ImageView r119 = r117.f410882e;
        if (r119 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r119 = null;
    L19:
        r119.setVisibility(0);
    L25:
        if (r117.f410887j == 0) goto L36;
        ImageView r120 = r117.f410883f;
        if (r120 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r120 = null;
    L29:
        r120.setImageResource(r101);
        ImageView r121 = r117.f410883f;
        if (r121 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r121 = null;
    L32:
        r121.getDrawable().setTint(UIUtils.getColor(r117.getContext(), R.color.white));
        ImageView r122 = r117.f410883f;
        if (r122 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r122 = null;
    L35:
        r122.setVisibility(0);
    L40:
        this.f410913t = (FocusView) r103.findViewById(R.id.fouce_view);
        this.f410901h = (LinearLayout) r103.findViewById(R.id.camera_back);
        this.f410902i = (TextView) r103.findViewById(R.id.prompt_word);
        this.f410908o = (ConstraintLayout) r103.findViewById(R.id.camera_preview_container);
        this.f410907n = (FrameLayout) r103.findViewById(R.id.video_play_container);
        this.f410909p = (LinearLayout) r103.findViewById(R.id.back_to_camera);
        this.f410910q = (LinearLayout) r103.findViewById(R.id.download_button);
        this.f410911r = (Button) r103.findViewById(R.id.send_button);
        LinearLayout r123 = this.f410909p;
        if (r123 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mBackToPreviewPage");
        r123 = null;
    L43:
        r123.setOnClickListener(new c0b.g(this));
        LinearLayout r124 = this.f410910q;
        if (r124 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mDownloadButton");
        r124 = null;
    L46:
        r124.setOnClickListener(new h(this, r103));
        Button r125 = this.f410911r;
        if (r125 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mSendButton");
        r125 = null;
    L49:
        r125.setOnClickListener(new i(this));
        LinearLayout r126 = this.f410901h;
        if (r126 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mBackButton");
        r126 = null;
    L52:
        r126.setOnClickListener(new j(this));
        LinearLayout r127 = this.f410901h;
        if (r127 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mBackButton");
        r127 = null;
    L55:
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if ((r128 instanceof ViewGroup.MarginLayoutParams) == false) goto L58;
        ViewGroup.MarginLayoutParams r129 = (ViewGroup.MarginLayoutParams) r128;
    L60:
        if (r129 == null) goto L65;
        int r106 = r129.topMargin;
        Context r107 = r103.getContext();
        r129.topMargin = r106 + r107.getResources().getDimensionPixelSize(r107.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        LinearLayout r130 = this.f410901h;
        if (r130 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mBackButton");
        r130 = null;
    L64:
        r130.requestLayout();
    L65:
        ConstraintLayout r131 = (ConstraintLayout) findViewById(R.id.top_bar);
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        if ((r132 instanceof ViewGroup.MarginLayoutParams) == false) goto L68;
        ViewGroup.MarginLayoutParams r133 = (ViewGroup.MarginLayoutParams) r132;
    L69:
        if (r133 == null) goto L71;
        int r108 = r133.topMargin;
        Context r109 = r103.getContext();
        r133.topMargin = r108 + r109.getResources().getDimensionPixelSize(r109.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        r131.requestLayout();
    L71:
        CaptureLayoutV2 r134 = this.f410912s;
        if (r134 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r134 = null;
    L74:
        r134.setCaptureListener(new k(this));
        CaptureLayoutV2 r135 = this.f410912s;
        if (r135 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r135 = null;
    L77:
        r135.setTypeListener(new c0b.l(this));
        CaptureLayoutV2 r136 = this.f410912s;
        if (r136 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        r136 = null;
    L80:
        r136.setLeftClickListener(new m(this));
        CaptureLayoutV2 r137 = this.f410912s;
        if (r137 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
    L84:
        r104.setRightClickListener(new f(this));
        return;
    L83:
        r104 = r137;
        goto L84
    L68:
        r133 = null;
        goto L69
    L58:
        r129 = null;
        goto L60
    L36:
        ImageView r138 = r117.f410883f;
        if (r138 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r138 = null;
    L39:
        r138.setVisibility(4);
        goto L40
    L20:
        ImageView r139 = r117.f410882e;
        if (r139 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r139 = null;
    L23:
        r139.setVisibility(4);
        goto L25
    }

    public static final void i(JCameraViewV2 r100, String r101, int r102) {
        TextView r103 = r100.f410902i;
        CaptureLayoutV2 r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTipTextView");
        r103 = null;
    L5:
        r103.setText(r101);
        r100.removeCallbacks(r100.f410906m);
        r100.postDelayed(r100.f410906m, 2000);
        CaptureLayoutV2 r105 = r100.f410912s;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
    L9:
        r104.setLeftIconSrc(r102);
        return;
    L8:
        r104 = r105;
        goto L9
    }

    public /* synthetic */ JCameraViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void j(JCameraViewV2 r100, VideoPreview r101, int r102, int r103) {
        float r104 = r100.getWidth();
        float r105 = r100.getHeight();
        Log.i("JCameraViewV2", "updateSurfaceSize, parentWidth:" + r104 + ",parentHeight:" + r105 + ",videoWidth:" + r102 + ",videoHeight:" + r103);
        if (r102 == 0) goto L23;
        if (r103 == 0) goto L24;
        boolean r106 = true;
        if (r104 != 0.0f) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L11;
        return;
    L11:
        if (r105 == 0.0f) goto L14;
        r106 = false;
    L14:
        if (r106 == true) goto L27;
        float r108 = r102;
        float r109 = r103;
        float r110 = Math.min(r104 / r108, r105 / r109);
        VideoPreview r111 = r100.f410899f;
        if (r111 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
        r111 = null;
    L19:
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r113 = (FrameLayout.LayoutParams) r112;
        r113.width = (int) (r108 * r110);
        r113.height = (int) (r109 * r110);
        if (r101 == null) goto L26;
        r101.setLayoutParams(r113);
        return;
    L26:
        return;
    L27:
        return;
    L8:
        r107 = false;
        goto L9
    L24:
        return;
    }
}
