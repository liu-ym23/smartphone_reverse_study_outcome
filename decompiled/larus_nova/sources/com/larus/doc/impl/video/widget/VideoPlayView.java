package com.larus.doc.impl.video.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common_ui.view.ActivityIndicatorView;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.media.MixPriority;
import com.larus.nova.R;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.n0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000Å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e*\u00013\u0018\u0000 \u0084\u00012\u00020\u0001:\f\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0014J\b\u0010N\u001a\u00020\u0011H\u0014J\b\u0010O\u001a\u00020\u0011H\u0014J\u001a\u0010P\u001a\u00020\u00112\b\u0010Q\u001a\u0004\u0018\u00010&2\b\u0010R\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010S\u001a\u00020\u0011J\b\u0010T\u001a\u00020\u0011H\u0002J\b\u0010U\u001a\u00020\u0011H\u0002J\b\u0010V\u001a\u00020\u0011H\u0002J\u0006\u0010W\u001a\u00020\u0011J\u0006\u0010X\u001a\u00020YJ\u0006\u0010Z\u001a\u00020YJ\u0006\u0010[\u001a\u00020\u0011J\u0006\u0010\\\u001a\u00020\u0011J\u0010\u0010b\u001a\u00020\u00112\b\b\u0002\u0010c\u001a\u00020!J\u0010\u0010d\u001a\u00020\u00112\b\b\u0002\u0010c\u001a\u00020!J\u0010\u0010e\u001a\u00020!2\u0006\u0010f\u001a\u00020gH\u0016J\u0010\u0010h\u001a\u00020!2\u0006\u0010f\u001a\u00020gH\u0016J\u0018\u0010i\u001a\u00020\u00112\u0006\u0010j\u001a\u00020\u00072\b\u0010k\u001a\u0004\u0018\u00010lJ\u0006\u0010m\u001a\u00020\u0011J\u0006\u0010n\u001a\u00020\u0011J\u0006\u0010o\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0007J)\u0010p\u001a\u00020\u00112!\u0010q\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rJ)\u0010r\u001a\u00020\u00112!\u0010q\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rJ+\u0010\u0013\u001a\u00020\u00112#\u0010s\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rJ\u0006\u0010t\u001a\u00020!J\u0006\u0010u\u001a\u00020!J\u0006\u0010v\u001a\u00020\u0011J\b\u0010w\u001a\u00020\u0011H\u0002J\b\u0010x\u001a\u00020\u0011H\u0002J\b\u0010y\u001a\u00020\u0011H\u0002J\u000e\u0010z\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\u0007J\b\u0010|\u001a\u00020\u0011H\u0002J\b\u0010}\u001a\u00020\u0011H\u0002J\u0010\u0010~\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020.H\u0002J\t\u0010\u0080\u0001\u001a\u00020!H\u0002J\u0011\u0010\u0081\u0001\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020.H\u0002J\t\u0010\u0082\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0083\u0001\u001a\u00020\u0011H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010,\u001a\u0016\u0012\u0004\u0012\u00020.\u0018\u00010-j\n\u0012\u0004\u0012\u00020.\u0018\u0001`/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001eX\u0082D¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0004\n\u0002\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010]\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a¨\u0006\u008a\u0001"}, d2 = {"Lcom/larus/doc/impl/video/widget/VideoPlayView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mUrl", "", "mOnBufferingUpdate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "percent", "", "mOnPlayingProgressUpdate", "onPlayStatusChanged", "status", "mVideoView", "Landroid/view/TextureView;", "mPlayButton", "Landroid/widget/ImageView;", "mLoadingView", "Lcom/larus/common_ui/view/ActivityIndicatorView;", "mSurface", "Landroid/view/Surface;", "mViewAspectRatio", "", "mVideoAspectRatio", "banInnerDismiss", "", "startX", "startY", "mVideoId", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "parentSlideDirection", "mShouldBePlaying", "mMainHandler", "Landroid/os/Handler;", "mExecutingActions", "mPendingActions", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "touchSlop", "dismissOffset", "mSurfaceTextureListener", "com/larus/doc/impl/video/widget/VideoPlayView$mSurfaceTextureListener$1", "Lcom/larus/doc/impl/video/widget/VideoPlayView$mSurfaceTextureListener$1;", "mProgressUpdateTask", "Lcom/larus/doc/impl/video/widget/VideoPlayView$ProgressUpdateTask;", "ignoreClick", "showLoadingRunable", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "afterClickCallBack", "Lcom/larus/doc/impl/video/widget/VideoPlayView$AfterClickCallBack;", "getAfterClickCallBack", "()Lcom/larus/doc/impl/video/widget/VideoPlayView$AfterClickCallBack;", "setAfterClickCallBack", "(Lcom/larus/doc/impl/video/widget/VideoPlayView$AfterClickCallBack;)V", "dismissCallback", "Lkotlin/Function0;", "getDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "mediaApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "setUrl", "videoController", "url", "start", "realStart", "playByVideoUrl", "resetSurfaceAndPlay", "retryStart", "getCurrentPlaybackTime", "", "getDuration", "stop", "release", "mResumeOrPauseByUser", "getMResumeOrPauseByUser", "()Z", "setMResumeOrPauseByUser", "(Z)V", "resume", "byUser", "pause", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "seekTo", "msec", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "showLoadingWithDelay", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "onBufferingUpdate", "block", "onPlayingProgressUpdate", "callback", "isPlaying", "isPaused", "onSingleTap", "updateProgress", "resetViewVisible", "fitVideoSize", "setPlayButtonVisible", "visible", "fitVideoViewSize", "abandonAudioFocus", "execAction", "action", "isSurfaceValid", "enqueueAction", "execPendingActions", "clearPendingActions", "Companion", "PlayType", "EngineListener", "ProgressUpdateTask", "GestureDetectorListener", "AfterClickCallBack", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoPlayView extends FrameLayout {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f331517z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f331518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Integer, Unit> f331519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Integer, Unit> f331520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextureView f331521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f331522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ActivityIndicatorView f331523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Surface f331524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f331525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f331526i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f331527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f331528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IVideoController f331529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f331530m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f331531n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f331532o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<Runnable> f331533p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f331534q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f331535r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c f331536s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f331537t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final p f331538u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q f331539v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Function0<Unit> f331540w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.larus.media.model.a f331541x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f331542y;

    public static final class Companion {

        @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/doc/impl/video/widget/VideoPlayView$Companion$PlayStatus;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PlayStatus {
            public static final a Companion = null;
            public static final int PLAY_COMPLETE = 2;
            public static final int PLAY_FAIL = 1;
            public static final int PLAY_PAUSE = 3;
            public static final int PLAY_SUCCESS = 0;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f331543a = null;

                static {
                    f331543a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f331543a;
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larus/doc/impl/video/widget/VideoPlayView$PlayType;", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PlayType {
    }

    public interface a {
    }

    public static final class b implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final VideoPlayView f331544a;

        @Override // com.larus.platform.api.n0
        public final void b(Integer r100, Integer r101) {
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepare() {
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepared() {
        }

        @Override // com.larus.platform.api.n0
        public final void onCompletion() {
            Function1<? super Integer, Unit> r100 = this.f331544a.f331520c;
            if (r100 == null) goto L6;
            r100.invoke(2);
            return;
        }

        @Override // com.larus.platform.api.n0
        public final void onRenderStart() {
            VideoPlayView.a(this.f331544a);
            this.f331544a.c();
            Function1<? super Integer, Unit> r100 = this.f331544a.f331520c;
            if (r100 == null) goto L6;
            r100.invoke(0);
            return;
        }

        public b(VideoPlayView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f331544a = r100;
        }

        @Override // com.larus.platform.api.n0
        public final void c(int r100) {
            FLogger.f375446a.i("VideoPlayView", "onPlaybackStateChanged: " + r100);
            if (r100 != 0) goto L5;
        L18:
            VideoPlayView r101 = this.f331544a;
            int r102 = VideoPlayView.f331517z;
            r101.getClass();
            Lazy r103 = MediaResourceManager.f358950a;
            MediaResourceManager.a(r101.f331541x);
            return;
        L5:
            if (r100 != 1) goto L7;
            this.f331544a.f331522e.setVisibility(8);
            this.f331544a.c();
            Function1<? super Integer, Unit> r104 = this.f331544a.f331520c;
            if (r104 == null) goto L17;
            r104.invoke(0);
        L17:
            this.f331544a.getCurrentPlaybackTime();
            return;
        L7:
            if (r100 == 2) goto L18;
            if (r100 != 3) goto L23;
            this.f331544a.c();
            Function1<? super Integer, Unit> r105 = this.f331544a.f331520c;
            if (r105 == null) goto L20;
            r105.invoke(1);
            return;
        L20:
            return;
        }

        @Override // com.larus.platform.api.n0
        public final void d(int r100) {
            FLogger.f375446a.i("VideoPlayView", "onLoadStateChanged: " + r100);
            if (r100 != 1) goto L5;
            this.f331544a.c();
            Function1<? super Integer, Unit> r101 = this.f331544a.f331520c;
            if (r101 == null) goto L23;
            r101.invoke(0);
            return;
        L23:
            return;
        L5:
            if (r100 != 2) goto L7;
            VideoPlayView r102 = this.f331544a;
            r102.f331531n.removeCallbacks(r102.f331538u);
            r102.f331531n.postDelayed(r102.f331538u, 500);
            if (NetworkUtils.isNetworkAvailable(this.f331544a.getContext()) == true) goto L21;
            t19.s r103 = t19.s.f544207a;
            Context r104 = this.f331544a.getContext();
            String r105 = this.f331544a.getContext().getResources().getString(R.string.larus_internet_connection_failed);
            r103.getClass();
            t19.s.c(r104, r105);
            return;
        L21:
            return;
        L7:
            if (r100 != 3) goto L24;
            Function1<? super Integer, Unit> r106 = this.f331544a.f331520c;
            if (r106 == null) goto L12;
            r106.invoke(1);
        L12:
            this.f331544a.c();
            return;
        }

        @Override // com.larus.platform.api.n0
        public final void onVideoStatusException(int r100) {
            FLogger.f375446a.e("VideoPlayView", "onVideoStatusException: " + r100);
            this.f331544a.post(new u(this));
        }

        @Override // com.larus.platform.api.n0
        public final void a(Integer r100, Integer r101) {
            FLogger.f375446a.e("VideoPlayView", "onError: " + r100);
            Function1<? super Integer, Unit> r102 = this.f331544a.f331520c;
            if (r102 == null) goto L5;
            r102.invoke(1);
        L5:
            this.f331544a.c();
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final VideoPlayView f331545a;

        @Override // java.lang.Runnable
        public final void run() {
            VideoPlayView.a(this.f331545a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(VideoPlayView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f331545a = r100;
        }
    }

    public static final class d implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f331546a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        public d(VideoPlayView r100) {
            this.f331546a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            r100.release();
            Surface r101 = this.f331546a.f331524g;
            if (r101 == null) goto L5;
            r101.release();
        L5:
            this.f331546a.f331524g = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            VideoPlayView r103 = this.f331546a;
            int r104 = VideoPlayView.f331517z;
            Surface r105 = r103.f331524g;
            if (r105 != null) goto L5;
        L7:
            boolean r106 = false;
        L8:
            if (r106 == true) goto L10;
            VideoPlayView r107 = this.f331546a;
            r107.f331524g = new Surface(r100);
        L10:
            VideoPlayView r108 = this.f331546a;
            IVideoController r109 = r108.f331529l;
            if (r109 != null) goto L13;
        L15:
            VideoPlayView r110 = this.f331546a;
            if (r110.f331532o == true) goto L30;
            ArrayList<Runnable> r111 = r110.f331533p;
            if (r111 == null) goto L27;
            r110.f331532o = true;
            Iterator r112 = new ArrayList(r111).iterator();
        L22:
            if (r112.hasNext() == false) goto L24;
            ((Runnable) r112.next()).run();
            goto L22
        L24:
            ArrayList<Runnable> r113 = r110.f331533p;
            if (r113 == null) goto L27;
            r113.clear();
        L27:
            r110.f331532o = false;
            return;
        L30:
            return;
        L13:
            if (r108.f331530m == false) goto L15;
            r109.setSurface(r108.f331524g);
            goto L15
        L5:
            if (r105.isValid() != true) goto L7;
            r106 = true;
            goto L8
        }
    }

    public static final class e implements com.larus.media.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ValueAnimator f331547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f331548b;

        public e(VideoPlayView r100) {
            this.f331548b = r100;
        }

        @Override // com.larus.media.v
        public final boolean b(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.TTS_SAMPLE) == false) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // com.larus.media.v
        public final void e(lk9.g r100) {
            com.larus.media.v.a.d(r100);
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.media.v
        public final void a(lk9.g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            final VideoPlayView r102 = this.f331548b;
            r102.f331531n.post(new w(r102, this));
            com.larus.media.v.a.f(r100, r101);
        }

        @Override // com.larus.media.v
        public final void d(lk9.g r100, lk9.g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            com.larus.media.v.a.c(r100, r101);
            final VideoPlayView r102 = this.f331548b;
            r102.f331531n.post(new v(r102, this));
        }

        @Override // com.larus.media.v
        public final void g(lk9.g r100, float r101) {
            com.larus.media.v.a.g(r100, r101);
        }

        @Override // com.larus.media.v
        public final void i(lk9.g r100, lk9.g r101) {
            com.larus.media.v.a.e(r100, r101);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy c(lk9.g r100, lk9.g r101, int r102) {
            return com.larus.media.v.a.a(this, r100, r101, r102);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy h(lk9.g r100, lk9.g r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            return MediaOccupyStrategy.PAUSE;
        }
    }

    static {
    }

    public VideoPlayView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoPlayView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final a getAfterClickCallBack() {
        return null;
    }

    public final void setAfterClickCallBack(a r100) {
    }

    public final void c() {
        this.f331531n.removeCallbacks(this.f331538u);
        this.f331523f.setVisibility(8);
    }

    public final void d() {
        FLogger.f375446a.i("VideoPlayView", "[onSingleTap]");
        if (this.f331537t == false) goto L5;
        return;
    L5:
        IVideoController r100 = this.f331529l;
        IVideoController.PlayType r101 = null;
        if (r100 == null) goto L8;
        IVideoController.PlayType r102 = r100.d();
    L9:
        boolean r103 = false;
        if (r102 != IVideoController.PlayType.PLAY) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        e(true);
        return;
    L15:
        IVideoController r105 = this.f331529l;
        if (r105 == null) goto L19;
        r101 = r105.d();
    L19:
        if (r101 != IVideoController.PlayType.PAUSE) goto L21;
        r103 = true;
    L21:
        if (r103 == false) goto L23;
        f(true);
        return;
    L23:
        g();
        return;
    L12:
        r104 = false;
        goto L13
    L8:
        r102 = null;
        goto L9
    }

    public final void g() {
        Lazy r100 = MediaResourceManager.f358950a;
        MediaResourceManager.m(this.f331541x, new n(this), new o(this), 0, 8);
    }

    public final long getCurrentPlaybackTime() {
        IVideoController r100 = this.f331529l;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCurrentPlaybackTime();
    }

    public final long getDuration() {
        IVideoController r100 = this.f331529l;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.n();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.f331539v);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.f331539v);
        Lazy r100 = MediaResourceManager.f358950a;
        MediaResourceManager.a(this.f331541x);
    }

    public final Function0<Unit> getDismissCallback() {
        return this.f331540w;
    }

    public final boolean getMResumeOrPauseByUser() {
        return this.f331542y;
    }

    public static final void a(VideoPlayView r100) {
        c r101 = r100.f331536s;
        if (r101 == null) goto L9;
        long r102 = r100.getCurrentPlaybackTime();
        long r103 = r100.getDuration();
        Function1<? super Integer, Unit> r104 = r100.f331519b;
        if (r104 == null) goto L7;
        r104.invoke(Integer.valueOf((int) ((r102 * ((long) 100)) / r103)));
    L7:
        r100.postDelayed(r101, 30);
        return;
    }

    public final void b(Runnable r100) {
        Surface r101 = this.f331524g;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.isValid() != true) goto L7;
    L8:
        if (r102 == false) goto L11;
        r100.run();
        return;
    L11:
        if (this.f331533p != null) goto L13;
        this.f331533p = new ArrayList();
    L13:
        ArrayList<Runnable> r103 = this.f331533p;
        if (r103 == null) goto L18;
        r103.add(r100);
        return;
    L18:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void e(final boolean r100) {
        FLogger.f375446a.i("VideoPlayView", "[pause] byUser:" + r100);
        IVideoController r101 = this.f331529l;
        if (r101 == null) goto L5;
        IVideoController.PlayType r102 = r101.d();
    L7:
        if (r102 != IVideoController.PlayType.PLAY) goto L11;
        Function1<? super Integer, Unit> r103 = this.f331520c;
        if (r103 == null) goto L11;
        r103.invoke(3);
    L11:
        b(new m(this, r100));
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void f(final boolean r100) {
        FLogger.f375446a.i("VideoPlayView", "[resume] byUser:" + r100);
        b(new l(this, r100));
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        this.f331526i = r100.getX();
        this.f331527j = r100.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L27:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r101 != 1) goto L7;
    L24:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L27
    L7:
        if (r101 != 2) goto L9;
        float r102 = r100.getX() - this.f331526i;
        float r103 = r100.getY() - this.f331527j;
        if (Math.abs(r103) > this.f331534q) goto L14;
    L16:
        boolean r104 = false;
    L18:
        if (Math.abs(r102) <= this.f331534q) goto L20;
        int r105 = (Math.abs(r102) > Math.abs(r103) ? 1 : (Math.abs(r102) == Math.abs(r103) ? 0 : -1));
    L20:
        if (r104 == true) goto L22;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L27
    L22:
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L14:
        if (Math.abs(r103) <= Math.abs(r102)) goto L16;
        r104 = true;
        goto L18
    L9:
        if (r101 == 3) goto L24;
        goto L24
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getActionMasked() != 2) goto L27;
        float r101 = r100.getX() - this.f331526i;
        float r102 = r100.getY() - this.f331527j;
        boolean r103 = false;
        if (Math.abs(r102) > this.f331534q) goto L7;
    L9:
        boolean r104 = false;
    L11:
        if (Math.abs(r101) <= this.f331534q) goto L13;
        int r105 = (Math.abs(r101) > Math.abs(r102) ? 1 : (Math.abs(r101) == Math.abs(r102) ? 0 : -1));
    L13:
        if (r104 == true) goto L15;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L27
    L15:
        getParent().requestDisallowInterceptTouchEvent(true);
        float r106 = this.f331535r;
        if (r102 <= r106) goto L18;
        r103 = true;
    L18:
        int r107 = (r101 > r106 ? 1 : (r101 == r106 ? 0 : -1));
        if (r103 == false) goto L25;
        Function0<Unit> r108 = this.f331540w;
        if (r108 == null) goto L24;
        r108.invoke();
    L24:
        this.f331537t = true;
    L25:
        return true;
    L7:
        if (Math.abs(r102) <= Math.abs(r101)) goto L9;
        r104 = true;
    L27:
        return super.onTouchEvent(r100);
    }

    public final void setDismissCallback(Function0<Unit> r100) {
        this.f331540w = r100;
    }

    public final void setMResumeOrPauseByUser(boolean r100) {
        this.f331542y = r100;
    }

    public final void setPlayButtonVisible(int r100) {
        this.f331522e.setVisibility(r100);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.doc.impl.video.widget.p] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.larus.doc.impl.video.widget.q] */
    public VideoPlayView(Context r210, AttributeSet r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        TextureView r100 = new TextureView(r210);
        this.f331521d = r100;
        ImageView r101 = new ImageView(r210);
        this.f331522e = r101;
        ActivityIndicatorView r102 = new ActivityIndicatorView(r210, null);
        this.f331523f = r102;
        this.f331531n = new Handler(Looper.getMainLooper());
        this.f331534q = ViewConfiguration.get(r210).getScaledTouchSlop();
        this.f331535r = 150.0f;
        d r103 = new d(this);
        this.f331538u = new p(this);
        this.f331539v = new q(this);
        this.f331541x = new com.larus.media.model.a(null, "VIDEO", false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, false, MediaLevel.PLAY_HIGH.getValue(), false, new e(this), 1453);
        setBackgroundColor(v19.c.a(R.attr.larus_static_black, r210, R.color.larus_static_black));
        addView(r100, -1, -1);
        int r104 = (int) UIUtils.dip2Px(r210, 56.0f);
        int r105 = (int) UIUtils.dip2Px(r210, 32.0f);
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(r104, r104);
        r106.gravity = 17;
        addView(r101, r106);
        r101.setImageResource(R.drawable.larus_tiktok_video_play);
        e1.d(r101, new r(this));
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(r105, r105);
        r107.gravity = 17;
        r102.f328120d = true;
        r102.setColor(v19.c.a(R.attr.larus_neutral_50, r210, R.color.larus_neutral_50));
        r102.setStrokeWidth(i5.Y());
        r102.setVisibility(8);
        addView(r102, r107);
        r100.setSurfaceTextureListener(r103);
        e1.d(this, new s(this));
    }

    public /* synthetic */ VideoPlayView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
    }
}
